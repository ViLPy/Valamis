/*
* Tincan helper functions
* */
var myTinCan = new TinCan();

var TincanHelper = {
    getEndpoint: function() {
        var lrs = myTinCan.recordStores[0];
        return lrs.endpoint;
    },
    getAuth: function() {
        var lrs = myTinCan.recordStores[0];
        return lrs.auth;
    },
    getActor: function() {
        return myTinCan.actor;
    },
    getLaunchArguments: function() { //jQuery('#tincanActor').val(),
        var lrs = myTinCan.recordStores[0];

        return 'endpoint={0}&auth={1}&actor={2}'
            .replace('{0}', encodeURIComponent(lrs.endpoint))
            .replace('{1}', encodeURIComponent(lrs.auth))
            .replace('{2}', encodeURIComponent(JSON.stringify({
                "objectType":myTinCan.actor.objectType,
                "name":myTinCan.actor.name,
                "mbox":myTinCan.actor.mbox
            })));
    },

    initialize: function(callback) {
        if (myTinCan.recordStores.length > 0 && myTinCan.recordStores[0].endpoint) {
            if (callback) callback.call();
        } else {
            toastr.error('No LRS settings!');
        }
    },
// Set LRS info
    SetLRS: function (data) {
        var myLRS;
        if (data.internal) {
            myLRS = new TinCan.LRS({
                endpoint: data.endpoint,
                version: "1.0.1",
                auth: data.auth
            });
        }
        else {
            myLRS = new TinCan.LRS({
                endpoint: data.endpoint,
                version: "1.0.1"
            });
            if (data.authType == "Basic") {
                if (data.auth) {
                    myLRS.auth = data.auth;
                }
                else {
                    window.playerLayout.modals.show(window.tincanModal);
                }
            } else if (data.authType === "OAuth") {
                if (data.auth) {
                    myLRS.auth = data.auth;
                }
            }
        }
        myTinCan.recordStores[0] = myLRS;
    },

// Set LRS info with auth
    SetLRSAuth: function ( auth) {
        myTinCan.recordStores[0].auth = auth;
    },

// Create actor object
    SetActor: function (actorRaw) {
        var myActor = new TinCan.Agent(actorRaw);
        myTinCan.actor = myActor;
    },

    SetActivity: function (activityURI, activityDefinition) {
//Create the activity
        var activity = new TinCan.Activity({
            id: activityURI,
            definition: activityDefinition
        });

//use this activity as default
        myTinCan.activity = activity;
    },

    createStatement: function (activity, currentPackageURI, registrationId) {
        var stmt =  new TinCan.Statement({
            actor: myTinCan.actor,
            target: activity,
            context: {
                contextActivities: {
                    grouping: [
                        {id: currentPackageURI, objectType: "Activity"}
                    ]
                }
            }
        });
        if(registrationId)
            stmt.context.registration = registrationId;
        return stmt;
    },

// create the TinCan Verb object
    createVerb: function (verb, library, display) {
        display = typeof display == 'undefined' ? verb : display;
        library = typeof library == 'undefined' ? "http://adlnet.gov/expapi/verbs/" : library;
        return new TinCan.Verb({
            id: library + verb,
            display: {
                "en-US": display
            }
        });
    },

    getVerbId: function (verb, library) {
        library = typeof library == 'undefined' ? "http://adlnet.gov/expapi/verbs/" : library;
        return library + verb;
    },

    sendStatement: function(stmt) {
        return myTinCan.sendStatement(stmt, function () {
        });
    },

    getStatements: function(query) {
        return myTinCan.getStatements(query);
    }
}
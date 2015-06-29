/**
 * Created by aklimov on 21.05.15.
 */
window.GAPISettings = {};

function initGAPISettings() {
    window.GAPISettings = {
        apiKey: slidesConfig.googleApiKey,
        clientId: slidesConfig.googleClientId,
        appId: slidesConfig.googleAppId,
        // Scope to use to access user's Drive items.
        scope: ['https://www.googleapis.com/auth/drive.readonly', 'https://www.googleapis.com/auth/youtube.readonly', 'https://www.googleapis.com/auth/photos'],
        pickerApiLoaded: false,
        oauthToken: null
    };
}

// Use the Google API Loader script to load the google.picker script.
function loadPicker() {
    gapi.load('auth', {'callback': onAuthApiLoad});
    gapi.load('picker', {'callback': onPickerApiLoad});
}

function onAuthApiLoad() {
    window.gapi.auth.authorize(
        {
            'client_id': GAPISettings.clientId,
            'scope': GAPISettings.scope, 'immediate': false
        },
        handleAuthResult);
}

function onPickerApiLoad() {
    GAPISettings.pickerApiLoaded = true;
}

function handleAuthResult(authResult) {
    if (authResult && !authResult.error) {
        GAPISettings.oauthToken = authResult.access_token;
        createPicker();
    }
    else toastr.error(slidesConfig.translations['googleAuthenticationFailedLabel']);
}

// Create and render a Picker object for searching images.
function createPicker() {
    if (GAPISettings.pickerApiLoaded && GAPISettings.oauthToken) {
        var docsView = new google.picker.View(google.picker.ViewId.DOCS);
        var photosView = new google.picker.View(google.picker.ViewId.PHOTOS);
        if(slidesConfig.youtubeIframeAPIReady) {
            var youtubeView = new google.picker.View(google.picker.ViewId.YOUTUBE);
            var videoSearchView = new google.picker.View(google.picker.ViewId.VIDEO_SEARCH);
        }
        var imageSearchView = new google.picker.View(google.picker.ViewId.IMAGE_SEARCH);
        var pdfView = new google.picker.View(google.picker.ViewId.PDFS);
        var fileTypes = '';
        var fileTypeGroup = slidesApp.activeElement.view.model.get('slideEntityType');
        for(var i in Object.keys(mimeToExt[fileTypeGroup]))
            fileTypes += Object.keys(mimeToExt[fileTypeGroup])[i] + ',';
        fileTypes = fileTypes.slice(0,-1);
        // Set Picker file type filter depending on slide element type
        docsView.setMimeTypes(fileTypes);
        var picker = new google.picker.PickerBuilder()
            .setAppId(GAPISettings.appId)
            .setOAuthToken(GAPISettings.oauthToken)
            .addView(docsView);
        switch(fileTypeGroup) {
            case 'video':
                if(slidesConfig.youtubeIframeAPIReady)
                    picker
                        .addView(videoSearchView)
                        .addView(youtubeView);
                break;
            case 'image':
                picker
                    .addView(photosView)
                    .addView(imageSearchView);
                break;
            case 'pdf':
                picker.addView(pdfView);
                break;
        }
        picker = picker
            .setDeveloperKey(GAPISettings.apiKey)
            .setCallback(pickerCallback)
            .build();
        picker.setVisible(true);
        jQueryValamis('iframe.picker.picker-dialog-bg').css('z-index', '1200');
        jQueryValamis('div.picker-dialog-bg').css('z-index', '1200');
        jQueryValamis('div.picker').css('z-index', '1201');
    }
}

// A simple callback implementation.
function pickerCallback(data) {
    if (data.action == google.picker.Action.PICKED) {
        var doc = data[google.picker.Response.DOCUMENTS][0];
        var url = doc[google.picker.Document.URL];
        var thumbnails = doc[google.picker.Document.THUMBNAILS];
        switch(slidesApp.activeElement.view.model.get('slideEntityType')) {
            case 'video':
                if(url && url.indexOf('youtube.com/') != -1)
                    slidesApp.commands.execute('picker:file:selected', url);
                else
                {
                    var previewUrl = 'https://docs.google.com/file/d/' + doc.id + '/preview';
                    slidesApp.commands.execute('picker:file:selected', previewUrl);
                    /*
                     * THIS MIGHT GET NECESSARY, DON'T REMOVE
                     */
                    /*gapi.client.load('drive', 'v2', function () {
                        var request = gapi.client.request({
                            'path': '/drive/v2/files/' + doc.id + '?key=' + GAPISettings.clientId,
                            'method': 'GET'
                        });
                        callback = function (file) {
                            var previewUrl = 'https://docs.google.com/file/d/' + file.id + '/preview';
                            slidesApp.commands.execute('picker:file:selected', previewUrl);
                        };
                        request.execute(callback);
                    });*/
                }
                break;
            case 'image':
                if(thumbnails) {
                    var imageUrl = _.last(thumbnails)[google.picker.Thumbnail.URL],
                        imageWidth = _.last(thumbnails)[google.picker.Thumbnail.WIDTH],
                        imageHeight = _.last(thumbnails)[google.picker.Thumbnail.HEIGHT];
                        imageUrl = imageUrl.indexOf('googleusercontent.com') != -1
                            ? imageUrl.replace('lh3.googleusercontent.com', 'lh4.googleusercontent.com')
                            : imageUrl;
                    slidesApp.activeElement.view.updateUrl('url("' + imageUrl + '")', imageWidth, imageHeight);
                }
                else {
                    var previewUrl = 'https://docs.google.com/file/d/' + doc.id + '/preview';
                    slidesApp.activeElement.view.updateUrl(previewUrl);
                }
                break;
            case 'pdf':
                break;
        }
    }
}
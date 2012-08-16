function findAPI(win) {
    var findAPITries = 0;
    while ((win.API_1484_11 == null) && (win.parent != null) && (win.parent != win)) {
        findAPITries++;
        if (findAPITries > 20) return null;
        win = win.parent;
    }
    return win.API_1484_11;
}

function getAPI() {
    var theAPI = findAPI(window);
    if ((theAPI == null)) {
        if ((window.opener != null) && (typeof(window.opener) != "undefined"))
            theAPI = findAPI(window.opener);
    }
    return theAPI;
}
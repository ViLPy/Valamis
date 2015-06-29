function placeSlideControls(windowWidth, windowHeight) {
    var sidebarWidth = !jQueryValamis('.sidebar').is(':hidden') ? jQueryValamis('.sidebar').outerWidth() : 0;
    var container = jQueryValamis('.reveal-wrapper');
    var containerScrollTop = container.scrollTop();
    container.css( 'left', sidebarWidth + 'px' );

    jQueryValamis('.ui-resizable-handle').hide();
    var slideContainer = jQueryValamis('.reveal-wrapper > .reveal > .slides');
    var offsetX = (windowWidth > 1200)
        ? parseFloat(slideContainer.offset().left/*css('margin-left').slice(0, -2)*/) + slideContainer.width() - 5
        : windowWidth - sidebarWidth - jQueryValamis('#slide-controls').outerWidth();
    var offsetY = (windowHeight > 760)
        ? slideContainer.offset().top - 4
        : 0;

    var rightButtonOffsetX = (windowWidth > 1200)
        ? windowWidth - sidebarWidth - jQueryValamis('.js-add-page-right').outerWidth() - 15
        : windowWidth - sidebarWidth - jQueryValamis('.js-add-page-right').outerWidth();
    var downButtonOffsetY = (windowHeight > 860)
        ? jQueryValamis(window.parent.document).find('.js-slides-editor-topbar').outerHeight() + 15
        : jQueryValamis(window.parent.document).find('.js-slides-editor-topbar').outerHeight();

    var revealControlsOffsetX = (windowWidth > 1320)
        ? windowWidth - sidebarWidth - jQueryValamis('.reveal > .controls').outerWidth() - 15
        : windowWidth - sidebarWidth - jQueryValamis('.reveal > .controls').outerWidth() + parseInt(jQueryValamis('.reveal > .controls').css('right').slice(0, -2));
    var revealControlsOffsetY = (windowHeight > 860)
        ? windowHeight - jQueryValamis('.reveal > .controls').outerHeight() - 70 + containerScrollTop
        : windowHeight - jQueryValamis('.reveal > .controls').outerHeight() - 60 + containerScrollTop;

    jQueryValamis('#slide-controls').css({
        'position': 'fixed',
        'top': offsetY + 'px',
        'left': offsetX + 'px'
    });
    jQueryValamis('.image-upload-panel').css({
        'left': (0 - jQueryValamis('.image-upload-panel').width() - jQueryValamis('#slide-controls').width() - 19) + 'px'
    });
    jQueryValamis('.slide-title-edit-panel').css({
        'left': (0 - jQueryValamis('.slide-title-edit-panel').width() - jQueryValamis('#slide-controls').width() - 19) + 'px'
    });
    jQueryValamis('.slide-statement-edit-panel').css({
        'left': (0 - jQueryValamis('.slide-statement-edit-panel').width() - jQueryValamis('#slide-controls').width() - 19) + 'px'
    });
    jQueryValamis('.reveal-controls').css({
        'width': windowWidth + 'px',
        'height': windowHeight + 'px'
    });

    jQueryValamis('.js-add-page-right').css({
        'left': rightButtonOffsetX + 'px',
        'top': (windowHeight - jQueryValamis('.js-add-page-right').outerHeight()) / 2 + 'px'
    });
    jQueryValamis('.js-add-page-down').css({
        'bottom': downButtonOffsetY + 'px',
        'left': (windowWidth - jQueryValamis('.js-add-page-down').outerWidth() - sidebarWidth) / 2 + 'px'
    });

    jQueryValamis('.reveal > .controls').css({
        'position': 'absolute',
        'left': revealControlsOffsetX + 'px',
        'top': revealControlsOffsetY + 'px'
    });

    if(slidesApp.mode.indexOf('arrange') != -1) {
        jQueryValamis('#arrangeContainer').height(windowHeight - jQueryValamis(window.parent.document).find('.js-slides-editor-topbar').outerHeight());
        jQueryValamis('#arrangeContainer').width(windowWidth);
        arrangeModule.initDraggable();
    }
}

(function() {
    var objGlobal = this;
    if(!(objGlobal.escape && objGlobal.unescape)) {
        var escapeHash = {
            _ : function(input) {
                var ret = escapeHash[input];
                if(!ret) {
                    if(input.length - 1) {
                        ret = String.fromCharCode(input.substring(input.length - 3 ? 2 : 1));
                    }
                    else {
                        var code = input.charCodeAt(0);
                        ret = code < 256
                            ? "%" + (0 + code.toString(16)).slice(-2).toUpperCase()
                            : "%u" + ("000" + code.toString(16)).slice(-4).toUpperCase();
                    }
                    escapeHash[ret] = input;
                    escapeHash[input] = ret;
                }
                return ret;
            }
        };
        objGlobal.escape = objGlobal.escape || function(str) {
            return str.replace(/[^\w @\*\-\+\.\/]/g, function(aChar) {
                return escapeHash._(aChar);
            });
        };
        objGlobal.unescape = objGlobal.unescape || function(str) {
            return str.replace(/%(u[\da-f]{4}|[\da-f]{2})/gi, function(seq) {
                return escapeHash._(seq);
            });
        };
    }
})();

var mimeToExt = {
    'image': {
        'image/jpeg': 'img',
        'image/png': 'png',
        'image/gif': 'gif',
        'image/pjpeg': 'jpeg',
        'image/svg+xml': 'svg',
        'image/tiff': 'tiff',
        'image/vnd.microsoft.icon': 'ico',
        'image/bmp': 'bmp'
    },
    'video': {
        'video/mp4': 'mp4',
        'video/mpeg': 'mpeg',
        'video/x-flv': 'flv',
        'video/3gpp': '3gp',
        'video/quicktime': 'mov',
        'video/x-msvideo': 'avi',
        'video/ogg': 'ogv',
        'video/webm': 'webm'
    },
    'pdf': {
        'application/pdf': 'pdf'
    }
};
function getExtByMime(mime) {
    for(var i in mimeToExt)
        if (mimeToExt[i].hasOwnProperty(mime))
            return mimeToExt[i][mime];
    return false;
}
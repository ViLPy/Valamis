/*
 Implementing Liferay Poller Service for reactive portlet.
 Client-side.
 */

/* Hacking out console for IE testing so it is like a "console" */
if (!window.console) {
    window.console = {
        write: function (msg) {
            $('body').append('<div class="alert-msg">' + msg + '</div>');
        },
        log: function (msg) {
            $('body').append('<div class="alert-msg">' + msg + '</div>');
        },
        dir: function (msg) {
            $('body').append('<div class="alert-msg">' + msg + '</div>');
        }
    };
}

/* just for testing */

AUI().use(
    'aui-base',
    'liferay-poller',
    function (A) {
        Liferay.namespace('NotificationsPoller');
        Liferay.NotificationsPoller.Manager = {
            init: function () {
                //console.log('NotificationsPoller Init called');
                var instance = this;
                instance._portletId = A.one('#portletID').val();
                instance._notificationsContainer = "info";
                //console.log('PortletId: ' + instance._portletId);
                instance._sendTask = A.debounce(instance.send, 20000, instance);
                //console.log('SendTask created');
                Liferay.Poller.init({
                    encryptedUserId: A.one('#encryptUserID').val(),
                    supportsComet: false
                });
                Liferay.Poller.addListener(instance._portletId, instance._doPollingUpdate, instance);
                //console.log('Listener Added');
                Liferay.on(
                    'sessionExpired',
                    function (event) {
                        Liferay.Poller.removeListener(instance._portletId);
                    }
                );

                //console.log('Session Expired event setup');


            },
            send: function (options, id) {
                var instance = this;
                //console.log('NotificationsPoller.send called');
                Liferay.Poller.submitRequest(instance._portletId, options, id);
            },
            _doPollingUpdate: function (response, chunkId) {
                //console.log('NotificationsPoller._doPollingUpdate called');
                var instance = this;
                if (response.content.update == "1") {
                    onGradeListChanged();
                }
                instance.send(
                    {
                        status: 'OK'
                    }
                );
            }
        };
        A.augment(Liferay.NotificationsPoller.Manager, A.Attribute, true);

        Liferay.publish(
            'notificationsPortletReady',
            {
                defaultFn: A.bind(Liferay.NotificationsPoller.Manager.init, Liferay.NotificationsPoller.Manager),
                fireOnce: true
            }
        );

        A.on(
            'domready',
            function () {
                Liferay.fire('notificationsPortletReady');
            }
        );
    }
);
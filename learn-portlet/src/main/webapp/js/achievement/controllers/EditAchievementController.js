app.controller('EditAchievementController', ['$scope', '$http', '$fileUploader', '$log', '$window', function ($scope, $http, $fileUploader, $log, $window) {
    $window.onmessage = function (e) {
        if (e.origin == "https://www.openbadges.me") {
            var tabId = $scope.jqTabs.tabs("option", "selected");

            $log.log(tabId);
            var achievement = $scope.tabs[tabId-1].achievement;
            $log.log(achievement);
            var url = "{0}/services/upload/base64-icon/achievement/{1}"
                .replace("{0}", $window.scormContextPath)
                .replace("{1}", achievement.id);

            $http
                .post(url, { 'inputBase64': e.data })
                .success(function () {
                    achievement.logo = "{0}/services/openbadges?directory={1}&fileName=icon.png&date={3}"
                        .replace("{0}", $window.scormContextPath)
                        .replace("{1}", achievement.id)
                        .replace("{3}", Date.parse(new Date()));

                    saveAchievement();
                });
        }
    }

    function getAvailableActivities() {
        return from($scope.allActivities)
            .except($scope.achievement.activities, function (activity1, activity2) {
                return activity1.name == activity2.name;
            })
            .toArray();
    }

    function updateLogo(newLogo) {
        $scope.achievement.logo = "{0}/services/openbadges?directory={1}&fileName={2}&date={3}"
            .replace("{0}", scormContextPath)
            .replace("{1}", $scope.achievement.id)
            .replace("{2}", newLogo)
            .replace("{3}", Date.parse(new Date()));

        saveAchievement();
    }

    function init() {
        var currentTab = $scope.tabs[$scope.tabs.length - 1];
        $scope.achievement = currentTab.achievement;
        $scope.isEditingTitle = false;

        var url = '{0}/services/activity/'
            .replace('{0}', $window.scormContextPath)
            .replace('{1}', $scope.achievement.id);

        $http.
            get(url)
            .success(function (response) {
                $scope.allActivities = response.data;
                $scope.activities = getAvailableActivities();
            });

        if (!$scope.disabledTestMode) {
            $scope.uploader = $fileUploader.create({
                scope: $scope,
                url: "{0}/services/upload/upload-icon/achievement/{1}"
                    .replace("{0}", $window.scormContextPath)
                    .replace("{1}", $scope.achievement.id)
            });

            $scope.uploader.filters.push(function (item) {
                var type = $scope.uploader.isHTML5
                    ? item.type
                    : '/' + item.value.slice(item.value.lastIndexOf('.') + 1);
                type = '|' + type.toLowerCase().slice(type.lastIndexOf('/') + 1) + '|';
                return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            });

            $scope.uploader.bind('afteraddingfile', function (event, item) {
                item.upload();
            });

            $scope.uploader.bind('complete', function (event, xhr, item, response) {
                updateLogo(response.name);
            });
        }
    }

    function saveAchievement(onSuccess) {
        var url = '{0}/services/achievement/{1}'
            .replace('{0}', $window.scormContextPath)
            .replace('{1}', $scope.achievement.id);

        var data = {
            action: "update",
            id: $scope.achievement.id,
            title: $scope.achievement.title,
            description: $scope.achievement.description,
            logo: $scope.achievement.logo,
            startDate: $scope.achievement.startDate
        };

        $http
            .post(url, data)
            .success(function () {
                if (onSuccess)
                    onSuccess();
            });
    }

    $scope.hasExceptedActivities = function () {
        return $scope.activities && $scope.activities.length > 0;
    }

    $scope.addActivity = function (activity) {
        var url = '{0}/services/achievement/activity/'
            .replace('{0}', scormContextPath);

        $http
            .post(url, {
                action: "add",
                achievementId: $scope.achievement.id,
                activityClassName: activity.name
            })
            .success(function (response) {
                $scope.achievement.activities.push(response.data);

                var index = $scope.activities.indexOf(activity);
                $scope.activities.splice(index, 1);
            })
    }

    $scope.editTitle = function () {
        $scope.isEditingTitle = true;
        $scope.newTitle = $scope.achievement.title;
    }

    $scope.unescape = $window.unescape;

    $scope.applyTitle = function () {
        $scope.isEditingTitle = false;
        $scope.achievement.title = $scope.newTitle;

        saveAchievement(function(){
            $scope.$emit('achievementChanged', $scope.achievement);
        });
    }

    $scope.modifyWithDesignBadge = function () {
        var url = 'https://www.openbadges.me/designer.html?origin=http://{0}&email=developer@example.com&close=true'.replace("{0}", rootUrl);
        var options = 'width=1015,height=680,location=0,menubar=0,status=0,toolbar=0';
        $window.open(url, '', options);
    }

    $scope.removeActivity = function (activity) {
        var url = '{0}/services/achievement/activity/{1}'
            .replace('{0}', $window.scormContextPath)
            .replace('{1}', activity.id);

        $http
            .post(url, { action: "delete" })
            .success(function () {
                var index = $scope.achievement.activities.indexOf(activity);
                $scope.achievement.activities.splice(index, 1);
                $scope.activities = getAvailableActivities();
            })
    }

    $scope.requiredActivityNumberChanged = function (activity) {
        if (!activity.numberActivitiesRequired && activity.numberActivitiesRequired > 0)
            return;

        var url = '{0}/services/achievement/activity/{1}'
            .replace('{0}', $window.scormContextPath)
            .replace('{1}', activity.id);

        var data = {
            action: "update",
            //activityId: activity.id,
            achievementId: $scope.achievement.id,
            numberActivitiesRequired: activity.requiredCount
        };

        $http.post(url, data);
    }

    $scope.dateChanged = function () {
        saveAchievement();
    }

    $scope.hasActivities = function () {
        return $scope.achievement.activities.length > 0;
    }

    $scope.descriptionEditorDialogConfig = {
        width: 930,
        resizable: false,
        modal: true,
        open: function () {
            jQuery("#descriptionEditor").val($scope.unescape($scope.achievement.description));

            this.tinyMceRedactor = jQuery("#descriptionEditor").tinymce({
                theme: "advanced",
                plugins: "table,file",
                relative_urls: false,
                convert_urls: false,
                theme_advanced_buttons3_add: "tablecontrols",
                fileServiceURL: Utils.getContextPath() + 'services/upload'
            });

            //jQuery(this.tinyMceRedactor).html($scope.unescape($scope.achievement.description));
        },
        buttons: {
            Ok: function () {
                $scope.achievement.description = jQuery(this.tinyMceRedactor).html();
                var that = this;
                saveAchievement(function () {
                    jQuery1816Curriculum(that).dialog("close");

                    $scope.$emit(
                        'achievementDescriptionChanged',
                        {
                            newDescription: $scope.achievement.description,
                            id: $scope.achievement.id
                        });
                    tinyMCE.EditorManager.execCommand('mceRemoveControl', true, "descriptionEditor");
                });
            },
            Cancel: function () {
                jQuery1816Curriculum(this).dialog("close");
                tinyMCE.EditorManager.execCommand('mceRemoveControl', true, "descriptionEditor");
            }
        }
    }

    $scope.activityDialogConfig = {
        width: 930,
        resizable: false,
        modal: true,
        buttons: {
            Cancel: function () {
                jQuery1816Curriculum(this).dialog("close");
            }
        }
    }

    $scope.startDateChanged = function() {
        saveAchievement();
    };

    init();
}]);
var jQuery1816Curriculum = jQuery.noConflict();
var scormLanguageDataCurriculum = {};
window.curriculumActionURL = "{{{actionURL}}}";

jQuery1816Curriculum(function () {
    Backbone.emulateJSON = true;
    Backbone.ajax = window.LearnAjax.ajax;
    window.LearnAjax.setHeader("scormUserID", "{{userID}}");
    window.LearnAjax.setHeader("liferayGroupID", "{{groupID}}");
    var defaultURL = Utils.getContextPath() + '/i18n/curriculum_en.properties';
    var localizedURL = Utils.getContextPath() + '/i18n/curriculum_{{language}}.properties';
    Utils.i18nLoader(localizedURL, defaultURL, onCurriculumLanguageLoad, onCurriculumLanguageError);
});

function onCurriculumLanguageLoad(properties) {
    scormLanguageDataCurriculum = properties;
    initCurriculumView();
}
function onCurriculumLanguageError() {
    alert('Translation resource loading failed!');
}

function initCurriculumView() {
    window.onmessage = function(e){
        if(e.origin=="https://www.openbadges.me"){
            var id = jQuery1816Curriculum("#selectedCertificateID").val();
            window.LearnAjax.post(Utils.getContextPath() + "services/upload/base64-icon/" + id,
                { 'inputBase64':e.data },
                jQuery.proxy(function () {
                    var icon = "<img src=\"" + Utils.getContextPath() +
                        "services/openbadges?directory=" + id +
                        "&fileName=icon.png&date="+ Date.now() +"\" class=\"logo\">";
                    jQuery("#certificateIcon_"+ id).html(icon);
                    jQuery("#certificateList_Icon_"+ id).html(icon);
                }, this));
        }
    }


    window.CurriculumAppView = Backbone.View.extend({
        initialize:function () {
            var loader = new TemplateLoader(jQuery1816Curriculum.proxy(this.initViews, this));
            loader.fetch("templates/curriculum_templates.html");
        },

        initViews:function () {
            if (!window.SitesDialog) {
                window.SitesDialog = new LiferaySiteSelectDialog({
                    el:jQuery1816Curriculum("#CurriculumLiferaySiteDialog"),
                    languageID:"{{language}}"
                });
            }
            if (!window.UsersDialog) {
                this.userList = new LiferayUserCollection();
                window.UsersDialog = new LiferayUserSelectDialog({
                    collection:this.userList,
                    el:jQuery1816Curriculum("#CurriculumLiferayUserDialog"),
                    language:scormLanguageDataCurriculum
                });
            }
            if (!window.CourseGradeDialog) {
                window.CourseGradeDialog = new UserCourseGradeDialog({
                    el:jQuery1816Curriculum("#CurriculumUserCourseGradeDialog"),
                    language:scormLanguageDataCurriculum
                });
            }

            this.availableCertificateList = new CertificateCollection();
            this.availableCertificates = new AvailableCertificateListView({
                collection:this.availableCertificateList,
                el:jQuery1816Curriculum('#certificateList'),
                language:scormLanguageDataCurriculum,
                isAdmin:true
            });
            this.availableCertificates.bind('certificateSite-open', this.openCertificateSite, this);
            this.availableCertificates.bind('certificateUser-open', this.openCertificateUser, this);
            this.availableCertificates.bind('certificate-remove', this.closeCertificate, this);

            this.openedCertificateCollection = new CertificateCollection();
            this.openedCertificates = new OpenedCertificateSiteView({
                collection:this.openedCertificateCollection,
                el:jQuery1816Curriculum('#certificateTabs'),
                language:scormLanguageDataCurriculum
            });

            /*this.availableCertificateList.fetch({reset:true});

            this.availableAchievements = new AchievementCollection();
            this.achievementView = new AvailableAchievementCollectionView({
                collection: this.availableAchievements,
                el: jQuery1816Curriculum("#achievementList"),
                language:scormLanguageDataCurriculum,
                isAdmin:true
            });

            this.availableAchievements.fetch({reset:true});*/

            //this.achievementView = new AvailableAchievementCollectionView({collection: this.availableAchievementCollection});
        },

        openCertificateUser:function (certificate) {
            this.openCertificate(certificate, "user");
        },
        openCertificateSite:function (certificate) {
            this.openCertificate(certificate, "site");
        },
        openCertificate:function (certificate, mode) {
            var model = this.openedCertificateCollection.get(certificate.id);
            if (model && model.viewMode == mode) {
                this.openedCertificates.select(certificate);
            } else {
                if (model) this.openedCertificateCollection.remove(model);
                certificate.viewMode = mode;
                this.openedCertificateCollection.add(certificate);
            }
        },
        closeCertificate:function (certificateID) {
            var item = this.openedCertificateCollection.get(certificateID);
            this.openedCertificateCollection.remove(item);
        },

        openAchievement: function(achivement, model) {
            console.log("openAchievement not implemented")
        }
    });

    window.CurriculumApp = new CurriculumAppView();
    if (!window.RichEdit) {
        window.RichEdit = new SCORMTinyMCERichEdit({el:jQuery1816Curriculum("#SCORMCurriculumEditRichEdit")});
    }



}
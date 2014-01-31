package com.arcusys.learn.persistence.liferay.service;

import com.arcusys.learn.persistence.liferay.model.LFAchievementActivityClp;
import com.arcusys.learn.persistence.liferay.model.LFAchievementClp;
import com.arcusys.learn.persistence.liferay.model.LFAchievementUserClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityDataMapClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateNodeClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTreeClp;
import com.arcusys.learn.persistence.liferay.model.LFAnswerClp;
import com.arcusys.learn.persistence.liferay.model.LFAttemptClp;
import com.arcusys.learn.persistence.liferay.model.LFAttemptDataClp;
import com.arcusys.learn.persistence.liferay.model.LFBigDecimalClp;
import com.arcusys.learn.persistence.liferay.model.LFCertificateClp;
import com.arcusys.learn.persistence.liferay.model.LFCertificateSiteClp;
import com.arcusys.learn.persistence.liferay.model.LFCertificateUserClp;
import com.arcusys.learn.persistence.liferay.model.LFChildrenSelectionClp;
import com.arcusys.learn.persistence.liferay.model.LFConditionRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFConfigClp;
import com.arcusys.learn.persistence.liferay.model.LFCourseClp;
import com.arcusys.learn.persistence.liferay.model.LFFileStorageClp;
import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveStateClp;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveClp;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveMapClp;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveStateClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageCommentClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageVoteClp;
import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFQuestionCategoryClp;
import com.arcusys.learn.persistence.liferay.model.LFQuestionClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategoryClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionClp;
import com.arcusys.learn.persistence.liferay.model.LFRequiredActivityClp;
import com.arcusys.learn.persistence.liferay.model.LFResourceClp;
import com.arcusys.learn.persistence.liferay.model.LFRoleClp;
import com.arcusys.learn.persistence.liferay.model.LFRollupContributionClp;
import com.arcusys.learn.persistence.liferay.model.LFRollupRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFRuleConditionClp;
import com.arcusys.learn.persistence.liferay.model.LFSequencingClp;
import com.arcusys.learn.persistence.liferay.model.LFSequencingPermissionsClp;
import com.arcusys.learn.persistence.liferay.model.LFSequencingTrackingClp;
import com.arcusys.learn.persistence.liferay.model.LFSocialPackageClp;
import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTagClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanActivityClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanActorClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfileClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfileClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachmentClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivitiesClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocumentClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpointClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResultClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStateClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRefClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatementClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivityClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanPackageClp;
import com.arcusys.learn.persistence.liferay.model.LFUserClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "learn-maven-plugin-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "learn-maven-plugin-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "learn-maven-plugin";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(LFAchievementClp.class.getName())) {
            return translateInputLFAchievement(oldModel);
        }

        if (oldModelClassName.equals(LFAchievementActivityClp.class.getName())) {
            return translateInputLFAchievementActivity(oldModel);
        }

        if (oldModelClassName.equals(LFAchievementUserClp.class.getName())) {
            return translateInputLFAchievementUser(oldModel);
        }

        if (oldModelClassName.equals(LFActivityClp.class.getName())) {
            return translateInputLFActivity(oldModel);
        }

        if (oldModelClassName.equals(LFActivityDataMapClp.class.getName())) {
            return translateInputLFActivityDataMap(oldModel);
        }

        if (oldModelClassName.equals(LFActivityStateClp.class.getName())) {
            return translateInputLFActivityState(oldModel);
        }

        if (oldModelClassName.equals(LFActivityStateNodeClp.class.getName())) {
            return translateInputLFActivityStateNode(oldModel);
        }

        if (oldModelClassName.equals(LFActivityStateTreeClp.class.getName())) {
            return translateInputLFActivityStateTree(oldModel);
        }

        if (oldModelClassName.equals(LFAnswerClp.class.getName())) {
            return translateInputLFAnswer(oldModel);
        }

        if (oldModelClassName.equals(LFAttemptClp.class.getName())) {
            return translateInputLFAttempt(oldModel);
        }

        if (oldModelClassName.equals(LFAttemptDataClp.class.getName())) {
            return translateInputLFAttemptData(oldModel);
        }

        if (oldModelClassName.equals(LFBigDecimalClp.class.getName())) {
            return translateInputLFBigDecimal(oldModel);
        }

        if (oldModelClassName.equals(LFCertificateClp.class.getName())) {
            return translateInputLFCertificate(oldModel);
        }

        if (oldModelClassName.equals(LFCertificateSiteClp.class.getName())) {
            return translateInputLFCertificateSite(oldModel);
        }

        if (oldModelClassName.equals(LFCertificateUserClp.class.getName())) {
            return translateInputLFCertificateUser(oldModel);
        }

        if (oldModelClassName.equals(LFChildrenSelectionClp.class.getName())) {
            return translateInputLFChildrenSelection(oldModel);
        }

        if (oldModelClassName.equals(LFConditionRuleClp.class.getName())) {
            return translateInputLFConditionRule(oldModel);
        }

        if (oldModelClassName.equals(LFConfigClp.class.getName())) {
            return translateInputLFConfig(oldModel);
        }

        if (oldModelClassName.equals(LFCourseClp.class.getName())) {
            return translateInputLFCourse(oldModel);
        }

        if (oldModelClassName.equals(LFFileStorageClp.class.getName())) {
            return translateInputLFFileStorage(oldModel);
        }

        if (oldModelClassName.equals(LFGlobalObjectiveStateClp.class.getName())) {
            return translateInputLFGlobalObjectiveState(oldModel);
        }

        if (oldModelClassName.equals(LFObjectiveClp.class.getName())) {
            return translateInputLFObjective(oldModel);
        }

        if (oldModelClassName.equals(LFObjectiveMapClp.class.getName())) {
            return translateInputLFObjectiveMap(oldModel);
        }

        if (oldModelClassName.equals(LFObjectiveStateClp.class.getName())) {
            return translateInputLFObjectiveState(oldModel);
        }

        if (oldModelClassName.equals(LFPackageClp.class.getName())) {
            return translateInputLFPackage(oldModel);
        }

        if (oldModelClassName.equals(LFPackageCommentClp.class.getName())) {
            return translateInputLFPackageComment(oldModel);
        }

        if (oldModelClassName.equals(LFPackageScopeRuleClp.class.getName())) {
            return translateInputLFPackageScopeRule(oldModel);
        }

        if (oldModelClassName.equals(LFPackageVoteClp.class.getName())) {
            return translateInputLFPackageVote(oldModel);
        }

        if (oldModelClassName.equals(LFPlayerScopeRuleClp.class.getName())) {
            return translateInputLFPlayerScopeRule(oldModel);
        }

        if (oldModelClassName.equals(LFQuestionClp.class.getName())) {
            return translateInputLFQuestion(oldModel);
        }

        if (oldModelClassName.equals(LFQuestionCategoryClp.class.getName())) {
            return translateInputLFQuestionCategory(oldModel);
        }

        if (oldModelClassName.equals(LFQuizClp.class.getName())) {
            return translateInputLFQuiz(oldModel);
        }

        if (oldModelClassName.equals(LFQuizQuestionClp.class.getName())) {
            return translateInputLFQuizQuestion(oldModel);
        }

        if (oldModelClassName.equals(LFQuizQuestionCategoryClp.class.getName())) {
            return translateInputLFQuizQuestionCategory(oldModel);
        }

        if (oldModelClassName.equals(LFRequiredActivityClp.class.getName())) {
            return translateInputLFRequiredActivity(oldModel);
        }

        if (oldModelClassName.equals(LFResourceClp.class.getName())) {
            return translateInputLFResource(oldModel);
        }

        if (oldModelClassName.equals(LFRoleClp.class.getName())) {
            return translateInputLFRole(oldModel);
        }

        if (oldModelClassName.equals(LFRollupContributionClp.class.getName())) {
            return translateInputLFRollupContribution(oldModel);
        }

        if (oldModelClassName.equals(LFRollupRuleClp.class.getName())) {
            return translateInputLFRollupRule(oldModel);
        }

        if (oldModelClassName.equals(LFRuleConditionClp.class.getName())) {
            return translateInputLFRuleCondition(oldModel);
        }

        if (oldModelClassName.equals(LFSequencingClp.class.getName())) {
            return translateInputLFSequencing(oldModel);
        }

        if (oldModelClassName.equals(LFSequencingPermissionsClp.class.getName())) {
            return translateInputLFSequencingPermissions(oldModel);
        }

        if (oldModelClassName.equals(LFSequencingTrackingClp.class.getName())) {
            return translateInputLFSequencingTracking(oldModel);
        }

        if (oldModelClassName.equals(LFSocialPackageClp.class.getName())) {
            return translateInputLFSocialPackage(oldModel);
        }

        if (oldModelClassName.equals(LFSocialPackageTagClp.class.getName())) {
            return translateInputLFSocialPackageTag(oldModel);
        }

        if (oldModelClassName.equals(LFTincanActivityClp.class.getName())) {
            return translateInputLFTincanActivity(oldModel);
        }

        if (oldModelClassName.equals(LFTincanActorClp.class.getName())) {
            return translateInputLFTincanActor(oldModel);
        }

        if (oldModelClassName.equals(
                    LFTincanLrsActivityProfileClp.class.getName())) {
            return translateInputLFTincanLrsActivityProfile(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsAgentProfileClp.class.getName())) {
            return translateInputLFTincanLrsAgentProfile(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsAttachmentClp.class.getName())) {
            return translateInputLFTincanLrsAttachment(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsContextClp.class.getName())) {
            return translateInputLFTincanLrsContext(oldModel);
        }

        if (oldModelClassName.equals(
                    LFTincanLrsContextActivitiesClp.class.getName())) {
            return translateInputLFTincanLrsContextActivities(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsDocumentClp.class.getName())) {
            return translateInputLFTincanLrsDocument(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsEndpointClp.class.getName())) {
            return translateInputLFTincanLrsEndpoint(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsResultClp.class.getName())) {
            return translateInputLFTincanLrsResult(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsStateClp.class.getName())) {
            return translateInputLFTincanLrsState(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsStatementClp.class.getName())) {
            return translateInputLFTincanLrsStatement(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsStatementRefClp.class.getName())) {
            return translateInputLFTincanLrsStatementRef(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsSubStatementClp.class.getName())) {
            return translateInputLFTincanLrsSubStatement(oldModel);
        }

        if (oldModelClassName.equals(
                    LFTincanManifestActivityClp.class.getName())) {
            return translateInputLFTincanManifestActivity(oldModel);
        }

        if (oldModelClassName.equals(LFTincanPackageClp.class.getName())) {
            return translateInputLFTincanPackage(oldModel);
        }

        if (oldModelClassName.equals(LFUserClp.class.getName())) {
            return translateInputLFUser(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputLFAchievement(BaseModel<?> oldModel) {
        LFAchievementClp oldClpModel = (LFAchievementClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFAchievementRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFAchievementActivity(
        BaseModel<?> oldModel) {
        LFAchievementActivityClp oldClpModel = (LFAchievementActivityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFAchievementActivityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFAchievementUser(BaseModel<?> oldModel) {
        LFAchievementUserClp oldClpModel = (LFAchievementUserClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFAchievementUserRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFActivity(BaseModel<?> oldModel) {
        LFActivityClp oldClpModel = (LFActivityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFActivityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFActivityDataMap(BaseModel<?> oldModel) {
        LFActivityDataMapClp oldClpModel = (LFActivityDataMapClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFActivityDataMapRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFActivityState(BaseModel<?> oldModel) {
        LFActivityStateClp oldClpModel = (LFActivityStateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFActivityStateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFActivityStateNode(
        BaseModel<?> oldModel) {
        LFActivityStateNodeClp oldClpModel = (LFActivityStateNodeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFActivityStateNodeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFActivityStateTree(
        BaseModel<?> oldModel) {
        LFActivityStateTreeClp oldClpModel = (LFActivityStateTreeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFActivityStateTreeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFAnswer(BaseModel<?> oldModel) {
        LFAnswerClp oldClpModel = (LFAnswerClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFAnswerRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFAttempt(BaseModel<?> oldModel) {
        LFAttemptClp oldClpModel = (LFAttemptClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFAttemptRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFAttemptData(BaseModel<?> oldModel) {
        LFAttemptDataClp oldClpModel = (LFAttemptDataClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFAttemptDataRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFBigDecimal(BaseModel<?> oldModel) {
        LFBigDecimalClp oldClpModel = (LFBigDecimalClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFBigDecimalRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFCertificate(BaseModel<?> oldModel) {
        LFCertificateClp oldClpModel = (LFCertificateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFCertificateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFCertificateSite(BaseModel<?> oldModel) {
        LFCertificateSiteClp oldClpModel = (LFCertificateSiteClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFCertificateSiteRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFCertificateUser(BaseModel<?> oldModel) {
        LFCertificateUserClp oldClpModel = (LFCertificateUserClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFCertificateUserRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFChildrenSelection(
        BaseModel<?> oldModel) {
        LFChildrenSelectionClp oldClpModel = (LFChildrenSelectionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFChildrenSelectionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFConditionRule(BaseModel<?> oldModel) {
        LFConditionRuleClp oldClpModel = (LFConditionRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFConditionRuleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFConfig(BaseModel<?> oldModel) {
        LFConfigClp oldClpModel = (LFConfigClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFConfigRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFCourse(BaseModel<?> oldModel) {
        LFCourseClp oldClpModel = (LFCourseClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFCourseRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFFileStorage(BaseModel<?> oldModel) {
        LFFileStorageClp oldClpModel = (LFFileStorageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFFileStorageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFGlobalObjectiveState(
        BaseModel<?> oldModel) {
        LFGlobalObjectiveStateClp oldClpModel = (LFGlobalObjectiveStateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFGlobalObjectiveStateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFObjective(BaseModel<?> oldModel) {
        LFObjectiveClp oldClpModel = (LFObjectiveClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFObjectiveRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFObjectiveMap(BaseModel<?> oldModel) {
        LFObjectiveMapClp oldClpModel = (LFObjectiveMapClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFObjectiveMapRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFObjectiveState(BaseModel<?> oldModel) {
        LFObjectiveStateClp oldClpModel = (LFObjectiveStateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFObjectiveStateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFPackage(BaseModel<?> oldModel) {
        LFPackageClp oldClpModel = (LFPackageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPackageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFPackageComment(BaseModel<?> oldModel) {
        LFPackageCommentClp oldClpModel = (LFPackageCommentClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPackageCommentRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFPackageScopeRule(BaseModel<?> oldModel) {
        LFPackageScopeRuleClp oldClpModel = (LFPackageScopeRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPackageScopeRuleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFPackageVote(BaseModel<?> oldModel) {
        LFPackageVoteClp oldClpModel = (LFPackageVoteClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPackageVoteRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFPlayerScopeRule(BaseModel<?> oldModel) {
        LFPlayerScopeRuleClp oldClpModel = (LFPlayerScopeRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPlayerScopeRuleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuestion(BaseModel<?> oldModel) {
        LFQuestionClp oldClpModel = (LFQuestionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuestionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuestionCategory(BaseModel<?> oldModel) {
        LFQuestionCategoryClp oldClpModel = (LFQuestionCategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuestionCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuiz(BaseModel<?> oldModel) {
        LFQuizClp oldClpModel = (LFQuizClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuizQuestion(BaseModel<?> oldModel) {
        LFQuizQuestionClp oldClpModel = (LFQuizQuestionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizQuestionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuizQuestionCategory(
        BaseModel<?> oldModel) {
        LFQuizQuestionCategoryClp oldClpModel = (LFQuizQuestionCategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizQuestionCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFRequiredActivity(BaseModel<?> oldModel) {
        LFRequiredActivityClp oldClpModel = (LFRequiredActivityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFRequiredActivityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFResource(BaseModel<?> oldModel) {
        LFResourceClp oldClpModel = (LFResourceClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFResourceRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFRole(BaseModel<?> oldModel) {
        LFRoleClp oldClpModel = (LFRoleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFRoleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFRollupContribution(
        BaseModel<?> oldModel) {
        LFRollupContributionClp oldClpModel = (LFRollupContributionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFRollupContributionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFRollupRule(BaseModel<?> oldModel) {
        LFRollupRuleClp oldClpModel = (LFRollupRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFRollupRuleRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFRuleCondition(BaseModel<?> oldModel) {
        LFRuleConditionClp oldClpModel = (LFRuleConditionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFRuleConditionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSequencing(BaseModel<?> oldModel) {
        LFSequencingClp oldClpModel = (LFSequencingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSequencingRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSequencingPermissions(
        BaseModel<?> oldModel) {
        LFSequencingPermissionsClp oldClpModel = (LFSequencingPermissionsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSequencingPermissionsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSequencingTracking(
        BaseModel<?> oldModel) {
        LFSequencingTrackingClp oldClpModel = (LFSequencingTrackingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSequencingTrackingRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSocialPackage(BaseModel<?> oldModel) {
        LFSocialPackageClp oldClpModel = (LFSocialPackageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSocialPackageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSocialPackageTag(BaseModel<?> oldModel) {
        LFSocialPackageTagClp oldClpModel = (LFSocialPackageTagClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSocialPackageTagRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanActivity(BaseModel<?> oldModel) {
        LFTincanActivityClp oldClpModel = (LFTincanActivityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanActivityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanActor(BaseModel<?> oldModel) {
        LFTincanActorClp oldClpModel = (LFTincanActorClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanActorRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsActivityProfile(
        BaseModel<?> oldModel) {
        LFTincanLrsActivityProfileClp oldClpModel = (LFTincanLrsActivityProfileClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsActivityProfileRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsAgentProfile(
        BaseModel<?> oldModel) {
        LFTincanLrsAgentProfileClp oldClpModel = (LFTincanLrsAgentProfileClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsAgentProfileRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsAttachment(
        BaseModel<?> oldModel) {
        LFTincanLrsAttachmentClp oldClpModel = (LFTincanLrsAttachmentClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsAttachmentRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsContext(BaseModel<?> oldModel) {
        LFTincanLrsContextClp oldClpModel = (LFTincanLrsContextClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsContextRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsContextActivities(
        BaseModel<?> oldModel) {
        LFTincanLrsContextActivitiesClp oldClpModel = (LFTincanLrsContextActivitiesClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsContextActivitiesRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsDocument(
        BaseModel<?> oldModel) {
        LFTincanLrsDocumentClp oldClpModel = (LFTincanLrsDocumentClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsDocumentRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsEndpoint(
        BaseModel<?> oldModel) {
        LFTincanLrsEndpointClp oldClpModel = (LFTincanLrsEndpointClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsEndpointRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsResult(BaseModel<?> oldModel) {
        LFTincanLrsResultClp oldClpModel = (LFTincanLrsResultClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsResultRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsState(BaseModel<?> oldModel) {
        LFTincanLrsStateClp oldClpModel = (LFTincanLrsStateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsStateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsStatement(
        BaseModel<?> oldModel) {
        LFTincanLrsStatementClp oldClpModel = (LFTincanLrsStatementClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsStatementRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsStatementRef(
        BaseModel<?> oldModel) {
        LFTincanLrsStatementRefClp oldClpModel = (LFTincanLrsStatementRefClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsStatementRefRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanLrsSubStatement(
        BaseModel<?> oldModel) {
        LFTincanLrsSubStatementClp oldClpModel = (LFTincanLrsSubStatementClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanLrsSubStatementRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanManifestActivity(
        BaseModel<?> oldModel) {
        LFTincanManifestActivityClp oldClpModel = (LFTincanManifestActivityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanManifestActivityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanPackage(BaseModel<?> oldModel) {
        LFTincanPackageClp oldClpModel = (LFTincanPackageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanPackageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFUser(BaseModel<?> oldModel) {
        LFUserClp oldClpModel = (LFUserClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFUserRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFAchievementImpl")) {
            return translateOutputLFAchievement(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityImpl")) {
            return translateOutputLFAchievementActivity(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserImpl")) {
            return translateOutputLFAchievementUser(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFActivityImpl")) {
            return translateOutputLFActivity(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapImpl")) {
            return translateOutputLFActivityDataMap(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateImpl")) {
            return translateOutputLFActivityState(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateNodeImpl")) {
            return translateOutputLFActivityStateNode(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateTreeImpl")) {
            return translateOutputLFActivityStateTree(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFAnswerImpl")) {
            return translateOutputLFAnswer(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFAttemptImpl")) {
            return translateOutputLFAttempt(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataImpl")) {
            return translateOutputLFAttemptData(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalImpl")) {
            return translateOutputLFBigDecimal(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFCertificateImpl")) {
            return translateOutputLFCertificate(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteImpl")) {
            return translateOutputLFCertificateSite(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserImpl")) {
            return translateOutputLFCertificateUser(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionImpl")) {
            return translateOutputLFChildrenSelection(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFConditionRuleImpl")) {
            return translateOutputLFConditionRule(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFConfigImpl")) {
            return translateOutputLFConfig(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFCourseImpl")) {
            return translateOutputLFCourse(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageImpl")) {
            return translateOutputLFFileStorage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateImpl")) {
            return translateOutputLFGlobalObjectiveState(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveImpl")) {
            return translateOutputLFObjective(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapImpl")) {
            return translateOutputLFObjectiveMap(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveStateImpl")) {
            return translateOutputLFObjectiveState(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPackageImpl")) {
            return translateOutputLFPackage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPackageCommentImpl")) {
            return translateOutputLFPackageComment(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleImpl")) {
            return translateOutputLFPackageScopeRule(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteImpl")) {
            return translateOutputLFPackageVote(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleImpl")) {
            return translateOutputLFPlayerScopeRule(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuestionImpl")) {
            return translateOutputLFQuestion(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuestionCategoryImpl")) {
            return translateOutputLFQuestionCategory(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizImpl")) {
            return translateOutputLFQuiz(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionImpl")) {
            return translateOutputLFQuizQuestion(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryImpl")) {
            return translateOutputLFQuizQuestionCategory(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityImpl")) {
            return translateOutputLFRequiredActivity(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFResourceImpl")) {
            return translateOutputLFResource(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFRoleImpl")) {
            return translateOutputLFRole(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionImpl")) {
            return translateOutputLFRollupContribution(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleImpl")) {
            return translateOutputLFRollupRule(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionImpl")) {
            return translateOutputLFRuleCondition(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSequencingImpl")) {
            return translateOutputLFSequencing(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSequencingPermissionsImpl")) {
            return translateOutputLFSequencingPermissions(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingImpl")) {
            return translateOutputLFSequencingTracking(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageImpl")) {
            return translateOutputLFSocialPackage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagImpl")) {
            return translateOutputLFSocialPackageTag(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityImpl")) {
            return translateOutputLFTincanActivity(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanActorImpl")) {
            return translateOutputLFTincanActor(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileImpl")) {
            return translateOutputLFTincanLrsActivityProfile(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAgentProfileImpl")) {
            return translateOutputLFTincanLrsAgentProfile(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentImpl")) {
            return translateOutputLFTincanLrsAttachment(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextImpl")) {
            return translateOutputLFTincanLrsContext(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesImpl")) {
            return translateOutputLFTincanLrsContextActivities(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentImpl")) {
            return translateOutputLFTincanLrsDocument(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointImpl")) {
            return translateOutputLFTincanLrsEndpoint(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultImpl")) {
            return translateOutputLFTincanLrsResult(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateImpl")) {
            return translateOutputLFTincanLrsState(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementImpl")) {
            return translateOutputLFTincanLrsStatement(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefImpl")) {
            return translateOutputLFTincanLrsStatementRef(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsSubStatementImpl")) {
            return translateOutputLFTincanLrsSubStatement(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityImpl")) {
            return translateOutputLFTincanManifestActivity(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageImpl")) {
            return translateOutputLFTincanPackage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFUserImpl")) {
            return translateOutputLFUser(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFActivityException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFActivityException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateNodeException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFActivityStateTreeException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFConfigException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFConfigException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFCourseException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFCourseException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFFileStorageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPackageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPackageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPackageCommentException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPackageVoteException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFResourceException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFResourceException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFRoleException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFRoleException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSequencingPermissionsException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSequencingPermissionsException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanActorException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStateException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFUserException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFUserException();
        }

        return throwable;
    }

    public static Object translateOutputLFAchievement(BaseModel<?> oldModel) {
        LFAchievementClp newModel = new LFAchievementClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFAchievementRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFAchievementActivity(
        BaseModel<?> oldModel) {
        LFAchievementActivityClp newModel = new LFAchievementActivityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFAchievementActivityRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFAchievementUser(BaseModel<?> oldModel) {
        LFAchievementUserClp newModel = new LFAchievementUserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFAchievementUserRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFActivity(BaseModel<?> oldModel) {
        LFActivityClp newModel = new LFActivityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFActivityRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFActivityDataMap(BaseModel<?> oldModel) {
        LFActivityDataMapClp newModel = new LFActivityDataMapClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFActivityDataMapRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFActivityState(BaseModel<?> oldModel) {
        LFActivityStateClp newModel = new LFActivityStateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFActivityStateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFActivityStateNode(
        BaseModel<?> oldModel) {
        LFActivityStateNodeClp newModel = new LFActivityStateNodeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFActivityStateNodeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFActivityStateTree(
        BaseModel<?> oldModel) {
        LFActivityStateTreeClp newModel = new LFActivityStateTreeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFActivityStateTreeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFAnswer(BaseModel<?> oldModel) {
        LFAnswerClp newModel = new LFAnswerClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFAnswerRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFAttempt(BaseModel<?> oldModel) {
        LFAttemptClp newModel = new LFAttemptClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFAttemptRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFAttemptData(BaseModel<?> oldModel) {
        LFAttemptDataClp newModel = new LFAttemptDataClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFAttemptDataRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFBigDecimal(BaseModel<?> oldModel) {
        LFBigDecimalClp newModel = new LFBigDecimalClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFBigDecimalRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFCertificate(BaseModel<?> oldModel) {
        LFCertificateClp newModel = new LFCertificateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFCertificateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFCertificateSite(BaseModel<?> oldModel) {
        LFCertificateSiteClp newModel = new LFCertificateSiteClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFCertificateSiteRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFCertificateUser(BaseModel<?> oldModel) {
        LFCertificateUserClp newModel = new LFCertificateUserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFCertificateUserRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFChildrenSelection(
        BaseModel<?> oldModel) {
        LFChildrenSelectionClp newModel = new LFChildrenSelectionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFChildrenSelectionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFConditionRule(BaseModel<?> oldModel) {
        LFConditionRuleClp newModel = new LFConditionRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFConditionRuleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFConfig(BaseModel<?> oldModel) {
        LFConfigClp newModel = new LFConfigClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFConfigRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFCourse(BaseModel<?> oldModel) {
        LFCourseClp newModel = new LFCourseClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFCourseRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFFileStorage(BaseModel<?> oldModel) {
        LFFileStorageClp newModel = new LFFileStorageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFFileStorageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFGlobalObjectiveState(
        BaseModel<?> oldModel) {
        LFGlobalObjectiveStateClp newModel = new LFGlobalObjectiveStateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFGlobalObjectiveStateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFObjective(BaseModel<?> oldModel) {
        LFObjectiveClp newModel = new LFObjectiveClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFObjectiveRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFObjectiveMap(BaseModel<?> oldModel) {
        LFObjectiveMapClp newModel = new LFObjectiveMapClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFObjectiveMapRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFObjectiveState(BaseModel<?> oldModel) {
        LFObjectiveStateClp newModel = new LFObjectiveStateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFObjectiveStateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFPackage(BaseModel<?> oldModel) {
        LFPackageClp newModel = new LFPackageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPackageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFPackageComment(BaseModel<?> oldModel) {
        LFPackageCommentClp newModel = new LFPackageCommentClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPackageCommentRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFPackageScopeRule(
        BaseModel<?> oldModel) {
        LFPackageScopeRuleClp newModel = new LFPackageScopeRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPackageScopeRuleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFPackageVote(BaseModel<?> oldModel) {
        LFPackageVoteClp newModel = new LFPackageVoteClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPackageVoteRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFPlayerScopeRule(BaseModel<?> oldModel) {
        LFPlayerScopeRuleClp newModel = new LFPlayerScopeRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPlayerScopeRuleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuestion(BaseModel<?> oldModel) {
        LFQuestionClp newModel = new LFQuestionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuestionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuestionCategory(
        BaseModel<?> oldModel) {
        LFQuestionCategoryClp newModel = new LFQuestionCategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuestionCategoryRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuiz(BaseModel<?> oldModel) {
        LFQuizClp newModel = new LFQuizClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuizQuestion(BaseModel<?> oldModel) {
        LFQuizQuestionClp newModel = new LFQuizQuestionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizQuestionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuizQuestionCategory(
        BaseModel<?> oldModel) {
        LFQuizQuestionCategoryClp newModel = new LFQuizQuestionCategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizQuestionCategoryRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFRequiredActivity(
        BaseModel<?> oldModel) {
        LFRequiredActivityClp newModel = new LFRequiredActivityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFRequiredActivityRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFResource(BaseModel<?> oldModel) {
        LFResourceClp newModel = new LFResourceClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFResourceRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFRole(BaseModel<?> oldModel) {
        LFRoleClp newModel = new LFRoleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFRoleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFRollupContribution(
        BaseModel<?> oldModel) {
        LFRollupContributionClp newModel = new LFRollupContributionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFRollupContributionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFRollupRule(BaseModel<?> oldModel) {
        LFRollupRuleClp newModel = new LFRollupRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFRollupRuleRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFRuleCondition(BaseModel<?> oldModel) {
        LFRuleConditionClp newModel = new LFRuleConditionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFRuleConditionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSequencing(BaseModel<?> oldModel) {
        LFSequencingClp newModel = new LFSequencingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSequencingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSequencingPermissions(
        BaseModel<?> oldModel) {
        LFSequencingPermissionsClp newModel = new LFSequencingPermissionsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSequencingPermissionsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSequencingTracking(
        BaseModel<?> oldModel) {
        LFSequencingTrackingClp newModel = new LFSequencingTrackingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSequencingTrackingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSocialPackage(BaseModel<?> oldModel) {
        LFSocialPackageClp newModel = new LFSocialPackageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSocialPackageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSocialPackageTag(
        BaseModel<?> oldModel) {
        LFSocialPackageTagClp newModel = new LFSocialPackageTagClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSocialPackageTagRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanActivity(BaseModel<?> oldModel) {
        LFTincanActivityClp newModel = new LFTincanActivityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanActivityRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanActor(BaseModel<?> oldModel) {
        LFTincanActorClp newModel = new LFTincanActorClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanActorRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsActivityProfile(
        BaseModel<?> oldModel) {
        LFTincanLrsActivityProfileClp newModel = new LFTincanLrsActivityProfileClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsActivityProfileRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsAgentProfile(
        BaseModel<?> oldModel) {
        LFTincanLrsAgentProfileClp newModel = new LFTincanLrsAgentProfileClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsAgentProfileRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsAttachment(
        BaseModel<?> oldModel) {
        LFTincanLrsAttachmentClp newModel = new LFTincanLrsAttachmentClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsAttachmentRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsContext(
        BaseModel<?> oldModel) {
        LFTincanLrsContextClp newModel = new LFTincanLrsContextClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsContextRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsContextActivities(
        BaseModel<?> oldModel) {
        LFTincanLrsContextActivitiesClp newModel = new LFTincanLrsContextActivitiesClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsContextActivitiesRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsDocument(
        BaseModel<?> oldModel) {
        LFTincanLrsDocumentClp newModel = new LFTincanLrsDocumentClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsDocumentRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsEndpoint(
        BaseModel<?> oldModel) {
        LFTincanLrsEndpointClp newModel = new LFTincanLrsEndpointClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsEndpointRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsResult(BaseModel<?> oldModel) {
        LFTincanLrsResultClp newModel = new LFTincanLrsResultClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsResultRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsState(BaseModel<?> oldModel) {
        LFTincanLrsStateClp newModel = new LFTincanLrsStateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsStateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsStatement(
        BaseModel<?> oldModel) {
        LFTincanLrsStatementClp newModel = new LFTincanLrsStatementClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsStatementRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsStatementRef(
        BaseModel<?> oldModel) {
        LFTincanLrsStatementRefClp newModel = new LFTincanLrsStatementRefClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsStatementRefRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsSubStatement(
        BaseModel<?> oldModel) {
        LFTincanLrsSubStatementClp newModel = new LFTincanLrsSubStatementClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsSubStatementRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanManifestActivity(
        BaseModel<?> oldModel) {
        LFTincanManifestActivityClp newModel = new LFTincanManifestActivityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanManifestActivityRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanPackage(BaseModel<?> oldModel) {
        LFTincanPackageClp newModel = new LFTincanPackageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanPackageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFUser(BaseModel<?> oldModel) {
        LFUserClp newModel = new LFUserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFUserRemoteModel(oldModel);

        return newModel;
    }
}

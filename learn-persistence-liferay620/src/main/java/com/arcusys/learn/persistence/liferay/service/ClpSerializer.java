package com.arcusys.learn.persistence.liferay.service;

import com.arcusys.learn.persistence.liferay.model.LFActivityClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityDataMapClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateNodeClp;
import com.arcusys.learn.persistence.liferay.model.LFActivityStateTreeClp;
import com.arcusys.learn.persistence.liferay.model.LFAnswerClp;
import com.arcusys.learn.persistence.liferay.model.LFAttemptClp;
import com.arcusys.learn.persistence.liferay.model.LFAttemptDataClp;
import com.arcusys.learn.persistence.liferay.model.LFBigDecimalClp;
import com.arcusys.learn.persistence.liferay.model.LFChildrenSelectionClp;
import com.arcusys.learn.persistence.liferay.model.LFConditionRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFConfigClp;
import com.arcusys.learn.persistence.liferay.model.LFCourseClp;
import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveStateClp;
import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySettingClp;
import com.arcusys.learn.persistence.liferay.model.LFLessonLimitClp;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveClp;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveMapClp;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveStateClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorageClp;
import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFQuestionCategoryClp;
import com.arcusys.learn.persistence.liferay.model.LFQuestionClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScoreClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCatClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionClp;
import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElementClp;
import com.arcusys.learn.persistence.liferay.model.LFResourceClp;
import com.arcusys.learn.persistence.liferay.model.LFRollupContributionClp;
import com.arcusys.learn.persistence.liferay.model.LFRollupRuleClp;
import com.arcusys.learn.persistence.liferay.model.LFRuleConditionClp;
import com.arcusys.learn.persistence.liferay.model.LFSeqPermissionsClp;
import com.arcusys.learn.persistence.liferay.model.LFSequencingClp;
import com.arcusys.learn.persistence.liferay.model.LFSequencingTrackingClp;
import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfigClp;
import com.arcusys.learn.persistence.liferay.model.LFSlideClp;
import com.arcusys.learn.persistence.liferay.model.LFSlideEntityClp;
import com.arcusys.learn.persistence.liferay.model.LFSlideSetClp;
import com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorageClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpointClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanPackageClp;
import com.arcusys.learn.persistence.liferay.model.LFTincanURIClp;
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

        if (oldModelClassName.equals(LFGlblObjectiveStateClp.class.getName())) {
            return translateInputLFGlblObjectiveState(oldModel);
        }

        if (oldModelClassName.equals(LFLessonLimitClp.class.getName())) {
            return translateInputLFLessonLimit(oldModel);
        }

        if (oldModelClassName.equals(LFLRSToActivitySettingClp.class.getName())) {
            return translateInputLFLRSToActivitySetting(oldModel);
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

        if (oldModelClassName.equals(LFPackageGradeStorageClp.class.getName())) {
            return translateInputLFPackageGradeStorage(oldModel);
        }

        if (oldModelClassName.equals(LFPackageScopeRuleClp.class.getName())) {
            return translateInputLFPackageScopeRule(oldModel);
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

        if (oldModelClassName.equals(LFQuizAnswerScoreClp.class.getName())) {
            return translateInputLFQuizAnswerScore(oldModel);
        }

        if (oldModelClassName.equals(LFQuizQuestCatClp.class.getName())) {
            return translateInputLFQuizQuestCat(oldModel);
        }

        if (oldModelClassName.equals(LFQuizQuestionClp.class.getName())) {
            return translateInputLFQuizQuestion(oldModel);
        }

        if (oldModelClassName.equals(LFQuizTreeElementClp.class.getName())) {
            return translateInputLFQuizTreeElement(oldModel);
        }

        if (oldModelClassName.equals(LFResourceClp.class.getName())) {
            return translateInputLFResource(oldModel);
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

        if (oldModelClassName.equals(LFSeqPermissionsClp.class.getName())) {
            return translateInputLFSeqPermissions(oldModel);
        }

        if (oldModelClassName.equals(LFSequencingClp.class.getName())) {
            return translateInputLFSequencing(oldModel);
        }

        if (oldModelClassName.equals(LFSequencingTrackingClp.class.getName())) {
            return translateInputLFSequencingTracking(oldModel);
        }

        if (oldModelClassName.equals(LFSiteDependentConfigClp.class.getName())) {
            return translateInputLFSiteDependentConfig(oldModel);
        }

        if (oldModelClassName.equals(LFSlideClp.class.getName())) {
            return translateInputLFSlide(oldModel);
        }

        if (oldModelClassName.equals(LFSlideEntityClp.class.getName())) {
            return translateInputLFSlideEntity(oldModel);
        }

        if (oldModelClassName.equals(LFSlideSetClp.class.getName())) {
            return translateInputLFSlideSet(oldModel);
        }

        if (oldModelClassName.equals(LFTCClntApiStorageClp.class.getName())) {
            return translateInputLFTCClntApiStorage(oldModel);
        }

        if (oldModelClassName.equals(LFTincanLrsEndpointClp.class.getName())) {
            return translateInputLFTincanLrsEndpoint(oldModel);
        }

        if (oldModelClassName.equals(LFTincanManifestActClp.class.getName())) {
            return translateInputLFTincanManifestAct(oldModel);
        }

        if (oldModelClassName.equals(LFTincanPackageClp.class.getName())) {
            return translateInputLFTincanPackage(oldModel);
        }

        if (oldModelClassName.equals(LFTincanURIClp.class.getName())) {
            return translateInputLFTincanURI(oldModel);
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

    public static Object translateInputLFGlblObjectiveState(
        BaseModel<?> oldModel) {
        LFGlblObjectiveStateClp oldClpModel = (LFGlblObjectiveStateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFGlblObjectiveStateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFLessonLimit(BaseModel<?> oldModel) {
        LFLessonLimitClp oldClpModel = (LFLessonLimitClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFLessonLimitRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFLRSToActivitySetting(
        BaseModel<?> oldModel) {
        LFLRSToActivitySettingClp oldClpModel = (LFLRSToActivitySettingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFLRSToActivitySettingRemoteModel();

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

    public static Object translateInputLFPackageGradeStorage(
        BaseModel<?> oldModel) {
        LFPackageGradeStorageClp oldClpModel = (LFPackageGradeStorageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPackageGradeStorageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFPackageScopeRule(BaseModel<?> oldModel) {
        LFPackageScopeRuleClp oldClpModel = (LFPackageScopeRuleClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFPackageScopeRuleRemoteModel();

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

    public static Object translateInputLFQuizAnswerScore(BaseModel<?> oldModel) {
        LFQuizAnswerScoreClp oldClpModel = (LFQuizAnswerScoreClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizAnswerScoreRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuizQuestCat(BaseModel<?> oldModel) {
        LFQuizQuestCatClp oldClpModel = (LFQuizQuestCatClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizQuestCatRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuizQuestion(BaseModel<?> oldModel) {
        LFQuizQuestionClp oldClpModel = (LFQuizQuestionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizQuestionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFQuizTreeElement(BaseModel<?> oldModel) {
        LFQuizTreeElementClp oldClpModel = (LFQuizTreeElementClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFQuizTreeElementRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFResource(BaseModel<?> oldModel) {
        LFResourceClp oldClpModel = (LFResourceClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFResourceRemoteModel();

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

    public static Object translateInputLFSeqPermissions(BaseModel<?> oldModel) {
        LFSeqPermissionsClp oldClpModel = (LFSeqPermissionsClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSeqPermissionsRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSequencing(BaseModel<?> oldModel) {
        LFSequencingClp oldClpModel = (LFSequencingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSequencingRemoteModel();

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

    public static Object translateInputLFSiteDependentConfig(
        BaseModel<?> oldModel) {
        LFSiteDependentConfigClp oldClpModel = (LFSiteDependentConfigClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSiteDependentConfigRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSlide(BaseModel<?> oldModel) {
        LFSlideClp oldClpModel = (LFSlideClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSlideRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSlideEntity(BaseModel<?> oldModel) {
        LFSlideEntityClp oldClpModel = (LFSlideEntityClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSlideEntityRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFSlideSet(BaseModel<?> oldModel) {
        LFSlideSetClp oldClpModel = (LFSlideSetClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFSlideSetRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTCClntApiStorage(BaseModel<?> oldModel) {
        LFTCClntApiStorageClp oldClpModel = (LFTCClntApiStorageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTCClntApiStorageRemoteModel();

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

    public static Object translateInputLFTincanManifestAct(
        BaseModel<?> oldModel) {
        LFTincanManifestActClp oldClpModel = (LFTincanManifestActClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanManifestActRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanPackage(BaseModel<?> oldModel) {
        LFTincanPackageClp oldClpModel = (LFTincanPackageClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanPackageRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLFTincanURI(BaseModel<?> oldModel) {
        LFTincanURIClp oldClpModel = (LFTincanURIClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLFTincanURIRemoteModel();

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
                    "com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateImpl")) {
            return translateOutputLFGlblObjectiveState(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitImpl")) {
            return translateOutputLFLessonLimit(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingImpl")) {
            return translateOutputLFLRSToActivitySetting(oldModel);
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
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPackageGradeStorageImpl")) {
            return translateOutputLFPackageGradeStorage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFPackageScopeRuleImpl")) {
            return translateOutputLFPackageScopeRule(oldModel);
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
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreImpl")) {
            return translateOutputLFQuizAnswerScore(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatImpl")) {
            return translateOutputLFQuizQuestCat(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionImpl")) {
            return translateOutputLFQuizQuestion(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementImpl")) {
            return translateOutputLFQuizTreeElement(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFResourceImpl")) {
            return translateOutputLFResource(oldModel);
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
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsImpl")) {
            return translateOutputLFSeqPermissions(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSequencingImpl")) {
            return translateOutputLFSequencing(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingImpl")) {
            return translateOutputLFSequencingTracking(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigImpl")) {
            return translateOutputLFSiteDependentConfig(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSlideImpl")) {
            return translateOutputLFSlide(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityImpl")) {
            return translateOutputLFSlideEntity(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFSlideSetImpl")) {
            return translateOutputLFSlideSet(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageImpl")) {
            return translateOutputLFTCClntApiStorage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointImpl")) {
            return translateOutputLFTincanLrsEndpoint(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActImpl")) {
            return translateOutputLFTincanManifestAct(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageImpl")) {
            return translateOutputLFTincanPackage(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIImpl")) {
            return translateOutputLFTincanURI(oldModel);
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
                    "com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException();
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
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException();
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
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFQuizTreeElementException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFResourceException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFResourceException();
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
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSlideException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSlideException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException();
        }

        if (className.equals(
                    "com.arcusys.learn.persistence.liferay.NoSuchLFUserException")) {
            return new com.arcusys.learn.persistence.liferay.NoSuchLFUserException();
        }

        return throwable;
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

    public static Object translateOutputLFGlblObjectiveState(
        BaseModel<?> oldModel) {
        LFGlblObjectiveStateClp newModel = new LFGlblObjectiveStateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFGlblObjectiveStateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFLessonLimit(BaseModel<?> oldModel) {
        LFLessonLimitClp newModel = new LFLessonLimitClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFLessonLimitRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFLRSToActivitySetting(
        BaseModel<?> oldModel) {
        LFLRSToActivitySettingClp newModel = new LFLRSToActivitySettingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFLRSToActivitySettingRemoteModel(oldModel);

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

    public static Object translateOutputLFPackageGradeStorage(
        BaseModel<?> oldModel) {
        LFPackageGradeStorageClp newModel = new LFPackageGradeStorageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPackageGradeStorageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFPackageScopeRule(
        BaseModel<?> oldModel) {
        LFPackageScopeRuleClp newModel = new LFPackageScopeRuleClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFPackageScopeRuleRemoteModel(oldModel);

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

    public static Object translateOutputLFQuizAnswerScore(BaseModel<?> oldModel) {
        LFQuizAnswerScoreClp newModel = new LFQuizAnswerScoreClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizAnswerScoreRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuizQuestCat(BaseModel<?> oldModel) {
        LFQuizQuestCatClp newModel = new LFQuizQuestCatClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizQuestCatRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuizQuestion(BaseModel<?> oldModel) {
        LFQuizQuestionClp newModel = new LFQuizQuestionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizQuestionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFQuizTreeElement(BaseModel<?> oldModel) {
        LFQuizTreeElementClp newModel = new LFQuizTreeElementClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFQuizTreeElementRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFResource(BaseModel<?> oldModel) {
        LFResourceClp newModel = new LFResourceClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFResourceRemoteModel(oldModel);

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

    public static Object translateOutputLFSeqPermissions(BaseModel<?> oldModel) {
        LFSeqPermissionsClp newModel = new LFSeqPermissionsClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSeqPermissionsRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSequencing(BaseModel<?> oldModel) {
        LFSequencingClp newModel = new LFSequencingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSequencingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSequencingTracking(
        BaseModel<?> oldModel) {
        LFSequencingTrackingClp newModel = new LFSequencingTrackingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSequencingTrackingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSiteDependentConfig(
        BaseModel<?> oldModel) {
        LFSiteDependentConfigClp newModel = new LFSiteDependentConfigClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSiteDependentConfigRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSlide(BaseModel<?> oldModel) {
        LFSlideClp newModel = new LFSlideClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSlideRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSlideEntity(BaseModel<?> oldModel) {
        LFSlideEntityClp newModel = new LFSlideEntityClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSlideEntityRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFSlideSet(BaseModel<?> oldModel) {
        LFSlideSetClp newModel = new LFSlideSetClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFSlideSetRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTCClntApiStorage(
        BaseModel<?> oldModel) {
        LFTCClntApiStorageClp newModel = new LFTCClntApiStorageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTCClntApiStorageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanLrsEndpoint(
        BaseModel<?> oldModel) {
        LFTincanLrsEndpointClp newModel = new LFTincanLrsEndpointClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanLrsEndpointRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanManifestAct(
        BaseModel<?> oldModel) {
        LFTincanManifestActClp newModel = new LFTincanManifestActClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanManifestActRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanPackage(BaseModel<?> oldModel) {
        LFTincanPackageClp newModel = new LFTincanPackageClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanPackageRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFTincanURI(BaseModel<?> oldModel) {
        LFTincanURIClp newModel = new LFTincanURIClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFTincanURIRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLFUser(BaseModel<?> oldModel) {
        LFUserClp newModel = new LFUserClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLFUserRemoteModel(oldModel);

        return newModel;
    }
}

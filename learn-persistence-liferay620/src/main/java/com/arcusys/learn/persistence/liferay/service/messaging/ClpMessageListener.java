package com.arcusys.learn.persistence.liferay.service.messaging;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuestionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestCatLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSlideEntityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSlideLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSlideSetLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTCClntApiStorageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanURILocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFUserLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            LFActivityLocalServiceUtil.clearService();

            LFActivityDataMapLocalServiceUtil.clearService();

            LFActivityStateLocalServiceUtil.clearService();

            LFActivityStateNodeLocalServiceUtil.clearService();

            LFActivityStateTreeLocalServiceUtil.clearService();

            LFAnswerLocalServiceUtil.clearService();

            LFAttemptLocalServiceUtil.clearService();

            LFAttemptDataLocalServiceUtil.clearService();

            LFBigDecimalLocalServiceUtil.clearService();

            LFChildrenSelectionLocalServiceUtil.clearService();

            LFConditionRuleLocalServiceUtil.clearService();

            LFConfigLocalServiceUtil.clearService();

            LFCourseLocalServiceUtil.clearService();

            LFGlblObjectiveStateLocalServiceUtil.clearService();

            LFLessonLimitLocalServiceUtil.clearService();

            LFLRSToActivitySettingLocalServiceUtil.clearService();

            LFObjectiveLocalServiceUtil.clearService();

            LFObjectiveMapLocalServiceUtil.clearService();

            LFObjectiveStateLocalServiceUtil.clearService();

            LFPackageLocalServiceUtil.clearService();

            LFPackageGradeStorageLocalServiceUtil.clearService();

            LFPackageScopeRuleLocalServiceUtil.clearService();

            LFPlayerScopeRuleLocalServiceUtil.clearService();

            LFQuestionLocalServiceUtil.clearService();

            LFQuestionCategoryLocalServiceUtil.clearService();

            LFQuizLocalServiceUtil.clearService();

            LFQuizAnswerScoreLocalServiceUtil.clearService();

            LFQuizQuestCatLocalServiceUtil.clearService();

            LFQuizQuestionLocalServiceUtil.clearService();

            LFQuizTreeElementLocalServiceUtil.clearService();

            LFResourceLocalServiceUtil.clearService();

            LFRollupContributionLocalServiceUtil.clearService();

            LFRollupRuleLocalServiceUtil.clearService();

            LFRuleConditionLocalServiceUtil.clearService();

            LFSeqPermissionsLocalServiceUtil.clearService();

            LFSequencingLocalServiceUtil.clearService();

            LFSequencingTrackingLocalServiceUtil.clearService();

            LFSiteDependentConfigLocalServiceUtil.clearService();

            LFSlideLocalServiceUtil.clearService();

            LFSlideEntityLocalServiceUtil.clearService();

            LFSlideSetLocalServiceUtil.clearService();

            LFTCClntApiStorageLocalServiceUtil.clearService();

            LFTincanLrsEndpointLocalServiceUtil.clearService();

            LFTincanManifestActLocalServiceUtil.clearService();

            LFTincanPackageLocalServiceUtil.clearService();

            LFTincanURILocalServiceUtil.clearService();

            LFUserLocalServiceUtil.clearService();
        }
    }
}

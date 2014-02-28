package com.arcusys.learn.persistence.liferay.service.messaging;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAchievementLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCertificateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCourseLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuestionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil;
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
            LFAchievementLocalServiceUtil.clearService();

            LFAchievementActivityLocalServiceUtil.clearService();

            LFAchievementUserLocalServiceUtil.clearService();

            LFActivityLocalServiceUtil.clearService();

            LFActivityDataMapLocalServiceUtil.clearService();

            LFActivityStateLocalServiceUtil.clearService();

            LFActivityStateNodeLocalServiceUtil.clearService();

            LFActivityStateTreeLocalServiceUtil.clearService();

            LFAnswerLocalServiceUtil.clearService();

            LFAttemptLocalServiceUtil.clearService();

            LFAttemptDataLocalServiceUtil.clearService();

            LFBigDecimalLocalServiceUtil.clearService();

            LFCertificateLocalServiceUtil.clearService();

            LFCertificateSiteLocalServiceUtil.clearService();

            LFCertificateUserLocalServiceUtil.clearService();

            LFChildrenSelectionLocalServiceUtil.clearService();

            LFConditionRuleLocalServiceUtil.clearService();

            LFConfigLocalServiceUtil.clearService();

            LFCourseLocalServiceUtil.clearService();

            LFFileStorageLocalServiceUtil.clearService();

            LFGlobalObjectiveStateLocalServiceUtil.clearService();

            LFObjectiveLocalServiceUtil.clearService();

            LFObjectiveMapLocalServiceUtil.clearService();

            LFObjectiveStateLocalServiceUtil.clearService();

            LFPackageLocalServiceUtil.clearService();

            LFPackageCommentLocalServiceUtil.clearService();

            LFPackageScopeRuleLocalServiceUtil.clearService();

            LFPackageVoteLocalServiceUtil.clearService();

            LFPlayerScopeRuleLocalServiceUtil.clearService();

            LFQuestionLocalServiceUtil.clearService();

            LFQuestionCategoryLocalServiceUtil.clearService();

            LFQuizLocalServiceUtil.clearService();

            LFQuizQuestionLocalServiceUtil.clearService();

            LFQuizQuestionCategoryLocalServiceUtil.clearService();

            LFRequiredActivityLocalServiceUtil.clearService();

            LFResourceLocalServiceUtil.clearService();

            LFRoleLocalServiceUtil.clearService();

            LFRollupContributionLocalServiceUtil.clearService();

            LFRollupRuleLocalServiceUtil.clearService();

            LFRuleConditionLocalServiceUtil.clearService();

            LFSequencingLocalServiceUtil.clearService();

            LFSequencingPermissionsLocalServiceUtil.clearService();

            LFSequencingTrackingLocalServiceUtil.clearService();

            LFSocialPackageLocalServiceUtil.clearService();

            LFSocialPackageTagLocalServiceUtil.clearService();

            LFTincanActivityLocalServiceUtil.clearService();

            LFTincanActorLocalServiceUtil.clearService();

            LFTincanActProfileLocalServiceUtil.clearService();

            LFTincanClientApiStorageLocalServiceUtil.clearService();

            LFTincanCtxActivitiesLocalServiceUtil.clearService();

            LFTincanLrsAgentProfileLocalServiceUtil.clearService();

            LFTincanLrsAttachmentLocalServiceUtil.clearService();

            LFTincanLrsContextLocalServiceUtil.clearService();

            LFTincanLrsDocumentLocalServiceUtil.clearService();

            LFTincanLrsEndpointLocalServiceUtil.clearService();

            LFTincanLrsResultLocalServiceUtil.clearService();

            LFTincanLrsStateLocalServiceUtil.clearService();

            LFTincanLrsStatementLocalServiceUtil.clearService();

            LFTincanLrsStatementRefLocalServiceUtil.clearService();

            LFTincanLrsSubStatementLocalServiceUtil.clearService();

            LFTincanManifestActLocalServiceUtil.clearService();

            LFTincanPackageLocalServiceUtil.clearService();

            LFUserLocalServiceUtil.clearService();
        }
    }
}

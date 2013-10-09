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
import com.arcusys.learn.persistence.liferay.service.LFCertificateLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil;
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
import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSettingLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil;
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

            LFResourceLocalServiceUtil.clearService();

            LFRoleLocalServiceUtil.clearService();

            LFRollupContributionLocalServiceUtil.clearService();

            LFRollupRuleLocalServiceUtil.clearService();

            LFRuleConditionLocalServiceUtil.clearService();

            LFSequencingLocalServiceUtil.clearService();

            LFSequencingPermissionsLocalServiceUtil.clearService();

            LFSequencingTrackingLocalServiceUtil.clearService();

            LFSettingLocalServiceUtil.clearService();

            LFSocialPackageLocalServiceUtil.clearService();

            LFSocialPackageTagLocalServiceUtil.clearService();

            LFTincanActivityLocalServiceUtil.clearService();

            LFTincanLrsEndpointLocalServiceUtil.clearService();

            LFTincanPackageLocalServiceUtil.clearService();

            LFUserLocalServiceUtil.clearService();
        }
    }
}

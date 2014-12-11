package com.arcusys.learn.persistence.liferay.service.base;

import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;
import com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalService;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAchievementActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAchievementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAchievementUserPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAnswerPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConfigPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFFileStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFLRSToActivitySettingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK;
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageCommentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageVotePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPlayerScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizAnswerScorePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizTreeElementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRequiredActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFResourcePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRolePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSiteDependentConfigPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActorPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanClientApiStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanCtxActivitiesPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAgentProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAttachmentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsDocumentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsEndpointPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsResultPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementRefPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsSubStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanManifestActPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanURIPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFUserPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the l f lesson limit local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.arcusys.learn.persistence.liferay.service.impl.LFLessonLimitLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFLessonLimitLocalServiceImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil
 * @generated
 */
public abstract class LFLessonLimitLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements LFLessonLimitLocalService,
        IdentifiableBean {
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFAchievementLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFAchievementLocalService lfAchievementLocalService;
    @BeanReference(type = LFAchievementPersistence.class)
    protected LFAchievementPersistence lfAchievementPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalService lfAchievementActivityLocalService;
    @BeanReference(type = LFAchievementActivityPersistence.class)
    protected LFAchievementActivityPersistence lfAchievementActivityPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalService lfAchievementUserLocalService;
    @BeanReference(type = LFAchievementUserPersistence.class)
    protected LFAchievementUserPersistence lfAchievementUserPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFActivityLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFActivityLocalService lfActivityLocalService;
    @BeanReference(type = LFActivityPersistence.class)
    protected LFActivityPersistence lfActivityPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalService lfActivityDataMapLocalService;
    @BeanReference(type = LFActivityDataMapPersistence.class)
    protected LFActivityDataMapPersistence lfActivityDataMapPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalService lfActivityStateLocalService;
    @BeanReference(type = LFActivityStatePersistence.class)
    protected LFActivityStatePersistence lfActivityStatePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalService lfActivityStateNodeLocalService;
    @BeanReference(type = LFActivityStateNodePersistence.class)
    protected LFActivityStateNodePersistence lfActivityStateNodePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalService lfActivityStateTreeLocalService;
    @BeanReference(type = LFActivityStateTreePersistence.class)
    protected LFActivityStateTreePersistence lfActivityStateTreePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFAnswerLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFAnswerLocalService lfAnswerLocalService;
    @BeanReference(type = LFAnswerPersistence.class)
    protected LFAnswerPersistence lfAnswerPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFAttemptLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFAttemptLocalService lfAttemptLocalService;
    @BeanReference(type = LFAttemptPersistence.class)
    protected LFAttemptPersistence lfAttemptPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalService lfAttemptDataLocalService;
    @BeanReference(type = LFAttemptDataPersistence.class)
    protected LFAttemptDataPersistence lfAttemptDataPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalService lfBigDecimalLocalService;
    @BeanReference(type = LFBigDecimalPersistence.class)
    protected LFBigDecimalPersistence lfBigDecimalPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFCertificateLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFCertificateLocalService lfCertificateLocalService;
    @BeanReference(type = LFCertificatePersistence.class)
    protected LFCertificatePersistence lfCertificatePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalService lfCertificateActivityLocalService;
    @BeanReference(type = LFCertificateActivityPersistence.class)
    protected LFCertificateActivityPersistence lfCertificateActivityPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalService lfCertificateCourseLocalService;
    @BeanReference(type = LFCertificateCoursePersistence.class)
    protected LFCertificateCoursePersistence lfCertificateCoursePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalService lfCertificateTincanStatementLocalService;
    @BeanReference(type = LFCertificateTincanStatementPersistence.class)
    protected LFCertificateTincanStatementPersistence lfCertificateTincanStatementPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalService lfCertificateUserLocalService;
    @BeanReference(type = LFCertificateUserPersistence.class)
    protected LFCertificateUserPersistence lfCertificateUserPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalService lfChildrenSelectionLocalService;
    @BeanReference(type = LFChildrenSelectionPersistence.class)
    protected LFChildrenSelectionPersistence lfChildrenSelectionPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalService lfConditionRuleLocalService;
    @BeanReference(type = LFConditionRulePersistence.class)
    protected LFConditionRulePersistence lfConditionRulePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFConfigLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFConfigLocalService lfConfigLocalService;
    @BeanReference(type = LFConfigPersistence.class)
    protected LFConfigPersistence lfConfigPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFCourseLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFCourseLocalService lfCourseLocalService;
    @BeanReference(type = LFCoursePersistence.class)
    protected LFCoursePersistence lfCoursePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalService lfFileStorageLocalService;
    @BeanReference(type = LFFileStoragePersistence.class)
    protected LFFileStoragePersistence lfFileStoragePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalService lfGlobalObjectiveStateLocalService;
    @BeanReference(type = LFGlobalObjectiveStatePersistence.class)
    protected LFGlobalObjectiveStatePersistence lfGlobalObjectiveStatePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalService lfLessonLimitLocalService;
    @BeanReference(type = LFLessonLimitPersistence.class)
    protected LFLessonLimitPersistence lfLessonLimitPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalService lflrsToActivitySettingLocalService;
    @BeanReference(type = LFLRSToActivitySettingPersistence.class)
    protected LFLRSToActivitySettingPersistence lflrsToActivitySettingPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalService lfObjectiveLocalService;
    @BeanReference(type = LFObjectivePersistence.class)
    protected LFObjectivePersistence lfObjectivePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalService lfObjectiveMapLocalService;
    @BeanReference(type = LFObjectiveMapPersistence.class)
    protected LFObjectiveMapPersistence lfObjectiveMapPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalService lfObjectiveStateLocalService;
    @BeanReference(type = LFObjectiveStatePersistence.class)
    protected LFObjectiveStatePersistence lfObjectiveStatePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFPackageLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFPackageLocalService lfPackageLocalService;
    @BeanReference(type = LFPackagePersistence.class)
    protected LFPackagePersistence lfPackagePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalService lfPackageCommentLocalService;
    @BeanReference(type = LFPackageCommentPersistence.class)
    protected LFPackageCommentPersistence lfPackageCommentPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalService lfPackageGradeStorageLocalService;
    @BeanReference(type = LFPackageGradeStoragePersistence.class)
    protected LFPackageGradeStoragePersistence lfPackageGradeStoragePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalService lfPackageScopeRuleLocalService;
    @BeanReference(type = LFPackageScopeRulePersistence.class)
    protected LFPackageScopeRulePersistence lfPackageScopeRulePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalService lfPackageVoteLocalService;
    @BeanReference(type = LFPackageVotePersistence.class)
    protected LFPackageVotePersistence lfPackageVotePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalService lfPlayerScopeRuleLocalService;
    @BeanReference(type = LFPlayerScopeRulePersistence.class)
    protected LFPlayerScopeRulePersistence lfPlayerScopeRulePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuestionLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuestionLocalService lfQuestionLocalService;
    @BeanReference(type = LFQuestionPersistence.class)
    protected LFQuestionPersistence lfQuestionPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalService lfQuestionCategoryLocalService;
    @BeanReference(type = LFQuestionCategoryPersistence.class)
    protected LFQuestionCategoryPersistence lfQuestionCategoryPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuizLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuizLocalService lfQuizLocalService;
    @BeanReference(type = LFQuizPersistence.class)
    protected LFQuizPersistence lfQuizPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalService lfQuizAnswerScoreLocalService;
    @BeanReference(type = LFQuizAnswerScorePersistence.class)
    protected LFQuizAnswerScorePersistence lfQuizAnswerScorePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalService lfQuizQuestionLocalService;
    @BeanReference(type = LFQuizQuestionPersistence.class)
    protected LFQuizQuestionPersistence lfQuizQuestionPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalService lfQuizQuestionCategoryLocalService;
    @BeanReference(type = LFQuizQuestionCategoryPersistence.class)
    protected LFQuizQuestionCategoryPersistence lfQuizQuestionCategoryPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalService lfQuizTreeElementLocalService;
    @BeanReference(type = LFQuizTreeElementPersistence.class)
    protected LFQuizTreeElementPersistence lfQuizTreeElementPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalService lfRequiredActivityLocalService;
    @BeanReference(type = LFRequiredActivityPersistence.class)
    protected LFRequiredActivityPersistence lfRequiredActivityPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFResourceLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFResourceLocalService lfResourceLocalService;
    @BeanReference(type = LFResourcePersistence.class)
    protected LFResourcePersistence lfResourcePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFRoleLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFRoleLocalService lfRoleLocalService;
    @BeanReference(type = LFRolePersistence.class)
    protected LFRolePersistence lfRolePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalService lfRollupContributionLocalService;
    @BeanReference(type = LFRollupContributionPersistence.class)
    protected LFRollupContributionPersistence lfRollupContributionPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalService lfRollupRuleLocalService;
    @BeanReference(type = LFRollupRulePersistence.class)
    protected LFRollupRulePersistence lfRollupRulePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalService lfRuleConditionLocalService;
    @BeanReference(type = LFRuleConditionPersistence.class)
    protected LFRuleConditionPersistence lfRuleConditionPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFSequencingLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFSequencingLocalService lfSequencingLocalService;
    @BeanReference(type = LFSequencingPersistence.class)
    protected LFSequencingPersistence lfSequencingPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalService lfSequencingPermissionsLocalService;
    @BeanReference(type = LFSequencingPermissionsPersistence.class)
    protected LFSequencingPermissionsPersistence lfSequencingPermissionsPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalService lfSequencingTrackingLocalService;
    @BeanReference(type = LFSequencingTrackingPersistence.class)
    protected LFSequencingTrackingPersistence lfSequencingTrackingPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalService lfSiteDependentConfigLocalService;
    @BeanReference(type = LFSiteDependentConfigPersistence.class)
    protected LFSiteDependentConfigPersistence lfSiteDependentConfigPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalService lfSocialPackageLocalService;
    @BeanReference(type = LFSocialPackagePersistence.class)
    protected LFSocialPackagePersistence lfSocialPackagePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalService lfSocialPackageTagLocalService;
    @BeanReference(type = LFSocialPackageTagPersistence.class)
    protected LFSocialPackageTagPersistence lfSocialPackageTagPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalService lfTincanActivityLocalService;
    @BeanReference(type = LFTincanActivityPersistence.class)
    protected LFTincanActivityPersistence lfTincanActivityPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalService lfTincanActorLocalService;
    @BeanReference(type = LFTincanActorPersistence.class)
    protected LFTincanActorPersistence lfTincanActorPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalService lfTincanActProfileLocalService;
    @BeanReference(type = LFTincanActProfilePersistence.class)
    protected LFTincanActProfilePersistence lfTincanActProfilePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalService lfTincanClientApiStorageLocalService;
    @BeanReference(type = LFTincanClientApiStoragePersistence.class)
    protected LFTincanClientApiStoragePersistence lfTincanClientApiStoragePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalService lfTincanCtxActivitiesLocalService;
    @BeanReference(type = LFTincanCtxActivitiesPersistence.class)
    protected LFTincanCtxActivitiesPersistence lfTincanCtxActivitiesPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalService lfTincanLrsAgentProfileLocalService;
    @BeanReference(type = LFTincanLrsAgentProfilePersistence.class)
    protected LFTincanLrsAgentProfilePersistence lfTincanLrsAgentProfilePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalService lfTincanLrsAttachmentLocalService;
    @BeanReference(type = LFTincanLrsAttachmentPersistence.class)
    protected LFTincanLrsAttachmentPersistence lfTincanLrsAttachmentPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalService lfTincanLrsContextLocalService;
    @BeanReference(type = LFTincanLrsContextPersistence.class)
    protected LFTincanLrsContextPersistence lfTincanLrsContextPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalService lfTincanLrsDocumentLocalService;
    @BeanReference(type = LFTincanLrsDocumentPersistence.class)
    protected LFTincanLrsDocumentPersistence lfTincanLrsDocumentPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalService lfTincanLrsEndpointLocalService;
    @BeanReference(type = LFTincanLrsEndpointPersistence.class)
    protected LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalService lfTincanLrsResultLocalService;
    @BeanReference(type = LFTincanLrsResultPersistence.class)
    protected LFTincanLrsResultPersistence lfTincanLrsResultPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalService lfTincanLrsStateLocalService;
    @BeanReference(type = LFTincanLrsStatePersistence.class)
    protected LFTincanLrsStatePersistence lfTincanLrsStatePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalService lfTincanLrsStatementLocalService;
    @BeanReference(type = LFTincanLrsStatementPersistence.class)
    protected LFTincanLrsStatementPersistence lfTincanLrsStatementPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalService lfTincanLrsStatementRefLocalService;
    @BeanReference(type = LFTincanLrsStatementRefPersistence.class)
    protected LFTincanLrsStatementRefPersistence lfTincanLrsStatementRefPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalService lfTincanLrsSubStatementLocalService;
    @BeanReference(type = LFTincanLrsSubStatementPersistence.class)
    protected LFTincanLrsSubStatementPersistence lfTincanLrsSubStatementPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalService lfTincanManifestActLocalService;
    @BeanReference(type = LFTincanManifestActPersistence.class)
    protected LFTincanManifestActPersistence lfTincanManifestActPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalService lfTincanPackageLocalService;
    @BeanReference(type = LFTincanPackagePersistence.class)
    protected LFTincanPackagePersistence lfTincanPackagePersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFTincanURILocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFTincanURILocalService lfTincanURILocalService;
    @BeanReference(type = LFTincanURIPersistence.class)
    protected LFTincanURIPersistence lfTincanURIPersistence;
    @BeanReference(type = com.arcusys.learn.persistence.liferay.service.LFUserLocalService.class)
    protected com.arcusys.learn.persistence.liferay.service.LFUserLocalService lfUserLocalService;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private LFLessonLimitLocalServiceClpInvoker _clpInvoker = new LFLessonLimitLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil} to access the l f lesson limit local service.
     */

    /**
     * Adds the l f lesson limit to the database. Also notifies the appropriate model listeners.
     *
     * @param lfLessonLimit the l f lesson limit
     * @return the l f lesson limit that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public LFLessonLimit addLFLessonLimit(LFLessonLimit lfLessonLimit)
        throws SystemException {
        lfLessonLimit.setNew(true);

        return lfLessonLimitPersistence.update(lfLessonLimit);
    }

    /**
     * Creates a new l f lesson limit with the primary key. Does not add the l f lesson limit to the database.
     *
     * @param lfLessonLimitPK the primary key for the new l f lesson limit
     * @return the new l f lesson limit
     */
    @Override
    public LFLessonLimit createLFLessonLimit(LFLessonLimitPK lfLessonLimitPK) {
        return lfLessonLimitPersistence.create(lfLessonLimitPK);
    }

    /**
     * Deletes the l f lesson limit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfLessonLimitPK the primary key of the l f lesson limit
     * @return the l f lesson limit that was removed
     * @throws PortalException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public LFLessonLimit deleteLFLessonLimit(LFLessonLimitPK lfLessonLimitPK)
        throws PortalException, SystemException {
        return lfLessonLimitPersistence.remove(lfLessonLimitPK);
    }

    /**
     * Deletes the l f lesson limit from the database. Also notifies the appropriate model listeners.
     *
     * @param lfLessonLimit the l f lesson limit
     * @return the l f lesson limit that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public LFLessonLimit deleteLFLessonLimit(LFLessonLimit lfLessonLimit)
        throws SystemException {
        return lfLessonLimitPersistence.remove(lfLessonLimit);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(LFLessonLimit.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return lfLessonLimitPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return lfLessonLimitPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return lfLessonLimitPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return lfLessonLimitPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return lfLessonLimitPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public LFLessonLimit fetchLFLessonLimit(LFLessonLimitPK lfLessonLimitPK)
        throws SystemException {
        return lfLessonLimitPersistence.fetchByPrimaryKey(lfLessonLimitPK);
    }

    /**
     * Returns the l f lesson limit with the primary key.
     *
     * @param lfLessonLimitPK the primary key of the l f lesson limit
     * @return the l f lesson limit
     * @throws PortalException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit getLFLessonLimit(LFLessonLimitPK lfLessonLimitPK)
        throws PortalException, SystemException {
        return lfLessonLimitPersistence.findByPrimaryKey(lfLessonLimitPK);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return lfLessonLimitPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the l f lesson limits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @return the range of l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> getLFLessonLimits(int start, int end)
        throws SystemException {
        return lfLessonLimitPersistence.findAll(start, end);
    }

    /**
     * Returns the number of l f lesson limits.
     *
     * @return the number of l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getLFLessonLimitsCount() throws SystemException {
        return lfLessonLimitPersistence.countAll();
    }

    /**
     * Updates the l f lesson limit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param lfLessonLimit the l f lesson limit
     * @return the l f lesson limit that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public LFLessonLimit updateLFLessonLimit(LFLessonLimit lfLessonLimit)
        throws SystemException {
        return lfLessonLimitPersistence.update(lfLessonLimit);
    }

    /**
     * Returns the l f achievement local service.
     *
     * @return the l f achievement local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFAchievementLocalService getLFAchievementLocalService() {
        return lfAchievementLocalService;
    }

    /**
     * Sets the l f achievement local service.
     *
     * @param lfAchievementLocalService the l f achievement local service
     */
    public void setLFAchievementLocalService(
        com.arcusys.learn.persistence.liferay.service.LFAchievementLocalService lfAchievementLocalService) {
        this.lfAchievementLocalService = lfAchievementLocalService;
    }

    /**
     * Returns the l f achievement persistence.
     *
     * @return the l f achievement persistence
     */
    public LFAchievementPersistence getLFAchievementPersistence() {
        return lfAchievementPersistence;
    }

    /**
     * Sets the l f achievement persistence.
     *
     * @param lfAchievementPersistence the l f achievement persistence
     */
    public void setLFAchievementPersistence(
        LFAchievementPersistence lfAchievementPersistence) {
        this.lfAchievementPersistence = lfAchievementPersistence;
    }

    /**
     * Returns the l f achievement activity local service.
     *
     * @return the l f achievement activity local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalService getLFAchievementActivityLocalService() {
        return lfAchievementActivityLocalService;
    }

    /**
     * Sets the l f achievement activity local service.
     *
     * @param lfAchievementActivityLocalService the l f achievement activity local service
     */
    public void setLFAchievementActivityLocalService(
        com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalService lfAchievementActivityLocalService) {
        this.lfAchievementActivityLocalService = lfAchievementActivityLocalService;
    }

    /**
     * Returns the l f achievement activity persistence.
     *
     * @return the l f achievement activity persistence
     */
    public LFAchievementActivityPersistence getLFAchievementActivityPersistence() {
        return lfAchievementActivityPersistence;
    }

    /**
     * Sets the l f achievement activity persistence.
     *
     * @param lfAchievementActivityPersistence the l f achievement activity persistence
     */
    public void setLFAchievementActivityPersistence(
        LFAchievementActivityPersistence lfAchievementActivityPersistence) {
        this.lfAchievementActivityPersistence = lfAchievementActivityPersistence;
    }

    /**
     * Returns the l f achievement user local service.
     *
     * @return the l f achievement user local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalService getLFAchievementUserLocalService() {
        return lfAchievementUserLocalService;
    }

    /**
     * Sets the l f achievement user local service.
     *
     * @param lfAchievementUserLocalService the l f achievement user local service
     */
    public void setLFAchievementUserLocalService(
        com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalService lfAchievementUserLocalService) {
        this.lfAchievementUserLocalService = lfAchievementUserLocalService;
    }

    /**
     * Returns the l f achievement user persistence.
     *
     * @return the l f achievement user persistence
     */
    public LFAchievementUserPersistence getLFAchievementUserPersistence() {
        return lfAchievementUserPersistence;
    }

    /**
     * Sets the l f achievement user persistence.
     *
     * @param lfAchievementUserPersistence the l f achievement user persistence
     */
    public void setLFAchievementUserPersistence(
        LFAchievementUserPersistence lfAchievementUserPersistence) {
        this.lfAchievementUserPersistence = lfAchievementUserPersistence;
    }

    /**
     * Returns the l f activity local service.
     *
     * @return the l f activity local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFActivityLocalService getLFActivityLocalService() {
        return lfActivityLocalService;
    }

    /**
     * Sets the l f activity local service.
     *
     * @param lfActivityLocalService the l f activity local service
     */
    public void setLFActivityLocalService(
        com.arcusys.learn.persistence.liferay.service.LFActivityLocalService lfActivityLocalService) {
        this.lfActivityLocalService = lfActivityLocalService;
    }

    /**
     * Returns the l f activity persistence.
     *
     * @return the l f activity persistence
     */
    public LFActivityPersistence getLFActivityPersistence() {
        return lfActivityPersistence;
    }

    /**
     * Sets the l f activity persistence.
     *
     * @param lfActivityPersistence the l f activity persistence
     */
    public void setLFActivityPersistence(
        LFActivityPersistence lfActivityPersistence) {
        this.lfActivityPersistence = lfActivityPersistence;
    }

    /**
     * Returns the l f activity data map local service.
     *
     * @return the l f activity data map local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalService getLFActivityDataMapLocalService() {
        return lfActivityDataMapLocalService;
    }

    /**
     * Sets the l f activity data map local service.
     *
     * @param lfActivityDataMapLocalService the l f activity data map local service
     */
    public void setLFActivityDataMapLocalService(
        com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalService lfActivityDataMapLocalService) {
        this.lfActivityDataMapLocalService = lfActivityDataMapLocalService;
    }

    /**
     * Returns the l f activity data map persistence.
     *
     * @return the l f activity data map persistence
     */
    public LFActivityDataMapPersistence getLFActivityDataMapPersistence() {
        return lfActivityDataMapPersistence;
    }

    /**
     * Sets the l f activity data map persistence.
     *
     * @param lfActivityDataMapPersistence the l f activity data map persistence
     */
    public void setLFActivityDataMapPersistence(
        LFActivityDataMapPersistence lfActivityDataMapPersistence) {
        this.lfActivityDataMapPersistence = lfActivityDataMapPersistence;
    }

    /**
     * Returns the l f activity state local service.
     *
     * @return the l f activity state local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalService getLFActivityStateLocalService() {
        return lfActivityStateLocalService;
    }

    /**
     * Sets the l f activity state local service.
     *
     * @param lfActivityStateLocalService the l f activity state local service
     */
    public void setLFActivityStateLocalService(
        com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalService lfActivityStateLocalService) {
        this.lfActivityStateLocalService = lfActivityStateLocalService;
    }

    /**
     * Returns the l f activity state persistence.
     *
     * @return the l f activity state persistence
     */
    public LFActivityStatePersistence getLFActivityStatePersistence() {
        return lfActivityStatePersistence;
    }

    /**
     * Sets the l f activity state persistence.
     *
     * @param lfActivityStatePersistence the l f activity state persistence
     */
    public void setLFActivityStatePersistence(
        LFActivityStatePersistence lfActivityStatePersistence) {
        this.lfActivityStatePersistence = lfActivityStatePersistence;
    }

    /**
     * Returns the l f activity state node local service.
     *
     * @return the l f activity state node local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalService getLFActivityStateNodeLocalService() {
        return lfActivityStateNodeLocalService;
    }

    /**
     * Sets the l f activity state node local service.
     *
     * @param lfActivityStateNodeLocalService the l f activity state node local service
     */
    public void setLFActivityStateNodeLocalService(
        com.arcusys.learn.persistence.liferay.service.LFActivityStateNodeLocalService lfActivityStateNodeLocalService) {
        this.lfActivityStateNodeLocalService = lfActivityStateNodeLocalService;
    }

    /**
     * Returns the l f activity state node persistence.
     *
     * @return the l f activity state node persistence
     */
    public LFActivityStateNodePersistence getLFActivityStateNodePersistence() {
        return lfActivityStateNodePersistence;
    }

    /**
     * Sets the l f activity state node persistence.
     *
     * @param lfActivityStateNodePersistence the l f activity state node persistence
     */
    public void setLFActivityStateNodePersistence(
        LFActivityStateNodePersistence lfActivityStateNodePersistence) {
        this.lfActivityStateNodePersistence = lfActivityStateNodePersistence;
    }

    /**
     * Returns the l f activity state tree local service.
     *
     * @return the l f activity state tree local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalService getLFActivityStateTreeLocalService() {
        return lfActivityStateTreeLocalService;
    }

    /**
     * Sets the l f activity state tree local service.
     *
     * @param lfActivityStateTreeLocalService the l f activity state tree local service
     */
    public void setLFActivityStateTreeLocalService(
        com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalService lfActivityStateTreeLocalService) {
        this.lfActivityStateTreeLocalService = lfActivityStateTreeLocalService;
    }

    /**
     * Returns the l f activity state tree persistence.
     *
     * @return the l f activity state tree persistence
     */
    public LFActivityStateTreePersistence getLFActivityStateTreePersistence() {
        return lfActivityStateTreePersistence;
    }

    /**
     * Sets the l f activity state tree persistence.
     *
     * @param lfActivityStateTreePersistence the l f activity state tree persistence
     */
    public void setLFActivityStateTreePersistence(
        LFActivityStateTreePersistence lfActivityStateTreePersistence) {
        this.lfActivityStateTreePersistence = lfActivityStateTreePersistence;
    }

    /**
     * Returns the l f answer local service.
     *
     * @return the l f answer local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFAnswerLocalService getLFAnswerLocalService() {
        return lfAnswerLocalService;
    }

    /**
     * Sets the l f answer local service.
     *
     * @param lfAnswerLocalService the l f answer local service
     */
    public void setLFAnswerLocalService(
        com.arcusys.learn.persistence.liferay.service.LFAnswerLocalService lfAnswerLocalService) {
        this.lfAnswerLocalService = lfAnswerLocalService;
    }

    /**
     * Returns the l f answer persistence.
     *
     * @return the l f answer persistence
     */
    public LFAnswerPersistence getLFAnswerPersistence() {
        return lfAnswerPersistence;
    }

    /**
     * Sets the l f answer persistence.
     *
     * @param lfAnswerPersistence the l f answer persistence
     */
    public void setLFAnswerPersistence(LFAnswerPersistence lfAnswerPersistence) {
        this.lfAnswerPersistence = lfAnswerPersistence;
    }

    /**
     * Returns the l f attempt local service.
     *
     * @return the l f attempt local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFAttemptLocalService getLFAttemptLocalService() {
        return lfAttemptLocalService;
    }

    /**
     * Sets the l f attempt local service.
     *
     * @param lfAttemptLocalService the l f attempt local service
     */
    public void setLFAttemptLocalService(
        com.arcusys.learn.persistence.liferay.service.LFAttemptLocalService lfAttemptLocalService) {
        this.lfAttemptLocalService = lfAttemptLocalService;
    }

    /**
     * Returns the l f attempt persistence.
     *
     * @return the l f attempt persistence
     */
    public LFAttemptPersistence getLFAttemptPersistence() {
        return lfAttemptPersistence;
    }

    /**
     * Sets the l f attempt persistence.
     *
     * @param lfAttemptPersistence the l f attempt persistence
     */
    public void setLFAttemptPersistence(
        LFAttemptPersistence lfAttemptPersistence) {
        this.lfAttemptPersistence = lfAttemptPersistence;
    }

    /**
     * Returns the l f attempt data local service.
     *
     * @return the l f attempt data local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalService getLFAttemptDataLocalService() {
        return lfAttemptDataLocalService;
    }

    /**
     * Sets the l f attempt data local service.
     *
     * @param lfAttemptDataLocalService the l f attempt data local service
     */
    public void setLFAttemptDataLocalService(
        com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalService lfAttemptDataLocalService) {
        this.lfAttemptDataLocalService = lfAttemptDataLocalService;
    }

    /**
     * Returns the l f attempt data persistence.
     *
     * @return the l f attempt data persistence
     */
    public LFAttemptDataPersistence getLFAttemptDataPersistence() {
        return lfAttemptDataPersistence;
    }

    /**
     * Sets the l f attempt data persistence.
     *
     * @param lfAttemptDataPersistence the l f attempt data persistence
     */
    public void setLFAttemptDataPersistence(
        LFAttemptDataPersistence lfAttemptDataPersistence) {
        this.lfAttemptDataPersistence = lfAttemptDataPersistence;
    }

    /**
     * Returns the l f big decimal local service.
     *
     * @return the l f big decimal local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalService getLFBigDecimalLocalService() {
        return lfBigDecimalLocalService;
    }

    /**
     * Sets the l f big decimal local service.
     *
     * @param lfBigDecimalLocalService the l f big decimal local service
     */
    public void setLFBigDecimalLocalService(
        com.arcusys.learn.persistence.liferay.service.LFBigDecimalLocalService lfBigDecimalLocalService) {
        this.lfBigDecimalLocalService = lfBigDecimalLocalService;
    }

    /**
     * Returns the l f big decimal persistence.
     *
     * @return the l f big decimal persistence
     */
    public LFBigDecimalPersistence getLFBigDecimalPersistence() {
        return lfBigDecimalPersistence;
    }

    /**
     * Sets the l f big decimal persistence.
     *
     * @param lfBigDecimalPersistence the l f big decimal persistence
     */
    public void setLFBigDecimalPersistence(
        LFBigDecimalPersistence lfBigDecimalPersistence) {
        this.lfBigDecimalPersistence = lfBigDecimalPersistence;
    }

    /**
     * Returns the l f certificate local service.
     *
     * @return the l f certificate local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFCertificateLocalService getLFCertificateLocalService() {
        return lfCertificateLocalService;
    }

    /**
     * Sets the l f certificate local service.
     *
     * @param lfCertificateLocalService the l f certificate local service
     */
    public void setLFCertificateLocalService(
        com.arcusys.learn.persistence.liferay.service.LFCertificateLocalService lfCertificateLocalService) {
        this.lfCertificateLocalService = lfCertificateLocalService;
    }

    /**
     * Returns the l f certificate persistence.
     *
     * @return the l f certificate persistence
     */
    public LFCertificatePersistence getLFCertificatePersistence() {
        return lfCertificatePersistence;
    }

    /**
     * Sets the l f certificate persistence.
     *
     * @param lfCertificatePersistence the l f certificate persistence
     */
    public void setLFCertificatePersistence(
        LFCertificatePersistence lfCertificatePersistence) {
        this.lfCertificatePersistence = lfCertificatePersistence;
    }

    /**
     * Returns the l f certificate activity local service.
     *
     * @return the l f certificate activity local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalService getLFCertificateActivityLocalService() {
        return lfCertificateActivityLocalService;
    }

    /**
     * Sets the l f certificate activity local service.
     *
     * @param lfCertificateActivityLocalService the l f certificate activity local service
     */
    public void setLFCertificateActivityLocalService(
        com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalService lfCertificateActivityLocalService) {
        this.lfCertificateActivityLocalService = lfCertificateActivityLocalService;
    }

    /**
     * Returns the l f certificate activity persistence.
     *
     * @return the l f certificate activity persistence
     */
    public LFCertificateActivityPersistence getLFCertificateActivityPersistence() {
        return lfCertificateActivityPersistence;
    }

    /**
     * Sets the l f certificate activity persistence.
     *
     * @param lfCertificateActivityPersistence the l f certificate activity persistence
     */
    public void setLFCertificateActivityPersistence(
        LFCertificateActivityPersistence lfCertificateActivityPersistence) {
        this.lfCertificateActivityPersistence = lfCertificateActivityPersistence;
    }

    /**
     * Returns the l f certificate course local service.
     *
     * @return the l f certificate course local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalService getLFCertificateCourseLocalService() {
        return lfCertificateCourseLocalService;
    }

    /**
     * Sets the l f certificate course local service.
     *
     * @param lfCertificateCourseLocalService the l f certificate course local service
     */
    public void setLFCertificateCourseLocalService(
        com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalService lfCertificateCourseLocalService) {
        this.lfCertificateCourseLocalService = lfCertificateCourseLocalService;
    }

    /**
     * Returns the l f certificate course persistence.
     *
     * @return the l f certificate course persistence
     */
    public LFCertificateCoursePersistence getLFCertificateCoursePersistence() {
        return lfCertificateCoursePersistence;
    }

    /**
     * Sets the l f certificate course persistence.
     *
     * @param lfCertificateCoursePersistence the l f certificate course persistence
     */
    public void setLFCertificateCoursePersistence(
        LFCertificateCoursePersistence lfCertificateCoursePersistence) {
        this.lfCertificateCoursePersistence = lfCertificateCoursePersistence;
    }

    /**
     * Returns the l f certificate tincan statement local service.
     *
     * @return the l f certificate tincan statement local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalService getLFCertificateTincanStatementLocalService() {
        return lfCertificateTincanStatementLocalService;
    }

    /**
     * Sets the l f certificate tincan statement local service.
     *
     * @param lfCertificateTincanStatementLocalService the l f certificate tincan statement local service
     */
    public void setLFCertificateTincanStatementLocalService(
        com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalService lfCertificateTincanStatementLocalService) {
        this.lfCertificateTincanStatementLocalService = lfCertificateTincanStatementLocalService;
    }

    /**
     * Returns the l f certificate tincan statement persistence.
     *
     * @return the l f certificate tincan statement persistence
     */
    public LFCertificateTincanStatementPersistence getLFCertificateTincanStatementPersistence() {
        return lfCertificateTincanStatementPersistence;
    }

    /**
     * Sets the l f certificate tincan statement persistence.
     *
     * @param lfCertificateTincanStatementPersistence the l f certificate tincan statement persistence
     */
    public void setLFCertificateTincanStatementPersistence(
        LFCertificateTincanStatementPersistence lfCertificateTincanStatementPersistence) {
        this.lfCertificateTincanStatementPersistence = lfCertificateTincanStatementPersistence;
    }

    /**
     * Returns the l f certificate user local service.
     *
     * @return the l f certificate user local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalService getLFCertificateUserLocalService() {
        return lfCertificateUserLocalService;
    }

    /**
     * Sets the l f certificate user local service.
     *
     * @param lfCertificateUserLocalService the l f certificate user local service
     */
    public void setLFCertificateUserLocalService(
        com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalService lfCertificateUserLocalService) {
        this.lfCertificateUserLocalService = lfCertificateUserLocalService;
    }

    /**
     * Returns the l f certificate user persistence.
     *
     * @return the l f certificate user persistence
     */
    public LFCertificateUserPersistence getLFCertificateUserPersistence() {
        return lfCertificateUserPersistence;
    }

    /**
     * Sets the l f certificate user persistence.
     *
     * @param lfCertificateUserPersistence the l f certificate user persistence
     */
    public void setLFCertificateUserPersistence(
        LFCertificateUserPersistence lfCertificateUserPersistence) {
        this.lfCertificateUserPersistence = lfCertificateUserPersistence;
    }

    /**
     * Returns the l f children selection local service.
     *
     * @return the l f children selection local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalService getLFChildrenSelectionLocalService() {
        return lfChildrenSelectionLocalService;
    }

    /**
     * Sets the l f children selection local service.
     *
     * @param lfChildrenSelectionLocalService the l f children selection local service
     */
    public void setLFChildrenSelectionLocalService(
        com.arcusys.learn.persistence.liferay.service.LFChildrenSelectionLocalService lfChildrenSelectionLocalService) {
        this.lfChildrenSelectionLocalService = lfChildrenSelectionLocalService;
    }

    /**
     * Returns the l f children selection persistence.
     *
     * @return the l f children selection persistence
     */
    public LFChildrenSelectionPersistence getLFChildrenSelectionPersistence() {
        return lfChildrenSelectionPersistence;
    }

    /**
     * Sets the l f children selection persistence.
     *
     * @param lfChildrenSelectionPersistence the l f children selection persistence
     */
    public void setLFChildrenSelectionPersistence(
        LFChildrenSelectionPersistence lfChildrenSelectionPersistence) {
        this.lfChildrenSelectionPersistence = lfChildrenSelectionPersistence;
    }

    /**
     * Returns the l f condition rule local service.
     *
     * @return the l f condition rule local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalService getLFConditionRuleLocalService() {
        return lfConditionRuleLocalService;
    }

    /**
     * Sets the l f condition rule local service.
     *
     * @param lfConditionRuleLocalService the l f condition rule local service
     */
    public void setLFConditionRuleLocalService(
        com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalService lfConditionRuleLocalService) {
        this.lfConditionRuleLocalService = lfConditionRuleLocalService;
    }

    /**
     * Returns the l f condition rule persistence.
     *
     * @return the l f condition rule persistence
     */
    public LFConditionRulePersistence getLFConditionRulePersistence() {
        return lfConditionRulePersistence;
    }

    /**
     * Sets the l f condition rule persistence.
     *
     * @param lfConditionRulePersistence the l f condition rule persistence
     */
    public void setLFConditionRulePersistence(
        LFConditionRulePersistence lfConditionRulePersistence) {
        this.lfConditionRulePersistence = lfConditionRulePersistence;
    }

    /**
     * Returns the l f config local service.
     *
     * @return the l f config local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFConfigLocalService getLFConfigLocalService() {
        return lfConfigLocalService;
    }

    /**
     * Sets the l f config local service.
     *
     * @param lfConfigLocalService the l f config local service
     */
    public void setLFConfigLocalService(
        com.arcusys.learn.persistence.liferay.service.LFConfigLocalService lfConfigLocalService) {
        this.lfConfigLocalService = lfConfigLocalService;
    }

    /**
     * Returns the l f config persistence.
     *
     * @return the l f config persistence
     */
    public LFConfigPersistence getLFConfigPersistence() {
        return lfConfigPersistence;
    }

    /**
     * Sets the l f config persistence.
     *
     * @param lfConfigPersistence the l f config persistence
     */
    public void setLFConfigPersistence(LFConfigPersistence lfConfigPersistence) {
        this.lfConfigPersistence = lfConfigPersistence;
    }

    /**
     * Returns the l f course local service.
     *
     * @return the l f course local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFCourseLocalService getLFCourseLocalService() {
        return lfCourseLocalService;
    }

    /**
     * Sets the l f course local service.
     *
     * @param lfCourseLocalService the l f course local service
     */
    public void setLFCourseLocalService(
        com.arcusys.learn.persistence.liferay.service.LFCourseLocalService lfCourseLocalService) {
        this.lfCourseLocalService = lfCourseLocalService;
    }

    /**
     * Returns the l f course persistence.
     *
     * @return the l f course persistence
     */
    public LFCoursePersistence getLFCoursePersistence() {
        return lfCoursePersistence;
    }

    /**
     * Sets the l f course persistence.
     *
     * @param lfCoursePersistence the l f course persistence
     */
    public void setLFCoursePersistence(LFCoursePersistence lfCoursePersistence) {
        this.lfCoursePersistence = lfCoursePersistence;
    }

    /**
     * Returns the l f file storage local service.
     *
     * @return the l f file storage local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalService getLFFileStorageLocalService() {
        return lfFileStorageLocalService;
    }

    /**
     * Sets the l f file storage local service.
     *
     * @param lfFileStorageLocalService the l f file storage local service
     */
    public void setLFFileStorageLocalService(
        com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalService lfFileStorageLocalService) {
        this.lfFileStorageLocalService = lfFileStorageLocalService;
    }

    /**
     * Returns the l f file storage persistence.
     *
     * @return the l f file storage persistence
     */
    public LFFileStoragePersistence getLFFileStoragePersistence() {
        return lfFileStoragePersistence;
    }

    /**
     * Sets the l f file storage persistence.
     *
     * @param lfFileStoragePersistence the l f file storage persistence
     */
    public void setLFFileStoragePersistence(
        LFFileStoragePersistence lfFileStoragePersistence) {
        this.lfFileStoragePersistence = lfFileStoragePersistence;
    }

    /**
     * Returns the l f global objective state local service.
     *
     * @return the l f global objective state local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalService getLFGlobalObjectiveStateLocalService() {
        return lfGlobalObjectiveStateLocalService;
    }

    /**
     * Sets the l f global objective state local service.
     *
     * @param lfGlobalObjectiveStateLocalService the l f global objective state local service
     */
    public void setLFGlobalObjectiveStateLocalService(
        com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalService lfGlobalObjectiveStateLocalService) {
        this.lfGlobalObjectiveStateLocalService = lfGlobalObjectiveStateLocalService;
    }

    /**
     * Returns the l f global objective state persistence.
     *
     * @return the l f global objective state persistence
     */
    public LFGlobalObjectiveStatePersistence getLFGlobalObjectiveStatePersistence() {
        return lfGlobalObjectiveStatePersistence;
    }

    /**
     * Sets the l f global objective state persistence.
     *
     * @param lfGlobalObjectiveStatePersistence the l f global objective state persistence
     */
    public void setLFGlobalObjectiveStatePersistence(
        LFGlobalObjectiveStatePersistence lfGlobalObjectiveStatePersistence) {
        this.lfGlobalObjectiveStatePersistence = lfGlobalObjectiveStatePersistence;
    }

    /**
     * Returns the l f lesson limit local service.
     *
     * @return the l f lesson limit local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalService getLFLessonLimitLocalService() {
        return lfLessonLimitLocalService;
    }

    /**
     * Sets the l f lesson limit local service.
     *
     * @param lfLessonLimitLocalService the l f lesson limit local service
     */
    public void setLFLessonLimitLocalService(
        com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalService lfLessonLimitLocalService) {
        this.lfLessonLimitLocalService = lfLessonLimitLocalService;
    }

    /**
     * Returns the l f lesson limit persistence.
     *
     * @return the l f lesson limit persistence
     */
    public LFLessonLimitPersistence getLFLessonLimitPersistence() {
        return lfLessonLimitPersistence;
    }

    /**
     * Sets the l f lesson limit persistence.
     *
     * @param lfLessonLimitPersistence the l f lesson limit persistence
     */
    public void setLFLessonLimitPersistence(
        LFLessonLimitPersistence lfLessonLimitPersistence) {
        this.lfLessonLimitPersistence = lfLessonLimitPersistence;
    }

    /**
     * Returns the l f l r s to activity setting local service.
     *
     * @return the l f l r s to activity setting local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalService getLFLRSToActivitySettingLocalService() {
        return lflrsToActivitySettingLocalService;
    }

    /**
     * Sets the l f l r s to activity setting local service.
     *
     * @param lflrsToActivitySettingLocalService the l f l r s to activity setting local service
     */
    public void setLFLRSToActivitySettingLocalService(
        com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalService lflrsToActivitySettingLocalService) {
        this.lflrsToActivitySettingLocalService = lflrsToActivitySettingLocalService;
    }

    /**
     * Returns the l f l r s to activity setting persistence.
     *
     * @return the l f l r s to activity setting persistence
     */
    public LFLRSToActivitySettingPersistence getLFLRSToActivitySettingPersistence() {
        return lflrsToActivitySettingPersistence;
    }

    /**
     * Sets the l f l r s to activity setting persistence.
     *
     * @param lflrsToActivitySettingPersistence the l f l r s to activity setting persistence
     */
    public void setLFLRSToActivitySettingPersistence(
        LFLRSToActivitySettingPersistence lflrsToActivitySettingPersistence) {
        this.lflrsToActivitySettingPersistence = lflrsToActivitySettingPersistence;
    }

    /**
     * Returns the l f objective local service.
     *
     * @return the l f objective local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalService getLFObjectiveLocalService() {
        return lfObjectiveLocalService;
    }

    /**
     * Sets the l f objective local service.
     *
     * @param lfObjectiveLocalService the l f objective local service
     */
    public void setLFObjectiveLocalService(
        com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalService lfObjectiveLocalService) {
        this.lfObjectiveLocalService = lfObjectiveLocalService;
    }

    /**
     * Returns the l f objective persistence.
     *
     * @return the l f objective persistence
     */
    public LFObjectivePersistence getLFObjectivePersistence() {
        return lfObjectivePersistence;
    }

    /**
     * Sets the l f objective persistence.
     *
     * @param lfObjectivePersistence the l f objective persistence
     */
    public void setLFObjectivePersistence(
        LFObjectivePersistence lfObjectivePersistence) {
        this.lfObjectivePersistence = lfObjectivePersistence;
    }

    /**
     * Returns the l f objective map local service.
     *
     * @return the l f objective map local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalService getLFObjectiveMapLocalService() {
        return lfObjectiveMapLocalService;
    }

    /**
     * Sets the l f objective map local service.
     *
     * @param lfObjectiveMapLocalService the l f objective map local service
     */
    public void setLFObjectiveMapLocalService(
        com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalService lfObjectiveMapLocalService) {
        this.lfObjectiveMapLocalService = lfObjectiveMapLocalService;
    }

    /**
     * Returns the l f objective map persistence.
     *
     * @return the l f objective map persistence
     */
    public LFObjectiveMapPersistence getLFObjectiveMapPersistence() {
        return lfObjectiveMapPersistence;
    }

    /**
     * Sets the l f objective map persistence.
     *
     * @param lfObjectiveMapPersistence the l f objective map persistence
     */
    public void setLFObjectiveMapPersistence(
        LFObjectiveMapPersistence lfObjectiveMapPersistence) {
        this.lfObjectiveMapPersistence = lfObjectiveMapPersistence;
    }

    /**
     * Returns the l f objective state local service.
     *
     * @return the l f objective state local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalService getLFObjectiveStateLocalService() {
        return lfObjectiveStateLocalService;
    }

    /**
     * Sets the l f objective state local service.
     *
     * @param lfObjectiveStateLocalService the l f objective state local service
     */
    public void setLFObjectiveStateLocalService(
        com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalService lfObjectiveStateLocalService) {
        this.lfObjectiveStateLocalService = lfObjectiveStateLocalService;
    }

    /**
     * Returns the l f objective state persistence.
     *
     * @return the l f objective state persistence
     */
    public LFObjectiveStatePersistence getLFObjectiveStatePersistence() {
        return lfObjectiveStatePersistence;
    }

    /**
     * Sets the l f objective state persistence.
     *
     * @param lfObjectiveStatePersistence the l f objective state persistence
     */
    public void setLFObjectiveStatePersistence(
        LFObjectiveStatePersistence lfObjectiveStatePersistence) {
        this.lfObjectiveStatePersistence = lfObjectiveStatePersistence;
    }

    /**
     * Returns the l f package local service.
     *
     * @return the l f package local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFPackageLocalService getLFPackageLocalService() {
        return lfPackageLocalService;
    }

    /**
     * Sets the l f package local service.
     *
     * @param lfPackageLocalService the l f package local service
     */
    public void setLFPackageLocalService(
        com.arcusys.learn.persistence.liferay.service.LFPackageLocalService lfPackageLocalService) {
        this.lfPackageLocalService = lfPackageLocalService;
    }

    /**
     * Returns the l f package persistence.
     *
     * @return the l f package persistence
     */
    public LFPackagePersistence getLFPackagePersistence() {
        return lfPackagePersistence;
    }

    /**
     * Sets the l f package persistence.
     *
     * @param lfPackagePersistence the l f package persistence
     */
    public void setLFPackagePersistence(
        LFPackagePersistence lfPackagePersistence) {
        this.lfPackagePersistence = lfPackagePersistence;
    }

    /**
     * Returns the l f package comment local service.
     *
     * @return the l f package comment local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalService getLFPackageCommentLocalService() {
        return lfPackageCommentLocalService;
    }

    /**
     * Sets the l f package comment local service.
     *
     * @param lfPackageCommentLocalService the l f package comment local service
     */
    public void setLFPackageCommentLocalService(
        com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalService lfPackageCommentLocalService) {
        this.lfPackageCommentLocalService = lfPackageCommentLocalService;
    }

    /**
     * Returns the l f package comment persistence.
     *
     * @return the l f package comment persistence
     */
    public LFPackageCommentPersistence getLFPackageCommentPersistence() {
        return lfPackageCommentPersistence;
    }

    /**
     * Sets the l f package comment persistence.
     *
     * @param lfPackageCommentPersistence the l f package comment persistence
     */
    public void setLFPackageCommentPersistence(
        LFPackageCommentPersistence lfPackageCommentPersistence) {
        this.lfPackageCommentPersistence = lfPackageCommentPersistence;
    }

    /**
     * Returns the l f package grade storage local service.
     *
     * @return the l f package grade storage local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalService getLFPackageGradeStorageLocalService() {
        return lfPackageGradeStorageLocalService;
    }

    /**
     * Sets the l f package grade storage local service.
     *
     * @param lfPackageGradeStorageLocalService the l f package grade storage local service
     */
    public void setLFPackageGradeStorageLocalService(
        com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalService lfPackageGradeStorageLocalService) {
        this.lfPackageGradeStorageLocalService = lfPackageGradeStorageLocalService;
    }

    /**
     * Returns the l f package grade storage persistence.
     *
     * @return the l f package grade storage persistence
     */
    public LFPackageGradeStoragePersistence getLFPackageGradeStoragePersistence() {
        return lfPackageGradeStoragePersistence;
    }

    /**
     * Sets the l f package grade storage persistence.
     *
     * @param lfPackageGradeStoragePersistence the l f package grade storage persistence
     */
    public void setLFPackageGradeStoragePersistence(
        LFPackageGradeStoragePersistence lfPackageGradeStoragePersistence) {
        this.lfPackageGradeStoragePersistence = lfPackageGradeStoragePersistence;
    }

    /**
     * Returns the l f package scope rule local service.
     *
     * @return the l f package scope rule local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalService getLFPackageScopeRuleLocalService() {
        return lfPackageScopeRuleLocalService;
    }

    /**
     * Sets the l f package scope rule local service.
     *
     * @param lfPackageScopeRuleLocalService the l f package scope rule local service
     */
    public void setLFPackageScopeRuleLocalService(
        com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalService lfPackageScopeRuleLocalService) {
        this.lfPackageScopeRuleLocalService = lfPackageScopeRuleLocalService;
    }

    /**
     * Returns the l f package scope rule persistence.
     *
     * @return the l f package scope rule persistence
     */
    public LFPackageScopeRulePersistence getLFPackageScopeRulePersistence() {
        return lfPackageScopeRulePersistence;
    }

    /**
     * Sets the l f package scope rule persistence.
     *
     * @param lfPackageScopeRulePersistence the l f package scope rule persistence
     */
    public void setLFPackageScopeRulePersistence(
        LFPackageScopeRulePersistence lfPackageScopeRulePersistence) {
        this.lfPackageScopeRulePersistence = lfPackageScopeRulePersistence;
    }

    /**
     * Returns the l f package vote local service.
     *
     * @return the l f package vote local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalService getLFPackageVoteLocalService() {
        return lfPackageVoteLocalService;
    }

    /**
     * Sets the l f package vote local service.
     *
     * @param lfPackageVoteLocalService the l f package vote local service
     */
    public void setLFPackageVoteLocalService(
        com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalService lfPackageVoteLocalService) {
        this.lfPackageVoteLocalService = lfPackageVoteLocalService;
    }

    /**
     * Returns the l f package vote persistence.
     *
     * @return the l f package vote persistence
     */
    public LFPackageVotePersistence getLFPackageVotePersistence() {
        return lfPackageVotePersistence;
    }

    /**
     * Sets the l f package vote persistence.
     *
     * @param lfPackageVotePersistence the l f package vote persistence
     */
    public void setLFPackageVotePersistence(
        LFPackageVotePersistence lfPackageVotePersistence) {
        this.lfPackageVotePersistence = lfPackageVotePersistence;
    }

    /**
     * Returns the l f player scope rule local service.
     *
     * @return the l f player scope rule local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalService getLFPlayerScopeRuleLocalService() {
        return lfPlayerScopeRuleLocalService;
    }

    /**
     * Sets the l f player scope rule local service.
     *
     * @param lfPlayerScopeRuleLocalService the l f player scope rule local service
     */
    public void setLFPlayerScopeRuleLocalService(
        com.arcusys.learn.persistence.liferay.service.LFPlayerScopeRuleLocalService lfPlayerScopeRuleLocalService) {
        this.lfPlayerScopeRuleLocalService = lfPlayerScopeRuleLocalService;
    }

    /**
     * Returns the l f player scope rule persistence.
     *
     * @return the l f player scope rule persistence
     */
    public LFPlayerScopeRulePersistence getLFPlayerScopeRulePersistence() {
        return lfPlayerScopeRulePersistence;
    }

    /**
     * Sets the l f player scope rule persistence.
     *
     * @param lfPlayerScopeRulePersistence the l f player scope rule persistence
     */
    public void setLFPlayerScopeRulePersistence(
        LFPlayerScopeRulePersistence lfPlayerScopeRulePersistence) {
        this.lfPlayerScopeRulePersistence = lfPlayerScopeRulePersistence;
    }

    /**
     * Returns the l f question local service.
     *
     * @return the l f question local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuestionLocalService getLFQuestionLocalService() {
        return lfQuestionLocalService;
    }

    /**
     * Sets the l f question local service.
     *
     * @param lfQuestionLocalService the l f question local service
     */
    public void setLFQuestionLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuestionLocalService lfQuestionLocalService) {
        this.lfQuestionLocalService = lfQuestionLocalService;
    }

    /**
     * Returns the l f question persistence.
     *
     * @return the l f question persistence
     */
    public LFQuestionPersistence getLFQuestionPersistence() {
        return lfQuestionPersistence;
    }

    /**
     * Sets the l f question persistence.
     *
     * @param lfQuestionPersistence the l f question persistence
     */
    public void setLFQuestionPersistence(
        LFQuestionPersistence lfQuestionPersistence) {
        this.lfQuestionPersistence = lfQuestionPersistence;
    }

    /**
     * Returns the l f question category local service.
     *
     * @return the l f question category local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalService getLFQuestionCategoryLocalService() {
        return lfQuestionCategoryLocalService;
    }

    /**
     * Sets the l f question category local service.
     *
     * @param lfQuestionCategoryLocalService the l f question category local service
     */
    public void setLFQuestionCategoryLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalService lfQuestionCategoryLocalService) {
        this.lfQuestionCategoryLocalService = lfQuestionCategoryLocalService;
    }

    /**
     * Returns the l f question category persistence.
     *
     * @return the l f question category persistence
     */
    public LFQuestionCategoryPersistence getLFQuestionCategoryPersistence() {
        return lfQuestionCategoryPersistence;
    }

    /**
     * Sets the l f question category persistence.
     *
     * @param lfQuestionCategoryPersistence the l f question category persistence
     */
    public void setLFQuestionCategoryPersistence(
        LFQuestionCategoryPersistence lfQuestionCategoryPersistence) {
        this.lfQuestionCategoryPersistence = lfQuestionCategoryPersistence;
    }

    /**
     * Returns the l f quiz local service.
     *
     * @return the l f quiz local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuizLocalService getLFQuizLocalService() {
        return lfQuizLocalService;
    }

    /**
     * Sets the l f quiz local service.
     *
     * @param lfQuizLocalService the l f quiz local service
     */
    public void setLFQuizLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuizLocalService lfQuizLocalService) {
        this.lfQuizLocalService = lfQuizLocalService;
    }

    /**
     * Returns the l f quiz persistence.
     *
     * @return the l f quiz persistence
     */
    public LFQuizPersistence getLFQuizPersistence() {
        return lfQuizPersistence;
    }

    /**
     * Sets the l f quiz persistence.
     *
     * @param lfQuizPersistence the l f quiz persistence
     */
    public void setLFQuizPersistence(LFQuizPersistence lfQuizPersistence) {
        this.lfQuizPersistence = lfQuizPersistence;
    }

    /**
     * Returns the l f quiz answer score local service.
     *
     * @return the l f quiz answer score local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalService getLFQuizAnswerScoreLocalService() {
        return lfQuizAnswerScoreLocalService;
    }

    /**
     * Sets the l f quiz answer score local service.
     *
     * @param lfQuizAnswerScoreLocalService the l f quiz answer score local service
     */
    public void setLFQuizAnswerScoreLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalService lfQuizAnswerScoreLocalService) {
        this.lfQuizAnswerScoreLocalService = lfQuizAnswerScoreLocalService;
    }

    /**
     * Returns the l f quiz answer score persistence.
     *
     * @return the l f quiz answer score persistence
     */
    public LFQuizAnswerScorePersistence getLFQuizAnswerScorePersistence() {
        return lfQuizAnswerScorePersistence;
    }

    /**
     * Sets the l f quiz answer score persistence.
     *
     * @param lfQuizAnswerScorePersistence the l f quiz answer score persistence
     */
    public void setLFQuizAnswerScorePersistence(
        LFQuizAnswerScorePersistence lfQuizAnswerScorePersistence) {
        this.lfQuizAnswerScorePersistence = lfQuizAnswerScorePersistence;
    }

    /**
     * Returns the l f quiz question local service.
     *
     * @return the l f quiz question local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalService getLFQuizQuestionLocalService() {
        return lfQuizQuestionLocalService;
    }

    /**
     * Sets the l f quiz question local service.
     *
     * @param lfQuizQuestionLocalService the l f quiz question local service
     */
    public void setLFQuizQuestionLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalService lfQuizQuestionLocalService) {
        this.lfQuizQuestionLocalService = lfQuizQuestionLocalService;
    }

    /**
     * Returns the l f quiz question persistence.
     *
     * @return the l f quiz question persistence
     */
    public LFQuizQuestionPersistence getLFQuizQuestionPersistence() {
        return lfQuizQuestionPersistence;
    }

    /**
     * Sets the l f quiz question persistence.
     *
     * @param lfQuizQuestionPersistence the l f quiz question persistence
     */
    public void setLFQuizQuestionPersistence(
        LFQuizQuestionPersistence lfQuizQuestionPersistence) {
        this.lfQuizQuestionPersistence = lfQuizQuestionPersistence;
    }

    /**
     * Returns the l f quiz question category local service.
     *
     * @return the l f quiz question category local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalService getLFQuizQuestionCategoryLocalService() {
        return lfQuizQuestionCategoryLocalService;
    }

    /**
     * Sets the l f quiz question category local service.
     *
     * @param lfQuizQuestionCategoryLocalService the l f quiz question category local service
     */
    public void setLFQuizQuestionCategoryLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalService lfQuizQuestionCategoryLocalService) {
        this.lfQuizQuestionCategoryLocalService = lfQuizQuestionCategoryLocalService;
    }

    /**
     * Returns the l f quiz question category persistence.
     *
     * @return the l f quiz question category persistence
     */
    public LFQuizQuestionCategoryPersistence getLFQuizQuestionCategoryPersistence() {
        return lfQuizQuestionCategoryPersistence;
    }

    /**
     * Sets the l f quiz question category persistence.
     *
     * @param lfQuizQuestionCategoryPersistence the l f quiz question category persistence
     */
    public void setLFQuizQuestionCategoryPersistence(
        LFQuizQuestionCategoryPersistence lfQuizQuestionCategoryPersistence) {
        this.lfQuizQuestionCategoryPersistence = lfQuizQuestionCategoryPersistence;
    }

    /**
     * Returns the l f quiz tree element local service.
     *
     * @return the l f quiz tree element local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalService getLFQuizTreeElementLocalService() {
        return lfQuizTreeElementLocalService;
    }

    /**
     * Sets the l f quiz tree element local service.
     *
     * @param lfQuizTreeElementLocalService the l f quiz tree element local service
     */
    public void setLFQuizTreeElementLocalService(
        com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalService lfQuizTreeElementLocalService) {
        this.lfQuizTreeElementLocalService = lfQuizTreeElementLocalService;
    }

    /**
     * Returns the l f quiz tree element persistence.
     *
     * @return the l f quiz tree element persistence
     */
    public LFQuizTreeElementPersistence getLFQuizTreeElementPersistence() {
        return lfQuizTreeElementPersistence;
    }

    /**
     * Sets the l f quiz tree element persistence.
     *
     * @param lfQuizTreeElementPersistence the l f quiz tree element persistence
     */
    public void setLFQuizTreeElementPersistence(
        LFQuizTreeElementPersistence lfQuizTreeElementPersistence) {
        this.lfQuizTreeElementPersistence = lfQuizTreeElementPersistence;
    }

    /**
     * Returns the l f required activity local service.
     *
     * @return the l f required activity local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalService getLFRequiredActivityLocalService() {
        return lfRequiredActivityLocalService;
    }

    /**
     * Sets the l f required activity local service.
     *
     * @param lfRequiredActivityLocalService the l f required activity local service
     */
    public void setLFRequiredActivityLocalService(
        com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalService lfRequiredActivityLocalService) {
        this.lfRequiredActivityLocalService = lfRequiredActivityLocalService;
    }

    /**
     * Returns the l f required activity persistence.
     *
     * @return the l f required activity persistence
     */
    public LFRequiredActivityPersistence getLFRequiredActivityPersistence() {
        return lfRequiredActivityPersistence;
    }

    /**
     * Sets the l f required activity persistence.
     *
     * @param lfRequiredActivityPersistence the l f required activity persistence
     */
    public void setLFRequiredActivityPersistence(
        LFRequiredActivityPersistence lfRequiredActivityPersistence) {
        this.lfRequiredActivityPersistence = lfRequiredActivityPersistence;
    }

    /**
     * Returns the l f resource local service.
     *
     * @return the l f resource local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFResourceLocalService getLFResourceLocalService() {
        return lfResourceLocalService;
    }

    /**
     * Sets the l f resource local service.
     *
     * @param lfResourceLocalService the l f resource local service
     */
    public void setLFResourceLocalService(
        com.arcusys.learn.persistence.liferay.service.LFResourceLocalService lfResourceLocalService) {
        this.lfResourceLocalService = lfResourceLocalService;
    }

    /**
     * Returns the l f resource persistence.
     *
     * @return the l f resource persistence
     */
    public LFResourcePersistence getLFResourcePersistence() {
        return lfResourcePersistence;
    }

    /**
     * Sets the l f resource persistence.
     *
     * @param lfResourcePersistence the l f resource persistence
     */
    public void setLFResourcePersistence(
        LFResourcePersistence lfResourcePersistence) {
        this.lfResourcePersistence = lfResourcePersistence;
    }

    /**
     * Returns the l f role local service.
     *
     * @return the l f role local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFRoleLocalService getLFRoleLocalService() {
        return lfRoleLocalService;
    }

    /**
     * Sets the l f role local service.
     *
     * @param lfRoleLocalService the l f role local service
     */
    public void setLFRoleLocalService(
        com.arcusys.learn.persistence.liferay.service.LFRoleLocalService lfRoleLocalService) {
        this.lfRoleLocalService = lfRoleLocalService;
    }

    /**
     * Returns the l f role persistence.
     *
     * @return the l f role persistence
     */
    public LFRolePersistence getLFRolePersistence() {
        return lfRolePersistence;
    }

    /**
     * Sets the l f role persistence.
     *
     * @param lfRolePersistence the l f role persistence
     */
    public void setLFRolePersistence(LFRolePersistence lfRolePersistence) {
        this.lfRolePersistence = lfRolePersistence;
    }

    /**
     * Returns the l f rollup contribution local service.
     *
     * @return the l f rollup contribution local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalService getLFRollupContributionLocalService() {
        return lfRollupContributionLocalService;
    }

    /**
     * Sets the l f rollup contribution local service.
     *
     * @param lfRollupContributionLocalService the l f rollup contribution local service
     */
    public void setLFRollupContributionLocalService(
        com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalService lfRollupContributionLocalService) {
        this.lfRollupContributionLocalService = lfRollupContributionLocalService;
    }

    /**
     * Returns the l f rollup contribution persistence.
     *
     * @return the l f rollup contribution persistence
     */
    public LFRollupContributionPersistence getLFRollupContributionPersistence() {
        return lfRollupContributionPersistence;
    }

    /**
     * Sets the l f rollup contribution persistence.
     *
     * @param lfRollupContributionPersistence the l f rollup contribution persistence
     */
    public void setLFRollupContributionPersistence(
        LFRollupContributionPersistence lfRollupContributionPersistence) {
        this.lfRollupContributionPersistence = lfRollupContributionPersistence;
    }

    /**
     * Returns the l f rollup rule local service.
     *
     * @return the l f rollup rule local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalService getLFRollupRuleLocalService() {
        return lfRollupRuleLocalService;
    }

    /**
     * Sets the l f rollup rule local service.
     *
     * @param lfRollupRuleLocalService the l f rollup rule local service
     */
    public void setLFRollupRuleLocalService(
        com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalService lfRollupRuleLocalService) {
        this.lfRollupRuleLocalService = lfRollupRuleLocalService;
    }

    /**
     * Returns the l f rollup rule persistence.
     *
     * @return the l f rollup rule persistence
     */
    public LFRollupRulePersistence getLFRollupRulePersistence() {
        return lfRollupRulePersistence;
    }

    /**
     * Sets the l f rollup rule persistence.
     *
     * @param lfRollupRulePersistence the l f rollup rule persistence
     */
    public void setLFRollupRulePersistence(
        LFRollupRulePersistence lfRollupRulePersistence) {
        this.lfRollupRulePersistence = lfRollupRulePersistence;
    }

    /**
     * Returns the l f rule condition local service.
     *
     * @return the l f rule condition local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalService getLFRuleConditionLocalService() {
        return lfRuleConditionLocalService;
    }

    /**
     * Sets the l f rule condition local service.
     *
     * @param lfRuleConditionLocalService the l f rule condition local service
     */
    public void setLFRuleConditionLocalService(
        com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalService lfRuleConditionLocalService) {
        this.lfRuleConditionLocalService = lfRuleConditionLocalService;
    }

    /**
     * Returns the l f rule condition persistence.
     *
     * @return the l f rule condition persistence
     */
    public LFRuleConditionPersistence getLFRuleConditionPersistence() {
        return lfRuleConditionPersistence;
    }

    /**
     * Sets the l f rule condition persistence.
     *
     * @param lfRuleConditionPersistence the l f rule condition persistence
     */
    public void setLFRuleConditionPersistence(
        LFRuleConditionPersistence lfRuleConditionPersistence) {
        this.lfRuleConditionPersistence = lfRuleConditionPersistence;
    }

    /**
     * Returns the l f sequencing local service.
     *
     * @return the l f sequencing local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFSequencingLocalService getLFSequencingLocalService() {
        return lfSequencingLocalService;
    }

    /**
     * Sets the l f sequencing local service.
     *
     * @param lfSequencingLocalService the l f sequencing local service
     */
    public void setLFSequencingLocalService(
        com.arcusys.learn.persistence.liferay.service.LFSequencingLocalService lfSequencingLocalService) {
        this.lfSequencingLocalService = lfSequencingLocalService;
    }

    /**
     * Returns the l f sequencing persistence.
     *
     * @return the l f sequencing persistence
     */
    public LFSequencingPersistence getLFSequencingPersistence() {
        return lfSequencingPersistence;
    }

    /**
     * Sets the l f sequencing persistence.
     *
     * @param lfSequencingPersistence the l f sequencing persistence
     */
    public void setLFSequencingPersistence(
        LFSequencingPersistence lfSequencingPersistence) {
        this.lfSequencingPersistence = lfSequencingPersistence;
    }

    /**
     * Returns the l f sequencing permissions local service.
     *
     * @return the l f sequencing permissions local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalService getLFSequencingPermissionsLocalService() {
        return lfSequencingPermissionsLocalService;
    }

    /**
     * Sets the l f sequencing permissions local service.
     *
     * @param lfSequencingPermissionsLocalService the l f sequencing permissions local service
     */
    public void setLFSequencingPermissionsLocalService(
        com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalService lfSequencingPermissionsLocalService) {
        this.lfSequencingPermissionsLocalService = lfSequencingPermissionsLocalService;
    }

    /**
     * Returns the l f sequencing permissions persistence.
     *
     * @return the l f sequencing permissions persistence
     */
    public LFSequencingPermissionsPersistence getLFSequencingPermissionsPersistence() {
        return lfSequencingPermissionsPersistence;
    }

    /**
     * Sets the l f sequencing permissions persistence.
     *
     * @param lfSequencingPermissionsPersistence the l f sequencing permissions persistence
     */
    public void setLFSequencingPermissionsPersistence(
        LFSequencingPermissionsPersistence lfSequencingPermissionsPersistence) {
        this.lfSequencingPermissionsPersistence = lfSequencingPermissionsPersistence;
    }

    /**
     * Returns the l f sequencing tracking local service.
     *
     * @return the l f sequencing tracking local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalService getLFSequencingTrackingLocalService() {
        return lfSequencingTrackingLocalService;
    }

    /**
     * Sets the l f sequencing tracking local service.
     *
     * @param lfSequencingTrackingLocalService the l f sequencing tracking local service
     */
    public void setLFSequencingTrackingLocalService(
        com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalService lfSequencingTrackingLocalService) {
        this.lfSequencingTrackingLocalService = lfSequencingTrackingLocalService;
    }

    /**
     * Returns the l f sequencing tracking persistence.
     *
     * @return the l f sequencing tracking persistence
     */
    public LFSequencingTrackingPersistence getLFSequencingTrackingPersistence() {
        return lfSequencingTrackingPersistence;
    }

    /**
     * Sets the l f sequencing tracking persistence.
     *
     * @param lfSequencingTrackingPersistence the l f sequencing tracking persistence
     */
    public void setLFSequencingTrackingPersistence(
        LFSequencingTrackingPersistence lfSequencingTrackingPersistence) {
        this.lfSequencingTrackingPersistence = lfSequencingTrackingPersistence;
    }

    /**
     * Returns the l f site dependent config local service.
     *
     * @return the l f site dependent config local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalService getLFSiteDependentConfigLocalService() {
        return lfSiteDependentConfigLocalService;
    }

    /**
     * Sets the l f site dependent config local service.
     *
     * @param lfSiteDependentConfigLocalService the l f site dependent config local service
     */
    public void setLFSiteDependentConfigLocalService(
        com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalService lfSiteDependentConfigLocalService) {
        this.lfSiteDependentConfigLocalService = lfSiteDependentConfigLocalService;
    }

    /**
     * Returns the l f site dependent config persistence.
     *
     * @return the l f site dependent config persistence
     */
    public LFSiteDependentConfigPersistence getLFSiteDependentConfigPersistence() {
        return lfSiteDependentConfigPersistence;
    }

    /**
     * Sets the l f site dependent config persistence.
     *
     * @param lfSiteDependentConfigPersistence the l f site dependent config persistence
     */
    public void setLFSiteDependentConfigPersistence(
        LFSiteDependentConfigPersistence lfSiteDependentConfigPersistence) {
        this.lfSiteDependentConfigPersistence = lfSiteDependentConfigPersistence;
    }

    /**
     * Returns the l f social package local service.
     *
     * @return the l f social package local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalService getLFSocialPackageLocalService() {
        return lfSocialPackageLocalService;
    }

    /**
     * Sets the l f social package local service.
     *
     * @param lfSocialPackageLocalService the l f social package local service
     */
    public void setLFSocialPackageLocalService(
        com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalService lfSocialPackageLocalService) {
        this.lfSocialPackageLocalService = lfSocialPackageLocalService;
    }

    /**
     * Returns the l f social package persistence.
     *
     * @return the l f social package persistence
     */
    public LFSocialPackagePersistence getLFSocialPackagePersistence() {
        return lfSocialPackagePersistence;
    }

    /**
     * Sets the l f social package persistence.
     *
     * @param lfSocialPackagePersistence the l f social package persistence
     */
    public void setLFSocialPackagePersistence(
        LFSocialPackagePersistence lfSocialPackagePersistence) {
        this.lfSocialPackagePersistence = lfSocialPackagePersistence;
    }

    /**
     * Returns the l f social package tag local service.
     *
     * @return the l f social package tag local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalService getLFSocialPackageTagLocalService() {
        return lfSocialPackageTagLocalService;
    }

    /**
     * Sets the l f social package tag local service.
     *
     * @param lfSocialPackageTagLocalService the l f social package tag local service
     */
    public void setLFSocialPackageTagLocalService(
        com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalService lfSocialPackageTagLocalService) {
        this.lfSocialPackageTagLocalService = lfSocialPackageTagLocalService;
    }

    /**
     * Returns the l f social package tag persistence.
     *
     * @return the l f social package tag persistence
     */
    public LFSocialPackageTagPersistence getLFSocialPackageTagPersistence() {
        return lfSocialPackageTagPersistence;
    }

    /**
     * Sets the l f social package tag persistence.
     *
     * @param lfSocialPackageTagPersistence the l f social package tag persistence
     */
    public void setLFSocialPackageTagPersistence(
        LFSocialPackageTagPersistence lfSocialPackageTagPersistence) {
        this.lfSocialPackageTagPersistence = lfSocialPackageTagPersistence;
    }

    /**
     * Returns the l f tincan activity local service.
     *
     * @return the l f tincan activity local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalService getLFTincanActivityLocalService() {
        return lfTincanActivityLocalService;
    }

    /**
     * Sets the l f tincan activity local service.
     *
     * @param lfTincanActivityLocalService the l f tincan activity local service
     */
    public void setLFTincanActivityLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalService lfTincanActivityLocalService) {
        this.lfTincanActivityLocalService = lfTincanActivityLocalService;
    }

    /**
     * Returns the l f tincan activity persistence.
     *
     * @return the l f tincan activity persistence
     */
    public LFTincanActivityPersistence getLFTincanActivityPersistence() {
        return lfTincanActivityPersistence;
    }

    /**
     * Sets the l f tincan activity persistence.
     *
     * @param lfTincanActivityPersistence the l f tincan activity persistence
     */
    public void setLFTincanActivityPersistence(
        LFTincanActivityPersistence lfTincanActivityPersistence) {
        this.lfTincanActivityPersistence = lfTincanActivityPersistence;
    }

    /**
     * Returns the l f tincan actor local service.
     *
     * @return the l f tincan actor local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalService getLFTincanActorLocalService() {
        return lfTincanActorLocalService;
    }

    /**
     * Sets the l f tincan actor local service.
     *
     * @param lfTincanActorLocalService the l f tincan actor local service
     */
    public void setLFTincanActorLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanActorLocalService lfTincanActorLocalService) {
        this.lfTincanActorLocalService = lfTincanActorLocalService;
    }

    /**
     * Returns the l f tincan actor persistence.
     *
     * @return the l f tincan actor persistence
     */
    public LFTincanActorPersistence getLFTincanActorPersistence() {
        return lfTincanActorPersistence;
    }

    /**
     * Sets the l f tincan actor persistence.
     *
     * @param lfTincanActorPersistence the l f tincan actor persistence
     */
    public void setLFTincanActorPersistence(
        LFTincanActorPersistence lfTincanActorPersistence) {
        this.lfTincanActorPersistence = lfTincanActorPersistence;
    }

    /**
     * Returns the l f tincan act profile local service.
     *
     * @return the l f tincan act profile local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalService getLFTincanActProfileLocalService() {
        return lfTincanActProfileLocalService;
    }

    /**
     * Sets the l f tincan act profile local service.
     *
     * @param lfTincanActProfileLocalService the l f tincan act profile local service
     */
    public void setLFTincanActProfileLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalService lfTincanActProfileLocalService) {
        this.lfTincanActProfileLocalService = lfTincanActProfileLocalService;
    }

    /**
     * Returns the l f tincan act profile persistence.
     *
     * @return the l f tincan act profile persistence
     */
    public LFTincanActProfilePersistence getLFTincanActProfilePersistence() {
        return lfTincanActProfilePersistence;
    }

    /**
     * Sets the l f tincan act profile persistence.
     *
     * @param lfTincanActProfilePersistence the l f tincan act profile persistence
     */
    public void setLFTincanActProfilePersistence(
        LFTincanActProfilePersistence lfTincanActProfilePersistence) {
        this.lfTincanActProfilePersistence = lfTincanActProfilePersistence;
    }

    /**
     * Returns the l f tincan client api storage local service.
     *
     * @return the l f tincan client api storage local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalService getLFTincanClientApiStorageLocalService() {
        return lfTincanClientApiStorageLocalService;
    }

    /**
     * Sets the l f tincan client api storage local service.
     *
     * @param lfTincanClientApiStorageLocalService the l f tincan client api storage local service
     */
    public void setLFTincanClientApiStorageLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalService lfTincanClientApiStorageLocalService) {
        this.lfTincanClientApiStorageLocalService = lfTincanClientApiStorageLocalService;
    }

    /**
     * Returns the l f tincan client api storage persistence.
     *
     * @return the l f tincan client api storage persistence
     */
    public LFTincanClientApiStoragePersistence getLFTincanClientApiStoragePersistence() {
        return lfTincanClientApiStoragePersistence;
    }

    /**
     * Sets the l f tincan client api storage persistence.
     *
     * @param lfTincanClientApiStoragePersistence the l f tincan client api storage persistence
     */
    public void setLFTincanClientApiStoragePersistence(
        LFTincanClientApiStoragePersistence lfTincanClientApiStoragePersistence) {
        this.lfTincanClientApiStoragePersistence = lfTincanClientApiStoragePersistence;
    }

    /**
     * Returns the l f tincan ctx activities local service.
     *
     * @return the l f tincan ctx activities local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalService getLFTincanCtxActivitiesLocalService() {
        return lfTincanCtxActivitiesLocalService;
    }

    /**
     * Sets the l f tincan ctx activities local service.
     *
     * @param lfTincanCtxActivitiesLocalService the l f tincan ctx activities local service
     */
    public void setLFTincanCtxActivitiesLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalService lfTincanCtxActivitiesLocalService) {
        this.lfTincanCtxActivitiesLocalService = lfTincanCtxActivitiesLocalService;
    }

    /**
     * Returns the l f tincan ctx activities persistence.
     *
     * @return the l f tincan ctx activities persistence
     */
    public LFTincanCtxActivitiesPersistence getLFTincanCtxActivitiesPersistence() {
        return lfTincanCtxActivitiesPersistence;
    }

    /**
     * Sets the l f tincan ctx activities persistence.
     *
     * @param lfTincanCtxActivitiesPersistence the l f tincan ctx activities persistence
     */
    public void setLFTincanCtxActivitiesPersistence(
        LFTincanCtxActivitiesPersistence lfTincanCtxActivitiesPersistence) {
        this.lfTincanCtxActivitiesPersistence = lfTincanCtxActivitiesPersistence;
    }

    /**
     * Returns the l f tincan lrs agent profile local service.
     *
     * @return the l f tincan lrs agent profile local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalService getLFTincanLrsAgentProfileLocalService() {
        return lfTincanLrsAgentProfileLocalService;
    }

    /**
     * Sets the l f tincan lrs agent profile local service.
     *
     * @param lfTincanLrsAgentProfileLocalService the l f tincan lrs agent profile local service
     */
    public void setLFTincanLrsAgentProfileLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalService lfTincanLrsAgentProfileLocalService) {
        this.lfTincanLrsAgentProfileLocalService = lfTincanLrsAgentProfileLocalService;
    }

    /**
     * Returns the l f tincan lrs agent profile persistence.
     *
     * @return the l f tincan lrs agent profile persistence
     */
    public LFTincanLrsAgentProfilePersistence getLFTincanLrsAgentProfilePersistence() {
        return lfTincanLrsAgentProfilePersistence;
    }

    /**
     * Sets the l f tincan lrs agent profile persistence.
     *
     * @param lfTincanLrsAgentProfilePersistence the l f tincan lrs agent profile persistence
     */
    public void setLFTincanLrsAgentProfilePersistence(
        LFTincanLrsAgentProfilePersistence lfTincanLrsAgentProfilePersistence) {
        this.lfTincanLrsAgentProfilePersistence = lfTincanLrsAgentProfilePersistence;
    }

    /**
     * Returns the l f tincan lrs attachment local service.
     *
     * @return the l f tincan lrs attachment local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalService getLFTincanLrsAttachmentLocalService() {
        return lfTincanLrsAttachmentLocalService;
    }

    /**
     * Sets the l f tincan lrs attachment local service.
     *
     * @param lfTincanLrsAttachmentLocalService the l f tincan lrs attachment local service
     */
    public void setLFTincanLrsAttachmentLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalService lfTincanLrsAttachmentLocalService) {
        this.lfTincanLrsAttachmentLocalService = lfTincanLrsAttachmentLocalService;
    }

    /**
     * Returns the l f tincan lrs attachment persistence.
     *
     * @return the l f tincan lrs attachment persistence
     */
    public LFTincanLrsAttachmentPersistence getLFTincanLrsAttachmentPersistence() {
        return lfTincanLrsAttachmentPersistence;
    }

    /**
     * Sets the l f tincan lrs attachment persistence.
     *
     * @param lfTincanLrsAttachmentPersistence the l f tincan lrs attachment persistence
     */
    public void setLFTincanLrsAttachmentPersistence(
        LFTincanLrsAttachmentPersistence lfTincanLrsAttachmentPersistence) {
        this.lfTincanLrsAttachmentPersistence = lfTincanLrsAttachmentPersistence;
    }

    /**
     * Returns the l f tincan lrs context local service.
     *
     * @return the l f tincan lrs context local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalService getLFTincanLrsContextLocalService() {
        return lfTincanLrsContextLocalService;
    }

    /**
     * Sets the l f tincan lrs context local service.
     *
     * @param lfTincanLrsContextLocalService the l f tincan lrs context local service
     */
    public void setLFTincanLrsContextLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalService lfTincanLrsContextLocalService) {
        this.lfTincanLrsContextLocalService = lfTincanLrsContextLocalService;
    }

    /**
     * Returns the l f tincan lrs context persistence.
     *
     * @return the l f tincan lrs context persistence
     */
    public LFTincanLrsContextPersistence getLFTincanLrsContextPersistence() {
        return lfTincanLrsContextPersistence;
    }

    /**
     * Sets the l f tincan lrs context persistence.
     *
     * @param lfTincanLrsContextPersistence the l f tincan lrs context persistence
     */
    public void setLFTincanLrsContextPersistence(
        LFTincanLrsContextPersistence lfTincanLrsContextPersistence) {
        this.lfTincanLrsContextPersistence = lfTincanLrsContextPersistence;
    }

    /**
     * Returns the l f tincan lrs document local service.
     *
     * @return the l f tincan lrs document local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalService getLFTincanLrsDocumentLocalService() {
        return lfTincanLrsDocumentLocalService;
    }

    /**
     * Sets the l f tincan lrs document local service.
     *
     * @param lfTincanLrsDocumentLocalService the l f tincan lrs document local service
     */
    public void setLFTincanLrsDocumentLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalService lfTincanLrsDocumentLocalService) {
        this.lfTincanLrsDocumentLocalService = lfTincanLrsDocumentLocalService;
    }

    /**
     * Returns the l f tincan lrs document persistence.
     *
     * @return the l f tincan lrs document persistence
     */
    public LFTincanLrsDocumentPersistence getLFTincanLrsDocumentPersistence() {
        return lfTincanLrsDocumentPersistence;
    }

    /**
     * Sets the l f tincan lrs document persistence.
     *
     * @param lfTincanLrsDocumentPersistence the l f tincan lrs document persistence
     */
    public void setLFTincanLrsDocumentPersistence(
        LFTincanLrsDocumentPersistence lfTincanLrsDocumentPersistence) {
        this.lfTincanLrsDocumentPersistence = lfTincanLrsDocumentPersistence;
    }

    /**
     * Returns the l f tincan lrs endpoint local service.
     *
     * @return the l f tincan lrs endpoint local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalService getLFTincanLrsEndpointLocalService() {
        return lfTincanLrsEndpointLocalService;
    }

    /**
     * Sets the l f tincan lrs endpoint local service.
     *
     * @param lfTincanLrsEndpointLocalService the l f tincan lrs endpoint local service
     */
    public void setLFTincanLrsEndpointLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalService lfTincanLrsEndpointLocalService) {
        this.lfTincanLrsEndpointLocalService = lfTincanLrsEndpointLocalService;
    }

    /**
     * Returns the l f tincan lrs endpoint persistence.
     *
     * @return the l f tincan lrs endpoint persistence
     */
    public LFTincanLrsEndpointPersistence getLFTincanLrsEndpointPersistence() {
        return lfTincanLrsEndpointPersistence;
    }

    /**
     * Sets the l f tincan lrs endpoint persistence.
     *
     * @param lfTincanLrsEndpointPersistence the l f tincan lrs endpoint persistence
     */
    public void setLFTincanLrsEndpointPersistence(
        LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence) {
        this.lfTincanLrsEndpointPersistence = lfTincanLrsEndpointPersistence;
    }

    /**
     * Returns the l f tincan lrs result local service.
     *
     * @return the l f tincan lrs result local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalService getLFTincanLrsResultLocalService() {
        return lfTincanLrsResultLocalService;
    }

    /**
     * Sets the l f tincan lrs result local service.
     *
     * @param lfTincanLrsResultLocalService the l f tincan lrs result local service
     */
    public void setLFTincanLrsResultLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsResultLocalService lfTincanLrsResultLocalService) {
        this.lfTincanLrsResultLocalService = lfTincanLrsResultLocalService;
    }

    /**
     * Returns the l f tincan lrs result persistence.
     *
     * @return the l f tincan lrs result persistence
     */
    public LFTincanLrsResultPersistence getLFTincanLrsResultPersistence() {
        return lfTincanLrsResultPersistence;
    }

    /**
     * Sets the l f tincan lrs result persistence.
     *
     * @param lfTincanLrsResultPersistence the l f tincan lrs result persistence
     */
    public void setLFTincanLrsResultPersistence(
        LFTincanLrsResultPersistence lfTincanLrsResultPersistence) {
        this.lfTincanLrsResultPersistence = lfTincanLrsResultPersistence;
    }

    /**
     * Returns the l f tincan lrs state local service.
     *
     * @return the l f tincan lrs state local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalService getLFTincanLrsStateLocalService() {
        return lfTincanLrsStateLocalService;
    }

    /**
     * Sets the l f tincan lrs state local service.
     *
     * @param lfTincanLrsStateLocalService the l f tincan lrs state local service
     */
    public void setLFTincanLrsStateLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalService lfTincanLrsStateLocalService) {
        this.lfTincanLrsStateLocalService = lfTincanLrsStateLocalService;
    }

    /**
     * Returns the l f tincan lrs state persistence.
     *
     * @return the l f tincan lrs state persistence
     */
    public LFTincanLrsStatePersistence getLFTincanLrsStatePersistence() {
        return lfTincanLrsStatePersistence;
    }

    /**
     * Sets the l f tincan lrs state persistence.
     *
     * @param lfTincanLrsStatePersistence the l f tincan lrs state persistence
     */
    public void setLFTincanLrsStatePersistence(
        LFTincanLrsStatePersistence lfTincanLrsStatePersistence) {
        this.lfTincanLrsStatePersistence = lfTincanLrsStatePersistence;
    }

    /**
     * Returns the l f tincan lrs statement local service.
     *
     * @return the l f tincan lrs statement local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalService getLFTincanLrsStatementLocalService() {
        return lfTincanLrsStatementLocalService;
    }

    /**
     * Sets the l f tincan lrs statement local service.
     *
     * @param lfTincanLrsStatementLocalService the l f tincan lrs statement local service
     */
    public void setLFTincanLrsStatementLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalService lfTincanLrsStatementLocalService) {
        this.lfTincanLrsStatementLocalService = lfTincanLrsStatementLocalService;
    }

    /**
     * Returns the l f tincan lrs statement persistence.
     *
     * @return the l f tincan lrs statement persistence
     */
    public LFTincanLrsStatementPersistence getLFTincanLrsStatementPersistence() {
        return lfTincanLrsStatementPersistence;
    }

    /**
     * Sets the l f tincan lrs statement persistence.
     *
     * @param lfTincanLrsStatementPersistence the l f tincan lrs statement persistence
     */
    public void setLFTincanLrsStatementPersistence(
        LFTincanLrsStatementPersistence lfTincanLrsStatementPersistence) {
        this.lfTincanLrsStatementPersistence = lfTincanLrsStatementPersistence;
    }

    /**
     * Returns the l f tincan lrs statement ref local service.
     *
     * @return the l f tincan lrs statement ref local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalService getLFTincanLrsStatementRefLocalService() {
        return lfTincanLrsStatementRefLocalService;
    }

    /**
     * Sets the l f tincan lrs statement ref local service.
     *
     * @param lfTincanLrsStatementRefLocalService the l f tincan lrs statement ref local service
     */
    public void setLFTincanLrsStatementRefLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalService lfTincanLrsStatementRefLocalService) {
        this.lfTincanLrsStatementRefLocalService = lfTincanLrsStatementRefLocalService;
    }

    /**
     * Returns the l f tincan lrs statement ref persistence.
     *
     * @return the l f tincan lrs statement ref persistence
     */
    public LFTincanLrsStatementRefPersistence getLFTincanLrsStatementRefPersistence() {
        return lfTincanLrsStatementRefPersistence;
    }

    /**
     * Sets the l f tincan lrs statement ref persistence.
     *
     * @param lfTincanLrsStatementRefPersistence the l f tincan lrs statement ref persistence
     */
    public void setLFTincanLrsStatementRefPersistence(
        LFTincanLrsStatementRefPersistence lfTincanLrsStatementRefPersistence) {
        this.lfTincanLrsStatementRefPersistence = lfTincanLrsStatementRefPersistence;
    }

    /**
     * Returns the l f tincan lrs sub statement local service.
     *
     * @return the l f tincan lrs sub statement local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalService getLFTincanLrsSubStatementLocalService() {
        return lfTincanLrsSubStatementLocalService;
    }

    /**
     * Sets the l f tincan lrs sub statement local service.
     *
     * @param lfTincanLrsSubStatementLocalService the l f tincan lrs sub statement local service
     */
    public void setLFTincanLrsSubStatementLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalService lfTincanLrsSubStatementLocalService) {
        this.lfTincanLrsSubStatementLocalService = lfTincanLrsSubStatementLocalService;
    }

    /**
     * Returns the l f tincan lrs sub statement persistence.
     *
     * @return the l f tincan lrs sub statement persistence
     */
    public LFTincanLrsSubStatementPersistence getLFTincanLrsSubStatementPersistence() {
        return lfTincanLrsSubStatementPersistence;
    }

    /**
     * Sets the l f tincan lrs sub statement persistence.
     *
     * @param lfTincanLrsSubStatementPersistence the l f tincan lrs sub statement persistence
     */
    public void setLFTincanLrsSubStatementPersistence(
        LFTincanLrsSubStatementPersistence lfTincanLrsSubStatementPersistence) {
        this.lfTincanLrsSubStatementPersistence = lfTincanLrsSubStatementPersistence;
    }

    /**
     * Returns the l f tincan manifest act local service.
     *
     * @return the l f tincan manifest act local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalService getLFTincanManifestActLocalService() {
        return lfTincanManifestActLocalService;
    }

    /**
     * Sets the l f tincan manifest act local service.
     *
     * @param lfTincanManifestActLocalService the l f tincan manifest act local service
     */
    public void setLFTincanManifestActLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalService lfTincanManifestActLocalService) {
        this.lfTincanManifestActLocalService = lfTincanManifestActLocalService;
    }

    /**
     * Returns the l f tincan manifest act persistence.
     *
     * @return the l f tincan manifest act persistence
     */
    public LFTincanManifestActPersistence getLFTincanManifestActPersistence() {
        return lfTincanManifestActPersistence;
    }

    /**
     * Sets the l f tincan manifest act persistence.
     *
     * @param lfTincanManifestActPersistence the l f tincan manifest act persistence
     */
    public void setLFTincanManifestActPersistence(
        LFTincanManifestActPersistence lfTincanManifestActPersistence) {
        this.lfTincanManifestActPersistence = lfTincanManifestActPersistence;
    }

    /**
     * Returns the l f tincan package local service.
     *
     * @return the l f tincan package local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalService getLFTincanPackageLocalService() {
        return lfTincanPackageLocalService;
    }

    /**
     * Sets the l f tincan package local service.
     *
     * @param lfTincanPackageLocalService the l f tincan package local service
     */
    public void setLFTincanPackageLocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalService lfTincanPackageLocalService) {
        this.lfTincanPackageLocalService = lfTincanPackageLocalService;
    }

    /**
     * Returns the l f tincan package persistence.
     *
     * @return the l f tincan package persistence
     */
    public LFTincanPackagePersistence getLFTincanPackagePersistence() {
        return lfTincanPackagePersistence;
    }

    /**
     * Sets the l f tincan package persistence.
     *
     * @param lfTincanPackagePersistence the l f tincan package persistence
     */
    public void setLFTincanPackagePersistence(
        LFTincanPackagePersistence lfTincanPackagePersistence) {
        this.lfTincanPackagePersistence = lfTincanPackagePersistence;
    }

    /**
     * Returns the l f tincan u r i local service.
     *
     * @return the l f tincan u r i local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFTincanURILocalService getLFTincanURILocalService() {
        return lfTincanURILocalService;
    }

    /**
     * Sets the l f tincan u r i local service.
     *
     * @param lfTincanURILocalService the l f tincan u r i local service
     */
    public void setLFTincanURILocalService(
        com.arcusys.learn.persistence.liferay.service.LFTincanURILocalService lfTincanURILocalService) {
        this.lfTincanURILocalService = lfTincanURILocalService;
    }

    /**
     * Returns the l f tincan u r i persistence.
     *
     * @return the l f tincan u r i persistence
     */
    public LFTincanURIPersistence getLFTincanURIPersistence() {
        return lfTincanURIPersistence;
    }

    /**
     * Sets the l f tincan u r i persistence.
     *
     * @param lfTincanURIPersistence the l f tincan u r i persistence
     */
    public void setLFTincanURIPersistence(
        LFTincanURIPersistence lfTincanURIPersistence) {
        this.lfTincanURIPersistence = lfTincanURIPersistence;
    }

    /**
     * Returns the l f user local service.
     *
     * @return the l f user local service
     */
    public com.arcusys.learn.persistence.liferay.service.LFUserLocalService getLFUserLocalService() {
        return lfUserLocalService;
    }

    /**
     * Sets the l f user local service.
     *
     * @param lfUserLocalService the l f user local service
     */
    public void setLFUserLocalService(
        com.arcusys.learn.persistence.liferay.service.LFUserLocalService lfUserLocalService) {
        this.lfUserLocalService = lfUserLocalService;
    }

    /**
     * Returns the l f user persistence.
     *
     * @return the l f user persistence
     */
    public LFUserPersistence getLFUserPersistence() {
        return lfUserPersistence;
    }

    /**
     * Sets the l f user persistence.
     *
     * @param lfUserPersistence the l f user persistence
     */
    public void setLFUserPersistence(LFUserPersistence lfUserPersistence) {
        this.lfUserPersistence = lfUserPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.arcusys.learn.persistence.liferay.model.LFLessonLimit",
            lfLessonLimitLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.arcusys.learn.persistence.liferay.model.LFLessonLimit");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return LFLessonLimit.class;
    }

    protected String getModelClassName() {
        return LFLessonLimit.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = lfLessonLimitPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}

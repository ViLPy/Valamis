package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsActivityProfileModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAnswerPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateSitePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConfigPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFFileStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageCommentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageVotePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPlayerScopeRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionCategoryPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFResourcePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRolePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActorPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsActivityProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAgentProfilePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsAttachmentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextActivitiesPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsDocumentPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsEndpointPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsResultPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementRefPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsSubStatementPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanManifestActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFUserPersistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the l f tincan lrs activity profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsActivityProfilePersistence
 * @see LFTincanLrsActivityProfileUtil
 * @generated
 */
public class LFTincanLrsActivityProfilePersistenceImpl
    extends BasePersistenceImpl<LFTincanLrsActivityProfile>
    implements LFTincanLrsActivityProfilePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsActivityProfileUtil} to access the l f tincan lrs activity profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsActivityProfileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByActivityIdAndProfileId",
            new String[] { String.class.getName(), String.class.getName() },
            LFTincanLrsActivityProfileModelImpl.ACTIVITYID_COLUMN_BITMASK |
            LFTincanLrsActivityProfileModelImpl.PROFILEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityIdAndProfileId",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSACTIVITYPROFILE = "SELECT lfTincanLrsActivityProfile FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile";
    private static final String _SQL_SELECT_LFTINCANLRSACTIVITYPROFILE_WHERE = "SELECT lfTincanLrsActivityProfile FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSACTIVITYPROFILE = "SELECT COUNT(lfTincanLrsActivityProfile) FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile";
    private static final String _SQL_COUNT_LFTINCANLRSACTIVITYPROFILE_WHERE = "SELECT COUNT(lfTincanLrsActivityProfile) FROM LFTincanLrsActivityProfile lfTincanLrsActivityProfile WHERE ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1 =
        "lfTincanLrsActivityProfile.activityId IS NULL AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_NULL =
        "lfTincanLrsActivityProfile.activityId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_NULL_2 =
        "lfTincanLrsActivityProfile.activityId IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2 =
        "lfTincanLrsActivityProfile.activityId = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3 =
        "(lfTincanLrsActivityProfile.activityId IS NULL OR lfTincanLrsActivityProfile.activityId = ?) AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1 =
        "lfTincanLrsActivityProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_NULL =
        "lfTincanLrsActivityProfile.profileId IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_NULL_2 =
        "lfTincanLrsActivityProfile.profileId IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2 =
        "lfTincanLrsActivityProfile.profileId = ?";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3 =
        "(lfTincanLrsActivityProfile.profileId IS NULL OR lfTincanLrsActivityProfile.profileId = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsActivityProfile.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsActivityProfile exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsActivityProfile exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsActivityProfilePersistenceImpl.class);
    private static LFTincanLrsActivityProfile _nullLFTincanLrsActivityProfile = new LFTincanLrsActivityProfileImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsActivityProfile> toCacheModel() {
                return _nullLFTincanLrsActivityProfileCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsActivityProfile> _nullLFTincanLrsActivityProfileCacheModel =
        new CacheModel<LFTincanLrsActivityProfile>() {
            public LFTincanLrsActivityProfile toEntityModel() {
                return _nullLFTincanLrsActivityProfile;
            }
        };

    @BeanReference(type = LFActivityPersistence.class)
    protected LFActivityPersistence lfActivityPersistence;
    @BeanReference(type = LFActivityDataMapPersistence.class)
    protected LFActivityDataMapPersistence lfActivityDataMapPersistence;
    @BeanReference(type = LFActivityStatePersistence.class)
    protected LFActivityStatePersistence lfActivityStatePersistence;
    @BeanReference(type = LFActivityStateNodePersistence.class)
    protected LFActivityStateNodePersistence lfActivityStateNodePersistence;
    @BeanReference(type = LFActivityStateTreePersistence.class)
    protected LFActivityStateTreePersistence lfActivityStateTreePersistence;
    @BeanReference(type = LFAnswerPersistence.class)
    protected LFAnswerPersistence lfAnswerPersistence;
    @BeanReference(type = LFAttemptPersistence.class)
    protected LFAttemptPersistence lfAttemptPersistence;
    @BeanReference(type = LFAttemptDataPersistence.class)
    protected LFAttemptDataPersistence lfAttemptDataPersistence;
    @BeanReference(type = LFBigDecimalPersistence.class)
    protected LFBigDecimalPersistence lfBigDecimalPersistence;
    @BeanReference(type = LFCertificatePersistence.class)
    protected LFCertificatePersistence lfCertificatePersistence;
    @BeanReference(type = LFCertificateSitePersistence.class)
    protected LFCertificateSitePersistence lfCertificateSitePersistence;
    @BeanReference(type = LFCertificateUserPersistence.class)
    protected LFCertificateUserPersistence lfCertificateUserPersistence;
    @BeanReference(type = LFChildrenSelectionPersistence.class)
    protected LFChildrenSelectionPersistence lfChildrenSelectionPersistence;
    @BeanReference(type = LFConditionRulePersistence.class)
    protected LFConditionRulePersistence lfConditionRulePersistence;
    @BeanReference(type = LFConfigPersistence.class)
    protected LFConfigPersistence lfConfigPersistence;
    @BeanReference(type = LFCoursePersistence.class)
    protected LFCoursePersistence lfCoursePersistence;
    @BeanReference(type = LFFileStoragePersistence.class)
    protected LFFileStoragePersistence lfFileStoragePersistence;
    @BeanReference(type = LFGlobalObjectiveStatePersistence.class)
    protected LFGlobalObjectiveStatePersistence lfGlobalObjectiveStatePersistence;
    @BeanReference(type = LFObjectivePersistence.class)
    protected LFObjectivePersistence lfObjectivePersistence;
    @BeanReference(type = LFObjectiveMapPersistence.class)
    protected LFObjectiveMapPersistence lfObjectiveMapPersistence;
    @BeanReference(type = LFObjectiveStatePersistence.class)
    protected LFObjectiveStatePersistence lfObjectiveStatePersistence;
    @BeanReference(type = LFPackagePersistence.class)
    protected LFPackagePersistence lfPackagePersistence;
    @BeanReference(type = LFPackageCommentPersistence.class)
    protected LFPackageCommentPersistence lfPackageCommentPersistence;
    @BeanReference(type = LFPackageScopeRulePersistence.class)
    protected LFPackageScopeRulePersistence lfPackageScopeRulePersistence;
    @BeanReference(type = LFPackageVotePersistence.class)
    protected LFPackageVotePersistence lfPackageVotePersistence;
    @BeanReference(type = LFPlayerScopeRulePersistence.class)
    protected LFPlayerScopeRulePersistence lfPlayerScopeRulePersistence;
    @BeanReference(type = LFQuestionPersistence.class)
    protected LFQuestionPersistence lfQuestionPersistence;
    @BeanReference(type = LFQuestionCategoryPersistence.class)
    protected LFQuestionCategoryPersistence lfQuestionCategoryPersistence;
    @BeanReference(type = LFQuizPersistence.class)
    protected LFQuizPersistence lfQuizPersistence;
    @BeanReference(type = LFQuizQuestionPersistence.class)
    protected LFQuizQuestionPersistence lfQuizQuestionPersistence;
    @BeanReference(type = LFQuizQuestionCategoryPersistence.class)
    protected LFQuizQuestionCategoryPersistence lfQuizQuestionCategoryPersistence;
    @BeanReference(type = LFResourcePersistence.class)
    protected LFResourcePersistence lfResourcePersistence;
    @BeanReference(type = LFRolePersistence.class)
    protected LFRolePersistence lfRolePersistence;
    @BeanReference(type = LFRollupContributionPersistence.class)
    protected LFRollupContributionPersistence lfRollupContributionPersistence;
    @BeanReference(type = LFRollupRulePersistence.class)
    protected LFRollupRulePersistence lfRollupRulePersistence;
    @BeanReference(type = LFRuleConditionPersistence.class)
    protected LFRuleConditionPersistence lfRuleConditionPersistence;
    @BeanReference(type = LFSequencingPersistence.class)
    protected LFSequencingPersistence lfSequencingPersistence;
    @BeanReference(type = LFSequencingPermissionsPersistence.class)
    protected LFSequencingPermissionsPersistence lfSequencingPermissionsPersistence;
    @BeanReference(type = LFSequencingTrackingPersistence.class)
    protected LFSequencingTrackingPersistence lfSequencingTrackingPersistence;
    @BeanReference(type = LFSocialPackagePersistence.class)
    protected LFSocialPackagePersistence lfSocialPackagePersistence;
    @BeanReference(type = LFSocialPackageTagPersistence.class)
    protected LFSocialPackageTagPersistence lfSocialPackageTagPersistence;
    @BeanReference(type = LFTincanActivityPersistence.class)
    protected LFTincanActivityPersistence lfTincanActivityPersistence;
    @BeanReference(type = LFTincanActorPersistence.class)
    protected LFTincanActorPersistence lfTincanActorPersistence;
    @BeanReference(type = LFTincanLrsActivityProfilePersistence.class)
    protected LFTincanLrsActivityProfilePersistence lfTincanLrsActivityProfilePersistence;
    @BeanReference(type = LFTincanLrsAgentProfilePersistence.class)
    protected LFTincanLrsAgentProfilePersistence lfTincanLrsAgentProfilePersistence;
    @BeanReference(type = LFTincanLrsAttachmentPersistence.class)
    protected LFTincanLrsAttachmentPersistence lfTincanLrsAttachmentPersistence;
    @BeanReference(type = LFTincanLrsContextPersistence.class)
    protected LFTincanLrsContextPersistence lfTincanLrsContextPersistence;
    @BeanReference(type = LFTincanLrsContextActivitiesPersistence.class)
    protected LFTincanLrsContextActivitiesPersistence lfTincanLrsContextActivitiesPersistence;
    @BeanReference(type = LFTincanLrsDocumentPersistence.class)
    protected LFTincanLrsDocumentPersistence lfTincanLrsDocumentPersistence;
    @BeanReference(type = LFTincanLrsEndpointPersistence.class)
    protected LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence;
    @BeanReference(type = LFTincanLrsResultPersistence.class)
    protected LFTincanLrsResultPersistence lfTincanLrsResultPersistence;
    @BeanReference(type = LFTincanLrsStatePersistence.class)
    protected LFTincanLrsStatePersistence lfTincanLrsStatePersistence;
    @BeanReference(type = LFTincanLrsStatementPersistence.class)
    protected LFTincanLrsStatementPersistence lfTincanLrsStatementPersistence;
    @BeanReference(type = LFTincanLrsStatementRefPersistence.class)
    protected LFTincanLrsStatementRefPersistence lfTincanLrsStatementRefPersistence;
    @BeanReference(type = LFTincanLrsSubStatementPersistence.class)
    protected LFTincanLrsSubStatementPersistence lfTincanLrsSubStatementPersistence;
    @BeanReference(type = LFTincanManifestActivityPersistence.class)
    protected LFTincanManifestActivityPersistence lfTincanManifestActivityPersistence;
    @BeanReference(type = LFTincanPackagePersistence.class)
    protected LFTincanPackagePersistence lfTincanPackagePersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f tincan lrs activity profile in the entity cache if it is enabled.
     *
     * @param lfTincanLrsActivityProfile the l f tincan lrs activity profile
     */
    public void cacheResult(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        EntityCacheUtil.putResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            lfTincanLrsActivityProfile.getPrimaryKey(),
            lfTincanLrsActivityProfile);

        boolean noNullsInACTIVITYIDANDPROFILEID = true;

        if (noNullsInACTIVITYIDANDPROFILEID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                new Object[] {
                    lfTincanLrsActivityProfile.getActivityId(),
                    
                lfTincanLrsActivityProfile.getProfileId()
                }, lfTincanLrsActivityProfile);
        }

        lfTincanLrsActivityProfile.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs activity profiles in the entity cache if it is enabled.
     *
     * @param lfTincanLrsActivityProfiles the l f tincan lrs activity profiles
     */
    public void cacheResult(
        List<LFTincanLrsActivityProfile> lfTincanLrsActivityProfiles) {
        for (LFTincanLrsActivityProfile lfTincanLrsActivityProfile : lfTincanLrsActivityProfiles) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsActivityProfileImpl.class,
                        lfTincanLrsActivityProfile.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsActivityProfile);
            } else {
                lfTincanLrsActivityProfile.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs activity profiles.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsActivityProfileImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsActivityProfileImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs activity profile.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        EntityCacheUtil.removeResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            lfTincanLrsActivityProfile.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanLrsActivityProfile);
    }

    @Override
    public void clearCache(
        List<LFTincanLrsActivityProfile> lfTincanLrsActivityProfiles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsActivityProfile lfTincanLrsActivityProfile : lfTincanLrsActivityProfiles) {
            EntityCacheUtil.removeResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsActivityProfileImpl.class,
                lfTincanLrsActivityProfile.getPrimaryKey());

            clearUniqueFindersCache(lfTincanLrsActivityProfile);
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        boolean noNullsInACTIVITYIDANDPROFILEID = true;

        if (noNullsInACTIVITYIDANDPROFILEID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                new Object[] {
                    lfTincanLrsActivityProfile.getActivityId(),
                    
                lfTincanLrsActivityProfile.getProfileId()
                });
        }
    }

    /**
     * Creates a new l f tincan lrs activity profile with the primary key. Does not add the l f tincan lrs activity profile to the database.
     *
     * @param id the primary key for the new l f tincan lrs activity profile
     * @return the new l f tincan lrs activity profile
     */
    public LFTincanLrsActivityProfile create(long id) {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = new LFTincanLrsActivityProfileImpl();

        lfTincanLrsActivityProfile.setNew(true);
        lfTincanLrsActivityProfile.setPrimaryKey(id);

        return lfTincanLrsActivityProfile;
    }

    /**
     * Removes the l f tincan lrs activity profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile remove(long id)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs activity profile with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsActivityProfile lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) session.get(LFTincanLrsActivityProfileImpl.class,
                    primaryKey);

            if (lfTincanLrsActivityProfile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsActivityProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsActivityProfile);
        } catch (NoSuchLFTincanLrsActivityProfileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsActivityProfile removeImpl(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile)
        throws SystemException {
        lfTincanLrsActivityProfile = toUnwrappedModel(lfTincanLrsActivityProfile);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsActivityProfile);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsActivityProfile);

        return lfTincanLrsActivityProfile;
    }

    @Override
    public LFTincanLrsActivityProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile lfTincanLrsActivityProfile,
        boolean merge) throws SystemException {
        lfTincanLrsActivityProfile = toUnwrappedModel(lfTincanLrsActivityProfile);

        boolean isNew = lfTincanLrsActivityProfile.isNew();

        LFTincanLrsActivityProfileModelImpl lfTincanLrsActivityProfileModelImpl = (LFTincanLrsActivityProfileModelImpl) lfTincanLrsActivityProfile;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsActivityProfile, merge);

            lfTincanLrsActivityProfile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew ||
                !LFTincanLrsActivityProfileModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsActivityProfileImpl.class,
            lfTincanLrsActivityProfile.getPrimaryKey(),
            lfTincanLrsActivityProfile);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                new Object[] {
                    lfTincanLrsActivityProfile.getActivityId(),
                    
                lfTincanLrsActivityProfile.getProfileId()
                }, lfTincanLrsActivityProfile);
        } else {
            if ((lfTincanLrsActivityProfileModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsActivityProfileModelImpl.getOriginalActivityId(),
                        
                        lfTincanLrsActivityProfileModelImpl.getOriginalProfileId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    new Object[] {
                        lfTincanLrsActivityProfile.getActivityId(),
                        
                    lfTincanLrsActivityProfile.getProfileId()
                    }, lfTincanLrsActivityProfile);
            }
        }

        return lfTincanLrsActivityProfile;
    }

    protected LFTincanLrsActivityProfile toUnwrappedModel(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        if (lfTincanLrsActivityProfile instanceof LFTincanLrsActivityProfileImpl) {
            return lfTincanLrsActivityProfile;
        }

        LFTincanLrsActivityProfileImpl lfTincanLrsActivityProfileImpl = new LFTincanLrsActivityProfileImpl();

        lfTincanLrsActivityProfileImpl.setNew(lfTincanLrsActivityProfile.isNew());
        lfTincanLrsActivityProfileImpl.setPrimaryKey(lfTincanLrsActivityProfile.getPrimaryKey());

        lfTincanLrsActivityProfileImpl.setId(lfTincanLrsActivityProfile.getId());
        lfTincanLrsActivityProfileImpl.setDocumentId(lfTincanLrsActivityProfile.getDocumentId());
        lfTincanLrsActivityProfileImpl.setActivityId(lfTincanLrsActivityProfile.getActivityId());
        lfTincanLrsActivityProfileImpl.setProfileId(lfTincanLrsActivityProfile.getProfileId());

        return lfTincanLrsActivityProfileImpl;
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = fetchByPrimaryKey(id);

        if (lfTincanLrsActivityProfile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsActivityProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsActivityProfile;
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile, or <code>null</code> if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsActivityProfile fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs activity profile with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs activity profile
     * @return the l f tincan lrs activity profile, or <code>null</code> if a l f tincan lrs activity profile with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) EntityCacheUtil.getResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsActivityProfileImpl.class, id);

        if (lfTincanLrsActivityProfile == _nullLFTincanLrsActivityProfile) {
            return null;
        }

        if (lfTincanLrsActivityProfile == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) session.get(LFTincanLrsActivityProfileImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsActivityProfile != null) {
                    cacheResult(lfTincanLrsActivityProfile);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsActivityProfileModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsActivityProfileImpl.class, id,
                        _nullLFTincanLrsActivityProfile);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsActivityProfile;
    }

    /**
     * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the matching l f tincan lrs activity profile
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a matching l f tincan lrs activity profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile findByActivityIdAndProfileId(
        String activityId, String profileId)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = fetchByActivityIdAndProfileId(activityId,
                profileId);

        if (lfTincanLrsActivityProfile == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("activityId=");
            msg.append(activityId);

            msg.append(", profileId=");
            msg.append(profileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanLrsActivityProfileException(msg.toString());
        }

        return lfTincanLrsActivityProfile;
    }

    /**
     * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        String activityId, String profileId) throws SystemException {
        return fetchByActivityIdAndProfileId(activityId, profileId, true);
    }

    /**
     * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        String activityId, String profileId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityId, profileId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanLrsActivityProfile) {
            LFTincanLrsActivityProfile lfTincanLrsActivityProfile = (LFTincanLrsActivityProfile) result;

            if (!Validator.equals(activityId,
                        lfTincanLrsActivityProfile.getActivityId()) ||
                    !Validator.equals(profileId,
                        lfTincanLrsActivityProfile.getProfileId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANLRSACTIVITYPROFILE_WHERE);

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1);
            } else {
                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2);
                }
            }

            if (profileId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1);
            } else {
                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityId != null) {
                    qPos.add(activityId);
                }

                if (profileId != null) {
                    qPos.add(profileId);
                }

                List<LFTincanLrsActivityProfile> list = q.list();

                result = list;

                LFTincanLrsActivityProfile lfTincanLrsActivityProfile = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                        finderArgs, list);
                } else {
                    lfTincanLrsActivityProfile = list.get(0);

                    cacheResult(lfTincanLrsActivityProfile);

                    if ((lfTincanLrsActivityProfile.getActivityId() == null) ||
                            !lfTincanLrsActivityProfile.getActivityId()
                                                           .equals(activityId) ||
                            (lfTincanLrsActivityProfile.getProfileId() == null) ||
                            !lfTincanLrsActivityProfile.getProfileId()
                                                           .equals(profileId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                            finderArgs, lfTincanLrsActivityProfile);
                    }
                }

                return lfTincanLrsActivityProfile;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPROFILEID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFTincanLrsActivityProfile) result;
            }
        }
    }

    /**
     * Returns all the l f tincan lrs activity profiles.
     *
     * @return the l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsActivityProfile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs activity profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs activity profiles
     * @param end the upper bound of the range of l f tincan lrs activity profiles (not inclusive)
     * @return the range of l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsActivityProfile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs activity profiles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs activity profiles
     * @param end the upper bound of the range of l f tincan lrs activity profiles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsActivityProfile> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<LFTincanLrsActivityProfile> list = (List<LFTincanLrsActivityProfile>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSACTIVITYPROFILE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSACTIVITYPROFILE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsActivityProfile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsActivityProfile>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; from the database.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the l f tincan lrs activity profile that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsActivityProfile removeByActivityIdAndProfileId(
        String activityId, String profileId)
        throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile = findByActivityIdAndProfileId(activityId,
                profileId);

        return remove(lfTincanLrsActivityProfile);
    }

    /**
     * Removes all the l f tincan lrs activity profiles from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsActivityProfile lfTincanLrsActivityProfile : findAll()) {
            remove(lfTincanLrsActivityProfile);
        }
    }

    /**
     * Returns the number of l f tincan lrs activity profiles where activityId = &#63; and profileId = &#63;.
     *
     * @param activityId the activity ID
     * @param profileId the profile ID
     * @return the number of matching l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityIdAndProfileId(String activityId, String profileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityId, profileId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANLRSACTIVITYPROFILE_WHERE);

            if (activityId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_1);
            } else {
                if (activityId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_ACTIVITYID_2);
                }
            }

            if (profileId == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_1);
            } else {
                if (profileId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPROFILEID_PROFILEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityId != null) {
                    qPos.add(activityId);
                }

                if (profileId != null) {
                    qPos.add(profileId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPROFILEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs activity profiles.
     *
     * @return the number of l f tincan lrs activity profiles
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSACTIVITYPROFILE);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the l f tincan lrs activity profile persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsActivityProfile>> listenersList = new ArrayList<ModelListener<LFTincanLrsActivityProfile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsActivityProfile>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsActivityProfileImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

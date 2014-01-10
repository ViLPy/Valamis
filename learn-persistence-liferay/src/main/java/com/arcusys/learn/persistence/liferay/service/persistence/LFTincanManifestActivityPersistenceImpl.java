package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityModelImpl;
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
 * The persistence implementation for the l f tincan manifest activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActivityPersistence
 * @see LFTincanManifestActivityUtil
 * @generated
 */
public class LFTincanManifestActivityPersistenceImpl extends BasePersistenceImpl<LFTincanManifestActivity>
    implements LFTincanManifestActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanManifestActivityUtil} to access the l f tincan manifest activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanManifestActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Long.class.getName() },
            LFTincanManifestActivityModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanManifestActivityModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANMANIFESTACTIVITY = "SELECT lfTincanManifestActivity FROM LFTincanManifestActivity lfTincanManifestActivity";
    private static final String _SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE = "SELECT lfTincanManifestActivity FROM LFTincanManifestActivity lfTincanManifestActivity WHERE ";
    private static final String _SQL_COUNT_LFTINCANMANIFESTACTIVITY = "SELECT COUNT(lfTincanManifestActivity) FROM LFTincanManifestActivity lfTincanManifestActivity";
    private static final String _SQL_COUNT_LFTINCANMANIFESTACTIVITY_WHERE = "SELECT COUNT(lfTincanManifestActivity) FROM LFTincanManifestActivity lfTincanManifestActivity WHERE ";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfTincanManifestActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfTincanManifestActivity.packageID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfTincanManifestActivity.packageID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanManifestActivity.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanManifestActivity.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanManifestActivity.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanManifestActivity.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanManifestActivity.tincanID IS NULL OR lfTincanManifestActivity.tincanID = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanManifestActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanManifestActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanManifestActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanManifestActivityPersistenceImpl.class);
    private static LFTincanManifestActivity _nullLFTincanManifestActivity = new LFTincanManifestActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanManifestActivity> toCacheModel() {
                return _nullLFTincanManifestActivityCacheModel;
            }
        };

    private static CacheModel<LFTincanManifestActivity> _nullLFTincanManifestActivityCacheModel =
        new CacheModel<LFTincanManifestActivity>() {
            public LFTincanManifestActivity toEntityModel() {
                return _nullLFTincanManifestActivity;
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
     * Caches the l f tincan manifest activity in the entity cache if it is enabled.
     *
     * @param lfTincanManifestActivity the l f tincan manifest activity
     */
    public void cacheResult(LFTincanManifestActivity lfTincanManifestActivity) {
        EntityCacheUtil.putResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            lfTincanManifestActivity.getPrimaryKey(), lfTincanManifestActivity);

        boolean noNullsInTINCANID = true;

        if (noNullsInTINCANID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanManifestActivity.getTincanID() },
                lfTincanManifestActivity);
        }

        lfTincanManifestActivity.resetOriginalValues();
    }

    /**
     * Caches the l f tincan manifest activities in the entity cache if it is enabled.
     *
     * @param lfTincanManifestActivities the l f tincan manifest activities
     */
    public void cacheResult(
        List<LFTincanManifestActivity> lfTincanManifestActivities) {
        for (LFTincanManifestActivity lfTincanManifestActivity : lfTincanManifestActivities) {
            if (EntityCacheUtil.getResult(
                        LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanManifestActivityImpl.class,
                        lfTincanManifestActivity.getPrimaryKey()) == null) {
                cacheResult(lfTincanManifestActivity);
            } else {
                lfTincanManifestActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan manifest activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanManifestActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanManifestActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan manifest activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanManifestActivity lfTincanManifestActivity) {
        EntityCacheUtil.removeResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            lfTincanManifestActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanManifestActivity);
    }

    @Override
    public void clearCache(
        List<LFTincanManifestActivity> lfTincanManifestActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanManifestActivity lfTincanManifestActivity : lfTincanManifestActivities) {
            EntityCacheUtil.removeResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanManifestActivityImpl.class,
                lfTincanManifestActivity.getPrimaryKey());

            clearUniqueFindersCache(lfTincanManifestActivity);
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanManifestActivity lfTincanManifestActivity) {
        boolean noNullsInTINCANID = true;

        if (noNullsInTINCANID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanManifestActivity.getTincanID() });
        }
    }

    /**
     * Creates a new l f tincan manifest activity with the primary key. Does not add the l f tincan manifest activity to the database.
     *
     * @param id the primary key for the new l f tincan manifest activity
     * @return the new l f tincan manifest activity
     */
    public LFTincanManifestActivity create(long id) {
        LFTincanManifestActivity lfTincanManifestActivity = new LFTincanManifestActivityImpl();

        lfTincanManifestActivity.setNew(true);
        lfTincanManifestActivity.setPrimaryKey(id);

        return lfTincanManifestActivity;
    }

    /**
     * Removes the l f tincan manifest activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity remove(long id)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan manifest activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity remove(Serializable primaryKey)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanManifestActivity lfTincanManifestActivity = (LFTincanManifestActivity) session.get(LFTincanManifestActivityImpl.class,
                    primaryKey);

            if (lfTincanManifestActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanManifestActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanManifestActivity);
        } catch (NoSuchLFTincanManifestActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanManifestActivity removeImpl(
        LFTincanManifestActivity lfTincanManifestActivity)
        throws SystemException {
        lfTincanManifestActivity = toUnwrappedModel(lfTincanManifestActivity);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanManifestActivity);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanManifestActivity);

        return lfTincanManifestActivity;
    }

    @Override
    public LFTincanManifestActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity lfTincanManifestActivity,
        boolean merge) throws SystemException {
        lfTincanManifestActivity = toUnwrappedModel(lfTincanManifestActivity);

        boolean isNew = lfTincanManifestActivity.isNew();

        LFTincanManifestActivityModelImpl lfTincanManifestActivityModelImpl = (LFTincanManifestActivityModelImpl) lfTincanManifestActivity;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanManifestActivity, merge);

            lfTincanManifestActivity.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanManifestActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanManifestActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Long.valueOf(   */
                        lfTincanManifestActivityModelImpl.getOriginalPackageID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] {
                        /* Long.valueOf( */
                        lfTincanManifestActivityModelImpl.getPackageID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            lfTincanManifestActivity.getPrimaryKey(), lfTincanManifestActivity);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                new Object[] { lfTincanManifestActivity.getTincanID() },
                lfTincanManifestActivity);
        } else {
            if ((lfTincanManifestActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanManifestActivityModelImpl.getOriginalTincanID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                    new Object[] { lfTincanManifestActivity.getTincanID() },
                    lfTincanManifestActivity);
            }
        }

        return lfTincanManifestActivity;
    }

    protected LFTincanManifestActivity toUnwrappedModel(
        LFTincanManifestActivity lfTincanManifestActivity) {
        if (lfTincanManifestActivity instanceof LFTincanManifestActivityImpl) {
            return lfTincanManifestActivity;
        }

        LFTincanManifestActivityImpl lfTincanManifestActivityImpl = new LFTincanManifestActivityImpl();

        lfTincanManifestActivityImpl.setNew(lfTincanManifestActivity.isNew());
        lfTincanManifestActivityImpl.setPrimaryKey(lfTincanManifestActivity.getPrimaryKey());

        lfTincanManifestActivityImpl.setId(lfTincanManifestActivity.getId());
        lfTincanManifestActivityImpl.setTincanID(lfTincanManifestActivity.getTincanID());
        lfTincanManifestActivityImpl.setPackageID(lfTincanManifestActivity.getPackageID());
        lfTincanManifestActivityImpl.setActivityType(lfTincanManifestActivity.getActivityType());
        lfTincanManifestActivityImpl.setName(lfTincanManifestActivity.getName());
        lfTincanManifestActivityImpl.setDescription(lfTincanManifestActivity.getDescription());
        lfTincanManifestActivityImpl.setLaunch(lfTincanManifestActivity.getLaunch());
        lfTincanManifestActivityImpl.setResource(lfTincanManifestActivity.getResource());

        return lfTincanManifestActivityImpl;
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException} if it could not be found.
     *
     * @param id the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity findByPrimaryKey(long id)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByPrimaryKey(id);

        if (lfTincanManifestActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanManifestActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanManifestActivity;
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity, or <code>null</code> if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity, or <code>null</code> if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = (LFTincanManifestActivity) EntityCacheUtil.getResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanManifestActivityImpl.class, id);

        if (lfTincanManifestActivity == _nullLFTincanManifestActivity) {
            return null;
        }

        if (lfTincanManifestActivity == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanManifestActivity = (LFTincanManifestActivity) session.get(LFTincanManifestActivityImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanManifestActivity != null) {
                    cacheResult(lfTincanManifestActivity);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanManifestActivityImpl.class, id,
                        _nullLFTincanManifestActivity);
                }

                closeSession(session);
            }
        }

        return lfTincanManifestActivity;
    }

    /**
     * Returns all the l f tincan manifest activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanManifestActivity> findByPackageID(Long packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan manifest activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @return the range of matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanManifestActivity> findByPackageID(Long packageID,
        int start, int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan manifest activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanManifestActivity> findByPackageID(Long packageID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID, start, end, orderByComparator };
        }

        List<LFTincanManifestActivity> list = (List<LFTincanManifestActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanManifestActivity lfTincanManifestActivity : list) {
                if (!Validator.equals(packageID,
                            lfTincanManifestActivity.getPackageID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.longValue());
                }

                list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity findByPackageID_First(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfTincanManifestActivity != null) {
            return lfTincanManifestActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanManifestActivityException(msg.toString());
    }

    /**
     * Returns the first l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity fetchByPackageID_First(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanManifestActivity> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity findByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfTincanManifestActivity != null) {
            return lfTincanManifestActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanManifestActivityException(msg.toString());
    }

    /**
     * Returns the last l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity fetchByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        List<LFTincanManifestActivity> list = findByPackageID(packageID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan manifest activities before and after the current l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f tincan manifest activity
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity[] findByPackageID_PrevAndNext(long id,
        Long packageID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanManifestActivity[] array = new LFTincanManifestActivityImpl[3];

            array[0] = getByPackageID_PrevAndNext(session,
                    lfTincanManifestActivity, packageID, orderByComparator, true);

            array[1] = lfTincanManifestActivity;

            array[2] = getByPackageID_PrevAndNext(session,
                    lfTincanManifestActivity, packageID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanManifestActivity getByPackageID_PrevAndNext(
        Session session, LFTincanManifestActivity lfTincanManifestActivity,
        Long packageID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanManifestActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanManifestActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns the l f tincan manifest activity where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity findByTincanID(String tincanID)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByTincanID(tincanID);

        if (lfTincanManifestActivity == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanManifestActivityException(msg.toString());
        }

        return lfTincanManifestActivity;
    }

    /**
     * Returns the l f tincan manifest activity where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan manifest activity where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanManifestActivity) {
            LFTincanManifestActivity lfTincanManifestActivity = (LFTincanManifestActivity) result;

            if (!Validator.equals(tincanID,
                        lfTincanManifestActivity.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE);

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else {
                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (tincanID != null) {
                    qPos.add(tincanID);
                }

                List<LFTincanManifestActivity> list = q.list();

                result = list;

                LFTincanManifestActivity lfTincanManifestActivity = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    lfTincanManifestActivity = list.get(0);

                    cacheResult(lfTincanManifestActivity);

                    if ((lfTincanManifestActivity.getTincanID() == null) ||
                            !lfTincanManifestActivity.getTincanID()
                                                         .equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanManifestActivity);
                    }
                }

                return lfTincanManifestActivity;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFTincanManifestActivity) result;
            }
        }
    }

    /**
     * Returns all the l f tincan manifest activities.
     *
     * @return the l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanManifestActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan manifest activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @return the range of l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanManifestActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan manifest activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanManifestActivity> findAll(int start, int end,
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

        List<LFTincanManifestActivity> list = (List<LFTincanManifestActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANMANIFESTACTIVITY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
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
     * Removes all the l f tincan manifest activities where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByPackageID(Long packageID) throws SystemException {
        for (LFTincanManifestActivity lfTincanManifestActivity : findByPackageID(
                packageID)) {
            remove(lfTincanManifestActivity);
        }
    }

    /**
     * Removes the l f tincan manifest activity where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan manifest activity that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanManifestActivity removeByTincanID(String tincanID)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = findByTincanID(tincanID);

        return remove(lfTincanManifestActivity);
    }

    /**
     * Removes all the l f tincan manifest activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanManifestActivity lfTincanManifestActivity : findAll()) {
            remove(lfTincanManifestActivity);
        }
    }

    /**
     * Returns the number of l f tincan manifest activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public int countByPackageID(Long packageID) throws SystemException {
        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANMANIFESTACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.longValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan manifest activities where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public int countByTincanID(String tincanID) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TINCANID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANMANIFESTACTIVITY_WHERE);

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else {
                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (tincanID != null) {
                    qPos.add(tincanID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan manifest activities.
     *
     * @return the number of l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANMANIFESTACTIVITY);

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
     * Initializes the l f tincan manifest activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanManifestActivity>> listenersList = new ArrayList<ModelListener<LFTincanManifestActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanManifestActivity>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanManifestActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

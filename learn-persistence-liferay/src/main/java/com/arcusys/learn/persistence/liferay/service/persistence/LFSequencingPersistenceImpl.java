package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException;
import com.arcusys.learn.persistence.liferay.model.LFSequencing;
import com.arcusys.learn.persistence.liferay.model.impl.LFSequencingImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSequencingModelImpl;
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
 * The persistence implementation for the l f sequencing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingPersistence
 * @see LFSequencingUtil
 * @generated
 */
public class LFSequencingPersistenceImpl extends BasePersistenceImpl<LFSequencing>
    implements LFSequencingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSequencingUtil} to access the l f sequencing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSequencingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID = new FinderPath(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingModelImpl.FINDER_CACHE_ENABLED, LFSequencingImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByActivityIDAndPackageID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFSequencingModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFSequencingModelImpl.ACTIVITYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYIDANDPACKAGEID = new FinderPath(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityIDAndPackageID",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingModelImpl.FINDER_CACHE_ENABLED, LFSequencingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingModelImpl.FINDER_CACHE_ENABLED, LFSequencingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFSEQUENCING = "SELECT lfSequencing FROM LFSequencing lfSequencing";
    private static final String _SQL_SELECT_LFSEQUENCING_WHERE = "SELECT lfSequencing FROM LFSequencing lfSequencing WHERE ";
    private static final String _SQL_COUNT_LFSEQUENCING = "SELECT COUNT(lfSequencing) FROM LFSequencing lfSequencing";
    private static final String _SQL_COUNT_LFSEQUENCING_WHERE = "SELECT COUNT(lfSequencing) FROM LFSequencing lfSequencing WHERE ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_NULL =
        "lfSequencing.packageID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_NULL_2 =
        "lfSequencing.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_2 =
        "lfSequencing.packageID = ? AND ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_1 =
        "lfSequencing.activityID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_NULL =
        "lfSequencing.activityID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_NULL_2 =
        "lfSequencing.activityID IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_2 =
        "lfSequencing.activityID = ?";
    private static final String _FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_3 =
        "(lfSequencing.activityID IS NULL OR lfSequencing.activityID = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSequencing.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSequencing exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSequencing exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSequencingPersistenceImpl.class);
    private static LFSequencing _nullLFSequencing = new LFSequencingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSequencing> toCacheModel() {
                return _nullLFSequencingCacheModel;
            }
        };

    private static CacheModel<LFSequencing> _nullLFSequencingCacheModel = new CacheModel<LFSequencing>() {
            public LFSequencing toEntityModel() {
                return _nullLFSequencing;
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
     * Caches the l f sequencing in the entity cache if it is enabled.
     *
     * @param lfSequencing the l f sequencing
     */
    public void cacheResult(LFSequencing lfSequencing) {
        EntityCacheUtil.putResult(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingImpl.class, lfSequencing.getPrimaryKey(), lfSequencing);

        boolean noNullsInACTIVITYIDANDPACKAGEID = true;

        if (lfSequencing.getPackageID() == null) {
            noNullsInACTIVITYIDANDPACKAGEID = false;
        }

        if (noNullsInACTIVITYIDANDPACKAGEID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                new Object[] {
                    Integer.valueOf(lfSequencing.getPackageID()),
                    
                lfSequencing.getActivityID()
                }, lfSequencing);
        }

        lfSequencing.resetOriginalValues();
    }

    /**
     * Caches the l f sequencings in the entity cache if it is enabled.
     *
     * @param lfSequencings the l f sequencings
     */
    public void cacheResult(List<LFSequencing> lfSequencings) {
        for (LFSequencing lfSequencing : lfSequencings) {
            if (EntityCacheUtil.getResult(
                        LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
                        LFSequencingImpl.class, lfSequencing.getPrimaryKey()) == null) {
                cacheResult(lfSequencing);
            } else {
                lfSequencing.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f sequencings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSequencingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSequencingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f sequencing.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSequencing lfSequencing) {
        EntityCacheUtil.removeResult(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingImpl.class, lfSequencing.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfSequencing);
    }

    @Override
    public void clearCache(List<LFSequencing> lfSequencings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSequencing lfSequencing : lfSequencings) {
            EntityCacheUtil.removeResult(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
                LFSequencingImpl.class, lfSequencing.getPrimaryKey());

            clearUniqueFindersCache(lfSequencing);
        }
    }

    protected void clearUniqueFindersCache(LFSequencing lfSequencing) {
        boolean noNullsInACTIVITYIDANDPACKAGEID = true;

        if (lfSequencing.getPackageID() == null) {
            noNullsInACTIVITYIDANDPACKAGEID = false;
        }

        if (noNullsInACTIVITYIDANDPACKAGEID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                new Object[] {
                    Integer.valueOf(lfSequencing.getPackageID()),
                    
                lfSequencing.getActivityID()
                });
        }
    }

    /**
     * Creates a new l f sequencing with the primary key. Does not add the l f sequencing to the database.
     *
     * @param id the primary key for the new l f sequencing
     * @return the new l f sequencing
     */
    public LFSequencing create(long id) {
        LFSequencing lfSequencing = new LFSequencingImpl();

        lfSequencing.setNew(true);
        lfSequencing.setPrimaryKey(id);

        return lfSequencing;
    }

    /**
     * Removes the l f sequencing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f sequencing
     * @return the l f sequencing that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing remove(long id)
        throws NoSuchLFSequencingException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f sequencing with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f sequencing
     * @return the l f sequencing that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSequencing remove(Serializable primaryKey)
        throws NoSuchLFSequencingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSequencing lfSequencing = (LFSequencing) session.get(LFSequencingImpl.class,
                    primaryKey);

            if (lfSequencing == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSequencingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSequencing);
        } catch (NoSuchLFSequencingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSequencing removeImpl(LFSequencing lfSequencing)
        throws SystemException {
        lfSequencing = toUnwrappedModel(lfSequencing);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfSequencing);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfSequencing);

        return lfSequencing;
    }

    @Override
    public LFSequencing updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing,
        boolean merge) throws SystemException {
        lfSequencing = toUnwrappedModel(lfSequencing);

        boolean isNew = lfSequencing.isNew();

        LFSequencingModelImpl lfSequencingModelImpl = (LFSequencingModelImpl) lfSequencing;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfSequencing, merge);

            lfSequencing.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSequencingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingImpl.class, lfSequencing.getPrimaryKey(), lfSequencing);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                new Object[] {
                    /*Integer.valueOf( */
                lfSequencing.getPackageID(),
                    
                lfSequencing.getActivityID()
                }, lfSequencing);
        } else {
            if ((lfSequencingModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Integer.valueOf( */
                        lfSequencingModelImpl.getOriginalPackageID(),
                        
                        lfSequencingModelImpl.getOriginalActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPACKAGEID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                    new Object[] {
                        /*        Integer.valueOf( */
                    lfSequencing.getPackageID(),
                        
                    lfSequencing.getActivityID()
                    }, lfSequencing);
            }
        }

        return lfSequencing;
    }

    protected LFSequencing toUnwrappedModel(LFSequencing lfSequencing) {
        if (lfSequencing instanceof LFSequencingImpl) {
            return lfSequencing;
        }

        LFSequencingImpl lfSequencingImpl = new LFSequencingImpl();

        lfSequencingImpl.setNew(lfSequencing.isNew());
        lfSequencingImpl.setPrimaryKey(lfSequencing.getPrimaryKey());

        lfSequencingImpl.setId(lfSequencing.getId());
        lfSequencingImpl.setPackageID(lfSequencing.getPackageID());
        lfSequencingImpl.setActivityID(lfSequencing.getActivityID());
        lfSequencingImpl.setSharedId(lfSequencing.getSharedId());
        lfSequencingImpl.setSharedSequencingIdReference(lfSequencing.getSharedSequencingIdReference());
        lfSequencingImpl.setOnlyCurrentAttemptObjectiveProgressForChildren(lfSequencing.isOnlyCurrentAttemptObjectiveProgressForChildren());
        lfSequencingImpl.setOnlyCurrentAttemptAttemptProgressForChildren(lfSequencing.isOnlyCurrentAttemptAttemptProgressForChildren());
        lfSequencingImpl.setAttemptLimit(lfSequencing.getAttemptLimit());
        lfSequencingImpl.setDurationLimitInMilliseconds(lfSequencing.getDurationLimitInMilliseconds());
        lfSequencingImpl.setRollupContributionID(lfSequencing.getRollupContributionID());
        lfSequencingImpl.setPreventChildrenActivation(lfSequencing.isPreventChildrenActivation());
        lfSequencingImpl.setConstrainChoice(lfSequencing.isConstrainChoice());

        return lfSequencingImpl;
    }

    /**
     * Returns the l f sequencing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f sequencing
     * @return the l f sequencing
     * @throws com.liferay.portal.NoSuchModelException if a l f sequencing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSequencing findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f sequencing with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException} if it could not be found.
     *
     * @param id the primary key of the l f sequencing
     * @return the l f sequencing
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing findByPrimaryKey(long id)
        throws NoSuchLFSequencingException, SystemException {
        LFSequencing lfSequencing = fetchByPrimaryKey(id);

        if (lfSequencing == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFSequencingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfSequencing;
    }

    /**
     * Returns the l f sequencing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f sequencing
     * @return the l f sequencing, or <code>null</code> if a l f sequencing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSequencing fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f sequencing with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f sequencing
     * @return the l f sequencing, or <code>null</code> if a l f sequencing with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing fetchByPrimaryKey(long id) throws SystemException {
        LFSequencing lfSequencing = (LFSequencing) EntityCacheUtil.getResult(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
                LFSequencingImpl.class, id);

        if (lfSequencing == _nullLFSequencing) {
            return null;
        }

        if (lfSequencing == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfSequencing = (LFSequencing) session.get(LFSequencingImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfSequencing != null) {
                    cacheResult(lfSequencing);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFSequencingModelImpl.ENTITY_CACHE_ENABLED,
                        LFSequencingImpl.class, id, _nullLFSequencing);
                }

                closeSession(session);
            }
        }

        return lfSequencing;
    }

    /**
     * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException} if it could not be found.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @return the matching l f sequencing
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a matching l f sequencing could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing findByActivityIDAndPackageID(Integer packageID,
        String activityID) throws NoSuchLFSequencingException, SystemException {
        LFSequencing lfSequencing = fetchByActivityIDAndPackageID(packageID,
                activityID);

        if (lfSequencing == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("packageID=");
            msg.append(packageID);

            msg.append(", activityID=");
            msg.append(activityID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFSequencingException(msg.toString());
        }

        return lfSequencing;
    }

    /**
     * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @return the matching l f sequencing, or <code>null</code> if a matching l f sequencing could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing fetchByActivityIDAndPackageID(Integer packageID,
        String activityID) throws SystemException {
        return fetchByActivityIDAndPackageID(packageID, activityID, true);
    }

    /**
     * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f sequencing, or <code>null</code> if a matching l f sequencing could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing fetchByActivityIDAndPackageID(Integer packageID,
        String activityID, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { packageID, activityID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                    finderArgs, this);
        }

        if (result instanceof LFSequencing) {
            LFSequencing lfSequencing = (LFSequencing) result;

            if (!Validator.equals(packageID, lfSequencing.getPackageID()) ||
                    !Validator.equals(activityID, lfSequencing.getActivityID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFSEQUENCING_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_2);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_1);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (activityID != null) {
                    qPos.add(activityID);
                }

                List<LFSequencing> list = q.list();

                result = list;

                LFSequencing lfSequencing = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                        finderArgs, list);
                } else {
                    lfSequencing = list.get(0);

                    cacheResult(lfSequencing);

                    if ((lfSequencing.getPackageID() != packageID) ||
                            (lfSequencing.getActivityID() == null) ||
                            !lfSequencing.getActivityID().equals(activityID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                            finderArgs, lfSequencing);
                    }
                }

                return lfSequencing;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ACTIVITYIDANDPACKAGEID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFSequencing) result;
            }
        }
    }

    /**
     * Returns all the l f sequencings.
     *
     * @return the l f sequencings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencing> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f sequencings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f sequencings
     * @param end the upper bound of the range of l f sequencings (not inclusive)
     * @return the range of l f sequencings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencing> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f sequencings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f sequencings
     * @param end the upper bound of the range of l f sequencings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f sequencings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencing> findAll(int start, int end,
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

        List<LFSequencing> list = (List<LFSequencing>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSEQUENCING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSEQUENCING;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFSequencing>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFSequencing>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes the l f sequencing where packageID = &#63; and activityID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @return the l f sequencing that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFSequencing removeByActivityIDAndPackageID(Integer packageID,
        String activityID) throws NoSuchLFSequencingException, SystemException {
        LFSequencing lfSequencing = findByActivityIDAndPackageID(packageID,
                activityID);

        return remove(lfSequencing);
    }

    /**
     * Removes all the l f sequencings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFSequencing lfSequencing : findAll()) {
            remove(lfSequencing);
        }
    }

    /**
     * Returns the number of l f sequencings where packageID = &#63; and activityID = &#63;.
     *
     * @param packageID the package i d
     * @param activityID the activity i d
     * @return the number of matching l f sequencings
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityIDAndPackageID(Integer packageID,
        String activityID) throws SystemException {
        Object[] finderArgs = new Object[] { packageID, activityID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPACKAGEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFSEQUENCING_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_PACKAGEID_2);
            }

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_1);
            } else {
                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYIDANDPACKAGEID_ACTIVITYID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (activityID != null) {
                    qPos.add(activityID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYIDANDPACKAGEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f sequencings.
     *
     * @return the number of l f sequencings
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFSEQUENCING);

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
     * Initializes the l f sequencing persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSequencing")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSequencing>> listenersList = new ArrayList<ModelListener<LFSequencing>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSequencing>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSequencingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

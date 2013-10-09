package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException;
import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl;
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
import com.arcusys.learn.persistence.liferay.service.persistence.LFSettingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsEndpointPersistence;
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
import com.liferay.portal.kernel.util.ArrayUtil;
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
 * The persistence implementation for the l f tincan package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackagePersistence
 * @see LFTincanPackageUtil
 * @generated
 */
public class LFTincanPackagePersistenceImpl extends BasePersistenceImpl<LFTincanPackage>
    implements LFTincanPackagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanPackageUtil} to access the l f tincan package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanPackageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_REFID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByRefID", new String[] { Long.class.getName() },
            LFTincanPackageModelImpl.ASSETREFID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REFID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRefID",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByInstance",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstance",
            new String[] { Integer.class.getName() },
            LFTincanPackageModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_INSTANCE = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstance",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByInstance",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCourseID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseID",
            new String[] { Integer.class.getName() },
            LFTincanPackageModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANPACKAGE = "SELECT lfTincanPackage FROM LFTincanPackage lfTincanPackage";
    private static final String _SQL_SELECT_LFTINCANPACKAGE_WHERE = "SELECT lfTincanPackage FROM LFTincanPackage lfTincanPackage WHERE ";
    private static final String _SQL_COUNT_LFTINCANPACKAGE = "SELECT COUNT(lfTincanPackage) FROM LFTincanPackage lfTincanPackage";
    private static final String _SQL_COUNT_LFTINCANPACKAGE_WHERE = "SELECT COUNT(lfTincanPackage) FROM LFTincanPackage lfTincanPackage WHERE ";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_NULL = "lfTincanPackage.assetRefID IS NULL";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_NULL_2 = "lfTincanPackage.assetRefID IS NULL ";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_2 = "lfTincanPackage.assetRefID = ?";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_NULL = "lfTincanPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_NULL_2 = "lfTincanPackage.courseID IS NULL ";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_2 = "lfTincanPackage.courseID = ?";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2) + ")";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_INSTANCE_COURSEID_2) + ")";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lfTincanPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lfTincanPackage.courseID IS NULL ";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lfTincanPackage.courseID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanPackage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanPackage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanPackage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanPackagePersistenceImpl.class);
    private static LFTincanPackage _nullLFTincanPackage = new LFTincanPackageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanPackage> toCacheModel() {
                return _nullLFTincanPackageCacheModel;
            }
        };

    private static CacheModel<LFTincanPackage> _nullLFTincanPackageCacheModel = new CacheModel<LFTincanPackage>() {
            public LFTincanPackage toEntityModel() {
                return _nullLFTincanPackage;
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
    @BeanReference(type = LFSettingPersistence.class)
    protected LFSettingPersistence lfSettingPersistence;
    @BeanReference(type = LFSocialPackagePersistence.class)
    protected LFSocialPackagePersistence lfSocialPackagePersistence;
    @BeanReference(type = LFSocialPackageTagPersistence.class)
    protected LFSocialPackageTagPersistence lfSocialPackageTagPersistence;
    @BeanReference(type = LFTincanActivityPersistence.class)
    protected LFTincanActivityPersistence lfTincanActivityPersistence;
    @BeanReference(type = LFTincanLrsEndpointPersistence.class)
    protected LFTincanLrsEndpointPersistence lfTincanLrsEndpointPersistence;
    @BeanReference(type = LFTincanPackagePersistence.class)
    protected LFTincanPackagePersistence lfTincanPackagePersistence;
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f tincan package in the entity cache if it is enabled.
     *
     * @param lfTincanPackage the l f tincan package
     */
    public void cacheResult(LFTincanPackage lfTincanPackage) {
        EntityCacheUtil.putResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey(),
            lfTincanPackage);

        if (lfTincanPackage.getAssetRefID() != null) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                new Object[] { Long.valueOf(lfTincanPackage.getAssetRefID()) },
                lfTincanPackage);
        }

        lfTincanPackage.resetOriginalValues();
    }

    /**
     * Caches the l f tincan packages in the entity cache if it is enabled.
     *
     * @param lfTincanPackages the l f tincan packages
     */
    public void cacheResult(List<LFTincanPackage> lfTincanPackages) {
        for (LFTincanPackage lfTincanPackage : lfTincanPackages) {
            if (EntityCacheUtil.getResult(
                        LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanPackageImpl.class,
                        lfTincanPackage.getPrimaryKey()) == null) {
                cacheResult(lfTincanPackage);
            } else {
                lfTincanPackage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan packages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanPackageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanPackageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan package.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanPackage lfTincanPackage) {
        EntityCacheUtil.removeResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanPackage);
    }

    @Override
    public void clearCache(List<LFTincanPackage> lfTincanPackages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanPackage lfTincanPackage : lfTincanPackages) {
            EntityCacheUtil.removeResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey());

            clearUniqueFindersCache(lfTincanPackage);
        }
    }

    protected void clearUniqueFindersCache(LFTincanPackage lfTincanPackage) {
        if (lfTincanPackage.getAssetRefID() == null) return;
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID,
            new Object[] { Long.valueOf(lfTincanPackage.getAssetRefID()) });
    }

    /**
     * Creates a new l f tincan package with the primary key. Does not add the l f tincan package to the database.
     *
     * @param id the primary key for the new l f tincan package
     * @return the new l f tincan package
     */
    public LFTincanPackage create(long id) {
        LFTincanPackage lfTincanPackage = new LFTincanPackageImpl();

        lfTincanPackage.setNew(true);
        lfTincanPackage.setPrimaryKey(id);

        return lfTincanPackage;
    }

    /**
     * Removes the l f tincan package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan package
     * @return the l f tincan package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage remove(long id)
        throws NoSuchLFTincanPackageException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan package
     * @return the l f tincan package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage remove(Serializable primaryKey)
        throws NoSuchLFTincanPackageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanPackage lfTincanPackage = (LFTincanPackage) session.get(LFTincanPackageImpl.class,
                    primaryKey);

            if (lfTincanPackage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanPackage);
        } catch (NoSuchLFTincanPackageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanPackage removeImpl(LFTincanPackage lfTincanPackage)
        throws SystemException {
        lfTincanPackage = toUnwrappedModel(lfTincanPackage);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanPackage);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanPackage);

        return lfTincanPackage;
    }

    @Override
    public LFTincanPackage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanPackage lfTincanPackage,
        boolean merge) throws SystemException {
        lfTincanPackage = toUnwrappedModel(lfTincanPackage);

        boolean isNew = lfTincanPackage.isNew();

        LFTincanPackageModelImpl lfTincanPackageModelImpl = (LFTincanPackageModelImpl) lfTincanPackage;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanPackage, merge);

            lfTincanPackage.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanPackageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfTincanPackageModelImpl.getOriginalCourseID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTANCE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfTincanPackageModelImpl.getCourseID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTANCE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE,
                    args);
            }

            if ((lfTincanPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfTincanPackageModelImpl.getOriginalCourseID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfTincanPackageModelImpl.getCourseID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey(),
            lfTincanPackage);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                new Object[] { /*Long.valueOf( */
                lfTincanPackage.getAssetRefID()/*) */
                }, lfTincanPackage);
        } else {
            if ((lfTincanPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_REFID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Long.valueOf( */
                        lfTincanPackageModelImpl.getOriginalAssetRefID()
                    /*        ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFID, args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                    new Object[] { /*        Long.valueOf( */
                    lfTincanPackage.getAssetRefID()/*        ) */
                    }, lfTincanPackage);
            }
        }

        return lfTincanPackage;
    }

    protected LFTincanPackage toUnwrappedModel(LFTincanPackage lfTincanPackage) {
        if (lfTincanPackage instanceof LFTincanPackageImpl) {
            return lfTincanPackage;
        }

        LFTincanPackageImpl lfTincanPackageImpl = new LFTincanPackageImpl();

        lfTincanPackageImpl.setNew(lfTincanPackage.isNew());
        lfTincanPackageImpl.setPrimaryKey(lfTincanPackage.getPrimaryKey());

        lfTincanPackageImpl.setId(lfTincanPackage.getId());
        lfTincanPackageImpl.setTitle(lfTincanPackage.getTitle());
        lfTincanPackageImpl.setSummary(lfTincanPackage.getSummary());
        lfTincanPackageImpl.setAssetRefID(lfTincanPackage.getAssetRefID());
        lfTincanPackageImpl.setCourseID(lfTincanPackage.getCourseID());

        return lfTincanPackageImpl;
    }

    /**
     * Returns the l f tincan package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan package
     * @return the l f tincan package
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan package with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException} if it could not be found.
     *
     * @param id the primary key of the l f tincan package
     * @return the l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage findByPrimaryKey(long id)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByPrimaryKey(id);

        if (lfTincanPackage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanPackage;
    }

    /**
     * Returns the l f tincan package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan package
     * @return the l f tincan package, or <code>null</code> if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan package
     * @return the l f tincan package, or <code>null</code> if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByPrimaryKey(long id) throws SystemException {
        LFTincanPackage lfTincanPackage = (LFTincanPackage) EntityCacheUtil.getResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanPackageImpl.class, id);

        if (lfTincanPackage == _nullLFTincanPackage) {
            return null;
        }

        if (lfTincanPackage == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanPackage = (LFTincanPackage) session.get(LFTincanPackageImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanPackage != null) {
                    cacheResult(lfTincanPackage);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanPackageImpl.class, id, _nullLFTincanPackage);
                }

                closeSession(session);
            }
        }

        return lfTincanPackage;
    }

    /**
     * Returns the l f tincan package where assetRefID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException} if it could not be found.
     *
     * @param assetRefID the asset ref i d
     * @return the matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage findByRefID(Long assetRefID)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByRefID(assetRefID);

        if (lfTincanPackage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("assetRefID=");
            msg.append(assetRefID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanPackageException(msg.toString());
        }

        return lfTincanPackage;
    }

    /**
     * Returns the l f tincan package where assetRefID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param assetRefID the asset ref i d
     * @return the matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByRefID(Long assetRefID)
        throws SystemException {
        return fetchByRefID(assetRefID, true);
    }

    /**
     * Returns the l f tincan package where assetRefID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param assetRefID the asset ref i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByRefID(Long assetRefID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { assetRefID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REFID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanPackage) {
            LFTincanPackage lfTincanPackage = (LFTincanPackage) result;

            if (!Validator.equals(assetRefID, lfTincanPackage.getAssetRefID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

            if (assetRefID == null) {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (assetRefID != null) {
                    qPos.add(assetRefID.longValue());
                }

                List<LFTincanPackage> list = q.list();

                result = list;

                LFTincanPackage lfTincanPackage = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                        finderArgs, list);
                } else {
                    lfTincanPackage = list.get(0);

                    cacheResult(lfTincanPackage);

                    if ((lfTincanPackage.getAssetRefID() != assetRefID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                            finderArgs, lfTincanPackage);
                    }
                }

                return lfTincanPackage;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFTincanPackage) result;
            }
        }
    }

    /**
     * Returns all the l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByInstance(Integer courseID)
        throws SystemException {
        return findByInstance(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByInstance(Integer courseID, int start,
        int end) throws SystemException {
        return findByInstance(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByInstance(Integer courseID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE;
            finderArgs = new Object[] { courseID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE;
            finderArgs = new Object[] { courseID, start, end, orderByComparator };
        }

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!Validator.equals(courseID, lfTincanPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_2);
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

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                list = (List<LFTincanPackage>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage findByInstance_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByInstance_First(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByInstance_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanPackage> list = findByInstance(courseID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage findByInstance_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByInstance_Last(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByInstance_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByInstance(courseID);

        List<LFTincanPackage> list = findByInstance(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan packages before and after the current l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f tincan package
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage[] findByInstance_PrevAndNext(long id,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanPackage[] array = new LFTincanPackageImpl[3];

            array[0] = getByInstance_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, true);

            array[1] = lfTincanPackage;

            array[2] = getByInstance_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanPackage getByInstance_PrevAndNext(Session session,
        LFTincanPackage lfTincanPackage, Integer courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

        if (courseID == null) {
            query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_INSTANCE_COURSEID_2);
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

        if (courseID != null) {
            qPos.add(courseID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIDs the course i ds
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByInstance(Integer[] courseIDs)
        throws SystemException {
        return findByInstance(courseIDs, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByInstance(Integer[] courseIDs, int start,
        int end) throws SystemException {
        return findByInstance(courseIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByInstance(Integer[] courseIDs, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] { StringUtil.merge(courseIDs) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIDs),
                    
                    start, end, orderByComparator
                };
        }

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!ArrayUtil.contains(courseIDs, lfTincanPackage.getCourseID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

            boolean conjunctionable = false;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_5);
                    }

                    if ((i + 1) < courseIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
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

                if (courseIDs != null) {
                    for (Integer courseID : courseIDs) {
                        if (courseID != null) {
                            qPos.add(courseID);
                        }
                    }
                }

                list = (List<LFTincanPackage>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns all the l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByCourseID(Integer courseID)
        throws SystemException {
        return findByCourseID(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByCourseID(Integer courseID, int start,
        int end) throws SystemException {
        return findByCourseID(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findByCourseID(Integer courseID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
            finderArgs = new Object[] { courseID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
            finderArgs = new Object[] { courseID, start, end, orderByComparator };
        }

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!Validator.equals(courseID, lfTincanPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
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

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                list = (List<LFTincanPackage>) QueryUtil.list(q, getDialect(),
                        start, end);
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
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage findByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByCourseID_First(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanPackage> list = findByCourseID(courseID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage findByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByCourseID_Last(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage fetchByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseID(courseID);

        List<LFTincanPackage> list = findByCourseID(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan packages before and after the current l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f tincan package
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage[] findByCourseID_PrevAndNext(long id,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanPackage[] array = new LFTincanPackageImpl[3];

            array[0] = getByCourseID_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, true);

            array[1] = lfTincanPackage;

            array[2] = getByCourseID_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanPackage getByCourseID_PrevAndNext(Session session,
        LFTincanPackage lfTincanPackage, Integer courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

        if (courseID == null) {
            query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
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

        if (courseID != null) {
            qPos.add(courseID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan packages.
     *
     * @return the l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanPackage> findAll(int start, int end,
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

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANPACKAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANPACKAGE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
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
     * Removes the l f tincan package where assetRefID = &#63; from the database.
     *
     * @param assetRefID the asset ref i d
     * @return the l f tincan package that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanPackage removeByRefID(Long assetRefID)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByRefID(assetRefID);

        return remove(lfTincanPackage);
    }

    /**
     * Removes all the l f tincan packages where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByInstance(Integer courseID) throws SystemException {
        for (LFTincanPackage lfTincanPackage : findByInstance(courseID)) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Removes all the l f tincan packages where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByCourseID(Integer courseID) throws SystemException {
        for (LFTincanPackage lfTincanPackage : findByCourseID(courseID)) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Removes all the l f tincan packages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanPackage lfTincanPackage : findAll()) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Returns the number of l f tincan packages where assetRefID = &#63;.
     *
     * @param assetRefID the asset ref i d
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public int countByRefID(Long assetRefID) throws SystemException {
        Object[] finderArgs = new Object[] { assetRefID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_REFID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

            if (assetRefID == null) {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (assetRefID != null) {
                    qPos.add(assetRefID.longValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REFID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public int countByInstance(Integer courseID) throws SystemException {
        Object[] finderArgs = new Object[] { courseID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_INSTANCE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INSTANCE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan packages where courseID = any &#63;.
     *
     * @param courseIDs the course i ds
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public int countByInstance(Integer[] courseIDs) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(courseIDs) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

            boolean conjunctionable = false;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_5);
                    }

                    if ((i + 1) < courseIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseIDs != null) {
                    for (Integer courseID : courseIDs) {
                        if (courseID != null) {
                            qPos.add(courseID);
                        }
                    }
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseID(Integer courseID) throws SystemException {
        Object[] finderArgs = new Object[] { courseID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan packages.
     *
     * @return the number of l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANPACKAGE);

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
     * Initializes the l f tincan package persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanPackage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanPackage>> listenersList = new ArrayList<ModelListener<LFTincanPackage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanPackage>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanPackageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    private static String _removeConjunction(String sql) {
        int pos = sql.indexOf(" AND ");

        if (pos != -1) {
            sql = sql.substring(0, pos);
        }

        return sql;
    }
}

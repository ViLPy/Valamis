package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException;
import com.arcusys.learn.persistence.liferay.model.LFAttempt;
import com.arcusys.learn.persistence.liferay.model.impl.LFAttemptImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl;
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
 * The persistence implementation for the l f attempt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptPersistence
 * @see LFAttemptUtil
 * @generated
 */
public class LFAttemptPersistenceImpl extends BasePersistenceImpl<LFAttempt>
    implements LFAttemptPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFAttemptUtil} to access the l f attempt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFAttemptImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Integer.class.getName() },
            LFAttemptModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
            new String[] { Integer.class.getName() },
            LFAttemptModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE =
        new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUserIDPackageIDIsComplete",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE =
        new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUserIDPackageIDIsComplete",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                Boolean.class.getName()
            },
            LFAttemptModelImpl.USERID_COLUMN_BITMASK |
            LFAttemptModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFAttemptModelImpl.ISCOMPLETE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDPACKAGEIDISCOMPLETE =
        new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserIDPackageIDIsComplete",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                Boolean.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, LFAttemptImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFATTEMPT = "SELECT lfAttempt FROM LFAttempt lfAttempt";
    private static final String _SQL_SELECT_LFATTEMPT_WHERE = "SELECT lfAttempt FROM LFAttempt lfAttempt WHERE ";
    private static final String _SQL_COUNT_LFATTEMPT = "SELECT COUNT(lfAttempt) FROM LFAttempt lfAttempt";
    private static final String _SQL_COUNT_LFATTEMPT_WHERE = "SELECT COUNT(lfAttempt) FROM LFAttempt lfAttempt WHERE ";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfAttempt.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfAttempt.packageID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfAttempt.packageID = ?";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL = "lfAttempt.userID IS NULL";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL_2 = "lfAttempt.userID IS NULL ";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "lfAttempt.userID = ?";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_NULL =
        "lfAttempt.userID IS NULL";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_NULL_2 =
        "lfAttempt.userID IS NULL  AND ";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_2 =
        "lfAttempt.userID = ? AND ";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_NULL =
        "lfAttempt.packageID IS NULL";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_NULL_2 =
        "lfAttempt.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_2 =
        "lfAttempt.packageID = ? AND ";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_NULL =
        "lfAttempt.isComplete IS NULL";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_NULL_2 =
        "lfAttempt.isComplete IS NULL ";
    private static final String _FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_2 =
        "lfAttempt.isComplete = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfAttempt.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFAttempt exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFAttempt exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFAttemptPersistenceImpl.class);
    private static LFAttempt _nullLFAttempt = new LFAttemptImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFAttempt> toCacheModel() {
                return _nullLFAttemptCacheModel;
            }
        };

    private static CacheModel<LFAttempt> _nullLFAttemptCacheModel = new CacheModel<LFAttempt>() {
            public LFAttempt toEntityModel() {
                return _nullLFAttempt;
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
     * Caches the l f attempt in the entity cache if it is enabled.
     *
     * @param lfAttempt the l f attempt
     */
    public void cacheResult(LFAttempt lfAttempt) {
        EntityCacheUtil.putResult(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptImpl.class, lfAttempt.getPrimaryKey(), lfAttempt);

        lfAttempt.resetOriginalValues();
    }

    /**
     * Caches the l f attempts in the entity cache if it is enabled.
     *
     * @param lfAttempts the l f attempts
     */
    public void cacheResult(List<LFAttempt> lfAttempts) {
        for (LFAttempt lfAttempt : lfAttempts) {
            if (EntityCacheUtil.getResult(
                        LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
                        LFAttemptImpl.class, lfAttempt.getPrimaryKey()) == null) {
                cacheResult(lfAttempt);
            } else {
                lfAttempt.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f attempts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFAttemptImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFAttemptImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f attempt.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFAttempt lfAttempt) {
        EntityCacheUtil.removeResult(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptImpl.class, lfAttempt.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFAttempt> lfAttempts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFAttempt lfAttempt : lfAttempts) {
            EntityCacheUtil.removeResult(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
                LFAttemptImpl.class, lfAttempt.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f attempt with the primary key. Does not add the l f attempt to the database.
     *
     * @param id the primary key for the new l f attempt
     * @return the new l f attempt
     */
    public LFAttempt create(long id) {
        LFAttempt lfAttempt = new LFAttemptImpl();

        lfAttempt.setNew(true);
        lfAttempt.setPrimaryKey(id);

        return lfAttempt;
    }

    /**
     * Removes the l f attempt with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f attempt
     * @return the l f attempt that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt remove(long id)
        throws NoSuchLFAttemptException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f attempt with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f attempt
     * @return the l f attempt that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttempt remove(Serializable primaryKey)
        throws NoSuchLFAttemptException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFAttempt lfAttempt = (LFAttempt) session.get(LFAttemptImpl.class,
                    primaryKey);

            if (lfAttempt == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFAttemptException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfAttempt);
        } catch (NoSuchLFAttemptException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFAttempt removeImpl(LFAttempt lfAttempt)
        throws SystemException {
        lfAttempt = toUnwrappedModel(lfAttempt);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfAttempt);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfAttempt);

        return lfAttempt;
    }

    @Override
    public LFAttempt updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt,
        boolean merge) throws SystemException {
        lfAttempt = toUnwrappedModel(lfAttempt);

        boolean isNew = lfAttempt.isNew();

        LFAttemptModelImpl lfAttemptModelImpl = (LFAttemptModelImpl) lfAttempt;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfAttempt, merge);

            lfAttempt.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFAttemptModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfAttemptModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfAttemptModelImpl.getOriginalPackageID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfAttemptModelImpl.getPackageID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }

            if ((lfAttemptModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfAttemptModelImpl.getOriginalUserID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfAttemptModelImpl.getUserID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((lfAttemptModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfAttemptModelImpl.getOriginalUserID(),
                        /* Integer.valueOf(   */
                        lfAttemptModelImpl.getOriginalPackageID(),
                        /* Boolean.valueOf(   */
                        lfAttemptModelImpl.getOriginalIsComplete()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPACKAGEIDISCOMPLETE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfAttemptModelImpl.getUserID(),
                        /* Integer.valueOf( */
                        lfAttemptModelImpl.getPackageID(),
                        /* Boolean.valueOf( */
                        lfAttemptModelImpl.getIsComplete()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDPACKAGEIDISCOMPLETE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptImpl.class, lfAttempt.getPrimaryKey(), lfAttempt);

        return lfAttempt;
    }

    protected LFAttempt toUnwrappedModel(LFAttempt lfAttempt) {
        if (lfAttempt instanceof LFAttemptImpl) {
            return lfAttempt;
        }

        LFAttemptImpl lfAttemptImpl = new LFAttemptImpl();

        lfAttemptImpl.setNew(lfAttempt.isNew());
        lfAttemptImpl.setPrimaryKey(lfAttempt.getPrimaryKey());

        lfAttemptImpl.setId(lfAttempt.getId());
        lfAttemptImpl.setUserID(lfAttempt.getUserID());
        lfAttemptImpl.setPackageID(lfAttempt.getPackageID());
        lfAttemptImpl.setOrganizationID(lfAttempt.getOrganizationID());
        lfAttemptImpl.setIsComplete(lfAttempt.getIsComplete());

        return lfAttemptImpl;
    }

    /**
     * Returns the l f attempt with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f attempt
     * @return the l f attempt
     * @throws com.liferay.portal.NoSuchModelException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttempt findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f attempt with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException} if it could not be found.
     *
     * @param id the primary key of the l f attempt
     * @return the l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByPrimaryKey(long id)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByPrimaryKey(id);

        if (lfAttempt == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFAttemptException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfAttempt;
    }

    /**
     * Returns the l f attempt with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f attempt
     * @return the l f attempt, or <code>null</code> if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttempt fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f attempt with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f attempt
     * @return the l f attempt, or <code>null</code> if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByPrimaryKey(long id) throws SystemException {
        LFAttempt lfAttempt = (LFAttempt) EntityCacheUtil.getResult(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
                LFAttemptImpl.class, id);

        if (lfAttempt == _nullLFAttempt) {
            return null;
        }

        if (lfAttempt == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfAttempt = (LFAttempt) session.get(LFAttemptImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfAttempt != null) {
                    cacheResult(lfAttempt);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFAttemptModelImpl.ENTITY_CACHE_ENABLED,
                        LFAttemptImpl.class, id, _nullLFAttempt);
                }

                closeSession(session);
            }
        }

        return lfAttempt;
    }

    /**
     * Returns all the l f attempts where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByPackageID(Integer packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f attempts where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @return the range of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByPackageID(Integer packageID, int start, int end)
        throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempts where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByPackageID(Integer packageID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<LFAttempt> list = (List<LFAttempt>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttempt lfAttempt : list) {
                if (!Validator.equals(packageID, lfAttempt.getPackageID())) {
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

            query.append(_SQL_SELECT_LFATTEMPT_WHERE);

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
                    qPos.add(packageID.intValue());
                }

                list = (List<LFAttempt>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first l f attempt in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfAttempt != null) {
            return lfAttempt;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptException(msg.toString());
    }

    /**
     * Returns the first l f attempt in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAttempt> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByPackageID_Last(packageID, orderByComparator);

        if (lfAttempt != null) {
            return lfAttempt;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptException(msg.toString());
    }

    /**
     * Returns the last l f attempt in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        List<LFAttempt> list = findByPackageID(packageID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempts before and after the current l f attempt in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f attempt
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt[] findByPackageID_PrevAndNext(long id, Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttempt[] array = new LFAttemptImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfAttempt,
                    packageID, orderByComparator, true);

            array[1] = lfAttempt;

            array[2] = getByPackageID_PrevAndNext(session, lfAttempt,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttempt getByPackageID_PrevAndNext(Session session,
        LFAttempt lfAttempt, Integer packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPT_WHERE);

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
            qPos.add(packageID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttempt);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttempt> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f attempts where userID = &#63;.
     *
     * @param userID the user i d
     * @return the matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByUserID(Integer userID)
        throws SystemException {
        return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempts where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @return the range of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByUserID(Integer userID, int start, int end)
        throws SystemException {
        return findByUserID(userID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempts where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByUserID(Integer userID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userID, start, end, orderByComparator };
        }

        List<LFAttempt> list = (List<LFAttempt>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttempt lfAttempt : list) {
                if (!Validator.equals(userID, lfAttempt.getUserID())) {
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

            query.append(_SQL_SELECT_LFATTEMPT_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_USERID_2);
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

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                list = (List<LFAttempt>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first l f attempt in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByUserID_First(Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByUserID_First(userID, orderByComparator);

        if (lfAttempt != null) {
            return lfAttempt;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptException(msg.toString());
    }

    /**
     * Returns the first l f attempt in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByUserID_First(Integer userID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAttempt> list = findByUserID(userID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByUserID_Last(Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByUserID_Last(userID, orderByComparator);

        if (lfAttempt != null) {
            return lfAttempt;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptException(msg.toString());
    }

    /**
     * Returns the last l f attempt in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByUserID_Last(Integer userID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserID(userID);

        List<LFAttempt> list = findByUserID(userID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempts before and after the current l f attempt in the ordered set where userID = &#63;.
     *
     * @param id the primary key of the current l f attempt
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt[] findByUserID_PrevAndNext(long id, Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttempt[] array = new LFAttemptImpl[3];

            array[0] = getByUserID_PrevAndNext(session, lfAttempt, userID,
                    orderByComparator, true);

            array[1] = lfAttempt;

            array[2] = getByUserID_PrevAndNext(session, lfAttempt, userID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttempt getByUserID_PrevAndNext(Session session,
        LFAttempt lfAttempt, Integer userID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPT_WHERE);

        if (userID == null) {
            query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERID_USERID_2);
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

        if (userID != null) {
            qPos.add(userID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttempt);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttempt> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @return the matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByUserIDPackageIDIsComplete(Integer userID,
        Integer packageID, Boolean isComplete) throws SystemException {
        return findByUserIDPackageIDIsComplete(userID, packageID, isComplete,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @return the range of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByUserIDPackageIDIsComplete(Integer userID,
        Integer packageID, Boolean isComplete, int start, int end)
        throws SystemException {
        return findByUserIDPackageIDIsComplete(userID, packageID, isComplete,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findByUserIDPackageIDIsComplete(Integer userID,
        Integer packageID, Boolean isComplete, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE;
            finderArgs = new Object[] { userID, packageID, isComplete };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDPACKAGEIDISCOMPLETE;
            finderArgs = new Object[] {
                    userID, packageID, isComplete,
                    
                    start, end, orderByComparator
                };
        }

        List<LFAttempt> list = (List<LFAttempt>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttempt lfAttempt : list) {
                if (!Validator.equals(userID, lfAttempt.getUserID()) ||
                        !Validator.equals(packageID, lfAttempt.getPackageID()) ||
                        !Validator.equals(isComplete, lfAttempt.getIsComplete())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFATTEMPT_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_2);
            }

            if (packageID == null) {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_2);
            }

            if (isComplete == null) {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_2);
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

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (isComplete != null) {
                    qPos.add(isComplete.booleanValue());
                }

                list = (List<LFAttempt>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByUserIDPackageIDIsComplete_First(Integer userID,
        Integer packageID, Boolean isComplete,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByUserIDPackageIDIsComplete_First(userID,
                packageID, isComplete, orderByComparator);

        if (lfAttempt != null) {
            return lfAttempt;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(", packageID=");
        msg.append(packageID);

        msg.append(", isComplete=");
        msg.append(isComplete);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptException(msg.toString());
    }

    /**
     * Returns the first l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByUserIDPackageIDIsComplete_First(Integer userID,
        Integer packageID, Boolean isComplete,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAttempt> list = findByUserIDPackageIDIsComplete(userID,
                packageID, isComplete, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt findByUserIDPackageIDIsComplete_Last(Integer userID,
        Integer packageID, Boolean isComplete,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = fetchByUserIDPackageIDIsComplete_Last(userID,
                packageID, isComplete, orderByComparator);

        if (lfAttempt != null) {
            return lfAttempt;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(", packageID=");
        msg.append(packageID);

        msg.append(", isComplete=");
        msg.append(isComplete);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptException(msg.toString());
    }

    /**
     * Returns the last l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt fetchByUserIDPackageIDIsComplete_Last(Integer userID,
        Integer packageID, Boolean isComplete,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserIDPackageIDIsComplete(userID, packageID,
                isComplete);

        List<LFAttempt> list = findByUserIDPackageIDIsComplete(userID,
                packageID, isComplete, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempts before and after the current l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param id the primary key of the current l f attempt
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFAttempt[] findByUserIDPackageIDIsComplete_PrevAndNext(long id,
        Integer userID, Integer packageID, Boolean isComplete,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptException, SystemException {
        LFAttempt lfAttempt = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttempt[] array = new LFAttemptImpl[3];

            array[0] = getByUserIDPackageIDIsComplete_PrevAndNext(session,
                    lfAttempt, userID, packageID, isComplete,
                    orderByComparator, true);

            array[1] = lfAttempt;

            array[2] = getByUserIDPackageIDIsComplete_PrevAndNext(session,
                    lfAttempt, userID, packageID, isComplete,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttempt getByUserIDPackageIDIsComplete_PrevAndNext(
        Session session, LFAttempt lfAttempt, Integer userID,
        Integer packageID, Boolean isComplete,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPT_WHERE);

        if (userID == null) {
            query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_2);
        }

        if (packageID == null) {
            query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_2);
        }

        if (isComplete == null) {
            query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_2);
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

        if (userID != null) {
            qPos.add(userID.intValue());
        }

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (isComplete != null) {
            qPos.add(isComplete.booleanValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttempt);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttempt> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f attempts.
     *
     * @return the l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @return the range of l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f attempts
     * @param end the upper bound of the range of l f attempts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f attempts
     * @throws SystemException if a system exception occurred
     */
    public List<LFAttempt> findAll(int start, int end,
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

        List<LFAttempt> list = (List<LFAttempt>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFATTEMPT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFATTEMPT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFAttempt>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFAttempt>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f attempts where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByPackageID(Integer packageID) throws SystemException {
        for (LFAttempt lfAttempt : findByPackageID(packageID)) {
            remove(lfAttempt);
        }
    }

    /**
     * Removes all the l f attempts where userID = &#63; from the database.
     *
     * @param userID the user i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByUserID(Integer userID) throws SystemException {
        for (LFAttempt lfAttempt : findByUserID(userID)) {
            remove(lfAttempt);
        }
    }

    /**
     * Removes all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63; from the database.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @throws SystemException if a system exception occurred
     */
    public void removeByUserIDPackageIDIsComplete(Integer userID,
        Integer packageID, Boolean isComplete) throws SystemException {
        for (LFAttempt lfAttempt : findByUserIDPackageIDIsComplete(userID,
                packageID, isComplete)) {
            remove(lfAttempt);
        }
    }

    /**
     * Removes all the l f attempts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFAttempt lfAttempt : findAll()) {
            remove(lfAttempt);
        }
    }

    /**
     * Returns the number of l f attempts where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public int countByPackageID(Integer packageID) throws SystemException {
        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFATTEMPT_WHERE);

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
                    qPos.add(packageID.intValue());
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
     * Returns the number of l f attempts where userID = &#63;.
     *
     * @param userID the user i d
     * @return the number of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public int countByUserID(Integer userID) throws SystemException {
        Object[] finderArgs = new Object[] { userID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFATTEMPT_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_USERID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
     *
     * @param userID the user i d
     * @param packageID the package i d
     * @param isComplete the is complete
     * @return the number of matching l f attempts
     * @throws SystemException if a system exception occurred
     */
    public int countByUserIDPackageIDIsComplete(Integer userID,
        Integer packageID, Boolean isComplete) throws SystemException {
        Object[] finderArgs = new Object[] { userID, packageID, isComplete };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDPACKAGEIDISCOMPLETE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFATTEMPT_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_USERID_2);
            }

            if (packageID == null) {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_PACKAGEID_2);
            }

            if (isComplete == null) {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDPACKAGEIDISCOMPLETE_ISCOMPLETE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (isComplete != null) {
                    qPos.add(isComplete.booleanValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDPACKAGEIDISCOMPLETE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f attempts.
     *
     * @return the number of l f attempts
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFATTEMPT);

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
     * Initializes the l f attempt persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFAttempt")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFAttempt>> listenersList = new ArrayList<ModelListener<LFAttempt>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFAttempt>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFAttemptImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

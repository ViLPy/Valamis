package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException;
import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuestionCategoryImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuestionCategoryModelImpl;
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
 * The persistence implementation for the l f question category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionCategoryPersistence
 * @see LFQuestionCategoryUtil
 * @generated
 */
public class LFQuestionCategoryPersistenceImpl extends BasePersistenceImpl<LFQuestionCategory>
    implements LFQuestionCategoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuestionCategoryUtil} to access the l f question category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuestionCategoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED,
            LFQuestionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED,
            LFQuestionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
            new String[] { Integer.class.getName() },
            LFQuestionCategoryModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID =
        new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCourseId",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDPARENTID =
        new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED,
            LFQuestionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCourseIdAndParentId",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDPARENTID =
        new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED,
            LFQuestionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCourseIdAndParentId",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFQuestionCategoryModelImpl.COURSEID_COLUMN_BITMASK |
            LFQuestionCategoryModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEIDANDPARENTID = new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCourseIdAndParentId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDANDPARENTID =
        new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByCourseIdAndParentId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED,
            LFQuestionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED,
            LFQuestionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFQUESTIONCATEGORY = "SELECT lfQuestionCategory FROM LFQuestionCategory lfQuestionCategory";
    private static final String _SQL_SELECT_LFQUESTIONCATEGORY_WHERE = "SELECT lfQuestionCategory FROM LFQuestionCategory lfQuestionCategory WHERE ";
    private static final String _SQL_COUNT_LFQUESTIONCATEGORY = "SELECT COUNT(lfQuestionCategory) FROM LFQuestionCategory lfQuestionCategory";
    private static final String _SQL_COUNT_LFQUESTIONCATEGORY_WHERE = "SELECT COUNT(lfQuestionCategory) FROM LFQuestionCategory lfQuestionCategory WHERE ";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lfQuestionCategory.courseId IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lfQuestionCategory.courseId IS NULL ";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lfQuestionCategory.courseId = ?";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2) + ")";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEID_COURSEID_2) + ")";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL =
        "lfQuestionCategory.courseId IS NULL";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL_2 =
        "lfQuestionCategory.courseId IS NULL  AND ";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_2 = "lfQuestionCategory.courseId = ? AND ";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_2) +
        ")";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL =
        "lfQuestionCategory.parentId IS NULL";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL_2 =
        "lfQuestionCategory.parentId IS NULL ";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_2 = "lfQuestionCategory.parentId = ?";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_2) +
        ")";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuestionCategory.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuestionCategory exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuestionCategory exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuestionCategoryPersistenceImpl.class);
    private static LFQuestionCategory _nullLFQuestionCategory = new LFQuestionCategoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuestionCategory> toCacheModel() {
                return _nullLFQuestionCategoryCacheModel;
            }
        };

    private static CacheModel<LFQuestionCategory> _nullLFQuestionCategoryCacheModel =
        new CacheModel<LFQuestionCategory>() {
            public LFQuestionCategory toEntityModel() {
                return _nullLFQuestionCategory;
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
     * Caches the l f question category in the entity cache if it is enabled.
     *
     * @param lfQuestionCategory the l f question category
     */
    public void cacheResult(LFQuestionCategory lfQuestionCategory) {
        EntityCacheUtil.putResult(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryImpl.class, lfQuestionCategory.getPrimaryKey(),
            lfQuestionCategory);

        lfQuestionCategory.resetOriginalValues();
    }

    /**
     * Caches the l f question categories in the entity cache if it is enabled.
     *
     * @param lfQuestionCategories the l f question categories
     */
    public void cacheResult(List<LFQuestionCategory> lfQuestionCategories) {
        for (LFQuestionCategory lfQuestionCategory : lfQuestionCategories) {
            if (EntityCacheUtil.getResult(
                        LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuestionCategoryImpl.class,
                        lfQuestionCategory.getPrimaryKey()) == null) {
                cacheResult(lfQuestionCategory);
            } else {
                lfQuestionCategory.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f question categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuestionCategoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuestionCategoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f question category.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuestionCategory lfQuestionCategory) {
        EntityCacheUtil.removeResult(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryImpl.class, lfQuestionCategory.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuestionCategory> lfQuestionCategories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuestionCategory lfQuestionCategory : lfQuestionCategories) {
            EntityCacheUtil.removeResult(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                LFQuestionCategoryImpl.class, lfQuestionCategory.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f question category with the primary key. Does not add the l f question category to the database.
     *
     * @param id the primary key for the new l f question category
     * @return the new l f question category
     */
    public LFQuestionCategory create(long id) {
        LFQuestionCategory lfQuestionCategory = new LFQuestionCategoryImpl();

        lfQuestionCategory.setNew(true);
        lfQuestionCategory.setPrimaryKey(id);

        return lfQuestionCategory;
    }

    /**
     * Removes the l f question category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f question category
     * @return the l f question category that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory remove(long id)
        throws NoSuchLFQuestionCategoryException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f question category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f question category
     * @return the l f question category that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuestionCategory remove(Serializable primaryKey)
        throws NoSuchLFQuestionCategoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuestionCategory lfQuestionCategory = (LFQuestionCategory) session.get(LFQuestionCategoryImpl.class,
                    primaryKey);

            if (lfQuestionCategory == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuestionCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuestionCategory);
        } catch (NoSuchLFQuestionCategoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuestionCategory removeImpl(
        LFQuestionCategory lfQuestionCategory) throws SystemException {
        lfQuestionCategory = toUnwrappedModel(lfQuestionCategory);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfQuestionCategory);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfQuestionCategory);

        return lfQuestionCategory;
    }

    @Override
    public LFQuestionCategory updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory,
        boolean merge) throws SystemException {
        lfQuestionCategory = toUnwrappedModel(lfQuestionCategory);

        boolean isNew = lfQuestionCategory.isNew();

        LFQuestionCategoryModelImpl lfQuestionCategoryModelImpl = (LFQuestionCategoryModelImpl) lfQuestionCategory;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfQuestionCategory, merge);

            lfQuestionCategory.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuestionCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuestionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfQuestionCategoryModelImpl.getOriginalCourseId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfQuestionCategoryModelImpl.getCourseId()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }

            if ((lfQuestionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDPARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfQuestionCategoryModelImpl.getOriginalCourseId(),
                        /* Integer.valueOf(   */
                        lfQuestionCategoryModelImpl.getOriginalParentId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDPARENTID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfQuestionCategoryModelImpl.getCourseId(),
                        /* Integer.valueOf( */
                        lfQuestionCategoryModelImpl.getParentId()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDPARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            LFQuestionCategoryImpl.class, lfQuestionCategory.getPrimaryKey(),
            lfQuestionCategory);

        return lfQuestionCategory;
    }

    protected LFQuestionCategory toUnwrappedModel(
        LFQuestionCategory lfQuestionCategory) {
        if (lfQuestionCategory instanceof LFQuestionCategoryImpl) {
            return lfQuestionCategory;
        }

        LFQuestionCategoryImpl lfQuestionCategoryImpl = new LFQuestionCategoryImpl();

        lfQuestionCategoryImpl.setNew(lfQuestionCategory.isNew());
        lfQuestionCategoryImpl.setPrimaryKey(lfQuestionCategory.getPrimaryKey());

        lfQuestionCategoryImpl.setId(lfQuestionCategory.getId());
        lfQuestionCategoryImpl.setTitle(lfQuestionCategory.getTitle());
        lfQuestionCategoryImpl.setDescription(lfQuestionCategory.getDescription());
        lfQuestionCategoryImpl.setParentId(lfQuestionCategory.getParentId());
        lfQuestionCategoryImpl.setCourseId(lfQuestionCategory.getCourseId());
        lfQuestionCategoryImpl.setArrangementIndex(lfQuestionCategory.getArrangementIndex());

        return lfQuestionCategoryImpl;
    }

    /**
     * Returns the l f question category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f question category
     * @return the l f question category
     * @throws com.liferay.portal.NoSuchModelException if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuestionCategory findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f question category with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException} if it could not be found.
     *
     * @param id the primary key of the l f question category
     * @return the l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory findByPrimaryKey(long id)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = fetchByPrimaryKey(id);

        if (lfQuestionCategory == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFQuestionCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfQuestionCategory;
    }

    /**
     * Returns the l f question category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f question category
     * @return the l f question category, or <code>null</code> if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuestionCategory fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f question category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f question category
     * @return the l f question category, or <code>null</code> if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory fetchByPrimaryKey(long id)
        throws SystemException {
        LFQuestionCategory lfQuestionCategory = (LFQuestionCategory) EntityCacheUtil.getResult(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                LFQuestionCategoryImpl.class, id);

        if (lfQuestionCategory == _nullLFQuestionCategory) {
            return null;
        }

        if (lfQuestionCategory == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfQuestionCategory = (LFQuestionCategory) session.get(LFQuestionCategoryImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfQuestionCategory != null) {
                    cacheResult(lfQuestionCategory);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFQuestionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuestionCategoryImpl.class, id,
                        _nullLFQuestionCategory);
                }

                closeSession(session);
            }
        }

        return lfQuestionCategory;
    }

    /**
     * Returns all the l f question categories where courseId = &#63;.
     *
     * @param courseId the course ID
     * @return the matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseId(Integer courseId)
        throws SystemException {
        return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f question categories where courseId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseId the course ID
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @return the range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseId(Integer courseId, int start,
        int end) throws SystemException {
        return findByCourseId(courseId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f question categories where courseId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseId the course ID
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseId(Integer courseId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
            finderArgs = new Object[] { courseId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
            finderArgs = new Object[] { courseId, start, end, orderByComparator };
        }

        List<LFQuestionCategory> list = (List<LFQuestionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuestionCategory lfQuestionCategory : list) {
                if (!Validator.equals(courseId, lfQuestionCategory.getCourseId())) {
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

            query.append(_SQL_SELECT_LFQUESTIONCATEGORY_WHERE);

            if (courseId == null) {
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

                if (courseId != null) {
                    qPos.add(courseId.intValue());
                }

                list = (List<LFQuestionCategory>) QueryUtil.list(q,
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
     * Returns the first l f question category in the ordered set where courseId = &#63;.
     *
     * @param courseId the course ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory findByCourseId_First(Integer courseId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = fetchByCourseId_First(courseId,
                orderByComparator);

        if (lfQuestionCategory != null) {
            return lfQuestionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseId=");
        msg.append(courseId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuestionCategoryException(msg.toString());
    }

    /**
     * Returns the first l f question category in the ordered set where courseId = &#63;.
     *
     * @param courseId the course ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f question category, or <code>null</code> if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory fetchByCourseId_First(Integer courseId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFQuestionCategory> list = findByCourseId(courseId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f question category in the ordered set where courseId = &#63;.
     *
     * @param courseId the course ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory findByCourseId_Last(Integer courseId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = fetchByCourseId_Last(courseId,
                orderByComparator);

        if (lfQuestionCategory != null) {
            return lfQuestionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseId=");
        msg.append(courseId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuestionCategoryException(msg.toString());
    }

    /**
     * Returns the last l f question category in the ordered set where courseId = &#63;.
     *
     * @param courseId the course ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f question category, or <code>null</code> if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory fetchByCourseId_Last(Integer courseId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseId(courseId);

        List<LFQuestionCategory> list = findByCourseId(courseId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f question categories before and after the current l f question category in the ordered set where courseId = &#63;.
     *
     * @param id the primary key of the current l f question category
     * @param courseId the course ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory[] findByCourseId_PrevAndNext(long id,
        Integer courseId, OrderByComparator orderByComparator)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuestionCategory[] array = new LFQuestionCategoryImpl[3];

            array[0] = getByCourseId_PrevAndNext(session, lfQuestionCategory,
                    courseId, orderByComparator, true);

            array[1] = lfQuestionCategory;

            array[2] = getByCourseId_PrevAndNext(session, lfQuestionCategory,
                    courseId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuestionCategory getByCourseId_PrevAndNext(Session session,
        LFQuestionCategory lfQuestionCategory, Integer courseId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUESTIONCATEGORY_WHERE);

        if (courseId == null) {
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

        if (courseId != null) {
            qPos.add(courseId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuestionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuestionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f question categories where courseId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @return the matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseId(Integer[] courseIds)
        throws SystemException {
        return findByCourseId(courseIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f question categories where courseId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @return the range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseId(Integer[] courseIds,
        int start, int end) throws SystemException {
        return findByCourseId(courseIds, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f question categories where courseId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseId(Integer[] courseIds,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] { StringUtil.merge(courseIds) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIds),
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuestionCategory> list = (List<LFQuestionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuestionCategory lfQuestionCategory : list) {
                if (!ArrayUtil.contains(courseIds,
                            lfQuestionCategory.getCourseId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFQUESTIONCATEGORY_WHERE);

            boolean conjunctionable = false;

            if ((courseIds != null) && (courseIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_5);
                    }

                    if ((i + 1) < courseIds.length) {
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

                if (courseIds != null) {
                    for (Integer courseId : courseIds) {
                        if (courseId != null) {
                            qPos.add(courseId);
                        }
                    }
                }

                list = (List<LFQuestionCategory>) QueryUtil.list(q,
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
     * Returns all the l f question categories where courseId = &#63; and parentId = &#63;.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @return the matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseIdAndParentId(
        Integer courseId, Integer parentId) throws SystemException {
        return findByCourseIdAndParentId(courseId, parentId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f question categories where courseId = &#63; and parentId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @return the range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseIdAndParentId(
        Integer courseId, Integer parentId, int start, int end)
        throws SystemException {
        return findByCourseIdAndParentId(courseId, parentId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f question categories where courseId = &#63; and parentId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseIdAndParentId(
        Integer courseId, Integer parentId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEIDANDPARENTID;
            finderArgs = new Object[] { courseId, parentId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDPARENTID;
            finderArgs = new Object[] {
                    courseId, parentId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuestionCategory> list = (List<LFQuestionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuestionCategory lfQuestionCategory : list) {
                if (!Validator.equals(courseId, lfQuestionCategory.getCourseId()) ||
                        !Validator.equals(parentId,
                            lfQuestionCategory.getParentId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFQUESTIONCATEGORY_WHERE);

            if (courseId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_2);
            }

            if (parentId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_2);
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

                if (courseId != null) {
                    qPos.add(courseId.intValue());
                }

                if (parentId != null) {
                    qPos.add(parentId.intValue());
                }

                list = (List<LFQuestionCategory>) QueryUtil.list(q,
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
     * Returns the first l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory findByCourseIdAndParentId_First(
        Integer courseId, Integer parentId, OrderByComparator orderByComparator)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = fetchByCourseIdAndParentId_First(courseId,
                parentId, orderByComparator);

        if (lfQuestionCategory != null) {
            return lfQuestionCategory;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseId=");
        msg.append(courseId);

        msg.append(", parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuestionCategoryException(msg.toString());
    }

    /**
     * Returns the first l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f question category, or <code>null</code> if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory fetchByCourseIdAndParentId_First(
        Integer courseId, Integer parentId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFQuestionCategory> list = findByCourseIdAndParentId(courseId,
                parentId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory findByCourseIdAndParentId_Last(Integer courseId,
        Integer parentId, OrderByComparator orderByComparator)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = fetchByCourseIdAndParentId_Last(courseId,
                parentId, orderByComparator);

        if (lfQuestionCategory != null) {
            return lfQuestionCategory;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseId=");
        msg.append(courseId);

        msg.append(", parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuestionCategoryException(msg.toString());
    }

    /**
     * Returns the last l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f question category, or <code>null</code> if a matching l f question category could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory fetchByCourseIdAndParentId_Last(
        Integer courseId, Integer parentId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCourseIdAndParentId(courseId, parentId);

        List<LFQuestionCategory> list = findByCourseIdAndParentId(courseId,
                parentId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f question categories before and after the current l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
     *
     * @param id the primary key of the current l f question category
     * @param courseId the course ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f question category
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFQuestionCategory[] findByCourseIdAndParentId_PrevAndNext(long id,
        Integer courseId, Integer parentId, OrderByComparator orderByComparator)
        throws NoSuchLFQuestionCategoryException, SystemException {
        LFQuestionCategory lfQuestionCategory = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuestionCategory[] array = new LFQuestionCategoryImpl[3];

            array[0] = getByCourseIdAndParentId_PrevAndNext(session,
                    lfQuestionCategory, courseId, parentId, orderByComparator,
                    true);

            array[1] = lfQuestionCategory;

            array[2] = getByCourseIdAndParentId_PrevAndNext(session,
                    lfQuestionCategory, courseId, parentId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuestionCategory getByCourseIdAndParentId_PrevAndNext(
        Session session, LFQuestionCategory lfQuestionCategory,
        Integer courseId, Integer parentId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUESTIONCATEGORY_WHERE);

        if (courseId == null) {
            query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_2);
        }

        if (parentId == null) {
            query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_2);
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

        if (courseId != null) {
            qPos.add(courseId.intValue());
        }

        if (parentId != null) {
            qPos.add(parentId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuestionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuestionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f question categories where courseId = any &#63; and parentId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param parentIds the parent IDs
     * @return the matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseIdAndParentId(
        Integer[] courseIds, Integer[] parentIds) throws SystemException {
        return findByCourseIdAndParentId(courseIds, parentIds,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f question categories where courseId = any &#63; and parentId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param parentIds the parent IDs
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @return the range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseIdAndParentId(
        Integer[] courseIds, Integer[] parentIds, int start, int end)
        throws SystemException {
        return findByCourseIdAndParentId(courseIds, parentIds, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f question categories where courseId = any &#63; and parentId = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param courseIds the course IDs
     * @param parentIds the parent IDs
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findByCourseIdAndParentId(
        Integer[] courseIds, Integer[] parentIds, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEIDANDPARENTID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIds), StringUtil.merge(parentIds)
                };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIds), StringUtil.merge(parentIds),
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuestionCategory> list = (List<LFQuestionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuestionCategory lfQuestionCategory : list) {
                if (!ArrayUtil.contains(courseIds,
                            lfQuestionCategory.getCourseId()) ||
                        !ArrayUtil.contains(parentIds,
                            lfQuestionCategory.getParentId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFQUESTIONCATEGORY_WHERE);

            boolean conjunctionable = false;

            if ((courseIds != null) && (courseIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_5);
                    }

                    if ((i + 1) < courseIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if ((parentIds != null) && (parentIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < parentIds.length; i++) {
                    if (parentIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_5);
                    }

                    if ((i + 1) < parentIds.length) {
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

                if (courseIds != null) {
                    for (Integer courseId : courseIds) {
                        if (courseId != null) {
                            qPos.add(courseId);
                        }
                    }
                }

                if (parentIds != null) {
                    for (Integer parentId : parentIds) {
                        if (parentId != null) {
                            qPos.add(parentId);
                        }
                    }
                }

                list = (List<LFQuestionCategory>) QueryUtil.list(q,
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
     * Returns all the l f question categories.
     *
     * @return the l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f question categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @return the range of l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f question categories.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f question categories
     * @param end the upper bound of the range of l f question categories (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f question categories
     * @throws SystemException if a system exception occurred
     */
    public List<LFQuestionCategory> findAll(int start, int end,
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

        List<LFQuestionCategory> list = (List<LFQuestionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUESTIONCATEGORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUESTIONCATEGORY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFQuestionCategory>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFQuestionCategory>) QueryUtil.list(q,
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
     * Removes all the l f question categories where courseId = &#63; from the database.
     *
     * @param courseId the course ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCourseId(Integer courseId) throws SystemException {
        for (LFQuestionCategory lfQuestionCategory : findByCourseId(courseId)) {
            remove(lfQuestionCategory);
        }
    }

    /**
     * Removes all the l f question categories where courseId = &#63; and parentId = &#63; from the database.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCourseIdAndParentId(Integer courseId, Integer parentId)
        throws SystemException {
        for (LFQuestionCategory lfQuestionCategory : findByCourseIdAndParentId(
                courseId, parentId)) {
            remove(lfQuestionCategory);
        }
    }

    /**
     * Removes all the l f question categories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFQuestionCategory lfQuestionCategory : findAll()) {
            remove(lfQuestionCategory);
        }
    }

    /**
     * Returns the number of l f question categories where courseId = &#63;.
     *
     * @param courseId the course ID
     * @return the number of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseId(Integer courseId) throws SystemException {
        Object[] finderArgs = new Object[] { courseId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFQUESTIONCATEGORY_WHERE);

            if (courseId == null) {
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

                if (courseId != null) {
                    qPos.add(courseId.intValue());
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
     * Returns the number of l f question categories where courseId = any &#63;.
     *
     * @param courseIds the course IDs
     * @return the number of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseId(Integer[] courseIds) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(courseIds) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFQUESTIONCATEGORY_WHERE);

            boolean conjunctionable = false;

            if ((courseIds != null) && (courseIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_5);
                    }

                    if ((i + 1) < courseIds.length) {
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

                if (courseIds != null) {
                    for (Integer courseId : courseIds) {
                        if (courseId != null) {
                            qPos.add(courseId);
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

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f question categories where courseId = &#63; and parentId = &#63;.
     *
     * @param courseId the course ID
     * @param parentId the parent ID
     * @return the number of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseIdAndParentId(Integer courseId, Integer parentId)
        throws SystemException {
        Object[] finderArgs = new Object[] { courseId, parentId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEIDANDPARENTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFQUESTIONCATEGORY_WHERE);

            if (courseId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_2);
            }

            if (parentId == null) {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseId != null) {
                    qPos.add(courseId.intValue());
                }

                if (parentId != null) {
                    qPos.add(parentId.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEIDANDPARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f question categories where courseId = any &#63; and parentId = any &#63;.
     *
     * @param courseIds the course IDs
     * @param parentIds the parent IDs
     * @return the number of matching l f question categories
     * @throws SystemException if a system exception occurred
     */
    public int countByCourseIdAndParentId(Integer[] courseIds,
        Integer[] parentIds) throws SystemException {
        Object[] finderArgs = new Object[] {
                StringUtil.merge(courseIds), StringUtil.merge(parentIds)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDANDPARENTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFQUESTIONCATEGORY_WHERE);

            boolean conjunctionable = false;

            if ((courseIds != null) && (courseIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIds.length; i++) {
                    if (courseIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_COURSEID_5);
                    }

                    if ((i + 1) < courseIds.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if ((parentIds != null) && (parentIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < parentIds.length; i++) {
                    if (parentIds[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEIDANDPARENTID_PARENTID_5);
                    }

                    if ((i + 1) < parentIds.length) {
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

                if (courseIds != null) {
                    for (Integer courseId : courseIds) {
                        if (courseId != null) {
                            qPos.add(courseId);
                        }
                    }
                }

                if (parentIds != null) {
                    for (Integer parentId : parentIds) {
                        if (parentId != null) {
                            qPos.add(parentId);
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

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEIDANDPARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f question categories.
     *
     * @return the number of l f question categories
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFQUESTIONCATEGORY);

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
     * Initializes the l f question category persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuestionCategory")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuestionCategory>> listenersList = new ArrayList<ModelListener<LFQuestionCategory>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuestionCategory>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuestionCategoryImpl.class.getName());
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

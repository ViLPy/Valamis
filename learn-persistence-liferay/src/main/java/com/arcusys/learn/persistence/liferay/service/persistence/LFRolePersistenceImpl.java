package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRoleException;
import com.arcusys.learn.persistence.liferay.model.LFRole;
import com.arcusys.learn.persistence.liferay.model.impl.LFRoleImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRoleModelImpl;
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
 * The persistence implementation for the l f role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRolePersistence
 * @see LFRoleUtil
 * @generated
 */
public class LFRolePersistenceImpl extends BasePersistenceImpl<LFRole>
    implements LFRolePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRoleUtil} to access the l f role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRoleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMISSION =
        new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPermission",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMISSION =
        new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPermission",
            new String[] { String.class.getName() },
            LFRoleModelImpl.PERMISSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PERMISSION = new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPermission",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDANDPERMISSION =
        new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByRoleIDAndPermission",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDANDPERMISSION =
        new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByRoleIDAndPermission",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFRoleModelImpl.LIFERAYROLEID_COLUMN_BITMASK |
            LFRoleModelImpl.PERMISSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ROLEIDANDPERMISSION = new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByRoleIDAndPermission",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEFAULTANDPERMISSION =
        new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByDefaultAndPermission",
            new String[] {
                Boolean.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTANDPERMISSION =
        new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByDefaultAndPermission",
            new String[] { Boolean.class.getName(), String.class.getName() },
            LFRoleModelImpl.ISDEFAULT_COLUMN_BITMASK |
            LFRoleModelImpl.PERMISSION_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DEFAULTANDPERMISSION = new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByDefaultAndPermission",
            new String[] { Boolean.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, LFRoleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFROLE = "SELECT lfRole FROM LFRole lfRole";
    private static final String _SQL_SELECT_LFROLE_WHERE = "SELECT lfRole FROM LFRole lfRole WHERE ";
    private static final String _SQL_COUNT_LFROLE = "SELECT COUNT(lfRole) FROM LFRole lfRole";
    private static final String _SQL_COUNT_LFROLE_WHERE = "SELECT COUNT(lfRole) FROM LFRole lfRole WHERE ";
    private static final String _FINDER_COLUMN_PERMISSION_PERMISSION_1 = "lfRole.permission IS NULL";
    private static final String _FINDER_COLUMN_PERMISSION_PERMISSION_NULL = "lfRole.permission IS NULL";
    private static final String _FINDER_COLUMN_PERMISSION_PERMISSION_NULL_2 = "lfRole.permission IS NULL ";
    private static final String _FINDER_COLUMN_PERMISSION_PERMISSION_2 = "lfRole.permission = ?";
    private static final String _FINDER_COLUMN_PERMISSION_PERMISSION_3 = "(lfRole.permission IS NULL OR lfRole.permission = ?)";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_NULL =
        "lfRole.liferayRoleID IS NULL";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_NULL_2 =
        "lfRole.liferayRoleID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_2 =
        "lfRole.liferayRoleID = ? AND ";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_1 = "lfRole.permission IS NULL";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_NULL =
        "lfRole.permission IS NULL";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_NULL_2 =
        "lfRole.permission IS NULL ";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_2 = "lfRole.permission = ?";
    private static final String _FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_3 = "(lfRole.permission IS NULL OR lfRole.permission = ?)";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_NULL =
        "lfRole.isDefault IS NULL";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_NULL_2 =
        "lfRole.isDefault IS NULL  AND ";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_2 = "lfRole.isDefault = ? AND ";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_1 =
        "lfRole.permission IS NULL";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_NULL =
        "lfRole.permission IS NULL";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_NULL_2 =
        "lfRole.permission IS NULL ";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_2 =
        "lfRole.permission = ?";
    private static final String _FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_3 =
        "(lfRole.permission IS NULL OR lfRole.permission = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRole.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRole exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRole exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRolePersistenceImpl.class);
    private static LFRole _nullLFRole = new LFRoleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRole> toCacheModel() {
                return _nullLFRoleCacheModel;
            }
        };

    private static CacheModel<LFRole> _nullLFRoleCacheModel = new CacheModel<LFRole>() {
            public LFRole toEntityModel() {
                return _nullLFRole;
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
     * Caches the l f role in the entity cache if it is enabled.
     *
     * @param lfRole the l f role
     */
    public void cacheResult(LFRole lfRole) {
        EntityCacheUtil.putResult(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleImpl.class, lfRole.getPrimaryKey(), lfRole);

        lfRole.resetOriginalValues();
    }

    /**
     * Caches the l f roles in the entity cache if it is enabled.
     *
     * @param lfRoles the l f roles
     */
    public void cacheResult(List<LFRole> lfRoles) {
        for (LFRole lfRole : lfRoles) {
            if (EntityCacheUtil.getResult(
                        LFRoleModelImpl.ENTITY_CACHE_ENABLED, LFRoleImpl.class,
                        lfRole.getPrimaryKey()) == null) {
                cacheResult(lfRole);
            } else {
                lfRole.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f roles.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRoleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRoleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f role.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRole lfRole) {
        EntityCacheUtil.removeResult(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleImpl.class, lfRole.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFRole> lfRoles) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRole lfRole : lfRoles) {
            EntityCacheUtil.removeResult(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
                LFRoleImpl.class, lfRole.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f role with the primary key. Does not add the l f role to the database.
     *
     * @param id the primary key for the new l f role
     * @return the new l f role
     */
    public LFRole create(long id) {
        LFRole lfRole = new LFRoleImpl();

        lfRole.setNew(true);
        lfRole.setPrimaryKey(id);

        return lfRole;
    }

    /**
     * Removes the l f role with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f role
     * @return the l f role that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole remove(long id) throws NoSuchLFRoleException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f role with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f role
     * @return the l f role that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRole remove(Serializable primaryKey)
        throws NoSuchLFRoleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRole lfRole = (LFRole) session.get(LFRoleImpl.class, primaryKey);

            if (lfRole == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRole);
        } catch (NoSuchLFRoleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRole removeImpl(LFRole lfRole) throws SystemException {
        lfRole = toUnwrappedModel(lfRole);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfRole);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfRole);

        return lfRole;
    }

    @Override
    public LFRole updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole, boolean merge)
        throws SystemException {
        lfRole = toUnwrappedModel(lfRole);

        boolean isNew = lfRole.isNew();

        LFRoleModelImpl lfRoleModelImpl = (LFRoleModelImpl) lfRole;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfRole, merge);

            lfRole.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRoleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfRoleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMISSION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfRoleModelImpl.getOriginalPermission()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMISSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMISSION,
                    args);

                args = new Object[] { lfRoleModelImpl.getPermission() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMISSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMISSION,
                    args);
            }

            if ((lfRoleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDANDPERMISSION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfRoleModelImpl.getOriginalLiferayRoleID(),
                        
                        lfRoleModelImpl.getOriginalPermission()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDANDPERMISSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDANDPERMISSION,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfRoleModelImpl.getLiferayRoleID(),
                        
                        lfRoleModelImpl.getPermission()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLEIDANDPERMISSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDANDPERMISSION,
                    args);
            }

            if ((lfRoleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTANDPERMISSION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Boolean.valueOf(   */
                        lfRoleModelImpl.getOriginalIsDefault(),
                        
                        lfRoleModelImpl.getOriginalPermission()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTANDPERMISSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTANDPERMISSION,
                    args);

                args = new Object[] {
                        /* Boolean.valueOf( */
                        lfRoleModelImpl.getIsDefault(),
                        
                        lfRoleModelImpl.getPermission()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEFAULTANDPERMISSION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTANDPERMISSION,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
            LFRoleImpl.class, lfRole.getPrimaryKey(), lfRole);

        return lfRole;
    }

    protected LFRole toUnwrappedModel(LFRole lfRole) {
        if (lfRole instanceof LFRoleImpl) {
            return lfRole;
        }

        LFRoleImpl lfRoleImpl = new LFRoleImpl();

        lfRoleImpl.setNew(lfRole.isNew());
        lfRoleImpl.setPrimaryKey(lfRole.getPrimaryKey());

        lfRoleImpl.setId(lfRole.getId());
        lfRoleImpl.setLiferayRoleID(lfRole.getLiferayRoleID());
        lfRoleImpl.setPermission(lfRole.getPermission());
        lfRoleImpl.setIsDefault(lfRole.getIsDefault());

        return lfRoleImpl;
    }

    /**
     * Returns the l f role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f role
     * @return the l f role
     * @throws com.liferay.portal.NoSuchModelException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRole findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f role with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRoleException} if it could not be found.
     *
     * @param id the primary key of the l f role
     * @return the l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByPrimaryKey(long id)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByPrimaryKey(id);

        if (lfRole == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfRole;
    }

    /**
     * Returns the l f role with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f role
     * @return the l f role, or <code>null</code> if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRole fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f role with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f role
     * @return the l f role, or <code>null</code> if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByPrimaryKey(long id) throws SystemException {
        LFRole lfRole = (LFRole) EntityCacheUtil.getResult(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
                LFRoleImpl.class, id);

        if (lfRole == _nullLFRole) {
            return null;
        }

        if (lfRole == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfRole = (LFRole) session.get(LFRoleImpl.class, Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfRole != null) {
                    cacheResult(lfRole);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFRoleModelImpl.ENTITY_CACHE_ENABLED,
                        LFRoleImpl.class, id, _nullLFRole);
                }

                closeSession(session);
            }
        }

        return lfRole;
    }

    /**
     * Returns all the l f roles where permission = &#63;.
     *
     * @param permission the permission
     * @return the matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByPermission(String permission)
        throws SystemException {
        return findByPermission(permission, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f roles where permission = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param permission the permission
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @return the range of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByPermission(String permission, int start, int end)
        throws SystemException {
        return findByPermission(permission, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f roles where permission = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param permission the permission
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByPermission(String permission, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMISSION;
            finderArgs = new Object[] { permission };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMISSION;
            finderArgs = new Object[] { permission, start, end, orderByComparator };
        }

        List<LFRole> list = (List<LFRole>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRole lfRole : list) {
                if (!Validator.equals(permission, lfRole.getPermission())) {
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

            query.append(_SQL_SELECT_LFROLE_WHERE);

            if (permission == null) {
                query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_1);
            } else {
                if (permission.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_3);
                } else {
                    query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_2);
                }
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

                if (permission != null) {
                    qPos.add(permission);
                }

                list = (List<LFRole>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first l f role in the ordered set where permission = &#63;.
     *
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByPermission_First(String permission,
        OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByPermission_First(permission, orderByComparator);

        if (lfRole != null) {
            return lfRole;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("permission=");
        msg.append(permission);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRoleException(msg.toString());
    }

    /**
     * Returns the first l f role in the ordered set where permission = &#63;.
     *
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByPermission_First(String permission,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFRole> list = findByPermission(permission, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f role in the ordered set where permission = &#63;.
     *
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByPermission_Last(String permission,
        OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByPermission_Last(permission, orderByComparator);

        if (lfRole != null) {
            return lfRole;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("permission=");
        msg.append(permission);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRoleException(msg.toString());
    }

    /**
     * Returns the last l f role in the ordered set where permission = &#63;.
     *
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByPermission_Last(String permission,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPermission(permission);

        List<LFRole> list = findByPermission(permission, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f roles before and after the current l f role in the ordered set where permission = &#63;.
     *
     * @param id the primary key of the current l f role
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole[] findByPermission_PrevAndNext(long id, String permission,
        OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRole[] array = new LFRoleImpl[3];

            array[0] = getByPermission_PrevAndNext(session, lfRole, permission,
                    orderByComparator, true);

            array[1] = lfRole;

            array[2] = getByPermission_PrevAndNext(session, lfRole, permission,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRole getByPermission_PrevAndNext(Session session,
        LFRole lfRole, String permission, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFROLE_WHERE);

        if (permission == null) {
            query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_1);
        } else {
            if (permission.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_3);
            } else {
                query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_2);
            }
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

        if (permission != null) {
            qPos.add(permission);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfRole);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRole> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f roles where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @return the matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByRoleIDAndPermission(Integer liferayRoleID,
        String permission) throws SystemException {
        return findByRoleIDAndPermission(liferayRoleID, permission,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f roles where liferayRoleID = &#63; and permission = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @return the range of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByRoleIDAndPermission(Integer liferayRoleID,
        String permission, int start, int end) throws SystemException {
        return findByRoleIDAndPermission(liferayRoleID, permission, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f roles where liferayRoleID = &#63; and permission = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByRoleIDAndPermission(Integer liferayRoleID,
        String permission, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLEIDANDPERMISSION;
            finderArgs = new Object[] { liferayRoleID, permission };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLEIDANDPERMISSION;
            finderArgs = new Object[] {
                    liferayRoleID, permission,
                    
                    start, end, orderByComparator
                };
        }

        List<LFRole> list = (List<LFRole>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRole lfRole : list) {
                if (!Validator.equals(liferayRoleID, lfRole.getLiferayRoleID()) ||
                        !Validator.equals(permission, lfRole.getPermission())) {
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

            query.append(_SQL_SELECT_LFROLE_WHERE);

            if (liferayRoleID == null) {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_2);
            }

            if (permission == null) {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_1);
            } else {
                if (permission.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_3);
                } else {
                    query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_2);
                }
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

                if (liferayRoleID != null) {
                    qPos.add(liferayRoleID.intValue());
                }

                if (permission != null) {
                    qPos.add(permission);
                }

                list = (List<LFRole>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByRoleIDAndPermission_First(Integer liferayRoleID,
        String permission, OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByRoleIDAndPermission_First(liferayRoleID,
                permission, orderByComparator);

        if (lfRole != null) {
            return lfRole;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("liferayRoleID=");
        msg.append(liferayRoleID);

        msg.append(", permission=");
        msg.append(permission);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRoleException(msg.toString());
    }

    /**
     * Returns the first l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByRoleIDAndPermission_First(Integer liferayRoleID,
        String permission, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFRole> list = findByRoleIDAndPermission(liferayRoleID,
                permission, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByRoleIDAndPermission_Last(Integer liferayRoleID,
        String permission, OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByRoleIDAndPermission_Last(liferayRoleID,
                permission, orderByComparator);

        if (lfRole != null) {
            return lfRole;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("liferayRoleID=");
        msg.append(liferayRoleID);

        msg.append(", permission=");
        msg.append(permission);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRoleException(msg.toString());
    }

    /**
     * Returns the last l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByRoleIDAndPermission_Last(Integer liferayRoleID,
        String permission, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByRoleIDAndPermission(liferayRoleID, permission);

        List<LFRole> list = findByRoleIDAndPermission(liferayRoleID,
                permission, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f roles before and after the current l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param id the primary key of the current l f role
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole[] findByRoleIDAndPermission_PrevAndNext(long id,
        Integer liferayRoleID, String permission,
        OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRole[] array = new LFRoleImpl[3];

            array[0] = getByRoleIDAndPermission_PrevAndNext(session, lfRole,
                    liferayRoleID, permission, orderByComparator, true);

            array[1] = lfRole;

            array[2] = getByRoleIDAndPermission_PrevAndNext(session, lfRole,
                    liferayRoleID, permission, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRole getByRoleIDAndPermission_PrevAndNext(Session session,
        LFRole lfRole, Integer liferayRoleID, String permission,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFROLE_WHERE);

        if (liferayRoleID == null) {
            query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_2);
        }

        if (permission == null) {
            query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_1);
        } else {
            if (permission.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_3);
            } else {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_2);
            }
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

        if (liferayRoleID != null) {
            qPos.add(liferayRoleID.intValue());
        }

        if (permission != null) {
            qPos.add(permission);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfRole);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRole> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f roles where isDefault = &#63; and permission = &#63;.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @return the matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByDefaultAndPermission(Boolean isDefault,
        String permission) throws SystemException {
        return findByDefaultAndPermission(isDefault, permission,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f roles where isDefault = &#63; and permission = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param isDefault the is default
     * @param permission the permission
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @return the range of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByDefaultAndPermission(Boolean isDefault,
        String permission, int start, int end) throws SystemException {
        return findByDefaultAndPermission(isDefault, permission, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f roles where isDefault = &#63; and permission = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param isDefault the is default
     * @param permission the permission
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findByDefaultAndPermission(Boolean isDefault,
        String permission, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEFAULTANDPERMISSION;
            finderArgs = new Object[] { isDefault, permission };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEFAULTANDPERMISSION;
            finderArgs = new Object[] {
                    isDefault, permission,
                    
                    start, end, orderByComparator
                };
        }

        List<LFRole> list = (List<LFRole>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRole lfRole : list) {
                if (!Validator.equals(isDefault, lfRole.getIsDefault()) ||
                        !Validator.equals(permission, lfRole.getPermission())) {
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

            query.append(_SQL_SELECT_LFROLE_WHERE);

            if (isDefault == null) {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_2);
            }

            if (permission == null) {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_1);
            } else {
                if (permission.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_3);
                } else {
                    query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_2);
                }
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

                if (isDefault != null) {
                    qPos.add(isDefault.booleanValue());
                }

                if (permission != null) {
                    qPos.add(permission);
                }

                list = (List<LFRole>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first l f role in the ordered set where isDefault = &#63; and permission = &#63;.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByDefaultAndPermission_First(Boolean isDefault,
        String permission, OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByDefaultAndPermission_First(isDefault,
                permission, orderByComparator);

        if (lfRole != null) {
            return lfRole;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("isDefault=");
        msg.append(isDefault);

        msg.append(", permission=");
        msg.append(permission);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRoleException(msg.toString());
    }

    /**
     * Returns the first l f role in the ordered set where isDefault = &#63; and permission = &#63;.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByDefaultAndPermission_First(Boolean isDefault,
        String permission, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFRole> list = findByDefaultAndPermission(isDefault, permission,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f role in the ordered set where isDefault = &#63; and permission = &#63;.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole findByDefaultAndPermission_Last(Boolean isDefault,
        String permission, OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = fetchByDefaultAndPermission_Last(isDefault, permission,
                orderByComparator);

        if (lfRole != null) {
            return lfRole;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("isDefault=");
        msg.append(isDefault);

        msg.append(", permission=");
        msg.append(permission);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRoleException(msg.toString());
    }

    /**
     * Returns the last l f role in the ordered set where isDefault = &#63; and permission = &#63;.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole fetchByDefaultAndPermission_Last(Boolean isDefault,
        String permission, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByDefaultAndPermission(isDefault, permission);

        List<LFRole> list = findByDefaultAndPermission(isDefault, permission,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f roles before and after the current l f role in the ordered set where isDefault = &#63; and permission = &#63;.
     *
     * @param id the primary key of the current l f role
     * @param isDefault the is default
     * @param permission the permission
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f role
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRole[] findByDefaultAndPermission_PrevAndNext(long id,
        Boolean isDefault, String permission,
        OrderByComparator orderByComparator)
        throws NoSuchLFRoleException, SystemException {
        LFRole lfRole = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRole[] array = new LFRoleImpl[3];

            array[0] = getByDefaultAndPermission_PrevAndNext(session, lfRole,
                    isDefault, permission, orderByComparator, true);

            array[1] = lfRole;

            array[2] = getByDefaultAndPermission_PrevAndNext(session, lfRole,
                    isDefault, permission, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRole getByDefaultAndPermission_PrevAndNext(Session session,
        LFRole lfRole, Boolean isDefault, String permission,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFROLE_WHERE);

        if (isDefault == null) {
            query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_2);
        }

        if (permission == null) {
            query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_1);
        } else {
            if (permission.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_3);
            } else {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_2);
            }
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

        if (isDefault != null) {
            qPos.add(isDefault.booleanValue());
        }

        if (permission != null) {
            qPos.add(permission);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfRole);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRole> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f roles.
     *
     * @return the l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f roles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @return the range of l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f roles.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f roles
     * @param end the upper bound of the range of l f roles (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f roles
     * @throws SystemException if a system exception occurred
     */
    public List<LFRole> findAll(int start, int end,
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

        List<LFRole> list = (List<LFRole>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFROLE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFROLE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFRole>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFRole>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f roles where permission = &#63; from the database.
     *
     * @param permission the permission
     * @throws SystemException if a system exception occurred
     */
    public void removeByPermission(String permission) throws SystemException {
        for (LFRole lfRole : findByPermission(permission)) {
            remove(lfRole);
        }
    }

    /**
     * Removes all the l f roles where liferayRoleID = &#63; and permission = &#63; from the database.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @throws SystemException if a system exception occurred
     */
    public void removeByRoleIDAndPermission(Integer liferayRoleID,
        String permission) throws SystemException {
        for (LFRole lfRole : findByRoleIDAndPermission(liferayRoleID, permission)) {
            remove(lfRole);
        }
    }

    /**
     * Removes all the l f roles where isDefault = &#63; and permission = &#63; from the database.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @throws SystemException if a system exception occurred
     */
    public void removeByDefaultAndPermission(Boolean isDefault,
        String permission) throws SystemException {
        for (LFRole lfRole : findByDefaultAndPermission(isDefault, permission)) {
            remove(lfRole);
        }
    }

    /**
     * Removes all the l f roles from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFRole lfRole : findAll()) {
            remove(lfRole);
        }
    }

    /**
     * Returns the number of l f roles where permission = &#63;.
     *
     * @param permission the permission
     * @return the number of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public int countByPermission(String permission) throws SystemException {
        Object[] finderArgs = new Object[] { permission };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERMISSION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFROLE_WHERE);

            if (permission == null) {
                query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_1);
            } else {
                if (permission.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_3);
                } else {
                    query.append(_FINDER_COLUMN_PERMISSION_PERMISSION_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (permission != null) {
                    qPos.add(permission);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERMISSION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f roles where liferayRoleID = &#63; and permission = &#63;.
     *
     * @param liferayRoleID the liferay role i d
     * @param permission the permission
     * @return the number of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public int countByRoleIDAndPermission(Integer liferayRoleID,
        String permission) throws SystemException {
        Object[] finderArgs = new Object[] { liferayRoleID, permission };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLEIDANDPERMISSION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFROLE_WHERE);

            if (liferayRoleID == null) {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_LIFERAYROLEID_2);
            }

            if (permission == null) {
                query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_1);
            } else {
                if (permission.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_3);
                } else {
                    query.append(_FINDER_COLUMN_ROLEIDANDPERMISSION_PERMISSION_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (liferayRoleID != null) {
                    qPos.add(liferayRoleID.intValue());
                }

                if (permission != null) {
                    qPos.add(permission);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEIDANDPERMISSION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f roles where isDefault = &#63; and permission = &#63;.
     *
     * @param isDefault the is default
     * @param permission the permission
     * @return the number of matching l f roles
     * @throws SystemException if a system exception occurred
     */
    public int countByDefaultAndPermission(Boolean isDefault, String permission)
        throws SystemException {
        Object[] finderArgs = new Object[] { isDefault, permission };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEFAULTANDPERMISSION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFROLE_WHERE);

            if (isDefault == null) {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_ISDEFAULT_2);
            }

            if (permission == null) {
                query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_1);
            } else {
                if (permission.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_3);
                } else {
                    query.append(_FINDER_COLUMN_DEFAULTANDPERMISSION_PERMISSION_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (isDefault != null) {
                    qPos.add(isDefault.booleanValue());
                }

                if (permission != null) {
                    qPos.add(permission);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEFAULTANDPERMISSION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f roles.
     *
     * @return the number of l f roles
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFROLE);

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
     * Initializes the l f role persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRole")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRole>> listenersList = new ArrayList<ModelListener<LFRole>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRole>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRoleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityException;
import com.arcusys.learn.persistence.liferay.model.LFActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl;
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
 * The persistence implementation for the l f activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityPersistence
 * @see LFActivityUtil
 * @generated
 */
public class LFActivityPersistenceImpl extends BasePersistenceImpl<LFActivity>
    implements LFActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityUtil} to access the l f activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_PACKAGEANDID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByPackageAndID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityModelImpl.ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEANDID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageAndID",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Integer.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageIDAndOrganizationID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPackageIDAndOrganizationID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndOrganizationID",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageIDAndParentID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPackageIDAndParentID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndParentID",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFACTIVITY = "SELECT lfActivity FROM LFActivity lfActivity";
    private static final String _SQL_SELECT_LFACTIVITY_WHERE = "SELECT lfActivity FROM LFActivity lfActivity WHERE ";
    private static final String _SQL_COUNT_LFACTIVITY = "SELECT COUNT(lfActivity) FROM LFActivity lfActivity";
    private static final String _SQL_COUNT_LFACTIVITY_WHERE = "SELECT COUNT(lfActivity) FROM LFActivity lfActivity WHERE ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL = "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL_2 = "lfActivity.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_PACKAGEID_2 = "lfActivity.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_1 = "lfActivity.id IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_NULL = "lfActivity.id IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_NULL_2 = "lfActivity.id IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_2 = "lfActivity.id = ?";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_3 = "(lfActivity.id IS NULL OR lfActivity.id = ?)";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfActivity.packageID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfActivity.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL =
        "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2 =
        "lfActivity.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2 =
        "lfActivity.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1 =
        "lfActivity.organizationID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_NULL =
        "lfActivity.organizationID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_NULL_2 =
        "lfActivity.organizationID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2 =
        "lfActivity.organizationID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3 =
        "(lfActivity.organizationID IS NULL OR lfActivity.organizationID = ?)";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL =
        "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2 =
        "lfActivity.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2 = "lfActivity.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1 = "lfActivity.parentID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_NULL =
        "lfActivity.parentID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_NULL_2 =
        "lfActivity.parentID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2 = "lfActivity.parentID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3 = "(lfActivity.parentID IS NULL OR lfActivity.parentID = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityPersistenceImpl.class);
    private static LFActivity _nullLFActivity = new LFActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivity> toCacheModel() {
                return _nullLFActivityCacheModel;
            }
        };

    private static CacheModel<LFActivity> _nullLFActivityCacheModel = new CacheModel<LFActivity>() {
            public LFActivity toEntityModel() {
                return _nullLFActivity;
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
     * Caches the l f activity in the entity cache if it is enabled.
     *
     * @param lfActivity the l f activity
     */
    public void cacheResult(LFActivity lfActivity) {
        EntityCacheUtil.putResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityImpl.class, lfActivity.getPrimaryKey(), lfActivity);

        boolean noNullsInPACKAGEANDID = true;

        if (lfActivity.getPackageID() == null) {
            noNullsInPACKAGEANDID = false;
        }

        if (noNullsInPACKAGEANDID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                new Object[] {
                    Integer.valueOf(lfActivity.getPackageID()),
                    
                lfActivity.getId()
                }, lfActivity);
        }

        lfActivity.resetOriginalValues();
    }

    /**
     * Caches the l f activities in the entity cache if it is enabled.
     *
     * @param lfActivities the l f activities
     */
    public void cacheResult(List<LFActivity> lfActivities) {
        for (LFActivity lfActivity : lfActivities) {
            if (EntityCacheUtil.getResult(
                        LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityImpl.class, lfActivity.getPrimaryKey()) == null) {
                cacheResult(lfActivity);
            } else {
                lfActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivity lfActivity) {
        EntityCacheUtil.removeResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityImpl.class, lfActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfActivity);
    }

    @Override
    public void clearCache(List<LFActivity> lfActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivity lfActivity : lfActivities) {
            EntityCacheUtil.removeResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityImpl.class, lfActivity.getPrimaryKey());

            clearUniqueFindersCache(lfActivity);
        }
    }

    protected void clearUniqueFindersCache(LFActivity lfActivity) {
        boolean noNullsInPACKAGEANDID = true;

        if (lfActivity.getPackageID() == null) {
            noNullsInPACKAGEANDID = false;
        }

        if (noNullsInPACKAGEANDID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                new Object[] {
                    Integer.valueOf(lfActivity.getPackageID()),
                    
                lfActivity.getId()
                });
        }
    }

    /**
     * Creates a new l f activity with the primary key. Does not add the l f activity to the database.
     *
     * @param indexNumber the primary key for the new l f activity
     * @return the new l f activity
     */
    public LFActivity create(long indexNumber) {
        LFActivity lfActivity = new LFActivityImpl();

        lfActivity.setNew(true);
        lfActivity.setPrimaryKey(indexNumber);

        return lfActivity;
    }

    /**
     * Removes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param indexNumber the primary key of the l f activity
     * @return the l f activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity remove(long indexNumber)
        throws NoSuchLFActivityException, SystemException {
        return remove(Long.valueOf(indexNumber));
    }

    /**
     * Removes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity
     * @return the l f activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity remove(Serializable primaryKey)
        throws NoSuchLFActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivity lfActivity = (LFActivity) session.get(LFActivityImpl.class,
                    primaryKey);

            if (lfActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivity);
        } catch (NoSuchLFActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivity removeImpl(LFActivity lfActivity)
        throws SystemException {
        lfActivity = toUnwrappedModel(lfActivity);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfActivity);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfActivity);

        return lfActivity;
    }

    @Override
    public LFActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity,
        boolean merge) throws SystemException {
        lfActivity = toUnwrappedModel(lfActivity);

        boolean isNew = lfActivity.isNew();

        LFActivityModelImpl lfActivityModelImpl = (LFActivityModelImpl) lfActivity;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfActivity, merge);

            lfActivity.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfActivityModelImpl.getOriginalPackageID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfActivityModelImpl.getPackageID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }

            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfActivityModelImpl.getOriginalPackageID(),
                        
                        lfActivityModelImpl.getOriginalOrganizationID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfActivityModelImpl.getPackageID(),
                        
                        lfActivityModelImpl.getOrganizationID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID,
                    args);
            }

            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfActivityModelImpl.getOriginalPackageID(),
                        
                        lfActivityModelImpl.getOriginalParentID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfActivityModelImpl.getPackageID(),
                        
                        lfActivityModelImpl.getParentID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityImpl.class, lfActivity.getPrimaryKey(), lfActivity);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                new Object[] { /*Integer.valueOf( */
                lfActivity.getPackageID()/*) */
                , lfActivity.getId() }, lfActivity);
        } else {
            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_PACKAGEANDID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Integer.valueOf( */
                        lfActivityModelImpl.getOriginalPackageID(),
                        
                        lfActivityModelImpl.getOriginalId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEANDID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                    new Object[] { /*        Integer.valueOf( */
                    lfActivity.getPackageID()/*        ) */
                    , lfActivity.getId() }, lfActivity);
            }
        }

        return lfActivity;
    }

    protected LFActivity toUnwrappedModel(LFActivity lfActivity) {
        if (lfActivity instanceof LFActivityImpl) {
            return lfActivity;
        }

        LFActivityImpl lfActivityImpl = new LFActivityImpl();

        lfActivityImpl.setNew(lfActivity.isNew());
        lfActivityImpl.setPrimaryKey(lfActivity.getPrimaryKey());

        lfActivityImpl.setIndexNumber(lfActivity.getIndexNumber());
        lfActivityImpl.setId(lfActivity.getId());
        lfActivityImpl.setPackageID(lfActivity.getPackageID());
        lfActivityImpl.setOrganizationID(lfActivity.getOrganizationID());
        lfActivityImpl.setParentID(lfActivity.getParentID());
        lfActivityImpl.setTitle(lfActivity.getTitle());
        lfActivityImpl.setIdentifierRef(lfActivity.getIdentifierRef());
        lfActivityImpl.setResourceParameters(lfActivity.getResourceParameters());
        lfActivityImpl.setHideLMSUI(lfActivity.getHideLMSUI());
        lfActivityImpl.setVisible(lfActivity.isVisible());
        lfActivityImpl.setObjectivesGlobalToSystem(lfActivity.isObjectivesGlobalToSystem());
        lfActivityImpl.setSharedDataGlobalToSystem(lfActivity.isSharedDataGlobalToSystem());
        lfActivityImpl.setMasteryScore(lfActivity.getMasteryScore());
        lfActivityImpl.setMaxTimeAllowed(lfActivity.getMaxTimeAllowed());

        return lfActivityImpl;
    }

    /**
     * Returns the l f activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity
     * @return the l f activity
     * @throws com.liferay.portal.NoSuchModelException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
     *
     * @param indexNumber the primary key of the l f activity
     * @return the l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPrimaryKey(long indexNumber)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPrimaryKey(indexNumber);

        if (lfActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + indexNumber);
            }

            throw new NoSuchLFActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                indexNumber);
        }

        return lfActivity;
    }

    /**
     * Returns the l f activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity
     * @return the l f activity, or <code>null</code> if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param indexNumber the primary key of the l f activity
     * @return the l f activity, or <code>null</code> if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPrimaryKey(long indexNumber)
        throws SystemException {
        LFActivity lfActivity = (LFActivity) EntityCacheUtil.getResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityImpl.class, indexNumber);

        if (lfActivity == _nullLFActivity) {
            return null;
        }

        if (lfActivity == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfActivity = (LFActivity) session.get(LFActivityImpl.class,
                        Long.valueOf(indexNumber));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfActivity != null) {
                    cacheResult(lfActivity);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityImpl.class, indexNumber, _nullLFActivity);
                }

                closeSession(session);
            }
        }

        return lfActivity;
    }

    /**
     * Returns the l f activity where packageID = &#63; and id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageAndID(Integer packageID, String id)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageAndID(packageID, id);

        if (lfActivity == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("packageID=");
            msg.append(packageID);

            msg.append(", id=");
            msg.append(id);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFActivityException(msg.toString());
        }

        return lfActivity;
    }

    /**
     * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageAndID(Integer packageID, String id)
        throws SystemException {
        return fetchByPackageAndID(packageID, id, true);
    }

    /**
     * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param packageID the package i d
     * @param id the ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageAndID(Integer packageID, String id,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { packageID, id };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                    finderArgs, this);
        }

        if (result instanceof LFActivity) {
            LFActivity lfActivity = (LFActivity) result;

            if (!Validator.equals(packageID, lfActivity.getPackageID()) ||
                    !Validator.equals(id, lfActivity.getId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_2);
            }

            if (id == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_ID_1);
            } else {
                if (id.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_2);
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

                if (id != null) {
                    qPos.add(id);
                }

                List<LFActivity> list = q.list();

                result = list;

                LFActivity lfActivity = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                        finderArgs, list);
                } else {
                    lfActivity = list.get(0);

                    cacheResult(lfActivity);

                    if ((lfActivity.getPackageID() != packageID) ||
                            (lfActivity.getId() == null) ||
                            !lfActivity.getId().equals(id)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                            finderArgs, lfActivity);
                    }
                }

                return lfActivity;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFActivity) result;
            }
        }
    }

    /**
     * Returns all the l f activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageID(Integer packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageID(Integer packageID, int start,
        int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageID(Integer packageID, int start,
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

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivity lfActivity : list) {
                if (!Validator.equals(packageID, lfActivity.getPackageID())) {
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

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

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

                list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the first l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivity> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        List<LFActivity> list = findByPackageID(packageID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63;.
     *
     * @param indexNumber the primary key of the current l f activity
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity[] findByPackageID_PrevAndNext(long indexNumber,
        Integer packageID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPrimaryKey(indexNumber);

        Session session = null;

        try {
            session = openSession();

            LFActivity[] array = new LFActivityImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfActivity,
                    packageID, orderByComparator, true);

            array[1] = lfActivity;

            array[2] = getByPackageID_PrevAndNext(session, lfActivity,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivity getByPackageID_PrevAndNext(Session session,
        LFActivity lfActivity, Integer packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITY_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @return the matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageIDAndOrganizationID(
        Integer packageID, String organizationID) throws SystemException {
        return findByPackageIDAndOrganizationID(packageID, organizationID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageIDAndOrganizationID(
        Integer packageID, String organizationID, int start, int end)
        throws SystemException {
        return findByPackageIDAndOrganizationID(packageID, organizationID,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageIDAndOrganizationID(
        Integer packageID, String organizationID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID;
            finderArgs = new Object[] { packageID, organizationID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID;
            finderArgs = new Object[] {
                    packageID, organizationID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivity lfActivity : list) {
                if (!Validator.equals(packageID, lfActivity.getPackageID()) ||
                        !Validator.equals(organizationID,
                            lfActivity.getOrganizationID())) {
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

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2);
            }

            if (organizationID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1);
            } else {
                if (organizationID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2);
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

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (organizationID != null) {
                    qPos.add(organizationID);
                }

                list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageIDAndOrganizationID_First(
        Integer packageID, String organizationID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndOrganizationID_First(packageID,
                organizationID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", organizationID=");
        msg.append(organizationID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageIDAndOrganizationID_First(
        Integer packageID, String organizationID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivity> list = findByPackageIDAndOrganizationID(packageID,
                organizationID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageIDAndOrganizationID_Last(Integer packageID,
        String organizationID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndOrganizationID_Last(packageID,
                organizationID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", organizationID=");
        msg.append(organizationID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageIDAndOrganizationID_Last(
        Integer packageID, String organizationID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageIDAndOrganizationID(packageID, organizationID);

        List<LFActivity> list = findByPackageIDAndOrganizationID(packageID,
                organizationID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param indexNumber the primary key of the current l f activity
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity[] findByPackageIDAndOrganizationID_PrevAndNext(
        long indexNumber, Integer packageID, String organizationID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPrimaryKey(indexNumber);

        Session session = null;

        try {
            session = openSession();

            LFActivity[] array = new LFActivityImpl[3];

            array[0] = getByPackageIDAndOrganizationID_PrevAndNext(session,
                    lfActivity, packageID, organizationID, orderByComparator,
                    true);

            array[1] = lfActivity;

            array[2] = getByPackageIDAndOrganizationID_PrevAndNext(session,
                    lfActivity, packageID, organizationID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivity getByPackageIDAndOrganizationID_PrevAndNext(
        Session session, LFActivity lfActivity, Integer packageID,
        String organizationID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITY_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2);
        }

        if (organizationID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1);
        } else {
            if (organizationID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2);
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

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (organizationID != null) {
            qPos.add(organizationID);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f activities where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @return the matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageIDAndParentID(Integer packageID,
        String parentID) throws SystemException {
        return findByPackageIDAndParentID(packageID, parentID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activities where packageID = &#63; and parentID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageIDAndParentID(Integer packageID,
        String parentID, int start, int end) throws SystemException {
        return findByPackageIDAndParentID(packageID, parentID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities where packageID = &#63; and parentID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findByPackageIDAndParentID(Integer packageID,
        String parentID, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID;
            finderArgs = new Object[] { packageID, parentID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID;
            finderArgs = new Object[] {
                    packageID, parentID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivity lfActivity : list) {
                if (!Validator.equals(packageID, lfActivity.getPackageID()) ||
                        !Validator.equals(parentID, lfActivity.getParentID())) {
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

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2);
            }

            if (parentID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1);
            } else {
                if (parentID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2);
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

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (parentID != null) {
                    qPos.add(parentID);
                }

                list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageIDAndParentID_First(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndParentID_First(packageID,
                parentID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageIDAndParentID_First(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFActivity> list = findByPackageIDAndParentID(packageID, parentID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity findByPackageIDAndParentID_Last(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndParentID_Last(packageID,
                parentID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity fetchByPackageIDAndParentID_Last(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByPackageIDAndParentID(packageID, parentID);

        List<LFActivity> list = findByPackageIDAndParentID(packageID, parentID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param indexNumber the primary key of the current l f activity
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFActivity[] findByPackageIDAndParentID_PrevAndNext(
        long indexNumber, Integer packageID, String parentID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPrimaryKey(indexNumber);

        Session session = null;

        try {
            session = openSession();

            LFActivity[] array = new LFActivityImpl[3];

            array[0] = getByPackageIDAndParentID_PrevAndNext(session,
                    lfActivity, packageID, parentID, orderByComparator, true);

            array[1] = lfActivity;

            array[2] = getByPackageIDAndParentID_PrevAndNext(session,
                    lfActivity, packageID, parentID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivity getByPackageIDAndParentID_PrevAndNext(
        Session session, LFActivity lfActivity, Integer packageID,
        String parentID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITY_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2);
        }

        if (parentID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1);
        } else {
            if (parentID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2);
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

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (parentID != null) {
            qPos.add(parentID);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f activities.
     *
     * @return the l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f activities
     * @throws SystemException if a system exception occurred
     */
    public List<LFActivity> findAll(int start, int end,
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

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Removes the l f activity where packageID = &#63; and id = &#63; from the database.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the l f activity that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFActivity removeByPackageAndID(Integer packageID, String id)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPackageAndID(packageID, id);

        return remove(lfActivity);
    }

    /**
     * Removes all the l f activities where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByPackageID(Integer packageID) throws SystemException {
        for (LFActivity lfActivity : findByPackageID(packageID)) {
            remove(lfActivity);
        }
    }

    /**
     * Removes all the l f activities where packageID = &#63; and organizationID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByPackageIDAndOrganizationID(Integer packageID,
        String organizationID) throws SystemException {
        for (LFActivity lfActivity : findByPackageIDAndOrganizationID(
                packageID, organizationID)) {
            remove(lfActivity);
        }
    }

    /**
     * Removes all the l f activities where packageID = &#63; and parentID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByPackageIDAndParentID(Integer packageID, String parentID)
        throws SystemException {
        for (LFActivity lfActivity : findByPackageIDAndParentID(packageID,
                parentID)) {
            remove(lfActivity);
        }
    }

    /**
     * Removes all the l f activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFActivity lfActivity : findAll()) {
            remove(lfActivity);
        }
    }

    /**
     * Returns the number of l f activities where packageID = &#63; and id = &#63;.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public int countByPackageAndID(Integer packageID, String id)
        throws SystemException {
        Object[] finderArgs = new Object[] { packageID, id };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PACKAGEANDID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_2);
            }

            if (id == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_ID_1);
            } else {
                if (id.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_2);
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

                if (id != null) {
                    qPos.add(id);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEANDID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public int countByPackageID(Integer packageID) throws SystemException {
        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

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
     * Returns the number of l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public int countByPackageIDAndOrganizationID(Integer packageID,
        String organizationID) throws SystemException {
        Object[] finderArgs = new Object[] { packageID, organizationID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2);
            }

            if (organizationID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1);
            } else {
                if (organizationID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2);
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

                if (organizationID != null) {
                    qPos.add(organizationID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activities where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    public int countByPackageIDAndParentID(Integer packageID, String parentID)
        throws SystemException {
        Object[] finderArgs = new Object[] { packageID, parentID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2);
            }

            if (parentID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1);
            } else {
                if (parentID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2);
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

                if (parentID != null) {
                    qPos.add(parentID);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f activities.
     *
     * @return the number of l f activities
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITY);

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
     * Initializes the l f activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivity>> listenersList = new ArrayList<ModelListener<LFActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivity>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

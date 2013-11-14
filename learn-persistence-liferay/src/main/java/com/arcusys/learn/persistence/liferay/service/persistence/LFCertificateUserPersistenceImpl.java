package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl;
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
 * The persistence implementation for the l f certificate user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateUserPersistence
 * @see LFCertificateUserUtil
 * @generated
 */
public class LFCertificateUserPersistenceImpl extends BasePersistenceImpl<LFCertificateUser>
    implements LFCertificateUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateUserUtil} to access the l f certificate user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Integer.class.getName() },
            LFCertificateUserModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertificateID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
            new String[] { Integer.class.getName() },
            LFCertificateUserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUserIDAndCertificateID",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUserIDAndCertificateID",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFCertificateUserModelImpl.USERID_COLUMN_BITMASK |
            LFCertificateUserModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserIDAndCertificateID",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFCERTIFICATEUSER = "SELECT lfCertificateUser FROM LFCertificateUser lfCertificateUser";
    private static final String _SQL_SELECT_LFCERTIFICATEUSER_WHERE = "SELECT lfCertificateUser FROM LFCertificateUser lfCertificateUser WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATEUSER = "SELECT COUNT(lfCertificateUser) FROM LFCertificateUser lfCertificateUser";
    private static final String _SQL_COUNT_LFCERTIFICATEUSER_WHERE = "SELECT COUNT(lfCertificateUser) FROM LFCertificateUser lfCertificateUser WHERE ";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateUser.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateUser.certificateID IS NULL ";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateUser.certificateID = ?";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL = "lfCertificateUser.userID IS NULL";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL_2 = "lfCertificateUser.userID IS NULL ";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "lfCertificateUser.userID = ?";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL =
        "lfCertificateUser.userID IS NULL";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2 =
        "lfCertificateUser.userID IS NULL  AND ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2 = "lfCertificateUser.userID = ? AND ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL =
        "lfCertificateUser.certificateID IS NULL";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateUser.certificateID IS NULL ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2 =
        "lfCertificateUser.certificateID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateUserPersistenceImpl.class);
    private static LFCertificateUser _nullLFCertificateUser = new LFCertificateUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateUser> toCacheModel() {
                return _nullLFCertificateUserCacheModel;
            }
        };

    private static CacheModel<LFCertificateUser> _nullLFCertificateUserCacheModel =
        new CacheModel<LFCertificateUser>() {
            public LFCertificateUser toEntityModel() {
                return _nullLFCertificateUser;
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
     * Caches the l f certificate user in the entity cache if it is enabled.
     *
     * @param lfCertificateUser the l f certificate user
     */
    public void cacheResult(LFCertificateUser lfCertificateUser) {
        EntityCacheUtil.putResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey(),
            lfCertificateUser);

        lfCertificateUser.resetOriginalValues();
    }

    /**
     * Caches the l f certificate users in the entity cache if it is enabled.
     *
     * @param lfCertificateUsers the l f certificate users
     */
    public void cacheResult(List<LFCertificateUser> lfCertificateUsers) {
        for (LFCertificateUser lfCertificateUser : lfCertificateUsers) {
            if (EntityCacheUtil.getResult(
                        LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateUserImpl.class,
                        lfCertificateUser.getPrimaryKey()) == null) {
                cacheResult(lfCertificateUser);
            } else {
                lfCertificateUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificateUser lfCertificateUser) {
        EntityCacheUtil.removeResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFCertificateUser> lfCertificateUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateUser lfCertificateUser : lfCertificateUsers) {
            EntityCacheUtil.removeResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f certificate user with the primary key. Does not add the l f certificate user to the database.
     *
     * @param id the primary key for the new l f certificate user
     * @return the new l f certificate user
     */
    public LFCertificateUser create(long id) {
        LFCertificateUser lfCertificateUser = new LFCertificateUserImpl();

        lfCertificateUser.setNew(true);
        lfCertificateUser.setPrimaryKey(id);

        return lfCertificateUser;
    }

    /**
     * Removes the l f certificate user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f certificate user
     * @return the l f certificate user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser remove(long id)
        throws NoSuchLFCertificateUserException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f certificate user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate user
     * @return the l f certificate user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser remove(Serializable primaryKey)
        throws NoSuchLFCertificateUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateUser lfCertificateUser = (LFCertificateUser) session.get(LFCertificateUserImpl.class,
                    primaryKey);

            if (lfCertificateUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateUser);
        } catch (NoSuchLFCertificateUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateUser removeImpl(LFCertificateUser lfCertificateUser)
        throws SystemException {
        lfCertificateUser = toUnwrappedModel(lfCertificateUser);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfCertificateUser);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfCertificateUser);

        return lfCertificateUser;
    }

    @Override
    public LFCertificateUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser,
        boolean merge) throws SystemException {
        lfCertificateUser = toUnwrappedModel(lfCertificateUser);

        boolean isNew = lfCertificateUser.isNew();

        LFCertificateUserModelImpl lfCertificateUserModelImpl = (LFCertificateUserModelImpl) lfCertificateUser;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfCertificateUser, merge);

            lfCertificateUser.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfCertificateUserModelImpl.getOriginalCertificateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfCertificateUserModelImpl.getCertificateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfCertificateUserModelImpl.getOriginalUserID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfCertificateUserModelImpl.getUserID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((lfCertificateUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfCertificateUserModelImpl.getOriginalUserID(),
                        /* Integer.valueOf(   */
                        lfCertificateUserModelImpl.getOriginalCertificateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfCertificateUserModelImpl.getUserID(),
                        /* Integer.valueOf( */
                        lfCertificateUserModelImpl.getCertificateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey(),
            lfCertificateUser);

        return lfCertificateUser;
    }

    protected LFCertificateUser toUnwrappedModel(
        LFCertificateUser lfCertificateUser) {
        if (lfCertificateUser instanceof LFCertificateUserImpl) {
            return lfCertificateUser;
        }

        LFCertificateUserImpl lfCertificateUserImpl = new LFCertificateUserImpl();

        lfCertificateUserImpl.setNew(lfCertificateUser.isNew());
        lfCertificateUserImpl.setPrimaryKey(lfCertificateUser.getPrimaryKey());

        lfCertificateUserImpl.setId(lfCertificateUser.getId());
        lfCertificateUserImpl.setCertificateID(lfCertificateUser.getCertificateID());
        lfCertificateUserImpl.setUserID(lfCertificateUser.getUserID());

        return lfCertificateUserImpl;
    }

    /**
     * Returns the l f certificate user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate user
     * @return the l f certificate user
     * @throws com.liferay.portal.NoSuchModelException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f certificate user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException} if it could not be found.
     *
     * @param id the primary key of the l f certificate user
     * @return the l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByPrimaryKey(long id)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByPrimaryKey(id);

        if (lfCertificateUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFCertificateUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfCertificateUser;
    }

    /**
     * Returns the l f certificate user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate user
     * @return the l f certificate user, or <code>null</code> if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f certificate user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f certificate user
     * @return the l f certificate user, or <code>null</code> if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByPrimaryKey(long id)
        throws SystemException {
        LFCertificateUser lfCertificateUser = (LFCertificateUser) EntityCacheUtil.getResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateUserImpl.class, id);

        if (lfCertificateUser == _nullLFCertificateUser) {
            return null;
        }

        if (lfCertificateUser == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfCertificateUser = (LFCertificateUser) session.get(LFCertificateUserImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfCertificateUser != null) {
                    cacheResult(lfCertificateUser);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateUserImpl.class, id, _nullLFCertificateUser);
                }

                closeSession(session);
            }
        }

        return lfCertificateUser;
    }

    /**
     * Returns all the l f certificate users where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByCertificateID(Integer certificateID)
        throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByCertificateID(Integer certificateID,
        int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate users where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByCertificateID(Integer certificateID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] { certificateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] {
                    certificateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateUser lfCertificateUser : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateUser.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
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

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
                }

                list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByCertificateID_First(Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByCertificateID_First(Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateUser> list = findByCertificateID(certificateID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByCertificateID_Last(Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByCertificateID_Last(Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCertificateID(certificateID);

        List<LFCertificateUser> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate users before and after the current l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param id the primary key of the current l f certificate user
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser[] findByCertificateID_PrevAndNext(long id,
        Integer certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificateUser[] array = new LFCertificateUserImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateUser, certificateID, orderByComparator, true);

            array[1] = lfCertificateUser;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateUser, certificateID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateUser getByCertificateID_PrevAndNext(
        Session session, LFCertificateUser lfCertificateUser,
        Integer certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

        if (certificateID == null) {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
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

        if (certificateID != null) {
            qPos.add(certificateID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificate users where userID = &#63;.
     *
     * @param userID the user i d
     * @return the matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByUserID(Integer userID)
        throws SystemException {
        return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByUserID(Integer userID, int start,
        int end) throws SystemException {
        return findByUserID(userID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate users where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByUserID(Integer userID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateUser lfCertificateUser : list) {
                if (!Validator.equals(userID, lfCertificateUser.getUserID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

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

                list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByUserID_First(Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserID_First(userID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByUserID_First(Integer userID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateUser> list = findByUserID(userID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByUserID_Last(Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserID_Last(userID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByUserID_Last(Integer userID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserID(userID);

        List<LFCertificateUser> list = findByUserID(userID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate users before and after the current l f certificate user in the ordered set where userID = &#63;.
     *
     * @param id the primary key of the current l f certificate user
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser[] findByUserID_PrevAndNext(long id,
        Integer userID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificateUser[] array = new LFCertificateUserImpl[3];

            array[0] = getByUserID_PrevAndNext(session, lfCertificateUser,
                    userID, orderByComparator, true);

            array[1] = lfCertificateUser;

            array[2] = getByUserID_PrevAndNext(session, lfCertificateUser,
                    userID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateUser getByUserID_PrevAndNext(Session session,
        LFCertificateUser lfCertificateUser, Integer userID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificate users where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByUserIDAndCertificateID(
        Integer userID, Integer certificateID) throws SystemException {
        return findByUserIDAndCertificateID(userID, certificateID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users where userID = &#63; and certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByUserIDAndCertificateID(
        Integer userID, Integer certificateID, int start, int end)
        throws SystemException {
        return findByUserIDAndCertificateID(userID, certificateID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f certificate users where userID = &#63; and certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findByUserIDAndCertificateID(
        Integer userID, Integer certificateID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID;
            finderArgs = new Object[] { userID, certificateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID;
            finderArgs = new Object[] {
                    userID, certificateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateUser lfCertificateUser : list) {
                if (!Validator.equals(userID, lfCertificateUser.getUserID()) ||
                        !Validator.equals(certificateID,
                            lfCertificateUser.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2);
            }

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2);
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

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
                }

                list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByUserIDAndCertificateID_First(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserIDAndCertificateID_First(userID,
                certificateID, orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(", certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByUserIDAndCertificateID_First(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateUser> list = findByUserIDAndCertificateID(userID,
                certificateID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser findByUserIDAndCertificateID_Last(Integer userID,
        Integer certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserIDAndCertificateID_Last(userID,
                certificateID, orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(", certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser fetchByUserIDAndCertificateID_Last(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserIDAndCertificateID(userID, certificateID);

        List<LFCertificateUser> list = findByUserIDAndCertificateID(userID,
                certificateID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate users before and after the current l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param id the primary key of the current l f certificate user
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateUser[] findByUserIDAndCertificateID_PrevAndNext(
        long id, Integer userID, Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificateUser[] array = new LFCertificateUserImpl[3];

            array[0] = getByUserIDAndCertificateID_PrevAndNext(session,
                    lfCertificateUser, userID, certificateID,
                    orderByComparator, true);

            array[1] = lfCertificateUser;

            array[2] = getByUserIDAndCertificateID_PrevAndNext(session,
                    lfCertificateUser, userID, certificateID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateUser getByUserIDAndCertificateID_PrevAndNext(
        Session session, LFCertificateUser lfCertificateUser, Integer userID,
        Integer certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

        if (userID == null) {
            query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2);
        }

        if (certificateID == null) {
            query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2);
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

        if (certificateID != null) {
            qPos.add(certificateID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificate users.
     *
     * @return the l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateUser> findAll(int start, int end,
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

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATEUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATEUSER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Removes all the l f certificate users where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByCertificateID(Integer certificateID)
        throws SystemException {
        for (LFCertificateUser lfCertificateUser : findByCertificateID(
                certificateID)) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Removes all the l f certificate users where userID = &#63; from the database.
     *
     * @param userID the user i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByUserID(Integer userID) throws SystemException {
        for (LFCertificateUser lfCertificateUser : findByUserID(userID)) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Removes all the l f certificate users where userID = &#63; and certificateID = &#63; from the database.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByUserIDAndCertificateID(Integer userID,
        Integer certificateID) throws SystemException {
        for (LFCertificateUser lfCertificateUser : findByUserIDAndCertificateID(
                userID, certificateID)) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Removes all the l f certificate users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFCertificateUser lfCertificateUser : findAll()) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Returns the number of l f certificate users where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public int countByCertificateID(Integer certificateID)
        throws SystemException {
        Object[] finderArgs = new Object[] { certificateID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATEUSER_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f certificate users where userID = &#63;.
     *
     * @param userID the user i d
     * @return the number of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public int countByUserID(Integer userID) throws SystemException {
        Object[] finderArgs = new Object[] { userID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATEUSER_WHERE);

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
     * Returns the number of l f certificate users where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public int countByUserIDAndCertificateID(Integer userID,
        Integer certificateID) throws SystemException {
        Object[] finderArgs = new Object[] { userID, certificateID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATEUSER_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2);
            }

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2);
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

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f certificate users.
     *
     * @return the number of l f certificate users
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATEUSER);

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
     * Initializes the l f certificate user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateUser>> listenersList = new ArrayList<ModelListener<LFCertificateUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateUser>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

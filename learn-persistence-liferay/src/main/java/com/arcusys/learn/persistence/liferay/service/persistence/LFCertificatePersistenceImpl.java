package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException;
import com.arcusys.learn.persistence.liferay.model.LFCertificate;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateModelImpl;
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
 * The persistence implementation for the l f certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificatePersistence
 * @see LFCertificateUtil
 * @generated
 */
public class LFCertificatePersistenceImpl extends BasePersistenceImpl<LFCertificate>
    implements LFCertificatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateUtil} to access the l f certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCompanyID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
        new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCompanyID", new String[] { Integer.class.getName() },
            LFCertificateModelImpl.COMPANYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByTitle",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE = new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFCERTIFICATE = "SELECT lfCertificate FROM LFCertificate lfCertificate";
    private static final String _SQL_SELECT_LFCERTIFICATE_WHERE = "SELECT lfCertificate FROM LFCertificate lfCertificate WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATE = "SELECT COUNT(lfCertificate) FROM LFCertificate lfCertificate";
    private static final String _SQL_COUNT_LFCERTIFICATE_WHERE = "SELECT COUNT(lfCertificate) FROM LFCertificate lfCertificate WHERE ";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_NULL = "lfCertificate.companyID IS NULL";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_NULL_2 = "lfCertificate.companyID IS NULL ";
    private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "lfCertificate.companyID = ?";
    private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "lfCertificate.title LIKE NULL";
    private static final String _FINDER_COLUMN_TITLE_TITLE_NULL = "lfCertificate.title IS NULL";
    private static final String _FINDER_COLUMN_TITLE_TITLE_NULL_2 = "lfCertificate.title IS NULL ";
    private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "lfCertificate.title LIKE ?";
    private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(lfCertificate.title IS NULL OR lfCertificate.title LIKE ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificate.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificate exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificate exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificatePersistenceImpl.class);
    private static LFCertificate _nullLFCertificate = new LFCertificateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificate> toCacheModel() {
                return _nullLFCertificateCacheModel;
            }
        };

    private static CacheModel<LFCertificate> _nullLFCertificateCacheModel = new CacheModel<LFCertificate>() {
            public LFCertificate toEntityModel() {
                return _nullLFCertificate;
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
     * Caches the l f certificate in the entity cache if it is enabled.
     *
     * @param lfCertificate the l f certificate
     */
    public void cacheResult(LFCertificate lfCertificate) {
        EntityCacheUtil.putResult(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateImpl.class, lfCertificate.getPrimaryKey(),
            lfCertificate);

        lfCertificate.resetOriginalValues();
    }

    /**
     * Caches the l f certificates in the entity cache if it is enabled.
     *
     * @param lfCertificates the l f certificates
     */
    public void cacheResult(List<LFCertificate> lfCertificates) {
        for (LFCertificate lfCertificate : lfCertificates) {
            if (EntityCacheUtil.getResult(
                        LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateImpl.class, lfCertificate.getPrimaryKey()) == null) {
                cacheResult(lfCertificate);
            } else {
                lfCertificate.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificates.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificate lfCertificate) {
        EntityCacheUtil.removeResult(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateImpl.class, lfCertificate.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFCertificate> lfCertificates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificate lfCertificate : lfCertificates) {
            EntityCacheUtil.removeResult(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateImpl.class, lfCertificate.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f certificate with the primary key. Does not add the l f certificate to the database.
     *
     * @param id the primary key for the new l f certificate
     * @return the new l f certificate
     */
    public LFCertificate create(long id) {
        LFCertificate lfCertificate = new LFCertificateImpl();

        lfCertificate.setNew(true);
        lfCertificate.setPrimaryKey(id);

        return lfCertificate;
    }

    /**
     * Removes the l f certificate with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f certificate
     * @return the l f certificate that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate remove(long id)
        throws NoSuchLFCertificateException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f certificate with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate
     * @return the l f certificate that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificate remove(Serializable primaryKey)
        throws NoSuchLFCertificateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificate lfCertificate = (LFCertificate) session.get(LFCertificateImpl.class,
                    primaryKey);

            if (lfCertificate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificate);
        } catch (NoSuchLFCertificateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificate removeImpl(LFCertificate lfCertificate)
        throws SystemException {
        lfCertificate = toUnwrappedModel(lfCertificate);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfCertificate);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfCertificate);

        return lfCertificate;
    }

    @Override
    public LFCertificate updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate,
        boolean merge) throws SystemException {
        lfCertificate = toUnwrappedModel(lfCertificate);

        boolean isNew = lfCertificate.isNew();

        LFCertificateModelImpl lfCertificateModelImpl = (LFCertificateModelImpl) lfCertificate;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfCertificate, merge);

            lfCertificate.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfCertificateModelImpl.getOriginalCompanyID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfCertificateModelImpl.getCompanyID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateImpl.class, lfCertificate.getPrimaryKey(),
            lfCertificate);

        return lfCertificate;
    }

    protected LFCertificate toUnwrappedModel(LFCertificate lfCertificate) {
        if (lfCertificate instanceof LFCertificateImpl) {
            return lfCertificate;
        }

        LFCertificateImpl lfCertificateImpl = new LFCertificateImpl();

        lfCertificateImpl.setNew(lfCertificate.isNew());
        lfCertificateImpl.setPrimaryKey(lfCertificate.getPrimaryKey());

        lfCertificateImpl.setId(lfCertificate.getId());
        lfCertificateImpl.setTitle(lfCertificate.getTitle());
        lfCertificateImpl.setDescription(lfCertificate.getDescription());
        lfCertificateImpl.setLogo(lfCertificate.getLogo());
        lfCertificateImpl.setIsPermanent(lfCertificate.getIsPermanent());
        lfCertificateImpl.setPublishBadge(lfCertificate.getPublishBadge());
        lfCertificateImpl.setShortDescription(lfCertificate.getShortDescription());
        lfCertificateImpl.setCompanyID(lfCertificate.getCompanyID());

        return lfCertificateImpl;
    }

    /**
     * Returns the l f certificate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate
     * @return the l f certificate
     * @throws com.liferay.portal.NoSuchModelException if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificate findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f certificate with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException} if it could not be found.
     *
     * @param id the primary key of the l f certificate
     * @return the l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate findByPrimaryKey(long id)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = fetchByPrimaryKey(id);

        if (lfCertificate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfCertificate;
    }

    /**
     * Returns the l f certificate with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate
     * @return the l f certificate, or <code>null</code> if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificate fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f certificate with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f certificate
     * @return the l f certificate, or <code>null</code> if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate fetchByPrimaryKey(long id) throws SystemException {
        LFCertificate lfCertificate = (LFCertificate) EntityCacheUtil.getResult(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateImpl.class, id);

        if (lfCertificate == _nullLFCertificate) {
            return null;
        }

        if (lfCertificate == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfCertificate = (LFCertificate) session.get(LFCertificateImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfCertificate != null) {
                    cacheResult(lfCertificate);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFCertificateModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateImpl.class, id, _nullLFCertificate);
                }

                closeSession(session);
            }
        }

        return lfCertificate;
    }

    /**
     * Returns all the l f certificates where companyID = &#63;.
     *
     * @param companyID the company i d
     * @return the matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findByCompanyID(Integer companyID)
        throws SystemException {
        return findByCompanyID(companyID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f certificates where companyID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyID the company i d
     * @param start the lower bound of the range of l f certificates
     * @param end the upper bound of the range of l f certificates (not inclusive)
     * @return the range of matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findByCompanyID(Integer companyID, int start,
        int end) throws SystemException {
        return findByCompanyID(companyID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificates where companyID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param companyID the company i d
     * @param start the lower bound of the range of l f certificates
     * @param end the upper bound of the range of l f certificates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findByCompanyID(Integer companyID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
            finderArgs = new Object[] { companyID, start, end, orderByComparator };
        }

        List<LFCertificate> list = (List<LFCertificate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificate lfCertificate : list) {
                if (!Validator.equals(companyID, lfCertificate.getCompanyID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATE_WHERE);

            if (companyID == null) {
                query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);
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

                if (companyID != null) {
                    qPos.add(companyID.intValue());
                }

                list = (List<LFCertificate>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f certificate in the ordered set where companyID = &#63;.
     *
     * @param companyID the company i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate findByCompanyID_First(Integer companyID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = fetchByCompanyID_First(companyID,
                orderByComparator);

        if (lfCertificate != null) {
            return lfCertificate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyID=");
        msg.append(companyID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateException(msg.toString());
    }

    /**
     * Returns the first l f certificate in the ordered set where companyID = &#63;.
     *
     * @param companyID the company i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate, or <code>null</code> if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate fetchByCompanyID_First(Integer companyID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificate> list = findByCompanyID(companyID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate in the ordered set where companyID = &#63;.
     *
     * @param companyID the company i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate findByCompanyID_Last(Integer companyID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = fetchByCompanyID_Last(companyID,
                orderByComparator);

        if (lfCertificate != null) {
            return lfCertificate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyID=");
        msg.append(companyID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateException(msg.toString());
    }

    /**
     * Returns the last l f certificate in the ordered set where companyID = &#63;.
     *
     * @param companyID the company i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate, or <code>null</code> if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate fetchByCompanyID_Last(Integer companyID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCompanyID(companyID);

        List<LFCertificate> list = findByCompanyID(companyID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificates before and after the current l f certificate in the ordered set where companyID = &#63;.
     *
     * @param id the primary key of the current l f certificate
     * @param companyID the company i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate[] findByCompanyID_PrevAndNext(long id,
        Integer companyID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificate[] array = new LFCertificateImpl[3];

            array[0] = getByCompanyID_PrevAndNext(session, lfCertificate,
                    companyID, orderByComparator, true);

            array[1] = lfCertificate;

            array[2] = getByCompanyID_PrevAndNext(session, lfCertificate,
                    companyID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificate getByCompanyID_PrevAndNext(Session session,
        LFCertificate lfCertificate, Integer companyID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATE_WHERE);

        if (companyID == null) {
            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);
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

        if (companyID != null) {
            qPos.add(companyID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificate);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificate> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificates where title LIKE &#63;.
     *
     * @param title the title
     * @return the matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findByTitle(String title)
        throws SystemException {
        return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificates where title LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param title the title
     * @param start the lower bound of the range of l f certificates
     * @param end the upper bound of the range of l f certificates (not inclusive)
     * @return the range of matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findByTitle(String title, int start, int end)
        throws SystemException {
        return findByTitle(title, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificates where title LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param title the title
     * @param start the lower bound of the range of l f certificates
     * @param end the upper bound of the range of l f certificates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findByTitle(String title, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
        finderArgs = new Object[] { title, start, end, orderByComparator };

        List<LFCertificate> list = (List<LFCertificate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificate lfCertificate : list) {
                if (!Validator.equals(title, lfCertificate.getTitle())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATE_WHERE);

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else {
                if (title.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TITLE_TITLE_3);
                } else {
                    query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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

                if (title != null) {
                    qPos.add(title);
                }

                list = (List<LFCertificate>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f certificate in the ordered set where title LIKE &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate findByTitle_First(String title,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = fetchByTitle_First(title,
                orderByComparator);

        if (lfCertificate != null) {
            return lfCertificate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateException(msg.toString());
    }

    /**
     * Returns the first l f certificate in the ordered set where title LIKE &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate, or <code>null</code> if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate fetchByTitle_First(String title,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificate> list = findByTitle(title, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate in the ordered set where title LIKE &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate findByTitle_Last(String title,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = fetchByTitle_Last(title, orderByComparator);

        if (lfCertificate != null) {
            return lfCertificate;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateException(msg.toString());
    }

    /**
     * Returns the last l f certificate in the ordered set where title LIKE &#63;.
     *
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate, or <code>null</code> if a matching l f certificate could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate fetchByTitle_Last(String title,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTitle(title);

        List<LFCertificate> list = findByTitle(title, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificates before and after the current l f certificate in the ordered set where title LIKE &#63;.
     *
     * @param id the primary key of the current l f certificate
     * @param title the title
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateException if a l f certificate with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificate[] findByTitle_PrevAndNext(long id, String title,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateException, SystemException {
        LFCertificate lfCertificate = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificate[] array = new LFCertificateImpl[3];

            array[0] = getByTitle_PrevAndNext(session, lfCertificate, title,
                    orderByComparator, true);

            array[1] = lfCertificate;

            array[2] = getByTitle_PrevAndNext(session, lfCertificate, title,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificate getByTitle_PrevAndNext(Session session,
        LFCertificate lfCertificate, String title,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATE_WHERE);

        if (title == null) {
            query.append(_FINDER_COLUMN_TITLE_TITLE_1);
        } else {
            if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_3);
            } else {
                query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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

        if (title != null) {
            qPos.add(title);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificate);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificate> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificates.
     *
     * @return the l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificates.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f certificates
     * @param end the upper bound of the range of l f certificates (not inclusive)
     * @return the range of l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificates.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f certificates
     * @param end the upper bound of the range of l f certificates (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificates
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificate> findAll(int start, int end,
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

        List<LFCertificate> list = (List<LFCertificate>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFCertificate>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFCertificate>) QueryUtil.list(q,
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
     * Removes all the l f certificates where companyID = &#63; from the database.
     *
     * @param companyID the company i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByCompanyID(Integer companyID) throws SystemException {
        for (LFCertificate lfCertificate : findByCompanyID(companyID)) {
            remove(lfCertificate);
        }
    }

    /**
     * Removes all the l f certificates where title LIKE &#63; from the database.
     *
     * @param title the title
     * @throws SystemException if a system exception occurred
     */
    public void removeByTitle(String title) throws SystemException {
        for (LFCertificate lfCertificate : findByTitle(title)) {
            remove(lfCertificate);
        }
    }

    /**
     * Removes all the l f certificates from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFCertificate lfCertificate : findAll()) {
            remove(lfCertificate);
        }
    }

    /**
     * Returns the number of l f certificates where companyID = &#63;.
     *
     * @param companyID the company i d
     * @return the number of matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public int countByCompanyID(Integer companyID) throws SystemException {
        Object[] finderArgs = new Object[] { companyID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATE_WHERE);

            if (companyID == null) {
                query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (companyID != null) {
                    qPos.add(companyID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f certificates where title LIKE &#63;.
     *
     * @param title the title
     * @return the number of matching l f certificates
     * @throws SystemException if a system exception occurred
     */
    public int countByTitle(String title) throws SystemException {
        Object[] finderArgs = new Object[] { title };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATE_WHERE);

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLE_TITLE_1);
            } else {
                if (title.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TITLE_TITLE_3);
                } else {
                    query.append(_FINDER_COLUMN_TITLE_TITLE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (title != null) {
                    qPos.add(title);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f certificates.
     *
     * @return the number of l f certificates
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATE);

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
     * Initializes the l f certificate persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificate>> listenersList = new ArrayList<ModelListener<LFCertificate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificate>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

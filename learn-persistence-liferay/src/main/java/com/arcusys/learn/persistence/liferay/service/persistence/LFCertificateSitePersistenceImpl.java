package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateSite;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateSiteModelImpl;
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
 * The persistence implementation for the l f certificate site service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateSitePersistence
 * @see LFCertificateSiteUtil
 * @generated
 */
public class LFCertificateSitePersistenceImpl extends BasePersistenceImpl<LFCertificateSite>
    implements LFCertificateSitePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateSiteUtil} to access the l f certificate site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateSiteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Integer.class.getName() },
            LFCertificateSiteModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertificateID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID =
        new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCertificateIDAndSiteID",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID =
        new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByCertificateIDAndSiteID",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFCertificateSiteModelImpl.CERTIFICATEID_COLUMN_BITMASK |
            LFCertificateSiteModelImpl.SITEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEIDANDSITEID = new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCertificateIDAndSiteID",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_CERTIFICATEIDANDSITEID =
        new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByCertificateIDAndSiteID",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateSiteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFCERTIFICATESITE = "SELECT lfCertificateSite FROM LFCertificateSite lfCertificateSite";
    private static final String _SQL_SELECT_LFCERTIFICATESITE_WHERE = "SELECT lfCertificateSite FROM LFCertificateSite lfCertificateSite WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATESITE = "SELECT COUNT(lfCertificateSite) FROM LFCertificateSite lfCertificateSite";
    private static final String _SQL_COUNT_LFCERTIFICATESITE_WHERE = "SELECT COUNT(lfCertificateSite) FROM LFCertificateSite lfCertificateSite WHERE ";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateSite.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateSite.certificateID IS NULL ";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateSite.certificateID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL =
        "lfCertificateSite.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL_2 =
        "lfCertificateSite.certificateID IS NULL  AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_2 =
        "lfCertificateSite.certificateID = ? AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_5 =
        "(" +
        _removeConjunction(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_2) +
        ")";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_NULL =
        "lfCertificateSite.siteID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_NULL_2 =
        "lfCertificateSite.siteID IS NULL ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_2 = "lfCertificateSite.siteID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_5_NULL =
        "(" +
        _removeConjunction(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_NULL_2) +
        ")";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_5 = "(" +
        _removeConjunction(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_2) +
        ")";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateSite.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateSite exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateSite exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateSitePersistenceImpl.class);
    private static LFCertificateSite _nullLFCertificateSite = new LFCertificateSiteImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateSite> toCacheModel() {
                return _nullLFCertificateSiteCacheModel;
            }
        };

    private static CacheModel<LFCertificateSite> _nullLFCertificateSiteCacheModel =
        new CacheModel<LFCertificateSite>() {
            public LFCertificateSite toEntityModel() {
                return _nullLFCertificateSite;
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
     * Caches the l f certificate site in the entity cache if it is enabled.
     *
     * @param lfCertificateSite the l f certificate site
     */
    public void cacheResult(LFCertificateSite lfCertificateSite) {
        EntityCacheUtil.putResult(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteImpl.class, lfCertificateSite.getPrimaryKey(),
            lfCertificateSite);

        lfCertificateSite.resetOriginalValues();
    }

    /**
     * Caches the l f certificate sites in the entity cache if it is enabled.
     *
     * @param lfCertificateSites the l f certificate sites
     */
    public void cacheResult(List<LFCertificateSite> lfCertificateSites) {
        for (LFCertificateSite lfCertificateSite : lfCertificateSites) {
            if (EntityCacheUtil.getResult(
                        LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateSiteImpl.class,
                        lfCertificateSite.getPrimaryKey()) == null) {
                cacheResult(lfCertificateSite);
            } else {
                lfCertificateSite.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate sites.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateSiteImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateSiteImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate site.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificateSite lfCertificateSite) {
        EntityCacheUtil.removeResult(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteImpl.class, lfCertificateSite.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFCertificateSite> lfCertificateSites) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateSite lfCertificateSite : lfCertificateSites) {
            EntityCacheUtil.removeResult(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateSiteImpl.class, lfCertificateSite.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f certificate site with the primary key. Does not add the l f certificate site to the database.
     *
     * @param id the primary key for the new l f certificate site
     * @return the new l f certificate site
     */
    public LFCertificateSite create(long id) {
        LFCertificateSite lfCertificateSite = new LFCertificateSiteImpl();

        lfCertificateSite.setNew(true);
        lfCertificateSite.setPrimaryKey(id);

        return lfCertificateSite;
    }

    /**
     * Removes the l f certificate site with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f certificate site
     * @return the l f certificate site that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite remove(long id)
        throws NoSuchLFCertificateSiteException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f certificate site with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate site
     * @return the l f certificate site that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateSite remove(Serializable primaryKey)
        throws NoSuchLFCertificateSiteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateSite lfCertificateSite = (LFCertificateSite) session.get(LFCertificateSiteImpl.class,
                    primaryKey);

            if (lfCertificateSite == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateSite);
        } catch (NoSuchLFCertificateSiteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateSite removeImpl(LFCertificateSite lfCertificateSite)
        throws SystemException {
        lfCertificateSite = toUnwrappedModel(lfCertificateSite);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfCertificateSite);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfCertificateSite);

        return lfCertificateSite;
    }

    @Override
    public LFCertificateSite updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite,
        boolean merge) throws SystemException {
        lfCertificateSite = toUnwrappedModel(lfCertificateSite);

        boolean isNew = lfCertificateSite.isNew();

        LFCertificateSiteModelImpl lfCertificateSiteModelImpl = (LFCertificateSiteModelImpl) lfCertificateSite;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfCertificateSite, merge);

            lfCertificateSite.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateSiteModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateSiteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfCertificateSiteModelImpl.getOriginalCertificateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfCertificateSiteModelImpl.getCertificateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateSiteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfCertificateSiteModelImpl.getOriginalCertificateID(),
                        /* Integer.valueOf(   */
                        lfCertificateSiteModelImpl.getOriginalSiteID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDSITEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfCertificateSiteModelImpl.getCertificateID(),
                        /* Integer.valueOf( */
                        lfCertificateSiteModelImpl.getSiteID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDSITEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateSiteImpl.class, lfCertificateSite.getPrimaryKey(),
            lfCertificateSite);

        return lfCertificateSite;
    }

    protected LFCertificateSite toUnwrappedModel(
        LFCertificateSite lfCertificateSite) {
        if (lfCertificateSite instanceof LFCertificateSiteImpl) {
            return lfCertificateSite;
        }

        LFCertificateSiteImpl lfCertificateSiteImpl = new LFCertificateSiteImpl();

        lfCertificateSiteImpl.setNew(lfCertificateSite.isNew());
        lfCertificateSiteImpl.setPrimaryKey(lfCertificateSite.getPrimaryKey());

        lfCertificateSiteImpl.setId(lfCertificateSite.getId());
        lfCertificateSiteImpl.setCertificateID(lfCertificateSite.getCertificateID());
        lfCertificateSiteImpl.setSiteID(lfCertificateSite.getSiteID());
        lfCertificateSiteImpl.setArrangementIndex(lfCertificateSite.getArrangementIndex());

        return lfCertificateSiteImpl;
    }

    /**
     * Returns the l f certificate site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate site
     * @return the l f certificate site
     * @throws com.liferay.portal.NoSuchModelException if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateSite findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f certificate site with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException} if it could not be found.
     *
     * @param id the primary key of the l f certificate site
     * @return the l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite findByPrimaryKey(long id)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = fetchByPrimaryKey(id);

        if (lfCertificateSite == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFCertificateSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfCertificateSite;
    }

    /**
     * Returns the l f certificate site with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate site
     * @return the l f certificate site, or <code>null</code> if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateSite fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f certificate site with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f certificate site
     * @return the l f certificate site, or <code>null</code> if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite fetchByPrimaryKey(long id)
        throws SystemException {
        LFCertificateSite lfCertificateSite = (LFCertificateSite) EntityCacheUtil.getResult(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateSiteImpl.class, id);

        if (lfCertificateSite == _nullLFCertificateSite) {
            return null;
        }

        if (lfCertificateSite == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfCertificateSite = (LFCertificateSite) session.get(LFCertificateSiteImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfCertificateSite != null) {
                    cacheResult(lfCertificateSite);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFCertificateSiteModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateSiteImpl.class, id, _nullLFCertificateSite);
                }

                closeSession(session);
            }
        }

        return lfCertificateSite;
    }

    /**
     * Returns all the l f certificate sites where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateID(Integer certificateID)
        throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate sites where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @return the range of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateID(Integer certificateID,
        int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate sites where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateID(Integer certificateID,
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

        List<LFCertificateSite> list = (List<LFCertificateSite>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateSite lfCertificateSite : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateSite.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATESITE_WHERE);

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

                list = (List<LFCertificateSite>) QueryUtil.list(q,
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
     * Returns the first l f certificate site in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite findByCertificateID_First(Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateSite != null) {
            return lfCertificateSite;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateSiteException(msg.toString());
    }

    /**
     * Returns the first l f certificate site in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite fetchByCertificateID_First(Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateSite> list = findByCertificateID(certificateID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate site in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite findByCertificateID_Last(Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateSite != null) {
            return lfCertificateSite;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateSiteException(msg.toString());
    }

    /**
     * Returns the last l f certificate site in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite fetchByCertificateID_Last(Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCertificateID(certificateID);

        List<LFCertificateSite> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate sites before and after the current l f certificate site in the ordered set where certificateID = &#63;.
     *
     * @param id the primary key of the current l f certificate site
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite[] findByCertificateID_PrevAndNext(long id,
        Integer certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificateSite[] array = new LFCertificateSiteImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateSite, certificateID, orderByComparator, true);

            array[1] = lfCertificateSite;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateSite, certificateID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateSite getByCertificateID_PrevAndNext(
        Session session, LFCertificateSite lfCertificateSite,
        Integer certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATESITE_WHERE);

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
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateSite);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateSite> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @return the matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateIDAndSiteID(
        Integer certificateID, Integer siteID) throws SystemException {
        return findByCertificateIDAndSiteID(certificateID, siteID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @return the range of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateIDAndSiteID(
        Integer certificateID, Integer siteID, int start, int end)
        throws SystemException {
        return findByCertificateIDAndSiteID(certificateID, siteID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f certificate sites where certificateID = &#63; and siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateIDAndSiteID(
        Integer certificateID, Integer siteID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID;
            finderArgs = new Object[] { certificateID, siteID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID;
            finderArgs = new Object[] {
                    certificateID, siteID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateSite> list = (List<LFCertificateSite>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateSite lfCertificateSite : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateSite.getCertificateID()) ||
                        !Validator.equals(siteID, lfCertificateSite.getSiteID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATESITE_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_2);
            }

            if (siteID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_2);
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

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                list = (List<LFCertificateSite>) QueryUtil.list(q,
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
     * Returns the first l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite findByCertificateIDAndSiteID_First(
        Integer certificateID, Integer siteID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = fetchByCertificateIDAndSiteID_First(certificateID,
                siteID, orderByComparator);

        if (lfCertificateSite != null) {
            return lfCertificateSite;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(", siteID=");
        msg.append(siteID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateSiteException(msg.toString());
    }

    /**
     * Returns the first l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite fetchByCertificateIDAndSiteID_First(
        Integer certificateID, Integer siteID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateSite> list = findByCertificateIDAndSiteID(certificateID,
                siteID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite findByCertificateIDAndSiteID_Last(
        Integer certificateID, Integer siteID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = fetchByCertificateIDAndSiteID_Last(certificateID,
                siteID, orderByComparator);

        if (lfCertificateSite != null) {
            return lfCertificateSite;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(", siteID=");
        msg.append(siteID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateSiteException(msg.toString());
    }

    /**
     * Returns the last l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate site, or <code>null</code> if a matching l f certificate site could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite fetchByCertificateIDAndSiteID_Last(
        Integer certificateID, Integer siteID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCertificateIDAndSiteID(certificateID, siteID);

        List<LFCertificateSite> list = findByCertificateIDAndSiteID(certificateID,
                siteID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate sites before and after the current l f certificate site in the ordered set where certificateID = &#63; and siteID = &#63;.
     *
     * @param id the primary key of the current l f certificate site
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate site
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateSiteException if a l f certificate site with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFCertificateSite[] findByCertificateIDAndSiteID_PrevAndNext(
        long id, Integer certificateID, Integer siteID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateSiteException, SystemException {
        LFCertificateSite lfCertificateSite = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFCertificateSite[] array = new LFCertificateSiteImpl[3];

            array[0] = getByCertificateIDAndSiteID_PrevAndNext(session,
                    lfCertificateSite, certificateID, siteID,
                    orderByComparator, true);

            array[1] = lfCertificateSite;

            array[2] = getByCertificateIDAndSiteID_PrevAndNext(session,
                    lfCertificateSite, certificateID, siteID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateSite getByCertificateIDAndSiteID_PrevAndNext(
        Session session, LFCertificateSite lfCertificateSite,
        Integer certificateID, Integer siteID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATESITE_WHERE);

        if (certificateID == null) {
            query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_2);
        }

        if (siteID == null) {
            query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_2);
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

        if (siteID != null) {
            qPos.add(siteID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateSite);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateSite> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateIDs the certificate i ds
     * @param siteID the site i d
     * @return the matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateIDAndSiteID(
        Integer[] certificateIDs, Integer siteID) throws SystemException {
        return findByCertificateIDAndSiteID(certificateIDs, siteID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateIDs the certificate i ds
     * @param siteID the site i d
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @return the range of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateIDAndSiteID(
        Integer[] certificateIDs, Integer siteID, int start, int end)
        throws SystemException {
        return findByCertificateIDAndSiteID(certificateIDs, siteID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f certificate sites where certificateID = any &#63; and siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param certificateIDs the certificate i ds
     * @param siteID the site i d
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findByCertificateIDAndSiteID(
        Integer[] certificateIDs, Integer siteID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEIDANDSITEID;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderArgs = new Object[] { StringUtil.merge(certificateIDs), siteID };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(certificateIDs), siteID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateSite> list = (List<LFCertificateSite>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateSite lfCertificateSite : list) {
                if (!ArrayUtil.contains(certificateIDs,
                            lfCertificateSite.getCertificateID()) ||
                        !Validator.equals(siteID, lfCertificateSite.getSiteID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFCERTIFICATESITE_WHERE);

            boolean conjunctionable = false;

            if ((certificateIDs != null) && (certificateIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < certificateIDs.length; i++) {
                    if (certificateIDs[i] == null) {
                        query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_5);
                    }

                    if ((i + 1) < certificateIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (siteID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_5_NULL);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_5);
            }

            conjunctionable = true;

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

                if (certificateIDs != null) {
                    for (Integer certificateID : certificateIDs) {
                        if (certificateID != null) {
                            qPos.add(certificateID);
                        }
                    }
                }

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                list = (List<LFCertificateSite>) QueryUtil.list(q,
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
     * Returns all the l f certificate sites.
     *
     * @return the l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate sites.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @return the range of l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate sites.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate sites
     * @param end the upper bound of the range of l f certificate sites (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public List<LFCertificateSite> findAll(int start, int end,
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

        List<LFCertificateSite> list = (List<LFCertificateSite>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATESITE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATESITE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFCertificateSite>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFCertificateSite>) QueryUtil.list(q,
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
     * Removes all the l f certificate sites where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByCertificateID(Integer certificateID)
        throws SystemException {
        for (LFCertificateSite lfCertificateSite : findByCertificateID(
                certificateID)) {
            remove(lfCertificateSite);
        }
    }

    /**
     * Removes all the l f certificate sites where certificateID = &#63; and siteID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByCertificateIDAndSiteID(Integer certificateID,
        Integer siteID) throws SystemException {
        for (LFCertificateSite lfCertificateSite : findByCertificateIDAndSiteID(
                certificateID, siteID)) {
            remove(lfCertificateSite);
        }
    }

    /**
     * Removes all the l f certificate sites from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFCertificateSite lfCertificateSite : findAll()) {
            remove(lfCertificateSite);
        }
    }

    /**
     * Returns the number of l f certificate sites where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public int countByCertificateID(Integer certificateID)
        throws SystemException {
        Object[] finderArgs = new Object[] { certificateID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATESITE_WHERE);

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
     * Returns the number of l f certificate sites where certificateID = &#63; and siteID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param siteID the site i d
     * @return the number of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public int countByCertificateIDAndSiteID(Integer certificateID,
        Integer siteID) throws SystemException {
        Object[] finderArgs = new Object[] { certificateID, siteID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDSITEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATESITE_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_2);
            }

            if (siteID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_2);
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

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDSITEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f certificate sites where certificateID = any &#63; and siteID = &#63;.
     *
     * @param certificateIDs the certificate i ds
     * @param siteID the site i d
     * @return the number of matching l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public int countByCertificateIDAndSiteID(Integer[] certificateIDs,
        Integer siteID) throws SystemException {
        Object[] finderArgs = new Object[] {
                StringUtil.merge(certificateIDs), siteID
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CERTIFICATEIDANDSITEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFCERTIFICATESITE_WHERE);

            boolean conjunctionable = false;

            if ((certificateIDs != null) && (certificateIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < certificateIDs.length; i++) {
                    if (certificateIDs[i] == null) {
                        query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_CERTIFICATEID_5);
                    }

                    if ((i + 1) < certificateIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (siteID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_5_NULL);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDSITEID_SITEID_5);
            }

            conjunctionable = true;

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateIDs != null) {
                    for (Integer certificateID : certificateIDs) {
                        if (certificateID != null) {
                            qPos.add(certificateID);
                        }
                    }
                }

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_CERTIFICATEIDANDSITEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f certificate sites.
     *
     * @return the number of l f certificate sites
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATESITE);

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
     * Initializes the l f certificate site persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateSite")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateSite>> listenersList = new ArrayList<ModelListener<LFCertificateSite>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateSite>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateSiteImpl.class.getName());
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

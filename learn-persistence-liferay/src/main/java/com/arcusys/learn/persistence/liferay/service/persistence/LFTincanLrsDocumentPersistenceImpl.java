package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl;
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
 * The persistence implementation for the l f tincan lrs document service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsDocumentPersistence
 * @see LFTincanLrsDocumentUtil
 * @generated
 */
public class LFTincanLrsDocumentPersistenceImpl extends BasePersistenceImpl<LFTincanLrsDocument>
    implements LFTincanLrsDocumentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsDocumentUtil} to access the l f tincan lrs document persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsDocumentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_DOCUMENTID = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByDocumentId", new String[] { String.class.getName() },
            LFTincanLrsDocumentModelImpl.DOCUMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTID = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSDOCUMENT = "SELECT lfTincanLrsDocument FROM LFTincanLrsDocument lfTincanLrsDocument";
    private static final String _SQL_SELECT_LFTINCANLRSDOCUMENT_WHERE = "SELECT lfTincanLrsDocument FROM LFTincanLrsDocument lfTincanLrsDocument WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSDOCUMENT = "SELECT COUNT(lfTincanLrsDocument) FROM LFTincanLrsDocument lfTincanLrsDocument";
    private static final String _SQL_COUNT_LFTINCANLRSDOCUMENT_WHERE = "SELECT COUNT(lfTincanLrsDocument) FROM LFTincanLrsDocument lfTincanLrsDocument WHERE ";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1 = "lfTincanLrsDocument.documentId IS NULL";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_NULL = "lfTincanLrsDocument.documentId IS NULL";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_NULL_2 = "lfTincanLrsDocument.documentId IS NULL ";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 = "lfTincanLrsDocument.documentId = ?";
    private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3 = "(lfTincanLrsDocument.documentId IS NULL OR lfTincanLrsDocument.documentId = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsDocument.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsDocument exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsDocument exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsDocumentPersistenceImpl.class);
    private static LFTincanLrsDocument _nullLFTincanLrsDocument = new LFTincanLrsDocumentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsDocument> toCacheModel() {
                return _nullLFTincanLrsDocumentCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsDocument> _nullLFTincanLrsDocumentCacheModel =
        new CacheModel<LFTincanLrsDocument>() {
            public LFTincanLrsDocument toEntityModel() {
                return _nullLFTincanLrsDocument;
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
     * Caches the l f tincan lrs document in the entity cache if it is enabled.
     *
     * @param lfTincanLrsDocument the l f tincan lrs document
     */
    public void cacheResult(LFTincanLrsDocument lfTincanLrsDocument) {
        EntityCacheUtil.putResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, lfTincanLrsDocument.getPrimaryKey(),
            lfTincanLrsDocument);

        boolean noNullsInDOCUMENTID = true;

        if (noNullsInDOCUMENTID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                new Object[] { lfTincanLrsDocument.getDocumentId() },
                lfTincanLrsDocument);
        }

        lfTincanLrsDocument.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs documents in the entity cache if it is enabled.
     *
     * @param lfTincanLrsDocuments the l f tincan lrs documents
     */
    public void cacheResult(List<LFTincanLrsDocument> lfTincanLrsDocuments) {
        for (LFTincanLrsDocument lfTincanLrsDocument : lfTincanLrsDocuments) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsDocumentImpl.class,
                        lfTincanLrsDocument.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsDocument);
            } else {
                lfTincanLrsDocument.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs documents.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsDocumentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsDocumentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs document.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsDocument lfTincanLrsDocument) {
        EntityCacheUtil.removeResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, lfTincanLrsDocument.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanLrsDocument);
    }

    @Override
    public void clearCache(List<LFTincanLrsDocument> lfTincanLrsDocuments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsDocument lfTincanLrsDocument : lfTincanLrsDocuments) {
            EntityCacheUtil.removeResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsDocumentImpl.class,
                lfTincanLrsDocument.getPrimaryKey());

            clearUniqueFindersCache(lfTincanLrsDocument);
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanLrsDocument lfTincanLrsDocument) {
        boolean noNullsInDOCUMENTID = true;

        if (noNullsInDOCUMENTID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                new Object[] { lfTincanLrsDocument.getDocumentId() });
        }
    }

    /**
     * Creates a new l f tincan lrs document with the primary key. Does not add the l f tincan lrs document to the database.
     *
     * @param id the primary key for the new l f tincan lrs document
     * @return the new l f tincan lrs document
     */
    public LFTincanLrsDocument create(long id) {
        LFTincanLrsDocument lfTincanLrsDocument = new LFTincanLrsDocumentImpl();

        lfTincanLrsDocument.setNew(true);
        lfTincanLrsDocument.setPrimaryKey(id);

        return lfTincanLrsDocument;
    }

    /**
     * Removes the l f tincan lrs document with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument remove(long id)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs document with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsDocument lfTincanLrsDocument = (LFTincanLrsDocument) session.get(LFTincanLrsDocumentImpl.class,
                    primaryKey);

            if (lfTincanLrsDocument == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsDocument);
        } catch (NoSuchLFTincanLrsDocumentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsDocument removeImpl(
        LFTincanLrsDocument lfTincanLrsDocument) throws SystemException {
        lfTincanLrsDocument = toUnwrappedModel(lfTincanLrsDocument);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsDocument);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsDocument);

        return lfTincanLrsDocument;
    }

    @Override
    public LFTincanLrsDocument updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument,
        boolean merge) throws SystemException {
        lfTincanLrsDocument = toUnwrappedModel(lfTincanLrsDocument);

        boolean isNew = lfTincanLrsDocument.isNew();

        LFTincanLrsDocumentModelImpl lfTincanLrsDocumentModelImpl = (LFTincanLrsDocumentModelImpl) lfTincanLrsDocument;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsDocument, merge);

            lfTincanLrsDocument.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanLrsDocumentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsDocumentImpl.class, lfTincanLrsDocument.getPrimaryKey(),
            lfTincanLrsDocument);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                new Object[] { lfTincanLrsDocument.getDocumentId() },
                lfTincanLrsDocument);
        } else {
            if ((lfTincanLrsDocumentModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_DOCUMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanLrsDocumentModelImpl.getOriginalDocumentId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENTID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                    new Object[] { lfTincanLrsDocument.getDocumentId() },
                    lfTincanLrsDocument);
            }
        }

        return lfTincanLrsDocument;
    }

    protected LFTincanLrsDocument toUnwrappedModel(
        LFTincanLrsDocument lfTincanLrsDocument) {
        if (lfTincanLrsDocument instanceof LFTincanLrsDocumentImpl) {
            return lfTincanLrsDocument;
        }

        LFTincanLrsDocumentImpl lfTincanLrsDocumentImpl = new LFTincanLrsDocumentImpl();

        lfTincanLrsDocumentImpl.setNew(lfTincanLrsDocument.isNew());
        lfTincanLrsDocumentImpl.setPrimaryKey(lfTincanLrsDocument.getPrimaryKey());

        lfTincanLrsDocumentImpl.setId(lfTincanLrsDocument.getId());
        lfTincanLrsDocumentImpl.setDocumentId(lfTincanLrsDocument.getDocumentId());
        lfTincanLrsDocumentImpl.setUpdate(lfTincanLrsDocument.getUpdate());
        lfTincanLrsDocumentImpl.setContent(lfTincanLrsDocument.getContent());
        lfTincanLrsDocumentImpl.setContentType(lfTincanLrsDocument.getContentType());

        return lfTincanLrsDocumentImpl;
    }

    /**
     * Returns the l f tincan lrs document with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs document with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = fetchByPrimaryKey(id);

        if (lfTincanLrsDocument == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsDocumentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsDocument;
    }

    /**
     * Returns the l f tincan lrs document with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document, or <code>null</code> if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsDocument fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs document with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs document
     * @return the l f tincan lrs document, or <code>null</code> if a l f tincan lrs document with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = (LFTincanLrsDocument) EntityCacheUtil.getResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsDocumentImpl.class, id);

        if (lfTincanLrsDocument == _nullLFTincanLrsDocument) {
            return null;
        }

        if (lfTincanLrsDocument == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsDocument = (LFTincanLrsDocument) session.get(LFTincanLrsDocumentImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsDocument != null) {
                    cacheResult(lfTincanLrsDocument);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsDocumentModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsDocumentImpl.class, id,
                        _nullLFTincanLrsDocument);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsDocument;
    }

    /**
     * Returns the l f tincan lrs document where documentId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException} if it could not be found.
     *
     * @param documentId the document ID
     * @return the matching l f tincan lrs document
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException if a matching l f tincan lrs document could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument findByDocumentId(String documentId)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = fetchByDocumentId(documentId);

        if (lfTincanLrsDocument == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("documentId=");
            msg.append(documentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanLrsDocumentException(msg.toString());
        }

        return lfTincanLrsDocument;
    }

    /**
     * Returns the l f tincan lrs document where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param documentId the document ID
     * @return the matching l f tincan lrs document, or <code>null</code> if a matching l f tincan lrs document could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument fetchByDocumentId(String documentId)
        throws SystemException {
        return fetchByDocumentId(documentId, true);
    }

    /**
     * Returns the l f tincan lrs document where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param documentId the document ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan lrs document, or <code>null</code> if a matching l f tincan lrs document could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument fetchByDocumentId(String documentId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { documentId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanLrsDocument) {
            LFTincanLrsDocument lfTincanLrsDocument = (LFTincanLrsDocument) result;

            if (!Validator.equals(documentId,
                        lfTincanLrsDocument.getDocumentId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFTINCANLRSDOCUMENT_WHERE);

            if (documentId == null) {
                query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1);
            } else {
                if (documentId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentId != null) {
                    qPos.add(documentId);
                }

                List<LFTincanLrsDocument> list = q.list();

                result = list;

                LFTincanLrsDocument lfTincanLrsDocument = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                        finderArgs, list);
                } else {
                    lfTincanLrsDocument = list.get(0);

                    cacheResult(lfTincanLrsDocument);

                    if ((lfTincanLrsDocument.getDocumentId() == null) ||
                            !lfTincanLrsDocument.getDocumentId()
                                                    .equals(documentId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                            finderArgs, lfTincanLrsDocument);
                    }
                }

                return lfTincanLrsDocument;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DOCUMENTID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFTincanLrsDocument) result;
            }
        }
    }

    /**
     * Returns all the l f tincan lrs documents.
     *
     * @return the l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsDocument> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs documents.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs documents
     * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
     * @return the range of l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsDocument> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs documents.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs documents
     * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsDocument> findAll(int start, int end,
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

        List<LFTincanLrsDocument> list = (List<LFTincanLrsDocument>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSDOCUMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSDOCUMENT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsDocument>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsDocument>) QueryUtil.list(q,
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
     * Removes the l f tincan lrs document where documentId = &#63; from the database.
     *
     * @param documentId the document ID
     * @return the l f tincan lrs document that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsDocument removeByDocumentId(String documentId)
        throws NoSuchLFTincanLrsDocumentException, SystemException {
        LFTincanLrsDocument lfTincanLrsDocument = findByDocumentId(documentId);

        return remove(lfTincanLrsDocument);
    }

    /**
     * Removes all the l f tincan lrs documents from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsDocument lfTincanLrsDocument : findAll()) {
            remove(lfTincanLrsDocument);
        }
    }

    /**
     * Returns the number of l f tincan lrs documents where documentId = &#63;.
     *
     * @param documentId the document ID
     * @return the number of matching l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    public int countByDocumentId(String documentId) throws SystemException {
        Object[] finderArgs = new Object[] { documentId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCUMENTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSDOCUMENT_WHERE);

            if (documentId == null) {
                query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_1);
            } else {
                if (documentId.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentId != null) {
                    qPos.add(documentId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs documents.
     *
     * @return the number of l f tincan lrs documents
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSDOCUMENT);

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
     * Initializes the l f tincan lrs document persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsDocument>> listenersList = new ArrayList<ModelListener<LFTincanLrsDocument>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsDocument>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsDocumentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

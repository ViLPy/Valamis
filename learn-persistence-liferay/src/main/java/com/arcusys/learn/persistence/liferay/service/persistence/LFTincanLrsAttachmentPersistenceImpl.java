package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsAttachmentModelImpl;
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
 * The persistence implementation for the l f tincan lrs attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAttachmentPersistence
 * @see LFTincanLrsAttachmentUtil
 * @generated
 */
public class LFTincanLrsAttachmentPersistenceImpl extends BasePersistenceImpl<LFTincanLrsAttachment>
    implements LFTincanLrsAttachmentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsAttachmentUtil} to access the l f tincan lrs attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsAttachmentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
        new FinderPath(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentID",
            new String[] { Integer.class.getName() },
            LFTincanLrsAttachmentModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSATTACHMENT = "SELECT lfTincanLrsAttachment FROM LFTincanLrsAttachment lfTincanLrsAttachment";
    private static final String _SQL_SELECT_LFTINCANLRSATTACHMENT_WHERE = "SELECT lfTincanLrsAttachment FROM LFTincanLrsAttachment lfTincanLrsAttachment WHERE ";
    private static final String _SQL_COUNT_LFTINCANLRSATTACHMENT = "SELECT COUNT(lfTincanLrsAttachment) FROM LFTincanLrsAttachment lfTincanLrsAttachment";
    private static final String _SQL_COUNT_LFTINCANLRSATTACHMENT_WHERE = "SELECT COUNT(lfTincanLrsAttachment) FROM LFTincanLrsAttachment lfTincanLrsAttachment WHERE ";
    private static final String _FINDER_COLUMN_PARENTID_PARENTID_NULL = "lfTincanLrsAttachment.parentID IS NULL";
    private static final String _FINDER_COLUMN_PARENTID_PARENTID_NULL_2 = "lfTincanLrsAttachment.parentID IS NULL ";
    private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "lfTincanLrsAttachment.parentID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsAttachment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsAttachment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanLrsAttachment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsAttachmentPersistenceImpl.class);
    private static LFTincanLrsAttachment _nullLFTincanLrsAttachment = new LFTincanLrsAttachmentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsAttachment> toCacheModel() {
                return _nullLFTincanLrsAttachmentCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsAttachment> _nullLFTincanLrsAttachmentCacheModel =
        new CacheModel<LFTincanLrsAttachment>() {
            public LFTincanLrsAttachment toEntityModel() {
                return _nullLFTincanLrsAttachment;
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
     * Caches the l f tincan lrs attachment in the entity cache if it is enabled.
     *
     * @param lfTincanLrsAttachment the l f tincan lrs attachment
     */
    public void cacheResult(LFTincanLrsAttachment lfTincanLrsAttachment) {
        EntityCacheUtil.putResult(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            lfTincanLrsAttachment.getPrimaryKey(), lfTincanLrsAttachment);

        lfTincanLrsAttachment.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs attachments in the entity cache if it is enabled.
     *
     * @param lfTincanLrsAttachments the l f tincan lrs attachments
     */
    public void cacheResult(List<LFTincanLrsAttachment> lfTincanLrsAttachments) {
        for (LFTincanLrsAttachment lfTincanLrsAttachment : lfTincanLrsAttachments) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsAttachmentImpl.class,
                        lfTincanLrsAttachment.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsAttachment);
            } else {
                lfTincanLrsAttachment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs attachments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsAttachmentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsAttachmentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs attachment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsAttachment lfTincanLrsAttachment) {
        EntityCacheUtil.removeResult(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            lfTincanLrsAttachment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFTincanLrsAttachment> lfTincanLrsAttachments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsAttachment lfTincanLrsAttachment : lfTincanLrsAttachments) {
            EntityCacheUtil.removeResult(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsAttachmentImpl.class,
                lfTincanLrsAttachment.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs attachment with the primary key. Does not add the l f tincan lrs attachment to the database.
     *
     * @param id the primary key for the new l f tincan lrs attachment
     * @return the new l f tincan lrs attachment
     */
    public LFTincanLrsAttachment create(long id) {
        LFTincanLrsAttachment lfTincanLrsAttachment = new LFTincanLrsAttachmentImpl();

        lfTincanLrsAttachment.setNew(true);
        lfTincanLrsAttachment.setPrimaryKey(id);

        return lfTincanLrsAttachment;
    }

    /**
     * Removes the l f tincan lrs attachment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs attachment
     * @return the l f tincan lrs attachment that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment remove(long id)
        throws NoSuchLFTincanLrsAttachmentException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs attachment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs attachment
     * @return the l f tincan lrs attachment that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsAttachment remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsAttachmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsAttachment lfTincanLrsAttachment = (LFTincanLrsAttachment) session.get(LFTincanLrsAttachmentImpl.class,
                    primaryKey);

            if (lfTincanLrsAttachment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsAttachment);
        } catch (NoSuchLFTincanLrsAttachmentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsAttachment removeImpl(
        LFTincanLrsAttachment lfTincanLrsAttachment) throws SystemException {
        lfTincanLrsAttachment = toUnwrappedModel(lfTincanLrsAttachment);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsAttachment);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsAttachment);

        return lfTincanLrsAttachment;
    }

    @Override
    public LFTincanLrsAttachment updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment,
        boolean merge) throws SystemException {
        lfTincanLrsAttachment = toUnwrappedModel(lfTincanLrsAttachment);

        boolean isNew = lfTincanLrsAttachment.isNew();

        LFTincanLrsAttachmentModelImpl lfTincanLrsAttachmentModelImpl = (LFTincanLrsAttachmentModelImpl) lfTincanLrsAttachment;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsAttachment, merge);

            lfTincanLrsAttachment.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanLrsAttachmentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanLrsAttachmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfTincanLrsAttachmentModelImpl.getOriginalParentID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);

                args = new Object[] { /* Integer.valueOf( */
                        lfTincanLrsAttachmentModelImpl.getParentID()/* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsAttachmentImpl.class,
            lfTincanLrsAttachment.getPrimaryKey(), lfTincanLrsAttachment);

        return lfTincanLrsAttachment;
    }

    protected LFTincanLrsAttachment toUnwrappedModel(
        LFTincanLrsAttachment lfTincanLrsAttachment) {
        if (lfTincanLrsAttachment instanceof LFTincanLrsAttachmentImpl) {
            return lfTincanLrsAttachment;
        }

        LFTincanLrsAttachmentImpl lfTincanLrsAttachmentImpl = new LFTincanLrsAttachmentImpl();

        lfTincanLrsAttachmentImpl.setNew(lfTincanLrsAttachment.isNew());
        lfTincanLrsAttachmentImpl.setPrimaryKey(lfTincanLrsAttachment.getPrimaryKey());

        lfTincanLrsAttachmentImpl.setId(lfTincanLrsAttachment.getId());
        lfTincanLrsAttachmentImpl.setParentID(lfTincanLrsAttachment.getParentID());
        lfTincanLrsAttachmentImpl.setUsageType(lfTincanLrsAttachment.getUsageType());
        lfTincanLrsAttachmentImpl.setDisplay(lfTincanLrsAttachment.getDisplay());
        lfTincanLrsAttachmentImpl.setDescription(lfTincanLrsAttachment.getDescription());
        lfTincanLrsAttachmentImpl.setContentType(lfTincanLrsAttachment.getContentType());
        lfTincanLrsAttachmentImpl.setLength(lfTincanLrsAttachment.getLength());
        lfTincanLrsAttachmentImpl.setSha2(lfTincanLrsAttachment.getSha2());
        lfTincanLrsAttachmentImpl.setFileUrl(lfTincanLrsAttachment.getFileUrl());

        return lfTincanLrsAttachmentImpl;
    }

    /**
     * Returns the l f tincan lrs attachment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs attachment
     * @return the l f tincan lrs attachment
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsAttachment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs attachment with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs attachment
     * @return the l f tincan lrs attachment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsAttachmentException, SystemException {
        LFTincanLrsAttachment lfTincanLrsAttachment = fetchByPrimaryKey(id);

        if (lfTincanLrsAttachment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsAttachment;
    }

    /**
     * Returns the l f tincan lrs attachment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs attachment
     * @return the l f tincan lrs attachment, or <code>null</code> if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsAttachment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs attachment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs attachment
     * @return the l f tincan lrs attachment, or <code>null</code> if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsAttachment lfTincanLrsAttachment = (LFTincanLrsAttachment) EntityCacheUtil.getResult(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsAttachmentImpl.class, id);

        if (lfTincanLrsAttachment == _nullLFTincanLrsAttachment) {
            return null;
        }

        if (lfTincanLrsAttachment == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsAttachment = (LFTincanLrsAttachment) session.get(LFTincanLrsAttachmentImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsAttachment != null) {
                    cacheResult(lfTincanLrsAttachment);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsAttachmentModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsAttachmentImpl.class, id,
                        _nullLFTincanLrsAttachment);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsAttachment;
    }

    /**
     * Returns all the l f tincan lrs attachments where parentID = &#63;.
     *
     * @param parentID the parent i d
     * @return the matching l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAttachment> findByParentID(Integer parentID)
        throws SystemException {
        return findByParentID(parentID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan lrs attachments where parentID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param parentID the parent i d
     * @param start the lower bound of the range of l f tincan lrs attachments
     * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
     * @return the range of matching l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAttachment> findByParentID(Integer parentID,
        int start, int end) throws SystemException {
        return findByParentID(parentID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs attachments where parentID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param parentID the parent i d
     * @param start the lower bound of the range of l f tincan lrs attachments
     * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAttachment> findByParentID(Integer parentID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
            finderArgs = new Object[] { parentID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
            finderArgs = new Object[] { parentID, start, end, orderByComparator };
        }

        List<LFTincanLrsAttachment> list = (List<LFTincanLrsAttachment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanLrsAttachment lfTincanLrsAttachment : list) {
                if (!Validator.equals(parentID,
                            lfTincanLrsAttachment.getParentID())) {
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

            query.append(_SQL_SELECT_LFTINCANLRSATTACHMENT_WHERE);

            if (parentID == null) {
                query.append(_FINDER_COLUMN_PARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);
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

                if (parentID != null) {
                    qPos.add(parentID.intValue());
                }

                list = (List<LFTincanLrsAttachment>) QueryUtil.list(q,
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
     * Returns the first l f tincan lrs attachment in the ordered set where parentID = &#63;.
     *
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs attachment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a matching l f tincan lrs attachment could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment findByParentID_First(Integer parentID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsAttachmentException, SystemException {
        LFTincanLrsAttachment lfTincanLrsAttachment = fetchByParentID_First(parentID,
                orderByComparator);

        if (lfTincanLrsAttachment != null) {
            return lfTincanLrsAttachment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsAttachmentException(msg.toString());
    }

    /**
     * Returns the first l f tincan lrs attachment in the ordered set where parentID = &#63;.
     *
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan lrs attachment, or <code>null</code> if a matching l f tincan lrs attachment could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment fetchByParentID_First(Integer parentID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanLrsAttachment> list = findByParentID(parentID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan lrs attachment in the ordered set where parentID = &#63;.
     *
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs attachment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a matching l f tincan lrs attachment could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment findByParentID_Last(Integer parentID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsAttachmentException, SystemException {
        LFTincanLrsAttachment lfTincanLrsAttachment = fetchByParentID_Last(parentID,
                orderByComparator);

        if (lfTincanLrsAttachment != null) {
            return lfTincanLrsAttachment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanLrsAttachmentException(msg.toString());
    }

    /**
     * Returns the last l f tincan lrs attachment in the ordered set where parentID = &#63;.
     *
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan lrs attachment, or <code>null</code> if a matching l f tincan lrs attachment could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment fetchByParentID_Last(Integer parentID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByParentID(parentID);

        List<LFTincanLrsAttachment> list = findByParentID(parentID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan lrs attachments before and after the current l f tincan lrs attachment in the ordered set where parentID = &#63;.
     *
     * @param id the primary key of the current l f tincan lrs attachment
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan lrs attachment
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAttachmentException if a l f tincan lrs attachment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsAttachment[] findByParentID_PrevAndNext(long id,
        Integer parentID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanLrsAttachmentException, SystemException {
        LFTincanLrsAttachment lfTincanLrsAttachment = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanLrsAttachment[] array = new LFTincanLrsAttachmentImpl[3];

            array[0] = getByParentID_PrevAndNext(session,
                    lfTincanLrsAttachment, parentID, orderByComparator, true);

            array[1] = lfTincanLrsAttachment;

            array[2] = getByParentID_PrevAndNext(session,
                    lfTincanLrsAttachment, parentID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanLrsAttachment getByParentID_PrevAndNext(Session session,
        LFTincanLrsAttachment lfTincanLrsAttachment, Integer parentID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANLRSATTACHMENT_WHERE);

        if (parentID == null) {
            query.append(_FINDER_COLUMN_PARENTID_PARENTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);
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

        if (parentID != null) {
            qPos.add(parentID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanLrsAttachment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanLrsAttachment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan lrs attachments.
     *
     * @return the l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAttachment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs attachments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs attachments
     * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
     * @return the range of l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAttachment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs attachments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs attachments
     * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsAttachment> findAll(int start, int end,
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

        List<LFTincanLrsAttachment> list = (List<LFTincanLrsAttachment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSATTACHMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSATTACHMENT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsAttachment>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsAttachment>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs attachments where parentID = &#63; from the database.
     *
     * @param parentID the parent i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByParentID(Integer parentID) throws SystemException {
        for (LFTincanLrsAttachment lfTincanLrsAttachment : findByParentID(
                parentID)) {
            remove(lfTincanLrsAttachment);
        }
    }

    /**
     * Removes all the l f tincan lrs attachments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsAttachment lfTincanLrsAttachment : findAll()) {
            remove(lfTincanLrsAttachment);
        }
    }

    /**
     * Returns the number of l f tincan lrs attachments where parentID = &#63;.
     *
     * @param parentID the parent i d
     * @return the number of matching l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public int countByParentID(Integer parentID) throws SystemException {
        Object[] finderArgs = new Object[] { parentID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANLRSATTACHMENT_WHERE);

            if (parentID == null) {
                query.append(_FINDER_COLUMN_PARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (parentID != null) {
                    qPos.add(parentID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f tincan lrs attachments.
     *
     * @return the number of l f tincan lrs attachments
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSATTACHMENT);

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
     * Initializes the l f tincan lrs attachment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsAttachment>> listenersList = new ArrayList<ModelListener<LFTincanLrsAttachment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsAttachment>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsAttachmentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

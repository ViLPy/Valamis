package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesModelImpl;
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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the l f tincan lrs context activities service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextActivitiesPersistence
 * @see LFTincanLrsContextActivitiesUtil
 * @generated
 */
public class LFTincanLrsContextActivitiesPersistenceImpl
    extends BasePersistenceImpl<LFTincanLrsContextActivities>
    implements LFTincanLrsContextActivitiesPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsContextActivitiesUtil} to access the l f tincan lrs context activities persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsContextActivitiesImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextActivitiesModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsContextActivitiesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextActivitiesModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsContextActivitiesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextActivitiesModelImpl.FINDER_CACHE_ENABLED,
            Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
            new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSCONTEXTACTIVITIES = "SELECT lfTincanLrsContextActivities FROM LFTincanLrsContextActivities lfTincanLrsContextActivities";
    private static final String _SQL_COUNT_LFTINCANLRSCONTEXTACTIVITIES = "SELECT COUNT(lfTincanLrsContextActivities) FROM LFTincanLrsContextActivities lfTincanLrsContextActivities";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsContextActivities.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsContextActivities exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsContextActivitiesPersistenceImpl.class);
    private static LFTincanLrsContextActivities _nullLFTincanLrsContextActivities =
        new LFTincanLrsContextActivitiesImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsContextActivities> toCacheModel() {
                return _nullLFTincanLrsContextActivitiesCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsContextActivities> _nullLFTincanLrsContextActivitiesCacheModel =
        new CacheModel<LFTincanLrsContextActivities>() {
            public LFTincanLrsContextActivities toEntityModel() {
                return _nullLFTincanLrsContextActivities;
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
     * Caches the l f tincan lrs context activities in the entity cache if it is enabled.
     *
     * @param lfTincanLrsContextActivities the l f tincan lrs context activities
     */
    public void cacheResult(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        EntityCacheUtil.putResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextActivitiesImpl.class,
            lfTincanLrsContextActivities.getPrimaryKey(),
            lfTincanLrsContextActivities);

        lfTincanLrsContextActivities.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs context activitieses in the entity cache if it is enabled.
     *
     * @param lfTincanLrsContextActivitieses the l f tincan lrs context activitieses
     */
    public void cacheResult(
        List<LFTincanLrsContextActivities> lfTincanLrsContextActivitieses) {
        for (LFTincanLrsContextActivities lfTincanLrsContextActivities : lfTincanLrsContextActivitieses) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsContextActivitiesImpl.class,
                        lfTincanLrsContextActivities.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsContextActivities);
            } else {
                lfTincanLrsContextActivities.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs context activitieses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsContextActivitiesImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsContextActivitiesImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs context activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        EntityCacheUtil.removeResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextActivitiesImpl.class,
            lfTincanLrsContextActivities.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<LFTincanLrsContextActivities> lfTincanLrsContextActivitieses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsContextActivities lfTincanLrsContextActivities : lfTincanLrsContextActivitieses) {
            EntityCacheUtil.removeResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsContextActivitiesImpl.class,
                lfTincanLrsContextActivities.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs context activities with the primary key. Does not add the l f tincan lrs context activities to the database.
     *
     * @param id the primary key for the new l f tincan lrs context activities
     * @return the new l f tincan lrs context activities
     */
    public LFTincanLrsContextActivities create(long id) {
        LFTincanLrsContextActivities lfTincanLrsContextActivities = new LFTincanLrsContextActivitiesImpl();

        lfTincanLrsContextActivities.setNew(true);
        lfTincanLrsContextActivities.setPrimaryKey(id);

        return lfTincanLrsContextActivities;
    }

    /**
     * Removes the l f tincan lrs context activities with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsContextActivities remove(long id)
        throws NoSuchLFTincanLrsContextActivitiesException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs context activities with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContextActivities remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsContextActivitiesException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsContextActivities lfTincanLrsContextActivities = (LFTincanLrsContextActivities) session.get(LFTincanLrsContextActivitiesImpl.class,
                    primaryKey);

            if (lfTincanLrsContextActivities == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsContextActivitiesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsContextActivities);
        } catch (NoSuchLFTincanLrsContextActivitiesException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsContextActivities removeImpl(
        LFTincanLrsContextActivities lfTincanLrsContextActivities)
        throws SystemException {
        lfTincanLrsContextActivities = toUnwrappedModel(lfTincanLrsContextActivities);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsContextActivities);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsContextActivities);

        return lfTincanLrsContextActivities;
    }

    @Override
    public LFTincanLrsContextActivities updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities,
        boolean merge) throws SystemException {
        lfTincanLrsContextActivities = toUnwrappedModel(lfTincanLrsContextActivities);

        boolean isNew = lfTincanLrsContextActivities.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsContextActivities, merge);

            lfTincanLrsContextActivities.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextActivitiesImpl.class,
            lfTincanLrsContextActivities.getPrimaryKey(),
            lfTincanLrsContextActivities);

        return lfTincanLrsContextActivities;
    }

    protected LFTincanLrsContextActivities toUnwrappedModel(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        if (lfTincanLrsContextActivities instanceof LFTincanLrsContextActivitiesImpl) {
            return lfTincanLrsContextActivities;
        }

        LFTincanLrsContextActivitiesImpl lfTincanLrsContextActivitiesImpl = new LFTincanLrsContextActivitiesImpl();

        lfTincanLrsContextActivitiesImpl.setNew(lfTincanLrsContextActivities.isNew());
        lfTincanLrsContextActivitiesImpl.setPrimaryKey(lfTincanLrsContextActivities.getPrimaryKey());

        lfTincanLrsContextActivitiesImpl.setId(lfTincanLrsContextActivities.getId());
        lfTincanLrsContextActivitiesImpl.setParent(lfTincanLrsContextActivities.getParent());
        lfTincanLrsContextActivitiesImpl.setGrouping(lfTincanLrsContextActivities.getGrouping());
        lfTincanLrsContextActivitiesImpl.setCategory(lfTincanLrsContextActivities.getCategory());
        lfTincanLrsContextActivitiesImpl.setOther(lfTincanLrsContextActivities.getOther());

        return lfTincanLrsContextActivitiesImpl;
    }

    /**
     * Returns the l f tincan lrs context activities with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContextActivities findByPrimaryKey(
        Serializable primaryKey) throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs context activities with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsContextActivities findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsContextActivitiesException, SystemException {
        LFTincanLrsContextActivities lfTincanLrsContextActivities = fetchByPrimaryKey(id);

        if (lfTincanLrsContextActivities == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsContextActivitiesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsContextActivities;
    }

    /**
     * Returns the l f tincan lrs context activities with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities, or <code>null</code> if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContextActivities fetchByPrimaryKey(
        Serializable primaryKey) throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs context activities with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities, or <code>null</code> if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsContextActivities fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsContextActivities lfTincanLrsContextActivities = (LFTincanLrsContextActivities) EntityCacheUtil.getResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsContextActivitiesImpl.class, id);

        if (lfTincanLrsContextActivities == _nullLFTincanLrsContextActivities) {
            return null;
        }

        if (lfTincanLrsContextActivities == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsContextActivities = (LFTincanLrsContextActivities) session.get(LFTincanLrsContextActivitiesImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsContextActivities != null) {
                    cacheResult(lfTincanLrsContextActivities);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsContextActivitiesImpl.class, id,
                        _nullLFTincanLrsContextActivities);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsContextActivities;
    }

    /**
     * Returns all the l f tincan lrs context activitieses.
     *
     * @return the l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsContextActivities> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs context activitieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs context activitieses
     * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
     * @return the range of l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsContextActivities> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs context activitieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs context activitieses
     * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsContextActivities> findAll(int start, int end,
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

        List<LFTincanLrsContextActivities> list = (List<LFTincanLrsContextActivities>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSCONTEXTACTIVITIES);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSCONTEXTACTIVITIES;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsContextActivities>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsContextActivities>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs context activitieses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsContextActivities lfTincanLrsContextActivities : findAll()) {
            remove(lfTincanLrsContextActivities);
        }
    }

    /**
     * Returns the number of l f tincan lrs context activitieses.
     *
     * @return the number of l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSCONTEXTACTIVITIES);

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
     * Initializes the l f tincan lrs context activities persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsContextActivities>> listenersList = new ArrayList<ModelListener<LFTincanLrsContextActivities>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsContextActivities>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsContextActivitiesImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

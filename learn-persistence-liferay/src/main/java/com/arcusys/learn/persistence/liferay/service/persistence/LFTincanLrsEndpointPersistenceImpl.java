package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointModelImpl;
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
 * The persistence implementation for the l f tincan lrs endpoint service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsEndpointPersistence
 * @see LFTincanLrsEndpointUtil
 * @generated
 */
public class LFTincanLrsEndpointPersistenceImpl extends BasePersistenceImpl<LFTincanLrsEndpoint>
    implements LFTincanLrsEndpointPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsEndpointUtil} to access the l f tincan lrs endpoint persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsEndpointImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsEndpointModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsEndpointImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsEndpointModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsEndpointImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsEndpointModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSENDPOINT = "SELECT lfTincanLrsEndpoint FROM LFTincanLrsEndpoint lfTincanLrsEndpoint";
    private static final String _SQL_COUNT_LFTINCANLRSENDPOINT = "SELECT COUNT(lfTincanLrsEndpoint) FROM LFTincanLrsEndpoint lfTincanLrsEndpoint";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsEndpoint.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsEndpoint exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsEndpointPersistenceImpl.class);
    private static LFTincanLrsEndpoint _nullLFTincanLrsEndpoint = new LFTincanLrsEndpointImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsEndpoint> toCacheModel() {
                return _nullLFTincanLrsEndpointCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsEndpoint> _nullLFTincanLrsEndpointCacheModel =
        new CacheModel<LFTincanLrsEndpoint>() {
            public LFTincanLrsEndpoint toEntityModel() {
                return _nullLFTincanLrsEndpoint;
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
     * Caches the l f tincan lrs endpoint in the entity cache if it is enabled.
     *
     * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
     */
    public void cacheResult(LFTincanLrsEndpoint lfTincanLrsEndpoint) {
        EntityCacheUtil.putResult(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsEndpointImpl.class, lfTincanLrsEndpoint.getPrimaryKey(),
            lfTincanLrsEndpoint);

        lfTincanLrsEndpoint.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs endpoints in the entity cache if it is enabled.
     *
     * @param lfTincanLrsEndpoints the l f tincan lrs endpoints
     */
    public void cacheResult(List<LFTincanLrsEndpoint> lfTincanLrsEndpoints) {
        for (LFTincanLrsEndpoint lfTincanLrsEndpoint : lfTincanLrsEndpoints) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsEndpointImpl.class,
                        lfTincanLrsEndpoint.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsEndpoint);
            } else {
                lfTincanLrsEndpoint.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs endpoints.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsEndpointImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsEndpointImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs endpoint.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsEndpoint lfTincanLrsEndpoint) {
        EntityCacheUtil.removeResult(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsEndpointImpl.class, lfTincanLrsEndpoint.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFTincanLrsEndpoint> lfTincanLrsEndpoints) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsEndpoint lfTincanLrsEndpoint : lfTincanLrsEndpoints) {
            EntityCacheUtil.removeResult(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsEndpointImpl.class,
                lfTincanLrsEndpoint.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs endpoint with the primary key. Does not add the l f tincan lrs endpoint to the database.
     *
     * @param id the primary key for the new l f tincan lrs endpoint
     * @return the new l f tincan lrs endpoint
     */
    public LFTincanLrsEndpoint create(long id) {
        LFTincanLrsEndpoint lfTincanLrsEndpoint = new LFTincanLrsEndpointImpl();

        lfTincanLrsEndpoint.setNew(true);
        lfTincanLrsEndpoint.setPrimaryKey(id);

        return lfTincanLrsEndpoint;
    }

    /**
     * Removes the l f tincan lrs endpoint with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs endpoint
     * @return the l f tincan lrs endpoint that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException if a l f tincan lrs endpoint with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsEndpoint remove(long id)
        throws NoSuchLFTincanLrsEndpointException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f tincan lrs endpoint with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs endpoint
     * @return the l f tincan lrs endpoint that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException if a l f tincan lrs endpoint with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsEndpoint remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsEndpointException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsEndpoint lfTincanLrsEndpoint = (LFTincanLrsEndpoint) session.get(LFTincanLrsEndpointImpl.class,
                    primaryKey);

            if (lfTincanLrsEndpoint == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsEndpointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsEndpoint);
        } catch (NoSuchLFTincanLrsEndpointException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsEndpoint removeImpl(
        LFTincanLrsEndpoint lfTincanLrsEndpoint) throws SystemException {
        lfTincanLrsEndpoint = toUnwrappedModel(lfTincanLrsEndpoint);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfTincanLrsEndpoint);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfTincanLrsEndpoint);

        return lfTincanLrsEndpoint;
    }

    @Override
    public LFTincanLrsEndpoint updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint,
        boolean merge) throws SystemException {
        lfTincanLrsEndpoint = toUnwrappedModel(lfTincanLrsEndpoint);

        boolean isNew = lfTincanLrsEndpoint.isNew();

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfTincanLrsEndpoint, merge);

            lfTincanLrsEndpoint.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsEndpointImpl.class, lfTincanLrsEndpoint.getPrimaryKey(),
            lfTincanLrsEndpoint);

        return lfTincanLrsEndpoint;
    }

    protected LFTincanLrsEndpoint toUnwrappedModel(
        LFTincanLrsEndpoint lfTincanLrsEndpoint) {
        if (lfTincanLrsEndpoint instanceof LFTincanLrsEndpointImpl) {
            return lfTincanLrsEndpoint;
        }

        LFTincanLrsEndpointImpl lfTincanLrsEndpointImpl = new LFTincanLrsEndpointImpl();

        lfTincanLrsEndpointImpl.setNew(lfTincanLrsEndpoint.isNew());
        lfTincanLrsEndpointImpl.setPrimaryKey(lfTincanLrsEndpoint.getPrimaryKey());

        lfTincanLrsEndpointImpl.setId(lfTincanLrsEndpoint.getId());
        lfTincanLrsEndpointImpl.setEndpoint(lfTincanLrsEndpoint.getEndpoint());
        lfTincanLrsEndpointImpl.setAuthType(lfTincanLrsEndpoint.getAuthType());
        lfTincanLrsEndpointImpl.setKey(lfTincanLrsEndpoint.getKey());
        lfTincanLrsEndpointImpl.setSecret(lfTincanLrsEndpoint.getSecret());

        return lfTincanLrsEndpointImpl;
    }

    /**
     * Returns the l f tincan lrs endpoint with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs endpoint
     * @return the l f tincan lrs endpoint
     * @throws com.liferay.portal.NoSuchModelException if a l f tincan lrs endpoint with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsEndpoint findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs endpoint with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs endpoint
     * @return the l f tincan lrs endpoint
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsEndpointException if a l f tincan lrs endpoint with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsEndpoint findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsEndpointException, SystemException {
        LFTincanLrsEndpoint lfTincanLrsEndpoint = fetchByPrimaryKey(id);

        if (lfTincanLrsEndpoint == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFTincanLrsEndpointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfTincanLrsEndpoint;
    }

    /**
     * Returns the l f tincan lrs endpoint with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs endpoint
     * @return the l f tincan lrs endpoint, or <code>null</code> if a l f tincan lrs endpoint with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsEndpoint fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f tincan lrs endpoint with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs endpoint
     * @return the l f tincan lrs endpoint, or <code>null</code> if a l f tincan lrs endpoint with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFTincanLrsEndpoint fetchByPrimaryKey(long id)
        throws SystemException {
        LFTincanLrsEndpoint lfTincanLrsEndpoint = (LFTincanLrsEndpoint) EntityCacheUtil.getResult(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsEndpointImpl.class, id);

        if (lfTincanLrsEndpoint == _nullLFTincanLrsEndpoint) {
            return null;
        }

        if (lfTincanLrsEndpoint == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfTincanLrsEndpoint = (LFTincanLrsEndpoint) session.get(LFTincanLrsEndpointImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfTincanLrsEndpoint != null) {
                    cacheResult(lfTincanLrsEndpoint);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFTincanLrsEndpointModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsEndpointImpl.class, id,
                        _nullLFTincanLrsEndpoint);
                }

                closeSession(session);
            }
        }

        return lfTincanLrsEndpoint;
    }

    /**
     * Returns all the l f tincan lrs endpoints.
     *
     * @return the l f tincan lrs endpoints
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsEndpoint> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs endpoints.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs endpoints
     * @param end the upper bound of the range of l f tincan lrs endpoints (not inclusive)
     * @return the range of l f tincan lrs endpoints
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsEndpoint> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs endpoints.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs endpoints
     * @param end the upper bound of the range of l f tincan lrs endpoints (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs endpoints
     * @throws SystemException if a system exception occurred
     */
    public List<LFTincanLrsEndpoint> findAll(int start, int end,
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

        List<LFTincanLrsEndpoint> list = (List<LFTincanLrsEndpoint>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSENDPOINT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSENDPOINT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFTincanLrsEndpoint>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFTincanLrsEndpoint>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs endpoints from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFTincanLrsEndpoint lfTincanLrsEndpoint : findAll()) {
            remove(lfTincanLrsEndpoint);
        }
    }

    /**
     * Returns the number of l f tincan lrs endpoints.
     *
     * @return the number of l f tincan lrs endpoints
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSENDPOINT);

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
     * Initializes the l f tincan lrs endpoint persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsEndpoint>> listenersList = new ArrayList<ModelListener<LFTincanLrsEndpoint>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsEndpoint>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsEndpointImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

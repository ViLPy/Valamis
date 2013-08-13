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
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupContributionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPermissionsPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSequencingTrackingPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSocialPackageTagPersistence;
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
    private static final String _SQL_COUNT_LFCERTIFICATE = "SELECT COUNT(lfCertificate) FROM LFCertificate lfCertificate";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificate.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificate exists with the primary key ";
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

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
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

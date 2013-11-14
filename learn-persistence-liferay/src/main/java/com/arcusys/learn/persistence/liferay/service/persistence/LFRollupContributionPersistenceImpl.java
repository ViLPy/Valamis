package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException;
import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupContributionModelImpl;
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
 * The persistence implementation for the l f rollup contribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupContributionPersistence
 * @see LFRollupContributionUtil
 * @generated
 */
public class LFRollupContributionPersistenceImpl extends BasePersistenceImpl<LFRollupContribution>
    implements LFRollupContributionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRollupContributionUtil} to access the l f rollup contribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRollupContributionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_SEQUENCINGID = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED,
            LFRollupContributionImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchBySequencingID", new String[] { Integer.class.getName() },
            LFRollupContributionModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFROLLUPCONTRIBUTION = "SELECT lfRollupContribution FROM LFRollupContribution lfRollupContribution";
    private static final String _SQL_SELECT_LFROLLUPCONTRIBUTION_WHERE = "SELECT lfRollupContribution FROM LFRollupContribution lfRollupContribution WHERE ";
    private static final String _SQL_COUNT_LFROLLUPCONTRIBUTION = "SELECT COUNT(lfRollupContribution) FROM LFRollupContribution lfRollupContribution";
    private static final String _SQL_COUNT_LFROLLUPCONTRIBUTION_WHERE = "SELECT COUNT(lfRollupContribution) FROM LFRollupContribution lfRollupContribution WHERE ";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfRollupContribution.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfRollupContribution.sequencingID IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfRollupContribution.sequencingID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRollupContribution.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRollupContribution exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRollupContribution exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRollupContributionPersistenceImpl.class);
    private static LFRollupContribution _nullLFRollupContribution = new LFRollupContributionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRollupContribution> toCacheModel() {
                return _nullLFRollupContributionCacheModel;
            }
        };

    private static CacheModel<LFRollupContribution> _nullLFRollupContributionCacheModel =
        new CacheModel<LFRollupContribution>() {
            public LFRollupContribution toEntityModel() {
                return _nullLFRollupContribution;
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
     * Caches the l f rollup contribution in the entity cache if it is enabled.
     *
     * @param lfRollupContribution the l f rollup contribution
     */
    public void cacheResult(LFRollupContribution lfRollupContribution) {
        EntityCacheUtil.putResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            lfRollupContribution.getPrimaryKey(), lfRollupContribution);

        boolean noNullsInSEQUENCINGID = true;

        if (lfRollupContribution.getSequencingID() == null) {
            noNullsInSEQUENCINGID = false;
        }

        if (noNullsInSEQUENCINGID) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                new Object[] {
                    Integer.valueOf(lfRollupContribution.getSequencingID())
                }, lfRollupContribution);
        }

        lfRollupContribution.resetOriginalValues();
    }

    /**
     * Caches the l f rollup contributions in the entity cache if it is enabled.
     *
     * @param lfRollupContributions the l f rollup contributions
     */
    public void cacheResult(List<LFRollupContribution> lfRollupContributions) {
        for (LFRollupContribution lfRollupContribution : lfRollupContributions) {
            if (EntityCacheUtil.getResult(
                        LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupContributionImpl.class,
                        lfRollupContribution.getPrimaryKey()) == null) {
                cacheResult(lfRollupContribution);
            } else {
                lfRollupContribution.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f rollup contributions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRollupContributionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRollupContributionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f rollup contribution.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRollupContribution lfRollupContribution) {
        EntityCacheUtil.removeResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionImpl.class, lfRollupContribution.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfRollupContribution);
    }

    @Override
    public void clearCache(List<LFRollupContribution> lfRollupContributions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRollupContribution lfRollupContribution : lfRollupContributions) {
            EntityCacheUtil.removeResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupContributionImpl.class,
                lfRollupContribution.getPrimaryKey());

            clearUniqueFindersCache(lfRollupContribution);
        }
    }

    protected void clearUniqueFindersCache(
        LFRollupContribution lfRollupContribution) {
        boolean noNullsInSEQUENCINGID = true;

        if (lfRollupContribution.getSequencingID() == null) {
            noNullsInSEQUENCINGID = false;
        }

        if (noNullsInSEQUENCINGID) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                new Object[] {
                    Integer.valueOf(lfRollupContribution.getSequencingID())
                });
        }
    }

    /**
     * Creates a new l f rollup contribution with the primary key. Does not add the l f rollup contribution to the database.
     *
     * @param id the primary key for the new l f rollup contribution
     * @return the new l f rollup contribution
     */
    public LFRollupContribution create(long id) {
        LFRollupContribution lfRollupContribution = new LFRollupContributionImpl();

        lfRollupContribution.setNew(true);
        lfRollupContribution.setPrimaryKey(id);

        return lfRollupContribution;
    }

    /**
     * Removes the l f rollup contribution with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f rollup contribution
     * @return the l f rollup contribution that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution remove(long id)
        throws NoSuchLFRollupContributionException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f rollup contribution with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f rollup contribution
     * @return the l f rollup contribution that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution remove(Serializable primaryKey)
        throws NoSuchLFRollupContributionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRollupContribution lfRollupContribution = (LFRollupContribution) session.get(LFRollupContributionImpl.class,
                    primaryKey);

            if (lfRollupContribution == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRollupContributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRollupContribution);
        } catch (NoSuchLFRollupContributionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRollupContribution removeImpl(
        LFRollupContribution lfRollupContribution) throws SystemException {
        lfRollupContribution = toUnwrappedModel(lfRollupContribution);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfRollupContribution);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfRollupContribution);

        return lfRollupContribution;
    }

    @Override
    public LFRollupContribution updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution,
        boolean merge) throws SystemException {
        lfRollupContribution = toUnwrappedModel(lfRollupContribution);

        boolean isNew = lfRollupContribution.isNew();

        LFRollupContributionModelImpl lfRollupContributionModelImpl = (LFRollupContributionModelImpl) lfRollupContribution;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfRollupContribution, merge);

            lfRollupContribution.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRollupContributionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupContributionImpl.class,
            lfRollupContribution.getPrimaryKey(), lfRollupContribution);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                new Object[] { /*Integer.valueOf( */
                lfRollupContribution.getSequencingID()/*) */
                }, lfRollupContribution);
        } else {
            if ((lfRollupContributionModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /*        Integer.valueOf( */
                        lfRollupContributionModelImpl.getOriginalSequencingID()
                    /*        ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    new Object[] { /*        Integer.valueOf( */
                    lfRollupContribution.getSequencingID()/*        ) */
                    }, lfRollupContribution);
            }
        }

        return lfRollupContribution;
    }

    protected LFRollupContribution toUnwrappedModel(
        LFRollupContribution lfRollupContribution) {
        if (lfRollupContribution instanceof LFRollupContributionImpl) {
            return lfRollupContribution;
        }

        LFRollupContributionImpl lfRollupContributionImpl = new LFRollupContributionImpl();

        lfRollupContributionImpl.setNew(lfRollupContribution.isNew());
        lfRollupContributionImpl.setPrimaryKey(lfRollupContribution.getPrimaryKey());

        lfRollupContributionImpl.setId(lfRollupContribution.getId());
        lfRollupContributionImpl.setSequencingID(lfRollupContribution.getSequencingID());
        lfRollupContributionImpl.setContributeToSatisfied(lfRollupContribution.getContributeToSatisfied());
        lfRollupContributionImpl.setContributeToNotSatisfied(lfRollupContribution.getContributeToNotSatisfied());
        lfRollupContributionImpl.setContributeToCompleted(lfRollupContribution.getContributeToCompleted());
        lfRollupContributionImpl.setContributeToIncomplete(lfRollupContribution.getContributeToIncomplete());
        lfRollupContributionImpl.setObjectiveMeasureWeight(lfRollupContribution.getObjectiveMeasureWeight());
        lfRollupContributionImpl.setMeasureSatisfactionIfActive(lfRollupContribution.isMeasureSatisfactionIfActive());

        return lfRollupContributionImpl;
    }

    /**
     * Returns the l f rollup contribution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup contribution
     * @return the l f rollup contribution
     * @throws com.liferay.portal.NoSuchModelException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f rollup contribution with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException} if it could not be found.
     *
     * @param id the primary key of the l f rollup contribution
     * @return the l f rollup contribution
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution findByPrimaryKey(long id)
        throws NoSuchLFRollupContributionException, SystemException {
        LFRollupContribution lfRollupContribution = fetchByPrimaryKey(id);

        if (lfRollupContribution == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFRollupContributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfRollupContribution;
    }

    /**
     * Returns the l f rollup contribution with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup contribution
     * @return the l f rollup contribution, or <code>null</code> if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupContribution fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f rollup contribution with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f rollup contribution
     * @return the l f rollup contribution, or <code>null</code> if a l f rollup contribution with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution fetchByPrimaryKey(long id)
        throws SystemException {
        LFRollupContribution lfRollupContribution = (LFRollupContribution) EntityCacheUtil.getResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupContributionImpl.class, id);

        if (lfRollupContribution == _nullLFRollupContribution) {
            return null;
        }

        if (lfRollupContribution == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfRollupContribution = (LFRollupContribution) session.get(LFRollupContributionImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfRollupContribution != null) {
                    cacheResult(lfRollupContribution);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFRollupContributionModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupContributionImpl.class, id,
                        _nullLFRollupContribution);
                }

                closeSession(session);
            }
        }

        return lfRollupContribution;
    }

    /**
     * Returns the l f rollup contribution where sequencingID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException} if it could not be found.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f rollup contribution
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException if a matching l f rollup contribution could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution findBySequencingID(Integer sequencingID)
        throws NoSuchLFRollupContributionException, SystemException {
        LFRollupContribution lfRollupContribution = fetchBySequencingID(sequencingID);

        if (lfRollupContribution == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("sequencingID=");
            msg.append(sequencingID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFRollupContributionException(msg.toString());
        }

        return lfRollupContribution;
    }

    /**
     * Returns the l f rollup contribution where sequencingID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f rollup contribution, or <code>null</code> if a matching l f rollup contribution could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution fetchBySequencingID(Integer sequencingID)
        throws SystemException {
        return fetchBySequencingID(sequencingID, true);
    }

    /**
     * Returns the l f rollup contribution where sequencingID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param sequencingID the sequencing i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f rollup contribution, or <code>null</code> if a matching l f rollup contribution could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution fetchBySequencingID(Integer sequencingID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                    finderArgs, this);
        }

        if (result instanceof LFRollupContribution) {
            LFRollupContribution lfRollupContribution = (LFRollupContribution) result;

            if (!Validator.equals(sequencingID,
                        lfRollupContribution.getSequencingID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_SELECT_LFROLLUPCONTRIBUTION_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                List<LFRollupContribution> list = q.list();

                result = list;

                LFRollupContribution lfRollupContribution = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                        finderArgs, list);
                } else {
                    lfRollupContribution = list.get(0);

                    cacheResult(lfRollupContribution);

                    if ((lfRollupContribution.getSequencingID() != sequencingID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                            finderArgs, lfRollupContribution);
                    }
                }

                return lfRollupContribution;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SEQUENCINGID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFRollupContribution) result;
            }
        }
    }

    /**
     * Returns all the l f rollup contributions.
     *
     * @return the l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupContribution> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rollup contributions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup contributions
     * @param end the upper bound of the range of l f rollup contributions (not inclusive)
     * @return the range of l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupContribution> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rollup contributions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup contributions
     * @param end the upper bound of the range of l f rollup contributions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    public List<LFRollupContribution> findAll(int start, int end,
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

        List<LFRollupContribution> list = (List<LFRollupContribution>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFROLLUPCONTRIBUTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFROLLUPCONTRIBUTION;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFRollupContribution>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFRollupContribution>) QueryUtil.list(q,
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
     * Removes the l f rollup contribution where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @return the l f rollup contribution that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFRollupContribution removeBySequencingID(Integer sequencingID)
        throws NoSuchLFRollupContributionException, SystemException {
        LFRollupContribution lfRollupContribution = findBySequencingID(sequencingID);

        return remove(lfRollupContribution);
    }

    /**
     * Removes all the l f rollup contributions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFRollupContribution lfRollupContribution : findAll()) {
            remove(lfRollupContribution);
        }
    }

    /**
     * Returns the number of l f rollup contributions where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFROLLUPCONTRIBUTION_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f rollup contributions.
     *
     * @return the number of l f rollup contributions
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFROLLUPCONTRIBUTION);

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
     * Initializes the l f rollup contribution persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRollupContribution")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRollupContribution>> listenersList = new ArrayList<ModelListener<LFRollupContribution>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRollupContribution>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRollupContributionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

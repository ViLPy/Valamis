package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException;
import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;
import com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityDataMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateNodePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityStateTreePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAnswerPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFChildrenSelectionPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConditionRulePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCoursePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFFileStoragePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectivePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveStatePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageScopeRulePersistence;
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
 * The persistence implementation for the l f sequencing tracking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingTrackingPersistence
 * @see LFSequencingTrackingUtil
 * @generated
 */
public class LFSequencingTrackingPersistenceImpl extends BasePersistenceImpl<LFSequencingTracking>
    implements LFSequencingTrackingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSequencingTrackingUtil} to access the l f sequencing tracking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSequencingTrackingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingModelImpl.FINDER_CACHE_ENABLED,
            LFSequencingTrackingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySequencingID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingModelImpl.FINDER_CACHE_ENABLED,
            LFSequencingTrackingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequencingID",
            new String[] { Integer.class.getName() },
            LFSequencingTrackingModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingModelImpl.FINDER_CACHE_ENABLED,
            LFSequencingTrackingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingModelImpl.FINDER_CACHE_ENABLED,
            LFSequencingTrackingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFSEQUENCINGTRACKING = "SELECT lfSequencingTracking FROM LFSequencingTracking lfSequencingTracking";
    private static final String _SQL_SELECT_LFSEQUENCINGTRACKING_WHERE = "SELECT lfSequencingTracking FROM LFSequencingTracking lfSequencingTracking WHERE ";
    private static final String _SQL_COUNT_LFSEQUENCINGTRACKING = "SELECT COUNT(lfSequencingTracking) FROM LFSequencingTracking lfSequencingTracking";
    private static final String _SQL_COUNT_LFSEQUENCINGTRACKING_WHERE = "SELECT COUNT(lfSequencingTracking) FROM LFSequencingTracking lfSequencingTracking WHERE ";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfSequencingTracking.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfSequencingTracking.sequencingID IS NULL ";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfSequencingTracking.sequencingID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSequencingTracking.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSequencingTracking exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSequencingTracking exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSequencingTrackingPersistenceImpl.class);
    private static LFSequencingTracking _nullLFSequencingTracking = new LFSequencingTrackingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSequencingTracking> toCacheModel() {
                return _nullLFSequencingTrackingCacheModel;
            }
        };

    private static CacheModel<LFSequencingTracking> _nullLFSequencingTrackingCacheModel =
        new CacheModel<LFSequencingTracking>() {
            public LFSequencingTracking toEntityModel() {
                return _nullLFSequencingTracking;
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
    @BeanReference(type = LFPackageScopeRulePersistence.class)
    protected LFPackageScopeRulePersistence lfPackageScopeRulePersistence;
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
    @BeanReference(type = LFUserPersistence.class)
    protected LFUserPersistence lfUserPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the l f sequencing tracking in the entity cache if it is enabled.
     *
     * @param lfSequencingTracking the l f sequencing tracking
     */
    public void cacheResult(LFSequencingTracking lfSequencingTracking) {
        EntityCacheUtil.putResult(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingImpl.class,
            lfSequencingTracking.getPrimaryKey(), lfSequencingTracking);

        lfSequencingTracking.resetOriginalValues();
    }

    /**
     * Caches the l f sequencing trackings in the entity cache if it is enabled.
     *
     * @param lfSequencingTrackings the l f sequencing trackings
     */
    public void cacheResult(List<LFSequencingTracking> lfSequencingTrackings) {
        for (LFSequencingTracking lfSequencingTracking : lfSequencingTrackings) {
            if (EntityCacheUtil.getResult(
                        LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
                        LFSequencingTrackingImpl.class,
                        lfSequencingTracking.getPrimaryKey()) == null) {
                cacheResult(lfSequencingTracking);
            } else {
                lfSequencingTracking.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f sequencing trackings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSequencingTrackingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSequencingTrackingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f sequencing tracking.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSequencingTracking lfSequencingTracking) {
        EntityCacheUtil.removeResult(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingImpl.class, lfSequencingTracking.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFSequencingTracking> lfSequencingTrackings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSequencingTracking lfSequencingTracking : lfSequencingTrackings) {
            EntityCacheUtil.removeResult(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
                LFSequencingTrackingImpl.class,
                lfSequencingTracking.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f sequencing tracking with the primary key. Does not add the l f sequencing tracking to the database.
     *
     * @param id the primary key for the new l f sequencing tracking
     * @return the new l f sequencing tracking
     */
    public LFSequencingTracking create(long id) {
        LFSequencingTracking lfSequencingTracking = new LFSequencingTrackingImpl();

        lfSequencingTracking.setNew(true);
        lfSequencingTracking.setPrimaryKey(id);

        return lfSequencingTracking;
    }

    /**
     * Removes the l f sequencing tracking with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f sequencing tracking
     * @return the l f sequencing tracking that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking remove(long id)
        throws NoSuchLFSequencingTrackingException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f sequencing tracking with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f sequencing tracking
     * @return the l f sequencing tracking that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSequencingTracking remove(Serializable primaryKey)
        throws NoSuchLFSequencingTrackingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSequencingTracking lfSequencingTracking = (LFSequencingTracking) session.get(LFSequencingTrackingImpl.class,
                    primaryKey);

            if (lfSequencingTracking == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSequencingTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSequencingTracking);
        } catch (NoSuchLFSequencingTrackingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSequencingTracking removeImpl(
        LFSequencingTracking lfSequencingTracking) throws SystemException {
        lfSequencingTracking = toUnwrappedModel(lfSequencingTracking);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfSequencingTracking);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfSequencingTracking);

        return lfSequencingTracking;
    }

    @Override
    public LFSequencingTracking updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSequencingTracking lfSequencingTracking,
        boolean merge) throws SystemException {
        lfSequencingTracking = toUnwrappedModel(lfSequencingTracking);

        boolean isNew = lfSequencingTracking.isNew();

        LFSequencingTrackingModelImpl lfSequencingTrackingModelImpl = (LFSequencingTrackingModelImpl) lfSequencingTracking;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfSequencingTracking, merge);

            lfSequencingTracking.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSequencingTrackingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfSequencingTrackingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfSequencingTrackingModelImpl.getOriginalSequencingID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfSequencingTrackingModelImpl.getSequencingID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
            LFSequencingTrackingImpl.class,
            lfSequencingTracking.getPrimaryKey(), lfSequencingTracking);

        return lfSequencingTracking;
    }

    protected LFSequencingTracking toUnwrappedModel(
        LFSequencingTracking lfSequencingTracking) {
        if (lfSequencingTracking instanceof LFSequencingTrackingImpl) {
            return lfSequencingTracking;
        }

        LFSequencingTrackingImpl lfSequencingTrackingImpl = new LFSequencingTrackingImpl();

        lfSequencingTrackingImpl.setNew(lfSequencingTracking.isNew());
        lfSequencingTrackingImpl.setPrimaryKey(lfSequencingTracking.getPrimaryKey());

        lfSequencingTrackingImpl.setId(lfSequencingTracking.getId());
        lfSequencingTrackingImpl.setSequencingID(lfSequencingTracking.getSequencingID());
        lfSequencingTrackingImpl.setCompletionSetByContent(lfSequencingTracking.isCompletionSetByContent());
        lfSequencingTrackingImpl.setObjectiveSetByContent(lfSequencingTracking.isObjectiveSetByContent());

        return lfSequencingTrackingImpl;
    }

    /**
     * Returns the l f sequencing tracking with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f sequencing tracking
     * @return the l f sequencing tracking
     * @throws com.liferay.portal.NoSuchModelException if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSequencingTracking findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f sequencing tracking with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException} if it could not be found.
     *
     * @param id the primary key of the l f sequencing tracking
     * @return the l f sequencing tracking
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking findByPrimaryKey(long id)
        throws NoSuchLFSequencingTrackingException, SystemException {
        LFSequencingTracking lfSequencingTracking = fetchByPrimaryKey(id);

        if (lfSequencingTracking == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFSequencingTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfSequencingTracking;
    }

    /**
     * Returns the l f sequencing tracking with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f sequencing tracking
     * @return the l f sequencing tracking, or <code>null</code> if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSequencingTracking fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f sequencing tracking with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f sequencing tracking
     * @return the l f sequencing tracking, or <code>null</code> if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking fetchByPrimaryKey(long id)
        throws SystemException {
        LFSequencingTracking lfSequencingTracking = (LFSequencingTracking) EntityCacheUtil.getResult(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
                LFSequencingTrackingImpl.class, id);

        if (lfSequencingTracking == _nullLFSequencingTracking) {
            return null;
        }

        if (lfSequencingTracking == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfSequencingTracking = (LFSequencingTracking) session.get(LFSequencingTrackingImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfSequencingTracking != null) {
                    cacheResult(lfSequencingTracking);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFSequencingTrackingModelImpl.ENTITY_CACHE_ENABLED,
                        LFSequencingTrackingImpl.class, id,
                        _nullLFSequencingTracking);
                }

                closeSession(session);
            }
        }

        return lfSequencingTracking;
    }

    /**
     * Returns all the l f sequencing trackings where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencingTracking> findBySequencingID(Integer sequencingID)
        throws SystemException {
        return findBySequencingID(sequencingID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f sequencing trackings where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f sequencing trackings
     * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
     * @return the range of matching l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencingTracking> findBySequencingID(Integer sequencingID,
        int start, int end) throws SystemException {
        return findBySequencingID(sequencingID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f sequencing trackings where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f sequencing trackings
     * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencingTracking> findBySequencingID(Integer sequencingID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] { sequencingID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] {
                    sequencingID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFSequencingTracking> list = (List<LFSequencingTracking>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSequencingTracking lfSequencingTracking : list) {
                if (!Validator.equals(sequencingID,
                            lfSequencingTracking.getSequencingID())) {
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

            query.append(_SQL_SELECT_LFSEQUENCINGTRACKING_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                list = (List<LFSequencingTracking>) QueryUtil.list(q,
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
     * Returns the first l f sequencing tracking in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f sequencing tracking
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a matching l f sequencing tracking could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking findBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSequencingTrackingException, SystemException {
        LFSequencingTracking lfSequencingTracking = fetchBySequencingID_First(sequencingID,
                orderByComparator);

        if (lfSequencingTracking != null) {
            return lfSequencingTracking;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSequencingTrackingException(msg.toString());
    }

    /**
     * Returns the first l f sequencing tracking in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f sequencing tracking, or <code>null</code> if a matching l f sequencing tracking could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking fetchBySequencingID_First(
        Integer sequencingID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFSequencingTracking> list = findBySequencingID(sequencingID, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f sequencing tracking in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f sequencing tracking
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a matching l f sequencing tracking could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking findBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSequencingTrackingException, SystemException {
        LFSequencingTracking lfSequencingTracking = fetchBySequencingID_Last(sequencingID,
                orderByComparator);

        if (lfSequencingTracking != null) {
            return lfSequencingTracking;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSequencingTrackingException(msg.toString());
    }

    /**
     * Returns the last l f sequencing tracking in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f sequencing tracking, or <code>null</code> if a matching l f sequencing tracking could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking fetchBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingID(sequencingID);

        List<LFSequencingTracking> list = findBySequencingID(sequencingID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f sequencing trackings before and after the current l f sequencing tracking in the ordered set where sequencingID = &#63;.
     *
     * @param id the primary key of the current l f sequencing tracking
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f sequencing tracking
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFSequencingTracking[] findBySequencingID_PrevAndNext(long id,
        Integer sequencingID, OrderByComparator orderByComparator)
        throws NoSuchLFSequencingTrackingException, SystemException {
        LFSequencingTracking lfSequencingTracking = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSequencingTracking[] array = new LFSequencingTrackingImpl[3];

            array[0] = getBySequencingID_PrevAndNext(session,
                    lfSequencingTracking, sequencingID, orderByComparator, true);

            array[1] = lfSequencingTracking;

            array[2] = getBySequencingID_PrevAndNext(session,
                    lfSequencingTracking, sequencingID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSequencingTracking getBySequencingID_PrevAndNext(
        Session session, LFSequencingTracking lfSequencingTracking,
        Integer sequencingID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSEQUENCINGTRACKING_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfSequencingTracking);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSequencingTracking> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f sequencing trackings.
     *
     * @return the l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencingTracking> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f sequencing trackings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f sequencing trackings
     * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
     * @return the range of l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencingTracking> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f sequencing trackings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f sequencing trackings
     * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public List<LFSequencingTracking> findAll(int start, int end,
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

        List<LFSequencingTracking> list = (List<LFSequencingTracking>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSEQUENCINGTRACKING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSEQUENCINGTRACKING;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFSequencingTracking>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFSequencingTracking>) QueryUtil.list(q,
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
     * Removes all the l f sequencing trackings where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @throws SystemException if a system exception occurred
     */
    public void removeBySequencingID(Integer sequencingID)
        throws SystemException {
        for (LFSequencingTracking lfSequencingTracking : findBySequencingID(
                sequencingID)) {
            remove(lfSequencingTracking);
        }
    }

    /**
     * Removes all the l f sequencing trackings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFSequencingTracking lfSequencingTracking : findAll()) {
            remove(lfSequencingTracking);
        }
    }

    /**
     * Returns the number of l f sequencing trackings where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSEQUENCINGTRACKING_WHERE);

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
     * Returns the number of l f sequencing trackings.
     *
     * @return the number of l f sequencing trackings
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFSEQUENCINGTRACKING);

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
     * Initializes the l f sequencing tracking persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSequencingTracking")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSequencingTracking>> listenersList = new ArrayList<ModelListener<LFSequencingTracking>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSequencingTracking>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSequencingTrackingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

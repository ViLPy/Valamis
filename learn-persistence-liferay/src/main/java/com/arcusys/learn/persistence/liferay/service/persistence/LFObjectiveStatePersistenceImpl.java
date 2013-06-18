package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveStateImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveStateModelImpl;
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
 * The persistence implementation for the l f objective state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveStatePersistence
 * @see LFObjectiveStateUtil
 * @generated
 */
public class LFObjectiveStatePersistenceImpl extends BasePersistenceImpl<LFObjectiveState>
    implements LFObjectiveStatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFObjectiveStateUtil} to access the l f objective state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFObjectiveStateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID =
        new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveStateImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByMapKeyAndActivityStateID",
            new String[] { String.class.getName(), Integer.class.getName() },
            LFObjectiveStateModelImpl.MAPKEY_COLUMN_BITMASK |
            LFObjectiveStateModelImpl.ACTIVITYSTATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_MAPKEYANDACTIVITYSTATEID =
        new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByMapKeyAndActivityStateID",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATEID =
        new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByActivityStateID",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATEID =
        new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityStateID",
            new String[] { Integer.class.getName() },
            LFObjectiveStateModelImpl.ACTIVITYSTATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYSTATEID = new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByActivityStateID", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveStateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFOBJECTIVESTATE = "SELECT lfObjectiveState FROM LFObjectiveState lfObjectiveState";
    private static final String _SQL_SELECT_LFOBJECTIVESTATE_WHERE = "SELECT lfObjectiveState FROM LFObjectiveState lfObjectiveState WHERE ";
    private static final String _SQL_COUNT_LFOBJECTIVESTATE = "SELECT COUNT(lfObjectiveState) FROM LFObjectiveState lfObjectiveState";
    private static final String _SQL_COUNT_LFOBJECTIVESTATE_WHERE = "SELECT COUNT(lfObjectiveState) FROM LFObjectiveState lfObjectiveState WHERE ";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_1 =
        "lfObjectiveState.mapKey IS NULL AND ";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_NULL =
        "lfObjectiveState.mapKey IS NULL";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_NULL_2 =
        "lfObjectiveState.mapKey IS NULL  AND ";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_2 =
        "lfObjectiveState.mapKey = ? AND ";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_3 =
        "(lfObjectiveState.mapKey IS NULL OR lfObjectiveState.mapKey = ?) AND ";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_NULL =
        "lfObjectiveState.activityStateID IS NULL";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2 =
        "lfObjectiveState.activityStateID IS NULL ";
    private static final String _FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_2 =
        "lfObjectiveState.activityStateID = ?";
    private static final String _FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_NULL =
        "lfObjectiveState.activityStateID IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2 =
        "lfObjectiveState.activityStateID IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_2 =
        "lfObjectiveState.activityStateID = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfObjectiveState.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFObjectiveState exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFObjectiveState exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFObjectiveStatePersistenceImpl.class);
    private static LFObjectiveState _nullLFObjectiveState = new LFObjectiveStateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFObjectiveState> toCacheModel() {
                return _nullLFObjectiveStateCacheModel;
            }
        };

    private static CacheModel<LFObjectiveState> _nullLFObjectiveStateCacheModel = new CacheModel<LFObjectiveState>() {
            public LFObjectiveState toEntityModel() {
                return _nullLFObjectiveState;
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
     * Caches the l f objective state in the entity cache if it is enabled.
     *
     * @param lfObjectiveState the l f objective state
     */
    public void cacheResult(LFObjectiveState lfObjectiveState) {
        EntityCacheUtil.putResult(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateImpl.class, lfObjectiveState.getPrimaryKey(),
            lfObjectiveState);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
            new Object[] {
                lfObjectiveState.getMapKey(),
                Integer.valueOf(lfObjectiveState.getActivityStateID())
            }, lfObjectiveState);

        lfObjectiveState.resetOriginalValues();
    }

    /**
     * Caches the l f objective states in the entity cache if it is enabled.
     *
     * @param lfObjectiveStates the l f objective states
     */
    public void cacheResult(List<LFObjectiveState> lfObjectiveStates) {
        for (LFObjectiveState lfObjectiveState : lfObjectiveStates) {
            if (EntityCacheUtil.getResult(
                        LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveStateImpl.class,
                        lfObjectiveState.getPrimaryKey()) == null) {
                cacheResult(lfObjectiveState);
            } else {
                lfObjectiveState.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f objective states.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFObjectiveStateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFObjectiveStateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f objective state.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFObjectiveState lfObjectiveState) {
        EntityCacheUtil.removeResult(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateImpl.class, lfObjectiveState.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfObjectiveState);
    }

    @Override
    public void clearCache(List<LFObjectiveState> lfObjectiveStates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFObjectiveState lfObjectiveState : lfObjectiveStates) {
            EntityCacheUtil.removeResult(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveStateImpl.class, lfObjectiveState.getPrimaryKey());

            clearUniqueFindersCache(lfObjectiveState);
        }
    }

    protected void clearUniqueFindersCache(LFObjectiveState lfObjectiveState) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
            new Object[] {
                lfObjectiveState.getMapKey(),
                Integer.valueOf(lfObjectiveState.getActivityStateID())
            });
    }

    /**
     * Creates a new l f objective state with the primary key. Does not add the l f objective state to the database.
     *
     * @param id the primary key for the new l f objective state
     * @return the new l f objective state
     */
    public LFObjectiveState create(long id) {
        LFObjectiveState lfObjectiveState = new LFObjectiveStateImpl();

        lfObjectiveState.setNew(true);
        lfObjectiveState.setPrimaryKey(id);

        return lfObjectiveState;
    }

    /**
     * Removes the l f objective state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f objective state
     * @return the l f objective state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState remove(long id)
        throws NoSuchLFObjectiveStateException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the l f objective state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f objective state
     * @return the l f objective state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveState remove(Serializable primaryKey)
        throws NoSuchLFObjectiveStateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFObjectiveState lfObjectiveState = (LFObjectiveState) session.get(LFObjectiveStateImpl.class,
                    primaryKey);

            if (lfObjectiveState == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFObjectiveStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfObjectiveState);
        } catch (NoSuchLFObjectiveStateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFObjectiveState removeImpl(LFObjectiveState lfObjectiveState)
        throws SystemException {
        lfObjectiveState = toUnwrappedModel(lfObjectiveState);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, lfObjectiveState);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(lfObjectiveState);

        return lfObjectiveState;
    }

    @Override
    public LFObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveState lfObjectiveState,
        boolean merge) throws SystemException {
        lfObjectiveState = toUnwrappedModel(lfObjectiveState);

        boolean isNew = lfObjectiveState.isNew();

        LFObjectiveStateModelImpl lfObjectiveStateModelImpl = (LFObjectiveStateModelImpl) lfObjectiveState;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lfObjectiveState, merge);

            lfObjectiveState.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFObjectiveStateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfObjectiveStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        /* Integer.valueOf(   */
                        lfObjectiveStateModelImpl.getOriginalActivityStateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATEID,
                    args);

                args = new Object[] {
                        /* Integer.valueOf( */
                        lfObjectiveStateModelImpl.getActivityStateID()
                    /* ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveStateImpl.class, lfObjectiveState.getPrimaryKey(),
            lfObjectiveState);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                new Object[] {
                    lfObjectiveState.getMapKey(),
                    /*Integer.valueOf( */
                lfObjectiveState.getActivityStateID()
                /*) */
            }, lfObjectiveState);
        } else {
            if ((lfObjectiveStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfObjectiveStateModelImpl.getOriginalMapKey(),
                        /*        Integer.valueOf( */
                        lfObjectiveStateModelImpl.getOriginalActivityStateID()
                    /*        ) */
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MAPKEYANDACTIVITYSTATEID,
                    args);

                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                    args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                    new Object[] {
                        lfObjectiveState.getMapKey(),
                        /*        Integer.valueOf( */
                    lfObjectiveState.getActivityStateID()
                    /*        ) */
                }, lfObjectiveState);
            }
        }

        return lfObjectiveState;
    }

    protected LFObjectiveState toUnwrappedModel(
        LFObjectiveState lfObjectiveState) {
        if (lfObjectiveState instanceof LFObjectiveStateImpl) {
            return lfObjectiveState;
        }

        LFObjectiveStateImpl lfObjectiveStateImpl = new LFObjectiveStateImpl();

        lfObjectiveStateImpl.setNew(lfObjectiveState.isNew());
        lfObjectiveStateImpl.setPrimaryKey(lfObjectiveState.getPrimaryKey());

        lfObjectiveStateImpl.setId(lfObjectiveState.getId());
        lfObjectiveStateImpl.setSatisfied(lfObjectiveState.getSatisfied());
        lfObjectiveStateImpl.setNormalizedMeasure(lfObjectiveState.getNormalizedMeasure());
        lfObjectiveStateImpl.setMapKey(lfObjectiveState.getMapKey());
        lfObjectiveStateImpl.setActivityStateID(lfObjectiveState.getActivityStateID());
        lfObjectiveStateImpl.setObjectiveID(lfObjectiveState.getObjectiveID());

        return lfObjectiveStateImpl;
    }

    /**
     * Returns the l f objective state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective state
     * @return the l f objective state
     * @throws com.liferay.portal.NoSuchModelException if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveState findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException} if it could not be found.
     *
     * @param id the primary key of the l f objective state
     * @return the l f objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState findByPrimaryKey(long id)
        throws NoSuchLFObjectiveStateException, SystemException {
        LFObjectiveState lfObjectiveState = fetchByPrimaryKey(id);

        if (lfObjectiveState == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchLFObjectiveStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return lfObjectiveState;
    }

    /**
     * Returns the l f objective state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective state
     * @return the l f objective state, or <code>null</code> if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveState fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the l f objective state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f objective state
     * @return the l f objective state, or <code>null</code> if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState fetchByPrimaryKey(long id)
        throws SystemException {
        LFObjectiveState lfObjectiveState = (LFObjectiveState) EntityCacheUtil.getResult(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveStateImpl.class, id);

        if (lfObjectiveState == _nullLFObjectiveState) {
            return null;
        }

        if (lfObjectiveState == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                lfObjectiveState = (LFObjectiveState) session.get(LFObjectiveStateImpl.class,
                        Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (lfObjectiveState != null) {
                    cacheResult(lfObjectiveState);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LFObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveStateImpl.class, id, _nullLFObjectiveState);
                }

                closeSession(session);
            }
        }

        return lfObjectiveState;
    }

    /**
     * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException} if it could not be found.
     *
     * @param mapKey the map key
     * @param activityStateID the activity state i d
     * @return the matching l f objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState findByMapKeyAndActivityStateID(String mapKey,
        Integer activityStateID)
        throws NoSuchLFObjectiveStateException, SystemException {
        LFObjectiveState lfObjectiveState = fetchByMapKeyAndActivityStateID(mapKey,
                activityStateID);

        if (lfObjectiveState == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("mapKey=");
            msg.append(mapKey);

            msg.append(", activityStateID=");
            msg.append(activityStateID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFObjectiveStateException(msg.toString());
        }

        return lfObjectiveState;
    }

    /**
     * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param mapKey the map key
     * @param activityStateID the activity state i d
     * @return the matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState fetchByMapKeyAndActivityStateID(String mapKey,
        Integer activityStateID) throws SystemException {
        return fetchByMapKeyAndActivityStateID(mapKey, activityStateID, true);
    }

    /**
     * Returns the l f objective state where mapKey = &#63; and activityStateID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param mapKey the map key
     * @param activityStateID the activity state i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState fetchByMapKeyAndActivityStateID(String mapKey,
        Integer activityStateID, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { mapKey, activityStateID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                    finderArgs, this);
        }

        if (result instanceof LFObjectiveState) {
            LFObjectiveState lfObjectiveState = (LFObjectiveState) result;

            if (!Validator.equals(mapKey, lfObjectiveState.getMapKey()) ||
                    !Validator.equals(activityStateID,
                        lfObjectiveState.getActivityStateID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFOBJECTIVESTATE_WHERE);

            if (mapKey == null) {
                query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_1);
            } else {
                if (mapKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_2);
                }
            }

            if (activityStateID == null) {
                query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (mapKey != null) {
                    qPos.add(mapKey);
                }

                if (activityStateID != null) {
                    qPos.add(activityStateID.intValue());
                }

                List<LFObjectiveState> list = q.list();

                result = list;

                LFObjectiveState lfObjectiveState = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                        finderArgs, list);
                } else {
                    lfObjectiveState = list.get(0);

                    cacheResult(lfObjectiveState);

                    if ((lfObjectiveState.getMapKey() == null) ||
                            !lfObjectiveState.getMapKey().equals(mapKey) ||
                            (lfObjectiveState.getActivityStateID() != activityStateID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                            finderArgs, lfObjectiveState);
                    }
                }

                return lfObjectiveState;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MAPKEYANDACTIVITYSTATEID,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (LFObjectiveState) result;
            }
        }
    }

    /**
     * Returns all the l f objective states where activityStateID = &#63;.
     *
     * @param activityStateID the activity state i d
     * @return the matching l f objective states
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjectiveState> findByActivityStateID(Integer activityStateID)
        throws SystemException {
        return findByActivityStateID(activityStateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objective states where activityStateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateID the activity state i d
     * @param start the lower bound of the range of l f objective states
     * @param end the upper bound of the range of l f objective states (not inclusive)
     * @return the range of matching l f objective states
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjectiveState> findByActivityStateID(
        Integer activityStateID, int start, int end) throws SystemException {
        return findByActivityStateID(activityStateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objective states where activityStateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param activityStateID the activity state i d
     * @param start the lower bound of the range of l f objective states
     * @param end the upper bound of the range of l f objective states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f objective states
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjectiveState> findByActivityStateID(
        Integer activityStateID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYSTATEID;
            finderArgs = new Object[] { activityStateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYSTATEID;
            finderArgs = new Object[] {
                    activityStateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFObjectiveState> list = (List<LFObjectiveState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFObjectiveState lfObjectiveState : list) {
                if (!Validator.equals(activityStateID,
                            lfObjectiveState.getActivityStateID())) {
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

            query.append(_SQL_SELECT_LFOBJECTIVESTATE_WHERE);

            if (activityStateID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_2);
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

                if (activityStateID != null) {
                    qPos.add(activityStateID.intValue());
                }

                list = (List<LFObjectiveState>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f objective state in the ordered set where activityStateID = &#63;.
     *
     * @param activityStateID the activity state i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState findByActivityStateID_First(
        Integer activityStateID, OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveStateException, SystemException {
        LFObjectiveState lfObjectiveState = fetchByActivityStateID_First(activityStateID,
                orderByComparator);

        if (lfObjectiveState != null) {
            return lfObjectiveState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityStateID=");
        msg.append(activityStateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveStateException(msg.toString());
    }

    /**
     * Returns the first l f objective state in the ordered set where activityStateID = &#63;.
     *
     * @param activityStateID the activity state i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState fetchByActivityStateID_First(
        Integer activityStateID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFObjectiveState> list = findByActivityStateID(activityStateID, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f objective state in the ordered set where activityStateID = &#63;.
     *
     * @param activityStateID the activity state i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState findByActivityStateID_Last(
        Integer activityStateID, OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveStateException, SystemException {
        LFObjectiveState lfObjectiveState = fetchByActivityStateID_Last(activityStateID,
                orderByComparator);

        if (lfObjectiveState != null) {
            return lfObjectiveState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityStateID=");
        msg.append(activityStateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveStateException(msg.toString());
    }

    /**
     * Returns the last l f objective state in the ordered set where activityStateID = &#63;.
     *
     * @param activityStateID the activity state i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective state, or <code>null</code> if a matching l f objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState fetchByActivityStateID_Last(
        Integer activityStateID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByActivityStateID(activityStateID);

        List<LFObjectiveState> list = findByActivityStateID(activityStateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f objective states before and after the current l f objective state in the ordered set where activityStateID = &#63;.
     *
     * @param id the primary key of the current l f objective state
     * @param activityStateID the activity state i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException if a l f objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState[] findByActivityStateID_PrevAndNext(long id,
        Integer activityStateID, OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveStateException, SystemException {
        LFObjectiveState lfObjectiveState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFObjectiveState[] array = new LFObjectiveStateImpl[3];

            array[0] = getByActivityStateID_PrevAndNext(session,
                    lfObjectiveState, activityStateID, orderByComparator, true);

            array[1] = lfObjectiveState;

            array[2] = getByActivityStateID_PrevAndNext(session,
                    lfObjectiveState, activityStateID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFObjectiveState getByActivityStateID_PrevAndNext(
        Session session, LFObjectiveState lfObjectiveState,
        Integer activityStateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFOBJECTIVESTATE_WHERE);

        if (activityStateID == null) {
            query.append(_FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_2);
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

        if (activityStateID != null) {
            qPos.add(activityStateID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfObjectiveState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFObjectiveState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f objective states.
     *
     * @return the l f objective states
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjectiveState> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objective states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f objective states
     * @param end the upper bound of the range of l f objective states (not inclusive)
     * @return the range of l f objective states
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjectiveState> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objective states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of l f objective states
     * @param end the upper bound of the range of l f objective states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f objective states
     * @throws SystemException if a system exception occurred
     */
    public List<LFObjectiveState> findAll(int start, int end,
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

        List<LFObjectiveState> list = (List<LFObjectiveState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFOBJECTIVESTATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFOBJECTIVESTATE;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<LFObjectiveState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LFObjectiveState>) QueryUtil.list(q,
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
     * Removes the l f objective state where mapKey = &#63; and activityStateID = &#63; from the database.
     *
     * @param mapKey the map key
     * @param activityStateID the activity state i d
     * @return the l f objective state that was removed
     * @throws SystemException if a system exception occurred
     */
    public LFObjectiveState removeByMapKeyAndActivityStateID(String mapKey,
        Integer activityStateID)
        throws NoSuchLFObjectiveStateException, SystemException {
        LFObjectiveState lfObjectiveState = findByMapKeyAndActivityStateID(mapKey,
                activityStateID);

        return remove(lfObjectiveState);
    }

    /**
     * Removes all the l f objective states where activityStateID = &#63; from the database.
     *
     * @param activityStateID the activity state i d
     * @throws SystemException if a system exception occurred
     */
    public void removeByActivityStateID(Integer activityStateID)
        throws SystemException {
        for (LFObjectiveState lfObjectiveState : findByActivityStateID(
                activityStateID)) {
            remove(lfObjectiveState);
        }
    }

    /**
     * Removes all the l f objective states from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (LFObjectiveState lfObjectiveState : findAll()) {
            remove(lfObjectiveState);
        }
    }

    /**
     * Returns the number of l f objective states where mapKey = &#63; and activityStateID = &#63;.
     *
     * @param mapKey the map key
     * @param activityStateID the activity state i d
     * @return the number of matching l f objective states
     * @throws SystemException if a system exception occurred
     */
    public int countByMapKeyAndActivityStateID(String mapKey,
        Integer activityStateID) throws SystemException {
        Object[] finderArgs = new Object[] { mapKey, activityStateID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAPKEYANDACTIVITYSTATEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFOBJECTIVESTATE_WHERE);

            if (mapKey == null) {
                query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_1);
            } else {
                if (mapKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_MAPKEY_2);
                }
            }

            if (activityStateID == null) {
                query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_MAPKEYANDACTIVITYSTATEID_ACTIVITYSTATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (mapKey != null) {
                    qPos.add(mapKey);
                }

                if (activityStateID != null) {
                    qPos.add(activityStateID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAPKEYANDACTIVITYSTATEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f objective states where activityStateID = &#63;.
     *
     * @param activityStateID the activity state i d
     * @return the number of matching l f objective states
     * @throws SystemException if a system exception occurred
     */
    public int countByActivityStateID(Integer activityStateID)
        throws SystemException {
        Object[] finderArgs = new Object[] { activityStateID };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFOBJECTIVESTATE_WHERE);

            if (activityStateID == null) {
                query.append(_FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYSTATEID_ACTIVITYSTATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (activityStateID != null) {
                    qPos.add(activityStateID.intValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVITYSTATEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of l f objective states.
     *
     * @return the number of l f objective states
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFOBJECTIVESTATE);

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
     * Initializes the l f objective state persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFObjectiveState")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFObjectiveState>> listenersList = new ArrayList<ModelListener<LFObjectiveState>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFObjectiveState>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFObjectiveStateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

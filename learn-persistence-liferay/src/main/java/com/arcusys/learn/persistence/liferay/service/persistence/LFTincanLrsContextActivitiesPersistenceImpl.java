package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextActivitiesPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
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
            @Override
            public LFTincanLrsContextActivities toEntityModel() {
                return _nullLFTincanLrsContextActivities;
            }
        };

    public LFTincanLrsContextActivitiesPersistenceImpl() {
        setModelClass(LFTincanLrsContextActivities.class);
    }

    /**
     * Caches the l f tincan lrs context activities in the entity cache if it is enabled.
     *
     * @param lfTincanLrsContextActivities the l f tincan lrs context activities
     */
    @Override
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
    @Override
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
    @Override
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
    @Override
    public LFTincanLrsContextActivities remove(long id)
        throws NoSuchLFTincanLrsContextActivitiesException, SystemException {
        return remove((Serializable) id);
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

            if (!session.contains(lfTincanLrsContextActivities)) {
                lfTincanLrsContextActivities = (LFTincanLrsContextActivities) session.get(LFTincanLrsContextActivitiesImpl.class,
                        lfTincanLrsContextActivities.getPrimaryKeyObj());
            }

            if (lfTincanLrsContextActivities != null) {
                session.delete(lfTincanLrsContextActivities);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsContextActivities != null) {
            clearCache(lfTincanLrsContextActivities);
        }

        return lfTincanLrsContextActivities;
    }

    @Override
    public LFTincanLrsContextActivities updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities)
        throws SystemException {
        lfTincanLrsContextActivities = toUnwrappedModel(lfTincanLrsContextActivities);

        boolean isNew = lfTincanLrsContextActivities.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsContextActivities.isNew()) {
                session.save(lfTincanLrsContextActivities);

                lfTincanLrsContextActivities.setNew(false);
            } else {
                session.merge(lfTincanLrsContextActivities);
            }
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
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContextActivities findByPrimaryKey(
        Serializable primaryKey)
        throws NoSuchLFTincanLrsContextActivitiesException, SystemException {
        LFTincanLrsContextActivities lfTincanLrsContextActivities = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsContextActivities == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsContextActivitiesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsContextActivities;
    }

    /**
     * Returns the l f tincan lrs context activities with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextActivitiesException if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContextActivities findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsContextActivitiesException, SystemException {
        return findByPrimaryKey((Serializable) id);
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
        LFTincanLrsContextActivities lfTincanLrsContextActivities = (LFTincanLrsContextActivities) EntityCacheUtil.getResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsContextActivitiesImpl.class, primaryKey);

        if (lfTincanLrsContextActivities == _nullLFTincanLrsContextActivities) {
            return null;
        }

        if (lfTincanLrsContextActivities == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsContextActivities = (LFTincanLrsContextActivities) session.get(LFTincanLrsContextActivitiesImpl.class,
                        primaryKey);

                if (lfTincanLrsContextActivities != null) {
                    cacheResult(lfTincanLrsContextActivities);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsContextActivitiesImpl.class, primaryKey,
                        _nullLFTincanLrsContextActivities);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsContextActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsContextActivitiesImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsContextActivities;
    }

    /**
     * Returns the l f tincan lrs context activities with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs context activities
     * @return the l f tincan lrs context activities, or <code>null</code> if a l f tincan lrs context activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContextActivities fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs context activitieses.
     *
     * @return the l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsContextActivities> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs context activitieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs context activitieses
     * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
     * @return the range of l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsContextActivities> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs context activitieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs context activitieses
     * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs context activitieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsContextActivities> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
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

                if (pagination) {
                    sql = sql.concat(LFTincanLrsContextActivitiesModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsContextActivities>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsContextActivities>(list);
                } else {
                    list = (List<LFTincanLrsContextActivities>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
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
    @Override
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
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSCONTEXTACTIVITIES);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
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
                            getClassLoader(), listenerClassName));
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
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

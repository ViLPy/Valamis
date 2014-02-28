package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanCtxActivitiesException;
import com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanCtxActivitiesPersistence;

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
 * The persistence implementation for the l f tincan ctx activities service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanCtxActivitiesPersistence
 * @see LFTincanCtxActivitiesUtil
 * @generated
 */
public class LFTincanCtxActivitiesPersistenceImpl extends BasePersistenceImpl<LFTincanCtxActivities>
    implements LFTincanCtxActivitiesPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanCtxActivitiesUtil} to access the l f tincan ctx activities persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanCtxActivitiesImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanCtxActivitiesModelImpl.FINDER_CACHE_ENABLED,
            LFTincanCtxActivitiesImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanCtxActivitiesModelImpl.FINDER_CACHE_ENABLED,
            LFTincanCtxActivitiesImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanCtxActivitiesModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANCTXACTIVITIES = "SELECT lfTincanCtxActivities FROM LFTincanCtxActivities lfTincanCtxActivities";
    private static final String _SQL_COUNT_LFTINCANCTXACTIVITIES = "SELECT COUNT(lfTincanCtxActivities) FROM LFTincanCtxActivities lfTincanCtxActivities";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanCtxActivities.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanCtxActivities exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanCtxActivitiesPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanCtxActivities _nullLFTincanCtxActivities = new LFTincanCtxActivitiesImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanCtxActivities> toCacheModel() {
                return _nullLFTincanCtxActivitiesCacheModel;
            }
        };

    private static CacheModel<LFTincanCtxActivities> _nullLFTincanCtxActivitiesCacheModel =
        new CacheModel<LFTincanCtxActivities>() {
            @Override
            public LFTincanCtxActivities toEntityModel() {
                return _nullLFTincanCtxActivities;
            }
        };

    public LFTincanCtxActivitiesPersistenceImpl() {
        setModelClass(LFTincanCtxActivities.class);
    }

    /**
     * Caches the l f tincan ctx activities in the entity cache if it is enabled.
     *
     * @param lfTincanCtxActivities the l f tincan ctx activities
     */
    @Override
    public void cacheResult(LFTincanCtxActivities lfTincanCtxActivities) {
        EntityCacheUtil.putResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanCtxActivitiesImpl.class,
            lfTincanCtxActivities.getPrimaryKey(), lfTincanCtxActivities);

        lfTincanCtxActivities.resetOriginalValues();
    }

    /**
     * Caches the l f tincan ctx activitieses in the entity cache if it is enabled.
     *
     * @param lfTincanCtxActivitieses the l f tincan ctx activitieses
     */
    @Override
    public void cacheResult(List<LFTincanCtxActivities> lfTincanCtxActivitieses) {
        for (LFTincanCtxActivities lfTincanCtxActivities : lfTincanCtxActivitieses) {
            if (EntityCacheUtil.getResult(
                        LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanCtxActivitiesImpl.class,
                        lfTincanCtxActivities.getPrimaryKey()) == null) {
                cacheResult(lfTincanCtxActivities);
            } else {
                lfTincanCtxActivities.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan ctx activitieses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanCtxActivitiesImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanCtxActivitiesImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan ctx activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanCtxActivities lfTincanCtxActivities) {
        EntityCacheUtil.removeResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanCtxActivitiesImpl.class,
            lfTincanCtxActivities.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFTincanCtxActivities> lfTincanCtxActivitieses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanCtxActivities lfTincanCtxActivities : lfTincanCtxActivitieses) {
            EntityCacheUtil.removeResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanCtxActivitiesImpl.class,
                lfTincanCtxActivities.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan ctx activities with the primary key. Does not add the l f tincan ctx activities to the database.
     *
     * @param id the primary key for the new l f tincan ctx activities
     * @return the new l f tincan ctx activities
     */
    @Override
    public LFTincanCtxActivities create(long id) {
        LFTincanCtxActivities lfTincanCtxActivities = new LFTincanCtxActivitiesImpl();

        lfTincanCtxActivities.setNew(true);
        lfTincanCtxActivities.setPrimaryKey(id);

        return lfTincanCtxActivities;
    }

    /**
     * Removes the l f tincan ctx activities with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan ctx activities
     * @return the l f tincan ctx activities that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanCtxActivitiesException if a l f tincan ctx activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanCtxActivities remove(long id)
        throws NoSuchLFTincanCtxActivitiesException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan ctx activities with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan ctx activities
     * @return the l f tincan ctx activities that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanCtxActivitiesException if a l f tincan ctx activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanCtxActivities remove(Serializable primaryKey)
        throws NoSuchLFTincanCtxActivitiesException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanCtxActivities lfTincanCtxActivities = (LFTincanCtxActivities) session.get(LFTincanCtxActivitiesImpl.class,
                    primaryKey);

            if (lfTincanCtxActivities == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanCtxActivitiesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanCtxActivities);
        } catch (NoSuchLFTincanCtxActivitiesException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanCtxActivities removeImpl(
        LFTincanCtxActivities lfTincanCtxActivities) throws SystemException {
        lfTincanCtxActivities = toUnwrappedModel(lfTincanCtxActivities);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanCtxActivities)) {
                lfTincanCtxActivities = (LFTincanCtxActivities) session.get(LFTincanCtxActivitiesImpl.class,
                        lfTincanCtxActivities.getPrimaryKeyObj());
            }

            if (lfTincanCtxActivities != null) {
                session.delete(lfTincanCtxActivities);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanCtxActivities != null) {
            clearCache(lfTincanCtxActivities);
        }

        return lfTincanCtxActivities;
    }

    @Override
    public LFTincanCtxActivities updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities lfTincanCtxActivities)
        throws SystemException {
        lfTincanCtxActivities = toUnwrappedModel(lfTincanCtxActivities);

        boolean isNew = lfTincanCtxActivities.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanCtxActivities.isNew()) {
                session.save(lfTincanCtxActivities);

                lfTincanCtxActivities.setNew(false);
            } else {
                session.merge(lfTincanCtxActivities);
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

        EntityCacheUtil.putResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanCtxActivitiesImpl.class,
            lfTincanCtxActivities.getPrimaryKey(), lfTincanCtxActivities);

        return lfTincanCtxActivities;
    }

    protected LFTincanCtxActivities toUnwrappedModel(
        LFTincanCtxActivities lfTincanCtxActivities) {
        if (lfTincanCtxActivities instanceof LFTincanCtxActivitiesImpl) {
            return lfTincanCtxActivities;
        }

        LFTincanCtxActivitiesImpl lfTincanCtxActivitiesImpl = new LFTincanCtxActivitiesImpl();

        lfTincanCtxActivitiesImpl.setNew(lfTincanCtxActivities.isNew());
        lfTincanCtxActivitiesImpl.setPrimaryKey(lfTincanCtxActivities.getPrimaryKey());

        lfTincanCtxActivitiesImpl.setId(lfTincanCtxActivities.getId());
        lfTincanCtxActivitiesImpl.setParent(lfTincanCtxActivities.getParent());
        lfTincanCtxActivitiesImpl.setGrouping(lfTincanCtxActivities.getGrouping());
        lfTincanCtxActivitiesImpl.setCategory(lfTincanCtxActivities.getCategory());
        lfTincanCtxActivitiesImpl.setOther(lfTincanCtxActivities.getOther());

        return lfTincanCtxActivitiesImpl;
    }

    /**
     * Returns the l f tincan ctx activities with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan ctx activities
     * @return the l f tincan ctx activities
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanCtxActivitiesException if a l f tincan ctx activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanCtxActivities findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanCtxActivitiesException, SystemException {
        LFTincanCtxActivities lfTincanCtxActivities = fetchByPrimaryKey(primaryKey);

        if (lfTincanCtxActivities == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanCtxActivitiesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanCtxActivities;
    }

    /**
     * Returns the l f tincan ctx activities with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanCtxActivitiesException} if it could not be found.
     *
     * @param id the primary key of the l f tincan ctx activities
     * @return the l f tincan ctx activities
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanCtxActivitiesException if a l f tincan ctx activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanCtxActivities findByPrimaryKey(long id)
        throws NoSuchLFTincanCtxActivitiesException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan ctx activities with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan ctx activities
     * @return the l f tincan ctx activities, or <code>null</code> if a l f tincan ctx activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanCtxActivities fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanCtxActivities lfTincanCtxActivities = (LFTincanCtxActivities) EntityCacheUtil.getResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanCtxActivitiesImpl.class, primaryKey);

        if (lfTincanCtxActivities == _nullLFTincanCtxActivities) {
            return null;
        }

        if (lfTincanCtxActivities == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanCtxActivities = (LFTincanCtxActivities) session.get(LFTincanCtxActivitiesImpl.class,
                        primaryKey);

                if (lfTincanCtxActivities != null) {
                    cacheResult(lfTincanCtxActivities);
                } else {
                    EntityCacheUtil.putResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanCtxActivitiesImpl.class, primaryKey,
                        _nullLFTincanCtxActivities);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanCtxActivitiesModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanCtxActivitiesImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanCtxActivities;
    }

    /**
     * Returns the l f tincan ctx activities with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan ctx activities
     * @return the l f tincan ctx activities, or <code>null</code> if a l f tincan ctx activities with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanCtxActivities fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan ctx activitieses.
     *
     * @return the l f tincan ctx activitieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanCtxActivities> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan ctx activitieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan ctx activitieses
     * @param end the upper bound of the range of l f tincan ctx activitieses (not inclusive)
     * @return the range of l f tincan ctx activitieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanCtxActivities> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan ctx activitieses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan ctx activitieses
     * @param end the upper bound of the range of l f tincan ctx activitieses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan ctx activitieses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanCtxActivities> findAll(int start, int end,
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

        List<LFTincanCtxActivities> list = (List<LFTincanCtxActivities>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANCTXACTIVITIES);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANCTXACTIVITIES;

                if (pagination) {
                    sql = sql.concat(LFTincanCtxActivitiesModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanCtxActivities>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanCtxActivities>(list);
                } else {
                    list = (List<LFTincanCtxActivities>) QueryUtil.list(q,
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
     * Removes all the l f tincan ctx activitieses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanCtxActivities lfTincanCtxActivities : findAll()) {
            remove(lfTincanCtxActivities);
        }
    }

    /**
     * Returns the number of l f tincan ctx activitieses.
     *
     * @return the number of l f tincan ctx activitieses
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANCTXACTIVITIES);

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
     * Initializes the l f tincan ctx activities persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanCtxActivities>> listenersList = new ArrayList<ModelListener<LFTincanCtxActivities>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanCtxActivities>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanCtxActivitiesImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

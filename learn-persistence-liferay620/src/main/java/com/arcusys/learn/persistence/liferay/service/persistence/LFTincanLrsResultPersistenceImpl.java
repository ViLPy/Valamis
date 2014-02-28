package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsResultPersistence;

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
 * The persistence implementation for the l f tincan lrs result service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsResultPersistence
 * @see LFTincanLrsResultUtil
 * @generated
 */
public class LFTincanLrsResultPersistenceImpl extends BasePersistenceImpl<LFTincanLrsResult>
    implements LFTincanLrsResultPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsResultUtil} to access the l f tincan lrs result persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsResultImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsResultModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsResultImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsResultModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsResultImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsResultModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSRESULT = "SELECT lfTincanLrsResult FROM LFTincanLrsResult lfTincanLrsResult";
    private static final String _SQL_COUNT_LFTINCANLRSRESULT = "SELECT COUNT(lfTincanLrsResult) FROM LFTincanLrsResult lfTincanLrsResult";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsResult.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsResult exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsResultPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanLrsResult _nullLFTincanLrsResult = new LFTincanLrsResultImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsResult> toCacheModel() {
                return _nullLFTincanLrsResultCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsResult> _nullLFTincanLrsResultCacheModel =
        new CacheModel<LFTincanLrsResult>() {
            @Override
            public LFTincanLrsResult toEntityModel() {
                return _nullLFTincanLrsResult;
            }
        };

    public LFTincanLrsResultPersistenceImpl() {
        setModelClass(LFTincanLrsResult.class);
    }

    /**
     * Caches the l f tincan lrs result in the entity cache if it is enabled.
     *
     * @param lfTincanLrsResult the l f tincan lrs result
     */
    @Override
    public void cacheResult(LFTincanLrsResult lfTincanLrsResult) {
        EntityCacheUtil.putResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsResultImpl.class, lfTincanLrsResult.getPrimaryKey(),
            lfTincanLrsResult);

        lfTincanLrsResult.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs results in the entity cache if it is enabled.
     *
     * @param lfTincanLrsResults the l f tincan lrs results
     */
    @Override
    public void cacheResult(List<LFTincanLrsResult> lfTincanLrsResults) {
        for (LFTincanLrsResult lfTincanLrsResult : lfTincanLrsResults) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsResultImpl.class,
                        lfTincanLrsResult.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsResult);
            } else {
                lfTincanLrsResult.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs results.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsResultImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsResultImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs result.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsResult lfTincanLrsResult) {
        EntityCacheUtil.removeResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsResultImpl.class, lfTincanLrsResult.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFTincanLrsResult> lfTincanLrsResults) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsResult lfTincanLrsResult : lfTincanLrsResults) {
            EntityCacheUtil.removeResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsResultImpl.class, lfTincanLrsResult.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs result with the primary key. Does not add the l f tincan lrs result to the database.
     *
     * @param id the primary key for the new l f tincan lrs result
     * @return the new l f tincan lrs result
     */
    @Override
    public LFTincanLrsResult create(long id) {
        LFTincanLrsResult lfTincanLrsResult = new LFTincanLrsResultImpl();

        lfTincanLrsResult.setNew(true);
        lfTincanLrsResult.setPrimaryKey(id);

        return lfTincanLrsResult;
    }

    /**
     * Removes the l f tincan lrs result with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs result
     * @return the l f tincan lrs result that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException if a l f tincan lrs result with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsResult remove(long id)
        throws NoSuchLFTincanLrsResultException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan lrs result with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs result
     * @return the l f tincan lrs result that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException if a l f tincan lrs result with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsResult remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsResultException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsResult lfTincanLrsResult = (LFTincanLrsResult) session.get(LFTincanLrsResultImpl.class,
                    primaryKey);

            if (lfTincanLrsResult == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsResult);
        } catch (NoSuchLFTincanLrsResultException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsResult removeImpl(LFTincanLrsResult lfTincanLrsResult)
        throws SystemException {
        lfTincanLrsResult = toUnwrappedModel(lfTincanLrsResult);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanLrsResult)) {
                lfTincanLrsResult = (LFTincanLrsResult) session.get(LFTincanLrsResultImpl.class,
                        lfTincanLrsResult.getPrimaryKeyObj());
            }

            if (lfTincanLrsResult != null) {
                session.delete(lfTincanLrsResult);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsResult != null) {
            clearCache(lfTincanLrsResult);
        }

        return lfTincanLrsResult;
    }

    @Override
    public LFTincanLrsResult updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult)
        throws SystemException {
        lfTincanLrsResult = toUnwrappedModel(lfTincanLrsResult);

        boolean isNew = lfTincanLrsResult.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsResult.isNew()) {
                session.save(lfTincanLrsResult);

                lfTincanLrsResult.setNew(false);
            } else {
                session.merge(lfTincanLrsResult);
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

        EntityCacheUtil.putResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsResultImpl.class, lfTincanLrsResult.getPrimaryKey(),
            lfTincanLrsResult);

        return lfTincanLrsResult;
    }

    protected LFTincanLrsResult toUnwrappedModel(
        LFTincanLrsResult lfTincanLrsResult) {
        if (lfTincanLrsResult instanceof LFTincanLrsResultImpl) {
            return lfTincanLrsResult;
        }

        LFTincanLrsResultImpl lfTincanLrsResultImpl = new LFTincanLrsResultImpl();

        lfTincanLrsResultImpl.setNew(lfTincanLrsResult.isNew());
        lfTincanLrsResultImpl.setPrimaryKey(lfTincanLrsResult.getPrimaryKey());

        lfTincanLrsResultImpl.setId(lfTincanLrsResult.getId());
        lfTincanLrsResultImpl.setScore(lfTincanLrsResult.getScore());
        lfTincanLrsResultImpl.setSuccess(lfTincanLrsResult.getSuccess());
        lfTincanLrsResultImpl.setCompletion(lfTincanLrsResult.getCompletion());
        lfTincanLrsResultImpl.setResponse(lfTincanLrsResult.getResponse());
        lfTincanLrsResultImpl.setDuration(lfTincanLrsResult.getDuration());
        lfTincanLrsResultImpl.setExtension(lfTincanLrsResult.getExtension());

        return lfTincanLrsResultImpl;
    }

    /**
     * Returns the l f tincan lrs result with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs result
     * @return the l f tincan lrs result
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException if a l f tincan lrs result with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsResult findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanLrsResultException, SystemException {
        LFTincanLrsResult lfTincanLrsResult = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsResult == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsResultException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsResult;
    }

    /**
     * Returns the l f tincan lrs result with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs result
     * @return the l f tincan lrs result
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsResultException if a l f tincan lrs result with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsResult findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsResultException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan lrs result with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs result
     * @return the l f tincan lrs result, or <code>null</code> if a l f tincan lrs result with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsResult fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanLrsResult lfTincanLrsResult = (LFTincanLrsResult) EntityCacheUtil.getResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsResultImpl.class, primaryKey);

        if (lfTincanLrsResult == _nullLFTincanLrsResult) {
            return null;
        }

        if (lfTincanLrsResult == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsResult = (LFTincanLrsResult) session.get(LFTincanLrsResultImpl.class,
                        primaryKey);

                if (lfTincanLrsResult != null) {
                    cacheResult(lfTincanLrsResult);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsResultImpl.class, primaryKey,
                        _nullLFTincanLrsResult);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsResultModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsResultImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsResult;
    }

    /**
     * Returns the l f tincan lrs result with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs result
     * @return the l f tincan lrs result, or <code>null</code> if a l f tincan lrs result with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsResult fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs results.
     *
     * @return the l f tincan lrs results
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsResult> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs results.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs results
     * @param end the upper bound of the range of l f tincan lrs results (not inclusive)
     * @return the range of l f tincan lrs results
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsResult> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs results.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs results
     * @param end the upper bound of the range of l f tincan lrs results (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs results
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsResult> findAll(int start, int end,
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

        List<LFTincanLrsResult> list = (List<LFTincanLrsResult>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSRESULT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSRESULT;

                if (pagination) {
                    sql = sql.concat(LFTincanLrsResultModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsResult>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsResult>(list);
                } else {
                    list = (List<LFTincanLrsResult>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs results from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanLrsResult lfTincanLrsResult : findAll()) {
            remove(lfTincanLrsResult);
        }
    }

    /**
     * Returns the number of l f tincan lrs results.
     *
     * @return the number of l f tincan lrs results
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSRESULT);

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
     * Initializes the l f tincan lrs result persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsResult>> listenersList = new ArrayList<ModelListener<LFTincanLrsResult>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsResult>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsResultImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

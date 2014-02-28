package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsContextPersistence;

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
 * The persistence implementation for the l f tincan lrs context service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsContextPersistence
 * @see LFTincanLrsContextUtil
 * @generated
 */
public class LFTincanLrsContextPersistenceImpl extends BasePersistenceImpl<LFTincanLrsContext>
    implements LFTincanLrsContextPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsContextUtil} to access the l f tincan lrs context persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsContextImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsContextImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsContextImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSCONTEXT = "SELECT lfTincanLrsContext FROM LFTincanLrsContext lfTincanLrsContext";
    private static final String _SQL_COUNT_LFTINCANLRSCONTEXT = "SELECT COUNT(lfTincanLrsContext) FROM LFTincanLrsContext lfTincanLrsContext";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsContext.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsContext exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsContextPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanLrsContext _nullLFTincanLrsContext = new LFTincanLrsContextImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsContext> toCacheModel() {
                return _nullLFTincanLrsContextCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsContext> _nullLFTincanLrsContextCacheModel =
        new CacheModel<LFTincanLrsContext>() {
            @Override
            public LFTincanLrsContext toEntityModel() {
                return _nullLFTincanLrsContext;
            }
        };

    public LFTincanLrsContextPersistenceImpl() {
        setModelClass(LFTincanLrsContext.class);
    }

    /**
     * Caches the l f tincan lrs context in the entity cache if it is enabled.
     *
     * @param lfTincanLrsContext the l f tincan lrs context
     */
    @Override
    public void cacheResult(LFTincanLrsContext lfTincanLrsContext) {
        EntityCacheUtil.putResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextImpl.class, lfTincanLrsContext.getPrimaryKey(),
            lfTincanLrsContext);

        lfTincanLrsContext.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs contexts in the entity cache if it is enabled.
     *
     * @param lfTincanLrsContexts the l f tincan lrs contexts
     */
    @Override
    public void cacheResult(List<LFTincanLrsContext> lfTincanLrsContexts) {
        for (LFTincanLrsContext lfTincanLrsContext : lfTincanLrsContexts) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsContextImpl.class,
                        lfTincanLrsContext.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsContext);
            } else {
                lfTincanLrsContext.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs contexts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsContextImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsContextImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs context.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsContext lfTincanLrsContext) {
        EntityCacheUtil.removeResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextImpl.class, lfTincanLrsContext.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFTincanLrsContext> lfTincanLrsContexts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsContext lfTincanLrsContext : lfTincanLrsContexts) {
            EntityCacheUtil.removeResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsContextImpl.class, lfTincanLrsContext.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs context with the primary key. Does not add the l f tincan lrs context to the database.
     *
     * @param id the primary key for the new l f tincan lrs context
     * @return the new l f tincan lrs context
     */
    @Override
    public LFTincanLrsContext create(long id) {
        LFTincanLrsContext lfTincanLrsContext = new LFTincanLrsContextImpl();

        lfTincanLrsContext.setNew(true);
        lfTincanLrsContext.setPrimaryKey(id);

        return lfTincanLrsContext;
    }

    /**
     * Removes the l f tincan lrs context with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs context
     * @return the l f tincan lrs context that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException if a l f tincan lrs context with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContext remove(long id)
        throws NoSuchLFTincanLrsContextException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan lrs context with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs context
     * @return the l f tincan lrs context that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException if a l f tincan lrs context with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContext remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsContextException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsContext lfTincanLrsContext = (LFTincanLrsContext) session.get(LFTincanLrsContextImpl.class,
                    primaryKey);

            if (lfTincanLrsContext == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsContextException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsContext);
        } catch (NoSuchLFTincanLrsContextException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsContext removeImpl(
        LFTincanLrsContext lfTincanLrsContext) throws SystemException {
        lfTincanLrsContext = toUnwrappedModel(lfTincanLrsContext);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanLrsContext)) {
                lfTincanLrsContext = (LFTincanLrsContext) session.get(LFTincanLrsContextImpl.class,
                        lfTincanLrsContext.getPrimaryKeyObj());
            }

            if (lfTincanLrsContext != null) {
                session.delete(lfTincanLrsContext);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsContext != null) {
            clearCache(lfTincanLrsContext);
        }

        return lfTincanLrsContext;
    }

    @Override
    public LFTincanLrsContext updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext lfTincanLrsContext)
        throws SystemException {
        lfTincanLrsContext = toUnwrappedModel(lfTincanLrsContext);

        boolean isNew = lfTincanLrsContext.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsContext.isNew()) {
                session.save(lfTincanLrsContext);

                lfTincanLrsContext.setNew(false);
            } else {
                session.merge(lfTincanLrsContext);
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

        EntityCacheUtil.putResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsContextImpl.class, lfTincanLrsContext.getPrimaryKey(),
            lfTincanLrsContext);

        return lfTincanLrsContext;
    }

    protected LFTincanLrsContext toUnwrappedModel(
        LFTincanLrsContext lfTincanLrsContext) {
        if (lfTincanLrsContext instanceof LFTincanLrsContextImpl) {
            return lfTincanLrsContext;
        }

        LFTincanLrsContextImpl lfTincanLrsContextImpl = new LFTincanLrsContextImpl();

        lfTincanLrsContextImpl.setNew(lfTincanLrsContext.isNew());
        lfTincanLrsContextImpl.setPrimaryKey(lfTincanLrsContext.getPrimaryKey());

        lfTincanLrsContextImpl.setId(lfTincanLrsContext.getId());
        lfTincanLrsContextImpl.setRegistration(lfTincanLrsContext.getRegistration());
        lfTincanLrsContextImpl.setInstructorID(lfTincanLrsContext.getInstructorID());
        lfTincanLrsContextImpl.setTeamID(lfTincanLrsContext.getTeamID());
        lfTincanLrsContextImpl.setContextActivitiesID(lfTincanLrsContext.getContextActivitiesID());
        lfTincanLrsContextImpl.setRevision(lfTincanLrsContext.getRevision());
        lfTincanLrsContextImpl.setPlatform(lfTincanLrsContext.getPlatform());
        lfTincanLrsContextImpl.setLanguage(lfTincanLrsContext.getLanguage());
        lfTincanLrsContextImpl.setStatement(lfTincanLrsContext.getStatement());
        lfTincanLrsContextImpl.setExtensions(lfTincanLrsContext.getExtensions());

        return lfTincanLrsContextImpl;
    }

    /**
     * Returns the l f tincan lrs context with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs context
     * @return the l f tincan lrs context
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException if a l f tincan lrs context with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContext findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanLrsContextException, SystemException {
        LFTincanLrsContext lfTincanLrsContext = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsContext == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsContextException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsContext;
    }

    /**
     * Returns the l f tincan lrs context with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs context
     * @return the l f tincan lrs context
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsContextException if a l f tincan lrs context with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContext findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsContextException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan lrs context with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs context
     * @return the l f tincan lrs context, or <code>null</code> if a l f tincan lrs context with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContext fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanLrsContext lfTincanLrsContext = (LFTincanLrsContext) EntityCacheUtil.getResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsContextImpl.class, primaryKey);

        if (lfTincanLrsContext == _nullLFTincanLrsContext) {
            return null;
        }

        if (lfTincanLrsContext == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsContext = (LFTincanLrsContext) session.get(LFTincanLrsContextImpl.class,
                        primaryKey);

                if (lfTincanLrsContext != null) {
                    cacheResult(lfTincanLrsContext);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsContextImpl.class, primaryKey,
                        _nullLFTincanLrsContext);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsContextModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsContextImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsContext;
    }

    /**
     * Returns the l f tincan lrs context with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs context
     * @return the l f tincan lrs context, or <code>null</code> if a l f tincan lrs context with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsContext fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs contexts.
     *
     * @return the l f tincan lrs contexts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsContext> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs contexts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs contexts
     * @param end the upper bound of the range of l f tincan lrs contexts (not inclusive)
     * @return the range of l f tincan lrs contexts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsContext> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs contexts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsContextModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs contexts
     * @param end the upper bound of the range of l f tincan lrs contexts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs contexts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsContext> findAll(int start, int end,
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

        List<LFTincanLrsContext> list = (List<LFTincanLrsContext>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSCONTEXT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSCONTEXT;

                if (pagination) {
                    sql = sql.concat(LFTincanLrsContextModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsContext>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsContext>(list);
                } else {
                    list = (List<LFTincanLrsContext>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs contexts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanLrsContext lfTincanLrsContext : findAll()) {
            remove(lfTincanLrsContext);
        }
    }

    /**
     * Returns the number of l f tincan lrs contexts.
     *
     * @return the number of l f tincan lrs contexts
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSCONTEXT);

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
     * Initializes the l f tincan lrs context persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsContext>> listenersList = new ArrayList<ModelListener<LFTincanLrsContext>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsContext>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsContextImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

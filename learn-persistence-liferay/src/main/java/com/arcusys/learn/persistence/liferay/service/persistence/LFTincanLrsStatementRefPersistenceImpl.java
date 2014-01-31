package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementRefPersistence;

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
 * The persistence implementation for the l f tincan lrs statement ref service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementRefPersistence
 * @see LFTincanLrsStatementRefUtil
 * @generated
 */
public class LFTincanLrsStatementRefPersistenceImpl extends BasePersistenceImpl<LFTincanLrsStatementRef>
    implements LFTincanLrsStatementRefPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsStatementRefUtil} to access the l f tincan lrs statement ref persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsStatementRefImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementRefModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementRefImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementRefModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsStatementRefImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementRefModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSSTATEMENTREF = "SELECT lfTincanLrsStatementRef FROM LFTincanLrsStatementRef lfTincanLrsStatementRef";
    private static final String _SQL_COUNT_LFTINCANLRSSTATEMENTREF = "SELECT COUNT(lfTincanLrsStatementRef) FROM LFTincanLrsStatementRef lfTincanLrsStatementRef";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsStatementRef.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsStatementRef exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsStatementRefPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "uuid"
            });
    private static LFTincanLrsStatementRef _nullLFTincanLrsStatementRef = new LFTincanLrsStatementRefImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsStatementRef> toCacheModel() {
                return _nullLFTincanLrsStatementRefCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsStatementRef> _nullLFTincanLrsStatementRefCacheModel =
        new CacheModel<LFTincanLrsStatementRef>() {
            @Override
            public LFTincanLrsStatementRef toEntityModel() {
                return _nullLFTincanLrsStatementRef;
            }
        };

    public LFTincanLrsStatementRefPersistenceImpl() {
        setModelClass(LFTincanLrsStatementRef.class);
    }

    /**
     * Caches the l f tincan lrs statement ref in the entity cache if it is enabled.
     *
     * @param lfTincanLrsStatementRef the l f tincan lrs statement ref
     */
    @Override
    public void cacheResult(LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        EntityCacheUtil.putResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementRefImpl.class,
            lfTincanLrsStatementRef.getPrimaryKey(), lfTincanLrsStatementRef);

        lfTincanLrsStatementRef.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs statement refs in the entity cache if it is enabled.
     *
     * @param lfTincanLrsStatementRefs the l f tincan lrs statement refs
     */
    @Override
    public void cacheResult(
        List<LFTincanLrsStatementRef> lfTincanLrsStatementRefs) {
        for (LFTincanLrsStatementRef lfTincanLrsStatementRef : lfTincanLrsStatementRefs) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsStatementRefImpl.class,
                        lfTincanLrsStatementRef.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsStatementRef);
            } else {
                lfTincanLrsStatementRef.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs statement refs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsStatementRefImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsStatementRefImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs statement ref.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        EntityCacheUtil.removeResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementRefImpl.class,
            lfTincanLrsStatementRef.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<LFTincanLrsStatementRef> lfTincanLrsStatementRefs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsStatementRef lfTincanLrsStatementRef : lfTincanLrsStatementRefs) {
            EntityCacheUtil.removeResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsStatementRefImpl.class,
                lfTincanLrsStatementRef.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs statement ref with the primary key. Does not add the l f tincan lrs statement ref to the database.
     *
     * @param id the primary key for the new l f tincan lrs statement ref
     * @return the new l f tincan lrs statement ref
     */
    @Override
    public LFTincanLrsStatementRef create(long id) {
        LFTincanLrsStatementRef lfTincanLrsStatementRef = new LFTincanLrsStatementRefImpl();

        lfTincanLrsStatementRef.setNew(true);
        lfTincanLrsStatementRef.setPrimaryKey(id);

        return lfTincanLrsStatementRef;
    }

    /**
     * Removes the l f tincan lrs statement ref with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs statement ref
     * @return the l f tincan lrs statement ref that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException if a l f tincan lrs statement ref with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatementRef remove(long id)
        throws NoSuchLFTincanLrsStatementRefException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan lrs statement ref with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs statement ref
     * @return the l f tincan lrs statement ref that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException if a l f tincan lrs statement ref with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatementRef remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsStatementRefException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsStatementRef lfTincanLrsStatementRef = (LFTincanLrsStatementRef) session.get(LFTincanLrsStatementRefImpl.class,
                    primaryKey);

            if (lfTincanLrsStatementRef == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsStatementRefException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsStatementRef);
        } catch (NoSuchLFTincanLrsStatementRefException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsStatementRef removeImpl(
        LFTincanLrsStatementRef lfTincanLrsStatementRef)
        throws SystemException {
        lfTincanLrsStatementRef = toUnwrappedModel(lfTincanLrsStatementRef);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanLrsStatementRef)) {
                lfTincanLrsStatementRef = (LFTincanLrsStatementRef) session.get(LFTincanLrsStatementRefImpl.class,
                        lfTincanLrsStatementRef.getPrimaryKeyObj());
            }

            if (lfTincanLrsStatementRef != null) {
                session.delete(lfTincanLrsStatementRef);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsStatementRef != null) {
            clearCache(lfTincanLrsStatementRef);
        }

        return lfTincanLrsStatementRef;
    }

    @Override
    public LFTincanLrsStatementRef updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef lfTincanLrsStatementRef)
        throws SystemException {
        lfTincanLrsStatementRef = toUnwrappedModel(lfTincanLrsStatementRef);

        boolean isNew = lfTincanLrsStatementRef.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsStatementRef.isNew()) {
                session.save(lfTincanLrsStatementRef);

                lfTincanLrsStatementRef.setNew(false);
            } else {
                session.merge(lfTincanLrsStatementRef);
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

        EntityCacheUtil.putResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsStatementRefImpl.class,
            lfTincanLrsStatementRef.getPrimaryKey(), lfTincanLrsStatementRef);

        return lfTincanLrsStatementRef;
    }

    protected LFTincanLrsStatementRef toUnwrappedModel(
        LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        if (lfTincanLrsStatementRef instanceof LFTincanLrsStatementRefImpl) {
            return lfTincanLrsStatementRef;
        }

        LFTincanLrsStatementRefImpl lfTincanLrsStatementRefImpl = new LFTincanLrsStatementRefImpl();

        lfTincanLrsStatementRefImpl.setNew(lfTincanLrsStatementRef.isNew());
        lfTincanLrsStatementRefImpl.setPrimaryKey(lfTincanLrsStatementRef.getPrimaryKey());

        lfTincanLrsStatementRefImpl.setId(lfTincanLrsStatementRef.getId());
        lfTincanLrsStatementRefImpl.setUuid(lfTincanLrsStatementRef.getUuid());

        return lfTincanLrsStatementRefImpl;
    }

    /**
     * Returns the l f tincan lrs statement ref with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs statement ref
     * @return the l f tincan lrs statement ref
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException if a l f tincan lrs statement ref with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatementRef findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanLrsStatementRefException, SystemException {
        LFTincanLrsStatementRef lfTincanLrsStatementRef = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsStatementRef == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsStatementRefException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsStatementRef;
    }

    /**
     * Returns the l f tincan lrs statement ref with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs statement ref
     * @return the l f tincan lrs statement ref
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException if a l f tincan lrs statement ref with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatementRef findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsStatementRefException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan lrs statement ref with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs statement ref
     * @return the l f tincan lrs statement ref, or <code>null</code> if a l f tincan lrs statement ref with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatementRef fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanLrsStatementRef lfTincanLrsStatementRef = (LFTincanLrsStatementRef) EntityCacheUtil.getResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsStatementRefImpl.class, primaryKey);

        if (lfTincanLrsStatementRef == _nullLFTincanLrsStatementRef) {
            return null;
        }

        if (lfTincanLrsStatementRef == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsStatementRef = (LFTincanLrsStatementRef) session.get(LFTincanLrsStatementRefImpl.class,
                        primaryKey);

                if (lfTincanLrsStatementRef != null) {
                    cacheResult(lfTincanLrsStatementRef);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsStatementRefImpl.class, primaryKey,
                        _nullLFTincanLrsStatementRef);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsStatementRefModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsStatementRefImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsStatementRef;
    }

    /**
     * Returns the l f tincan lrs statement ref with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs statement ref
     * @return the l f tincan lrs statement ref, or <code>null</code> if a l f tincan lrs statement ref with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsStatementRef fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs statement refs.
     *
     * @return the l f tincan lrs statement refs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsStatementRef> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs statement refs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs statement refs
     * @param end the upper bound of the range of l f tincan lrs statement refs (not inclusive)
     * @return the range of l f tincan lrs statement refs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsStatementRef> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs statement refs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementRefModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs statement refs
     * @param end the upper bound of the range of l f tincan lrs statement refs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs statement refs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsStatementRef> findAll(int start, int end,
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

        List<LFTincanLrsStatementRef> list = (List<LFTincanLrsStatementRef>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSSTATEMENTREF);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSSTATEMENTREF;

                if (pagination) {
                    sql = sql.concat(LFTincanLrsStatementRefModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsStatementRef>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsStatementRef>(list);
                } else {
                    list = (List<LFTincanLrsStatementRef>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs statement refs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanLrsStatementRef lfTincanLrsStatementRef : findAll()) {
            remove(lfTincanLrsStatementRef);
        }
    }

    /**
     * Returns the number of l f tincan lrs statement refs.
     *
     * @return the number of l f tincan lrs statement refs
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSSTATEMENTREF);

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
     * Initializes the l f tincan lrs statement ref persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsStatementRef>> listenersList = new ArrayList<ModelListener<LFTincanLrsStatementRef>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsStatementRef>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsStatementRefImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

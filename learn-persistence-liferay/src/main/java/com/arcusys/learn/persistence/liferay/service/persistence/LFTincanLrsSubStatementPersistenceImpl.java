package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsSubStatementImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsSubStatementModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsSubStatementPersistence;

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
 * The persistence implementation for the l f tincan lrs sub statement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsSubStatementPersistence
 * @see LFTincanLrsSubStatementUtil
 * @generated
 */
public class LFTincanLrsSubStatementPersistenceImpl extends BasePersistenceImpl<LFTincanLrsSubStatement>
    implements LFTincanLrsSubStatementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanLrsSubStatementUtil} to access the l f tincan lrs sub statement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanLrsSubStatementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsSubStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsSubStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsSubStatementModelImpl.FINDER_CACHE_ENABLED,
            LFTincanLrsSubStatementImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsSubStatementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFTINCANLRSSUBSTATEMENT = "SELECT lfTincanLrsSubStatement FROM LFTincanLrsSubStatement lfTincanLrsSubStatement";
    private static final String _SQL_COUNT_LFTINCANLRSSUBSTATEMENT = "SELECT COUNT(lfTincanLrsSubStatement) FROM LFTincanLrsSubStatement lfTincanLrsSubStatement";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanLrsSubStatement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanLrsSubStatement exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanLrsSubStatementPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanLrsSubStatement _nullLFTincanLrsSubStatement = new LFTincanLrsSubStatementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanLrsSubStatement> toCacheModel() {
                return _nullLFTincanLrsSubStatementCacheModel;
            }
        };

    private static CacheModel<LFTincanLrsSubStatement> _nullLFTincanLrsSubStatementCacheModel =
        new CacheModel<LFTincanLrsSubStatement>() {
            @Override
            public LFTincanLrsSubStatement toEntityModel() {
                return _nullLFTincanLrsSubStatement;
            }
        };

    public LFTincanLrsSubStatementPersistenceImpl() {
        setModelClass(LFTincanLrsSubStatement.class);
    }

    /**
     * Caches the l f tincan lrs sub statement in the entity cache if it is enabled.
     *
     * @param lfTincanLrsSubStatement the l f tincan lrs sub statement
     */
    @Override
    public void cacheResult(LFTincanLrsSubStatement lfTincanLrsSubStatement) {
        EntityCacheUtil.putResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsSubStatementImpl.class,
            lfTincanLrsSubStatement.getPrimaryKey(), lfTincanLrsSubStatement);

        lfTincanLrsSubStatement.resetOriginalValues();
    }

    /**
     * Caches the l f tincan lrs sub statements in the entity cache if it is enabled.
     *
     * @param lfTincanLrsSubStatements the l f tincan lrs sub statements
     */
    @Override
    public void cacheResult(
        List<LFTincanLrsSubStatement> lfTincanLrsSubStatements) {
        for (LFTincanLrsSubStatement lfTincanLrsSubStatement : lfTincanLrsSubStatements) {
            if (EntityCacheUtil.getResult(
                        LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsSubStatementImpl.class,
                        lfTincanLrsSubStatement.getPrimaryKey()) == null) {
                cacheResult(lfTincanLrsSubStatement);
            } else {
                lfTincanLrsSubStatement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan lrs sub statements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanLrsSubStatementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanLrsSubStatementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan lrs sub statement.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanLrsSubStatement lfTincanLrsSubStatement) {
        EntityCacheUtil.removeResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsSubStatementImpl.class,
            lfTincanLrsSubStatement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(
        List<LFTincanLrsSubStatement> lfTincanLrsSubStatements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanLrsSubStatement lfTincanLrsSubStatement : lfTincanLrsSubStatements) {
            EntityCacheUtil.removeResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsSubStatementImpl.class,
                lfTincanLrsSubStatement.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f tincan lrs sub statement with the primary key. Does not add the l f tincan lrs sub statement to the database.
     *
     * @param id the primary key for the new l f tincan lrs sub statement
     * @return the new l f tincan lrs sub statement
     */
    @Override
    public LFTincanLrsSubStatement create(long id) {
        LFTincanLrsSubStatement lfTincanLrsSubStatement = new LFTincanLrsSubStatementImpl();

        lfTincanLrsSubStatement.setNew(true);
        lfTincanLrsSubStatement.setPrimaryKey(id);

        return lfTincanLrsSubStatement;
    }

    /**
     * Removes the l f tincan lrs sub statement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan lrs sub statement
     * @return the l f tincan lrs sub statement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException if a l f tincan lrs sub statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsSubStatement remove(long id)
        throws NoSuchLFTincanLrsSubStatementException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan lrs sub statement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan lrs sub statement
     * @return the l f tincan lrs sub statement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException if a l f tincan lrs sub statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsSubStatement remove(Serializable primaryKey)
        throws NoSuchLFTincanLrsSubStatementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanLrsSubStatement lfTincanLrsSubStatement = (LFTincanLrsSubStatement) session.get(LFTincanLrsSubStatementImpl.class,
                    primaryKey);

            if (lfTincanLrsSubStatement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanLrsSubStatementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanLrsSubStatement);
        } catch (NoSuchLFTincanLrsSubStatementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanLrsSubStatement removeImpl(
        LFTincanLrsSubStatement lfTincanLrsSubStatement)
        throws SystemException {
        lfTincanLrsSubStatement = toUnwrappedModel(lfTincanLrsSubStatement);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanLrsSubStatement)) {
                lfTincanLrsSubStatement = (LFTincanLrsSubStatement) session.get(LFTincanLrsSubStatementImpl.class,
                        lfTincanLrsSubStatement.getPrimaryKeyObj());
            }

            if (lfTincanLrsSubStatement != null) {
                session.delete(lfTincanLrsSubStatement);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanLrsSubStatement != null) {
            clearCache(lfTincanLrsSubStatement);
        }

        return lfTincanLrsSubStatement;
    }

    @Override
    public LFTincanLrsSubStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement)
        throws SystemException {
        lfTincanLrsSubStatement = toUnwrappedModel(lfTincanLrsSubStatement);

        boolean isNew = lfTincanLrsSubStatement.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfTincanLrsSubStatement.isNew()) {
                session.save(lfTincanLrsSubStatement);

                lfTincanLrsSubStatement.setNew(false);
            } else {
                session.merge(lfTincanLrsSubStatement);
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

        EntityCacheUtil.putResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanLrsSubStatementImpl.class,
            lfTincanLrsSubStatement.getPrimaryKey(), lfTincanLrsSubStatement);

        return lfTincanLrsSubStatement;
    }

    protected LFTincanLrsSubStatement toUnwrappedModel(
        LFTincanLrsSubStatement lfTincanLrsSubStatement) {
        if (lfTincanLrsSubStatement instanceof LFTincanLrsSubStatementImpl) {
            return lfTincanLrsSubStatement;
        }

        LFTincanLrsSubStatementImpl lfTincanLrsSubStatementImpl = new LFTincanLrsSubStatementImpl();

        lfTincanLrsSubStatementImpl.setNew(lfTincanLrsSubStatement.isNew());
        lfTincanLrsSubStatementImpl.setPrimaryKey(lfTincanLrsSubStatement.getPrimaryKey());

        lfTincanLrsSubStatementImpl.setId(lfTincanLrsSubStatement.getId());
        lfTincanLrsSubStatementImpl.setActorID(lfTincanLrsSubStatement.getActorID());
        lfTincanLrsSubStatementImpl.setVerbID(lfTincanLrsSubStatement.getVerbID());
        lfTincanLrsSubStatementImpl.setVerbDisplay(lfTincanLrsSubStatement.getVerbDisplay());
        lfTincanLrsSubStatementImpl.setObjType(lfTincanLrsSubStatement.getObjType());
        lfTincanLrsSubStatementImpl.setObjID(lfTincanLrsSubStatement.getObjID());

        return lfTincanLrsSubStatementImpl;
    }

    /**
     * Returns the l f tincan lrs sub statement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs sub statement
     * @return the l f tincan lrs sub statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException if a l f tincan lrs sub statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsSubStatement findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanLrsSubStatementException, SystemException {
        LFTincanLrsSubStatement lfTincanLrsSubStatement = fetchByPrimaryKey(primaryKey);

        if (lfTincanLrsSubStatement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanLrsSubStatementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanLrsSubStatement;
    }

    /**
     * Returns the l f tincan lrs sub statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException} if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs sub statement
     * @return the l f tincan lrs sub statement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException if a l f tincan lrs sub statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsSubStatement findByPrimaryKey(long id)
        throws NoSuchLFTincanLrsSubStatementException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan lrs sub statement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan lrs sub statement
     * @return the l f tincan lrs sub statement, or <code>null</code> if a l f tincan lrs sub statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsSubStatement fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanLrsSubStatement lfTincanLrsSubStatement = (LFTincanLrsSubStatement) EntityCacheUtil.getResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanLrsSubStatementImpl.class, primaryKey);

        if (lfTincanLrsSubStatement == _nullLFTincanLrsSubStatement) {
            return null;
        }

        if (lfTincanLrsSubStatement == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanLrsSubStatement = (LFTincanLrsSubStatement) session.get(LFTincanLrsSubStatementImpl.class,
                        primaryKey);

                if (lfTincanLrsSubStatement != null) {
                    cacheResult(lfTincanLrsSubStatement);
                } else {
                    EntityCacheUtil.putResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanLrsSubStatementImpl.class, primaryKey,
                        _nullLFTincanLrsSubStatement);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanLrsSubStatementModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanLrsSubStatementImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanLrsSubStatement;
    }

    /**
     * Returns the l f tincan lrs sub statement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan lrs sub statement
     * @return the l f tincan lrs sub statement, or <code>null</code> if a l f tincan lrs sub statement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanLrsSubStatement fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan lrs sub statements.
     *
     * @return the l f tincan lrs sub statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsSubStatement> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan lrs sub statements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsSubStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs sub statements
     * @param end the upper bound of the range of l f tincan lrs sub statements (not inclusive)
     * @return the range of l f tincan lrs sub statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsSubStatement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan lrs sub statements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsSubStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan lrs sub statements
     * @param end the upper bound of the range of l f tincan lrs sub statements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan lrs sub statements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanLrsSubStatement> findAll(int start, int end,
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

        List<LFTincanLrsSubStatement> list = (List<LFTincanLrsSubStatement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANLRSSUBSTATEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANLRSSUBSTATEMENT;

                if (pagination) {
                    sql = sql.concat(LFTincanLrsSubStatementModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanLrsSubStatement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanLrsSubStatement>(list);
                } else {
                    list = (List<LFTincanLrsSubStatement>) QueryUtil.list(q,
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
     * Removes all the l f tincan lrs sub statements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanLrsSubStatement lfTincanLrsSubStatement : findAll()) {
            remove(lfTincanLrsSubStatement);
        }
    }

    /**
     * Returns the number of l f tincan lrs sub statements.
     *
     * @return the number of l f tincan lrs sub statements
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANLRSSUBSTATEMENT);

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
     * Initializes the l f tincan lrs sub statement persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanLrsSubStatement>> listenersList = new ArrayList<ModelListener<LFTincanLrsSubStatement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanLrsSubStatement>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanLrsSubStatementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException;
import com.arcusys.learn.persistence.liferay.model.LFAchievement;
import com.arcusys.learn.persistence.liferay.model.impl.LFAchievementImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAchievementPersistence;

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
 * The persistence implementation for the l f achievement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementPersistence
 * @see LFAchievementUtil
 * @generated
 */
public class LFAchievementPersistenceImpl extends BasePersistenceImpl<LFAchievement>
    implements LFAchievementPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFAchievementUtil} to access the l f achievement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFAchievementImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFACHIEVEMENT = "SELECT lfAchievement FROM LFAchievement lfAchievement";
    private static final String _SQL_COUNT_LFACHIEVEMENT = "SELECT COUNT(lfAchievement) FROM LFAchievement lfAchievement";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfAchievement.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFAchievement exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFAchievementPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFAchievement _nullLFAchievement = new LFAchievementImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFAchievement> toCacheModel() {
                return _nullLFAchievementCacheModel;
            }
        };

    private static CacheModel<LFAchievement> _nullLFAchievementCacheModel = new CacheModel<LFAchievement>() {
            @Override
            public LFAchievement toEntityModel() {
                return _nullLFAchievement;
            }
        };

    public LFAchievementPersistenceImpl() {
        setModelClass(LFAchievement.class);
    }

    /**
     * Caches the l f achievement in the entity cache if it is enabled.
     *
     * @param lfAchievement the l f achievement
     */
    @Override
    public void cacheResult(LFAchievement lfAchievement) {
        EntityCacheUtil.putResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementImpl.class, lfAchievement.getPrimaryKey(),
            lfAchievement);

        lfAchievement.resetOriginalValues();
    }

    /**
     * Caches the l f achievements in the entity cache if it is enabled.
     *
     * @param lfAchievements the l f achievements
     */
    @Override
    public void cacheResult(List<LFAchievement> lfAchievements) {
        for (LFAchievement lfAchievement : lfAchievements) {
            if (EntityCacheUtil.getResult(
                        LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
                        LFAchievementImpl.class, lfAchievement.getPrimaryKey()) == null) {
                cacheResult(lfAchievement);
            } else {
                lfAchievement.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f achievements.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFAchievementImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFAchievementImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f achievement.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFAchievement lfAchievement) {
        EntityCacheUtil.removeResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementImpl.class, lfAchievement.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFAchievement> lfAchievements) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFAchievement lfAchievement : lfAchievements) {
            EntityCacheUtil.removeResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
                LFAchievementImpl.class, lfAchievement.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f achievement with the primary key. Does not add the l f achievement to the database.
     *
     * @param id the primary key for the new l f achievement
     * @return the new l f achievement
     */
    @Override
    public LFAchievement create(long id) {
        LFAchievement lfAchievement = new LFAchievementImpl();

        lfAchievement.setNew(true);
        lfAchievement.setPrimaryKey(id);

        return lfAchievement;
    }

    /**
     * Removes the l f achievement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f achievement
     * @return the l f achievement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException if a l f achievement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievement remove(long id)
        throws NoSuchLFAchievementException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f achievement with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f achievement
     * @return the l f achievement that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException if a l f achievement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievement remove(Serializable primaryKey)
        throws NoSuchLFAchievementException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFAchievement lfAchievement = (LFAchievement) session.get(LFAchievementImpl.class,
                    primaryKey);

            if (lfAchievement == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFAchievementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfAchievement);
        } catch (NoSuchLFAchievementException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFAchievement removeImpl(LFAchievement lfAchievement)
        throws SystemException {
        lfAchievement = toUnwrappedModel(lfAchievement);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfAchievement)) {
                lfAchievement = (LFAchievement) session.get(LFAchievementImpl.class,
                        lfAchievement.getPrimaryKeyObj());
            }

            if (lfAchievement != null) {
                session.delete(lfAchievement);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfAchievement != null) {
            clearCache(lfAchievement);
        }

        return lfAchievement;
    }

    @Override
    public LFAchievement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievement lfAchievement)
        throws SystemException {
        lfAchievement = toUnwrappedModel(lfAchievement);

        boolean isNew = lfAchievement.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfAchievement.isNew()) {
                session.save(lfAchievement);

                lfAchievement.setNew(false);
            } else {
                session.merge(lfAchievement);
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

        EntityCacheUtil.putResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementImpl.class, lfAchievement.getPrimaryKey(),
            lfAchievement);

        return lfAchievement;
    }

    protected LFAchievement toUnwrappedModel(LFAchievement lfAchievement) {
        if (lfAchievement instanceof LFAchievementImpl) {
            return lfAchievement;
        }

        LFAchievementImpl lfAchievementImpl = new LFAchievementImpl();

        lfAchievementImpl.setNew(lfAchievement.isNew());
        lfAchievementImpl.setPrimaryKey(lfAchievement.getPrimaryKey());

        lfAchievementImpl.setId(lfAchievement.getId());
        lfAchievementImpl.setTitle(lfAchievement.getTitle());
        lfAchievementImpl.setDescription(lfAchievement.getDescription());
        lfAchievementImpl.setLogo(lfAchievement.getLogo());
        lfAchievementImpl.setCreationDate(lfAchievement.getCreationDate());

        return lfAchievementImpl;
    }

    /**
     * Returns the l f achievement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f achievement
     * @return the l f achievement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException if a l f achievement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievement findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFAchievementException, SystemException {
        LFAchievement lfAchievement = fetchByPrimaryKey(primaryKey);

        if (lfAchievement == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFAchievementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfAchievement;
    }

    /**
     * Returns the l f achievement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException} if it could not be found.
     *
     * @param id the primary key of the l f achievement
     * @return the l f achievement
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException if a l f achievement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievement findByPrimaryKey(long id)
        throws NoSuchLFAchievementException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f achievement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f achievement
     * @return the l f achievement, or <code>null</code> if a l f achievement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievement fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFAchievement lfAchievement = (LFAchievement) EntityCacheUtil.getResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
                LFAchievementImpl.class, primaryKey);

        if (lfAchievement == _nullLFAchievement) {
            return null;
        }

        if (lfAchievement == null) {
            Session session = null;

            try {
                session = openSession();

                lfAchievement = (LFAchievement) session.get(LFAchievementImpl.class,
                        primaryKey);

                if (lfAchievement != null) {
                    cacheResult(lfAchievement);
                } else {
                    EntityCacheUtil.putResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
                        LFAchievementImpl.class, primaryKey, _nullLFAchievement);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFAchievementModelImpl.ENTITY_CACHE_ENABLED,
                    LFAchievementImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfAchievement;
    }

    /**
     * Returns the l f achievement with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f achievement
     * @return the l f achievement, or <code>null</code> if a l f achievement with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievement fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f achievements.
     *
     * @return the l f achievements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievement> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f achievements
     * @param end the upper bound of the range of l f achievements (not inclusive)
     * @return the range of l f achievements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievement> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievements.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f achievements
     * @param end the upper bound of the range of l f achievements (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f achievements
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievement> findAll(int start, int end,
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

        List<LFAchievement> list = (List<LFAchievement>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACHIEVEMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACHIEVEMENT;

                if (pagination) {
                    sql = sql.concat(LFAchievementModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFAchievement>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievement>(list);
                } else {
                    list = (List<LFAchievement>) QueryUtil.list(q,
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
     * Removes all the l f achievements from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFAchievement lfAchievement : findAll()) {
            remove(lfAchievement);
        }
    }

    /**
     * Returns the number of l f achievements.
     *
     * @return the number of l f achievements
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

                Query q = session.createQuery(_SQL_COUNT_LFACHIEVEMENT);

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
     * Initializes the l f achievement persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFAchievement")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFAchievement>> listenersList = new ArrayList<ModelListener<LFAchievement>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFAchievement>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFAchievementImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

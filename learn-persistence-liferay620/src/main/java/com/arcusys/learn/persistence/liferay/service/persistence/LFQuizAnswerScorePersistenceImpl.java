package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException;
import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizAnswerScorePersistence;

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

/**
 * The persistence implementation for the l f quiz answer score service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScorePersistence
 * @see LFQuizAnswerScoreUtil
 * @generated
 */
public class LFQuizAnswerScorePersistenceImpl extends BasePersistenceImpl<LFQuizAnswerScore>
    implements LFQuizAnswerScorePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuizAnswerScoreUtil} to access the l f quiz answer score persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuizAnswerScoreImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizAnswerScoreModelImpl.FINDER_CACHE_ENABLED,
            LFQuizAnswerScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizAnswerScoreModelImpl.FINDER_CACHE_ENABLED,
            LFQuizAnswerScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizAnswerScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFQUIZANSWERSCORE = "SELECT lfQuizAnswerScore FROM LFQuizAnswerScore lfQuizAnswerScore";
    private static final String _SQL_COUNT_LFQUIZANSWERSCORE = "SELECT COUNT(lfQuizAnswerScore) FROM LFQuizAnswerScore lfQuizAnswerScore";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuizAnswerScore.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuizAnswerScore exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuizAnswerScorePersistenceImpl.class);
    private static LFQuizAnswerScore _nullLFQuizAnswerScore = new LFQuizAnswerScoreImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuizAnswerScore> toCacheModel() {
                return _nullLFQuizAnswerScoreCacheModel;
            }
        };

    private static CacheModel<LFQuizAnswerScore> _nullLFQuizAnswerScoreCacheModel =
        new CacheModel<LFQuizAnswerScore>() {
            @Override
            public LFQuizAnswerScore toEntityModel() {
                return _nullLFQuizAnswerScore;
            }
        };

    public LFQuizAnswerScorePersistenceImpl() {
        setModelClass(LFQuizAnswerScore.class);
    }

    /**
     * Caches the l f quiz answer score in the entity cache if it is enabled.
     *
     * @param lfQuizAnswerScore the l f quiz answer score
     */
    @Override
    public void cacheResult(LFQuizAnswerScore lfQuizAnswerScore) {
        EntityCacheUtil.putResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizAnswerScoreImpl.class, lfQuizAnswerScore.getPrimaryKey(),
            lfQuizAnswerScore);

        lfQuizAnswerScore.resetOriginalValues();
    }

    /**
     * Caches the l f quiz answer scores in the entity cache if it is enabled.
     *
     * @param lfQuizAnswerScores the l f quiz answer scores
     */
    @Override
    public void cacheResult(List<LFQuizAnswerScore> lfQuizAnswerScores) {
        for (LFQuizAnswerScore lfQuizAnswerScore : lfQuizAnswerScores) {
            if (EntityCacheUtil.getResult(
                        LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizAnswerScoreImpl.class,
                        lfQuizAnswerScore.getPrimaryKey()) == null) {
                cacheResult(lfQuizAnswerScore);
            } else {
                lfQuizAnswerScore.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f quiz answer scores.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuizAnswerScoreImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuizAnswerScoreImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f quiz answer score.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuizAnswerScore lfQuizAnswerScore) {
        EntityCacheUtil.removeResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizAnswerScoreImpl.class, lfQuizAnswerScore.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuizAnswerScore> lfQuizAnswerScores) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuizAnswerScore lfQuizAnswerScore : lfQuizAnswerScores) {
            EntityCacheUtil.removeResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizAnswerScoreImpl.class, lfQuizAnswerScore.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f quiz answer score with the primary key. Does not add the l f quiz answer score to the database.
     *
     * @param answerId the primary key for the new l f quiz answer score
     * @return the new l f quiz answer score
     */
    @Override
    public LFQuizAnswerScore create(long answerId) {
        LFQuizAnswerScore lfQuizAnswerScore = new LFQuizAnswerScoreImpl();

        lfQuizAnswerScore.setNew(true);
        lfQuizAnswerScore.setPrimaryKey(answerId);

        return lfQuizAnswerScore;
    }

    /**
     * Removes the l f quiz answer score with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param answerId the primary key of the l f quiz answer score
     * @return the l f quiz answer score that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizAnswerScore remove(long answerId)
        throws NoSuchLFQuizAnswerScoreException, SystemException {
        return remove((Serializable) answerId);
    }

    /**
     * Removes the l f quiz answer score with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f quiz answer score
     * @return the l f quiz answer score that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizAnswerScore remove(Serializable primaryKey)
        throws NoSuchLFQuizAnswerScoreException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuizAnswerScore lfQuizAnswerScore = (LFQuizAnswerScore) session.get(LFQuizAnswerScoreImpl.class,
                    primaryKey);

            if (lfQuizAnswerScore == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuizAnswerScoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuizAnswerScore);
        } catch (NoSuchLFQuizAnswerScoreException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuizAnswerScore removeImpl(LFQuizAnswerScore lfQuizAnswerScore)
        throws SystemException {
        lfQuizAnswerScore = toUnwrappedModel(lfQuizAnswerScore);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfQuizAnswerScore)) {
                lfQuizAnswerScore = (LFQuizAnswerScore) session.get(LFQuizAnswerScoreImpl.class,
                        lfQuizAnswerScore.getPrimaryKeyObj());
            }

            if (lfQuizAnswerScore != null) {
                session.delete(lfQuizAnswerScore);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfQuizAnswerScore != null) {
            clearCache(lfQuizAnswerScore);
        }

        return lfQuizAnswerScore;
    }

    @Override
    public LFQuizAnswerScore updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws SystemException {
        lfQuizAnswerScore = toUnwrappedModel(lfQuizAnswerScore);

        boolean isNew = lfQuizAnswerScore.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfQuizAnswerScore.isNew()) {
                session.save(lfQuizAnswerScore);

                lfQuizAnswerScore.setNew(false);
            } else {
                session.merge(lfQuizAnswerScore);
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

        EntityCacheUtil.putResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizAnswerScoreImpl.class, lfQuizAnswerScore.getPrimaryKey(),
            lfQuizAnswerScore);

        return lfQuizAnswerScore;
    }

    protected LFQuizAnswerScore toUnwrappedModel(
        LFQuizAnswerScore lfQuizAnswerScore) {
        if (lfQuizAnswerScore instanceof LFQuizAnswerScoreImpl) {
            return lfQuizAnswerScore;
        }

        LFQuizAnswerScoreImpl lfQuizAnswerScoreImpl = new LFQuizAnswerScoreImpl();

        lfQuizAnswerScoreImpl.setNew(lfQuizAnswerScore.isNew());
        lfQuizAnswerScoreImpl.setPrimaryKey(lfQuizAnswerScore.getPrimaryKey());

        lfQuizAnswerScoreImpl.setAnswerId(lfQuizAnswerScore.getAnswerId());
        lfQuizAnswerScoreImpl.setScore(lfQuizAnswerScore.getScore());

        return lfQuizAnswerScoreImpl;
    }

    /**
     * Returns the l f quiz answer score with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz answer score
     * @return the l f quiz answer score
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizAnswerScore findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFQuizAnswerScoreException, SystemException {
        LFQuizAnswerScore lfQuizAnswerScore = fetchByPrimaryKey(primaryKey);

        if (lfQuizAnswerScore == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFQuizAnswerScoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfQuizAnswerScore;
    }

    /**
     * Returns the l f quiz answer score with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException} if it could not be found.
     *
     * @param answerId the primary key of the l f quiz answer score
     * @return the l f quiz answer score
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizAnswerScore findByPrimaryKey(long answerId)
        throws NoSuchLFQuizAnswerScoreException, SystemException {
        return findByPrimaryKey((Serializable) answerId);
    }

    /**
     * Returns the l f quiz answer score with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz answer score
     * @return the l f quiz answer score, or <code>null</code> if a l f quiz answer score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizAnswerScore fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFQuizAnswerScore lfQuizAnswerScore = (LFQuizAnswerScore) EntityCacheUtil.getResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizAnswerScoreImpl.class, primaryKey);

        if (lfQuizAnswerScore == _nullLFQuizAnswerScore) {
            return null;
        }

        if (lfQuizAnswerScore == null) {
            Session session = null;

            try {
                session = openSession();

                lfQuizAnswerScore = (LFQuizAnswerScore) session.get(LFQuizAnswerScoreImpl.class,
                        primaryKey);

                if (lfQuizAnswerScore != null) {
                    cacheResult(lfQuizAnswerScore);
                } else {
                    EntityCacheUtil.putResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizAnswerScoreImpl.class, primaryKey,
                        _nullLFQuizAnswerScore);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFQuizAnswerScoreModelImpl.ENTITY_CACHE_ENABLED,
                    LFQuizAnswerScoreImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfQuizAnswerScore;
    }

    /**
     * Returns the l f quiz answer score with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param answerId the primary key of the l f quiz answer score
     * @return the l f quiz answer score, or <code>null</code> if a l f quiz answer score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizAnswerScore fetchByPrimaryKey(long answerId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) answerId);
    }

    /**
     * Returns all the l f quiz answer scores.
     *
     * @return the l f quiz answer scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizAnswerScore> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz answer scores.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz answer scores
     * @param end the upper bound of the range of l f quiz answer scores (not inclusive)
     * @return the range of l f quiz answer scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizAnswerScore> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz answer scores.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz answer scores
     * @param end the upper bound of the range of l f quiz answer scores (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f quiz answer scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizAnswerScore> findAll(int start, int end,
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

        List<LFQuizAnswerScore> list = (List<LFQuizAnswerScore>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUIZANSWERSCORE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUIZANSWERSCORE;

                if (pagination) {
                    sql = sql.concat(LFQuizAnswerScoreModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFQuizAnswerScore>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizAnswerScore>(list);
                } else {
                    list = (List<LFQuizAnswerScore>) QueryUtil.list(q,
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
     * Removes all the l f quiz answer scores from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFQuizAnswerScore lfQuizAnswerScore : findAll()) {
            remove(lfQuizAnswerScore);
        }
    }

    /**
     * Returns the number of l f quiz answer scores.
     *
     * @return the number of l f quiz answer scores
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

                Query q = session.createQuery(_SQL_COUNT_LFQUIZANSWERSCORE);

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

    /**
     * Initializes the l f quiz answer score persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuizAnswerScore>> listenersList = new ArrayList<ModelListener<LFQuizAnswerScore>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuizAnswerScore>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuizAnswerScoreImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

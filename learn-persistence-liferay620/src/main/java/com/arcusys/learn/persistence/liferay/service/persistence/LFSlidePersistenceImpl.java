package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSlideException;
import com.arcusys.learn.persistence.liferay.model.LFSlide;
import com.arcusys.learn.persistence.liferay.model.impl.LFSlideImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSlideModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSlidePersistence;

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
 * The persistence implementation for the l f slide service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlidePersistence
 * @see LFSlideUtil
 * @generated
 */
public class LFSlidePersistenceImpl extends BasePersistenceImpl<LFSlide>
    implements LFSlidePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSlideUtil} to access the l f slide persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSlideImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideModelImpl.FINDER_CACHE_ENABLED, LFSlideImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideModelImpl.FINDER_CACHE_ENABLED, LFSlideImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFSLIDE = "SELECT lfSlide FROM LFSlide lfSlide";
    private static final String _SQL_COUNT_LFSLIDE = "SELECT COUNT(lfSlide) FROM LFSlide lfSlide";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSlide.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSlide exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSlidePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFSlide _nullLFSlide = new LFSlideImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSlide> toCacheModel() {
                return _nullLFSlideCacheModel;
            }
        };

    private static CacheModel<LFSlide> _nullLFSlideCacheModel = new CacheModel<LFSlide>() {
            @Override
            public LFSlide toEntityModel() {
                return _nullLFSlide;
            }
        };

    public LFSlidePersistenceImpl() {
        setModelClass(LFSlide.class);
    }

    /**
     * Caches the l f slide in the entity cache if it is enabled.
     *
     * @param lfSlide the l f slide
     */
    @Override
    public void cacheResult(LFSlide lfSlide) {
        EntityCacheUtil.putResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideImpl.class, lfSlide.getPrimaryKey(), lfSlide);

        lfSlide.resetOriginalValues();
    }

    /**
     * Caches the l f slides in the entity cache if it is enabled.
     *
     * @param lfSlides the l f slides
     */
    @Override
    public void cacheResult(List<LFSlide> lfSlides) {
        for (LFSlide lfSlide : lfSlides) {
            if (EntityCacheUtil.getResult(
                        LFSlideModelImpl.ENTITY_CACHE_ENABLED,
                        LFSlideImpl.class, lfSlide.getPrimaryKey()) == null) {
                cacheResult(lfSlide);
            } else {
                lfSlide.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f slides.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSlideImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSlideImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f slide.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSlide lfSlide) {
        EntityCacheUtil.removeResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideImpl.class, lfSlide.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFSlide> lfSlides) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSlide lfSlide : lfSlides) {
            EntityCacheUtil.removeResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
                LFSlideImpl.class, lfSlide.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f slide with the primary key. Does not add the l f slide to the database.
     *
     * @param id the primary key for the new l f slide
     * @return the new l f slide
     */
    @Override
    public LFSlide create(long id) {
        LFSlide lfSlide = new LFSlideImpl();

        lfSlide.setNew(true);
        lfSlide.setPrimaryKey(id);

        return lfSlide;
    }

    /**
     * Removes the l f slide with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f slide
     * @return the l f slide that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException if a l f slide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlide remove(long id)
        throws NoSuchLFSlideException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f slide with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f slide
     * @return the l f slide that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException if a l f slide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlide remove(Serializable primaryKey)
        throws NoSuchLFSlideException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSlide lfSlide = (LFSlide) session.get(LFSlideImpl.class,
                    primaryKey);

            if (lfSlide == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSlideException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSlide);
        } catch (NoSuchLFSlideException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSlide removeImpl(LFSlide lfSlide) throws SystemException {
        lfSlide = toUnwrappedModel(lfSlide);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfSlide)) {
                lfSlide = (LFSlide) session.get(LFSlideImpl.class,
                        lfSlide.getPrimaryKeyObj());
            }

            if (lfSlide != null) {
                session.delete(lfSlide);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfSlide != null) {
            clearCache(lfSlide);
        }

        return lfSlide;
    }

    @Override
    public LFSlide updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSlide lfSlide)
        throws SystemException {
        lfSlide = toUnwrappedModel(lfSlide);

        boolean isNew = lfSlide.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfSlide.isNew()) {
                session.save(lfSlide);

                lfSlide.setNew(false);
            } else {
                session.merge(lfSlide);
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

        EntityCacheUtil.putResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideImpl.class, lfSlide.getPrimaryKey(), lfSlide);

        return lfSlide;
    }

    protected LFSlide toUnwrappedModel(LFSlide lfSlide) {
        if (lfSlide instanceof LFSlideImpl) {
            return lfSlide;
        }

        LFSlideImpl lfSlideImpl = new LFSlideImpl();

        lfSlideImpl.setNew(lfSlide.isNew());
        lfSlideImpl.setPrimaryKey(lfSlide.getPrimaryKey());

        lfSlideImpl.setId(lfSlide.getId());
        lfSlideImpl.setBgcolor(lfSlide.getBgcolor());
        lfSlideImpl.setBgimage(lfSlide.getBgimage());
        lfSlideImpl.setTitle(lfSlide.getTitle());
        lfSlideImpl.setSlideSetId(lfSlide.getSlideSetId());
        lfSlideImpl.setTopSlideId(lfSlide.getTopSlideId());
        lfSlideImpl.setLeftSlideId(lfSlide.getLeftSlideId());
        lfSlideImpl.setStatementVerb(lfSlide.getStatementVerb());
        lfSlideImpl.setStatementObject(lfSlide.getStatementObject());
        lfSlideImpl.setStatementCategoryId(lfSlide.getStatementCategoryId());

        return lfSlideImpl;
    }

    /**
     * Returns the l f slide with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f slide
     * @return the l f slide
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException if a l f slide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlide findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFSlideException, SystemException {
        LFSlide lfSlide = fetchByPrimaryKey(primaryKey);

        if (lfSlide == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFSlideException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfSlide;
    }

    /**
     * Returns the l f slide with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSlideException} if it could not be found.
     *
     * @param id the primary key of the l f slide
     * @return the l f slide
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException if a l f slide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlide findByPrimaryKey(long id)
        throws NoSuchLFSlideException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f slide with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f slide
     * @return the l f slide, or <code>null</code> if a l f slide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlide fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFSlide lfSlide = (LFSlide) EntityCacheUtil.getResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
                LFSlideImpl.class, primaryKey);

        if (lfSlide == _nullLFSlide) {
            return null;
        }

        if (lfSlide == null) {
            Session session = null;

            try {
                session = openSession();

                lfSlide = (LFSlide) session.get(LFSlideImpl.class, primaryKey);

                if (lfSlide != null) {
                    cacheResult(lfSlide);
                } else {
                    EntityCacheUtil.putResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
                        LFSlideImpl.class, primaryKey, _nullLFSlide);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFSlideModelImpl.ENTITY_CACHE_ENABLED,
                    LFSlideImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfSlide;
    }

    /**
     * Returns the l f slide with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f slide
     * @return the l f slide, or <code>null</code> if a l f slide with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlide fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f slides.
     *
     * @return the l f slides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSlide> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f slides.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f slides
     * @param end the upper bound of the range of l f slides (not inclusive)
     * @return the range of l f slides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSlide> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f slides.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f slides
     * @param end the upper bound of the range of l f slides (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f slides
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSlide> findAll(int start, int end,
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

        List<LFSlide> list = (List<LFSlide>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSLIDE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSLIDE;

                if (pagination) {
                    sql = sql.concat(LFSlideModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFSlide>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSlide>(list);
                } else {
                    list = (List<LFSlide>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the l f slides from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFSlide lfSlide : findAll()) {
            remove(lfSlide);
        }
    }

    /**
     * Returns the number of l f slides.
     *
     * @return the number of l f slides
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

                Query q = session.createQuery(_SQL_COUNT_LFSLIDE);

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
     * Initializes the l f slide persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSlide")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSlide>> listenersList = new ArrayList<ModelListener<LFSlide>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSlide>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSlideImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

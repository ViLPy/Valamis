package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException;
import com.arcusys.learn.persistence.liferay.model.LFSlideEntity;
import com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSlideEntityPersistence;

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
 * The persistence implementation for the l f slide entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideEntityPersistence
 * @see LFSlideEntityUtil
 * @generated
 */
public class LFSlideEntityPersistenceImpl extends BasePersistenceImpl<LFSlideEntity>
    implements LFSlideEntityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSlideEntityUtil} to access the l f slide entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSlideEntityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideEntityModelImpl.FINDER_CACHE_ENABLED,
            LFSlideEntityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideEntityModelImpl.FINDER_CACHE_ENABLED,
            LFSlideEntityImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideEntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LFSLIDEENTITY = "SELECT lfSlideEntity FROM LFSlideEntity lfSlideEntity";
    private static final String _SQL_COUNT_LFSLIDEENTITY = "SELECT COUNT(lfSlideEntity) FROM LFSlideEntity lfSlideEntity";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSlideEntity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSlideEntity exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSlideEntityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "top", "left"
            });
    private static LFSlideEntity _nullLFSlideEntity = new LFSlideEntityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSlideEntity> toCacheModel() {
                return _nullLFSlideEntityCacheModel;
            }
        };

    private static CacheModel<LFSlideEntity> _nullLFSlideEntityCacheModel = new CacheModel<LFSlideEntity>() {
            @Override
            public LFSlideEntity toEntityModel() {
                return _nullLFSlideEntity;
            }
        };

    public LFSlideEntityPersistenceImpl() {
        setModelClass(LFSlideEntity.class);
    }

    /**
     * Caches the l f slide entity in the entity cache if it is enabled.
     *
     * @param lfSlideEntity the l f slide entity
     */
    @Override
    public void cacheResult(LFSlideEntity lfSlideEntity) {
        EntityCacheUtil.putResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideEntityImpl.class, lfSlideEntity.getPrimaryKey(),
            lfSlideEntity);

        lfSlideEntity.resetOriginalValues();
    }

    /**
     * Caches the l f slide entities in the entity cache if it is enabled.
     *
     * @param lfSlideEntities the l f slide entities
     */
    @Override
    public void cacheResult(List<LFSlideEntity> lfSlideEntities) {
        for (LFSlideEntity lfSlideEntity : lfSlideEntities) {
            if (EntityCacheUtil.getResult(
                        LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
                        LFSlideEntityImpl.class, lfSlideEntity.getPrimaryKey()) == null) {
                cacheResult(lfSlideEntity);
            } else {
                lfSlideEntity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f slide entities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSlideEntityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSlideEntityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f slide entity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSlideEntity lfSlideEntity) {
        EntityCacheUtil.removeResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideEntityImpl.class, lfSlideEntity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFSlideEntity> lfSlideEntities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSlideEntity lfSlideEntity : lfSlideEntities) {
            EntityCacheUtil.removeResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
                LFSlideEntityImpl.class, lfSlideEntity.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f slide entity with the primary key. Does not add the l f slide entity to the database.
     *
     * @param id the primary key for the new l f slide entity
     * @return the new l f slide entity
     */
    @Override
    public LFSlideEntity create(long id) {
        LFSlideEntity lfSlideEntity = new LFSlideEntityImpl();

        lfSlideEntity.setNew(true);
        lfSlideEntity.setPrimaryKey(id);

        return lfSlideEntity;
    }

    /**
     * Removes the l f slide entity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f slide entity
     * @return the l f slide entity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException if a l f slide entity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlideEntity remove(long id)
        throws NoSuchLFSlideEntityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f slide entity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f slide entity
     * @return the l f slide entity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException if a l f slide entity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlideEntity remove(Serializable primaryKey)
        throws NoSuchLFSlideEntityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSlideEntity lfSlideEntity = (LFSlideEntity) session.get(LFSlideEntityImpl.class,
                    primaryKey);

            if (lfSlideEntity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSlideEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSlideEntity);
        } catch (NoSuchLFSlideEntityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSlideEntity removeImpl(LFSlideEntity lfSlideEntity)
        throws SystemException {
        lfSlideEntity = toUnwrappedModel(lfSlideEntity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfSlideEntity)) {
                lfSlideEntity = (LFSlideEntity) session.get(LFSlideEntityImpl.class,
                        lfSlideEntity.getPrimaryKeyObj());
            }

            if (lfSlideEntity != null) {
                session.delete(lfSlideEntity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfSlideEntity != null) {
            clearCache(lfSlideEntity);
        }

        return lfSlideEntity;
    }

    @Override
    public LFSlideEntity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSlideEntity lfSlideEntity)
        throws SystemException {
        lfSlideEntity = toUnwrappedModel(lfSlideEntity);

        boolean isNew = lfSlideEntity.isNew();

        Session session = null;

        try {
            session = openSession();

            if (lfSlideEntity.isNew()) {
                session.save(lfSlideEntity);

                lfSlideEntity.setNew(false);
            } else {
                session.merge(lfSlideEntity);
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

        EntityCacheUtil.putResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
            LFSlideEntityImpl.class, lfSlideEntity.getPrimaryKey(),
            lfSlideEntity);

        return lfSlideEntity;
    }

    protected LFSlideEntity toUnwrappedModel(LFSlideEntity lfSlideEntity) {
        if (lfSlideEntity instanceof LFSlideEntityImpl) {
            return lfSlideEntity;
        }

        LFSlideEntityImpl lfSlideEntityImpl = new LFSlideEntityImpl();

        lfSlideEntityImpl.setNew(lfSlideEntity.isNew());
        lfSlideEntityImpl.setPrimaryKey(lfSlideEntity.getPrimaryKey());

        lfSlideEntityImpl.setId(lfSlideEntity.getId());
        lfSlideEntityImpl.setTop(lfSlideEntity.getTop());
        lfSlideEntityImpl.setLeft(lfSlideEntity.getLeft());
        lfSlideEntityImpl.setWidth(lfSlideEntity.getWidth());
        lfSlideEntityImpl.setHeight(lfSlideEntity.getHeight());
        lfSlideEntityImpl.setZIndex(lfSlideEntity.getZIndex());
        lfSlideEntityImpl.setContent(lfSlideEntity.getContent());
        lfSlideEntityImpl.setEntityType(lfSlideEntity.getEntityType());
        lfSlideEntityImpl.setSlideId(lfSlideEntity.getSlideId());
        lfSlideEntityImpl.setCorrectLinkedSlideId(lfSlideEntity.getCorrectLinkedSlideId());
        lfSlideEntityImpl.setIncorrectLinkedSlideId(lfSlideEntity.getIncorrectLinkedSlideId());
        lfSlideEntityImpl.setNotifyCorrectAnswer(lfSlideEntity.getNotifyCorrectAnswer());

        return lfSlideEntityImpl;
    }

    /**
     * Returns the l f slide entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f slide entity
     * @return the l f slide entity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException if a l f slide entity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlideEntity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFSlideEntityException, SystemException {
        LFSlideEntity lfSlideEntity = fetchByPrimaryKey(primaryKey);

        if (lfSlideEntity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFSlideEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfSlideEntity;
    }

    /**
     * Returns the l f slide entity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException} if it could not be found.
     *
     * @param id the primary key of the l f slide entity
     * @return the l f slide entity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideEntityException if a l f slide entity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlideEntity findByPrimaryKey(long id)
        throws NoSuchLFSlideEntityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f slide entity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f slide entity
     * @return the l f slide entity, or <code>null</code> if a l f slide entity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlideEntity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFSlideEntity lfSlideEntity = (LFSlideEntity) EntityCacheUtil.getResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
                LFSlideEntityImpl.class, primaryKey);

        if (lfSlideEntity == _nullLFSlideEntity) {
            return null;
        }

        if (lfSlideEntity == null) {
            Session session = null;

            try {
                session = openSession();

                lfSlideEntity = (LFSlideEntity) session.get(LFSlideEntityImpl.class,
                        primaryKey);

                if (lfSlideEntity != null) {
                    cacheResult(lfSlideEntity);
                } else {
                    EntityCacheUtil.putResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
                        LFSlideEntityImpl.class, primaryKey, _nullLFSlideEntity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFSlideEntityModelImpl.ENTITY_CACHE_ENABLED,
                    LFSlideEntityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfSlideEntity;
    }

    /**
     * Returns the l f slide entity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f slide entity
     * @return the l f slide entity, or <code>null</code> if a l f slide entity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSlideEntity fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f slide entities.
     *
     * @return the l f slide entities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSlideEntity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f slide entities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f slide entities
     * @param end the upper bound of the range of l f slide entities (not inclusive)
     * @return the range of l f slide entities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSlideEntity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f slide entities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f slide entities
     * @param end the upper bound of the range of l f slide entities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f slide entities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSlideEntity> findAll(int start, int end,
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

        List<LFSlideEntity> list = (List<LFSlideEntity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSLIDEENTITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSLIDEENTITY;

                if (pagination) {
                    sql = sql.concat(LFSlideEntityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFSlideEntity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSlideEntity>(list);
                } else {
                    list = (List<LFSlideEntity>) QueryUtil.list(q,
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
     * Removes all the l f slide entities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFSlideEntity lfSlideEntity : findAll()) {
            remove(lfSlideEntity);
        }
    }

    /**
     * Returns the number of l f slide entities.
     *
     * @return the number of l f slide entities
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

                Query q = session.createQuery(_SQL_COUNT_LFSLIDEENTITY);

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
     * Initializes the l f slide entity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSlideEntity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSlideEntity>> listenersList = new ArrayList<ModelListener<LFSlideEntity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSlideEntity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSlideEntityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

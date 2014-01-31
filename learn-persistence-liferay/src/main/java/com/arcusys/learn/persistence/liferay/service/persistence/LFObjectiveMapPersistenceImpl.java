package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFObjectiveMapPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l f objective map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveMapPersistence
 * @see LFObjectiveMapUtil
 * @generated
 */
public class LFObjectiveMapPersistenceImpl extends BasePersistenceImpl<LFObjectiveMap>
    implements LFObjectiveMapPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFObjectiveMapUtil} to access the l f objective map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFObjectiveMapImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTIVEID =
        new FinderPath(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveMapImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByObjectiveID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTIVEID =
        new FinderPath(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapModelImpl.FINDER_CACHE_ENABLED,
            LFObjectiveMapImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectiveID",
            new String[] { Integer.class.getName() },
            LFObjectiveMapModelImpl.OBJECTIVEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTIVEID = new FinderPath(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByObjectiveID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_NULL = "lfObjectiveMap.objectiveID IS NULL";
    private static final String _FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_2 = "lfObjectiveMap.objectiveID = ?";
    private static final String _FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_NULL_2 = "lfObjectiveMap.objectiveID IS NULL ";
    private static final String _SQL_SELECT_LFOBJECTIVEMAP = "SELECT lfObjectiveMap FROM LFObjectiveMap lfObjectiveMap";
    private static final String _SQL_SELECT_LFOBJECTIVEMAP_WHERE = "SELECT lfObjectiveMap FROM LFObjectiveMap lfObjectiveMap WHERE ";
    private static final String _SQL_COUNT_LFOBJECTIVEMAP = "SELECT COUNT(lfObjectiveMap) FROM LFObjectiveMap lfObjectiveMap";
    private static final String _SQL_COUNT_LFOBJECTIVEMAP_WHERE = "SELECT COUNT(lfObjectiveMap) FROM LFObjectiveMap lfObjectiveMap WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfObjectiveMap.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFObjectiveMap exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFObjectiveMap exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFObjectiveMapPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFObjectiveMap _nullLFObjectiveMap = new LFObjectiveMapImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFObjectiveMap> toCacheModel() {
                return _nullLFObjectiveMapCacheModel;
            }
        };

    private static CacheModel<LFObjectiveMap> _nullLFObjectiveMapCacheModel = new CacheModel<LFObjectiveMap>() {
            @Override
            public LFObjectiveMap toEntityModel() {
                return _nullLFObjectiveMap;
            }
        };

    public LFObjectiveMapPersistenceImpl() {
        setModelClass(LFObjectiveMap.class);
    }

    /**
     * Returns all the l f objective maps where objectiveID = &#63;.
     *
     * @param objectiveID the objective i d
     * @return the matching l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjectiveMap> findByObjectiveID(Integer objectiveID)
        throws SystemException {
        return findByObjectiveID(objectiveID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objective maps where objectiveID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param objectiveID the objective i d
     * @param start the lower bound of the range of l f objective maps
     * @param end the upper bound of the range of l f objective maps (not inclusive)
     * @return the range of matching l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjectiveMap> findByObjectiveID(Integer objectiveID,
        int start, int end) throws SystemException {
        return findByObjectiveID(objectiveID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objective maps where objectiveID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param objectiveID the objective i d
     * @param start the lower bound of the range of l f objective maps
     * @param end the upper bound of the range of l f objective maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjectiveMap> findByObjectiveID(Integer objectiveID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTIVEID;
            finderArgs = new Object[] { objectiveID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OBJECTIVEID;
            finderArgs = new Object[] { objectiveID, start, end, orderByComparator };
        }

        List<LFObjectiveMap> list = (List<LFObjectiveMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFObjectiveMap lfObjectiveMap : list) {
                if (!Validator.equals(objectiveID,
                            lfObjectiveMap.getObjectiveID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_LFOBJECTIVEMAP_WHERE);

            if (objectiveID == null) {
                query.append(_FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFObjectiveMapModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectiveID != null) {
                    qPos.add(objectiveID.intValue());
                }

                if (!pagination) {
                    list = (List<LFObjectiveMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFObjectiveMap>(list);
                } else {
                    list = (List<LFObjectiveMap>) QueryUtil.list(q,
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
     * Returns the first l f objective map in the ordered set where objectiveID = &#63;.
     *
     * @param objectiveID the objective i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a matching l f objective map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap findByObjectiveID_First(Integer objectiveID,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveMapException, SystemException {
        LFObjectiveMap lfObjectiveMap = fetchByObjectiveID_First(objectiveID,
                orderByComparator);

        if (lfObjectiveMap != null) {
            return lfObjectiveMap;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objectiveID=");
        msg.append(objectiveID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveMapException(msg.toString());
    }

    /**
     * Returns the first l f objective map in the ordered set where objectiveID = &#63;.
     *
     * @param objectiveID the objective i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f objective map, or <code>null</code> if a matching l f objective map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap fetchByObjectiveID_First(Integer objectiveID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFObjectiveMap> list = findByObjectiveID(objectiveID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f objective map in the ordered set where objectiveID = &#63;.
     *
     * @param objectiveID the objective i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a matching l f objective map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap findByObjectiveID_Last(Integer objectiveID,
        OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveMapException, SystemException {
        LFObjectiveMap lfObjectiveMap = fetchByObjectiveID_Last(objectiveID,
                orderByComparator);

        if (lfObjectiveMap != null) {
            return lfObjectiveMap;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("objectiveID=");
        msg.append(objectiveID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFObjectiveMapException(msg.toString());
    }

    /**
     * Returns the last l f objective map in the ordered set where objectiveID = &#63;.
     *
     * @param objectiveID the objective i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f objective map, or <code>null</code> if a matching l f objective map could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap fetchByObjectiveID_Last(Integer objectiveID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByObjectiveID(objectiveID);

        if (count == 0) {
            return null;
        }

        List<LFObjectiveMap> list = findByObjectiveID(objectiveID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f objective maps before and after the current l f objective map in the ordered set where objectiveID = &#63;.
     *
     * @param id the primary key of the current l f objective map
     * @param objectiveID the objective i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f objective map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap[] findByObjectiveID_PrevAndNext(long id,
        Integer objectiveID, OrderByComparator orderByComparator)
        throws NoSuchLFObjectiveMapException, SystemException {
        LFObjectiveMap lfObjectiveMap = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFObjectiveMap[] array = new LFObjectiveMapImpl[3];

            array[0] = getByObjectiveID_PrevAndNext(session, lfObjectiveMap,
                    objectiveID, orderByComparator, true);

            array[1] = lfObjectiveMap;

            array[2] = getByObjectiveID_PrevAndNext(session, lfObjectiveMap,
                    objectiveID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFObjectiveMap getByObjectiveID_PrevAndNext(Session session,
        LFObjectiveMap lfObjectiveMap, Integer objectiveID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFOBJECTIVEMAP_WHERE);

        if (objectiveID == null) {
            query.append(_FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(LFObjectiveMapModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (objectiveID != null) {
            qPos.add(objectiveID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfObjectiveMap);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFObjectiveMap> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f objective maps where objectiveID = &#63; from the database.
     *
     * @param objectiveID the objective i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByObjectiveID(Integer objectiveID)
        throws SystemException {
        for (LFObjectiveMap lfObjectiveMap : findByObjectiveID(objectiveID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfObjectiveMap);
        }
    }

    /**
     * Returns the number of l f objective maps where objectiveID = &#63;.
     *
     * @param objectiveID the objective i d
     * @return the number of matching l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByObjectiveID(Integer objectiveID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_OBJECTIVEID;

        Object[] finderArgs = new Object[] { objectiveID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFOBJECTIVEMAP_WHERE);

            if (objectiveID == null) {
                query.append(_FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_OBJECTIVEID_OBJECTIVEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectiveID != null) {
                    qPos.add(objectiveID.intValue());
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f objective map in the entity cache if it is enabled.
     *
     * @param lfObjectiveMap the l f objective map
     */
    @Override
    public void cacheResult(LFObjectiveMap lfObjectiveMap) {
        EntityCacheUtil.putResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapImpl.class, lfObjectiveMap.getPrimaryKey(),
            lfObjectiveMap);

        lfObjectiveMap.resetOriginalValues();
    }

    /**
     * Caches the l f objective maps in the entity cache if it is enabled.
     *
     * @param lfObjectiveMaps the l f objective maps
     */
    @Override
    public void cacheResult(List<LFObjectiveMap> lfObjectiveMaps) {
        for (LFObjectiveMap lfObjectiveMap : lfObjectiveMaps) {
            if (EntityCacheUtil.getResult(
                        LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveMapImpl.class, lfObjectiveMap.getPrimaryKey()) == null) {
                cacheResult(lfObjectiveMap);
            } else {
                lfObjectiveMap.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f objective maps.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFObjectiveMapImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFObjectiveMapImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f objective map.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFObjectiveMap lfObjectiveMap) {
        EntityCacheUtil.removeResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapImpl.class, lfObjectiveMap.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFObjectiveMap> lfObjectiveMaps) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFObjectiveMap lfObjectiveMap : lfObjectiveMaps) {
            EntityCacheUtil.removeResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveMapImpl.class, lfObjectiveMap.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f objective map with the primary key. Does not add the l f objective map to the database.
     *
     * @param id the primary key for the new l f objective map
     * @return the new l f objective map
     */
    @Override
    public LFObjectiveMap create(long id) {
        LFObjectiveMap lfObjectiveMap = new LFObjectiveMapImpl();

        lfObjectiveMap.setNew(true);
        lfObjectiveMap.setPrimaryKey(id);

        return lfObjectiveMap;
    }

    /**
     * Removes the l f objective map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f objective map
     * @return the l f objective map that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap remove(long id)
        throws NoSuchLFObjectiveMapException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f objective map with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f objective map
     * @return the l f objective map that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap remove(Serializable primaryKey)
        throws NoSuchLFObjectiveMapException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFObjectiveMap lfObjectiveMap = (LFObjectiveMap) session.get(LFObjectiveMapImpl.class,
                    primaryKey);

            if (lfObjectiveMap == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFObjectiveMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfObjectiveMap);
        } catch (NoSuchLFObjectiveMapException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFObjectiveMap removeImpl(LFObjectiveMap lfObjectiveMap)
        throws SystemException {
        lfObjectiveMap = toUnwrappedModel(lfObjectiveMap);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfObjectiveMap)) {
                lfObjectiveMap = (LFObjectiveMap) session.get(LFObjectiveMapImpl.class,
                        lfObjectiveMap.getPrimaryKeyObj());
            }

            if (lfObjectiveMap != null) {
                session.delete(lfObjectiveMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfObjectiveMap != null) {
            clearCache(lfObjectiveMap);
        }

        return lfObjectiveMap;
    }

    @Override
    public LFObjectiveMap updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap)
        throws SystemException {
        lfObjectiveMap = toUnwrappedModel(lfObjectiveMap);

        boolean isNew = lfObjectiveMap.isNew();

        LFObjectiveMapModelImpl lfObjectiveMapModelImpl = (LFObjectiveMapModelImpl) lfObjectiveMap;

        Session session = null;

        try {
            session = openSession();

            if (lfObjectiveMap.isNew()) {
                session.save(lfObjectiveMap);

                lfObjectiveMap.setNew(false);
            } else {
                session.merge(lfObjectiveMap);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFObjectiveMapModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfObjectiveMapModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTIVEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfObjectiveMapModelImpl.getOriginalObjectiveID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTIVEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTIVEID,
                    args);

                args = new Object[] { lfObjectiveMapModelImpl.getObjectiveID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OBJECTIVEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OBJECTIVEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
            LFObjectiveMapImpl.class, lfObjectiveMap.getPrimaryKey(),
            lfObjectiveMap);

        return lfObjectiveMap;
    }

    protected LFObjectiveMap toUnwrappedModel(LFObjectiveMap lfObjectiveMap) {
        if (lfObjectiveMap instanceof LFObjectiveMapImpl) {
            return lfObjectiveMap;
        }

        LFObjectiveMapImpl lfObjectiveMapImpl = new LFObjectiveMapImpl();

        lfObjectiveMapImpl.setNew(lfObjectiveMap.isNew());
        lfObjectiveMapImpl.setPrimaryKey(lfObjectiveMap.getPrimaryKey());

        lfObjectiveMapImpl.setId(lfObjectiveMap.getId());
        lfObjectiveMapImpl.setObjectiveID(lfObjectiveMap.getObjectiveID());
        lfObjectiveMapImpl.setReadSatisfiedStatusFrom(lfObjectiveMap.getReadSatisfiedStatusFrom());
        lfObjectiveMapImpl.setReadNormalizedMeasureFrom(lfObjectiveMap.getReadNormalizedMeasureFrom());
        lfObjectiveMapImpl.setWriteSatisfiedStatusTo(lfObjectiveMap.getWriteSatisfiedStatusTo());
        lfObjectiveMapImpl.setWriteNormalizedMeasureTo(lfObjectiveMap.getWriteNormalizedMeasureTo());
        lfObjectiveMapImpl.setReadRawScoreFrom(lfObjectiveMap.getReadRawScoreFrom());
        lfObjectiveMapImpl.setReadMinScoreFrom(lfObjectiveMap.getReadMinScoreFrom());
        lfObjectiveMapImpl.setReadMaxScoreFrom(lfObjectiveMap.getReadMaxScoreFrom());
        lfObjectiveMapImpl.setReadCompletionStatusFrom(lfObjectiveMap.getReadCompletionStatusFrom());
        lfObjectiveMapImpl.setReadProgressMeasureFrom(lfObjectiveMap.getReadProgressMeasureFrom());
        lfObjectiveMapImpl.setWriteRawScoreTo(lfObjectiveMap.getWriteRawScoreTo());
        lfObjectiveMapImpl.setWriteMinScoreTo(lfObjectiveMap.getWriteMinScoreTo());
        lfObjectiveMapImpl.setWriteMaxScoreTo(lfObjectiveMap.getWriteMaxScoreTo());
        lfObjectiveMapImpl.setWriteCompletionStatusTo(lfObjectiveMap.getWriteCompletionStatusTo());
        lfObjectiveMapImpl.setWriteProgressMeasureTo(lfObjectiveMap.getWriteProgressMeasureTo());

        return lfObjectiveMapImpl;
    }

    /**
     * Returns the l f objective map with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective map
     * @return the l f objective map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFObjectiveMapException, SystemException {
        LFObjectiveMap lfObjectiveMap = fetchByPrimaryKey(primaryKey);

        if (lfObjectiveMap == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFObjectiveMapException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfObjectiveMap;
    }

    /**
     * Returns the l f objective map with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException} if it could not be found.
     *
     * @param id the primary key of the l f objective map
     * @return the l f objective map
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap findByPrimaryKey(long id)
        throws NoSuchLFObjectiveMapException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f objective map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f objective map
     * @return the l f objective map, or <code>null</code> if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFObjectiveMap lfObjectiveMap = (LFObjectiveMap) EntityCacheUtil.getResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
                LFObjectiveMapImpl.class, primaryKey);

        if (lfObjectiveMap == _nullLFObjectiveMap) {
            return null;
        }

        if (lfObjectiveMap == null) {
            Session session = null;

            try {
                session = openSession();

                lfObjectiveMap = (LFObjectiveMap) session.get(LFObjectiveMapImpl.class,
                        primaryKey);

                if (lfObjectiveMap != null) {
                    cacheResult(lfObjectiveMap);
                } else {
                    EntityCacheUtil.putResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
                        LFObjectiveMapImpl.class, primaryKey,
                        _nullLFObjectiveMap);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFObjectiveMapModelImpl.ENTITY_CACHE_ENABLED,
                    LFObjectiveMapImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfObjectiveMap;
    }

    /**
     * Returns the l f objective map with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f objective map
     * @return the l f objective map, or <code>null</code> if a l f objective map with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFObjectiveMap fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f objective maps.
     *
     * @return the l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjectiveMap> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f objective maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f objective maps
     * @param end the upper bound of the range of l f objective maps (not inclusive)
     * @return the range of l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjectiveMap> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f objective maps.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f objective maps
     * @param end the upper bound of the range of l f objective maps (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f objective maps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFObjectiveMap> findAll(int start, int end,
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

        List<LFObjectiveMap> list = (List<LFObjectiveMap>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFOBJECTIVEMAP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFOBJECTIVEMAP;

                if (pagination) {
                    sql = sql.concat(LFObjectiveMapModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFObjectiveMap>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFObjectiveMap>(list);
                } else {
                    list = (List<LFObjectiveMap>) QueryUtil.list(q,
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
     * Removes all the l f objective maps from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFObjectiveMap lfObjectiveMap : findAll()) {
            remove(lfObjectiveMap);
        }
    }

    /**
     * Returns the number of l f objective maps.
     *
     * @return the number of l f objective maps
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

                Query q = session.createQuery(_SQL_COUNT_LFOBJECTIVEMAP);

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
     * Initializes the l f objective map persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFObjectiveMap")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFObjectiveMap>> listenersList = new ArrayList<ModelListener<LFObjectiveMap>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFObjectiveMap>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFObjectiveMapImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException;
import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;
import com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlobalObjectiveStatePersistence;

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
 * The persistence implementation for the l f global objective state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlobalObjectiveStatePersistence
 * @see LFGlobalObjectiveStateUtil
 * @generated
 */
public class LFGlobalObjectiveStatePersistenceImpl extends BasePersistenceImpl<LFGlobalObjectiveState>
    implements LFGlobalObjectiveStatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFGlobalObjectiveStateUtil} to access the l f global objective state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFGlobalObjectiveStateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEID = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTreeID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID =
        new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTreeID",
            new String[] { Integer.class.getName() },
            LFGlobalObjectiveStateModelImpl.TREEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TREEID = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTreeID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_TREEID_TREEID_NULL = "lfGlobalObjectiveState.treeID IS NULL";
    private static final String _FINDER_COLUMN_TREEID_TREEID_2 = "lfGlobalObjectiveState.treeID = ?";
    private static final String _FINDER_COLUMN_TREEID_TREEID_NULL_2 = "lfGlobalObjectiveState.treeID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTreeIDAndMapKey",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFGlobalObjectiveStateModelImpl.TREEID_COLUMN_BITMASK |
            LFGlobalObjectiveStateModelImpl.MAPKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY = new FinderPath(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByTreeIDAndMapKey",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_NULL = "lfGlobalObjectiveState.treeID IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_2 = "lfGlobalObjectiveState.treeID = ? AND ";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_NULL_2 = "lfGlobalObjectiveState.treeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_1 = "lfGlobalObjectiveState.mapKey IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_NULL = "lfGlobalObjectiveState.mapKey IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_2 = "lfGlobalObjectiveState.mapKey = ?";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_NULL_2 = "lfGlobalObjectiveState.mapKey IS NULL ";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_3 = "(lfGlobalObjectiveState.mapKey IS NULL OR lfGlobalObjectiveState.mapKey = '')";
    private static final String _SQL_SELECT_LFGLOBALOBJECTIVESTATE = "SELECT lfGlobalObjectiveState FROM LFGlobalObjectiveState lfGlobalObjectiveState";
    private static final String _SQL_SELECT_LFGLOBALOBJECTIVESTATE_WHERE = "SELECT lfGlobalObjectiveState FROM LFGlobalObjectiveState lfGlobalObjectiveState WHERE ";
    private static final String _SQL_COUNT_LFGLOBALOBJECTIVESTATE = "SELECT COUNT(lfGlobalObjectiveState) FROM LFGlobalObjectiveState lfGlobalObjectiveState";
    private static final String _SQL_COUNT_LFGLOBALOBJECTIVESTATE_WHERE = "SELECT COUNT(lfGlobalObjectiveState) FROM LFGlobalObjectiveState lfGlobalObjectiveState WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfGlobalObjectiveState.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFGlobalObjectiveState exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFGlobalObjectiveState exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFGlobalObjectiveStatePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFGlobalObjectiveState _nullLFGlobalObjectiveState = new LFGlobalObjectiveStateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFGlobalObjectiveState> toCacheModel() {
                return _nullLFGlobalObjectiveStateCacheModel;
            }
        };

    private static CacheModel<LFGlobalObjectiveState> _nullLFGlobalObjectiveStateCacheModel =
        new CacheModel<LFGlobalObjectiveState>() {
            @Override
            public LFGlobalObjectiveState toEntityModel() {
                return _nullLFGlobalObjectiveState;
            }
        };

    public LFGlobalObjectiveStatePersistenceImpl() {
        setModelClass(LFGlobalObjectiveState.class);
    }

    /**
     * Returns all the l f global objective states where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @return the matching l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlobalObjectiveState> findByTreeID(Integer treeID)
        throws SystemException {
        return findByTreeID(treeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f global objective states where treeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param treeID the tree i d
     * @param start the lower bound of the range of l f global objective states
     * @param end the upper bound of the range of l f global objective states (not inclusive)
     * @return the range of matching l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlobalObjectiveState> findByTreeID(Integer treeID, int start,
        int end) throws SystemException {
        return findByTreeID(treeID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f global objective states where treeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param treeID the tree i d
     * @param start the lower bound of the range of l f global objective states
     * @param end the upper bound of the range of l f global objective states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlobalObjectiveState> findByTreeID(Integer treeID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID;
            finderArgs = new Object[] { treeID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEID;
            finderArgs = new Object[] { treeID, start, end, orderByComparator };
        }

        List<LFGlobalObjectiveState> list = (List<LFGlobalObjectiveState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFGlobalObjectiveState lfGlobalObjectiveState : list) {
                if (!Validator.equals(treeID, lfGlobalObjectiveState.getTreeID())) {
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

            query.append(_SQL_SELECT_LFGLOBALOBJECTIVESTATE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEID_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEID_TREEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFGlobalObjectiveStateModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                if (!pagination) {
                    list = (List<LFGlobalObjectiveState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFGlobalObjectiveState>(list);
                } else {
                    list = (List<LFGlobalObjectiveState>) QueryUtil.list(q,
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
     * Returns the first l f global objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f global objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState findByTreeID_First(Integer treeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = fetchByTreeID_First(treeID,
                orderByComparator);

        if (lfGlobalObjectiveState != null) {
            return lfGlobalObjectiveState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFGlobalObjectiveStateException(msg.toString());
    }

    /**
     * Returns the first l f global objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState fetchByTreeID_First(Integer treeID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFGlobalObjectiveState> list = findByTreeID(treeID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f global objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f global objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState findByTreeID_Last(Integer treeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = fetchByTreeID_Last(treeID,
                orderByComparator);

        if (lfGlobalObjectiveState != null) {
            return lfGlobalObjectiveState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFGlobalObjectiveStateException(msg.toString());
    }

    /**
     * Returns the last l f global objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState fetchByTreeID_Last(Integer treeID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTreeID(treeID);

        if (count == 0) {
            return null;
        }

        List<LFGlobalObjectiveState> list = findByTreeID(treeID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f global objective states before and after the current l f global objective state in the ordered set where treeID = &#63;.
     *
     * @param id the primary key of the current l f global objective state
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f global objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState[] findByTreeID_PrevAndNext(long id,
        Integer treeID, OrderByComparator orderByComparator)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFGlobalObjectiveState[] array = new LFGlobalObjectiveStateImpl[3];

            array[0] = getByTreeID_PrevAndNext(session, lfGlobalObjectiveState,
                    treeID, orderByComparator, true);

            array[1] = lfGlobalObjectiveState;

            array[2] = getByTreeID_PrevAndNext(session, lfGlobalObjectiveState,
                    treeID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFGlobalObjectiveState getByTreeID_PrevAndNext(Session session,
        LFGlobalObjectiveState lfGlobalObjectiveState, Integer treeID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFGLOBALOBJECTIVESTATE_WHERE);

        if (treeID == null) {
            query.append(_FINDER_COLUMN_TREEID_TREEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_TREEID_TREEID_2);
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
            query.append(LFGlobalObjectiveStateModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (treeID != null) {
            qPos.add(treeID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfGlobalObjectiveState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFGlobalObjectiveState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f global objective states where treeID = &#63; from the database.
     *
     * @param treeID the tree i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTreeID(Integer treeID) throws SystemException {
        for (LFGlobalObjectiveState lfGlobalObjectiveState : findByTreeID(
                treeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfGlobalObjectiveState);
        }
    }

    /**
     * Returns the number of l f global objective states where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @return the number of matching l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTreeID(Integer treeID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TREEID;

        Object[] finderArgs = new Object[] { treeID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFGLOBALOBJECTIVESTATE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEID_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEID_TREEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
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
     * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException} if it could not be found.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the matching l f global objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState findByTreeIDAndMapKey(Integer treeID,
        String mapKey)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = fetchByTreeIDAndMapKey(treeID,
                mapKey);

        if (lfGlobalObjectiveState == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("treeID=");
            msg.append(treeID);

            msg.append(", mapKey=");
            msg.append(mapKey);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFGlobalObjectiveStateException(msg.toString());
        }

        return lfGlobalObjectiveState;
    }

    /**
     * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState fetchByTreeIDAndMapKey(Integer treeID,
        String mapKey) throws SystemException {
        return fetchByTreeIDAndMapKey(treeID, mapKey, true);
    }

    /**
     * Returns the l f global objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f global objective state, or <code>null</code> if a matching l f global objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState fetchByTreeIDAndMapKey(Integer treeID,
        String mapKey, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { treeID, mapKey };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                    finderArgs, this);
        }

        if (result instanceof LFGlobalObjectiveState) {
            LFGlobalObjectiveState lfGlobalObjectiveState = (LFGlobalObjectiveState) result;

            if (!Validator.equals(treeID, lfGlobalObjectiveState.getTreeID()) ||
                    !Validator.equals(mapKey, lfGlobalObjectiveState.getMapKey())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFGLOBALOBJECTIVESTATE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_2);
            }

            boolean bindMapKey = false;

            if (mapKey == null) {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_1);
            } else if (mapKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_3);
            } else {
                bindMapKey = true;

                if (mapKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                if (bindMapKey) {
                    if (mapKey != null) {
                        qPos.add(mapKey);
                    }
                }

                List<LFGlobalObjectiveState> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFGlobalObjectiveStatePersistenceImpl.fetchByTreeIDAndMapKey(Integer, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFGlobalObjectiveState lfGlobalObjectiveState = list.get(0);

                    result = lfGlobalObjectiveState;

                    cacheResult(lfGlobalObjectiveState);

                    if ((lfGlobalObjectiveState.getTreeID() != treeID) ||
                            (lfGlobalObjectiveState.getMapKey() == null) ||
                            !lfGlobalObjectiveState.getMapKey().equals(mapKey)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                            finderArgs, lfGlobalObjectiveState);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFGlobalObjectiveState) result;
        }
    }

    /**
     * Removes the l f global objective state where treeID = &#63; and mapKey = &#63; from the database.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the l f global objective state that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState removeByTreeIDAndMapKey(Integer treeID,
        String mapKey)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = findByTreeIDAndMapKey(treeID,
                mapKey);

        return remove(lfGlobalObjectiveState);
    }

    /**
     * Returns the number of l f global objective states where treeID = &#63; and mapKey = &#63;.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the number of matching l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTreeIDAndMapKey(Integer treeID, String mapKey)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY;

        Object[] finderArgs = new Object[] { treeID, mapKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFGLOBALOBJECTIVESTATE_WHERE);

            if (treeID == null) {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_2);
            }

            boolean bindMapKey = false;

            if (mapKey == null) {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_1);
            } else if (mapKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_3);
            } else {
                bindMapKey = true;

                if (mapKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (treeID != null) {
                    qPos.add(treeID.intValue());
                }

                if (bindMapKey) {
                    if (mapKey != null) {
                        qPos.add(mapKey);
                    }
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
     * Caches the l f global objective state in the entity cache if it is enabled.
     *
     * @param lfGlobalObjectiveState the l f global objective state
     */
    @Override
    public void cacheResult(LFGlobalObjectiveState lfGlobalObjectiveState) {
        EntityCacheUtil.putResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            lfGlobalObjectiveState.getPrimaryKey(), lfGlobalObjectiveState);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
            new Object[] {
                lfGlobalObjectiveState.getTreeID(),
                lfGlobalObjectiveState.getMapKey()
            }, lfGlobalObjectiveState);

        lfGlobalObjectiveState.resetOriginalValues();
    }

    /**
     * Caches the l f global objective states in the entity cache if it is enabled.
     *
     * @param lfGlobalObjectiveStates the l f global objective states
     */
    @Override
    public void cacheResult(
        List<LFGlobalObjectiveState> lfGlobalObjectiveStates) {
        for (LFGlobalObjectiveState lfGlobalObjectiveState : lfGlobalObjectiveStates) {
            if (EntityCacheUtil.getResult(
                        LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFGlobalObjectiveStateImpl.class,
                        lfGlobalObjectiveState.getPrimaryKey()) == null) {
                cacheResult(lfGlobalObjectiveState);
            } else {
                lfGlobalObjectiveState.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f global objective states.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFGlobalObjectiveStateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFGlobalObjectiveStateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f global objective state.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFGlobalObjectiveState lfGlobalObjectiveState) {
        EntityCacheUtil.removeResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            lfGlobalObjectiveState.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfGlobalObjectiveState);
    }

    @Override
    public void clearCache(List<LFGlobalObjectiveState> lfGlobalObjectiveStates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFGlobalObjectiveState lfGlobalObjectiveState : lfGlobalObjectiveStates) {
            EntityCacheUtil.removeResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                LFGlobalObjectiveStateImpl.class,
                lfGlobalObjectiveState.getPrimaryKey());

            clearUniqueFindersCache(lfGlobalObjectiveState);
        }
    }

    protected void cacheUniqueFindersCache(
        LFGlobalObjectiveState lfGlobalObjectiveState) {
        if (lfGlobalObjectiveState.isNew()) {
            Object[] args = new Object[] {
                    lfGlobalObjectiveState.getTreeID(),
                    lfGlobalObjectiveState.getMapKey()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                args, lfGlobalObjectiveState);
        } else {
            LFGlobalObjectiveStateModelImpl lfGlobalObjectiveStateModelImpl = (LFGlobalObjectiveStateModelImpl) lfGlobalObjectiveState;

            if ((lfGlobalObjectiveStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfGlobalObjectiveState.getTreeID(),
                        lfGlobalObjectiveState.getMapKey()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                    args, lfGlobalObjectiveState);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFGlobalObjectiveState lfGlobalObjectiveState) {
        LFGlobalObjectiveStateModelImpl lfGlobalObjectiveStateModelImpl = (LFGlobalObjectiveStateModelImpl) lfGlobalObjectiveState;

        Object[] args = new Object[] {
                lfGlobalObjectiveState.getTreeID(),
                lfGlobalObjectiveState.getMapKey()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY, args);

        if ((lfGlobalObjectiveStateModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfGlobalObjectiveStateModelImpl.getOriginalTreeID(),
                    lfGlobalObjectiveStateModelImpl.getOriginalMapKey()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                args);
        }
    }

    /**
     * Creates a new l f global objective state with the primary key. Does not add the l f global objective state to the database.
     *
     * @param id the primary key for the new l f global objective state
     * @return the new l f global objective state
     */
    @Override
    public LFGlobalObjectiveState create(long id) {
        LFGlobalObjectiveState lfGlobalObjectiveState = new LFGlobalObjectiveStateImpl();

        lfGlobalObjectiveState.setNew(true);
        lfGlobalObjectiveState.setPrimaryKey(id);

        return lfGlobalObjectiveState;
    }

    /**
     * Removes the l f global objective state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f global objective state
     * @return the l f global objective state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState remove(long id)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f global objective state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f global objective state
     * @return the l f global objective state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState remove(Serializable primaryKey)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFGlobalObjectiveState lfGlobalObjectiveState = (LFGlobalObjectiveState) session.get(LFGlobalObjectiveStateImpl.class,
                    primaryKey);

            if (lfGlobalObjectiveState == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFGlobalObjectiveStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfGlobalObjectiveState);
        } catch (NoSuchLFGlobalObjectiveStateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFGlobalObjectiveState removeImpl(
        LFGlobalObjectiveState lfGlobalObjectiveState)
        throws SystemException {
        lfGlobalObjectiveState = toUnwrappedModel(lfGlobalObjectiveState);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfGlobalObjectiveState)) {
                lfGlobalObjectiveState = (LFGlobalObjectiveState) session.get(LFGlobalObjectiveStateImpl.class,
                        lfGlobalObjectiveState.getPrimaryKeyObj());
            }

            if (lfGlobalObjectiveState != null) {
                session.delete(lfGlobalObjectiveState);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfGlobalObjectiveState != null) {
            clearCache(lfGlobalObjectiveState);
        }

        return lfGlobalObjectiveState;
    }

    @Override
    public LFGlobalObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws SystemException {
        lfGlobalObjectiveState = toUnwrappedModel(lfGlobalObjectiveState);

        boolean isNew = lfGlobalObjectiveState.isNew();

        LFGlobalObjectiveStateModelImpl lfGlobalObjectiveStateModelImpl = (LFGlobalObjectiveStateModelImpl) lfGlobalObjectiveState;

        Session session = null;

        try {
            session = openSession();

            if (lfGlobalObjectiveState.isNew()) {
                session.save(lfGlobalObjectiveState);

                lfGlobalObjectiveState.setNew(false);
            } else {
                session.merge(lfGlobalObjectiveState);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFGlobalObjectiveStateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfGlobalObjectiveStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfGlobalObjectiveStateModelImpl.getOriginalTreeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID,
                    args);

                args = new Object[] { lfGlobalObjectiveStateModelImpl.getTreeID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlobalObjectiveStateImpl.class,
            lfGlobalObjectiveState.getPrimaryKey(), lfGlobalObjectiveState);

        clearUniqueFindersCache(lfGlobalObjectiveState);
        cacheUniqueFindersCache(lfGlobalObjectiveState);

        return lfGlobalObjectiveState;
    }

    protected LFGlobalObjectiveState toUnwrappedModel(
        LFGlobalObjectiveState lfGlobalObjectiveState) {
        if (lfGlobalObjectiveState instanceof LFGlobalObjectiveStateImpl) {
            return lfGlobalObjectiveState;
        }

        LFGlobalObjectiveStateImpl lfGlobalObjectiveStateImpl = new LFGlobalObjectiveStateImpl();

        lfGlobalObjectiveStateImpl.setNew(lfGlobalObjectiveState.isNew());
        lfGlobalObjectiveStateImpl.setPrimaryKey(lfGlobalObjectiveState.getPrimaryKey());

        lfGlobalObjectiveStateImpl.setId(lfGlobalObjectiveState.getId());
        lfGlobalObjectiveStateImpl.setSatisfied(lfGlobalObjectiveState.getSatisfied());
        lfGlobalObjectiveStateImpl.setNormalizedMeasure(lfGlobalObjectiveState.getNormalizedMeasure());
        lfGlobalObjectiveStateImpl.setAttemptCompleted(lfGlobalObjectiveState.getAttemptCompleted());
        lfGlobalObjectiveStateImpl.setMapKey(lfGlobalObjectiveState.getMapKey());
        lfGlobalObjectiveStateImpl.setTreeID(lfGlobalObjectiveState.getTreeID());

        return lfGlobalObjectiveStateImpl;
    }

    /**
     * Returns the l f global objective state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f global objective state
     * @return the l f global objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = fetchByPrimaryKey(primaryKey);

        if (lfGlobalObjectiveState == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFGlobalObjectiveStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfGlobalObjectiveState;
    }

    /**
     * Returns the l f global objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException} if it could not be found.
     *
     * @param id the primary key of the l f global objective state
     * @return the l f global objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState findByPrimaryKey(long id)
        throws NoSuchLFGlobalObjectiveStateException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f global objective state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f global objective state
     * @return the l f global objective state, or <code>null</code> if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFGlobalObjectiveState lfGlobalObjectiveState = (LFGlobalObjectiveState) EntityCacheUtil.getResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                LFGlobalObjectiveStateImpl.class, primaryKey);

        if (lfGlobalObjectiveState == _nullLFGlobalObjectiveState) {
            return null;
        }

        if (lfGlobalObjectiveState == null) {
            Session session = null;

            try {
                session = openSession();

                lfGlobalObjectiveState = (LFGlobalObjectiveState) session.get(LFGlobalObjectiveStateImpl.class,
                        primaryKey);

                if (lfGlobalObjectiveState != null) {
                    cacheResult(lfGlobalObjectiveState);
                } else {
                    EntityCacheUtil.putResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFGlobalObjectiveStateImpl.class, primaryKey,
                        _nullLFGlobalObjectiveState);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFGlobalObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                    LFGlobalObjectiveStateImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfGlobalObjectiveState;
    }

    /**
     * Returns the l f global objective state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f global objective state
     * @return the l f global objective state, or <code>null</code> if a l f global objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlobalObjectiveState fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f global objective states.
     *
     * @return the l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlobalObjectiveState> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f global objective states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f global objective states
     * @param end the upper bound of the range of l f global objective states (not inclusive)
     * @return the range of l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlobalObjectiveState> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f global objective states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlobalObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f global objective states
     * @param end the upper bound of the range of l f global objective states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f global objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlobalObjectiveState> findAll(int start, int end,
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

        List<LFGlobalObjectiveState> list = (List<LFGlobalObjectiveState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFGLOBALOBJECTIVESTATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFGLOBALOBJECTIVESTATE;

                if (pagination) {
                    sql = sql.concat(LFGlobalObjectiveStateModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFGlobalObjectiveState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFGlobalObjectiveState>(list);
                } else {
                    list = (List<LFGlobalObjectiveState>) QueryUtil.list(q,
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
     * Removes all the l f global objective states from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFGlobalObjectiveState lfGlobalObjectiveState : findAll()) {
            remove(lfGlobalObjectiveState);
        }
    }

    /**
     * Returns the number of l f global objective states.
     *
     * @return the number of l f global objective states
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

                Query q = session.createQuery(_SQL_COUNT_LFGLOBALOBJECTIVESTATE);

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
     * Initializes the l f global objective state persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFGlobalObjectiveState>> listenersList = new ArrayList<ModelListener<LFGlobalObjectiveState>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFGlobalObjectiveState>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFGlobalObjectiveStateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

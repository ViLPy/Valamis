package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException;
import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState;
import com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFGlblObjectiveStatePersistence;

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
 * The persistence implementation for the l f glbl objective state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlblObjectiveStatePersistence
 * @see LFGlblObjectiveStateUtil
 * @generated
 */
public class LFGlblObjectiveStatePersistenceImpl extends BasePersistenceImpl<LFGlblObjectiveState>
    implements LFGlblObjectiveStatePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFGlblObjectiveStateUtil} to access the l f glbl objective state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFGlblObjectiveStateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TREEID = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTreeID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID =
        new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTreeID",
            new String[] { Integer.class.getName() },
            LFGlblObjectiveStateModelImpl.TREEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TREEID = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTreeID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_TREEID_TREEID_NULL = "lfGlblObjectiveState.treeID IS NULL";
    private static final String _FINDER_COLUMN_TREEID_TREEID_2 = "lfGlblObjectiveState.treeID = ?";
    private static final String _FINDER_COLUMN_TREEID_TREEID_NULL_2 = "lfGlblObjectiveState.treeID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTreeIDAndMapKey",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFGlblObjectiveStateModelImpl.TREEID_COLUMN_BITMASK |
            LFGlblObjectiveStateModelImpl.MAPKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY = new FinderPath(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByTreeIDAndMapKey",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_NULL = "lfGlblObjectiveState.treeID IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_2 = "lfGlblObjectiveState.treeID = ? AND ";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_TREEID_NULL_2 = "lfGlblObjectiveState.treeID IS NULL  AND ";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_1 = "lfGlblObjectiveState.mapKey IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_NULL = "lfGlblObjectiveState.mapKey IS NULL";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_2 = "lfGlblObjectiveState.mapKey = ?";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_NULL_2 = "lfGlblObjectiveState.mapKey IS NULL ";
    private static final String _FINDER_COLUMN_TREEIDANDMAPKEY_MAPKEY_3 = "(lfGlblObjectiveState.mapKey IS NULL OR lfGlblObjectiveState.mapKey = '')";
    private static final String _SQL_SELECT_LFGLBLOBJECTIVESTATE = "SELECT lfGlblObjectiveState FROM LFGlblObjectiveState lfGlblObjectiveState";
    private static final String _SQL_SELECT_LFGLBLOBJECTIVESTATE_WHERE = "SELECT lfGlblObjectiveState FROM LFGlblObjectiveState lfGlblObjectiveState WHERE ";
    private static final String _SQL_COUNT_LFGLBLOBJECTIVESTATE = "SELECT COUNT(lfGlblObjectiveState) FROM LFGlblObjectiveState lfGlblObjectiveState";
    private static final String _SQL_COUNT_LFGLBLOBJECTIVESTATE_WHERE = "SELECT COUNT(lfGlblObjectiveState) FROM LFGlblObjectiveState lfGlblObjectiveState WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfGlblObjectiveState.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFGlblObjectiveState exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFGlblObjectiveState exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFGlblObjectiveStatePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFGlblObjectiveState _nullLFGlblObjectiveState = new LFGlblObjectiveStateImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFGlblObjectiveState> toCacheModel() {
                return _nullLFGlblObjectiveStateCacheModel;
            }
        };

    private static CacheModel<LFGlblObjectiveState> _nullLFGlblObjectiveStateCacheModel =
        new CacheModel<LFGlblObjectiveState>() {
            @Override
            public LFGlblObjectiveState toEntityModel() {
                return _nullLFGlblObjectiveState;
            }
        };

    public LFGlblObjectiveStatePersistenceImpl() {
        setModelClass(LFGlblObjectiveState.class);
    }

    /**
     * Returns all the l f glbl objective states where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @return the matching l f glbl objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlblObjectiveState> findByTreeID(Integer treeID)
        throws SystemException {
        return findByTreeID(treeID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f glbl objective states where treeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param treeID the tree i d
     * @param start the lower bound of the range of l f glbl objective states
     * @param end the upper bound of the range of l f glbl objective states (not inclusive)
     * @return the range of matching l f glbl objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlblObjectiveState> findByTreeID(Integer treeID, int start,
        int end) throws SystemException {
        return findByTreeID(treeID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f glbl objective states where treeID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param treeID the tree i d
     * @param start the lower bound of the range of l f glbl objective states
     * @param end the upper bound of the range of l f glbl objective states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f glbl objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlblObjectiveState> findByTreeID(Integer treeID, int start,
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

        List<LFGlblObjectiveState> list = (List<LFGlblObjectiveState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFGlblObjectiveState lfGlblObjectiveState : list) {
                if (!Validator.equals(treeID, lfGlblObjectiveState.getTreeID())) {
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

            query.append(_SQL_SELECT_LFGLBLOBJECTIVESTATE_WHERE);

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
                query.append(LFGlblObjectiveStateModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFGlblObjectiveState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFGlblObjectiveState>(list);
                } else {
                    list = (List<LFGlblObjectiveState>) QueryUtil.list(q,
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
     * Returns the first l f glbl objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f glbl objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState findByTreeID_First(Integer treeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = fetchByTreeID_First(treeID,
                orderByComparator);

        if (lfGlblObjectiveState != null) {
            return lfGlblObjectiveState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFGlblObjectiveStateException(msg.toString());
    }

    /**
     * Returns the first l f glbl objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState fetchByTreeID_First(Integer treeID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFGlblObjectiveState> list = findByTreeID(treeID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f glbl objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f glbl objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState findByTreeID_Last(Integer treeID,
        OrderByComparator orderByComparator)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = fetchByTreeID_Last(treeID,
                orderByComparator);

        if (lfGlblObjectiveState != null) {
            return lfGlblObjectiveState;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("treeID=");
        msg.append(treeID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFGlblObjectiveStateException(msg.toString());
    }

    /**
     * Returns the last l f glbl objective state in the ordered set where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState fetchByTreeID_Last(Integer treeID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTreeID(treeID);

        if (count == 0) {
            return null;
        }

        List<LFGlblObjectiveState> list = findByTreeID(treeID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f glbl objective states before and after the current l f glbl objective state in the ordered set where treeID = &#63;.
     *
     * @param id the primary key of the current l f glbl objective state
     * @param treeID the tree i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f glbl objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState[] findByTreeID_PrevAndNext(long id,
        Integer treeID, OrderByComparator orderByComparator)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFGlblObjectiveState[] array = new LFGlblObjectiveStateImpl[3];

            array[0] = getByTreeID_PrevAndNext(session, lfGlblObjectiveState,
                    treeID, orderByComparator, true);

            array[1] = lfGlblObjectiveState;

            array[2] = getByTreeID_PrevAndNext(session, lfGlblObjectiveState,
                    treeID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFGlblObjectiveState getByTreeID_PrevAndNext(Session session,
        LFGlblObjectiveState lfGlblObjectiveState, Integer treeID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFGLBLOBJECTIVESTATE_WHERE);

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
            query.append(LFGlblObjectiveStateModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfGlblObjectiveState);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFGlblObjectiveState> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f glbl objective states where treeID = &#63; from the database.
     *
     * @param treeID the tree i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTreeID(Integer treeID) throws SystemException {
        for (LFGlblObjectiveState lfGlblObjectiveState : findByTreeID(treeID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfGlblObjectiveState);
        }
    }

    /**
     * Returns the number of l f glbl objective states where treeID = &#63;.
     *
     * @param treeID the tree i d
     * @return the number of matching l f glbl objective states
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

            query.append(_SQL_COUNT_LFGLBLOBJECTIVESTATE_WHERE);

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
     * Returns the l f glbl objective state where treeID = &#63; and mapKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException} if it could not be found.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the matching l f glbl objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState findByTreeIDAndMapKey(Integer treeID,
        String mapKey)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = fetchByTreeIDAndMapKey(treeID,
                mapKey);

        if (lfGlblObjectiveState == null) {
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

            throw new NoSuchLFGlblObjectiveStateException(msg.toString());
        }

        return lfGlblObjectiveState;
    }

    /**
     * Returns the l f glbl objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState fetchByTreeIDAndMapKey(Integer treeID,
        String mapKey) throws SystemException {
        return fetchByTreeIDAndMapKey(treeID, mapKey, true);
    }

    /**
     * Returns the l f glbl objective state where treeID = &#63; and mapKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f glbl objective state, or <code>null</code> if a matching l f glbl objective state could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState fetchByTreeIDAndMapKey(Integer treeID,
        String mapKey, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { treeID, mapKey };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                    finderArgs, this);
        }

        if (result instanceof LFGlblObjectiveState) {
            LFGlblObjectiveState lfGlblObjectiveState = (LFGlblObjectiveState) result;

            if (!Validator.equals(treeID, lfGlblObjectiveState.getTreeID()) ||
                    !Validator.equals(mapKey, lfGlblObjectiveState.getMapKey())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFGLBLOBJECTIVESTATE_WHERE);

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

                List<LFGlblObjectiveState> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFGlblObjectiveStatePersistenceImpl.fetchByTreeIDAndMapKey(Integer, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFGlblObjectiveState lfGlblObjectiveState = list.get(0);

                    result = lfGlblObjectiveState;

                    cacheResult(lfGlblObjectiveState);

                    if ((lfGlblObjectiveState.getTreeID() != treeID) ||
                            (lfGlblObjectiveState.getMapKey() == null) ||
                            !lfGlblObjectiveState.getMapKey().equals(mapKey)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                            finderArgs, lfGlblObjectiveState);
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
            return (LFGlblObjectiveState) result;
        }
    }

    /**
     * Removes the l f glbl objective state where treeID = &#63; and mapKey = &#63; from the database.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the l f glbl objective state that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState removeByTreeIDAndMapKey(Integer treeID,
        String mapKey)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = findByTreeIDAndMapKey(treeID,
                mapKey);

        return remove(lfGlblObjectiveState);
    }

    /**
     * Returns the number of l f glbl objective states where treeID = &#63; and mapKey = &#63;.
     *
     * @param treeID the tree i d
     * @param mapKey the map key
     * @return the number of matching l f glbl objective states
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

            query.append(_SQL_COUNT_LFGLBLOBJECTIVESTATE_WHERE);

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
     * Caches the l f glbl objective state in the entity cache if it is enabled.
     *
     * @param lfGlblObjectiveState the l f glbl objective state
     */
    @Override
    public void cacheResult(LFGlblObjectiveState lfGlblObjectiveState) {
        EntityCacheUtil.putResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class,
            lfGlblObjectiveState.getPrimaryKey(), lfGlblObjectiveState);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
            new Object[] {
                lfGlblObjectiveState.getTreeID(),
                lfGlblObjectiveState.getMapKey()
            }, lfGlblObjectiveState);

        lfGlblObjectiveState.resetOriginalValues();
    }

    /**
     * Caches the l f glbl objective states in the entity cache if it is enabled.
     *
     * @param lfGlblObjectiveStates the l f glbl objective states
     */
    @Override
    public void cacheResult(List<LFGlblObjectiveState> lfGlblObjectiveStates) {
        for (LFGlblObjectiveState lfGlblObjectiveState : lfGlblObjectiveStates) {
            if (EntityCacheUtil.getResult(
                        LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFGlblObjectiveStateImpl.class,
                        lfGlblObjectiveState.getPrimaryKey()) == null) {
                cacheResult(lfGlblObjectiveState);
            } else {
                lfGlblObjectiveState.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f glbl objective states.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFGlblObjectiveStateImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFGlblObjectiveStateImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f glbl objective state.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFGlblObjectiveState lfGlblObjectiveState) {
        EntityCacheUtil.removeResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class, lfGlblObjectiveState.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfGlblObjectiveState);
    }

    @Override
    public void clearCache(List<LFGlblObjectiveState> lfGlblObjectiveStates) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFGlblObjectiveState lfGlblObjectiveState : lfGlblObjectiveStates) {
            EntityCacheUtil.removeResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                LFGlblObjectiveStateImpl.class,
                lfGlblObjectiveState.getPrimaryKey());

            clearUniqueFindersCache(lfGlblObjectiveState);
        }
    }

    protected void cacheUniqueFindersCache(
        LFGlblObjectiveState lfGlblObjectiveState) {
        if (lfGlblObjectiveState.isNew()) {
            Object[] args = new Object[] {
                    lfGlblObjectiveState.getTreeID(),
                    lfGlblObjectiveState.getMapKey()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                args, lfGlblObjectiveState);
        } else {
            LFGlblObjectiveStateModelImpl lfGlblObjectiveStateModelImpl = (LFGlblObjectiveStateModelImpl) lfGlblObjectiveState;

            if ((lfGlblObjectiveStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfGlblObjectiveState.getTreeID(),
                        lfGlblObjectiveState.getMapKey()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                    args, lfGlblObjectiveState);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFGlblObjectiveState lfGlblObjectiveState) {
        LFGlblObjectiveStateModelImpl lfGlblObjectiveStateModelImpl = (LFGlblObjectiveStateModelImpl) lfGlblObjectiveState;

        Object[] args = new Object[] {
                lfGlblObjectiveState.getTreeID(),
                lfGlblObjectiveState.getMapKey()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY, args);

        if ((lfGlblObjectiveStateModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfGlblObjectiveStateModelImpl.getOriginalTreeID(),
                    lfGlblObjectiveStateModelImpl.getOriginalMapKey()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEIDANDMAPKEY,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TREEIDANDMAPKEY,
                args);
        }
    }

    /**
     * Creates a new l f glbl objective state with the primary key. Does not add the l f glbl objective state to the database.
     *
     * @param id the primary key for the new l f glbl objective state
     * @return the new l f glbl objective state
     */
    @Override
    public LFGlblObjectiveState create(long id) {
        LFGlblObjectiveState lfGlblObjectiveState = new LFGlblObjectiveStateImpl();

        lfGlblObjectiveState.setNew(true);
        lfGlblObjectiveState.setPrimaryKey(id);

        return lfGlblObjectiveState;
    }

    /**
     * Removes the l f glbl objective state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f glbl objective state
     * @return the l f glbl objective state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState remove(long id)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f glbl objective state with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f glbl objective state
     * @return the l f glbl objective state that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState remove(Serializable primaryKey)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFGlblObjectiveState lfGlblObjectiveState = (LFGlblObjectiveState) session.get(LFGlblObjectiveStateImpl.class,
                    primaryKey);

            if (lfGlblObjectiveState == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFGlblObjectiveStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfGlblObjectiveState);
        } catch (NoSuchLFGlblObjectiveStateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFGlblObjectiveState removeImpl(
        LFGlblObjectiveState lfGlblObjectiveState) throws SystemException {
        lfGlblObjectiveState = toUnwrappedModel(lfGlblObjectiveState);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfGlblObjectiveState)) {
                lfGlblObjectiveState = (LFGlblObjectiveState) session.get(LFGlblObjectiveStateImpl.class,
                        lfGlblObjectiveState.getPrimaryKeyObj());
            }

            if (lfGlblObjectiveState != null) {
                session.delete(lfGlblObjectiveState);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfGlblObjectiveState != null) {
            clearCache(lfGlblObjectiveState);
        }

        return lfGlblObjectiveState;
    }

    @Override
    public LFGlblObjectiveState updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState lfGlblObjectiveState)
        throws SystemException {
        lfGlblObjectiveState = toUnwrappedModel(lfGlblObjectiveState);

        boolean isNew = lfGlblObjectiveState.isNew();

        LFGlblObjectiveStateModelImpl lfGlblObjectiveStateModelImpl = (LFGlblObjectiveStateModelImpl) lfGlblObjectiveState;

        Session session = null;

        try {
            session = openSession();

            if (lfGlblObjectiveState.isNew()) {
                session.save(lfGlblObjectiveState);

                lfGlblObjectiveState.setNew(false);
            } else {
                session.merge(lfGlblObjectiveState);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFGlblObjectiveStateModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfGlblObjectiveStateModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfGlblObjectiveStateModelImpl.getOriginalTreeID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID,
                    args);

                args = new Object[] { lfGlblObjectiveStateModelImpl.getTreeID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TREEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TREEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
            LFGlblObjectiveStateImpl.class,
            lfGlblObjectiveState.getPrimaryKey(), lfGlblObjectiveState);

        clearUniqueFindersCache(lfGlblObjectiveState);
        cacheUniqueFindersCache(lfGlblObjectiveState);

        return lfGlblObjectiveState;
    }

    protected LFGlblObjectiveState toUnwrappedModel(
        LFGlblObjectiveState lfGlblObjectiveState) {
        if (lfGlblObjectiveState instanceof LFGlblObjectiveStateImpl) {
            return lfGlblObjectiveState;
        }

        LFGlblObjectiveStateImpl lfGlblObjectiveStateImpl = new LFGlblObjectiveStateImpl();

        lfGlblObjectiveStateImpl.setNew(lfGlblObjectiveState.isNew());
        lfGlblObjectiveStateImpl.setPrimaryKey(lfGlblObjectiveState.getPrimaryKey());

        lfGlblObjectiveStateImpl.setId(lfGlblObjectiveState.getId());
        lfGlblObjectiveStateImpl.setSatisfied(lfGlblObjectiveState.getSatisfied());
        lfGlblObjectiveStateImpl.setNormalizedMeasure(lfGlblObjectiveState.getNormalizedMeasure());
        lfGlblObjectiveStateImpl.setAttemptCompleted(lfGlblObjectiveState.getAttemptCompleted());
        lfGlblObjectiveStateImpl.setMapKey(lfGlblObjectiveState.getMapKey());
        lfGlblObjectiveStateImpl.setTreeID(lfGlblObjectiveState.getTreeID());

        return lfGlblObjectiveStateImpl;
    }

    /**
     * Returns the l f glbl objective state with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f glbl objective state
     * @return the l f glbl objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = fetchByPrimaryKey(primaryKey);

        if (lfGlblObjectiveState == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFGlblObjectiveStateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfGlblObjectiveState;
    }

    /**
     * Returns the l f glbl objective state with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException} if it could not be found.
     *
     * @param id the primary key of the l f glbl objective state
     * @return the l f glbl objective state
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState findByPrimaryKey(long id)
        throws NoSuchLFGlblObjectiveStateException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f glbl objective state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f glbl objective state
     * @return the l f glbl objective state, or <code>null</code> if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFGlblObjectiveState lfGlblObjectiveState = (LFGlblObjectiveState) EntityCacheUtil.getResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                LFGlblObjectiveStateImpl.class, primaryKey);

        if (lfGlblObjectiveState == _nullLFGlblObjectiveState) {
            return null;
        }

        if (lfGlblObjectiveState == null) {
            Session session = null;

            try {
                session = openSession();

                lfGlblObjectiveState = (LFGlblObjectiveState) session.get(LFGlblObjectiveStateImpl.class,
                        primaryKey);

                if (lfGlblObjectiveState != null) {
                    cacheResult(lfGlblObjectiveState);
                } else {
                    EntityCacheUtil.putResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                        LFGlblObjectiveStateImpl.class, primaryKey,
                        _nullLFGlblObjectiveState);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFGlblObjectiveStateModelImpl.ENTITY_CACHE_ENABLED,
                    LFGlblObjectiveStateImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfGlblObjectiveState;
    }

    /**
     * Returns the l f glbl objective state with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f glbl objective state
     * @return the l f glbl objective state, or <code>null</code> if a l f glbl objective state with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFGlblObjectiveState fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f glbl objective states.
     *
     * @return the l f glbl objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlblObjectiveState> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f glbl objective states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f glbl objective states
     * @param end the upper bound of the range of l f glbl objective states (not inclusive)
     * @return the range of l f glbl objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlblObjectiveState> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f glbl objective states.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f glbl objective states
     * @param end the upper bound of the range of l f glbl objective states (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f glbl objective states
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFGlblObjectiveState> findAll(int start, int end,
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

        List<LFGlblObjectiveState> list = (List<LFGlblObjectiveState>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFGLBLOBJECTIVESTATE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFGLBLOBJECTIVESTATE;

                if (pagination) {
                    sql = sql.concat(LFGlblObjectiveStateModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFGlblObjectiveState>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFGlblObjectiveState>(list);
                } else {
                    list = (List<LFGlblObjectiveState>) QueryUtil.list(q,
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
     * Removes all the l f glbl objective states from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFGlblObjectiveState lfGlblObjectiveState : findAll()) {
            remove(lfGlblObjectiveState);
        }
    }

    /**
     * Returns the number of l f glbl objective states.
     *
     * @return the number of l f glbl objective states
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

                Query q = session.createQuery(_SQL_COUNT_LFGLBLOBJECTIVESTATE);

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
     * Initializes the l f glbl objective state persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFGlblObjectiveState>> listenersList = new ArrayList<ModelListener<LFGlblObjectiveState>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFGlblObjectiveState>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFGlblObjectiveStateImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

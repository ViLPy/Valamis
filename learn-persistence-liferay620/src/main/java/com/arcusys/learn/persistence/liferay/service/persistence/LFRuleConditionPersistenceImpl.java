package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException;
import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;
import com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRuleConditionPersistence;

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
 * The persistence implementation for the l f rule condition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRuleConditionPersistence
 * @see LFRuleConditionUtil
 * @generated
 */
public class LFRuleConditionPersistenceImpl extends BasePersistenceImpl<LFRuleCondition>
    implements LFRuleConditionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRuleConditionUtil} to access the l f rule condition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRuleConditionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED,
            LFRuleConditionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED,
            LFRuleConditionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLLUP = new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED,
            LFRuleConditionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByRollup",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLLUP =
        new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED,
            LFRuleConditionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRollup",
            new String[] { Integer.class.getName() },
            LFRuleConditionModelImpl.ROLLUPRULEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ROLLUP = new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRollup",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ROLLUP_ROLLUPRULEID_NULL = "lfRuleCondition.rollupRuleID IS NULL";
    private static final String _FINDER_COLUMN_ROLLUP_ROLLUPRULEID_2 = "lfRuleCondition.rollupRuleID = ?";
    private static final String _FINDER_COLUMN_ROLLUP_ROLLUPRULEID_NULL_2 = "lfRuleCondition.rollupRuleID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONDITION =
        new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED,
            LFRuleConditionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCondition",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONDITION =
        new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED,
            LFRuleConditionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCondition",
            new String[] { Integer.class.getName() },
            LFRuleConditionModelImpl.CONDITIONRULEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONDITION = new FinderPath(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCondition",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_CONDITION_CONDITIONRULEID_NULL = "lfRuleCondition.conditionRuleID IS NULL";
    private static final String _FINDER_COLUMN_CONDITION_CONDITIONRULEID_2 = "lfRuleCondition.conditionRuleID = ?";
    private static final String _FINDER_COLUMN_CONDITION_CONDITIONRULEID_NULL_2 = "lfRuleCondition.conditionRuleID IS NULL ";
    private static final String _SQL_SELECT_LFRULECONDITION = "SELECT lfRuleCondition FROM LFRuleCondition lfRuleCondition";
    private static final String _SQL_SELECT_LFRULECONDITION_WHERE = "SELECT lfRuleCondition FROM LFRuleCondition lfRuleCondition WHERE ";
    private static final String _SQL_COUNT_LFRULECONDITION = "SELECT COUNT(lfRuleCondition) FROM LFRuleCondition lfRuleCondition";
    private static final String _SQL_COUNT_LFRULECONDITION_WHERE = "SELECT COUNT(lfRuleCondition) FROM LFRuleCondition lfRuleCondition WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRuleCondition.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRuleCondition exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRuleCondition exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRuleConditionPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFRuleCondition _nullLFRuleCondition = new LFRuleConditionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRuleCondition> toCacheModel() {
                return _nullLFRuleConditionCacheModel;
            }
        };

    private static CacheModel<LFRuleCondition> _nullLFRuleConditionCacheModel = new CacheModel<LFRuleCondition>() {
            @Override
            public LFRuleCondition toEntityModel() {
                return _nullLFRuleCondition;
            }
        };

    public LFRuleConditionPersistenceImpl() {
        setModelClass(LFRuleCondition.class);
    }

    /**
     * Returns all the l f rule conditions where rollupRuleID = &#63;.
     *
     * @param rollupRuleID the rollup rule i d
     * @return the matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findByRollup(Integer rollupRuleID)
        throws SystemException {
        return findByRollup(rollupRuleID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f rule conditions where rollupRuleID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param rollupRuleID the rollup rule i d
     * @param start the lower bound of the range of l f rule conditions
     * @param end the upper bound of the range of l f rule conditions (not inclusive)
     * @return the range of matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findByRollup(Integer rollupRuleID, int start,
        int end) throws SystemException {
        return findByRollup(rollupRuleID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rule conditions where rollupRuleID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param rollupRuleID the rollup rule i d
     * @param start the lower bound of the range of l f rule conditions
     * @param end the upper bound of the range of l f rule conditions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findByRollup(Integer rollupRuleID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLLUP;
            finderArgs = new Object[] { rollupRuleID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ROLLUP;
            finderArgs = new Object[] {
                    rollupRuleID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFRuleCondition> list = (List<LFRuleCondition>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRuleCondition lfRuleCondition : list) {
                if (!Validator.equals(rollupRuleID,
                            lfRuleCondition.getRollupRuleID())) {
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

            query.append(_SQL_SELECT_LFRULECONDITION_WHERE);

            if (rollupRuleID == null) {
                query.append(_FINDER_COLUMN_ROLLUP_ROLLUPRULEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ROLLUP_ROLLUPRULEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFRuleConditionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (rollupRuleID != null) {
                    qPos.add(rollupRuleID.intValue());
                }

                if (!pagination) {
                    list = (List<LFRuleCondition>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRuleCondition>(list);
                } else {
                    list = (List<LFRuleCondition>) QueryUtil.list(q,
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
     * Returns the first l f rule condition in the ordered set where rollupRuleID = &#63;.
     *
     * @param rollupRuleID the rollup rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition findByRollup_First(Integer rollupRuleID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = fetchByRollup_First(rollupRuleID,
                orderByComparator);

        if (lfRuleCondition != null) {
            return lfRuleCondition;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("rollupRuleID=");
        msg.append(rollupRuleID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRuleConditionException(msg.toString());
    }

    /**
     * Returns the first l f rule condition in the ordered set where rollupRuleID = &#63;.
     *
     * @param rollupRuleID the rollup rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition fetchByRollup_First(Integer rollupRuleID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFRuleCondition> list = findByRollup(rollupRuleID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f rule condition in the ordered set where rollupRuleID = &#63;.
     *
     * @param rollupRuleID the rollup rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition findByRollup_Last(Integer rollupRuleID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = fetchByRollup_Last(rollupRuleID,
                orderByComparator);

        if (lfRuleCondition != null) {
            return lfRuleCondition;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("rollupRuleID=");
        msg.append(rollupRuleID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRuleConditionException(msg.toString());
    }

    /**
     * Returns the last l f rule condition in the ordered set where rollupRuleID = &#63;.
     *
     * @param rollupRuleID the rollup rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition fetchByRollup_Last(Integer rollupRuleID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByRollup(rollupRuleID);

        if (count == 0) {
            return null;
        }

        List<LFRuleCondition> list = findByRollup(rollupRuleID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f rule conditions before and after the current l f rule condition in the ordered set where rollupRuleID = &#63;.
     *
     * @param id the primary key of the current l f rule condition
     * @param rollupRuleID the rollup rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition[] findByRollup_PrevAndNext(long id,
        Integer rollupRuleID, OrderByComparator orderByComparator)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRuleCondition[] array = new LFRuleConditionImpl[3];

            array[0] = getByRollup_PrevAndNext(session, lfRuleCondition,
                    rollupRuleID, orderByComparator, true);

            array[1] = lfRuleCondition;

            array[2] = getByRollup_PrevAndNext(session, lfRuleCondition,
                    rollupRuleID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRuleCondition getByRollup_PrevAndNext(Session session,
        LFRuleCondition lfRuleCondition, Integer rollupRuleID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFRULECONDITION_WHERE);

        if (rollupRuleID == null) {
            query.append(_FINDER_COLUMN_ROLLUP_ROLLUPRULEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ROLLUP_ROLLUPRULEID_2);
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
            query.append(LFRuleConditionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (rollupRuleID != null) {
            qPos.add(rollupRuleID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfRuleCondition);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRuleCondition> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f rule conditions where rollupRuleID = &#63; from the database.
     *
     * @param rollupRuleID the rollup rule i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByRollup(Integer rollupRuleID) throws SystemException {
        for (LFRuleCondition lfRuleCondition : findByRollup(rollupRuleID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfRuleCondition);
        }
    }

    /**
     * Returns the number of l f rule conditions where rollupRuleID = &#63;.
     *
     * @param rollupRuleID the rollup rule i d
     * @return the number of matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRollup(Integer rollupRuleID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ROLLUP;

        Object[] finderArgs = new Object[] { rollupRuleID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFRULECONDITION_WHERE);

            if (rollupRuleID == null) {
                query.append(_FINDER_COLUMN_ROLLUP_ROLLUPRULEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ROLLUP_ROLLUPRULEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (rollupRuleID != null) {
                    qPos.add(rollupRuleID.intValue());
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
     * Returns all the l f rule conditions where conditionRuleID = &#63;.
     *
     * @param conditionRuleID the condition rule i d
     * @return the matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findByCondition(Integer conditionRuleID)
        throws SystemException {
        return findByCondition(conditionRuleID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rule conditions where conditionRuleID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param conditionRuleID the condition rule i d
     * @param start the lower bound of the range of l f rule conditions
     * @param end the upper bound of the range of l f rule conditions (not inclusive)
     * @return the range of matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findByCondition(Integer conditionRuleID,
        int start, int end) throws SystemException {
        return findByCondition(conditionRuleID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rule conditions where conditionRuleID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param conditionRuleID the condition rule i d
     * @param start the lower bound of the range of l f rule conditions
     * @param end the upper bound of the range of l f rule conditions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findByCondition(Integer conditionRuleID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONDITION;
            finderArgs = new Object[] { conditionRuleID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONDITION;
            finderArgs = new Object[] {
                    conditionRuleID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFRuleCondition> list = (List<LFRuleCondition>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRuleCondition lfRuleCondition : list) {
                if (!Validator.equals(conditionRuleID,
                            lfRuleCondition.getConditionRuleID())) {
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

            query.append(_SQL_SELECT_LFRULECONDITION_WHERE);

            if (conditionRuleID == null) {
                query.append(_FINDER_COLUMN_CONDITION_CONDITIONRULEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CONDITION_CONDITIONRULEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFRuleConditionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (conditionRuleID != null) {
                    qPos.add(conditionRuleID.intValue());
                }

                if (!pagination) {
                    list = (List<LFRuleCondition>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRuleCondition>(list);
                } else {
                    list = (List<LFRuleCondition>) QueryUtil.list(q,
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
     * Returns the first l f rule condition in the ordered set where conditionRuleID = &#63;.
     *
     * @param conditionRuleID the condition rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition findByCondition_First(Integer conditionRuleID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = fetchByCondition_First(conditionRuleID,
                orderByComparator);

        if (lfRuleCondition != null) {
            return lfRuleCondition;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("conditionRuleID=");
        msg.append(conditionRuleID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRuleConditionException(msg.toString());
    }

    /**
     * Returns the first l f rule condition in the ordered set where conditionRuleID = &#63;.
     *
     * @param conditionRuleID the condition rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition fetchByCondition_First(Integer conditionRuleID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFRuleCondition> list = findByCondition(conditionRuleID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f rule condition in the ordered set where conditionRuleID = &#63;.
     *
     * @param conditionRuleID the condition rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition findByCondition_Last(Integer conditionRuleID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = fetchByCondition_Last(conditionRuleID,
                orderByComparator);

        if (lfRuleCondition != null) {
            return lfRuleCondition;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("conditionRuleID=");
        msg.append(conditionRuleID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRuleConditionException(msg.toString());
    }

    /**
     * Returns the last l f rule condition in the ordered set where conditionRuleID = &#63;.
     *
     * @param conditionRuleID the condition rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition fetchByCondition_Last(Integer conditionRuleID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCondition(conditionRuleID);

        if (count == 0) {
            return null;
        }

        List<LFRuleCondition> list = findByCondition(conditionRuleID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f rule conditions before and after the current l f rule condition in the ordered set where conditionRuleID = &#63;.
     *
     * @param id the primary key of the current l f rule condition
     * @param conditionRuleID the condition rule i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition[] findByCondition_PrevAndNext(long id,
        Integer conditionRuleID, OrderByComparator orderByComparator)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRuleCondition[] array = new LFRuleConditionImpl[3];

            array[0] = getByCondition_PrevAndNext(session, lfRuleCondition,
                    conditionRuleID, orderByComparator, true);

            array[1] = lfRuleCondition;

            array[2] = getByCondition_PrevAndNext(session, lfRuleCondition,
                    conditionRuleID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRuleCondition getByCondition_PrevAndNext(Session session,
        LFRuleCondition lfRuleCondition, Integer conditionRuleID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFRULECONDITION_WHERE);

        if (conditionRuleID == null) {
            query.append(_FINDER_COLUMN_CONDITION_CONDITIONRULEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CONDITION_CONDITIONRULEID_2);
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
            query.append(LFRuleConditionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (conditionRuleID != null) {
            qPos.add(conditionRuleID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfRuleCondition);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRuleCondition> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f rule conditions where conditionRuleID = &#63; from the database.
     *
     * @param conditionRuleID the condition rule i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCondition(Integer conditionRuleID)
        throws SystemException {
        for (LFRuleCondition lfRuleCondition : findByCondition(
                conditionRuleID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfRuleCondition);
        }
    }

    /**
     * Returns the number of l f rule conditions where conditionRuleID = &#63;.
     *
     * @param conditionRuleID the condition rule i d
     * @return the number of matching l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCondition(Integer conditionRuleID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CONDITION;

        Object[] finderArgs = new Object[] { conditionRuleID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFRULECONDITION_WHERE);

            if (conditionRuleID == null) {
                query.append(_FINDER_COLUMN_CONDITION_CONDITIONRULEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CONDITION_CONDITIONRULEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (conditionRuleID != null) {
                    qPos.add(conditionRuleID.intValue());
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
     * Caches the l f rule condition in the entity cache if it is enabled.
     *
     * @param lfRuleCondition the l f rule condition
     */
    @Override
    public void cacheResult(LFRuleCondition lfRuleCondition) {
        EntityCacheUtil.putResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionImpl.class, lfRuleCondition.getPrimaryKey(),
            lfRuleCondition);

        lfRuleCondition.resetOriginalValues();
    }

    /**
     * Caches the l f rule conditions in the entity cache if it is enabled.
     *
     * @param lfRuleConditions the l f rule conditions
     */
    @Override
    public void cacheResult(List<LFRuleCondition> lfRuleConditions) {
        for (LFRuleCondition lfRuleCondition : lfRuleConditions) {
            if (EntityCacheUtil.getResult(
                        LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
                        LFRuleConditionImpl.class,
                        lfRuleCondition.getPrimaryKey()) == null) {
                cacheResult(lfRuleCondition);
            } else {
                lfRuleCondition.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f rule conditions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRuleConditionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRuleConditionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f rule condition.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRuleCondition lfRuleCondition) {
        EntityCacheUtil.removeResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionImpl.class, lfRuleCondition.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFRuleCondition> lfRuleConditions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRuleCondition lfRuleCondition : lfRuleConditions) {
            EntityCacheUtil.removeResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
                LFRuleConditionImpl.class, lfRuleCondition.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f rule condition with the primary key. Does not add the l f rule condition to the database.
     *
     * @param id the primary key for the new l f rule condition
     * @return the new l f rule condition
     */
    @Override
    public LFRuleCondition create(long id) {
        LFRuleCondition lfRuleCondition = new LFRuleConditionImpl();

        lfRuleCondition.setNew(true);
        lfRuleCondition.setPrimaryKey(id);

        return lfRuleCondition;
    }

    /**
     * Removes the l f rule condition with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f rule condition
     * @return the l f rule condition that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition remove(long id)
        throws NoSuchLFRuleConditionException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f rule condition with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f rule condition
     * @return the l f rule condition that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition remove(Serializable primaryKey)
        throws NoSuchLFRuleConditionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRuleCondition lfRuleCondition = (LFRuleCondition) session.get(LFRuleConditionImpl.class,
                    primaryKey);

            if (lfRuleCondition == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRuleConditionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRuleCondition);
        } catch (NoSuchLFRuleConditionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRuleCondition removeImpl(LFRuleCondition lfRuleCondition)
        throws SystemException {
        lfRuleCondition = toUnwrappedModel(lfRuleCondition);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfRuleCondition)) {
                lfRuleCondition = (LFRuleCondition) session.get(LFRuleConditionImpl.class,
                        lfRuleCondition.getPrimaryKeyObj());
            }

            if (lfRuleCondition != null) {
                session.delete(lfRuleCondition);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfRuleCondition != null) {
            clearCache(lfRuleCondition);
        }

        return lfRuleCondition;
    }

    @Override
    public LFRuleCondition updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws SystemException {
        lfRuleCondition = toUnwrappedModel(lfRuleCondition);

        boolean isNew = lfRuleCondition.isNew();

        LFRuleConditionModelImpl lfRuleConditionModelImpl = (LFRuleConditionModelImpl) lfRuleCondition;

        Session session = null;

        try {
            session = openSession();

            if (lfRuleCondition.isNew()) {
                session.save(lfRuleCondition);

                lfRuleCondition.setNew(false);
            } else {
                session.merge(lfRuleCondition);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRuleConditionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfRuleConditionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLLUP.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfRuleConditionModelImpl.getOriginalRollupRuleID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLLUP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLLUP,
                    args);

                args = new Object[] { lfRuleConditionModelImpl.getRollupRuleID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ROLLUP, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ROLLUP,
                    args);
            }

            if ((lfRuleConditionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONDITION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfRuleConditionModelImpl.getOriginalConditionRuleID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONDITION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONDITION,
                    args);

                args = new Object[] {
                        lfRuleConditionModelImpl.getConditionRuleID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONDITION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONDITION,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
            LFRuleConditionImpl.class, lfRuleCondition.getPrimaryKey(),
            lfRuleCondition);

        return lfRuleCondition;
    }

    protected LFRuleCondition toUnwrappedModel(LFRuleCondition lfRuleCondition) {
        if (lfRuleCondition instanceof LFRuleConditionImpl) {
            return lfRuleCondition;
        }

        LFRuleConditionImpl lfRuleConditionImpl = new LFRuleConditionImpl();

        lfRuleConditionImpl.setNew(lfRuleCondition.isNew());
        lfRuleConditionImpl.setPrimaryKey(lfRuleCondition.getPrimaryKey());

        lfRuleConditionImpl.setId(lfRuleCondition.getId());
        lfRuleConditionImpl.setConditionType(lfRuleCondition.getConditionType());
        lfRuleConditionImpl.setObjectiveId(lfRuleCondition.getObjectiveId());
        lfRuleConditionImpl.setMeasureThreshold(lfRuleCondition.getMeasureThreshold());
        lfRuleConditionImpl.setInverse(lfRuleCondition.isInverse());
        lfRuleConditionImpl.setRollupRuleID(lfRuleCondition.getRollupRuleID());
        lfRuleConditionImpl.setConditionRuleID(lfRuleCondition.getConditionRuleID());

        return lfRuleConditionImpl;
    }

    /**
     * Returns the l f rule condition with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f rule condition
     * @return the l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFRuleConditionException, SystemException {
        LFRuleCondition lfRuleCondition = fetchByPrimaryKey(primaryKey);

        if (lfRuleCondition == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFRuleConditionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfRuleCondition;
    }

    /**
     * Returns the l f rule condition with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException} if it could not be found.
     *
     * @param id the primary key of the l f rule condition
     * @return the l f rule condition
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition findByPrimaryKey(long id)
        throws NoSuchLFRuleConditionException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f rule condition with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f rule condition
     * @return the l f rule condition, or <code>null</code> if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFRuleCondition lfRuleCondition = (LFRuleCondition) EntityCacheUtil.getResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
                LFRuleConditionImpl.class, primaryKey);

        if (lfRuleCondition == _nullLFRuleCondition) {
            return null;
        }

        if (lfRuleCondition == null) {
            Session session = null;

            try {
                session = openSession();

                lfRuleCondition = (LFRuleCondition) session.get(LFRuleConditionImpl.class,
                        primaryKey);

                if (lfRuleCondition != null) {
                    cacheResult(lfRuleCondition);
                } else {
                    EntityCacheUtil.putResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
                        LFRuleConditionImpl.class, primaryKey,
                        _nullLFRuleCondition);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFRuleConditionModelImpl.ENTITY_CACHE_ENABLED,
                    LFRuleConditionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfRuleCondition;
    }

    /**
     * Returns the l f rule condition with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f rule condition
     * @return the l f rule condition, or <code>null</code> if a l f rule condition with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRuleCondition fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f rule conditions.
     *
     * @return the l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rule conditions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f rule conditions
     * @param end the upper bound of the range of l f rule conditions (not inclusive)
     * @return the range of l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rule conditions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f rule conditions
     * @param end the upper bound of the range of l f rule conditions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f rule conditions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRuleCondition> findAll(int start, int end,
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

        List<LFRuleCondition> list = (List<LFRuleCondition>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFRULECONDITION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFRULECONDITION;

                if (pagination) {
                    sql = sql.concat(LFRuleConditionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFRuleCondition>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRuleCondition>(list);
                } else {
                    list = (List<LFRuleCondition>) QueryUtil.list(q,
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
     * Removes all the l f rule conditions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFRuleCondition lfRuleCondition : findAll()) {
            remove(lfRuleCondition);
        }
    }

    /**
     * Returns the number of l f rule conditions.
     *
     * @return the number of l f rule conditions
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

                Query q = session.createQuery(_SQL_COUNT_LFRULECONDITION);

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
     * Initializes the l f rule condition persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRuleCondition")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRuleCondition>> listenersList = new ArrayList<ModelListener<LFRuleCondition>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRuleCondition>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRuleConditionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

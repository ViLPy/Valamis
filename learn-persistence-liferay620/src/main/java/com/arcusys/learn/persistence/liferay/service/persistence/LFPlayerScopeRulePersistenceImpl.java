package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException;
import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule;
import com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPlayerScopeRulePersistence;

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
 * The persistence implementation for the l f player scope rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPlayerScopeRulePersistence
 * @see LFPlayerScopeRuleUtil
 * @generated
 */
public class LFPlayerScopeRulePersistenceImpl extends BasePersistenceImpl<LFPlayerScopeRule>
    implements LFPlayerScopeRulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFPlayerScopeRuleUtil} to access the l f player scope rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFPlayerScopeRuleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PLAYERID = new FinderPath(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlayerID",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLAYERID =
        new FinderPath(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleModelImpl.FINDER_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlayerID",
            new String[] { String.class.getName() },
            LFPlayerScopeRuleModelImpl.PLAYERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PLAYERID = new FinderPath(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlayerID",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_PLAYERID_PLAYERID_1 = "lfPlayerScopeRule.playerID IS NULL";
    private static final String _FINDER_COLUMN_PLAYERID_PLAYERID_NULL = "lfPlayerScopeRule.playerID IS NULL";
    private static final String _FINDER_COLUMN_PLAYERID_PLAYERID_2 = "lfPlayerScopeRule.playerID = ?";
    private static final String _FINDER_COLUMN_PLAYERID_PLAYERID_NULL_2 = "lfPlayerScopeRule.playerID IS NULL ";
    private static final String _FINDER_COLUMN_PLAYERID_PLAYERID_3 = "(lfPlayerScopeRule.playerID IS NULL OR lfPlayerScopeRule.playerID = '')";
    private static final String _SQL_SELECT_LFPLAYERSCOPERULE = "SELECT lfPlayerScopeRule FROM LFPlayerScopeRule lfPlayerScopeRule";
    private static final String _SQL_SELECT_LFPLAYERSCOPERULE_WHERE = "SELECT lfPlayerScopeRule FROM LFPlayerScopeRule lfPlayerScopeRule WHERE ";
    private static final String _SQL_COUNT_LFPLAYERSCOPERULE = "SELECT COUNT(lfPlayerScopeRule) FROM LFPlayerScopeRule lfPlayerScopeRule";
    private static final String _SQL_COUNT_LFPLAYERSCOPERULE_WHERE = "SELECT COUNT(lfPlayerScopeRule) FROM LFPlayerScopeRule lfPlayerScopeRule WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfPlayerScopeRule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFPlayerScopeRule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFPlayerScopeRule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFPlayerScopeRulePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFPlayerScopeRule _nullLFPlayerScopeRule = new LFPlayerScopeRuleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFPlayerScopeRule> toCacheModel() {
                return _nullLFPlayerScopeRuleCacheModel;
            }
        };

    private static CacheModel<LFPlayerScopeRule> _nullLFPlayerScopeRuleCacheModel =
        new CacheModel<LFPlayerScopeRule>() {
            @Override
            public LFPlayerScopeRule toEntityModel() {
                return _nullLFPlayerScopeRule;
            }
        };

    public LFPlayerScopeRulePersistenceImpl() {
        setModelClass(LFPlayerScopeRule.class);
    }

    /**
     * Returns all the l f player scope rules where playerID = &#63;.
     *
     * @param playerID the player i d
     * @return the matching l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPlayerScopeRule> findByPlayerID(String playerID)
        throws SystemException {
        return findByPlayerID(playerID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f player scope rules where playerID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param playerID the player i d
     * @param start the lower bound of the range of l f player scope rules
     * @param end the upper bound of the range of l f player scope rules (not inclusive)
     * @return the range of matching l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPlayerScopeRule> findByPlayerID(String playerID, int start,
        int end) throws SystemException {
        return findByPlayerID(playerID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f player scope rules where playerID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param playerID the player i d
     * @param start the lower bound of the range of l f player scope rules
     * @param end the upper bound of the range of l f player scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPlayerScopeRule> findByPlayerID(String playerID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLAYERID;
            finderArgs = new Object[] { playerID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PLAYERID;
            finderArgs = new Object[] { playerID, start, end, orderByComparator };
        }

        List<LFPlayerScopeRule> list = (List<LFPlayerScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPlayerScopeRule lfPlayerScopeRule : list) {
                if (!Validator.equals(playerID, lfPlayerScopeRule.getPlayerID())) {
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

            query.append(_SQL_SELECT_LFPLAYERSCOPERULE_WHERE);

            boolean bindPlayerID = false;

            if (playerID == null) {
                query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_1);
            } else if (playerID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_3);
            } else {
                bindPlayerID = true;

                if (playerID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_3);
                } else {
                    query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPlayerScopeRuleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPlayerID) {
                    if (playerID != null) {
                        qPos.add(playerID);
                    }
                }

                if (!pagination) {
                    list = (List<LFPlayerScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPlayerScopeRule>(list);
                } else {
                    list = (List<LFPlayerScopeRule>) QueryUtil.list(q,
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
     * Returns the first l f player scope rule in the ordered set where playerID = &#63;.
     *
     * @param playerID the player i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f player scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a matching l f player scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule findByPlayerID_First(String playerID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        LFPlayerScopeRule lfPlayerScopeRule = fetchByPlayerID_First(playerID,
                orderByComparator);

        if (lfPlayerScopeRule != null) {
            return lfPlayerScopeRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("playerID=");
        msg.append(playerID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPlayerScopeRuleException(msg.toString());
    }

    /**
     * Returns the first l f player scope rule in the ordered set where playerID = &#63;.
     *
     * @param playerID the player i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f player scope rule, or <code>null</code> if a matching l f player scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule fetchByPlayerID_First(String playerID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPlayerScopeRule> list = findByPlayerID(playerID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f player scope rule in the ordered set where playerID = &#63;.
     *
     * @param playerID the player i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f player scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a matching l f player scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule findByPlayerID_Last(String playerID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        LFPlayerScopeRule lfPlayerScopeRule = fetchByPlayerID_Last(playerID,
                orderByComparator);

        if (lfPlayerScopeRule != null) {
            return lfPlayerScopeRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("playerID=");
        msg.append(playerID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPlayerScopeRuleException(msg.toString());
    }

    /**
     * Returns the last l f player scope rule in the ordered set where playerID = &#63;.
     *
     * @param playerID the player i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f player scope rule, or <code>null</code> if a matching l f player scope rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule fetchByPlayerID_Last(String playerID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPlayerID(playerID);

        if (count == 0) {
            return null;
        }

        List<LFPlayerScopeRule> list = findByPlayerID(playerID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f player scope rules before and after the current l f player scope rule in the ordered set where playerID = &#63;.
     *
     * @param id the primary key of the current l f player scope rule
     * @param playerID the player i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f player scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule[] findByPlayerID_PrevAndNext(long id,
        String playerID, OrderByComparator orderByComparator)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        LFPlayerScopeRule lfPlayerScopeRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPlayerScopeRule[] array = new LFPlayerScopeRuleImpl[3];

            array[0] = getByPlayerID_PrevAndNext(session, lfPlayerScopeRule,
                    playerID, orderByComparator, true);

            array[1] = lfPlayerScopeRule;

            array[2] = getByPlayerID_PrevAndNext(session, lfPlayerScopeRule,
                    playerID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPlayerScopeRule getByPlayerID_PrevAndNext(Session session,
        LFPlayerScopeRule lfPlayerScopeRule, String playerID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPLAYERSCOPERULE_WHERE);

        boolean bindPlayerID = false;

        if (playerID == null) {
            query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_1);
        } else if (playerID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_3);
        } else {
            bindPlayerID = true;

            if (playerID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_3);
            } else {
                query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_2);
            }
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
            query.append(LFPlayerScopeRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindPlayerID) {
            if (playerID != null) {
                qPos.add(playerID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPlayerScopeRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPlayerScopeRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f player scope rules where playerID = &#63; from the database.
     *
     * @param playerID the player i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPlayerID(String playerID) throws SystemException {
        for (LFPlayerScopeRule lfPlayerScopeRule : findByPlayerID(playerID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfPlayerScopeRule);
        }
    }

    /**
     * Returns the number of l f player scope rules where playerID = &#63;.
     *
     * @param playerID the player i d
     * @return the number of matching l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPlayerID(String playerID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PLAYERID;

        Object[] finderArgs = new Object[] { playerID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFPLAYERSCOPERULE_WHERE);

            boolean bindPlayerID = false;

            if (playerID == null) {
                query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_1);
            } else if (playerID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_3);
            } else {
                bindPlayerID = true;

                if (playerID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_3);
                } else {
                    query.append(_FINDER_COLUMN_PLAYERID_PLAYERID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindPlayerID) {
                    if (playerID != null) {
                        qPos.add(playerID);
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
     * Caches the l f player scope rule in the entity cache if it is enabled.
     *
     * @param lfPlayerScopeRule the l f player scope rule
     */
    @Override
    public void cacheResult(LFPlayerScopeRule lfPlayerScopeRule) {
        EntityCacheUtil.putResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class, lfPlayerScopeRule.getPrimaryKey(),
            lfPlayerScopeRule);

        lfPlayerScopeRule.resetOriginalValues();
    }

    /**
     * Caches the l f player scope rules in the entity cache if it is enabled.
     *
     * @param lfPlayerScopeRules the l f player scope rules
     */
    @Override
    public void cacheResult(List<LFPlayerScopeRule> lfPlayerScopeRules) {
        for (LFPlayerScopeRule lfPlayerScopeRule : lfPlayerScopeRules) {
            if (EntityCacheUtil.getResult(
                        LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFPlayerScopeRuleImpl.class,
                        lfPlayerScopeRule.getPrimaryKey()) == null) {
                cacheResult(lfPlayerScopeRule);
            } else {
                lfPlayerScopeRule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f player scope rules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFPlayerScopeRuleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFPlayerScopeRuleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f player scope rule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFPlayerScopeRule lfPlayerScopeRule) {
        EntityCacheUtil.removeResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class, lfPlayerScopeRule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFPlayerScopeRule> lfPlayerScopeRules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFPlayerScopeRule lfPlayerScopeRule : lfPlayerScopeRules) {
            EntityCacheUtil.removeResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFPlayerScopeRuleImpl.class, lfPlayerScopeRule.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f player scope rule with the primary key. Does not add the l f player scope rule to the database.
     *
     * @param id the primary key for the new l f player scope rule
     * @return the new l f player scope rule
     */
    @Override
    public LFPlayerScopeRule create(long id) {
        LFPlayerScopeRule lfPlayerScopeRule = new LFPlayerScopeRuleImpl();

        lfPlayerScopeRule.setNew(true);
        lfPlayerScopeRule.setPrimaryKey(id);

        return lfPlayerScopeRule;
    }

    /**
     * Removes the l f player scope rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f player scope rule
     * @return the l f player scope rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule remove(long id)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f player scope rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f player scope rule
     * @return the l f player scope rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule remove(Serializable primaryKey)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFPlayerScopeRule lfPlayerScopeRule = (LFPlayerScopeRule) session.get(LFPlayerScopeRuleImpl.class,
                    primaryKey);

            if (lfPlayerScopeRule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFPlayerScopeRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfPlayerScopeRule);
        } catch (NoSuchLFPlayerScopeRuleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFPlayerScopeRule removeImpl(LFPlayerScopeRule lfPlayerScopeRule)
        throws SystemException {
        lfPlayerScopeRule = toUnwrappedModel(lfPlayerScopeRule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfPlayerScopeRule)) {
                lfPlayerScopeRule = (LFPlayerScopeRule) session.get(LFPlayerScopeRuleImpl.class,
                        lfPlayerScopeRule.getPrimaryKeyObj());
            }

            if (lfPlayerScopeRule != null) {
                session.delete(lfPlayerScopeRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfPlayerScopeRule != null) {
            clearCache(lfPlayerScopeRule);
        }

        return lfPlayerScopeRule;
    }

    @Override
    public LFPlayerScopeRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule)
        throws SystemException {
        lfPlayerScopeRule = toUnwrappedModel(lfPlayerScopeRule);

        boolean isNew = lfPlayerScopeRule.isNew();

        LFPlayerScopeRuleModelImpl lfPlayerScopeRuleModelImpl = (LFPlayerScopeRuleModelImpl) lfPlayerScopeRule;

        Session session = null;

        try {
            session = openSession();

            if (lfPlayerScopeRule.isNew()) {
                session.save(lfPlayerScopeRule);

                lfPlayerScopeRule.setNew(false);
            } else {
                session.merge(lfPlayerScopeRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFPlayerScopeRuleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfPlayerScopeRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLAYERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPlayerScopeRuleModelImpl.getOriginalPlayerID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLAYERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLAYERID,
                    args);

                args = new Object[] { lfPlayerScopeRuleModelImpl.getPlayerID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PLAYERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PLAYERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFPlayerScopeRuleImpl.class, lfPlayerScopeRule.getPrimaryKey(),
            lfPlayerScopeRule);

        return lfPlayerScopeRule;
    }

    protected LFPlayerScopeRule toUnwrappedModel(
        LFPlayerScopeRule lfPlayerScopeRule) {
        if (lfPlayerScopeRule instanceof LFPlayerScopeRuleImpl) {
            return lfPlayerScopeRule;
        }

        LFPlayerScopeRuleImpl lfPlayerScopeRuleImpl = new LFPlayerScopeRuleImpl();

        lfPlayerScopeRuleImpl.setNew(lfPlayerScopeRule.isNew());
        lfPlayerScopeRuleImpl.setPrimaryKey(lfPlayerScopeRule.getPrimaryKey());

        lfPlayerScopeRuleImpl.setId(lfPlayerScopeRule.getId());
        lfPlayerScopeRuleImpl.setPlayerID(lfPlayerScopeRule.getPlayerID());
        lfPlayerScopeRuleImpl.setScope(lfPlayerScopeRule.getScope());

        return lfPlayerScopeRuleImpl;
    }

    /**
     * Returns the l f player scope rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f player scope rule
     * @return the l f player scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        LFPlayerScopeRule lfPlayerScopeRule = fetchByPrimaryKey(primaryKey);

        if (lfPlayerScopeRule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFPlayerScopeRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfPlayerScopeRule;
    }

    /**
     * Returns the l f player scope rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException} if it could not be found.
     *
     * @param id the primary key of the l f player scope rule
     * @return the l f player scope rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule findByPrimaryKey(long id)
        throws NoSuchLFPlayerScopeRuleException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f player scope rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f player scope rule
     * @return the l f player scope rule, or <code>null</code> if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFPlayerScopeRule lfPlayerScopeRule = (LFPlayerScopeRule) EntityCacheUtil.getResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFPlayerScopeRuleImpl.class, primaryKey);

        if (lfPlayerScopeRule == _nullLFPlayerScopeRule) {
            return null;
        }

        if (lfPlayerScopeRule == null) {
            Session session = null;

            try {
                session = openSession();

                lfPlayerScopeRule = (LFPlayerScopeRule) session.get(LFPlayerScopeRuleImpl.class,
                        primaryKey);

                if (lfPlayerScopeRule != null) {
                    cacheResult(lfPlayerScopeRule);
                } else {
                    EntityCacheUtil.putResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFPlayerScopeRuleImpl.class, primaryKey,
                        _nullLFPlayerScopeRule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFPlayerScopeRuleModelImpl.ENTITY_CACHE_ENABLED,
                    LFPlayerScopeRuleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfPlayerScopeRule;
    }

    /**
     * Returns the l f player scope rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f player scope rule
     * @return the l f player scope rule, or <code>null</code> if a l f player scope rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPlayerScopeRule fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f player scope rules.
     *
     * @return the l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPlayerScopeRule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f player scope rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f player scope rules
     * @param end the upper bound of the range of l f player scope rules (not inclusive)
     * @return the range of l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPlayerScopeRule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f player scope rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f player scope rules
     * @param end the upper bound of the range of l f player scope rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f player scope rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPlayerScopeRule> findAll(int start, int end,
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

        List<LFPlayerScopeRule> list = (List<LFPlayerScopeRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFPLAYERSCOPERULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFPLAYERSCOPERULE;

                if (pagination) {
                    sql = sql.concat(LFPlayerScopeRuleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFPlayerScopeRule>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPlayerScopeRule>(list);
                } else {
                    list = (List<LFPlayerScopeRule>) QueryUtil.list(q,
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
     * Removes all the l f player scope rules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFPlayerScopeRule lfPlayerScopeRule : findAll()) {
            remove(lfPlayerScopeRule);
        }
    }

    /**
     * Returns the number of l f player scope rules.
     *
     * @return the number of l f player scope rules
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

                Query q = session.createQuery(_SQL_COUNT_LFPLAYERSCOPERULE);

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
     * Initializes the l f player scope rule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFPlayerScopeRule>> listenersList = new ArrayList<ModelListener<LFPlayerScopeRule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFPlayerScopeRule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFPlayerScopeRuleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

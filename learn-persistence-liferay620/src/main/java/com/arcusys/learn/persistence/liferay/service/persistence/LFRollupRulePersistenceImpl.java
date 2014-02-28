package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException;
import com.arcusys.learn.persistence.liferay.model.LFRollupRule;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRollupRulePersistence;

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
 * The persistence implementation for the l f rollup rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupRulePersistence
 * @see LFRollupRuleUtil
 * @generated
 */
public class LFRollupRulePersistenceImpl extends BasePersistenceImpl<LFRollupRule>
    implements LFRollupRulePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRollupRuleUtil} to access the l f rollup rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRollupRuleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySequencingID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, LFRollupRuleImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequencingID",
            new String[] { Integer.class.getName() },
            LFRollupRuleModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfRollupRule.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfRollupRule.sequencingID = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfRollupRule.sequencingID IS NULL ";
    private static final String _SQL_SELECT_LFROLLUPRULE = "SELECT lfRollupRule FROM LFRollupRule lfRollupRule";
    private static final String _SQL_SELECT_LFROLLUPRULE_WHERE = "SELECT lfRollupRule FROM LFRollupRule lfRollupRule WHERE ";
    private static final String _SQL_COUNT_LFROLLUPRULE = "SELECT COUNT(lfRollupRule) FROM LFRollupRule lfRollupRule";
    private static final String _SQL_COUNT_LFROLLUPRULE_WHERE = "SELECT COUNT(lfRollupRule) FROM LFRollupRule lfRollupRule WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRollupRule.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRollupRule exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRollupRule exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRollupRulePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFRollupRule _nullLFRollupRule = new LFRollupRuleImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRollupRule> toCacheModel() {
                return _nullLFRollupRuleCacheModel;
            }
        };

    private static CacheModel<LFRollupRule> _nullLFRollupRuleCacheModel = new CacheModel<LFRollupRule>() {
            @Override
            public LFRollupRule toEntityModel() {
                return _nullLFRollupRule;
            }
        };

    public LFRollupRulePersistenceImpl() {
        setModelClass(LFRollupRule.class);
    }

    /**
     * Returns all the l f rollup rules where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupRule> findBySequencingID(Integer sequencingID)
        throws SystemException {
        return findBySequencingID(sequencingID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rollup rules where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @return the range of matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupRule> findBySequencingID(Integer sequencingID,
        int start, int end) throws SystemException {
        return findBySequencingID(sequencingID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rollup rules where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupRule> findBySequencingID(Integer sequencingID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] { sequencingID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] {
                    sequencingID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFRollupRule> list = (List<LFRollupRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRollupRule lfRollupRule : list) {
                if (!Validator.equals(sequencingID,
                            lfRollupRule.getSequencingID())) {
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

            query.append(_SQL_SELECT_LFROLLUPRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFRollupRuleModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (!pagination) {
                    list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRollupRule>(list);
                } else {
                    list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule findBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = fetchBySequencingID_First(sequencingID,
                orderByComparator);

        if (lfRollupRule != null) {
            return lfRollupRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRollupRuleException(msg.toString());
    }

    /**
     * Returns the first l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f rollup rule, or <code>null</code> if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule fetchBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFRollupRule> list = findBySequencingID(sequencingID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule findBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = fetchBySequencingID_Last(sequencingID,
                orderByComparator);

        if (lfRollupRule != null) {
            return lfRollupRule;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRollupRuleException(msg.toString());
    }

    /**
     * Returns the last l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f rollup rule, or <code>null</code> if a matching l f rollup rule could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule fetchBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingID(sequencingID);

        if (count == 0) {
            return null;
        }

        List<LFRollupRule> list = findBySequencingID(sequencingID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f rollup rules before and after the current l f rollup rule in the ordered set where sequencingID = &#63;.
     *
     * @param id the primary key of the current l f rollup rule
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule[] findBySequencingID_PrevAndNext(long id,
        Integer sequencingID, OrderByComparator orderByComparator)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRollupRule[] array = new LFRollupRuleImpl[3];

            array[0] = getBySequencingID_PrevAndNext(session, lfRollupRule,
                    sequencingID, orderByComparator, true);

            array[1] = lfRollupRule;

            array[2] = getBySequencingID_PrevAndNext(session, lfRollupRule,
                    sequencingID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRollupRule getBySequencingID_PrevAndNext(Session session,
        LFRollupRule lfRollupRule, Integer sequencingID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFROLLUPRULE_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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
            query.append(LFRollupRuleModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfRollupRule);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRollupRule> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f rollup rules where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySequencingID(Integer sequencingID)
        throws SystemException {
        for (LFRollupRule lfRollupRule : findBySequencingID(sequencingID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfRollupRule);
        }
    }

    /**
     * Returns the number of l f rollup rules where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGID;

        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFROLLUPRULE_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
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
     * Caches the l f rollup rule in the entity cache if it is enabled.
     *
     * @param lfRollupRule the l f rollup rule
     */
    @Override
    public void cacheResult(LFRollupRule lfRollupRule) {
        EntityCacheUtil.putResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey(), lfRollupRule);

        lfRollupRule.resetOriginalValues();
    }

    /**
     * Caches the l f rollup rules in the entity cache if it is enabled.
     *
     * @param lfRollupRules the l f rollup rules
     */
    @Override
    public void cacheResult(List<LFRollupRule> lfRollupRules) {
        for (LFRollupRule lfRollupRule : lfRollupRules) {
            if (EntityCacheUtil.getResult(
                        LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey()) == null) {
                cacheResult(lfRollupRule);
            } else {
                lfRollupRule.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f rollup rules.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRollupRuleImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRollupRuleImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f rollup rule.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRollupRule lfRollupRule) {
        EntityCacheUtil.removeResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFRollupRule> lfRollupRules) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRollupRule lfRollupRule : lfRollupRules) {
            EntityCacheUtil.removeResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f rollup rule with the primary key. Does not add the l f rollup rule to the database.
     *
     * @param id the primary key for the new l f rollup rule
     * @return the new l f rollup rule
     */
    @Override
    public LFRollupRule create(long id) {
        LFRollupRule lfRollupRule = new LFRollupRuleImpl();

        lfRollupRule.setNew(true);
        lfRollupRule.setPrimaryKey(id);

        return lfRollupRule;
    }

    /**
     * Removes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f rollup rule
     * @return the l f rollup rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule remove(long id)
        throws NoSuchLFRollupRuleException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f rollup rule
     * @return the l f rollup rule that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule remove(Serializable primaryKey)
        throws NoSuchLFRollupRuleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRollupRule lfRollupRule = (LFRollupRule) session.get(LFRollupRuleImpl.class,
                    primaryKey);

            if (lfRollupRule == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRollupRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRollupRule);
        } catch (NoSuchLFRollupRuleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRollupRule removeImpl(LFRollupRule lfRollupRule)
        throws SystemException {
        lfRollupRule = toUnwrappedModel(lfRollupRule);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfRollupRule)) {
                lfRollupRule = (LFRollupRule) session.get(LFRollupRuleImpl.class,
                        lfRollupRule.getPrimaryKeyObj());
            }

            if (lfRollupRule != null) {
                session.delete(lfRollupRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfRollupRule != null) {
            clearCache(lfRollupRule);
        }

        return lfRollupRule;
    }

    @Override
    public LFRollupRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws SystemException {
        lfRollupRule = toUnwrappedModel(lfRollupRule);

        boolean isNew = lfRollupRule.isNew();

        LFRollupRuleModelImpl lfRollupRuleModelImpl = (LFRollupRuleModelImpl) lfRollupRule;

        Session session = null;

        try {
            session = openSession();

            if (lfRollupRule.isNew()) {
                session.save(lfRollupRule);

                lfRollupRule.setNew(false);
            } else {
                session.merge(lfRollupRule);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRollupRuleModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfRollupRuleModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfRollupRuleModelImpl.getOriginalSequencingID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);

                args = new Object[] { lfRollupRuleModelImpl.getSequencingID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
            LFRollupRuleImpl.class, lfRollupRule.getPrimaryKey(), lfRollupRule);

        return lfRollupRule;
    }

    protected LFRollupRule toUnwrappedModel(LFRollupRule lfRollupRule) {
        if (lfRollupRule instanceof LFRollupRuleImpl) {
            return lfRollupRule;
        }

        LFRollupRuleImpl lfRollupRuleImpl = new LFRollupRuleImpl();

        lfRollupRuleImpl.setNew(lfRollupRule.isNew());
        lfRollupRuleImpl.setPrimaryKey(lfRollupRule.getPrimaryKey());

        lfRollupRuleImpl.setId(lfRollupRule.getId());
        lfRollupRuleImpl.setSequencingID(lfRollupRule.getSequencingID());
        lfRollupRuleImpl.setCombination(lfRollupRule.getCombination());
        lfRollupRuleImpl.setChildActivitySet(lfRollupRule.getChildActivitySet());
        lfRollupRuleImpl.setMinimumCount(lfRollupRule.getMinimumCount());
        lfRollupRuleImpl.setMinimumPercent(lfRollupRule.getMinimumPercent());
        lfRollupRuleImpl.setAction(lfRollupRule.getAction());

        return lfRollupRuleImpl;
    }

    /**
     * Returns the l f rollup rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup rule
     * @return the l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFRollupRuleException, SystemException {
        LFRollupRule lfRollupRule = fetchByPrimaryKey(primaryKey);

        if (lfRollupRule == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFRollupRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfRollupRule;
    }

    /**
     * Returns the l f rollup rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException} if it could not be found.
     *
     * @param id the primary key of the l f rollup rule
     * @return the l f rollup rule
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule findByPrimaryKey(long id)
        throws NoSuchLFRollupRuleException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f rollup rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f rollup rule
     * @return the l f rollup rule, or <code>null</code> if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFRollupRule lfRollupRule = (LFRollupRule) EntityCacheUtil.getResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                LFRollupRuleImpl.class, primaryKey);

        if (lfRollupRule == _nullLFRollupRule) {
            return null;
        }

        if (lfRollupRule == null) {
            Session session = null;

            try {
                session = openSession();

                lfRollupRule = (LFRollupRule) session.get(LFRollupRuleImpl.class,
                        primaryKey);

                if (lfRollupRule != null) {
                    cacheResult(lfRollupRule);
                } else {
                    EntityCacheUtil.putResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                        LFRollupRuleImpl.class, primaryKey, _nullLFRollupRule);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFRollupRuleModelImpl.ENTITY_CACHE_ENABLED,
                    LFRollupRuleImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfRollupRule;
    }

    /**
     * Returns the l f rollup rule with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f rollup rule
     * @return the l f rollup rule, or <code>null</code> if a l f rollup rule with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRollupRule fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f rollup rules.
     *
     * @return the l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupRule> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f rollup rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @return the range of l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupRule> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f rollup rules.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f rollup rules
     * @param end the upper bound of the range of l f rollup rules (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f rollup rules
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRollupRule> findAll(int start, int end,
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

        List<LFRollupRule> list = (List<LFRollupRule>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFROLLUPRULE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFROLLUPRULE;

                if (pagination) {
                    sql = sql.concat(LFRollupRuleModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRollupRule>(list);
                } else {
                    list = (List<LFRollupRule>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f rollup rules from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFRollupRule lfRollupRule : findAll()) {
            remove(lfRollupRule);
        }
    }

    /**
     * Returns the number of l f rollup rules.
     *
     * @return the number of l f rollup rules
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

                Query q = session.createQuery(_SQL_COUNT_LFROLLUPRULE);

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
     * Initializes the l f rollup rule persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRollupRule")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRollupRule>> listenersList = new ArrayList<ModelListener<LFRollupRule>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRollupRule>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRollupRuleImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

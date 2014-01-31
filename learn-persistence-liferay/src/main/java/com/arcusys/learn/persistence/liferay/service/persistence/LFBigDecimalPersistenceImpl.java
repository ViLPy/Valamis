package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException;
import com.arcusys.learn.persistence.liferay.model.LFBigDecimal;
import com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFBigDecimalPersistence;

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

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the l f big decimal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFBigDecimalPersistence
 * @see LFBigDecimalUtil
 * @generated
 */
public class LFBigDecimalPersistenceImpl extends BasePersistenceImpl<LFBigDecimal>
    implements LFBigDecimalPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFBigDecimalUtil} to access the l f big decimal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFBigDecimalImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DECIMAL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDecimal",
            new String[] {
                BigDecimal.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL =
        new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, LFBigDecimalImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDecimal",
            new String[] { BigDecimal.class.getName() },
            LFBigDecimalModelImpl.DECIMAL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DECIMAL = new FinderPath(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDecimal",
            new String[] { BigDecimal.class.getName() });
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_1 = "lfBigDecimal.decimal IS NULL";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_NULL = "lfBigDecimal.decimal IS NULL";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_2 = "lfBigDecimal.decimal = ?";
    private static final String _FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2 = "lfBigDecimal.decimal IS NULL ";
    private static final String _SQL_SELECT_LFBIGDECIMAL = "SELECT lfBigDecimal FROM LFBigDecimal lfBigDecimal";
    private static final String _SQL_SELECT_LFBIGDECIMAL_WHERE = "SELECT lfBigDecimal FROM LFBigDecimal lfBigDecimal WHERE ";
    private static final String _SQL_COUNT_LFBIGDECIMAL = "SELECT COUNT(lfBigDecimal) FROM LFBigDecimal lfBigDecimal";
    private static final String _SQL_COUNT_LFBIGDECIMAL_WHERE = "SELECT COUNT(lfBigDecimal) FROM LFBigDecimal lfBigDecimal WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfBigDecimal.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFBigDecimal exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFBigDecimal exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFBigDecimalPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "decimal", "text"
            });
    private static LFBigDecimal _nullLFBigDecimal = new LFBigDecimalImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFBigDecimal> toCacheModel() {
                return _nullLFBigDecimalCacheModel;
            }
        };

    private static CacheModel<LFBigDecimal> _nullLFBigDecimalCacheModel = new CacheModel<LFBigDecimal>() {
            @Override
            public LFBigDecimal toEntityModel() {
                return _nullLFBigDecimal;
            }
        };

    public LFBigDecimalPersistenceImpl() {
        setModelClass(LFBigDecimal.class);
    }

    /**
     * Returns all the l f big decimals where decimal = &#63;.
     *
     * @param decimal the decimal
     * @return the matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFBigDecimal> findByDecimal(BigDecimal decimal)
        throws SystemException {
        return findByDecimal(decimal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f big decimals where decimal = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param decimal the decimal
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @return the range of matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFBigDecimal> findByDecimal(BigDecimal decimal, int start,
        int end) throws SystemException {
        return findByDecimal(decimal, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f big decimals where decimal = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param decimal the decimal
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFBigDecimal> findByDecimal(BigDecimal decimal, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL;
            finderArgs = new Object[] { decimal };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DECIMAL;
            finderArgs = new Object[] { decimal, start, end, orderByComparator };
        }

        List<LFBigDecimal> list = (List<LFBigDecimal>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFBigDecimal lfBigDecimal : list) {
                if (!Validator.equals(decimal, lfBigDecimal.getDecimal())) {
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

            query.append(_SQL_SELECT_LFBIGDECIMAL_WHERE);

            boolean bindDecimal = false;

            if (decimal == null) {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_1);
            } else {
                bindDecimal = true;

                if (decimal == null) {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2);
                } else {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFBigDecimalModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDecimal) {
                    if (decimal != null) {
                        qPos.add(decimal);
                    }
                }

                if (!pagination) {
                    list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFBigDecimal>(list);
                } else {
                    list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal findByDecimal_First(BigDecimal decimal,
        OrderByComparator orderByComparator)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = fetchByDecimal_First(decimal,
                orderByComparator);

        if (lfBigDecimal != null) {
            return lfBigDecimal;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("decimal=");
        msg.append(decimal);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFBigDecimalException(msg.toString());
    }

    /**
     * Returns the first l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f big decimal, or <code>null</code> if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal fetchByDecimal_First(BigDecimal decimal,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFBigDecimal> list = findByDecimal(decimal, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal findByDecimal_Last(BigDecimal decimal,
        OrderByComparator orderByComparator)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = fetchByDecimal_Last(decimal,
                orderByComparator);

        if (lfBigDecimal != null) {
            return lfBigDecimal;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("decimal=");
        msg.append(decimal);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFBigDecimalException(msg.toString());
    }

    /**
     * Returns the last l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f big decimal, or <code>null</code> if a matching l f big decimal could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal fetchByDecimal_Last(BigDecimal decimal,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDecimal(decimal);

        if (count == 0) {
            return null;
        }

        List<LFBigDecimal> list = findByDecimal(decimal, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f big decimals before and after the current l f big decimal in the ordered set where decimal = &#63;.
     *
     * @param id the primary key of the current l f big decimal
     * @param decimal the decimal
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal[] findByDecimal_PrevAndNext(long id,
        BigDecimal decimal, OrderByComparator orderByComparator)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFBigDecimal[] array = new LFBigDecimalImpl[3];

            array[0] = getByDecimal_PrevAndNext(session, lfBigDecimal, decimal,
                    orderByComparator, true);

            array[1] = lfBigDecimal;

            array[2] = getByDecimal_PrevAndNext(session, lfBigDecimal, decimal,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFBigDecimal getByDecimal_PrevAndNext(Session session,
        LFBigDecimal lfBigDecimal, BigDecimal decimal,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFBIGDECIMAL_WHERE);

        boolean bindDecimal = false;

        if (decimal == null) {
            query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_1);
        } else {
            bindDecimal = true;

            if (decimal == null) {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_2);
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
            query.append(LFBigDecimalModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindDecimal) {
            if (decimal != null) {
                qPos.add(decimal);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfBigDecimal);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFBigDecimal> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f big decimals where decimal = &#63; from the database.
     *
     * @param decimal the decimal
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDecimal(BigDecimal decimal) throws SystemException {
        for (LFBigDecimal lfBigDecimal : findByDecimal(decimal,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfBigDecimal);
        }
    }

    /**
     * Returns the number of l f big decimals where decimal = &#63;.
     *
     * @param decimal the decimal
     * @return the number of matching l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDecimal(BigDecimal decimal) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DECIMAL;

        Object[] finderArgs = new Object[] { decimal };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFBIGDECIMAL_WHERE);

            boolean bindDecimal = false;

            if (decimal == null) {
                query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_1);
            } else {
                bindDecimal = true;

                if (decimal == null) {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_NULL_2);
                } else {
                    query.append(_FINDER_COLUMN_DECIMAL_DECIMAL_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDecimal) {
                    if (decimal != null) {
                        qPos.add(decimal);
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
     * Caches the l f big decimal in the entity cache if it is enabled.
     *
     * @param lfBigDecimal the l f big decimal
     */
    @Override
    public void cacheResult(LFBigDecimal lfBigDecimal) {
        EntityCacheUtil.putResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey(), lfBigDecimal);

        lfBigDecimal.resetOriginalValues();
    }

    /**
     * Caches the l f big decimals in the entity cache if it is enabled.
     *
     * @param lfBigDecimals the l f big decimals
     */
    @Override
    public void cacheResult(List<LFBigDecimal> lfBigDecimals) {
        for (LFBigDecimal lfBigDecimal : lfBigDecimals) {
            if (EntityCacheUtil.getResult(
                        LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                        LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey()) == null) {
                cacheResult(lfBigDecimal);
            } else {
                lfBigDecimal.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f big decimals.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFBigDecimalImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFBigDecimalImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f big decimal.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFBigDecimal lfBigDecimal) {
        EntityCacheUtil.removeResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFBigDecimal> lfBigDecimals) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFBigDecimal lfBigDecimal : lfBigDecimals) {
            EntityCacheUtil.removeResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f big decimal with the primary key. Does not add the l f big decimal to the database.
     *
     * @param id the primary key for the new l f big decimal
     * @return the new l f big decimal
     */
    @Override
    public LFBigDecimal create(long id) {
        LFBigDecimal lfBigDecimal = new LFBigDecimalImpl();

        lfBigDecimal.setNew(true);
        lfBigDecimal.setPrimaryKey(id);

        return lfBigDecimal;
    }

    /**
     * Removes the l f big decimal with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f big decimal
     * @return the l f big decimal that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal remove(long id)
        throws NoSuchLFBigDecimalException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f big decimal with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f big decimal
     * @return the l f big decimal that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal remove(Serializable primaryKey)
        throws NoSuchLFBigDecimalException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFBigDecimal lfBigDecimal = (LFBigDecimal) session.get(LFBigDecimalImpl.class,
                    primaryKey);

            if (lfBigDecimal == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFBigDecimalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfBigDecimal);
        } catch (NoSuchLFBigDecimalException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFBigDecimal removeImpl(LFBigDecimal lfBigDecimal)
        throws SystemException {
        lfBigDecimal = toUnwrappedModel(lfBigDecimal);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfBigDecimal)) {
                lfBigDecimal = (LFBigDecimal) session.get(LFBigDecimalImpl.class,
                        lfBigDecimal.getPrimaryKeyObj());
            }

            if (lfBigDecimal != null) {
                session.delete(lfBigDecimal);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfBigDecimal != null) {
            clearCache(lfBigDecimal);
        }

        return lfBigDecimal;
    }

    @Override
    public LFBigDecimal updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFBigDecimal lfBigDecimal)
        throws SystemException {
        lfBigDecimal = toUnwrappedModel(lfBigDecimal);

        boolean isNew = lfBigDecimal.isNew();

        LFBigDecimalModelImpl lfBigDecimalModelImpl = (LFBigDecimalModelImpl) lfBigDecimal;

        Session session = null;

        try {
            session = openSession();

            if (lfBigDecimal.isNew()) {
                session.save(lfBigDecimal);

                lfBigDecimal.setNew(false);
            } else {
                session.merge(lfBigDecimal);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFBigDecimalModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfBigDecimalModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfBigDecimalModelImpl.getOriginalDecimal()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DECIMAL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL,
                    args);

                args = new Object[] { lfBigDecimalModelImpl.getDecimal() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DECIMAL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DECIMAL,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
            LFBigDecimalImpl.class, lfBigDecimal.getPrimaryKey(), lfBigDecimal);

        return lfBigDecimal;
    }

    protected LFBigDecimal toUnwrappedModel(LFBigDecimal lfBigDecimal) {
        if (lfBigDecimal instanceof LFBigDecimalImpl) {
            return lfBigDecimal;
        }

        LFBigDecimalImpl lfBigDecimalImpl = new LFBigDecimalImpl();

        lfBigDecimalImpl.setNew(lfBigDecimal.isNew());
        lfBigDecimalImpl.setPrimaryKey(lfBigDecimal.getPrimaryKey());

        lfBigDecimalImpl.setId(lfBigDecimal.getId());
        lfBigDecimalImpl.setDecimal(lfBigDecimal.getDecimal());
        lfBigDecimalImpl.setText(lfBigDecimal.getText());

        return lfBigDecimalImpl;
    }

    /**
     * Returns the l f big decimal with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f big decimal
     * @return the l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFBigDecimalException, SystemException {
        LFBigDecimal lfBigDecimal = fetchByPrimaryKey(primaryKey);

        if (lfBigDecimal == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFBigDecimalException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfBigDecimal;
    }

    /**
     * Returns the l f big decimal with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException} if it could not be found.
     *
     * @param id the primary key of the l f big decimal
     * @return the l f big decimal
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFBigDecimalException if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal findByPrimaryKey(long id)
        throws NoSuchLFBigDecimalException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f big decimal with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f big decimal
     * @return the l f big decimal, or <code>null</code> if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFBigDecimal lfBigDecimal = (LFBigDecimal) EntityCacheUtil.getResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                LFBigDecimalImpl.class, primaryKey);

        if (lfBigDecimal == _nullLFBigDecimal) {
            return null;
        }

        if (lfBigDecimal == null) {
            Session session = null;

            try {
                session = openSession();

                lfBigDecimal = (LFBigDecimal) session.get(LFBigDecimalImpl.class,
                        primaryKey);

                if (lfBigDecimal != null) {
                    cacheResult(lfBigDecimal);
                } else {
                    EntityCacheUtil.putResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                        LFBigDecimalImpl.class, primaryKey, _nullLFBigDecimal);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFBigDecimalModelImpl.ENTITY_CACHE_ENABLED,
                    LFBigDecimalImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfBigDecimal;
    }

    /**
     * Returns the l f big decimal with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f big decimal
     * @return the l f big decimal, or <code>null</code> if a l f big decimal with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFBigDecimal fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f big decimals.
     *
     * @return the l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFBigDecimal> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f big decimals.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @return the range of l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFBigDecimal> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f big decimals.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFBigDecimalModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f big decimals
     * @param end the upper bound of the range of l f big decimals (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f big decimals
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFBigDecimal> findAll(int start, int end,
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

        List<LFBigDecimal> list = (List<LFBigDecimal>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFBIGDECIMAL);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFBIGDECIMAL;

                if (pagination) {
                    sql = sql.concat(LFBigDecimalModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFBigDecimal>(list);
                } else {
                    list = (List<LFBigDecimal>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f big decimals from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFBigDecimal lfBigDecimal : findAll()) {
            remove(lfBigDecimal);
        }
    }

    /**
     * Returns the number of l f big decimals.
     *
     * @return the number of l f big decimals
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

                Query q = session.createQuery(_SQL_COUNT_LFBIGDECIMAL);

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
     * Initializes the l f big decimal persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFBigDecimal")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFBigDecimal>> listenersList = new ArrayList<ModelListener<LFBigDecimal>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFBigDecimal>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFBigDecimalImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

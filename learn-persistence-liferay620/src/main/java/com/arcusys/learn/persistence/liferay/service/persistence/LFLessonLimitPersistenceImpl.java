package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException;
import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;
import com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPersistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
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

/**
 * The persistence implementation for the l f lesson limit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLessonLimitPersistence
 * @see LFLessonLimitUtil
 * @generated
 */
public class LFLessonLimitPersistenceImpl extends BasePersistenceImpl<LFLessonLimit>
    implements LFLessonLimitPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFLessonLimitUtil} to access the l f lesson limit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFLessonLimitImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED,
            LFLessonLimitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED,
            LFLessonLimitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IDS = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED,
            LFLessonLimitImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByIDs",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDS = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED,
            LFLessonLimitImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByIDs", new String[] { Long.class.getName() },
            LFLessonLimitModelImpl.ITEMID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_IDS = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIDs",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_IDS = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByIDs",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_IDS_ITEMID_NULL = "lfLessonLimit.itemID IS NULL";
    private static final String _FINDER_COLUMN_IDS_ITEMID_2 = "lfLessonLimit.id.itemID = ?";
    private static final String _FINDER_COLUMN_IDS_ITEMID_NULL_2 = "lfLessonLimit.itemID IS NULL ";
    private static final String _FINDER_COLUMN_IDS_ITEMID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_IDS_ITEMID_2) + ")";
    private static final String _FINDER_COLUMN_IDS_ITEMID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_IDS_ITEMID_NULL_2) + ")";
    public static final FinderPath FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED,
            LFLessonLimitImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByItemIDAndItemType",
            new String[] { Long.class.getName(), String.class.getName() },
            LFLessonLimitModelImpl.ITEMID_COLUMN_BITMASK |
            LFLessonLimitModelImpl.ITEMTYPE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ITEMIDANDITEMTYPE = new FinderPath(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByItemIDAndItemType",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_NULL = "lfLessonLimit.itemID IS NULL";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_2 = "lfLessonLimit.id.itemID = ? AND ";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_NULL_2 = "lfLessonLimit.itemID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_1 = "lfLessonLimit.id.itemType IS NULL";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_NULL = "lfLessonLimit.itemType IS NULL";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_2 = "lfLessonLimit.id.itemType = ?";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_NULL_2 =
        "lfLessonLimit.itemType IS NULL ";
    private static final String _FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_3 = "(lfLessonLimit.id.itemType IS NULL OR lfLessonLimit.id.itemType = '')";
    private static final String _SQL_SELECT_LFLESSONLIMIT = "SELECT lfLessonLimit FROM LFLessonLimit lfLessonLimit";
    private static final String _SQL_SELECT_LFLESSONLIMIT_WHERE = "SELECT lfLessonLimit FROM LFLessonLimit lfLessonLimit WHERE ";
    private static final String _SQL_COUNT_LFLESSONLIMIT = "SELECT COUNT(lfLessonLimit) FROM LFLessonLimit lfLessonLimit";
    private static final String _SQL_COUNT_LFLESSONLIMIT_WHERE = "SELECT COUNT(lfLessonLimit) FROM LFLessonLimit lfLessonLimit WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfLessonLimit.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFLessonLimit exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFLessonLimit exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFLessonLimitPersistenceImpl.class);
    private static LFLessonLimit _nullLFLessonLimit = new LFLessonLimitImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFLessonLimit> toCacheModel() {
                return _nullLFLessonLimitCacheModel;
            }
        };

    private static CacheModel<LFLessonLimit> _nullLFLessonLimitCacheModel = new CacheModel<LFLessonLimit>() {
            @Override
            public LFLessonLimit toEntityModel() {
                return _nullLFLessonLimit;
            }
        };

    public LFLessonLimitPersistenceImpl() {
        setModelClass(LFLessonLimit.class);
    }

    /**
     * Returns all the l f lesson limits where itemID = &#63;.
     *
     * @param itemID the item i d
     * @return the matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findByIDs(Long itemID) throws SystemException {
        return findByIDs(itemID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f lesson limits where itemID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemID the item i d
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @return the range of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findByIDs(Long itemID, int start, int end)
        throws SystemException {
        return findByIDs(itemID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f lesson limits where itemID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemID the item i d
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findByIDs(Long itemID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDS;
            finderArgs = new Object[] { itemID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IDS;
            finderArgs = new Object[] { itemID, start, end, orderByComparator };
        }

        List<LFLessonLimit> list = (List<LFLessonLimit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFLessonLimit lfLessonLimit : list) {
                if (!Validator.equals(itemID, lfLessonLimit.getItemID())) {
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

            query.append(_SQL_SELECT_LFLESSONLIMIT_WHERE);

            if (itemID == null) {
                query.append(_FINDER_COLUMN_IDS_ITEMID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_IDS_ITEMID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFLessonLimitModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (itemID != null) {
                    qPos.add(itemID.longValue());
                }

                if (!pagination) {
                    list = (List<LFLessonLimit>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFLessonLimit>(list);
                } else {
                    list = (List<LFLessonLimit>) QueryUtil.list(q,
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
     * Returns the first l f lesson limit in the ordered set where itemID = &#63;.
     *
     * @param itemID the item i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f lesson limit
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit findByIDs_First(Long itemID,
        OrderByComparator orderByComparator)
        throws NoSuchLFLessonLimitException, SystemException {
        LFLessonLimit lfLessonLimit = fetchByIDs_First(itemID, orderByComparator);

        if (lfLessonLimit != null) {
            return lfLessonLimit;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("itemID=");
        msg.append(itemID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFLessonLimitException(msg.toString());
    }

    /**
     * Returns the first l f lesson limit in the ordered set where itemID = &#63;.
     *
     * @param itemID the item i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit fetchByIDs_First(Long itemID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFLessonLimit> list = findByIDs(itemID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f lesson limit in the ordered set where itemID = &#63;.
     *
     * @param itemID the item i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f lesson limit
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit findByIDs_Last(Long itemID,
        OrderByComparator orderByComparator)
        throws NoSuchLFLessonLimitException, SystemException {
        LFLessonLimit lfLessonLimit = fetchByIDs_Last(itemID, orderByComparator);

        if (lfLessonLimit != null) {
            return lfLessonLimit;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("itemID=");
        msg.append(itemID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFLessonLimitException(msg.toString());
    }

    /**
     * Returns the last l f lesson limit in the ordered set where itemID = &#63;.
     *
     * @param itemID the item i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit fetchByIDs_Last(Long itemID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByIDs(itemID);

        if (count == 0) {
            return null;
        }

        List<LFLessonLimit> list = findByIDs(itemID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f lesson limits before and after the current l f lesson limit in the ordered set where itemID = &#63;.
     *
     * @param lfLessonLimitPK the primary key of the current l f lesson limit
     * @param itemID the item i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f lesson limit
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit[] findByIDs_PrevAndNext(
        LFLessonLimitPK lfLessonLimitPK, Long itemID,
        OrderByComparator orderByComparator)
        throws NoSuchLFLessonLimitException, SystemException {
        LFLessonLimit lfLessonLimit = findByPrimaryKey(lfLessonLimitPK);

        Session session = null;

        try {
            session = openSession();

            LFLessonLimit[] array = new LFLessonLimitImpl[3];

            array[0] = getByIDs_PrevAndNext(session, lfLessonLimit, itemID,
                    orderByComparator, true);

            array[1] = lfLessonLimit;

            array[2] = getByIDs_PrevAndNext(session, lfLessonLimit, itemID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFLessonLimit getByIDs_PrevAndNext(Session session,
        LFLessonLimit lfLessonLimit, Long itemID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFLESSONLIMIT_WHERE);

        if (itemID == null) {
            query.append(_FINDER_COLUMN_IDS_ITEMID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_IDS_ITEMID_2);
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
            query.append(LFLessonLimitModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (itemID != null) {
            qPos.add(itemID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfLessonLimit);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFLessonLimit> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f lesson limits where itemID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemIDs the item i ds
     * @return the matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findByIDs(Long[] itemIDs)
        throws SystemException {
        return findByIDs(itemIDs, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f lesson limits where itemID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemIDs the item i ds
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @return the range of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findByIDs(Long[] itemIDs, int start, int end)
        throws SystemException {
        return findByIDs(itemIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f lesson limits where itemID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param itemIDs the item i ds
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findByIDs(Long[] itemIDs, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if ((itemIDs != null) && (itemIDs.length == 1)) {
            return findByIDs(itemIDs[0], start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(itemIDs) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(itemIDs),
                    
                    start, end, orderByComparator
                };
        }

        List<LFLessonLimit> list = (List<LFLessonLimit>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_IDS,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFLessonLimit lfLessonLimit : list) {
                if (!ArrayUtil.contains(itemIDs, lfLessonLimit.getItemID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFLESSONLIMIT_WHERE);

            boolean conjunctionable = false;

            if ((itemIDs != null) && (itemIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < itemIDs.length; i++) {
                    if (itemIDs[i] == null) {
                        query.append(_FINDER_COLUMN_IDS_ITEMID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_IDS_ITEMID_5);
                    }

                    if ((i + 1) < itemIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFLessonLimitModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (itemIDs != null) {
                    for (Long itemID : itemIDs) {
                        if (itemID != null) {
                            qPos.add(itemID);
                        }
                    }
                }

                if (!pagination) {
                    list = (List<LFLessonLimit>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFLessonLimit>(list);
                } else {
                    list = (List<LFLessonLimit>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_IDS,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_IDS,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f lesson limits where itemID = &#63; from the database.
     *
     * @param itemID the item i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByIDs(Long itemID) throws SystemException {
        for (LFLessonLimit lfLessonLimit : findByIDs(itemID, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfLessonLimit);
        }
    }

    /**
     * Returns the number of l f lesson limits where itemID = &#63;.
     *
     * @param itemID the item i d
     * @return the number of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByIDs(Long itemID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_IDS;

        Object[] finderArgs = new Object[] { itemID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFLESSONLIMIT_WHERE);

            if (itemID == null) {
                query.append(_FINDER_COLUMN_IDS_ITEMID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_IDS_ITEMID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (itemID != null) {
                    qPos.add(itemID.longValue());
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
     * Returns the number of l f lesson limits where itemID = any &#63;.
     *
     * @param itemIDs the item i ds
     * @return the number of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByIDs(Long[] itemIDs) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(itemIDs) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_IDS,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFLESSONLIMIT_WHERE);

            boolean conjunctionable = false;

            if ((itemIDs != null) && (itemIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < itemIDs.length; i++) {
                    if (itemIDs[i] == null) {
                        query.append(_FINDER_COLUMN_IDS_ITEMID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_IDS_ITEMID_5);
                    }

                    if ((i + 1) < itemIDs.length) {
                        query.append(WHERE_OR);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (itemIDs != null) {
                    for (Long itemID : itemIDs) {
                        if (itemID != null) {
                            qPos.add(itemID);
                        }
                    }
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_IDS,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_IDS,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException} if it could not be found.
     *
     * @param itemID the item i d
     * @param itemType the item type
     * @return the matching l f lesson limit
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit findByItemIDAndItemType(Long itemID, String itemType)
        throws NoSuchLFLessonLimitException, SystemException {
        LFLessonLimit lfLessonLimit = fetchByItemIDAndItemType(itemID, itemType);

        if (lfLessonLimit == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("itemID=");
            msg.append(itemID);

            msg.append(", itemType=");
            msg.append(itemType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFLessonLimitException(msg.toString());
        }

        return lfLessonLimit;
    }

    /**
     * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param itemID the item i d
     * @param itemType the item type
     * @return the matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit fetchByItemIDAndItemType(Long itemID, String itemType)
        throws SystemException {
        return fetchByItemIDAndItemType(itemID, itemType, true);
    }

    /**
     * Returns the l f lesson limit where itemID = &#63; and itemType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param itemID the item i d
     * @param itemType the item type
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f lesson limit, or <code>null</code> if a matching l f lesson limit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit fetchByItemIDAndItemType(Long itemID, String itemType,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { itemID, itemType };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                    finderArgs, this);
        }

        if (result instanceof LFLessonLimit) {
            LFLessonLimit lfLessonLimit = (LFLessonLimit) result;

            if (!Validator.equals(itemID, lfLessonLimit.getItemID()) ||
                    !Validator.equals(itemType, lfLessonLimit.getItemType())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFLESSONLIMIT_WHERE);

            if (itemID == null) {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_2);
            }

            boolean bindItemType = false;

            if (itemType == null) {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_1);
            } else if (itemType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_3);
            } else {
                bindItemType = true;

                if (itemType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (itemID != null) {
                    qPos.add(itemID.longValue());
                }

                if (bindItemType) {
                    if (itemType != null) {
                        qPos.add(itemType);
                    }
                }

                List<LFLessonLimit> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFLessonLimitPersistenceImpl.fetchByItemIDAndItemType(Long, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFLessonLimit lfLessonLimit = list.get(0);

                    result = lfLessonLimit;

                    cacheResult(lfLessonLimit);

                    if ((lfLessonLimit.getItemID() != itemID) ||
                            (lfLessonLimit.getItemType() == null) ||
                            !lfLessonLimit.getItemType().equals(itemType)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                            finderArgs, lfLessonLimit);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFLessonLimit) result;
        }
    }

    /**
     * Removes the l f lesson limit where itemID = &#63; and itemType = &#63; from the database.
     *
     * @param itemID the item i d
     * @param itemType the item type
     * @return the l f lesson limit that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit removeByItemIDAndItemType(Long itemID, String itemType)
        throws NoSuchLFLessonLimitException, SystemException {
        LFLessonLimit lfLessonLimit = findByItemIDAndItemType(itemID, itemType);

        return remove(lfLessonLimit);
    }

    /**
     * Returns the number of l f lesson limits where itemID = &#63; and itemType = &#63;.
     *
     * @param itemID the item i d
     * @param itemType the item type
     * @return the number of matching l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByItemIDAndItemType(Long itemID, String itemType)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ITEMIDANDITEMTYPE;

        Object[] finderArgs = new Object[] { itemID, itemType };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFLESSONLIMIT_WHERE);

            if (itemID == null) {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMID_2);
            }

            boolean bindItemType = false;

            if (itemType == null) {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_1);
            } else if (itemType.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_3);
            } else {
                bindItemType = true;

                if (itemType.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_3);
                } else {
                    query.append(_FINDER_COLUMN_ITEMIDANDITEMTYPE_ITEMTYPE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (itemID != null) {
                    qPos.add(itemID.longValue());
                }

                if (bindItemType) {
                    if (itemType != null) {
                        qPos.add(itemType);
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
     * Caches the l f lesson limit in the entity cache if it is enabled.
     *
     * @param lfLessonLimit the l f lesson limit
     */
    @Override
    public void cacheResult(LFLessonLimit lfLessonLimit) {
        EntityCacheUtil.putResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitImpl.class, lfLessonLimit.getPrimaryKey(),
            lfLessonLimit);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
            new Object[] { lfLessonLimit.getItemID(), lfLessonLimit.getItemType() },
            lfLessonLimit);

        lfLessonLimit.resetOriginalValues();
    }

    /**
     * Caches the l f lesson limits in the entity cache if it is enabled.
     *
     * @param lfLessonLimits the l f lesson limits
     */
    @Override
    public void cacheResult(List<LFLessonLimit> lfLessonLimits) {
        for (LFLessonLimit lfLessonLimit : lfLessonLimits) {
            if (EntityCacheUtil.getResult(
                        LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
                        LFLessonLimitImpl.class, lfLessonLimit.getPrimaryKey()) == null) {
                cacheResult(lfLessonLimit);
            } else {
                lfLessonLimit.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f lesson limits.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFLessonLimitImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFLessonLimitImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f lesson limit.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFLessonLimit lfLessonLimit) {
        EntityCacheUtil.removeResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitImpl.class, lfLessonLimit.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfLessonLimit);
    }

    @Override
    public void clearCache(List<LFLessonLimit> lfLessonLimits) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFLessonLimit lfLessonLimit : lfLessonLimits) {
            EntityCacheUtil.removeResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
                LFLessonLimitImpl.class, lfLessonLimit.getPrimaryKey());

            clearUniqueFindersCache(lfLessonLimit);
        }
    }

    protected void cacheUniqueFindersCache(LFLessonLimit lfLessonLimit) {
        if (lfLessonLimit.isNew()) {
            Object[] args = new Object[] {
                    lfLessonLimit.getItemID(), lfLessonLimit.getItemType()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMIDANDITEMTYPE,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                args, lfLessonLimit);
        } else {
            LFLessonLimitModelImpl lfLessonLimitModelImpl = (LFLessonLimitModelImpl) lfLessonLimit;

            if ((lfLessonLimitModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfLessonLimit.getItemID(), lfLessonLimit.getItemType()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ITEMIDANDITEMTYPE,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                    args, lfLessonLimit);
            }
        }
    }

    protected void clearUniqueFindersCache(LFLessonLimit lfLessonLimit) {
        LFLessonLimitModelImpl lfLessonLimitModelImpl = (LFLessonLimitModelImpl) lfLessonLimit;

        Object[] args = new Object[] {
                lfLessonLimit.getItemID(), lfLessonLimit.getItemType()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMIDANDITEMTYPE,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
            args);

        if ((lfLessonLimitModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfLessonLimitModelImpl.getOriginalItemID(),
                    lfLessonLimitModelImpl.getOriginalItemType()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ITEMIDANDITEMTYPE,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ITEMIDANDITEMTYPE,
                args);
        }
    }

    /**
     * Creates a new l f lesson limit with the primary key. Does not add the l f lesson limit to the database.
     *
     * @param lfLessonLimitPK the primary key for the new l f lesson limit
     * @return the new l f lesson limit
     */
    @Override
    public LFLessonLimit create(LFLessonLimitPK lfLessonLimitPK) {
        LFLessonLimit lfLessonLimit = new LFLessonLimitImpl();

        lfLessonLimit.setNew(true);
        lfLessonLimit.setPrimaryKey(lfLessonLimitPK);

        return lfLessonLimit;
    }

    /**
     * Removes the l f lesson limit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfLessonLimitPK the primary key of the l f lesson limit
     * @return the l f lesson limit that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit remove(LFLessonLimitPK lfLessonLimitPK)
        throws NoSuchLFLessonLimitException, SystemException {
        return remove((Serializable) lfLessonLimitPK);
    }

    /**
     * Removes the l f lesson limit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f lesson limit
     * @return the l f lesson limit that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit remove(Serializable primaryKey)
        throws NoSuchLFLessonLimitException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFLessonLimit lfLessonLimit = (LFLessonLimit) session.get(LFLessonLimitImpl.class,
                    primaryKey);

            if (lfLessonLimit == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFLessonLimitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfLessonLimit);
        } catch (NoSuchLFLessonLimitException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFLessonLimit removeImpl(LFLessonLimit lfLessonLimit)
        throws SystemException {
        lfLessonLimit = toUnwrappedModel(lfLessonLimit);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfLessonLimit)) {
                lfLessonLimit = (LFLessonLimit) session.get(LFLessonLimitImpl.class,
                        lfLessonLimit.getPrimaryKeyObj());
            }

            if (lfLessonLimit != null) {
                session.delete(lfLessonLimit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfLessonLimit != null) {
            clearCache(lfLessonLimit);
        }

        return lfLessonLimit;
    }

    @Override
    public LFLessonLimit updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFLessonLimit lfLessonLimit)
        throws SystemException {
        lfLessonLimit = toUnwrappedModel(lfLessonLimit);

        boolean isNew = lfLessonLimit.isNew();

        LFLessonLimitModelImpl lfLessonLimitModelImpl = (LFLessonLimitModelImpl) lfLessonLimit;

        Session session = null;

        try {
            session = openSession();

            if (lfLessonLimit.isNew()) {
                session.save(lfLessonLimit);

                lfLessonLimit.setNew(false);
            } else {
                session.merge(lfLessonLimit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFLessonLimitModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfLessonLimitModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfLessonLimitModelImpl.getOriginalItemID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDS,
                    args);

                args = new Object[] { lfLessonLimitModelImpl.getItemID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IDS,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
            LFLessonLimitImpl.class, lfLessonLimit.getPrimaryKey(),
            lfLessonLimit);

        clearUniqueFindersCache(lfLessonLimit);
        cacheUniqueFindersCache(lfLessonLimit);

        return lfLessonLimit;
    }

    protected LFLessonLimit toUnwrappedModel(LFLessonLimit lfLessonLimit) {
        if (lfLessonLimit instanceof LFLessonLimitImpl) {
            return lfLessonLimit;
        }

        LFLessonLimitImpl lfLessonLimitImpl = new LFLessonLimitImpl();

        lfLessonLimitImpl.setNew(lfLessonLimit.isNew());
        lfLessonLimitImpl.setPrimaryKey(lfLessonLimit.getPrimaryKey());

        lfLessonLimitImpl.setItemID(lfLessonLimit.getItemID());
        lfLessonLimitImpl.setItemType(lfLessonLimit.getItemType());
        lfLessonLimitImpl.setPassingLimit(lfLessonLimit.getPassingLimit());
        lfLessonLimitImpl.setRerunInterval(lfLessonLimit.getRerunInterval());
        lfLessonLimitImpl.setRerunIntervalType(lfLessonLimit.getRerunIntervalType());

        return lfLessonLimitImpl;
    }

    /**
     * Returns the l f lesson limit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f lesson limit
     * @return the l f lesson limit
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFLessonLimitException, SystemException {
        LFLessonLimit lfLessonLimit = fetchByPrimaryKey(primaryKey);

        if (lfLessonLimit == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFLessonLimitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfLessonLimit;
    }

    /**
     * Returns the l f lesson limit with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException} if it could not be found.
     *
     * @param lfLessonLimitPK the primary key of the l f lesson limit
     * @return the l f lesson limit
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit findByPrimaryKey(LFLessonLimitPK lfLessonLimitPK)
        throws NoSuchLFLessonLimitException, SystemException {
        return findByPrimaryKey((Serializable) lfLessonLimitPK);
    }

    /**
     * Returns the l f lesson limit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f lesson limit
     * @return the l f lesson limit, or <code>null</code> if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFLessonLimit lfLessonLimit = (LFLessonLimit) EntityCacheUtil.getResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
                LFLessonLimitImpl.class, primaryKey);

        if (lfLessonLimit == _nullLFLessonLimit) {
            return null;
        }

        if (lfLessonLimit == null) {
            Session session = null;

            try {
                session = openSession();

                lfLessonLimit = (LFLessonLimit) session.get(LFLessonLimitImpl.class,
                        primaryKey);

                if (lfLessonLimit != null) {
                    cacheResult(lfLessonLimit);
                } else {
                    EntityCacheUtil.putResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
                        LFLessonLimitImpl.class, primaryKey, _nullLFLessonLimit);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFLessonLimitModelImpl.ENTITY_CACHE_ENABLED,
                    LFLessonLimitImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfLessonLimit;
    }

    /**
     * Returns the l f lesson limit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfLessonLimitPK the primary key of the l f lesson limit
     * @return the l f lesson limit, or <code>null</code> if a l f lesson limit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLessonLimit fetchByPrimaryKey(LFLessonLimitPK lfLessonLimitPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) lfLessonLimitPK);
    }

    /**
     * Returns all the l f lesson limits.
     *
     * @return the l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f lesson limits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @return the range of l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f lesson limits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLessonLimitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f lesson limits
     * @param end the upper bound of the range of l f lesson limits (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f lesson limits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLessonLimit> findAll(int start, int end,
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

        List<LFLessonLimit> list = (List<LFLessonLimit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFLESSONLIMIT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFLESSONLIMIT;

                if (pagination) {
                    sql = sql.concat(LFLessonLimitModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFLessonLimit>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFLessonLimit>(list);
                } else {
                    list = (List<LFLessonLimit>) QueryUtil.list(q,
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
     * Removes all the l f lesson limits from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFLessonLimit lfLessonLimit : findAll()) {
            remove(lfLessonLimit);
        }
    }

    /**
     * Returns the number of l f lesson limits.
     *
     * @return the number of l f lesson limits
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

                Query q = session.createQuery(_SQL_COUNT_LFLESSONLIMIT);

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
     * Initializes the l f lesson limit persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFLessonLimit")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFLessonLimit>> listenersList = new ArrayList<ModelListener<LFLessonLimit>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFLessonLimit>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFLessonLimitImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    private static String _removeConjunction(String sql) {
        int pos = sql.indexOf(" AND ");

        if (pos != -1) {
            sql = sql.substring(0, pos);
        }

        return sql;
    }
}

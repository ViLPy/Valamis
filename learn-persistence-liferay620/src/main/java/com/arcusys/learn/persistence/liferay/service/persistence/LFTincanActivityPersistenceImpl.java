package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException;
import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanActivityPersistence;

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
 * The persistence implementation for the l f tincan activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActivityPersistence
 * @see LFTincanActivityUtil
 * @generated
 */
public class LFTincanActivityPersistenceImpl extends BasePersistenceImpl<LFTincanActivity>
    implements LFTincanActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanActivityUtil} to access the l f tincan activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActivityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActivityImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Long.class.getName() },
            LFTincanActivityModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfTincanActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfTincanActivity.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfTincanActivity.packageID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanActivityImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanActivityModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanActivity.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanActivity.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanActivity.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanActivity.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanActivity.tincanID IS NULL OR lfTincanActivity.tincanID = '')";
    private static final String _SQL_SELECT_LFTINCANACTIVITY = "SELECT lfTincanActivity FROM LFTincanActivity lfTincanActivity";
    private static final String _SQL_SELECT_LFTINCANACTIVITY_WHERE = "SELECT lfTincanActivity FROM LFTincanActivity lfTincanActivity WHERE ";
    private static final String _SQL_COUNT_LFTINCANACTIVITY = "SELECT COUNT(lfTincanActivity) FROM LFTincanActivity lfTincanActivity";
    private static final String _SQL_COUNT_LFTINCANACTIVITY_WHERE = "SELECT COUNT(lfTincanActivity) FROM LFTincanActivity lfTincanActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanActivityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanActivity _nullLFTincanActivity = new LFTincanActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanActivity> toCacheModel() {
                return _nullLFTincanActivityCacheModel;
            }
        };

    private static CacheModel<LFTincanActivity> _nullLFTincanActivityCacheModel = new CacheModel<LFTincanActivity>() {
            @Override
            public LFTincanActivity toEntityModel() {
                return _nullLFTincanActivity;
            }
        };

    public LFTincanActivityPersistenceImpl() {
        setModelClass(LFTincanActivity.class);
    }

    /**
     * Returns all the l f tincan activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActivity> findByPackageID(Long packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan activities
     * @param end the upper bound of the range of l f tincan activities (not inclusive)
     * @return the range of matching l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActivity> findByPackageID(Long packageID, int start,
        int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan activities
     * @param end the upper bound of the range of l f tincan activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActivity> findByPackageID(Long packageID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID, start, end, orderByComparator };
        }

        List<LFTincanActivity> list = (List<LFTincanActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanActivity lfTincanActivity : list) {
                if (!Validator.equals(packageID, lfTincanActivity.getPackageID())) {
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

            query.append(_SQL_SELECT_LFTINCANACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFTincanActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.longValue());
                }

                if (!pagination) {
                    list = (List<LFTincanActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActivity>(list);
                } else {
                    list = (List<LFTincanActivity>) QueryUtil.list(q,
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
     * Returns the first l f tincan activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity findByPackageID_First(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActivityException, SystemException {
        LFTincanActivity lfTincanActivity = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfTincanActivity != null) {
            return lfTincanActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActivityException(msg.toString());
    }

    /**
     * Returns the first l f tincan activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan activity, or <code>null</code> if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity fetchByPackageID_First(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanActivity> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity findByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanActivityException, SystemException {
        LFTincanActivity lfTincanActivity = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfTincanActivity != null) {
            return lfTincanActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanActivityException(msg.toString());
    }

    /**
     * Returns the last l f tincan activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan activity, or <code>null</code> if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity fetchByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        if (count == 0) {
            return null;
        }

        List<LFTincanActivity> list = findByPackageID(packageID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan activities before and after the current l f tincan activity in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f tincan activity
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity[] findByPackageID_PrevAndNext(long id,
        Long packageID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanActivityException, SystemException {
        LFTincanActivity lfTincanActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanActivity[] array = new LFTincanActivityImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfTincanActivity,
                    packageID, orderByComparator, true);

            array[1] = lfTincanActivity;

            array[2] = getByPackageID_PrevAndNext(session, lfTincanActivity,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanActivity getByPackageID_PrevAndNext(Session session,
        LFTincanActivity lfTincanActivity, Long packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANACTIVITY_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
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
            query.append(LFTincanActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan activities where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageID(Long packageID) throws SystemException {
        for (LFTincanActivity lfTincanActivity : findByPackageID(packageID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanActivity);
        }
    }

    /**
     * Returns the number of l f tincan activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageID(Long packageID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.longValue());
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
     * Returns the l f tincan activity where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity findByTincanID(String tincanID)
        throws NoSuchLFTincanActivityException, SystemException {
        LFTincanActivity lfTincanActivity = fetchByTincanID(tincanID);

        if (lfTincanActivity == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanActivityException(msg.toString());
        }

        return lfTincanActivity;
    }

    /**
     * Returns the l f tincan activity where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan activity, or <code>null</code> if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan activity where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan activity, or <code>null</code> if a matching l f tincan activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanActivity) {
            LFTincanActivity lfTincanActivity = (LFTincanActivity) result;

            if (!Validator.equals(tincanID, lfTincanActivity.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANACTIVITY_WHERE);

            boolean bindTincanID = false;

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else if (tincanID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
            } else {
                bindTincanID = true;

                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTincanID) {
                    if (tincanID != null) {
                        qPos.add(tincanID);
                    }
                }

                List<LFTincanActivity> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanActivityPersistenceImpl.fetchByTincanID(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanActivity lfTincanActivity = list.get(0);

                    result = lfTincanActivity;

                    cacheResult(lfTincanActivity);

                    if ((lfTincanActivity.getTincanID() == null) ||
                            !lfTincanActivity.getTincanID().equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanActivity);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFTincanActivity) result;
        }
    }

    /**
     * Removes the l f tincan activity where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan activity that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity removeByTincanID(String tincanID)
        throws NoSuchLFTincanActivityException, SystemException {
        LFTincanActivity lfTincanActivity = findByTincanID(tincanID);

        return remove(lfTincanActivity);
    }

    /**
     * Returns the number of l f tincan activities where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTincanID(String tincanID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TINCANID;

        Object[] finderArgs = new Object[] { tincanID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFTINCANACTIVITY_WHERE);

            boolean bindTincanID = false;

            if (tincanID == null) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_1);
            } else if (tincanID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
            } else {
                bindTincanID = true;

                if (tincanID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_3);
                } else {
                    query.append(_FINDER_COLUMN_TINCANID_TINCANID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTincanID) {
                    if (tincanID != null) {
                        qPos.add(tincanID);
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
     * Caches the l f tincan activity in the entity cache if it is enabled.
     *
     * @param lfTincanActivity the l f tincan activity
     */
    @Override
    public void cacheResult(LFTincanActivity lfTincanActivity) {
        EntityCacheUtil.putResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityImpl.class, lfTincanActivity.getPrimaryKey(),
            lfTincanActivity);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
            new Object[] { lfTincanActivity.getTincanID() }, lfTincanActivity);

        lfTincanActivity.resetOriginalValues();
    }

    /**
     * Caches the l f tincan activities in the entity cache if it is enabled.
     *
     * @param lfTincanActivities the l f tincan activities
     */
    @Override
    public void cacheResult(List<LFTincanActivity> lfTincanActivities) {
        for (LFTincanActivity lfTincanActivity : lfTincanActivities) {
            if (EntityCacheUtil.getResult(
                        LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActivityImpl.class,
                        lfTincanActivity.getPrimaryKey()) == null) {
                cacheResult(lfTincanActivity);
            } else {
                lfTincanActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanActivity lfTincanActivity) {
        EntityCacheUtil.removeResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityImpl.class, lfTincanActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanActivity);
    }

    @Override
    public void clearCache(List<LFTincanActivity> lfTincanActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanActivity lfTincanActivity : lfTincanActivities) {
            EntityCacheUtil.removeResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActivityImpl.class, lfTincanActivity.getPrimaryKey());

            clearUniqueFindersCache(lfTincanActivity);
        }
    }

    protected void cacheUniqueFindersCache(LFTincanActivity lfTincanActivity) {
        if (lfTincanActivity.isNew()) {
            Object[] args = new Object[] { lfTincanActivity.getTincanID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                lfTincanActivity);
        } else {
            LFTincanActivityModelImpl lfTincanActivityModelImpl = (LFTincanActivityModelImpl) lfTincanActivity;

            if ((lfTincanActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanActivity.getTincanID() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                    lfTincanActivity);
            }
        }
    }

    protected void clearUniqueFindersCache(LFTincanActivity lfTincanActivity) {
        LFTincanActivityModelImpl lfTincanActivityModelImpl = (LFTincanActivityModelImpl) lfTincanActivity;

        Object[] args = new Object[] { lfTincanActivity.getTincanID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

        if ((lfTincanActivityModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
            args = new Object[] { lfTincanActivityModelImpl.getOriginalTincanID() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);
        }
    }

    /**
     * Creates a new l f tincan activity with the primary key. Does not add the l f tincan activity to the database.
     *
     * @param id the primary key for the new l f tincan activity
     * @return the new l f tincan activity
     */
    @Override
    public LFTincanActivity create(long id) {
        LFTincanActivity lfTincanActivity = new LFTincanActivityImpl();

        lfTincanActivity.setNew(true);
        lfTincanActivity.setPrimaryKey(id);

        return lfTincanActivity;
    }

    /**
     * Removes the l f tincan activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan activity
     * @return the l f tincan activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity remove(long id)
        throws NoSuchLFTincanActivityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan activity
     * @return the l f tincan activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity remove(Serializable primaryKey)
        throws NoSuchLFTincanActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanActivity lfTincanActivity = (LFTincanActivity) session.get(LFTincanActivityImpl.class,
                    primaryKey);

            if (lfTincanActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanActivity);
        } catch (NoSuchLFTincanActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanActivity removeImpl(LFTincanActivity lfTincanActivity)
        throws SystemException {
        lfTincanActivity = toUnwrappedModel(lfTincanActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanActivity)) {
                lfTincanActivity = (LFTincanActivity) session.get(LFTincanActivityImpl.class,
                        lfTincanActivity.getPrimaryKeyObj());
            }

            if (lfTincanActivity != null) {
                session.delete(lfTincanActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanActivity != null) {
            clearCache(lfTincanActivity);
        }

        return lfTincanActivity;
    }

    @Override
    public LFTincanActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity)
        throws SystemException {
        lfTincanActivity = toUnwrappedModel(lfTincanActivity);

        boolean isNew = lfTincanActivity.isNew();

        LFTincanActivityModelImpl lfTincanActivityModelImpl = (LFTincanActivityModelImpl) lfTincanActivity;

        Session session = null;

        try {
            session = openSession();

            if (lfTincanActivity.isNew()) {
                session.save(lfTincanActivity);

                lfTincanActivity.setNew(false);
            } else {
                session.merge(lfTincanActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanActivityModelImpl.getOriginalPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { lfTincanActivityModelImpl.getPackageID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanActivityImpl.class, lfTincanActivity.getPrimaryKey(),
            lfTincanActivity);

        clearUniqueFindersCache(lfTincanActivity);
        cacheUniqueFindersCache(lfTincanActivity);

        return lfTincanActivity;
    }

    protected LFTincanActivity toUnwrappedModel(
        LFTincanActivity lfTincanActivity) {
        if (lfTincanActivity instanceof LFTincanActivityImpl) {
            return lfTincanActivity;
        }

        LFTincanActivityImpl lfTincanActivityImpl = new LFTincanActivityImpl();

        lfTincanActivityImpl.setNew(lfTincanActivity.isNew());
        lfTincanActivityImpl.setPrimaryKey(lfTincanActivity.getPrimaryKey());

        lfTincanActivityImpl.setId(lfTincanActivity.getId());
        lfTincanActivityImpl.setTincanID(lfTincanActivity.getTincanID());
        lfTincanActivityImpl.setPackageID(lfTincanActivity.getPackageID());
        lfTincanActivityImpl.setObjectType(lfTincanActivity.getObjectType());
        lfTincanActivityImpl.setName(lfTincanActivity.getName());
        lfTincanActivityImpl.setDescription(lfTincanActivity.getDescription());
        lfTincanActivityImpl.setTheType(lfTincanActivity.getTheType());
        lfTincanActivityImpl.setMoreInfo(lfTincanActivity.getMoreInfo());
        lfTincanActivityImpl.setInteractionType(lfTincanActivity.getInteractionType());
        lfTincanActivityImpl.setCorrectResponsesPattern(lfTincanActivity.getCorrectResponsesPattern());
        lfTincanActivityImpl.setChoices(lfTincanActivity.getChoices());
        lfTincanActivityImpl.setScale(lfTincanActivity.getScale());
        lfTincanActivityImpl.setSource(lfTincanActivity.getSource());
        lfTincanActivityImpl.setTarget(lfTincanActivity.getTarget());
        lfTincanActivityImpl.setSteps(lfTincanActivity.getSteps());
        lfTincanActivityImpl.setExtensions(lfTincanActivity.getExtensions());

        return lfTincanActivityImpl;
    }

    /**
     * Returns the l f tincan activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan activity
     * @return the l f tincan activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanActivityException, SystemException {
        LFTincanActivity lfTincanActivity = fetchByPrimaryKey(primaryKey);

        if (lfTincanActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanActivity;
    }

    /**
     * Returns the l f tincan activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException} if it could not be found.
     *
     * @param id the primary key of the l f tincan activity
     * @return the l f tincan activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity findByPrimaryKey(long id)
        throws NoSuchLFTincanActivityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan activity
     * @return the l f tincan activity, or <code>null</code> if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanActivity lfTincanActivity = (LFTincanActivity) EntityCacheUtil.getResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanActivityImpl.class, primaryKey);

        if (lfTincanActivity == _nullLFTincanActivity) {
            return null;
        }

        if (lfTincanActivity == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanActivity = (LFTincanActivity) session.get(LFTincanActivityImpl.class,
                        primaryKey);

                if (lfTincanActivity != null) {
                    cacheResult(lfTincanActivity);
                } else {
                    EntityCacheUtil.putResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanActivityImpl.class, primaryKey,
                        _nullLFTincanActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanActivityModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanActivity;
    }

    /**
     * Returns the l f tincan activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan activity
     * @return the l f tincan activity, or <code>null</code> if a l f tincan activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanActivity fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan activities.
     *
     * @return the l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan activities
     * @param end the upper bound of the range of l f tincan activities (not inclusive)
     * @return the range of l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan activities
     * @param end the upper bound of the range of l f tincan activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanActivity> findAll(int start, int end,
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

        List<LFTincanActivity> list = (List<LFTincanActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANACTIVITY;

                if (pagination) {
                    sql = sql.concat(LFTincanActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanActivity>(list);
                } else {
                    list = (List<LFTincanActivity>) QueryUtil.list(q,
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
     * Removes all the l f tincan activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanActivity lfTincanActivity : findAll()) {
            remove(lfTincanActivity);
        }
    }

    /**
     * Returns the number of l f tincan activities.
     *
     * @return the number of l f tincan activities
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANACTIVITY);

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
     * Initializes the l f tincan activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanActivity>> listenersList = new ArrayList<ModelListener<LFTincanActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

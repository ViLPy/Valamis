package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanManifestActivityPersistence;

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
 * The persistence implementation for the l f tincan manifest activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActivityPersistence
 * @see LFTincanManifestActivityUtil
 * @generated
 */
public class LFTincanManifestActivityPersistenceImpl extends BasePersistenceImpl<LFTincanManifestActivity>
    implements LFTincanManifestActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanManifestActivityUtil} to access the l f tincan manifest activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanManifestActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Long.class.getName() },
            LFTincanManifestActivityModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfTincanManifestActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfTincanManifestActivity.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfTincanManifestActivity.packageID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanManifestActivityModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanManifestActivity.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanManifestActivity.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanManifestActivity.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanManifestActivity.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanManifestActivity.tincanID IS NULL OR lfTincanManifestActivity.tincanID = '')";
    private static final String _SQL_SELECT_LFTINCANMANIFESTACTIVITY = "SELECT lfTincanManifestActivity FROM LFTincanManifestActivity lfTincanManifestActivity";
    private static final String _SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE = "SELECT lfTincanManifestActivity FROM LFTincanManifestActivity lfTincanManifestActivity WHERE ";
    private static final String _SQL_COUNT_LFTINCANMANIFESTACTIVITY = "SELECT COUNT(lfTincanManifestActivity) FROM LFTincanManifestActivity lfTincanManifestActivity";
    private static final String _SQL_COUNT_LFTINCANMANIFESTACTIVITY_WHERE = "SELECT COUNT(lfTincanManifestActivity) FROM LFTincanManifestActivity lfTincanManifestActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanManifestActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanManifestActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanManifestActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanManifestActivityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanManifestActivity _nullLFTincanManifestActivity = new LFTincanManifestActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanManifestActivity> toCacheModel() {
                return _nullLFTincanManifestActivityCacheModel;
            }
        };

    private static CacheModel<LFTincanManifestActivity> _nullLFTincanManifestActivityCacheModel =
        new CacheModel<LFTincanManifestActivity>() {
            @Override
            public LFTincanManifestActivity toEntityModel() {
                return _nullLFTincanManifestActivity;
            }
        };

    public LFTincanManifestActivityPersistenceImpl() {
        setModelClass(LFTincanManifestActivity.class);
    }

    /**
     * Returns all the l f tincan manifest activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestActivity> findByPackageID(Long packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan manifest activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @return the range of matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestActivity> findByPackageID(Long packageID,
        int start, int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan manifest activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestActivity> findByPackageID(Long packageID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<LFTincanManifestActivity> list = (List<LFTincanManifestActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanManifestActivity lfTincanManifestActivity : list) {
                if (!Validator.equals(packageID,
                            lfTincanManifestActivity.getPackageID())) {
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

            query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE);

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
                query.append(LFTincanManifestActivityModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanManifestActivity>(list);
                } else {
                    list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
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
     * Returns the first l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity findByPackageID_First(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfTincanManifestActivity != null) {
            return lfTincanManifestActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanManifestActivityException(msg.toString());
    }

    /**
     * Returns the first l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByPackageID_First(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanManifestActivity> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity findByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfTincanManifestActivity != null) {
            return lfTincanManifestActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanManifestActivityException(msg.toString());
    }

    /**
     * Returns the last l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        if (count == 0) {
            return null;
        }

        List<LFTincanManifestActivity> list = findByPackageID(packageID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan manifest activities before and after the current l f tincan manifest activity in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f tincan manifest activity
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity[] findByPackageID_PrevAndNext(long id,
        Long packageID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanManifestActivity[] array = new LFTincanManifestActivityImpl[3];

            array[0] = getByPackageID_PrevAndNext(session,
                    lfTincanManifestActivity, packageID, orderByComparator, true);

            array[1] = lfTincanManifestActivity;

            array[2] = getByPackageID_PrevAndNext(session,
                    lfTincanManifestActivity, packageID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanManifestActivity getByPackageID_PrevAndNext(
        Session session, LFTincanManifestActivity lfTincanManifestActivity,
        Long packageID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE);

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
            query.append(LFTincanManifestActivityModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanManifestActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanManifestActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan manifest activities where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageID(Long packageID) throws SystemException {
        for (LFTincanManifestActivity lfTincanManifestActivity : findByPackageID(
                packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanManifestActivity);
        }
    }

    /**
     * Returns the number of l f tincan manifest activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f tincan manifest activities
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

            query.append(_SQL_COUNT_LFTINCANMANIFESTACTIVITY_WHERE);

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
     * Returns the l f tincan manifest activity where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity findByTincanID(String tincanID)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByTincanID(tincanID);

        if (lfTincanManifestActivity == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanManifestActivityException(msg.toString());
        }

        return lfTincanManifestActivity;
    }

    /**
     * Returns the l f tincan manifest activity where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan manifest activity where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan manifest activity, or <code>null</code> if a matching l f tincan manifest activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanManifestActivity) {
            LFTincanManifestActivity lfTincanManifestActivity = (LFTincanManifestActivity) result;

            if (!Validator.equals(tincanID,
                        lfTincanManifestActivity.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY_WHERE);

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

                List<LFTincanManifestActivity> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanManifestActivityPersistenceImpl.fetchByTincanID(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanManifestActivity lfTincanManifestActivity = list.get(0);

                    result = lfTincanManifestActivity;

                    cacheResult(lfTincanManifestActivity);

                    if ((lfTincanManifestActivity.getTincanID() == null) ||
                            !lfTincanManifestActivity.getTincanID()
                                                         .equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanManifestActivity);
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
            return (LFTincanManifestActivity) result;
        }
    }

    /**
     * Removes the l f tincan manifest activity where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan manifest activity that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity removeByTincanID(String tincanID)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = findByTincanID(tincanID);

        return remove(lfTincanManifestActivity);
    }

    /**
     * Returns the number of l f tincan manifest activities where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan manifest activities
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

            query.append(_SQL_COUNT_LFTINCANMANIFESTACTIVITY_WHERE);

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
     * Caches the l f tincan manifest activity in the entity cache if it is enabled.
     *
     * @param lfTincanManifestActivity the l f tincan manifest activity
     */
    @Override
    public void cacheResult(LFTincanManifestActivity lfTincanManifestActivity) {
        EntityCacheUtil.putResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            lfTincanManifestActivity.getPrimaryKey(), lfTincanManifestActivity);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
            new Object[] { lfTincanManifestActivity.getTincanID() },
            lfTincanManifestActivity);

        lfTincanManifestActivity.resetOriginalValues();
    }

    /**
     * Caches the l f tincan manifest activities in the entity cache if it is enabled.
     *
     * @param lfTincanManifestActivities the l f tincan manifest activities
     */
    @Override
    public void cacheResult(
        List<LFTincanManifestActivity> lfTincanManifestActivities) {
        for (LFTincanManifestActivity lfTincanManifestActivity : lfTincanManifestActivities) {
            if (EntityCacheUtil.getResult(
                        LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanManifestActivityImpl.class,
                        lfTincanManifestActivity.getPrimaryKey()) == null) {
                cacheResult(lfTincanManifestActivity);
            } else {
                lfTincanManifestActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan manifest activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanManifestActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanManifestActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan manifest activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanManifestActivity lfTincanManifestActivity) {
        EntityCacheUtil.removeResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            lfTincanManifestActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanManifestActivity);
    }

    @Override
    public void clearCache(
        List<LFTincanManifestActivity> lfTincanManifestActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanManifestActivity lfTincanManifestActivity : lfTincanManifestActivities) {
            EntityCacheUtil.removeResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanManifestActivityImpl.class,
                lfTincanManifestActivity.getPrimaryKey());

            clearUniqueFindersCache(lfTincanManifestActivity);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTincanManifestActivity lfTincanManifestActivity) {
        if (lfTincanManifestActivity.isNew()) {
            Object[] args = new Object[] { lfTincanManifestActivity.getTincanID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                lfTincanManifestActivity);
        } else {
            LFTincanManifestActivityModelImpl lfTincanManifestActivityModelImpl = (LFTincanManifestActivityModelImpl) lfTincanManifestActivity;

            if ((lfTincanManifestActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanManifestActivity.getTincanID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                    lfTincanManifestActivity);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanManifestActivity lfTincanManifestActivity) {
        LFTincanManifestActivityModelImpl lfTincanManifestActivityModelImpl = (LFTincanManifestActivityModelImpl) lfTincanManifestActivity;

        Object[] args = new Object[] { lfTincanManifestActivity.getTincanID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

        if ((lfTincanManifestActivityModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanManifestActivityModelImpl.getOriginalTincanID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);
        }
    }

    /**
     * Creates a new l f tincan manifest activity with the primary key. Does not add the l f tincan manifest activity to the database.
     *
     * @param id the primary key for the new l f tincan manifest activity
     * @return the new l f tincan manifest activity
     */
    @Override
    public LFTincanManifestActivity create(long id) {
        LFTincanManifestActivity lfTincanManifestActivity = new LFTincanManifestActivityImpl();

        lfTincanManifestActivity.setNew(true);
        lfTincanManifestActivity.setPrimaryKey(id);

        return lfTincanManifestActivity;
    }

    /**
     * Removes the l f tincan manifest activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity remove(long id)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan manifest activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity remove(Serializable primaryKey)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanManifestActivity lfTincanManifestActivity = (LFTincanManifestActivity) session.get(LFTincanManifestActivityImpl.class,
                    primaryKey);

            if (lfTincanManifestActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanManifestActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanManifestActivity);
        } catch (NoSuchLFTincanManifestActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanManifestActivity removeImpl(
        LFTincanManifestActivity lfTincanManifestActivity)
        throws SystemException {
        lfTincanManifestActivity = toUnwrappedModel(lfTincanManifestActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanManifestActivity)) {
                lfTincanManifestActivity = (LFTincanManifestActivity) session.get(LFTincanManifestActivityImpl.class,
                        lfTincanManifestActivity.getPrimaryKeyObj());
            }

            if (lfTincanManifestActivity != null) {
                session.delete(lfTincanManifestActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanManifestActivity != null) {
            clearCache(lfTincanManifestActivity);
        }

        return lfTincanManifestActivity;
    }

    @Override
    public LFTincanManifestActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity lfTincanManifestActivity)
        throws SystemException {
        lfTincanManifestActivity = toUnwrappedModel(lfTincanManifestActivity);

        boolean isNew = lfTincanManifestActivity.isNew();

        LFTincanManifestActivityModelImpl lfTincanManifestActivityModelImpl = (LFTincanManifestActivityModelImpl) lfTincanManifestActivity;

        Session session = null;

        try {
            session = openSession();

            if (lfTincanManifestActivity.isNew()) {
                session.save(lfTincanManifestActivity);

                lfTincanManifestActivity.setNew(false);
            } else {
                session.merge(lfTincanManifestActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanManifestActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanManifestActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanManifestActivityModelImpl.getOriginalPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] {
                        lfTincanManifestActivityModelImpl.getPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActivityImpl.class,
            lfTincanManifestActivity.getPrimaryKey(), lfTincanManifestActivity);

        clearUniqueFindersCache(lfTincanManifestActivity);
        cacheUniqueFindersCache(lfTincanManifestActivity);

        return lfTincanManifestActivity;
    }

    protected LFTincanManifestActivity toUnwrappedModel(
        LFTincanManifestActivity lfTincanManifestActivity) {
        if (lfTincanManifestActivity instanceof LFTincanManifestActivityImpl) {
            return lfTincanManifestActivity;
        }

        LFTincanManifestActivityImpl lfTincanManifestActivityImpl = new LFTincanManifestActivityImpl();

        lfTincanManifestActivityImpl.setNew(lfTincanManifestActivity.isNew());
        lfTincanManifestActivityImpl.setPrimaryKey(lfTincanManifestActivity.getPrimaryKey());

        lfTincanManifestActivityImpl.setId(lfTincanManifestActivity.getId());
        lfTincanManifestActivityImpl.setTincanID(lfTincanManifestActivity.getTincanID());
        lfTincanManifestActivityImpl.setPackageID(lfTincanManifestActivity.getPackageID());
        lfTincanManifestActivityImpl.setActivityType(lfTincanManifestActivity.getActivityType());
        lfTincanManifestActivityImpl.setName(lfTincanManifestActivity.getName());
        lfTincanManifestActivityImpl.setDescription(lfTincanManifestActivity.getDescription());
        lfTincanManifestActivityImpl.setLaunch(lfTincanManifestActivity.getLaunch());
        lfTincanManifestActivityImpl.setResource(lfTincanManifestActivity.getResource());

        return lfTincanManifestActivityImpl;
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = fetchByPrimaryKey(primaryKey);

        if (lfTincanManifestActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanManifestActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanManifestActivity;
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException} if it could not be found.
     *
     * @param id the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity findByPrimaryKey(long id)
        throws NoSuchLFTincanManifestActivityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity, or <code>null</code> if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanManifestActivity lfTincanManifestActivity = (LFTincanManifestActivity) EntityCacheUtil.getResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanManifestActivityImpl.class, primaryKey);

        if (lfTincanManifestActivity == _nullLFTincanManifestActivity) {
            return null;
        }

        if (lfTincanManifestActivity == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanManifestActivity = (LFTincanManifestActivity) session.get(LFTincanManifestActivityImpl.class,
                        primaryKey);

                if (lfTincanManifestActivity != null) {
                    cacheResult(lfTincanManifestActivity);
                } else {
                    EntityCacheUtil.putResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanManifestActivityImpl.class, primaryKey,
                        _nullLFTincanManifestActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanManifestActivityModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanManifestActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanManifestActivity;
    }

    /**
     * Returns the l f tincan manifest activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan manifest activity
     * @return the l f tincan manifest activity, or <code>null</code> if a l f tincan manifest activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestActivity fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan manifest activities.
     *
     * @return the l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan manifest activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @return the range of l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan manifest activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan manifest activities
     * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan manifest activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestActivity> findAll(int start, int end,
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

        List<LFTincanManifestActivity> list = (List<LFTincanManifestActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANMANIFESTACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANMANIFESTACTIVITY;

                if (pagination) {
                    sql = sql.concat(LFTincanManifestActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanManifestActivity>(list);
                } else {
                    list = (List<LFTincanManifestActivity>) QueryUtil.list(q,
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
     * Removes all the l f tincan manifest activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanManifestActivity lfTincanManifestActivity : findAll()) {
            remove(lfTincanManifestActivity);
        }
    }

    /**
     * Returns the number of l f tincan manifest activities.
     *
     * @return the number of l f tincan manifest activities
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANMANIFESTACTIVITY);

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
     * Initializes the l f tincan manifest activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanManifestActivity>> listenersList = new ArrayList<ModelListener<LFTincanManifestActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanManifestActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanManifestActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

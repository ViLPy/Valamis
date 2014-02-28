package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanManifestActPersistence;

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
 * The persistence implementation for the l f tincan manifest act service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanManifestActPersistence
 * @see LFTincanManifestActUtil
 * @generated
 */
public class LFTincanManifestActPersistenceImpl extends BasePersistenceImpl<LFTincanManifestAct>
    implements LFTincanManifestActPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanManifestActUtil} to access the l f tincan manifest act persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanManifestActImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Long.class.getName() },
            LFTincanManifestActModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfTincanManifestAct.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfTincanManifestAct.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfTincanManifestAct.packageID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_TINCANID = new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED,
            LFTincanManifestActImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByTincanID", new String[] { String.class.getName() },
            LFTincanManifestActModelImpl.TINCANID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TINCANID = new FinderPath(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTincanID",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_1 = "lfTincanManifestAct.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL = "lfTincanManifestAct.tincanID IS NULL";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_2 = "lfTincanManifestAct.tincanID = ?";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_NULL_2 = "lfTincanManifestAct.tincanID IS NULL ";
    private static final String _FINDER_COLUMN_TINCANID_TINCANID_3 = "(lfTincanManifestAct.tincanID IS NULL OR lfTincanManifestAct.tincanID = '')";
    private static final String _SQL_SELECT_LFTINCANMANIFESTACT = "SELECT lfTincanManifestAct FROM LFTincanManifestAct lfTincanManifestAct";
    private static final String _SQL_SELECT_LFTINCANMANIFESTACT_WHERE = "SELECT lfTincanManifestAct FROM LFTincanManifestAct lfTincanManifestAct WHERE ";
    private static final String _SQL_COUNT_LFTINCANMANIFESTACT = "SELECT COUNT(lfTincanManifestAct) FROM LFTincanManifestAct lfTincanManifestAct";
    private static final String _SQL_COUNT_LFTINCANMANIFESTACT_WHERE = "SELECT COUNT(lfTincanManifestAct) FROM LFTincanManifestAct lfTincanManifestAct WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanManifestAct.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanManifestAct exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanManifestAct exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanManifestActPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanManifestAct _nullLFTincanManifestAct = new LFTincanManifestActImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanManifestAct> toCacheModel() {
                return _nullLFTincanManifestActCacheModel;
            }
        };

    private static CacheModel<LFTincanManifestAct> _nullLFTincanManifestActCacheModel =
        new CacheModel<LFTincanManifestAct>() {
            @Override
            public LFTincanManifestAct toEntityModel() {
                return _nullLFTincanManifestAct;
            }
        };

    public LFTincanManifestActPersistenceImpl() {
        setModelClass(LFTincanManifestAct.class);
    }

    /**
     * Returns all the l f tincan manifest acts where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f tincan manifest acts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestAct> findByPackageID(Long packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan manifest acts where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan manifest acts
     * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
     * @return the range of matching l f tincan manifest acts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestAct> findByPackageID(Long packageID, int start,
        int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan manifest acts where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f tincan manifest acts
     * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan manifest acts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestAct> findByPackageID(Long packageID, int start,
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

        List<LFTincanManifestAct> list = (List<LFTincanManifestAct>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanManifestAct lfTincanManifestAct : list) {
                if (!Validator.equals(packageID,
                            lfTincanManifestAct.getPackageID())) {
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

            query.append(_SQL_SELECT_LFTINCANMANIFESTACT_WHERE);

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
                query.append(LFTincanManifestActModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFTincanManifestAct>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanManifestAct>(list);
                } else {
                    list = (List<LFTincanManifestAct>) QueryUtil.list(q,
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
     * Returns the first l f tincan manifest act in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan manifest act
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct findByPackageID_First(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActException, SystemException {
        LFTincanManifestAct lfTincanManifestAct = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfTincanManifestAct != null) {
            return lfTincanManifestAct;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanManifestActException(msg.toString());
    }

    /**
     * Returns the first l f tincan manifest act in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct fetchByPackageID_First(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanManifestAct> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan manifest act in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan manifest act
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct findByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActException, SystemException {
        LFTincanManifestAct lfTincanManifestAct = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfTincanManifestAct != null) {
            return lfTincanManifestAct;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanManifestActException(msg.toString());
    }

    /**
     * Returns the last l f tincan manifest act in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct fetchByPackageID_Last(Long packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        if (count == 0) {
            return null;
        }

        List<LFTincanManifestAct> list = findByPackageID(packageID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan manifest acts before and after the current l f tincan manifest act in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f tincan manifest act
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan manifest act
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct[] findByPackageID_PrevAndNext(long id,
        Long packageID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanManifestActException, SystemException {
        LFTincanManifestAct lfTincanManifestAct = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanManifestAct[] array = new LFTincanManifestActImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfTincanManifestAct,
                    packageID, orderByComparator, true);

            array[1] = lfTincanManifestAct;

            array[2] = getByPackageID_PrevAndNext(session, lfTincanManifestAct,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanManifestAct getByPackageID_PrevAndNext(Session session,
        LFTincanManifestAct lfTincanManifestAct, Long packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANMANIFESTACT_WHERE);

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
            query.append(LFTincanManifestActModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanManifestAct);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanManifestAct> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan manifest acts where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageID(Long packageID) throws SystemException {
        for (LFTincanManifestAct lfTincanManifestAct : findByPackageID(
                packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanManifestAct);
        }
    }

    /**
     * Returns the number of l f tincan manifest acts where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f tincan manifest acts
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

            query.append(_SQL_COUNT_LFTINCANMANIFESTACT_WHERE);

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
     * Returns the l f tincan manifest act where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException} if it could not be found.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan manifest act
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct findByTincanID(String tincanID)
        throws NoSuchLFTincanManifestActException, SystemException {
        LFTincanManifestAct lfTincanManifestAct = fetchByTincanID(tincanID);

        if (lfTincanManifestAct == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("tincanID=");
            msg.append(tincanID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanManifestActException(msg.toString());
        }

        return lfTincanManifestAct;
    }

    /**
     * Returns the l f tincan manifest act where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param tincanID the tincan i d
     * @return the matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct fetchByTincanID(String tincanID)
        throws SystemException {
        return fetchByTincanID(tincanID, true);
    }

    /**
     * Returns the l f tincan manifest act where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param tincanID the tincan i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan manifest act, or <code>null</code> if a matching l f tincan manifest act could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct fetchByTincanID(String tincanID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { tincanID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TINCANID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanManifestAct) {
            LFTincanManifestAct lfTincanManifestAct = (LFTincanManifestAct) result;

            if (!Validator.equals(tincanID, lfTincanManifestAct.getTincanID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANMANIFESTACT_WHERE);

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

                List<LFTincanManifestAct> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanManifestActPersistenceImpl.fetchByTincanID(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanManifestAct lfTincanManifestAct = list.get(0);

                    result = lfTincanManifestAct;

                    cacheResult(lfTincanManifestAct);

                    if ((lfTincanManifestAct.getTincanID() == null) ||
                            !lfTincanManifestAct.getTincanID().equals(tincanID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
                            finderArgs, lfTincanManifestAct);
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
            return (LFTincanManifestAct) result;
        }
    }

    /**
     * Removes the l f tincan manifest act where tincanID = &#63; from the database.
     *
     * @param tincanID the tincan i d
     * @return the l f tincan manifest act that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct removeByTincanID(String tincanID)
        throws NoSuchLFTincanManifestActException, SystemException {
        LFTincanManifestAct lfTincanManifestAct = findByTincanID(tincanID);

        return remove(lfTincanManifestAct);
    }

    /**
     * Returns the number of l f tincan manifest acts where tincanID = &#63;.
     *
     * @param tincanID the tincan i d
     * @return the number of matching l f tincan manifest acts
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

            query.append(_SQL_COUNT_LFTINCANMANIFESTACT_WHERE);

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
     * Caches the l f tincan manifest act in the entity cache if it is enabled.
     *
     * @param lfTincanManifestAct the l f tincan manifest act
     */
    @Override
    public void cacheResult(LFTincanManifestAct lfTincanManifestAct) {
        EntityCacheUtil.putResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActImpl.class, lfTincanManifestAct.getPrimaryKey(),
            lfTincanManifestAct);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID,
            new Object[] { lfTincanManifestAct.getTincanID() },
            lfTincanManifestAct);

        lfTincanManifestAct.resetOriginalValues();
    }

    /**
     * Caches the l f tincan manifest acts in the entity cache if it is enabled.
     *
     * @param lfTincanManifestActs the l f tincan manifest acts
     */
    @Override
    public void cacheResult(List<LFTincanManifestAct> lfTincanManifestActs) {
        for (LFTincanManifestAct lfTincanManifestAct : lfTincanManifestActs) {
            if (EntityCacheUtil.getResult(
                        LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanManifestActImpl.class,
                        lfTincanManifestAct.getPrimaryKey()) == null) {
                cacheResult(lfTincanManifestAct);
            } else {
                lfTincanManifestAct.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan manifest acts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanManifestActImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanManifestActImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan manifest act.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanManifestAct lfTincanManifestAct) {
        EntityCacheUtil.removeResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActImpl.class, lfTincanManifestAct.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanManifestAct);
    }

    @Override
    public void clearCache(List<LFTincanManifestAct> lfTincanManifestActs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanManifestAct lfTincanManifestAct : lfTincanManifestActs) {
            EntityCacheUtil.removeResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanManifestActImpl.class,
                lfTincanManifestAct.getPrimaryKey());

            clearUniqueFindersCache(lfTincanManifestAct);
        }
    }

    protected void cacheUniqueFindersCache(
        LFTincanManifestAct lfTincanManifestAct) {
        if (lfTincanManifestAct.isNew()) {
            Object[] args = new Object[] { lfTincanManifestAct.getTincanID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                lfTincanManifestAct);
        } else {
            LFTincanManifestActModelImpl lfTincanManifestActModelImpl = (LFTincanManifestActModelImpl) lfTincanManifestAct;

            if ((lfTincanManifestActModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanManifestAct.getTincanID() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TINCANID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TINCANID, args,
                    lfTincanManifestAct);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFTincanManifestAct lfTincanManifestAct) {
        LFTincanManifestActModelImpl lfTincanManifestActModelImpl = (LFTincanManifestActModelImpl) lfTincanManifestAct;

        Object[] args = new Object[] { lfTincanManifestAct.getTincanID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);

        if ((lfTincanManifestActModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TINCANID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfTincanManifestActModelImpl.getOriginalTincanID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TINCANID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TINCANID, args);
        }
    }

    /**
     * Creates a new l f tincan manifest act with the primary key. Does not add the l f tincan manifest act to the database.
     *
     * @param id the primary key for the new l f tincan manifest act
     * @return the new l f tincan manifest act
     */
    @Override
    public LFTincanManifestAct create(long id) {
        LFTincanManifestAct lfTincanManifestAct = new LFTincanManifestActImpl();

        lfTincanManifestAct.setNew(true);
        lfTincanManifestAct.setPrimaryKey(id);

        return lfTincanManifestAct;
    }

    /**
     * Removes the l f tincan manifest act with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan manifest act
     * @return the l f tincan manifest act that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct remove(long id)
        throws NoSuchLFTincanManifestActException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan manifest act with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan manifest act
     * @return the l f tincan manifest act that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct remove(Serializable primaryKey)
        throws NoSuchLFTincanManifestActException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanManifestAct lfTincanManifestAct = (LFTincanManifestAct) session.get(LFTincanManifestActImpl.class,
                    primaryKey);

            if (lfTincanManifestAct == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanManifestActException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanManifestAct);
        } catch (NoSuchLFTincanManifestActException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanManifestAct removeImpl(
        LFTincanManifestAct lfTincanManifestAct) throws SystemException {
        lfTincanManifestAct = toUnwrappedModel(lfTincanManifestAct);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanManifestAct)) {
                lfTincanManifestAct = (LFTincanManifestAct) session.get(LFTincanManifestActImpl.class,
                        lfTincanManifestAct.getPrimaryKeyObj());
            }

            if (lfTincanManifestAct != null) {
                session.delete(lfTincanManifestAct);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanManifestAct != null) {
            clearCache(lfTincanManifestAct);
        }

        return lfTincanManifestAct;
    }

    @Override
    public LFTincanManifestAct updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct lfTincanManifestAct)
        throws SystemException {
        lfTincanManifestAct = toUnwrappedModel(lfTincanManifestAct);

        boolean isNew = lfTincanManifestAct.isNew();

        LFTincanManifestActModelImpl lfTincanManifestActModelImpl = (LFTincanManifestActModelImpl) lfTincanManifestAct;

        Session session = null;

        try {
            session = openSession();

            if (lfTincanManifestAct.isNew()) {
                session.save(lfTincanManifestAct);

                lfTincanManifestAct.setNew(false);
            } else {
                session.merge(lfTincanManifestAct);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanManifestActModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanManifestActModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanManifestActModelImpl.getOriginalPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { lfTincanManifestActModelImpl.getPackageID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanManifestActImpl.class, lfTincanManifestAct.getPrimaryKey(),
            lfTincanManifestAct);

        clearUniqueFindersCache(lfTincanManifestAct);
        cacheUniqueFindersCache(lfTincanManifestAct);

        return lfTincanManifestAct;
    }

    protected LFTincanManifestAct toUnwrappedModel(
        LFTincanManifestAct lfTincanManifestAct) {
        if (lfTincanManifestAct instanceof LFTincanManifestActImpl) {
            return lfTincanManifestAct;
        }

        LFTincanManifestActImpl lfTincanManifestActImpl = new LFTincanManifestActImpl();

        lfTincanManifestActImpl.setNew(lfTincanManifestAct.isNew());
        lfTincanManifestActImpl.setPrimaryKey(lfTincanManifestAct.getPrimaryKey());

        lfTincanManifestActImpl.setId(lfTincanManifestAct.getId());
        lfTincanManifestActImpl.setTincanID(lfTincanManifestAct.getTincanID());
        lfTincanManifestActImpl.setPackageID(lfTincanManifestAct.getPackageID());
        lfTincanManifestActImpl.setActivityType(lfTincanManifestAct.getActivityType());
        lfTincanManifestActImpl.setName(lfTincanManifestAct.getName());
        lfTincanManifestActImpl.setDescription(lfTincanManifestAct.getDescription());
        lfTincanManifestActImpl.setLaunch(lfTincanManifestAct.getLaunch());
        lfTincanManifestActImpl.setResourceID(lfTincanManifestAct.getResourceID());

        return lfTincanManifestActImpl;
    }

    /**
     * Returns the l f tincan manifest act with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan manifest act
     * @return the l f tincan manifest act
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanManifestActException, SystemException {
        LFTincanManifestAct lfTincanManifestAct = fetchByPrimaryKey(primaryKey);

        if (lfTincanManifestAct == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanManifestActException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanManifestAct;
    }

    /**
     * Returns the l f tincan manifest act with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException} if it could not be found.
     *
     * @param id the primary key of the l f tincan manifest act
     * @return the l f tincan manifest act
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct findByPrimaryKey(long id)
        throws NoSuchLFTincanManifestActException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan manifest act with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan manifest act
     * @return the l f tincan manifest act, or <code>null</code> if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanManifestAct lfTincanManifestAct = (LFTincanManifestAct) EntityCacheUtil.getResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanManifestActImpl.class, primaryKey);

        if (lfTincanManifestAct == _nullLFTincanManifestAct) {
            return null;
        }

        if (lfTincanManifestAct == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanManifestAct = (LFTincanManifestAct) session.get(LFTincanManifestActImpl.class,
                        primaryKey);

                if (lfTincanManifestAct != null) {
                    cacheResult(lfTincanManifestAct);
                } else {
                    EntityCacheUtil.putResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanManifestActImpl.class, primaryKey,
                        _nullLFTincanManifestAct);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanManifestActModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanManifestActImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanManifestAct;
    }

    /**
     * Returns the l f tincan manifest act with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan manifest act
     * @return the l f tincan manifest act, or <code>null</code> if a l f tincan manifest act with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanManifestAct fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan manifest acts.
     *
     * @return the l f tincan manifest acts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestAct> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan manifest acts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan manifest acts
     * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
     * @return the range of l f tincan manifest acts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestAct> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan manifest acts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanManifestActModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan manifest acts
     * @param end the upper bound of the range of l f tincan manifest acts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan manifest acts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanManifestAct> findAll(int start, int end,
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

        List<LFTincanManifestAct> list = (List<LFTincanManifestAct>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANMANIFESTACT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANMANIFESTACT;

                if (pagination) {
                    sql = sql.concat(LFTincanManifestActModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanManifestAct>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanManifestAct>(list);
                } else {
                    list = (List<LFTincanManifestAct>) QueryUtil.list(q,
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
     * Removes all the l f tincan manifest acts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanManifestAct lfTincanManifestAct : findAll()) {
            remove(lfTincanManifestAct);
        }
    }

    /**
     * Returns the number of l f tincan manifest acts.
     *
     * @return the number of l f tincan manifest acts
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANMANIFESTACT);

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
     * Initializes the l f tincan manifest act persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanManifestAct>> listenersList = new ArrayList<ModelListener<LFTincanManifestAct>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanManifestAct>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanManifestActImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityException;
import com.arcusys.learn.persistence.liferay.model.LFActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFActivityPersistence;

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
 * The persistence implementation for the l f activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityPersistence
 * @see LFActivityUtil
 * @generated
 */
public class LFActivityPersistenceImpl extends BasePersistenceImpl<LFActivity>
    implements LFActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFActivityUtil} to access the l f activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_PACKAGEANDID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByPackageAndID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityModelImpl.ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEANDID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageAndID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL = "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEANDID_PACKAGEID_2 = "lfActivity.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL_2 = "lfActivity.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_1 = "lfActivity.id IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_NULL = "lfActivity.id IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_2 = "lfActivity.id = ?";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_NULL_2 = "lfActivity.id IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEANDID_ID_3 = "(lfActivity.id IS NULL OR lfActivity.id = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Integer.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfActivity.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfActivity.packageID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageIDAndOrganizationID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPackageIDAndOrganizationID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndOrganizationID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL =
        "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2 =
        "lfActivity.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2 =
        "lfActivity.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1 =
        "lfActivity.organizationID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_NULL =
        "lfActivity.organizationID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2 =
        "lfActivity.organizationID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_NULL_2 =
        "lfActivity.organizationID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3 =
        "(lfActivity.organizationID IS NULL OR lfActivity.organizationID = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageIDAndParentID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID =
        new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, LFActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPackageIDAndParentID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFActivityModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFActivityModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID = new FinderPath(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndParentID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL =
        "lfActivity.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2 = "lfActivity.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2 =
        "lfActivity.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1 = "lfActivity.parentID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_NULL =
        "lfActivity.parentID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2 = "lfActivity.parentID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_NULL_2 =
        "lfActivity.parentID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3 = "(lfActivity.parentID IS NULL OR lfActivity.parentID = '')";
    private static final String _SQL_SELECT_LFACTIVITY = "SELECT lfActivity FROM LFActivity lfActivity";
    private static final String _SQL_SELECT_LFACTIVITY_WHERE = "SELECT lfActivity FROM LFActivity lfActivity WHERE ";
    private static final String _SQL_COUNT_LFACTIVITY = "SELECT COUNT(lfActivity) FROM LFActivity lfActivity";
    private static final String _SQL_COUNT_LFACTIVITY_WHERE = "SELECT COUNT(lfActivity) FROM LFActivity lfActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFActivityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFActivity _nullLFActivity = new LFActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFActivity> toCacheModel() {
                return _nullLFActivityCacheModel;
            }
        };

    private static CacheModel<LFActivity> _nullLFActivityCacheModel = new CacheModel<LFActivity>() {
            @Override
            public LFActivity toEntityModel() {
                return _nullLFActivity;
            }
        };

    public LFActivityPersistenceImpl() {
        setModelClass(LFActivity.class);
    }

    /**
     * Returns the l f activity where packageID = &#63; and id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageAndID(Integer packageID, String id)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageAndID(packageID, id);

        if (lfActivity == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("packageID=");
            msg.append(packageID);

            msg.append(", id=");
            msg.append(id);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFActivityException(msg.toString());
        }

        return lfActivity;
    }

    /**
     * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageAndID(Integer packageID, String id)
        throws SystemException {
        return fetchByPackageAndID(packageID, id, true);
    }

    /**
     * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param packageID the package i d
     * @param id the ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageAndID(Integer packageID, String id,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { packageID, id };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                    finderArgs, this);
        }

        if (result instanceof LFActivity) {
            LFActivity lfActivity = (LFActivity) result;

            if (!Validator.equals(packageID, lfActivity.getPackageID()) ||
                    !Validator.equals(id, lfActivity.getId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_2);
            }

            boolean bindId = false;

            if (id == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_ID_1);
            } else if (id.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_ID_3);
            } else {
                bindId = true;

                if (id.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindId) {
                    if (id != null) {
                        qPos.add(id);
                    }
                }

                List<LFActivity> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFActivityPersistenceImpl.fetchByPackageAndID(Integer, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFActivity lfActivity = list.get(0);

                    result = lfActivity;

                    cacheResult(lfActivity);

                    if ((lfActivity.getPackageID() != packageID) ||
                            (lfActivity.getId() == null) ||
                            !lfActivity.getId().equals(id)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                            finderArgs, lfActivity);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFActivity) result;
        }
    }

    /**
     * Removes the l f activity where packageID = &#63; and id = &#63; from the database.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the l f activity that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity removeByPackageAndID(Integer packageID, String id)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPackageAndID(packageID, id);

        return remove(lfActivity);
    }

    /**
     * Returns the number of l f activities where packageID = &#63; and id = &#63;.
     *
     * @param packageID the package i d
     * @param id the ID
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageAndID(Integer packageID, String id)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEANDID;

        Object[] finderArgs = new Object[] { packageID, id };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEANDID_PACKAGEID_2);
            }

            boolean bindId = false;

            if (id == null) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_ID_1);
            } else if (id.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEANDID_ID_3);
            } else {
                bindId = true;

                if (id.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEANDID_ID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindId) {
                    if (id != null) {
                        qPos.add(id);
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
     * Returns all the l f activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageID(Integer packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageID(Integer packageID, int start,
        int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageID(Integer packageID, int start,
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

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivity lfActivity : list) {
                if (!Validator.equals(packageID, lfActivity.getPackageID())) {
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

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

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
                query.append(LFActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (!pagination) {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivity>(list);
                } else {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the first l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivity> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        if (count == 0) {
            return null;
        }

        List<LFActivity> list = findByPackageID(packageID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63;.
     *
     * @param indexNumber the primary key of the current l f activity
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity[] findByPackageID_PrevAndNext(long indexNumber,
        Integer packageID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPrimaryKey(indexNumber);

        Session session = null;

        try {
            session = openSession();

            LFActivity[] array = new LFActivityImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfActivity,
                    packageID, orderByComparator, true);

            array[1] = lfActivity;

            array[2] = getByPackageID_PrevAndNext(session, lfActivity,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivity getByPackageID_PrevAndNext(Session session,
        LFActivity lfActivity, Integer packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITY_WHERE);

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
            query.append(LFActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f activities where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageID(Integer packageID) throws SystemException {
        for (LFActivity lfActivity : findByPackageID(packageID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfActivity);
        }
    }

    /**
     * Returns the number of l f activities where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageID(Integer packageID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

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
                    qPos.add(packageID.intValue());
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
     * Returns all the l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @return the matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageIDAndOrganizationID(
        Integer packageID, String organizationID) throws SystemException {
        return findByPackageIDAndOrganizationID(packageID, organizationID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageIDAndOrganizationID(
        Integer packageID, String organizationID, int start, int end)
        throws SystemException {
        return findByPackageIDAndOrganizationID(packageID, organizationID,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageIDAndOrganizationID(
        Integer packageID, String organizationID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID;
            finderArgs = new Object[] { packageID, organizationID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID;
            finderArgs = new Object[] {
                    packageID, organizationID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivity lfActivity : list) {
                if (!Validator.equals(packageID, lfActivity.getPackageID()) ||
                        !Validator.equals(organizationID,
                            lfActivity.getOrganizationID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2);
            }

            boolean bindOrganizationID = false;

            if (organizationID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1);
            } else if (organizationID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
            } else {
                bindOrganizationID = true;

                if (organizationID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindOrganizationID) {
                    if (organizationID != null) {
                        qPos.add(organizationID);
                    }
                }

                if (!pagination) {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivity>(list);
                } else {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageIDAndOrganizationID_First(
        Integer packageID, String organizationID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndOrganizationID_First(packageID,
                organizationID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", organizationID=");
        msg.append(organizationID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageIDAndOrganizationID_First(
        Integer packageID, String organizationID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFActivity> list = findByPackageIDAndOrganizationID(packageID,
                organizationID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageIDAndOrganizationID_Last(Integer packageID,
        String organizationID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndOrganizationID_Last(packageID,
                organizationID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", organizationID=");
        msg.append(organizationID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageIDAndOrganizationID_Last(
        Integer packageID, String organizationID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageIDAndOrganizationID(packageID, organizationID);

        if (count == 0) {
            return null;
        }

        List<LFActivity> list = findByPackageIDAndOrganizationID(packageID,
                organizationID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
     *
     * @param indexNumber the primary key of the current l f activity
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity[] findByPackageIDAndOrganizationID_PrevAndNext(
        long indexNumber, Integer packageID, String organizationID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPrimaryKey(indexNumber);

        Session session = null;

        try {
            session = openSession();

            LFActivity[] array = new LFActivityImpl[3];

            array[0] = getByPackageIDAndOrganizationID_PrevAndNext(session,
                    lfActivity, packageID, organizationID, orderByComparator,
                    true);

            array[1] = lfActivity;

            array[2] = getByPackageIDAndOrganizationID_PrevAndNext(session,
                    lfActivity, packageID, organizationID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivity getByPackageIDAndOrganizationID_PrevAndNext(
        Session session, LFActivity lfActivity, Integer packageID,
        String organizationID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITY_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2);
        }

        boolean bindOrganizationID = false;

        if (organizationID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1);
        } else if (organizationID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
        } else {
            bindOrganizationID = true;

            if (organizationID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2);
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
            query.append(LFActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (bindOrganizationID) {
            if (organizationID != null) {
                qPos.add(organizationID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f activities where packageID = &#63; and organizationID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageIDAndOrganizationID(Integer packageID,
        String organizationID) throws SystemException {
        for (LFActivity lfActivity : findByPackageIDAndOrganizationID(
                packageID, organizationID, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfActivity);
        }
    }

    /**
     * Returns the number of l f activities where packageID = &#63; and organizationID = &#63;.
     *
     * @param packageID the package i d
     * @param organizationID the organization i d
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageIDAndOrganizationID(Integer packageID,
        String organizationID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID;

        Object[] finderArgs = new Object[] { packageID, organizationID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_PACKAGEID_2);
            }

            boolean bindOrganizationID = false;

            if (organizationID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_1);
            } else if (organizationID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
            } else {
                bindOrganizationID = true;

                if (organizationID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDORGANIZATIONID_ORGANIZATIONID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindOrganizationID) {
                    if (organizationID != null) {
                        qPos.add(organizationID);
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
     * Returns all the l f activities where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @return the matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageIDAndParentID(Integer packageID,
        String parentID) throws SystemException {
        return findByPackageIDAndParentID(packageID, parentID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activities where packageID = &#63; and parentID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageIDAndParentID(Integer packageID,
        String parentID, int start, int end) throws SystemException {
        return findByPackageIDAndParentID(packageID, parentID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities where packageID = &#63; and parentID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findByPackageIDAndParentID(Integer packageID,
        String parentID, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID;
            finderArgs = new Object[] { packageID, parentID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID;
            finderArgs = new Object[] {
                    packageID, parentID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFActivity lfActivity : list) {
                if (!Validator.equals(packageID, lfActivity.getPackageID()) ||
                        !Validator.equals(parentID, lfActivity.getParentID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2);
            }

            boolean bindParentID = false;

            if (parentID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1);
            } else if (parentID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
            } else {
                bindParentID = true;

                if (parentID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindParentID) {
                    if (parentID != null) {
                        qPos.add(parentID);
                    }
                }

                if (!pagination) {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivity>(list);
                } else {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageIDAndParentID_First(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndParentID_First(packageID,
                parentID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageIDAndParentID_First(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFActivity> list = findByPackageIDAndParentID(packageID, parentID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPackageIDAndParentID_Last(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPackageIDAndParentID_Last(packageID,
                parentID, orderByComparator);

        if (lfActivity != null) {
            return lfActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", parentID=");
        msg.append(parentID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFActivityException(msg.toString());
    }

    /**
     * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPackageIDAndParentID_Last(Integer packageID,
        String parentID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByPackageIDAndParentID(packageID, parentID);

        if (count == 0) {
            return null;
        }

        List<LFActivity> list = findByPackageIDAndParentID(packageID, parentID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
     *
     * @param indexNumber the primary key of the current l f activity
     * @param packageID the package i d
     * @param parentID the parent i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity[] findByPackageIDAndParentID_PrevAndNext(
        long indexNumber, Integer packageID, String parentID,
        OrderByComparator orderByComparator)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = findByPrimaryKey(indexNumber);

        Session session = null;

        try {
            session = openSession();

            LFActivity[] array = new LFActivityImpl[3];

            array[0] = getByPackageIDAndParentID_PrevAndNext(session,
                    lfActivity, packageID, parentID, orderByComparator, true);

            array[1] = lfActivity;

            array[2] = getByPackageIDAndParentID_PrevAndNext(session,
                    lfActivity, packageID, parentID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFActivity getByPackageIDAndParentID_PrevAndNext(
        Session session, LFActivity lfActivity, Integer packageID,
        String parentID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACTIVITY_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2);
        }

        boolean bindParentID = false;

        if (parentID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1);
        } else if (parentID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
        } else {
            bindParentID = true;

            if (parentID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2);
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
            query.append(LFActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (bindParentID) {
            if (parentID != null) {
                qPos.add(parentID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f activities where packageID = &#63; and parentID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageIDAndParentID(Integer packageID, String parentID)
        throws SystemException {
        for (LFActivity lfActivity : findByPackageIDAndParentID(packageID,
                parentID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfActivity);
        }
    }

    /**
     * Returns the number of l f activities where packageID = &#63; and parentID = &#63;.
     *
     * @param packageID the package i d
     * @param parentID the parent i d
     * @return the number of matching l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageIDAndParentID(Integer packageID, String parentID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID;

        Object[] finderArgs = new Object[] { packageID, parentID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACTIVITY_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PACKAGEID_2);
            }

            boolean bindParentID = false;

            if (parentID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_1);
            } else if (parentID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
            } else {
                bindParentID = true;

                if (parentID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDPARENTID_PARENTID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindParentID) {
                    if (parentID != null) {
                        qPos.add(parentID);
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
     * Caches the l f activity in the entity cache if it is enabled.
     *
     * @param lfActivity the l f activity
     */
    @Override
    public void cacheResult(LFActivity lfActivity) {
        EntityCacheUtil.putResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityImpl.class, lfActivity.getPrimaryKey(), lfActivity);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
            new Object[] { lfActivity.getPackageID(), lfActivity.getId() },
            lfActivity);

        lfActivity.resetOriginalValues();
    }

    /**
     * Caches the l f activities in the entity cache if it is enabled.
     *
     * @param lfActivities the l f activities
     */
    @Override
    public void cacheResult(List<LFActivity> lfActivities) {
        for (LFActivity lfActivity : lfActivities) {
            if (EntityCacheUtil.getResult(
                        LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityImpl.class, lfActivity.getPrimaryKey()) == null) {
                cacheResult(lfActivity);
            } else {
                lfActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFActivity lfActivity) {
        EntityCacheUtil.removeResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityImpl.class, lfActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfActivity);
    }

    @Override
    public void clearCache(List<LFActivity> lfActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFActivity lfActivity : lfActivities) {
            EntityCacheUtil.removeResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityImpl.class, lfActivity.getPrimaryKey());

            clearUniqueFindersCache(lfActivity);
        }
    }

    protected void cacheUniqueFindersCache(LFActivity lfActivity) {
        if (lfActivity.isNew()) {
            Object[] args = new Object[] {
                    lfActivity.getPackageID(), lfActivity.getId()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEANDID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID, args,
                lfActivity);
        } else {
            LFActivityModelImpl lfActivityModelImpl = (LFActivityModelImpl) lfActivity;

            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_PACKAGEANDID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivity.getPackageID(), lfActivity.getId()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PACKAGEANDID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PACKAGEANDID,
                    args, lfActivity);
            }
        }
    }

    protected void clearUniqueFindersCache(LFActivity lfActivity) {
        LFActivityModelImpl lfActivityModelImpl = (LFActivityModelImpl) lfActivity;

        Object[] args = new Object[] {
                lfActivity.getPackageID(), lfActivity.getId()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEANDID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEANDID, args);

        if ((lfActivityModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_PACKAGEANDID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfActivityModelImpl.getOriginalPackageID(),
                    lfActivityModelImpl.getOriginalId()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEANDID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PACKAGEANDID, args);
        }
    }

    /**
     * Creates a new l f activity with the primary key. Does not add the l f activity to the database.
     *
     * @param indexNumber the primary key for the new l f activity
     * @return the new l f activity
     */
    @Override
    public LFActivity create(long indexNumber) {
        LFActivity lfActivity = new LFActivityImpl();

        lfActivity.setNew(true);
        lfActivity.setPrimaryKey(indexNumber);

        return lfActivity;
    }

    /**
     * Removes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param indexNumber the primary key of the l f activity
     * @return the l f activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity remove(long indexNumber)
        throws NoSuchLFActivityException, SystemException {
        return remove((Serializable) indexNumber);
    }

    /**
     * Removes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f activity
     * @return the l f activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity remove(Serializable primaryKey)
        throws NoSuchLFActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFActivity lfActivity = (LFActivity) session.get(LFActivityImpl.class,
                    primaryKey);

            if (lfActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfActivity);
        } catch (NoSuchLFActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFActivity removeImpl(LFActivity lfActivity)
        throws SystemException {
        lfActivity = toUnwrappedModel(lfActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfActivity)) {
                lfActivity = (LFActivity) session.get(LFActivityImpl.class,
                        lfActivity.getPrimaryKeyObj());
            }

            if (lfActivity != null) {
                session.delete(lfActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfActivity != null) {
            clearCache(lfActivity);
        }

        return lfActivity;
    }

    @Override
    public LFActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws SystemException {
        lfActivity = toUnwrappedModel(lfActivity);

        boolean isNew = lfActivity.isNew();

        LFActivityModelImpl lfActivityModelImpl = (LFActivityModelImpl) lfActivity;

        Session session = null;

        try {
            session = openSession();

            if (lfActivity.isNew()) {
                session.save(lfActivity);

                lfActivity.setNew(false);
            } else {
                session.merge(lfActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityModelImpl.getOriginalPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { lfActivityModelImpl.getPackageID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }

            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityModelImpl.getOriginalPackageID(),
                        lfActivityModelImpl.getOriginalOrganizationID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID,
                    args);

                args = new Object[] {
                        lfActivityModelImpl.getPackageID(),
                        lfActivityModelImpl.getOrganizationID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDORGANIZATIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDORGANIZATIONID,
                    args);
            }

            if ((lfActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfActivityModelImpl.getOriginalPackageID(),
                        lfActivityModelImpl.getOriginalParentID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID,
                    args);

                args = new Object[] {
                        lfActivityModelImpl.getPackageID(),
                        lfActivityModelImpl.getParentID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDPARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFActivityImpl.class, lfActivity.getPrimaryKey(), lfActivity);

        clearUniqueFindersCache(lfActivity);
        cacheUniqueFindersCache(lfActivity);

        return lfActivity;
    }

    protected LFActivity toUnwrappedModel(LFActivity lfActivity) {
        if (lfActivity instanceof LFActivityImpl) {
            return lfActivity;
        }

        LFActivityImpl lfActivityImpl = new LFActivityImpl();

        lfActivityImpl.setNew(lfActivity.isNew());
        lfActivityImpl.setPrimaryKey(lfActivity.getPrimaryKey());

        lfActivityImpl.setIndexNumber(lfActivity.getIndexNumber());
        lfActivityImpl.setId(lfActivity.getId());
        lfActivityImpl.setPackageID(lfActivity.getPackageID());
        lfActivityImpl.setOrganizationID(lfActivity.getOrganizationID());
        lfActivityImpl.setParentID(lfActivity.getParentID());
        lfActivityImpl.setTitle(lfActivity.getTitle());
        lfActivityImpl.setIdentifierRef(lfActivity.getIdentifierRef());
        lfActivityImpl.setResourceParameters(lfActivity.getResourceParameters());
        lfActivityImpl.setHideLMSUI(lfActivity.getHideLMSUI());
        lfActivityImpl.setVisible(lfActivity.isVisible());
        lfActivityImpl.setObjectivesGlobalToSystem(lfActivity.isObjectivesGlobalToSystem());
        lfActivityImpl.setSharedDataGlobalToSystem(lfActivity.isSharedDataGlobalToSystem());
        lfActivityImpl.setMasteryScore(lfActivity.getMasteryScore());
        lfActivityImpl.setMaxTimeAllowed(lfActivity.getMaxTimeAllowed());

        return lfActivityImpl;
    }

    /**
     * Returns the l f activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity
     * @return the l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFActivityException, SystemException {
        LFActivity lfActivity = fetchByPrimaryKey(primaryKey);

        if (lfActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfActivity;
    }

    /**
     * Returns the l f activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
     *
     * @param indexNumber the primary key of the l f activity
     * @return the l f activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity findByPrimaryKey(long indexNumber)
        throws NoSuchLFActivityException, SystemException {
        return findByPrimaryKey((Serializable) indexNumber);
    }

    /**
     * Returns the l f activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f activity
     * @return the l f activity, or <code>null</code> if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFActivity lfActivity = (LFActivity) EntityCacheUtil.getResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFActivityImpl.class, primaryKey);

        if (lfActivity == _nullLFActivity) {
            return null;
        }

        if (lfActivity == null) {
            Session session = null;

            try {
                session = openSession();

                lfActivity = (LFActivity) session.get(LFActivityImpl.class,
                        primaryKey);

                if (lfActivity != null) {
                    cacheResult(lfActivity);
                } else {
                    EntityCacheUtil.putResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFActivityImpl.class, primaryKey, _nullLFActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFActivityModelImpl.ENTITY_CACHE_ENABLED,
                    LFActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfActivity;
    }

    /**
     * Returns the l f activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param indexNumber the primary key of the l f activity
     * @return the l f activity, or <code>null</code> if a l f activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFActivity fetchByPrimaryKey(long indexNumber)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) indexNumber);
    }

    /**
     * Returns all the l f activities.
     *
     * @return the l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @return the range of l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f activities
     * @param end the upper bound of the range of l f activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFActivity> findAll(int start, int end,
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

        List<LFActivity> list = (List<LFActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACTIVITY;

                if (pagination) {
                    sql = sql.concat(LFActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFActivity>(list);
                } else {
                    list = (List<LFActivity>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFActivity lfActivity : findAll()) {
            remove(lfActivity);
        }
    }

    /**
     * Returns the number of l f activities.
     *
     * @return the number of l f activities
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

                Query q = session.createQuery(_SQL_COUNT_LFACTIVITY);

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
     * Initializes the l f activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFActivity>> listenersList = new ArrayList<ModelListener<LFActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

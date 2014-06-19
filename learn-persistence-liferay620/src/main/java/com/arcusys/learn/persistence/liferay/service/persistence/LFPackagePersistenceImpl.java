package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageException;
import com.arcusys.learn.persistence.liferay.model.LFPackage;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFPackagePersistence;

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
 * The persistence implementation for the l f package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackagePersistence
 * @see LFPackageUtil
 * @generated
 */
public class LFPackagePersistenceImpl extends BasePersistenceImpl<LFPackage>
    implements LFPackagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFPackageUtil} to access the l f package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFPackageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_REFID = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByRefID",
            new String[] { Long.class.getName() },
            LFPackageModelImpl.ASSETREFID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REFID = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRefID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_NULL = "lfPackage.assetRefID IS NULL";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_2 = "lfPackage.assetRefID = ?";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_NULL_2 = "lfPackage.assetRefID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstance",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE =
        new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstance",
            new String[] { Integer.class.getName() },
            LFPackageModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_INSTANCE = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstance",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE =
        new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByInstance",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_NULL = "lfPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_2 = "lfPackage.courseID = ?";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_NULL_2 = "lfPackage.courseID IS NULL ";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_INSTANCE_COURSEID_2) + ")";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, LFPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseID",
            new String[] { Integer.class.getName() },
            LFPackageModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lfPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lfPackage.courseID = ?";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lfPackage.courseID IS NULL ";
    private static final String _SQL_SELECT_LFPACKAGE = "SELECT lfPackage FROM LFPackage lfPackage";
    private static final String _SQL_SELECT_LFPACKAGE_WHERE = "SELECT lfPackage FROM LFPackage lfPackage WHERE ";
    private static final String _SQL_COUNT_LFPACKAGE = "SELECT COUNT(lfPackage) FROM LFPackage lfPackage";
    private static final String _SQL_COUNT_LFPACKAGE_WHERE = "SELECT COUNT(lfPackage) FROM LFPackage lfPackage WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfPackage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFPackage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFPackage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFPackagePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFPackage _nullLFPackage = new LFPackageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFPackage> toCacheModel() {
                return _nullLFPackageCacheModel;
            }
        };

    private static CacheModel<LFPackage> _nullLFPackageCacheModel = new CacheModel<LFPackage>() {
            @Override
            public LFPackage toEntityModel() {
                return _nullLFPackage;
            }
        };

    public LFPackagePersistenceImpl() {
        setModelClass(LFPackage.class);
    }

    /**
     * Returns the l f package where assetRefID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageException} if it could not be found.
     *
     * @param assetRefID the asset ref i d
     * @return the matching l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByRefID(Long assetRefID)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = fetchByRefID(assetRefID);

        if (lfPackage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("assetRefID=");
            msg.append(assetRefID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFPackageException(msg.toString());
        }

        return lfPackage;
    }

    /**
     * Returns the l f package where assetRefID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param assetRefID the asset ref i d
     * @return the matching l f package, or <code>null</code> if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByRefID(Long assetRefID) throws SystemException {
        return fetchByRefID(assetRefID, true);
    }

    /**
     * Returns the l f package where assetRefID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param assetRefID the asset ref i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f package, or <code>null</code> if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByRefID(Long assetRefID, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { assetRefID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REFID,
                    finderArgs, this);
        }

        if (result instanceof LFPackage) {
            LFPackage lfPackage = (LFPackage) result;

            if (!Validator.equals(assetRefID, lfPackage.getAssetRefID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFPACKAGE_WHERE);

            if (assetRefID == null) {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (assetRefID != null) {
                    qPos.add(assetRefID.longValue());
                }

                List<LFPackage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFPackagePersistenceImpl.fetchByRefID(Long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFPackage lfPackage = list.get(0);

                    result = lfPackage;

                    cacheResult(lfPackage);

                    if ((lfPackage.getAssetRefID() != assetRefID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                            finderArgs, lfPackage);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFPackage) result;
        }
    }

    /**
     * Removes the l f package where assetRefID = &#63; from the database.
     *
     * @param assetRefID the asset ref i d
     * @return the l f package that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage removeByRefID(Long assetRefID)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = findByRefID(assetRefID);

        return remove(lfPackage);
    }

    /**
     * Returns the number of l f packages where assetRefID = &#63;.
     *
     * @param assetRefID the asset ref i d
     * @return the number of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRefID(Long assetRefID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_REFID;

        Object[] finderArgs = new Object[] { assetRefID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFPACKAGE_WHERE);

            if (assetRefID == null) {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_REFID_ASSETREFID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (assetRefID != null) {
                    qPos.add(assetRefID.longValue());
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
     * Returns all the l f packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByInstance(Integer courseID)
        throws SystemException {
        return findByInstance(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @return the range of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByInstance(Integer courseID, int start, int end)
        throws SystemException {
        return findByInstance(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByInstance(Integer courseID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE;
            finderArgs = new Object[] { courseID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE;
            finderArgs = new Object[] { courseID, start, end, orderByComparator };
        }

        List<LFPackage> list = (List<LFPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackage lfPackage : list) {
                if (!Validator.equals(courseID, lfPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                if (!pagination) {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackage>(list);
                } else {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByInstance_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = fetchByInstance_First(courseID, orderByComparator);

        if (lfPackage != null) {
            return lfPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageException(msg.toString());
    }

    /**
     * Returns the first l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package, or <code>null</code> if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByInstance_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPackage> list = findByInstance(courseID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByInstance_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = fetchByInstance_Last(courseID, orderByComparator);

        if (lfPackage != null) {
            return lfPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageException(msg.toString());
    }

    /**
     * Returns the last l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package, or <code>null</code> if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByInstance_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByInstance(courseID);

        if (count == 0) {
            return null;
        }

        List<LFPackage> list = findByInstance(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f packages before and after the current l f package in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f package
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage[] findByInstance_PrevAndNext(long id, Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackage[] array = new LFPackageImpl[3];

            array[0] = getByInstance_PrevAndNext(session, lfPackage, courseID,
                    orderByComparator, true);

            array[1] = lfPackage;

            array[2] = getByInstance_PrevAndNext(session, lfPackage, courseID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackage getByInstance_PrevAndNext(Session session,
        LFPackage lfPackage, Integer courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGE_WHERE);

        if (courseID == null) {
            query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_INSTANCE_COURSEID_2);
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
            query.append(LFPackageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (courseID != null) {
            qPos.add(courseID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @return the matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByInstance(Integer[] courseIDs)
        throws SystemException {
        return findByInstance(courseIDs, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @return the range of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByInstance(Integer[] courseIDs, int start,
        int end) throws SystemException {
        return findByInstance(courseIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByInstance(Integer[] courseIDs, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if ((courseIDs != null) && (courseIDs.length == 1)) {
            return findByInstance(courseIDs[0], start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(courseIDs) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(courseIDs),
                    
                    start, end, orderByComparator
                };
        }

        List<LFPackage> list = (List<LFPackage>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackage lfPackage : list) {
                if (!ArrayUtil.contains(courseIDs, lfPackage.getCourseID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFPACKAGE_WHERE);

            boolean conjunctionable = false;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_5);
                    }

                    if ((i + 1) < courseIDs.length) {
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
                query.append(LFPackageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseIDs != null) {
                    for (Integer courseID : courseIDs) {
                        if (courseID != null) {
                            qPos.add(courseID);
                        }
                    }
                }

                if (!pagination) {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackage>(list);
                } else {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f packages where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByInstance(Integer courseID) throws SystemException {
        for (LFPackage lfPackage : findByInstance(courseID, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfPackage);
        }
    }

    /**
     * Returns the number of l f packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByInstance(Integer courseID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTANCE;

        Object[] finderArgs = new Object[] { courseID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_INSTANCE_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
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
     * Returns the number of l f packages where courseID = any &#63;.
     *
     * @param courseIDs the course i ds
     * @return the number of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByInstance(Integer[] courseIDs) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(courseIDs) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFPACKAGE_WHERE);

            boolean conjunctionable = false;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_INSTANCE_COURSEID_5);
                    }

                    if ((i + 1) < courseIDs.length) {
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

                if (courseIDs != null) {
                    for (Integer courseID : courseIDs) {
                        if (courseID != null) {
                            qPos.add(courseID);
                        }
                    }
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the l f packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByCourseID(Integer courseID)
        throws SystemException {
        return findByCourseID(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @return the range of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByCourseID(Integer courseID, int start, int end)
        throws SystemException {
        return findByCourseID(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findByCourseID(Integer courseID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID;
            finderArgs = new Object[] { courseID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID;
            finderArgs = new Object[] { courseID, start, end, orderByComparator };
        }

        List<LFPackage> list = (List<LFPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFPackage lfPackage : list) {
                if (!Validator.equals(courseID, lfPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFPackageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                if (!pagination) {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackage>(list);
                } else {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = fetchByCourseID_First(courseID, orderByComparator);

        if (lfPackage != null) {
            return lfPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageException(msg.toString());
    }

    /**
     * Returns the first l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f package, or <code>null</code> if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFPackage> list = findByCourseID(courseID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = fetchByCourseID_Last(courseID, orderByComparator);

        if (lfPackage != null) {
            return lfPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFPackageException(msg.toString());
    }

    /**
     * Returns the last l f package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f package, or <code>null</code> if a matching l f package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseID(courseID);

        if (count == 0) {
            return null;
        }

        List<LFPackage> list = findByCourseID(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f packages before and after the current l f package in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f package
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage[] findByCourseID_PrevAndNext(long id, Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFPackage[] array = new LFPackageImpl[3];

            array[0] = getByCourseID_PrevAndNext(session, lfPackage, courseID,
                    orderByComparator, true);

            array[1] = lfPackage;

            array[2] = getByCourseID_PrevAndNext(session, lfPackage, courseID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFPackage getByCourseID_PrevAndNext(Session session,
        LFPackage lfPackage, Integer courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFPACKAGE_WHERE);

        if (courseID == null) {
            query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
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
            query.append(LFPackageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (courseID != null) {
            qPos.add(courseID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f packages where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCourseID(Integer courseID) throws SystemException {
        for (LFPackage lfPackage : findByCourseID(courseID, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfPackage);
        }
    }

    /**
     * Returns the number of l f packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCourseID(Integer courseID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

        Object[] finderArgs = new Object[] { courseID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFPACKAGE_WHERE);

            if (courseID == null) {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.intValue());
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
     * Caches the l f package in the entity cache if it is enabled.
     *
     * @param lfPackage the l f package
     */
    @Override
    public void cacheResult(LFPackage lfPackage) {
        EntityCacheUtil.putResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageImpl.class, lfPackage.getPrimaryKey(), lfPackage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
            new Object[] { lfPackage.getAssetRefID() }, lfPackage);

        lfPackage.resetOriginalValues();
    }

    /**
     * Caches the l f packages in the entity cache if it is enabled.
     *
     * @param lfPackages the l f packages
     */
    @Override
    public void cacheResult(List<LFPackage> lfPackages) {
        for (LFPackage lfPackage : lfPackages) {
            if (EntityCacheUtil.getResult(
                        LFPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageImpl.class, lfPackage.getPrimaryKey()) == null) {
                cacheResult(lfPackage);
            } else {
                lfPackage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f packages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFPackageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFPackageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f package.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFPackage lfPackage) {
        EntityCacheUtil.removeResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageImpl.class, lfPackage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfPackage);
    }

    @Override
    public void clearCache(List<LFPackage> lfPackages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFPackage lfPackage : lfPackages) {
            EntityCacheUtil.removeResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageImpl.class, lfPackage.getPrimaryKey());

            clearUniqueFindersCache(lfPackage);
        }
    }

    protected void cacheUniqueFindersCache(LFPackage lfPackage) {
        if (lfPackage.isNew()) {
            Object[] args = new Object[] { lfPackage.getAssetRefID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REFID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID, args,
                lfPackage);
        } else {
            LFPackageModelImpl lfPackageModelImpl = (LFPackageModelImpl) lfPackage;

            if ((lfPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_REFID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfPackage.getAssetRefID() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REFID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID, args,
                    lfPackage);
            }
        }
    }

    protected void clearUniqueFindersCache(LFPackage lfPackage) {
        LFPackageModelImpl lfPackageModelImpl = (LFPackageModelImpl) lfPackage;

        Object[] args = new Object[] { lfPackage.getAssetRefID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID, args);

        if ((lfPackageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_REFID.getColumnBitmask()) != 0) {
            args = new Object[] { lfPackageModelImpl.getOriginalAssetRefID() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID, args);
        }
    }

    /**
     * Creates a new l f package with the primary key. Does not add the l f package to the database.
     *
     * @param id the primary key for the new l f package
     * @return the new l f package
     */
    @Override
    public LFPackage create(long id) {
        LFPackage lfPackage = new LFPackageImpl();

        lfPackage.setNew(true);
        lfPackage.setPrimaryKey(id);

        return lfPackage;
    }

    /**
     * Removes the l f package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f package
     * @return the l f package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage remove(long id)
        throws NoSuchLFPackageException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f package
     * @return the l f package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage remove(Serializable primaryKey)
        throws NoSuchLFPackageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFPackage lfPackage = (LFPackage) session.get(LFPackageImpl.class,
                    primaryKey);

            if (lfPackage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfPackage);
        } catch (NoSuchLFPackageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFPackage removeImpl(LFPackage lfPackage)
        throws SystemException {
        lfPackage = toUnwrappedModel(lfPackage);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfPackage)) {
                lfPackage = (LFPackage) session.get(LFPackageImpl.class,
                        lfPackage.getPrimaryKeyObj());
            }

            if (lfPackage != null) {
                session.delete(lfPackage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfPackage != null) {
            clearCache(lfPackage);
        }

        return lfPackage;
    }

    @Override
    public LFPackage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws SystemException {
        lfPackage = toUnwrappedModel(lfPackage);

        boolean isNew = lfPackage.isNew();

        LFPackageModelImpl lfPackageModelImpl = (LFPackageModelImpl) lfPackage;

        Session session = null;

        try {
            session = openSession();

            if (lfPackage.isNew()) {
                session.save(lfPackage);

                lfPackage.setNew(false);
            } else {
                session.merge(lfPackage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFPackageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTANCE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE,
                    args);

                args = new Object[] { lfPackageModelImpl.getCourseID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTANCE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE,
                    args);
            }

            if ((lfPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfPackageModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] { lfPackageModelImpl.getCourseID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFPackageImpl.class, lfPackage.getPrimaryKey(), lfPackage);

        clearUniqueFindersCache(lfPackage);
        cacheUniqueFindersCache(lfPackage);

        return lfPackage;
    }

    protected LFPackage toUnwrappedModel(LFPackage lfPackage) {
        if (lfPackage instanceof LFPackageImpl) {
            return lfPackage;
        }

        LFPackageImpl lfPackageImpl = new LFPackageImpl();

        lfPackageImpl.setNew(lfPackage.isNew());
        lfPackageImpl.setPrimaryKey(lfPackage.getPrimaryKey());

        lfPackageImpl.setId(lfPackage.getId());
        lfPackageImpl.setDefaultOrganizationID(lfPackage.getDefaultOrganizationID());
        lfPackageImpl.setTitle(lfPackage.getTitle());
        lfPackageImpl.setBase(lfPackage.getBase());
        lfPackageImpl.setResourcesBase(lfPackage.getResourcesBase());
        lfPackageImpl.setSummary(lfPackage.getSummary());
        lfPackageImpl.setAssetRefID(lfPackage.getAssetRefID());
        lfPackageImpl.setCourseID(lfPackage.getCourseID());
        lfPackageImpl.setLogo(lfPackage.getLogo());

        return lfPackageImpl;
    }

    /**
     * Returns the l f package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f package
     * @return the l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFPackageException, SystemException {
        LFPackage lfPackage = fetchByPrimaryKey(primaryKey);

        if (lfPackage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfPackage;
    }

    /**
     * Returns the l f package with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageException} if it could not be found.
     *
     * @param id the primary key of the l f package
     * @return the l f package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage findByPrimaryKey(long id)
        throws NoSuchLFPackageException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f package
     * @return the l f package, or <code>null</code> if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFPackage lfPackage = (LFPackage) EntityCacheUtil.getResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFPackageImpl.class, primaryKey);

        if (lfPackage == _nullLFPackage) {
            return null;
        }

        if (lfPackage == null) {
            Session session = null;

            try {
                session = openSession();

                lfPackage = (LFPackage) session.get(LFPackageImpl.class,
                        primaryKey);

                if (lfPackage != null) {
                    cacheResult(lfPackage);
                } else {
                    EntityCacheUtil.putResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFPackageImpl.class, primaryKey, _nullLFPackage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFPackageModelImpl.ENTITY_CACHE_ENABLED,
                    LFPackageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfPackage;
    }

    /**
     * Returns the l f package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f package
     * @return the l f package, or <code>null</code> if a l f package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFPackage fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f packages.
     *
     * @return the l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @return the range of l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f packages
     * @param end the upper bound of the range of l f packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFPackage> findAll(int start, int end,
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

        List<LFPackage> list = (List<LFPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFPACKAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFPACKAGE;

                if (pagination) {
                    sql = sql.concat(LFPackageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFPackage>(list);
                } else {
                    list = (List<LFPackage>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f packages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFPackage lfPackage : findAll()) {
            remove(lfPackage);
        }
    }

    /**
     * Returns the number of l f packages.
     *
     * @return the number of l f packages
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

                Query q = session.createQuery(_SQL_COUNT_LFPACKAGE);

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
     * Initializes the l f package persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFPackage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFPackage>> listenersList = new ArrayList<ModelListener<LFPackage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFPackage>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFPackageImpl.class.getName());
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

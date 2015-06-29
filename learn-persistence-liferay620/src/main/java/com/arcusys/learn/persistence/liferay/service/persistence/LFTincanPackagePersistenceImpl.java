package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException;
import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanPackagePersistence;

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
import com.liferay.portal.kernel.util.CharPool;
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
 * The persistence implementation for the l f tincan package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackagePersistence
 * @see LFTincanPackageUtil
 * @generated
 */
public class LFTincanPackagePersistenceImpl extends BasePersistenceImpl<LFTincanPackage>
    implements LFTincanPackagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFTincanPackageUtil} to access the l f tincan package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFTincanPackageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_REFID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByRefID", new String[] { Long.class.getName() },
            LFTincanPackageModelImpl.ASSETREFID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REFID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRefID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_NULL = "lfTincanPackage.assetRefID IS NULL";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_2 = "lfTincanPackage.assetRefID = ?";
    private static final String _FINDER_COLUMN_REFID_ASSETREFID_NULL_2 = "lfTincanPackage.assetRefID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEANDCOURSEID =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByTitleAndCourseID",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEANDCOURSEID =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitleAndCourseID",
            new String[] { String.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_1 = "lfTincanPackage.title LIKE NULL AND ";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_NULL = "lfTincanPackage.title IS NULL";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_2 = "lower(lfTincanPackage.title) LIKE ? AND ";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_NULL_2 = "lfTincanPackage.title IS NULL  AND ";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3 = "(lfTincanPackage.title IS NULL OR lfTincanPackage.title LIKE '') AND ";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_4 = "(" +
        removeConjunction(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_1) + ")";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_5 = "(" +
        removeConjunction(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_2) + ")";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_NULL_2) + ")";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_TITLE_6 = "(" +
        removeConjunction(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3) + ")";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL = "lfTincanPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_2 = "lfTincanPackage.courseID = ?";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL_2 = "lfTincanPackage.courseID IS NULL ";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_2) + ")";
    private static final String _FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL_2) +
        ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByInstance",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstance",
            new String[] { Integer.class.getName() },
            LFTincanPackageModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_INSTANCE = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstance",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByInstance",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_NULL = "lfTincanPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_2 = "lfTincanPackage.courseID = ?";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_NULL_2 = "lfTincanPackage.courseID IS NULL ";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_INSTANCE_COURSEID_2) + ")";
    private static final String _FINDER_COLUMN_INSTANCE_COURSEID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_INSTANCE_COURSEID_NULL_2) + ")";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCourseID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED,
            LFTincanPackageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseID",
            new String[] { Integer.class.getName() },
            LFTincanPackageModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lfTincanPackage.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lfTincanPackage.courseID = ?";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lfTincanPackage.courseID IS NULL ";
    private static final String _SQL_SELECT_LFTINCANPACKAGE = "SELECT lfTincanPackage FROM LFTincanPackage lfTincanPackage";
    private static final String _SQL_SELECT_LFTINCANPACKAGE_WHERE = "SELECT lfTincanPackage FROM LFTincanPackage lfTincanPackage WHERE ";
    private static final String _SQL_COUNT_LFTINCANPACKAGE = "SELECT COUNT(lfTincanPackage) FROM LFTincanPackage lfTincanPackage";
    private static final String _SQL_COUNT_LFTINCANPACKAGE_WHERE = "SELECT COUNT(lfTincanPackage) FROM LFTincanPackage lfTincanPackage WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfTincanPackage.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFTincanPackage exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFTincanPackage exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFTincanPackagePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFTincanPackage _nullLFTincanPackage = new LFTincanPackageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFTincanPackage> toCacheModel() {
                return _nullLFTincanPackageCacheModel;
            }
        };

    private static CacheModel<LFTincanPackage> _nullLFTincanPackageCacheModel = new CacheModel<LFTincanPackage>() {
            @Override
            public LFTincanPackage toEntityModel() {
                return _nullLFTincanPackage;
            }
        };

    public LFTincanPackagePersistenceImpl() {
        setModelClass(LFTincanPackage.class);
    }

    /**
     * Returns the l f tincan package where assetRefID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException} if it could not be found.
     *
     * @param assetRefID the asset ref i d
     * @return the matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByRefID(Long assetRefID)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByRefID(assetRefID);

        if (lfTincanPackage == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("assetRefID=");
            msg.append(assetRefID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFTincanPackageException(msg.toString());
        }

        return lfTincanPackage;
    }

    /**
     * Returns the l f tincan package where assetRefID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param assetRefID the asset ref i d
     * @return the matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByRefID(Long assetRefID)
        throws SystemException {
        return fetchByRefID(assetRefID, true);
    }

    /**
     * Returns the l f tincan package where assetRefID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param assetRefID the asset ref i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByRefID(Long assetRefID,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { assetRefID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REFID,
                    finderArgs, this);
        }

        if (result instanceof LFTincanPackage) {
            LFTincanPackage lfTincanPackage = (LFTincanPackage) result;

            if (!Validator.equals(assetRefID, lfTincanPackage.getAssetRefID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

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

                List<LFTincanPackage> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFTincanPackagePersistenceImpl.fetchByRefID(Long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFTincanPackage lfTincanPackage = list.get(0);

                    result = lfTincanPackage;

                    cacheResult(lfTincanPackage);

                    if ((lfTincanPackage.getAssetRefID() != assetRefID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
                            finderArgs, lfTincanPackage);
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
            return (LFTincanPackage) result;
        }
    }

    /**
     * Removes the l f tincan package where assetRefID = &#63; from the database.
     *
     * @param assetRefID the asset ref i d
     * @return the l f tincan package that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage removeByRefID(Long assetRefID)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByRefID(assetRefID);

        return remove(lfTincanPackage);
    }

    /**
     * Returns the number of l f tincan packages where assetRefID = &#63;.
     *
     * @param assetRefID the asset ref i d
     * @return the number of matching l f tincan packages
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

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

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
     * Returns all the l f tincan packages where title LIKE &#63; and courseID = &#63;.
     *
     * @param title the title
     * @param courseID the course i d
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByTitleAndCourseID(String title,
        Integer courseID) throws SystemException {
        return findByTitleAndCourseID(title, courseID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan packages where title LIKE &#63; and courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByTitleAndCourseID(String title,
        Integer courseID, int start, int end) throws SystemException {
        return findByTitleAndCourseID(title, courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where title LIKE &#63; and courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByTitleAndCourseID(String title,
        Integer courseID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEANDCOURSEID;
        finderArgs = new Object[] { title, courseID, start, end, orderByComparator };

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!StringUtil.wildcardMatches(lfTincanPackage.getTitle(),
                            title, CharPool.UNDERLINE, CharPool.PERCENT,
                            CharPool.BACK_SLASH, false) ||
                        !Validator.equals(courseID,
                            lfTincanPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3);
            } else {
                bindTitle = true;

                if (title.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3);
                } else {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_2);
                }
            }

            if (courseID == null) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTitle) {
                    if (title != null) {
                        qPos.add(title.toLowerCase());
                    }
                }

                if (courseID != null) {
                    qPos.add(courseID.intValue());
                }

                if (!pagination) {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanPackage>(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
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
     * Returns the first l f tincan package in the ordered set where title LIKE &#63; and courseID = &#63;.
     *
     * @param title the title
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByTitleAndCourseID_First(String title,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByTitleAndCourseID_First(title,
                courseID, orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(", courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the first l f tincan package in the ordered set where title LIKE &#63; and courseID = &#63;.
     *
     * @param title the title
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByTitleAndCourseID_First(String title,
        Integer courseID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFTincanPackage> list = findByTitleAndCourseID(title, courseID, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan package in the ordered set where title LIKE &#63; and courseID = &#63;.
     *
     * @param title the title
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByTitleAndCourseID_Last(String title,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByTitleAndCourseID_Last(title,
                courseID, orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("title=");
        msg.append(title);

        msg.append(", courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the last l f tincan package in the ordered set where title LIKE &#63; and courseID = &#63;.
     *
     * @param title the title
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByTitleAndCourseID_Last(String title,
        Integer courseID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByTitleAndCourseID(title, courseID);

        if (count == 0) {
            return null;
        }

        List<LFTincanPackage> list = findByTitleAndCourseID(title, courseID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan packages before and after the current l f tincan package in the ordered set where title LIKE &#63; and courseID = &#63;.
     *
     * @param id the primary key of the current l f tincan package
     * @param title the title
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage[] findByTitleAndCourseID_PrevAndNext(long id,
        String title, Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanPackage[] array = new LFTincanPackageImpl[3];

            array[0] = getByTitleAndCourseID_PrevAndNext(session,
                    lfTincanPackage, title, courseID, orderByComparator, true);

            array[1] = lfTincanPackage;

            array[2] = getByTitleAndCourseID_PrevAndNext(session,
                    lfTincanPackage, title, courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanPackage getByTitleAndCourseID_PrevAndNext(
        Session session, LFTincanPackage lfTincanPackage, String title,
        Integer courseID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

        boolean bindTitle = false;

        if (title == null) {
            query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_1);
        } else if (title.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3);
        } else {
            bindTitle = true;

            if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3);
            } else {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_2);
            }
        }

        if (courseID == null) {
            query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_2);
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
            query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindTitle) {
            if (title != null) {
                qPos.add(title.toLowerCase());
            }
        }

        if (courseID != null) {
            qPos.add(courseID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan packages where title LIKE &#63; and courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param courseIDs the course i ds
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByTitleAndCourseID(String title,
        Integer[] courseIDs) throws SystemException {
        return findByTitleAndCourseID(title, courseIDs, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan packages where title LIKE &#63; and courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByTitleAndCourseID(String title,
        Integer[] courseIDs, int start, int end) throws SystemException {
        return findByTitleAndCourseID(title, courseIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where title LIKE &#63; and courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param title the title
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByTitleAndCourseID(String title,
        Integer[] courseIDs, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if ((courseIDs != null) && (courseIDs.length == 1)) {
            return findByTitleAndCourseID(title, courseIDs[0], start, end,
                orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { title, StringUtil.merge(courseIDs) };
        } else {
            finderArgs = new Object[] {
                    title, StringUtil.merge(courseIDs),
                    
                    start, end, orderByComparator
                };
        }

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEANDCOURSEID,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!Validator.equals(title, lfTincanPackage.getTitle()) ||
                        !ArrayUtil.contains(courseIDs,
                            lfTincanPackage.getCourseID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

            boolean conjunctionable = false;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_4);
            } else {
                if (title.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_6);
                } else {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_5);
                }
            }

            conjunctionable = true;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_5);
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
                query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (title != null) {
                    qPos.add(title);
                }

                if (courseIDs != null) {
                    for (Integer courseID : courseIDs) {
                        if (courseID != null) {
                            qPos.add(courseID);
                        }
                    }
                }

                if (!pagination) {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanPackage>(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEANDCOURSEID,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEANDCOURSEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f tincan packages where title LIKE &#63; and courseID = &#63; from the database.
     *
     * @param title the title
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTitleAndCourseID(String title, Integer courseID)
        throws SystemException {
        for (LFTincanPackage lfTincanPackage : findByTitleAndCourseID(title,
                courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Returns the number of l f tincan packages where title LIKE &#63; and courseID = &#63;.
     *
     * @param title the title
     * @param courseID the course i d
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTitleAndCourseID(String title, Integer courseID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEANDCOURSEID;

        Object[] finderArgs = new Object[] { title, courseID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

            boolean bindTitle = false;

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_1);
            } else if (title.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3);
            } else {
                bindTitle = true;

                if (title.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_3);
                } else {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_2);
                }
            }

            if (courseID == null) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindTitle) {
                    if (title != null) {
                        qPos.add(title.toLowerCase());
                    }
                }

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
     * Returns the number of l f tincan packages where title LIKE &#63; and courseID = any &#63;.
     *
     * @param title the title
     * @param courseIDs the course i ds
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTitleAndCourseID(String title, Integer[] courseIDs)
        throws SystemException {
        Object[] finderArgs = new Object[] { title, StringUtil.merge(courseIDs) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEANDCOURSEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

            boolean conjunctionable = false;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            if (title == null) {
                query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_4);
            } else {
                if (title.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_6);
                } else {
                    query.append(_FINDER_COLUMN_TITLEANDCOURSEID_TITLE_5);
                }
            }

            conjunctionable = true;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_TITLEANDCOURSEID_COURSEID_5);
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

                if (title != null) {
                    qPos.add(title);
                }

                if (courseIDs != null) {
                    for (Integer courseID : courseIDs) {
                        if (courseID != null) {
                            qPos.add(courseID);
                        }
                    }
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEANDCOURSEID,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEANDCOURSEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByInstance(Integer courseID)
        throws SystemException {
        return findByInstance(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByInstance(Integer courseID, int start,
        int end) throws SystemException {
        return findByInstance(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByInstance(Integer courseID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!Validator.equals(courseID, lfTincanPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

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
                query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanPackage>(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
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
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByInstance_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByInstance_First(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByInstance_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanPackage> list = findByInstance(courseID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByInstance_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByInstance_Last(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByInstance_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByInstance(courseID);

        if (count == 0) {
            return null;
        }

        List<LFTincanPackage> list = findByInstance(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan packages before and after the current l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f tincan package
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage[] findByInstance_PrevAndNext(long id,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanPackage[] array = new LFTincanPackageImpl[3];

            array[0] = getByInstance_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, true);

            array[1] = lfTincanPackage;

            array[2] = getByInstance_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanPackage getByInstance_PrevAndNext(Session session,
        LFTincanPackage lfTincanPackage, Integer courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

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
            query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f tincan packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByInstance(Integer[] courseIDs)
        throws SystemException {
        return findByInstance(courseIDs, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByInstance(Integer[] courseIDs, int start,
        int end) throws SystemException {
        return findByInstance(courseIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByInstance(Integer[] courseIDs, int start,
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

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCE,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!ArrayUtil.contains(courseIDs, lfTincanPackage.getCourseID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

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
                query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanPackage>(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the l f tincan packages where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByInstance(Integer courseID) throws SystemException {
        for (LFTincanPackage lfTincanPackage : findByInstance(courseID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Returns the number of l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f tincan packages
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

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

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
     * Returns the number of l f tincan packages where courseID = any &#63;.
     *
     * @param courseIDs the course i ds
     * @return the number of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByInstance(Integer[] courseIDs) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(courseIDs) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_INSTANCE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

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
     * Returns all the l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByCourseID(Integer courseID)
        throws SystemException {
        return findByCourseID(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByCourseID(Integer courseID, int start,
        int end) throws SystemException {
        return findByCourseID(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findByCourseID(Integer courseID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
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

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFTincanPackage lfTincanPackage : list) {
                if (!Validator.equals(courseID, lfTincanPackage.getCourseID())) {
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

            query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

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
                query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanPackage>(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
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
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByCourseID_First(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the first l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFTincanPackage> list = findByCourseID(courseID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByCourseID_Last(courseID,
                orderByComparator);

        if (lfTincanPackage != null) {
            return lfTincanPackage;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFTincanPackageException(msg.toString());
    }

    /**
     * Returns the last l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f tincan package, or <code>null</code> if a matching l f tincan package could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseID(courseID);

        if (count == 0) {
            return null;
        }

        List<LFTincanPackage> list = findByCourseID(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f tincan packages before and after the current l f tincan package in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f tincan package
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage[] findByCourseID_PrevAndNext(long id,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFTincanPackage[] array = new LFTincanPackageImpl[3];

            array[0] = getByCourseID_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, true);

            array[1] = lfTincanPackage;

            array[2] = getByCourseID_PrevAndNext(session, lfTincanPackage,
                    courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFTincanPackage getByCourseID_PrevAndNext(Session session,
        LFTincanPackage lfTincanPackage, Integer courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFTINCANPACKAGE_WHERE);

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
            query.append(LFTincanPackageModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfTincanPackage);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFTincanPackage> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f tincan packages where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCourseID(Integer courseID) throws SystemException {
        for (LFTincanPackage lfTincanPackage : findByCourseID(courseID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Returns the number of l f tincan packages where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f tincan packages
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

            query.append(_SQL_COUNT_LFTINCANPACKAGE_WHERE);

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
     * Caches the l f tincan package in the entity cache if it is enabled.
     *
     * @param lfTincanPackage the l f tincan package
     */
    @Override
    public void cacheResult(LFTincanPackage lfTincanPackage) {
        EntityCacheUtil.putResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey(),
            lfTincanPackage);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID,
            new Object[] { lfTincanPackage.getAssetRefID() }, lfTincanPackage);

        lfTincanPackage.resetOriginalValues();
    }

    /**
     * Caches the l f tincan packages in the entity cache if it is enabled.
     *
     * @param lfTincanPackages the l f tincan packages
     */
    @Override
    public void cacheResult(List<LFTincanPackage> lfTincanPackages) {
        for (LFTincanPackage lfTincanPackage : lfTincanPackages) {
            if (EntityCacheUtil.getResult(
                        LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanPackageImpl.class,
                        lfTincanPackage.getPrimaryKey()) == null) {
                cacheResult(lfTincanPackage);
            } else {
                lfTincanPackage.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f tincan packages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFTincanPackageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFTincanPackageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f tincan package.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFTincanPackage lfTincanPackage) {
        EntityCacheUtil.removeResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfTincanPackage);
    }

    @Override
    public void clearCache(List<LFTincanPackage> lfTincanPackages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFTincanPackage lfTincanPackage : lfTincanPackages) {
            EntityCacheUtil.removeResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey());

            clearUniqueFindersCache(lfTincanPackage);
        }
    }

    protected void cacheUniqueFindersCache(LFTincanPackage lfTincanPackage) {
        if (lfTincanPackage.isNew()) {
            Object[] args = new Object[] { lfTincanPackage.getAssetRefID() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REFID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID, args,
                lfTincanPackage);
        } else {
            LFTincanPackageModelImpl lfTincanPackageModelImpl = (LFTincanPackageModelImpl) lfTincanPackage;

            if ((lfTincanPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_REFID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfTincanPackage.getAssetRefID() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REFID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REFID, args,
                    lfTincanPackage);
            }
        }
    }

    protected void clearUniqueFindersCache(LFTincanPackage lfTincanPackage) {
        LFTincanPackageModelImpl lfTincanPackageModelImpl = (LFTincanPackageModelImpl) lfTincanPackage;

        Object[] args = new Object[] { lfTincanPackage.getAssetRefID() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID, args);

        if ((lfTincanPackageModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_REFID.getColumnBitmask()) != 0) {
            args = new Object[] { lfTincanPackageModelImpl.getOriginalAssetRefID() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REFID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REFID, args);
        }
    }

    /**
     * Creates a new l f tincan package with the primary key. Does not add the l f tincan package to the database.
     *
     * @param id the primary key for the new l f tincan package
     * @return the new l f tincan package
     */
    @Override
    public LFTincanPackage create(long id) {
        LFTincanPackage lfTincanPackage = new LFTincanPackageImpl();

        lfTincanPackage.setNew(true);
        lfTincanPackage.setPrimaryKey(id);

        return lfTincanPackage;
    }

    /**
     * Removes the l f tincan package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f tincan package
     * @return the l f tincan package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage remove(long id)
        throws NoSuchLFTincanPackageException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f tincan package with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f tincan package
     * @return the l f tincan package that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage remove(Serializable primaryKey)
        throws NoSuchLFTincanPackageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFTincanPackage lfTincanPackage = (LFTincanPackage) session.get(LFTincanPackageImpl.class,
                    primaryKey);

            if (lfTincanPackage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFTincanPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfTincanPackage);
        } catch (NoSuchLFTincanPackageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFTincanPackage removeImpl(LFTincanPackage lfTincanPackage)
        throws SystemException {
        lfTincanPackage = toUnwrappedModel(lfTincanPackage);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfTincanPackage)) {
                lfTincanPackage = (LFTincanPackage) session.get(LFTincanPackageImpl.class,
                        lfTincanPackage.getPrimaryKeyObj());
            }

            if (lfTincanPackage != null) {
                session.delete(lfTincanPackage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfTincanPackage != null) {
            clearCache(lfTincanPackage);
        }

        return lfTincanPackage;
    }

    @Override
    public LFTincanPackage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanPackage lfTincanPackage)
        throws SystemException {
        lfTincanPackage = toUnwrappedModel(lfTincanPackage);

        boolean isNew = lfTincanPackage.isNew();

        LFTincanPackageModelImpl lfTincanPackageModelImpl = (LFTincanPackageModelImpl) lfTincanPackage;

        Session session = null;

        try {
            session = openSession();

            if (lfTincanPackage.isNew()) {
                session.save(lfTincanPackage);

                lfTincanPackage.setNew(false);
            } else {
                session.merge(lfTincanPackage);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFTincanPackageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfTincanPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanPackageModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTANCE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE,
                    args);

                args = new Object[] { lfTincanPackageModelImpl.getCourseID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INSTANCE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCE,
                    args);
            }

            if ((lfTincanPackageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfTincanPackageModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] { lfTincanPackageModelImpl.getCourseID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
            LFTincanPackageImpl.class, lfTincanPackage.getPrimaryKey(),
            lfTincanPackage);

        clearUniqueFindersCache(lfTincanPackage);
        cacheUniqueFindersCache(lfTincanPackage);

        return lfTincanPackage;
    }

    protected LFTincanPackage toUnwrappedModel(LFTincanPackage lfTincanPackage) {
        if (lfTincanPackage instanceof LFTincanPackageImpl) {
            return lfTincanPackage;
        }

        LFTincanPackageImpl lfTincanPackageImpl = new LFTincanPackageImpl();

        lfTincanPackageImpl.setNew(lfTincanPackage.isNew());
        lfTincanPackageImpl.setPrimaryKey(lfTincanPackage.getPrimaryKey());

        lfTincanPackageImpl.setId(lfTincanPackage.getId());
        lfTincanPackageImpl.setTitle(lfTincanPackage.getTitle());
        lfTincanPackageImpl.setSummary(lfTincanPackage.getSummary());
        lfTincanPackageImpl.setAssetRefID(lfTincanPackage.getAssetRefID());
        lfTincanPackageImpl.setCourseID(lfTincanPackage.getCourseID());
        lfTincanPackageImpl.setLogo(lfTincanPackage.getLogo());
        lfTincanPackageImpl.setBeginDate(lfTincanPackage.getBeginDate());
        lfTincanPackageImpl.setEndDate(lfTincanPackage.getEndDate());

        return lfTincanPackageImpl;
    }

    /**
     * Returns the l f tincan package with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan package
     * @return the l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFTincanPackageException, SystemException {
        LFTincanPackage lfTincanPackage = fetchByPrimaryKey(primaryKey);

        if (lfTincanPackage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFTincanPackageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfTincanPackage;
    }

    /**
     * Returns the l f tincan package with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException} if it could not be found.
     *
     * @param id the primary key of the l f tincan package
     * @return the l f tincan package
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage findByPrimaryKey(long id)
        throws NoSuchLFTincanPackageException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f tincan package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f tincan package
     * @return the l f tincan package, or <code>null</code> if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFTincanPackage lfTincanPackage = (LFTincanPackage) EntityCacheUtil.getResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                LFTincanPackageImpl.class, primaryKey);

        if (lfTincanPackage == _nullLFTincanPackage) {
            return null;
        }

        if (lfTincanPackage == null) {
            Session session = null;

            try {
                session = openSession();

                lfTincanPackage = (LFTincanPackage) session.get(LFTincanPackageImpl.class,
                        primaryKey);

                if (lfTincanPackage != null) {
                    cacheResult(lfTincanPackage);
                } else {
                    EntityCacheUtil.putResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                        LFTincanPackageImpl.class, primaryKey,
                        _nullLFTincanPackage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFTincanPackageModelImpl.ENTITY_CACHE_ENABLED,
                    LFTincanPackageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfTincanPackage;
    }

    /**
     * Returns the l f tincan package with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f tincan package
     * @return the l f tincan package, or <code>null</code> if a l f tincan package with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFTincanPackage fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f tincan packages.
     *
     * @return the l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f tincan packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @return the range of l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f tincan packages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f tincan packages
     * @param end the upper bound of the range of l f tincan packages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f tincan packages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFTincanPackage> findAll(int start, int end,
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

        List<LFTincanPackage> list = (List<LFTincanPackage>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFTINCANPACKAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFTINCANPACKAGE;

                if (pagination) {
                    sql = sql.concat(LFTincanPackageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFTincanPackage>(list);
                } else {
                    list = (List<LFTincanPackage>) QueryUtil.list(q,
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
     * Removes all the l f tincan packages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFTincanPackage lfTincanPackage : findAll()) {
            remove(lfTincanPackage);
        }
    }

    /**
     * Returns the number of l f tincan packages.
     *
     * @return the number of l f tincan packages
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

                Query q = session.createQuery(_SQL_COUNT_LFTINCANPACKAGE);

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
     * Initializes the l f tincan package persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFTincanPackage")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFTincanPackage>> listenersList = new ArrayList<ModelListener<LFTincanPackage>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFTincanPackage>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFTincanPackageImpl.class.getName());
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

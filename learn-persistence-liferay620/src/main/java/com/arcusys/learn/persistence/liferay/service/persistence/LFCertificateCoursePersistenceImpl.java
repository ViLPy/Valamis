package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePersistence;

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
 * The persistence implementation for the l f certificate course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateCoursePersistence
 * @see LFCertificateCourseUtil
 * @generated
 */
public class LFCertificateCoursePersistenceImpl extends BasePersistenceImpl<LFCertificateCourse>
    implements LFCertificateCoursePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateCourseUtil} to access the l f certificate course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateCourseImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Long.class.getName() },
            LFCertificateCourseModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertificateID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateCourse.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateCourse.id.certificateID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateCourse.certificateID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseID",
            new String[] { Long.class.getName() },
            LFCertificateCourseModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lfCertificateCourse.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lfCertificateCourse.id.courseID = ?";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lfCertificateCourse.courseID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID =
        new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateCourseImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByCertificateIDAndCourseID",
            new String[] { Long.class.getName(), Long.class.getName() },
            LFCertificateCourseModelImpl.CERTIFICATEID_COLUMN_BITMASK |
            LFCertificateCourseModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEIDANDCOURSEID =
        new FinderPath(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCertificateIDAndCourseID",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_NULL =
        "lfCertificateCourse.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_2 =
        "lfCertificateCourse.id.certificateID = ? AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_NULL_2 =
        "lfCertificateCourse.certificateID IS NULL  AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_NULL =
        "lfCertificateCourse.courseID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_2 =
        "lfCertificateCourse.id.courseID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_NULL_2 =
        "lfCertificateCourse.courseID IS NULL ";
    private static final String _SQL_SELECT_LFCERTIFICATECOURSE = "SELECT lfCertificateCourse FROM LFCertificateCourse lfCertificateCourse";
    private static final String _SQL_SELECT_LFCERTIFICATECOURSE_WHERE = "SELECT lfCertificateCourse FROM LFCertificateCourse lfCertificateCourse WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATECOURSE = "SELECT COUNT(lfCertificateCourse) FROM LFCertificateCourse lfCertificateCourse";
    private static final String _SQL_COUNT_LFCERTIFICATECOURSE_WHERE = "SELECT COUNT(lfCertificateCourse) FROM LFCertificateCourse lfCertificateCourse WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateCourse.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateCourse exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateCourse exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateCoursePersistenceImpl.class);
    private static LFCertificateCourse _nullLFCertificateCourse = new LFCertificateCourseImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateCourse> toCacheModel() {
                return _nullLFCertificateCourseCacheModel;
            }
        };

    private static CacheModel<LFCertificateCourse> _nullLFCertificateCourseCacheModel =
        new CacheModel<LFCertificateCourse>() {
            @Override
            public LFCertificateCourse toEntityModel() {
                return _nullLFCertificateCourse;
            }
        };

    public LFCertificateCoursePersistenceImpl() {
        setModelClass(LFCertificateCourse.class);
    }

    /**
     * Returns all the l f certificate courses where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findByCertificateID(Long certificateID)
        throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate courses where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate courses
     * @param end the upper bound of the range of l f certificate courses (not inclusive)
     * @return the range of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findByCertificateID(Long certificateID,
        int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate courses where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate courses
     * @param end the upper bound of the range of l f certificate courses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findByCertificateID(Long certificateID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] { certificateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] {
                    certificateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateCourse> list = (List<LFCertificateCourse>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateCourse lfCertificateCourse : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateCourse.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATECOURSE_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateCourseModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateCourse>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateCourse>(list);
                } else {
                    list = (List<LFCertificateCourse>) QueryUtil.list(q,
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
     * Returns the first l f certificate course in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByCertificateID_First(Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateCourse != null) {
            return lfCertificateCourse;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateCourseException(msg.toString());
    }

    /**
     * Returns the first l f certificate course in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByCertificateID_First(Long certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateCourse> list = findByCertificateID(certificateID, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate course in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByCertificateID_Last(Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateCourse != null) {
            return lfCertificateCourse;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateCourseException(msg.toString());
    }

    /**
     * Returns the last l f certificate course in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByCertificateID_Last(Long certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCertificateID(certificateID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateCourse> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate courses before and after the current l f certificate course in the ordered set where certificateID = &#63;.
     *
     * @param lfCertificateCoursePK the primary key of the current l f certificate course
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse[] findByCertificateID_PrevAndNext(
        LFCertificateCoursePK lfCertificateCoursePK, Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = findByPrimaryKey(lfCertificateCoursePK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateCourse[] array = new LFCertificateCourseImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateCourse, certificateID, orderByComparator, true);

            array[1] = lfCertificateCourse;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateCourse, certificateID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateCourse getByCertificateID_PrevAndNext(
        Session session, LFCertificateCourse lfCertificateCourse,
        Long certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATECOURSE_WHERE);

        if (certificateID == null) {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
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
            query.append(LFCertificateCourseModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (certificateID != null) {
            qPos.add(certificateID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateCourse);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateCourse> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate courses where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCertificateID(Long certificateID)
        throws SystemException {
        for (LFCertificateCourse lfCertificateCourse : findByCertificateID(
                certificateID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateCourse);
        }
    }

    /**
     * Returns the number of l f certificate courses where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateID(Long certificateID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEID;

        Object[] finderArgs = new Object[] { certificateID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATECOURSE_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
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
     * Returns all the l f certificate courses where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findByCourseID(Long courseID)
        throws SystemException {
        return findByCourseID(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f certificate courses where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f certificate courses
     * @param end the upper bound of the range of l f certificate courses (not inclusive)
     * @return the range of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findByCourseID(Long courseID, int start,
        int end) throws SystemException {
        return findByCourseID(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate courses where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f certificate courses
     * @param end the upper bound of the range of l f certificate courses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findByCourseID(Long courseID, int start,
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

        List<LFCertificateCourse> list = (List<LFCertificateCourse>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateCourse lfCertificateCourse : list) {
                if (!Validator.equals(courseID,
                            lfCertificateCourse.getCourseID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATECOURSE_WHERE);

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
                query.append(LFCertificateCourseModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (courseID != null) {
                    qPos.add(courseID.longValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateCourse>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateCourse>(list);
                } else {
                    list = (List<LFCertificateCourse>) QueryUtil.list(q,
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
     * Returns the first l f certificate course in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByCourseID_First(Long courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = fetchByCourseID_First(courseID,
                orderByComparator);

        if (lfCertificateCourse != null) {
            return lfCertificateCourse;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateCourseException(msg.toString());
    }

    /**
     * Returns the first l f certificate course in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByCourseID_First(Long courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateCourse> list = findByCourseID(courseID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate course in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByCourseID_Last(Long courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = fetchByCourseID_Last(courseID,
                orderByComparator);

        if (lfCertificateCourse != null) {
            return lfCertificateCourse;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateCourseException(msg.toString());
    }

    /**
     * Returns the last l f certificate course in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByCourseID_Last(Long courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseID(courseID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateCourse> list = findByCourseID(courseID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate courses before and after the current l f certificate course in the ordered set where courseID = &#63;.
     *
     * @param lfCertificateCoursePK the primary key of the current l f certificate course
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse[] findByCourseID_PrevAndNext(
        LFCertificateCoursePK lfCertificateCoursePK, Long courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = findByPrimaryKey(lfCertificateCoursePK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateCourse[] array = new LFCertificateCourseImpl[3];

            array[0] = getByCourseID_PrevAndNext(session, lfCertificateCourse,
                    courseID, orderByComparator, true);

            array[1] = lfCertificateCourse;

            array[2] = getByCourseID_PrevAndNext(session, lfCertificateCourse,
                    courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateCourse getByCourseID_PrevAndNext(Session session,
        LFCertificateCourse lfCertificateCourse, Long courseID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATECOURSE_WHERE);

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
            query.append(LFCertificateCourseModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (courseID != null) {
            qPos.add(courseID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateCourse);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateCourse> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate courses where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCourseID(Long courseID) throws SystemException {
        for (LFCertificateCourse lfCertificateCourse : findByCourseID(
                courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateCourse);
        }
    }

    /**
     * Returns the number of l f certificate courses where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCourseID(Long courseID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

        Object[] finderArgs = new Object[] { courseID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATECOURSE_WHERE);

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
                    qPos.add(courseID.longValue());
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
     * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException} if it could not be found.
     *
     * @param certificateID the certificate i d
     * @param courseID the course i d
     * @return the matching l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByCertificateIDAndCourseID(
        Long certificateID, Long courseID)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = fetchByCertificateIDAndCourseID(certificateID,
                courseID);

        if (lfCertificateCourse == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("certificateID=");
            msg.append(certificateID);

            msg.append(", courseID=");
            msg.append(courseID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFCertificateCourseException(msg.toString());
        }

        return lfCertificateCourse;
    }

    /**
     * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param certificateID the certificate i d
     * @param courseID the course i d
     * @return the matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByCertificateIDAndCourseID(
        Long certificateID, Long courseID) throws SystemException {
        return fetchByCertificateIDAndCourseID(certificateID, courseID, true);
    }

    /**
     * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param certificateID the certificate i d
     * @param courseID the course i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByCertificateIDAndCourseID(
        Long certificateID, Long courseID, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { certificateID, courseID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                    finderArgs, this);
        }

        if (result instanceof LFCertificateCourse) {
            LFCertificateCourse lfCertificateCourse = (LFCertificateCourse) result;

            if (!Validator.equals(certificateID,
                        lfCertificateCourse.getCertificateID()) ||
                    !Validator.equals(courseID,
                        lfCertificateCourse.getCourseID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFCERTIFICATECOURSE_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_2);
            }

            if (courseID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (courseID != null) {
                    qPos.add(courseID.longValue());
                }

                List<LFCertificateCourse> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFCertificateCoursePersistenceImpl.fetchByCertificateIDAndCourseID(Long, Long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFCertificateCourse lfCertificateCourse = list.get(0);

                    result = lfCertificateCourse;

                    cacheResult(lfCertificateCourse);

                    if ((lfCertificateCourse.getCertificateID() != certificateID) ||
                            (lfCertificateCourse.getCourseID() != courseID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                            finderArgs, lfCertificateCourse);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFCertificateCourse) result;
        }
    }

    /**
     * Removes the l f certificate course where certificateID = &#63; and courseID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @param courseID the course i d
     * @return the l f certificate course that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse removeByCertificateIDAndCourseID(
        Long certificateID, Long courseID)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = findByCertificateIDAndCourseID(certificateID,
                courseID);

        return remove(lfCertificateCourse);
    }

    /**
     * Returns the number of l f certificate courses where certificateID = &#63; and courseID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param courseID the course i d
     * @return the number of matching l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateIDAndCourseID(Long certificateID, Long courseID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEIDANDCOURSEID;

        Object[] finderArgs = new Object[] { certificateID, courseID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATECOURSE_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_CERTIFICATEID_2);
            }

            if (courseID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDCOURSEID_COURSEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (courseID != null) {
                    qPos.add(courseID.longValue());
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
     * Caches the l f certificate course in the entity cache if it is enabled.
     *
     * @param lfCertificateCourse the l f certificate course
     */
    @Override
    public void cacheResult(LFCertificateCourse lfCertificateCourse) {
        EntityCacheUtil.putResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseImpl.class, lfCertificateCourse.getPrimaryKey(),
            lfCertificateCourse);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
            new Object[] {
                lfCertificateCourse.getCertificateID(),
                lfCertificateCourse.getCourseID()
            }, lfCertificateCourse);

        lfCertificateCourse.resetOriginalValues();
    }

    /**
     * Caches the l f certificate courses in the entity cache if it is enabled.
     *
     * @param lfCertificateCourses the l f certificate courses
     */
    @Override
    public void cacheResult(List<LFCertificateCourse> lfCertificateCourses) {
        for (LFCertificateCourse lfCertificateCourse : lfCertificateCourses) {
            if (EntityCacheUtil.getResult(
                        LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateCourseImpl.class,
                        lfCertificateCourse.getPrimaryKey()) == null) {
                cacheResult(lfCertificateCourse);
            } else {
                lfCertificateCourse.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate courses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateCourseImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateCourseImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate course.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificateCourse lfCertificateCourse) {
        EntityCacheUtil.removeResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseImpl.class, lfCertificateCourse.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfCertificateCourse);
    }

    @Override
    public void clearCache(List<LFCertificateCourse> lfCertificateCourses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateCourse lfCertificateCourse : lfCertificateCourses) {
            EntityCacheUtil.removeResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateCourseImpl.class,
                lfCertificateCourse.getPrimaryKey());

            clearUniqueFindersCache(lfCertificateCourse);
        }
    }

    protected void cacheUniqueFindersCache(
        LFCertificateCourse lfCertificateCourse) {
        if (lfCertificateCourse.isNew()) {
            Object[] args = new Object[] {
                    lfCertificateCourse.getCertificateID(),
                    lfCertificateCourse.getCourseID()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDCOURSEID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                args, lfCertificateCourse);
        } else {
            LFCertificateCourseModelImpl lfCertificateCourseModelImpl = (LFCertificateCourseModelImpl) lfCertificateCourse;

            if ((lfCertificateCourseModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateCourse.getCertificateID(),
                        lfCertificateCourse.getCourseID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDCOURSEID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                    args, lfCertificateCourse);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFCertificateCourse lfCertificateCourse) {
        LFCertificateCourseModelImpl lfCertificateCourseModelImpl = (LFCertificateCourseModelImpl) lfCertificateCourse;

        Object[] args = new Object[] {
                lfCertificateCourse.getCertificateID(),
                lfCertificateCourse.getCourseID()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDCOURSEID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
            args);

        if ((lfCertificateCourseModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfCertificateCourseModelImpl.getOriginalCertificateID(),
                    lfCertificateCourseModelImpl.getOriginalCourseID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDCOURSEID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDCOURSEID,
                args);
        }
    }

    /**
     * Creates a new l f certificate course with the primary key. Does not add the l f certificate course to the database.
     *
     * @param lfCertificateCoursePK the primary key for the new l f certificate course
     * @return the new l f certificate course
     */
    @Override
    public LFCertificateCourse create(
        LFCertificateCoursePK lfCertificateCoursePK) {
        LFCertificateCourse lfCertificateCourse = new LFCertificateCourseImpl();

        lfCertificateCourse.setNew(true);
        lfCertificateCourse.setPrimaryKey(lfCertificateCoursePK);

        return lfCertificateCourse;
    }

    /**
     * Removes the l f certificate course with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfCertificateCoursePK the primary key of the l f certificate course
     * @return the l f certificate course that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse remove(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws NoSuchLFCertificateCourseException, SystemException {
        return remove((Serializable) lfCertificateCoursePK);
    }

    /**
     * Removes the l f certificate course with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate course
     * @return the l f certificate course that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse remove(Serializable primaryKey)
        throws NoSuchLFCertificateCourseException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateCourse lfCertificateCourse = (LFCertificateCourse) session.get(LFCertificateCourseImpl.class,
                    primaryKey);

            if (lfCertificateCourse == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateCourse);
        } catch (NoSuchLFCertificateCourseException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateCourse removeImpl(
        LFCertificateCourse lfCertificateCourse) throws SystemException {
        lfCertificateCourse = toUnwrappedModel(lfCertificateCourse);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfCertificateCourse)) {
                lfCertificateCourse = (LFCertificateCourse) session.get(LFCertificateCourseImpl.class,
                        lfCertificateCourse.getPrimaryKeyObj());
            }

            if (lfCertificateCourse != null) {
                session.delete(lfCertificateCourse);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfCertificateCourse != null) {
            clearCache(lfCertificateCourse);
        }

        return lfCertificateCourse;
    }

    @Override
    public LFCertificateCourse updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateCourse lfCertificateCourse)
        throws SystemException {
        lfCertificateCourse = toUnwrappedModel(lfCertificateCourse);

        boolean isNew = lfCertificateCourse.isNew();

        LFCertificateCourseModelImpl lfCertificateCourseModelImpl = (LFCertificateCourseModelImpl) lfCertificateCourse;

        Session session = null;

        try {
            session = openSession();

            if (lfCertificateCourse.isNew()) {
                session.save(lfCertificateCourse);

                lfCertificateCourse.setNew(false);
            } else {
                session.merge(lfCertificateCourse);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateCourseModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateCourseModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateCourseModelImpl.getOriginalCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        lfCertificateCourseModelImpl.getCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateCourseModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateCourseModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] { lfCertificateCourseModelImpl.getCourseID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateCourseImpl.class, lfCertificateCourse.getPrimaryKey(),
            lfCertificateCourse);

        clearUniqueFindersCache(lfCertificateCourse);
        cacheUniqueFindersCache(lfCertificateCourse);

        return lfCertificateCourse;
    }

    protected LFCertificateCourse toUnwrappedModel(
        LFCertificateCourse lfCertificateCourse) {
        if (lfCertificateCourse instanceof LFCertificateCourseImpl) {
            return lfCertificateCourse;
        }

        LFCertificateCourseImpl lfCertificateCourseImpl = new LFCertificateCourseImpl();

        lfCertificateCourseImpl.setNew(lfCertificateCourse.isNew());
        lfCertificateCourseImpl.setPrimaryKey(lfCertificateCourse.getPrimaryKey());

        lfCertificateCourseImpl.setCertificateID(lfCertificateCourse.getCertificateID());
        lfCertificateCourseImpl.setCourseID(lfCertificateCourse.getCourseID());
        lfCertificateCourseImpl.setArrangementIndex(lfCertificateCourse.getArrangementIndex());
        lfCertificateCourseImpl.setPeriodType(lfCertificateCourse.getPeriodType());
        lfCertificateCourseImpl.setPeriod(lfCertificateCourse.getPeriod());

        return lfCertificateCourseImpl;
    }

    /**
     * Returns the l f certificate course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate course
     * @return the l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFCertificateCourseException, SystemException {
        LFCertificateCourse lfCertificateCourse = fetchByPrimaryKey(primaryKey);

        if (lfCertificateCourse == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFCertificateCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfCertificateCourse;
    }

    /**
     * Returns the l f certificate course with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException} if it could not be found.
     *
     * @param lfCertificateCoursePK the primary key of the l f certificate course
     * @return the l f certificate course
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse findByPrimaryKey(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws NoSuchLFCertificateCourseException, SystemException {
        return findByPrimaryKey((Serializable) lfCertificateCoursePK);
    }

    /**
     * Returns the l f certificate course with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate course
     * @return the l f certificate course, or <code>null</code> if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFCertificateCourse lfCertificateCourse = (LFCertificateCourse) EntityCacheUtil.getResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateCourseImpl.class, primaryKey);

        if (lfCertificateCourse == _nullLFCertificateCourse) {
            return null;
        }

        if (lfCertificateCourse == null) {
            Session session = null;

            try {
                session = openSession();

                lfCertificateCourse = (LFCertificateCourse) session.get(LFCertificateCourseImpl.class,
                        primaryKey);

                if (lfCertificateCourse != null) {
                    cacheResult(lfCertificateCourse);
                } else {
                    EntityCacheUtil.putResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateCourseImpl.class, primaryKey,
                        _nullLFCertificateCourse);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFCertificateCourseModelImpl.ENTITY_CACHE_ENABLED,
                    LFCertificateCourseImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfCertificateCourse;
    }

    /**
     * Returns the l f certificate course with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfCertificateCoursePK the primary key of the l f certificate course
     * @return the l f certificate course, or <code>null</code> if a l f certificate course with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateCourse fetchByPrimaryKey(
        LFCertificateCoursePK lfCertificateCoursePK) throws SystemException {
        return fetchByPrimaryKey((Serializable) lfCertificateCoursePK);
    }

    /**
     * Returns all the l f certificate courses.
     *
     * @return the l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate courses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate courses
     * @param end the upper bound of the range of l f certificate courses (not inclusive)
     * @return the range of l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate courses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate courses
     * @param end the upper bound of the range of l f certificate courses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate courses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateCourse> findAll(int start, int end,
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

        List<LFCertificateCourse> list = (List<LFCertificateCourse>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATECOURSE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATECOURSE;

                if (pagination) {
                    sql = sql.concat(LFCertificateCourseModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFCertificateCourse>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateCourse>(list);
                } else {
                    list = (List<LFCertificateCourse>) QueryUtil.list(q,
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
     * Removes all the l f certificate courses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFCertificateCourse lfCertificateCourse : findAll()) {
            remove(lfCertificateCourse);
        }
    }

    /**
     * Returns the number of l f certificate courses.
     *
     * @return the number of l f certificate courses
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

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATECOURSE);

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
     * Initializes the l f certificate course persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateCourse")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateCourse>> listenersList = new ArrayList<ModelListener<LFCertificateCourse>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateCourse>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateCourseImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

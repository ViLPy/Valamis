package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizException;
import com.arcusys.learn.persistence.liferay.model.LFQuiz;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizPersistence;

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
 * The persistence implementation for the l f quiz service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizPersistence
 * @see LFQuizUtil
 * @generated
 */
public class LFQuizPersistenceImpl extends BasePersistenceImpl<LFQuiz>
    implements LFQuizPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuizUtil} to access the l f quiz persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuizImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, LFQuizImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, LFQuizImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, LFQuizImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, LFQuizImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
            new String[] { Integer.class.getName() },
            LFQuizModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID =
        new FinderPath(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCourseId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lfQuiz.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lfQuiz.courseID = ?";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lfQuiz.courseID IS NULL ";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_COURSEID_COURSEID_2) + ")";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_COURSEID_COURSEID_NULL_2) + ")";
    private static final String _SQL_SELECT_LFQUIZ = "SELECT lfQuiz FROM LFQuiz lfQuiz";
    private static final String _SQL_SELECT_LFQUIZ_WHERE = "SELECT lfQuiz FROM LFQuiz lfQuiz WHERE ";
    private static final String _SQL_COUNT_LFQUIZ = "SELECT COUNT(lfQuiz) FROM LFQuiz lfQuiz";
    private static final String _SQL_COUNT_LFQUIZ_WHERE = "SELECT COUNT(lfQuiz) FROM LFQuiz lfQuiz WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuiz.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuiz exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuiz exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuizPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFQuiz _nullLFQuiz = new LFQuizImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuiz> toCacheModel() {
                return _nullLFQuizCacheModel;
            }
        };

    private static CacheModel<LFQuiz> _nullLFQuizCacheModel = new CacheModel<LFQuiz>() {
            @Override
            public LFQuiz toEntityModel() {
                return _nullLFQuiz;
            }
        };

    public LFQuizPersistenceImpl() {
        setModelClass(LFQuiz.class);
    }

    /**
     * Returns all the l f quizs where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findByCourseId(Integer courseID)
        throws SystemException {
        return findByCourseId(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f quizs where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f quizs
     * @param end the upper bound of the range of l f quizs (not inclusive)
     * @return the range of matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findByCourseId(Integer courseID, int start, int end)
        throws SystemException {
        return findByCourseId(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quizs where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f quizs
     * @param end the upper bound of the range of l f quizs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findByCourseId(Integer courseID, int start, int end,
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

        List<LFQuiz> list = (List<LFQuiz>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuiz lfQuiz : list) {
                if (!Validator.equals(courseID, lfQuiz.getCourseID())) {
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

            query.append(_SQL_SELECT_LFQUIZ_WHERE);

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
                query.append(LFQuizModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFQuiz>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuiz>(list);
                } else {
                    list = (List<LFQuiz>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f quiz in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a matching l f quiz could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz findByCourseId_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizException, SystemException {
        LFQuiz lfQuiz = fetchByCourseId_First(courseID, orderByComparator);

        if (lfQuiz != null) {
            return lfQuiz;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizException(msg.toString());
    }

    /**
     * Returns the first l f quiz in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz, or <code>null</code> if a matching l f quiz could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz fetchByCourseId_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFQuiz> list = findByCourseId(courseID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a matching l f quiz could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz findByCourseId_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizException, SystemException {
        LFQuiz lfQuiz = fetchByCourseId_Last(courseID, orderByComparator);

        if (lfQuiz != null) {
            return lfQuiz;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizException(msg.toString());
    }

    /**
     * Returns the last l f quiz in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz, or <code>null</code> if a matching l f quiz could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz fetchByCourseId_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseId(courseID);

        if (count == 0) {
            return null;
        }

        List<LFQuiz> list = findByCourseId(courseID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quizs before and after the current l f quiz in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f quiz
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz[] findByCourseId_PrevAndNext(long id, Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizException, SystemException {
        LFQuiz lfQuiz = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuiz[] array = new LFQuizImpl[3];

            array[0] = getByCourseId_PrevAndNext(session, lfQuiz, courseID,
                    orderByComparator, true);

            array[1] = lfQuiz;

            array[2] = getByCourseId_PrevAndNext(session, lfQuiz, courseID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuiz getByCourseId_PrevAndNext(Session session, LFQuiz lfQuiz,
        Integer courseID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZ_WHERE);

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
            query.append(LFQuizModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuiz);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuiz> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f quizs where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @return the matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findByCourseId(Integer[] courseIDs)
        throws SystemException {
        return findByCourseId(courseIDs, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f quizs where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f quizs
     * @param end the upper bound of the range of l f quizs (not inclusive)
     * @return the range of matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findByCourseId(Integer[] courseIDs, int start, int end)
        throws SystemException {
        return findByCourseId(courseIDs, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quizs where courseID = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseIDs the course i ds
     * @param start the lower bound of the range of l f quizs
     * @param end the upper bound of the range of l f quizs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findByCourseId(Integer[] courseIDs, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if ((courseIDs != null) && (courseIDs.length == 1)) {
            return findByCourseId(courseIDs[0], start, end, orderByComparator);
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

        List<LFQuiz> list = (List<LFQuiz>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuiz lfQuiz : list) {
                if (!ArrayUtil.contains(courseIDs, lfQuiz.getCourseID())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFQUIZ_WHERE);

            boolean conjunctionable = false;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_5);
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
                query.append(LFQuizModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFQuiz>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuiz>(list);
                } else {
                    list = (List<LFQuiz>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f quizs where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCourseId(Integer courseID) throws SystemException {
        for (LFQuiz lfQuiz : findByCourseId(courseID, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfQuiz);
        }
    }

    /**
     * Returns the number of l f quizs where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCourseId(Integer courseID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_COURSEID;

        Object[] finderArgs = new Object[] { courseID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFQUIZ_WHERE);

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
     * Returns the number of l f quizs where courseID = any &#63;.
     *
     * @param courseIDs the course i ds
     * @return the number of matching l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCourseId(Integer[] courseIDs) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(courseIDs) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFQUIZ_WHERE);

            boolean conjunctionable = false;

            if ((courseIDs != null) && (courseIDs.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < courseIDs.length; i++) {
                    if (courseIDs[i] == null) {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_COURSEID_COURSEID_5);
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

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_COURSEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f quiz in the entity cache if it is enabled.
     *
     * @param lfQuiz the l f quiz
     */
    @Override
    public void cacheResult(LFQuiz lfQuiz) {
        EntityCacheUtil.putResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizImpl.class, lfQuiz.getPrimaryKey(), lfQuiz);

        lfQuiz.resetOriginalValues();
    }

    /**
     * Caches the l f quizs in the entity cache if it is enabled.
     *
     * @param lfQuizs the l f quizs
     */
    @Override
    public void cacheResult(List<LFQuiz> lfQuizs) {
        for (LFQuiz lfQuiz : lfQuizs) {
            if (EntityCacheUtil.getResult(
                        LFQuizModelImpl.ENTITY_CACHE_ENABLED, LFQuizImpl.class,
                        lfQuiz.getPrimaryKey()) == null) {
                cacheResult(lfQuiz);
            } else {
                lfQuiz.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f quizs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuizImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuizImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f quiz.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuiz lfQuiz) {
        EntityCacheUtil.removeResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizImpl.class, lfQuiz.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuiz> lfQuizs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuiz lfQuiz : lfQuizs) {
            EntityCacheUtil.removeResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizImpl.class, lfQuiz.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f quiz with the primary key. Does not add the l f quiz to the database.
     *
     * @param id the primary key for the new l f quiz
     * @return the new l f quiz
     */
    @Override
    public LFQuiz create(long id) {
        LFQuiz lfQuiz = new LFQuizImpl();

        lfQuiz.setNew(true);
        lfQuiz.setPrimaryKey(id);

        return lfQuiz;
    }

    /**
     * Removes the l f quiz with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f quiz
     * @return the l f quiz that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz remove(long id) throws NoSuchLFQuizException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f quiz with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f quiz
     * @return the l f quiz that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz remove(Serializable primaryKey)
        throws NoSuchLFQuizException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuiz lfQuiz = (LFQuiz) session.get(LFQuizImpl.class, primaryKey);

            if (lfQuiz == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuizException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuiz);
        } catch (NoSuchLFQuizException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuiz removeImpl(LFQuiz lfQuiz) throws SystemException {
        lfQuiz = toUnwrappedModel(lfQuiz);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfQuiz)) {
                lfQuiz = (LFQuiz) session.get(LFQuizImpl.class,
                        lfQuiz.getPrimaryKeyObj());
            }

            if (lfQuiz != null) {
                session.delete(lfQuiz);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfQuiz != null) {
            clearCache(lfQuiz);
        }

        return lfQuiz;
    }

    @Override
    public LFQuiz updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz)
        throws SystemException {
        lfQuiz = toUnwrappedModel(lfQuiz);

        boolean isNew = lfQuiz.isNew();

        LFQuizModelImpl lfQuizModelImpl = (LFQuizModelImpl) lfQuiz;

        Session session = null;

        try {
            session = openSession();

            if (lfQuiz.isNew()) {
                session.save(lfQuiz);

                lfQuiz.setNew(false);
            } else {
                session.merge(lfQuiz);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuizModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuizModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] { lfQuizModelImpl.getCourseID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizImpl.class, lfQuiz.getPrimaryKey(), lfQuiz);

        return lfQuiz;
    }

    protected LFQuiz toUnwrappedModel(LFQuiz lfQuiz) {
        if (lfQuiz instanceof LFQuizImpl) {
            return lfQuiz;
        }

        LFQuizImpl lfQuizImpl = new LFQuizImpl();

        lfQuizImpl.setNew(lfQuiz.isNew());
        lfQuizImpl.setPrimaryKey(lfQuiz.getPrimaryKey());

        lfQuizImpl.setId(lfQuiz.getId());
        lfQuizImpl.setTitle(lfQuiz.getTitle());
        lfQuizImpl.setDescription(lfQuiz.getDescription());
        lfQuizImpl.setWelcomePageContent(lfQuiz.getWelcomePageContent());
        lfQuizImpl.setFinalPageContent(lfQuiz.getFinalPageContent());
        lfQuizImpl.setCourseID(lfQuiz.getCourseID());

        return lfQuizImpl;
    }

    /**
     * Returns the l f quiz with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz
     * @return the l f quiz
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFQuizException, SystemException {
        LFQuiz lfQuiz = fetchByPrimaryKey(primaryKey);

        if (lfQuiz == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFQuizException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfQuiz;
    }

    /**
     * Returns the l f quiz with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizException} if it could not be found.
     *
     * @param id the primary key of the l f quiz
     * @return the l f quiz
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz findByPrimaryKey(long id)
        throws NoSuchLFQuizException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f quiz with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz
     * @return the l f quiz, or <code>null</code> if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFQuiz lfQuiz = (LFQuiz) EntityCacheUtil.getResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizImpl.class, primaryKey);

        if (lfQuiz == _nullLFQuiz) {
            return null;
        }

        if (lfQuiz == null) {
            Session session = null;

            try {
                session = openSession();

                lfQuiz = (LFQuiz) session.get(LFQuizImpl.class, primaryKey);

                if (lfQuiz != null) {
                    cacheResult(lfQuiz);
                } else {
                    EntityCacheUtil.putResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizImpl.class, primaryKey, _nullLFQuiz);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFQuizModelImpl.ENTITY_CACHE_ENABLED,
                    LFQuizImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfQuiz;
    }

    /**
     * Returns the l f quiz with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f quiz
     * @return the l f quiz, or <code>null</code> if a l f quiz with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuiz fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f quizs.
     *
     * @return the l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quizs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quizs
     * @param end the upper bound of the range of l f quizs (not inclusive)
     * @return the range of l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quizs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quizs
     * @param end the upper bound of the range of l f quizs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f quizs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuiz> findAll(int start, int end,
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

        List<LFQuiz> list = (List<LFQuiz>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUIZ);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUIZ;

                if (pagination) {
                    sql = sql.concat(LFQuizModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFQuiz>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuiz>(list);
                } else {
                    list = (List<LFQuiz>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f quizs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFQuiz lfQuiz : findAll()) {
            remove(lfQuiz);
        }
    }

    /**
     * Returns the number of l f quizs.
     *
     * @return the number of l f quizs
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

                Query q = session.createQuery(_SQL_COUNT_LFQUIZ);

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
     * Initializes the l f quiz persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuiz")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuiz>> listenersList = new ArrayList<ModelListener<LFQuiz>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuiz>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuizImpl.class.getName());
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

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestionPersistence;

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
 * The persistence implementation for the l f quiz question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionPersistence
 * @see LFQuizQuestionUtil
 * @generated
 */
public class LFQuizQuestionPersistenceImpl extends BasePersistenceImpl<LFQuizQuestion>
    implements LFQuizQuestionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuizQuestionUtil} to access the l f quiz question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuizQuestionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByQuizID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID =
        new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuizID",
            new String[] { Integer.class.getName() },
            LFQuizQuestionModelImpl.QUIZID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZID = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuizID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL = "lfQuizQuestion.quizId IS NULL";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_2 = "lfQuizQuestion.quizId = ?";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL_2 = "lfQuizQuestion.quizId IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZANDCATEGORY =
        new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByQuizAndCategory",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY =
        new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuizAndCategory",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFQuizQuestionModelImpl.QUIZID_COLUMN_BITMASK |
            LFQuizQuestionModelImpl.CATEGORYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZANDCATEGORY = new FinderPath(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByQuizAndCategory",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL = "lfQuizQuestion.quizId IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2 = "lfQuizQuestion.quizId = ? AND ";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2 = "lfQuizQuestion.quizId IS NULL  AND ";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL = "lfQuizQuestion.categoryId IS NULL";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2 = "lfQuizQuestion.categoryId = ?";
    private static final String _FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2 =
        "lfQuizQuestion.categoryId IS NULL ";
    private static final String _SQL_SELECT_LFQUIZQUESTION = "SELECT lfQuizQuestion FROM LFQuizQuestion lfQuizQuestion";
    private static final String _SQL_SELECT_LFQUIZQUESTION_WHERE = "SELECT lfQuizQuestion FROM LFQuizQuestion lfQuizQuestion WHERE ";
    private static final String _SQL_COUNT_LFQUIZQUESTION = "SELECT COUNT(lfQuizQuestion) FROM LFQuizQuestion lfQuizQuestion";
    private static final String _SQL_COUNT_LFQUIZQUESTION_WHERE = "SELECT COUNT(lfQuizQuestion) FROM LFQuizQuestion lfQuizQuestion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuizQuestion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuizQuestion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuizQuestion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuizQuestionPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFQuizQuestion _nullLFQuizQuestion = new LFQuizQuestionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuizQuestion> toCacheModel() {
                return _nullLFQuizQuestionCacheModel;
            }
        };

    private static CacheModel<LFQuizQuestion> _nullLFQuizQuestionCacheModel = new CacheModel<LFQuizQuestion>() {
            @Override
            public LFQuizQuestion toEntityModel() {
                return _nullLFQuizQuestion;
            }
        };

    public LFQuizQuestionPersistenceImpl() {
        setModelClass(LFQuizQuestion.class);
    }

    /**
     * Returns all the l f quiz questions where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @return the matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findByQuizID(Integer quizId)
        throws SystemException {
        return findByQuizID(quizId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz questions where quizId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @return the range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findByQuizID(Integer quizId, int start, int end)
        throws SystemException {
        return findByQuizID(quizId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz questions where quizId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findByQuizID(Integer quizId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID;
            finderArgs = new Object[] { quizId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID;
            finderArgs = new Object[] { quizId, start, end, orderByComparator };
        }

        List<LFQuizQuestion> list = (List<LFQuizQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizQuestion lfQuizQuestion : list) {
                if (!Validator.equals(quizId, lfQuizQuestion.getQuizId())) {
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

            query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFQuizQuestionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizId != null) {
                    qPos.add(quizId.intValue());
                }

                if (!pagination) {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizQuestion>(list);
                } else {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
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
     * Returns the first l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByQuizID_First(Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizID_First(quizId,
                orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the first l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByQuizID_First(Integer quizId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFQuizQuestion> list = findByQuizID(quizId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByQuizID_Last(Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizID_Last(quizId,
                orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByQuizID_Last(Integer quizId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByQuizID(quizId);

        if (count == 0) {
            return null;
        }

        List<LFQuizQuestion> list = findByQuizID(quizId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz questions before and after the current l f quiz question in the ordered set where quizId = &#63;.
     *
     * @param id the primary key of the current l f quiz question
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion[] findByQuizID_PrevAndNext(long id, Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizQuestion[] array = new LFQuizQuestionImpl[3];

            array[0] = getByQuizID_PrevAndNext(session, lfQuizQuestion, quizId,
                    orderByComparator, true);

            array[1] = lfQuizQuestion;

            array[2] = getByQuizID_PrevAndNext(session, lfQuizQuestion, quizId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizQuestion getByQuizID_PrevAndNext(Session session,
        LFQuizQuestion lfQuizQuestion, Integer quizId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

        if (quizId == null) {
            query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
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
            query.append(LFQuizQuestionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (quizId != null) {
            qPos.add(quizId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f quiz questions where quizId = &#63; from the database.
     *
     * @param quizId the quiz ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByQuizID(Integer quizId) throws SystemException {
        for (LFQuizQuestion lfQuizQuestion : findByQuizID(quizId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfQuizQuestion);
        }
    }

    /**
     * Returns the number of l f quiz questions where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @return the number of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByQuizID(Integer quizId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_QUIZID;

        Object[] finderArgs = new Object[] { quizId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZID_QUIZID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizId != null) {
                    qPos.add(quizId.intValue());
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
     * Returns all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @return the matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findByQuizAndCategory(Integer quizId,
        Integer categoryId) throws SystemException {
        return findByQuizAndCategory(quizId, categoryId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @return the range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findByQuizAndCategory(Integer quizId,
        Integer categoryId, int start, int end) throws SystemException {
        return findByQuizAndCategory(quizId, categoryId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findByQuizAndCategory(Integer quizId,
        Integer categoryId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY;
            finderArgs = new Object[] { quizId, categoryId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZANDCATEGORY;
            finderArgs = new Object[] {
                    quizId, categoryId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuizQuestion> list = (List<LFQuizQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizQuestion lfQuizQuestion : list) {
                if (!Validator.equals(quizId, lfQuizQuestion.getQuizId()) ||
                        !Validator.equals(categoryId,
                            lfQuizQuestion.getCategoryId())) {
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

            query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2);
            }

            if (categoryId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFQuizQuestionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizId != null) {
                    qPos.add(quizId.intValue());
                }

                if (categoryId != null) {
                    qPos.add(categoryId.intValue());
                }

                if (!pagination) {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizQuestion>(list);
                } else {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
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
     * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByQuizAndCategory_First(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizAndCategory_First(quizId,
                categoryId, orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(", categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByQuizAndCategory_First(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFQuizQuestion> list = findByQuizAndCategory(quizId, categoryId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByQuizAndCategory_Last(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByQuizAndCategory_Last(quizId,
                categoryId, orderByComparator);

        if (lfQuizQuestion != null) {
            return lfQuizQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(", categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestionException(msg.toString());
    }

    /**
     * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByQuizAndCategory_Last(Integer quizId,
        Integer categoryId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByQuizAndCategory(quizId, categoryId);

        if (count == 0) {
            return null;
        }

        List<LFQuizQuestion> list = findByQuizAndCategory(quizId, categoryId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz questions before and after the current l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
     *
     * @param id the primary key of the current l f quiz question
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion[] findByQuizAndCategory_PrevAndNext(long id,
        Integer quizId, Integer categoryId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizQuestion[] array = new LFQuizQuestionImpl[3];

            array[0] = getByQuizAndCategory_PrevAndNext(session,
                    lfQuizQuestion, quizId, categoryId, orderByComparator, true);

            array[1] = lfQuizQuestion;

            array[2] = getByQuizAndCategory_PrevAndNext(session,
                    lfQuizQuestion, quizId, categoryId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizQuestion getByQuizAndCategory_PrevAndNext(Session session,
        LFQuizQuestion lfQuizQuestion, Integer quizId, Integer categoryId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZQUESTION_WHERE);

        if (quizId == null) {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2);
        }

        if (categoryId == null) {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2);
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
            query.append(LFQuizQuestionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (quizId != null) {
            qPos.add(quizId.intValue());
        }

        if (categoryId != null) {
            qPos.add(categoryId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f quiz questions where quizId = &#63; and categoryId = &#63; from the database.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByQuizAndCategory(Integer quizId, Integer categoryId)
        throws SystemException {
        for (LFQuizQuestion lfQuizQuestion : findByQuizAndCategory(quizId,
                categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfQuizQuestion);
        }
    }

    /**
     * Returns the number of l f quiz questions where quizId = &#63; and categoryId = &#63;.
     *
     * @param quizId the quiz ID
     * @param categoryId the category ID
     * @return the number of matching l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByQuizAndCategory(Integer quizId, Integer categoryId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_QUIZANDCATEGORY;

        Object[] finderArgs = new Object[] { quizId, categoryId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFQUIZQUESTION_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_QUIZID_2);
            }

            if (categoryId == null) {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZANDCATEGORY_CATEGORYID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (quizId != null) {
                    qPos.add(quizId.intValue());
                }

                if (categoryId != null) {
                    qPos.add(categoryId.intValue());
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
     * Caches the l f quiz question in the entity cache if it is enabled.
     *
     * @param lfQuizQuestion the l f quiz question
     */
    @Override
    public void cacheResult(LFQuizQuestion lfQuizQuestion) {
        EntityCacheUtil.putResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey(),
            lfQuizQuestion);

        lfQuizQuestion.resetOriginalValues();
    }

    /**
     * Caches the l f quiz questions in the entity cache if it is enabled.
     *
     * @param lfQuizQuestions the l f quiz questions
     */
    @Override
    public void cacheResult(List<LFQuizQuestion> lfQuizQuestions) {
        for (LFQuizQuestion lfQuizQuestion : lfQuizQuestions) {
            if (EntityCacheUtil.getResult(
                        LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey()) == null) {
                cacheResult(lfQuizQuestion);
            } else {
                lfQuizQuestion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f quiz questions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuizQuestionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuizQuestionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f quiz question.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuizQuestion lfQuizQuestion) {
        EntityCacheUtil.removeResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuizQuestion> lfQuizQuestions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuizQuestion lfQuizQuestion : lfQuizQuestions) {
            EntityCacheUtil.removeResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f quiz question with the primary key. Does not add the l f quiz question to the database.
     *
     * @param id the primary key for the new l f quiz question
     * @return the new l f quiz question
     */
    @Override
    public LFQuizQuestion create(long id) {
        LFQuizQuestion lfQuizQuestion = new LFQuizQuestionImpl();

        lfQuizQuestion.setNew(true);
        lfQuizQuestion.setPrimaryKey(id);

        return lfQuizQuestion;
    }

    /**
     * Removes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f quiz question
     * @return the l f quiz question that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion remove(long id)
        throws NoSuchLFQuizQuestionException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f quiz question
     * @return the l f quiz question that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion remove(Serializable primaryKey)
        throws NoSuchLFQuizQuestionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuizQuestion lfQuizQuestion = (LFQuizQuestion) session.get(LFQuizQuestionImpl.class,
                    primaryKey);

            if (lfQuizQuestion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuizQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuizQuestion);
        } catch (NoSuchLFQuizQuestionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuizQuestion removeImpl(LFQuizQuestion lfQuizQuestion)
        throws SystemException {
        lfQuizQuestion = toUnwrappedModel(lfQuizQuestion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfQuizQuestion)) {
                lfQuizQuestion = (LFQuizQuestion) session.get(LFQuizQuestionImpl.class,
                        lfQuizQuestion.getPrimaryKeyObj());
            }

            if (lfQuizQuestion != null) {
                session.delete(lfQuizQuestion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfQuizQuestion != null) {
            clearCache(lfQuizQuestion);
        }

        return lfQuizQuestion;
    }

    @Override
    public LFQuizQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws SystemException {
        lfQuizQuestion = toUnwrappedModel(lfQuizQuestion);

        boolean isNew = lfQuizQuestion.isNew();

        LFQuizQuestionModelImpl lfQuizQuestionModelImpl = (LFQuizQuestionModelImpl) lfQuizQuestion;

        Session session = null;

        try {
            session = openSession();

            if (lfQuizQuestion.isNew()) {
                session.save(lfQuizQuestion);

                lfQuizQuestion.setNew(false);
            } else {
                session.merge(lfQuizQuestion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuizQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuizQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizQuestionModelImpl.getOriginalQuizId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);

                args = new Object[] { lfQuizQuestionModelImpl.getQuizId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);
            }

            if ((lfQuizQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizQuestionModelImpl.getOriginalQuizId(),
                        lfQuizQuestionModelImpl.getOriginalCategoryId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZANDCATEGORY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY,
                    args);

                args = new Object[] {
                        lfQuizQuestionModelImpl.getQuizId(),
                        lfQuizQuestionModelImpl.getCategoryId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZANDCATEGORY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZANDCATEGORY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestionImpl.class, lfQuizQuestion.getPrimaryKey(),
            lfQuizQuestion);

        return lfQuizQuestion;
    }

    protected LFQuizQuestion toUnwrappedModel(LFQuizQuestion lfQuizQuestion) {
        if (lfQuizQuestion instanceof LFQuizQuestionImpl) {
            return lfQuizQuestion;
        }

        LFQuizQuestionImpl lfQuizQuestionImpl = new LFQuizQuestionImpl();

        lfQuizQuestionImpl.setNew(lfQuizQuestion.isNew());
        lfQuizQuestionImpl.setPrimaryKey(lfQuizQuestion.getPrimaryKey());

        lfQuizQuestionImpl.setId(lfQuizQuestion.getId());
        lfQuizQuestionImpl.setQuizId(lfQuizQuestion.getQuizId());
        lfQuizQuestionImpl.setCategoryId(lfQuizQuestion.getCategoryId());
        lfQuizQuestionImpl.setQuestionId(lfQuizQuestion.getQuestionId());
        lfQuizQuestionImpl.setQuestionType(lfQuizQuestion.getQuestionType());
        lfQuizQuestionImpl.setTitle(lfQuizQuestion.getTitle());
        lfQuizQuestionImpl.setUrl(lfQuizQuestion.getUrl());
        lfQuizQuestionImpl.setPlainText(lfQuizQuestion.getPlainText());
        lfQuizQuestionImpl.setArrangementIndex(lfQuizQuestion.getArrangementIndex());
        lfQuizQuestionImpl.setAutoShowAnswer(lfQuizQuestion.getAutoShowAnswer());
        lfQuizQuestionImpl.setGroupId(lfQuizQuestion.getGroupId());

        return lfQuizQuestionImpl;
    }

    /**
     * Returns the l f quiz question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz question
     * @return the l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFQuizQuestionException, SystemException {
        LFQuizQuestion lfQuizQuestion = fetchByPrimaryKey(primaryKey);

        if (lfQuizQuestion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFQuizQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfQuizQuestion;
    }

    /**
     * Returns the l f quiz question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException} if it could not be found.
     *
     * @param id the primary key of the l f quiz question
     * @return the l f quiz question
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion findByPrimaryKey(long id)
        throws NoSuchLFQuizQuestionException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f quiz question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz question
     * @return the l f quiz question, or <code>null</code> if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFQuizQuestion lfQuizQuestion = (LFQuizQuestion) EntityCacheUtil.getResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizQuestionImpl.class, primaryKey);

        if (lfQuizQuestion == _nullLFQuizQuestion) {
            return null;
        }

        if (lfQuizQuestion == null) {
            Session session = null;

            try {
                session = openSession();

                lfQuizQuestion = (LFQuizQuestion) session.get(LFQuizQuestionImpl.class,
                        primaryKey);

                if (lfQuizQuestion != null) {
                    cacheResult(lfQuizQuestion);
                } else {
                    EntityCacheUtil.putResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizQuestionImpl.class, primaryKey,
                        _nullLFQuizQuestion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFQuizQuestionModelImpl.ENTITY_CACHE_ENABLED,
                    LFQuizQuestionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfQuizQuestion;
    }

    /**
     * Returns the l f quiz question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f quiz question
     * @return the l f quiz question, or <code>null</code> if a l f quiz question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestion fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f quiz questions.
     *
     * @return the l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @return the range of l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz questions
     * @param end the upper bound of the range of l f quiz questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f quiz questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestion> findAll(int start, int end,
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

        List<LFQuizQuestion> list = (List<LFQuizQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUIZQUESTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUIZQUESTION;

                if (pagination) {
                    sql = sql.concat(LFQuizQuestionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizQuestion>(list);
                } else {
                    list = (List<LFQuizQuestion>) QueryUtil.list(q,
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
     * Removes all the l f quiz questions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFQuizQuestion lfQuizQuestion : findAll()) {
            remove(lfQuizQuestion);
        }
    }

    /**
     * Returns the number of l f quiz questions.
     *
     * @return the number of l f quiz questions
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

                Query q = session.createQuery(_SQL_COUNT_LFQUIZQUESTION);

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
     * Initializes the l f quiz question persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuizQuestion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuizQuestion>> listenersList = new ArrayList<ModelListener<LFQuizQuestion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuizQuestion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuizQuestionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

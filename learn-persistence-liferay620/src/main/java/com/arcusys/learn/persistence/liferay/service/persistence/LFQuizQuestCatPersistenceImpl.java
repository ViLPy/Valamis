package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException;
import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFQuizQuestCatPersistence;

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
 * The persistence implementation for the l f quiz quest cat service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestCatPersistence
 * @see LFQuizQuestCatUtil
 * @generated
 */
public class LFQuizQuestCatPersistenceImpl extends BasePersistenceImpl<LFQuizQuestCat>
    implements LFQuizQuestCatPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFQuizQuestCatUtil} to access the l f quiz quest cat persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFQuizQuestCatImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestCatImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestCatImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZIDANDPARENTID =
        new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestCatImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByQuizIdAndParentId",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZIDANDPARENTID =
        new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestCatImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByQuizIdAndParentId",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFQuizQuestCatModelImpl.QUIZID_COLUMN_BITMASK |
            LFQuizQuestCatModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZIDANDPARENTID = new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByQuizIdAndParentId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_NULL = "lfQuizQuestCat.quizId IS NULL";
    private static final String _FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_2 = "lfQuizQuestCat.quizId = ? AND ";
    private static final String _FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_NULL_2 = "lfQuizQuestCat.quizId IS NULL  AND ";
    private static final String _FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_NULL = "lfQuizQuestCat.parentId IS NULL";
    private static final String _FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_2 = "lfQuizQuestCat.parentId = ?";
    private static final String _FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_NULL_2 =
        "lfQuizQuestCat.parentId IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZID = new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestCatImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByQuizId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID =
        new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED,
            LFQuizQuestCatImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuizId",
            new String[] { Integer.class.getName() },
            LFQuizQuestCatModelImpl.QUIZID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_QUIZID = new FinderPath(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuizId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL = "lfQuizQuestCat.quizId IS NULL";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_2 = "lfQuizQuestCat.quizId = ?";
    private static final String _FINDER_COLUMN_QUIZID_QUIZID_NULL_2 = "lfQuizQuestCat.quizId IS NULL ";
    private static final String _SQL_SELECT_LFQUIZQUESTCAT = "SELECT lfQuizQuestCat FROM LFQuizQuestCat lfQuizQuestCat";
    private static final String _SQL_SELECT_LFQUIZQUESTCAT_WHERE = "SELECT lfQuizQuestCat FROM LFQuizQuestCat lfQuizQuestCat WHERE ";
    private static final String _SQL_COUNT_LFQUIZQUESTCAT = "SELECT COUNT(lfQuizQuestCat) FROM LFQuizQuestCat lfQuizQuestCat";
    private static final String _SQL_COUNT_LFQUIZQUESTCAT_WHERE = "SELECT COUNT(lfQuizQuestCat) FROM LFQuizQuestCat lfQuizQuestCat WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfQuizQuestCat.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFQuizQuestCat exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFQuizQuestCat exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFQuizQuestCatPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFQuizQuestCat _nullLFQuizQuestCat = new LFQuizQuestCatImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFQuizQuestCat> toCacheModel() {
                return _nullLFQuizQuestCatCacheModel;
            }
        };

    private static CacheModel<LFQuizQuestCat> _nullLFQuizQuestCatCacheModel = new CacheModel<LFQuizQuestCat>() {
            @Override
            public LFQuizQuestCat toEntityModel() {
                return _nullLFQuizQuestCat;
            }
        };

    public LFQuizQuestCatPersistenceImpl() {
        setModelClass(LFQuizQuestCat.class);
    }

    /**
     * Returns all the l f quiz quest cats where quizId = &#63; and parentId = &#63;.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @return the matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findByQuizIdAndParentId(Integer quizId,
        Integer parentId) throws SystemException {
        return findByQuizIdAndParentId(quizId, parentId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz quest cats where quizId = &#63; and parentId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param start the lower bound of the range of l f quiz quest cats
     * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
     * @return the range of matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findByQuizIdAndParentId(Integer quizId,
        Integer parentId, int start, int end) throws SystemException {
        return findByQuizIdAndParentId(quizId, parentId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz quest cats where quizId = &#63; and parentId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param start the lower bound of the range of l f quiz quest cats
     * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findByQuizIdAndParentId(Integer quizId,
        Integer parentId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZIDANDPARENTID;
            finderArgs = new Object[] { quizId, parentId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUIZIDANDPARENTID;
            finderArgs = new Object[] {
                    quizId, parentId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFQuizQuestCat> list = (List<LFQuizQuestCat>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizQuestCat lfQuizQuestCat : list) {
                if (!Validator.equals(quizId, lfQuizQuestCat.getQuizId()) ||
                        !Validator.equals(parentId, lfQuizQuestCat.getParentId())) {
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

            query.append(_SQL_SELECT_LFQUIZQUESTCAT_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_2);
            }

            if (parentId == null) {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFQuizQuestCatModelImpl.ORDER_BY_JPQL);
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

                if (parentId != null) {
                    qPos.add(parentId.intValue());
                }

                if (!pagination) {
                    list = (List<LFQuizQuestCat>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizQuestCat>(list);
                } else {
                    list = (List<LFQuizQuestCat>) QueryUtil.list(q,
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
     * Returns the first l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat findByQuizIdAndParentId_First(Integer quizId,
        Integer parentId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = fetchByQuizIdAndParentId_First(quizId,
                parentId, orderByComparator);

        if (lfQuizQuestCat != null) {
            return lfQuizQuestCat;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(", parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestCatException(msg.toString());
    }

    /**
     * Returns the first l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat fetchByQuizIdAndParentId_First(Integer quizId,
        Integer parentId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFQuizQuestCat> list = findByQuizIdAndParentId(quizId, parentId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat findByQuizIdAndParentId_Last(Integer quizId,
        Integer parentId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = fetchByQuizIdAndParentId_Last(quizId,
                parentId, orderByComparator);

        if (lfQuizQuestCat != null) {
            return lfQuizQuestCat;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(", parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestCatException(msg.toString());
    }

    /**
     * Returns the last l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat fetchByQuizIdAndParentId_Last(Integer quizId,
        Integer parentId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByQuizIdAndParentId(quizId, parentId);

        if (count == 0) {
            return null;
        }

        List<LFQuizQuestCat> list = findByQuizIdAndParentId(quizId, parentId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz quest cats before and after the current l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
     *
     * @param id the primary key of the current l f quiz quest cat
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat[] findByQuizIdAndParentId_PrevAndNext(long id,
        Integer quizId, Integer parentId, OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizQuestCat[] array = new LFQuizQuestCatImpl[3];

            array[0] = getByQuizIdAndParentId_PrevAndNext(session,
                    lfQuizQuestCat, quizId, parentId, orderByComparator, true);

            array[1] = lfQuizQuestCat;

            array[2] = getByQuizIdAndParentId_PrevAndNext(session,
                    lfQuizQuestCat, quizId, parentId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizQuestCat getByQuizIdAndParentId_PrevAndNext(
        Session session, LFQuizQuestCat lfQuizQuestCat, Integer quizId,
        Integer parentId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZQUESTCAT_WHERE);

        if (quizId == null) {
            query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_2);
        }

        if (parentId == null) {
            query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_2);
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
            query.append(LFQuizQuestCatModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (quizId != null) {
            qPos.add(quizId.intValue());
        }

        if (parentId != null) {
            qPos.add(parentId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizQuestCat);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizQuestCat> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f quiz quest cats where quizId = &#63; and parentId = &#63; from the database.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByQuizIdAndParentId(Integer quizId, Integer parentId)
        throws SystemException {
        for (LFQuizQuestCat lfQuizQuestCat : findByQuizIdAndParentId(quizId,
                parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfQuizQuestCat);
        }
    }

    /**
     * Returns the number of l f quiz quest cats where quizId = &#63; and parentId = &#63;.
     *
     * @param quizId the quiz ID
     * @param parentId the parent ID
     * @return the number of matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByQuizIdAndParentId(Integer quizId, Integer parentId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_QUIZIDANDPARENTID;

        Object[] finderArgs = new Object[] { quizId, parentId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFQUIZQUESTCAT_WHERE);

            if (quizId == null) {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_QUIZID_2);
            }

            if (parentId == null) {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_QUIZIDANDPARENTID_PARENTID_2);
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

                if (parentId != null) {
                    qPos.add(parentId.intValue());
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
     * Returns all the l f quiz quest cats where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @return the matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findByQuizId(Integer quizId)
        throws SystemException {
        return findByQuizId(quizId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz quest cats where quizId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param start the lower bound of the range of l f quiz quest cats
     * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
     * @return the range of matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findByQuizId(Integer quizId, int start, int end)
        throws SystemException {
        return findByQuizId(quizId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz quest cats where quizId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param quizId the quiz ID
     * @param start the lower bound of the range of l f quiz quest cats
     * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findByQuizId(Integer quizId, int start,
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

        List<LFQuizQuestCat> list = (List<LFQuizQuestCat>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFQuizQuestCat lfQuizQuestCat : list) {
                if (!Validator.equals(quizId, lfQuizQuestCat.getQuizId())) {
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

            query.append(_SQL_SELECT_LFQUIZQUESTCAT_WHERE);

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
                query.append(LFQuizQuestCatModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFQuizQuestCat>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizQuestCat>(list);
                } else {
                    list = (List<LFQuizQuestCat>) QueryUtil.list(q,
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
     * Returns the first l f quiz quest cat in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat findByQuizId_First(Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = fetchByQuizId_First(quizId,
                orderByComparator);

        if (lfQuizQuestCat != null) {
            return lfQuizQuestCat;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestCatException(msg.toString());
    }

    /**
     * Returns the first l f quiz quest cat in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat fetchByQuizId_First(Integer quizId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFQuizQuestCat> list = findByQuizId(quizId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f quiz quest cat in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat findByQuizId_Last(Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = fetchByQuizId_Last(quizId,
                orderByComparator);

        if (lfQuizQuestCat != null) {
            return lfQuizQuestCat;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("quizId=");
        msg.append(quizId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFQuizQuestCatException(msg.toString());
    }

    /**
     * Returns the last l f quiz quest cat in the ordered set where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat fetchByQuizId_Last(Integer quizId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByQuizId(quizId);

        if (count == 0) {
            return null;
        }

        List<LFQuizQuestCat> list = findByQuizId(quizId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f quiz quest cats before and after the current l f quiz quest cat in the ordered set where quizId = &#63;.
     *
     * @param id the primary key of the current l f quiz quest cat
     * @param quizId the quiz ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat[] findByQuizId_PrevAndNext(long id, Integer quizId,
        OrderByComparator orderByComparator)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFQuizQuestCat[] array = new LFQuizQuestCatImpl[3];

            array[0] = getByQuizId_PrevAndNext(session, lfQuizQuestCat, quizId,
                    orderByComparator, true);

            array[1] = lfQuizQuestCat;

            array[2] = getByQuizId_PrevAndNext(session, lfQuizQuestCat, quizId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFQuizQuestCat getByQuizId_PrevAndNext(Session session,
        LFQuizQuestCat lfQuizQuestCat, Integer quizId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFQUIZQUESTCAT_WHERE);

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
            query.append(LFQuizQuestCatModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfQuizQuestCat);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFQuizQuestCat> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f quiz quest cats where quizId = &#63; from the database.
     *
     * @param quizId the quiz ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByQuizId(Integer quizId) throws SystemException {
        for (LFQuizQuestCat lfQuizQuestCat : findByQuizId(quizId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfQuizQuestCat);
        }
    }

    /**
     * Returns the number of l f quiz quest cats where quizId = &#63;.
     *
     * @param quizId the quiz ID
     * @return the number of matching l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByQuizId(Integer quizId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_QUIZID;

        Object[] finderArgs = new Object[] { quizId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFQUIZQUESTCAT_WHERE);

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
     * Caches the l f quiz quest cat in the entity cache if it is enabled.
     *
     * @param lfQuizQuestCat the l f quiz quest cat
     */
    @Override
    public void cacheResult(LFQuizQuestCat lfQuizQuestCat) {
        EntityCacheUtil.putResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatImpl.class, lfQuizQuestCat.getPrimaryKey(),
            lfQuizQuestCat);

        lfQuizQuestCat.resetOriginalValues();
    }

    /**
     * Caches the l f quiz quest cats in the entity cache if it is enabled.
     *
     * @param lfQuizQuestCats the l f quiz quest cats
     */
    @Override
    public void cacheResult(List<LFQuizQuestCat> lfQuizQuestCats) {
        for (LFQuizQuestCat lfQuizQuestCat : lfQuizQuestCats) {
            if (EntityCacheUtil.getResult(
                        LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizQuestCatImpl.class, lfQuizQuestCat.getPrimaryKey()) == null) {
                cacheResult(lfQuizQuestCat);
            } else {
                lfQuizQuestCat.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f quiz quest cats.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFQuizQuestCatImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFQuizQuestCatImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f quiz quest cat.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFQuizQuestCat lfQuizQuestCat) {
        EntityCacheUtil.removeResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatImpl.class, lfQuizQuestCat.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFQuizQuestCat> lfQuizQuestCats) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFQuizQuestCat lfQuizQuestCat : lfQuizQuestCats) {
            EntityCacheUtil.removeResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizQuestCatImpl.class, lfQuizQuestCat.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f quiz quest cat with the primary key. Does not add the l f quiz quest cat to the database.
     *
     * @param id the primary key for the new l f quiz quest cat
     * @return the new l f quiz quest cat
     */
    @Override
    public LFQuizQuestCat create(long id) {
        LFQuizQuestCat lfQuizQuestCat = new LFQuizQuestCatImpl();

        lfQuizQuestCat.setNew(true);
        lfQuizQuestCat.setPrimaryKey(id);

        return lfQuizQuestCat;
    }

    /**
     * Removes the l f quiz quest cat with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f quiz quest cat
     * @return the l f quiz quest cat that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat remove(long id)
        throws NoSuchLFQuizQuestCatException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f quiz quest cat with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f quiz quest cat
     * @return the l f quiz quest cat that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat remove(Serializable primaryKey)
        throws NoSuchLFQuizQuestCatException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFQuizQuestCat lfQuizQuestCat = (LFQuizQuestCat) session.get(LFQuizQuestCatImpl.class,
                    primaryKey);

            if (lfQuizQuestCat == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFQuizQuestCatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfQuizQuestCat);
        } catch (NoSuchLFQuizQuestCatException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFQuizQuestCat removeImpl(LFQuizQuestCat lfQuizQuestCat)
        throws SystemException {
        lfQuizQuestCat = toUnwrappedModel(lfQuizQuestCat);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfQuizQuestCat)) {
                lfQuizQuestCat = (LFQuizQuestCat) session.get(LFQuizQuestCatImpl.class,
                        lfQuizQuestCat.getPrimaryKeyObj());
            }

            if (lfQuizQuestCat != null) {
                session.delete(lfQuizQuestCat);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfQuizQuestCat != null) {
            clearCache(lfQuizQuestCat);
        }

        return lfQuizQuestCat;
    }

    @Override
    public LFQuizQuestCat updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat lfQuizQuestCat)
        throws SystemException {
        lfQuizQuestCat = toUnwrappedModel(lfQuizQuestCat);

        boolean isNew = lfQuizQuestCat.isNew();

        LFQuizQuestCatModelImpl lfQuizQuestCatModelImpl = (LFQuizQuestCatModelImpl) lfQuizQuestCat;

        Session session = null;

        try {
            session = openSession();

            if (lfQuizQuestCat.isNew()) {
                session.save(lfQuizQuestCat);

                lfQuizQuestCat.setNew(false);
            } else {
                session.merge(lfQuizQuestCat);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFQuizQuestCatModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfQuizQuestCatModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZIDANDPARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizQuestCatModelImpl.getOriginalQuizId(),
                        lfQuizQuestCatModelImpl.getOriginalParentId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZIDANDPARENTID,
                    args);

                args = new Object[] {
                        lfQuizQuestCatModelImpl.getQuizId(),
                        lfQuizQuestCatModelImpl.getParentId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZIDANDPARENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZIDANDPARENTID,
                    args);
            }

            if ((lfQuizQuestCatModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfQuizQuestCatModelImpl.getOriginalQuizId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);

                args = new Object[] { lfQuizQuestCatModelImpl.getQuizId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUIZID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUIZID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
            LFQuizQuestCatImpl.class, lfQuizQuestCat.getPrimaryKey(),
            lfQuizQuestCat);

        return lfQuizQuestCat;
    }

    protected LFQuizQuestCat toUnwrappedModel(LFQuizQuestCat lfQuizQuestCat) {
        if (lfQuizQuestCat instanceof LFQuizQuestCatImpl) {
            return lfQuizQuestCat;
        }

        LFQuizQuestCatImpl lfQuizQuestCatImpl = new LFQuizQuestCatImpl();

        lfQuizQuestCatImpl.setNew(lfQuizQuestCat.isNew());
        lfQuizQuestCatImpl.setPrimaryKey(lfQuizQuestCat.getPrimaryKey());

        lfQuizQuestCatImpl.setId(lfQuizQuestCat.getId());
        lfQuizQuestCatImpl.setTitle(lfQuizQuestCat.getTitle());
        lfQuizQuestCatImpl.setDescription(lfQuizQuestCat.getDescription());
        lfQuizQuestCatImpl.setQuizId(lfQuizQuestCat.getQuizId());
        lfQuizQuestCatImpl.setParentId(lfQuizQuestCat.getParentId());
        lfQuizQuestCatImpl.setArrangementIndex(lfQuizQuestCat.getArrangementIndex());

        return lfQuizQuestCatImpl;
    }

    /**
     * Returns the l f quiz quest cat with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz quest cat
     * @return the l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFQuizQuestCatException, SystemException {
        LFQuizQuestCat lfQuizQuestCat = fetchByPrimaryKey(primaryKey);

        if (lfQuizQuestCat == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFQuizQuestCatException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfQuizQuestCat;
    }

    /**
     * Returns the l f quiz quest cat with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException} if it could not be found.
     *
     * @param id the primary key of the l f quiz quest cat
     * @return the l f quiz quest cat
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat findByPrimaryKey(long id)
        throws NoSuchLFQuizQuestCatException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f quiz quest cat with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f quiz quest cat
     * @return the l f quiz quest cat, or <code>null</code> if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFQuizQuestCat lfQuizQuestCat = (LFQuizQuestCat) EntityCacheUtil.getResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
                LFQuizQuestCatImpl.class, primaryKey);

        if (lfQuizQuestCat == _nullLFQuizQuestCat) {
            return null;
        }

        if (lfQuizQuestCat == null) {
            Session session = null;

            try {
                session = openSession();

                lfQuizQuestCat = (LFQuizQuestCat) session.get(LFQuizQuestCatImpl.class,
                        primaryKey);

                if (lfQuizQuestCat != null) {
                    cacheResult(lfQuizQuestCat);
                } else {
                    EntityCacheUtil.putResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
                        LFQuizQuestCatImpl.class, primaryKey,
                        _nullLFQuizQuestCat);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFQuizQuestCatModelImpl.ENTITY_CACHE_ENABLED,
                    LFQuizQuestCatImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfQuizQuestCat;
    }

    /**
     * Returns the l f quiz quest cat with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f quiz quest cat
     * @return the l f quiz quest cat, or <code>null</code> if a l f quiz quest cat with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFQuizQuestCat fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f quiz quest cats.
     *
     * @return the l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f quiz quest cats.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz quest cats
     * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
     * @return the range of l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f quiz quest cats.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f quiz quest cats
     * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f quiz quest cats
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFQuizQuestCat> findAll(int start, int end,
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

        List<LFQuizQuestCat> list = (List<LFQuizQuestCat>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFQUIZQUESTCAT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFQUIZQUESTCAT;

                if (pagination) {
                    sql = sql.concat(LFQuizQuestCatModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFQuizQuestCat>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFQuizQuestCat>(list);
                } else {
                    list = (List<LFQuizQuestCat>) QueryUtil.list(q,
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
     * Removes all the l f quiz quest cats from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFQuizQuestCat lfQuizQuestCat : findAll()) {
            remove(lfQuizQuestCat);
        }
    }

    /**
     * Returns the number of l f quiz quest cats.
     *
     * @return the number of l f quiz quest cats
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

                Query q = session.createQuery(_SQL_COUNT_LFQUIZQUESTCAT);

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
     * Initializes the l f quiz quest cat persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFQuizQuestCat>> listenersList = new ArrayList<ModelListener<LFQuizQuestCat>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFQuizQuestCat>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFQuizQuestCatImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException;
import com.arcusys.learn.persistence.liferay.model.LFAchievementUser;
import com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAchievementUserPersistence;

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
 * The persistence implementation for the l f achievement user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementUserPersistence
 * @see LFAchievementUserUtil
 * @generated
 */
public class LFAchievementUserPersistenceImpl extends BasePersistenceImpl<LFAchievementUser>
    implements LFAchievementUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFAchievementUserUtil} to access the l f achievement user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFAchievementUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Integer.class.getName() },
            LFAchievementUserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_NULL = "lfAchievementUser.userId IS NULL";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "lfAchievementUser.userId = ?";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL_2 = "lfAchievementUser.userId IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACHIEVEMENTID =
        new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAchievementId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID =
        new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAchievementId",
            new String[] { Integer.class.getName() },
            LFAchievementUserModelImpl.ACHIEVEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACHIEVEMENTID = new FinderPath(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAchievementId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL = "lfAchievementUser.achievementId IS NULL";
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_2 = "lfAchievementUser.achievementId = ?";
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL_2 =
        "lfAchievementUser.achievementId IS NULL ";
    private static final String _SQL_SELECT_LFACHIEVEMENTUSER = "SELECT lfAchievementUser FROM LFAchievementUser lfAchievementUser";
    private static final String _SQL_SELECT_LFACHIEVEMENTUSER_WHERE = "SELECT lfAchievementUser FROM LFAchievementUser lfAchievementUser WHERE ";
    private static final String _SQL_COUNT_LFACHIEVEMENTUSER = "SELECT COUNT(lfAchievementUser) FROM LFAchievementUser lfAchievementUser";
    private static final String _SQL_COUNT_LFACHIEVEMENTUSER_WHERE = "SELECT COUNT(lfAchievementUser) FROM LFAchievementUser lfAchievementUser WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfAchievementUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFAchievementUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFAchievementUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFAchievementUserPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFAchievementUser _nullLFAchievementUser = new LFAchievementUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFAchievementUser> toCacheModel() {
                return _nullLFAchievementUserCacheModel;
            }
        };

    private static CacheModel<LFAchievementUser> _nullLFAchievementUserCacheModel =
        new CacheModel<LFAchievementUser>() {
            @Override
            public LFAchievementUser toEntityModel() {
                return _nullLFAchievementUser;
            }
        };

    public LFAchievementUserPersistenceImpl() {
        setModelClass(LFAchievementUser.class);
    }

    /**
     * Returns all the l f achievement users where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findByUserId(Integer userId)
        throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement users where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of l f achievement users
     * @param end the upper bound of the range of l f achievement users (not inclusive)
     * @return the range of matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findByUserId(Integer userId, int start,
        int end) throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement users where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of l f achievement users
     * @param end the upper bound of the range of l f achievement users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findByUserId(Integer userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<LFAchievementUser> list = (List<LFAchievementUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAchievementUser lfAchievementUser : list) {
                if (!Validator.equals(userId, lfAchievementUser.getUserId())) {
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

            query.append(_SQL_SELECT_LFACHIEVEMENTUSER_WHERE);

            if (userId == null) {
                query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_USERID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAchievementUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userId != null) {
                    qPos.add(userId.intValue());
                }

                if (!pagination) {
                    list = (List<LFAchievementUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementUser>(list);
                } else {
                    list = (List<LFAchievementUser>) QueryUtil.list(q,
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
     * Returns the first l f achievement user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser findByUserId_First(Integer userId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = fetchByUserId_First(userId,
                orderByComparator);

        if (lfAchievementUser != null) {
            return lfAchievementUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementUserException(msg.toString());
    }

    /**
     * Returns the first l f achievement user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser fetchByUserId_First(Integer userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAchievementUser> list = findByUserId(userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f achievement user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser findByUserId_Last(Integer userId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = fetchByUserId_Last(userId,
                orderByComparator);

        if (lfAchievementUser != null) {
            return lfAchievementUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementUserException(msg.toString());
    }

    /**
     * Returns the last l f achievement user in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser fetchByUserId_Last(Integer userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<LFAchievementUser> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f achievement users before and after the current l f achievement user in the ordered set where userId = &#63;.
     *
     * @param id the primary key of the current l f achievement user
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser[] findByUserId_PrevAndNext(long id,
        Integer userId, OrderByComparator orderByComparator)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAchievementUser[] array = new LFAchievementUserImpl[3];

            array[0] = getByUserId_PrevAndNext(session, lfAchievementUser,
                    userId, orderByComparator, true);

            array[1] = lfAchievementUser;

            array[2] = getByUserId_PrevAndNext(session, lfAchievementUser,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAchievementUser getByUserId_PrevAndNext(Session session,
        LFAchievementUser lfAchievementUser, Integer userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACHIEVEMENTUSER_WHERE);

        if (userId == null) {
            query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERID_USERID_2);
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
            query.append(LFAchievementUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (userId != null) {
            qPos.add(userId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAchievementUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAchievementUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f achievement users where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(Integer userId) throws SystemException {
        for (LFAchievementUser lfAchievementUser : findByUserId(userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAchievementUser);
        }
    }

    /**
     * Returns the number of l f achievement users where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(Integer userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACHIEVEMENTUSER_WHERE);

            if (userId == null) {
                query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_USERID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userId != null) {
                    qPos.add(userId.intValue());
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
     * Returns all the l f achievement users where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @return the matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findByAchievementId(Integer achievementId)
        throws SystemException {
        return findByAchievementId(achievementId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement users where achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f achievement users
     * @param end the upper bound of the range of l f achievement users (not inclusive)
     * @return the range of matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findByAchievementId(Integer achievementId,
        int start, int end) throws SystemException {
        return findByAchievementId(achievementId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement users where achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f achievement users
     * @param end the upper bound of the range of l f achievement users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findByAchievementId(Integer achievementId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID;
            finderArgs = new Object[] { achievementId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACHIEVEMENTID;
            finderArgs = new Object[] {
                    achievementId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFAchievementUser> list = (List<LFAchievementUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAchievementUser lfAchievementUser : list) {
                if (!Validator.equals(achievementId,
                            lfAchievementUser.getAchievementId())) {
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

            query.append(_SQL_SELECT_LFACHIEVEMENTUSER_WHERE);

            if (achievementId == null) {
                query.append(_FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAchievementUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (achievementId != null) {
                    qPos.add(achievementId.intValue());
                }

                if (!pagination) {
                    list = (List<LFAchievementUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementUser>(list);
                } else {
                    list = (List<LFAchievementUser>) QueryUtil.list(q,
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
     * Returns the first l f achievement user in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser findByAchievementId_First(Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = fetchByAchievementId_First(achievementId,
                orderByComparator);

        if (lfAchievementUser != null) {
            return lfAchievementUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementUserException(msg.toString());
    }

    /**
     * Returns the first l f achievement user in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser fetchByAchievementId_First(Integer achievementId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAchievementUser> list = findByAchievementId(achievementId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f achievement user in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser findByAchievementId_Last(Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = fetchByAchievementId_Last(achievementId,
                orderByComparator);

        if (lfAchievementUser != null) {
            return lfAchievementUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementUserException(msg.toString());
    }

    /**
     * Returns the last l f achievement user in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser fetchByAchievementId_Last(Integer achievementId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAchievementId(achievementId);

        if (count == 0) {
            return null;
        }

        List<LFAchievementUser> list = findByAchievementId(achievementId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f achievement users before and after the current l f achievement user in the ordered set where achievementId = &#63;.
     *
     * @param id the primary key of the current l f achievement user
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser[] findByAchievementId_PrevAndNext(long id,
        Integer achievementId, OrderByComparator orderByComparator)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAchievementUser[] array = new LFAchievementUserImpl[3];

            array[0] = getByAchievementId_PrevAndNext(session,
                    lfAchievementUser, achievementId, orderByComparator, true);

            array[1] = lfAchievementUser;

            array[2] = getByAchievementId_PrevAndNext(session,
                    lfAchievementUser, achievementId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAchievementUser getByAchievementId_PrevAndNext(
        Session session, LFAchievementUser lfAchievementUser,
        Integer achievementId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACHIEVEMENTUSER_WHERE);

        if (achievementId == null) {
            query.append(_FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_2);
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
            query.append(LFAchievementUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (achievementId != null) {
            qPos.add(achievementId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAchievementUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAchievementUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f achievement users where achievementId = &#63; from the database.
     *
     * @param achievementId the achievement ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAchievementId(Integer achievementId)
        throws SystemException {
        for (LFAchievementUser lfAchievementUser : findByAchievementId(
                achievementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAchievementUser);
        }
    }

    /**
     * Returns the number of l f achievement users where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @return the number of matching l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAchievementId(Integer achievementId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACHIEVEMENTID;

        Object[] finderArgs = new Object[] { achievementId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFACHIEVEMENTUSER_WHERE);

            if (achievementId == null) {
                query.append(_FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (achievementId != null) {
                    qPos.add(achievementId.intValue());
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
     * Caches the l f achievement user in the entity cache if it is enabled.
     *
     * @param lfAchievementUser the l f achievement user
     */
    @Override
    public void cacheResult(LFAchievementUser lfAchievementUser) {
        EntityCacheUtil.putResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserImpl.class, lfAchievementUser.getPrimaryKey(),
            lfAchievementUser);

        lfAchievementUser.resetOriginalValues();
    }

    /**
     * Caches the l f achievement users in the entity cache if it is enabled.
     *
     * @param lfAchievementUsers the l f achievement users
     */
    @Override
    public void cacheResult(List<LFAchievementUser> lfAchievementUsers) {
        for (LFAchievementUser lfAchievementUser : lfAchievementUsers) {
            if (EntityCacheUtil.getResult(
                        LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFAchievementUserImpl.class,
                        lfAchievementUser.getPrimaryKey()) == null) {
                cacheResult(lfAchievementUser);
            } else {
                lfAchievementUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f achievement users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFAchievementUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFAchievementUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f achievement user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFAchievementUser lfAchievementUser) {
        EntityCacheUtil.removeResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserImpl.class, lfAchievementUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFAchievementUser> lfAchievementUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFAchievementUser lfAchievementUser : lfAchievementUsers) {
            EntityCacheUtil.removeResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
                LFAchievementUserImpl.class, lfAchievementUser.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f achievement user with the primary key. Does not add the l f achievement user to the database.
     *
     * @param id the primary key for the new l f achievement user
     * @return the new l f achievement user
     */
    @Override
    public LFAchievementUser create(long id) {
        LFAchievementUser lfAchievementUser = new LFAchievementUserImpl();

        lfAchievementUser.setNew(true);
        lfAchievementUser.setPrimaryKey(id);

        return lfAchievementUser;
    }

    /**
     * Removes the l f achievement user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f achievement user
     * @return the l f achievement user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser remove(long id)
        throws NoSuchLFAchievementUserException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f achievement user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f achievement user
     * @return the l f achievement user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser remove(Serializable primaryKey)
        throws NoSuchLFAchievementUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFAchievementUser lfAchievementUser = (LFAchievementUser) session.get(LFAchievementUserImpl.class,
                    primaryKey);

            if (lfAchievementUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFAchievementUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfAchievementUser);
        } catch (NoSuchLFAchievementUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFAchievementUser removeImpl(LFAchievementUser lfAchievementUser)
        throws SystemException {
        lfAchievementUser = toUnwrappedModel(lfAchievementUser);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfAchievementUser)) {
                lfAchievementUser = (LFAchievementUser) session.get(LFAchievementUserImpl.class,
                        lfAchievementUser.getPrimaryKeyObj());
            }

            if (lfAchievementUser != null) {
                session.delete(lfAchievementUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfAchievementUser != null) {
            clearCache(lfAchievementUser);
        }

        return lfAchievementUser;
    }

    @Override
    public LFAchievementUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser)
        throws SystemException {
        lfAchievementUser = toUnwrappedModel(lfAchievementUser);

        boolean isNew = lfAchievementUser.isNew();

        LFAchievementUserModelImpl lfAchievementUserModelImpl = (LFAchievementUserModelImpl) lfAchievementUser;

        Session session = null;

        try {
            session = openSession();

            if (lfAchievementUser.isNew()) {
                session.save(lfAchievementUser);

                lfAchievementUser.setNew(false);
            } else {
                session.merge(lfAchievementUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFAchievementUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfAchievementUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAchievementUserModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { lfAchievementUserModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((lfAchievementUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAchievementUserModelImpl.getOriginalAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACHIEVEMENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID,
                    args);

                args = new Object[] {
                        lfAchievementUserModelImpl.getAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACHIEVEMENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementUserImpl.class, lfAchievementUser.getPrimaryKey(),
            lfAchievementUser);

        return lfAchievementUser;
    }

    protected LFAchievementUser toUnwrappedModel(
        LFAchievementUser lfAchievementUser) {
        if (lfAchievementUser instanceof LFAchievementUserImpl) {
            return lfAchievementUser;
        }

        LFAchievementUserImpl lfAchievementUserImpl = new LFAchievementUserImpl();

        lfAchievementUserImpl.setNew(lfAchievementUser.isNew());
        lfAchievementUserImpl.setPrimaryKey(lfAchievementUser.getPrimaryKey());

        lfAchievementUserImpl.setId(lfAchievementUser.getId());
        lfAchievementUserImpl.setUserId(lfAchievementUser.getUserId());
        lfAchievementUserImpl.setAchievementId(lfAchievementUser.getAchievementId());

        return lfAchievementUserImpl;
    }

    /**
     * Returns the l f achievement user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f achievement user
     * @return the l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFAchievementUserException, SystemException {
        LFAchievementUser lfAchievementUser = fetchByPrimaryKey(primaryKey);

        if (lfAchievementUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFAchievementUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfAchievementUser;
    }

    /**
     * Returns the l f achievement user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException} if it could not be found.
     *
     * @param id the primary key of the l f achievement user
     * @return the l f achievement user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser findByPrimaryKey(long id)
        throws NoSuchLFAchievementUserException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f achievement user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f achievement user
     * @return the l f achievement user, or <code>null</code> if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFAchievementUser lfAchievementUser = (LFAchievementUser) EntityCacheUtil.getResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
                LFAchievementUserImpl.class, primaryKey);

        if (lfAchievementUser == _nullLFAchievementUser) {
            return null;
        }

        if (lfAchievementUser == null) {
            Session session = null;

            try {
                session = openSession();

                lfAchievementUser = (LFAchievementUser) session.get(LFAchievementUserImpl.class,
                        primaryKey);

                if (lfAchievementUser != null) {
                    cacheResult(lfAchievementUser);
                } else {
                    EntityCacheUtil.putResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFAchievementUserImpl.class, primaryKey,
                        _nullLFAchievementUser);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFAchievementUserModelImpl.ENTITY_CACHE_ENABLED,
                    LFAchievementUserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfAchievementUser;
    }

    /**
     * Returns the l f achievement user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f achievement user
     * @return the l f achievement user, or <code>null</code> if a l f achievement user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementUser fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f achievement users.
     *
     * @return the l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f achievement users
     * @param end the upper bound of the range of l f achievement users (not inclusive)
     * @return the range of l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f achievement users
     * @param end the upper bound of the range of l f achievement users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f achievement users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementUser> findAll(int start, int end,
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

        List<LFAchievementUser> list = (List<LFAchievementUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACHIEVEMENTUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACHIEVEMENTUSER;

                if (pagination) {
                    sql = sql.concat(LFAchievementUserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFAchievementUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementUser>(list);
                } else {
                    list = (List<LFAchievementUser>) QueryUtil.list(q,
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
     * Removes all the l f achievement users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFAchievementUser lfAchievementUser : findAll()) {
            remove(lfAchievementUser);
        }
    }

    /**
     * Returns the number of l f achievement users.
     *
     * @return the number of l f achievement users
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

                Query q = session.createQuery(_SQL_COUNT_LFACHIEVEMENTUSER);

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
     * Initializes the l f achievement user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFAchievementUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFAchievementUser>> listenersList = new ArrayList<ModelListener<LFAchievementUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFAchievementUser>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFAchievementUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

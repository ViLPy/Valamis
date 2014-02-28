package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFUserException;
import com.arcusys.learn.persistence.liferay.model.LFUser;
import com.arcusys.learn.persistence.liferay.model.impl.LFUserImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFUserPersistence;

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
 * The persistence implementation for the l f user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFUserPersistence
 * @see LFUserUtil
 * @generated
 */
public class LFUserPersistenceImpl extends BasePersistenceImpl<LFUser>
    implements LFUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFUserUtil} to access the l f user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
            new String[] { Integer.class.getName() },
            LFUserModelImpl.ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_USERID_ID_NULL = "lfUser.id IS NULL";
    private static final String _FINDER_COLUMN_USERID_ID_2 = "lfUser.id = ?";
    private static final String _FINDER_COLUMN_USERID_ID_NULL_2 = "lfUser.id IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION =
        new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdCollection",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION =
        new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, LFUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUserIdCollection", new String[] { Integer.class.getName() },
            LFUserModelImpl.ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDCOLLECTION = new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserIdCollection", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION =
        new FinderPath(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserIdCollection",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_NULL = "lfUser.id IS NULL";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_2 = "lfUser.id = ?";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2 = "lfUser.id IS NULL ";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_USERIDCOLLECTION_ID_2) + ")";
    private static final String _FINDER_COLUMN_USERIDCOLLECTION_ID_5_NULL = "(" +
        _removeConjunction(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2) + ")";
    private static final String _SQL_SELECT_LFUSER = "SELECT lfUser FROM LFUser lfUser";
    private static final String _SQL_SELECT_LFUSER_WHERE = "SELECT lfUser FROM LFUser lfUser WHERE ";
    private static final String _SQL_COUNT_LFUSER = "SELECT COUNT(lfUser) FROM LFUser lfUser";
    private static final String _SQL_COUNT_LFUSER_WHERE = "SELECT COUNT(lfUser) FROM LFUser lfUser WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFUserPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFUser _nullLFUser = new LFUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFUser> toCacheModel() {
                return _nullLFUserCacheModel;
            }
        };

    private static CacheModel<LFUser> _nullLFUserCacheModel = new CacheModel<LFUser>() {
            @Override
            public LFUser toEntityModel() {
                return _nullLFUser;
            }
        };

    public LFUserPersistenceImpl() {
        setModelClass(LFUser.class);
    }

    /**
     * Returns the l f user where id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFUserException} if it could not be found.
     *
     * @param id the ID
     * @return the matching l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser findByUserId(Integer id)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByUserId(id);

        if (lfUser == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("id=");
            msg.append(id);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFUserException(msg.toString());
        }

        return lfUser;
    }

    /**
     * Returns the l f user where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param id the ID
     * @return the matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByUserId(Integer id) throws SystemException {
        return fetchByUserId(id, true);
    }

    /**
     * Returns the l f user where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param id the ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByUserId(Integer id, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { id };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs, this);
        }

        if (result instanceof LFUser) {
            LFUser lfUser = (LFUser) result;

            if (!Validator.equals(id, lfUser.getId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERID_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_ID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
                }

                List<LFUser> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFUserPersistenceImpl.fetchByUserId(Integer, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFUser lfUser = list.get(0);

                    result = lfUser;

                    cacheResult(lfUser);

                    if ((lfUser.getId() != id)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                            finderArgs, lfUser);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFUser) result;
        }
    }

    /**
     * Removes the l f user where id = &#63; from the database.
     *
     * @param id the ID
     * @return the l f user that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser removeByUserId(Integer id)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = findByUserId(id);

        return remove(lfUser);
    }

    /**
     * Returns the number of l f users where id = &#63;.
     *
     * @param id the ID
     * @return the number of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(Integer id) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { id };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERID_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_ID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
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
     * Returns all the l f users where id = &#63;.
     *
     * @param id the ID
     * @return the matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findByUserIdCollection(Integer id)
        throws SystemException {
        return findByUserIdCollection(id, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f users where id = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param id the ID
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @return the range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findByUserIdCollection(Integer id, int start, int end)
        throws SystemException {
        return findByUserIdCollection(id, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f users where id = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param id the ID
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findByUserIdCollection(Integer id, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION;
            finderArgs = new Object[] { id };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION;
            finderArgs = new Object[] { id, start, end, orderByComparator };
        }

        List<LFUser> list = (List<LFUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFUser lfUser : list) {
                if (!Validator.equals(id, lfUser.getId())) {
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

            query.append(_SQL_SELECT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
                }

                if (!pagination) {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFUser>(list);
                } else {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser findByUserIdCollection_First(Integer id,
        OrderByComparator orderByComparator)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByUserIdCollection_First(id, orderByComparator);

        if (lfUser != null) {
            return lfUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("id=");
        msg.append(id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFUserException(msg.toString());
    }

    /**
     * Returns the first l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByUserIdCollection_First(Integer id,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFUser> list = findByUserIdCollection(id, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser findByUserIdCollection_Last(Integer id,
        OrderByComparator orderByComparator)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByUserIdCollection_Last(id, orderByComparator);

        if (lfUser != null) {
            return lfUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("id=");
        msg.append(id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFUserException(msg.toString());
    }

    /**
     * Returns the last l f user in the ordered set where id = &#63;.
     *
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f user, or <code>null</code> if a matching l f user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByUserIdCollection_Last(Integer id,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserIdCollection(id);

        if (count == 0) {
            return null;
        }

        List<LFUser> list = findByUserIdCollection(id, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f users before and after the current l f user in the ordered set where id = &#63;.
     *
     * @param lfid the primary key of the current l f user
     * @param id the ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser[] findByUserIdCollection_PrevAndNext(long lfid, Integer id,
        OrderByComparator orderByComparator)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = findByPrimaryKey(lfid);

        Session session = null;

        try {
            session = openSession();

            LFUser[] array = new LFUserImpl[3];

            array[0] = getByUserIdCollection_PrevAndNext(session, lfUser, id,
                    orderByComparator, true);

            array[1] = lfUser;

            array[2] = getByUserIdCollection_PrevAndNext(session, lfUser, id,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFUser getByUserIdCollection_PrevAndNext(Session session,
        LFUser lfUser, Integer id, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFUSER_WHERE);

        if (id == null) {
            query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_2);
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
            query.append(LFUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (id != null) {
            qPos.add(id.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the l f users where id = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param ids the IDs
     * @return the matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findByUserIdCollection(Integer[] ids)
        throws SystemException {
        return findByUserIdCollection(ids, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f users where id = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param ids the IDs
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @return the range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findByUserIdCollection(Integer[] ids, int start, int end)
        throws SystemException {
        return findByUserIdCollection(ids, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f users where id = any &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param ids the IDs
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findByUserIdCollection(Integer[] ids, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        if ((ids != null) && (ids.length == 1)) {
            return findByUserIdCollection(ids[0], start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] { StringUtil.merge(ids) };
        } else {
            finderArgs = new Object[] {
                    StringUtil.merge(ids),
                    
                    start, end, orderByComparator
                };
        }

        List<LFUser> list = (List<LFUser>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFUser lfUser : list) {
                if (!ArrayUtil.contains(ids, lfUser.getId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_LFUSER_WHERE);

            boolean conjunctionable = false;

            if ((ids != null) && (ids.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == null) {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_5);
                    }

                    if ((i + 1) < ids.length) {
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
                query.append(LFUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (ids != null) {
                    for (Integer id : ids) {
                        if (id != null) {
                            qPos.add(id);
                        }
                    }
                }

                if (!pagination) {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFUser>(list);
                } else {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDCOLLECTION,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the l f users where id = &#63; from the database.
     *
     * @param id the ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserIdCollection(Integer id) throws SystemException {
        for (LFUser lfUser : findByUserIdCollection(id, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfUser);
        }
    }

    /**
     * Returns the number of l f users where id = &#63;.
     *
     * @param id the ID
     * @return the number of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserIdCollection(Integer id) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDCOLLECTION;

        Object[] finderArgs = new Object[] { id };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFUSER_WHERE);

            if (id == null) {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (id != null) {
                    qPos.add(id.intValue());
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
     * Returns the number of l f users where id = any &#63;.
     *
     * @param ids the IDs
     * @return the number of matching l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserIdCollection(Integer[] ids) throws SystemException {
        Object[] finderArgs = new Object[] { StringUtil.merge(ids) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_LFUSER_WHERE);

            boolean conjunctionable = false;

            if ((ids != null) && (ids.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < ids.length; i++) {
                    if (ids[i] == null) {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_NULL);
                    } else {
                        query.append(_FINDER_COLUMN_USERIDCOLLECTION_ID_5);
                    }

                    if ((i + 1) < ids.length) {
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

                if (ids != null) {
                    for (Integer id : ids) {
                        if (id != null) {
                            qPos.add(id);
                        }
                    }
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERIDCOLLECTION,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the l f user in the entity cache if it is enabled.
     *
     * @param lfUser the l f user
     */
    @Override
    public void cacheResult(LFUser lfUser) {
        EntityCacheUtil.putResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserImpl.class, lfUser.getPrimaryKey(), lfUser);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
            new Object[] { lfUser.getId() }, lfUser);

        lfUser.resetOriginalValues();
    }

    /**
     * Caches the l f users in the entity cache if it is enabled.
     *
     * @param lfUsers the l f users
     */
    @Override
    public void cacheResult(List<LFUser> lfUsers) {
        for (LFUser lfUser : lfUsers) {
            if (EntityCacheUtil.getResult(
                        LFUserModelImpl.ENTITY_CACHE_ENABLED, LFUserImpl.class,
                        lfUser.getPrimaryKey()) == null) {
                cacheResult(lfUser);
            } else {
                lfUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFUser lfUser) {
        EntityCacheUtil.removeResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserImpl.class, lfUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfUser);
    }

    @Override
    public void clearCache(List<LFUser> lfUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFUser lfUser : lfUsers) {
            EntityCacheUtil.removeResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                LFUserImpl.class, lfUser.getPrimaryKey());

            clearUniqueFindersCache(lfUser);
        }
    }

    protected void cacheUniqueFindersCache(LFUser lfUser) {
        if (lfUser.isNew()) {
            Object[] args = new Object[] { lfUser.getId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args, lfUser);
        } else {
            LFUserModelImpl lfUserModelImpl = (LFUserModelImpl) lfUser;

            if ((lfUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfUser.getId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
                    lfUser);
            }
        }
    }

    protected void clearUniqueFindersCache(LFUser lfUser) {
        LFUserModelImpl lfUserModelImpl = (LFUserModelImpl) lfUser;

        Object[] args = new Object[] { lfUser.getId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

        if ((lfUserModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
            args = new Object[] { lfUserModelImpl.getOriginalId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
        }
    }

    /**
     * Creates a new l f user with the primary key. Does not add the l f user to the database.
     *
     * @param lfid the primary key for the new l f user
     * @return the new l f user
     */
    @Override
    public LFUser create(long lfid) {
        LFUser lfUser = new LFUserImpl();

        lfUser.setNew(true);
        lfUser.setPrimaryKey(lfid);

        return lfUser;
    }

    /**
     * Removes the l f user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfid the primary key of the l f user
     * @return the l f user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser remove(long lfid)
        throws NoSuchLFUserException, SystemException {
        return remove((Serializable) lfid);
    }

    /**
     * Removes the l f user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f user
     * @return the l f user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser remove(Serializable primaryKey)
        throws NoSuchLFUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFUser lfUser = (LFUser) session.get(LFUserImpl.class, primaryKey);

            if (lfUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfUser);
        } catch (NoSuchLFUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFUser removeImpl(LFUser lfUser) throws SystemException {
        lfUser = toUnwrappedModel(lfUser);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfUser)) {
                lfUser = (LFUser) session.get(LFUserImpl.class,
                        lfUser.getPrimaryKeyObj());
            }

            if (lfUser != null) {
                session.delete(lfUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfUser != null) {
            clearCache(lfUser);
        }

        return lfUser;
    }

    @Override
    public LFUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser)
        throws SystemException {
        lfUser = toUnwrappedModel(lfUser);

        boolean isNew = lfUser.isNew();

        LFUserModelImpl lfUserModelImpl = (LFUserModelImpl) lfUser;

        Session session = null;

        try {
            session = openSession();

            if (lfUser.isNew()) {
                session.save(lfUser);

                lfUser.setNew(false);
            } else {
                session.merge(lfUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { lfUserModelImpl.getOriginalId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION,
                    args);

                args = new Object[] { lfUserModelImpl.getId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDCOLLECTION,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDCOLLECTION,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
            LFUserImpl.class, lfUser.getPrimaryKey(), lfUser);

        clearUniqueFindersCache(lfUser);
        cacheUniqueFindersCache(lfUser);

        return lfUser;
    }

    protected LFUser toUnwrappedModel(LFUser lfUser) {
        if (lfUser instanceof LFUserImpl) {
            return lfUser;
        }

        LFUserImpl lfUserImpl = new LFUserImpl();

        lfUserImpl.setNew(lfUser.isNew());
        lfUserImpl.setPrimaryKey(lfUser.getPrimaryKey());

        lfUserImpl.setLfid(lfUser.getLfid());
        lfUserImpl.setId(lfUser.getId());
        lfUserImpl.setName(lfUser.getName());
        lfUserImpl.setPreferredAudioLevel(lfUser.getPreferredAudioLevel());
        lfUserImpl.setPreferredLanguage(lfUser.getPreferredLanguage());
        lfUserImpl.setPreferredDeliverySpeed(lfUser.getPreferredDeliverySpeed());
        lfUserImpl.setPreferredAudioCaptioning(lfUser.getPreferredAudioCaptioning());

        return lfUserImpl;
    }

    /**
     * Returns the l f user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f user
     * @return the l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFUserException, SystemException {
        LFUser lfUser = fetchByPrimaryKey(primaryKey);

        if (lfUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfUser;
    }

    /**
     * Returns the l f user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFUserException} if it could not be found.
     *
     * @param lfid the primary key of the l f user
     * @return the l f user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser findByPrimaryKey(long lfid)
        throws NoSuchLFUserException, SystemException {
        return findByPrimaryKey((Serializable) lfid);
    }

    /**
     * Returns the l f user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f user
     * @return the l f user, or <code>null</code> if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFUser lfUser = (LFUser) EntityCacheUtil.getResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                LFUserImpl.class, primaryKey);

        if (lfUser == _nullLFUser) {
            return null;
        }

        if (lfUser == null) {
            Session session = null;

            try {
                session = openSession();

                lfUser = (LFUser) session.get(LFUserImpl.class, primaryKey);

                if (lfUser != null) {
                    cacheResult(lfUser);
                } else {
                    EntityCacheUtil.putResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFUserImpl.class, primaryKey, _nullLFUser);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFUserModelImpl.ENTITY_CACHE_ENABLED,
                    LFUserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfUser;
    }

    /**
     * Returns the l f user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfid the primary key of the l f user
     * @return the l f user, or <code>null</code> if a l f user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFUser fetchByPrimaryKey(long lfid) throws SystemException {
        return fetchByPrimaryKey((Serializable) lfid);
    }

    /**
     * Returns all the l f users.
     *
     * @return the l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @return the range of l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f users
     * @param end the upper bound of the range of l f users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFUser> findAll(int start, int end,
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

        List<LFUser> list = (List<LFUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFUSER;

                if (pagination) {
                    sql = sql.concat(LFUserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFUser>(list);
                } else {
                    list = (List<LFUser>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFUser lfUser : findAll()) {
            remove(lfUser);
        }
    }

    /**
     * Returns the number of l f users.
     *
     * @return the number of l f users
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

                Query q = session.createQuery(_SQL_COUNT_LFUSER);

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
     * Initializes the l f user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFUser>> listenersList = new ArrayList<ModelListener<LFUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFUser>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFUserImpl.class.getName());
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

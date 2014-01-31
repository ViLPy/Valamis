package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException;
import com.arcusys.learn.persistence.liferay.model.LFRequiredActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFRequiredActivityPersistence;

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
 * The persistence implementation for the l f required activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRequiredActivityPersistence
 * @see LFRequiredActivityUtil
 * @generated
 */
public class LFRequiredActivityPersistenceImpl extends BasePersistenceImpl<LFRequiredActivity>
    implements LFRequiredActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFRequiredActivityUtil} to access the l f required activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFRequiredActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityModelImpl.FINDER_CACHE_ENABLED,
            LFRequiredActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityModelImpl.FINDER_CACHE_ENABLED,
            LFRequiredActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACHIEVEMENTID =
        new FinderPath(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityModelImpl.FINDER_CACHE_ENABLED,
            LFRequiredActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAchievementId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID =
        new FinderPath(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityModelImpl.FINDER_CACHE_ENABLED,
            LFRequiredActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAchievementId",
            new String[] { Integer.class.getName() },
            LFRequiredActivityModelImpl.ACHIEVEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACHIEVEMENTID = new FinderPath(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAchievementId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL = "lfRequiredActivity.achievementId IS NULL";
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_2 = "lfRequiredActivity.achievementId = ?";
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL_2 =
        "lfRequiredActivity.achievementId IS NULL ";
    private static final String _SQL_SELECT_LFREQUIREDACTIVITY = "SELECT lfRequiredActivity FROM LFRequiredActivity lfRequiredActivity";
    private static final String _SQL_SELECT_LFREQUIREDACTIVITY_WHERE = "SELECT lfRequiredActivity FROM LFRequiredActivity lfRequiredActivity WHERE ";
    private static final String _SQL_COUNT_LFREQUIREDACTIVITY = "SELECT COUNT(lfRequiredActivity) FROM LFRequiredActivity lfRequiredActivity";
    private static final String _SQL_COUNT_LFREQUIREDACTIVITY_WHERE = "SELECT COUNT(lfRequiredActivity) FROM LFRequiredActivity lfRequiredActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfRequiredActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFRequiredActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFRequiredActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFRequiredActivityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFRequiredActivity _nullLFRequiredActivity = new LFRequiredActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFRequiredActivity> toCacheModel() {
                return _nullLFRequiredActivityCacheModel;
            }
        };

    private static CacheModel<LFRequiredActivity> _nullLFRequiredActivityCacheModel =
        new CacheModel<LFRequiredActivity>() {
            @Override
            public LFRequiredActivity toEntityModel() {
                return _nullLFRequiredActivity;
            }
        };

    public LFRequiredActivityPersistenceImpl() {
        setModelClass(LFRequiredActivity.class);
    }

    /**
     * Returns all the l f required activities where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @return the matching l f required activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRequiredActivity> findByAchievementId(Integer achievementId)
        throws SystemException {
        return findByAchievementId(achievementId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f required activities where achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f required activities
     * @param end the upper bound of the range of l f required activities (not inclusive)
     * @return the range of matching l f required activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRequiredActivity> findByAchievementId(Integer achievementId,
        int start, int end) throws SystemException {
        return findByAchievementId(achievementId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f required activities where achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f required activities
     * @param end the upper bound of the range of l f required activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f required activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRequiredActivity> findByAchievementId(Integer achievementId,
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

        List<LFRequiredActivity> list = (List<LFRequiredActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFRequiredActivity lfRequiredActivity : list) {
                if (!Validator.equals(achievementId,
                            lfRequiredActivity.getAchievementId())) {
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

            query.append(_SQL_SELECT_LFREQUIREDACTIVITY_WHERE);

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
                query.append(LFRequiredActivityModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFRequiredActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRequiredActivity>(list);
                } else {
                    list = (List<LFRequiredActivity>) QueryUtil.list(q,
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
     * Returns the first l f required activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f required activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a matching l f required activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity findByAchievementId_First(Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFRequiredActivityException, SystemException {
        LFRequiredActivity lfRequiredActivity = fetchByAchievementId_First(achievementId,
                orderByComparator);

        if (lfRequiredActivity != null) {
            return lfRequiredActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRequiredActivityException(msg.toString());
    }

    /**
     * Returns the first l f required activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f required activity, or <code>null</code> if a matching l f required activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity fetchByAchievementId_First(
        Integer achievementId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFRequiredActivity> list = findByAchievementId(achievementId, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f required activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f required activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a matching l f required activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity findByAchievementId_Last(Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFRequiredActivityException, SystemException {
        LFRequiredActivity lfRequiredActivity = fetchByAchievementId_Last(achievementId,
                orderByComparator);

        if (lfRequiredActivity != null) {
            return lfRequiredActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFRequiredActivityException(msg.toString());
    }

    /**
     * Returns the last l f required activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f required activity, or <code>null</code> if a matching l f required activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity fetchByAchievementId_Last(Integer achievementId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAchievementId(achievementId);

        if (count == 0) {
            return null;
        }

        List<LFRequiredActivity> list = findByAchievementId(achievementId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f required activities before and after the current l f required activity in the ordered set where achievementId = &#63;.
     *
     * @param id the primary key of the current l f required activity
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f required activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity[] findByAchievementId_PrevAndNext(long id,
        Integer achievementId, OrderByComparator orderByComparator)
        throws NoSuchLFRequiredActivityException, SystemException {
        LFRequiredActivity lfRequiredActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFRequiredActivity[] array = new LFRequiredActivityImpl[3];

            array[0] = getByAchievementId_PrevAndNext(session,
                    lfRequiredActivity, achievementId, orderByComparator, true);

            array[1] = lfRequiredActivity;

            array[2] = getByAchievementId_PrevAndNext(session,
                    lfRequiredActivity, achievementId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFRequiredActivity getByAchievementId_PrevAndNext(
        Session session, LFRequiredActivity lfRequiredActivity,
        Integer achievementId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFREQUIREDACTIVITY_WHERE);

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
            query.append(LFRequiredActivityModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfRequiredActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFRequiredActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f required activities where achievementId = &#63; from the database.
     *
     * @param achievementId the achievement ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAchievementId(Integer achievementId)
        throws SystemException {
        for (LFRequiredActivity lfRequiredActivity : findByAchievementId(
                achievementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfRequiredActivity);
        }
    }

    /**
     * Returns the number of l f required activities where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @return the number of matching l f required activities
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

            query.append(_SQL_COUNT_LFREQUIREDACTIVITY_WHERE);

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
     * Caches the l f required activity in the entity cache if it is enabled.
     *
     * @param lfRequiredActivity the l f required activity
     */
    @Override
    public void cacheResult(LFRequiredActivity lfRequiredActivity) {
        EntityCacheUtil.putResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityImpl.class, lfRequiredActivity.getPrimaryKey(),
            lfRequiredActivity);

        lfRequiredActivity.resetOriginalValues();
    }

    /**
     * Caches the l f required activities in the entity cache if it is enabled.
     *
     * @param lfRequiredActivities the l f required activities
     */
    @Override
    public void cacheResult(List<LFRequiredActivity> lfRequiredActivities) {
        for (LFRequiredActivity lfRequiredActivity : lfRequiredActivities) {
            if (EntityCacheUtil.getResult(
                        LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFRequiredActivityImpl.class,
                        lfRequiredActivity.getPrimaryKey()) == null) {
                cacheResult(lfRequiredActivity);
            } else {
                lfRequiredActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f required activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFRequiredActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFRequiredActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f required activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFRequiredActivity lfRequiredActivity) {
        EntityCacheUtil.removeResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityImpl.class, lfRequiredActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFRequiredActivity> lfRequiredActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFRequiredActivity lfRequiredActivity : lfRequiredActivities) {
            EntityCacheUtil.removeResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFRequiredActivityImpl.class, lfRequiredActivity.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f required activity with the primary key. Does not add the l f required activity to the database.
     *
     * @param id the primary key for the new l f required activity
     * @return the new l f required activity
     */
    @Override
    public LFRequiredActivity create(long id) {
        LFRequiredActivity lfRequiredActivity = new LFRequiredActivityImpl();

        lfRequiredActivity.setNew(true);
        lfRequiredActivity.setPrimaryKey(id);

        return lfRequiredActivity;
    }

    /**
     * Removes the l f required activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f required activity
     * @return the l f required activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity remove(long id)
        throws NoSuchLFRequiredActivityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f required activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f required activity
     * @return the l f required activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity remove(Serializable primaryKey)
        throws NoSuchLFRequiredActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFRequiredActivity lfRequiredActivity = (LFRequiredActivity) session.get(LFRequiredActivityImpl.class,
                    primaryKey);

            if (lfRequiredActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFRequiredActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfRequiredActivity);
        } catch (NoSuchLFRequiredActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFRequiredActivity removeImpl(
        LFRequiredActivity lfRequiredActivity) throws SystemException {
        lfRequiredActivity = toUnwrappedModel(lfRequiredActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfRequiredActivity)) {
                lfRequiredActivity = (LFRequiredActivity) session.get(LFRequiredActivityImpl.class,
                        lfRequiredActivity.getPrimaryKeyObj());
            }

            if (lfRequiredActivity != null) {
                session.delete(lfRequiredActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfRequiredActivity != null) {
            clearCache(lfRequiredActivity);
        }

        return lfRequiredActivity;
    }

    @Override
    public LFRequiredActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRequiredActivity lfRequiredActivity)
        throws SystemException {
        lfRequiredActivity = toUnwrappedModel(lfRequiredActivity);

        boolean isNew = lfRequiredActivity.isNew();

        LFRequiredActivityModelImpl lfRequiredActivityModelImpl = (LFRequiredActivityModelImpl) lfRequiredActivity;

        Session session = null;

        try {
            session = openSession();

            if (lfRequiredActivity.isNew()) {
                session.save(lfRequiredActivity);

                lfRequiredActivity.setNew(false);
            } else {
                session.merge(lfRequiredActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFRequiredActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfRequiredActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfRequiredActivityModelImpl.getOriginalAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACHIEVEMENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID,
                    args);

                args = new Object[] {
                        lfRequiredActivityModelImpl.getAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACHIEVEMENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFRequiredActivityImpl.class, lfRequiredActivity.getPrimaryKey(),
            lfRequiredActivity);

        return lfRequiredActivity;
    }

    protected LFRequiredActivity toUnwrappedModel(
        LFRequiredActivity lfRequiredActivity) {
        if (lfRequiredActivity instanceof LFRequiredActivityImpl) {
            return lfRequiredActivity;
        }

        LFRequiredActivityImpl lfRequiredActivityImpl = new LFRequiredActivityImpl();

        lfRequiredActivityImpl.setNew(lfRequiredActivity.isNew());
        lfRequiredActivityImpl.setPrimaryKey(lfRequiredActivity.getPrimaryKey());

        lfRequiredActivityImpl.setId(lfRequiredActivity.getId());
        lfRequiredActivityImpl.setAchievementId(lfRequiredActivity.getAchievementId());
        lfRequiredActivityImpl.setActivityClassName(lfRequiredActivity.getActivityClassName());
        lfRequiredActivityImpl.setNumberActivitiesRequired(lfRequiredActivity.getNumberActivitiesRequired());

        return lfRequiredActivityImpl;
    }

    /**
     * Returns the l f required activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f required activity
     * @return the l f required activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFRequiredActivityException, SystemException {
        LFRequiredActivity lfRequiredActivity = fetchByPrimaryKey(primaryKey);

        if (lfRequiredActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFRequiredActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfRequiredActivity;
    }

    /**
     * Returns the l f required activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException} if it could not be found.
     *
     * @param id the primary key of the l f required activity
     * @return the l f required activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity findByPrimaryKey(long id)
        throws NoSuchLFRequiredActivityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f required activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f required activity
     * @return the l f required activity, or <code>null</code> if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFRequiredActivity lfRequiredActivity = (LFRequiredActivity) EntityCacheUtil.getResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFRequiredActivityImpl.class, primaryKey);

        if (lfRequiredActivity == _nullLFRequiredActivity) {
            return null;
        }

        if (lfRequiredActivity == null) {
            Session session = null;

            try {
                session = openSession();

                lfRequiredActivity = (LFRequiredActivity) session.get(LFRequiredActivityImpl.class,
                        primaryKey);

                if (lfRequiredActivity != null) {
                    cacheResult(lfRequiredActivity);
                } else {
                    EntityCacheUtil.putResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFRequiredActivityImpl.class, primaryKey,
                        _nullLFRequiredActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFRequiredActivityModelImpl.ENTITY_CACHE_ENABLED,
                    LFRequiredActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfRequiredActivity;
    }

    /**
     * Returns the l f required activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f required activity
     * @return the l f required activity, or <code>null</code> if a l f required activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFRequiredActivity fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f required activities.
     *
     * @return the l f required activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRequiredActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f required activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f required activities
     * @param end the upper bound of the range of l f required activities (not inclusive)
     * @return the range of l f required activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRequiredActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f required activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f required activities
     * @param end the upper bound of the range of l f required activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f required activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFRequiredActivity> findAll(int start, int end,
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

        List<LFRequiredActivity> list = (List<LFRequiredActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFREQUIREDACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFREQUIREDACTIVITY;

                if (pagination) {
                    sql = sql.concat(LFRequiredActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFRequiredActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFRequiredActivity>(list);
                } else {
                    list = (List<LFRequiredActivity>) QueryUtil.list(q,
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
     * Removes all the l f required activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFRequiredActivity lfRequiredActivity : findAll()) {
            remove(lfRequiredActivity);
        }
    }

    /**
     * Returns the number of l f required activities.
     *
     * @return the number of l f required activities
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

                Query q = session.createQuery(_SQL_COUNT_LFREQUIREDACTIVITY);

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
     * Initializes the l f required activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFRequiredActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFRequiredActivity>> listenersList = new ArrayList<ModelListener<LFRequiredActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFRequiredActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFRequiredActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

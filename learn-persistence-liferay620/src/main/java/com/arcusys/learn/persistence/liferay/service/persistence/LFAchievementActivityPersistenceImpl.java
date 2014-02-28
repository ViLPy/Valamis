package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException;
import com.arcusys.learn.persistence.liferay.model.LFAchievementActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAchievementActivityPersistence;

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
 * The persistence implementation for the l f achievement activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementActivityPersistence
 * @see LFAchievementActivityUtil
 * @generated
 */
public class LFAchievementActivityPersistenceImpl extends BasePersistenceImpl<LFAchievementActivity>
    implements LFAchievementActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFAchievementActivityUtil} to access the l f achievement activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFAchievementActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACHIEVEMENTID =
        new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAchievementId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID =
        new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAchievementId",
            new String[] { Integer.class.getName() },
            LFAchievementActivityModelImpl.ACHIEVEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACHIEVEMENTID = new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAchievementId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL = "lfAchievementActivity.achievementId IS NULL";
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_2 = "lfAchievementActivity.achievementId = ?";
    private static final String _FINDER_COLUMN_ACHIEVEMENTID_ACHIEVEMENTID_NULL_2 =
        "lfAchievementActivity.achievementId IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Integer.class.getName() },
            LFAchievementActivityModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_NULL = "lfAchievementActivity.userId IS NULL";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "lfAchievementActivity.userId = ?";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL_2 = "lfAchievementActivity.userId IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID =
        new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAllByAchievementAndUserId",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID =
        new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAllByAchievementAndUserId",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFAchievementActivityModelImpl.USERID_COLUMN_BITMASK |
            LFAchievementActivityModelImpl.ACHIEVEMENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLBYACHIEVEMENTANDUSERID =
        new FinderPath(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAllByAchievementAndUserId",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_NULL =
        "lfAchievementActivity.userId IS NULL";
    private static final String _FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_2 =
        "lfAchievementActivity.userId = ? AND ";
    private static final String _FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_NULL_2 =
        "lfAchievementActivity.userId IS NULL  AND ";
    private static final String _FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_NULL =
        "lfAchievementActivity.achievementId IS NULL";
    private static final String _FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_2 =
        "lfAchievementActivity.achievementId = ?";
    private static final String _FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_NULL_2 =
        "lfAchievementActivity.achievementId IS NULL ";
    private static final String _SQL_SELECT_LFACHIEVEMENTACTIVITY = "SELECT lfAchievementActivity FROM LFAchievementActivity lfAchievementActivity";
    private static final String _SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE = "SELECT lfAchievementActivity FROM LFAchievementActivity lfAchievementActivity WHERE ";
    private static final String _SQL_COUNT_LFACHIEVEMENTACTIVITY = "SELECT COUNT(lfAchievementActivity) FROM LFAchievementActivity lfAchievementActivity";
    private static final String _SQL_COUNT_LFACHIEVEMENTACTIVITY_WHERE = "SELECT COUNT(lfAchievementActivity) FROM LFAchievementActivity lfAchievementActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfAchievementActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFAchievementActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFAchievementActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFAchievementActivityPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFAchievementActivity _nullLFAchievementActivity = new LFAchievementActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFAchievementActivity> toCacheModel() {
                return _nullLFAchievementActivityCacheModel;
            }
        };

    private static CacheModel<LFAchievementActivity> _nullLFAchievementActivityCacheModel =
        new CacheModel<LFAchievementActivity>() {
            @Override
            public LFAchievementActivity toEntityModel() {
                return _nullLFAchievementActivity;
            }
        };

    public LFAchievementActivityPersistenceImpl() {
        setModelClass(LFAchievementActivity.class);
    }

    /**
     * Returns all the l f achievement activities where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @return the matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByAchievementId(
        Integer achievementId) throws SystemException {
        return findByAchievementId(achievementId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement activities where achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @return the range of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByAchievementId(
        Integer achievementId, int start, int end) throws SystemException {
        return findByAchievementId(achievementId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement activities where achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByAchievementId(
        Integer achievementId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
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

        List<LFAchievementActivity> list = (List<LFAchievementActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAchievementActivity lfAchievementActivity : list) {
                if (!Validator.equals(achievementId,
                            lfAchievementActivity.getAchievementId())) {
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

            query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE);

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
                query.append(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementActivity>(list);
                } else {
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
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
     * Returns the first l f achievement activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByAchievementId_First(
        Integer achievementId, OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByAchievementId_First(achievementId,
                orderByComparator);

        if (lfAchievementActivity != null) {
            return lfAchievementActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementActivityException(msg.toString());
    }

    /**
     * Returns the first l f achievement activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByAchievementId_First(
        Integer achievementId, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFAchievementActivity> list = findByAchievementId(achievementId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f achievement activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByAchievementId_Last(
        Integer achievementId, OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByAchievementId_Last(achievementId,
                orderByComparator);

        if (lfAchievementActivity != null) {
            return lfAchievementActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementActivityException(msg.toString());
    }

    /**
     * Returns the last l f achievement activity in the ordered set where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByAchievementId_Last(
        Integer achievementId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByAchievementId(achievementId);

        if (count == 0) {
            return null;
        }

        List<LFAchievementActivity> list = findByAchievementId(achievementId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f achievement activities before and after the current l f achievement activity in the ordered set where achievementId = &#63;.
     *
     * @param id the primary key of the current l f achievement activity
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity[] findByAchievementId_PrevAndNext(long id,
        Integer achievementId, OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAchievementActivity[] array = new LFAchievementActivityImpl[3];

            array[0] = getByAchievementId_PrevAndNext(session,
                    lfAchievementActivity, achievementId, orderByComparator,
                    true);

            array[1] = lfAchievementActivity;

            array[2] = getByAchievementId_PrevAndNext(session,
                    lfAchievementActivity, achievementId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAchievementActivity getByAchievementId_PrevAndNext(
        Session session, LFAchievementActivity lfAchievementActivity,
        Integer achievementId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE);

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
            query.append(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfAchievementActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAchievementActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f achievement activities where achievementId = &#63; from the database.
     *
     * @param achievementId the achievement ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAchievementId(Integer achievementId)
        throws SystemException {
        for (LFAchievementActivity lfAchievementActivity : findByAchievementId(
                achievementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAchievementActivity);
        }
    }

    /**
     * Returns the number of l f achievement activities where achievementId = &#63;.
     *
     * @param achievementId the achievement ID
     * @return the number of matching l f achievement activities
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

            query.append(_SQL_COUNT_LFACHIEVEMENTACTIVITY_WHERE);

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
     * Returns all the l f achievement activities where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByUserId(Integer userId)
        throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement activities where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @return the range of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByUserId(Integer userId, int start,
        int end) throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement activities where userId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByUserId(Integer userId, int start,
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

        List<LFAchievementActivity> list = (List<LFAchievementActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAchievementActivity lfAchievementActivity : list) {
                if (!Validator.equals(userId, lfAchievementActivity.getUserId())) {
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

            query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE);

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
                query.append(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementActivity>(list);
                } else {
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
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
     * Returns the first l f achievement activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByUserId_First(Integer userId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByUserId_First(userId,
                orderByComparator);

        if (lfAchievementActivity != null) {
            return lfAchievementActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementActivityException(msg.toString());
    }

    /**
     * Returns the first l f achievement activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByUserId_First(Integer userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAchievementActivity> list = findByUserId(userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f achievement activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByUserId_Last(Integer userId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByUserId_Last(userId,
                orderByComparator);

        if (lfAchievementActivity != null) {
            return lfAchievementActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementActivityException(msg.toString());
    }

    /**
     * Returns the last l f achievement activity in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByUserId_Last(Integer userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<LFAchievementActivity> list = findByUserId(userId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f achievement activities before and after the current l f achievement activity in the ordered set where userId = &#63;.
     *
     * @param id the primary key of the current l f achievement activity
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity[] findByUserId_PrevAndNext(long id,
        Integer userId, OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAchievementActivity[] array = new LFAchievementActivityImpl[3];

            array[0] = getByUserId_PrevAndNext(session, lfAchievementActivity,
                    userId, orderByComparator, true);

            array[1] = lfAchievementActivity;

            array[2] = getByUserId_PrevAndNext(session, lfAchievementActivity,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAchievementActivity getByUserId_PrevAndNext(Session session,
        LFAchievementActivity lfAchievementActivity, Integer userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE);

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
            query.append(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfAchievementActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAchievementActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f achievement activities where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(Integer userId) throws SystemException {
        for (LFAchievementActivity lfAchievementActivity : findByUserId(
                userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAchievementActivity);
        }
    }

    /**
     * Returns the number of l f achievement activities where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching l f achievement activities
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

            query.append(_SQL_COUNT_LFACHIEVEMENTACTIVITY_WHERE);

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
     * Returns all the l f achievement activities where userId = &#63; and achievementId = &#63;.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @return the matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByAllByAchievementAndUserId(
        Integer userId, Integer achievementId) throws SystemException {
        return findByAllByAchievementAndUserId(userId, achievementId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement activities where userId = &#63; and achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @return the range of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByAllByAchievementAndUserId(
        Integer userId, Integer achievementId, int start, int end)
        throws SystemException {
        return findByAllByAchievementAndUserId(userId, achievementId, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement activities where userId = &#63; and achievementId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findByAllByAchievementAndUserId(
        Integer userId, Integer achievementId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID;
            finderArgs = new Object[] { userId, achievementId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID;
            finderArgs = new Object[] {
                    userId, achievementId,
                    
                    start, end, orderByComparator
                };
        }

        List<LFAchievementActivity> list = (List<LFAchievementActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAchievementActivity lfAchievementActivity : list) {
                if (!Validator.equals(userId, lfAchievementActivity.getUserId()) ||
                        !Validator.equals(achievementId,
                            lfAchievementActivity.getAchievementId())) {
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

            query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE);

            if (userId == null) {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_2);
            }

            if (achievementId == null) {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
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

                if (achievementId != null) {
                    qPos.add(achievementId.intValue());
                }

                if (!pagination) {
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementActivity>(list);
                } else {
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
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
     * Returns the first l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByAllByAchievementAndUserId_First(
        Integer userId, Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByAllByAchievementAndUserId_First(userId,
                achievementId, orderByComparator);

        if (lfAchievementActivity != null) {
            return lfAchievementActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementActivityException(msg.toString());
    }

    /**
     * Returns the first l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByAllByAchievementAndUserId_First(
        Integer userId, Integer achievementId,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAchievementActivity> list = findByAllByAchievementAndUserId(userId,
                achievementId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByAllByAchievementAndUserId_Last(
        Integer userId, Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByAllByAchievementAndUserId_Last(userId,
                achievementId, orderByComparator);

        if (lfAchievementActivity != null) {
            return lfAchievementActivity;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(", achievementId=");
        msg.append(achievementId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAchievementActivityException(msg.toString());
    }

    /**
     * Returns the last l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByAllByAchievementAndUserId_Last(
        Integer userId, Integer achievementId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAllByAchievementAndUserId(userId, achievementId);

        if (count == 0) {
            return null;
        }

        List<LFAchievementActivity> list = findByAllByAchievementAndUserId(userId,
                achievementId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f achievement activities before and after the current l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
     *
     * @param id the primary key of the current l f achievement activity
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity[] findByAllByAchievementAndUserId_PrevAndNext(
        long id, Integer userId, Integer achievementId,
        OrderByComparator orderByComparator)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAchievementActivity[] array = new LFAchievementActivityImpl[3];

            array[0] = getByAllByAchievementAndUserId_PrevAndNext(session,
                    lfAchievementActivity, userId, achievementId,
                    orderByComparator, true);

            array[1] = lfAchievementActivity;

            array[2] = getByAllByAchievementAndUserId_PrevAndNext(session,
                    lfAchievementActivity, userId, achievementId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAchievementActivity getByAllByAchievementAndUserId_PrevAndNext(
        Session session, LFAchievementActivity lfAchievementActivity,
        Integer userId, Integer achievementId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY_WHERE);

        if (userId == null) {
            query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_2);
        }

        if (achievementId == null) {
            query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_2);
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
            query.append(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (userId != null) {
            qPos.add(userId.intValue());
        }

        if (achievementId != null) {
            qPos.add(achievementId.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAchievementActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAchievementActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f achievement activities where userId = &#63; and achievementId = &#63; from the database.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAllByAchievementAndUserId(Integer userId,
        Integer achievementId) throws SystemException {
        for (LFAchievementActivity lfAchievementActivity : findByAllByAchievementAndUserId(
                userId, achievementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(lfAchievementActivity);
        }
    }

    /**
     * Returns the number of l f achievement activities where userId = &#63; and achievementId = &#63;.
     *
     * @param userId the user ID
     * @param achievementId the achievement ID
     * @return the number of matching l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAllByAchievementAndUserId(Integer userId,
        Integer achievementId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLBYACHIEVEMENTANDUSERID;

        Object[] finderArgs = new Object[] { userId, achievementId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFACHIEVEMENTACTIVITY_WHERE);

            if (userId == null) {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_USERID_2);
            }

            if (achievementId == null) {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ALLBYACHIEVEMENTANDUSERID_ACHIEVEMENTID_2);
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
     * Caches the l f achievement activity in the entity cache if it is enabled.
     *
     * @param lfAchievementActivity the l f achievement activity
     */
    @Override
    public void cacheResult(LFAchievementActivity lfAchievementActivity) {
        EntityCacheUtil.putResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            lfAchievementActivity.getPrimaryKey(), lfAchievementActivity);

        lfAchievementActivity.resetOriginalValues();
    }

    /**
     * Caches the l f achievement activities in the entity cache if it is enabled.
     *
     * @param lfAchievementActivities the l f achievement activities
     */
    @Override
    public void cacheResult(List<LFAchievementActivity> lfAchievementActivities) {
        for (LFAchievementActivity lfAchievementActivity : lfAchievementActivities) {
            if (EntityCacheUtil.getResult(
                        LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFAchievementActivityImpl.class,
                        lfAchievementActivity.getPrimaryKey()) == null) {
                cacheResult(lfAchievementActivity);
            } else {
                lfAchievementActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f achievement activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFAchievementActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFAchievementActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f achievement activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFAchievementActivity lfAchievementActivity) {
        EntityCacheUtil.removeResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            lfAchievementActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFAchievementActivity> lfAchievementActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFAchievementActivity lfAchievementActivity : lfAchievementActivities) {
            EntityCacheUtil.removeResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFAchievementActivityImpl.class,
                lfAchievementActivity.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f achievement activity with the primary key. Does not add the l f achievement activity to the database.
     *
     * @param id the primary key for the new l f achievement activity
     * @return the new l f achievement activity
     */
    @Override
    public LFAchievementActivity create(long id) {
        LFAchievementActivity lfAchievementActivity = new LFAchievementActivityImpl();

        lfAchievementActivity.setNew(true);
        lfAchievementActivity.setPrimaryKey(id);

        return lfAchievementActivity;
    }

    /**
     * Removes the l f achievement activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f achievement activity
     * @return the l f achievement activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity remove(long id)
        throws NoSuchLFAchievementActivityException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f achievement activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f achievement activity
     * @return the l f achievement activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity remove(Serializable primaryKey)
        throws NoSuchLFAchievementActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFAchievementActivity lfAchievementActivity = (LFAchievementActivity) session.get(LFAchievementActivityImpl.class,
                    primaryKey);

            if (lfAchievementActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFAchievementActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfAchievementActivity);
        } catch (NoSuchLFAchievementActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFAchievementActivity removeImpl(
        LFAchievementActivity lfAchievementActivity) throws SystemException {
        lfAchievementActivity = toUnwrappedModel(lfAchievementActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfAchievementActivity)) {
                lfAchievementActivity = (LFAchievementActivity) session.get(LFAchievementActivityImpl.class,
                        lfAchievementActivity.getPrimaryKeyObj());
            }

            if (lfAchievementActivity != null) {
                session.delete(lfAchievementActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfAchievementActivity != null) {
            clearCache(lfAchievementActivity);
        }

        return lfAchievementActivity;
    }

    @Override
    public LFAchievementActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievementActivity lfAchievementActivity)
        throws SystemException {
        lfAchievementActivity = toUnwrappedModel(lfAchievementActivity);

        boolean isNew = lfAchievementActivity.isNew();

        LFAchievementActivityModelImpl lfAchievementActivityModelImpl = (LFAchievementActivityModelImpl) lfAchievementActivity;

        Session session = null;

        try {
            session = openSession();

            if (lfAchievementActivity.isNew()) {
                session.save(lfAchievementActivity);

                lfAchievementActivity.setNew(false);
            } else {
                session.merge(lfAchievementActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFAchievementActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfAchievementActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAchievementActivityModelImpl.getOriginalAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACHIEVEMENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID,
                    args);

                args = new Object[] {
                        lfAchievementActivityModelImpl.getAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACHIEVEMENTID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACHIEVEMENTID,
                    args);
            }

            if ((lfAchievementActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAchievementActivityModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { lfAchievementActivityModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((lfAchievementActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAchievementActivityModelImpl.getOriginalUserId(),
                        lfAchievementActivityModelImpl.getOriginalAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLBYACHIEVEMENTANDUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID,
                    args);

                args = new Object[] {
                        lfAchievementActivityModelImpl.getUserId(),
                        lfAchievementActivityModelImpl.getAchievementId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLBYACHIEVEMENTANDUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLBYACHIEVEMENTANDUSERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFAchievementActivityImpl.class,
            lfAchievementActivity.getPrimaryKey(), lfAchievementActivity);

        return lfAchievementActivity;
    }

    protected LFAchievementActivity toUnwrappedModel(
        LFAchievementActivity lfAchievementActivity) {
        if (lfAchievementActivity instanceof LFAchievementActivityImpl) {
            return lfAchievementActivity;
        }

        LFAchievementActivityImpl lfAchievementActivityImpl = new LFAchievementActivityImpl();

        lfAchievementActivityImpl.setNew(lfAchievementActivity.isNew());
        lfAchievementActivityImpl.setPrimaryKey(lfAchievementActivity.getPrimaryKey());

        lfAchievementActivityImpl.setId(lfAchievementActivity.getId());
        lfAchievementActivityImpl.setUserId(lfAchievementActivity.getUserId());
        lfAchievementActivityImpl.setAchievementId(lfAchievementActivity.getAchievementId());

        return lfAchievementActivityImpl;
    }

    /**
     * Returns the l f achievement activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f achievement activity
     * @return the l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFAchievementActivityException, SystemException {
        LFAchievementActivity lfAchievementActivity = fetchByPrimaryKey(primaryKey);

        if (lfAchievementActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFAchievementActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfAchievementActivity;
    }

    /**
     * Returns the l f achievement activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException} if it could not be found.
     *
     * @param id the primary key of the l f achievement activity
     * @return the l f achievement activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity findByPrimaryKey(long id)
        throws NoSuchLFAchievementActivityException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f achievement activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f achievement activity
     * @return the l f achievement activity, or <code>null</code> if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFAchievementActivity lfAchievementActivity = (LFAchievementActivity) EntityCacheUtil.getResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFAchievementActivityImpl.class, primaryKey);

        if (lfAchievementActivity == _nullLFAchievementActivity) {
            return null;
        }

        if (lfAchievementActivity == null) {
            Session session = null;

            try {
                session = openSession();

                lfAchievementActivity = (LFAchievementActivity) session.get(LFAchievementActivityImpl.class,
                        primaryKey);

                if (lfAchievementActivity != null) {
                    cacheResult(lfAchievementActivity);
                } else {
                    EntityCacheUtil.putResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFAchievementActivityImpl.class, primaryKey,
                        _nullLFAchievementActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFAchievementActivityModelImpl.ENTITY_CACHE_ENABLED,
                    LFAchievementActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfAchievementActivity;
    }

    /**
     * Returns the l f achievement activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f achievement activity
     * @return the l f achievement activity, or <code>null</code> if a l f achievement activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAchievementActivity fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f achievement activities.
     *
     * @return the l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f achievement activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @return the range of l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f achievement activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f achievement activities
     * @param end the upper bound of the range of l f achievement activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f achievement activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAchievementActivity> findAll(int start, int end,
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

        List<LFAchievementActivity> list = (List<LFAchievementActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFACHIEVEMENTACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFACHIEVEMENTACTIVITY;

                if (pagination) {
                    sql = sql.concat(LFAchievementActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAchievementActivity>(list);
                } else {
                    list = (List<LFAchievementActivity>) QueryUtil.list(q,
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
     * Removes all the l f achievement activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFAchievementActivity lfAchievementActivity : findAll()) {
            remove(lfAchievementActivity);
        }
    }

    /**
     * Returns the number of l f achievement activities.
     *
     * @return the number of l f achievement activities
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

                Query q = session.createQuery(_SQL_COUNT_LFACHIEVEMENTACTIVITY);

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
     * Initializes the l f achievement activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFAchievementActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFAchievementActivity>> listenersList = new ArrayList<ModelListener<LFAchievementActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFAchievementActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFAchievementActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException;
import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting;
import com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFLRSToActivitySettingPersistence;

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
 * The persistence implementation for the l f l r s to activity setting service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLRSToActivitySettingPersistence
 * @see LFLRSToActivitySettingUtil
 * @generated
 */
public class LFLRSToActivitySettingPersistenceImpl extends BasePersistenceImpl<LFLRSToActivitySetting>
    implements LFLRSToActivitySettingPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFLRSToActivitySettingUtil} to access the l f l r s to activity setting persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFLRSToActivitySettingImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingModelImpl.FINDER_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingModelImpl.FINDER_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COURSEID = new FinderPath(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingModelImpl.FINDER_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID =
        new FinderPath(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingModelImpl.FINDER_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseID",
            new String[] { Integer.class.getName() },
            LFLRSToActivitySettingModelImpl.COURSEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL = "lflrsToActivitySetting.courseID IS NULL";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "lflrsToActivitySetting.courseID = ?";
    private static final String _FINDER_COLUMN_COURSEID_COURSEID_NULL_2 = "lflrsToActivitySetting.courseID IS NULL ";
    private static final String _SQL_SELECT_LFLRSTOACTIVITYSETTING = "SELECT lflrsToActivitySetting FROM LFLRSToActivitySetting lflrsToActivitySetting";
    private static final String _SQL_SELECT_LFLRSTOACTIVITYSETTING_WHERE = "SELECT lflrsToActivitySetting FROM LFLRSToActivitySetting lflrsToActivitySetting WHERE ";
    private static final String _SQL_COUNT_LFLRSTOACTIVITYSETTING = "SELECT COUNT(lflrsToActivitySetting) FROM LFLRSToActivitySetting lflrsToActivitySetting";
    private static final String _SQL_COUNT_LFLRSTOACTIVITYSETTING_WHERE = "SELECT COUNT(lflrsToActivitySetting) FROM LFLRSToActivitySetting lflrsToActivitySetting WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lflrsToActivitySetting.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFLRSToActivitySetting exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFLRSToActivitySetting exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFLRSToActivitySettingPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFLRSToActivitySetting _nullLFLRSToActivitySetting = new LFLRSToActivitySettingImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFLRSToActivitySetting> toCacheModel() {
                return _nullLFLRSToActivitySettingCacheModel;
            }
        };

    private static CacheModel<LFLRSToActivitySetting> _nullLFLRSToActivitySettingCacheModel =
        new CacheModel<LFLRSToActivitySetting>() {
            @Override
            public LFLRSToActivitySetting toEntityModel() {
                return _nullLFLRSToActivitySetting;
            }
        };

    public LFLRSToActivitySettingPersistenceImpl() {
        setModelClass(LFLRSToActivitySetting.class);
    }

    /**
     * Returns all the l f l r s to activity settings where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the matching l f l r s to activity settings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLRSToActivitySetting> findByCourseID(Integer courseID)
        throws SystemException {
        return findByCourseID(courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f l r s to activity settings where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f l r s to activity settings
     * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
     * @return the range of matching l f l r s to activity settings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLRSToActivitySetting> findByCourseID(Integer courseID,
        int start, int end) throws SystemException {
        return findByCourseID(courseID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f l r s to activity settings where courseID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param courseID the course i d
     * @param start the lower bound of the range of l f l r s to activity settings
     * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f l r s to activity settings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLRSToActivitySetting> findByCourseID(Integer courseID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
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

        List<LFLRSToActivitySetting> list = (List<LFLRSToActivitySetting>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFLRSToActivitySetting lflrsToActivitySetting : list) {
                if (!Validator.equals(courseID,
                            lflrsToActivitySetting.getCourseID())) {
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

            query.append(_SQL_SELECT_LFLRSTOACTIVITYSETTING_WHERE);

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
                query.append(LFLRSToActivitySettingModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFLRSToActivitySetting>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFLRSToActivitySetting>(list);
                } else {
                    list = (List<LFLRSToActivitySetting>) QueryUtil.list(q,
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
     * Returns the first l f l r s to activity setting in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f l r s to activity setting
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a matching l f l r s to activity setting could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting findByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        LFLRSToActivitySetting lflrsToActivitySetting = fetchByCourseID_First(courseID,
                orderByComparator);

        if (lflrsToActivitySetting != null) {
            return lflrsToActivitySetting;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFLRSToActivitySettingException(msg.toString());
    }

    /**
     * Returns the first l f l r s to activity setting in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f l r s to activity setting, or <code>null</code> if a matching l f l r s to activity setting could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting fetchByCourseID_First(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFLRSToActivitySetting> list = findByCourseID(courseID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f l r s to activity setting in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f l r s to activity setting
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a matching l f l r s to activity setting could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting findByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        LFLRSToActivitySetting lflrsToActivitySetting = fetchByCourseID_Last(courseID,
                orderByComparator);

        if (lflrsToActivitySetting != null) {
            return lflrsToActivitySetting;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("courseID=");
        msg.append(courseID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFLRSToActivitySettingException(msg.toString());
    }

    /**
     * Returns the last l f l r s to activity setting in the ordered set where courseID = &#63;.
     *
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f l r s to activity setting, or <code>null</code> if a matching l f l r s to activity setting could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting fetchByCourseID_Last(Integer courseID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCourseID(courseID);

        if (count == 0) {
            return null;
        }

        List<LFLRSToActivitySetting> list = findByCourseID(courseID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f l r s to activity settings before and after the current l f l r s to activity setting in the ordered set where courseID = &#63;.
     *
     * @param id the primary key of the current l f l r s to activity setting
     * @param courseID the course i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f l r s to activity setting
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting[] findByCourseID_PrevAndNext(long id,
        Integer courseID, OrderByComparator orderByComparator)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        LFLRSToActivitySetting lflrsToActivitySetting = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFLRSToActivitySetting[] array = new LFLRSToActivitySettingImpl[3];

            array[0] = getByCourseID_PrevAndNext(session,
                    lflrsToActivitySetting, courseID, orderByComparator, true);

            array[1] = lflrsToActivitySetting;

            array[2] = getByCourseID_PrevAndNext(session,
                    lflrsToActivitySetting, courseID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFLRSToActivitySetting getByCourseID_PrevAndNext(
        Session session, LFLRSToActivitySetting lflrsToActivitySetting,
        Integer courseID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFLRSTOACTIVITYSETTING_WHERE);

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
            query.append(LFLRSToActivitySettingModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lflrsToActivitySetting);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFLRSToActivitySetting> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f l r s to activity settings where courseID = &#63; from the database.
     *
     * @param courseID the course i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCourseID(Integer courseID) throws SystemException {
        for (LFLRSToActivitySetting lflrsToActivitySetting : findByCourseID(
                courseID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lflrsToActivitySetting);
        }
    }

    /**
     * Returns the number of l f l r s to activity settings where courseID = &#63;.
     *
     * @param courseID the course i d
     * @return the number of matching l f l r s to activity settings
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

            query.append(_SQL_COUNT_LFLRSTOACTIVITYSETTING_WHERE);

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
     * Caches the l f l r s to activity setting in the entity cache if it is enabled.
     *
     * @param lflrsToActivitySetting the l f l r s to activity setting
     */
    @Override
    public void cacheResult(LFLRSToActivitySetting lflrsToActivitySetting) {
        EntityCacheUtil.putResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            lflrsToActivitySetting.getPrimaryKey(), lflrsToActivitySetting);

        lflrsToActivitySetting.resetOriginalValues();
    }

    /**
     * Caches the l f l r s to activity settings in the entity cache if it is enabled.
     *
     * @param lflrsToActivitySettings the l f l r s to activity settings
     */
    @Override
    public void cacheResult(
        List<LFLRSToActivitySetting> lflrsToActivitySettings) {
        for (LFLRSToActivitySetting lflrsToActivitySetting : lflrsToActivitySettings) {
            if (EntityCacheUtil.getResult(
                        LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
                        LFLRSToActivitySettingImpl.class,
                        lflrsToActivitySetting.getPrimaryKey()) == null) {
                cacheResult(lflrsToActivitySetting);
            } else {
                lflrsToActivitySetting.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f l r s to activity settings.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFLRSToActivitySettingImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFLRSToActivitySettingImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f l r s to activity setting.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFLRSToActivitySetting lflrsToActivitySetting) {
        EntityCacheUtil.removeResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            lflrsToActivitySetting.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFLRSToActivitySetting> lflrsToActivitySettings) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFLRSToActivitySetting lflrsToActivitySetting : lflrsToActivitySettings) {
            EntityCacheUtil.removeResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
                LFLRSToActivitySettingImpl.class,
                lflrsToActivitySetting.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f l r s to activity setting with the primary key. Does not add the l f l r s to activity setting to the database.
     *
     * @param id the primary key for the new l f l r s to activity setting
     * @return the new l f l r s to activity setting
     */
    @Override
    public LFLRSToActivitySetting create(long id) {
        LFLRSToActivitySetting lflrsToActivitySetting = new LFLRSToActivitySettingImpl();

        lflrsToActivitySetting.setNew(true);
        lflrsToActivitySetting.setPrimaryKey(id);

        return lflrsToActivitySetting;
    }

    /**
     * Removes the l f l r s to activity setting with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f l r s to activity setting
     * @return the l f l r s to activity setting that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting remove(long id)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f l r s to activity setting with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f l r s to activity setting
     * @return the l f l r s to activity setting that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting remove(Serializable primaryKey)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFLRSToActivitySetting lflrsToActivitySetting = (LFLRSToActivitySetting) session.get(LFLRSToActivitySettingImpl.class,
                    primaryKey);

            if (lflrsToActivitySetting == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFLRSToActivitySettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lflrsToActivitySetting);
        } catch (NoSuchLFLRSToActivitySettingException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFLRSToActivitySetting removeImpl(
        LFLRSToActivitySetting lflrsToActivitySetting)
        throws SystemException {
        lflrsToActivitySetting = toUnwrappedModel(lflrsToActivitySetting);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lflrsToActivitySetting)) {
                lflrsToActivitySetting = (LFLRSToActivitySetting) session.get(LFLRSToActivitySettingImpl.class,
                        lflrsToActivitySetting.getPrimaryKeyObj());
            }

            if (lflrsToActivitySetting != null) {
                session.delete(lflrsToActivitySetting);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lflrsToActivitySetting != null) {
            clearCache(lflrsToActivitySetting);
        }

        return lflrsToActivitySetting;
    }

    @Override
    public LFLRSToActivitySetting updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting lflrsToActivitySetting)
        throws SystemException {
        lflrsToActivitySetting = toUnwrappedModel(lflrsToActivitySetting);

        boolean isNew = lflrsToActivitySetting.isNew();

        LFLRSToActivitySettingModelImpl lflrsToActivitySettingModelImpl = (LFLRSToActivitySettingModelImpl) lflrsToActivitySetting;

        Session session = null;

        try {
            session = openSession();

            if (lflrsToActivitySetting.isNew()) {
                session.save(lflrsToActivitySetting);

                lflrsToActivitySetting.setNew(false);
            } else {
                session.merge(lflrsToActivitySetting);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFLRSToActivitySettingModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lflrsToActivitySettingModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lflrsToActivitySettingModelImpl.getOriginalCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);

                args = new Object[] {
                        lflrsToActivitySettingModelImpl.getCourseID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COURSEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COURSEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
            LFLRSToActivitySettingImpl.class,
            lflrsToActivitySetting.getPrimaryKey(), lflrsToActivitySetting);

        return lflrsToActivitySetting;
    }

    protected LFLRSToActivitySetting toUnwrappedModel(
        LFLRSToActivitySetting lflrsToActivitySetting) {
        if (lflrsToActivitySetting instanceof LFLRSToActivitySettingImpl) {
            return lflrsToActivitySetting;
        }

        LFLRSToActivitySettingImpl lflrsToActivitySettingImpl = new LFLRSToActivitySettingImpl();

        lflrsToActivitySettingImpl.setNew(lflrsToActivitySetting.isNew());
        lflrsToActivitySettingImpl.setPrimaryKey(lflrsToActivitySetting.getPrimaryKey());

        lflrsToActivitySettingImpl.setId(lflrsToActivitySetting.getId());
        lflrsToActivitySettingImpl.setCourseID(lflrsToActivitySetting.getCourseID());
        lflrsToActivitySettingImpl.setTitle(lflrsToActivitySetting.getTitle());
        lflrsToActivitySettingImpl.setActivityFilter(lflrsToActivitySetting.getActivityFilter());
        lflrsToActivitySettingImpl.setVerbFilter(lflrsToActivitySetting.getVerbFilter());

        return lflrsToActivitySettingImpl;
    }

    /**
     * Returns the l f l r s to activity setting with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f l r s to activity setting
     * @return the l f l r s to activity setting
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        LFLRSToActivitySetting lflrsToActivitySetting = fetchByPrimaryKey(primaryKey);

        if (lflrsToActivitySetting == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFLRSToActivitySettingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lflrsToActivitySetting;
    }

    /**
     * Returns the l f l r s to activity setting with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException} if it could not be found.
     *
     * @param id the primary key of the l f l r s to activity setting
     * @return the l f l r s to activity setting
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFLRSToActivitySettingException if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting findByPrimaryKey(long id)
        throws NoSuchLFLRSToActivitySettingException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f l r s to activity setting with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f l r s to activity setting
     * @return the l f l r s to activity setting, or <code>null</code> if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFLRSToActivitySetting lflrsToActivitySetting = (LFLRSToActivitySetting) EntityCacheUtil.getResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
                LFLRSToActivitySettingImpl.class, primaryKey);

        if (lflrsToActivitySetting == _nullLFLRSToActivitySetting) {
            return null;
        }

        if (lflrsToActivitySetting == null) {
            Session session = null;

            try {
                session = openSession();

                lflrsToActivitySetting = (LFLRSToActivitySetting) session.get(LFLRSToActivitySettingImpl.class,
                        primaryKey);

                if (lflrsToActivitySetting != null) {
                    cacheResult(lflrsToActivitySetting);
                } else {
                    EntityCacheUtil.putResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
                        LFLRSToActivitySettingImpl.class, primaryKey,
                        _nullLFLRSToActivitySetting);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFLRSToActivitySettingModelImpl.ENTITY_CACHE_ENABLED,
                    LFLRSToActivitySettingImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lflrsToActivitySetting;
    }

    /**
     * Returns the l f l r s to activity setting with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f l r s to activity setting
     * @return the l f l r s to activity setting, or <code>null</code> if a l f l r s to activity setting with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFLRSToActivitySetting fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f l r s to activity settings.
     *
     * @return the l f l r s to activity settings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLRSToActivitySetting> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f l r s to activity settings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f l r s to activity settings
     * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
     * @return the range of l f l r s to activity settings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLRSToActivitySetting> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f l r s to activity settings.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFLRSToActivitySettingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f l r s to activity settings
     * @param end the upper bound of the range of l f l r s to activity settings (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f l r s to activity settings
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFLRSToActivitySetting> findAll(int start, int end,
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

        List<LFLRSToActivitySetting> list = (List<LFLRSToActivitySetting>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFLRSTOACTIVITYSETTING);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFLRSTOACTIVITYSETTING;

                if (pagination) {
                    sql = sql.concat(LFLRSToActivitySettingModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFLRSToActivitySetting>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFLRSToActivitySetting>(list);
                } else {
                    list = (List<LFLRSToActivitySetting>) QueryUtil.list(q,
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
     * Removes all the l f l r s to activity settings from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFLRSToActivitySetting lflrsToActivitySetting : findAll()) {
            remove(lflrsToActivitySetting);
        }
    }

    /**
     * Returns the number of l f l r s to activity settings.
     *
     * @return the number of l f l r s to activity settings
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

                Query q = session.createQuery(_SQL_COUNT_LFLRSTOACTIVITYSETTING);

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
     * Initializes the l f l r s to activity setting persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFLRSToActivitySetting>> listenersList = new ArrayList<ModelListener<LFLRSToActivitySetting>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFLRSToActivitySetting>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFLRSToActivitySettingImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

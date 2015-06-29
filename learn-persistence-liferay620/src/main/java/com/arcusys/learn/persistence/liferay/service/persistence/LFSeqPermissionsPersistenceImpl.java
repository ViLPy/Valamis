package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException;
import com.arcusys.learn.persistence.liferay.model.LFSeqPermissions;
import com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSeqPermissionsPersistence;

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
 * The persistence implementation for the l f seq permissions service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSeqPermissionsPersistence
 * @see LFSeqPermissionsUtil
 * @generated
 */
public class LFSeqPermissionsPersistenceImpl extends BasePersistenceImpl<LFSeqPermissions>
    implements LFSeqPermissionsPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSeqPermissionsUtil} to access the l f seq permissions persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSeqPermissionsImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsModelImpl.FINDER_CACHE_ENABLED,
            LFSeqPermissionsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsModelImpl.FINDER_CACHE_ENABLED,
            LFSeqPermissionsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsModelImpl.FINDER_CACHE_ENABLED,
            LFSeqPermissionsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySequencingID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID =
        new FinderPath(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsModelImpl.FINDER_CACHE_ENABLED,
            LFSeqPermissionsImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySequencingID",
            new String[] { Integer.class.getName() },
            LFSeqPermissionsModelImpl.SEQUENCINGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SEQUENCINGID = new FinderPath(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySequencingID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL = "lfSeqPermissions.sequencingID IS NULL";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2 = "lfSeqPermissions.sequencingID = ?";
    private static final String _FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2 = "lfSeqPermissions.sequencingID IS NULL ";
    private static final String _SQL_SELECT_LFSEQPERMISSIONS = "SELECT lfSeqPermissions FROM LFSeqPermissions lfSeqPermissions";
    private static final String _SQL_SELECT_LFSEQPERMISSIONS_WHERE = "SELECT lfSeqPermissions FROM LFSeqPermissions lfSeqPermissions WHERE ";
    private static final String _SQL_COUNT_LFSEQPERMISSIONS = "SELECT COUNT(lfSeqPermissions) FROM LFSeqPermissions lfSeqPermissions";
    private static final String _SQL_COUNT_LFSEQPERMISSIONS_WHERE = "SELECT COUNT(lfSeqPermissions) FROM LFSeqPermissions lfSeqPermissions WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSeqPermissions.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSeqPermissions exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSeqPermissions exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSeqPermissionsPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFSeqPermissions _nullLFSeqPermissions = new LFSeqPermissionsImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSeqPermissions> toCacheModel() {
                return _nullLFSeqPermissionsCacheModel;
            }
        };

    private static CacheModel<LFSeqPermissions> _nullLFSeqPermissionsCacheModel = new CacheModel<LFSeqPermissions>() {
            @Override
            public LFSeqPermissions toEntityModel() {
                return _nullLFSeqPermissions;
            }
        };

    public LFSeqPermissionsPersistenceImpl() {
        setModelClass(LFSeqPermissions.class);
    }

    /**
     * Returns all the l f seq permissionses where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the matching l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSeqPermissions> findBySequencingID(Integer sequencingID)
        throws SystemException {
        return findBySequencingID(sequencingID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f seq permissionses where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f seq permissionses
     * @param end the upper bound of the range of l f seq permissionses (not inclusive)
     * @return the range of matching l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSeqPermissions> findBySequencingID(Integer sequencingID,
        int start, int end) throws SystemException {
        return findBySequencingID(sequencingID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f seq permissionses where sequencingID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param sequencingID the sequencing i d
     * @param start the lower bound of the range of l f seq permissionses
     * @param end the upper bound of the range of l f seq permissionses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSeqPermissions> findBySequencingID(Integer sequencingID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] { sequencingID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SEQUENCINGID;
            finderArgs = new Object[] {
                    sequencingID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFSeqPermissions> list = (List<LFSeqPermissions>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSeqPermissions lfSeqPermissions : list) {
                if (!Validator.equals(sequencingID,
                            lfSeqPermissions.getSequencingID())) {
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

            query.append(_SQL_SELECT_LFSEQPERMISSIONS_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFSeqPermissionsModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
                }

                if (!pagination) {
                    list = (List<LFSeqPermissions>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSeqPermissions>(list);
                } else {
                    list = (List<LFSeqPermissions>) QueryUtil.list(q,
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
     * Returns the first l f seq permissions in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f seq permissions
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a matching l f seq permissions could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions findBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSeqPermissionsException, SystemException {
        LFSeqPermissions lfSeqPermissions = fetchBySequencingID_First(sequencingID,
                orderByComparator);

        if (lfSeqPermissions != null) {
            return lfSeqPermissions;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSeqPermissionsException(msg.toString());
    }

    /**
     * Returns the first l f seq permissions in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f seq permissions, or <code>null</code> if a matching l f seq permissions could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions fetchBySequencingID_First(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFSeqPermissions> list = findBySequencingID(sequencingID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f seq permissions in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f seq permissions
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a matching l f seq permissions could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions findBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSeqPermissionsException, SystemException {
        LFSeqPermissions lfSeqPermissions = fetchBySequencingID_Last(sequencingID,
                orderByComparator);

        if (lfSeqPermissions != null) {
            return lfSeqPermissions;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("sequencingID=");
        msg.append(sequencingID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSeqPermissionsException(msg.toString());
    }

    /**
     * Returns the last l f seq permissions in the ordered set where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f seq permissions, or <code>null</code> if a matching l f seq permissions could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions fetchBySequencingID_Last(Integer sequencingID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySequencingID(sequencingID);

        if (count == 0) {
            return null;
        }

        List<LFSeqPermissions> list = findBySequencingID(sequencingID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f seq permissionses before and after the current l f seq permissions in the ordered set where sequencingID = &#63;.
     *
     * @param id the primary key of the current l f seq permissions
     * @param sequencingID the sequencing i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f seq permissions
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions[] findBySequencingID_PrevAndNext(long id,
        Integer sequencingID, OrderByComparator orderByComparator)
        throws NoSuchLFSeqPermissionsException, SystemException {
        LFSeqPermissions lfSeqPermissions = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSeqPermissions[] array = new LFSeqPermissionsImpl[3];

            array[0] = getBySequencingID_PrevAndNext(session, lfSeqPermissions,
                    sequencingID, orderByComparator, true);

            array[1] = lfSeqPermissions;

            array[2] = getBySequencingID_PrevAndNext(session, lfSeqPermissions,
                    sequencingID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSeqPermissions getBySequencingID_PrevAndNext(Session session,
        LFSeqPermissions lfSeqPermissions, Integer sequencingID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSEQPERMISSIONS_WHERE);

        if (sequencingID == null) {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
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
            query.append(LFSeqPermissionsModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (sequencingID != null) {
            qPos.add(sequencingID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfSeqPermissions);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSeqPermissions> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f seq permissionses where sequencingID = &#63; from the database.
     *
     * @param sequencingID the sequencing i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySequencingID(Integer sequencingID)
        throws SystemException {
        for (LFSeqPermissions lfSeqPermissions : findBySequencingID(
                sequencingID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfSeqPermissions);
        }
    }

    /**
     * Returns the number of l f seq permissionses where sequencingID = &#63;.
     *
     * @param sequencingID the sequencing i d
     * @return the number of matching l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySequencingID(Integer sequencingID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SEQUENCINGID;

        Object[] finderArgs = new Object[] { sequencingID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSEQPERMISSIONS_WHERE);

            if (sequencingID == null) {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SEQUENCINGID_SEQUENCINGID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (sequencingID != null) {
                    qPos.add(sequencingID.intValue());
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
     * Caches the l f seq permissions in the entity cache if it is enabled.
     *
     * @param lfSeqPermissions the l f seq permissions
     */
    @Override
    public void cacheResult(LFSeqPermissions lfSeqPermissions) {
        EntityCacheUtil.putResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsImpl.class, lfSeqPermissions.getPrimaryKey(),
            lfSeqPermissions);

        lfSeqPermissions.resetOriginalValues();
    }

    /**
     * Caches the l f seq permissionses in the entity cache if it is enabled.
     *
     * @param lfSeqPermissionses the l f seq permissionses
     */
    @Override
    public void cacheResult(List<LFSeqPermissions> lfSeqPermissionses) {
        for (LFSeqPermissions lfSeqPermissions : lfSeqPermissionses) {
            if (EntityCacheUtil.getResult(
                        LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
                        LFSeqPermissionsImpl.class,
                        lfSeqPermissions.getPrimaryKey()) == null) {
                cacheResult(lfSeqPermissions);
            } else {
                lfSeqPermissions.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f seq permissionses.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSeqPermissionsImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSeqPermissionsImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f seq permissions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSeqPermissions lfSeqPermissions) {
        EntityCacheUtil.removeResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsImpl.class, lfSeqPermissions.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFSeqPermissions> lfSeqPermissionses) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSeqPermissions lfSeqPermissions : lfSeqPermissionses) {
            EntityCacheUtil.removeResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
                LFSeqPermissionsImpl.class, lfSeqPermissions.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f seq permissions with the primary key. Does not add the l f seq permissions to the database.
     *
     * @param id the primary key for the new l f seq permissions
     * @return the new l f seq permissions
     */
    @Override
    public LFSeqPermissions create(long id) {
        LFSeqPermissions lfSeqPermissions = new LFSeqPermissionsImpl();

        lfSeqPermissions.setNew(true);
        lfSeqPermissions.setPrimaryKey(id);

        return lfSeqPermissions;
    }

    /**
     * Removes the l f seq permissions with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f seq permissions
     * @return the l f seq permissions that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions remove(long id)
        throws NoSuchLFSeqPermissionsException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f seq permissions with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f seq permissions
     * @return the l f seq permissions that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions remove(Serializable primaryKey)
        throws NoSuchLFSeqPermissionsException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSeqPermissions lfSeqPermissions = (LFSeqPermissions) session.get(LFSeqPermissionsImpl.class,
                    primaryKey);

            if (lfSeqPermissions == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSeqPermissionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSeqPermissions);
        } catch (NoSuchLFSeqPermissionsException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSeqPermissions removeImpl(LFSeqPermissions lfSeqPermissions)
        throws SystemException {
        lfSeqPermissions = toUnwrappedModel(lfSeqPermissions);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfSeqPermissions)) {
                lfSeqPermissions = (LFSeqPermissions) session.get(LFSeqPermissionsImpl.class,
                        lfSeqPermissions.getPrimaryKeyObj());
            }

            if (lfSeqPermissions != null) {
                session.delete(lfSeqPermissions);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfSeqPermissions != null) {
            clearCache(lfSeqPermissions);
        }

        return lfSeqPermissions;
    }

    @Override
    public LFSeqPermissions updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSeqPermissions lfSeqPermissions)
        throws SystemException {
        lfSeqPermissions = toUnwrappedModel(lfSeqPermissions);

        boolean isNew = lfSeqPermissions.isNew();

        LFSeqPermissionsModelImpl lfSeqPermissionsModelImpl = (LFSeqPermissionsModelImpl) lfSeqPermissions;

        Session session = null;

        try {
            session = openSession();

            if (lfSeqPermissions.isNew()) {
                session.save(lfSeqPermissions);

                lfSeqPermissions.setNew(false);
            } else {
                session.merge(lfSeqPermissions);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSeqPermissionsModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfSeqPermissionsModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSeqPermissionsModelImpl.getOriginalSequencingID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);

                args = new Object[] { lfSeqPermissionsModelImpl.getSequencingID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SEQUENCINGID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SEQUENCINGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
            LFSeqPermissionsImpl.class, lfSeqPermissions.getPrimaryKey(),
            lfSeqPermissions);

        return lfSeqPermissions;
    }

    protected LFSeqPermissions toUnwrappedModel(
        LFSeqPermissions lfSeqPermissions) {
        if (lfSeqPermissions instanceof LFSeqPermissionsImpl) {
            return lfSeqPermissions;
        }

        LFSeqPermissionsImpl lfSeqPermissionsImpl = new LFSeqPermissionsImpl();

        lfSeqPermissionsImpl.setNew(lfSeqPermissions.isNew());
        lfSeqPermissionsImpl.setPrimaryKey(lfSeqPermissions.getPrimaryKey());

        lfSeqPermissionsImpl.setId(lfSeqPermissions.getId());
        lfSeqPermissionsImpl.setSequencingID(lfSeqPermissions.getSequencingID());
        lfSeqPermissionsImpl.setChoiceForChildren(lfSeqPermissions.isChoiceForChildren());
        lfSeqPermissionsImpl.setChoiceForNonDescendants(lfSeqPermissions.isChoiceForNonDescendants());
        lfSeqPermissionsImpl.setFlowForChildren(lfSeqPermissions.isFlowForChildren());
        lfSeqPermissionsImpl.setForwardOnlyForChildren(lfSeqPermissions.isForwardOnlyForChildren());

        return lfSeqPermissionsImpl;
    }

    /**
     * Returns the l f seq permissions with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f seq permissions
     * @return the l f seq permissions
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFSeqPermissionsException, SystemException {
        LFSeqPermissions lfSeqPermissions = fetchByPrimaryKey(primaryKey);

        if (lfSeqPermissions == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFSeqPermissionsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfSeqPermissions;
    }

    /**
     * Returns the l f seq permissions with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException} if it could not be found.
     *
     * @param id the primary key of the l f seq permissions
     * @return the l f seq permissions
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions findByPrimaryKey(long id)
        throws NoSuchLFSeqPermissionsException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f seq permissions with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f seq permissions
     * @return the l f seq permissions, or <code>null</code> if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFSeqPermissions lfSeqPermissions = (LFSeqPermissions) EntityCacheUtil.getResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
                LFSeqPermissionsImpl.class, primaryKey);

        if (lfSeqPermissions == _nullLFSeqPermissions) {
            return null;
        }

        if (lfSeqPermissions == null) {
            Session session = null;

            try {
                session = openSession();

                lfSeqPermissions = (LFSeqPermissions) session.get(LFSeqPermissionsImpl.class,
                        primaryKey);

                if (lfSeqPermissions != null) {
                    cacheResult(lfSeqPermissions);
                } else {
                    EntityCacheUtil.putResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
                        LFSeqPermissionsImpl.class, primaryKey,
                        _nullLFSeqPermissions);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFSeqPermissionsModelImpl.ENTITY_CACHE_ENABLED,
                    LFSeqPermissionsImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfSeqPermissions;
    }

    /**
     * Returns the l f seq permissions with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f seq permissions
     * @return the l f seq permissions, or <code>null</code> if a l f seq permissions with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSeqPermissions fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f seq permissionses.
     *
     * @return the l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSeqPermissions> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f seq permissionses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f seq permissionses
     * @param end the upper bound of the range of l f seq permissionses (not inclusive)
     * @return the range of l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSeqPermissions> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f seq permissionses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f seq permissionses
     * @param end the upper bound of the range of l f seq permissionses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f seq permissionses
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSeqPermissions> findAll(int start, int end,
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

        List<LFSeqPermissions> list = (List<LFSeqPermissions>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSEQPERMISSIONS);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSEQPERMISSIONS;

                if (pagination) {
                    sql = sql.concat(LFSeqPermissionsModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFSeqPermissions>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSeqPermissions>(list);
                } else {
                    list = (List<LFSeqPermissions>) QueryUtil.list(q,
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
     * Removes all the l f seq permissionses from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFSeqPermissions lfSeqPermissions : findAll()) {
            remove(lfSeqPermissions);
        }
    }

    /**
     * Returns the number of l f seq permissionses.
     *
     * @return the number of l f seq permissionses
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

                Query q = session.createQuery(_SQL_COUNT_LFSEQPERMISSIONS);

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
     * Initializes the l f seq permissions persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSeqPermissions")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSeqPermissions>> listenersList = new ArrayList<ModelListener<LFSeqPermissions>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSeqPermissions>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSeqPermissionsImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

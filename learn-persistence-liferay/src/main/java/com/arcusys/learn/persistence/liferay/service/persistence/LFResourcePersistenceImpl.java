package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFResourceException;
import com.arcusys.learn.persistence.liferay.model.LFResource;
import com.arcusys.learn.persistence.liferay.model.impl.LFResourceImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFResourcePersistence;

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
 * The persistence implementation for the l f resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFResourcePersistence
 * @see LFResourceUtil
 * @generated
 */
public class LFResourcePersistenceImpl extends BasePersistenceImpl<LFResource>
    implements LFResourcePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFResourceUtil} to access the l f resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFResourceImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, LFResourceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, LFResourceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, LFResourceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPackageID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID =
        new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, LFResourceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPackageID",
            new String[] { Integer.class.getName() },
            LFResourceModelImpl.PACKAGEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEID = new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPackageID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL = "lfResource.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_2 = "lfResource.packageID = ?";
    private static final String _FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2 = "lfResource.packageID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID =
        new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, LFResourceImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByPackageIDAndResourceID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID =
        new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, LFResourceImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByPackageIDAndResourceID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFResourceModelImpl.PACKAGEID_COLUMN_BITMASK |
            LFResourceModelImpl.RESOURCEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PACKAGEIDANDRESOURCEID = new FinderPath(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByPackageIDAndResourceID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_NULL =
        "lfResource.packageID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_2 =
        "lfResource.packageID = ? AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_NULL_2 =
        "lfResource.packageID IS NULL  AND ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_1 =
        "lfResource.resourceID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_NULL =
        "lfResource.resourceID IS NULL";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_2 =
        "lfResource.resourceID = ?";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_NULL_2 =
        "lfResource.resourceID IS NULL ";
    private static final String _FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3 =
        "(lfResource.resourceID IS NULL OR lfResource.resourceID = '')";
    private static final String _SQL_SELECT_LFRESOURCE = "SELECT lfResource FROM LFResource lfResource";
    private static final String _SQL_SELECT_LFRESOURCE_WHERE = "SELECT lfResource FROM LFResource lfResource WHERE ";
    private static final String _SQL_COUNT_LFRESOURCE = "SELECT COUNT(lfResource) FROM LFResource lfResource";
    private static final String _SQL_COUNT_LFRESOURCE_WHERE = "SELECT COUNT(lfResource) FROM LFResource lfResource WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfResource.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFResource exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFResource exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFResourcePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFResource _nullLFResource = new LFResourceImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFResource> toCacheModel() {
                return _nullLFResourceCacheModel;
            }
        };

    private static CacheModel<LFResource> _nullLFResourceCacheModel = new CacheModel<LFResource>() {
            @Override
            public LFResource toEntityModel() {
                return _nullLFResource;
            }
        };

    public LFResourcePersistenceImpl() {
        setModelClass(LFResource.class);
    }

    /**
     * Returns all the l f resources where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findByPackageID(Integer packageID)
        throws SystemException {
        return findByPackageID(packageID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
    }

    /**
     * Returns a range of all the l f resources where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f resources
     * @param end the upper bound of the range of l f resources (not inclusive)
     * @return the range of matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findByPackageID(Integer packageID, int start,
        int end) throws SystemException {
        return findByPackageID(packageID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f resources where packageID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param start the lower bound of the range of l f resources
     * @param end the upper bound of the range of l f resources (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findByPackageID(Integer packageID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEID;
            finderArgs = new Object[] { packageID, start, end, orderByComparator };
        }

        List<LFResource> list = (List<LFResource>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFResource lfResource : list) {
                if (!Validator.equals(packageID, lfResource.getPackageID())) {
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

            query.append(_SQL_SELECT_LFRESOURCE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFResourceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (!pagination) {
                    list = (List<LFResource>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFResource>(list);
                } else {
                    list = (List<LFResource>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f resource in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource findByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = fetchByPackageID_First(packageID,
                orderByComparator);

        if (lfResource != null) {
            return lfResource;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFResourceException(msg.toString());
    }

    /**
     * Returns the first l f resource in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f resource, or <code>null</code> if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource fetchByPackageID_First(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFResource> list = findByPackageID(packageID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f resource in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource findByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = fetchByPackageID_Last(packageID,
                orderByComparator);

        if (lfResource != null) {
            return lfResource;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFResourceException(msg.toString());
    }

    /**
     * Returns the last l f resource in the ordered set where packageID = &#63;.
     *
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f resource, or <code>null</code> if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource fetchByPackageID_Last(Integer packageID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByPackageID(packageID);

        if (count == 0) {
            return null;
        }

        List<LFResource> list = findByPackageID(packageID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f resources before and after the current l f resource in the ordered set where packageID = &#63;.
     *
     * @param id the primary key of the current l f resource
     * @param packageID the package i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource[] findByPackageID_PrevAndNext(long id, Integer packageID,
        OrderByComparator orderByComparator)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFResource[] array = new LFResourceImpl[3];

            array[0] = getByPackageID_PrevAndNext(session, lfResource,
                    packageID, orderByComparator, true);

            array[1] = lfResource;

            array[2] = getByPackageID_PrevAndNext(session, lfResource,
                    packageID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFResource getByPackageID_PrevAndNext(Session session,
        LFResource lfResource, Integer packageID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFRESOURCE_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
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
            query.append(LFResourceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfResource);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFResource> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f resources where packageID = &#63; from the database.
     *
     * @param packageID the package i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageID(Integer packageID) throws SystemException {
        for (LFResource lfResource : findByPackageID(packageID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfResource);
        }
    }

    /**
     * Returns the number of l f resources where packageID = &#63;.
     *
     * @param packageID the package i d
     * @return the number of matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageID(Integer packageID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEID;

        Object[] finderArgs = new Object[] { packageID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFRESOURCE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEID_PACKAGEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
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
     * Returns all the l f resources where packageID = &#63; and resourceID = &#63;.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @return the matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findByPackageIDAndResourceID(Integer packageID,
        String resourceID) throws SystemException {
        return findByPackageIDAndResourceID(packageID, resourceID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f resources where packageID = &#63; and resourceID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param start the lower bound of the range of l f resources
     * @param end the upper bound of the range of l f resources (not inclusive)
     * @return the range of matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findByPackageIDAndResourceID(Integer packageID,
        String resourceID, int start, int end) throws SystemException {
        return findByPackageIDAndResourceID(packageID, resourceID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f resources where packageID = &#63; and resourceID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param start the lower bound of the range of l f resources
     * @param end the upper bound of the range of l f resources (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findByPackageIDAndResourceID(Integer packageID,
        String resourceID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID;
            finderArgs = new Object[] { packageID, resourceID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID;
            finderArgs = new Object[] {
                    packageID, resourceID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFResource> list = (List<LFResource>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFResource lfResource : list) {
                if (!Validator.equals(packageID, lfResource.getPackageID()) ||
                        !Validator.equals(resourceID, lfResource.getResourceID())) {
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

            query.append(_SQL_SELECT_LFRESOURCE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_2);
            }

            boolean bindResourceID = false;

            if (resourceID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_1);
            } else if (resourceID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3);
            } else {
                bindResourceID = true;

                if (resourceID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFResourceModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindResourceID) {
                    if (resourceID != null) {
                        qPos.add(resourceID);
                    }
                }

                if (!pagination) {
                    list = (List<LFResource>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFResource>(list);
                } else {
                    list = (List<LFResource>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource findByPackageIDAndResourceID_First(Integer packageID,
        String resourceID, OrderByComparator orderByComparator)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = fetchByPackageIDAndResourceID_First(packageID,
                resourceID, orderByComparator);

        if (lfResource != null) {
            return lfResource;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", resourceID=");
        msg.append(resourceID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFResourceException(msg.toString());
    }

    /**
     * Returns the first l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f resource, or <code>null</code> if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource fetchByPackageIDAndResourceID_First(Integer packageID,
        String resourceID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFResource> list = findByPackageIDAndResourceID(packageID,
                resourceID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource findByPackageIDAndResourceID_Last(Integer packageID,
        String resourceID, OrderByComparator orderByComparator)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = fetchByPackageIDAndResourceID_Last(packageID,
                resourceID, orderByComparator);

        if (lfResource != null) {
            return lfResource;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("packageID=");
        msg.append(packageID);

        msg.append(", resourceID=");
        msg.append(resourceID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFResourceException(msg.toString());
    }

    /**
     * Returns the last l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f resource, or <code>null</code> if a matching l f resource could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource fetchByPackageIDAndResourceID_Last(Integer packageID,
        String resourceID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByPackageIDAndResourceID(packageID, resourceID);

        if (count == 0) {
            return null;
        }

        List<LFResource> list = findByPackageIDAndResourceID(packageID,
                resourceID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f resources before and after the current l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
     *
     * @param id the primary key of the current l f resource
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource[] findByPackageIDAndResourceID_PrevAndNext(long id,
        Integer packageID, String resourceID,
        OrderByComparator orderByComparator)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFResource[] array = new LFResourceImpl[3];

            array[0] = getByPackageIDAndResourceID_PrevAndNext(session,
                    lfResource, packageID, resourceID, orderByComparator, true);

            array[1] = lfResource;

            array[2] = getByPackageIDAndResourceID_PrevAndNext(session,
                    lfResource, packageID, resourceID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFResource getByPackageIDAndResourceID_PrevAndNext(
        Session session, LFResource lfResource, Integer packageID,
        String resourceID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFRESOURCE_WHERE);

        if (packageID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_2);
        }

        boolean bindResourceID = false;

        if (resourceID == null) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_1);
        } else if (resourceID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3);
        } else {
            bindResourceID = true;

            if (resourceID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_2);
            }
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
            query.append(LFResourceModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (packageID != null) {
            qPos.add(packageID.intValue());
        }

        if (bindResourceID) {
            if (resourceID != null) {
                qPos.add(resourceID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfResource);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFResource> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f resources where packageID = &#63; and resourceID = &#63; from the database.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByPackageIDAndResourceID(Integer packageID,
        String resourceID) throws SystemException {
        for (LFResource lfResource : findByPackageIDAndResourceID(packageID,
                resourceID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfResource);
        }
    }

    /**
     * Returns the number of l f resources where packageID = &#63; and resourceID = &#63;.
     *
     * @param packageID the package i d
     * @param resourceID the resource i d
     * @return the number of matching l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByPackageIDAndResourceID(Integer packageID,
        String resourceID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PACKAGEIDANDRESOURCEID;

        Object[] finderArgs = new Object[] { packageID, resourceID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFRESOURCE_WHERE);

            if (packageID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_PACKAGEID_2);
            }

            boolean bindResourceID = false;

            if (resourceID == null) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_1);
            } else if (resourceID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3);
            } else {
                bindResourceID = true;

                if (resourceID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_3);
                } else {
                    query.append(_FINDER_COLUMN_PACKAGEIDANDRESOURCEID_RESOURCEID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (packageID != null) {
                    qPos.add(packageID.intValue());
                }

                if (bindResourceID) {
                    if (resourceID != null) {
                        qPos.add(resourceID);
                    }
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
     * Caches the l f resource in the entity cache if it is enabled.
     *
     * @param lfResource the l f resource
     */
    @Override
    public void cacheResult(LFResource lfResource) {
        EntityCacheUtil.putResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceImpl.class, lfResource.getPrimaryKey(), lfResource);

        lfResource.resetOriginalValues();
    }

    /**
     * Caches the l f resources in the entity cache if it is enabled.
     *
     * @param lfResources the l f resources
     */
    @Override
    public void cacheResult(List<LFResource> lfResources) {
        for (LFResource lfResource : lfResources) {
            if (EntityCacheUtil.getResult(
                        LFResourceModelImpl.ENTITY_CACHE_ENABLED,
                        LFResourceImpl.class, lfResource.getPrimaryKey()) == null) {
                cacheResult(lfResource);
            } else {
                lfResource.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f resources.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFResourceImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFResourceImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f resource.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFResource lfResource) {
        EntityCacheUtil.removeResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceImpl.class, lfResource.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFResource> lfResources) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFResource lfResource : lfResources) {
            EntityCacheUtil.removeResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
                LFResourceImpl.class, lfResource.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f resource with the primary key. Does not add the l f resource to the database.
     *
     * @param id the primary key for the new l f resource
     * @return the new l f resource
     */
    @Override
    public LFResource create(long id) {
        LFResource lfResource = new LFResourceImpl();

        lfResource.setNew(true);
        lfResource.setPrimaryKey(id);

        return lfResource;
    }

    /**
     * Removes the l f resource with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f resource
     * @return the l f resource that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource remove(long id)
        throws NoSuchLFResourceException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f resource with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f resource
     * @return the l f resource that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource remove(Serializable primaryKey)
        throws NoSuchLFResourceException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFResource lfResource = (LFResource) session.get(LFResourceImpl.class,
                    primaryKey);

            if (lfResource == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfResource);
        } catch (NoSuchLFResourceException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFResource removeImpl(LFResource lfResource)
        throws SystemException {
        lfResource = toUnwrappedModel(lfResource);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfResource)) {
                lfResource = (LFResource) session.get(LFResourceImpl.class,
                        lfResource.getPrimaryKeyObj());
            }

            if (lfResource != null) {
                session.delete(lfResource);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfResource != null) {
            clearCache(lfResource);
        }

        return lfResource;
    }

    @Override
    public LFResource updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws SystemException {
        lfResource = toUnwrappedModel(lfResource);

        boolean isNew = lfResource.isNew();

        LFResourceModelImpl lfResourceModelImpl = (LFResourceModelImpl) lfResource;

        Session session = null;

        try {
            session = openSession();

            if (lfResource.isNew()) {
                session.save(lfResource);

                lfResource.setNew(false);
            } else {
                session.merge(lfResource);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFResourceModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfResourceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfResourceModelImpl.getOriginalPackageID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);

                args = new Object[] { lfResourceModelImpl.getPackageID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEID,
                    args);
            }

            if ((lfResourceModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfResourceModelImpl.getOriginalPackageID(),
                        lfResourceModelImpl.getOriginalResourceID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDRESOURCEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID,
                    args);

                args = new Object[] {
                        lfResourceModelImpl.getPackageID(),
                        lfResourceModelImpl.getResourceID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PACKAGEIDANDRESOURCEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PACKAGEIDANDRESOURCEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
            LFResourceImpl.class, lfResource.getPrimaryKey(), lfResource);

        return lfResource;
    }

    protected LFResource toUnwrappedModel(LFResource lfResource) {
        if (lfResource instanceof LFResourceImpl) {
            return lfResource;
        }

        LFResourceImpl lfResourceImpl = new LFResourceImpl();

        lfResourceImpl.setNew(lfResource.isNew());
        lfResourceImpl.setPrimaryKey(lfResource.getPrimaryKey());

        lfResourceImpl.setId(lfResource.getId());
        lfResourceImpl.setPackageID(lfResource.getPackageID());
        lfResourceImpl.setScormType(lfResource.getScormType());
        lfResourceImpl.setResourceID(lfResource.getResourceID());
        lfResourceImpl.setHref(lfResource.getHref());
        lfResourceImpl.setBase(lfResource.getBase());

        return lfResourceImpl;
    }

    /**
     * Returns the l f resource with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f resource
     * @return the l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFResourceException, SystemException {
        LFResource lfResource = fetchByPrimaryKey(primaryKey);

        if (lfResource == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFResourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfResource;
    }

    /**
     * Returns the l f resource with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFResourceException} if it could not be found.
     *
     * @param id the primary key of the l f resource
     * @return the l f resource
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource findByPrimaryKey(long id)
        throws NoSuchLFResourceException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f resource with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f resource
     * @return the l f resource, or <code>null</code> if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFResource lfResource = (LFResource) EntityCacheUtil.getResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
                LFResourceImpl.class, primaryKey);

        if (lfResource == _nullLFResource) {
            return null;
        }

        if (lfResource == null) {
            Session session = null;

            try {
                session = openSession();

                lfResource = (LFResource) session.get(LFResourceImpl.class,
                        primaryKey);

                if (lfResource != null) {
                    cacheResult(lfResource);
                } else {
                    EntityCacheUtil.putResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
                        LFResourceImpl.class, primaryKey, _nullLFResource);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFResourceModelImpl.ENTITY_CACHE_ENABLED,
                    LFResourceImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfResource;
    }

    /**
     * Returns the l f resource with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f resource
     * @return the l f resource, or <code>null</code> if a l f resource with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFResource fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f resources.
     *
     * @return the l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f resources.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f resources
     * @param end the upper bound of the range of l f resources (not inclusive)
     * @return the range of l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f resources.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f resources
     * @param end the upper bound of the range of l f resources (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f resources
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFResource> findAll(int start, int end,
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

        List<LFResource> list = (List<LFResource>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFRESOURCE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFRESOURCE;

                if (pagination) {
                    sql = sql.concat(LFResourceModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFResource>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFResource>(list);
                } else {
                    list = (List<LFResource>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f resources from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFResource lfResource : findAll()) {
            remove(lfResource);
        }
    }

    /**
     * Returns the number of l f resources.
     *
     * @return the number of l f resources
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

                Query q = session.createQuery(_SQL_COUNT_LFRESOURCE);

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
     * Initializes the l f resource persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFResource")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFResource>> listenersList = new ArrayList<ModelListener<LFResource>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFResource>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFResourceImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

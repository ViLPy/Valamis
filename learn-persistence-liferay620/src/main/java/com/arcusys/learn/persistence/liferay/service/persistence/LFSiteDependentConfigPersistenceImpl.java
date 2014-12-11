package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException;
import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig;
import com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFSiteDependentConfigPersistence;

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
 * The persistence implementation for the l f site dependent config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSiteDependentConfigPersistence
 * @see LFSiteDependentConfigUtil
 * @generated
 */
public class LFSiteDependentConfigPersistenceImpl extends BasePersistenceImpl<LFSiteDependentConfig>
    implements LFSiteDependentConfigPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFSiteDependentConfigUtil} to access the l f site dependent config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFSiteDependentConfigImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SITEID = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySiteID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID =
        new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySiteID",
            new String[] { Integer.class.getName() },
            LFSiteDependentConfigModelImpl.SITEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SITEID = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySiteID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_SITEID_SITEID_NULL = "lfSiteDependentConfig.siteID IS NULL";
    private static final String _FINDER_COLUMN_SITEID_SITEID_2 = "lfSiteDependentConfig.siteID = ?";
    private static final String _FINDER_COLUMN_SITEID_SITEID_NULL_2 = "lfSiteDependentConfig.siteID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchBySiteIDAndDataKey",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFSiteDependentConfigModelImpl.SITEID_COLUMN_BITMASK |
            LFSiteDependentConfigModelImpl.DATAKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SITEIDANDDATAKEY = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countBySiteIDAndDataKey",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_NULL = "lfSiteDependentConfig.siteID IS NULL";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_2 = "lfSiteDependentConfig.siteID = ? AND ";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_NULL_2 = "lfSiteDependentConfig.siteID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_1 = "lfSiteDependentConfig.dataKey IS NULL";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_NULL = "lfSiteDependentConfig.dataKey IS NULL";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_2 = "lfSiteDependentConfig.dataKey = ?";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_NULL_2 = "lfSiteDependentConfig.dataKey IS NULL ";
    private static final String _FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_3 = "(lfSiteDependentConfig.dataKey IS NULL OR lfSiteDependentConfig.dataKey = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATAKEY = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataKey",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY =
        new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataKey",
            new String[] { String.class.getName() },
            LFSiteDependentConfigModelImpl.DATAKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DATAKEY = new FinderPath(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataKey",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_1 = "lfSiteDependentConfig.dataKey IS NULL";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_NULL = "lfSiteDependentConfig.dataKey IS NULL";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_2 = "lfSiteDependentConfig.dataKey = ?";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_NULL_2 = "lfSiteDependentConfig.dataKey IS NULL ";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_3 = "(lfSiteDependentConfig.dataKey IS NULL OR lfSiteDependentConfig.dataKey = '')";
    private static final String _SQL_SELECT_LFSITEDEPENDENTCONFIG = "SELECT lfSiteDependentConfig FROM LFSiteDependentConfig lfSiteDependentConfig";
    private static final String _SQL_SELECT_LFSITEDEPENDENTCONFIG_WHERE = "SELECT lfSiteDependentConfig FROM LFSiteDependentConfig lfSiteDependentConfig WHERE ";
    private static final String _SQL_COUNT_LFSITEDEPENDENTCONFIG = "SELECT COUNT(lfSiteDependentConfig) FROM LFSiteDependentConfig lfSiteDependentConfig";
    private static final String _SQL_COUNT_LFSITEDEPENDENTCONFIG_WHERE = "SELECT COUNT(lfSiteDependentConfig) FROM LFSiteDependentConfig lfSiteDependentConfig WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfSiteDependentConfig.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFSiteDependentConfig exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFSiteDependentConfig exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFSiteDependentConfigPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFSiteDependentConfig _nullLFSiteDependentConfig = new LFSiteDependentConfigImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFSiteDependentConfig> toCacheModel() {
                return _nullLFSiteDependentConfigCacheModel;
            }
        };

    private static CacheModel<LFSiteDependentConfig> _nullLFSiteDependentConfigCacheModel =
        new CacheModel<LFSiteDependentConfig>() {
            @Override
            public LFSiteDependentConfig toEntityModel() {
                return _nullLFSiteDependentConfig;
            }
        };

    public LFSiteDependentConfigPersistenceImpl() {
        setModelClass(LFSiteDependentConfig.class);
    }

    /**
     * Returns all the l f site dependent configs where siteID = &#63;.
     *
     * @param siteID the site i d
     * @return the matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findBySiteID(Integer siteID)
        throws SystemException {
        return findBySiteID(siteID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f site dependent configs where siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param siteID the site i d
     * @param start the lower bound of the range of l f site dependent configs
     * @param end the upper bound of the range of l f site dependent configs (not inclusive)
     * @return the range of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findBySiteID(Integer siteID, int start,
        int end) throws SystemException {
        return findBySiteID(siteID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f site dependent configs where siteID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param siteID the site i d
     * @param start the lower bound of the range of l f site dependent configs
     * @param end the upper bound of the range of l f site dependent configs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findBySiteID(Integer siteID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID;
            finderArgs = new Object[] { siteID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SITEID;
            finderArgs = new Object[] { siteID, start, end, orderByComparator };
        }

        List<LFSiteDependentConfig> list = (List<LFSiteDependentConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSiteDependentConfig lfSiteDependentConfig : list) {
                if (!Validator.equals(siteID, lfSiteDependentConfig.getSiteID())) {
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

            query.append(_SQL_SELECT_LFSITEDEPENDENTCONFIG_WHERE);

            if (siteID == null) {
                query.append(_FINDER_COLUMN_SITEID_SITEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SITEID_SITEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFSiteDependentConfigModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                if (!pagination) {
                    list = (List<LFSiteDependentConfig>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSiteDependentConfig>(list);
                } else {
                    list = (List<LFSiteDependentConfig>) QueryUtil.list(q,
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
     * Returns the first l f site dependent config in the ordered set where siteID = &#63;.
     *
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findBySiteID_First(Integer siteID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = fetchBySiteID_First(siteID,
                orderByComparator);

        if (lfSiteDependentConfig != null) {
            return lfSiteDependentConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("siteID=");
        msg.append(siteID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSiteDependentConfigException(msg.toString());
    }

    /**
     * Returns the first l f site dependent config in the ordered set where siteID = &#63;.
     *
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchBySiteID_First(Integer siteID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFSiteDependentConfig> list = findBySiteID(siteID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f site dependent config in the ordered set where siteID = &#63;.
     *
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findBySiteID_Last(Integer siteID,
        OrderByComparator orderByComparator)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = fetchBySiteID_Last(siteID,
                orderByComparator);

        if (lfSiteDependentConfig != null) {
            return lfSiteDependentConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("siteID=");
        msg.append(siteID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSiteDependentConfigException(msg.toString());
    }

    /**
     * Returns the last l f site dependent config in the ordered set where siteID = &#63;.
     *
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchBySiteID_Last(Integer siteID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBySiteID(siteID);

        if (count == 0) {
            return null;
        }

        List<LFSiteDependentConfig> list = findBySiteID(siteID, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f site dependent configs before and after the current l f site dependent config in the ordered set where siteID = &#63;.
     *
     * @param id the primary key of the current l f site dependent config
     * @param siteID the site i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig[] findBySiteID_PrevAndNext(long id,
        Integer siteID, OrderByComparator orderByComparator)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSiteDependentConfig[] array = new LFSiteDependentConfigImpl[3];

            array[0] = getBySiteID_PrevAndNext(session, lfSiteDependentConfig,
                    siteID, orderByComparator, true);

            array[1] = lfSiteDependentConfig;

            array[2] = getBySiteID_PrevAndNext(session, lfSiteDependentConfig,
                    siteID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSiteDependentConfig getBySiteID_PrevAndNext(Session session,
        LFSiteDependentConfig lfSiteDependentConfig, Integer siteID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSITEDEPENDENTCONFIG_WHERE);

        if (siteID == null) {
            query.append(_FINDER_COLUMN_SITEID_SITEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SITEID_SITEID_2);
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
            query.append(LFSiteDependentConfigModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (siteID != null) {
            qPos.add(siteID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfSiteDependentConfig);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSiteDependentConfig> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f site dependent configs where siteID = &#63; from the database.
     *
     * @param siteID the site i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySiteID(Integer siteID) throws SystemException {
        for (LFSiteDependentConfig lfSiteDependentConfig : findBySiteID(
                siteID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfSiteDependentConfig);
        }
    }

    /**
     * Returns the number of l f site dependent configs where siteID = &#63;.
     *
     * @param siteID the site i d
     * @return the number of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySiteID(Integer siteID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SITEID;

        Object[] finderArgs = new Object[] { siteID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSITEDEPENDENTCONFIG_WHERE);

            if (siteID == null) {
                query.append(_FINDER_COLUMN_SITEID_SITEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SITEID_SITEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (siteID != null) {
                    qPos.add(siteID.intValue());
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
     * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException} if it could not be found.
     *
     * @param siteID the site i d
     * @param dataKey the data key
     * @return the matching l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findBySiteIDAndDataKey(Integer siteID,
        String dataKey)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = fetchBySiteIDAndDataKey(siteID,
                dataKey);

        if (lfSiteDependentConfig == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("siteID=");
            msg.append(siteID);

            msg.append(", dataKey=");
            msg.append(dataKey);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFSiteDependentConfigException(msg.toString());
        }

        return lfSiteDependentConfig;
    }

    /**
     * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param siteID the site i d
     * @param dataKey the data key
     * @return the matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchBySiteIDAndDataKey(Integer siteID,
        String dataKey) throws SystemException {
        return fetchBySiteIDAndDataKey(siteID, dataKey, true);
    }

    /**
     * Returns the l f site dependent config where siteID = &#63; and dataKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param siteID the site i d
     * @param dataKey the data key
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchBySiteIDAndDataKey(Integer siteID,
        String dataKey, boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { siteID, dataKey };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                    finderArgs, this);
        }

        if (result instanceof LFSiteDependentConfig) {
            LFSiteDependentConfig lfSiteDependentConfig = (LFSiteDependentConfig) result;

            if (!Validator.equals(siteID, lfSiteDependentConfig.getSiteID()) ||
                    !Validator.equals(dataKey,
                        lfSiteDependentConfig.getDataKey())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFSITEDEPENDENTCONFIG_WHERE);

            if (siteID == null) {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_2);
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
                    }
                }

                List<LFSiteDependentConfig> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFSiteDependentConfigPersistenceImpl.fetchBySiteIDAndDataKey(Integer, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFSiteDependentConfig lfSiteDependentConfig = list.get(0);

                    result = lfSiteDependentConfig;

                    cacheResult(lfSiteDependentConfig);

                    if ((lfSiteDependentConfig.getSiteID() != siteID) ||
                            (lfSiteDependentConfig.getDataKey() == null) ||
                            !lfSiteDependentConfig.getDataKey().equals(dataKey)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                            finderArgs, lfSiteDependentConfig);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFSiteDependentConfig) result;
        }
    }

    /**
     * Removes the l f site dependent config where siteID = &#63; and dataKey = &#63; from the database.
     *
     * @param siteID the site i d
     * @param dataKey the data key
     * @return the l f site dependent config that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig removeBySiteIDAndDataKey(Integer siteID,
        String dataKey)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = findBySiteIDAndDataKey(siteID,
                dataKey);

        return remove(lfSiteDependentConfig);
    }

    /**
     * Returns the number of l f site dependent configs where siteID = &#63; and dataKey = &#63;.
     *
     * @param siteID the site i d
     * @param dataKey the data key
     * @return the number of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySiteIDAndDataKey(Integer siteID, String dataKey)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SITEIDANDDATAKEY;

        Object[] finderArgs = new Object[] { siteID, dataKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFSITEDEPENDENTCONFIG_WHERE);

            if (siteID == null) {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_SITEID_2);
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_SITEIDANDDATAKEY_DATAKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (siteID != null) {
                    qPos.add(siteID.intValue());
                }

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
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
     * Returns all the l f site dependent configs where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @return the matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findByDataKey(String dataKey)
        throws SystemException {
        return findByDataKey(dataKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f site dependent configs where dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataKey the data key
     * @param start the lower bound of the range of l f site dependent configs
     * @param end the upper bound of the range of l f site dependent configs (not inclusive)
     * @return the range of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findByDataKey(String dataKey, int start,
        int end) throws SystemException {
        return findByDataKey(dataKey, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f site dependent configs where dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataKey the data key
     * @param start the lower bound of the range of l f site dependent configs
     * @param end the upper bound of the range of l f site dependent configs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findByDataKey(String dataKey, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY;
            finderArgs = new Object[] { dataKey };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATAKEY;
            finderArgs = new Object[] { dataKey, start, end, orderByComparator };
        }

        List<LFSiteDependentConfig> list = (List<LFSiteDependentConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFSiteDependentConfig lfSiteDependentConfig : list) {
                if (!Validator.equals(dataKey,
                            lfSiteDependentConfig.getDataKey())) {
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

            query.append(_SQL_SELECT_LFSITEDEPENDENTCONFIG_WHERE);

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFSiteDependentConfigModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
                    }
                }

                if (!pagination) {
                    list = (List<LFSiteDependentConfig>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSiteDependentConfig>(list);
                } else {
                    list = (List<LFSiteDependentConfig>) QueryUtil.list(q,
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
     * Returns the first l f site dependent config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findByDataKey_First(String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = fetchByDataKey_First(dataKey,
                orderByComparator);

        if (lfSiteDependentConfig != null) {
            return lfSiteDependentConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSiteDependentConfigException(msg.toString());
    }

    /**
     * Returns the first l f site dependent config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchByDataKey_First(String dataKey,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFSiteDependentConfig> list = findByDataKey(dataKey, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f site dependent config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findByDataKey_Last(String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = fetchByDataKey_Last(dataKey,
                orderByComparator);

        if (lfSiteDependentConfig != null) {
            return lfSiteDependentConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFSiteDependentConfigException(msg.toString());
    }

    /**
     * Returns the last l f site dependent config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f site dependent config, or <code>null</code> if a matching l f site dependent config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchByDataKey_Last(String dataKey,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDataKey(dataKey);

        if (count == 0) {
            return null;
        }

        List<LFSiteDependentConfig> list = findByDataKey(dataKey, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f site dependent configs before and after the current l f site dependent config in the ordered set where dataKey = &#63;.
     *
     * @param id the primary key of the current l f site dependent config
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig[] findByDataKey_PrevAndNext(long id,
        String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFSiteDependentConfig[] array = new LFSiteDependentConfigImpl[3];

            array[0] = getByDataKey_PrevAndNext(session, lfSiteDependentConfig,
                    dataKey, orderByComparator, true);

            array[1] = lfSiteDependentConfig;

            array[2] = getByDataKey_PrevAndNext(session, lfSiteDependentConfig,
                    dataKey, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFSiteDependentConfig getByDataKey_PrevAndNext(Session session,
        LFSiteDependentConfig lfSiteDependentConfig, String dataKey,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFSITEDEPENDENTCONFIG_WHERE);

        boolean bindDataKey = false;

        if (dataKey == null) {
            query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_1);
        } else if (dataKey.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_3);
        } else {
            bindDataKey = true;

            if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_3);
            } else {
                query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_2);
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
            query.append(LFSiteDependentConfigModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindDataKey) {
            if (dataKey != null) {
                qPos.add(dataKey);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfSiteDependentConfig);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFSiteDependentConfig> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f site dependent configs where dataKey = &#63; from the database.
     *
     * @param dataKey the data key
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDataKey(String dataKey) throws SystemException {
        for (LFSiteDependentConfig lfSiteDependentConfig : findByDataKey(
                dataKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfSiteDependentConfig);
        }
    }

    /**
     * Returns the number of l f site dependent configs where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @return the number of matching l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDataKey(String dataKey) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DATAKEY;

        Object[] finderArgs = new Object[] { dataKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFSITEDEPENDENTCONFIG_WHERE);

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_DATAKEY_DATAKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
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
     * Caches the l f site dependent config in the entity cache if it is enabled.
     *
     * @param lfSiteDependentConfig the l f site dependent config
     */
    @Override
    public void cacheResult(LFSiteDependentConfig lfSiteDependentConfig) {
        EntityCacheUtil.putResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            lfSiteDependentConfig.getPrimaryKey(), lfSiteDependentConfig);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
            new Object[] {
                lfSiteDependentConfig.getSiteID(),
                lfSiteDependentConfig.getDataKey()
            }, lfSiteDependentConfig);

        lfSiteDependentConfig.resetOriginalValues();
    }

    /**
     * Caches the l f site dependent configs in the entity cache if it is enabled.
     *
     * @param lfSiteDependentConfigs the l f site dependent configs
     */
    @Override
    public void cacheResult(List<LFSiteDependentConfig> lfSiteDependentConfigs) {
        for (LFSiteDependentConfig lfSiteDependentConfig : lfSiteDependentConfigs) {
            if (EntityCacheUtil.getResult(
                        LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
                        LFSiteDependentConfigImpl.class,
                        lfSiteDependentConfig.getPrimaryKey()) == null) {
                cacheResult(lfSiteDependentConfig);
            } else {
                lfSiteDependentConfig.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f site dependent configs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFSiteDependentConfigImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFSiteDependentConfigImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f site dependent config.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFSiteDependentConfig lfSiteDependentConfig) {
        EntityCacheUtil.removeResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            lfSiteDependentConfig.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfSiteDependentConfig);
    }

    @Override
    public void clearCache(List<LFSiteDependentConfig> lfSiteDependentConfigs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFSiteDependentConfig lfSiteDependentConfig : lfSiteDependentConfigs) {
            EntityCacheUtil.removeResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
                LFSiteDependentConfigImpl.class,
                lfSiteDependentConfig.getPrimaryKey());

            clearUniqueFindersCache(lfSiteDependentConfig);
        }
    }

    protected void cacheUniqueFindersCache(
        LFSiteDependentConfig lfSiteDependentConfig) {
        if (lfSiteDependentConfig.isNew()) {
            Object[] args = new Object[] {
                    lfSiteDependentConfig.getSiteID(),
                    lfSiteDependentConfig.getDataKey()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SITEIDANDDATAKEY,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                args, lfSiteDependentConfig);
        } else {
            LFSiteDependentConfigModelImpl lfSiteDependentConfigModelImpl = (LFSiteDependentConfigModelImpl) lfSiteDependentConfig;

            if ((lfSiteDependentConfigModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSiteDependentConfig.getSiteID(),
                        lfSiteDependentConfig.getDataKey()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SITEIDANDDATAKEY,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                    args, lfSiteDependentConfig);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFSiteDependentConfig lfSiteDependentConfig) {
        LFSiteDependentConfigModelImpl lfSiteDependentConfigModelImpl = (LFSiteDependentConfigModelImpl) lfSiteDependentConfig;

        Object[] args = new Object[] {
                lfSiteDependentConfig.getSiteID(),
                lfSiteDependentConfig.getDataKey()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SITEIDANDDATAKEY, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY, args);

        if ((lfSiteDependentConfigModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfSiteDependentConfigModelImpl.getOriginalSiteID(),
                    lfSiteDependentConfigModelImpl.getOriginalDataKey()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SITEIDANDDATAKEY,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SITEIDANDDATAKEY,
                args);
        }
    }

    /**
     * Creates a new l f site dependent config with the primary key. Does not add the l f site dependent config to the database.
     *
     * @param id the primary key for the new l f site dependent config
     * @return the new l f site dependent config
     */
    @Override
    public LFSiteDependentConfig create(long id) {
        LFSiteDependentConfig lfSiteDependentConfig = new LFSiteDependentConfigImpl();

        lfSiteDependentConfig.setNew(true);
        lfSiteDependentConfig.setPrimaryKey(id);

        return lfSiteDependentConfig;
    }

    /**
     * Removes the l f site dependent config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f site dependent config
     * @return the l f site dependent config that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig remove(long id)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f site dependent config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f site dependent config
     * @return the l f site dependent config that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig remove(Serializable primaryKey)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFSiteDependentConfig lfSiteDependentConfig = (LFSiteDependentConfig) session.get(LFSiteDependentConfigImpl.class,
                    primaryKey);

            if (lfSiteDependentConfig == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFSiteDependentConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfSiteDependentConfig);
        } catch (NoSuchLFSiteDependentConfigException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFSiteDependentConfig removeImpl(
        LFSiteDependentConfig lfSiteDependentConfig) throws SystemException {
        lfSiteDependentConfig = toUnwrappedModel(lfSiteDependentConfig);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfSiteDependentConfig)) {
                lfSiteDependentConfig = (LFSiteDependentConfig) session.get(LFSiteDependentConfigImpl.class,
                        lfSiteDependentConfig.getPrimaryKeyObj());
            }

            if (lfSiteDependentConfig != null) {
                session.delete(lfSiteDependentConfig);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfSiteDependentConfig != null) {
            clearCache(lfSiteDependentConfig);
        }

        return lfSiteDependentConfig;
    }

    @Override
    public LFSiteDependentConfig updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig)
        throws SystemException {
        lfSiteDependentConfig = toUnwrappedModel(lfSiteDependentConfig);

        boolean isNew = lfSiteDependentConfig.isNew();

        LFSiteDependentConfigModelImpl lfSiteDependentConfigModelImpl = (LFSiteDependentConfigModelImpl) lfSiteDependentConfig;

        Session session = null;

        try {
            session = openSession();

            if (lfSiteDependentConfig.isNew()) {
                session.save(lfSiteDependentConfig);

                lfSiteDependentConfig.setNew(false);
            } else {
                session.merge(lfSiteDependentConfig);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFSiteDependentConfigModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfSiteDependentConfigModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSiteDependentConfigModelImpl.getOriginalSiteID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SITEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID,
                    args);

                args = new Object[] { lfSiteDependentConfigModelImpl.getSiteID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SITEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SITEID,
                    args);
            }

            if ((lfSiteDependentConfigModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfSiteDependentConfigModelImpl.getOriginalDataKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAKEY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY,
                    args);

                args = new Object[] { lfSiteDependentConfigModelImpl.getDataKey() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAKEY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFSiteDependentConfigImpl.class,
            lfSiteDependentConfig.getPrimaryKey(), lfSiteDependentConfig);

        clearUniqueFindersCache(lfSiteDependentConfig);
        cacheUniqueFindersCache(lfSiteDependentConfig);

        return lfSiteDependentConfig;
    }

    protected LFSiteDependentConfig toUnwrappedModel(
        LFSiteDependentConfig lfSiteDependentConfig) {
        if (lfSiteDependentConfig instanceof LFSiteDependentConfigImpl) {
            return lfSiteDependentConfig;
        }

        LFSiteDependentConfigImpl lfSiteDependentConfigImpl = new LFSiteDependentConfigImpl();

        lfSiteDependentConfigImpl.setNew(lfSiteDependentConfig.isNew());
        lfSiteDependentConfigImpl.setPrimaryKey(lfSiteDependentConfig.getPrimaryKey());

        lfSiteDependentConfigImpl.setId(lfSiteDependentConfig.getId());
        lfSiteDependentConfigImpl.setSiteID(lfSiteDependentConfig.getSiteID());
        lfSiteDependentConfigImpl.setDataKey(lfSiteDependentConfig.getDataKey());
        lfSiteDependentConfigImpl.setDataValue(lfSiteDependentConfig.getDataValue());

        return lfSiteDependentConfigImpl;
    }

    /**
     * Returns the l f site dependent config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f site dependent config
     * @return the l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = fetchByPrimaryKey(primaryKey);

        if (lfSiteDependentConfig == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFSiteDependentConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfSiteDependentConfig;
    }

    /**
     * Returns the l f site dependent config with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException} if it could not be found.
     *
     * @param id the primary key of the l f site dependent config
     * @return the l f site dependent config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig findByPrimaryKey(long id)
        throws NoSuchLFSiteDependentConfigException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f site dependent config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f site dependent config
     * @return the l f site dependent config, or <code>null</code> if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFSiteDependentConfig lfSiteDependentConfig = (LFSiteDependentConfig) EntityCacheUtil.getResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
                LFSiteDependentConfigImpl.class, primaryKey);

        if (lfSiteDependentConfig == _nullLFSiteDependentConfig) {
            return null;
        }

        if (lfSiteDependentConfig == null) {
            Session session = null;

            try {
                session = openSession();

                lfSiteDependentConfig = (LFSiteDependentConfig) session.get(LFSiteDependentConfigImpl.class,
                        primaryKey);

                if (lfSiteDependentConfig != null) {
                    cacheResult(lfSiteDependentConfig);
                } else {
                    EntityCacheUtil.putResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
                        LFSiteDependentConfigImpl.class, primaryKey,
                        _nullLFSiteDependentConfig);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFSiteDependentConfigModelImpl.ENTITY_CACHE_ENABLED,
                    LFSiteDependentConfigImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfSiteDependentConfig;
    }

    /**
     * Returns the l f site dependent config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f site dependent config
     * @return the l f site dependent config, or <code>null</code> if a l f site dependent config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFSiteDependentConfig fetchByPrimaryKey(long id)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f site dependent configs.
     *
     * @return the l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f site dependent configs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f site dependent configs
     * @param end the upper bound of the range of l f site dependent configs (not inclusive)
     * @return the range of l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f site dependent configs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f site dependent configs
     * @param end the upper bound of the range of l f site dependent configs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f site dependent configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFSiteDependentConfig> findAll(int start, int end,
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

        List<LFSiteDependentConfig> list = (List<LFSiteDependentConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFSITEDEPENDENTCONFIG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFSITEDEPENDENTCONFIG;

                if (pagination) {
                    sql = sql.concat(LFSiteDependentConfigModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFSiteDependentConfig>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFSiteDependentConfig>(list);
                } else {
                    list = (List<LFSiteDependentConfig>) QueryUtil.list(q,
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
     * Removes all the l f site dependent configs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFSiteDependentConfig lfSiteDependentConfig : findAll()) {
            remove(lfSiteDependentConfig);
        }
    }

    /**
     * Returns the number of l f site dependent configs.
     *
     * @return the number of l f site dependent configs
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

                Query q = session.createQuery(_SQL_COUNT_LFSITEDEPENDENTCONFIG);

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
     * Initializes the l f site dependent config persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFSiteDependentConfig>> listenersList = new ArrayList<ModelListener<LFSiteDependentConfig>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFSiteDependentConfig>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFSiteDependentConfigImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

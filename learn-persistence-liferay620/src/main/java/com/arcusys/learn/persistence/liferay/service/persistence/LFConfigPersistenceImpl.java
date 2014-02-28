package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFConfigException;
import com.arcusys.learn.persistence.liferay.model.LFConfig;
import com.arcusys.learn.persistence.liferay.model.impl.LFConfigImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFConfigModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFConfigPersistence;

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
 * The persistence implementation for the l f config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConfigPersistence
 * @see LFConfigUtil
 * @generated
 */
public class LFConfigPersistenceImpl extends BasePersistenceImpl<LFConfig>
    implements LFConfigPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFConfigUtil} to access the l f config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFConfigImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigModelImpl.FINDER_CACHE_ENABLED, LFConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigModelImpl.FINDER_CACHE_ENABLED, LFConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATAKEY = new FinderPath(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigModelImpl.FINDER_CACHE_ENABLED, LFConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataKey",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY =
        new FinderPath(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigModelImpl.FINDER_CACHE_ENABLED, LFConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataKey",
            new String[] { String.class.getName() },
            LFConfigModelImpl.DATAKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DATAKEY = new FinderPath(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataKey",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_1 = "lfConfig.dataKey IS NULL";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_NULL = "lfConfig.dataKey IS NULL";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_2 = "lfConfig.dataKey = ?";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_NULL_2 = "lfConfig.dataKey IS NULL ";
    private static final String _FINDER_COLUMN_DATAKEY_DATAKEY_3 = "(lfConfig.dataKey IS NULL OR lfConfig.dataKey = '')";
    private static final String _SQL_SELECT_LFCONFIG = "SELECT lfConfig FROM LFConfig lfConfig";
    private static final String _SQL_SELECT_LFCONFIG_WHERE = "SELECT lfConfig FROM LFConfig lfConfig WHERE ";
    private static final String _SQL_COUNT_LFCONFIG = "SELECT COUNT(lfConfig) FROM LFConfig lfConfig";
    private static final String _SQL_COUNT_LFCONFIG_WHERE = "SELECT COUNT(lfConfig) FROM LFConfig lfConfig WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfConfig.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFConfig exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFConfig exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFConfigPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFConfig _nullLFConfig = new LFConfigImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFConfig> toCacheModel() {
                return _nullLFConfigCacheModel;
            }
        };

    private static CacheModel<LFConfig> _nullLFConfigCacheModel = new CacheModel<LFConfig>() {
            @Override
            public LFConfig toEntityModel() {
                return _nullLFConfig;
            }
        };

    public LFConfigPersistenceImpl() {
        setModelClass(LFConfig.class);
    }

    /**
     * Returns all the l f configs where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @return the matching l f configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConfig> findByDataKey(String dataKey)
        throws SystemException {
        return findByDataKey(dataKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f configs where dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataKey the data key
     * @param start the lower bound of the range of l f configs
     * @param end the upper bound of the range of l f configs (not inclusive)
     * @return the range of matching l f configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConfig> findByDataKey(String dataKey, int start, int end)
        throws SystemException {
        return findByDataKey(dataKey, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f configs where dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dataKey the data key
     * @param start the lower bound of the range of l f configs
     * @param end the upper bound of the range of l f configs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConfig> findByDataKey(String dataKey, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
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

        List<LFConfig> list = (List<LFConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFConfig lfConfig : list) {
                if (!Validator.equals(dataKey, lfConfig.getDataKey())) {
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

            query.append(_SQL_SELECT_LFCONFIG_WHERE);

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
                query.append(LFConfigModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFConfig>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFConfig>(list);
                } else {
                    list = (List<LFConfig>) QueryUtil.list(q, getDialect(),
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
     * Returns the first l f config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a matching l f config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig findByDataKey_First(String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFConfigException, SystemException {
        LFConfig lfConfig = fetchByDataKey_First(dataKey, orderByComparator);

        if (lfConfig != null) {
            return lfConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFConfigException(msg.toString());
    }

    /**
     * Returns the first l f config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f config, or <code>null</code> if a matching l f config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig fetchByDataKey_First(String dataKey,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFConfig> list = findByDataKey(dataKey, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a matching l f config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig findByDataKey_Last(String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFConfigException, SystemException {
        LFConfig lfConfig = fetchByDataKey_Last(dataKey, orderByComparator);

        if (lfConfig != null) {
            return lfConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFConfigException(msg.toString());
    }

    /**
     * Returns the last l f config in the ordered set where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f config, or <code>null</code> if a matching l f config could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig fetchByDataKey_Last(String dataKey,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDataKey(dataKey);

        if (count == 0) {
            return null;
        }

        List<LFConfig> list = findByDataKey(dataKey, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f configs before and after the current l f config in the ordered set where dataKey = &#63;.
     *
     * @param id the primary key of the current l f config
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig[] findByDataKey_PrevAndNext(long id, String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFConfigException, SystemException {
        LFConfig lfConfig = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFConfig[] array = new LFConfigImpl[3];

            array[0] = getByDataKey_PrevAndNext(session, lfConfig, dataKey,
                    orderByComparator, true);

            array[1] = lfConfig;

            array[2] = getByDataKey_PrevAndNext(session, lfConfig, dataKey,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFConfig getByDataKey_PrevAndNext(Session session,
        LFConfig lfConfig, String dataKey, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCONFIG_WHERE);

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
            query.append(LFConfigModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfConfig);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFConfig> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f configs where dataKey = &#63; from the database.
     *
     * @param dataKey the data key
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDataKey(String dataKey) throws SystemException {
        for (LFConfig lfConfig : findByDataKey(dataKey, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(lfConfig);
        }
    }

    /**
     * Returns the number of l f configs where dataKey = &#63;.
     *
     * @param dataKey the data key
     * @return the number of matching l f configs
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

            query.append(_SQL_COUNT_LFCONFIG_WHERE);

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
     * Caches the l f config in the entity cache if it is enabled.
     *
     * @param lfConfig the l f config
     */
    @Override
    public void cacheResult(LFConfig lfConfig) {
        EntityCacheUtil.putResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigImpl.class, lfConfig.getPrimaryKey(), lfConfig);

        lfConfig.resetOriginalValues();
    }

    /**
     * Caches the l f configs in the entity cache if it is enabled.
     *
     * @param lfConfigs the l f configs
     */
    @Override
    public void cacheResult(List<LFConfig> lfConfigs) {
        for (LFConfig lfConfig : lfConfigs) {
            if (EntityCacheUtil.getResult(
                        LFConfigModelImpl.ENTITY_CACHE_ENABLED,
                        LFConfigImpl.class, lfConfig.getPrimaryKey()) == null) {
                cacheResult(lfConfig);
            } else {
                lfConfig.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f configs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFConfigImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFConfigImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f config.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFConfig lfConfig) {
        EntityCacheUtil.removeResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigImpl.class, lfConfig.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFConfig> lfConfigs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFConfig lfConfig : lfConfigs) {
            EntityCacheUtil.removeResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
                LFConfigImpl.class, lfConfig.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f config with the primary key. Does not add the l f config to the database.
     *
     * @param id the primary key for the new l f config
     * @return the new l f config
     */
    @Override
    public LFConfig create(long id) {
        LFConfig lfConfig = new LFConfigImpl();

        lfConfig.setNew(true);
        lfConfig.setPrimaryKey(id);

        return lfConfig;
    }

    /**
     * Removes the l f config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f config
     * @return the l f config that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig remove(long id)
        throws NoSuchLFConfigException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f config
     * @return the l f config that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig remove(Serializable primaryKey)
        throws NoSuchLFConfigException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFConfig lfConfig = (LFConfig) session.get(LFConfigImpl.class,
                    primaryKey);

            if (lfConfig == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfConfig);
        } catch (NoSuchLFConfigException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFConfig removeImpl(LFConfig lfConfig) throws SystemException {
        lfConfig = toUnwrappedModel(lfConfig);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfConfig)) {
                lfConfig = (LFConfig) session.get(LFConfigImpl.class,
                        lfConfig.getPrimaryKeyObj());
            }

            if (lfConfig != null) {
                session.delete(lfConfig);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfConfig != null) {
            clearCache(lfConfig);
        }

        return lfConfig;
    }

    @Override
    public LFConfig updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFConfig lfConfig)
        throws SystemException {
        lfConfig = toUnwrappedModel(lfConfig);

        boolean isNew = lfConfig.isNew();

        LFConfigModelImpl lfConfigModelImpl = (LFConfigModelImpl) lfConfig;

        Session session = null;

        try {
            session = openSession();

            if (lfConfig.isNew()) {
                session.save(lfConfig);

                lfConfig.setNew(false);
            } else {
                session.merge(lfConfig);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFConfigModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfConfigModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfConfigModelImpl.getOriginalDataKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAKEY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY,
                    args);

                args = new Object[] { lfConfigModelImpl.getDataKey() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATAKEY, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATAKEY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
            LFConfigImpl.class, lfConfig.getPrimaryKey(), lfConfig);

        return lfConfig;
    }

    protected LFConfig toUnwrappedModel(LFConfig lfConfig) {
        if (lfConfig instanceof LFConfigImpl) {
            return lfConfig;
        }

        LFConfigImpl lfConfigImpl = new LFConfigImpl();

        lfConfigImpl.setNew(lfConfig.isNew());
        lfConfigImpl.setPrimaryKey(lfConfig.getPrimaryKey());

        lfConfigImpl.setId(lfConfig.getId());
        lfConfigImpl.setDataKey(lfConfig.getDataKey());
        lfConfigImpl.setDataValue(lfConfig.getDataValue());

        return lfConfigImpl;
    }

    /**
     * Returns the l f config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f config
     * @return the l f config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFConfigException, SystemException {
        LFConfig lfConfig = fetchByPrimaryKey(primaryKey);

        if (lfConfig == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfConfig;
    }

    /**
     * Returns the l f config with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFConfigException} if it could not be found.
     *
     * @param id the primary key of the l f config
     * @return the l f config
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConfigException if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig findByPrimaryKey(long id)
        throws NoSuchLFConfigException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f config
     * @return the l f config, or <code>null</code> if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFConfig lfConfig = (LFConfig) EntityCacheUtil.getResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
                LFConfigImpl.class, primaryKey);

        if (lfConfig == _nullLFConfig) {
            return null;
        }

        if (lfConfig == null) {
            Session session = null;

            try {
                session = openSession();

                lfConfig = (LFConfig) session.get(LFConfigImpl.class, primaryKey);

                if (lfConfig != null) {
                    cacheResult(lfConfig);
                } else {
                    EntityCacheUtil.putResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
                        LFConfigImpl.class, primaryKey, _nullLFConfig);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFConfigModelImpl.ENTITY_CACHE_ENABLED,
                    LFConfigImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfConfig;
    }

    /**
     * Returns the l f config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f config
     * @return the l f config, or <code>null</code> if a l f config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFConfig fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f configs.
     *
     * @return the l f configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConfig> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f configs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f configs
     * @param end the upper bound of the range of l f configs (not inclusive)
     * @return the range of l f configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConfig> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f configs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f configs
     * @param end the upper bound of the range of l f configs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFConfig> findAll(int start, int end,
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

        List<LFConfig> list = (List<LFConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCONFIG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCONFIG;

                if (pagination) {
                    sql = sql.concat(LFConfigModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFConfig>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFConfig>(list);
                } else {
                    list = (List<LFConfig>) QueryUtil.list(q, getDialect(),
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
     * Removes all the l f configs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFConfig lfConfig : findAll()) {
            remove(lfConfig);
        }
    }

    /**
     * Returns the number of l f configs.
     *
     * @return the number of l f configs
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

                Query q = session.createQuery(_SQL_COUNT_LFCONFIG);

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
     * Initializes the l f config persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFConfig")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFConfig>> listenersList = new ArrayList<ModelListener<LFConfig>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFConfig>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFConfigImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException;
import com.arcusys.learn.persistence.liferay.model.LFAttemptData;
import com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFAttemptDataPersistence;

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
import com.liferay.portal.kernel.util.CharPool;
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
 * The persistence implementation for the l f attempt data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptDataPersistence
 * @see LFAttemptDataUtil
 * @generated
 */
public class LFAttemptDataPersistenceImpl extends BasePersistenceImpl<LFAttemptData>
    implements LFAttemptDataPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFAttemptDataUtil} to access the l f attempt data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFAttemptDataImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAttemptIDWithActivityID",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAttemptIDWithActivityID",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFAttemptDataModelImpl.ATTEMPTID_COLUMN_BITMASK |
            LFAttemptDataModelImpl.ACTIVITYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTEMPTIDWITHACTIVITYID = new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAttemptIDWithActivityID",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_NULL =
        "lfAttemptData.attemptID IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_2 =
        "lfAttemptData.attemptID = ? AND ";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_NULL_2 =
        "lfAttemptData.attemptID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_1 =
        "lfAttemptData.activityID IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_NULL =
        "lfAttemptData.activityID IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_2 =
        "lfAttemptData.activityID = ?";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_NULL_2 =
        "lfAttemptData.activityID IS NULL ";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3 =
        "(lfAttemptData.activityID IS NULL OR lfAttemptData.activityID = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAttemptIDWithDataKey",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAttemptIDWithDataKey",
            new String[] { Integer.class.getName(), String.class.getName() },
            LFAttemptDataModelImpl.ATTEMPTID_COLUMN_BITMASK |
            LFAttemptDataModelImpl.DATAKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTEMPTIDWITHDATAKEY = new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAttemptIDWithDataKey",
            new String[] { Integer.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_NULL =
        "lfAttemptData.attemptID IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_2 = "lfAttemptData.attemptID = ? AND ";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_NULL_2 =
        "lfAttemptData.attemptID IS NULL  AND ";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_1 = "lfAttemptData.dataKey IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_NULL =
        "lfAttemptData.dataKey IS NULL";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_2 = "lfAttemptData.dataKey = ?";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_NULL_2 =
        "lfAttemptData.dataKey IS NULL ";
    private static final String _FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3 = "(lfAttemptData.dataKey IS NULL OR lfAttemptData.dataKey = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SINGLEKEY =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBySingleKey",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SINGLEKEY =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findBySingleKey",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            },
            LFAttemptDataModelImpl.ATTEMPTID_COLUMN_BITMASK |
            LFAttemptDataModelImpl.ACTIVITYID_COLUMN_BITMASK |
            LFAttemptDataModelImpl.DATAKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SINGLEKEY = new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySingleKey",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_SINGLEKEY_ATTEMPTID_NULL = "lfAttemptData.attemptID IS NULL";
    private static final String _FINDER_COLUMN_SINGLEKEY_ATTEMPTID_2 = "lfAttemptData.attemptID = ? AND ";
    private static final String _FINDER_COLUMN_SINGLEKEY_ATTEMPTID_NULL_2 = "lfAttemptData.attemptID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SINGLEKEY_ACTIVITYID_1 = "lfAttemptData.activityID IS NULL AND ";
    private static final String _FINDER_COLUMN_SINGLEKEY_ACTIVITYID_NULL = "lfAttemptData.activityID IS NULL";
    private static final String _FINDER_COLUMN_SINGLEKEY_ACTIVITYID_2 = "lfAttemptData.activityID = ? AND ";
    private static final String _FINDER_COLUMN_SINGLEKEY_ACTIVITYID_NULL_2 = "lfAttemptData.activityID IS NULL  AND ";
    private static final String _FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3 = "(lfAttemptData.activityID IS NULL OR lfAttemptData.activityID = '') AND ";
    private static final String _FINDER_COLUMN_SINGLEKEY_DATAKEY_1 = "lfAttemptData.dataKey IS NULL";
    private static final String _FINDER_COLUMN_SINGLEKEY_DATAKEY_NULL = "lfAttemptData.dataKey IS NULL";
    private static final String _FINDER_COLUMN_SINGLEKEY_DATAKEY_2 = "lfAttemptData.dataKey = ?";
    private static final String _FINDER_COLUMN_SINGLEKEY_DATAKEY_NULL_2 = "lfAttemptData.dataKey IS NULL ";
    private static final String _FINDER_COLUMN_SINGLEKEY_DATAKEY_3 = "(lfAttemptData.dataKey IS NULL OR lfAttemptData.dataKey = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONVALUES =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED,
            LFAttemptDataImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByCollectionValues",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_COLLECTIONVALUES =
        new FinderPath(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByCollectionValues",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                String.class.getName()
            });
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_NULL = "lfAttemptData.attemptID IS NULL";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_2 = "lfAttemptData.attemptID = ? AND ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_NULL_2 =
        "lfAttemptData.attemptID IS NULL  AND ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_1 = "lfAttemptData.activityID IS NULL AND ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_NULL = "lfAttemptData.activityID IS NULL";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_2 = "lfAttemptData.activityID = ? AND ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_NULL_2 =
        "lfAttemptData.activityID IS NULL  AND ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3 = "(lfAttemptData.activityID IS NULL OR lfAttemptData.activityID = '') AND ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_1 = "lfAttemptData.dataKey LIKE NULL";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_NULL = "lfAttemptData.dataKey IS NULL";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_2 = "lfAttemptData.dataKey LIKE ?";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_NULL_2 = "lfAttemptData.dataKey IS NULL ";
    private static final String _FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3 = "(lfAttemptData.dataKey IS NULL OR lfAttemptData.dataKey LIKE '')";
    private static final String _SQL_SELECT_LFATTEMPTDATA = "SELECT lfAttemptData FROM LFAttemptData lfAttemptData";
    private static final String _SQL_SELECT_LFATTEMPTDATA_WHERE = "SELECT lfAttemptData FROM LFAttemptData lfAttemptData WHERE ";
    private static final String _SQL_COUNT_LFATTEMPTDATA = "SELECT COUNT(lfAttemptData) FROM LFAttemptData lfAttemptData";
    private static final String _SQL_COUNT_LFATTEMPTDATA_WHERE = "SELECT COUNT(lfAttemptData) FROM LFAttemptData lfAttemptData WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfAttemptData.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFAttemptData exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFAttemptData exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFAttemptDataPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static LFAttemptData _nullLFAttemptData = new LFAttemptDataImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFAttemptData> toCacheModel() {
                return _nullLFAttemptDataCacheModel;
            }
        };

    private static CacheModel<LFAttemptData> _nullLFAttemptDataCacheModel = new CacheModel<LFAttemptData>() {
            @Override
            public LFAttemptData toEntityModel() {
                return _nullLFAttemptData;
            }
        };

    public LFAttemptDataPersistenceImpl() {
        setModelClass(LFAttemptData.class);
    }

    /**
     * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @return the matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByAttemptIDWithActivityID(
        Integer attemptID, String activityID) throws SystemException {
        return findByAttemptIDWithActivityID(attemptID, activityID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @return the range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByAttemptIDWithActivityID(
        Integer attemptID, String activityID, int start, int end)
        throws SystemException {
        return findByAttemptIDWithActivityID(attemptID, activityID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByAttemptIDWithActivityID(
        Integer attemptID, String activityID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID;
            finderArgs = new Object[] { attemptID, activityID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID;
            finderArgs = new Object[] {
                    attemptID, activityID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFAttemptData> list = (List<LFAttemptData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttemptData lfAttemptData : list) {
                if (!Validator.equals(attemptID, lfAttemptData.getAttemptID()) ||
                        !Validator.equals(activityID,
                            lfAttemptData.getActivityID())) {
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

            query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
                }

                if (!pagination) {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAttemptData>(list);
                } else {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
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
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByAttemptIDWithActivityID_First(
        Integer attemptID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByAttemptIDWithActivityID_First(attemptID,
                activityID, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByAttemptIDWithActivityID_First(
        Integer attemptID, String activityID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFAttemptData> list = findByAttemptIDWithActivityID(attemptID,
                activityID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByAttemptIDWithActivityID_Last(Integer attemptID,
        String activityID, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByAttemptIDWithActivityID_Last(attemptID,
                activityID, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByAttemptIDWithActivityID_Last(
        Integer attemptID, String activityID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAttemptIDWithActivityID(attemptID, activityID);

        if (count == 0) {
            return null;
        }

        List<LFAttemptData> list = findByAttemptIDWithActivityID(attemptID,
                activityID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63;.
     *
     * @param id the primary key of the current l f attempt data
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData[] findByAttemptIDWithActivityID_PrevAndNext(long id,
        Integer attemptID, String activityID,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttemptData[] array = new LFAttemptDataImpl[3];

            array[0] = getByAttemptIDWithActivityID_PrevAndNext(session,
                    lfAttemptData, attemptID, activityID, orderByComparator,
                    true);

            array[1] = lfAttemptData;

            array[2] = getByAttemptIDWithActivityID_PrevAndNext(session,
                    lfAttemptData, attemptID, activityID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttemptData getByAttemptIDWithActivityID_PrevAndNext(
        Session session, LFAttemptData lfAttemptData, Integer attemptID,
        String activityID, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

        if (attemptID == null) {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_2);
        }

        boolean bindActivityID = false;

        if (activityID == null) {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_1);
        } else if (activityID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3);
        } else {
            bindActivityID = true;

            if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_2);
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
            query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (attemptID != null) {
            qPos.add(attemptID.intValue());
        }

        if (bindActivityID) {
            if (activityID != null) {
                qPos.add(activityID);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttemptData);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttemptData> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; from the database.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAttemptIDWithActivityID(Integer attemptID,
        String activityID) throws SystemException {
        for (LFAttemptData lfAttemptData : findByAttemptIDWithActivityID(
                attemptID, activityID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(lfAttemptData);
        }
    }

    /**
     * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @return the number of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAttemptIDWithActivityID(Integer attemptID,
        String activityID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTEMPTIDWITHACTIVITYID;

        Object[] finderArgs = new Object[] { attemptID, activityID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ATTEMPTID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHACTIVITYID_ACTIVITYID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
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
     * Returns all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @return the matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByAttemptIDWithDataKey(Integer attemptID,
        String dataKey) throws SystemException {
        return findByAttemptIDWithDataKey(attemptID, dataKey,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @return the range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByAttemptIDWithDataKey(Integer attemptID,
        String dataKey, int start, int end) throws SystemException {
        return findByAttemptIDWithDataKey(attemptID, dataKey, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByAttemptIDWithDataKey(Integer attemptID,
        String dataKey, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY;
            finderArgs = new Object[] { attemptID, dataKey };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY;
            finderArgs = new Object[] {
                    attemptID, dataKey,
                    
                    start, end, orderByComparator
                };
        }

        List<LFAttemptData> list = (List<LFAttemptData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttemptData lfAttemptData : list) {
                if (!Validator.equals(attemptID, lfAttemptData.getAttemptID()) ||
                        !Validator.equals(dataKey, lfAttemptData.getDataKey())) {
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

            query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_2);
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
                    }
                }

                if (!pagination) {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAttemptData>(list);
                } else {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
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
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByAttemptIDWithDataKey_First(Integer attemptID,
        String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByAttemptIDWithDataKey_First(attemptID,
                dataKey, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByAttemptIDWithDataKey_First(Integer attemptID,
        String dataKey, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFAttemptData> list = findByAttemptIDWithDataKey(attemptID,
                dataKey, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByAttemptIDWithDataKey_Last(Integer attemptID,
        String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByAttemptIDWithDataKey_Last(attemptID,
                dataKey, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByAttemptIDWithDataKey_Last(Integer attemptID,
        String dataKey, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByAttemptIDWithDataKey(attemptID, dataKey);

        if (count == 0) {
            return null;
        }

        List<LFAttemptData> list = findByAttemptIDWithDataKey(attemptID,
                dataKey, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and dataKey = &#63;.
     *
     * @param id the primary key of the current l f attempt data
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData[] findByAttemptIDWithDataKey_PrevAndNext(long id,
        Integer attemptID, String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttemptData[] array = new LFAttemptDataImpl[3];

            array[0] = getByAttemptIDWithDataKey_PrevAndNext(session,
                    lfAttemptData, attemptID, dataKey, orderByComparator, true);

            array[1] = lfAttemptData;

            array[2] = getByAttemptIDWithDataKey_PrevAndNext(session,
                    lfAttemptData, attemptID, dataKey, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttemptData getByAttemptIDWithDataKey_PrevAndNext(
        Session session, LFAttemptData lfAttemptData, Integer attemptID,
        String dataKey, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

        if (attemptID == null) {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_2);
        }

        boolean bindDataKey = false;

        if (dataKey == null) {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_1);
        } else if (dataKey.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3);
        } else {
            bindDataKey = true;

            if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_2);
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
            query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (attemptID != null) {
            qPos.add(attemptID.intValue());
        }

        if (bindDataKey) {
            if (dataKey != null) {
                qPos.add(dataKey);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttemptData);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttemptData> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f attempt datas where attemptID = &#63; and dataKey = &#63; from the database.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAttemptIDWithDataKey(Integer attemptID, String dataKey)
        throws SystemException {
        for (LFAttemptData lfAttemptData : findByAttemptIDWithDataKey(
                attemptID, dataKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAttemptData);
        }
    }

    /**
     * Returns the number of l f attempt datas where attemptID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param dataKey the data key
     * @return the number of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAttemptIDWithDataKey(Integer attemptID, String dataKey)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTEMPTIDWITHDATAKEY;

        Object[] finderArgs = new Object[] { attemptID, dataKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_ATTEMPTID_2);
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_ATTEMPTIDWITHDATAKEY_DATAKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
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
     * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @return the matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findBySingleKey(Integer attemptID,
        String activityID, String dataKey) throws SystemException {
        return findBySingleKey(attemptID, activityID, dataKey,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @return the range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findBySingleKey(Integer attemptID,
        String activityID, String dataKey, int start, int end)
        throws SystemException {
        return findBySingleKey(attemptID, activityID, dataKey, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findBySingleKey(Integer attemptID,
        String activityID, String dataKey, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SINGLEKEY;
            finderArgs = new Object[] { attemptID, activityID, dataKey };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SINGLEKEY;
            finderArgs = new Object[] {
                    attemptID, activityID, dataKey,
                    
                    start, end, orderByComparator
                };
        }

        List<LFAttemptData> list = (List<LFAttemptData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttemptData lfAttemptData : list) {
                if (!Validator.equals(attemptID, lfAttemptData.getAttemptID()) ||
                        !Validator.equals(activityID,
                            lfAttemptData.getActivityID()) ||
                        !Validator.equals(dataKey, lfAttemptData.getDataKey())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SINGLEKEY_ATTEMPTID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_2);
                }
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
                }

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
                    }
                }

                if (!pagination) {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAttemptData>(list);
                } else {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
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
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findBySingleKey_First(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchBySingleKey_First(attemptID,
                activityID, dataKey, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(", dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchBySingleKey_First(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFAttemptData> list = findBySingleKey(attemptID, activityID,
                dataKey, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findBySingleKey_Last(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchBySingleKey_Last(attemptID,
                activityID, dataKey, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(", dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchBySingleKey_Last(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBySingleKey(attemptID, activityID, dataKey);

        if (count == 0) {
            return null;
        }

        List<LFAttemptData> list = findBySingleKey(attemptID, activityID,
                dataKey, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param id the primary key of the current l f attempt data
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData[] findBySingleKey_PrevAndNext(long id,
        Integer attemptID, String activityID, String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttemptData[] array = new LFAttemptDataImpl[3];

            array[0] = getBySingleKey_PrevAndNext(session, lfAttemptData,
                    attemptID, activityID, dataKey, orderByComparator, true);

            array[1] = lfAttemptData;

            array[2] = getBySingleKey_PrevAndNext(session, lfAttemptData,
                    attemptID, activityID, dataKey, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttemptData getBySingleKey_PrevAndNext(Session session,
        LFAttemptData lfAttemptData, Integer attemptID, String activityID,
        String dataKey, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

        if (attemptID == null) {
            query.append(_FINDER_COLUMN_SINGLEKEY_ATTEMPTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_SINGLEKEY_ATTEMPTID_2);
        }

        boolean bindActivityID = false;

        if (activityID == null) {
            query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_1);
        } else if (activityID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3);
        } else {
            bindActivityID = true;

            if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_2);
            }
        }

        boolean bindDataKey = false;

        if (dataKey == null) {
            query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_1);
        } else if (dataKey.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_3);
        } else {
            bindDataKey = true;

            if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_3);
            } else {
                query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_2);
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
            query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (attemptID != null) {
            qPos.add(attemptID.intValue());
        }

        if (bindActivityID) {
            if (activityID != null) {
                qPos.add(activityID);
            }
        }

        if (bindDataKey) {
            if (dataKey != null) {
                qPos.add(dataKey);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttemptData);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttemptData> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63; from the database.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBySingleKey(Integer attemptID, String activityID,
        String dataKey) throws SystemException {
        for (LFAttemptData lfAttemptData : findBySingleKey(attemptID,
                activityID, dataKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAttemptData);
        }
    }

    /**
     * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey = &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @return the number of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBySingleKey(Integer attemptID, String activityID,
        String dataKey) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_SINGLEKEY;

        Object[] finderArgs = new Object[] { attemptID, activityID, dataKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_SINGLEKEY_ATTEMPTID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_SINGLEKEY_ACTIVITYID_2);
                }
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_SINGLEKEY_DATAKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
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
     * Returns all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @return the matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByCollectionValues(Integer attemptID,
        String activityID, String dataKey) throws SystemException {
        return findByCollectionValues(attemptID, activityID, dataKey,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @return the range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByCollectionValues(Integer attemptID,
        String activityID, String dataKey, int start, int end)
        throws SystemException {
        return findByCollectionValues(attemptID, activityID, dataKey, start,
            end, null);
    }

    /**
     * Returns an ordered range of all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findByCollectionValues(Integer attemptID,
        String activityID, String dataKey, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COLLECTIONVALUES;
        finderArgs = new Object[] {
                attemptID, activityID, dataKey,
                
                start, end, orderByComparator
            };

        List<LFAttemptData> list = (List<LFAttemptData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFAttemptData lfAttemptData : list) {
                if (!Validator.equals(attemptID, lfAttemptData.getAttemptID()) ||
                        !Validator.equals(activityID,
                            lfAttemptData.getActivityID()) ||
                        !StringUtil.wildcardMatches(
                            lfAttemptData.getDataKey(), dataKey,
                            CharPool.UNDERLINE, CharPool.PERCENT,
                            CharPool.BACK_SLASH, true)) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_2);
                }
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
                }

                if (bindDataKey) {
                    if (dataKey != null) {
                        qPos.add(dataKey);
                    }
                }

                if (!pagination) {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAttemptData>(list);
                } else {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
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
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByCollectionValues_First(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByCollectionValues_First(attemptID,
                activityID, dataKey, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(", dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the first l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByCollectionValues_First(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFAttemptData> list = findByCollectionValues(attemptID,
                activityID, dataKey, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByCollectionValues_Last(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByCollectionValues_Last(attemptID,
                activityID, dataKey, orderByComparator);

        if (lfAttemptData != null) {
            return lfAttemptData;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("attemptID=");
        msg.append(attemptID);

        msg.append(", activityID=");
        msg.append(activityID);

        msg.append(", dataKey=");
        msg.append(dataKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFAttemptDataException(msg.toString());
    }

    /**
     * Returns the last l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f attempt data, or <code>null</code> if a matching l f attempt data could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByCollectionValues_Last(Integer attemptID,
        String activityID, String dataKey, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCollectionValues(attemptID, activityID, dataKey);

        if (count == 0) {
            return null;
        }

        List<LFAttemptData> list = findByCollectionValues(attemptID,
                activityID, dataKey, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f attempt datas before and after the current l f attempt data in the ordered set where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param id the primary key of the current l f attempt data
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData[] findByCollectionValues_PrevAndNext(long id,
        Integer attemptID, String activityID, String dataKey,
        OrderByComparator orderByComparator)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            LFAttemptData[] array = new LFAttemptDataImpl[3];

            array[0] = getByCollectionValues_PrevAndNext(session,
                    lfAttemptData, attemptID, activityID, dataKey,
                    orderByComparator, true);

            array[1] = lfAttemptData;

            array[2] = getByCollectionValues_PrevAndNext(session,
                    lfAttemptData, attemptID, activityID, dataKey,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFAttemptData getByCollectionValues_PrevAndNext(Session session,
        LFAttemptData lfAttemptData, Integer attemptID, String activityID,
        String dataKey, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFATTEMPTDATA_WHERE);

        if (attemptID == null) {
            query.append(_FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_2);
        }

        boolean bindActivityID = false;

        if (activityID == null) {
            query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_1);
        } else if (activityID.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3);
        } else {
            bindActivityID = true;

            if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3);
            } else {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_2);
            }
        }

        boolean bindDataKey = false;

        if (dataKey == null) {
            query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_1);
        } else if (dataKey.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3);
        } else {
            bindDataKey = true;

            if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3);
            } else {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_2);
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
            query.append(LFAttemptDataModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (attemptID != null) {
            qPos.add(attemptID.intValue());
        }

        if (bindActivityID) {
            if (activityID != null) {
                qPos.add(activityID);
            }
        }

        if (bindDataKey) {
            if (dataKey != null) {
                qPos.add(dataKey);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfAttemptData);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFAttemptData> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63; from the database.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCollectionValues(Integer attemptID, String activityID,
        String dataKey) throws SystemException {
        for (LFAttemptData lfAttemptData : findByCollectionValues(attemptID,
                activityID, dataKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfAttemptData);
        }
    }

    /**
     * Returns the number of l f attempt datas where attemptID = &#63; and activityID = &#63; and dataKey LIKE &#63;.
     *
     * @param attemptID the attempt i d
     * @param activityID the activity i d
     * @param dataKey the data key
     * @return the number of matching l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCollectionValues(Integer attemptID, String activityID,
        String dataKey) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_COLLECTIONVALUES;

        Object[] finderArgs = new Object[] { attemptID, activityID, dataKey };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_LFATTEMPTDATA_WHERE);

            if (attemptID == null) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ATTEMPTID_2);
            }

            boolean bindActivityID = false;

            if (activityID == null) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_1);
            } else if (activityID.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3);
            } else {
                bindActivityID = true;

                if (activityID.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_3);
                } else {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_ACTIVITYID_2);
                }
            }

            boolean bindDataKey = false;

            if (dataKey == null) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_1);
            } else if (dataKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3);
            } else {
                bindDataKey = true;

                if (dataKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_COLLECTIONVALUES_DATAKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (attemptID != null) {
                    qPos.add(attemptID.intValue());
                }

                if (bindActivityID) {
                    if (activityID != null) {
                        qPos.add(activityID);
                    }
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
     * Caches the l f attempt data in the entity cache if it is enabled.
     *
     * @param lfAttemptData the l f attempt data
     */
    @Override
    public void cacheResult(LFAttemptData lfAttemptData) {
        EntityCacheUtil.putResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataImpl.class, lfAttemptData.getPrimaryKey(),
            lfAttemptData);

        lfAttemptData.resetOriginalValues();
    }

    /**
     * Caches the l f attempt datas in the entity cache if it is enabled.
     *
     * @param lfAttemptDatas the l f attempt datas
     */
    @Override
    public void cacheResult(List<LFAttemptData> lfAttemptDatas) {
        for (LFAttemptData lfAttemptData : lfAttemptDatas) {
            if (EntityCacheUtil.getResult(
                        LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
                        LFAttemptDataImpl.class, lfAttemptData.getPrimaryKey()) == null) {
                cacheResult(lfAttemptData);
            } else {
                lfAttemptData.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f attempt datas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFAttemptDataImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFAttemptDataImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f attempt data.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFAttemptData lfAttemptData) {
        EntityCacheUtil.removeResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataImpl.class, lfAttemptData.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFAttemptData> lfAttemptDatas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFAttemptData lfAttemptData : lfAttemptDatas) {
            EntityCacheUtil.removeResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
                LFAttemptDataImpl.class, lfAttemptData.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f attempt data with the primary key. Does not add the l f attempt data to the database.
     *
     * @param id the primary key for the new l f attempt data
     * @return the new l f attempt data
     */
    @Override
    public LFAttemptData create(long id) {
        LFAttemptData lfAttemptData = new LFAttemptDataImpl();

        lfAttemptData.setNew(true);
        lfAttemptData.setPrimaryKey(id);

        return lfAttemptData;
    }

    /**
     * Removes the l f attempt data with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the l f attempt data
     * @return the l f attempt data that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData remove(long id)
        throws NoSuchLFAttemptDataException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the l f attempt data with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f attempt data
     * @return the l f attempt data that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData remove(Serializable primaryKey)
        throws NoSuchLFAttemptDataException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFAttemptData lfAttemptData = (LFAttemptData) session.get(LFAttemptDataImpl.class,
                    primaryKey);

            if (lfAttemptData == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFAttemptDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfAttemptData);
        } catch (NoSuchLFAttemptDataException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFAttemptData removeImpl(LFAttemptData lfAttemptData)
        throws SystemException {
        lfAttemptData = toUnwrappedModel(lfAttemptData);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfAttemptData)) {
                lfAttemptData = (LFAttemptData) session.get(LFAttemptDataImpl.class,
                        lfAttemptData.getPrimaryKeyObj());
            }

            if (lfAttemptData != null) {
                session.delete(lfAttemptData);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfAttemptData != null) {
            clearCache(lfAttemptData);
        }

        return lfAttemptData;
    }

    @Override
    public LFAttemptData updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws SystemException {
        lfAttemptData = toUnwrappedModel(lfAttemptData);

        boolean isNew = lfAttemptData.isNew();

        LFAttemptDataModelImpl lfAttemptDataModelImpl = (LFAttemptDataModelImpl) lfAttemptData;

        Session session = null;

        try {
            session = openSession();

            if (lfAttemptData.isNew()) {
                session.save(lfAttemptData);

                lfAttemptData.setNew(false);
            } else {
                session.merge(lfAttemptData);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFAttemptDataModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfAttemptDataModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAttemptDataModelImpl.getOriginalAttemptID(),
                        lfAttemptDataModelImpl.getOriginalActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTIDWITHACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID,
                    args);

                args = new Object[] {
                        lfAttemptDataModelImpl.getAttemptID(),
                        lfAttemptDataModelImpl.getActivityID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTIDWITHACTIVITYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHACTIVITYID,
                    args);
            }

            if ((lfAttemptDataModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAttemptDataModelImpl.getOriginalAttemptID(),
                        lfAttemptDataModelImpl.getOriginalDataKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTIDWITHDATAKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY,
                    args);

                args = new Object[] {
                        lfAttemptDataModelImpl.getAttemptID(),
                        lfAttemptDataModelImpl.getDataKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTEMPTIDWITHDATAKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTEMPTIDWITHDATAKEY,
                    args);
            }

            if ((lfAttemptDataModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SINGLEKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfAttemptDataModelImpl.getOriginalAttemptID(),
                        lfAttemptDataModelImpl.getOriginalActivityID(),
                        lfAttemptDataModelImpl.getOriginalDataKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SINGLEKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SINGLEKEY,
                    args);

                args = new Object[] {
                        lfAttemptDataModelImpl.getAttemptID(),
                        lfAttemptDataModelImpl.getActivityID(),
                        lfAttemptDataModelImpl.getDataKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SINGLEKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SINGLEKEY,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
            LFAttemptDataImpl.class, lfAttemptData.getPrimaryKey(),
            lfAttemptData);

        return lfAttemptData;
    }

    protected LFAttemptData toUnwrappedModel(LFAttemptData lfAttemptData) {
        if (lfAttemptData instanceof LFAttemptDataImpl) {
            return lfAttemptData;
        }

        LFAttemptDataImpl lfAttemptDataImpl = new LFAttemptDataImpl();

        lfAttemptDataImpl.setNew(lfAttemptData.isNew());
        lfAttemptDataImpl.setPrimaryKey(lfAttemptData.getPrimaryKey());

        lfAttemptDataImpl.setId(lfAttemptData.getId());
        lfAttemptDataImpl.setDataKey(lfAttemptData.getDataKey());
        lfAttemptDataImpl.setDataValue(lfAttemptData.getDataValue());
        lfAttemptDataImpl.setAttemptID(lfAttemptData.getAttemptID());
        lfAttemptDataImpl.setActivityID(lfAttemptData.getActivityID());

        return lfAttemptDataImpl;
    }

    /**
     * Returns the l f attempt data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f attempt data
     * @return the l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFAttemptDataException, SystemException {
        LFAttemptData lfAttemptData = fetchByPrimaryKey(primaryKey);

        if (lfAttemptData == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFAttemptDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfAttemptData;
    }

    /**
     * Returns the l f attempt data with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException} if it could not be found.
     *
     * @param id the primary key of the l f attempt data
     * @return the l f attempt data
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptDataException if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData findByPrimaryKey(long id)
        throws NoSuchLFAttemptDataException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the l f attempt data with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f attempt data
     * @return the l f attempt data, or <code>null</code> if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFAttemptData lfAttemptData = (LFAttemptData) EntityCacheUtil.getResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
                LFAttemptDataImpl.class, primaryKey);

        if (lfAttemptData == _nullLFAttemptData) {
            return null;
        }

        if (lfAttemptData == null) {
            Session session = null;

            try {
                session = openSession();

                lfAttemptData = (LFAttemptData) session.get(LFAttemptDataImpl.class,
                        primaryKey);

                if (lfAttemptData != null) {
                    cacheResult(lfAttemptData);
                } else {
                    EntityCacheUtil.putResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
                        LFAttemptDataImpl.class, primaryKey, _nullLFAttemptData);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFAttemptDataModelImpl.ENTITY_CACHE_ENABLED,
                    LFAttemptDataImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfAttemptData;
    }

    /**
     * Returns the l f attempt data with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the l f attempt data
     * @return the l f attempt data, or <code>null</code> if a l f attempt data with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFAttemptData fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the l f attempt datas.
     *
     * @return the l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f attempt datas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @return the range of l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f attempt datas.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f attempt datas
     * @param end the upper bound of the range of l f attempt datas (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f attempt datas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFAttemptData> findAll(int start, int end,
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

        List<LFAttemptData> list = (List<LFAttemptData>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFATTEMPTDATA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFATTEMPTDATA;

                if (pagination) {
                    sql = sql.concat(LFAttemptDataModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFAttemptData>(list);
                } else {
                    list = (List<LFAttemptData>) QueryUtil.list(q,
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
     * Removes all the l f attempt datas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFAttemptData lfAttemptData : findAll()) {
            remove(lfAttemptData);
        }
    }

    /**
     * Returns the number of l f attempt datas.
     *
     * @return the number of l f attempt datas
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

                Query q = session.createQuery(_SQL_COUNT_LFATTEMPTDATA);

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
     * Initializes the l f attempt data persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFAttemptData")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFAttemptData>> listenersList = new ArrayList<ModelListener<LFAttemptData>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFAttemptData>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFAttemptDataImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

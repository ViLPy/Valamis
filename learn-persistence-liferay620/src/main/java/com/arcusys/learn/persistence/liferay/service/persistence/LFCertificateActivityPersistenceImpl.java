package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateActivity;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPersistence;

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

/**
 * The persistence implementation for the l f certificate activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateActivityPersistence
 * @see LFCertificateActivityUtil
 * @generated
 */
public class LFCertificateActivityPersistenceImpl extends BasePersistenceImpl<LFCertificateActivity>
    implements LFCertificateActivityPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateActivityUtil} to access the l f certificate activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateActivityImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Long.class.getName() },
            LFCertificateActivityModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertificateID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateActivity.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateActivity.id.certificateID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateActivity.certificateID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYNAME =
        new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivityName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYNAME =
        new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityName",
            new String[] { String.class.getName() },
            LFCertificateActivityModelImpl.ACTIVITYNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVITYNAME = new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_1 = "lfCertificateActivity.id.activityName IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_NULL = "lfCertificateActivity.activityName IS NULL";
    private static final String _FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_2 = "lfCertificateActivity.id.activityName = ?";
    private static final String _FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_NULL_2 = "lfCertificateActivity.activityName IS NULL ";
    private static final String _FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3 = "(lfCertificateActivity.id.activityName IS NULL OR lfCertificateActivity.id.activityName = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME =
        new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateActivityImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByCertificateIDAndActivityName",
            new String[] { Long.class.getName(), String.class.getName() },
            LFCertificateActivityModelImpl.CERTIFICATEID_COLUMN_BITMASK |
            LFCertificateActivityModelImpl.ACTIVITYNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEIDANDACTIVITYNAME =
        new FinderPath(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCertificateIDAndActivityName",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_NULL =
        "lfCertificateActivity.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_2 =
        "lfCertificateActivity.id.certificateID = ? AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_NULL_2 =
        "lfCertificateActivity.certificateID IS NULL  AND ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_1 =
        "lfCertificateActivity.id.activityName IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_NULL =
        "lfCertificateActivity.activityName IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_2 =
        "lfCertificateActivity.id.activityName = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_NULL_2 =
        "lfCertificateActivity.activityName IS NULL ";
    private static final String _FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_3 =
        "(lfCertificateActivity.id.activityName IS NULL OR lfCertificateActivity.id.activityName = '')";
    private static final String _SQL_SELECT_LFCERTIFICATEACTIVITY = "SELECT lfCertificateActivity FROM LFCertificateActivity lfCertificateActivity";
    private static final String _SQL_SELECT_LFCERTIFICATEACTIVITY_WHERE = "SELECT lfCertificateActivity FROM LFCertificateActivity lfCertificateActivity WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATEACTIVITY = "SELECT COUNT(lfCertificateActivity) FROM LFCertificateActivity lfCertificateActivity";
    private static final String _SQL_COUNT_LFCERTIFICATEACTIVITY_WHERE = "SELECT COUNT(lfCertificateActivity) FROM LFCertificateActivity lfCertificateActivity WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateActivity.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateActivity exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateActivity exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateActivityPersistenceImpl.class);
    private static LFCertificateActivity _nullLFCertificateActivity = new LFCertificateActivityImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateActivity> toCacheModel() {
                return _nullLFCertificateActivityCacheModel;
            }
        };

    private static CacheModel<LFCertificateActivity> _nullLFCertificateActivityCacheModel =
        new CacheModel<LFCertificateActivity>() {
            @Override
            public LFCertificateActivity toEntityModel() {
                return _nullLFCertificateActivity;
            }
        };

    public LFCertificateActivityPersistenceImpl() {
        setModelClass(LFCertificateActivity.class);
    }

    /**
     * Returns all the l f certificate activities where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findByCertificateID(Long certificateID)
        throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate activities where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate activities
     * @param end the upper bound of the range of l f certificate activities (not inclusive)
     * @return the range of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findByCertificateID(Long certificateID,
        int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate activities where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate activities
     * @param end the upper bound of the range of l f certificate activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findByCertificateID(Long certificateID,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] { certificateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID;
            finderArgs = new Object[] {
                    certificateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateActivity> list = (List<LFCertificateActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateActivity lfCertificateActivity : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateActivity.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEACTIVITY_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateActivity>(list);
                } else {
                    list = (List<LFCertificateActivity>) QueryUtil.list(q,
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
     * Returns the first l f certificate activity in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByCertificateID_First(Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateActivity != null) {
            return lfCertificateActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateActivityException(msg.toString());
    }

    /**
     * Returns the first l f certificate activity in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByCertificateID_First(
        Long certificateID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFCertificateActivity> list = findByCertificateID(certificateID,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate activity in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByCertificateID_Last(Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateActivity != null) {
            return lfCertificateActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateActivityException(msg.toString());
    }

    /**
     * Returns the last l f certificate activity in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByCertificateID_Last(Long certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCertificateID(certificateID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateActivity> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate activities before and after the current l f certificate activity in the ordered set where certificateID = &#63;.
     *
     * @param lfCertificateActivityPK the primary key of the current l f certificate activity
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity[] findByCertificateID_PrevAndNext(
        LFCertificateActivityPK lfCertificateActivityPK, Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = findByPrimaryKey(lfCertificateActivityPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateActivity[] array = new LFCertificateActivityImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateActivity, certificateID, orderByComparator,
                    true);

            array[1] = lfCertificateActivity;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateActivity, certificateID, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateActivity getByCertificateID_PrevAndNext(
        Session session, LFCertificateActivity lfCertificateActivity,
        Long certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEACTIVITY_WHERE);

        if (certificateID == null) {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
        } else {
            query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
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
            query.append(LFCertificateActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (certificateID != null) {
            qPos.add(certificateID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate activities where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCertificateID(Long certificateID)
        throws SystemException {
        for (LFCertificateActivity lfCertificateActivity : findByCertificateID(
                certificateID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateActivity);
        }
    }

    /**
     * Returns the number of l f certificate activities where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateID(Long certificateID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEID;

        Object[] finderArgs = new Object[] { certificateID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATEACTIVITY_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
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
     * Returns all the l f certificate activities where activityName = &#63;.
     *
     * @param activityName the activity name
     * @return the matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findByActivityName(String activityName)
        throws SystemException {
        return findByActivityName(activityName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate activities where activityName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param activityName the activity name
     * @param start the lower bound of the range of l f certificate activities
     * @param end the upper bound of the range of l f certificate activities (not inclusive)
     * @return the range of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findByActivityName(String activityName,
        int start, int end) throws SystemException {
        return findByActivityName(activityName, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate activities where activityName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param activityName the activity name
     * @param start the lower bound of the range of l f certificate activities
     * @param end the upper bound of the range of l f certificate activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findByActivityName(String activityName,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYNAME;
            finderArgs = new Object[] { activityName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVITYNAME;
            finderArgs = new Object[] {
                    activityName,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateActivity> list = (List<LFCertificateActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateActivity lfCertificateActivity : list) {
                if (!Validator.equals(activityName,
                            lfCertificateActivity.getActivityName())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEACTIVITY_WHERE);

            boolean bindActivityName = false;

            if (activityName == null) {
                query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_1);
            } else if (activityName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3);
            } else {
                bindActivityName = true;

                if (activityName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateActivityModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindActivityName) {
                    if (activityName != null) {
                        qPos.add(activityName);
                    }
                }

                if (!pagination) {
                    list = (List<LFCertificateActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateActivity>(list);
                } else {
                    list = (List<LFCertificateActivity>) QueryUtil.list(q,
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
     * Returns the first l f certificate activity in the ordered set where activityName = &#63;.
     *
     * @param activityName the activity name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByActivityName_First(String activityName,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = fetchByActivityName_First(activityName,
                orderByComparator);

        if (lfCertificateActivity != null) {
            return lfCertificateActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityName=");
        msg.append(activityName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateActivityException(msg.toString());
    }

    /**
     * Returns the first l f certificate activity in the ordered set where activityName = &#63;.
     *
     * @param activityName the activity name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByActivityName_First(
        String activityName, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFCertificateActivity> list = findByActivityName(activityName, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate activity in the ordered set where activityName = &#63;.
     *
     * @param activityName the activity name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByActivityName_Last(String activityName,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = fetchByActivityName_Last(activityName,
                orderByComparator);

        if (lfCertificateActivity != null) {
            return lfCertificateActivity;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("activityName=");
        msg.append(activityName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateActivityException(msg.toString());
    }

    /**
     * Returns the last l f certificate activity in the ordered set where activityName = &#63;.
     *
     * @param activityName the activity name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByActivityName_Last(String activityName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByActivityName(activityName);

        if (count == 0) {
            return null;
        }

        List<LFCertificateActivity> list = findByActivityName(activityName,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate activities before and after the current l f certificate activity in the ordered set where activityName = &#63;.
     *
     * @param lfCertificateActivityPK the primary key of the current l f certificate activity
     * @param activityName the activity name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity[] findByActivityName_PrevAndNext(
        LFCertificateActivityPK lfCertificateActivityPK, String activityName,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = findByPrimaryKey(lfCertificateActivityPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateActivity[] array = new LFCertificateActivityImpl[3];

            array[0] = getByActivityName_PrevAndNext(session,
                    lfCertificateActivity, activityName, orderByComparator, true);

            array[1] = lfCertificateActivity;

            array[2] = getByActivityName_PrevAndNext(session,
                    lfCertificateActivity, activityName, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateActivity getByActivityName_PrevAndNext(
        Session session, LFCertificateActivity lfCertificateActivity,
        String activityName, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEACTIVITY_WHERE);

        boolean bindActivityName = false;

        if (activityName == null) {
            query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_1);
        } else if (activityName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3);
        } else {
            bindActivityName = true;

            if (activityName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3);
            } else {
                query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_2);
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
            query.append(LFCertificateActivityModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindActivityName) {
            if (activityName != null) {
                qPos.add(activityName);
            }
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateActivity);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateActivity> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate activities where activityName = &#63; from the database.
     *
     * @param activityName the activity name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByActivityName(String activityName)
        throws SystemException {
        for (LFCertificateActivity lfCertificateActivity : findByActivityName(
                activityName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateActivity);
        }
    }

    /**
     * Returns the number of l f certificate activities where activityName = &#63;.
     *
     * @param activityName the activity name
     * @return the number of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByActivityName(String activityName)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVITYNAME;

        Object[] finderArgs = new Object[] { activityName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATEACTIVITY_WHERE);

            boolean bindActivityName = false;

            if (activityName == null) {
                query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_1);
            } else if (activityName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3);
            } else {
                bindActivityName = true;

                if (activityName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_ACTIVITYNAME_ACTIVITYNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindActivityName) {
                    if (activityName != null) {
                        qPos.add(activityName);
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
     * Returns the l f certificate activity where certificateID = &#63; and activityName = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException} if it could not be found.
     *
     * @param certificateID the certificate i d
     * @param activityName the activity name
     * @return the matching l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByCertificateIDAndActivityName(
        Long certificateID, String activityName)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = fetchByCertificateIDAndActivityName(certificateID,
                activityName);

        if (lfCertificateActivity == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("certificateID=");
            msg.append(certificateID);

            msg.append(", activityName=");
            msg.append(activityName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFCertificateActivityException(msg.toString());
        }

        return lfCertificateActivity;
    }

    /**
     * Returns the l f certificate activity where certificateID = &#63; and activityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param certificateID the certificate i d
     * @param activityName the activity name
     * @return the matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByCertificateIDAndActivityName(
        Long certificateID, String activityName) throws SystemException {
        return fetchByCertificateIDAndActivityName(certificateID, activityName,
            true);
    }

    /**
     * Returns the l f certificate activity where certificateID = &#63; and activityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param certificateID the certificate i d
     * @param activityName the activity name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f certificate activity, or <code>null</code> if a matching l f certificate activity could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByCertificateIDAndActivityName(
        Long certificateID, String activityName, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { certificateID, activityName };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                    finderArgs, this);
        }

        if (result instanceof LFCertificateActivity) {
            LFCertificateActivity lfCertificateActivity = (LFCertificateActivity) result;

            if (!Validator.equals(certificateID,
                        lfCertificateActivity.getCertificateID()) ||
                    !Validator.equals(activityName,
                        lfCertificateActivity.getActivityName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFCERTIFICATEACTIVITY_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_2);
            }

            boolean bindActivityName = false;

            if (activityName == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_1);
            } else if (activityName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_3);
            } else {
                bindActivityName = true;

                if (activityName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (bindActivityName) {
                    if (activityName != null) {
                        qPos.add(activityName);
                    }
                }

                List<LFCertificateActivity> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFCertificateActivityPersistenceImpl.fetchByCertificateIDAndActivityName(Long, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFCertificateActivity lfCertificateActivity = list.get(0);

                    result = lfCertificateActivity;

                    cacheResult(lfCertificateActivity);

                    if ((lfCertificateActivity.getCertificateID() != certificateID) ||
                            (lfCertificateActivity.getActivityName() == null) ||
                            !lfCertificateActivity.getActivityName()
                                                      .equals(activityName)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                            finderArgs, lfCertificateActivity);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFCertificateActivity) result;
        }
    }

    /**
     * Removes the l f certificate activity where certificateID = &#63; and activityName = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @param activityName the activity name
     * @return the l f certificate activity that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity removeByCertificateIDAndActivityName(
        Long certificateID, String activityName)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = findByCertificateIDAndActivityName(certificateID,
                activityName);

        return remove(lfCertificateActivity);
    }

    /**
     * Returns the number of l f certificate activities where certificateID = &#63; and activityName = &#63;.
     *
     * @param certificateID the certificate i d
     * @param activityName the activity name
     * @return the number of matching l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateIDAndActivityName(Long certificateID,
        String activityName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEIDANDACTIVITYNAME;

        Object[] finderArgs = new Object[] { certificateID, activityName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATEACTIVITY_WHERE);

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_CERTIFICATEID_2);
            }

            boolean bindActivityName = false;

            if (activityName == null) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_1);
            } else if (activityName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_3);
            } else {
                bindActivityName = true;

                if (activityName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_CERTIFICATEIDANDACTIVITYNAME_ACTIVITYNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                if (bindActivityName) {
                    if (activityName != null) {
                        qPos.add(activityName);
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
     * Caches the l f certificate activity in the entity cache if it is enabled.
     *
     * @param lfCertificateActivity the l f certificate activity
     */
    @Override
    public void cacheResult(LFCertificateActivity lfCertificateActivity) {
        EntityCacheUtil.putResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            lfCertificateActivity.getPrimaryKey(), lfCertificateActivity);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
            new Object[] {
                lfCertificateActivity.getCertificateID(),
                lfCertificateActivity.getActivityName()
            }, lfCertificateActivity);

        lfCertificateActivity.resetOriginalValues();
    }

    /**
     * Caches the l f certificate activities in the entity cache if it is enabled.
     *
     * @param lfCertificateActivities the l f certificate activities
     */
    @Override
    public void cacheResult(List<LFCertificateActivity> lfCertificateActivities) {
        for (LFCertificateActivity lfCertificateActivity : lfCertificateActivities) {
            if (EntityCacheUtil.getResult(
                        LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateActivityImpl.class,
                        lfCertificateActivity.getPrimaryKey()) == null) {
                cacheResult(lfCertificateActivity);
            } else {
                lfCertificateActivity.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate activities.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateActivityImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateActivityImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate activity.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificateActivity lfCertificateActivity) {
        EntityCacheUtil.removeResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            lfCertificateActivity.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfCertificateActivity);
    }

    @Override
    public void clearCache(List<LFCertificateActivity> lfCertificateActivities) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateActivity lfCertificateActivity : lfCertificateActivities) {
            EntityCacheUtil.removeResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateActivityImpl.class,
                lfCertificateActivity.getPrimaryKey());

            clearUniqueFindersCache(lfCertificateActivity);
        }
    }

    protected void cacheUniqueFindersCache(
        LFCertificateActivity lfCertificateActivity) {
        if (lfCertificateActivity.isNew()) {
            Object[] args = new Object[] {
                    lfCertificateActivity.getCertificateID(),
                    lfCertificateActivity.getActivityName()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDACTIVITYNAME,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                args, lfCertificateActivity);
        } else {
            LFCertificateActivityModelImpl lfCertificateActivityModelImpl = (LFCertificateActivityModelImpl) lfCertificateActivity;

            if ((lfCertificateActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateActivity.getCertificateID(),
                        lfCertificateActivity.getActivityName()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDACTIVITYNAME,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                    args, lfCertificateActivity);
            }
        }
    }

    protected void clearUniqueFindersCache(
        LFCertificateActivity lfCertificateActivity) {
        LFCertificateActivityModelImpl lfCertificateActivityModelImpl = (LFCertificateActivityModelImpl) lfCertificateActivity;

        Object[] args = new Object[] {
                lfCertificateActivity.getCertificateID(),
                lfCertificateActivity.getActivityName()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDACTIVITYNAME,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
            args);

        if ((lfCertificateActivityModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfCertificateActivityModelImpl.getOriginalCertificateID(),
                    lfCertificateActivityModelImpl.getOriginalActivityName()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEIDANDACTIVITYNAME,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CERTIFICATEIDANDACTIVITYNAME,
                args);
        }
    }

    /**
     * Creates a new l f certificate activity with the primary key. Does not add the l f certificate activity to the database.
     *
     * @param lfCertificateActivityPK the primary key for the new l f certificate activity
     * @return the new l f certificate activity
     */
    @Override
    public LFCertificateActivity create(
        LFCertificateActivityPK lfCertificateActivityPK) {
        LFCertificateActivity lfCertificateActivity = new LFCertificateActivityImpl();

        lfCertificateActivity.setNew(true);
        lfCertificateActivity.setPrimaryKey(lfCertificateActivityPK);

        return lfCertificateActivity;
    }

    /**
     * Removes the l f certificate activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfCertificateActivityPK the primary key of the l f certificate activity
     * @return the l f certificate activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity remove(
        LFCertificateActivityPK lfCertificateActivityPK)
        throws NoSuchLFCertificateActivityException, SystemException {
        return remove((Serializable) lfCertificateActivityPK);
    }

    /**
     * Removes the l f certificate activity with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate activity
     * @return the l f certificate activity that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity remove(Serializable primaryKey)
        throws NoSuchLFCertificateActivityException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateActivity lfCertificateActivity = (LFCertificateActivity) session.get(LFCertificateActivityImpl.class,
                    primaryKey);

            if (lfCertificateActivity == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateActivity);
        } catch (NoSuchLFCertificateActivityException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateActivity removeImpl(
        LFCertificateActivity lfCertificateActivity) throws SystemException {
        lfCertificateActivity = toUnwrappedModel(lfCertificateActivity);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfCertificateActivity)) {
                lfCertificateActivity = (LFCertificateActivity) session.get(LFCertificateActivityImpl.class,
                        lfCertificateActivity.getPrimaryKeyObj());
            }

            if (lfCertificateActivity != null) {
                session.delete(lfCertificateActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfCertificateActivity != null) {
            clearCache(lfCertificateActivity);
        }

        return lfCertificateActivity;
    }

    @Override
    public LFCertificateActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateActivity lfCertificateActivity)
        throws SystemException {
        lfCertificateActivity = toUnwrappedModel(lfCertificateActivity);

        boolean isNew = lfCertificateActivity.isNew();

        LFCertificateActivityModelImpl lfCertificateActivityModelImpl = (LFCertificateActivityModelImpl) lfCertificateActivity;

        Session session = null;

        try {
            session = openSession();

            if (lfCertificateActivity.isNew()) {
                session.save(lfCertificateActivity);

                lfCertificateActivity.setNew(false);
            } else {
                session.merge(lfCertificateActivity);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateActivityModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateActivityModelImpl.getOriginalCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        lfCertificateActivityModelImpl.getCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateActivityModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateActivityModelImpl.getOriginalActivityName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYNAME,
                    args);

                args = new Object[] {
                        lfCertificateActivityModelImpl.getActivityName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVITYNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVITYNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateActivityImpl.class,
            lfCertificateActivity.getPrimaryKey(), lfCertificateActivity);

        clearUniqueFindersCache(lfCertificateActivity);
        cacheUniqueFindersCache(lfCertificateActivity);

        return lfCertificateActivity;
    }

    protected LFCertificateActivity toUnwrappedModel(
        LFCertificateActivity lfCertificateActivity) {
        if (lfCertificateActivity instanceof LFCertificateActivityImpl) {
            return lfCertificateActivity;
        }

        LFCertificateActivityImpl lfCertificateActivityImpl = new LFCertificateActivityImpl();

        lfCertificateActivityImpl.setNew(lfCertificateActivity.isNew());
        lfCertificateActivityImpl.setPrimaryKey(lfCertificateActivity.getPrimaryKey());

        lfCertificateActivityImpl.setCertificateID(lfCertificateActivity.getCertificateID());
        lfCertificateActivityImpl.setActivityName(lfCertificateActivity.getActivityName());
        lfCertificateActivityImpl.setDatacount(lfCertificateActivity.getDatacount());
        lfCertificateActivityImpl.setPeriodType(lfCertificateActivity.getPeriodType());
        lfCertificateActivityImpl.setPeriod(lfCertificateActivity.getPeriod());

        return lfCertificateActivityImpl;
    }

    /**
     * Returns the l f certificate activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate activity
     * @return the l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFCertificateActivityException, SystemException {
        LFCertificateActivity lfCertificateActivity = fetchByPrimaryKey(primaryKey);

        if (lfCertificateActivity == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFCertificateActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfCertificateActivity;
    }

    /**
     * Returns the l f certificate activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException} if it could not be found.
     *
     * @param lfCertificateActivityPK the primary key of the l f certificate activity
     * @return the l f certificate activity
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateActivityException if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity findByPrimaryKey(
        LFCertificateActivityPK lfCertificateActivityPK)
        throws NoSuchLFCertificateActivityException, SystemException {
        return findByPrimaryKey((Serializable) lfCertificateActivityPK);
    }

    /**
     * Returns the l f certificate activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate activity
     * @return the l f certificate activity, or <code>null</code> if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFCertificateActivity lfCertificateActivity = (LFCertificateActivity) EntityCacheUtil.getResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateActivityImpl.class, primaryKey);

        if (lfCertificateActivity == _nullLFCertificateActivity) {
            return null;
        }

        if (lfCertificateActivity == null) {
            Session session = null;

            try {
                session = openSession();

                lfCertificateActivity = (LFCertificateActivity) session.get(LFCertificateActivityImpl.class,
                        primaryKey);

                if (lfCertificateActivity != null) {
                    cacheResult(lfCertificateActivity);
                } else {
                    EntityCacheUtil.putResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateActivityImpl.class, primaryKey,
                        _nullLFCertificateActivity);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFCertificateActivityModelImpl.ENTITY_CACHE_ENABLED,
                    LFCertificateActivityImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfCertificateActivity;
    }

    /**
     * Returns the l f certificate activity with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfCertificateActivityPK the primary key of the l f certificate activity
     * @return the l f certificate activity, or <code>null</code> if a l f certificate activity with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateActivity fetchByPrimaryKey(
        LFCertificateActivityPK lfCertificateActivityPK)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) lfCertificateActivityPK);
    }

    /**
     * Returns all the l f certificate activities.
     *
     * @return the l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate activities
     * @param end the upper bound of the range of l f certificate activities (not inclusive)
     * @return the range of l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate activities.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate activities
     * @param end the upper bound of the range of l f certificate activities (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate activities
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateActivity> findAll(int start, int end,
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

        List<LFCertificateActivity> list = (List<LFCertificateActivity>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATEACTIVITY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATEACTIVITY;

                if (pagination) {
                    sql = sql.concat(LFCertificateActivityModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFCertificateActivity>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateActivity>(list);
                } else {
                    list = (List<LFCertificateActivity>) QueryUtil.list(q,
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
     * Removes all the l f certificate activities from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFCertificateActivity lfCertificateActivity : findAll()) {
            remove(lfCertificateActivity);
        }
    }

    /**
     * Returns the number of l f certificate activities.
     *
     * @return the number of l f certificate activities
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

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATEACTIVITY);

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

    /**
     * Initializes the l f certificate activity persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateActivity")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateActivity>> listenersList = new ArrayList<ModelListener<LFCertificateActivity>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateActivity>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateActivityImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

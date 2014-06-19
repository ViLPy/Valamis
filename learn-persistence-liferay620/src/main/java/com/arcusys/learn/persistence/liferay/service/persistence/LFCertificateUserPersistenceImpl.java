package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPersistence;

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
 * The persistence implementation for the l f certificate user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateUserPersistence
 * @see LFCertificateUserUtil
 * @generated
 */
public class LFCertificateUserPersistenceImpl extends BasePersistenceImpl<LFCertificateUser>
    implements LFCertificateUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateUserUtil} to access the l f certificate user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Long.class.getName() },
            LFCertificateUserModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertificateID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateUser.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateUser.id.certificateID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateUser.certificateID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
            new String[] { Long.class.getName() },
            LFCertificateUserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_NULL = "lfCertificateUser.userID IS NULL";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "lfCertificateUser.id.userID = ?";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL_2 = "lfCertificateUser.userID IS NULL ";
    public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateUserImpl.class, FINDER_CLASS_NAME_ENTITY,
            "fetchByUserIDAndCertificateID",
            new String[] { Long.class.getName(), Long.class.getName() },
            LFCertificateUserModelImpl.USERID_COLUMN_BITMASK |
            LFCertificateUserModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID = new FinderPath(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserIDAndCertificateID",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL =
        "lfCertificateUser.userID IS NULL";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2 = "lfCertificateUser.id.userID = ? AND ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2 =
        "lfCertificateUser.userID IS NULL  AND ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL =
        "lfCertificateUser.certificateID IS NULL";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2 =
        "lfCertificateUser.id.certificateID = ?";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateUser.certificateID IS NULL ";
    private static final String _SQL_SELECT_LFCERTIFICATEUSER = "SELECT lfCertificateUser FROM LFCertificateUser lfCertificateUser";
    private static final String _SQL_SELECT_LFCERTIFICATEUSER_WHERE = "SELECT lfCertificateUser FROM LFCertificateUser lfCertificateUser WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATEUSER = "SELECT COUNT(lfCertificateUser) FROM LFCertificateUser lfCertificateUser";
    private static final String _SQL_COUNT_LFCERTIFICATEUSER_WHERE = "SELECT COUNT(lfCertificateUser) FROM LFCertificateUser lfCertificateUser WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateUserPersistenceImpl.class);
    private static LFCertificateUser _nullLFCertificateUser = new LFCertificateUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateUser> toCacheModel() {
                return _nullLFCertificateUserCacheModel;
            }
        };

    private static CacheModel<LFCertificateUser> _nullLFCertificateUserCacheModel =
        new CacheModel<LFCertificateUser>() {
            @Override
            public LFCertificateUser toEntityModel() {
                return _nullLFCertificateUser;
            }
        };

    public LFCertificateUserPersistenceImpl() {
        setModelClass(LFCertificateUser.class);
    }

    /**
     * Returns all the l f certificate users where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findByCertificateID(Long certificateID)
        throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findByCertificateID(Long certificateID,
        int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate users where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findByCertificateID(Long certificateID,
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

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateUser lfCertificateUser : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateUser.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

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
                query.append(LFCertificateUserModelImpl.ORDER_BY_JPQL);
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
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateUser>(list);
                } else {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByCertificateID_First(Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByCertificateID_First(Long certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateUser> list = findByCertificateID(certificateID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByCertificateID_Last(Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByCertificateID_Last(Long certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCertificateID(certificateID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateUser> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate users before and after the current l f certificate user in the ordered set where certificateID = &#63;.
     *
     * @param lfCertificateUserPK the primary key of the current l f certificate user
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser[] findByCertificateID_PrevAndNext(
        LFCertificateUserPK lfCertificateUserPK, Long certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = findByPrimaryKey(lfCertificateUserPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateUser[] array = new LFCertificateUserImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateUser, certificateID, orderByComparator, true);

            array[1] = lfCertificateUser;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateUser, certificateID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateUser getByCertificateID_PrevAndNext(
        Session session, LFCertificateUser lfCertificateUser,
        Long certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

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
            query.append(LFCertificateUserModelImpl.ORDER_BY_JPQL);
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
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate users where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCertificateID(Long certificateID)
        throws SystemException {
        for (LFCertificateUser lfCertificateUser : findByCertificateID(
                certificateID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Returns the number of l f certificate users where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate users
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

            query.append(_SQL_COUNT_LFCERTIFICATEUSER_WHERE);

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
     * Returns all the l f certificate users where userID = &#63;.
     *
     * @param userID the user i d
     * @return the matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findByUserID(Long userID)
        throws SystemException {
        return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findByUserID(Long userID, int start, int end)
        throws SystemException {
        return findByUserID(userID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate users where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findByUserID(Long userID, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userID, start, end, orderByComparator };
        }

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateUser lfCertificateUser : list) {
                if (!Validator.equals(userID, lfCertificateUser.getUserID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERID_USERID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.longValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateUser>(list);
                } else {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByUserID_First(Long userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserID_First(userID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByUserID_First(Long userID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateUser> list = findByUserID(userID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByUserID_Last(Long userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserID_Last(userID,
                orderByComparator);

        if (lfCertificateUser != null) {
            return lfCertificateUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByUserID_Last(Long userID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserID(userID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateUser> list = findByUserID(userID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate users before and after the current l f certificate user in the ordered set where userID = &#63;.
     *
     * @param lfCertificateUserPK the primary key of the current l f certificate user
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser[] findByUserID_PrevAndNext(
        LFCertificateUserPK lfCertificateUserPK, Long userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = findByPrimaryKey(lfCertificateUserPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateUser[] array = new LFCertificateUserImpl[3];

            array[0] = getByUserID_PrevAndNext(session, lfCertificateUser,
                    userID, orderByComparator, true);

            array[1] = lfCertificateUser;

            array[2] = getByUserID_PrevAndNext(session, lfCertificateUser,
                    userID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateUser getByUserID_PrevAndNext(Session session,
        LFCertificateUser lfCertificateUser, Long userID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

        if (userID == null) {
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
            query.append(LFCertificateUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (userID != null) {
            qPos.add(userID.longValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate users where userID = &#63; from the database.
     *
     * @param userID the user i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserID(Long userID) throws SystemException {
        for (LFCertificateUser lfCertificateUser : findByUserID(userID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Returns the number of l f certificate users where userID = &#63;.
     *
     * @param userID the user i d
     * @return the number of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserID(Long userID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATEUSER_WHERE);

            if (userID == null) {
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

                if (userID != null) {
                    qPos.add(userID.longValue());
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
     * Returns the l f certificate user where userID = &#63; and certificateID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException} if it could not be found.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the matching l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByUserIDAndCertificateID(Long userID,
        Long certificateID)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByUserIDAndCertificateID(userID,
                certificateID);

        if (lfCertificateUser == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("userID=");
            msg.append(userID);

            msg.append(", certificateID=");
            msg.append(certificateID);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchLFCertificateUserException(msg.toString());
        }

        return lfCertificateUser;
    }

    /**
     * Returns the l f certificate user where userID = &#63; and certificateID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByUserIDAndCertificateID(Long userID,
        Long certificateID) throws SystemException {
        return fetchByUserIDAndCertificateID(userID, certificateID, true);
    }

    /**
     * Returns the l f certificate user where userID = &#63; and certificateID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByUserIDAndCertificateID(Long userID,
        Long certificateID, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { userID, certificateID };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                    finderArgs, this);
        }

        if (result instanceof LFCertificateUser) {
            LFCertificateUser lfCertificateUser = (LFCertificateUser) result;

            if (!Validator.equals(userID, lfCertificateUser.getUserID()) ||
                    !Validator.equals(certificateID,
                        lfCertificateUser.getCertificateID())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_LFCERTIFICATEUSER_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2);
            }

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.longValue());
                }

                if (certificateID != null) {
                    qPos.add(certificateID.longValue());
                }

                List<LFCertificateUser> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "LFCertificateUserPersistenceImpl.fetchByUserIDAndCertificateID(Long, Long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    LFCertificateUser lfCertificateUser = list.get(0);

                    result = lfCertificateUser;

                    cacheResult(lfCertificateUser);

                    if ((lfCertificateUser.getUserID() != userID) ||
                            (lfCertificateUser.getCertificateID() != certificateID)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                            finderArgs, lfCertificateUser);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (LFCertificateUser) result;
        }
    }

    /**
     * Removes the l f certificate user where userID = &#63; and certificateID = &#63; from the database.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the l f certificate user that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser removeByUserIDAndCertificateID(Long userID,
        Long certificateID)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = findByUserIDAndCertificateID(userID,
                certificateID);

        return remove(lfCertificateUser);
    }

    /**
     * Returns the number of l f certificate users where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserIDAndCertificateID(Long userID, Long certificateID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID;

        Object[] finderArgs = new Object[] { userID, certificateID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATEUSER_WHERE);

            if (userID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2);
            }

            if (certificateID == null) {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2);
            } else {
                query.append(_FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.longValue());
                }

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
     * Caches the l f certificate user in the entity cache if it is enabled.
     *
     * @param lfCertificateUser the l f certificate user
     */
    @Override
    public void cacheResult(LFCertificateUser lfCertificateUser) {
        EntityCacheUtil.putResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey(),
            lfCertificateUser);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
            new Object[] {
                lfCertificateUser.getUserID(),
                lfCertificateUser.getCertificateID()
            }, lfCertificateUser);

        lfCertificateUser.resetOriginalValues();
    }

    /**
     * Caches the l f certificate users in the entity cache if it is enabled.
     *
     * @param lfCertificateUsers the l f certificate users
     */
    @Override
    public void cacheResult(List<LFCertificateUser> lfCertificateUsers) {
        for (LFCertificateUser lfCertificateUser : lfCertificateUsers) {
            if (EntityCacheUtil.getResult(
                        LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateUserImpl.class,
                        lfCertificateUser.getPrimaryKey()) == null) {
                cacheResult(lfCertificateUser);
            } else {
                lfCertificateUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificateUser lfCertificateUser) {
        EntityCacheUtil.removeResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(lfCertificateUser);
    }

    @Override
    public void clearCache(List<LFCertificateUser> lfCertificateUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateUser lfCertificateUser : lfCertificateUsers) {
            EntityCacheUtil.removeResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey());

            clearUniqueFindersCache(lfCertificateUser);
        }
    }

    protected void cacheUniqueFindersCache(LFCertificateUser lfCertificateUser) {
        if (lfCertificateUser.isNew()) {
            Object[] args = new Object[] {
                    lfCertificateUser.getUserID(),
                    lfCertificateUser.getCertificateID()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                args, lfCertificateUser);
        } else {
            LFCertificateUserModelImpl lfCertificateUserModelImpl = (LFCertificateUserModelImpl) lfCertificateUser;

            if ((lfCertificateUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateUser.getUserID(),
                        lfCertificateUser.getCertificateID()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                    args, lfCertificateUser);
            }
        }
    }

    protected void clearUniqueFindersCache(LFCertificateUser lfCertificateUser) {
        LFCertificateUserModelImpl lfCertificateUserModelImpl = (LFCertificateUserModelImpl) lfCertificateUser;

        Object[] args = new Object[] {
                lfCertificateUser.getUserID(),
                lfCertificateUser.getCertificateID()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
            args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
            args);

        if ((lfCertificateUserModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID.getColumnBitmask()) != 0) {
            args = new Object[] {
                    lfCertificateUserModelImpl.getOriginalUserID(),
                    lfCertificateUserModelImpl.getOriginalCertificateID()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDCERTIFICATEID,
                args);
        }
    }

    /**
     * Creates a new l f certificate user with the primary key. Does not add the l f certificate user to the database.
     *
     * @param lfCertificateUserPK the primary key for the new l f certificate user
     * @return the new l f certificate user
     */
    @Override
    public LFCertificateUser create(LFCertificateUserPK lfCertificateUserPK) {
        LFCertificateUser lfCertificateUser = new LFCertificateUserImpl();

        lfCertificateUser.setNew(true);
        lfCertificateUser.setPrimaryKey(lfCertificateUserPK);

        return lfCertificateUser;
    }

    /**
     * Removes the l f certificate user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfCertificateUserPK the primary key of the l f certificate user
     * @return the l f certificate user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser remove(LFCertificateUserPK lfCertificateUserPK)
        throws NoSuchLFCertificateUserException, SystemException {
        return remove((Serializable) lfCertificateUserPK);
    }

    /**
     * Removes the l f certificate user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate user
     * @return the l f certificate user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser remove(Serializable primaryKey)
        throws NoSuchLFCertificateUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateUser lfCertificateUser = (LFCertificateUser) session.get(LFCertificateUserImpl.class,
                    primaryKey);

            if (lfCertificateUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateUser);
        } catch (NoSuchLFCertificateUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateUser removeImpl(LFCertificateUser lfCertificateUser)
        throws SystemException {
        lfCertificateUser = toUnwrappedModel(lfCertificateUser);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfCertificateUser)) {
                lfCertificateUser = (LFCertificateUser) session.get(LFCertificateUserImpl.class,
                        lfCertificateUser.getPrimaryKeyObj());
            }

            if (lfCertificateUser != null) {
                session.delete(lfCertificateUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfCertificateUser != null) {
            clearCache(lfCertificateUser);
        }

        return lfCertificateUser;
    }

    @Override
    public LFCertificateUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser)
        throws SystemException {
        lfCertificateUser = toUnwrappedModel(lfCertificateUser);

        boolean isNew = lfCertificateUser.isNew();

        LFCertificateUserModelImpl lfCertificateUserModelImpl = (LFCertificateUserModelImpl) lfCertificateUser;

        Session session = null;

        try {
            session = openSession();

            if (lfCertificateUser.isNew()) {
                session.save(lfCertificateUser);

                lfCertificateUser.setNew(false);
            } else {
                session.merge(lfCertificateUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateUserModelImpl.getOriginalCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        lfCertificateUserModelImpl.getCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateUserModelImpl.getOriginalUserID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { lfCertificateUserModelImpl.getUserID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateUserImpl.class, lfCertificateUser.getPrimaryKey(),
            lfCertificateUser);

        clearUniqueFindersCache(lfCertificateUser);
        cacheUniqueFindersCache(lfCertificateUser);

        return lfCertificateUser;
    }

    protected LFCertificateUser toUnwrappedModel(
        LFCertificateUser lfCertificateUser) {
        if (lfCertificateUser instanceof LFCertificateUserImpl) {
            return lfCertificateUser;
        }

        LFCertificateUserImpl lfCertificateUserImpl = new LFCertificateUserImpl();

        lfCertificateUserImpl.setNew(lfCertificateUser.isNew());
        lfCertificateUserImpl.setPrimaryKey(lfCertificateUser.getPrimaryKey());

        lfCertificateUserImpl.setCertificateID(lfCertificateUser.getCertificateID());
        lfCertificateUserImpl.setUserID(lfCertificateUser.getUserID());
        lfCertificateUserImpl.setAttachedDate(lfCertificateUser.getAttachedDate());

        return lfCertificateUserImpl;
    }

    /**
     * Returns the l f certificate user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate user
     * @return the l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFCertificateUserException, SystemException {
        LFCertificateUser lfCertificateUser = fetchByPrimaryKey(primaryKey);

        if (lfCertificateUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFCertificateUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfCertificateUser;
    }

    /**
     * Returns the l f certificate user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException} if it could not be found.
     *
     * @param lfCertificateUserPK the primary key of the l f certificate user
     * @return the l f certificate user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser findByPrimaryKey(
        LFCertificateUserPK lfCertificateUserPK)
        throws NoSuchLFCertificateUserException, SystemException {
        return findByPrimaryKey((Serializable) lfCertificateUserPK);
    }

    /**
     * Returns the l f certificate user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate user
     * @return the l f certificate user, or <code>null</code> if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFCertificateUser lfCertificateUser = (LFCertificateUser) EntityCacheUtil.getResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateUserImpl.class, primaryKey);

        if (lfCertificateUser == _nullLFCertificateUser) {
            return null;
        }

        if (lfCertificateUser == null) {
            Session session = null;

            try {
                session = openSession();

                lfCertificateUser = (LFCertificateUser) session.get(LFCertificateUserImpl.class,
                        primaryKey);

                if (lfCertificateUser != null) {
                    cacheResult(lfCertificateUser);
                } else {
                    EntityCacheUtil.putResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateUserImpl.class, primaryKey,
                        _nullLFCertificateUser);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFCertificateUserModelImpl.ENTITY_CACHE_ENABLED,
                    LFCertificateUserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfCertificateUser;
    }

    /**
     * Returns the l f certificate user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfCertificateUserPK the primary key of the l f certificate user
     * @return the l f certificate user, or <code>null</code> if a l f certificate user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateUser fetchByPrimaryKey(
        LFCertificateUserPK lfCertificateUserPK) throws SystemException {
        return fetchByPrimaryKey((Serializable) lfCertificateUserPK);
    }

    /**
     * Returns all the l f certificate users.
     *
     * @return the l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @return the range of l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate users
     * @param end the upper bound of the range of l f certificate users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateUser> findAll(int start, int end,
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

        List<LFCertificateUser> list = (List<LFCertificateUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATEUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATEUSER;

                if (pagination) {
                    sql = sql.concat(LFCertificateUserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateUser>(list);
                } else {
                    list = (List<LFCertificateUser>) QueryUtil.list(q,
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
     * Removes all the l f certificate users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFCertificateUser lfCertificateUser : findAll()) {
            remove(lfCertificateUser);
        }
    }

    /**
     * Returns the number of l f certificate users.
     *
     * @return the number of l f certificate users
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

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATEUSER);

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
     * Initializes the l f certificate user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateUser>> listenersList = new ArrayList<ModelListener<LFCertificateUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateUser>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

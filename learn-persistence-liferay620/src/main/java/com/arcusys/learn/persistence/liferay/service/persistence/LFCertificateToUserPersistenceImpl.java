package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateToUser;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserImpl;
import com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPersistence;

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
 * The persistence implementation for the l f certificate to user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUserPersistence
 * @see LFCertificateToUserUtil
 * @generated
 */
public class LFCertificateToUserPersistenceImpl extends BasePersistenceImpl<LFCertificateToUser>
    implements LFCertificateToUserPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LFCertificateToUserUtil} to access the l f certificate to user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LFCertificateToUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID =
        new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateID",
            new String[] { Integer.class.getName() },
            LFCertificateToUserModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATEID = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCertificateID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL = "lfCertificateToUser.certificateID IS NULL";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_2 = "lfCertificateToUser.id.certificateID = ?";
    private static final String _FINDER_COLUMN_CERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateToUser.certificateID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserID",
            new String[] {
                Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserID",
            new String[] { Integer.class.getName() },
            LFCertificateToUserModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserID",
            new String[] { Integer.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_NULL = "lfCertificateToUser.userID IS NULL";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "lfCertificateToUser.id.userID = ?";
    private static final String _FINDER_COLUMN_USERID_USERID_NULL_2 = "lfCertificateToUser.userID IS NULL ";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID =
        new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByUserIDAndCertificateID",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID =
        new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED,
            LFCertificateToUserImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByUserIDAndCertificateID",
            new String[] { Integer.class.getName(), Integer.class.getName() },
            LFCertificateToUserModelImpl.USERID_COLUMN_BITMASK |
            LFCertificateToUserModelImpl.CERTIFICATEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID = new FinderPath(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByUserIDAndCertificateID",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL =
        "lfCertificateToUser.userID IS NULL";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_2 = "lfCertificateToUser.id.userID = ? AND ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_USERID_NULL_2 =
        "lfCertificateToUser.userID IS NULL  AND ";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL =
        "lfCertificateToUser.certificateID IS NULL";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_2 =
        "lfCertificateToUser.id.certificateID = ?";
    private static final String _FINDER_COLUMN_USERIDANDCERTIFICATEID_CERTIFICATEID_NULL_2 =
        "lfCertificateToUser.certificateID IS NULL ";
    private static final String _SQL_SELECT_LFCERTIFICATETOUSER = "SELECT lfCertificateToUser FROM LFCertificateToUser lfCertificateToUser";
    private static final String _SQL_SELECT_LFCERTIFICATETOUSER_WHERE = "SELECT lfCertificateToUser FROM LFCertificateToUser lfCertificateToUser WHERE ";
    private static final String _SQL_COUNT_LFCERTIFICATETOUSER = "SELECT COUNT(lfCertificateToUser) FROM LFCertificateToUser lfCertificateToUser";
    private static final String _SQL_COUNT_LFCERTIFICATETOUSER_WHERE = "SELECT COUNT(lfCertificateToUser) FROM LFCertificateToUser lfCertificateToUser WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "lfCertificateToUser.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LFCertificateToUser exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LFCertificateToUser exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LFCertificateToUserPersistenceImpl.class);
    private static LFCertificateToUser _nullLFCertificateToUser = new LFCertificateToUserImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<LFCertificateToUser> toCacheModel() {
                return _nullLFCertificateToUserCacheModel;
            }
        };

    private static CacheModel<LFCertificateToUser> _nullLFCertificateToUserCacheModel =
        new CacheModel<LFCertificateToUser>() {
            @Override
            public LFCertificateToUser toEntityModel() {
                return _nullLFCertificateToUser;
            }
        };

    public LFCertificateToUserPersistenceImpl() {
        setModelClass(LFCertificateToUser.class);
    }

    /**
     * Returns all the l f certificate to users where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByCertificateID(Integer certificateID)
        throws SystemException {
        return findByCertificateID(certificateID, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate to users where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @return the range of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByCertificateID(
        Integer certificateID, int start, int end) throws SystemException {
        return findByCertificateID(certificateID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate to users where certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByCertificateID(
        Integer certificateID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
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

        List<LFCertificateToUser> list = (List<LFCertificateToUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateToUser lfCertificateToUser : list) {
                if (!Validator.equals(certificateID,
                            lfCertificateToUser.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATETOUSER_WHERE);

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
                query.append(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateToUser>(list);
                } else {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate to user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByCertificateID_First(
        Integer certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByCertificateID_First(certificateID,
                orderByComparator);

        if (lfCertificateToUser != null) {
            return lfCertificateToUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateToUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate to user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByCertificateID_First(
        Integer certificateID, OrderByComparator orderByComparator)
        throws SystemException {
        List<LFCertificateToUser> list = findByCertificateID(certificateID, 0,
                1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate to user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByCertificateID_Last(Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByCertificateID_Last(certificateID,
                orderByComparator);

        if (lfCertificateToUser != null) {
            return lfCertificateToUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateToUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate to user in the ordered set where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByCertificateID_Last(
        Integer certificateID, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCertificateID(certificateID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateToUser> list = findByCertificateID(certificateID,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate to users before and after the current l f certificate to user in the ordered set where certificateID = &#63;.
     *
     * @param lfCertificateToUserPK the primary key of the current l f certificate to user
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser[] findByCertificateID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = findByPrimaryKey(lfCertificateToUserPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateToUser[] array = new LFCertificateToUserImpl[3];

            array[0] = getByCertificateID_PrevAndNext(session,
                    lfCertificateToUser, certificateID, orderByComparator, true);

            array[1] = lfCertificateToUser;

            array[2] = getByCertificateID_PrevAndNext(session,
                    lfCertificateToUser, certificateID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateToUser getByCertificateID_PrevAndNext(
        Session session, LFCertificateToUser lfCertificateToUser,
        Integer certificateID, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETOUSER_WHERE);

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
            query.append(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (certificateID != null) {
            qPos.add(certificateID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateToUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateToUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate to users where certificateID = &#63; from the database.
     *
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByCertificateID(Integer certificateID)
        throws SystemException {
        for (LFCertificateToUser lfCertificateToUser : findByCertificateID(
                certificateID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateToUser);
        }
    }

    /**
     * Returns the number of l f certificate to users where certificateID = &#63;.
     *
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByCertificateID(Integer certificateID)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATEID;

        Object[] finderArgs = new Object[] { certificateID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATETOUSER_WHERE);

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
                    qPos.add(certificateID.intValue());
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
     * Returns all the l f certificate to users where userID = &#63;.
     *
     * @param userID the user i d
     * @return the matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByUserID(Integer userID)
        throws SystemException {
        return findByUserID(userID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate to users where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @return the range of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByUserID(Integer userID, int start,
        int end) throws SystemException {
        return findByUserID(userID, start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate to users where userID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userID the user i d
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByUserID(Integer userID, int start,
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

        List<LFCertificateToUser> list = (List<LFCertificateToUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateToUser lfCertificateToUser : list) {
                if (!Validator.equals(userID, lfCertificateToUser.getUserID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATETOUSER_WHERE);

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
                query.append(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateToUser>(list);
                } else {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate to user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByUserID_First(Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByUserID_First(userID,
                orderByComparator);

        if (lfCertificateToUser != null) {
            return lfCertificateToUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateToUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate to user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByUserID_First(Integer userID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateToUser> list = findByUserID(userID, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate to user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByUserID_Last(Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByUserID_Last(userID,
                orderByComparator);

        if (lfCertificateToUser != null) {
            return lfCertificateToUser;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateToUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate to user in the ordered set where userID = &#63;.
     *
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByUserID_Last(Integer userID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserID(userID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateToUser> list = findByUserID(userID, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate to users before and after the current l f certificate to user in the ordered set where userID = &#63;.
     *
     * @param lfCertificateToUserPK the primary key of the current l f certificate to user
     * @param userID the user i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser[] findByUserID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, Integer userID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = findByPrimaryKey(lfCertificateToUserPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateToUser[] array = new LFCertificateToUserImpl[3];

            array[0] = getByUserID_PrevAndNext(session, lfCertificateToUser,
                    userID, orderByComparator, true);

            array[1] = lfCertificateToUser;

            array[2] = getByUserID_PrevAndNext(session, lfCertificateToUser,
                    userID, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateToUser getByUserID_PrevAndNext(Session session,
        LFCertificateToUser lfCertificateToUser, Integer userID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETOUSER_WHERE);

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
            query.append(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (userID != null) {
            qPos.add(userID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateToUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateToUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate to users where userID = &#63; from the database.
     *
     * @param userID the user i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserID(Integer userID) throws SystemException {
        for (LFCertificateToUser lfCertificateToUser : findByUserID(userID,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(lfCertificateToUser);
        }
    }

    /**
     * Returns the number of l f certificate to users where userID = &#63;.
     *
     * @param userID the user i d
     * @return the number of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserID(Integer userID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LFCERTIFICATETOUSER_WHERE);

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
                    qPos.add(userID.intValue());
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
     * Returns all the l f certificate to users where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByUserIDAndCertificateID(
        Integer userID, Integer certificateID) throws SystemException {
        return findByUserIDAndCertificateID(userID, certificateID,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate to users where userID = &#63; and certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @return the range of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByUserIDAndCertificateID(
        Integer userID, Integer certificateID, int start, int end)
        throws SystemException {
        return findByUserIDAndCertificateID(userID, certificateID, start, end,
            null);
    }

    /**
     * Returns an ordered range of all the l f certificate to users where userID = &#63; and certificateID = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findByUserIDAndCertificateID(
        Integer userID, Integer certificateID, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID;
            finderArgs = new Object[] { userID, certificateID };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID;
            finderArgs = new Object[] {
                    userID, certificateID,
                    
                    start, end, orderByComparator
                };
        }

        List<LFCertificateToUser> list = (List<LFCertificateToUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (LFCertificateToUser lfCertificateToUser : list) {
                if (!Validator.equals(userID, lfCertificateToUser.getUserID()) ||
                        !Validator.equals(certificateID,
                            lfCertificateToUser.getCertificateID())) {
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

            query.append(_SQL_SELECT_LFCERTIFICATETOUSER_WHERE);

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

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (userID != null) {
                    qPos.add(userID.intValue());
                }

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
                }

                if (!pagination) {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateToUser>(list);
                } else {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
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
     * Returns the first l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByUserIDAndCertificateID_First(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByUserIDAndCertificateID_First(userID,
                certificateID, orderByComparator);

        if (lfCertificateToUser != null) {
            return lfCertificateToUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(", certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateToUserException(msg.toString());
    }

    /**
     * Returns the first l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByUserIDAndCertificateID_First(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        List<LFCertificateToUser> list = findByUserIDAndCertificateID(userID,
                certificateID, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByUserIDAndCertificateID_Last(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByUserIDAndCertificateID_Last(userID,
                certificateID, orderByComparator);

        if (lfCertificateToUser != null) {
            return lfCertificateToUser;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userID=");
        msg.append(userID);

        msg.append(", certificateID=");
        msg.append(certificateID);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLFCertificateToUserException(msg.toString());
    }

    /**
     * Returns the last l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByUserIDAndCertificateID_Last(
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserIDAndCertificateID(userID, certificateID);

        if (count == 0) {
            return null;
        }

        List<LFCertificateToUser> list = findByUserIDAndCertificateID(userID,
                certificateID, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the l f certificate to users before and after the current l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
     *
     * @param lfCertificateToUserPK the primary key of the current l f certificate to user
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser[] findByUserIDAndCertificateID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, Integer userID,
        Integer certificateID, OrderByComparator orderByComparator)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = findByPrimaryKey(lfCertificateToUserPK);

        Session session = null;

        try {
            session = openSession();

            LFCertificateToUser[] array = new LFCertificateToUserImpl[3];

            array[0] = getByUserIDAndCertificateID_PrevAndNext(session,
                    lfCertificateToUser, userID, certificateID,
                    orderByComparator, true);

            array[1] = lfCertificateToUser;

            array[2] = getByUserIDAndCertificateID_PrevAndNext(session,
                    lfCertificateToUser, userID, certificateID,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected LFCertificateToUser getByUserIDAndCertificateID_PrevAndNext(
        Session session, LFCertificateToUser lfCertificateToUser,
        Integer userID, Integer certificateID,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LFCERTIFICATETOUSER_WHERE);

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
            query.append(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (userID != null) {
            qPos.add(userID.intValue());
        }

        if (certificateID != null) {
            qPos.add(certificateID.intValue());
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(lfCertificateToUser);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<LFCertificateToUser> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the l f certificate to users where userID = &#63; and certificateID = &#63; from the database.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserIDAndCertificateID(Integer userID,
        Integer certificateID) throws SystemException {
        for (LFCertificateToUser lfCertificateToUser : findByUserIDAndCertificateID(
                userID, certificateID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(lfCertificateToUser);
        }
    }

    /**
     * Returns the number of l f certificate to users where userID = &#63; and certificateID = &#63;.
     *
     * @param userID the user i d
     * @param certificateID the certificate i d
     * @return the number of matching l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserIDAndCertificateID(Integer userID,
        Integer certificateID) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID;

        Object[] finderArgs = new Object[] { userID, certificateID };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_LFCERTIFICATETOUSER_WHERE);

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
                    qPos.add(userID.intValue());
                }

                if (certificateID != null) {
                    qPos.add(certificateID.intValue());
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
     * Caches the l f certificate to user in the entity cache if it is enabled.
     *
     * @param lfCertificateToUser the l f certificate to user
     */
    @Override
    public void cacheResult(LFCertificateToUser lfCertificateToUser) {
        EntityCacheUtil.putResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserImpl.class, lfCertificateToUser.getPrimaryKey(),
            lfCertificateToUser);

        lfCertificateToUser.resetOriginalValues();
    }

    /**
     * Caches the l f certificate to users in the entity cache if it is enabled.
     *
     * @param lfCertificateToUsers the l f certificate to users
     */
    @Override
    public void cacheResult(List<LFCertificateToUser> lfCertificateToUsers) {
        for (LFCertificateToUser lfCertificateToUser : lfCertificateToUsers) {
            if (EntityCacheUtil.getResult(
                        LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateToUserImpl.class,
                        lfCertificateToUser.getPrimaryKey()) == null) {
                cacheResult(lfCertificateToUser);
            } else {
                lfCertificateToUser.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all l f certificate to users.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LFCertificateToUserImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LFCertificateToUserImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the l f certificate to user.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(LFCertificateToUser lfCertificateToUser) {
        EntityCacheUtil.removeResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserImpl.class, lfCertificateToUser.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<LFCertificateToUser> lfCertificateToUsers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (LFCertificateToUser lfCertificateToUser : lfCertificateToUsers) {
            EntityCacheUtil.removeResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateToUserImpl.class,
                lfCertificateToUser.getPrimaryKey());
        }
    }

    /**
     * Creates a new l f certificate to user with the primary key. Does not add the l f certificate to user to the database.
     *
     * @param lfCertificateToUserPK the primary key for the new l f certificate to user
     * @return the new l f certificate to user
     */
    @Override
    public LFCertificateToUser create(
        LFCertificateToUserPK lfCertificateToUserPK) {
        LFCertificateToUser lfCertificateToUser = new LFCertificateToUserImpl();

        lfCertificateToUser.setNew(true);
        lfCertificateToUser.setPrimaryKey(lfCertificateToUserPK);

        return lfCertificateToUser;
    }

    /**
     * Removes the l f certificate to user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param lfCertificateToUserPK the primary key of the l f certificate to user
     * @return the l f certificate to user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser remove(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws NoSuchLFCertificateToUserException, SystemException {
        return remove((Serializable) lfCertificateToUserPK);
    }

    /**
     * Removes the l f certificate to user with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the l f certificate to user
     * @return the l f certificate to user that was removed
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser remove(Serializable primaryKey)
        throws NoSuchLFCertificateToUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LFCertificateToUser lfCertificateToUser = (LFCertificateToUser) session.get(LFCertificateToUserImpl.class,
                    primaryKey);

            if (lfCertificateToUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLFCertificateToUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(lfCertificateToUser);
        } catch (NoSuchLFCertificateToUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected LFCertificateToUser removeImpl(
        LFCertificateToUser lfCertificateToUser) throws SystemException {
        lfCertificateToUser = toUnwrappedModel(lfCertificateToUser);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(lfCertificateToUser)) {
                lfCertificateToUser = (LFCertificateToUser) session.get(LFCertificateToUserImpl.class,
                        lfCertificateToUser.getPrimaryKeyObj());
            }

            if (lfCertificateToUser != null) {
                session.delete(lfCertificateToUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (lfCertificateToUser != null) {
            clearCache(lfCertificateToUser);
        }

        return lfCertificateToUser;
    }

    @Override
    public LFCertificateToUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws SystemException {
        lfCertificateToUser = toUnwrappedModel(lfCertificateToUser);

        boolean isNew = lfCertificateToUser.isNew();

        LFCertificateToUserModelImpl lfCertificateToUserModelImpl = (LFCertificateToUserModelImpl) lfCertificateToUser;

        Session session = null;

        try {
            session = openSession();

            if (lfCertificateToUser.isNew()) {
                session.save(lfCertificateToUser);

                lfCertificateToUser.setNew(false);
            } else {
                session.merge(lfCertificateToUser);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LFCertificateToUserModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((lfCertificateToUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateToUserModelImpl.getOriginalCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);

                args = new Object[] {
                        lfCertificateToUserModelImpl.getCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATEID,
                    args);
            }

            if ((lfCertificateToUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateToUserModelImpl.getOriginalUserID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { lfCertificateToUserModelImpl.getUserID() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((lfCertificateToUserModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        lfCertificateToUserModelImpl.getOriginalUserID(),
                        lfCertificateToUserModelImpl.getOriginalCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID,
                    args);

                args = new Object[] {
                        lfCertificateToUserModelImpl.getUserID(),
                        lfCertificateToUserModelImpl.getCertificateID()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDCERTIFICATEID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDCERTIFICATEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
            LFCertificateToUserImpl.class, lfCertificateToUser.getPrimaryKey(),
            lfCertificateToUser);

        return lfCertificateToUser;
    }

    protected LFCertificateToUser toUnwrappedModel(
        LFCertificateToUser lfCertificateToUser) {
        if (lfCertificateToUser instanceof LFCertificateToUserImpl) {
            return lfCertificateToUser;
        }

        LFCertificateToUserImpl lfCertificateToUserImpl = new LFCertificateToUserImpl();

        lfCertificateToUserImpl.setNew(lfCertificateToUser.isNew());
        lfCertificateToUserImpl.setPrimaryKey(lfCertificateToUser.getPrimaryKey());

        lfCertificateToUserImpl.setCertificateID(lfCertificateToUser.getCertificateID());
        lfCertificateToUserImpl.setUserID(lfCertificateToUser.getUserID());
        lfCertificateToUserImpl.setStatus(lfCertificateToUser.getStatus());
        lfCertificateToUserImpl.setAddedToUserDate(lfCertificateToUser.getAddedToUserDate());

        return lfCertificateToUserImpl;
    }

    /**
     * Returns the l f certificate to user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate to user
     * @return the l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByPrimaryKey(Serializable primaryKey)
        throws NoSuchLFCertificateToUserException, SystemException {
        LFCertificateToUser lfCertificateToUser = fetchByPrimaryKey(primaryKey);

        if (lfCertificateToUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchLFCertificateToUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return lfCertificateToUser;
    }

    /**
     * Returns the l f certificate to user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException} if it could not be found.
     *
     * @param lfCertificateToUserPK the primary key of the l f certificate to user
     * @return the l f certificate to user
     * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser findByPrimaryKey(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws NoSuchLFCertificateToUserException, SystemException {
        return findByPrimaryKey((Serializable) lfCertificateToUserPK);
    }

    /**
     * Returns the l f certificate to user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the l f certificate to user
     * @return the l f certificate to user, or <code>null</code> if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        LFCertificateToUser lfCertificateToUser = (LFCertificateToUser) EntityCacheUtil.getResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
                LFCertificateToUserImpl.class, primaryKey);

        if (lfCertificateToUser == _nullLFCertificateToUser) {
            return null;
        }

        if (lfCertificateToUser == null) {
            Session session = null;

            try {
                session = openSession();

                lfCertificateToUser = (LFCertificateToUser) session.get(LFCertificateToUserImpl.class,
                        primaryKey);

                if (lfCertificateToUser != null) {
                    cacheResult(lfCertificateToUser);
                } else {
                    EntityCacheUtil.putResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
                        LFCertificateToUserImpl.class, primaryKey,
                        _nullLFCertificateToUser);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(LFCertificateToUserModelImpl.ENTITY_CACHE_ENABLED,
                    LFCertificateToUserImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return lfCertificateToUser;
    }

    /**
     * Returns the l f certificate to user with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param lfCertificateToUserPK the primary key of the l f certificate to user
     * @return the l f certificate to user, or <code>null</code> if a l f certificate to user with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public LFCertificateToUser fetchByPrimaryKey(
        LFCertificateToUserPK lfCertificateToUserPK) throws SystemException {
        return fetchByPrimaryKey((Serializable) lfCertificateToUserPK);
    }

    /**
     * Returns all the l f certificate to users.
     *
     * @return the l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the l f certificate to users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @return the range of l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the l f certificate to users.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of l f certificate to users
     * @param end the upper bound of the range of l f certificate to users (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of l f certificate to users
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<LFCertificateToUser> findAll(int start, int end,
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

        List<LFCertificateToUser> list = (List<LFCertificateToUser>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LFCERTIFICATETOUSER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LFCERTIFICATETOUSER;

                if (pagination) {
                    sql = sql.concat(LFCertificateToUserModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<LFCertificateToUser>(list);
                } else {
                    list = (List<LFCertificateToUser>) QueryUtil.list(q,
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
     * Removes all the l f certificate to users from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (LFCertificateToUser lfCertificateToUser : findAll()) {
            remove(lfCertificateToUser);
        }
    }

    /**
     * Returns the number of l f certificate to users.
     *
     * @return the number of l f certificate to users
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

                Query q = session.createQuery(_SQL_COUNT_LFCERTIFICATETOUSER);

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
     * Initializes the l f certificate to user persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arcusys.learn.persistence.liferay.model.LFCertificateToUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LFCertificateToUser>> listenersList = new ArrayList<ModelListener<LFCertificateToUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LFCertificateToUser>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LFCertificateToUserImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f certificate user service. This utility wraps {@link LFCertificateUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateUserPersistence
 * @see LFCertificateUserPersistenceImpl
 * @generated
 */
public class LFCertificateUserUtil {
    private static LFCertificateUserPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LFCertificateUser lfCertificateUser) {
        getPersistence().clearCache(lfCertificateUser);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFCertificateUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFCertificateUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFCertificateUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFCertificateUser update(LFCertificateUser lfCertificateUser)
        throws SystemException {
        return getPersistence().update(lfCertificateUser);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFCertificateUser update(
        LFCertificateUser lfCertificateUser, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfCertificateUser, serviceContext);
    }

    /**
    * Returns all the l f certificate users where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByCertificateID(
        java.lang.Integer certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID, start, end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByCertificateID(
        java.lang.Integer certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID(certificateID, start, end,
            orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the first l f certificate user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_First(certificateID, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the l f certificate users before and after the current l f certificate user in the ordered set where certificateID = &#63;.
    *
    * @param id the primary key of the current l f certificate user
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser[] findByCertificateID_PrevAndNext(
        long id, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_PrevAndNext(id, certificateID,
            orderByComparator);
    }

    /**
    * Removes all the l f certificate users where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCertificateID(certificateID);
    }

    /**
    * Returns the number of l f certificate users where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCertificateID(certificateID);
    }

    /**
    * Returns all the l f certificate users where userID = &#63;.
    *
    * @param userID the user i d
    * @return the matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID(userID);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserID(
        java.lang.Integer userID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID(userID, start, end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserID(
        java.lang.Integer userID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserID(userID, start, end, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID_First(userID, orderByComparator);
    }

    /**
    * Returns the first l f certificate user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserID_First(userID, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID_Last(userID, orderByComparator);
    }

    /**
    * Returns the last l f certificate user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserID_Last(userID, orderByComparator);
    }

    /**
    * Returns the l f certificate users before and after the current l f certificate user in the ordered set where userID = &#63;.
    *
    * @param id the primary key of the current l f certificate user
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser[] findByUserID_PrevAndNext(
        long id, java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserID_PrevAndNext(id, userID, orderByComparator);
    }

    /**
    * Removes all the l f certificate users where userID = &#63; from the database.
    *
    * @param userID the user i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserID(userID);
    }

    /**
    * Returns the number of l f certificate users where userID = &#63;.
    *
    * @param userID the user i d
    * @return the number of matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserID(userID);
    }

    /**
    * Returns all the l f certificate users where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @return the matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID(userID, certificateID);
    }

    /**
    * Returns a range of all the l f certificate users where userID = &#63; and certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate users
    * @param end the upper bound of the range of l f certificate users (not inclusive)
    * @return the range of matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID(userID, certificateID, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f certificate users where userID = &#63; and certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate users
    * @param end the upper bound of the range of l f certificate users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID(userID, certificateID, start,
            end, orderByComparator);
    }

    /**
    * Returns the first l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByUserIDAndCertificateID_First(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID_First(userID, certificateID,
            orderByComparator);
    }

    /**
    * Returns the first l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByUserIDAndCertificateID_First(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIDAndCertificateID_First(userID, certificateID,
            orderByComparator);
    }

    /**
    * Returns the last l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByUserIDAndCertificateID_Last(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID_Last(userID, certificateID,
            orderByComparator);
    }

    /**
    * Returns the last l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate user, or <code>null</code> if a matching l f certificate user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByUserIDAndCertificateID_Last(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIDAndCertificateID_Last(userID, certificateID,
            orderByComparator);
    }

    /**
    * Returns the l f certificate users before and after the current l f certificate user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param id the primary key of the current l f certificate user
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser[] findByUserIDAndCertificateID_PrevAndNext(
        long id, java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID_PrevAndNext(id, userID,
            certificateID, orderByComparator);
    }

    /**
    * Removes all the l f certificate users where userID = &#63; and certificateID = &#63; from the database.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserIDAndCertificateID(userID, certificateID);
    }

    /**
    * Returns the number of l f certificate users where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIDAndCertificateID(java.lang.Integer userID,
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByUserIDAndCertificateID(userID, certificateID);
    }

    /**
    * Caches the l f certificate user in the entity cache if it is enabled.
    *
    * @param lfCertificateUser the l f certificate user
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser) {
        getPersistence().cacheResult(lfCertificateUser);
    }

    /**
    * Caches the l f certificate users in the entity cache if it is enabled.
    *
    * @param lfCertificateUsers the l f certificate users
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> lfCertificateUsers) {
        getPersistence().cacheResult(lfCertificateUsers);
    }

    /**
    * Creates a new l f certificate user with the primary key. Does not add the l f certificate user to the database.
    *
    * @param id the primary key for the new l f certificate user
    * @return the new l f certificate user
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f certificate user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate user
    * @return the l f certificate user that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfCertificateUser);
    }

    /**
    * Returns the l f certificate user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException} if it could not be found.
    *
    * @param id the primary key of the l f certificate user
    * @return the l f certificate user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f certificate user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f certificate user
    * @return the l f certificate user, or <code>null</code> if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f certificate users.
    *
    * @return the l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f certificate users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f certificate users.
    *
    * @return the number of l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFCertificateUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFCertificateUserPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFCertificateUserPersistence.class.getName());

            ReferenceRegistry.registerReference(LFCertificateUserUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFCertificateUserPersistence persistence) {
    }
}

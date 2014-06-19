package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateToUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f certificate to user service. This utility wraps {@link LFCertificateToUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUserPersistence
 * @see LFCertificateToUserPersistenceImpl
 * @generated
 */
public class LFCertificateToUserUtil {
    private static LFCertificateToUserPersistence _persistence;

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
    public static void clearCache(LFCertificateToUser lfCertificateToUser) {
        getPersistence().clearCache(lfCertificateToUser);
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
    public static List<LFCertificateToUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFCertificateToUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFCertificateToUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFCertificateToUser update(
        LFCertificateToUser lfCertificateToUser) throws SystemException {
        return getPersistence().update(lfCertificateToUser);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFCertificateToUser update(
        LFCertificateToUser lfCertificateToUser, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfCertificateToUser, serviceContext);
    }

    /**
    * Returns all the l f certificate to users where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID, start, end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID(certificateID, start, end,
            orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the first l f certificate to user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_First(certificateID, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate to user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_Last(certificateID, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser[] findByCertificateID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK,
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_PrevAndNext(lfCertificateToUserPK,
            certificateID, orderByComparator);
    }

    /**
    * Removes all the l f certificate to users where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCertificateID(certificateID);
    }

    /**
    * Returns the number of l f certificate to users where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCertificateID(certificateID);
    }

    /**
    * Returns all the l f certificate to users where userID = &#63;.
    *
    * @param userID the user i d
    * @return the matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID(userID);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID(userID, start, end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserID(userID, start, end, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID_First(userID, orderByComparator);
    }

    /**
    * Returns the first l f certificate to user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserID_First(userID, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID_Last(userID, orderByComparator);
    }

    /**
    * Returns the last l f certificate to user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserID_Last(userID, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser[] findByUserID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserID_PrevAndNext(lfCertificateToUserPK, userID,
            orderByComparator);
    }

    /**
    * Removes all the l f certificate to users where userID = &#63; from the database.
    *
    * @param userID the user i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserID(userID);
    }

    /**
    * Returns the number of l f certificate to users where userID = &#63;.
    *
    * @param userID the user i d
    * @return the number of matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserID(userID);
    }

    /**
    * Returns all the l f certificate to users where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @return the matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID(userID, certificateID);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID(userID, certificateID, start,
            end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID(userID, certificateID, start,
            end, orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserIDAndCertificateID_First(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID_First(userID, certificateID,
            orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserIDAndCertificateID_First(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIDAndCertificateID_First(userID, certificateID,
            orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserIDAndCertificateID_Last(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID_Last(userID, certificateID,
            orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserIDAndCertificateID_Last(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIDAndCertificateID_Last(userID, certificateID,
            orderByComparator);
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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser[] findByUserIDAndCertificateID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, java.lang.Integer userID,
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDAndCertificateID_PrevAndNext(lfCertificateToUserPK,
            userID, certificateID, orderByComparator);
    }

    /**
    * Removes all the l f certificate to users where userID = &#63; and certificateID = &#63; from the database.
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
    * Returns the number of l f certificate to users where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIDAndCertificateID(java.lang.Integer userID,
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByUserIDAndCertificateID(userID, certificateID);
    }

    /**
    * Caches the l f certificate to user in the entity cache if it is enabled.
    *
    * @param lfCertificateToUser the l f certificate to user
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser) {
        getPersistence().cacheResult(lfCertificateToUser);
    }

    /**
    * Caches the l f certificate to users in the entity cache if it is enabled.
    *
    * @param lfCertificateToUsers the l f certificate to users
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> lfCertificateToUsers) {
        getPersistence().cacheResult(lfCertificateToUsers);
    }

    /**
    * Creates a new l f certificate to user with the primary key. Does not add the l f certificate to user to the database.
    *
    * @param lfCertificateToUserPK the primary key for the new l f certificate to user
    * @return the new l f certificate to user
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser create(
        LFCertificateToUserPK lfCertificateToUserPK) {
        return getPersistence().create(lfCertificateToUserPK);
    }

    /**
    * Removes the l f certificate to user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser remove(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfCertificateToUserPK);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfCertificateToUser);
    }

    /**
    * Returns the l f certificate to user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException} if it could not be found.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByPrimaryKey(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfCertificateToUserPK);
    }

    /**
    * Returns the l f certificate to user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user, or <code>null</code> if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByPrimaryKey(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfCertificateToUserPK);
    }

    /**
    * Returns all the l f certificate to users.
    *
    * @return the l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f certificate to users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f certificate to users.
    *
    * @return the number of l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFCertificateToUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFCertificateToUserPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFCertificateToUserPersistence.class.getName());

            ReferenceRegistry.registerReference(LFCertificateToUserUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFCertificateToUserPersistence persistence) {
    }
}

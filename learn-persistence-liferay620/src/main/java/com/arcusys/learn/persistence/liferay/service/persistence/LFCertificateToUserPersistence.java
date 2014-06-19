package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateToUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f certificate to user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUserPersistenceImpl
 * @see LFCertificateToUserUtil
 * @generated
 */
public interface LFCertificateToUserPersistence extends BasePersistence<LFCertificateToUser> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFCertificateToUserUtil} to access the l f certificate to user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f certificate to users where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate to user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate to user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByCertificateID_First(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate to user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate to user in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByCertificateID_Last(
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser[] findByCertificateID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK,
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate to users where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate to users where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateID(java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate to users where userID = &#63;.
    *
    * @param userID the user i d
    * @return the matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate to user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate to user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate to user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate to user in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser[] findByUserID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate to users where userID = &#63; from the database.
    *
    * @param userID the user i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate to users where userID = &#63;.
    *
    * @param userID the user i d
    * @return the number of matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public int countByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate to users where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @return the matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserIDAndCertificateID_First(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserIDAndCertificateID_First(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByUserIDAndCertificateID_Last(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate to user in the ordered set where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate to user, or <code>null</code> if a matching l f certificate to user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByUserIDAndCertificateID_Last(
        java.lang.Integer userID, java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser[] findByUserIDAndCertificateID_PrevAndNext(
        LFCertificateToUserPK lfCertificateToUserPK, java.lang.Integer userID,
        java.lang.Integer certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate to users where userID = &#63; and certificateID = &#63; from the database.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserIDAndCertificateID(java.lang.Integer userID,
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate to users where userID = &#63; and certificateID = &#63;.
    *
    * @param userID the user i d
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public int countByUserIDAndCertificateID(java.lang.Integer userID,
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f certificate to user in the entity cache if it is enabled.
    *
    * @param lfCertificateToUser the l f certificate to user
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser);

    /**
    * Caches the l f certificate to users in the entity cache if it is enabled.
    *
    * @param lfCertificateToUsers the l f certificate to users
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> lfCertificateToUsers);

    /**
    * Creates a new l f certificate to user with the primary key. Does not add the l f certificate to user to the database.
    *
    * @param lfCertificateToUserPK the primary key for the new l f certificate to user
    * @return the new l f certificate to user
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser create(
        LFCertificateToUserPK lfCertificateToUserPK);

    /**
    * Removes the l f certificate to user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser remove(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate to user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException} if it could not be found.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser findByPrimaryKey(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateToUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate to user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user, or <code>null</code> if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchByPrimaryKey(
        LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate to users.
    *
    * @return the l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate to users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate to users.
    *
    * @return the number of l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

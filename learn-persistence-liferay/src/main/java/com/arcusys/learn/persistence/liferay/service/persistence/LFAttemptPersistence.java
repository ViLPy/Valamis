package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAttempt;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f attempt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptPersistenceImpl
 * @see LFAttemptUtil
 * @generated
 */
public interface LFAttemptPersistence extends BasePersistence<LFAttempt> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFAttemptUtil} to access the l f attempt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f attempt in the entity cache if it is enabled.
    *
    * @param lfAttempt the l f attempt
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt);

    /**
    * Caches the l f attempts in the entity cache if it is enabled.
    *
    * @param lfAttempts the l f attempts
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> lfAttempts);

    /**
    * Creates a new l f attempt with the primary key. Does not add the l f attempt to the database.
    *
    * @param id the primary key for the new l f attempt
    * @return the new l f attempt
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt create(long id);

    /**
    * Removes the l f attempt with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt remove(long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFAttempt updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempt with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException} if it could not be found.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempt with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt, or <code>null</code> if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempts where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempts where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempts before and after the current l f attempt in the ordered set where packageID = &#63;.
    *
    * @param id the primary key of the current l f attempt
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt[] findByPackageID_PrevAndNext(
        long id, java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempts where userID = &#63;.
    *
    * @param userID the user i d
    * @return the matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempts where userID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userID the user i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempts where userID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userID the user i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempts before and after the current l f attempt in the ordered set where userID = &#63;.
    *
    * @param id the primary key of the current l f attempt
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt[] findByUserID_PrevAndNext(
        long id, java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @return the matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserIDPackageIDIsComplete_First(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserIDPackageIDIsComplete_First(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserIDPackageIDIsComplete_Last(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserIDPackageIDIsComplete_Last(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f attempts before and after the current l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param id the primary key of the current l f attempt
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt[] findByUserIDPackageIDIsComplete_PrevAndNext(
        long id, java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f attempts.
    *
    * @return the l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f attempts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f attempts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempts where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempts where userID = &#63; from the database.
    *
    * @param userID the user i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63; from the database.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserIDPackageIDIsComplete(java.lang.Integer userID,
        java.lang.Integer packageID, java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f attempts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempts where userID = &#63;.
    *
    * @param userID the user i d
    * @return the number of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public int countByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @return the number of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public int countByUserIDPackageIDIsComplete(java.lang.Integer userID,
        java.lang.Integer packageID, java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f attempts.
    *
    * @return the number of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

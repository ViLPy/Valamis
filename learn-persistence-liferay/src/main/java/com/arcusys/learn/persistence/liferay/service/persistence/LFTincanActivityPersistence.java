package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActivityPersistenceImpl
 * @see LFTincanActivityUtil
 * @generated
 */
public interface LFTincanActivityPersistence extends BasePersistence<LFTincanActivity> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanActivityUtil} to access the l f tincan activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f tincan activity in the entity cache if it is enabled.
    *
    * @param lfTincanActivity the l f tincan activity
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity);

    /**
    * Caches the l f tincan activities in the entity cache if it is enabled.
    *
    * @param lfTincanActivities the l f tincan activities
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> lfTincanActivities);

    /**
    * Creates a new l f tincan activity with the primary key. Does not add the l f tincan activity to the database.
    *
    * @param id the primary key for the new l f tincan activity
    * @return the new l f tincan activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity create(
        long id);

    /**
    * Removes the l f tincan activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan activity
    * @return the l f tincan activity that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException} if it could not be found.
    *
    * @param id the primary key of the l f tincan activity
    * @return the l f tincan activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan activity
    * @return the l f tincan activity, or <code>null</code> if a l f tincan activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan activities where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findByPackageID(
        java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan activities where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f tincan activities
    * @param end the upper bound of the range of l f tincan activities (not inclusive)
    * @return the range of matching l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findByPackageID(
        java.lang.Long packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan activities where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f tincan activities
    * @param end the upper bound of the range of l f tincan activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findByPackageID(
        java.lang.Long packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a matching l f tincan activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity findByPackageID_First(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan activity, or <code>null</code> if a matching l f tincan activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity fetchByPackageID_First(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a matching l f tincan activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity findByPackageID_Last(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan activity, or <code>null</code> if a matching l f tincan activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity fetchByPackageID_Last(
        java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan activities before and after the current l f tincan activity in the ordered set where packageID = &#63;.
    *
    * @param id the primary key of the current l f tincan activity
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException if a l f tincan activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity[] findByPackageID_PrevAndNext(
        long id, java.lang.Long packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan activities.
    *
    * @return the l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan activities
    * @param end the upper bound of the range of l f tincan activities (not inclusive)
    * @return the range of l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan activities
    * @param end the upper bound of the range of l f tincan activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan activities where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageID(java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan activities where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageID(java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan activities.
    *
    * @return the number of l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

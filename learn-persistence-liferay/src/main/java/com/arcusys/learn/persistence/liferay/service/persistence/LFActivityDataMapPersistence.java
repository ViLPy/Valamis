package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f activity data map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityDataMapPersistenceImpl
 * @see LFActivityDataMapUtil
 * @generated
 */
public interface LFActivityDataMapPersistence extends BasePersistence<LFActivityDataMap> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFActivityDataMapUtil} to access the l f activity data map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f activity data map in the entity cache if it is enabled.
    *
    * @param lfActivityDataMap the l f activity data map
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap);

    /**
    * Caches the l f activity data maps in the entity cache if it is enabled.
    *
    * @param lfActivityDataMaps the l f activity data maps
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> lfActivityDataMaps);

    /**
    * Creates a new l f activity data map with the primary key. Does not add the l f activity data map to the database.
    *
    * @param id the primary key for the new l f activity data map
    * @return the new l f activity data map
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap create(
        long id);

    /**
    * Removes the l f activity data map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity data map with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException} if it could not be found.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity data map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map, or <code>null</code> if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @return the range of matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity data map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a matching l f activity data map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap findByPackageIDAndActivityID_First(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity data map, or <code>null</code> if a matching l f activity data map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchByPackageIDAndActivityID_First(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity data map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a matching l f activity data map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap findByPackageIDAndActivityID_Last(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity data map, or <code>null</code> if a matching l f activity data map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchByPackageIDAndActivityID_Last(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity data maps before and after the current l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param id the primary key of the current l f activity data map
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity data map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap[] findByPackageIDAndActivityID_PrevAndNext(
        long id, java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activity data maps.
    *
    * @return the l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activity data maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @return the range of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activity data maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity data maps where packageID = &#63; and activityID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageIDAndActivityID(java.lang.Integer packageID,
        java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activity data maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the number of matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageIDAndActivityID(java.lang.Integer packageID,
        java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activity data maps.
    *
    * @return the number of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

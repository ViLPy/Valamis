package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFResource;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFResourcePersistenceImpl
 * @see LFResourceUtil
 * @generated
 */
public interface LFResourcePersistence extends BasePersistence<LFResource> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFResourceUtil} to access the l f resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f resource in the entity cache if it is enabled.
    *
    * @param lfResource the l f resource
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource);

    /**
    * Caches the l f resources in the entity cache if it is enabled.
    *
    * @param lfResources the l f resources
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> lfResources);

    /**
    * Creates a new l f resource with the primary key. Does not add the l f resource to the database.
    *
    * @param id the primary key for the new l f resource
    * @return the new l f resource
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource create(
        long id);

    /**
    * Removes the l f resource with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFResource updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f resource with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFResourceException} if it could not be found.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f resource with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource, or <code>null</code> if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f resources where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f resources where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f resources where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource findByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource findByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f resources before and after the current l f resource in the ordered set where packageID = &#63;.
    *
    * @param id the primary key of the current l f resource
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource[] findByPackageID_PrevAndNext(
        long id, java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @return the matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource findByPackageIDAndResourceID_First(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageIDAndResourceID_First(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource findByPackageIDAndResourceID_Last(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageIDAndResourceID_Last(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f resources before and after the current l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param id the primary key of the current l f resource
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFResource[] findByPackageIDAndResourceID_PrevAndNext(
        long id, java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f resources.
    *
    * @return the l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f resources.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f resources.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f resources
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f resources where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f resources where packageID = &#63; and resourceID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageIDAndResourceID(java.lang.Integer packageID,
        java.lang.String resourceID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f resources from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f resources where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @return the number of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageIDAndResourceID(java.lang.Integer packageID,
        java.lang.String resourceID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f resources.
    *
    * @return the number of l f resources
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

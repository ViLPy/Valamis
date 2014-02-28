package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFResource;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f resource service. This utility wraps {@link LFResourcePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFResourcePersistence
 * @see LFResourcePersistenceImpl
 * @generated
 */
public class LFResourceUtil {
    private static LFResourcePersistence _persistence;

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
    public static void clearCache(LFResource lfResource) {
        getPersistence().clearCache(lfResource);
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
    public static List<LFResource> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFResource> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFResource> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFResource update(LFResource lfResource)
        throws SystemException {
        return getPersistence().update(lfResource);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFResource update(LFResource lfResource,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfResource, serviceContext);
    }

    /**
    * Returns all the l f resources where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID);
    }

    /**
    * Returns a range of all the l f resources where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID, start, end);
    }

    /**
    * Returns an ordered range of all the l f resources where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID(packageID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource findByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource findByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_Last(packageID, orderByComparator);
    }

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_Last(packageID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFResource[] findByPackageID_PrevAndNext(
        long id, java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_PrevAndNext(id, packageID, orderByComparator);
    }

    /**
    * Removes all the l f resources where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageID(packageID);
    }

    /**
    * Returns the number of l f resources where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPackageID(packageID);
    }

    /**
    * Returns all the l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @return the matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndResourceID(packageID, resourceID);
    }

    /**
    * Returns a range of all the l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndResourceID(packageID, resourceID, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndResourceID(packageID, resourceID, start,
            end, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFResource findByPackageIDAndResourceID_First(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndResourceID_First(packageID, resourceID,
            orderByComparator);
    }

    /**
    * Returns the first l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageIDAndResourceID_First(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndResourceID_First(packageID, resourceID,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFResource findByPackageIDAndResourceID_Last(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndResourceID_Last(packageID, resourceID,
            orderByComparator);
    }

    /**
    * Returns the last l f resource in the ordered set where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f resource, or <code>null</code> if a matching l f resource could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource fetchByPackageIDAndResourceID_Last(
        java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndResourceID_Last(packageID, resourceID,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFResource[] findByPackageIDAndResourceID_PrevAndNext(
        long id, java.lang.Integer packageID, java.lang.String resourceID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndResourceID_PrevAndNext(id, packageID,
            resourceID, orderByComparator);
    }

    /**
    * Removes all the l f resources where packageID = &#63; and resourceID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageIDAndResourceID(packageID, resourceID);
    }

    /**
    * Returns the number of l f resources where packageID = &#63; and resourceID = &#63;.
    *
    * @param packageID the package i d
    * @param resourceID the resource i d
    * @return the number of matching l f resources
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByPackageIDAndResourceID(packageID, resourceID);
    }

    /**
    * Caches the l f resource in the entity cache if it is enabled.
    *
    * @param lfResource the l f resource
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource) {
        getPersistence().cacheResult(lfResource);
    }

    /**
    * Caches the l f resources in the entity cache if it is enabled.
    *
    * @param lfResources the l f resources
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> lfResources) {
        getPersistence().cacheResult(lfResources);
    }

    /**
    * Creates a new l f resource with the primary key. Does not add the l f resource to the database.
    *
    * @param id the primary key for the new l f resource
    * @return the new l f resource
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f resource with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFResource updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfResource);
    }

    /**
    * Returns the l f resource with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFResourceException} if it could not be found.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFResourceException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f resource with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource, or <code>null</code> if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f resources.
    *
    * @return the l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f resources.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f resources.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f resources from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f resources.
    *
    * @return the number of l f resources
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFResourcePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFResourcePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFResourcePersistence.class.getName());

            ReferenceRegistry.registerReference(LFResourceUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFResourcePersistence persistence) {
    }
}

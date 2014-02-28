package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivity;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f activity service. This utility wraps {@link LFActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityPersistence
 * @see LFActivityPersistenceImpl
 * @generated
 */
public class LFActivityUtil {
    private static LFActivityPersistence _persistence;

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
    public static void clearCache(LFActivity lfActivity) {
        getPersistence().clearCache(lfActivity);
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
    public static List<LFActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFActivity update(LFActivity lfActivity)
        throws SystemException {
        return getPersistence().update(lfActivity);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFActivity update(LFActivity lfActivity,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfActivity, serviceContext);
    }

    /**
    * Returns the l f activity where packageID = &#63; and id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageAndID(packageID, id);
    }

    /**
    * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPackageAndID(packageID, id);
    }

    /**
    * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param packageID the package i d
    * @param id the ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageAndID(
        java.lang.Integer packageID, java.lang.String id,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageAndID(packageID, id, retrieveFromCache);
    }

    /**
    * Removes the l f activity where packageID = &#63; and id = &#63; from the database.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the l f activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity removeByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByPackageAndID(packageID, id);
    }

    /**
    * Returns the number of l f activities where packageID = &#63; and id = &#63;.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageAndID(java.lang.Integer packageID,
        java.lang.String id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPackageAndID(packageID, id);
    }

    /**
    * Returns all the l f activities where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID);
    }

    /**
    * Returns a range of all the l f activities where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID, start, end);
    }

    /**
    * Returns an ordered range of all the l f activities where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID(packageID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_Last(packageID, orderByComparator);
    }

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_Last(packageID, orderByComparator);
    }

    /**
    * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63;.
    *
    * @param indexNumber the primary key of the current l f activity
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity[] findByPackageID_PrevAndNext(
        long indexNumber, java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_PrevAndNext(indexNumber, packageID,
            orderByComparator);
    }

    /**
    * Removes all the l f activities where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageID(packageID);
    }

    /**
    * Returns the number of l f activities where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPackageID(packageID);
    }

    /**
    * Returns all the l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @return the matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndOrganizationID(packageID, organizationID);
    }

    /**
    * Returns a range of all the l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndOrganizationID(packageID, organizationID,
            start, end);
    }

    /**
    * Returns an ordered range of all the l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndOrganizationID(packageID, organizationID,
            start, end, orderByComparator);
    }

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndOrganizationID_First(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndOrganizationID_First(packageID,
            organizationID, orderByComparator);
    }

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndOrganizationID_First(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndOrganizationID_First(packageID,
            organizationID, orderByComparator);
    }

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndOrganizationID_Last(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndOrganizationID_Last(packageID,
            organizationID, orderByComparator);
    }

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndOrganizationID_Last(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndOrganizationID_Last(packageID,
            organizationID, orderByComparator);
    }

    /**
    * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param indexNumber the primary key of the current l f activity
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity[] findByPackageIDAndOrganizationID_PrevAndNext(
        long indexNumber, java.lang.Integer packageID,
        java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndOrganizationID_PrevAndNext(indexNumber,
            packageID, organizationID, orderByComparator);
    }

    /**
    * Removes all the l f activities where packageID = &#63; and organizationID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByPackageIDAndOrganizationID(packageID, organizationID);
    }

    /**
    * Returns the number of l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByPackageIDAndOrganizationID(packageID, organizationID);
    }

    /**
    * Returns all the l f activities where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @return the matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageIDAndParentID(packageID, parentID);
    }

    /**
    * Returns a range of all the l f activities where packageID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndParentID(packageID, parentID, start, end);
    }

    /**
    * Returns an ordered range of all the l f activities where packageID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndParentID(packageID, parentID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndParentID_First(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndParentID_First(packageID, parentID,
            orderByComparator);
    }

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndParentID_First(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndParentID_First(packageID, parentID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndParentID_Last(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndParentID_Last(packageID, parentID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndParentID_Last(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndParentID_Last(packageID, parentID,
            orderByComparator);
    }

    /**
    * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param indexNumber the primary key of the current l f activity
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity[] findByPackageIDAndParentID_PrevAndNext(
        long indexNumber, java.lang.Integer packageID,
        java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndParentID_PrevAndNext(indexNumber,
            packageID, parentID, orderByComparator);
    }

    /**
    * Removes all the l f activities where packageID = &#63; and parentID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageIDAndParentID(packageID, parentID);
    }

    /**
    * Returns the number of l f activities where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageIDAndParentID(java.lang.Integer packageID,
        java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPackageIDAndParentID(packageID, parentID);
    }

    /**
    * Caches the l f activity in the entity cache if it is enabled.
    *
    * @param lfActivity the l f activity
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity) {
        getPersistence().cacheResult(lfActivity);
    }

    /**
    * Caches the l f activities in the entity cache if it is enabled.
    *
    * @param lfActivities the l f activities
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> lfActivities) {
        getPersistence().cacheResult(lfActivities);
    }

    /**
    * Creates a new l f activity with the primary key. Does not add the l f activity to the database.
    *
    * @param indexNumber the primary key for the new l f activity
    * @return the new l f activity
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity create(
        long indexNumber) {
        return getPersistence().create(indexNumber);
    }

    /**
    * Removes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity remove(
        long indexNumber)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(indexNumber);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfActivity);
    }

    /**
    * Returns the l f activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPrimaryKey(
        long indexNumber)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(indexNumber);
    }

    /**
    * Returns the l f activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity, or <code>null</code> if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPrimaryKey(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(indexNumber);
    }

    /**
    * Returns all the l f activities.
    *
    * @return the l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f activities.
    *
    * @return the number of l f activities
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFActivityPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFActivityPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFActivityPersistence.class.getName());

            ReferenceRegistry.registerReference(LFActivityUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFActivityPersistence persistence) {
    }
}

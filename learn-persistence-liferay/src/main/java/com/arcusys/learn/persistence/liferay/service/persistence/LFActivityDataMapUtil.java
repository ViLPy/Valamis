package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f activity data map service. This utility wraps {@link LFActivityDataMapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityDataMapPersistence
 * @see LFActivityDataMapPersistenceImpl
 * @generated
 */
public class LFActivityDataMapUtil {
    private static LFActivityDataMapPersistence _persistence;

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
    public static void clearCache(LFActivityDataMap lfActivityDataMap) {
        getPersistence().clearCache(lfActivityDataMap);
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
    public static List<LFActivityDataMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFActivityDataMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFActivityDataMap> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFActivityDataMap update(LFActivityDataMap lfActivityDataMap)
        throws SystemException {
        return getPersistence().update(lfActivityDataMap);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFActivityDataMap update(
        LFActivityDataMap lfActivityDataMap, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfActivityDataMap, serviceContext);
    }

    /**
    * Returns all the l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndActivityID(packageID, activityID);
    }

    /**
    * Returns a range of all the l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @return the range of matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndActivityID(packageID, activityID, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndActivityID(packageID, activityID, start,
            end, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap findByPackageIDAndActivityID_First(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndActivityID_First(packageID, activityID,
            orderByComparator);
    }

    /**
    * Returns the first l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity data map, or <code>null</code> if a matching l f activity data map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchByPackageIDAndActivityID_First(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndActivityID_First(packageID, activityID,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap findByPackageIDAndActivityID_Last(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndActivityID_Last(packageID, activityID,
            orderByComparator);
    }

    /**
    * Returns the last l f activity data map in the ordered set where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity data map, or <code>null</code> if a matching l f activity data map could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchByPackageIDAndActivityID_Last(
        java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageIDAndActivityID_Last(packageID, activityID,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap[] findByPackageIDAndActivityID_PrevAndNext(
        long id, java.lang.Integer packageID, java.lang.String activityID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageIDAndActivityID_PrevAndNext(id, packageID,
            activityID, orderByComparator);
    }

    /**
    * Removes all the l f activity data maps where packageID = &#63; and activityID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageIDAndActivityID(packageID, activityID);
    }

    /**
    * Returns the number of l f activity data maps where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the number of matching l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByPackageIDAndActivityID(packageID, activityID);
    }

    /**
    * Caches the l f activity data map in the entity cache if it is enabled.
    *
    * @param lfActivityDataMap the l f activity data map
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap) {
        getPersistence().cacheResult(lfActivityDataMap);
    }

    /**
    * Caches the l f activity data maps in the entity cache if it is enabled.
    *
    * @param lfActivityDataMaps the l f activity data maps
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> lfActivityDataMaps) {
        getPersistence().cacheResult(lfActivityDataMaps);
    }

    /**
    * Creates a new l f activity data map with the primary key. Does not add the l f activity data map to the database.
    *
    * @param id the primary key for the new l f activity data map
    * @return the new l f activity data map
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f activity data map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfActivityDataMap);
    }

    /**
    * Returns the l f activity data map with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException} if it could not be found.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityDataMapException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f activity data map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map, or <code>null</code> if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f activity data maps.
    *
    * @return the l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f activity data maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @return the range of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f activity data maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f activity data maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f activity data maps.
    *
    * @return the number of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFActivityDataMapPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFActivityDataMapPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFActivityDataMapPersistence.class.getName());

            ReferenceRegistry.registerReference(LFActivityDataMapUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFActivityDataMapPersistence persistence) {
    }
}

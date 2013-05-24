package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSequencing;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f sequencing service. This utility wraps {@link LFSequencingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingPersistence
 * @see LFSequencingPersistenceImpl
 * @generated
 */
public class LFSequencingUtil {
    private static LFSequencingPersistence _persistence;

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
    public static void clearCache(LFSequencing lfSequencing) {
        getPersistence().clearCache(lfSequencing);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFSequencing> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFSequencing> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFSequencing> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFSequencing update(LFSequencing lfSequencing, boolean merge)
        throws SystemException {
        return getPersistence().update(lfSequencing, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFSequencing update(LFSequencing lfSequencing, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfSequencing, merge, serviceContext);
    }

    /**
    * Caches the l f sequencing in the entity cache if it is enabled.
    *
    * @param lfSequencing the l f sequencing
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing) {
        getPersistence().cacheResult(lfSequencing);
    }

    /**
    * Caches the l f sequencings in the entity cache if it is enabled.
    *
    * @param lfSequencings the l f sequencings
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> lfSequencings) {
        getPersistence().cacheResult(lfSequencings);
    }

    /**
    * Creates a new l f sequencing with the primary key. Does not add the l f sequencing to the database.
    *
    * @param id the primary key for the new l f sequencing
    * @return the new l f sequencing
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f sequencing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSequencing updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfSequencing, merge);
    }

    /**
    * Returns the l f sequencing with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException} if it could not be found.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f sequencing with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing, or <code>null</code> if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException} if it could not be found.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the matching l f sequencing
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException if a matching l f sequencing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing findByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIDAndPackageID(packageID, activityID);
    }

    /**
    * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the matching l f sequencing, or <code>null</code> if a matching l f sequencing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing fetchByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIDAndPackageID(packageID, activityID);
    }

    /**
    * Returns the l f sequencing where packageID = &#63; and activityID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f sequencing, or <code>null</code> if a matching l f sequencing could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing fetchByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIDAndPackageID(packageID, activityID,
            retrieveFromCache);
    }

    /**
    * Returns all the l f sequencings.
    *
    * @return the l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f sequencings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencings
    * @param end the upper bound of the range of l f sequencings (not inclusive)
    * @return the range of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f sequencings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencings
    * @param end the upper bound of the range of l f sequencings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f sequencing where packageID = &#63; and activityID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the l f sequencing that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencing removeByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByActivityIDAndPackageID(packageID, activityID);
    }

    /**
    * Removes all the l f sequencings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f sequencings where packageID = &#63; and activityID = &#63;.
    *
    * @param packageID the package i d
    * @param activityID the activity i d
    * @return the number of matching l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActivityIDAndPackageID(packageID, activityID);
    }

    /**
    * Returns the number of l f sequencings.
    *
    * @return the number of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFSequencingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFSequencingPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFSequencingPersistence.class.getName());

            ReferenceRegistry.registerReference(LFSequencingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFSequencingPersistence persistence) {
    }
}

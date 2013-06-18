package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f sequencing tracking service. This utility wraps {@link LFSequencingTrackingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingTrackingPersistence
 * @see LFSequencingTrackingPersistenceImpl
 * @generated
 */
public class LFSequencingTrackingUtil {
    private static LFSequencingTrackingPersistence _persistence;

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
    public static void clearCache(LFSequencingTracking lfSequencingTracking) {
        getPersistence().clearCache(lfSequencingTracking);
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
    public static List<LFSequencingTracking> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFSequencingTracking> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFSequencingTracking> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFSequencingTracking update(
        LFSequencingTracking lfSequencingTracking, boolean merge)
        throws SystemException {
        return getPersistence().update(lfSequencingTracking, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFSequencingTracking update(
        LFSequencingTracking lfSequencingTracking, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfSequencingTracking, merge, serviceContext);
    }

    /**
    * Caches the l f sequencing tracking in the entity cache if it is enabled.
    *
    * @param lfSequencingTracking the l f sequencing tracking
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSequencingTracking lfSequencingTracking) {
        getPersistence().cacheResult(lfSequencingTracking);
    }

    /**
    * Caches the l f sequencing trackings in the entity cache if it is enabled.
    *
    * @param lfSequencingTrackings the l f sequencing trackings
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> lfSequencingTrackings) {
        getPersistence().cacheResult(lfSequencingTrackings);
    }

    /**
    * Creates a new l f sequencing tracking with the primary key. Does not add the l f sequencing tracking to the database.
    *
    * @param id the primary key for the new l f sequencing tracking
    * @return the new l f sequencing tracking
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f sequencing tracking with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing tracking
    * @return the l f sequencing tracking that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSequencingTracking lfSequencingTracking,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfSequencingTracking, merge);
    }

    /**
    * Returns the l f sequencing tracking with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException} if it could not be found.
    *
    * @param id the primary key of the l f sequencing tracking
    * @return the l f sequencing tracking
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f sequencing tracking with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f sequencing tracking
    * @return the l f sequencing tracking, or <code>null</code> if a l f sequencing tracking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f sequencing trackings where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID);
    }

    /**
    * Returns a range of all the l f sequencing trackings where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f sequencing trackings
    * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
    * @return the range of matching l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID, start, end);
    }

    /**
    * Returns an ordered range of all the l f sequencing trackings where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f sequencing trackings
    * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID(sequencingID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f sequencing tracking in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f sequencing tracking
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a matching l f sequencing tracking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking findBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_First(sequencingID, orderByComparator);
    }

    /**
    * Returns the first l f sequencing tracking in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f sequencing tracking, or <code>null</code> if a matching l f sequencing tracking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking fetchBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID_First(sequencingID, orderByComparator);
    }

    /**
    * Returns the last l f sequencing tracking in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f sequencing tracking
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a matching l f sequencing tracking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking findBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_Last(sequencingID, orderByComparator);
    }

    /**
    * Returns the last l f sequencing tracking in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f sequencing tracking, or <code>null</code> if a matching l f sequencing tracking could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking fetchBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID_Last(sequencingID, orderByComparator);
    }

    /**
    * Returns the l f sequencing trackings before and after the current l f sequencing tracking in the ordered set where sequencingID = &#63;.
    *
    * @param id the primary key of the current l f sequencing tracking
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f sequencing tracking
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException if a l f sequencing tracking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingTracking[] findBySequencingID_PrevAndNext(
        long id, java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingTrackingException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_PrevAndNext(id, sequencingID,
            orderByComparator);
    }

    /**
    * Returns all the l f sequencing trackings.
    *
    * @return the l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f sequencing trackings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencing trackings
    * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
    * @return the range of l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f sequencing trackings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencing trackings
    * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f sequencing trackings where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySequencingID(sequencingID);
    }

    /**
    * Removes all the l f sequencing trackings from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f sequencing trackings where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySequencingID(sequencingID);
    }

    /**
    * Returns the number of l f sequencing trackings.
    *
    * @return the number of l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFSequencingTrackingPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFSequencingTrackingPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFSequencingTrackingPersistence.class.getName());

            ReferenceRegistry.registerReference(LFSequencingTrackingUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFSequencingTrackingPersistence persistence) {
    }
}

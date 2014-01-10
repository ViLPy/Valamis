package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs activity profile service. This utility wraps {@link LFTincanLrsActivityProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsActivityProfilePersistence
 * @see LFTincanLrsActivityProfilePersistenceImpl
 * @generated
 */
public class LFTincanLrsActivityProfileUtil {
    private static LFTincanLrsActivityProfilePersistence _persistence;

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
    public static void clearCache(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        getPersistence().clearCache(lfTincanLrsActivityProfile);
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
    public static List<LFTincanLrsActivityProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsActivityProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsActivityProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFTincanLrsActivityProfile update(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile, boolean merge)
        throws SystemException {
        return getPersistence().update(lfTincanLrsActivityProfile, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFTincanLrsActivityProfile update(
        LFTincanLrsActivityProfile lfTincanLrsActivityProfile, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfTincanLrsActivityProfile, merge, serviceContext);
    }

    /**
    * Caches the l f tincan lrs activity profile in the entity cache if it is enabled.
    *
    * @param lfTincanLrsActivityProfile the l f tincan lrs activity profile
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile lfTincanLrsActivityProfile) {
        getPersistence().cacheResult(lfTincanLrsActivityProfile);
    }

    /**
    * Caches the l f tincan lrs activity profiles in the entity cache if it is enabled.
    *
    * @param lfTincanLrsActivityProfiles the l f tincan lrs activity profiles
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> lfTincanLrsActivityProfiles) {
        getPersistence().cacheResult(lfTincanLrsActivityProfiles);
    }

    /**
    * Creates a new l f tincan lrs activity profile with the primary key. Does not add the l f tincan lrs activity profile to the database.
    *
    * @param id the primary key for the new l f tincan lrs activity profile
    * @return the new l f tincan lrs activity profile
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs activity profile with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs activity profile
    * @return the l f tincan lrs activity profile that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile lfTincanLrsActivityProfile,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsActivityProfile, merge);
    }

    /**
    * Returns the l f tincan lrs activity profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs activity profile
    * @return the l f tincan lrs activity profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs activity profile with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs activity profile
    * @return the l f tincan lrs activity profile, or <code>null</code> if a l f tincan lrs activity profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan lrs activity profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a matching l f tincan lrs activity profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile findByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIdAndProfileId(activityId, profileId,
            retrieveFromCache);
    }

    /**
    * Returns all the l f tincan lrs activity profiles.
    *
    * @return the l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs activity profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs activity profiles
    * @param end the upper bound of the range of l f tincan lrs activity profiles (not inclusive)
    * @return the range of l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs activity profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs activity profiles
    * @param end the upper bound of the range of l f tincan lrs activity profiles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the l f tincan lrs activity profile that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile removeByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Removes all the l f tincan lrs activity profiles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs activity profiles where activityId = &#63; and profileId = &#63;.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the number of matching l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns the number of l f tincan lrs activity profiles.
    *
    * @return the number of l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsActivityProfilePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsActivityProfilePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsActivityProfilePersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsActivityProfileUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(
        LFTincanLrsActivityProfilePersistence persistence) {
    }
}

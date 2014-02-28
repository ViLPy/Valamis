package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActProfile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan act profile service. This utility wraps {@link LFTincanActProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActProfilePersistence
 * @see LFTincanActProfilePersistenceImpl
 * @generated
 */
public class LFTincanActProfileUtil {
    private static LFTincanActProfilePersistence _persistence;

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
    public static void clearCache(LFTincanActProfile lfTincanActProfile) {
        getPersistence().clearCache(lfTincanActProfile);
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
    public static List<LFTincanActProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanActProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanActProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanActProfile update(
        LFTincanActProfile lfTincanActProfile) throws SystemException {
        return getPersistence().update(lfTincanActProfile);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanActProfile update(
        LFTincanActProfile lfTincanActProfile, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfTincanActProfile, serviceContext);
    }

    /**
    * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException} if it could not be found.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityIdAndProfileId(activityId, profileId,
            retrieveFromCache);
    }

    /**
    * Removes the l f tincan act profile where activityId = &#63; and profileId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the l f tincan act profile that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile removeByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns the number of l f tincan act profiles where activityId = &#63; and profileId = &#63;.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the number of matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByActivityIdAndProfileId(activityId, profileId);
    }

    /**
    * Returns all the l f tincan act profiles where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findByActivityId(
        java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityId(activityId);
    }

    /**
    * Returns a range of all the l f tincan act profiles where activityId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityId the activity ID
    * @param start the lower bound of the range of l f tincan act profiles
    * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
    * @return the range of matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findByActivityId(
        java.lang.String activityId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActivityId(activityId, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan act profiles where activityId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param activityId the activity ID
    * @param start the lower bound of the range of l f tincan act profiles
    * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findByActivityId(
        java.lang.String activityId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId(activityId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId_First(activityId, orderByComparator);
    }

    /**
    * Returns the first l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityId_First(activityId, orderByComparator);
    }

    /**
    * Returns the last l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId_Last(activityId, orderByComparator);
    }

    /**
    * Returns the last l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByActivityId_Last(activityId, orderByComparator);
    }

    /**
    * Returns the l f tincan act profiles before and after the current l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param id the primary key of the current l f tincan act profile
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile[] findByActivityId_PrevAndNext(
        long id, java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActivityId_PrevAndNext(id, activityId,
            orderByComparator);
    }

    /**
    * Removes all the l f tincan act profiles where activityId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActivityId(activityId);
    }

    /**
    * Returns the number of l f tincan act profiles where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the number of matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActivityId(activityId);
    }

    /**
    * Caches the l f tincan act profile in the entity cache if it is enabled.
    *
    * @param lfTincanActProfile the l f tincan act profile
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanActProfile lfTincanActProfile) {
        getPersistence().cacheResult(lfTincanActProfile);
    }

    /**
    * Caches the l f tincan act profiles in the entity cache if it is enabled.
    *
    * @param lfTincanActProfiles the l f tincan act profiles
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> lfTincanActProfiles) {
        getPersistence().cacheResult(lfTincanActProfiles);
    }

    /**
    * Creates a new l f tincan act profile with the primary key. Does not add the l f tincan act profile to the database.
    *
    * @param id the primary key for the new l f tincan act profile
    * @return the new l f tincan act profile
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan act profile with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan act profile
    * @return the l f tincan act profile that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActProfile lfTincanActProfile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanActProfile);
    }

    /**
    * Returns the l f tincan act profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException} if it could not be found.
    *
    * @param id the primary key of the l f tincan act profile
    * @return the l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan act profile with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan act profile
    * @return the l f tincan act profile, or <code>null</code> if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan act profiles.
    *
    * @return the l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan act profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan act profiles
    * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
    * @return the range of l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan act profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanActProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan act profiles
    * @param end the upper bound of the range of l f tincan act profiles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan act profiles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan act profiles.
    *
    * @return the number of l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanActProfilePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanActProfilePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanActProfilePersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanActProfileUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanActProfilePersistence persistence) {
    }
}

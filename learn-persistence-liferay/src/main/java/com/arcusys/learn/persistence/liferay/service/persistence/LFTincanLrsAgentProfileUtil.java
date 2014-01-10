package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs agent profile service. This utility wraps {@link LFTincanLrsAgentProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAgentProfilePersistence
 * @see LFTincanLrsAgentProfilePersistenceImpl
 * @generated
 */
public class LFTincanLrsAgentProfileUtil {
    private static LFTincanLrsAgentProfilePersistence _persistence;

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
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        getPersistence().clearCache(lfTincanLrsAgentProfile);
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
    public static List<LFTincanLrsAgentProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsAgentProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsAgentProfile> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFTincanLrsAgentProfile update(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile, boolean merge)
        throws SystemException {
        return getPersistence().update(lfTincanLrsAgentProfile, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFTincanLrsAgentProfile update(
        LFTincanLrsAgentProfile lfTincanLrsAgentProfile, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfTincanLrsAgentProfile, merge, serviceContext);
    }

    /**
    * Caches the l f tincan lrs agent profile in the entity cache if it is enabled.
    *
    * @param lfTincanLrsAgentProfile the l f tincan lrs agent profile
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        getPersistence().cacheResult(lfTincanLrsAgentProfile);
    }

    /**
    * Caches the l f tincan lrs agent profiles in the entity cache if it is enabled.
    *
    * @param lfTincanLrsAgentProfiles the l f tincan lrs agent profiles
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> lfTincanLrsAgentProfiles) {
        getPersistence().cacheResult(lfTincanLrsAgentProfiles);
    }

    /**
    * Creates a new l f tincan lrs agent profile with the primary key. Does not add the l f tincan lrs agent profile to the database.
    *
    * @param id the primary key for the new l f tincan lrs agent profile
    * @return the new l f tincan lrs agent profile
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs agent profile with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsAgentProfile, merge);
    }

    /**
    * Returns the l f tincan lrs agent profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs agent profile with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile, or <code>null</code> if a l f tincan lrs agent profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs agent profiles where profileId = &#63;.
    *
    * @param profileId the profile ID
    * @return the matching l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findByProfileId(
        java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByProfileId(profileId);
    }

    /**
    * Returns a range of all the l f tincan lrs agent profiles where profileId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param profileId the profile ID
    * @param start the lower bound of the range of l f tincan lrs agent profiles
    * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
    * @return the range of matching l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findByProfileId(
        java.lang.String profileId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByProfileId(profileId, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs agent profiles where profileId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param profileId the profile ID
    * @param start the lower bound of the range of l f tincan lrs agent profiles
    * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findByProfileId(
        java.lang.String profileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByProfileId(profileId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs agent profile in the ordered set where profileId = &#63;.
    *
    * @param profileId the profile ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs agent profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile findByProfileId_First(
        java.lang.String profileId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByProfileId_First(profileId, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs agent profile in the ordered set where profileId = &#63;.
    *
    * @param profileId the profile ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile fetchByProfileId_First(
        java.lang.String profileId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByProfileId_First(profileId, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs agent profile in the ordered set where profileId = &#63;.
    *
    * @param profileId the profile ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs agent profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile findByProfileId_Last(
        java.lang.String profileId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByProfileId_Last(profileId, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs agent profile in the ordered set where profileId = &#63;.
    *
    * @param profileId the profile ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile fetchByProfileId_Last(
        java.lang.String profileId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByProfileId_Last(profileId, orderByComparator);
    }

    /**
    * Returns the l f tincan lrs agent profiles before and after the current l f tincan lrs agent profile in the ordered set where profileId = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs agent profile
    * @param profileId the profile ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs agent profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a l f tincan lrs agent profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile[] findByProfileId_PrevAndNext(
        long id, java.lang.String profileId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByProfileId_PrevAndNext(id, profileId, orderByComparator);
    }

    /**
    * Returns the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException} if it could not be found.
    *
    * @param agentId the agent ID
    * @param profileId the profile ID
    * @return the matching l f tincan lrs agent profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile findByAgentIdAndProfileId(
        java.lang.Integer agentId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAgentIdAndProfileId(agentId, profileId);
    }

    /**
    * Returns the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param agentId the agent ID
    * @param profileId the profile ID
    * @return the matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile fetchByAgentIdAndProfileId(
        java.lang.Integer agentId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAgentIdAndProfileId(agentId, profileId);
    }

    /**
    * Returns the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param agentId the agent ID
    * @param profileId the profile ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan lrs agent profile, or <code>null</code> if a matching l f tincan lrs agent profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile fetchByAgentIdAndProfileId(
        java.lang.Integer agentId, java.lang.String profileId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAgentIdAndProfileId(agentId, profileId,
            retrieveFromCache);
    }

    /**
    * Returns all the l f tincan lrs agent profiles.
    *
    * @return the l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs agent profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs agent profiles
    * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
    * @return the range of l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs agent profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs agent profiles
    * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs agent profiles where profileId = &#63; from the database.
    *
    * @param profileId the profile ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByProfileId(java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByProfileId(profileId);
    }

    /**
    * Removes the l f tincan lrs agent profile where agentId = &#63; and profileId = &#63; from the database.
    *
    * @param agentId the agent ID
    * @param profileId the profile ID
    * @return the l f tincan lrs agent profile that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile removeByAgentIdAndProfileId(
        java.lang.Integer agentId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByAgentIdAndProfileId(agentId, profileId);
    }

    /**
    * Removes all the l f tincan lrs agent profiles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs agent profiles where profileId = &#63;.
    *
    * @param profileId the profile ID
    * @return the number of matching l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countByProfileId(java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByProfileId(profileId);
    }

    /**
    * Returns the number of l f tincan lrs agent profiles where agentId = &#63; and profileId = &#63;.
    *
    * @param agentId the agent ID
    * @param profileId the profile ID
    * @return the number of matching l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countByAgentIdAndProfileId(java.lang.Integer agentId,
        java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAgentIdAndProfileId(agentId, profileId);
    }

    /**
    * Returns the number of l f tincan lrs agent profiles.
    *
    * @return the number of l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsAgentProfilePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsAgentProfilePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsAgentProfilePersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsAgentProfileUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFTincanLrsAgentProfilePersistence persistence) {
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan lrs activity profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsActivityProfilePersistenceImpl
 * @see LFTincanLrsActivityProfileUtil
 * @generated
 */
public interface LFTincanLrsActivityProfilePersistence extends BasePersistence<LFTincanLrsActivityProfile> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanLrsActivityProfileUtil} to access the l f tincan lrs activity profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f tincan lrs activity profile in the entity cache if it is enabled.
    *
    * @param lfTincanLrsActivityProfile the l f tincan lrs activity profile
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile lfTincanLrsActivityProfile);

    /**
    * Caches the l f tincan lrs activity profiles in the entity cache if it is enabled.
    *
    * @param lfTincanLrsActivityProfiles the l f tincan lrs activity profiles
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> lfTincanLrsActivityProfiles);

    /**
    * Creates a new l f tincan lrs activity profile with the primary key. Does not add the l f tincan lrs activity profile to the database.
    *
    * @param id the primary key for the new l f tincan lrs activity profile
    * @return the new l f tincan lrs activity profile
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile create(
        long id);

    /**
    * Removes the l f tincan lrs activity profile with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs activity profile
    * @return the l f tincan lrs activity profile that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile lfTincanLrsActivityProfile,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs activity profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs activity profile
    * @return the l f tincan lrs activity profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a l f tincan lrs activity profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs activity profile with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs activity profile
    * @return the l f tincan lrs activity profile, or <code>null</code> if a l f tincan lrs activity profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException} if it could not be found.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan lrs activity profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException if a matching l f tincan lrs activity profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile findByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan lrs activity profile, or <code>null</code> if a matching l f tincan lrs activity profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs activity profiles.
    *
    * @return the l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan lrs activity profile where activityId = &#63; and profileId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the l f tincan lrs activity profile that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile removeByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs activity profiles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs activity profiles where activityId = &#63; and profileId = &#63;.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the number of matching l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityIdAndProfileId(java.lang.String activityId,
        java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs activity profiles.
    *
    * @return the number of l f tincan lrs activity profiles
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

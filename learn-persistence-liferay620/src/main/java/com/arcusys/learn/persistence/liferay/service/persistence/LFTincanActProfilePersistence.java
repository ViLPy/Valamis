package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanActProfile;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan act profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActProfilePersistenceImpl
 * @see LFTincanActProfileUtil
 * @generated
 */
public interface LFTincanActProfilePersistence extends BasePersistence<LFTincanActProfile> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanActProfileUtil} to access the l f tincan act profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException} if it could not be found.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan act profile where activityId = &#63; and profileId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan act profile where activityId = &#63; and profileId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the l f tincan act profile that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile removeByActivityIdAndProfileId(
        java.lang.String activityId, java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan act profiles where activityId = &#63; and profileId = &#63;.
    *
    * @param activityId the activity ID
    * @param profileId the profile ID
    * @return the number of matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityIdAndProfileId(java.lang.String activityId,
        java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan act profiles where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findByActivityId(
        java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findByActivityId(
        java.lang.String activityId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findByActivityId(
        java.lang.String activityId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityId_First(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan act profile in the ordered set where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan act profile, or <code>null</code> if a matching l f tincan act profile could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByActivityId_Last(
        java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile[] findByActivityId_PrevAndNext(
        long id, java.lang.String activityId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan act profiles where activityId = &#63; from the database.
    *
    * @param activityId the activity ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan act profiles where activityId = &#63;.
    *
    * @param activityId the activity ID
    * @return the number of matching l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public int countByActivityId(java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f tincan act profile in the entity cache if it is enabled.
    *
    * @param lfTincanActProfile the l f tincan act profile
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanActProfile lfTincanActProfile);

    /**
    * Caches the l f tincan act profiles in the entity cache if it is enabled.
    *
    * @param lfTincanActProfiles the l f tincan act profiles
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> lfTincanActProfiles);

    /**
    * Creates a new l f tincan act profile with the primary key. Does not add the l f tincan act profile to the database.
    *
    * @param id the primary key for the new l f tincan act profile
    * @return the new l f tincan act profile
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile create(
        long id);

    /**
    * Removes the l f tincan act profile with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan act profile
    * @return the l f tincan act profile that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanActProfile lfTincanActProfile)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan act profile with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException} if it could not be found.
    *
    * @param id the primary key of the l f tincan act profile
    * @return the l f tincan act profile
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan act profile with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan act profile
    * @return the l f tincan act profile, or <code>null</code> if a l f tincan act profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActProfile fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan act profiles.
    *
    * @return the l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActProfile> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan act profiles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan act profiles.
    *
    * @return the number of l f tincan act profiles
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

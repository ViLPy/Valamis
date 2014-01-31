package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRequiredActivity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f required activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRequiredActivityPersistenceImpl
 * @see LFRequiredActivityUtil
 * @generated
 */
public interface LFRequiredActivityPersistence extends BasePersistence<LFRequiredActivity> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFRequiredActivityUtil} to access the l f required activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f required activities where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the matching l f required activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f required activities where achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f required activities
    * @param end the upper bound of the range of l f required activities (not inclusive)
    * @return the range of matching l f required activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findByAchievementId(
        java.lang.Integer achievementId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f required activities where achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f required activities
    * @param end the upper bound of the range of l f required activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f required activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findByAchievementId(
        java.lang.Integer achievementId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f required activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f required activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a matching l f required activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity findByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f required activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f required activity, or <code>null</code> if a matching l f required activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity fetchByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f required activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f required activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a matching l f required activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity findByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f required activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f required activity, or <code>null</code> if a matching l f required activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity fetchByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f required activities before and after the current l f required activity in the ordered set where achievementId = &#63;.
    *
    * @param id the primary key of the current l f required activity
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f required activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity[] findByAchievementId_PrevAndNext(
        long id, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f required activities where achievementId = &#63; from the database.
    *
    * @param achievementId the achievement ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f required activities where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the number of matching l f required activities
    * @throws SystemException if a system exception occurred
    */
    public int countByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f required activity in the entity cache if it is enabled.
    *
    * @param lfRequiredActivity the l f required activity
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRequiredActivity lfRequiredActivity);

    /**
    * Caches the l f required activities in the entity cache if it is enabled.
    *
    * @param lfRequiredActivities the l f required activities
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> lfRequiredActivities);

    /**
    * Creates a new l f required activity with the primary key. Does not add the l f required activity to the database.
    *
    * @param id the primary key for the new l f required activity
    * @return the new l f required activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity create(
        long id);

    /**
    * Removes the l f required activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f required activity
    * @return the l f required activity that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRequiredActivity lfRequiredActivity)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f required activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException} if it could not be found.
    *
    * @param id the primary key of the l f required activity
    * @return the l f required activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException if a l f required activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRequiredActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f required activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f required activity
    * @return the l f required activity, or <code>null</code> if a l f required activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f required activities.
    *
    * @return the l f required activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f required activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f required activities
    * @param end the upper bound of the range of l f required activities (not inclusive)
    * @return the range of l f required activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f required activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f required activities
    * @param end the upper bound of the range of l f required activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f required activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f required activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f required activities.
    *
    * @return the number of l f required activities
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

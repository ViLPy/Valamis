package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievement;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f achievement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementPersistenceImpl
 * @see LFAchievementUtil
 * @generated
 */
public interface LFAchievementPersistence extends BasePersistence<LFAchievement> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFAchievementUtil} to access the l f achievement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f achievement in the entity cache if it is enabled.
    *
    * @param lfAchievement the l f achievement
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAchievement lfAchievement);

    /**
    * Caches the l f achievements in the entity cache if it is enabled.
    *
    * @param lfAchievements the l f achievements
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievement> lfAchievements);

    /**
    * Creates a new l f achievement with the primary key. Does not add the l f achievement to the database.
    *
    * @param id the primary key for the new l f achievement
    * @return the new l f achievement
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievement create(
        long id);

    /**
    * Removes the l f achievement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement
    * @return the l f achievement that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException if a l f achievement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievement remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFAchievement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievement lfAchievement)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f achievement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException} if it could not be found.
    *
    * @param id the primary key of the l f achievement
    * @return the l f achievement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException if a l f achievement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievement findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f achievement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f achievement
    * @return the l f achievement, or <code>null</code> if a l f achievement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievement fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f achievements.
    *
    * @return the l f achievements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f achievements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievements
    * @param end the upper bound of the range of l f achievements (not inclusive)
    * @return the range of l f achievements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f achievements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievements
    * @param end the upper bound of the range of l f achievements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f achievements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f achievements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f achievements.
    *
    * @return the number of l f achievements
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

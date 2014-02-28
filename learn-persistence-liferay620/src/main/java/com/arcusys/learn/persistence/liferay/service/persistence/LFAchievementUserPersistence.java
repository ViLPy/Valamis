package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievementUser;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f achievement user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementUserPersistenceImpl
 * @see LFAchievementUserUtil
 * @generated
 */
public interface LFAchievementUserPersistence extends BasePersistence<LFAchievementUser> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFAchievementUserUtil} to access the l f achievement user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f achievement users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f achievement users where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @return the range of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f achievement users where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByUserId_First(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByUserId_First(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByUserId_Last(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByUserId_Last(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f achievement users before and after the current l f achievement user in the ordered set where userId = &#63;.
    *
    * @param id the primary key of the current l f achievement user
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser[] findByUserId_PrevAndNext(
        long id, java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f achievement users where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f achievement users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f achievement users where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f achievement users where achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @return the range of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f achievement users where achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f achievement users before and after the current l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param id the primary key of the current l f achievement user
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser[] findByAchievementId_PrevAndNext(
        long id, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f achievement users where achievementId = &#63; from the database.
    *
    * @param achievementId the achievement ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f achievement users where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the number of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public int countByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f achievement user in the entity cache if it is enabled.
    *
    * @param lfAchievementUser the l f achievement user
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser);

    /**
    * Caches the l f achievement users in the entity cache if it is enabled.
    *
    * @param lfAchievementUsers the l f achievement users
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> lfAchievementUsers);

    /**
    * Creates a new l f achievement user with the primary key. Does not add the l f achievement user to the database.
    *
    * @param id the primary key for the new l f achievement user
    * @return the new l f achievement user
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser create(
        long id);

    /**
    * Removes the l f achievement user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f achievement user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException} if it could not be found.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f achievement user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user, or <code>null</code> if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f achievement users.
    *
    * @return the l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f achievement users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @return the range of l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f achievement users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f achievement users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f achievement users.
    *
    * @return the number of l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievementUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f achievement user service. This utility wraps {@link LFAchievementUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementUserPersistence
 * @see LFAchievementUserPersistenceImpl
 * @generated
 */
public class LFAchievementUserUtil {
    private static LFAchievementUserPersistence _persistence;

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
    public static void clearCache(LFAchievementUser lfAchievementUser) {
        getPersistence().clearCache(lfAchievementUser);
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
    public static List<LFAchievementUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFAchievementUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFAchievementUser> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFAchievementUser update(LFAchievementUser lfAchievementUser)
        throws SystemException {
        return getPersistence().update(lfAchievementUser);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFAchievementUser update(
        LFAchievementUser lfAchievementUser, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfAchievementUser, serviceContext);
    }

    /**
    * Returns all the l f achievement users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByUserId_First(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByUserId_First(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByUserId_Last(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last l f achievement user in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByUserId_Last(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser[] findByUserId_PrevAndNext(
        long id, java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(id, userId, orderByComparator);
    }

    /**
    * Removes all the l f achievement users where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of l f achievement users where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the l f achievement users where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAchievementId(achievementId);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAchievementId(achievementId, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId(achievementId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId_First(achievementId, orderByComparator);
    }

    /**
    * Returns the first l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAchievementId_First(achievementId, orderByComparator);
    }

    /**
    * Returns the last l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId_Last(achievementId, orderByComparator);
    }

    /**
    * Returns the last l f achievement user in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement user, or <code>null</code> if a matching l f achievement user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAchievementId_Last(achievementId, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser[] findByAchievementId_PrevAndNext(
        long id, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId_PrevAndNext(id, achievementId,
            orderByComparator);
    }

    /**
    * Removes all the l f achievement users where achievementId = &#63; from the database.
    *
    * @param achievementId the achievement ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAchievementId(achievementId);
    }

    /**
    * Returns the number of l f achievement users where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the number of matching l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public static int countByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAchievementId(achievementId);
    }

    /**
    * Caches the l f achievement user in the entity cache if it is enabled.
    *
    * @param lfAchievementUser the l f achievement user
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser) {
        getPersistence().cacheResult(lfAchievementUser);
    }

    /**
    * Caches the l f achievement users in the entity cache if it is enabled.
    *
    * @param lfAchievementUsers the l f achievement users
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> lfAchievementUsers) {
        getPersistence().cacheResult(lfAchievementUsers);
    }

    /**
    * Creates a new l f achievement user with the primary key. Does not add the l f achievement user to the database.
    *
    * @param id the primary key for the new l f achievement user
    * @return the new l f achievement user
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f achievement user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfAchievementUser);
    }

    /**
    * Returns the l f achievement user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException} if it could not be found.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f achievement user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user, or <code>null</code> if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f achievement users.
    *
    * @return the l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f achievement users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f achievement users.
    *
    * @return the number of l f achievement users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFAchievementUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFAchievementUserPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFAchievementUserPersistence.class.getName());

            ReferenceRegistry.registerReference(LFAchievementUserUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFAchievementUserPersistence persistence) {
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAchievementActivity;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f achievement activity service. This utility wraps {@link LFAchievementActivityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementActivityPersistence
 * @see LFAchievementActivityPersistenceImpl
 * @generated
 */
public class LFAchievementActivityUtil {
    private static LFAchievementActivityPersistence _persistence;

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
    public static void clearCache(LFAchievementActivity lfAchievementActivity) {
        getPersistence().clearCache(lfAchievementActivity);
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
    public static List<LFAchievementActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFAchievementActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFAchievementActivity> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFAchievementActivity update(
        LFAchievementActivity lfAchievementActivity) throws SystemException {
        return getPersistence().update(lfAchievementActivity);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFAchievementActivity update(
        LFAchievementActivity lfAchievementActivity,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfAchievementActivity, serviceContext);
    }

    /**
    * Returns all the l f achievement activities where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAchievementId(achievementId);
    }

    /**
    * Returns a range of all the l f achievement activities where achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @return the range of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAchievementId(
        java.lang.Integer achievementId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAchievementId(achievementId, start, end);
    }

    /**
    * Returns an ordered range of all the l f achievement activities where achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAchievementId(
        java.lang.Integer achievementId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId(achievementId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f achievement activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId_First(achievementId, orderByComparator);
    }

    /**
    * Returns the first l f achievement activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByAchievementId_First(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAchievementId_First(achievementId, orderByComparator);
    }

    /**
    * Returns the last l f achievement activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId_Last(achievementId, orderByComparator);
    }

    /**
    * Returns the last l f achievement activity in the ordered set where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByAchievementId_Last(
        java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAchievementId_Last(achievementId, orderByComparator);
    }

    /**
    * Returns the l f achievement activities before and after the current l f achievement activity in the ordered set where achievementId = &#63;.
    *
    * @param id the primary key of the current l f achievement activity
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity[] findByAchievementId_PrevAndNext(
        long id, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAchievementId_PrevAndNext(id, achievementId,
            orderByComparator);
    }

    /**
    * Removes all the l f achievement activities where achievementId = &#63; from the database.
    *
    * @param achievementId the achievement ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAchievementId(achievementId);
    }

    /**
    * Returns the number of l f achievement activities where achievementId = &#63;.
    *
    * @param achievementId the achievement ID
    * @return the number of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByAchievementId(java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAchievementId(achievementId);
    }

    /**
    * Returns all the l f achievement activities where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByUserId(
        java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns a range of all the l f achievement activities where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @return the range of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByUserId(
        java.lang.Integer userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    /**
    * Returns an ordered range of all the l f achievement activities where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByUserId(
        java.lang.Integer userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f achievement activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByUserId_First(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first l f achievement activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByUserId_First(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last l f achievement activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByUserId_Last(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last l f achievement activity in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByUserId_Last(
        java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the l f achievement activities before and after the current l f achievement activity in the ordered set where userId = &#63;.
    *
    * @param id the primary key of the current l f achievement activity
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity[] findByUserId_PrevAndNext(
        long id, java.lang.Integer userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId_PrevAndNext(id, userId, orderByComparator);
    }

    /**
    * Removes all the l f achievement activities where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of l f achievement activities where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the l f achievement activities where userId = &#63; and achievementId = &#63;.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @return the matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAllByAchievementAndUserId(
        java.lang.Integer userId, java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllByAchievementAndUserId(userId, achievementId);
    }

    /**
    * Returns a range of all the l f achievement activities where userId = &#63; and achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @return the range of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAllByAchievementAndUserId(
        java.lang.Integer userId, java.lang.Integer achievementId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllByAchievementAndUserId(userId, achievementId,
            start, end);
    }

    /**
    * Returns an ordered range of all the l f achievement activities where userId = &#63; and achievementId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAllByAchievementAndUserId(
        java.lang.Integer userId, java.lang.Integer achievementId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllByAchievementAndUserId(userId, achievementId,
            start, end, orderByComparator);
    }

    /**
    * Returns the first l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByAllByAchievementAndUserId_First(
        java.lang.Integer userId, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllByAchievementAndUserId_First(userId,
            achievementId, orderByComparator);
    }

    /**
    * Returns the first l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByAllByAchievementAndUserId_First(
        java.lang.Integer userId, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAllByAchievementAndUserId_First(userId,
            achievementId, orderByComparator);
    }

    /**
    * Returns the last l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByAllByAchievementAndUserId_Last(
        java.lang.Integer userId, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllByAchievementAndUserId_Last(userId, achievementId,
            orderByComparator);
    }

    /**
    * Returns the last l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f achievement activity, or <code>null</code> if a matching l f achievement activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByAllByAchievementAndUserId_Last(
        java.lang.Integer userId, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAllByAchievementAndUserId_Last(userId,
            achievementId, orderByComparator);
    }

    /**
    * Returns the l f achievement activities before and after the current l f achievement activity in the ordered set where userId = &#63; and achievementId = &#63;.
    *
    * @param id the primary key of the current l f achievement activity
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity[] findByAllByAchievementAndUserId_PrevAndNext(
        long id, java.lang.Integer userId, java.lang.Integer achievementId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllByAchievementAndUserId_PrevAndNext(id, userId,
            achievementId, orderByComparator);
    }

    /**
    * Removes all the l f achievement activities where userId = &#63; and achievementId = &#63; from the database.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAllByAchievementAndUserId(
        java.lang.Integer userId, java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAllByAchievementAndUserId(userId, achievementId);
    }

    /**
    * Returns the number of l f achievement activities where userId = &#63; and achievementId = &#63;.
    *
    * @param userId the user ID
    * @param achievementId the achievement ID
    * @return the number of matching l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static int countByAllByAchievementAndUserId(
        java.lang.Integer userId, java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByAllByAchievementAndUserId(userId, achievementId);
    }

    /**
    * Caches the l f achievement activity in the entity cache if it is enabled.
    *
    * @param lfAchievementActivity the l f achievement activity
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAchievementActivity lfAchievementActivity) {
        getPersistence().cacheResult(lfAchievementActivity);
    }

    /**
    * Caches the l f achievement activities in the entity cache if it is enabled.
    *
    * @param lfAchievementActivities the l f achievement activities
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> lfAchievementActivities) {
        getPersistence().cacheResult(lfAchievementActivities);
    }

    /**
    * Creates a new l f achievement activity with the primary key. Does not add the l f achievement activity to the database.
    *
    * @param id the primary key for the new l f achievement activity
    * @return the new l f achievement activity
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f achievement activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement activity
    * @return the l f achievement activity that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAchievementActivity lfAchievementActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfAchievementActivity);
    }

    /**
    * Returns the l f achievement activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException} if it could not be found.
    *
    * @param id the primary key of the l f achievement activity
    * @return the l f achievement activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAchievementActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f achievement activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f achievement activity
    * @return the l f achievement activity, or <code>null</code> if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f achievement activities.
    *
    * @return the l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f achievement activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @return the range of l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f achievement activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f achievement activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f achievement activities.
    *
    * @return the number of l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFAchievementActivityPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFAchievementActivityPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFAchievementActivityPersistence.class.getName());

            ReferenceRegistry.registerReference(LFAchievementActivityUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFAchievementActivityPersistence persistence) {
    }
}

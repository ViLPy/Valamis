package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAttempt;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f attempt service. This utility wraps {@link LFAttemptPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptPersistence
 * @see LFAttemptPersistenceImpl
 * @generated
 */
public class LFAttemptUtil {
    private static LFAttemptPersistence _persistence;

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
    public static void clearCache(LFAttempt lfAttempt) {
        getPersistence().clearCache(lfAttempt);
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
    public static List<LFAttempt> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFAttempt> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFAttempt> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFAttempt update(LFAttempt lfAttempt)
        throws SystemException {
        return getPersistence().update(lfAttempt);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFAttempt update(LFAttempt lfAttempt,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfAttempt, serviceContext);
    }

    /**
    * Returns all the l f attempts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID);
    }

    /**
    * Returns a range of all the l f attempts where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPackageID(packageID, start, end);
    }

    /**
    * Returns an ordered range of all the l f attempts where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID(packageID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the first l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_First(packageID, orderByComparator);
    }

    /**
    * Returns the last l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_Last(packageID, orderByComparator);
    }

    /**
    * Returns the last l f attempt in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPackageID_Last(packageID, orderByComparator);
    }

    /**
    * Returns the l f attempts before and after the current l f attempt in the ordered set where packageID = &#63;.
    *
    * @param id the primary key of the current l f attempt
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt[] findByPackageID_PrevAndNext(
        long id, java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPackageID_PrevAndNext(id, packageID, orderByComparator);
    }

    /**
    * Removes all the l f attempts where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPackageID(packageID);
    }

    /**
    * Returns the number of l f attempts where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPackageID(packageID);
    }

    /**
    * Returns all the l f attempts where userID = &#63;.
    *
    * @param userID the user i d
    * @return the matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID(userID);
    }

    /**
    * Returns a range of all the l f attempts where userID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userID the user i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID(userID, start, end);
    }

    /**
    * Returns an ordered range of all the l f attempts where userID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userID the user i d
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserID(userID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID_First(userID, orderByComparator);
    }

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserID_First(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserID_First(userID, orderByComparator);
    }

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserID_Last(userID, orderByComparator);
    }

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63;.
    *
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserID_Last(
        java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserID_Last(userID, orderByComparator);
    }

    /**
    * Returns the l f attempts before and after the current l f attempt in the ordered set where userID = &#63;.
    *
    * @param id the primary key of the current l f attempt
    * @param userID the user i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt[] findByUserID_PrevAndNext(
        long id, java.lang.Integer userID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserID_PrevAndNext(id, userID, orderByComparator);
    }

    /**
    * Removes all the l f attempts where userID = &#63; from the database.
    *
    * @param userID the user i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserID(userID);
    }

    /**
    * Returns the number of l f attempts where userID = &#63;.
    *
    * @param userID the user i d
    * @return the number of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserID(java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserID(userID);
    }

    /**
    * Returns all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @return the matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDPackageIDIsComplete(userID, packageID,
            isComplete);
    }

    /**
    * Returns a range of all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDPackageIDIsComplete(userID, packageID,
            isComplete, start, end);
    }

    /**
    * Returns an ordered range of all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDPackageIDIsComplete(userID, packageID,
            isComplete, start, end, orderByComparator);
    }

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserIDPackageIDIsComplete_First(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDPackageIDIsComplete_First(userID, packageID,
            isComplete, orderByComparator);
    }

    /**
    * Returns the first l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserIDPackageIDIsComplete_First(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIDPackageIDIsComplete_First(userID, packageID,
            isComplete, orderByComparator);
    }

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByUserIDPackageIDIsComplete_Last(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDPackageIDIsComplete_Last(userID, packageID,
            isComplete, orderByComparator);
    }

    /**
    * Returns the last l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f attempt, or <code>null</code> if a matching l f attempt could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByUserIDPackageIDIsComplete_Last(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIDPackageIDIsComplete_Last(userID, packageID,
            isComplete, orderByComparator);
    }

    /**
    * Returns the l f attempts before and after the current l f attempt in the ordered set where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param id the primary key of the current l f attempt
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt[] findByUserIDPackageIDIsComplete_PrevAndNext(
        long id, java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIDPackageIDIsComplete_PrevAndNext(id, userID,
            packageID, isComplete, orderByComparator);
    }

    /**
    * Removes all the l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63; from the database.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByUserIDPackageIDIsComplete(userID, packageID, isComplete);
    }

    /**
    * Returns the number of l f attempts where userID = &#63; and packageID = &#63; and isComplete = &#63;.
    *
    * @param userID the user i d
    * @param packageID the package i d
    * @param isComplete the is complete
    * @return the number of matching l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByUserIDPackageIDIsComplete(userID, packageID,
            isComplete);
    }

    /**
    * Caches the l f attempt in the entity cache if it is enabled.
    *
    * @param lfAttempt the l f attempt
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt) {
        getPersistence().cacheResult(lfAttempt);
    }

    /**
    * Caches the l f attempts in the entity cache if it is enabled.
    *
    * @param lfAttempts the l f attempts
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> lfAttempts) {
        getPersistence().cacheResult(lfAttempts);
    }

    /**
    * Creates a new l f attempt with the primary key. Does not add the l f attempt to the database.
    *
    * @param id the primary key for the new l f attempt
    * @return the new l f attempt
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f attempt with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFAttempt updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfAttempt);
    }

    /**
    * Returns the l f attempt with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException} if it could not be found.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f attempt with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt, or <code>null</code> if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttempt fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f attempts.
    *
    * @return the l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f attempts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f attempts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f attempts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f attempts.
    *
    * @return the number of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFAttemptPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFAttemptPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFAttemptPersistence.class.getName());

            ReferenceRegistry.registerReference(LFAttemptUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFAttemptPersistence persistence) {
    }
}

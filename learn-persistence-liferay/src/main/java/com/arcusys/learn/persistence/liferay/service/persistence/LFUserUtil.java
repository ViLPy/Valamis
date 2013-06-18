package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFUser;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f user service. This utility wraps {@link LFUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFUserPersistence
 * @see LFUserPersistenceImpl
 * @generated
 */
public class LFUserUtil {
    private static LFUserPersistence _persistence;

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
    public static void clearCache(LFUser lfUser) {
        getPersistence().clearCache(lfUser);
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
    public static List<LFUser> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFUser> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFUser> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFUser update(LFUser lfUser, boolean merge)
        throws SystemException {
        return getPersistence().update(lfUser, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFUser update(LFUser lfUser, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfUser, merge, serviceContext);
    }

    /**
    * Caches the l f user in the entity cache if it is enabled.
    *
    * @param lfUser the l f user
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser) {
        getPersistence().cacheResult(lfUser);
    }

    /**
    * Caches the l f users in the entity cache if it is enabled.
    *
    * @param lfUsers the l f users
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> lfUsers) {
        getPersistence().cacheResult(lfUsers);
    }

    /**
    * Creates a new l f user with the primary key. Does not add the l f user to the database.
    *
    * @param lfid the primary key for the new l f user
    * @return the new l f user
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser create(
        long lfid) {
        return getPersistence().create(lfid);
    }

    /**
    * Removes the l f user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfid the primary key of the l f user
    * @return the l f user that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser remove(
        long lfid)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfid);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFUser updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfUser, merge);
    }

    /**
    * Returns the l f user with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFUserException} if it could not be found.
    *
    * @param lfid the primary key of the l f user
    * @return the l f user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser findByPrimaryKey(
        long lfid)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfid);
    }

    /**
    * Returns the l f user with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfid the primary key of the l f user
    * @return the l f user, or <code>null</code> if a l f user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser fetchByPrimaryKey(
        long lfid) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfid);
    }

    /**
    * Returns the l f user where id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFUserException} if it could not be found.
    *
    * @param id the ID
    * @return the matching l f user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser findByUserId(
        java.lang.Integer id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(id);
    }

    /**
    * Returns the l f user where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param id the ID
    * @return the matching l f user, or <code>null</code> if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser fetchByUserId(
        java.lang.Integer id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId(id);
    }

    /**
    * Returns the l f user where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param id the ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f user, or <code>null</code> if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser fetchByUserId(
        java.lang.Integer id, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId(id, retrieveFromCache);
    }

    /**
    * Returns all the l f users where id = &#63;.
    *
    * @param id the ID
    * @return the matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIdCollection(
        java.lang.Integer id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdCollection(id);
    }

    /**
    * Returns a range of all the l f users where id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the ID
    * @param start the lower bound of the range of l f users
    * @param end the upper bound of the range of l f users (not inclusive)
    * @return the range of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIdCollection(
        java.lang.Integer id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdCollection(id, start, end);
    }

    /**
    * Returns an ordered range of all the l f users where id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the ID
    * @param start the lower bound of the range of l f users
    * @param end the upper bound of the range of l f users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIdCollection(
        java.lang.Integer id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdCollection(id, start, end, orderByComparator);
    }

    /**
    * Returns the first l f user in the ordered set where id = &#63;.
    *
    * @param id the ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser findByUserIdCollection_First(
        java.lang.Integer id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdCollection_First(id, orderByComparator);
    }

    /**
    * Returns the first l f user in the ordered set where id = &#63;.
    *
    * @param id the ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f user, or <code>null</code> if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser fetchByUserIdCollection_First(
        java.lang.Integer id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIdCollection_First(id, orderByComparator);
    }

    /**
    * Returns the last l f user in the ordered set where id = &#63;.
    *
    * @param id the ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser findByUserIdCollection_Last(
        java.lang.Integer id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdCollection_Last(id, orderByComparator);
    }

    /**
    * Returns the last l f user in the ordered set where id = &#63;.
    *
    * @param id the ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f user, or <code>null</code> if a matching l f user could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser fetchByUserIdCollection_Last(
        java.lang.Integer id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIdCollection_Last(id, orderByComparator);
    }

    /**
    * Returns the l f users before and after the current l f user in the ordered set where id = &#63;.
    *
    * @param lfid the primary key of the current l f user
    * @param id the ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f user
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException if a l f user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser[] findByUserIdCollection_PrevAndNext(
        long lfid, java.lang.Integer id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdCollection_PrevAndNext(lfid, id,
            orderByComparator);
    }

    /**
    * Returns all the l f users where id = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ids the IDs
    * @return the matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIdCollection(
        java.lang.Integer[] ids)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdCollection(ids);
    }

    /**
    * Returns a range of all the l f users where id = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ids the IDs
    * @param start the lower bound of the range of l f users
    * @param end the upper bound of the range of l f users (not inclusive)
    * @return the range of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIdCollection(
        java.lang.Integer[] ids, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdCollection(ids, start, end);
    }

    /**
    * Returns an ordered range of all the l f users where id = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ids the IDs
    * @param start the lower bound of the range of l f users
    * @param end the upper bound of the range of l f users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIdCollection(
        java.lang.Integer[] ids, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdCollection(ids, start, end, orderByComparator);
    }

    /**
    * Returns all the l f users.
    *
    * @return the l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f users
    * @param end the upper bound of the range of l f users (not inclusive)
    * @return the range of l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f users
    * @param end the upper bound of the range of l f users (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f user where id = &#63; from the database.
    *
    * @param id the ID
    * @return the l f user that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFUser removeByUserId(
        java.lang.Integer id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByUserId(id);
    }

    /**
    * Removes all the l f users where id = &#63; from the database.
    *
    * @param id the ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserIdCollection(java.lang.Integer id)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserIdCollection(id);
    }

    /**
    * Removes all the l f users from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f users where id = &#63;.
    *
    * @param id the ID
    * @return the number of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(java.lang.Integer id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(id);
    }

    /**
    * Returns the number of l f users where id = &#63;.
    *
    * @param id the ID
    * @return the number of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIdCollection(java.lang.Integer id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserIdCollection(id);
    }

    /**
    * Returns the number of l f users where id = any &#63;.
    *
    * @param ids the IDs
    * @return the number of matching l f users
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIdCollection(java.lang.Integer[] ids)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserIdCollection(ids);
    }

    /**
    * Returns the number of l f users.
    *
    * @return the number of l f users
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFUserPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFUserPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFUserPersistence.class.getName());

            ReferenceRegistry.registerReference(LFUserUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFUserPersistence persistence) {
    }
}

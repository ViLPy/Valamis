package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRole;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f role service. This utility wraps {@link LFRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRolePersistence
 * @see LFRolePersistenceImpl
 * @generated
 */
public class LFRoleUtil {
    private static LFRolePersistence _persistence;

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
    public static void clearCache(LFRole lfRole) {
        getPersistence().clearCache(lfRole);
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
    public static List<LFRole> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFRole> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFRole> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFRole update(LFRole lfRole, boolean merge)
        throws SystemException {
        return getPersistence().update(lfRole, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFRole update(LFRole lfRole, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfRole, merge, serviceContext);
    }

    /**
    * Caches the l f role in the entity cache if it is enabled.
    *
    * @param lfRole the l f role
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole) {
        getPersistence().cacheResult(lfRole);
    }

    /**
    * Caches the l f roles in the entity cache if it is enabled.
    *
    * @param lfRoles the l f roles
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> lfRoles) {
        getPersistence().cacheResult(lfRoles);
    }

    /**
    * Creates a new l f role with the primary key. Does not add the l f role to the database.
    *
    * @param id the primary key for the new l f role
    * @return the new l f role
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f role with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f role
    * @return the l f role that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFRole updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfRole, merge);
    }

    /**
    * Returns the l f role with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRoleException} if it could not be found.
    *
    * @param id the primary key of the l f role
    * @return the l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f role with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f role
    * @return the l f role, or <code>null</code> if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f roles where permission = &#63;.
    *
    * @param permission the permission
    * @return the matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPermission(permission);
    }

    /**
    * Returns a range of all the l f roles where permission = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param permission the permission
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @return the range of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPermission(permission, start, end);
    }

    /**
    * Returns an ordered range of all the l f roles where permission = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param permission the permission
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPermission(permission, start, end, orderByComparator);
    }

    /**
    * Returns the first l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByPermission_First(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPermission_First(permission, orderByComparator);
    }

    /**
    * Returns the first l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByPermission_First(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPermission_First(permission, orderByComparator);
    }

    /**
    * Returns the last l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByPermission_Last(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPermission_Last(permission, orderByComparator);
    }

    /**
    * Returns the last l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByPermission_Last(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPermission_Last(permission, orderByComparator);
    }

    /**
    * Returns the l f roles before and after the current l f role in the ordered set where permission = &#63;.
    *
    * @param id the primary key of the current l f role
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole[] findByPermission_PrevAndNext(
        long id, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPermission_PrevAndNext(id, permission,
            orderByComparator);
    }

    /**
    * Returns all the l f roles where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @return the matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoleIDAndPermission(liferayRoleID, permission);
    }

    /**
    * Returns a range of all the l f roles where liferayRoleID = &#63; and permission = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @return the range of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoleIDAndPermission(liferayRoleID, permission, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f roles where liferayRoleID = &#63; and permission = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoleIDAndPermission(liferayRoleID, permission, start,
            end, orderByComparator);
    }

    /**
    * Returns the first l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByRoleIDAndPermission_First(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoleIDAndPermission_First(liferayRoleID, permission,
            orderByComparator);
    }

    /**
    * Returns the first l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByRoleIDAndPermission_First(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRoleIDAndPermission_First(liferayRoleID, permission,
            orderByComparator);
    }

    /**
    * Returns the last l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByRoleIDAndPermission_Last(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoleIDAndPermission_Last(liferayRoleID, permission,
            orderByComparator);
    }

    /**
    * Returns the last l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByRoleIDAndPermission_Last(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRoleIDAndPermission_Last(liferayRoleID, permission,
            orderByComparator);
    }

    /**
    * Returns the l f roles before and after the current l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param id the primary key of the current l f role
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole[] findByRoleIDAndPermission_PrevAndNext(
        long id, java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRoleIDAndPermission_PrevAndNext(id, liferayRoleID,
            permission, orderByComparator);
    }

    /**
    * Returns all the l f roles where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @return the matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDefaultAndPermission(isDefault, permission);
    }

    /**
    * Returns a range of all the l f roles where isDefault = &#63; and permission = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @return the range of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDefaultAndPermission(isDefault, permission, start, end);
    }

    /**
    * Returns an ordered range of all the l f roles where isDefault = &#63; and permission = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDefaultAndPermission(isDefault, permission, start,
            end, orderByComparator);
    }

    /**
    * Returns the first l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByDefaultAndPermission_First(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDefaultAndPermission_First(isDefault, permission,
            orderByComparator);
    }

    /**
    * Returns the first l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByDefaultAndPermission_First(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDefaultAndPermission_First(isDefault, permission,
            orderByComparator);
    }

    /**
    * Returns the last l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole findByDefaultAndPermission_Last(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDefaultAndPermission_Last(isDefault, permission,
            orderByComparator);
    }

    /**
    * Returns the last l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchByDefaultAndPermission_Last(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDefaultAndPermission_Last(isDefault, permission,
            orderByComparator);
    }

    /**
    * Returns the l f roles before and after the current l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param id the primary key of the current l f role
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole[] findByDefaultAndPermission_PrevAndNext(
        long id, java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDefaultAndPermission_PrevAndNext(id, isDefault,
            permission, orderByComparator);
    }

    /**
    * Returns all the l f roles.
    *
    * @return the l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f roles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @return the range of l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f roles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f roles
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f roles where permission = &#63; from the database.
    *
    * @param permission the permission
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPermission(java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPermission(permission);
    }

    /**
    * Removes all the l f roles where liferayRoleID = &#63; and permission = &#63; from the database.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @throws SystemException if a system exception occurred
    */
    public static void removeByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByRoleIDAndPermission(liferayRoleID, permission);
    }

    /**
    * Removes all the l f roles where isDefault = &#63; and permission = &#63; from the database.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDefaultAndPermission(isDefault, permission);
    }

    /**
    * Removes all the l f roles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f roles where permission = &#63;.
    *
    * @param permission the permission
    * @return the number of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static int countByPermission(java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPermission(permission);
    }

    /**
    * Returns the number of l f roles where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @return the number of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static int countByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByRoleIDAndPermission(liferayRoleID, permission);
    }

    /**
    * Returns the number of l f roles where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @return the number of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public static int countByDefaultAndPermission(java.lang.Boolean isDefault,
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByDefaultAndPermission(isDefault, permission);
    }

    /**
    * Returns the number of l f roles.
    *
    * @return the number of l f roles
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFRolePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFRolePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFRolePersistence.class.getName());

            ReferenceRegistry.registerReference(LFRoleUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFRolePersistence persistence) {
    }
}

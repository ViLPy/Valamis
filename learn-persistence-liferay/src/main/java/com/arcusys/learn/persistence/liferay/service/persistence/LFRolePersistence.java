package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRole;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRolePersistenceImpl
 * @see LFRoleUtil
 * @generated
 */
public interface LFRolePersistence extends BasePersistence<LFRole> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFRoleUtil} to access the l f role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f role in the entity cache if it is enabled.
    *
    * @param lfRole the l f role
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole);

    /**
    * Caches the l f roles in the entity cache if it is enabled.
    *
    * @param lfRoles the l f roles
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> lfRoles);

    /**
    * Creates a new l f role with the primary key. Does not add the l f role to the database.
    *
    * @param id the primary key for the new l f role
    * @return the new l f role
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole create(long id);

    /**
    * Removes the l f role with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f role
    * @return the l f role that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole remove(long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFRole updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f role with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRoleException} if it could not be found.
    *
    * @param id the primary key of the l f role
    * @return the l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f role with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f role
    * @return the l f role, or <code>null</code> if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f roles where permission = &#63;.
    *
    * @param permission the permission
    * @return the matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole findByPermission_First(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByPermission_First(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole findByPermission_Last(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f role in the ordered set where permission = &#63;.
    *
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByPermission_Last(
        java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole[] findByPermission_PrevAndNext(
        long id, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f roles where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @return the matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole findByRoleIDAndPermission_First(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByRoleIDAndPermission_First(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole findByRoleIDAndPermission_Last(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f role in the ordered set where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByRoleIDAndPermission_Last(
        java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole[] findByRoleIDAndPermission_PrevAndNext(
        long id, java.lang.Integer liferayRoleID, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f roles where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @return the matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.Boolean isDefault, java.lang.String permission, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole findByDefaultAndPermission_First(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByDefaultAndPermission_First(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole findByDefaultAndPermission_Last(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f role in the ordered set where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f role, or <code>null</code> if a matching l f role could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchByDefaultAndPermission_Last(
        java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRole[] findByDefaultAndPermission_PrevAndNext(
        long id, java.lang.Boolean isDefault, java.lang.String permission,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRoleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f roles.
    *
    * @return the l f roles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f roles where permission = &#63; from the database.
    *
    * @param permission the permission
    * @throws SystemException if a system exception occurred
    */
    public void removeByPermission(java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f roles where liferayRoleID = &#63; and permission = &#63; from the database.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @throws SystemException if a system exception occurred
    */
    public void removeByRoleIDAndPermission(java.lang.Integer liferayRoleID,
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f roles where isDefault = &#63; and permission = &#63; from the database.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @throws SystemException if a system exception occurred
    */
    public void removeByDefaultAndPermission(java.lang.Boolean isDefault,
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f roles from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f roles where permission = &#63;.
    *
    * @param permission the permission
    * @return the number of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public int countByPermission(java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f roles where liferayRoleID = &#63; and permission = &#63;.
    *
    * @param liferayRoleID the liferay role i d
    * @param permission the permission
    * @return the number of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public int countByRoleIDAndPermission(java.lang.Integer liferayRoleID,
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f roles where isDefault = &#63; and permission = &#63;.
    *
    * @param isDefault the is default
    * @param permission the permission
    * @return the number of matching l f roles
    * @throws SystemException if a system exception occurred
    */
    public int countByDefaultAndPermission(java.lang.Boolean isDefault,
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f roles.
    *
    * @return the number of l f roles
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

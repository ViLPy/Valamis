package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSeqPermissions;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f seq permissions service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSeqPermissionsPersistenceImpl
 * @see LFSeqPermissionsUtil
 * @generated
 */
public interface LFSeqPermissionsPersistence extends BasePersistence<LFSeqPermissions> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSeqPermissionsUtil} to access the l f seq permissions persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f seq permissionses where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f seq permissionses where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f seq permissionses
    * @param end the upper bound of the range of l f seq permissionses (not inclusive)
    * @return the range of matching l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f seq permissionses where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f seq permissionses
    * @param end the upper bound of the range of l f seq permissionses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f seq permissions in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f seq permissions
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a matching l f seq permissions could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions findBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f seq permissions in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f seq permissions, or <code>null</code> if a matching l f seq permissions could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions fetchBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f seq permissions in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f seq permissions
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a matching l f seq permissions could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions findBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f seq permissions in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f seq permissions, or <code>null</code> if a matching l f seq permissions could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions fetchBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f seq permissionses before and after the current l f seq permissions in the ordered set where sequencingID = &#63;.
    *
    * @param id the primary key of the current l f seq permissions
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f seq permissions
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions[] findBySequencingID_PrevAndNext(
        long id, java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f seq permissionses where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @throws SystemException if a system exception occurred
    */
    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f seq permissionses where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f seq permissions in the entity cache if it is enabled.
    *
    * @param lfSeqPermissions the l f seq permissions
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSeqPermissions lfSeqPermissions);

    /**
    * Caches the l f seq permissionses in the entity cache if it is enabled.
    *
    * @param lfSeqPermissionses the l f seq permissionses
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> lfSeqPermissionses);

    /**
    * Creates a new l f seq permissions with the primary key. Does not add the l f seq permissions to the database.
    *
    * @param id the primary key for the new l f seq permissions
    * @return the new l f seq permissions
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions create(
        long id);

    /**
    * Removes the l f seq permissions with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f seq permissions
    * @return the l f seq permissions that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSeqPermissions lfSeqPermissions)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f seq permissions with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException} if it could not be found.
    *
    * @param id the primary key of the l f seq permissions
    * @return the l f seq permissions
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException if a l f seq permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSeqPermissionsException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f seq permissions with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f seq permissions
    * @return the l f seq permissions, or <code>null</code> if a l f seq permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f seq permissionses.
    *
    * @return the l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f seq permissionses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f seq permissionses
    * @param end the upper bound of the range of l f seq permissionses (not inclusive)
    * @return the range of l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f seq permissionses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f seq permissionses
    * @param end the upper bound of the range of l f seq permissionses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f seq permissionses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f seq permissionses.
    *
    * @return the number of l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

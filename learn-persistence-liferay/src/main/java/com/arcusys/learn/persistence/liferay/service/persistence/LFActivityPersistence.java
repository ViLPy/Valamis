package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFActivity;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityPersistenceImpl
 * @see LFActivityUtil
 * @generated
 */
public interface LFActivityPersistence extends BasePersistence<LFActivity> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFActivityUtil} to access the l f activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f activity where packageID = &#63; and id = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity where packageID = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param packageID the package i d
    * @param id the ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageAndID(
        java.lang.Integer packageID, java.lang.String id,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f activity where packageID = &#63; and id = &#63; from the database.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the l f activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity removeByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activities where packageID = &#63; and id = &#63;.
    *
    * @param packageID the package i d
    * @param id the ID
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageAndID(java.lang.Integer packageID,
        java.lang.String id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activities where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activities where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activities where packageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageID_First(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63;.
    *
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageID_Last(
        java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63;.
    *
    * @param indexNumber the primary key of the current l f activity
    * @param packageID the package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity[] findByPackageID_PrevAndNext(
        long indexNumber, java.lang.Integer packageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activities where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activities where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @return the matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndOrganizationID_First(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndOrganizationID_First(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndOrganizationID_Last(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndOrganizationID_Last(
        java.lang.Integer packageID, java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and organizationID = &#63;.
    *
    * @param indexNumber the primary key of the current l f activity
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity[] findByPackageIDAndOrganizationID_PrevAndNext(
        long indexNumber, java.lang.Integer packageID,
        java.lang.String organizationID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activities where packageID = &#63; and organizationID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activities where packageID = &#63; and organizationID = &#63;.
    *
    * @param packageID the package i d
    * @param organizationID the organization i d
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageIDAndOrganizationID(java.lang.Integer packageID,
        java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activities where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @return the matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activities where packageID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activities where packageID = &#63; and parentID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndParentID_First(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndParentID_First(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageIDAndParentID_Last(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f activity, or <code>null</code> if a matching l f activity could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPackageIDAndParentID_Last(
        java.lang.Integer packageID, java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activities before and after the current l f activity in the ordered set where packageID = &#63; and parentID = &#63;.
    *
    * @param indexNumber the primary key of the current l f activity
    * @param packageID the package i d
    * @param parentID the parent i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity[] findByPackageIDAndParentID_PrevAndNext(
        long indexNumber, java.lang.Integer packageID,
        java.lang.String parentID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activities where packageID = &#63; and parentID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPackageIDAndParentID(java.lang.Integer packageID,
        java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activities where packageID = &#63; and parentID = &#63;.
    *
    * @param packageID the package i d
    * @param parentID the parent i d
    * @return the number of matching l f activities
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageIDAndParentID(java.lang.Integer packageID,
        java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f activity in the entity cache if it is enabled.
    *
    * @param lfActivity the l f activity
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity);

    /**
    * Caches the l f activities in the entity cache if it is enabled.
    *
    * @param lfActivities the l f activities
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> lfActivities);

    /**
    * Creates a new l f activity with the primary key. Does not add the l f activity to the database.
    *
    * @param indexNumber the primary key for the new l f activity
    * @return the new l f activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity create(
        long indexNumber);

    /**
    * Removes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity remove(
        long indexNumber)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFActivity updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFActivityException} if it could not be found.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPrimaryKey(
        long indexNumber)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFActivityException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f activity with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity, or <code>null</code> if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchByPrimaryKey(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f activities.
    *
    * @return the l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f activities from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f activities.
    *
    * @return the number of l f activities
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

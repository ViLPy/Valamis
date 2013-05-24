package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFUserLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFUserLocalService
 * @generated
 */
public class LFUserLocalServiceWrapper implements LFUserLocalService,
    ServiceWrapper<LFUserLocalService> {
    private LFUserLocalService _lfUserLocalService;

    public LFUserLocalServiceWrapper(LFUserLocalService lfUserLocalService) {
        _lfUserLocalService = lfUserLocalService;
    }

    /**
    * Adds the l f user to the database. Also notifies the appropriate model listeners.
    *
    * @param lfUser the l f user
    * @return the l f user that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser addLFUser(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.addLFUser(lfUser);
    }

    /**
    * Creates a new l f user with the primary key. Does not add the l f user to the database.
    *
    * @param lfid the primary key for the new l f user
    * @return the new l f user
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser createLFUser(
        long lfid) {
        return _lfUserLocalService.createLFUser(lfid);
    }

    /**
    * Deletes the l f user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfid the primary key of the l f user
    * @return the l f user that was removed
    * @throws PortalException if a l f user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser deleteLFUser(
        long lfid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.deleteLFUser(lfid);
    }

    /**
    * Deletes the l f user from the database. Also notifies the appropriate model listeners.
    *
    * @param lfUser the l f user
    * @return the l f user that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser deleteLFUser(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.deleteLFUser(lfUser);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfUserLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFUser fetchLFUser(
        long lfid) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.fetchLFUser(lfid);
    }

    /**
    * Returns the l f user with the primary key.
    *
    * @param lfid the primary key of the l f user
    * @return the l f user
    * @throws PortalException if a l f user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser getLFUser(
        long lfid)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.getLFUser(lfid);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> getLFUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.getLFUsers(start, end);
    }

    /**
    * Returns the number of l f users.
    *
    * @return the number of l f users
    * @throws SystemException if a system exception occurred
    */
    public int getLFUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.getLFUsersCount();
    }

    /**
    * Updates the l f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfUser the l f user
    * @return the l f user that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser updateLFUser(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.updateLFUser(lfUser);
    }

    /**
    * Updates the l f user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfUser the l f user
    * @param merge whether to merge the l f user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f user that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFUser updateLFUser(
        com.arcusys.learn.persistence.liferay.model.LFUser lfUser, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.updateLFUser(lfUser, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfUserLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFUser createLFUser()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.createLFUser();
    }

    public com.arcusys.learn.persistence.liferay.model.LFUser findByUserId(
        java.lang.Integer id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.findByUserId(id);
    }

    public void removeByUserId(java.lang.Integer id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        _lfUserLocalService.removeByUserId(id);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFUser> findByUserIds(
        java.lang.Integer[] ids)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfUserLocalService.findByUserIds(ids);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfUserLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFUserLocalService getWrappedLFUserLocalService() {
        return _lfUserLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFUserLocalService(
        LFUserLocalService lfUserLocalService) {
        _lfUserLocalService = lfUserLocalService;
    }

    public LFUserLocalService getWrappedService() {
        return _lfUserLocalService;
    }

    public void setWrappedService(LFUserLocalService lfUserLocalService) {
        _lfUserLocalService = lfUserLocalService;
    }
}

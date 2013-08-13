package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateUserLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFCertificateUserLocalService
 * @generated
 */
public class LFCertificateUserLocalServiceWrapper
    implements LFCertificateUserLocalService,
        ServiceWrapper<LFCertificateUserLocalService> {
    private LFCertificateUserLocalService _lfCertificateUserLocalService;

    public LFCertificateUserLocalServiceWrapper(
        LFCertificateUserLocalService lfCertificateUserLocalService) {
        _lfCertificateUserLocalService = lfCertificateUserLocalService;
    }

    /**
    * Adds the l f certificate user to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateUser the l f certificate user
    * @return the l f certificate user that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser addLFCertificateUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.addLFCertificateUser(lfCertificateUser);
    }

    /**
    * Creates a new l f certificate user with the primary key. Does not add the l f certificate user to the database.
    *
    * @param id the primary key for the new l f certificate user
    * @return the new l f certificate user
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser createLFCertificateUser(
        long id) {
        return _lfCertificateUserLocalService.createLFCertificateUser(id);
    }

    /**
    * Deletes the l f certificate user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate user
    * @return the l f certificate user that was removed
    * @throws PortalException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser deleteLFCertificateUser(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.deleteLFCertificateUser(id);
    }

    /**
    * Deletes the l f certificate user from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateUser the l f certificate user
    * @return the l f certificate user that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser deleteLFCertificateUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.deleteLFCertificateUser(lfCertificateUser);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCertificateUserLocalService.dynamicQuery();
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
        return _lfCertificateUserLocalService.dynamicQuery(dynamicQuery);
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
        return _lfCertificateUserLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
        return _lfCertificateUserLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _lfCertificateUserLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser fetchLFCertificateUser(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.fetchLFCertificateUser(id);
    }

    /**
    * Returns the l f certificate user with the primary key.
    *
    * @param id the primary key of the l f certificate user
    * @return the l f certificate user
    * @throws PortalException if a l f certificate user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser getLFCertificateUser(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.getLFCertificateUser(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificate users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate users
    * @param end the upper bound of the range of l f certificate users (not inclusive)
    * @return the range of l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> getLFCertificateUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.getLFCertificateUsers(start, end);
    }

    /**
    * Returns the number of l f certificate users.
    *
    * @return the number of l f certificate users
    * @throws SystemException if a system exception occurred
    */
    public int getLFCertificateUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.getLFCertificateUsersCount();
    }

    /**
    * Updates the l f certificate user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateUser the l f certificate user
    * @return the l f certificate user that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser updateLFCertificateUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.updateLFCertificateUser(lfCertificateUser);
    }

    /**
    * Updates the l f certificate user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateUser the l f certificate user
    * @param merge whether to merge the l f certificate user with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f certificate user that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser updateLFCertificateUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateUser lfCertificateUser,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.updateLFCertificateUser(lfCertificateUser,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfCertificateUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCertificateUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCertificateUserLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCertificateUser createLFCertificateUser()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.createLFCertificateUser();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.findByCertificateID(certificateID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.findByUserID(userID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateUserLocalService.findByUserIDAndCertificateID(userID,
            certificateID);
    }

    public void removeByUserIDAndCertificateID(java.lang.Integer userID,
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateUserLocalService.removeByUserIDAndCertificateID(userID,
            certificateID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateUserLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFCertificateUserLocalService getWrappedLFCertificateUserLocalService() {
        return _lfCertificateUserLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFCertificateUserLocalService(
        LFCertificateUserLocalService lfCertificateUserLocalService) {
        _lfCertificateUserLocalService = lfCertificateUserLocalService;
    }

    public LFCertificateUserLocalService getWrappedService() {
        return _lfCertificateUserLocalService;
    }

    public void setWrappedService(
        LFCertificateUserLocalService lfCertificateUserLocalService) {
        _lfCertificateUserLocalService = lfCertificateUserLocalService;
    }
}

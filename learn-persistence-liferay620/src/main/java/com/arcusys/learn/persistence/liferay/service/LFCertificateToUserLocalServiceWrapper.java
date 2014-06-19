package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFCertificateToUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUserLocalService
 * @generated
 */
public class LFCertificateToUserLocalServiceWrapper
    implements LFCertificateToUserLocalService,
        ServiceWrapper<LFCertificateToUserLocalService> {
    private LFCertificateToUserLocalService _lfCertificateToUserLocalService;

    public LFCertificateToUserLocalServiceWrapper(
        LFCertificateToUserLocalService lfCertificateToUserLocalService) {
        _lfCertificateToUserLocalService = lfCertificateToUserLocalService;
    }

    /**
    * Adds the l f certificate to user to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUser the l f certificate to user
    * @return the l f certificate to user that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser addLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.addLFCertificateToUser(lfCertificateToUser);
    }

    /**
    * Creates a new l f certificate to user with the primary key. Does not add the l f certificate to user to the database.
    *
    * @param lfCertificateToUserPK the primary key for the new l f certificate to user
    * @return the new l f certificate to user
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser createLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK) {
        return _lfCertificateToUserLocalService.createLFCertificateToUser(lfCertificateToUserPK);
    }

    /**
    * Deletes the l f certificate to user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user that was removed
    * @throws PortalException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser deleteLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.deleteLFCertificateToUser(lfCertificateToUserPK);
    }

    /**
    * Deletes the l f certificate to user from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUser the l f certificate to user
    * @return the l f certificate to user that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser deleteLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.deleteLFCertificateToUser(lfCertificateToUser);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCertificateToUserLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.fetchLFCertificateToUser(lfCertificateToUserPK);
    }

    /**
    * Returns the l f certificate to user with the primary key.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user
    * @throws PortalException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser getLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.getLFCertificateToUser(lfCertificateToUserPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificate to users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate to users
    * @param end the upper bound of the range of l f certificate to users (not inclusive)
    * @return the range of l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> getLFCertificateToUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.getLFCertificateToUsers(start,
            end);
    }

    /**
    * Returns the number of l f certificate to users.
    *
    * @return the number of l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFCertificateToUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.getLFCertificateToUsersCount();
    }

    /**
    * Updates the l f certificate to user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUser the l f certificate to user
    * @return the l f certificate to user that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser updateLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.updateLFCertificateToUser(lfCertificateToUser);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfCertificateToUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCertificateToUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCertificateToUserLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateToUser createLFCertificateUser(
        java.lang.Integer userId, java.lang.Integer certificateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.createLFCertificateUser(userId,
            certificateId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.findByCertificateID(certificateID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.findByUserID(userID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateToUserLocalService.findByUserIDAndCertificateID(userID,
            certificateID);
    }

    @Override
    public void removeByUserIDAndCertificateID(java.lang.Integer userID,
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateToUserLocalService.removeByUserIDAndCertificateID(userID,
            certificateID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateToUserLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFCertificateToUserLocalService getWrappedLFCertificateToUserLocalService() {
        return _lfCertificateToUserLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFCertificateToUserLocalService(
        LFCertificateToUserLocalService lfCertificateToUserLocalService) {
        _lfCertificateToUserLocalService = lfCertificateToUserLocalService;
    }

    @Override
    public LFCertificateToUserLocalService getWrappedService() {
        return _lfCertificateToUserLocalService;
    }

    @Override
    public void setWrappedService(
        LFCertificateToUserLocalService lfCertificateToUserLocalService) {
        _lfCertificateToUserLocalService = lfCertificateToUserLocalService;
    }
}

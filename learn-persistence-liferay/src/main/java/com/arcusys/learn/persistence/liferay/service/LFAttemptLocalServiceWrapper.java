package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFAttemptLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFAttemptLocalService
 * @generated
 */
public class LFAttemptLocalServiceWrapper implements LFAttemptLocalService,
    ServiceWrapper<LFAttemptLocalService> {
    private LFAttemptLocalService _lfAttemptLocalService;

    public LFAttemptLocalServiceWrapper(
        LFAttemptLocalService lfAttemptLocalService) {
        _lfAttemptLocalService = lfAttemptLocalService;
    }

    /**
    * Adds the l f attempt to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAttempt the l f attempt
    * @return the l f attempt that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt addLFAttempt(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.addLFAttempt(lfAttempt);
    }

    /**
    * Creates a new l f attempt with the primary key. Does not add the l f attempt to the database.
    *
    * @param id the primary key for the new l f attempt
    * @return the new l f attempt
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt createLFAttempt(
        long id) {
        return _lfAttemptLocalService.createLFAttempt(id);
    }

    /**
    * Deletes the l f attempt with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt that was removed
    * @throws PortalException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt deleteLFAttempt(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.deleteLFAttempt(id);
    }

    /**
    * Deletes the l f attempt from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAttempt the l f attempt
    * @return the l f attempt that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt deleteLFAttempt(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.deleteLFAttempt(lfAttempt);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfAttemptLocalService.dynamicQuery();
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
        return _lfAttemptLocalService.dynamicQuery(dynamicQuery);
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
        return _lfAttemptLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfAttemptLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _lfAttemptLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFAttempt fetchLFAttempt(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.fetchLFAttempt(id);
    }

    /**
    * Returns the l f attempt with the primary key.
    *
    * @param id the primary key of the l f attempt
    * @return the l f attempt
    * @throws PortalException if a l f attempt with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt getLFAttempt(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.getLFAttempt(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f attempts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f attempts
    * @param end the upper bound of the range of l f attempts (not inclusive)
    * @return the range of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> getLFAttempts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.getLFAttempts(start, end);
    }

    /**
    * Returns the number of l f attempts.
    *
    * @return the number of l f attempts
    * @throws SystemException if a system exception occurred
    */
    public int getLFAttemptsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.getLFAttemptsCount();
    }

    /**
    * Updates the l f attempt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAttempt the l f attempt
    * @return the l f attempt that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt updateLFAttempt(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.updateLFAttempt(lfAttempt);
    }

    /**
    * Updates the l f attempt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAttempt the l f attempt
    * @param merge whether to merge the l f attempt with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f attempt that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttempt updateLFAttempt(
        com.arcusys.learn.persistence.liferay.model.LFAttempt lfAttempt,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.updateLFAttempt(lfAttempt, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfAttemptLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfAttemptLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfAttemptLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFAttempt createLFAttempt()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.createLFAttempt();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserIDPackageIDIsComplete(
        java.lang.Integer userID, java.lang.Integer packageID,
        java.lang.Boolean isComplete)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.findByUserIDPackageIDIsComplete(userID,
            packageID, isComplete);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.findByPackageID(packageID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttempt> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptLocalService.findByUserID(userID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAttemptLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFAttemptLocalService getWrappedLFAttemptLocalService() {
        return _lfAttemptLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFAttemptLocalService(
        LFAttemptLocalService lfAttemptLocalService) {
        _lfAttemptLocalService = lfAttemptLocalService;
    }

    public LFAttemptLocalService getWrappedService() {
        return _lfAttemptLocalService;
    }

    public void setWrappedService(LFAttemptLocalService lfAttemptLocalService) {
        _lfAttemptLocalService = lfAttemptLocalService;
    }
}

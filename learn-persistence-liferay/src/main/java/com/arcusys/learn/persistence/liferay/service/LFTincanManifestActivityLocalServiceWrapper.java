package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanManifestActivityLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanManifestActivityLocalService
 * @generated
 */
public class LFTincanManifestActivityLocalServiceWrapper
    implements LFTincanManifestActivityLocalService,
        ServiceWrapper<LFTincanManifestActivityLocalService> {
    private LFTincanManifestActivityLocalService _lfTincanManifestActivityLocalService;

    public LFTincanManifestActivityLocalServiceWrapper(
        LFTincanManifestActivityLocalService lfTincanManifestActivityLocalService) {
        _lfTincanManifestActivityLocalService = lfTincanManifestActivityLocalService;
    }

    /**
    * Adds the l f tincan manifest activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanManifestActivity the l f tincan manifest activity
    * @return the l f tincan manifest activity that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity addLFTincanManifestActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity lfTincanManifestActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.addLFTincanManifestActivity(lfTincanManifestActivity);
    }

    /**
    * Creates a new l f tincan manifest activity with the primary key. Does not add the l f tincan manifest activity to the database.
    *
    * @param id the primary key for the new l f tincan manifest activity
    * @return the new l f tincan manifest activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity createLFTincanManifestActivity(
        long id) {
        return _lfTincanManifestActivityLocalService.createLFTincanManifestActivity(id);
    }

    /**
    * Deletes the l f tincan manifest activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan manifest activity
    * @return the l f tincan manifest activity that was removed
    * @throws PortalException if a l f tincan manifest activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity deleteLFTincanManifestActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.deleteLFTincanManifestActivity(id);
    }

    /**
    * Deletes the l f tincan manifest activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanManifestActivity the l f tincan manifest activity
    * @return the l f tincan manifest activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity deleteLFTincanManifestActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity lfTincanManifestActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.deleteLFTincanManifestActivity(lfTincanManifestActivity);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanManifestActivityLocalService.dynamicQuery();
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
        return _lfTincanManifestActivityLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanManifestActivityLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _lfTincanManifestActivityLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfTincanManifestActivityLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity fetchLFTincanManifestActivity(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.fetchLFTincanManifestActivity(id);
    }

    /**
    * Returns the l f tincan manifest activity with the primary key.
    *
    * @param id the primary key of the l f tincan manifest activity
    * @return the l f tincan manifest activity
    * @throws PortalException if a l f tincan manifest activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity getLFTincanManifestActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.getLFTincanManifestActivity(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan manifest activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan manifest activities
    * @param end the upper bound of the range of l f tincan manifest activities (not inclusive)
    * @return the range of l f tincan manifest activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity> getLFTincanManifestActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.getLFTincanManifestActivities(start,
            end);
    }

    /**
    * Returns the number of l f tincan manifest activities.
    *
    * @return the number of l f tincan manifest activities
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanManifestActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.getLFTincanManifestActivitiesCount();
    }

    /**
    * Updates the l f tincan manifest activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanManifestActivity the l f tincan manifest activity
    * @return the l f tincan manifest activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity updateLFTincanManifestActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity lfTincanManifestActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.updateLFTincanManifestActivity(lfTincanManifestActivity);
    }

    /**
    * Updates the l f tincan manifest activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanManifestActivity the l f tincan manifest activity
    * @param merge whether to merge the l f tincan manifest activity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan manifest activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity updateLFTincanManifestActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity lfTincanManifestActivity,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.updateLFTincanManifestActivity(lfTincanManifestActivity,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanManifestActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanManifestActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanManifestActivityLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanManifestActivityLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity createLFTincanManifestActivity()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.createLFTincanManifestActivity();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity> findByPackageID(
        java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.findByPackageID(packageID);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanManifestActivityLocalService.findByTincanID(tincanID);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanManifestActivityLocalService getWrappedLFTincanManifestActivityLocalService() {
        return _lfTincanManifestActivityLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanManifestActivityLocalService(
        LFTincanManifestActivityLocalService lfTincanManifestActivityLocalService) {
        _lfTincanManifestActivityLocalService = lfTincanManifestActivityLocalService;
    }

    public LFTincanManifestActivityLocalService getWrappedService() {
        return _lfTincanManifestActivityLocalService;
    }

    public void setWrappedService(
        LFTincanManifestActivityLocalService lfTincanManifestActivityLocalService) {
        _lfTincanManifestActivityLocalService = lfTincanManifestActivityLocalService;
    }
}

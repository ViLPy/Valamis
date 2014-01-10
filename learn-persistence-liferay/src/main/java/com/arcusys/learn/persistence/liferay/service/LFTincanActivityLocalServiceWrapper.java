package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanActivityLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanActivityLocalService
 * @generated
 */
public class LFTincanActivityLocalServiceWrapper
    implements LFTincanActivityLocalService,
        ServiceWrapper<LFTincanActivityLocalService> {
    private LFTincanActivityLocalService _lfTincanActivityLocalService;

    public LFTincanActivityLocalServiceWrapper(
        LFTincanActivityLocalService lfTincanActivityLocalService) {
        _lfTincanActivityLocalService = lfTincanActivityLocalService;
    }

    /**
    * Adds the l f tincan activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActivity the l f tincan activity
    * @return the l f tincan activity that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity addLFTincanActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.addLFTincanActivity(lfTincanActivity);
    }

    /**
    * Creates a new l f tincan activity with the primary key. Does not add the l f tincan activity to the database.
    *
    * @param id the primary key for the new l f tincan activity
    * @return the new l f tincan activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity createLFTincanActivity(
        long id) {
        return _lfTincanActivityLocalService.createLFTincanActivity(id);
    }

    /**
    * Deletes the l f tincan activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan activity
    * @return the l f tincan activity that was removed
    * @throws PortalException if a l f tincan activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity deleteLFTincanActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.deleteLFTincanActivity(id);
    }

    /**
    * Deletes the l f tincan activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActivity the l f tincan activity
    * @return the l f tincan activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity deleteLFTincanActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.deleteLFTincanActivity(lfTincanActivity);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanActivityLocalService.dynamicQuery();
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
        return _lfTincanActivityLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanActivityLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfTincanActivityLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfTincanActivityLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity fetchLFTincanActivity(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.fetchLFTincanActivity(id);
    }

    /**
    * Returns the l f tincan activity with the primary key.
    *
    * @param id the primary key of the l f tincan activity
    * @return the l f tincan activity
    * @throws PortalException if a l f tincan activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity getLFTincanActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.getLFTincanActivity(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan activities
    * @param end the upper bound of the range of l f tincan activities (not inclusive)
    * @return the range of l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> getLFTincanActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.getLFTincanActivities(start, end);
    }

    /**
    * Returns the number of l f tincan activities.
    *
    * @return the number of l f tincan activities
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.getLFTincanActivitiesCount();
    }

    /**
    * Updates the l f tincan activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActivity the l f tincan activity
    * @return the l f tincan activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity updateLFTincanActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.updateLFTincanActivity(lfTincanActivity);
    }

    /**
    * Updates the l f tincan activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanActivity the l f tincan activity
    * @param merge whether to merge the l f tincan activity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity updateLFTincanActivity(
        com.arcusys.learn.persistence.liferay.model.LFTincanActivity lfTincanActivity,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.updateLFTincanActivity(lfTincanActivity,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanActivityLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanActivityLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity createLFTincanActivity()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.createLFTincanActivity();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanActivity> findByPackageID(
        java.lang.Long packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.findByPackageID(packageID);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanActivity findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanActivityException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanActivityLocalService.findByTincanID(tincanID);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanActivityLocalService getWrappedLFTincanActivityLocalService() {
        return _lfTincanActivityLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanActivityLocalService(
        LFTincanActivityLocalService lfTincanActivityLocalService) {
        _lfTincanActivityLocalService = lfTincanActivityLocalService;
    }

    public LFTincanActivityLocalService getWrappedService() {
        return _lfTincanActivityLocalService;
    }

    public void setWrappedService(
        LFTincanActivityLocalService lfTincanActivityLocalService) {
        _lfTincanActivityLocalService = lfTincanActivityLocalService;
    }
}

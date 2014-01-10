package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsContextActivitiesLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanLrsContextActivitiesLocalService
 * @generated
 */
public class LFTincanLrsContextActivitiesLocalServiceWrapper
    implements LFTincanLrsContextActivitiesLocalService,
        ServiceWrapper<LFTincanLrsContextActivitiesLocalService> {
    private LFTincanLrsContextActivitiesLocalService _lfTincanLrsContextActivitiesLocalService;

    public LFTincanLrsContextActivitiesLocalServiceWrapper(
        LFTincanLrsContextActivitiesLocalService lfTincanLrsContextActivitiesLocalService) {
        _lfTincanLrsContextActivitiesLocalService = lfTincanLrsContextActivitiesLocalService;
    }

    /**
    * Adds the l f tincan lrs context activities to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsContextActivities the l f tincan lrs context activities
    * @return the l f tincan lrs context activities that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities addLFTincanLrsContextActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.addLFTincanLrsContextActivities(lfTincanLrsContextActivities);
    }

    /**
    * Creates a new l f tincan lrs context activities with the primary key. Does not add the l f tincan lrs context activities to the database.
    *
    * @param id the primary key for the new l f tincan lrs context activities
    * @return the new l f tincan lrs context activities
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities createLFTincanLrsContextActivities(
        long id) {
        return _lfTincanLrsContextActivitiesLocalService.createLFTincanLrsContextActivities(id);
    }

    /**
    * Deletes the l f tincan lrs context activities with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs context activities
    * @return the l f tincan lrs context activities that was removed
    * @throws PortalException if a l f tincan lrs context activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities deleteLFTincanLrsContextActivities(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.deleteLFTincanLrsContextActivities(id);
    }

    /**
    * Deletes the l f tincan lrs context activities from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsContextActivities the l f tincan lrs context activities
    * @return the l f tincan lrs context activities that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities deleteLFTincanLrsContextActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.deleteLFTincanLrsContextActivities(lfTincanLrsContextActivities);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsContextActivitiesLocalService.dynamicQuery();
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
        return _lfTincanLrsContextActivitiesLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanLrsContextActivitiesLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsContextActivitiesLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsContextActivitiesLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities fetchLFTincanLrsContextActivities(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.fetchLFTincanLrsContextActivities(id);
    }

    /**
    * Returns the l f tincan lrs context activities with the primary key.
    *
    * @param id the primary key of the l f tincan lrs context activities
    * @return the l f tincan lrs context activities
    * @throws PortalException if a l f tincan lrs context activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities getLFTincanLrsContextActivities(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.getLFTincanLrsContextActivities(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs context activitieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs context activitieses
    * @param end the upper bound of the range of l f tincan lrs context activitieses (not inclusive)
    * @return the range of l f tincan lrs context activitieses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities> getLFTincanLrsContextActivitieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.getLFTincanLrsContextActivitieses(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs context activitieses.
    *
    * @return the number of l f tincan lrs context activitieses
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanLrsContextActivitiesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.getLFTincanLrsContextActivitiesesCount();
    }

    /**
    * Updates the l f tincan lrs context activities in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsContextActivities the l f tincan lrs context activities
    * @return the l f tincan lrs context activities that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities updateLFTincanLrsContextActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.updateLFTincanLrsContextActivities(lfTincanLrsContextActivities);
    }

    /**
    * Updates the l f tincan lrs context activities in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsContextActivities the l f tincan lrs context activities
    * @param merge whether to merge the l f tincan lrs context activities with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan lrs context activities that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities updateLFTincanLrsContextActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities lfTincanLrsContextActivities,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.updateLFTincanLrsContextActivities(lfTincanLrsContextActivities,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsContextActivitiesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsContextActivitiesLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsContextActivitiesLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsContextActivitiesLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities createLFTincanLrsContextActivities()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsContextActivitiesLocalService.createLFTincanLrsContextActivities();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanLrsContextActivitiesLocalService getWrappedLFTincanLrsContextActivitiesLocalService() {
        return _lfTincanLrsContextActivitiesLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsContextActivitiesLocalService(
        LFTincanLrsContextActivitiesLocalService lfTincanLrsContextActivitiesLocalService) {
        _lfTincanLrsContextActivitiesLocalService = lfTincanLrsContextActivitiesLocalService;
    }

    public LFTincanLrsContextActivitiesLocalService getWrappedService() {
        return _lfTincanLrsContextActivitiesLocalService;
    }

    public void setWrappedService(
        LFTincanLrsContextActivitiesLocalService lfTincanLrsContextActivitiesLocalService) {
        _lfTincanLrsContextActivitiesLocalService = lfTincanLrsContextActivitiesLocalService;
    }
}

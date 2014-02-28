package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanCtxActivitiesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanCtxActivitiesLocalService
 * @generated
 */
public class LFTincanCtxActivitiesLocalServiceWrapper
    implements LFTincanCtxActivitiesLocalService,
        ServiceWrapper<LFTincanCtxActivitiesLocalService> {
    private LFTincanCtxActivitiesLocalService _lfTincanCtxActivitiesLocalService;

    public LFTincanCtxActivitiesLocalServiceWrapper(
        LFTincanCtxActivitiesLocalService lfTincanCtxActivitiesLocalService) {
        _lfTincanCtxActivitiesLocalService = lfTincanCtxActivitiesLocalService;
    }

    /**
    * Adds the l f tincan ctx activities to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanCtxActivities the l f tincan ctx activities
    * @return the l f tincan ctx activities that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities addLFTincanCtxActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities lfTincanCtxActivities)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.addLFTincanCtxActivities(lfTincanCtxActivities);
    }

    /**
    * Creates a new l f tincan ctx activities with the primary key. Does not add the l f tincan ctx activities to the database.
    *
    * @param id the primary key for the new l f tincan ctx activities
    * @return the new l f tincan ctx activities
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities createLFTincanCtxActivities(
        long id) {
        return _lfTincanCtxActivitiesLocalService.createLFTincanCtxActivities(id);
    }

    /**
    * Deletes the l f tincan ctx activities with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan ctx activities
    * @return the l f tincan ctx activities that was removed
    * @throws PortalException if a l f tincan ctx activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities deleteLFTincanCtxActivities(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.deleteLFTincanCtxActivities(id);
    }

    /**
    * Deletes the l f tincan ctx activities from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanCtxActivities the l f tincan ctx activities
    * @return the l f tincan ctx activities that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities deleteLFTincanCtxActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities lfTincanCtxActivities)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.deleteLFTincanCtxActivities(lfTincanCtxActivities);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanCtxActivitiesLocalService.dynamicQuery();
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
        return _lfTincanCtxActivitiesLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanCtxActivitiesLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanCtxActivitiesLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanCtxActivitiesLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanCtxActivitiesLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities fetchLFTincanCtxActivities(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.fetchLFTincanCtxActivities(id);
    }

    /**
    * Returns the l f tincan ctx activities with the primary key.
    *
    * @param id the primary key of the l f tincan ctx activities
    * @return the l f tincan ctx activities
    * @throws PortalException if a l f tincan ctx activities with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities getLFTincanCtxActivities(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.getLFTincanCtxActivities(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan ctx activitieses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanCtxActivitiesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan ctx activitieses
    * @param end the upper bound of the range of l f tincan ctx activitieses (not inclusive)
    * @return the range of l f tincan ctx activitieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities> getLFTincanCtxActivitieses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.getLFTincanCtxActivitieses(start,
            end);
    }

    /**
    * Returns the number of l f tincan ctx activitieses.
    *
    * @return the number of l f tincan ctx activitieses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanCtxActivitiesesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.getLFTincanCtxActivitiesesCount();
    }

    /**
    * Updates the l f tincan ctx activities in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanCtxActivities the l f tincan ctx activities
    * @return the l f tincan ctx activities that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities updateLFTincanCtxActivities(
        com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities lfTincanCtxActivities)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.updateLFTincanCtxActivities(lfTincanCtxActivities);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanCtxActivitiesLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanCtxActivitiesLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanCtxActivitiesLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanCtxActivitiesLocalService.removeAll();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities createLFTincanLrsContextActivities()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanCtxActivitiesLocalService.createLFTincanLrsContextActivities();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanCtxActivitiesLocalService getWrappedLFTincanCtxActivitiesLocalService() {
        return _lfTincanCtxActivitiesLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanCtxActivitiesLocalService(
        LFTincanCtxActivitiesLocalService lfTincanCtxActivitiesLocalService) {
        _lfTincanCtxActivitiesLocalService = lfTincanCtxActivitiesLocalService;
    }

    @Override
    public LFTincanCtxActivitiesLocalService getWrappedService() {
        return _lfTincanCtxActivitiesLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanCtxActivitiesLocalService lfTincanCtxActivitiesLocalService) {
        _lfTincanCtxActivitiesLocalService = lfTincanCtxActivitiesLocalService;
    }
}

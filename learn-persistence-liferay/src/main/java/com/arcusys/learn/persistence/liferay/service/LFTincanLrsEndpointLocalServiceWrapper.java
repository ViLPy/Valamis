package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanLrsEndpointLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsEndpointLocalService
 * @generated
 */
public class LFTincanLrsEndpointLocalServiceWrapper
    implements LFTincanLrsEndpointLocalService,
        ServiceWrapper<LFTincanLrsEndpointLocalService> {
    private LFTincanLrsEndpointLocalService _lfTincanLrsEndpointLocalService;

    public LFTincanLrsEndpointLocalServiceWrapper(
        LFTincanLrsEndpointLocalService lfTincanLrsEndpointLocalService) {
        _lfTincanLrsEndpointLocalService = lfTincanLrsEndpointLocalService;
    }

    /**
    * Adds the l f tincan lrs endpoint to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint addLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.addLFTincanLrsEndpoint(lfTincanLrsEndpoint);
    }

    /**
    * Creates a new l f tincan lrs endpoint with the primary key. Does not add the l f tincan lrs endpoint to the database.
    *
    * @param id the primary key for the new l f tincan lrs endpoint
    * @return the new l f tincan lrs endpoint
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint createLFTincanLrsEndpoint(
        long id) {
        return _lfTincanLrsEndpointLocalService.createLFTincanLrsEndpoint(id);
    }

    /**
    * Deletes the l f tincan lrs endpoint with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was removed
    * @throws PortalException if a l f tincan lrs endpoint with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint deleteLFTincanLrsEndpoint(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.deleteLFTincanLrsEndpoint(id);
    }

    /**
    * Deletes the l f tincan lrs endpoint from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint deleteLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.deleteLFTincanLrsEndpoint(lfTincanLrsEndpoint);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsEndpointLocalService.dynamicQuery();
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
        return _lfTincanLrsEndpointLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsEndpointLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsEndpointLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsEndpointLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanLrsEndpointLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint fetchLFTincanLrsEndpoint(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.fetchLFTincanLrsEndpoint(id);
    }

    /**
    * Returns the l f tincan lrs endpoint with the primary key.
    *
    * @param id the primary key of the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint
    * @throws PortalException if a l f tincan lrs endpoint with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint getLFTincanLrsEndpoint(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.getLFTincanLrsEndpoint(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs endpoints.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs endpoints
    * @param end the upper bound of the range of l f tincan lrs endpoints (not inclusive)
    * @return the range of l f tincan lrs endpoints
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint> getLFTincanLrsEndpoints(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.getLFTincanLrsEndpoints(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs endpoints.
    *
    * @return the number of l f tincan lrs endpoints
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanLrsEndpointsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.getLFTincanLrsEndpointsCount();
    }

    /**
    * Updates the l f tincan lrs endpoint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint updateLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.updateLFTincanLrsEndpoint(lfTincanLrsEndpoint);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsEndpointLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsEndpointLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsEndpointLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsEndpointLocalService.removeAll();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint getEndpoint()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsEndpointLocalService.getEndpoint();
    }

    @Override
    public void setEndpoint(java.lang.String endpoint,
        java.lang.String authType, java.lang.String key, java.lang.String secret)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsEndpointLocalService.setEndpoint(endpoint, authType, key,
            secret);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanLrsEndpointLocalService getWrappedLFTincanLrsEndpointLocalService() {
        return _lfTincanLrsEndpointLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsEndpointLocalService(
        LFTincanLrsEndpointLocalService lfTincanLrsEndpointLocalService) {
        _lfTincanLrsEndpointLocalService = lfTincanLrsEndpointLocalService;
    }

    @Override
    public LFTincanLrsEndpointLocalService getWrappedService() {
        return _lfTincanLrsEndpointLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanLrsEndpointLocalService lfTincanLrsEndpointLocalService) {
        _lfTincanLrsEndpointLocalService = lfTincanLrsEndpointLocalService;
    }
}

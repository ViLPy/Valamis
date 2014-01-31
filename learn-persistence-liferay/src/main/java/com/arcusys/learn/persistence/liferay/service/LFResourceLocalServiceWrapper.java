package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFResourceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFResourceLocalService
 * @generated
 */
public class LFResourceLocalServiceWrapper implements LFResourceLocalService,
    ServiceWrapper<LFResourceLocalService> {
    private LFResourceLocalService _lfResourceLocalService;

    public LFResourceLocalServiceWrapper(
        LFResourceLocalService lfResourceLocalService) {
        _lfResourceLocalService = lfResourceLocalService;
    }

    /**
    * Adds the l f resource to the database. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @return the l f resource that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource addLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.addLFResource(lfResource);
    }

    /**
    * Creates a new l f resource with the primary key. Does not add the l f resource to the database.
    *
    * @param id the primary key for the new l f resource
    * @return the new l f resource
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource createLFResource(
        long id) {
        return _lfResourceLocalService.createLFResource(id);
    }

    /**
    * Deletes the l f resource with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource that was removed
    * @throws PortalException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource deleteLFResource(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.deleteLFResource(id);
    }

    /**
    * Deletes the l f resource from the database. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @return the l f resource that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource deleteLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.deleteLFResource(lfResource);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfResourceLocalService.dynamicQuery();
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
        return _lfResourceLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfResourceLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfResourceLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _lfResourceLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfResourceLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource fetchLFResource(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.fetchLFResource(id);
    }

    /**
    * Returns the l f resource with the primary key.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource
    * @throws PortalException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource getLFResource(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.getLFResource(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f resources.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFResourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of l f resources
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> getLFResources(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.getLFResources(start, end);
    }

    /**
    * Returns the number of l f resources.
    *
    * @return the number of l f resources
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFResourcesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.getLFResourcesCount();
    }

    /**
    * Updates the l f resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @return the l f resource that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource updateLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.updateLFResource(lfResource);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfResourceLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfResourceLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfResourceLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFResource createLFResource()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.createLFResource();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.findByPackageID(packageID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfResourceLocalService.findByPackageIDAndResourceID(packageID,
            resourceID, start, end);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfResourceLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFResourceLocalService getWrappedLFResourceLocalService() {
        return _lfResourceLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFResourceLocalService(
        LFResourceLocalService lfResourceLocalService) {
        _lfResourceLocalService = lfResourceLocalService;
    }

    @Override
    public LFResourceLocalService getWrappedService() {
        return _lfResourceLocalService;
    }

    @Override
    public void setWrappedService(LFResourceLocalService lfResourceLocalService) {
        _lfResourceLocalService = lfResourceLocalService;
    }
}

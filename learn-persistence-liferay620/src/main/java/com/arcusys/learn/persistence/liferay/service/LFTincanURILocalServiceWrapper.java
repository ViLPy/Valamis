package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanURILocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURILocalService
 * @generated
 */
public class LFTincanURILocalServiceWrapper implements LFTincanURILocalService,
    ServiceWrapper<LFTincanURILocalService> {
    private LFTincanURILocalService _lfTincanURILocalService;

    public LFTincanURILocalServiceWrapper(
        LFTincanURILocalService lfTincanURILocalService) {
        _lfTincanURILocalService = lfTincanURILocalService;
    }

    /**
    * Adds the l f tincan u r i to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanURI the l f tincan u r i
    * @return the l f tincan u r i that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI addLFTincanURI(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.addLFTincanURI(lfTincanURI);
    }

    /**
    * Creates a new l f tincan u r i with the primary key. Does not add the l f tincan u r i to the database.
    *
    * @param uri the primary key for the new l f tincan u r i
    * @return the new l f tincan u r i
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI createLFTincanURI(
        java.lang.String uri) {
        return _lfTincanURILocalService.createLFTincanURI(uri);
    }

    /**
    * Deletes the l f tincan u r i with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i that was removed
    * @throws PortalException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI deleteLFTincanURI(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.deleteLFTincanURI(uri);
    }

    /**
    * Deletes the l f tincan u r i from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanURI the l f tincan u r i
    * @return the l f tincan u r i that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI deleteLFTincanURI(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.deleteLFTincanURI(lfTincanURI);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanURILocalService.dynamicQuery();
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
        return _lfTincanURILocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanURILocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanURILocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _lfTincanURILocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanURILocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchLFTincanURI(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.fetchLFTincanURI(uri);
    }

    /**
    * Returns the l f tincan u r i with the primary key.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i
    * @throws PortalException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI getLFTincanURI(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.getLFTincanURI(uri);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan u r is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan u r is
    * @param end the upper bound of the range of l f tincan u r is (not inclusive)
    * @return the range of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> getLFTincanURIs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.getLFTincanURIs(start, end);
    }

    /**
    * Returns the number of l f tincan u r is.
    *
    * @return the number of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanURIsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.getLFTincanURIsCount();
    }

    /**
    * Updates the l f tincan u r i in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanURI the l f tincan u r i
    * @return the l f tincan u r i that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI updateLFTincanURI(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.updateLFTincanURI(lfTincanURI);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanURILocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanURILocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanURILocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanURILocalService.removeAll();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI findURI(
        java.lang.String objId, java.lang.String objType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanURILocalService.findURI(objId, objType);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanURILocalService getWrappedLFTincanURILocalService() {
        return _lfTincanURILocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanURILocalService(
        LFTincanURILocalService lfTincanURILocalService) {
        _lfTincanURILocalService = lfTincanURILocalService;
    }

    @Override
    public LFTincanURILocalService getWrappedService() {
        return _lfTincanURILocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanURILocalService lfTincanURILocalService) {
        _lfTincanURILocalService = lfTincanURILocalService;
    }
}

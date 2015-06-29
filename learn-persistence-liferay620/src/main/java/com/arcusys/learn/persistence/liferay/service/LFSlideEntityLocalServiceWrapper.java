package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFSlideEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideEntityLocalService
 * @generated
 */
public class LFSlideEntityLocalServiceWrapper
    implements LFSlideEntityLocalService,
        ServiceWrapper<LFSlideEntityLocalService> {
    private LFSlideEntityLocalService _lfSlideEntityLocalService;

    public LFSlideEntityLocalServiceWrapper(
        LFSlideEntityLocalService lfSlideEntityLocalService) {
        _lfSlideEntityLocalService = lfSlideEntityLocalService;
    }

    /**
    * Adds the l f slide entity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSlideEntity the l f slide entity
    * @return the l f slide entity that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity addLFSlideEntity(
        com.arcusys.learn.persistence.liferay.model.LFSlideEntity lfSlideEntity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.addLFSlideEntity(lfSlideEntity);
    }

    /**
    * Creates a new l f slide entity with the primary key. Does not add the l f slide entity to the database.
    *
    * @param id the primary key for the new l f slide entity
    * @return the new l f slide entity
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity createLFSlideEntity(
        long id) {
        return _lfSlideEntityLocalService.createLFSlideEntity(id);
    }

    /**
    * Deletes the l f slide entity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f slide entity
    * @return the l f slide entity that was removed
    * @throws PortalException if a l f slide entity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity deleteLFSlideEntity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.deleteLFSlideEntity(id);
    }

    /**
    * Deletes the l f slide entity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSlideEntity the l f slide entity
    * @return the l f slide entity that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity deleteLFSlideEntity(
        com.arcusys.learn.persistence.liferay.model.LFSlideEntity lfSlideEntity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.deleteLFSlideEntity(lfSlideEntity);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSlideEntityLocalService.dynamicQuery();
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
        return _lfSlideEntityLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSlideEntityLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSlideEntityLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _lfSlideEntityLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfSlideEntityLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity fetchLFSlideEntity(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.fetchLFSlideEntity(id);
    }

    /**
    * Returns the l f slide entity with the primary key.
    *
    * @param id the primary key of the l f slide entity
    * @return the l f slide entity
    * @throws PortalException if a l f slide entity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity getLFSlideEntity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.getLFSlideEntity(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f slide entities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideEntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f slide entities
    * @param end the upper bound of the range of l f slide entities (not inclusive)
    * @return the range of l f slide entities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideEntity> getLFSlideEntities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.getLFSlideEntities(start, end);
    }

    /**
    * Returns the number of l f slide entities.
    *
    * @return the number of l f slide entities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFSlideEntitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.getLFSlideEntitiesCount();
    }

    /**
    * Updates the l f slide entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSlideEntity the l f slide entity
    * @return the l f slide entity that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity updateLFSlideEntity(
        com.arcusys.learn.persistence.liferay.model.LFSlideEntity lfSlideEntity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.updateLFSlideEntity(lfSlideEntity);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfSlideEntityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSlideEntityLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSlideEntityLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSlideEntity createLFSlideEntity()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSlideEntityLocalService.createLFSlideEntity();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFSlideEntityLocalService getWrappedLFSlideEntityLocalService() {
        return _lfSlideEntityLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFSlideEntityLocalService(
        LFSlideEntityLocalService lfSlideEntityLocalService) {
        _lfSlideEntityLocalService = lfSlideEntityLocalService;
    }

    @Override
    public LFSlideEntityLocalService getWrappedService() {
        return _lfSlideEntityLocalService;
    }

    @Override
    public void setWrappedService(
        LFSlideEntityLocalService lfSlideEntityLocalService) {
        _lfSlideEntityLocalService = lfSlideEntityLocalService;
    }
}

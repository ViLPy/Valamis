package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanPackageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanPackageLocalService
 * @generated
 */
public class LFTincanPackageLocalServiceWrapper
    implements LFTincanPackageLocalService,
        ServiceWrapper<LFTincanPackageLocalService> {
    private LFTincanPackageLocalService _lfTincanPackageLocalService;

    public LFTincanPackageLocalServiceWrapper(
        LFTincanPackageLocalService lfTincanPackageLocalService) {
        _lfTincanPackageLocalService = lfTincanPackageLocalService;
    }

    /**
    * Adds the l f tincan package to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanPackage the l f tincan package
    * @return the l f tincan package that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage addLFTincanPackage(
        com.arcusys.learn.persistence.liferay.model.LFTincanPackage lfTincanPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.addLFTincanPackage(lfTincanPackage);
    }

    /**
    * Creates a new l f tincan package with the primary key. Does not add the l f tincan package to the database.
    *
    * @param id the primary key for the new l f tincan package
    * @return the new l f tincan package
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage createLFTincanPackage(
        long id) {
        return _lfTincanPackageLocalService.createLFTincanPackage(id);
    }

    /**
    * Deletes the l f tincan package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan package
    * @return the l f tincan package that was removed
    * @throws PortalException if a l f tincan package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage deleteLFTincanPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.deleteLFTincanPackage(id);
    }

    /**
    * Deletes the l f tincan package from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanPackage the l f tincan package
    * @return the l f tincan package that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage deleteLFTincanPackage(
        com.arcusys.learn.persistence.liferay.model.LFTincanPackage lfTincanPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.deleteLFTincanPackage(lfTincanPackage);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanPackageLocalService.dynamicQuery();
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
        return _lfTincanPackageLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanPackageLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanPackageLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfTincanPackageLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanPackageLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage fetchLFTincanPackage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.fetchLFTincanPackage(id);
    }

    /**
    * Returns the l f tincan package with the primary key.
    *
    * @param id the primary key of the l f tincan package
    * @return the l f tincan package
    * @throws PortalException if a l f tincan package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage getLFTincanPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.getLFTincanPackage(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan packages
    * @param end the upper bound of the range of l f tincan packages (not inclusive)
    * @return the range of l f tincan packages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanPackage> getLFTincanPackages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.getLFTincanPackages(start, end);
    }

    /**
    * Returns the number of l f tincan packages.
    *
    * @return the number of l f tincan packages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanPackagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.getLFTincanPackagesCount();
    }

    /**
    * Updates the l f tincan package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanPackage the l f tincan package
    * @return the l f tincan package that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage updateLFTincanPackage(
        com.arcusys.learn.persistence.liferay.model.LFTincanPackage lfTincanPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.updateLFTincanPackage(lfTincanPackage);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanPackageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanPackageLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanPackageLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage createLFTincanPackage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.createLFTincanPackage();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanPackage findByRefID(
        java.lang.Long refId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.findByRefID(refId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanPackage> findByPackageID(
        java.lang.Long[] ids)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.findByPackageID(ids);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanPackage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.findAll();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanPackage> findByInstance(
        java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.findByInstance(courseIDs);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanPackage> findByCourseID(
        java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanPackageLocalService.findByCourseID(courseID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanPackageLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanPackageLocalService getWrappedLFTincanPackageLocalService() {
        return _lfTincanPackageLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanPackageLocalService(
        LFTincanPackageLocalService lfTincanPackageLocalService) {
        _lfTincanPackageLocalService = lfTincanPackageLocalService;
    }

    @Override
    public LFTincanPackageLocalService getWrappedService() {
        return _lfTincanPackageLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanPackageLocalService lfTincanPackageLocalService) {
        _lfTincanPackageLocalService = lfTincanPackageLocalService;
    }
}

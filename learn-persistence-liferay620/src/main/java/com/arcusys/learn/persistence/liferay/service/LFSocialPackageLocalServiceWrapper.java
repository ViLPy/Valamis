package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFSocialPackageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackageLocalService
 * @generated
 */
public class LFSocialPackageLocalServiceWrapper
    implements LFSocialPackageLocalService,
        ServiceWrapper<LFSocialPackageLocalService> {
    private LFSocialPackageLocalService _lfSocialPackageLocalService;

    public LFSocialPackageLocalServiceWrapper(
        LFSocialPackageLocalService lfSocialPackageLocalService) {
        _lfSocialPackageLocalService = lfSocialPackageLocalService;
    }

    /**
    * Adds the l f social package to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @return the l f social package that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage addLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.addLFSocialPackage(lfSocialPackage);
    }

    /**
    * Creates a new l f social package with the primary key. Does not add the l f social package to the database.
    *
    * @param id the primary key for the new l f social package
    * @return the new l f social package
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage createLFSocialPackage(
        long id) {
        return _lfSocialPackageLocalService.createLFSocialPackage(id);
    }

    /**
    * Deletes the l f social package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package that was removed
    * @throws PortalException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage deleteLFSocialPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.deleteLFSocialPackage(id);
    }

    /**
    * Deletes the l f social package from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @return the l f social package that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage deleteLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.deleteLFSocialPackage(lfSocialPackage);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSocialPackageLocalService.dynamicQuery();
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
        return _lfSocialPackageLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSocialPackageLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSocialPackageLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfSocialPackageLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfSocialPackageLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchLFSocialPackage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.fetchLFSocialPackage(id);
    }

    /**
    * Returns the l f social package with the primary key.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package
    * @throws PortalException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage getLFSocialPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.getLFSocialPackage(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f social packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @return the range of l f social packages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> getLFSocialPackages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.getLFSocialPackages(start, end);
    }

    /**
    * Returns the number of l f social packages.
    *
    * @return the number of l f social packages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFSocialPackagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.getLFSocialPackagesCount();
    }

    /**
    * Updates the l f social package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @return the l f social package that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage updateLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.updateLFSocialPackage(lfSocialPackage);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfSocialPackageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSocialPackageLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSocialPackageLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage createLFSocialPackage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.createLFSocialPackage();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageLocalService.findByAuthorID(authorID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSocialPackageLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFSocialPackageLocalService getWrappedLFSocialPackageLocalService() {
        return _lfSocialPackageLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFSocialPackageLocalService(
        LFSocialPackageLocalService lfSocialPackageLocalService) {
        _lfSocialPackageLocalService = lfSocialPackageLocalService;
    }

    @Override
    public LFSocialPackageLocalService getWrappedService() {
        return _lfSocialPackageLocalService;
    }

    @Override
    public void setWrappedService(
        LFSocialPackageLocalService lfSocialPackageLocalService) {
        _lfSocialPackageLocalService = lfSocialPackageLocalService;
    }
}

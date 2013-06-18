package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFPackageLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFPackageLocalService
 * @generated
 */
public class LFPackageLocalServiceWrapper implements LFPackageLocalService,
    ServiceWrapper<LFPackageLocalService> {
    private LFPackageLocalService _lfPackageLocalService;

    public LFPackageLocalServiceWrapper(
        LFPackageLocalService lfPackageLocalService) {
        _lfPackageLocalService = lfPackageLocalService;
    }

    /**
    * Adds the l f package to the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @return the l f package that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage addLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.addLFPackage(lfPackage);
    }

    /**
    * Creates a new l f package with the primary key. Does not add the l f package to the database.
    *
    * @param id the primary key for the new l f package
    * @return the new l f package
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage createLFPackage(
        long id) {
        return _lfPackageLocalService.createLFPackage(id);
    }

    /**
    * Deletes the l f package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package
    * @return the l f package that was removed
    * @throws PortalException if a l f package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage deleteLFPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.deleteLFPackage(id);
    }

    /**
    * Deletes the l f package from the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @return the l f package that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage deleteLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.deleteLFPackage(lfPackage);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfPackageLocalService.dynamicQuery();
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
        return _lfPackageLocalService.dynamicQuery(dynamicQuery);
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
        return _lfPackageLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfPackageLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _lfPackageLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFPackage fetchLFPackage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.fetchLFPackage(id);
    }

    /**
    * Returns the l f package with the primary key.
    *
    * @param id the primary key of the l f package
    * @return the l f package
    * @throws PortalException if a l f package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage getLFPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.getLFPackage(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f packages
    * @param end the upper bound of the range of l f packages (not inclusive)
    * @return the range of l f packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> getLFPackages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.getLFPackages(start, end);
    }

    /**
    * Returns the number of l f packages.
    *
    * @return the number of l f packages
    * @throws SystemException if a system exception occurred
    */
    public int getLFPackagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.getLFPackagesCount();
    }

    /**
    * Updates the l f package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @return the l f package that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage updateLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.updateLFPackage(lfPackage);
    }

    /**
    * Updates the l f package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @param merge whether to merge the l f package with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f package that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackage updateLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.updateLFPackage(lfPackage, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfPackageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfPackageLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfPackageLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFPackage createLFPackage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.createLFPackage();
    }

    public com.arcusys.learn.persistence.liferay.model.LFPackage findByRefID(
        java.lang.Long refId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.findByRefID(refId);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> findByPackageID(
        java.lang.Long[] ids)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.findByPackageID(ids);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> findByInstance(
        java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.findByInstance(courseIDs);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> findByCourseID(
        java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfPackageLocalService.findByCourseID(courseID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfPackageLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFPackageLocalService getWrappedLFPackageLocalService() {
        return _lfPackageLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFPackageLocalService(
        LFPackageLocalService lfPackageLocalService) {
        _lfPackageLocalService = lfPackageLocalService;
    }

    public LFPackageLocalService getWrappedService() {
        return _lfPackageLocalService;
    }

    public void setWrappedService(LFPackageLocalService lfPackageLocalService) {
        _lfPackageLocalService = lfPackageLocalService;
    }
}

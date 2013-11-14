package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFCertificateLocalService
 * @generated
 */
public class LFCertificateLocalServiceWrapper
    implements LFCertificateLocalService,
        ServiceWrapper<LFCertificateLocalService> {
    private LFCertificateLocalService _lfCertificateLocalService;

    public LFCertificateLocalServiceWrapper(
        LFCertificateLocalService lfCertificateLocalService) {
        _lfCertificateLocalService = lfCertificateLocalService;
    }

    /**
    * Adds the l f certificate to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @return the l f certificate that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate addLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.addLFCertificate(lfCertificate);
    }

    /**
    * Creates a new l f certificate with the primary key. Does not add the l f certificate to the database.
    *
    * @param id the primary key for the new l f certificate
    * @return the new l f certificate
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate createLFCertificate(
        long id) {
        return _lfCertificateLocalService.createLFCertificate(id);
    }

    /**
    * Deletes the l f certificate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate that was removed
    * @throws PortalException if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate deleteLFCertificate(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.deleteLFCertificate(id);
    }

    /**
    * Deletes the l f certificate from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @return the l f certificate that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate deleteLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.deleteLFCertificate(lfCertificate);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCertificateLocalService.dynamicQuery();
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
        return _lfCertificateLocalService.dynamicQuery(dynamicQuery);
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
        return _lfCertificateLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfCertificateLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfCertificateLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCertificate fetchLFCertificate(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.fetchLFCertificate(id);
    }

    /**
    * Returns the l f certificate with the primary key.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate
    * @throws PortalException if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate getLFCertificate(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.getLFCertificate(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificates
    * @param end the upper bound of the range of l f certificates (not inclusive)
    * @return the range of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> getLFCertificates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.getLFCertificates(start, end);
    }

    /**
    * Returns the number of l f certificates.
    *
    * @return the number of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public int getLFCertificatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.getLFCertificatesCount();
    }

    /**
    * Updates the l f certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @return the l f certificate that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate updateLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.updateLFCertificate(lfCertificate);
    }

    /**
    * Updates the l f certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @param merge whether to merge the l f certificate with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f certificate that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificate updateLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.updateLFCertificate(lfCertificate,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfCertificateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCertificateLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCertificateLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCertificate createLFCertificate()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.createLFCertificate();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> findByTitle(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.findByTitle(title);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> findByCompanyID(
        java.lang.Integer companyID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateLocalService.findByCompanyID(companyID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFCertificateLocalService getWrappedLFCertificateLocalService() {
        return _lfCertificateLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFCertificateLocalService(
        LFCertificateLocalService lfCertificateLocalService) {
        _lfCertificateLocalService = lfCertificateLocalService;
    }

    public LFCertificateLocalService getWrappedService() {
        return _lfCertificateLocalService;
    }

    public void setWrappedService(
        LFCertificateLocalService lfCertificateLocalService) {
        _lfCertificateLocalService = lfCertificateLocalService;
    }
}

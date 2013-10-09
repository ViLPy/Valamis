package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateSiteLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFCertificateSiteLocalService
 * @generated
 */
public class LFCertificateSiteLocalServiceWrapper
    implements LFCertificateSiteLocalService,
        ServiceWrapper<LFCertificateSiteLocalService> {
    private LFCertificateSiteLocalService _lfCertificateSiteLocalService;

    public LFCertificateSiteLocalServiceWrapper(
        LFCertificateSiteLocalService lfCertificateSiteLocalService) {
        _lfCertificateSiteLocalService = lfCertificateSiteLocalService;
    }

    /**
    * Adds the l f certificate site to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateSite the l f certificate site
    * @return the l f certificate site that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite addLFCertificateSite(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.addLFCertificateSite(lfCertificateSite);
    }

    /**
    * Creates a new l f certificate site with the primary key. Does not add the l f certificate site to the database.
    *
    * @param id the primary key for the new l f certificate site
    * @return the new l f certificate site
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite createLFCertificateSite(
        long id) {
        return _lfCertificateSiteLocalService.createLFCertificateSite(id);
    }

    /**
    * Deletes the l f certificate site with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site that was removed
    * @throws PortalException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite deleteLFCertificateSite(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.deleteLFCertificateSite(id);
    }

    /**
    * Deletes the l f certificate site from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateSite the l f certificate site
    * @return the l f certificate site that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite deleteLFCertificateSite(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.deleteLFCertificateSite(lfCertificateSite);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCertificateSiteLocalService.dynamicQuery();
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
        return _lfCertificateSiteLocalService.dynamicQuery(dynamicQuery);
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
        return _lfCertificateSiteLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
        return _lfCertificateSiteLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfCertificateSiteLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite fetchLFCertificateSite(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.fetchLFCertificateSite(id);
    }

    /**
    * Returns the l f certificate site with the primary key.
    *
    * @param id the primary key of the l f certificate site
    * @return the l f certificate site
    * @throws PortalException if a l f certificate site with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite getLFCertificateSite(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.getLFCertificateSite(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificate sites.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate sites
    * @param end the upper bound of the range of l f certificate sites (not inclusive)
    * @return the range of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> getLFCertificateSites(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.getLFCertificateSites(start, end);
    }

    /**
    * Returns the number of l f certificate sites.
    *
    * @return the number of l f certificate sites
    * @throws SystemException if a system exception occurred
    */
    public int getLFCertificateSitesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.getLFCertificateSitesCount();
    }

    /**
    * Updates the l f certificate site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateSite the l f certificate site
    * @return the l f certificate site that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite updateLFCertificateSite(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.updateLFCertificateSite(lfCertificateSite);
    }

    /**
    * Updates the l f certificate site in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateSite the l f certificate site
    * @param merge whether to merge the l f certificate site with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f certificate site that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite updateLFCertificateSite(
        com.arcusys.learn.persistence.liferay.model.LFCertificateSite lfCertificateSite,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.updateLFCertificateSite(lfCertificateSite,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfCertificateSiteLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCertificateSiteLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCertificateSiteLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCertificateSite createLFCertificateSite()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.createLFCertificateSite();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.findByCertificateID(certificateID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.findByCertificateIDAndSiteID(certificateID,
            siteID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateSite> findByCertificateIDAndSiteID(
        java.lang.Integer[] certificateID, java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateSiteLocalService.findByCertificateIDAndSiteID(certificateID,
            siteID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateSiteLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFCertificateSiteLocalService getWrappedLFCertificateSiteLocalService() {
        return _lfCertificateSiteLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFCertificateSiteLocalService(
        LFCertificateSiteLocalService lfCertificateSiteLocalService) {
        _lfCertificateSiteLocalService = lfCertificateSiteLocalService;
    }

    public LFCertificateSiteLocalService getWrappedService() {
        return _lfCertificateSiteLocalService;
    }

    public void setWrappedService(
        LFCertificateSiteLocalService lfCertificateSiteLocalService) {
        _lfCertificateSiteLocalService = lfCertificateSiteLocalService;
    }
}

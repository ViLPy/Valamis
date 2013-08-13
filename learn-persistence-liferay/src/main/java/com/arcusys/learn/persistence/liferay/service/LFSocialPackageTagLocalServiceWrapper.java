package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFSocialPackageTagLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFSocialPackageTagLocalService
 * @generated
 */
public class LFSocialPackageTagLocalServiceWrapper
    implements LFSocialPackageTagLocalService,
        ServiceWrapper<LFSocialPackageTagLocalService> {
    private LFSocialPackageTagLocalService _lfSocialPackageTagLocalService;

    public LFSocialPackageTagLocalServiceWrapper(
        LFSocialPackageTagLocalService lfSocialPackageTagLocalService) {
        _lfSocialPackageTagLocalService = lfSocialPackageTagLocalService;
    }

    /**
    * Adds the l f social package tag to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackageTag the l f social package tag
    * @return the l f social package tag that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag addLFSocialPackageTag(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.addLFSocialPackageTag(lfSocialPackageTag);
    }

    /**
    * Creates a new l f social package tag with the primary key. Does not add the l f social package tag to the database.
    *
    * @param id the primary key for the new l f social package tag
    * @return the new l f social package tag
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag createLFSocialPackageTag(
        long id) {
        return _lfSocialPackageTagLocalService.createLFSocialPackageTag(id);
    }

    /**
    * Deletes the l f social package tag with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f social package tag
    * @return the l f social package tag that was removed
    * @throws PortalException if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag deleteLFSocialPackageTag(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.deleteLFSocialPackageTag(id);
    }

    /**
    * Deletes the l f social package tag from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackageTag the l f social package tag
    * @return the l f social package tag that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag deleteLFSocialPackageTag(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.deleteLFSocialPackageTag(lfSocialPackageTag);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSocialPackageTagLocalService.dynamicQuery();
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
        return _lfSocialPackageTagLocalService.dynamicQuery(dynamicQuery);
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
        return _lfSocialPackageTagLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _lfSocialPackageTagLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfSocialPackageTagLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag fetchLFSocialPackageTag(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.fetchLFSocialPackageTag(id);
    }

    /**
    * Returns the l f social package tag with the primary key.
    *
    * @param id the primary key of the l f social package tag
    * @return the l f social package tag
    * @throws PortalException if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag getLFSocialPackageTag(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.getLFSocialPackageTag(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f social package tags.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @return the range of l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> getLFSocialPackageTags(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.getLFSocialPackageTags(start, end);
    }

    /**
    * Returns the number of l f social package tags.
    *
    * @return the number of l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public int getLFSocialPackageTagsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.getLFSocialPackageTagsCount();
    }

    /**
    * Updates the l f social package tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackageTag the l f social package tag
    * @return the l f social package tag that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag updateLFSocialPackageTag(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.updateLFSocialPackageTag(lfSocialPackageTag);
    }

    /**
    * Updates the l f social package tag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackageTag the l f social package tag
    * @param merge whether to merge the l f social package tag with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f social package tag that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag updateLFSocialPackageTag(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.updateLFSocialPackageTag(lfSocialPackageTag,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfSocialPackageTagLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSocialPackageTagLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSocialPackageTagLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag createLFSocialPackageTag()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.createLFSocialPackageTag();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.findByName(name);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findBySocialPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSocialPackageTagLocalService.findBySocialPackageID(packageID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSocialPackageTagLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFSocialPackageTagLocalService getWrappedLFSocialPackageTagLocalService() {
        return _lfSocialPackageTagLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFSocialPackageTagLocalService(
        LFSocialPackageTagLocalService lfSocialPackageTagLocalService) {
        _lfSocialPackageTagLocalService = lfSocialPackageTagLocalService;
    }

    public LFSocialPackageTagLocalService getWrappedService() {
        return _lfSocialPackageTagLocalService;
    }

    public void setWrappedService(
        LFSocialPackageTagLocalService lfSocialPackageTagLocalService) {
        _lfSocialPackageTagLocalService = lfSocialPackageTagLocalService;
    }
}

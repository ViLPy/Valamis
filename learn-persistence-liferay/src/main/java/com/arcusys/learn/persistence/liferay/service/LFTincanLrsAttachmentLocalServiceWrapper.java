package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsAttachmentLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanLrsAttachmentLocalService
 * @generated
 */
public class LFTincanLrsAttachmentLocalServiceWrapper
    implements LFTincanLrsAttachmentLocalService,
        ServiceWrapper<LFTincanLrsAttachmentLocalService> {
    private LFTincanLrsAttachmentLocalService _lfTincanLrsAttachmentLocalService;

    public LFTincanLrsAttachmentLocalServiceWrapper(
        LFTincanLrsAttachmentLocalService lfTincanLrsAttachmentLocalService) {
        _lfTincanLrsAttachmentLocalService = lfTincanLrsAttachmentLocalService;
    }

    /**
    * Adds the l f tincan lrs attachment to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAttachment the l f tincan lrs attachment
    * @return the l f tincan lrs attachment that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment addLFTincanLrsAttachment(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.addLFTincanLrsAttachment(lfTincanLrsAttachment);
    }

    /**
    * Creates a new l f tincan lrs attachment with the primary key. Does not add the l f tincan lrs attachment to the database.
    *
    * @param id the primary key for the new l f tincan lrs attachment
    * @return the new l f tincan lrs attachment
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment createLFTincanLrsAttachment(
        long id) {
        return _lfTincanLrsAttachmentLocalService.createLFTincanLrsAttachment(id);
    }

    /**
    * Deletes the l f tincan lrs attachment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs attachment
    * @return the l f tincan lrs attachment that was removed
    * @throws PortalException if a l f tincan lrs attachment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment deleteLFTincanLrsAttachment(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.deleteLFTincanLrsAttachment(id);
    }

    /**
    * Deletes the l f tincan lrs attachment from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAttachment the l f tincan lrs attachment
    * @return the l f tincan lrs attachment that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment deleteLFTincanLrsAttachment(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.deleteLFTincanLrsAttachment(lfTincanLrsAttachment);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsAttachmentLocalService.dynamicQuery();
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
        return _lfTincanLrsAttachmentLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanLrsAttachmentLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsAttachmentLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsAttachmentLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment fetchLFTincanLrsAttachment(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.fetchLFTincanLrsAttachment(id);
    }

    /**
    * Returns the l f tincan lrs attachment with the primary key.
    *
    * @param id the primary key of the l f tincan lrs attachment
    * @return the l f tincan lrs attachment
    * @throws PortalException if a l f tincan lrs attachment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment getLFTincanLrsAttachment(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.getLFTincanLrsAttachment(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs attachments.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs attachments
    * @param end the upper bound of the range of l f tincan lrs attachments (not inclusive)
    * @return the range of l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> getLFTincanLrsAttachments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.getLFTincanLrsAttachments(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs attachments.
    *
    * @return the number of l f tincan lrs attachments
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanLrsAttachmentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.getLFTincanLrsAttachmentsCount();
    }

    /**
    * Updates the l f tincan lrs attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAttachment the l f tincan lrs attachment
    * @return the l f tincan lrs attachment that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment updateLFTincanLrsAttachment(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.updateLFTincanLrsAttachment(lfTincanLrsAttachment);
    }

    /**
    * Updates the l f tincan lrs attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAttachment the l f tincan lrs attachment
    * @param merge whether to merge the l f tincan lrs attachment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan lrs attachment that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment updateLFTincanLrsAttachment(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment lfTincanLrsAttachment,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.updateLFTincanLrsAttachment(lfTincanLrsAttachment,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsAttachmentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsAttachmentLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsAttachmentLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsAttachmentLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment createLFTincanLrsAttachment()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.createLFTincanLrsAttachment();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment> findByParentID(
        java.lang.Integer parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAttachmentLocalService.findByParentID(parentID);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanLrsAttachmentLocalService getWrappedLFTincanLrsAttachmentLocalService() {
        return _lfTincanLrsAttachmentLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsAttachmentLocalService(
        LFTincanLrsAttachmentLocalService lfTincanLrsAttachmentLocalService) {
        _lfTincanLrsAttachmentLocalService = lfTincanLrsAttachmentLocalService;
    }

    public LFTincanLrsAttachmentLocalService getWrappedService() {
        return _lfTincanLrsAttachmentLocalService;
    }

    public void setWrappedService(
        LFTincanLrsAttachmentLocalService lfTincanLrsAttachmentLocalService) {
        _lfTincanLrsAttachmentLocalService = lfTincanLrsAttachmentLocalService;
    }
}

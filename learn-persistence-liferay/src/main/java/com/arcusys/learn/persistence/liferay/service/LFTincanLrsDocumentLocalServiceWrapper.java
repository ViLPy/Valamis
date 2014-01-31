package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanLrsDocumentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsDocumentLocalService
 * @generated
 */
public class LFTincanLrsDocumentLocalServiceWrapper
    implements LFTincanLrsDocumentLocalService,
        ServiceWrapper<LFTincanLrsDocumentLocalService> {
    private LFTincanLrsDocumentLocalService _lfTincanLrsDocumentLocalService;

    public LFTincanLrsDocumentLocalServiceWrapper(
        LFTincanLrsDocumentLocalService lfTincanLrsDocumentLocalService) {
        _lfTincanLrsDocumentLocalService = lfTincanLrsDocumentLocalService;
    }

    /**
    * Adds the l f tincan lrs document to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsDocument the l f tincan lrs document
    * @return the l f tincan lrs document that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument addLFTincanLrsDocument(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.addLFTincanLrsDocument(lfTincanLrsDocument);
    }

    /**
    * Creates a new l f tincan lrs document with the primary key. Does not add the l f tincan lrs document to the database.
    *
    * @param id the primary key for the new l f tincan lrs document
    * @return the new l f tincan lrs document
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument createLFTincanLrsDocument(
        long id) {
        return _lfTincanLrsDocumentLocalService.createLFTincanLrsDocument(id);
    }

    /**
    * Deletes the l f tincan lrs document with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs document
    * @return the l f tincan lrs document that was removed
    * @throws PortalException if a l f tincan lrs document with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument deleteLFTincanLrsDocument(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.deleteLFTincanLrsDocument(id);
    }

    /**
    * Deletes the l f tincan lrs document from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsDocument the l f tincan lrs document
    * @return the l f tincan lrs document that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument deleteLFTincanLrsDocument(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.deleteLFTincanLrsDocument(lfTincanLrsDocument);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsDocumentLocalService.dynamicQuery();
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
        return _lfTincanLrsDocumentLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsDocumentLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsDocumentLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfTincanLrsDocumentLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanLrsDocumentLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument fetchLFTincanLrsDocument(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.fetchLFTincanLrsDocument(id);
    }

    /**
    * Returns the l f tincan lrs document with the primary key.
    *
    * @param id the primary key of the l f tincan lrs document
    * @return the l f tincan lrs document
    * @throws PortalException if a l f tincan lrs document with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument getLFTincanLrsDocument(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.getLFTincanLrsDocument(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs documents.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsDocumentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs documents
    * @param end the upper bound of the range of l f tincan lrs documents (not inclusive)
    * @return the range of l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument> getLFTincanLrsDocuments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.getLFTincanLrsDocuments(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs documents.
    *
    * @return the number of l f tincan lrs documents
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanLrsDocumentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.getLFTincanLrsDocumentsCount();
    }

    /**
    * Updates the l f tincan lrs document in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsDocument the l f tincan lrs document
    * @return the l f tincan lrs document that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument updateLFTincanLrsDocument(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument lfTincanLrsDocument)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.updateLFTincanLrsDocument(lfTincanLrsDocument);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsDocumentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsDocumentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsDocumentLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument createLFTincanLrsDocument()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.createLFTincanLrsDocument();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument createLFTincanLrsDocument(
        java.lang.String documentId, java.util.Date update,
        java.lang.String contentType, java.lang.String content)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.createLFTincanLrsDocument(documentId,
            update, contentType, content);
    }

    @Override
    public void deleteLFTincanLrsDocument(java.lang.String documentId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException,
            com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsDocumentLocalService.deleteLFTincanLrsDocument(documentId);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument findByDocumentId(
        java.lang.String documentId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsDocumentLocalService.findByDocumentId(documentId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsDocumentLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanLrsDocumentLocalService getWrappedLFTincanLrsDocumentLocalService() {
        return _lfTincanLrsDocumentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsDocumentLocalService(
        LFTincanLrsDocumentLocalService lfTincanLrsDocumentLocalService) {
        _lfTincanLrsDocumentLocalService = lfTincanLrsDocumentLocalService;
    }

    @Override
    public LFTincanLrsDocumentLocalService getWrappedService() {
        return _lfTincanLrsDocumentLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanLrsDocumentLocalService lfTincanLrsDocumentLocalService) {
        _lfTincanLrsDocumentLocalService = lfTincanLrsDocumentLocalService;
    }
}

package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFQuizTreeElementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizTreeElementLocalService
 * @generated
 */
public class LFQuizTreeElementLocalServiceWrapper
    implements LFQuizTreeElementLocalService,
        ServiceWrapper<LFQuizTreeElementLocalService> {
    private LFQuizTreeElementLocalService _lfQuizTreeElementLocalService;

    public LFQuizTreeElementLocalServiceWrapper(
        LFQuizTreeElementLocalService lfQuizTreeElementLocalService) {
        _lfQuizTreeElementLocalService = lfQuizTreeElementLocalService;
    }

    /**
    * Adds the l f quiz tree element to the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizTreeElement the l f quiz tree element
    * @return the l f quiz tree element that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement addLFQuizTreeElement(
        com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement lfQuizTreeElement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.addLFQuizTreeElement(lfQuizTreeElement);
    }

    /**
    * Creates a new l f quiz tree element with the primary key. Does not add the l f quiz tree element to the database.
    *
    * @param id the primary key for the new l f quiz tree element
    * @return the new l f quiz tree element
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement createLFQuizTreeElement(
        long id) {
        return _lfQuizTreeElementLocalService.createLFQuizTreeElement(id);
    }

    /**
    * Deletes the l f quiz tree element with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz tree element
    * @return the l f quiz tree element that was removed
    * @throws PortalException if a l f quiz tree element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement deleteLFQuizTreeElement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.deleteLFQuizTreeElement(id);
    }

    /**
    * Deletes the l f quiz tree element from the database. Also notifies the appropriate model listeners.
    *
    * @param lfQuizTreeElement the l f quiz tree element
    * @return the l f quiz tree element that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement deleteLFQuizTreeElement(
        com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement lfQuizTreeElement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.deleteLFQuizTreeElement(lfQuizTreeElement);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfQuizTreeElementLocalService.dynamicQuery();
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
        return _lfQuizTreeElementLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfQuizTreeElementLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfQuizTreeElementLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfQuizTreeElementLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfQuizTreeElementLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement fetchLFQuizTreeElement(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.fetchLFQuizTreeElement(id);
    }

    /**
    * Returns the l f quiz tree element with the primary key.
    *
    * @param id the primary key of the l f quiz tree element
    * @return the l f quiz tree element
    * @throws PortalException if a l f quiz tree element with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement getLFQuizTreeElement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.getLFQuizTreeElement(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f quiz tree elements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizTreeElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz tree elements
    * @param end the upper bound of the range of l f quiz tree elements (not inclusive)
    * @return the range of l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> getLFQuizTreeElements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.getLFQuizTreeElements(start, end);
    }

    /**
    * Returns the number of l f quiz tree elements.
    *
    * @return the number of l f quiz tree elements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFQuizTreeElementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.getLFQuizTreeElementsCount();
    }

    /**
    * Updates the l f quiz tree element in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfQuizTreeElement the l f quiz tree element
    * @return the l f quiz tree element that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement updateLFQuizTreeElement(
        com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement lfQuizTreeElement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.updateLFQuizTreeElement(lfQuizTreeElement);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfQuizTreeElementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfQuizTreeElementLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfQuizTreeElementLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement createLFQuizTreeElement()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.createLFQuizTreeElement();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findByQuizID(
        java.lang.Integer quizID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.findByQuizID(quizID);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement findByQuizAndElementID(
        java.lang.Integer quizID, java.lang.String elementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.findByQuizAndElementID(quizID,
            elementId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement> findByQuizAndParentID(
        java.lang.Integer quizID, java.lang.String parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfQuizTreeElementLocalService.findByQuizAndParentID(quizID,
            parentId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizTreeElementLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFQuizTreeElementLocalService getWrappedLFQuizTreeElementLocalService() {
        return _lfQuizTreeElementLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFQuizTreeElementLocalService(
        LFQuizTreeElementLocalService lfQuizTreeElementLocalService) {
        _lfQuizTreeElementLocalService = lfQuizTreeElementLocalService;
    }

    @Override
    public LFQuizTreeElementLocalService getWrappedService() {
        return _lfQuizTreeElementLocalService;
    }

    @Override
    public void setWrappedService(
        LFQuizTreeElementLocalService lfQuizTreeElementLocalService) {
        _lfQuizTreeElementLocalService = lfQuizTreeElementLocalService;
    }
}

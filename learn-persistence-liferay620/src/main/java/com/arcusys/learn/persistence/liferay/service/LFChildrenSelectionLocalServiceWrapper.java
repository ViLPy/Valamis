package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFChildrenSelectionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFChildrenSelectionLocalService
 * @generated
 */
public class LFChildrenSelectionLocalServiceWrapper
    implements LFChildrenSelectionLocalService,
        ServiceWrapper<LFChildrenSelectionLocalService> {
    private LFChildrenSelectionLocalService _lfChildrenSelectionLocalService;

    public LFChildrenSelectionLocalServiceWrapper(
        LFChildrenSelectionLocalService lfChildrenSelectionLocalService) {
        _lfChildrenSelectionLocalService = lfChildrenSelectionLocalService;
    }

    /**
    * Adds the l f children selection to the database. Also notifies the appropriate model listeners.
    *
    * @param lfChildrenSelection the l f children selection
    * @return the l f children selection that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection addLFChildrenSelection(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.addLFChildrenSelection(lfChildrenSelection);
    }

    /**
    * Creates a new l f children selection with the primary key. Does not add the l f children selection to the database.
    *
    * @param id the primary key for the new l f children selection
    * @return the new l f children selection
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection createLFChildrenSelection(
        long id) {
        return _lfChildrenSelectionLocalService.createLFChildrenSelection(id);
    }

    /**
    * Deletes the l f children selection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection that was removed
    * @throws PortalException if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection deleteLFChildrenSelection(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.deleteLFChildrenSelection(id);
    }

    /**
    * Deletes the l f children selection from the database. Also notifies the appropriate model listeners.
    *
    * @param lfChildrenSelection the l f children selection
    * @return the l f children selection that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection deleteLFChildrenSelection(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.deleteLFChildrenSelection(lfChildrenSelection);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfChildrenSelectionLocalService.dynamicQuery();
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
        return _lfChildrenSelectionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfChildrenSelectionLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfChildrenSelectionLocalService.dynamicQuery(dynamicQuery,
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
        return _lfChildrenSelectionLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfChildrenSelectionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchLFChildrenSelection(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.fetchLFChildrenSelection(id);
    }

    /**
    * Returns the l f children selection with the primary key.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection
    * @throws PortalException if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection getLFChildrenSelection(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.getLFChildrenSelection(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f children selections.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFChildrenSelectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f children selections
    * @param end the upper bound of the range of l f children selections (not inclusive)
    * @return the range of l f children selections
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> getLFChildrenSelections(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.getLFChildrenSelections(start,
            end);
    }

    /**
    * Returns the number of l f children selections.
    *
    * @return the number of l f children selections
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFChildrenSelectionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.getLFChildrenSelectionsCount();
    }

    /**
    * Updates the l f children selection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfChildrenSelection the l f children selection
    * @return the l f children selection that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection updateLFChildrenSelection(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.updateLFChildrenSelection(lfChildrenSelection);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfChildrenSelectionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfChildrenSelectionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfChildrenSelectionLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection createLFChildrenSelection()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.createLFChildrenSelection();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfChildrenSelectionLocalService.findBySequencingID(sequencingID);
    }

    @Override
    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        _lfChildrenSelectionLocalService.removeBySequencingID(sequencingID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfChildrenSelectionLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFChildrenSelectionLocalService getWrappedLFChildrenSelectionLocalService() {
        return _lfChildrenSelectionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFChildrenSelectionLocalService(
        LFChildrenSelectionLocalService lfChildrenSelectionLocalService) {
        _lfChildrenSelectionLocalService = lfChildrenSelectionLocalService;
    }

    @Override
    public LFChildrenSelectionLocalService getWrappedService() {
        return _lfChildrenSelectionLocalService;
    }

    @Override
    public void setWrappedService(
        LFChildrenSelectionLocalService lfChildrenSelectionLocalService) {
        _lfChildrenSelectionLocalService = lfChildrenSelectionLocalService;
    }
}

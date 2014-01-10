package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsSubStatementLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanLrsSubStatementLocalService
 * @generated
 */
public class LFTincanLrsSubStatementLocalServiceWrapper
    implements LFTincanLrsSubStatementLocalService,
        ServiceWrapper<LFTincanLrsSubStatementLocalService> {
    private LFTincanLrsSubStatementLocalService _lfTincanLrsSubStatementLocalService;

    public LFTincanLrsSubStatementLocalServiceWrapper(
        LFTincanLrsSubStatementLocalService lfTincanLrsSubStatementLocalService) {
        _lfTincanLrsSubStatementLocalService = lfTincanLrsSubStatementLocalService;
    }

    /**
    * Adds the l f tincan lrs sub statement to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsSubStatement the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement addLFTincanLrsSubStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.addLFTincanLrsSubStatement(lfTincanLrsSubStatement);
    }

    /**
    * Creates a new l f tincan lrs sub statement with the primary key. Does not add the l f tincan lrs sub statement to the database.
    *
    * @param id the primary key for the new l f tincan lrs sub statement
    * @return the new l f tincan lrs sub statement
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement createLFTincanLrsSubStatement(
        long id) {
        return _lfTincanLrsSubStatementLocalService.createLFTincanLrsSubStatement(id);
    }

    /**
    * Deletes the l f tincan lrs sub statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement that was removed
    * @throws PortalException if a l f tincan lrs sub statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement deleteLFTincanLrsSubStatement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.deleteLFTincanLrsSubStatement(id);
    }

    /**
    * Deletes the l f tincan lrs sub statement from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsSubStatement the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement deleteLFTincanLrsSubStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.deleteLFTincanLrsSubStatement(lfTincanLrsSubStatement);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsSubStatementLocalService.dynamicQuery();
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
        return _lfTincanLrsSubStatementLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanLrsSubStatementLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsSubStatementLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsSubStatementLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement fetchLFTincanLrsSubStatement(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.fetchLFTincanLrsSubStatement(id);
    }

    /**
    * Returns the l f tincan lrs sub statement with the primary key.
    *
    * @param id the primary key of the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement
    * @throws PortalException if a l f tincan lrs sub statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement getLFTincanLrsSubStatement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.getLFTincanLrsSubStatement(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs sub statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs sub statements
    * @param end the upper bound of the range of l f tincan lrs sub statements (not inclusive)
    * @return the range of l f tincan lrs sub statements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement> getLFTincanLrsSubStatements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.getLFTincanLrsSubStatements(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs sub statements.
    *
    * @return the number of l f tincan lrs sub statements
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanLrsSubStatementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.getLFTincanLrsSubStatementsCount();
    }

    /**
    * Updates the l f tincan lrs sub statement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsSubStatement the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement updateLFTincanLrsSubStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.updateLFTincanLrsSubStatement(lfTincanLrsSubStatement);
    }

    /**
    * Updates the l f tincan lrs sub statement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsSubStatement the l f tincan lrs sub statement
    * @param merge whether to merge the l f tincan lrs sub statement with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan lrs sub statement that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement updateLFTincanLrsSubStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.updateLFTincanLrsSubStatement(lfTincanLrsSubStatement,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsSubStatementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsSubStatementLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsSubStatementLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsSubStatementLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement createLFTincanLrsSubStatement()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsSubStatementLocalService.createLFTincanLrsSubStatement();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanLrsSubStatementLocalService getWrappedLFTincanLrsSubStatementLocalService() {
        return _lfTincanLrsSubStatementLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsSubStatementLocalService(
        LFTincanLrsSubStatementLocalService lfTincanLrsSubStatementLocalService) {
        _lfTincanLrsSubStatementLocalService = lfTincanLrsSubStatementLocalService;
    }

    public LFTincanLrsSubStatementLocalService getWrappedService() {
        return _lfTincanLrsSubStatementLocalService;
    }

    public void setWrappedService(
        LFTincanLrsSubStatementLocalService lfTincanLrsSubStatementLocalService) {
        _lfTincanLrsSubStatementLocalService = lfTincanLrsSubStatementLocalService;
    }
}

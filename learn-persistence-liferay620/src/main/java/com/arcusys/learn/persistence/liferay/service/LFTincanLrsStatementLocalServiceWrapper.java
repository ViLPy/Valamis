package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanLrsStatementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementLocalService
 * @generated
 */
public class LFTincanLrsStatementLocalServiceWrapper
    implements LFTincanLrsStatementLocalService,
        ServiceWrapper<LFTincanLrsStatementLocalService> {
    private LFTincanLrsStatementLocalService _lfTincanLrsStatementLocalService;

    public LFTincanLrsStatementLocalServiceWrapper(
        LFTincanLrsStatementLocalService lfTincanLrsStatementLocalService) {
        _lfTincanLrsStatementLocalService = lfTincanLrsStatementLocalService;
    }

    /**
    * Adds the l f tincan lrs statement to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsStatement the l f tincan lrs statement
    * @return the l f tincan lrs statement that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement addLFTincanLrsStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.addLFTincanLrsStatement(lfTincanLrsStatement);
    }

    /**
    * Creates a new l f tincan lrs statement with the primary key. Does not add the l f tincan lrs statement to the database.
    *
    * @param id the primary key for the new l f tincan lrs statement
    * @return the new l f tincan lrs statement
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement createLFTincanLrsStatement(
        long id) {
        return _lfTincanLrsStatementLocalService.createLFTincanLrsStatement(id);
    }

    /**
    * Deletes the l f tincan lrs statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement that was removed
    * @throws PortalException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement deleteLFTincanLrsStatement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.deleteLFTincanLrsStatement(id);
    }

    /**
    * Deletes the l f tincan lrs statement from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsStatement the l f tincan lrs statement
    * @return the l f tincan lrs statement that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement deleteLFTincanLrsStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.deleteLFTincanLrsStatement(lfTincanLrsStatement);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsStatementLocalService.dynamicQuery();
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
        return _lfTincanLrsStatementLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsStatementLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsStatementLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsStatementLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanLrsStatementLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchLFTincanLrsStatement(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.fetchLFTincanLrsStatement(id);
    }

    /**
    * Returns the l f tincan lrs statement with the primary key.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement
    * @throws PortalException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement getLFTincanLrsStatement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.getLFTincanLrsStatement(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @return the range of l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> getLFTincanLrsStatements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.getLFTincanLrsStatements(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs statements.
    *
    * @return the number of l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanLrsStatementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.getLFTincanLrsStatementsCount();
    }

    /**
    * Updates the l f tincan lrs statement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsStatement the l f tincan lrs statement
    * @return the l f tincan lrs statement that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement updateLFTincanLrsStatement(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.updateLFTincanLrsStatement(lfTincanLrsStatement);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsStatementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsStatementLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsStatementLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsStatementLocalService.removeAll();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement createLFTincanLrsStatement()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.createLFTincanLrsStatement();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.findByActorID(actorID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.findByVerbID(verbID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.findByObjTypeAndObjID(objType,
            objID);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.findByTincanID(tincanID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findBy(
        java.lang.String statementID, java.lang.String voidedStatementID,
        java.lang.Integer actorID, java.lang.String verbID,
        java.lang.Integer objID, java.lang.String registration,
        java.util.Date since, java.util.Date until,
        java.lang.Boolean related_activities, java.lang.Boolean related_agents,
        java.lang.Boolean ascending, java.lang.Integer limit)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStatementLocalService.findBy(statementID,
            voidedStatementID, actorID, verbID, objID, registration, since,
            until, related_activities, related_agents, ascending, limit);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanLrsStatementLocalService getWrappedLFTincanLrsStatementLocalService() {
        return _lfTincanLrsStatementLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsStatementLocalService(
        LFTincanLrsStatementLocalService lfTincanLrsStatementLocalService) {
        _lfTincanLrsStatementLocalService = lfTincanLrsStatementLocalService;
    }

    @Override
    public LFTincanLrsStatementLocalService getWrappedService() {
        return _lfTincanLrsStatementLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanLrsStatementLocalService lfTincanLrsStatementLocalService) {
        _lfTincanLrsStatementLocalService = lfTincanLrsStatementLocalService;
    }
}

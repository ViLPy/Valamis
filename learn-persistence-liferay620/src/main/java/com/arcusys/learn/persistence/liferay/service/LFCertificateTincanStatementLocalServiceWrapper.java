package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFCertificateTincanStatementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateTincanStatementLocalService
 * @generated
 */
public class LFCertificateTincanStatementLocalServiceWrapper
    implements LFCertificateTincanStatementLocalService,
        ServiceWrapper<LFCertificateTincanStatementLocalService> {
    private LFCertificateTincanStatementLocalService _lfCertificateTincanStatementLocalService;

    public LFCertificateTincanStatementLocalServiceWrapper(
        LFCertificateTincanStatementLocalService lfCertificateTincanStatementLocalService) {
        _lfCertificateTincanStatementLocalService = lfCertificateTincanStatementLocalService;
    }

    /**
    * Adds the l f certificate tincan statement to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateTincanStatement the l f certificate tincan statement
    * @return the l f certificate tincan statement that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement addLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement lfCertificateTincanStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.addLFCertificateTincanStatement(lfCertificateTincanStatement);
    }

    /**
    * Creates a new l f certificate tincan statement with the primary key. Does not add the l f certificate tincan statement to the database.
    *
    * @param lfCertificateTincanStatementPK the primary key for the new l f certificate tincan statement
    * @return the new l f certificate tincan statement
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement createLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK lfCertificateTincanStatementPK) {
        return _lfCertificateTincanStatementLocalService.createLFCertificateTincanStatement(lfCertificateTincanStatementPK);
    }

    /**
    * Deletes the l f certificate tincan statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
    * @return the l f certificate tincan statement that was removed
    * @throws PortalException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement deleteLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.deleteLFCertificateTincanStatement(lfCertificateTincanStatementPK);
    }

    /**
    * Deletes the l f certificate tincan statement from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateTincanStatement the l f certificate tincan statement
    * @return the l f certificate tincan statement that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement deleteLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement lfCertificateTincanStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.deleteLFCertificateTincanStatement(lfCertificateTincanStatement);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCertificateTincanStatementLocalService.dynamicQuery();
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
        return _lfCertificateTincanStatementLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfCertificateTincanStatementLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfCertificateTincanStatementLocalService.dynamicQuery(dynamicQuery,
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
        return _lfCertificateTincanStatementLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfCertificateTincanStatementLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement fetchLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.fetchLFCertificateTincanStatement(lfCertificateTincanStatementPK);
    }

    /**
    * Returns the l f certificate tincan statement with the primary key.
    *
    * @param lfCertificateTincanStatementPK the primary key of the l f certificate tincan statement
    * @return the l f certificate tincan statement
    * @throws PortalException if a l f certificate tincan statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement getLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK lfCertificateTincanStatementPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.getLFCertificateTincanStatement(lfCertificateTincanStatementPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificate tincan statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateTincanStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate tincan statements
    * @param end the upper bound of the range of l f certificate tincan statements (not inclusive)
    * @return the range of l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> getLFCertificateTincanStatements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.getLFCertificateTincanStatements(start,
            end);
    }

    /**
    * Returns the number of l f certificate tincan statements.
    *
    * @return the number of l f certificate tincan statements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFCertificateTincanStatementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.getLFCertificateTincanStatementsCount();
    }

    /**
    * Updates the l f certificate tincan statement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateTincanStatement the l f certificate tincan statement
    * @return the l f certificate tincan statement that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement updateLFCertificateTincanStatement(
        com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement lfCertificateTincanStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.updateLFCertificateTincanStatement(lfCertificateTincanStatement);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfCertificateTincanStatementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCertificateTincanStatementLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCertificateTincanStatementLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByCertificateID(
        java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.findByCertificateID(certificateID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerb(
        java.lang.String verb)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.findByVerb(verb);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByStatementObject(
        java.lang.String obj)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.findByStatementObject(obj);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement> findByVerbAndObject(
        java.lang.String verb, java.lang.String obj)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.findByVerbAndObject(verb,
            obj);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement findByCertificateIDAndVerbAndObject(
        java.lang.Long certificateID, java.lang.String verb,
        java.lang.String obj)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateTincanStatementLocalService.findByCertificateIDAndVerbAndObject(certificateID,
            verb, obj);
    }

    @Override
    public void removeByUserIDAndCertificateID(java.lang.Long certificateID,
        java.lang.String verb, java.lang.String obj)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateTincanStatementLocalService.removeByUserIDAndCertificateID(certificateID,
            verb, obj);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateTincanStatementLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFCertificateTincanStatementLocalService getWrappedLFCertificateTincanStatementLocalService() {
        return _lfCertificateTincanStatementLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFCertificateTincanStatementLocalService(
        LFCertificateTincanStatementLocalService lfCertificateTincanStatementLocalService) {
        _lfCertificateTincanStatementLocalService = lfCertificateTincanStatementLocalService;
    }

    @Override
    public LFCertificateTincanStatementLocalService getWrappedService() {
        return _lfCertificateTincanStatementLocalService;
    }

    @Override
    public void setWrappedService(
        LFCertificateTincanStatementLocalService lfCertificateTincanStatementLocalService) {
        _lfCertificateTincanStatementLocalService = lfCertificateTincanStatementLocalService;
    }
}

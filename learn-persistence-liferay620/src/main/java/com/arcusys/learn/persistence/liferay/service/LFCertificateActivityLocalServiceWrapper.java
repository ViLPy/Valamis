package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFCertificateActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateActivityLocalService
 * @generated
 */
public class LFCertificateActivityLocalServiceWrapper
    implements LFCertificateActivityLocalService,
        ServiceWrapper<LFCertificateActivityLocalService> {
    private LFCertificateActivityLocalService _lfCertificateActivityLocalService;

    public LFCertificateActivityLocalServiceWrapper(
        LFCertificateActivityLocalService lfCertificateActivityLocalService) {
        _lfCertificateActivityLocalService = lfCertificateActivityLocalService;
    }

    /**
    * Adds the l f certificate activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateActivity the l f certificate activity
    * @return the l f certificate activity that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity addLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.model.LFCertificateActivity lfCertificateActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.addLFCertificateActivity(lfCertificateActivity);
    }

    /**
    * Creates a new l f certificate activity with the primary key. Does not add the l f certificate activity to the database.
    *
    * @param lfCertificateActivityPK the primary key for the new l f certificate activity
    * @return the new l f certificate activity
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity createLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK lfCertificateActivityPK) {
        return _lfCertificateActivityLocalService.createLFCertificateActivity(lfCertificateActivityPK);
    }

    /**
    * Deletes the l f certificate activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateActivityPK the primary key of the l f certificate activity
    * @return the l f certificate activity that was removed
    * @throws PortalException if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity deleteLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK lfCertificateActivityPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.deleteLFCertificateActivity(lfCertificateActivityPK);
    }

    /**
    * Deletes the l f certificate activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateActivity the l f certificate activity
    * @return the l f certificate activity that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity deleteLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.model.LFCertificateActivity lfCertificateActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.deleteLFCertificateActivity(lfCertificateActivity);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCertificateActivityLocalService.dynamicQuery();
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
        return _lfCertificateActivityLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfCertificateActivityLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfCertificateActivityLocalService.dynamicQuery(dynamicQuery,
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
        return _lfCertificateActivityLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfCertificateActivityLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity fetchLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK lfCertificateActivityPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.fetchLFCertificateActivity(lfCertificateActivityPK);
    }

    /**
    * Returns the l f certificate activity with the primary key.
    *
    * @param lfCertificateActivityPK the primary key of the l f certificate activity
    * @return the l f certificate activity
    * @throws PortalException if a l f certificate activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity getLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK lfCertificateActivityPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.getLFCertificateActivity(lfCertificateActivityPK);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificate activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate activities
    * @param end the upper bound of the range of l f certificate activities (not inclusive)
    * @return the range of l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> getLFCertificateActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.getLFCertificateActivities(start,
            end);
    }

    /**
    * Returns the number of l f certificate activities.
    *
    * @return the number of l f certificate activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFCertificateActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.getLFCertificateActivitiesCount();
    }

    /**
    * Updates the l f certificate activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateActivity the l f certificate activity
    * @return the l f certificate activity that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity updateLFCertificateActivity(
        com.arcusys.learn.persistence.liferay.model.LFCertificateActivity lfCertificateActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.updateLFCertificateActivity(lfCertificateActivity);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfCertificateActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCertificateActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCertificateActivityLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByCertificateID(
        java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.findByCertificateID(certificateID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateActivity> findByActivityName(
        java.lang.String activityName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.findByActivityName(activityName);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFCertificateActivity findByCertificateIDAndActivityName(
        java.lang.Long certificateID, java.lang.String activityName)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCertificateActivityLocalService.findByCertificateIDAndActivityName(certificateID,
            activityName);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateActivityLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFCertificateActivityLocalService getWrappedLFCertificateActivityLocalService() {
        return _lfCertificateActivityLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFCertificateActivityLocalService(
        LFCertificateActivityLocalService lfCertificateActivityLocalService) {
        _lfCertificateActivityLocalService = lfCertificateActivityLocalService;
    }

    @Override
    public LFCertificateActivityLocalService getWrappedService() {
        return _lfCertificateActivityLocalService;
    }

    @Override
    public void setWrappedService(
        LFCertificateActivityLocalService lfCertificateActivityLocalService) {
        _lfCertificateActivityLocalService = lfCertificateActivityLocalService;
    }
}

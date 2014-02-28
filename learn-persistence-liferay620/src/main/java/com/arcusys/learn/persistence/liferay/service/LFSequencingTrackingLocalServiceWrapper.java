package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFSequencingTrackingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingTrackingLocalService
 * @generated
 */
public class LFSequencingTrackingLocalServiceWrapper
    implements LFSequencingTrackingLocalService,
        ServiceWrapper<LFSequencingTrackingLocalService> {
    private LFSequencingTrackingLocalService _lfSequencingTrackingLocalService;

    public LFSequencingTrackingLocalServiceWrapper(
        LFSequencingTrackingLocalService lfSequencingTrackingLocalService) {
        _lfSequencingTrackingLocalService = lfSequencingTrackingLocalService;
    }

    /**
    * Adds the l f sequencing tracking to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingTracking the l f sequencing tracking
    * @return the l f sequencing tracking that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking addLFSequencingTracking(
        com.arcusys.learn.persistence.liferay.model.LFSequencingTracking lfSequencingTracking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.addLFSequencingTracking(lfSequencingTracking);
    }

    /**
    * Creates a new l f sequencing tracking with the primary key. Does not add the l f sequencing tracking to the database.
    *
    * @param id the primary key for the new l f sequencing tracking
    * @return the new l f sequencing tracking
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking createLFSequencingTracking(
        long id) {
        return _lfSequencingTrackingLocalService.createLFSequencingTracking(id);
    }

    /**
    * Deletes the l f sequencing tracking with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing tracking
    * @return the l f sequencing tracking that was removed
    * @throws PortalException if a l f sequencing tracking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking deleteLFSequencingTracking(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.deleteLFSequencingTracking(id);
    }

    /**
    * Deletes the l f sequencing tracking from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingTracking the l f sequencing tracking
    * @return the l f sequencing tracking that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking deleteLFSequencingTracking(
        com.arcusys.learn.persistence.liferay.model.LFSequencingTracking lfSequencingTracking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.deleteLFSequencingTracking(lfSequencingTracking);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSequencingTrackingLocalService.dynamicQuery();
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
        return _lfSequencingTrackingLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSequencingTrackingLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSequencingTrackingLocalService.dynamicQuery(dynamicQuery,
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
        return _lfSequencingTrackingLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfSequencingTrackingLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking fetchLFSequencingTracking(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.fetchLFSequencingTracking(id);
    }

    /**
    * Returns the l f sequencing tracking with the primary key.
    *
    * @param id the primary key of the l f sequencing tracking
    * @return the l f sequencing tracking
    * @throws PortalException if a l f sequencing tracking with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking getLFSequencingTracking(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.getLFSequencingTracking(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f sequencing trackings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencing trackings
    * @param end the upper bound of the range of l f sequencing trackings (not inclusive)
    * @return the range of l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> getLFSequencingTrackings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.getLFSequencingTrackings(start,
            end);
    }

    /**
    * Returns the number of l f sequencing trackings.
    *
    * @return the number of l f sequencing trackings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFSequencingTrackingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.getLFSequencingTrackingsCount();
    }

    /**
    * Updates the l f sequencing tracking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingTracking the l f sequencing tracking
    * @return the l f sequencing tracking that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking updateLFSequencingTracking(
        com.arcusys.learn.persistence.liferay.model.LFSequencingTracking lfSequencingTracking)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.updateLFSequencingTracking(lfSequencingTracking);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfSequencingTrackingLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSequencingTrackingLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSequencingTrackingLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencingTracking createLFSequencingTracking()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.createLFSequencingTracking();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingTracking> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingTrackingLocalService.findBySequencingID(sequencingID);
    }

    @Override
    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingTrackingLocalService.removeBySequencingID(sequencingID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingTrackingLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFSequencingTrackingLocalService getWrappedLFSequencingTrackingLocalService() {
        return _lfSequencingTrackingLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFSequencingTrackingLocalService(
        LFSequencingTrackingLocalService lfSequencingTrackingLocalService) {
        _lfSequencingTrackingLocalService = lfSequencingTrackingLocalService;
    }

    @Override
    public LFSequencingTrackingLocalService getWrappedService() {
        return _lfSequencingTrackingLocalService;
    }

    @Override
    public void setWrappedService(
        LFSequencingTrackingLocalService lfSequencingTrackingLocalService) {
        _lfSequencingTrackingLocalService = lfSequencingTrackingLocalService;
    }
}

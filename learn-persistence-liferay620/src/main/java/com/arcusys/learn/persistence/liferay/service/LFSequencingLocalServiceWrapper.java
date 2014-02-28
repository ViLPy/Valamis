package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFSequencingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingLocalService
 * @generated
 */
public class LFSequencingLocalServiceWrapper implements LFSequencingLocalService,
    ServiceWrapper<LFSequencingLocalService> {
    private LFSequencingLocalService _lfSequencingLocalService;

    public LFSequencingLocalServiceWrapper(
        LFSequencingLocalService lfSequencingLocalService) {
        _lfSequencingLocalService = lfSequencingLocalService;
    }

    /**
    * Adds the l f sequencing to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @return the l f sequencing that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing addLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.addLFSequencing(lfSequencing);
    }

    /**
    * Creates a new l f sequencing with the primary key. Does not add the l f sequencing to the database.
    *
    * @param id the primary key for the new l f sequencing
    * @return the new l f sequencing
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing createLFSequencing(
        long id) {
        return _lfSequencingLocalService.createLFSequencing(id);
    }

    /**
    * Deletes the l f sequencing with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing that was removed
    * @throws PortalException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing deleteLFSequencing(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.deleteLFSequencing(id);
    }

    /**
    * Deletes the l f sequencing from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @return the l f sequencing that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing deleteLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.deleteLFSequencing(lfSequencing);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSequencingLocalService.dynamicQuery();
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
        return _lfSequencingLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSequencingLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSequencingLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _lfSequencingLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfSequencingLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing fetchLFSequencing(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.fetchLFSequencing(id);
    }

    /**
    * Returns the l f sequencing with the primary key.
    *
    * @param id the primary key of the l f sequencing
    * @return the l f sequencing
    * @throws PortalException if a l f sequencing with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing getLFSequencing(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.getLFSequencing(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f sequencings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSequencingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencings
    * @param end the upper bound of the range of l f sequencings (not inclusive)
    * @return the range of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencing> getLFSequencings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.getLFSequencings(start, end);
    }

    /**
    * Returns the number of l f sequencings.
    *
    * @return the number of l f sequencings
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFSequencingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.getLFSequencingsCount();
    }

    /**
    * Updates the l f sequencing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSequencing the l f sequencing
    * @return the l f sequencing that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing updateLFSequencing(
        com.arcusys.learn.persistence.liferay.model.LFSequencing lfSequencing)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.updateLFSequencing(lfSequencing);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfSequencingLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSequencingLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSequencingLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing createLFSequencing()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.createLFSequencing();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing findByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.findByActivityIDAndPackageID(packageID,
            activityID);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSequencing removeByActivityIDAndPackageID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSequencingLocalService.removeByActivityIDAndPackageID(packageID,
            activityID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFSequencingLocalService getWrappedLFSequencingLocalService() {
        return _lfSequencingLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFSequencingLocalService(
        LFSequencingLocalService lfSequencingLocalService) {
        _lfSequencingLocalService = lfSequencingLocalService;
    }

    @Override
    public LFSequencingLocalService getWrappedService() {
        return _lfSequencingLocalService;
    }

    @Override
    public void setWrappedService(
        LFSequencingLocalService lfSequencingLocalService) {
        _lfSequencingLocalService = lfSequencingLocalService;
    }
}

package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFActivityDataMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityDataMapLocalService
 * @generated
 */
public class LFActivityDataMapLocalServiceWrapper
    implements LFActivityDataMapLocalService,
        ServiceWrapper<LFActivityDataMapLocalService> {
    private LFActivityDataMapLocalService _lfActivityDataMapLocalService;

    public LFActivityDataMapLocalServiceWrapper(
        LFActivityDataMapLocalService lfActivityDataMapLocalService) {
        _lfActivityDataMapLocalService = lfActivityDataMapLocalService;
    }

    /**
    * Adds the l f activity data map to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityDataMap the l f activity data map
    * @return the l f activity data map that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap addLFActivityDataMap(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.addLFActivityDataMap(lfActivityDataMap);
    }

    /**
    * Creates a new l f activity data map with the primary key. Does not add the l f activity data map to the database.
    *
    * @param id the primary key for the new l f activity data map
    * @return the new l f activity data map
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap createLFActivityDataMap(
        long id) {
        return _lfActivityDataMapLocalService.createLFActivityDataMap(id);
    }

    /**
    * Deletes the l f activity data map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map that was removed
    * @throws PortalException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap deleteLFActivityDataMap(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.deleteLFActivityDataMap(id);
    }

    /**
    * Deletes the l f activity data map from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityDataMap the l f activity data map
    * @return the l f activity data map that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap deleteLFActivityDataMap(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.deleteLFActivityDataMap(lfActivityDataMap);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfActivityDataMapLocalService.dynamicQuery();
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
        return _lfActivityDataMapLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfActivityDataMapLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfActivityDataMapLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfActivityDataMapLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfActivityDataMapLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap fetchLFActivityDataMap(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.fetchLFActivityDataMap(id);
    }

    /**
    * Returns the l f activity data map with the primary key.
    *
    * @param id the primary key of the l f activity data map
    * @return the l f activity data map
    * @throws PortalException if a l f activity data map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap getLFActivityDataMap(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.getLFActivityDataMap(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activity data maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityDataMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity data maps
    * @param end the upper bound of the range of l f activity data maps (not inclusive)
    * @return the range of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> getLFActivityDataMaps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.getLFActivityDataMaps(start, end);
    }

    /**
    * Returns the number of l f activity data maps.
    *
    * @return the number of l f activity data maps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFActivityDataMapsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.getLFActivityDataMapsCount();
    }

    /**
    * Updates the l f activity data map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityDataMap the l f activity data map
    * @return the l f activity data map that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap updateLFActivityDataMap(
        com.arcusys.learn.persistence.liferay.model.LFActivityDataMap lfActivityDataMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.updateLFActivityDataMap(lfActivityDataMap);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfActivityDataMapLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfActivityDataMapLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfActivityDataMapLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityDataMap createLFAttemptData()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.createLFAttemptData();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityDataMap> findByPackageIDAndActivityID(
        java.lang.Integer packageID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityDataMapLocalService.findByPackageIDAndActivityID(packageID,
            activityID);
    }

    @Override
    public void removeByPackageIDAndActivityID(java.lang.Integer packageID,
        java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityDataMapLocalService.removeByPackageIDAndActivityID(packageID,
            activityID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityDataMapLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFActivityDataMapLocalService getWrappedLFActivityDataMapLocalService() {
        return _lfActivityDataMapLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFActivityDataMapLocalService(
        LFActivityDataMapLocalService lfActivityDataMapLocalService) {
        _lfActivityDataMapLocalService = lfActivityDataMapLocalService;
    }

    @Override
    public LFActivityDataMapLocalService getWrappedService() {
        return _lfActivityDataMapLocalService;
    }

    @Override
    public void setWrappedService(
        LFActivityDataMapLocalService lfActivityDataMapLocalService) {
        _lfActivityDataMapLocalService = lfActivityDataMapLocalService;
    }
}

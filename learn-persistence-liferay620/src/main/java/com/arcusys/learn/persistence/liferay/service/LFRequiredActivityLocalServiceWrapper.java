package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFRequiredActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFRequiredActivityLocalService
 * @generated
 */
public class LFRequiredActivityLocalServiceWrapper
    implements LFRequiredActivityLocalService,
        ServiceWrapper<LFRequiredActivityLocalService> {
    private LFRequiredActivityLocalService _lfRequiredActivityLocalService;

    public LFRequiredActivityLocalServiceWrapper(
        LFRequiredActivityLocalService lfRequiredActivityLocalService) {
        _lfRequiredActivityLocalService = lfRequiredActivityLocalService;
    }

    /**
    * Adds the l f required activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRequiredActivity the l f required activity
    * @return the l f required activity that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity addLFRequiredActivity(
        com.arcusys.learn.persistence.liferay.model.LFRequiredActivity lfRequiredActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.addLFRequiredActivity(lfRequiredActivity);
    }

    /**
    * Creates a new l f required activity with the primary key. Does not add the l f required activity to the database.
    *
    * @param id the primary key for the new l f required activity
    * @return the new l f required activity
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity createLFRequiredActivity(
        long id) {
        return _lfRequiredActivityLocalService.createLFRequiredActivity(id);
    }

    /**
    * Deletes the l f required activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f required activity
    * @return the l f required activity that was removed
    * @throws PortalException if a l f required activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity deleteLFRequiredActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.deleteLFRequiredActivity(id);
    }

    /**
    * Deletes the l f required activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRequiredActivity the l f required activity
    * @return the l f required activity that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity deleteLFRequiredActivity(
        com.arcusys.learn.persistence.liferay.model.LFRequiredActivity lfRequiredActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.deleteLFRequiredActivity(lfRequiredActivity);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfRequiredActivityLocalService.dynamicQuery();
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
        return _lfRequiredActivityLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfRequiredActivityLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfRequiredActivityLocalService.dynamicQuery(dynamicQuery,
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
        return _lfRequiredActivityLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfRequiredActivityLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity fetchLFRequiredActivity(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.fetchLFRequiredActivity(id);
    }

    /**
    * Returns the l f required activity with the primary key.
    *
    * @param id the primary key of the l f required activity
    * @return the l f required activity
    * @throws PortalException if a l f required activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity getLFRequiredActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.getLFRequiredActivity(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f required activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRequiredActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f required activities
    * @param end the upper bound of the range of l f required activities (not inclusive)
    * @return the range of l f required activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> getLFRequiredActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.getLFRequiredActivities(start,
            end);
    }

    /**
    * Returns the number of l f required activities.
    *
    * @return the number of l f required activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFRequiredActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.getLFRequiredActivitiesCount();
    }

    /**
    * Updates the l f required activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRequiredActivity the l f required activity
    * @return the l f required activity that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity updateLFRequiredActivity(
        com.arcusys.learn.persistence.liferay.model.LFRequiredActivity lfRequiredActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.updateLFRequiredActivity(lfRequiredActivity);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfRequiredActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfRequiredActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfRequiredActivityLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRequiredActivity> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.findByAchievementId(achievementId);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRequiredActivity createLFRequiredActivity(
        java.lang.Integer achievementId, java.lang.String activityClassName,
        java.lang.Integer numberActivitiesRequired)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRequiredActivityLocalService.createLFRequiredActivity(achievementId,
            activityClassName, numberActivitiesRequired);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRequiredActivityLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFRequiredActivityLocalService getWrappedLFRequiredActivityLocalService() {
        return _lfRequiredActivityLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFRequiredActivityLocalService(
        LFRequiredActivityLocalService lfRequiredActivityLocalService) {
        _lfRequiredActivityLocalService = lfRequiredActivityLocalService;
    }

    @Override
    public LFRequiredActivityLocalService getWrappedService() {
        return _lfRequiredActivityLocalService;
    }

    @Override
    public void setWrappedService(
        LFRequiredActivityLocalService lfRequiredActivityLocalService) {
        _lfRequiredActivityLocalService = lfRequiredActivityLocalService;
    }
}

package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFAchievementActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementActivityLocalService
 * @generated
 */
public class LFAchievementActivityLocalServiceWrapper
    implements LFAchievementActivityLocalService,
        ServiceWrapper<LFAchievementActivityLocalService> {
    private LFAchievementActivityLocalService _lfAchievementActivityLocalService;

    public LFAchievementActivityLocalServiceWrapper(
        LFAchievementActivityLocalService lfAchievementActivityLocalService) {
        _lfAchievementActivityLocalService = lfAchievementActivityLocalService;
    }

    /**
    * Adds the l f achievement activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAchievementActivity the l f achievement activity
    * @return the l f achievement activity that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity addLFAchievementActivity(
        com.arcusys.learn.persistence.liferay.model.LFAchievementActivity lfAchievementActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.addLFAchievementActivity(lfAchievementActivity);
    }

    /**
    * Creates a new l f achievement activity with the primary key. Does not add the l f achievement activity to the database.
    *
    * @param id the primary key for the new l f achievement activity
    * @return the new l f achievement activity
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity createLFAchievementActivity(
        long id) {
        return _lfAchievementActivityLocalService.createLFAchievementActivity(id);
    }

    /**
    * Deletes the l f achievement activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement activity
    * @return the l f achievement activity that was removed
    * @throws PortalException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity deleteLFAchievementActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.deleteLFAchievementActivity(id);
    }

    /**
    * Deletes the l f achievement activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAchievementActivity the l f achievement activity
    * @return the l f achievement activity that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity deleteLFAchievementActivity(
        com.arcusys.learn.persistence.liferay.model.LFAchievementActivity lfAchievementActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.deleteLFAchievementActivity(lfAchievementActivity);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfAchievementActivityLocalService.dynamicQuery();
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
        return _lfAchievementActivityLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAchievementActivityLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAchievementActivityLocalService.dynamicQuery(dynamicQuery,
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
        return _lfAchievementActivityLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfAchievementActivityLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity fetchLFAchievementActivity(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.fetchLFAchievementActivity(id);
    }

    /**
    * Returns the l f achievement activity with the primary key.
    *
    * @param id the primary key of the l f achievement activity
    * @return the l f achievement activity
    * @throws PortalException if a l f achievement activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity getLFAchievementActivity(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.getLFAchievementActivity(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f achievement activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievement activities
    * @param end the upper bound of the range of l f achievement activities (not inclusive)
    * @return the range of l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> getLFAchievementActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.getLFAchievementActivities(start,
            end);
    }

    /**
    * Returns the number of l f achievement activities.
    *
    * @return the number of l f achievement activities
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFAchievementActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.getLFAchievementActivitiesCount();
    }

    /**
    * Updates the l f achievement activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAchievementActivity the l f achievement activity
    * @return the l f achievement activity that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity updateLFAchievementActivity(
        com.arcusys.learn.persistence.liferay.model.LFAchievementActivity lfAchievementActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.updateLFAchievementActivity(lfAchievementActivity);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfAchievementActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfAchievementActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfAchievementActivityLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.findByAchievementId(achievementId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findByUserId(
        java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.findByUserId(userId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.findAll();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementActivity> findAllByAchievementAndUserId(
        java.lang.Integer achievementId, java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.findAllByAchievementAndUserId(achievementId,
            userId);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementActivity createLFAchievementActivity(
        java.lang.Integer userId, java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementActivityLocalService.createLFAchievementActivity(userId,
            achievementId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAchievementActivityLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFAchievementActivityLocalService getWrappedLFAchievementActivityLocalService() {
        return _lfAchievementActivityLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFAchievementActivityLocalService(
        LFAchievementActivityLocalService lfAchievementActivityLocalService) {
        _lfAchievementActivityLocalService = lfAchievementActivityLocalService;
    }

    @Override
    public LFAchievementActivityLocalService getWrappedService() {
        return _lfAchievementActivityLocalService;
    }

    @Override
    public void setWrappedService(
        LFAchievementActivityLocalService lfAchievementActivityLocalService) {
        _lfAchievementActivityLocalService = lfAchievementActivityLocalService;
    }
}

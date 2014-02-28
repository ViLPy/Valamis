package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFAchievementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementLocalService
 * @generated
 */
public class LFAchievementLocalServiceWrapper
    implements LFAchievementLocalService,
        ServiceWrapper<LFAchievementLocalService> {
    private LFAchievementLocalService _lfAchievementLocalService;

    public LFAchievementLocalServiceWrapper(
        LFAchievementLocalService lfAchievementLocalService) {
        _lfAchievementLocalService = lfAchievementLocalService;
    }

    /**
    * Adds the l f achievement to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAchievement the l f achievement
    * @return the l f achievement that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement addLFAchievement(
        com.arcusys.learn.persistence.liferay.model.LFAchievement lfAchievement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.addLFAchievement(lfAchievement);
    }

    /**
    * Creates a new l f achievement with the primary key. Does not add the l f achievement to the database.
    *
    * @param id the primary key for the new l f achievement
    * @return the new l f achievement
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement createLFAchievement(
        long id) {
        return _lfAchievementLocalService.createLFAchievement(id);
    }

    /**
    * Deletes the l f achievement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement
    * @return the l f achievement that was removed
    * @throws PortalException if a l f achievement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement deleteLFAchievement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.deleteLFAchievement(id);
    }

    /**
    * Deletes the l f achievement from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAchievement the l f achievement
    * @return the l f achievement that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement deleteLFAchievement(
        com.arcusys.learn.persistence.liferay.model.LFAchievement lfAchievement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.deleteLFAchievement(lfAchievement);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfAchievementLocalService.dynamicQuery();
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
        return _lfAchievementLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAchievementLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAchievementLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfAchievementLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfAchievementLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement fetchLFAchievement(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.fetchLFAchievement(id);
    }

    /**
    * Returns the l f achievement with the primary key.
    *
    * @param id the primary key of the l f achievement
    * @return the l f achievement
    * @throws PortalException if a l f achievement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement getLFAchievement(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.getLFAchievement(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f achievements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievements
    * @param end the upper bound of the range of l f achievements (not inclusive)
    * @return the range of l f achievements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievement> getLFAchievements(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.getLFAchievements(start, end);
    }

    /**
    * Returns the number of l f achievements.
    *
    * @return the number of l f achievements
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFAchievementsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.getLFAchievementsCount();
    }

    /**
    * Updates the l f achievement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAchievement the l f achievement
    * @return the l f achievement that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement updateLFAchievement(
        com.arcusys.learn.persistence.liferay.model.LFAchievement lfAchievement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.updateLFAchievement(lfAchievement);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfAchievementLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfAchievementLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfAchievementLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievement createLFAchievement(
        java.lang.String title, java.lang.String description,
        java.lang.String logo, java.util.Date creationDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.createLFAchievement(title,
            description, logo, creationDate);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementLocalService.findAll();
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAchievementLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFAchievementLocalService getWrappedLFAchievementLocalService() {
        return _lfAchievementLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFAchievementLocalService(
        LFAchievementLocalService lfAchievementLocalService) {
        _lfAchievementLocalService = lfAchievementLocalService;
    }

    @Override
    public LFAchievementLocalService getWrappedService() {
        return _lfAchievementLocalService;
    }

    @Override
    public void setWrappedService(
        LFAchievementLocalService lfAchievementLocalService) {
        _lfAchievementLocalService = lfAchievementLocalService;
    }
}

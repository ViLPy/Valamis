package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFAchievementUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementUserLocalService
 * @generated
 */
public class LFAchievementUserLocalServiceWrapper
    implements LFAchievementUserLocalService,
        ServiceWrapper<LFAchievementUserLocalService> {
    private LFAchievementUserLocalService _lfAchievementUserLocalService;

    public LFAchievementUserLocalServiceWrapper(
        LFAchievementUserLocalService lfAchievementUserLocalService) {
        _lfAchievementUserLocalService = lfAchievementUserLocalService;
    }

    /**
    * Adds the l f achievement user to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAchievementUser the l f achievement user
    * @return the l f achievement user that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser addLFAchievementUser(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.addLFAchievementUser(lfAchievementUser);
    }

    /**
    * Creates a new l f achievement user with the primary key. Does not add the l f achievement user to the database.
    *
    * @param id the primary key for the new l f achievement user
    * @return the new l f achievement user
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser createLFAchievementUser(
        long id) {
        return _lfAchievementUserLocalService.createLFAchievementUser(id);
    }

    /**
    * Deletes the l f achievement user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user that was removed
    * @throws PortalException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser deleteLFAchievementUser(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.deleteLFAchievementUser(id);
    }

    /**
    * Deletes the l f achievement user from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAchievementUser the l f achievement user
    * @return the l f achievement user that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser deleteLFAchievementUser(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.deleteLFAchievementUser(lfAchievementUser);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfAchievementUserLocalService.dynamicQuery();
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
        return _lfAchievementUserLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAchievementUserLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfAchievementUserLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfAchievementUserLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfAchievementUserLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser fetchLFAchievementUser(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.fetchLFAchievementUser(id);
    }

    /**
    * Returns the l f achievement user with the primary key.
    *
    * @param id the primary key of the l f achievement user
    * @return the l f achievement user
    * @throws PortalException if a l f achievement user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser getLFAchievementUser(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.getLFAchievementUser(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f achievement users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAchievementUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f achievement users
    * @param end the upper bound of the range of l f achievement users (not inclusive)
    * @return the range of l f achievement users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> getLFAchievementUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.getLFAchievementUsers(start, end);
    }

    /**
    * Returns the number of l f achievement users.
    *
    * @return the number of l f achievement users
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFAchievementUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.getLFAchievementUsersCount();
    }

    /**
    * Updates the l f achievement user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAchievementUser the l f achievement user
    * @return the l f achievement user that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser updateLFAchievementUser(
        com.arcusys.learn.persistence.liferay.model.LFAchievementUser lfAchievementUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.updateLFAchievementUser(lfAchievementUser);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfAchievementUserLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfAchievementUserLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfAchievementUserLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByUserId(
        java.lang.Integer userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.findByUserId(userId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.findAll();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAchievementUser> findByAchievementId(
        java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.findByAchievementId(achievementId);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFAchievementUser createLFAchievementUser(
        java.lang.Integer userId, java.lang.Integer achievementId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAchievementUserLocalService.createLFAchievementUser(userId,
            achievementId);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAchievementUserLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFAchievementUserLocalService getWrappedLFAchievementUserLocalService() {
        return _lfAchievementUserLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFAchievementUserLocalService(
        LFAchievementUserLocalService lfAchievementUserLocalService) {
        _lfAchievementUserLocalService = lfAchievementUserLocalService;
    }

    @Override
    public LFAchievementUserLocalService getWrappedService() {
        return _lfAchievementUserLocalService;
    }

    @Override
    public void setWrappedService(
        LFAchievementUserLocalService lfAchievementUserLocalService) {
        _lfAchievementUserLocalService = lfAchievementUserLocalService;
    }
}

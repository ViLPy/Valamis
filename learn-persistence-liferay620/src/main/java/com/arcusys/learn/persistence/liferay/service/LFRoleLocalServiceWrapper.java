package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFRoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFRoleLocalService
 * @generated
 */
public class LFRoleLocalServiceWrapper implements LFRoleLocalService,
    ServiceWrapper<LFRoleLocalService> {
    private LFRoleLocalService _lfRoleLocalService;

    public LFRoleLocalServiceWrapper(LFRoleLocalService lfRoleLocalService) {
        _lfRoleLocalService = lfRoleLocalService;
    }

    /**
    * Adds the l f role to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRole the l f role
    * @return the l f role that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole addLFRole(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.addLFRole(lfRole);
    }

    /**
    * Creates a new l f role with the primary key. Does not add the l f role to the database.
    *
    * @param id the primary key for the new l f role
    * @return the new l f role
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole createLFRole(
        long id) {
        return _lfRoleLocalService.createLFRole(id);
    }

    /**
    * Deletes the l f role with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f role
    * @return the l f role that was removed
    * @throws PortalException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole deleteLFRole(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.deleteLFRole(id);
    }

    /**
    * Deletes the l f role from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRole the l f role
    * @return the l f role that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole deleteLFRole(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.deleteLFRole(lfRole);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfRoleLocalService.dynamicQuery();
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
        return _lfRoleLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfRoleLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfRoleLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _lfRoleLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfRoleLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole fetchLFRole(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.fetchLFRole(id);
    }

    /**
    * Returns the l f role with the primary key.
    *
    * @param id the primary key of the l f role
    * @return the l f role
    * @throws PortalException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole getLFRole(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.getLFRole(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f roles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f roles
    * @param end the upper bound of the range of l f roles (not inclusive)
    * @return the range of l f roles
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> getLFRoles(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.getLFRoles(start, end);
    }

    /**
    * Returns the number of l f roles.
    *
    * @return the number of l f roles
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFRolesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.getLFRolesCount();
    }

    /**
    * Updates the l f role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRole the l f role
    * @return the l f role that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole updateLFRole(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.updateLFRole(lfRole);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfRoleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfRoleLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfRoleLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRole createLFRole()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.createLFRole();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.findByPermission(permission);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer roleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.findByRoleIDAndPermission(roleID, permission);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.String permission, java.lang.Boolean isDefault)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRoleLocalService.findByDefaultAndPermission(permission,
            isDefault);
    }

    @Override
    public void removeByRoleIDAndPermission(java.lang.Integer liferayRoleID,
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRoleLocalService.removeByRoleIDAndPermission(liferayRoleID,
            permission);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRoleLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFRoleLocalService getWrappedLFRoleLocalService() {
        return _lfRoleLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFRoleLocalService(
        LFRoleLocalService lfRoleLocalService) {
        _lfRoleLocalService = lfRoleLocalService;
    }

    @Override
    public LFRoleLocalService getWrappedService() {
        return _lfRoleLocalService;
    }

    @Override
    public void setWrappedService(LFRoleLocalService lfRoleLocalService) {
        _lfRoleLocalService = lfRoleLocalService;
    }
}

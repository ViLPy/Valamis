package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFSeqPermissionsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFSeqPermissionsLocalService
 * @generated
 */
public class LFSeqPermissionsLocalServiceWrapper
    implements LFSeqPermissionsLocalService,
        ServiceWrapper<LFSeqPermissionsLocalService> {
    private LFSeqPermissionsLocalService _lfSeqPermissionsLocalService;

    public LFSeqPermissionsLocalServiceWrapper(
        LFSeqPermissionsLocalService lfSeqPermissionsLocalService) {
        _lfSeqPermissionsLocalService = lfSeqPermissionsLocalService;
    }

    /**
    * Adds the l f seq permissions to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSeqPermissions the l f seq permissions
    * @return the l f seq permissions that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions addLFSeqPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSeqPermissions lfSeqPermissions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.addLFSeqPermissions(lfSeqPermissions);
    }

    /**
    * Creates a new l f seq permissions with the primary key. Does not add the l f seq permissions to the database.
    *
    * @param id the primary key for the new l f seq permissions
    * @return the new l f seq permissions
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions createLFSeqPermissions(
        long id) {
        return _lfSeqPermissionsLocalService.createLFSeqPermissions(id);
    }

    /**
    * Deletes the l f seq permissions with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f seq permissions
    * @return the l f seq permissions that was removed
    * @throws PortalException if a l f seq permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions deleteLFSeqPermissions(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.deleteLFSeqPermissions(id);
    }

    /**
    * Deletes the l f seq permissions from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSeqPermissions the l f seq permissions
    * @return the l f seq permissions that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions deleteLFSeqPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSeqPermissions lfSeqPermissions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.deleteLFSeqPermissions(lfSeqPermissions);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSeqPermissionsLocalService.dynamicQuery();
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
        return _lfSeqPermissionsLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSeqPermissionsLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfSeqPermissionsLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfSeqPermissionsLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfSeqPermissionsLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions fetchLFSeqPermissions(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.fetchLFSeqPermissions(id);
    }

    /**
    * Returns the l f seq permissions with the primary key.
    *
    * @param id the primary key of the l f seq permissions
    * @return the l f seq permissions
    * @throws PortalException if a l f seq permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions getLFSeqPermissions(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.getLFSeqPermissions(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f seq permissionses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSeqPermissionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f seq permissionses
    * @param end the upper bound of the range of l f seq permissionses (not inclusive)
    * @return the range of l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> getLFSeqPermissionses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.getLFSeqPermissionses(start, end);
    }

    /**
    * Returns the number of l f seq permissionses.
    *
    * @return the number of l f seq permissionses
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFSeqPermissionsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.getLFSeqPermissionsesCount();
    }

    /**
    * Updates the l f seq permissions in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSeqPermissions the l f seq permissions
    * @return the l f seq permissions that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions updateLFSeqPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSeqPermissions lfSeqPermissions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.updateLFSeqPermissions(lfSeqPermissions);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfSeqPermissionsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSeqPermissionsLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSeqPermissionsLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFSeqPermissions createLFSequencingPermissions()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.createLFSequencingPermissions();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSeqPermissions> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSeqPermissionsLocalService.findBySequencingID(sequencingID);
    }

    @Override
    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSeqPermissionsLocalService.removeBySequencingID(sequencingID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSeqPermissionsLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFSeqPermissionsLocalService getWrappedLFSeqPermissionsLocalService() {
        return _lfSeqPermissionsLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFSeqPermissionsLocalService(
        LFSeqPermissionsLocalService lfSeqPermissionsLocalService) {
        _lfSeqPermissionsLocalService = lfSeqPermissionsLocalService;
    }

    @Override
    public LFSeqPermissionsLocalService getWrappedService() {
        return _lfSeqPermissionsLocalService;
    }

    @Override
    public void setWrappedService(
        LFSeqPermissionsLocalService lfSeqPermissionsLocalService) {
        _lfSeqPermissionsLocalService = lfSeqPermissionsLocalService;
    }
}

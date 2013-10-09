package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFSettingLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFSettingLocalService
 * @generated
 */
public class LFSettingLocalServiceWrapper implements LFSettingLocalService,
    ServiceWrapper<LFSettingLocalService> {
    private LFSettingLocalService _lfSettingLocalService;

    public LFSettingLocalServiceWrapper(
        LFSettingLocalService lfSettingLocalService) {
        _lfSettingLocalService = lfSettingLocalService;
    }

    /**
    * Adds the l f setting to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSetting the l f setting
    * @return the l f setting that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting addLFSetting(
        com.arcusys.learn.persistence.liferay.model.LFSetting lfSetting)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.addLFSetting(lfSetting);
    }

    /**
    * Creates a new l f setting with the primary key. Does not add the l f setting to the database.
    *
    * @param id the primary key for the new l f setting
    * @return the new l f setting
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting createLFSetting(
        long id) {
        return _lfSettingLocalService.createLFSetting(id);
    }

    /**
    * Deletes the l f setting with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f setting
    * @return the l f setting that was removed
    * @throws PortalException if a l f setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting deleteLFSetting(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.deleteLFSetting(id);
    }

    /**
    * Deletes the l f setting from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSetting the l f setting
    * @return the l f setting that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting deleteLFSetting(
        com.arcusys.learn.persistence.liferay.model.LFSetting lfSetting)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.deleteLFSetting(lfSetting);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSettingLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFSetting fetchLFSetting(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.fetchLFSetting(id);
    }

    /**
    * Returns the l f setting with the primary key.
    *
    * @param id the primary key of the l f setting
    * @return the l f setting
    * @throws PortalException if a l f setting with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting getLFSetting(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.getLFSetting(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f settings.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f settings
    * @param end the upper bound of the range of l f settings (not inclusive)
    * @return the range of l f settings
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSetting> getLFSettings(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.getLFSettings(start, end);
    }

    /**
    * Returns the number of l f settings.
    *
    * @return the number of l f settings
    * @throws SystemException if a system exception occurred
    */
    public int getLFSettingsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.getLFSettingsCount();
    }

    /**
    * Updates the l f setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSetting the l f setting
    * @return the l f setting that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting updateLFSetting(
        com.arcusys.learn.persistence.liferay.model.LFSetting lfSetting)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.updateLFSetting(lfSetting);
    }

    /**
    * Updates the l f setting in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSetting the l f setting
    * @param merge whether to merge the l f setting with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f setting that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSetting updateLFSetting(
        com.arcusys.learn.persistence.liferay.model.LFSetting lfSetting,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.updateLFSetting(lfSetting, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfSettingLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSettingLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSettingLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFSetting createLFSetting()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.createLFSetting();
    }

    public com.arcusys.learn.persistence.liferay.model.LFSetting findByKey(
        java.lang.String key)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingLocalService.findByKey(key);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSettingLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFSettingLocalService getWrappedLFSettingLocalService() {
        return _lfSettingLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFSettingLocalService(
        LFSettingLocalService lfSettingLocalService) {
        _lfSettingLocalService = lfSettingLocalService;
    }

    public LFSettingLocalService getWrappedService() {
        return _lfSettingLocalService;
    }

    public void setWrappedService(LFSettingLocalService lfSettingLocalService) {
        _lfSettingLocalService = lfSettingLocalService;
    }
}

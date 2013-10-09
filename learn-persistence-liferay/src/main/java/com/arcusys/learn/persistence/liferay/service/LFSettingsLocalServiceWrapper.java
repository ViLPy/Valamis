package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFSettingsLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFSettingsLocalService
 * @generated
 */
public class LFSettingsLocalServiceWrapper implements LFSettingsLocalService,
    ServiceWrapper<LFSettingsLocalService> {
    private LFSettingsLocalService _lfSettingsLocalService;

    public LFSettingsLocalServiceWrapper(
        LFSettingsLocalService lfSettingsLocalService) {
        _lfSettingsLocalService = lfSettingsLocalService;
    }

    /**
    * Adds the l f settings to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @return the l f settings that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings addLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.addLFSettings(lfSettings);
    }

    /**
    * Creates a new l f settings with the primary key. Does not add the l f settings to the database.
    *
    * @param id the primary key for the new l f settings
    * @return the new l f settings
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings createLFSettings(
        long id) {
        return _lfSettingsLocalService.createLFSettings(id);
    }

    /**
    * Deletes the l f settings with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings that was removed
    * @throws PortalException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings deleteLFSettings(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.deleteLFSettings(id);
    }

    /**
    * Deletes the l f settings from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @return the l f settings that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings deleteLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.deleteLFSettings(lfSettings);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfSettingsLocalService.dynamicQuery();
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
        return _lfSettingsLocalService.dynamicQuery(dynamicQuery);
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
        return _lfSettingsLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfSettingsLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _lfSettingsLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFSettings fetchLFSettings(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.fetchLFSettings(id);
    }

    /**
    * Returns the l f settings with the primary key.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings
    * @throws PortalException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings getLFSettings(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.getLFSettings(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f settingses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f settingses
    * @param end the upper bound of the range of l f settingses (not inclusive)
    * @return the range of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> getLFSettingses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.getLFSettingses(start, end);
    }

    /**
    * Returns the number of l f settingses.
    *
    * @return the number of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public int getLFSettingsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.getLFSettingsesCount();
    }

    /**
    * Updates the l f settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @return the l f settings that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings updateLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.updateLFSettings(lfSettings);
    }

    /**
    * Updates the l f settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @param merge whether to merge the l f settings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f settings that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSettings updateLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.updateLFSettings(lfSettings, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfSettingsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfSettingsLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfSettingsLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFSettings createLFSettings()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.createLFSettings();
    }

    public com.arcusys.learn.persistence.liferay.model.LFSettings findByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfSettingsLocalService.findByKey(key);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFSettingsLocalService getWrappedLFSettingsLocalService() {
        return _lfSettingsLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFSettingsLocalService(
        LFSettingsLocalService lfSettingsLocalService) {
        _lfSettingsLocalService = lfSettingsLocalService;
    }

    public LFSettingsLocalService getWrappedService() {
        return _lfSettingsLocalService;
    }

    public void setWrappedService(LFSettingsLocalService lfSettingsLocalService) {
        _lfSettingsLocalService = lfSettingsLocalService;
    }
}

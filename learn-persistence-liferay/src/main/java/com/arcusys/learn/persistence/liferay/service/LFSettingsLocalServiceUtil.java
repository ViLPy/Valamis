package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f settings local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFSettingsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSettingsLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSettingsLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFSettingsLocalServiceImpl
 * @generated
 */
public class LFSettingsLocalServiceUtil {
    private static LFSettingsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFSettingsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f settings to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @return the l f settings that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings addLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFSettings(lfSettings);
    }

    /**
    * Creates a new l f settings with the primary key. Does not add the l f settings to the database.
    *
    * @param id the primary key for the new l f settings
    * @return the new l f settings
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings createLFSettings(
        long id) {
        return getService().createLFSettings(id);
    }

    /**
    * Deletes the l f settings with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings that was removed
    * @throws PortalException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings deleteLFSettings(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSettings(id);
    }

    /**
    * Deletes the l f settings from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @return the l f settings that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings deleteLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSettings(lfSettings);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSettings fetchLFSettings(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFSettings(id);
    }

    /**
    * Returns the l f settings with the primary key.
    *
    * @param id the primary key of the l f settings
    * @return the l f settings
    * @throws PortalException if a l f settings with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings getLFSettings(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSettings(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSettings> getLFSettingses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSettingses(start, end);
    }

    /**
    * Returns the number of l f settingses.
    *
    * @return the number of l f settingses
    * @throws SystemException if a system exception occurred
    */
    public static int getLFSettingsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSettingsesCount();
    }

    /**
    * Updates the l f settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @return the l f settings that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings updateLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSettings(lfSettings);
    }

    /**
    * Updates the l f settings in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSettings the l f settings
    * @param merge whether to merge the l f settings with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f settings that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSettings updateLFSettings(
        com.arcusys.learn.persistence.liferay.model.LFSettings lfSettings,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSettings(lfSettings, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSettings createLFSettings()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFSettings();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSettings findByKey(
        java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSettingsException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByKey(key);
    }

    public static void clearService() {
        _service = null;
    }

    public static LFSettingsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFSettingsLocalService.class.getName());

            if (invokableLocalService instanceof LFSettingsLocalService) {
                _service = (LFSettingsLocalService) invokableLocalService;
            } else {
                _service = new LFSettingsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFSettingsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFSettingsLocalService service) {
    }
}

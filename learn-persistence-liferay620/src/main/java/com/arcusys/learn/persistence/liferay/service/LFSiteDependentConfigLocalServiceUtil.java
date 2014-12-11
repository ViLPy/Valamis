package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFSiteDependentConfig. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFSiteDependentConfigLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFSiteDependentConfigLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSiteDependentConfigLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFSiteDependentConfigLocalServiceImpl
 * @generated
 */
public class LFSiteDependentConfigLocalServiceUtil {
    private static LFSiteDependentConfigLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFSiteDependentConfigLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f site dependent config to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSiteDependentConfig the l f site dependent config
    * @return the l f site dependent config that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig addLFSiteDependentConfig(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFSiteDependentConfig(lfSiteDependentConfig);
    }

    /**
    * Creates a new l f site dependent config with the primary key. Does not add the l f site dependent config to the database.
    *
    * @param id the primary key for the new l f site dependent config
    * @return the new l f site dependent config
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig createLFSiteDependentConfig(
        long id) {
        return getService().createLFSiteDependentConfig(id);
    }

    /**
    * Deletes the l f site dependent config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config that was removed
    * @throws PortalException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig deleteLFSiteDependentConfig(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSiteDependentConfig(id);
    }

    /**
    * Deletes the l f site dependent config from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSiteDependentConfig the l f site dependent config
    * @return the l f site dependent config that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig deleteLFSiteDependentConfig(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSiteDependentConfig(lfSiteDependentConfig);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig fetchLFSiteDependentConfig(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFSiteDependentConfig(id);
    }

    /**
    * Returns the l f site dependent config with the primary key.
    *
    * @param id the primary key of the l f site dependent config
    * @return the l f site dependent config
    * @throws PortalException if a l f site dependent config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig getLFSiteDependentConfig(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSiteDependentConfig(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f site dependent configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSiteDependentConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f site dependent configs
    * @param end the upper bound of the range of l f site dependent configs (not inclusive)
    * @return the range of l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> getLFSiteDependentConfigs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSiteDependentConfigs(start, end);
    }

    /**
    * Returns the number of l f site dependent configs.
    *
    * @return the number of l f site dependent configs
    * @throws SystemException if a system exception occurred
    */
    public static int getLFSiteDependentConfigsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSiteDependentConfigsCount();
    }

    /**
    * Updates the l f site dependent config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSiteDependentConfig the l f site dependent config
    * @return the l f site dependent config that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig updateLFSiteDependentConfig(
        com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig lfSiteDependentConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSiteDependentConfig(lfSiteDependentConfig);
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

    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig createLFSiteDependentConfig()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFSiteDependentConfig();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findBySiteID(
        java.lang.Integer siteID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBySiteID(siteID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig> findByDataKey(
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByDataKey(dataKey);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig findBySiteIDAndDataKey(
        java.lang.Integer siteID, java.lang.String key)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findBySiteIDAndDataKey(siteID, key);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFSiteDependentConfigLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFSiteDependentConfigLocalService.class.getName());

            if (invokableLocalService instanceof LFSiteDependentConfigLocalService) {
                _service = (LFSiteDependentConfigLocalService) invokableLocalService;
            } else {
                _service = new LFSiteDependentConfigLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFSiteDependentConfigLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFSiteDependentConfigLocalService service) {
    }
}

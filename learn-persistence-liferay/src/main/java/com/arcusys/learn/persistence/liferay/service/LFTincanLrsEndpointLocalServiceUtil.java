package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f tincan lrs endpoint local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFTincanLrsEndpointLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsEndpointLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsEndpointLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFTincanLrsEndpointLocalServiceImpl
 * @generated
 */
public class LFTincanLrsEndpointLocalServiceUtil {
    private static LFTincanLrsEndpointLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFTincanLrsEndpointLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f tincan lrs endpoint to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint addLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFTincanLrsEndpoint(lfTincanLrsEndpoint);
    }

    /**
    * Creates a new l f tincan lrs endpoint with the primary key. Does not add the l f tincan lrs endpoint to the database.
    *
    * @param id the primary key for the new l f tincan lrs endpoint
    * @return the new l f tincan lrs endpoint
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint createLFTincanLrsEndpoint(
        long id) {
        return getService().createLFTincanLrsEndpoint(id);
    }

    /**
    * Deletes the l f tincan lrs endpoint with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was removed
    * @throws PortalException if a l f tincan lrs endpoint with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint deleteLFTincanLrsEndpoint(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFTincanLrsEndpoint(id);
    }

    /**
    * Deletes the l f tincan lrs endpoint from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint deleteLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFTincanLrsEndpoint(lfTincanLrsEndpoint);
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

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint fetchLFTincanLrsEndpoint(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFTincanLrsEndpoint(id);
    }

    /**
    * Returns the l f tincan lrs endpoint with the primary key.
    *
    * @param id the primary key of the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint
    * @throws PortalException if a l f tincan lrs endpoint with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint getLFTincanLrsEndpoint(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTincanLrsEndpoint(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs endpoints.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs endpoints
    * @param end the upper bound of the range of l f tincan lrs endpoints (not inclusive)
    * @return the range of l f tincan lrs endpoints
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint> getLFTincanLrsEndpoints(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTincanLrsEndpoints(start, end);
    }

    /**
    * Returns the number of l f tincan lrs endpoints.
    *
    * @return the number of l f tincan lrs endpoints
    * @throws SystemException if a system exception occurred
    */
    public static int getLFTincanLrsEndpointsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTincanLrsEndpointsCount();
    }

    /**
    * Updates the l f tincan lrs endpoint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @return the l f tincan lrs endpoint that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint updateLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFTincanLrsEndpoint(lfTincanLrsEndpoint);
    }

    /**
    * Updates the l f tincan lrs endpoint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsEndpoint the l f tincan lrs endpoint
    * @param merge whether to merge the l f tincan lrs endpoint with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan lrs endpoint that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint updateLFTincanLrsEndpoint(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint lfTincanLrsEndpoint,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFTincanLrsEndpoint(lfTincanLrsEndpoint, merge);
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

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint getEndpoint()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEndpoint();
    }

    public static void setEndpoint(java.lang.String endpoint,
        java.lang.String authType, java.lang.String key, java.lang.String secret)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().setEndpoint(endpoint, authType, key, secret);
    }

    public static void clearService() {
        _service = null;
    }

    public static LFTincanLrsEndpointLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFTincanLrsEndpointLocalService.class.getName());

            if (invokableLocalService instanceof LFTincanLrsEndpointLocalService) {
                _service = (LFTincanLrsEndpointLocalService) invokableLocalService;
            } else {
                _service = new LFTincanLrsEndpointLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFTincanLrsEndpointLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFTincanLrsEndpointLocalService service) {
    }
}

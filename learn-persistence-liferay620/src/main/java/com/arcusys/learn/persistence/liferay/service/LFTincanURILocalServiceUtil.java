package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFTincanURI. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFTincanURILocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURILocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanURILocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFTincanURILocalServiceImpl
 * @generated
 */
public class LFTincanURILocalServiceUtil {
    private static LFTincanURILocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFTincanURILocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f tincan u r i to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanURI the l f tincan u r i
    * @return the l f tincan u r i that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI addLFTincanURI(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFTincanURI(lfTincanURI);
    }

    /**
    * Creates a new l f tincan u r i with the primary key. Does not add the l f tincan u r i to the database.
    *
    * @param uri the primary key for the new l f tincan u r i
    * @return the new l f tincan u r i
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI createLFTincanURI(
        java.lang.String uri) {
        return getService().createLFTincanURI(uri);
    }

    /**
    * Deletes the l f tincan u r i with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i that was removed
    * @throws PortalException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI deleteLFTincanURI(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFTincanURI(uri);
    }

    /**
    * Deletes the l f tincan u r i from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanURI the l f tincan u r i
    * @return the l f tincan u r i that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI deleteLFTincanURI(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFTincanURI(lfTincanURI);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchLFTincanURI(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFTincanURI(uri);
    }

    /**
    * Returns the l f tincan u r i with the primary key.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i
    * @throws PortalException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI getLFTincanURI(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTincanURI(uri);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan u r is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan u r is
    * @param end the upper bound of the range of l f tincan u r is (not inclusive)
    * @return the range of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> getLFTincanURIs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTincanURIs(start, end);
    }

    /**
    * Returns the number of l f tincan u r is.
    *
    * @return the number of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public static int getLFTincanURIsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTincanURIsCount();
    }

    /**
    * Updates the l f tincan u r i in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanURI the l f tincan u r i
    * @return the l f tincan u r i that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI updateLFTincanURI(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFTincanURI(lfTincanURI);
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

    public static com.arcusys.learn.persistence.liferay.model.LFTincanURI findURI(
        java.lang.String objId, java.lang.String objType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findURI(objId, objType);
    }

    public static void clearService() {
        _service = null;
    }

    public static LFTincanURILocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFTincanURILocalService.class.getName());

            if (invokableLocalService instanceof LFTincanURILocalService) {
                _service = (LFTincanURILocalService) invokableLocalService;
            } else {
                _service = new LFTincanURILocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFTincanURILocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFTincanURILocalService service) {
    }
}

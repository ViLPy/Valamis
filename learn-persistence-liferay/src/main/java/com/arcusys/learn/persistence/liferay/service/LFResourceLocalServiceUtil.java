package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f resource local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFResourceLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFResourceLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFResourceLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFResourceLocalServiceImpl
 * @generated
 */
public class LFResourceLocalServiceUtil {
    private static LFResourceLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFResourceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f resource to the database. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @return the l f resource that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource addLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFResource(lfResource);
    }

    /**
    * Creates a new l f resource with the primary key. Does not add the l f resource to the database.
    *
    * @param id the primary key for the new l f resource
    * @return the new l f resource
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource createLFResource(
        long id) {
        return getService().createLFResource(id);
    }

    /**
    * Deletes the l f resource with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource that was removed
    * @throws PortalException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource deleteLFResource(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFResource(id);
    }

    /**
    * Deletes the l f resource from the database. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @return the l f resource that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource deleteLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFResource(lfResource);
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

    public static com.arcusys.learn.persistence.liferay.model.LFResource fetchLFResource(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFResource(id);
    }

    /**
    * Returns the l f resource with the primary key.
    *
    * @param id the primary key of the l f resource
    * @return the l f resource
    * @throws PortalException if a l f resource with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource getLFResource(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFResource(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f resources.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f resources
    * @param end the upper bound of the range of l f resources (not inclusive)
    * @return the range of l f resources
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> getLFResources(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFResources(start, end);
    }

    /**
    * Returns the number of l f resources.
    *
    * @return the number of l f resources
    * @throws SystemException if a system exception occurred
    */
    public static int getLFResourcesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFResourcesCount();
    }

    /**
    * Updates the l f resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @return the l f resource that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource updateLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFResource(lfResource);
    }

    /**
    * Updates the l f resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfResource the l f resource
    * @param merge whether to merge the l f resource with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f resource that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFResource updateLFResource(
        com.arcusys.learn.persistence.liferay.model.LFResource lfResource,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFResource(lfResource, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFResource createLFResource()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFResource();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageID(packageID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFResource> findByPackageIDAndResourceID(
        java.lang.Integer packageID, java.lang.String resourceID, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByPackageIDAndResourceID(packageID, resourceID, start,
            end);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFResourceLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFResourceLocalService.class.getName());

            if (invokableLocalService instanceof LFResourceLocalService) {
                _service = (LFResourceLocalService) invokableLocalService;
            } else {
                _service = new LFResourceLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFResourceLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFResourceLocalService service) {
    }
}

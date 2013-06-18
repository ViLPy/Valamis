package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f sequencing permissions local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFSequencingPermissionsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingPermissionsLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSequencingPermissionsLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFSequencingPermissionsLocalServiceImpl
 * @generated
 */
public class LFSequencingPermissionsLocalServiceUtil {
    private static LFSequencingPermissionsLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFSequencingPermissionsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f sequencing permissions to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingPermissions the l f sequencing permissions
    * @return the l f sequencing permissions that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions addLFSequencingPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions lfSequencingPermissions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFSequencingPermissions(lfSequencingPermissions);
    }

    /**
    * Creates a new l f sequencing permissions with the primary key. Does not add the l f sequencing permissions to the database.
    *
    * @param id the primary key for the new l f sequencing permissions
    * @return the new l f sequencing permissions
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions createLFSequencingPermissions(
        long id) {
        return getService().createLFSequencingPermissions(id);
    }

    /**
    * Deletes the l f sequencing permissions with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f sequencing permissions
    * @return the l f sequencing permissions that was removed
    * @throws PortalException if a l f sequencing permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions deleteLFSequencingPermissions(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSequencingPermissions(id);
    }

    /**
    * Deletes the l f sequencing permissions from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingPermissions the l f sequencing permissions
    * @return the l f sequencing permissions that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions deleteLFSequencingPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions lfSequencingPermissions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .deleteLFSequencingPermissions(lfSequencingPermissions);
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

    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions fetchLFSequencingPermissions(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFSequencingPermissions(id);
    }

    /**
    * Returns the l f sequencing permissions with the primary key.
    *
    * @param id the primary key of the l f sequencing permissions
    * @return the l f sequencing permissions
    * @throws PortalException if a l f sequencing permissions with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions getLFSequencingPermissions(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSequencingPermissions(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f sequencing permissionses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f sequencing permissionses
    * @param end the upper bound of the range of l f sequencing permissionses (not inclusive)
    * @return the range of l f sequencing permissionses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions> getLFSequencingPermissionses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSequencingPermissionses(start, end);
    }

    /**
    * Returns the number of l f sequencing permissionses.
    *
    * @return the number of l f sequencing permissionses
    * @throws SystemException if a system exception occurred
    */
    public static int getLFSequencingPermissionsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSequencingPermissionsesCount();
    }

    /**
    * Updates the l f sequencing permissions in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingPermissions the l f sequencing permissions
    * @return the l f sequencing permissions that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions updateLFSequencingPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions lfSequencingPermissions)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateLFSequencingPermissions(lfSequencingPermissions);
    }

    /**
    * Updates the l f sequencing permissions in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSequencingPermissions the l f sequencing permissions
    * @param merge whether to merge the l f sequencing permissions with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f sequencing permissions that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions updateLFSequencingPermissions(
        com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions lfSequencingPermissions,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateLFSequencingPermissions(lfSequencingPermissions, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions createLFSequencingPermissions()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFSequencingPermissions();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBySequencingID(sequencingID);
    }

    public static void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeBySequencingID(sequencingID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFSequencingPermissionsLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFSequencingPermissionsLocalService.class.getName());

            if (invokableLocalService instanceof LFSequencingPermissionsLocalService) {
                _service = (LFSequencingPermissionsLocalService) invokableLocalService;
            } else {
                _service = new LFSequencingPermissionsLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFSequencingPermissionsLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFSequencingPermissionsLocalService service) {
    }
}

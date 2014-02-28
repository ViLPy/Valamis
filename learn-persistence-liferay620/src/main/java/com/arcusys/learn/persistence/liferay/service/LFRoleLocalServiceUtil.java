package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFRole. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFRoleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFRoleLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRoleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFRoleLocalServiceImpl
 * @generated
 */
public class LFRoleLocalServiceUtil {
    private static LFRoleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f role to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRole the l f role
    * @return the l f role that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole addLFRole(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFRole(lfRole);
    }

    /**
    * Creates a new l f role with the primary key. Does not add the l f role to the database.
    *
    * @param id the primary key for the new l f role
    * @return the new l f role
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole createLFRole(
        long id) {
        return getService().createLFRole(id);
    }

    /**
    * Deletes the l f role with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f role
    * @return the l f role that was removed
    * @throws PortalException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole deleteLFRole(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFRole(id);
    }

    /**
    * Deletes the l f role from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRole the l f role
    * @return the l f role that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole deleteLFRole(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFRole(lfRole);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFRole fetchLFRole(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFRole(id);
    }

    /**
    * Returns the l f role with the primary key.
    *
    * @param id the primary key of the l f role
    * @return the l f role
    * @throws PortalException if a l f role with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole getLFRole(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRole(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> getLFRoles(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRoles(start, end);
    }

    /**
    * Returns the number of l f roles.
    *
    * @return the number of l f roles
    * @throws SystemException if a system exception occurred
    */
    public static int getLFRolesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRolesCount();
    }

    /**
    * Updates the l f role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRole the l f role
    * @return the l f role that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRole updateLFRole(
        com.arcusys.learn.persistence.liferay.model.LFRole lfRole)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFRole(lfRole);
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

    public static com.arcusys.learn.persistence.liferay.model.LFRole createLFRole()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFRole();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByPermission(
        java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPermission(permission);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByRoleIDAndPermission(
        java.lang.Integer roleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByRoleIDAndPermission(roleID, permission);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRole> findByDefaultAndPermission(
        java.lang.String permission, java.lang.Boolean isDefault)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByDefaultAndPermission(permission, isDefault);
    }

    public static void removeByRoleIDAndPermission(
        java.lang.Integer liferayRoleID, java.lang.String permission)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByRoleIDAndPermission(liferayRoleID, permission);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFRoleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFRoleLocalService.class.getName());

            if (invokableLocalService instanceof LFRoleLocalService) {
                _service = (LFRoleLocalService) invokableLocalService;
            } else {
                _service = new LFRoleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFRoleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFRoleLocalService service) {
    }
}

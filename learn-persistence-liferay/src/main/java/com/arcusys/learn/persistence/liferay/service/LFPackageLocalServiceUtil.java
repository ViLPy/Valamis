package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f package local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFPackageLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFPackageLocalServiceImpl
 * @generated
 */
public class LFPackageLocalServiceUtil {
    private static LFPackageLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFPackageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f package to the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @return the l f package that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage addLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFPackage(lfPackage);
    }

    /**
    * Creates a new l f package with the primary key. Does not add the l f package to the database.
    *
    * @param id the primary key for the new l f package
    * @return the new l f package
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage createLFPackage(
        long id) {
        return getService().createLFPackage(id);
    }

    /**
    * Deletes the l f package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package
    * @return the l f package that was removed
    * @throws PortalException if a l f package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage deleteLFPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPackage(id);
    }

    /**
    * Deletes the l f package from the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @return the l f package that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage deleteLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPackage(lfPackage);
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

    public static com.arcusys.learn.persistence.liferay.model.LFPackage fetchLFPackage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFPackage(id);
    }

    /**
    * Returns the l f package with the primary key.
    *
    * @param id the primary key of the l f package
    * @return the l f package
    * @throws PortalException if a l f package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage getLFPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackage(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f packages
    * @param end the upper bound of the range of l f packages (not inclusive)
    * @return the range of l f packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> getLFPackages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackages(start, end);
    }

    /**
    * Returns the number of l f packages.
    *
    * @return the number of l f packages
    * @throws SystemException if a system exception occurred
    */
    public static int getLFPackagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackagesCount();
    }

    /**
    * Updates the l f package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @return the l f package that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage updateLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFPackage(lfPackage);
    }

    /**
    * Updates the l f package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackage the l f package
    * @param merge whether to merge the l f package with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f package that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackage updateLFPackage(
        com.arcusys.learn.persistence.liferay.model.LFPackage lfPackage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFPackage(lfPackage, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFPackage createLFPackage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFPackage();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackage findByRefID(
        java.lang.Long refId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByRefID(refId);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> findByPackageID(
        java.lang.Long[] ids)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageID(ids);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> findByInstance(
        java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByInstance(courseIDs);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackage> findByCourseID(
        java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCourseID(courseID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFPackageLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFPackageLocalService.class.getName());

            if (invokableLocalService instanceof LFPackageLocalService) {
                _service = (LFPackageLocalService) invokableLocalService;
            } else {
                _service = new LFPackageLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFPackageLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFPackageLocalService service) {
    }
}

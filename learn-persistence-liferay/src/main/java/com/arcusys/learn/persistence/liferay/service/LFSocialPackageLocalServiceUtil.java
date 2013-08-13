package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f social package local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFSocialPackageLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackageLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSocialPackageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFSocialPackageLocalServiceImpl
 * @generated
 */
public class LFSocialPackageLocalServiceUtil {
    private static LFSocialPackageLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFSocialPackageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f social package to the database. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @return the l f social package that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage addLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFSocialPackage(lfSocialPackage);
    }

    /**
    * Creates a new l f social package with the primary key. Does not add the l f social package to the database.
    *
    * @param id the primary key for the new l f social package
    * @return the new l f social package
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage createLFSocialPackage(
        long id) {
        return getService().createLFSocialPackage(id);
    }

    /**
    * Deletes the l f social package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package that was removed
    * @throws PortalException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage deleteLFSocialPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSocialPackage(id);
    }

    /**
    * Deletes the l f social package from the database. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @return the l f social package that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage deleteLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFSocialPackage(lfSocialPackage);
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

    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchLFSocialPackage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFSocialPackage(id);
    }

    /**
    * Returns the l f social package with the primary key.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package
    * @throws PortalException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage getLFSocialPackage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSocialPackage(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f social packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @return the range of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> getLFSocialPackages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSocialPackages(start, end);
    }

    /**
    * Returns the number of l f social packages.
    *
    * @return the number of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static int getLFSocialPackagesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFSocialPackagesCount();
    }

    /**
    * Updates the l f social package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @return the l f social package that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage updateLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSocialPackage(lfSocialPackage);
    }

    /**
    * Updates the l f social package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfSocialPackage the l f social package
    * @param merge whether to merge the l f social package with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f social package that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage updateLFSocialPackage(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFSocialPackage(lfSocialPackage, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage createLFSocialPackage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFSocialPackage();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByAuthorID(authorID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFSocialPackageLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFSocialPackageLocalService.class.getName());

            if (invokableLocalService instanceof LFSocialPackageLocalService) {
                _service = (LFSocialPackageLocalService) invokableLocalService;
            } else {
                _service = new LFSocialPackageLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFSocialPackageLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFSocialPackageLocalService service) {
    }
}

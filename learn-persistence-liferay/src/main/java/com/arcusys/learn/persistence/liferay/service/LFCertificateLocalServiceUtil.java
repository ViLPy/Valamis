package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f certificate local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFCertificateLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFCertificateLocalServiceImpl
 * @generated
 */
public class LFCertificateLocalServiceUtil {
    private static LFCertificateLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFCertificateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f certificate to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @return the l f certificate that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate addLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFCertificate(lfCertificate);
    }

    /**
    * Creates a new l f certificate with the primary key. Does not add the l f certificate to the database.
    *
    * @param id the primary key for the new l f certificate
    * @return the new l f certificate
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate createLFCertificate(
        long id) {
        return getService().createLFCertificate(id);
    }

    /**
    * Deletes the l f certificate with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate that was removed
    * @throws PortalException if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate deleteLFCertificate(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFCertificate(id);
    }

    /**
    * Deletes the l f certificate from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @return the l f certificate that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate deleteLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFCertificate(lfCertificate);
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

    public static com.arcusys.learn.persistence.liferay.model.LFCertificate fetchLFCertificate(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFCertificate(id);
    }

    /**
    * Returns the l f certificate with the primary key.
    *
    * @param id the primary key of the l f certificate
    * @return the l f certificate
    * @throws PortalException if a l f certificate with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate getLFCertificate(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCertificate(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f certificates
    * @param end the upper bound of the range of l f certificates (not inclusive)
    * @return the range of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificate> getLFCertificates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCertificates(start, end);
    }

    /**
    * Returns the number of l f certificates.
    *
    * @return the number of l f certificates
    * @throws SystemException if a system exception occurred
    */
    public static int getLFCertificatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCertificatesCount();
    }

    /**
    * Updates the l f certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @return the l f certificate that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate updateLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFCertificate(lfCertificate);
    }

    /**
    * Updates the l f certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificate the l f certificate
    * @param merge whether to merge the l f certificate with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f certificate that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificate updateLFCertificate(
        com.arcusys.learn.persistence.liferay.model.LFCertificate lfCertificate,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFCertificate(lfCertificate, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFCertificate createLFCertificate()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFCertificate();
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFCertificateLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFCertificateLocalService.class.getName());

            if (invokableLocalService instanceof LFCertificateLocalService) {
                _service = (LFCertificateLocalService) invokableLocalService;
            } else {
                _service = new LFCertificateLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFCertificateLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFCertificateLocalService service) {
    }
}

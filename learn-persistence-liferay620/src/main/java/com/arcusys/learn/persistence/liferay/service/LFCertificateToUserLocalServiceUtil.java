package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFCertificateToUser. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFCertificateToUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateToUserLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateToUserLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFCertificateToUserLocalServiceImpl
 * @generated
 */
public class LFCertificateToUserLocalServiceUtil {
    private static LFCertificateToUserLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFCertificateToUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f certificate to user to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUser the l f certificate to user
    * @return the l f certificate to user that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser addLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFCertificateToUser(lfCertificateToUser);
    }

    /**
    * Creates a new l f certificate to user with the primary key. Does not add the l f certificate to user to the database.
    *
    * @param lfCertificateToUserPK the primary key for the new l f certificate to user
    * @return the new l f certificate to user
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser createLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK) {
        return getService().createLFCertificateToUser(lfCertificateToUserPK);
    }

    /**
    * Deletes the l f certificate to user with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user that was removed
    * @throws PortalException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser deleteLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFCertificateToUser(lfCertificateToUserPK);
    }

    /**
    * Deletes the l f certificate to user from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUser the l f certificate to user
    * @return the l f certificate to user that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser deleteLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFCertificateToUser(lfCertificateToUser);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser fetchLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFCertificateToUser(lfCertificateToUserPK);
    }

    /**
    * Returns the l f certificate to user with the primary key.
    *
    * @param lfCertificateToUserPK the primary key of the l f certificate to user
    * @return the l f certificate to user
    * @throws PortalException if a l f certificate to user with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser getLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK lfCertificateToUserPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCertificateToUser(lfCertificateToUserPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f certificate to users.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateToUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate to users
    * @param end the upper bound of the range of l f certificate to users (not inclusive)
    * @return the range of l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> getLFCertificateToUsers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCertificateToUsers(start, end);
    }

    /**
    * Returns the number of l f certificate to users.
    *
    * @return the number of l f certificate to users
    * @throws SystemException if a system exception occurred
    */
    public static int getLFCertificateToUsersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCertificateToUsersCount();
    }

    /**
    * Updates the l f certificate to user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateToUser the l f certificate to user
    * @return the l f certificate to user that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser updateLFCertificateToUser(
        com.arcusys.learn.persistence.liferay.model.LFCertificateToUser lfCertificateToUser)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFCertificateToUser(lfCertificateToUser);
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

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateToUser createLFCertificateUser(
        java.lang.Integer userId, java.lang.Integer certificateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFCertificateUser(userId, certificateId);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByCertificateID(
        java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCertificateID(certificateID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserID(
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByUserID(userID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateToUser> findByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByUserIDAndCertificateID(userID, certificateID);
    }

    public static void removeByUserIDAndCertificateID(
        java.lang.Integer userID, java.lang.Integer certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByUserIDAndCertificateID(userID, certificateID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFCertificateToUserLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFCertificateToUserLocalService.class.getName());

            if (invokableLocalService instanceof LFCertificateToUserLocalService) {
                _service = (LFCertificateToUserLocalService) invokableLocalService;
            } else {
                _service = new LFCertificateToUserLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFCertificateToUserLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFCertificateToUserLocalService service) {
    }
}

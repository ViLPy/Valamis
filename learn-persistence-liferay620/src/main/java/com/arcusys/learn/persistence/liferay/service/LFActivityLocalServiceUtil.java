package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFActivity. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFActivityLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFActivityLocalServiceImpl
 * @generated
 */
public class LFActivityLocalServiceUtil {
    private static LFActivityLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFActivityLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @return the l f activity that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity addLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFActivity(lfActivity);
    }

    /**
    * Creates a new l f activity with the primary key. Does not add the l f activity to the database.
    *
    * @param indexNumber the primary key for the new l f activity
    * @return the new l f activity
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity createLFActivity(
        long indexNumber) {
        return getService().createLFActivity(indexNumber);
    }

    /**
    * Deletes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity that was removed
    * @throws PortalException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity deleteLFActivity(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFActivity(indexNumber);
    }

    /**
    * Deletes the l f activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @return the l f activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity deleteLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFActivity(lfActivity);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFActivity fetchLFActivity(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFActivity(indexNumber);
    }

    /**
    * Returns the l f activity with the primary key.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity
    * @throws PortalException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity getLFActivity(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivity(indexNumber);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of l f activities
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> getLFActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivities(start, end);
    }

    /**
    * Returns the number of l f activities.
    *
    * @return the number of l f activities
    * @throws SystemException if a system exception occurred
    */
    public static int getLFActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivitiesCount();
    }

    /**
    * Updates the l f activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @return the l f activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivity updateLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFActivity(lfActivity);
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

    public static com.arcusys.learn.persistence.liferay.model.LFActivity createLFActivity()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFActivity();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageAndID(packageID, id);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageID(packageID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByPackageIDAndOrganizationID(packageID, organizationID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageIDAndParentID(packageID, parentID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFActivityLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFActivityLocalService.class.getName());

            if (invokableLocalService instanceof LFActivityLocalService) {
                _service = (LFActivityLocalService) invokableLocalService;
            } else {
                _service = new LFActivityLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFActivityLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFActivityLocalService service) {
    }
}

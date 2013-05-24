package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f course local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFCourseLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCourseLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCourseLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFCourseLocalServiceImpl
 * @generated
 */
public class LFCourseLocalServiceUtil {
    private static LFCourseLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFCourseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f course to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @return the l f course that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse addLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFCourse(lfCourse);
    }

    /**
    * Creates a new l f course with the primary key. Does not add the l f course to the database.
    *
    * @param id the primary key for the new l f course
    * @return the new l f course
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse createLFCourse(
        long id) {
        return getService().createLFCourse(id);
    }

    /**
    * Deletes the l f course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f course
    * @return the l f course that was removed
    * @throws PortalException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse deleteLFCourse(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFCourse(id);
    }

    /**
    * Deletes the l f course from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @return the l f course that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse deleteLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFCourse(lfCourse);
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

    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchLFCourse(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFCourse(id);
    }

    /**
    * Returns the l f course with the primary key.
    *
    * @param id the primary key of the l f course
    * @return the l f course
    * @throws PortalException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse getLFCourse(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCourse(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f courses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f courses
    * @param end the upper bound of the range of l f courses (not inclusive)
    * @return the range of l f courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> getLFCourses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCourses(start, end);
    }

    /**
    * Returns the number of l f courses.
    *
    * @return the number of l f courses
    * @throws SystemException if a system exception occurred
    */
    public static int getLFCoursesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFCoursesCount();
    }

    /**
    * Updates the l f course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @return the l f course that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse updateLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFCourse(lfCourse);
    }

    /**
    * Updates the l f course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @param merge whether to merge the l f course with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f course that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse updateLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFCourse(lfCourse, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFCourse createLFCourse()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFCourse();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCourse findByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCourseIdAndUserId(courseID, userID);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchByCourseIdAndUserId(courseID, userID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFCourseLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFCourseLocalService.class.getName());

            if (invokableLocalService instanceof LFCourseLocalService) {
                _service = (LFCourseLocalService) invokableLocalService;
            } else {
                _service = new LFCourseLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFCourseLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFCourseLocalService service) {
    }
}

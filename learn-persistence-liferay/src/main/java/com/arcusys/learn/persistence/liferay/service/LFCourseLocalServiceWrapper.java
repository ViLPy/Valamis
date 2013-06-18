package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFCourseLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFCourseLocalService
 * @generated
 */
public class LFCourseLocalServiceWrapper implements LFCourseLocalService,
    ServiceWrapper<LFCourseLocalService> {
    private LFCourseLocalService _lfCourseLocalService;

    public LFCourseLocalServiceWrapper(
        LFCourseLocalService lfCourseLocalService) {
        _lfCourseLocalService = lfCourseLocalService;
    }

    /**
    * Adds the l f course to the database. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @return the l f course that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse addLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.addLFCourse(lfCourse);
    }

    /**
    * Creates a new l f course with the primary key. Does not add the l f course to the database.
    *
    * @param id the primary key for the new l f course
    * @return the new l f course
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse createLFCourse(
        long id) {
        return _lfCourseLocalService.createLFCourse(id);
    }

    /**
    * Deletes the l f course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f course
    * @return the l f course that was removed
    * @throws PortalException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse deleteLFCourse(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.deleteLFCourse(id);
    }

    /**
    * Deletes the l f course from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @return the l f course that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse deleteLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.deleteLFCourse(lfCourse);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfCourseLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchLFCourse(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.fetchLFCourse(id);
    }

    /**
    * Returns the l f course with the primary key.
    *
    * @param id the primary key of the l f course
    * @return the l f course
    * @throws PortalException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse getLFCourse(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.getLFCourse(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> getLFCourses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.getLFCourses(start, end);
    }

    /**
    * Returns the number of l f courses.
    *
    * @return the number of l f courses
    * @throws SystemException if a system exception occurred
    */
    public int getLFCoursesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.getLFCoursesCount();
    }

    /**
    * Updates the l f course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @return the l f course that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse updateLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.updateLFCourse(lfCourse);
    }

    /**
    * Updates the l f course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfCourse the l f course
    * @param merge whether to merge the l f course with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f course that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse updateLFCourse(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.updateLFCourse(lfCourse, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfCourseLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfCourseLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfCourseLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCourse createLFCourse()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.createLFCourse();
    }

    public com.arcusys.learn.persistence.liferay.model.LFCourse findByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.findByCourseIdAndUserId(courseID, userID);
    }

    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfCourseLocalService.fetchByCourseIdAndUserId(courseID, userID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCourseLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFCourseLocalService getWrappedLFCourseLocalService() {
        return _lfCourseLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFCourseLocalService(
        LFCourseLocalService lfCourseLocalService) {
        _lfCourseLocalService = lfCourseLocalService;
    }

    public LFCourseLocalService getWrappedService() {
        return _lfCourseLocalService;
    }

    public void setWrappedService(LFCourseLocalService lfCourseLocalService) {
        _lfCourseLocalService = lfCourseLocalService;
    }
}

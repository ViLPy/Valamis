package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCourse;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f course service. This utility wraps {@link LFCoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCoursePersistence
 * @see LFCoursePersistenceImpl
 * @generated
 */
public class LFCourseUtil {
    private static LFCoursePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(LFCourse lfCourse) {
        getPersistence().clearCache(lfCourse);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFCourse> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFCourse> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFCourse> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFCourse update(LFCourse lfCourse, boolean merge)
        throws SystemException {
        return getPersistence().update(lfCourse, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFCourse update(LFCourse lfCourse, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfCourse, merge, serviceContext);
    }

    /**
    * Caches the l f course in the entity cache if it is enabled.
    *
    * @param lfCourse the l f course
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse) {
        getPersistence().cacheResult(lfCourse);
    }

    /**
    * Caches the l f courses in the entity cache if it is enabled.
    *
    * @param lfCourses the l f courses
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> lfCourses) {
        getPersistence().cacheResult(lfCourses);
    }

    /**
    * Creates a new l f course with the primary key. Does not add the l f course to the database.
    *
    * @param id the primary key for the new l f course
    * @return the new l f course
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f course
    * @return the l f course that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCourse updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfCourse, merge);
    }

    /**
    * Returns the l f course with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
    *
    * @param id the primary key of the l f course
    * @return the l f course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f course with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f course
    * @return the l f course, or <code>null</code> if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f course where courseID = &#63; and userID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the matching l f course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse findByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseIdAndUserId(courseID, userID);
    }

    /**
    * Returns the l f course where courseID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCourseIdAndUserId(courseID, userID);
    }

    /**
    * Returns the l f course where courseID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseIdAndUserId(courseID, userID, retrieveFromCache);
    }

    /**
    * Returns the l f course where grade = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
    *
    * @param grade the grade
    * @return the matching l f course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse findByGrade(
        java.lang.String grade)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGrade(grade);
    }

    /**
    * Returns the l f course where grade = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param grade the grade
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchByGrade(
        java.lang.String grade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGrade(grade);
    }

    /**
    * Returns the l f course where grade = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param grade the grade
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse fetchByGrade(
        java.lang.String grade, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGrade(grade, retrieveFromCache);
    }

    /**
    * Returns all the l f courses.
    *
    * @return the l f courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f courses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f courses
    * @param end the upper bound of the range of l f courses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f course where courseID = &#63; and userID = &#63; from the database.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the l f course that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse removeByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByCourseIdAndUserId(courseID, userID);
    }

    /**
    * Removes the l f course where grade = &#63; from the database.
    *
    * @param grade the grade
    * @return the l f course that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCourse removeByGrade(
        java.lang.String grade)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByGrade(grade);
    }

    /**
    * Removes all the l f courses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f courses where courseID = &#63; and userID = &#63;.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the number of matching l f courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseIdAndUserId(java.lang.Integer courseID,
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseIdAndUserId(courseID, userID);
    }

    /**
    * Returns the number of l f courses where grade = &#63;.
    *
    * @param grade the grade
    * @return the number of matching l f courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByGrade(java.lang.String grade)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGrade(grade);
    }

    /**
    * Returns the number of l f courses.
    *
    * @return the number of l f courses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFCoursePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFCoursePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFCoursePersistence.class.getName());

            ReferenceRegistry.registerReference(LFCourseUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFCoursePersistence persistence) {
    }
}

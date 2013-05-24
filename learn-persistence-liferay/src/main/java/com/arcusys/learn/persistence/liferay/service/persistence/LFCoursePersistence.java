package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCourse;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCoursePersistenceImpl
 * @see LFCourseUtil
 * @generated
 */
public interface LFCoursePersistence extends BasePersistence<LFCourse> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFCourseUtil} to access the l f course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f course in the entity cache if it is enabled.
    *
    * @param lfCourse the l f course
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse);

    /**
    * Caches the l f courses in the entity cache if it is enabled.
    *
    * @param lfCourses the l f courses
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> lfCourses);

    /**
    * Creates a new l f course with the primary key. Does not add the l f course to the database.
    *
    * @param id the primary key for the new l f course
    * @return the new l f course
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse create(long id);

    /**
    * Removes the l f course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f course
    * @return the l f course that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse remove(long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFCourse updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCourse lfCourse,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
    *
    * @param id the primary key of the l f course
    * @return the l f course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f course
    * @return the l f course, or <code>null</code> if a l f course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course where courseID = &#63; and userID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the matching l f course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse findByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course where courseID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course where courseID = &#63; and userID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course where grade = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCourseException} if it could not be found.
    *
    * @param grade the grade
    * @return the matching l f course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse findByGrade(
        java.lang.String grade)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course where grade = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param grade the grade
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchByGrade(
        java.lang.String grade)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f course where grade = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param grade the grade
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f course, or <code>null</code> if a matching l f course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse fetchByGrade(
        java.lang.String grade, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f courses.
    *
    * @return the l f courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCourse> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f course where courseID = &#63; and userID = &#63; from the database.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the l f course that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse removeByCourseIdAndUserId(
        java.lang.Integer courseID, java.lang.Integer userID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f course where grade = &#63; from the database.
    *
    * @param grade the grade
    * @return the l f course that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCourse removeByGrade(
        java.lang.String grade)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f courses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f courses where courseID = &#63; and userID = &#63;.
    *
    * @param courseID the course i d
    * @param userID the user i d
    * @return the number of matching l f courses
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseIdAndUserId(java.lang.Integer courseID,
        java.lang.Integer userID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f courses where grade = &#63;.
    *
    * @param grade the grade
    * @return the number of matching l f courses
    * @throws SystemException if a system exception occurred
    */
    public int countByGrade(java.lang.String grade)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f courses.
    *
    * @return the number of l f courses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

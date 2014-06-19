package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f certificate course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateCoursePersistenceImpl
 * @see LFCertificateCourseUtil
 * @generated
 */
public interface LFCertificateCoursePersistence extends BasePersistence<LFCertificateCourse> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFCertificateCourseUtil} to access the l f certificate course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f certificate courses where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCertificateID(
        java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate courses where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate courses
    * @param end the upper bound of the range of l f certificate courses (not inclusive)
    * @return the range of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCertificateID(
        java.lang.Long certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate courses where certificateID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param certificateID the certificate i d
    * @param start the lower bound of the range of l f certificate courses
    * @param end the upper bound of the range of l f certificate courses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCertificateID(
        java.lang.Long certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate courses before and after the current l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param lfCertificateCoursePK the primary key of the current l f certificate course
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse[] findByCertificateID_PrevAndNext(
        LFCertificateCoursePK lfCertificateCoursePK,
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate courses where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate courses where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate courses where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCourseID(
        java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate courses where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f certificate courses
    * @param end the upper bound of the range of l f certificate courses (not inclusive)
    * @return the range of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCourseID(
        java.lang.Long courseID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate courses where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f certificate courses
    * @param end the upper bound of the range of l f certificate courses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCourseID(
        java.lang.Long courseID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCourseID_First(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCourseID_First(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCourseID_Last(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCourseID_Last(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate courses before and after the current l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param lfCertificateCoursePK the primary key of the current l f certificate course
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse[] findByCourseID_PrevAndNext(
        LFCertificateCoursePK lfCertificateCoursePK, java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate courses where courseID = &#63; from the database.
    *
    * @param courseID the course i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseID(java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate courses where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the number of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseID(java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException} if it could not be found.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f certificate course where certificateID = &#63; and courseID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the l f certificate course that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse removeByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate courses where certificateID = &#63; and courseID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the number of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public int countByCertificateIDAndCourseID(java.lang.Long certificateID,
        java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f certificate course in the entity cache if it is enabled.
    *
    * @param lfCertificateCourse the l f certificate course
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateCourse lfCertificateCourse);

    /**
    * Caches the l f certificate courses in the entity cache if it is enabled.
    *
    * @param lfCertificateCourses the l f certificate courses
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> lfCertificateCourses);

    /**
    * Creates a new l f certificate course with the primary key. Does not add the l f certificate course to the database.
    *
    * @param lfCertificateCoursePK the primary key for the new l f certificate course
    * @return the new l f certificate course
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse create(
        LFCertificateCoursePK lfCertificateCoursePK);

    /**
    * Removes the l f certificate course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateCoursePK the primary key of the l f certificate course
    * @return the l f certificate course that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse remove(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateCourse lfCertificateCourse)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate course with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException} if it could not be found.
    *
    * @param lfCertificateCoursePK the primary key of the l f certificate course
    * @return the l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByPrimaryKey(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f certificate course with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfCertificateCoursePK the primary key of the l f certificate course
    * @return the l f certificate course, or <code>null</code> if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByPrimaryKey(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f certificate courses.
    *
    * @return the l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f certificate courses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate courses
    * @param end the upper bound of the range of l f certificate courses (not inclusive)
    * @return the range of l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f certificate courses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFCertificateCourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f certificate courses
    * @param end the upper bound of the range of l f certificate courses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f certificate courses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f certificate courses.
    *
    * @return the number of l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

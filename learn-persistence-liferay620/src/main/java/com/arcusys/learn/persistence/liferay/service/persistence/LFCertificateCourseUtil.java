package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f certificate course service. This utility wraps {@link LFCertificateCoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateCoursePersistence
 * @see LFCertificateCoursePersistenceImpl
 * @generated
 */
public class LFCertificateCourseUtil {
    private static LFCertificateCoursePersistence _persistence;

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
    public static void clearCache(LFCertificateCourse lfCertificateCourse) {
        getPersistence().clearCache(lfCertificateCourse);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFCertificateCourse> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFCertificateCourse> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFCertificateCourse> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFCertificateCourse update(
        LFCertificateCourse lfCertificateCourse) throws SystemException {
        return getPersistence().update(lfCertificateCourse);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFCertificateCourse update(
        LFCertificateCourse lfCertificateCourse, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfCertificateCourse, serviceContext);
    }

    /**
    * Returns all the l f certificate courses where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCertificateID(
        java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCertificateID(
        java.lang.Long certificateID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCertificateID(certificateID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCertificateID(
        java.lang.Long certificateID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID(certificateID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the first l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateID_First(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_First(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_Last(certificateID, orderByComparator);
    }

    /**
    * Returns the last l f certificate course in the ordered set where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateID_Last(
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateID_Last(certificateID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse[] findByCertificateID_PrevAndNext(
        LFCertificateCoursePK lfCertificateCoursePK,
        java.lang.Long certificateID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateID_PrevAndNext(lfCertificateCoursePK,
            certificateID, orderByComparator);
    }

    /**
    * Removes all the l f certificate courses where certificateID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCertificateID(certificateID);
    }

    /**
    * Returns the number of l f certificate courses where certificateID = &#63;.
    *
    * @param certificateID the certificate i d
    * @return the number of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateID(java.lang.Long certificateID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCertificateID(certificateID);
    }

    /**
    * Returns all the l f certificate courses where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCourseID(
        java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseID(courseID);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCourseID(
        java.lang.Long courseID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseID(courseID, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findByCourseID(
        java.lang.Long courseID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseID(courseID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCourseID_First(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseID_First(courseID, orderByComparator);
    }

    /**
    * Returns the first l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCourseID_First(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseID_First(courseID, orderByComparator);
    }

    /**
    * Returns the last l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCourseID_Last(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseID_Last(courseID, orderByComparator);
    }

    /**
    * Returns the last l f certificate course in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCourseID_Last(
        java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCourseID_Last(courseID, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse[] findByCourseID_PrevAndNext(
        LFCertificateCoursePK lfCertificateCoursePK, java.lang.Long courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseID_PrevAndNext(lfCertificateCoursePK, courseID,
            orderByComparator);
    }

    /**
    * Removes all the l f certificate courses where courseID = &#63; from the database.
    *
    * @param courseID the course i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCourseID(java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCourseID(courseID);
    }

    /**
    * Returns the number of l f certificate courses where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the number of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseID(java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseID(courseID);
    }

    /**
    * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException} if it could not be found.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the matching l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCertificateIDAndCourseID(certificateID, courseID);
    }

    /**
    * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateIDAndCourseID(certificateID, courseID);
    }

    /**
    * Returns the l f certificate course where certificateID = &#63; and courseID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f certificate course, or <code>null</code> if a matching l f certificate course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCertificateIDAndCourseID(certificateID, courseID,
            retrieveFromCache);
    }

    /**
    * Removes the l f certificate course where certificateID = &#63; and courseID = &#63; from the database.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the l f certificate course that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse removeByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByCertificateIDAndCourseID(certificateID, courseID);
    }

    /**
    * Returns the number of l f certificate courses where certificateID = &#63; and courseID = &#63;.
    *
    * @param certificateID the certificate i d
    * @param courseID the course i d
    * @return the number of matching l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByCertificateIDAndCourseID(
        java.lang.Long certificateID, java.lang.Long courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCertificateIDAndCourseID(certificateID, courseID);
    }

    /**
    * Caches the l f certificate course in the entity cache if it is enabled.
    *
    * @param lfCertificateCourse the l f certificate course
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFCertificateCourse lfCertificateCourse) {
        getPersistence().cacheResult(lfCertificateCourse);
    }

    /**
    * Caches the l f certificate courses in the entity cache if it is enabled.
    *
    * @param lfCertificateCourses the l f certificate courses
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> lfCertificateCourses) {
        getPersistence().cacheResult(lfCertificateCourses);
    }

    /**
    * Creates a new l f certificate course with the primary key. Does not add the l f certificate course to the database.
    *
    * @param lfCertificateCoursePK the primary key for the new l f certificate course
    * @return the new l f certificate course
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse create(
        LFCertificateCoursePK lfCertificateCoursePK) {
        return getPersistence().create(lfCertificateCoursePK);
    }

    /**
    * Removes the l f certificate course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfCertificateCoursePK the primary key of the l f certificate course
    * @return the l f certificate course that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse remove(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfCertificateCoursePK);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFCertificateCourse lfCertificateCourse)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfCertificateCourse);
    }

    /**
    * Returns the l f certificate course with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException} if it could not be found.
    *
    * @param lfCertificateCoursePK the primary key of the l f certificate course
    * @return the l f certificate course
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse findByPrimaryKey(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfCertificateCoursePK);
    }

    /**
    * Returns the l f certificate course with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfCertificateCoursePK the primary key of the l f certificate course
    * @return the l f certificate course, or <code>null</code> if a l f certificate course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFCertificateCourse fetchByPrimaryKey(
        LFCertificateCoursePK lfCertificateCoursePK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfCertificateCoursePK);
    }

    /**
    * Returns all the l f certificate courses.
    *
    * @return the l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFCertificateCourse> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f certificate courses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f certificate courses.
    *
    * @return the number of l f certificate courses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFCertificateCoursePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFCertificateCoursePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFCertificateCoursePersistence.class.getName());

            ReferenceRegistry.registerReference(LFCertificateCourseUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFCertificateCoursePersistence persistence) {
    }
}

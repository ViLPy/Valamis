package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuiz;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f quiz service. This utility wraps {@link LFQuizPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizPersistence
 * @see LFQuizPersistenceImpl
 * @generated
 */
public class LFQuizUtil {
    private static LFQuizPersistence _persistence;

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
    public static void clearCache(LFQuiz lfQuiz) {
        getPersistence().clearCache(lfQuiz);
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
    public static List<LFQuiz> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuiz> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuiz> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuiz update(LFQuiz lfQuiz) throws SystemException {
        return getPersistence().update(lfQuiz);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuiz update(LFQuiz lfQuiz, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfQuiz, serviceContext);
    }

    /**
    * Returns all the l f quizs where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseID);
    }

    /**
    * Returns a range of all the l f quizs where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer courseID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseID, start, end);
    }

    /**
    * Returns an ordered range of all the l f quizs where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer courseID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseId(courseID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz findByCourseId_First(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId_First(courseID, orderByComparator);
    }

    /**
    * Returns the first l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz, or <code>null</code> if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz fetchByCourseId_First(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseId_First(courseID, orderByComparator);
    }

    /**
    * Returns the last l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz findByCourseId_Last(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId_Last(courseID, orderByComparator);
    }

    /**
    * Returns the last l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz, or <code>null</code> if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz fetchByCourseId_Last(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCourseId_Last(courseID, orderByComparator);
    }

    /**
    * Returns the l f quizs before and after the current l f quiz in the ordered set where courseID = &#63;.
    *
    * @param id the primary key of the current l f quiz
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz[] findByCourseId_PrevAndNext(
        long id, java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseId_PrevAndNext(id, courseID, orderByComparator);
    }

    /**
    * Returns all the l f quizs where courseID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseIDs the course i ds
    * @return the matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseIDs);
    }

    /**
    * Returns a range of all the l f quizs where courseID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseIDs the course i ds
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIDs, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseIDs, start, end);
    }

    /**
    * Returns an ordered range of all the l f quizs where courseID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseIDs the course i ds
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIDs, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseId(courseIDs, start, end, orderByComparator);
    }

    /**
    * Removes all the l f quizs where courseID = &#63; from the database.
    *
    * @param courseID the course i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCourseId(java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCourseId(courseID);
    }

    /**
    * Returns the number of l f quizs where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the number of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseId(java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseId(courseID);
    }

    /**
    * Returns the number of l f quizs where courseID = any &#63;.
    *
    * @param courseIDs the course i ds
    * @return the number of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseId(java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseId(courseIDs);
    }

    /**
    * Caches the l f quiz in the entity cache if it is enabled.
    *
    * @param lfQuiz the l f quiz
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz) {
        getPersistence().cacheResult(lfQuiz);
    }

    /**
    * Caches the l f quizs in the entity cache if it is enabled.
    *
    * @param lfQuizs the l f quizs
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> lfQuizs) {
        getPersistence().cacheResult(lfQuizs);
    }

    /**
    * Creates a new l f quiz with the primary key. Does not add the l f quiz to the database.
    *
    * @param id the primary key for the new l f quiz
    * @return the new l f quiz
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f quiz with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuiz updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuiz);
    }

    /**
    * Returns the l f quiz with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizException} if it could not be found.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f quiz with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz, or <code>null</code> if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuiz fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f quizs.
    *
    * @return the l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f quizs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f quizs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f quizs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f quizs.
    *
    * @return the number of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuizPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuizPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuizPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuizUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuizPersistence persistence) {
    }
}

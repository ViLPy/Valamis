package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuestion;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f question service. This utility wraps {@link LFQuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionPersistence
 * @see LFQuestionPersistenceImpl
 * @generated
 */
public class LFQuestionUtil {
    private static LFQuestionPersistence _persistence;

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
    public static void clearCache(LFQuestion lfQuestion) {
        getPersistence().clearCache(lfQuestion);
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
    public static List<LFQuestion> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuestion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuestion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuestion update(LFQuestion lfQuestion)
        throws SystemException {
        return getPersistence().update(lfQuestion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuestion update(LFQuestion lfQuestion,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfQuestion, serviceContext);
    }

    /**
    * Returns all the l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @return the matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseIdAndCategoryId(courseId, categoryId);
    }

    /**
    * Returns a range of all the l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId(courseId, categoryId, start, end);
    }

    /**
    * Returns an ordered range of all the l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId(courseId, categoryId, start,
            end, orderByComparator);
    }

    /**
    * Returns the first l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a matching l f question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion findByCourseIdAndCategoryId_First(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId_First(courseId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the first l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question, or <code>null</code> if a matching l f question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion fetchByCourseIdAndCategoryId_First(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseIdAndCategoryId_First(courseId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the last l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a matching l f question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion findByCourseIdAndCategoryId_Last(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId_Last(courseId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the last l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question, or <code>null</code> if a matching l f question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion fetchByCourseIdAndCategoryId_Last(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseIdAndCategoryId_Last(courseId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the l f questions before and after the current l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param id the primary key of the current l f question
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion[] findByCourseIdAndCategoryId_PrevAndNext(
        long id, java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId_PrevAndNext(id, courseId,
            categoryId, orderByComparator);
    }

    /**
    * Returns all the l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @return the matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId(courseIds, categoryIds);
    }

    /**
    * Returns a range of all the l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId(courseIds, categoryIds, start,
            end);
    }

    /**
    * Returns an ordered range of all the l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndCategoryId(courseIds, categoryIds, start,
            end, orderByComparator);
    }

    /**
    * Removes all the l f questions where courseId = &#63; and categoryId = &#63; from the database.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCourseIdAndCategoryId(courseId, categoryId);
    }

    /**
    * Returns the number of l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @return the number of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseIdAndCategoryId(java.lang.Integer courseId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCourseIdAndCategoryId(courseId, categoryId);
    }

    /**
    * Returns the number of l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @return the number of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByCourseIdAndCategoryId(courseIds, categoryIds);
    }

    /**
    * Caches the l f question in the entity cache if it is enabled.
    *
    * @param lfQuestion the l f question
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion) {
        getPersistence().cacheResult(lfQuestion);
    }

    /**
    * Caches the l f questions in the entity cache if it is enabled.
    *
    * @param lfQuestions the l f questions
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> lfQuestions) {
        getPersistence().cacheResult(lfQuestions);
    }

    /**
    * Creates a new l f question with the primary key. Does not add the l f question to the database.
    *
    * @param id the primary key for the new l f question
    * @return the new l f question
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question
    * @return the l f question that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuestion);
    }

    /**
    * Returns the l f question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException} if it could not be found.
    *
    * @param id the primary key of the l f question
    * @return the l f question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f question with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f question
    * @return the l f question, or <code>null</code> if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestion fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f questions.
    *
    * @return the l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f questions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f questions.
    *
    * @return the number of l f questions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuestionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuestionPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuestionPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuestionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuestionPersistence persistence) {
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f quiz question service. This utility wraps {@link LFQuizQuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionPersistence
 * @see LFQuizQuestionPersistenceImpl
 * @generated
 */
public class LFQuizQuestionUtil {
    private static LFQuizQuestionPersistence _persistence;

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
    public static void clearCache(LFQuizQuestion lfQuizQuestion) {
        getPersistence().clearCache(lfQuizQuestion);
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
    public static List<LFQuizQuestion> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuizQuestion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuizQuestion> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuizQuestion update(LFQuizQuestion lfQuizQuestion)
        throws SystemException {
        return getPersistence().update(lfQuizQuestion);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuizQuestion update(LFQuizQuestion lfQuizQuestion,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfQuizQuestion, serviceContext);
    }

    /**
    * Returns all the l f quiz questions where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID(quizId);
    }

    /**
    * Returns a range of all the l f quiz questions where quizId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @return the range of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID(quizId, start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz questions where quizId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizID(quizId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizID_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID_First(quizId, orderByComparator);
    }

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizID_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizID_First(quizId, orderByComparator);
    }

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizID_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizID_Last(quizId, orderByComparator);
    }

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizID_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizID_Last(quizId, orderByComparator);
    }

    /**
    * Returns the l f quiz questions before and after the current l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param id the primary key of the current l f quiz question
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion[] findByQuizID_PrevAndNext(
        long id, java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizID_PrevAndNext(id, quizId, orderByComparator);
    }

    /**
    * Removes all the l f quiz questions where quizId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuizID(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuizID(quizId);
    }

    /**
    * Returns the number of l f quiz questions where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the number of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizID(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizID(quizId);
    }

    /**
    * Returns all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @return the matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizId, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizAndCategory(quizId, categoryId);
    }

    /**
    * Returns a range of all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @return the range of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizId, java.lang.Integer categoryId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizAndCategory(quizId, categoryId, start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizId, java.lang.Integer categoryId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizAndCategory(quizId, categoryId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizAndCategory_First(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizAndCategory_First(quizId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizAndCategory_First(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizAndCategory_First(quizId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizAndCategory_Last(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizAndCategory_Last(quizId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizAndCategory_Last(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizAndCategory_Last(quizId, categoryId,
            orderByComparator);
    }

    /**
    * Returns the l f quiz questions before and after the current l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param id the primary key of the current l f quiz question
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion[] findByQuizAndCategory_PrevAndNext(
        long id, java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizAndCategory_PrevAndNext(id, quizId, categoryId,
            orderByComparator);
    }

    /**
    * Removes all the l f quiz questions where quizId = &#63; and categoryId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuizAndCategory(java.lang.Integer quizId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuizAndCategory(quizId, categoryId);
    }

    /**
    * Returns the number of l f quiz questions where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @return the number of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizAndCategory(java.lang.Integer quizId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizAndCategory(quizId, categoryId);
    }

    /**
    * Caches the l f quiz question in the entity cache if it is enabled.
    *
    * @param lfQuizQuestion the l f quiz question
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion) {
        getPersistence().cacheResult(lfQuizQuestion);
    }

    /**
    * Caches the l f quiz questions in the entity cache if it is enabled.
    *
    * @param lfQuizQuestions the l f quiz questions
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> lfQuizQuestions) {
        getPersistence().cacheResult(lfQuizQuestions);
    }

    /**
    * Creates a new l f quiz question with the primary key. Does not add the l f quiz question to the database.
    *
    * @param id the primary key for the new l f quiz question
    * @return the new l f quiz question
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuizQuestion);
    }

    /**
    * Returns the l f quiz question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException} if it could not be found.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f quiz question with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question, or <code>null</code> if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f quiz questions.
    *
    * @return the l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f quiz questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @return the range of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz questions
    * @param end the upper bound of the range of l f quiz questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f quiz questions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f quiz questions.
    *
    * @return the number of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuizQuestionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuizQuestionPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuizQuestionPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuizQuestionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuizQuestionPersistence persistence) {
    }
}

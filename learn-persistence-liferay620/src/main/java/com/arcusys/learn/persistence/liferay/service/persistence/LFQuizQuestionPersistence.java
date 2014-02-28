package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f quiz question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionPersistenceImpl
 * @see LFQuizQuestionUtil
 * @generated
 */
public interface LFQuizQuestionPersistence extends BasePersistence<LFQuizQuestion> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFQuizQuestionUtil} to access the l f quiz question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f quiz questions where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizID(
        java.lang.Integer quizId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizID_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizID_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizID_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizID_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion[] findByQuizID_PrevAndNext(
        long id, java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz questions where quizId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByQuizID(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz questions where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the number of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public int countByQuizID(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quiz questions where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @return the matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizId, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizId, java.lang.Integer categoryId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findByQuizAndCategory(
        java.lang.Integer quizId, java.lang.Integer categoryId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizAndCategory_First(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizAndCategory_First(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByQuizAndCategory_Last(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question in the ordered set where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question, or <code>null</code> if a matching l f quiz question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByQuizAndCategory_Last(
        java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion[] findByQuizAndCategory_PrevAndNext(
        long id, java.lang.Integer quizId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz questions where quizId = &#63; and categoryId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByQuizAndCategory(java.lang.Integer quizId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz questions where quizId = &#63; and categoryId = &#63;.
    *
    * @param quizId the quiz ID
    * @param categoryId the category ID
    * @return the number of matching l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public int countByQuizAndCategory(java.lang.Integer quizId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f quiz question in the entity cache if it is enabled.
    *
    * @param lfQuizQuestion the l f quiz question
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion);

    /**
    * Caches the l f quiz questions in the entity cache if it is enabled.
    *
    * @param lfQuizQuestions the l f quiz questions
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> lfQuizQuestions);

    /**
    * Creates a new l f quiz question with the primary key. Does not add the l f quiz question to the database.
    *
    * @param id the primary key for the new l f quiz question
    * @return the new l f quiz question
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion create(
        long id);

    /**
    * Removes the l f quiz question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestion lfQuizQuestion)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException} if it could not be found.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz question with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz question
    * @return the l f quiz question, or <code>null</code> if a l f quiz question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestion fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quiz questions.
    *
    * @return the l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz questions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz questions.
    *
    * @return the number of l f quiz questions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

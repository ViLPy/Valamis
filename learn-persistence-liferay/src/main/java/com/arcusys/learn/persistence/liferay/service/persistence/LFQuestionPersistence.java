package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuestion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionPersistenceImpl
 * @see LFQuestionUtil
 * @generated
 */
public interface LFQuestionPersistence extends BasePersistence<LFQuestion> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFQuestionUtil} to access the l f question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f question in the entity cache if it is enabled.
    *
    * @param lfQuestion the l f question
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion);

    /**
    * Caches the l f questions in the entity cache if it is enabled.
    *
    * @param lfQuestions the l f questions
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> lfQuestions);

    /**
    * Creates a new l f question with the primary key. Does not add the l f question to the database.
    *
    * @param id the primary key for the new l f question
    * @return the new l f question
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion create(
        long id);

    /**
    * Removes the l f question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question
    * @return the l f question that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFQuestion updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuestion lfQuestion,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f question with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException} if it could not be found.
    *
    * @param id the primary key of the l f question
    * @return the l f question
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f question with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f question
    * @return the l f question, or <code>null</code> if a l f question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @return the matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer courseId, java.lang.Integer categoryId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuestion findByCourseIdAndCategoryId_First(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question, or <code>null</code> if a matching l f question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion fetchByCourseIdAndCategoryId_First(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuestion findByCourseIdAndCategoryId_Last(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f question in the ordered set where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question, or <code>null</code> if a matching l f question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestion fetchByCourseIdAndCategoryId_Last(
        java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuestion[] findByCourseIdAndCategoryId_PrevAndNext(
        long id, java.lang.Integer courseId, java.lang.Integer categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @return the matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findByCourseIdAndCategoryId(
        java.lang.Integer[] courseIds, java.lang.Integer[] categoryIds,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f questions.
    *
    * @return the l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @return the range of l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f questions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f questions
    * @param end the upper bound of the range of l f questions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f questions where courseId = &#63; and categoryId = &#63; from the database.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseIdAndCategoryId(java.lang.Integer courseId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f questions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f questions where courseId = &#63; and categoryId = &#63;.
    *
    * @param courseId the course ID
    * @param categoryId the category ID
    * @return the number of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseIdAndCategoryId(java.lang.Integer courseId,
        java.lang.Integer categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f questions where courseId = any &#63; and categoryId = any &#63;.
    *
    * @param courseIds the course IDs
    * @param categoryIds the category IDs
    * @return the number of matching l f questions
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseIdAndCategoryId(java.lang.Integer[] courseIds,
        java.lang.Integer[] categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f questions.
    *
    * @return the number of l f questions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

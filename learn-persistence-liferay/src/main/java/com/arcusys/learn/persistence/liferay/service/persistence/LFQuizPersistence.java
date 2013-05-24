package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuiz;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f quiz service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizPersistenceImpl
 * @see LFQuizUtil
 * @generated
 */
public interface LFQuizPersistence extends BasePersistence<LFQuiz> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFQuizUtil} to access the l f quiz persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f quiz in the entity cache if it is enabled.
    *
    * @param lfQuiz the l f quiz
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz);

    /**
    * Caches the l f quizs in the entity cache if it is enabled.
    *
    * @param lfQuizs the l f quizs
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> lfQuizs);

    /**
    * Creates a new l f quiz with the primary key. Does not add the l f quiz to the database.
    *
    * @param id the primary key for the new l f quiz
    * @return the new l f quiz
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz create(long id);

    /**
    * Removes the l f quiz with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz remove(long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFQuiz updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuiz lfQuiz, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizException} if it could not be found.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz
    * @return the l f quiz, or <code>null</code> if a l f quiz with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quizs where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quizs where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer courseID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quizs where courseID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseID the course i d
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer courseID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz findByCourseId_First(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz, or <code>null</code> if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz fetchByCourseId_First(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz findByCourseId_Last(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz in the ordered set where courseID = &#63;.
    *
    * @param courseID the course i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz, or <code>null</code> if a matching l f quiz could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuiz fetchByCourseId_Last(
        java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFQuiz[] findByCourseId_PrevAndNext(
        long id, java.lang.Integer courseID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quizs where courseID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIDs the course i ds
    * @return the matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quizs where courseID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIDs the course i ds
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIDs, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quizs where courseID = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIDs the course i ds
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findByCourseId(
        java.lang.Integer[] courseIDs, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quizs.
    *
    * @return the l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quizs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @return the range of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quizs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f quizs
    * @param end the upper bound of the range of l f quizs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuiz> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quizs where courseID = &#63; from the database.
    *
    * @param courseID the course i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseId(java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quizs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quizs where courseID = &#63;.
    *
    * @param courseID the course i d
    * @return the number of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseId(java.lang.Integer courseID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quizs where courseID = any &#63;.
    *
    * @param courseIDs the course i ds
    * @return the number of matching l f quizs
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseId(java.lang.Integer[] courseIDs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quizs.
    *
    * @return the number of l f quizs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

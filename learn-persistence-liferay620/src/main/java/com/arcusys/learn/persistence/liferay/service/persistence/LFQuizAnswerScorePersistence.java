package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f quiz answer score service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScorePersistenceImpl
 * @see LFQuizAnswerScoreUtil
 * @generated
 */
public interface LFQuizAnswerScorePersistence extends BasePersistence<LFQuizAnswerScore> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFQuizAnswerScoreUtil} to access the l f quiz answer score persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f quiz answer score in the entity cache if it is enabled.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore);

    /**
    * Caches the l f quiz answer scores in the entity cache if it is enabled.
    *
    * @param lfQuizAnswerScores the l f quiz answer scores
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> lfQuizAnswerScores);

    /**
    * Creates a new l f quiz answer score with the primary key. Does not add the l f quiz answer score to the database.
    *
    * @param answerId the primary key for the new l f quiz answer score
    * @return the new l f quiz answer score
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore create(
        long answerId);

    /**
    * Removes the l f quiz answer score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore remove(
        long answerId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz answer score with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException} if it could not be found.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore findByPrimaryKey(
        long answerId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz answer score with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score, or <code>null</code> if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore fetchByPrimaryKey(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quiz answer scores.
    *
    * @return the l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quiz answer scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz answer scores
    * @param end the upper bound of the range of l f quiz answer scores (not inclusive)
    * @return the range of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quiz answer scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizAnswerScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz answer scores
    * @param end the upper bound of the range of l f quiz answer scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz answer scores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz answer scores.
    *
    * @return the number of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

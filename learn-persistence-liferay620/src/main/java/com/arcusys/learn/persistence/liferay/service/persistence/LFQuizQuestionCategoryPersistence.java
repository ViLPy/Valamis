package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f quiz question category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionCategoryPersistenceImpl
 * @see LFQuizQuestionCategoryUtil
 * @generated
 */
public interface LFQuizQuestionCategoryPersistence extends BasePersistence<LFQuizQuestionCategory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFQuizQuestionCategoryUtil} to access the l f quiz question category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f quiz question categories where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @return the matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quiz question categories where quizId = &#63; and parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param start the lower bound of the range of l f quiz question categories
    * @param end the upper bound of the range of l f quiz question categories (not inclusive)
    * @return the range of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quiz question categories where quizId = &#63; and parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param start the lower bound of the range of l f quiz question categories
    * @param end the upper bound of the range of l f quiz question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizIdAndParentId_First(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizIdAndParentId_First(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizIdAndParentId_Last(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizIdAndParentId_Last(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz question categories before and after the current l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param id the primary key of the current l f quiz question category
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory[] findByQuizIdAndParentId_PrevAndNext(
        long id, java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz question categories where quizId = &#63; and parentId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByQuizIdAndParentId(java.lang.Integer quizId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz question categories where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @return the number of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public int countByQuizIdAndParentId(java.lang.Integer quizId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quiz question categories where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizId(
        java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quiz question categories where quizId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param start the lower bound of the range of l f quiz question categories
    * @param end the upper bound of the range of l f quiz question categories (not inclusive)
    * @return the range of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizId(
        java.lang.Integer quizId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quiz question categories where quizId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param start the lower bound of the range of l f quiz question categories
    * @param end the upper bound of the range of l f quiz question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizId(
        java.lang.Integer quizId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizId_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizId_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizId_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizId_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz question categories before and after the current l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param id the primary key of the current l f quiz question category
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory[] findByQuizId_PrevAndNext(
        long id, java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz question categories where quizId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByQuizId(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz question categories where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the number of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public int countByQuizId(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f quiz question category in the entity cache if it is enabled.
    *
    * @param lfQuizQuestionCategory the l f quiz question category
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory lfQuizQuestionCategory);

    /**
    * Caches the l f quiz question categories in the entity cache if it is enabled.
    *
    * @param lfQuizQuestionCategories the l f quiz question categories
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> lfQuizQuestionCategories);

    /**
    * Creates a new l f quiz question category with the primary key. Does not add the l f quiz question category to the database.
    *
    * @param id the primary key for the new l f quiz question category
    * @return the new l f quiz question category
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory create(
        long id);

    /**
    * Removes the l f quiz question category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz question category
    * @return the l f quiz question category that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory lfQuizQuestionCategory)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz question category with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException} if it could not be found.
    *
    * @param id the primary key of the l f quiz question category
    * @return the l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f quiz question category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz question category
    * @return the l f quiz question category, or <code>null</code> if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f quiz question categories.
    *
    * @return the l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f quiz question categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz question categories
    * @param end the upper bound of the range of l f quiz question categories (not inclusive)
    * @return the range of l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f quiz question categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestionCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz question categories
    * @param end the upper bound of the range of l f quiz question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f quiz question categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f quiz question categories.
    *
    * @return the number of l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

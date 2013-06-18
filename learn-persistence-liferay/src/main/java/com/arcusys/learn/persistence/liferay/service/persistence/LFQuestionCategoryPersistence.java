package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f question category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionCategoryPersistenceImpl
 * @see LFQuestionCategoryUtil
 * @generated
 */
public interface LFQuestionCategoryPersistence extends BasePersistence<LFQuestionCategory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFQuestionCategoryUtil} to access the l f question category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f question category in the entity cache if it is enabled.
    *
    * @param lfQuestionCategory the l f question category
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory);

    /**
    * Caches the l f question categories in the entity cache if it is enabled.
    *
    * @param lfQuestionCategories the l f question categories
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> lfQuestionCategories);

    /**
    * Creates a new l f question category with the primary key. Does not add the l f question category to the database.
    *
    * @param id the primary key for the new l f question category
    * @return the new l f question category
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory create(
        long id);

    /**
    * Removes the l f question category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f question category with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException} if it could not be found.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f question category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category, or <code>null</code> if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f question categories where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f question categories where courseId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseId the course ID
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @return the range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer courseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f question categories where courseId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseId the course ID
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer courseId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseId_First(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseId_First(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseId_Last(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseId_Last(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f question categories before and after the current l f question category in the ordered set where courseId = &#63;.
    *
    * @param id the primary key of the current l f question category
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory[] findByCourseId_PrevAndNext(
        long id, java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f question categories where courseId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @return the matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f question categories where courseId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @return the range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f question categories where courseId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f question categories where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @return the matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer courseId, java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f question categories where courseId = &#63; and parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @return the range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer courseId, java.lang.Integer parentId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f question categories where courseId = &#63; and parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer courseId, java.lang.Integer parentId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseIdAndParentId_First(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseIdAndParentId_First(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseIdAndParentId_Last(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseIdAndParentId_Last(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f question categories before and after the current l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param id the primary key of the current l f question category
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFQuestionCategory[] findByCourseIdAndParentId_PrevAndNext(
        long id, java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f question categories where courseId = any &#63; and parentId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param parentIds the parent IDs
    * @return the matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f question categories where courseId = any &#63; and parentId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param parentIds the parent IDs
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @return the range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f question categories where courseId = any &#63; and parentId = any &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param courseIds the course IDs
    * @param parentIds the parent IDs
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f question categories.
    *
    * @return the l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f question categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @return the range of l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f question categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f question categories
    * @param end the upper bound of the range of l f question categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f question categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f question categories where courseId = &#63; from the database.
    *
    * @param courseId the course ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseId(java.lang.Integer courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f question categories where courseId = &#63; and parentId = &#63; from the database.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseIdAndParentId(java.lang.Integer courseId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f question categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f question categories where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseId(java.lang.Integer courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f question categories where courseId = any &#63;.
    *
    * @param courseIds the course IDs
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseId(java.lang.Integer[] courseIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f question categories where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseIdAndParentId(java.lang.Integer courseId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f question categories where courseId = any &#63; and parentId = any &#63;.
    *
    * @param courseIds the course IDs
    * @param parentIds the parent IDs
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseIdAndParentId(java.lang.Integer[] courseIds,
        java.lang.Integer[] parentIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f question categories.
    *
    * @return the number of l f question categories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

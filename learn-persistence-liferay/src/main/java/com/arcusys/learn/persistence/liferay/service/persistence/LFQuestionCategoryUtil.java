package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f question category service. This utility wraps {@link LFQuestionCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionCategoryPersistence
 * @see LFQuestionCategoryPersistenceImpl
 * @generated
 */
public class LFQuestionCategoryUtil {
    private static LFQuestionCategoryPersistence _persistence;

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
    public static void clearCache(LFQuestionCategory lfQuestionCategory) {
        getPersistence().clearCache(lfQuestionCategory);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFQuestionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuestionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuestionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFQuestionCategory update(
        LFQuestionCategory lfQuestionCategory, boolean merge)
        throws SystemException {
        return getPersistence().update(lfQuestionCategory, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFQuestionCategory update(
        LFQuestionCategory lfQuestionCategory, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfQuestionCategory, merge, serviceContext);
    }

    /**
    * Caches the l f question category in the entity cache if it is enabled.
    *
    * @param lfQuestionCategory the l f question category
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory) {
        getPersistence().cacheResult(lfQuestionCategory);
    }

    /**
    * Caches the l f question categories in the entity cache if it is enabled.
    *
    * @param lfQuestionCategories the l f question categories
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> lfQuestionCategories) {
        getPersistence().cacheResult(lfQuestionCategories);
    }

    /**
    * Creates a new l f question category with the primary key. Does not add the l f question category to the database.
    *
    * @param id the primary key for the new l f question category
    * @return the new l f question category
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f question category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuestionCategory lfQuestionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuestionCategory, merge);
    }

    /**
    * Returns the l f question category with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException} if it could not be found.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f question category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f question category
    * @return the l f question category, or <code>null</code> if a l f question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f question categories where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer courseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseId);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer courseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseId, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer courseId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseId(courseId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseId_First(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId_First(courseId, orderByComparator);
    }

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseId_First(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseId_First(courseId, orderByComparator);
    }

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseId_Last(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId_Last(courseId, orderByComparator);
    }

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseId_Last(
        java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCourseId_Last(courseId, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory[] findByCourseId_PrevAndNext(
        long id, java.lang.Integer courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseId_PrevAndNext(id, courseId, orderByComparator);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseIds);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseId(courseIds, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseId(
        java.lang.Integer[] courseIds, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseId(courseIds, start, end, orderByComparator);
    }

    /**
    * Returns all the l f question categories where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @return the matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer courseId, java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseIdAndParentId(courseId, parentId);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer courseId, java.lang.Integer parentId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId(courseId, parentId, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer courseId, java.lang.Integer parentId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId(courseId, parentId, start, end,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseIdAndParentId_First(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId_First(courseId, parentId,
            orderByComparator);
    }

    /**
    * Returns the first l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseIdAndParentId_First(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseIdAndParentId_First(courseId, parentId,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory findByCourseIdAndParentId_Last(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId_Last(courseId, parentId,
            orderByComparator);
    }

    /**
    * Returns the last l f question category in the ordered set where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f question category, or <code>null</code> if a matching l f question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory fetchByCourseIdAndParentId_Last(
        java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCourseIdAndParentId_Last(courseId, parentId,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuestionCategory[] findByCourseIdAndParentId_PrevAndNext(
        long id, java.lang.Integer courseId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId_PrevAndNext(id, courseId,
            parentId, orderByComparator);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCourseIdAndParentId(courseIds, parentIds);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId(courseIds, parentIds, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCourseIdAndParentId(courseIds, parentIds, start, end,
            orderByComparator);
    }

    /**
    * Returns all the l f question categories.
    *
    * @return the l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuestionCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f question categories where courseId = &#63; from the database.
    *
    * @param courseId the course ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCourseId(java.lang.Integer courseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCourseId(courseId);
    }

    /**
    * Removes all the l f question categories where courseId = &#63; and parentId = &#63; from the database.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCourseIdAndParentId(java.lang.Integer courseId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCourseIdAndParentId(courseId, parentId);
    }

    /**
    * Removes all the l f question categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f question categories where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseId(java.lang.Integer courseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseId(courseId);
    }

    /**
    * Returns the number of l f question categories where courseId = any &#63;.
    *
    * @param courseIds the course IDs
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseId(java.lang.Integer[] courseIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseId(courseIds);
    }

    /**
    * Returns the number of l f question categories where courseId = &#63; and parentId = &#63;.
    *
    * @param courseId the course ID
    * @param parentId the parent ID
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseIdAndParentId(java.lang.Integer courseId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseIdAndParentId(courseId, parentId);
    }

    /**
    * Returns the number of l f question categories where courseId = any &#63; and parentId = any &#63;.
    *
    * @param courseIds the course IDs
    * @param parentIds the parent IDs
    * @return the number of matching l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseIdAndParentId(
        java.lang.Integer[] courseIds, java.lang.Integer[] parentIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseIdAndParentId(courseIds, parentIds);
    }

    /**
    * Returns the number of l f question categories.
    *
    * @return the number of l f question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuestionCategoryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuestionCategoryPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuestionCategoryPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuestionCategoryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFQuestionCategoryPersistence persistence) {
    }
}

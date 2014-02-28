package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f quiz question category service. This utility wraps {@link LFQuizQuestionCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionCategoryPersistence
 * @see LFQuizQuestionCategoryPersistenceImpl
 * @generated
 */
public class LFQuizQuestionCategoryUtil {
    private static LFQuizQuestionCategoryPersistence _persistence;

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
    public static void clearCache(LFQuizQuestionCategory lfQuizQuestionCategory) {
        getPersistence().clearCache(lfQuizQuestionCategory);
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
    public static List<LFQuizQuestionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuizQuestionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuizQuestionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuizQuestionCategory update(
        LFQuizQuestionCategory lfQuizQuestionCategory)
        throws SystemException {
        return getPersistence().update(lfQuizQuestionCategory);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuizQuestionCategory update(
        LFQuizQuestionCategory lfQuizQuestionCategory,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfQuizQuestionCategory, serviceContext);
    }

    /**
    * Returns all the l f quiz question categories where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @return the matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizIdAndParentId(quizId, parentId);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId(quizId, parentId, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId(quizId, parentId, start, end,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizIdAndParentId_First(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId_First(quizId, parentId,
            orderByComparator);
    }

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizIdAndParentId_First(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizIdAndParentId_First(quizId, parentId,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizIdAndParentId_Last(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId_Last(quizId, parentId,
            orderByComparator);
    }

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizIdAndParentId_Last(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizIdAndParentId_Last(quizId, parentId,
            orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory[] findByQuizIdAndParentId_PrevAndNext(
        long id, java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId_PrevAndNext(id, quizId, parentId,
            orderByComparator);
    }

    /**
    * Removes all the l f quiz question categories where quizId = &#63; and parentId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuizIdAndParentId(java.lang.Integer quizId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuizIdAndParentId(quizId, parentId);
    }

    /**
    * Returns the number of l f quiz question categories where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @return the number of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizIdAndParentId(java.lang.Integer quizId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizIdAndParentId(quizId, parentId);
    }

    /**
    * Returns all the l f quiz question categories where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizId(
        java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId(quizId);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizId(
        java.lang.Integer quizId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId(quizId, start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findByQuizId(
        java.lang.Integer quizId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizId(quizId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizId_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId_First(quizId, orderByComparator);
    }

    /**
    * Returns the first l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizId_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizId_First(quizId, orderByComparator);
    }

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByQuizId_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId_Last(quizId, orderByComparator);
    }

    /**
    * Returns the last l f quiz question category in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz question category, or <code>null</code> if a matching l f quiz question category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByQuizId_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizId_Last(quizId, orderByComparator);
    }

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
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory[] findByQuizId_PrevAndNext(
        long id, java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizId_PrevAndNext(id, quizId, orderByComparator);
    }

    /**
    * Removes all the l f quiz question categories where quizId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuizId(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuizId(quizId);
    }

    /**
    * Returns the number of l f quiz question categories where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the number of matching l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizId(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizId(quizId);
    }

    /**
    * Caches the l f quiz question category in the entity cache if it is enabled.
    *
    * @param lfQuizQuestionCategory the l f quiz question category
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory lfQuizQuestionCategory) {
        getPersistence().cacheResult(lfQuizQuestionCategory);
    }

    /**
    * Caches the l f quiz question categories in the entity cache if it is enabled.
    *
    * @param lfQuizQuestionCategories the l f quiz question categories
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> lfQuizQuestionCategories) {
        getPersistence().cacheResult(lfQuizQuestionCategories);
    }

    /**
    * Creates a new l f quiz question category with the primary key. Does not add the l f quiz question category to the database.
    *
    * @param id the primary key for the new l f quiz question category
    * @return the new l f quiz question category
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f quiz question category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz question category
    * @return the l f quiz question category that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory lfQuizQuestionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuizQuestionCategory);
    }

    /**
    * Returns the l f quiz question category with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException} if it could not be found.
    *
    * @param id the primary key of the l f quiz question category
    * @return the l f quiz question category
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestionCategoryException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f quiz question category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz question category
    * @return the l f quiz question category, or <code>null</code> if a l f quiz question category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f quiz question categories.
    *
    * @return the l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f quiz question categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f quiz question categories.
    *
    * @return the number of l f quiz question categories
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuizQuestionCategoryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuizQuestionCategoryPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuizQuestionCategoryPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuizQuestionCategoryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuizQuestionCategoryPersistence persistence) {
    }
}

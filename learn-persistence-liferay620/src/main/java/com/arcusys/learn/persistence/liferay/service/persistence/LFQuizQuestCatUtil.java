package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f quiz quest cat service. This utility wraps {@link LFQuizQuestCatPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestCatPersistence
 * @see LFQuizQuestCatPersistenceImpl
 * @generated
 */
public class LFQuizQuestCatUtil {
    private static LFQuizQuestCatPersistence _persistence;

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
    public static void clearCache(LFQuizQuestCat lfQuizQuestCat) {
        getPersistence().clearCache(lfQuizQuestCat);
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
    public static List<LFQuizQuestCat> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuizQuestCat> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuizQuestCat> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuizQuestCat update(LFQuizQuestCat lfQuizQuestCat)
        throws SystemException {
        return getPersistence().update(lfQuizQuestCat);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuizQuestCat update(LFQuizQuestCat lfQuizQuestCat,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfQuizQuestCat, serviceContext);
    }

    /**
    * Returns all the l f quiz quest cats where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @return the matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizIdAndParentId(quizId, parentId);
    }

    /**
    * Returns a range of all the l f quiz quest cats where quizId = &#63; and parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @return the range of matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId(quizId, parentId, start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz quest cats where quizId = &#63; and parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizIdAndParentId(
        java.lang.Integer quizId, java.lang.Integer parentId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId(quizId, parentId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat findByQuizIdAndParentId_First(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId_First(quizId, parentId,
            orderByComparator);
    }

    /**
    * Returns the first l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat fetchByQuizIdAndParentId_First(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizIdAndParentId_First(quizId, parentId,
            orderByComparator);
    }

    /**
    * Returns the last l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat findByQuizIdAndParentId_Last(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId_Last(quizId, parentId,
            orderByComparator);
    }

    /**
    * Returns the last l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat fetchByQuizIdAndParentId_Last(
        java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuizIdAndParentId_Last(quizId, parentId,
            orderByComparator);
    }

    /**
    * Returns the l f quiz quest cats before and after the current l f quiz quest cat in the ordered set where quizId = &#63; and parentId = &#63;.
    *
    * @param id the primary key of the current l f quiz quest cat
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat[] findByQuizIdAndParentId_PrevAndNext(
        long id, java.lang.Integer quizId, java.lang.Integer parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizIdAndParentId_PrevAndNext(id, quizId, parentId,
            orderByComparator);
    }

    /**
    * Removes all the l f quiz quest cats where quizId = &#63; and parentId = &#63; from the database.
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
    * Returns the number of l f quiz quest cats where quizId = &#63; and parentId = &#63;.
    *
    * @param quizId the quiz ID
    * @param parentId the parent ID
    * @return the number of matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizIdAndParentId(java.lang.Integer quizId,
        java.lang.Integer parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizIdAndParentId(quizId, parentId);
    }

    /**
    * Returns all the l f quiz quest cats where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizId(
        java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId(quizId);
    }

    /**
    * Returns a range of all the l f quiz quest cats where quizId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @return the range of matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizId(
        java.lang.Integer quizId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId(quizId, start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz quest cats where quizId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param quizId the quiz ID
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findByQuizId(
        java.lang.Integer quizId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizId(quizId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f quiz quest cat in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat findByQuizId_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId_First(quizId, orderByComparator);
    }

    /**
    * Returns the first l f quiz quest cat in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat fetchByQuizId_First(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizId_First(quizId, orderByComparator);
    }

    /**
    * Returns the last l f quiz quest cat in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat findByQuizId_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuizId_Last(quizId, orderByComparator);
    }

    /**
    * Returns the last l f quiz quest cat in the ordered set where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f quiz quest cat, or <code>null</code> if a matching l f quiz quest cat could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat fetchByQuizId_Last(
        java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByQuizId_Last(quizId, orderByComparator);
    }

    /**
    * Returns the l f quiz quest cats before and after the current l f quiz quest cat in the ordered set where quizId = &#63;.
    *
    * @param id the primary key of the current l f quiz quest cat
    * @param quizId the quiz ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat[] findByQuizId_PrevAndNext(
        long id, java.lang.Integer quizId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuizId_PrevAndNext(id, quizId, orderByComparator);
    }

    /**
    * Removes all the l f quiz quest cats where quizId = &#63; from the database.
    *
    * @param quizId the quiz ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuizId(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuizId(quizId);
    }

    /**
    * Returns the number of l f quiz quest cats where quizId = &#63;.
    *
    * @param quizId the quiz ID
    * @return the number of matching l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuizId(java.lang.Integer quizId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuizId(quizId);
    }

    /**
    * Caches the l f quiz quest cat in the entity cache if it is enabled.
    *
    * @param lfQuizQuestCat the l f quiz quest cat
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat lfQuizQuestCat) {
        getPersistence().cacheResult(lfQuizQuestCat);
    }

    /**
    * Caches the l f quiz quest cats in the entity cache if it is enabled.
    *
    * @param lfQuizQuestCats the l f quiz quest cats
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> lfQuizQuestCats) {
        getPersistence().cacheResult(lfQuizQuestCats);
    }

    /**
    * Creates a new l f quiz quest cat with the primary key. Does not add the l f quiz quest cat to the database.
    *
    * @param id the primary key for the new l f quiz quest cat
    * @return the new l f quiz quest cat
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f quiz quest cat with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f quiz quest cat
    * @return the l f quiz quest cat that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat lfQuizQuestCat)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuizQuestCat);
    }

    /**
    * Returns the l f quiz quest cat with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException} if it could not be found.
    *
    * @param id the primary key of the l f quiz quest cat
    * @return the l f quiz quest cat
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizQuestCatException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f quiz quest cat with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f quiz quest cat
    * @return the l f quiz quest cat, or <code>null</code> if a l f quiz quest cat with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f quiz quest cats.
    *
    * @return the l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f quiz quest cats.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @return the range of l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f quiz quest cats.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFQuizQuestCatModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f quiz quest cats
    * @param end the upper bound of the range of l f quiz quest cats (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f quiz quest cats from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f quiz quest cats.
    *
    * @return the number of l f quiz quest cats
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuizQuestCatPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuizQuestCatPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuizQuestCatPersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuizQuestCatUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuizQuestCatPersistence persistence) {
    }
}

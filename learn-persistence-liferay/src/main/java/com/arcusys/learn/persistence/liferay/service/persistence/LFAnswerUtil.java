package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFAnswer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f answer service. This utility wraps {@link LFAnswerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAnswerPersistence
 * @see LFAnswerPersistenceImpl
 * @generated
 */
public class LFAnswerUtil {
    private static LFAnswerPersistence _persistence;

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
    public static void clearCache(LFAnswer lfAnswer) {
        getPersistence().clearCache(lfAnswer);
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
    public static List<LFAnswer> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFAnswer update(LFAnswer lfAnswer, boolean merge)
        throws SystemException {
        return getPersistence().update(lfAnswer, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFAnswer update(LFAnswer lfAnswer, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfAnswer, merge, serviceContext);
    }

    /**
    * Caches the l f answer in the entity cache if it is enabled.
    *
    * @param lfAnswer the l f answer
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFAnswer lfAnswer) {
        getPersistence().cacheResult(lfAnswer);
    }

    /**
    * Caches the l f answers in the entity cache if it is enabled.
    *
    * @param lfAnswers the l f answers
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> lfAnswers) {
        getPersistence().cacheResult(lfAnswers);
    }

    /**
    * Creates a new l f answer with the primary key. Does not add the l f answer to the database.
    *
    * @param id the primary key for the new l f answer
    * @return the new l f answer
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f answer
    * @return the l f answer that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFAnswer updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFAnswer lfAnswer,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfAnswer, merge);
    }

    /**
    * Returns the l f answer with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException} if it could not be found.
    *
    * @param id the primary key of the l f answer
    * @return the l f answer
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f answer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f answer
    * @return the l f answer, or <code>null</code> if a l f answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f answers where questionId = &#63;.
    *
    * @param questionId the question ID
    * @return the matching l f answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findByQuestionId(
        java.lang.Integer questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuestionId(questionId);
    }

    /**
    * Returns a range of all the l f answers where questionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param questionId the question ID
    * @param start the lower bound of the range of l f answers
    * @param end the upper bound of the range of l f answers (not inclusive)
    * @return the range of matching l f answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findByQuestionId(
        java.lang.Integer questionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByQuestionId(questionId, start, end);
    }

    /**
    * Returns an ordered range of all the l f answers where questionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param questionId the question ID
    * @param start the lower bound of the range of l f answers
    * @param end the upper bound of the range of l f answers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findByQuestionId(
        java.lang.Integer questionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuestionId(questionId, start, end, orderByComparator);
    }

    /**
    * Returns the first l f answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f answer
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a matching l f answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer findByQuestionId_First(
        java.lang.Integer questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuestionId_First(questionId, orderByComparator);
    }

    /**
    * Returns the first l f answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f answer, or <code>null</code> if a matching l f answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer fetchByQuestionId_First(
        java.lang.Integer questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuestionId_First(questionId, orderByComparator);
    }

    /**
    * Returns the last l f answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f answer
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a matching l f answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer findByQuestionId_Last(
        java.lang.Integer questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuestionId_Last(questionId, orderByComparator);
    }

    /**
    * Returns the last l f answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f answer, or <code>null</code> if a matching l f answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer fetchByQuestionId_Last(
        java.lang.Integer questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByQuestionId_Last(questionId, orderByComparator);
    }

    /**
    * Returns the l f answers before and after the current l f answer in the ordered set where questionId = &#63;.
    *
    * @param id the primary key of the current l f answer
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f answer
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException if a l f answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAnswer[] findByQuestionId_PrevAndNext(
        long id, java.lang.Integer questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByQuestionId_PrevAndNext(id, questionId,
            orderByComparator);
    }

    /**
    * Returns all the l f answers.
    *
    * @return the l f answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f answers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f answers
    * @param end the upper bound of the range of l f answers (not inclusive)
    * @return the range of l f answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f answers.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f answers
    * @param end the upper bound of the range of l f answers (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAnswer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f answers where questionId = &#63; from the database.
    *
    * @param questionId the question ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByQuestionId(java.lang.Integer questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByQuestionId(questionId);
    }

    /**
    * Removes all the l f answers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f answers where questionId = &#63;.
    *
    * @param questionId the question ID
    * @return the number of matching l f answers
    * @throws SystemException if a system exception occurred
    */
    public static int countByQuestionId(java.lang.Integer questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByQuestionId(questionId);
    }

    /**
    * Returns the number of l f answers.
    *
    * @return the number of l f answers
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFAnswerPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFAnswerPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFAnswerPersistence.class.getName());

            ReferenceRegistry.registerReference(LFAnswerUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFAnswerPersistence persistence) {
    }
}

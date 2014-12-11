package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f quiz answer score service. This utility wraps {@link LFQuizAnswerScorePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScorePersistence
 * @see LFQuizAnswerScorePersistenceImpl
 * @generated
 */
public class LFQuizAnswerScoreUtil {
    private static LFQuizAnswerScorePersistence _persistence;

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
    public static void clearCache(LFQuizAnswerScore lfQuizAnswerScore) {
        getPersistence().clearCache(lfQuizAnswerScore);
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
    public static List<LFQuizAnswerScore> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFQuizAnswerScore> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFQuizAnswerScore> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFQuizAnswerScore update(LFQuizAnswerScore lfQuizAnswerScore)
        throws SystemException {
        return getPersistence().update(lfQuizAnswerScore);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFQuizAnswerScore update(
        LFQuizAnswerScore lfQuizAnswerScore, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfQuizAnswerScore, serviceContext);
    }

    /**
    * Caches the l f quiz answer score in the entity cache if it is enabled.
    *
    * @param lfQuizAnswerScore the l f quiz answer score
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore) {
        getPersistence().cacheResult(lfQuizAnswerScore);
    }

    /**
    * Caches the l f quiz answer scores in the entity cache if it is enabled.
    *
    * @param lfQuizAnswerScores the l f quiz answer scores
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> lfQuizAnswerScores) {
        getPersistence().cacheResult(lfQuizAnswerScores);
    }

    /**
    * Creates a new l f quiz answer score with the primary key. Does not add the l f quiz answer score to the database.
    *
    * @param answerId the primary key for the new l f quiz answer score
    * @return the new l f quiz answer score
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore create(
        long answerId) {
        return getPersistence().create(answerId);
    }

    /**
    * Removes the l f quiz answer score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore remove(
        long answerId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(answerId);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore lfQuizAnswerScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfQuizAnswerScore);
    }

    /**
    * Returns the l f quiz answer score with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException} if it could not be found.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore findByPrimaryKey(
        long answerId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(answerId);
    }

    /**
    * Returns the l f quiz answer score with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param answerId the primary key of the l f quiz answer score
    * @return the l f quiz answer score, or <code>null</code> if a l f quiz answer score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore fetchByPrimaryKey(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(answerId);
    }

    /**
    * Returns all the l f quiz answer scores.
    *
    * @return the l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f quiz answer scores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f quiz answer scores.
    *
    * @return the number of l f quiz answer scores
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFQuizAnswerScorePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFQuizAnswerScorePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFQuizAnswerScorePersistence.class.getName());

            ReferenceRegistry.registerReference(LFQuizAnswerScoreUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFQuizAnswerScorePersistence persistence) {
    }
}

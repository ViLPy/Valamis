package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f rule condition service. This utility wraps {@link LFRuleConditionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRuleConditionPersistence
 * @see LFRuleConditionPersistenceImpl
 * @generated
 */
public class LFRuleConditionUtil {
    private static LFRuleConditionPersistence _persistence;

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
    public static void clearCache(LFRuleCondition lfRuleCondition) {
        getPersistence().clearCache(lfRuleCondition);
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
    public static List<LFRuleCondition> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFRuleCondition> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFRuleCondition> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFRuleCondition update(LFRuleCondition lfRuleCondition)
        throws SystemException {
        return getPersistence().update(lfRuleCondition);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFRuleCondition update(LFRuleCondition lfRuleCondition,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfRuleCondition, serviceContext);
    }

    /**
    * Returns all the l f rule conditions where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @return the matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer rollupRuleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRollup(rollupRuleID);
    }

    /**
    * Returns a range of all the l f rule conditions where rollupRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param rollupRuleID the rollup rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer rollupRuleID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRollup(rollupRuleID, start, end);
    }

    /**
    * Returns an ordered range of all the l f rule conditions where rollupRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param rollupRuleID the rollup rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer rollupRuleID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRollup(rollupRuleID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByRollup_First(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRollup_First(rollupRuleID, orderByComparator);
    }

    /**
    * Returns the first l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByRollup_First(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRollup_First(rollupRuleID, orderByComparator);
    }

    /**
    * Returns the last l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByRollup_Last(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRollup_Last(rollupRuleID, orderByComparator);
    }

    /**
    * Returns the last l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByRollup_Last(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRollup_Last(rollupRuleID, orderByComparator);
    }

    /**
    * Returns the l f rule conditions before and after the current l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param id the primary key of the current l f rule condition
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition[] findByRollup_PrevAndNext(
        long id, java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRollup_PrevAndNext(id, rollupRuleID, orderByComparator);
    }

    /**
    * Removes all the l f rule conditions where rollupRuleID = &#63; from the database.
    *
    * @param rollupRuleID the rollup rule i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByRollup(java.lang.Integer rollupRuleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByRollup(rollupRuleID);
    }

    /**
    * Returns the number of l f rule conditions where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @return the number of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static int countByRollup(java.lang.Integer rollupRuleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByRollup(rollupRuleID);
    }

    /**
    * Returns all the l f rule conditions where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @return the matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer conditionRuleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCondition(conditionRuleID);
    }

    /**
    * Returns a range of all the l f rule conditions where conditionRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param conditionRuleID the condition rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer conditionRuleID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCondition(conditionRuleID, start, end);
    }

    /**
    * Returns an ordered range of all the l f rule conditions where conditionRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param conditionRuleID the condition rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer conditionRuleID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCondition(conditionRuleID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByCondition_First(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCondition_First(conditionRuleID, orderByComparator);
    }

    /**
    * Returns the first l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByCondition_First(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCondition_First(conditionRuleID, orderByComparator);
    }

    /**
    * Returns the last l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByCondition_Last(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCondition_Last(conditionRuleID, orderByComparator);
    }

    /**
    * Returns the last l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByCondition_Last(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCondition_Last(conditionRuleID, orderByComparator);
    }

    /**
    * Returns the l f rule conditions before and after the current l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param id the primary key of the current l f rule condition
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition[] findByCondition_PrevAndNext(
        long id, java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCondition_PrevAndNext(id, conditionRuleID,
            orderByComparator);
    }

    /**
    * Removes all the l f rule conditions where conditionRuleID = &#63; from the database.
    *
    * @param conditionRuleID the condition rule i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCondition(java.lang.Integer conditionRuleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCondition(conditionRuleID);
    }

    /**
    * Returns the number of l f rule conditions where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @return the number of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static int countByCondition(java.lang.Integer conditionRuleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCondition(conditionRuleID);
    }

    /**
    * Caches the l f rule condition in the entity cache if it is enabled.
    *
    * @param lfRuleCondition the l f rule condition
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition) {
        getPersistence().cacheResult(lfRuleCondition);
    }

    /**
    * Caches the l f rule conditions in the entity cache if it is enabled.
    *
    * @param lfRuleConditions the l f rule conditions
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> lfRuleConditions) {
        getPersistence().cacheResult(lfRuleConditions);
    }

    /**
    * Creates a new l f rule condition with the primary key. Does not add the l f rule condition to the database.
    *
    * @param id the primary key for the new l f rule condition
    * @return the new l f rule condition
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f rule condition with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfRuleCondition);
    }

    /**
    * Returns the l f rule condition with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException} if it could not be found.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f rule condition with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition, or <code>null</code> if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f rule conditions.
    *
    * @return the l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f rule conditions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f rule conditions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f rule conditions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f rule conditions.
    *
    * @return the number of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFRuleConditionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFRuleConditionPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFRuleConditionPersistence.class.getName());

            ReferenceRegistry.registerReference(LFRuleConditionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFRuleConditionPersistence persistence) {
    }
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f player scope rule service. This utility wraps {@link LFPlayerScopeRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPlayerScopeRulePersistence
 * @see LFPlayerScopeRulePersistenceImpl
 * @generated
 */
public class LFPlayerScopeRuleUtil {
    private static LFPlayerScopeRulePersistence _persistence;

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
    public static void clearCache(LFPlayerScopeRule lfPlayerScopeRule) {
        getPersistence().clearCache(lfPlayerScopeRule);
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
    public static List<LFPlayerScopeRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFPlayerScopeRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFPlayerScopeRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFPlayerScopeRule update(
        LFPlayerScopeRule lfPlayerScopeRule, boolean merge)
        throws SystemException {
        return getPersistence().update(lfPlayerScopeRule, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFPlayerScopeRule update(
        LFPlayerScopeRule lfPlayerScopeRule, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfPlayerScopeRule, merge, serviceContext);
    }

    /**
    * Caches the l f player scope rule in the entity cache if it is enabled.
    *
    * @param lfPlayerScopeRule the l f player scope rule
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule) {
        getPersistence().cacheResult(lfPlayerScopeRule);
    }

    /**
    * Caches the l f player scope rules in the entity cache if it is enabled.
    *
    * @param lfPlayerScopeRules the l f player scope rules
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> lfPlayerScopeRules) {
        getPersistence().cacheResult(lfPlayerScopeRules);
    }

    /**
    * Creates a new l f player scope rule with the primary key. Does not add the l f player scope rule to the database.
    *
    * @param id the primary key for the new l f player scope rule
    * @return the new l f player scope rule
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f player scope rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfPlayerScopeRule, merge);
    }

    /**
    * Returns the l f player scope rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException} if it could not be found.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f player scope rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule, or <code>null</code> if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f player scope rules where playerID = &#63;.
    *
    * @param playerID the player i d
    * @return the matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPlayerID(playerID);
    }

    /**
    * Returns a range of all the l f player scope rules where playerID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param playerID the player i d
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @return the range of matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPlayerID(playerID, start, end);
    }

    /**
    * Returns an ordered range of all the l f player scope rules where playerID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param playerID the player i d
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlayerID(playerID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule findByPlayerID_First(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPlayerID_First(playerID, orderByComparator);
    }

    /**
    * Returns the first l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f player scope rule, or <code>null</code> if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchByPlayerID_First(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByPlayerID_First(playerID, orderByComparator);
    }

    /**
    * Returns the last l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule findByPlayerID_Last(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPlayerID_Last(playerID, orderByComparator);
    }

    /**
    * Returns the last l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f player scope rule, or <code>null</code> if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchByPlayerID_Last(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPlayerID_Last(playerID, orderByComparator);
    }

    /**
    * Returns the l f player scope rules before and after the current l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param id the primary key of the current l f player scope rule
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule[] findByPlayerID_PrevAndNext(
        long id, java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByPlayerID_PrevAndNext(id, playerID, orderByComparator);
    }

    /**
    * Returns all the l f player scope rules.
    *
    * @return the l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f player scope rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @return the range of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f player scope rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f player scope rules where playerID = &#63; from the database.
    *
    * @param playerID the player i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByPlayerID(java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByPlayerID(playerID);
    }

    /**
    * Removes all the l f player scope rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f player scope rules where playerID = &#63;.
    *
    * @param playerID the player i d
    * @return the number of matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static int countByPlayerID(java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByPlayerID(playerID);
    }

    /**
    * Returns the number of l f player scope rules.
    *
    * @return the number of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFPlayerScopeRulePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFPlayerScopeRulePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFPlayerScopeRulePersistence.class.getName());

            ReferenceRegistry.registerReference(LFPlayerScopeRuleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFPlayerScopeRulePersistence persistence) {
    }
}

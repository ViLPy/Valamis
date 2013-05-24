package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFConditionRule;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f condition rule service. This utility wraps {@link LFConditionRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConditionRulePersistence
 * @see LFConditionRulePersistenceImpl
 * @generated
 */
public class LFConditionRuleUtil {
    private static LFConditionRulePersistence _persistence;

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
    public static void clearCache(LFConditionRule lfConditionRule) {
        getPersistence().clearCache(lfConditionRule);
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
    public static List<LFConditionRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFConditionRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFConditionRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFConditionRule update(LFConditionRule lfConditionRule,
        boolean merge) throws SystemException {
        return getPersistence().update(lfConditionRule, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFConditionRule update(LFConditionRule lfConditionRule,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfConditionRule, merge, serviceContext);
    }

    /**
    * Caches the l f condition rule in the entity cache if it is enabled.
    *
    * @param lfConditionRule the l f condition rule
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule) {
        getPersistence().cacheResult(lfConditionRule);
    }

    /**
    * Caches the l f condition rules in the entity cache if it is enabled.
    *
    * @param lfConditionRules the l f condition rules
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> lfConditionRules) {
        getPersistence().cacheResult(lfConditionRules);
    }

    /**
    * Creates a new l f condition rule with the primary key. Does not add the l f condition rule to the database.
    *
    * @param id the primary key for the new l f condition rule
    * @return the new l f condition rule
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f condition rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfConditionRule, merge);
    }

    /**
    * Returns the l f condition rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException} if it could not be found.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f condition rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule, or <code>null</code> if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @return the matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndRuleType(sequencingID, ruleType);
    }

    /**
    * Returns a range of all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param start the lower bound of the range of l f condition rules
    * @param end the upper bound of the range of l f condition rules (not inclusive)
    * @return the range of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndRuleType(sequencingID, ruleType,
            start, end);
    }

    /**
    * Returns an ordered range of all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param start the lower bound of the range of l f condition rules
    * @param end the upper bound of the range of l f condition rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndRuleType(sequencingID, ruleType,
            start, end, orderByComparator);
    }

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingIDAndRuleType_First(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndRuleType_First(sequencingID, ruleType,
            orderByComparator);
    }

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingIDAndRuleType_First(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingIDAndRuleType_First(sequencingID,
            ruleType, orderByComparator);
    }

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingIDAndRuleType_Last(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndRuleType_Last(sequencingID, ruleType,
            orderByComparator);
    }

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingIDAndRuleType_Last(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingIDAndRuleType_Last(sequencingID, ruleType,
            orderByComparator);
    }

    /**
    * Returns the l f condition rules before and after the current l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param id the primary key of the current l f condition rule
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule[] findBySequencingIDAndRuleType_PrevAndNext(
        long id, java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndRuleType_PrevAndNext(id, sequencingID,
            ruleType, orderByComparator);
    }

    /**
    * Returns all the l f condition rules where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID);
    }

    /**
    * Returns a range of all the l f condition rules where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f condition rules
    * @param end the upper bound of the range of l f condition rules (not inclusive)
    * @return the range of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID, start, end);
    }

    /**
    * Returns an ordered range of all the l f condition rules where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f condition rules
    * @param end the upper bound of the range of l f condition rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID(sequencingID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_First(sequencingID, orderByComparator);
    }

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID_First(sequencingID, orderByComparator);
    }

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_Last(sequencingID, orderByComparator);
    }

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID_Last(sequencingID, orderByComparator);
    }

    /**
    * Returns the l f condition rules before and after the current l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param id the primary key of the current l f condition rule
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFConditionRule[] findBySequencingID_PrevAndNext(
        long id, java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_PrevAndNext(id, sequencingID,
            orderByComparator);
    }

    /**
    * Returns all the l f condition rules.
    *
    * @return the l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f condition rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f condition rules
    * @param end the upper bound of the range of l f condition rules (not inclusive)
    * @return the range of l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f condition rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f condition rules
    * @param end the upper bound of the range of l f condition rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f condition rules where sequencingID = &#63; and ruleType = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySequencingIDAndRuleType(sequencingID, ruleType);
    }

    /**
    * Removes all the l f condition rules where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySequencingID(sequencingID);
    }

    /**
    * Removes all the l f condition rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f condition rules where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @return the number of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBySequencingIDAndRuleType(sequencingID, ruleType);
    }

    /**
    * Returns the number of l f condition rules where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySequencingID(sequencingID);
    }

    /**
    * Returns the number of l f condition rules.
    *
    * @return the number of l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFConditionRulePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFConditionRulePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFConditionRulePersistence.class.getName());

            ReferenceRegistry.registerReference(LFConditionRuleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFConditionRulePersistence persistence) {
    }
}

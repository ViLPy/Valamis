package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFConditionRule;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f condition rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConditionRulePersistenceImpl
 * @see LFConditionRuleUtil
 * @generated
 */
public interface LFConditionRulePersistence extends BasePersistence<LFConditionRule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFConditionRuleUtil} to access the l f condition rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f condition rule in the entity cache if it is enabled.
    *
    * @param lfConditionRule the l f condition rule
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule);

    /**
    * Caches the l f condition rules in the entity cache if it is enabled.
    *
    * @param lfConditionRules the l f condition rules
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> lfConditionRules);

    /**
    * Creates a new l f condition rule with the primary key. Does not add the l f condition rule to the database.
    *
    * @param id the primary key for the new l f condition rule
    * @return the new l f condition rule
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule create(
        long id);

    /**
    * Removes the l f condition rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFConditionRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f condition rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException} if it could not be found.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f condition rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule, or <code>null</code> if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f condition rules where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @return the matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingIDAndRuleType_First(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingIDAndRuleType_First(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingIDAndRuleType_Last(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingIDAndRuleType_Last(
        java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule[] findBySequencingIDAndRuleType_PrevAndNext(
        long id, java.lang.Integer sequencingID, java.lang.String ruleType,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f condition rules where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule findBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f condition rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f condition rule, or <code>null</code> if a matching l f condition rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule[] findBySequencingID_PrevAndNext(
        long id, java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFConditionRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f condition rules.
    *
    * @return the l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f condition rules where sequencingID = &#63; and ruleType = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @throws SystemException if a system exception occurred
    */
    public void removeBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f condition rules where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @throws SystemException if a system exception occurred
    */
    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f condition rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f condition rules where sequencingID = &#63; and ruleType = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param ruleType the rule type
    * @return the number of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingIDAndRuleType(java.lang.Integer sequencingID,
        java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f condition rules where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f condition rules.
    *
    * @return the number of l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

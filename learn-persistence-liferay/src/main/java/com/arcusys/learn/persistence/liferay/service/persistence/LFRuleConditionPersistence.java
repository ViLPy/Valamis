package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f rule condition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRuleConditionPersistenceImpl
 * @see LFRuleConditionUtil
 * @generated
 */
public interface LFRuleConditionPersistence extends BasePersistence<LFRuleCondition> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFRuleConditionUtil} to access the l f rule condition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f rule condition in the entity cache if it is enabled.
    *
    * @param lfRuleCondition the l f rule condition
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition);

    /**
    * Caches the l f rule conditions in the entity cache if it is enabled.
    *
    * @param lfRuleConditions the l f rule conditions
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> lfRuleConditions);

    /**
    * Creates a new l f rule condition with the primary key. Does not add the l f rule condition to the database.
    *
    * @param id the primary key for the new l f rule condition
    * @return the new l f rule condition
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition create(
        long id);

    /**
    * Removes the l f rule condition with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f rule condition with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException} if it could not be found.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f rule condition with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition, or <code>null</code> if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f rule conditions where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @return the matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer rollupRuleID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f rule conditions where rollupRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param rollupRuleID the rollup rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer rollupRuleID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f rule conditions where rollupRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param rollupRuleID the rollup rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer rollupRuleID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByRollup_First(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByRollup_First(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByRollup_Last(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f rule condition in the ordered set where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByRollup_Last(
        java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition[] findByRollup_PrevAndNext(
        long id, java.lang.Integer rollupRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f rule conditions where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @return the matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer conditionRuleID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f rule conditions where conditionRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param conditionRuleID the condition rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer conditionRuleID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f rule conditions where conditionRuleID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param conditionRuleID the condition rule i d
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer conditionRuleID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByCondition_First(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByCondition_First(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition findByCondition_Last(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f rule condition in the ordered set where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rule condition, or <code>null</code> if a matching l f rule condition could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchByCondition_Last(
        java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition[] findByCondition_PrevAndNext(
        long id, java.lang.Integer conditionRuleID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRuleConditionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f rule conditions.
    *
    * @return the l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f rule conditions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f rule conditions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f rule conditions where rollupRuleID = &#63; from the database.
    *
    * @param rollupRuleID the rollup rule i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByRollup(java.lang.Integer rollupRuleID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f rule conditions where conditionRuleID = &#63; from the database.
    *
    * @param conditionRuleID the condition rule i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByCondition(java.lang.Integer conditionRuleID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f rule conditions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f rule conditions where rollupRuleID = &#63;.
    *
    * @param rollupRuleID the rollup rule i d
    * @return the number of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public int countByRollup(java.lang.Integer rollupRuleID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f rule conditions where conditionRuleID = &#63;.
    *
    * @param conditionRuleID the condition rule i d
    * @return the number of matching l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public int countByCondition(java.lang.Integer conditionRuleID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f rule conditions.
    *
    * @return the number of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f player scope rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPlayerScopeRulePersistenceImpl
 * @see LFPlayerScopeRuleUtil
 * @generated
 */
public interface LFPlayerScopeRulePersistence extends BasePersistence<LFPlayerScopeRule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFPlayerScopeRuleUtil} to access the l f player scope rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f player scope rules where playerID = &#63;.
    *
    * @param playerID the player i d
    * @return the matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f player scope rules where playerID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param playerID the player i d
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @return the range of matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f player scope rules where playerID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param playerID the player i d
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule findByPlayerID_First(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f player scope rule, or <code>null</code> if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchByPlayerID_First(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule findByPlayerID_Last(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f player scope rule in the ordered set where playerID = &#63;.
    *
    * @param playerID the player i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f player scope rule, or <code>null</code> if a matching l f player scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchByPlayerID_Last(
        java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule[] findByPlayerID_PrevAndNext(
        long id, java.lang.String playerID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f player scope rules where playerID = &#63; from the database.
    *
    * @param playerID the player i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByPlayerID(java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f player scope rules where playerID = &#63;.
    *
    * @param playerID the player i d
    * @return the number of matching l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByPlayerID(java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f player scope rule in the entity cache if it is enabled.
    *
    * @param lfPlayerScopeRule the l f player scope rule
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule);

    /**
    * Caches the l f player scope rules in the entity cache if it is enabled.
    *
    * @param lfPlayerScopeRules the l f player scope rules
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> lfPlayerScopeRules);

    /**
    * Creates a new l f player scope rule with the primary key. Does not add the l f player scope rule to the database.
    *
    * @param id the primary key for the new l f player scope rule
    * @return the new l f player scope rule
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule create(
        long id);

    /**
    * Removes the l f player scope rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f player scope rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException} if it could not be found.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPlayerScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f player scope rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule, or <code>null</code> if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f player scope rules.
    *
    * @return the l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f player scope rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @return the range of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f player scope rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f player scope rules
    * @param end the upper bound of the range of l f player scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f player scope rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f player scope rules.
    *
    * @return the number of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

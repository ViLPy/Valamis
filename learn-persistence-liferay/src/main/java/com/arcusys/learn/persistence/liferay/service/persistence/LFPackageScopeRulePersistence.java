package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f package scope rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageScopeRulePersistenceImpl
 * @see LFPackageScopeRuleUtil
 * @generated
 */
public interface LFPackageScopeRulePersistence extends BasePersistence<LFPackageScopeRule> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFPackageScopeRuleUtil} to access the l f package scope rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f package scope rule in the entity cache if it is enabled.
    *
    * @param lfPackageScopeRule the l f package scope rule
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule);

    /**
    * Caches the l f package scope rules in the entity cache if it is enabled.
    *
    * @param lfPackageScopeRules the l f package scope rules
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> lfPackageScopeRules);

    /**
    * Creates a new l f package scope rule with the primary key. Does not add the l f package scope rule to the database.
    *
    * @param id the primary key for the new l f package scope rule
    * @return the new l f package scope rule
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule create(
        long id);

    /**
    * Removes the l f package scope rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package scope rule
    * @return the l f package scope rule that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
    *
    * @param id the primary key of the l f package scope rule
    * @return the l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f package scope rule
    * @return the l f package scope rule, or <code>null</code> if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where packageID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
    *
    * @param packageID the package i d
    * @return the matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByPackageID(
        java.lang.Integer packageID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where packageID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param packageID the package i d
    * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where packageID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param packageID the package i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByPackageID(
        java.lang.Integer packageID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param isDefault the is default
    * @return the matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByScopeAndIsDefault(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean isDefault)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param isDefault the is default
    * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByScopeAndIsDefault(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean isDefault)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param isDefault the is default
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByScopeAndIsDefault(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean isDefault, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f package scope rules where scope = &#63; and scopeID = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByScope(
        java.lang.String scope, java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f package scope rules where scope = &#63; and scopeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @return the range of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByScope(
        java.lang.String scope, java.lang.String scopeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f package scope rules where scope = &#63; and scopeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByScope(
        java.lang.String scope, java.lang.String scopeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByScope_First(
        java.lang.String scope, java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByScope_First(
        java.lang.String scope, java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByScope_Last(
        java.lang.String scope, java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByScope_Last(
        java.lang.String scope, java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63;.
    *
    * @param id the primary key of the current l f package scope rule
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule[] findByScope_PrevAndNext(
        long id, java.lang.String scope, java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException} if it could not be found.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByAllByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @return the range of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByAllByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByAllByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByAllByPackageIDAndScope_First(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByAllByPackageIDAndScope_First(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByAllByPackageIDAndScope_Last(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByAllByPackageIDAndScope_Last(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param id the primary key of the current l f package scope rule
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule[] findByAllByPackageIDAndScope_PrevAndNext(
        long id, java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @return the matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByVisibility(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @return the range of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByVisibility(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByVisibility(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByVisibility_First(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByVisibility_First(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByVisibility_Last(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f package scope rule, or <code>null</code> if a matching l f package scope rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByVisibility_Last(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f package scope rules before and after the current l f package scope rule in the ordered set where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param id the primary key of the current l f package scope rule
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f package scope rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule[] findByVisibility_PrevAndNext(
        long id, java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f package scope rules.
    *
    * @return the l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f package scope rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @return the range of l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f package scope rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f package scope rules
    * @param end the upper bound of the range of l f package scope rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f package scope rule where packageID = &#63; from the database.
    *
    * @param packageID the package i d
    * @return the l f package scope rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule removeByPackageID(
        java.lang.Integer packageID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f package scope rule where scope = &#63; and scopeID = &#63; and isDefault = &#63; from the database.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param isDefault the is default
    * @return the l f package scope rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule removeByScopeAndIsDefault(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean isDefault)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f package scope rules where scope = &#63; and scopeID = &#63; from the database.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByScope(java.lang.String scope, java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f package scope rule where packageID = &#63; and scope = &#63; and scopeID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the l f package scope rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule removeByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63; from the database.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByAllByPackageIDAndScope(java.lang.Integer packageID,
        java.lang.String scope, java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63; from the database.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @throws SystemException if a system exception occurred
    */
    public void removeByVisibility(java.lang.String scope,
        java.lang.String scopeID, java.lang.Boolean visibility)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f package scope rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules where packageID = &#63;.
    *
    * @param packageID the package i d
    * @return the number of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageID(java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules where scope = &#63; and scopeID = &#63; and isDefault = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param isDefault the is default
    * @return the number of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByScopeAndIsDefault(java.lang.String scope,
        java.lang.String scopeID, java.lang.Boolean isDefault)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules where scope = &#63; and scopeID = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the number of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByScope(java.lang.String scope, java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the number of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByPackageIDAndScope(java.lang.Integer packageID,
        java.lang.String scope, java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules where packageID = &#63; and scope = &#63; and scopeID = &#63;.
    *
    * @param packageID the package i d
    * @param scope the scope
    * @param scopeID the scope i d
    * @return the number of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByAllByPackageIDAndScope(java.lang.Integer packageID,
        java.lang.String scope, java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules where scope = &#63; and scopeID = &#63; and visibility = &#63;.
    *
    * @param scope the scope
    * @param scopeID the scope i d
    * @param visibility the visibility
    * @return the number of matching l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countByVisibility(java.lang.String scope,
        java.lang.String scopeID, java.lang.Boolean visibility)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f package scope rules.
    *
    * @return the number of l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

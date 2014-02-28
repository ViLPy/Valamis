package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRollupRule;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f rollup rule service. This utility wraps {@link LFRollupRulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupRulePersistence
 * @see LFRollupRulePersistenceImpl
 * @generated
 */
public class LFRollupRuleUtil {
    private static LFRollupRulePersistence _persistence;

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
    public static void clearCache(LFRollupRule lfRollupRule) {
        getPersistence().clearCache(lfRollupRule);
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
    public static List<LFRollupRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFRollupRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFRollupRule> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFRollupRule update(LFRollupRule lfRollupRule)
        throws SystemException {
        return getPersistence().update(lfRollupRule);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFRollupRule update(LFRollupRule lfRollupRule,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfRollupRule, serviceContext);
    }

    /**
    * Returns all the l f rollup rules where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID);
    }

    /**
    * Returns a range of all the l f rollup rules where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f rollup rules
    * @param end the upper bound of the range of l f rollup rules (not inclusive)
    * @return the range of matching l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID, start, end);
    }

    /**
    * Returns an ordered range of all the l f rollup rules where sequencingID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param start the lower bound of the range of l f rollup rules
    * @param end the upper bound of the range of l f rollup rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findBySequencingID(
        java.lang.Integer sequencingID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID(sequencingID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f rollup rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rollup rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a matching l f rollup rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule findBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_First(sequencingID, orderByComparator);
    }

    /**
    * Returns the first l f rollup rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f rollup rule, or <code>null</code> if a matching l f rollup rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule fetchBySequencingID_First(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID_First(sequencingID, orderByComparator);
    }

    /**
    * Returns the last l f rollup rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rollup rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a matching l f rollup rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule findBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_Last(sequencingID, orderByComparator);
    }

    /**
    * Returns the last l f rollup rule in the ordered set where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f rollup rule, or <code>null</code> if a matching l f rollup rule could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule fetchBySequencingID_Last(
        java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID_Last(sequencingID, orderByComparator);
    }

    /**
    * Returns the l f rollup rules before and after the current l f rollup rule in the ordered set where sequencingID = &#63;.
    *
    * @param id the primary key of the current l f rollup rule
    * @param sequencingID the sequencing i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f rollup rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule[] findBySequencingID_PrevAndNext(
        long id, java.lang.Integer sequencingID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingID_PrevAndNext(id, sequencingID,
            orderByComparator);
    }

    /**
    * Removes all the l f rollup rules where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySequencingID(sequencingID);
    }

    /**
    * Returns the number of l f rollup rules where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySequencingID(sequencingID);
    }

    /**
    * Caches the l f rollup rule in the entity cache if it is enabled.
    *
    * @param lfRollupRule the l f rollup rule
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule) {
        getPersistence().cacheResult(lfRollupRule);
    }

    /**
    * Caches the l f rollup rules in the entity cache if it is enabled.
    *
    * @param lfRollupRules the l f rollup rules
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> lfRollupRules) {
        getPersistence().cacheResult(lfRollupRules);
    }

    /**
    * Creates a new l f rollup rule with the primary key. Does not add the l f rollup rule to the database.
    *
    * @param id the primary key for the new l f rollup rule
    * @return the new l f rollup rule
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfRollupRule);
    }

    /**
    * Returns the l f rollup rule with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException} if it could not be found.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f rollup rule with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule, or <code>null</code> if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f rollup rules.
    *
    * @return the l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f rollup rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup rules
    * @param end the upper bound of the range of l f rollup rules (not inclusive)
    * @return the range of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f rollup rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRollupRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup rules
    * @param end the upper bound of the range of l f rollup rules (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f rollup rules from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f rollup rules.
    *
    * @return the number of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFRollupRulePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFRollupRulePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFRollupRulePersistence.class.getName());

            ReferenceRegistry.registerReference(LFRollupRuleUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFRollupRulePersistence persistence) {
    }
}

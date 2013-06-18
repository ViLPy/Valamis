package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f package scope rule local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFPackageScopeRuleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageScopeRuleLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageScopeRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFPackageScopeRuleLocalServiceImpl
 * @generated
 */
public class LFPackageScopeRuleLocalServiceUtil {
    private static LFPackageScopeRuleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFPackageScopeRuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f package scope rule to the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackageScopeRule the l f package scope rule
    * @return the l f package scope rule that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule addLFPackageScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFPackageScopeRule(lfPackageScopeRule);
    }

    /**
    * Creates a new l f package scope rule with the primary key. Does not add the l f package scope rule to the database.
    *
    * @param id the primary key for the new l f package scope rule
    * @return the new l f package scope rule
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule createLFPackageScopeRule(
        long id) {
        return getService().createLFPackageScopeRule(id);
    }

    /**
    * Deletes the l f package scope rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package scope rule
    * @return the l f package scope rule that was removed
    * @throws PortalException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule deleteLFPackageScopeRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPackageScopeRule(id);
    }

    /**
    * Deletes the l f package scope rule from the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackageScopeRule the l f package scope rule
    * @return the l f package scope rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule deleteLFPackageScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPackageScopeRule(lfPackageScopeRule);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchLFPackageScopeRule(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFPackageScopeRule(id);
    }

    /**
    * Returns the l f package scope rule with the primary key.
    *
    * @param id the primary key of the l f package scope rule
    * @return the l f package scope rule
    * @throws PortalException if a l f package scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule getLFPackageScopeRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackageScopeRule(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> getLFPackageScopeRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackageScopeRules(start, end);
    }

    /**
    * Returns the number of l f package scope rules.
    *
    * @return the number of l f package scope rules
    * @throws SystemException if a system exception occurred
    */
    public static int getLFPackageScopeRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackageScopeRulesCount();
    }

    /**
    * Updates the l f package scope rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackageScopeRule the l f package scope rule
    * @return the l f package scope rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule updateLFPackageScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFPackageScopeRule(lfPackageScopeRule);
    }

    /**
    * Updates the l f package scope rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackageScopeRule the l f package scope rule
    * @param merge whether to merge the l f package scope rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f package scope rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule updateLFPackageScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule lfPackageScopeRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFPackageScopeRule(lfPackageScopeRule, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule createLFPackageScopeRule()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFPackageScopeRule();
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByPackageID(
        java.lang.Integer packageID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageID(packageID);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByScopeAndIsDefault(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean isDefault)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByScopeAndIsDefault(scope, scopeID, isDefault);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByScope(
        java.lang.String scope, java.lang.String scopeID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByScope(scope, scopeID);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule findByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPackageIDAndScope(packageID, scope, scopeID);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule fetchByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchByPackageIDAndScope(packageID, scope, scopeID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByAllByPackageIDAndScope(
        java.lang.Integer packageID, java.lang.String scope,
        java.lang.String scopeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByAllByPackageIDAndScope(packageID, scope, scopeID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule> findByVisibility(
        java.lang.String scope, java.lang.String scopeID,
        java.lang.Boolean visibility)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByVisibility(scope, scopeID, visibility);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule removeByPackageID(
        java.lang.Integer packageID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().removeByPackageID(packageID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFPackageScopeRuleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFPackageScopeRuleLocalService.class.getName());

            if (invokableLocalService instanceof LFPackageScopeRuleLocalService) {
                _service = (LFPackageScopeRuleLocalService) invokableLocalService;
            } else {
                _service = new LFPackageScopeRuleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFPackageScopeRuleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFPackageScopeRuleLocalService service) {
    }
}

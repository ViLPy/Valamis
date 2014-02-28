package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFPlayerScopeRule. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFPlayerScopeRuleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFPlayerScopeRuleLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPlayerScopeRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFPlayerScopeRuleLocalServiceImpl
 * @generated
 */
public class LFPlayerScopeRuleLocalServiceUtil {
    private static LFPlayerScopeRuleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFPlayerScopeRuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f player scope rule to the database. Also notifies the appropriate model listeners.
    *
    * @param lfPlayerScopeRule the l f player scope rule
    * @return the l f player scope rule that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule addLFPlayerScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFPlayerScopeRule(lfPlayerScopeRule);
    }

    /**
    * Creates a new l f player scope rule with the primary key. Does not add the l f player scope rule to the database.
    *
    * @param id the primary key for the new l f player scope rule
    * @return the new l f player scope rule
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule createLFPlayerScopeRule(
        long id) {
        return getService().createLFPlayerScopeRule(id);
    }

    /**
    * Deletes the l f player scope rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule that was removed
    * @throws PortalException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule deleteLFPlayerScopeRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPlayerScopeRule(id);
    }

    /**
    * Deletes the l f player scope rule from the database. Also notifies the appropriate model listeners.
    *
    * @param lfPlayerScopeRule the l f player scope rule
    * @return the l f player scope rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule deleteLFPlayerScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPlayerScopeRule(lfPlayerScopeRule);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPlayerScopeRuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule fetchLFPlayerScopeRule(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFPlayerScopeRule(id);
    }

    /**
    * Returns the l f player scope rule with the primary key.
    *
    * @param id the primary key of the l f player scope rule
    * @return the l f player scope rule
    * @throws PortalException if a l f player scope rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule getLFPlayerScopeRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPlayerScopeRule(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> getLFPlayerScopeRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPlayerScopeRules(start, end);
    }

    /**
    * Returns the number of l f player scope rules.
    *
    * @return the number of l f player scope rules
    * @throws SystemException if a system exception occurred
    */
    public static int getLFPlayerScopeRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPlayerScopeRulesCount();
    }

    /**
    * Updates the l f player scope rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPlayerScopeRule the l f player scope rule
    * @return the l f player scope rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule updateLFPlayerScopeRule(
        com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule lfPlayerScopeRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFPlayerScopeRule(lfPlayerScopeRule);
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

    public static com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule createLFPlayerScopeRule()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFPlayerScopeRule();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPlayerID(playerID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPlayerScopeRule> findByPlayerID(
        java.lang.String playerID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPlayerID(playerID, start, end);
    }

    public static void removeByPlayerID(java.lang.String playerID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByPlayerID(playerID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFPlayerScopeRuleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFPlayerScopeRuleLocalService.class.getName());

            if (invokableLocalService instanceof LFPlayerScopeRuleLocalService) {
                _service = (LFPlayerScopeRuleLocalService) invokableLocalService;
            } else {
                _service = new LFPlayerScopeRuleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFPlayerScopeRuleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFPlayerScopeRuleLocalService service) {
    }
}

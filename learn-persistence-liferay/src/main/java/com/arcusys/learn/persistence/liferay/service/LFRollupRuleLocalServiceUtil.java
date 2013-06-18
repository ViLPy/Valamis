package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f rollup rule local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFRollupRuleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupRuleLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRollupRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFRollupRuleLocalServiceImpl
 * @generated
 */
public class LFRollupRuleLocalServiceUtil {
    private static LFRollupRuleLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFRollupRuleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f rollup rule to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @return the l f rollup rule that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule addLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFRollupRule(lfRollupRule);
    }

    /**
    * Creates a new l f rollup rule with the primary key. Does not add the l f rollup rule to the database.
    *
    * @param id the primary key for the new l f rollup rule
    * @return the new l f rollup rule
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule createLFRollupRule(
        long id) {
        return getService().createLFRollupRule(id);
    }

    /**
    * Deletes the l f rollup rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule that was removed
    * @throws PortalException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule deleteLFRollupRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFRollupRule(id);
    }

    /**
    * Deletes the l f rollup rule from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @return the l f rollup rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule deleteLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFRollupRule(lfRollupRule);
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

    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule fetchLFRollupRule(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFRollupRule(id);
    }

    /**
    * Returns the l f rollup rule with the primary key.
    *
    * @param id the primary key of the l f rollup rule
    * @return the l f rollup rule
    * @throws PortalException if a l f rollup rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule getLFRollupRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRollupRule(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f rollup rules.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup rules
    * @param end the upper bound of the range of l f rollup rules (not inclusive)
    * @return the range of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> getLFRollupRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRollupRules(start, end);
    }

    /**
    * Returns the number of l f rollup rules.
    *
    * @return the number of l f rollup rules
    * @throws SystemException if a system exception occurred
    */
    public static int getLFRollupRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRollupRulesCount();
    }

    /**
    * Updates the l f rollup rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @return the l f rollup rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule updateLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFRollupRule(lfRollupRule);
    }

    /**
    * Updates the l f rollup rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRollupRule the l f rollup rule
    * @param merge whether to merge the l f rollup rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f rollup rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule updateLFRollupRule(
        com.arcusys.learn.persistence.liferay.model.LFRollupRule lfRollupRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFRollupRule(lfRollupRule, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFRollupRule createLFRollupRule()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFRollupRule();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupRule> findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBySequencingID(sequencingID);
    }

    public static void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeBySequencingID(sequencingID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFRollupRuleLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFRollupRuleLocalService.class.getName());

            if (invokableLocalService instanceof LFRollupRuleLocalService) {
                _service = (LFRollupRuleLocalService) invokableLocalService;
            } else {
                _service = new LFRollupRuleLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFRollupRuleLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFRollupRuleLocalService service) {
    }
}

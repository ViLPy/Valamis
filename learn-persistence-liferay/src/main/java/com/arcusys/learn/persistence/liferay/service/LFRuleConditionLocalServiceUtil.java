package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f rule condition local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFRuleConditionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRuleConditionLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRuleConditionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFRuleConditionLocalServiceImpl
 * @generated
 */
public class LFRuleConditionLocalServiceUtil {
    private static LFRuleConditionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFRuleConditionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f rule condition to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @return the l f rule condition that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition addLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFRuleCondition(lfRuleCondition);
    }

    /**
    * Creates a new l f rule condition with the primary key. Does not add the l f rule condition to the database.
    *
    * @param id the primary key for the new l f rule condition
    * @return the new l f rule condition
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition createLFRuleCondition(
        long id) {
        return getService().createLFRuleCondition(id);
    }

    /**
    * Deletes the l f rule condition with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition that was removed
    * @throws PortalException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition deleteLFRuleCondition(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFRuleCondition(id);
    }

    /**
    * Deletes the l f rule condition from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @return the l f rule condition that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition deleteLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFRuleCondition(lfRuleCondition);
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

    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchLFRuleCondition(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFRuleCondition(id);
    }

    /**
    * Returns the l f rule condition with the primary key.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition
    * @throws PortalException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition getLFRuleCondition(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRuleCondition(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

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
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> getLFRuleConditions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRuleConditions(start, end);
    }

    /**
    * Returns the number of l f rule conditions.
    *
    * @return the number of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public static int getLFRuleConditionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFRuleConditionsCount();
    }

    /**
    * Updates the l f rule condition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @return the l f rule condition that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFRuleCondition(lfRuleCondition);
    }

    /**
    * Updates the l f rule condition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @param merge whether to merge the l f rule condition with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f rule condition that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFRuleCondition(lfRuleCondition, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFRuleCondition createLFRuleCondition()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFRuleCondition();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByRollup(ruleID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCondition(ruleID);
    }

    public static void removeByRollup(java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByRollup(ruleID);
    }

    public static void removeByCondition(java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByCondition(ruleID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFRuleConditionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFRuleConditionLocalService.class.getName());

            if (invokableLocalService instanceof LFRuleConditionLocalService) {
                _service = (LFRuleConditionLocalService) invokableLocalService;
            } else {
                _service = new LFRuleConditionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFRuleConditionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFRuleConditionLocalService service) {
    }
}

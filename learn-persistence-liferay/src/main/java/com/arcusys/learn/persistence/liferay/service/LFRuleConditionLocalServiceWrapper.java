package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFRuleConditionLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFRuleConditionLocalService
 * @generated
 */
public class LFRuleConditionLocalServiceWrapper
    implements LFRuleConditionLocalService,
        ServiceWrapper<LFRuleConditionLocalService> {
    private LFRuleConditionLocalService _lfRuleConditionLocalService;

    public LFRuleConditionLocalServiceWrapper(
        LFRuleConditionLocalService lfRuleConditionLocalService) {
        _lfRuleConditionLocalService = lfRuleConditionLocalService;
    }

    /**
    * Adds the l f rule condition to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @return the l f rule condition that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition addLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.addLFRuleCondition(lfRuleCondition);
    }

    /**
    * Creates a new l f rule condition with the primary key. Does not add the l f rule condition to the database.
    *
    * @param id the primary key for the new l f rule condition
    * @return the new l f rule condition
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition createLFRuleCondition(
        long id) {
        return _lfRuleConditionLocalService.createLFRuleCondition(id);
    }

    /**
    * Deletes the l f rule condition with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition that was removed
    * @throws PortalException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition deleteLFRuleCondition(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.deleteLFRuleCondition(id);
    }

    /**
    * Deletes the l f rule condition from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @return the l f rule condition that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition deleteLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.deleteLFRuleCondition(lfRuleCondition);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfRuleConditionLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition fetchLFRuleCondition(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.fetchLFRuleCondition(id);
    }

    /**
    * Returns the l f rule condition with the primary key.
    *
    * @param id the primary key of the l f rule condition
    * @return the l f rule condition
    * @throws PortalException if a l f rule condition with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition getLFRuleCondition(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.getLFRuleCondition(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> getLFRuleConditions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.getLFRuleConditions(start, end);
    }

    /**
    * Returns the number of l f rule conditions.
    *
    * @return the number of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    public int getLFRuleConditionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.getLFRuleConditionsCount();
    }

    /**
    * Updates the l f rule condition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @return the l f rule condition that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.updateLFRuleCondition(lfRuleCondition);
    }

    /**
    * Updates the l f rule condition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRuleCondition the l f rule condition
    * @param merge whether to merge the l f rule condition with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f rule condition that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.updateLFRuleCondition(lfRuleCondition,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfRuleConditionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfRuleConditionLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfRuleConditionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition createLFRuleCondition()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.createLFRuleCondition();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.findByRollup(ruleID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.findByCondition(ruleID);
    }

    public void removeByRollup(java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleConditionLocalService.removeByRollup(ruleID);
    }

    public void removeByCondition(java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleConditionLocalService.removeByCondition(ruleID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleConditionLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFRuleConditionLocalService getWrappedLFRuleConditionLocalService() {
        return _lfRuleConditionLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFRuleConditionLocalService(
        LFRuleConditionLocalService lfRuleConditionLocalService) {
        _lfRuleConditionLocalService = lfRuleConditionLocalService;
    }

    public LFRuleConditionLocalService getWrappedService() {
        return _lfRuleConditionLocalService;
    }

    public void setWrappedService(
        LFRuleConditionLocalService lfRuleConditionLocalService) {
        _lfRuleConditionLocalService = lfRuleConditionLocalService;
    }
}

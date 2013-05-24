package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFConditionRuleLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFConditionRuleLocalService
 * @generated
 */
public class LFConditionRuleLocalServiceWrapper
    implements LFConditionRuleLocalService,
        ServiceWrapper<LFConditionRuleLocalService> {
    private LFConditionRuleLocalService _lfConditionRuleLocalService;

    public LFConditionRuleLocalServiceWrapper(
        LFConditionRuleLocalService lfConditionRuleLocalService) {
        _lfConditionRuleLocalService = lfConditionRuleLocalService;
    }

    /**
    * Adds the l f condition rule to the database. Also notifies the appropriate model listeners.
    *
    * @param lfConditionRule the l f condition rule
    * @return the l f condition rule that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule addLFConditionRule(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.addLFConditionRule(lfConditionRule);
    }

    /**
    * Creates a new l f condition rule with the primary key. Does not add the l f condition rule to the database.
    *
    * @param id the primary key for the new l f condition rule
    * @return the new l f condition rule
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule createLFConditionRule(
        long id) {
        return _lfConditionRuleLocalService.createLFConditionRule(id);
    }

    /**
    * Deletes the l f condition rule with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule that was removed
    * @throws PortalException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule deleteLFConditionRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.deleteLFConditionRule(id);
    }

    /**
    * Deletes the l f condition rule from the database. Also notifies the appropriate model listeners.
    *
    * @param lfConditionRule the l f condition rule
    * @return the l f condition rule that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule deleteLFConditionRule(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.deleteLFConditionRule(lfConditionRule);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfConditionRuleLocalService.dynamicQuery();
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
        return _lfConditionRuleLocalService.dynamicQuery(dynamicQuery);
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
        return _lfConditionRuleLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfConditionRuleLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfConditionRuleLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFConditionRule fetchLFConditionRule(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.fetchLFConditionRule(id);
    }

    /**
    * Returns the l f condition rule with the primary key.
    *
    * @param id the primary key of the l f condition rule
    * @return the l f condition rule
    * @throws PortalException if a l f condition rule with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule getLFConditionRule(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.getLFConditionRule(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.getPersistedModel(primaryKeyObj);
    }

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> getLFConditionRules(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.getLFConditionRules(start, end);
    }

    /**
    * Returns the number of l f condition rules.
    *
    * @return the number of l f condition rules
    * @throws SystemException if a system exception occurred
    */
    public int getLFConditionRulesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.getLFConditionRulesCount();
    }

    /**
    * Updates the l f condition rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfConditionRule the l f condition rule
    * @return the l f condition rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule updateLFConditionRule(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.updateLFConditionRule(lfConditionRule);
    }

    /**
    * Updates the l f condition rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfConditionRule the l f condition rule
    * @param merge whether to merge the l f condition rule with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f condition rule that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFConditionRule updateLFConditionRule(
        com.arcusys.learn.persistence.liferay.model.LFConditionRule lfConditionRule,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.updateLFConditionRule(lfConditionRule,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfConditionRuleLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfConditionRuleLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfConditionRuleLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFConditionRule createLFConditionRule()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.createLFConditionRule();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(
        java.lang.Integer sequencingID, java.lang.String ruleType)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfConditionRuleLocalService.findBySequencingIDAndRuleType(sequencingID,
            ruleType);
    }

    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfConditionRuleLocalService.removeBySequencingID(sequencingID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfConditionRuleLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFConditionRuleLocalService getWrappedLFConditionRuleLocalService() {
        return _lfConditionRuleLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFConditionRuleLocalService(
        LFConditionRuleLocalService lfConditionRuleLocalService) {
        _lfConditionRuleLocalService = lfConditionRuleLocalService;
    }

    public LFConditionRuleLocalService getWrappedService() {
        return _lfConditionRuleLocalService;
    }

    public void setWrappedService(
        LFConditionRuleLocalService lfConditionRuleLocalService) {
        _lfConditionRuleLocalService = lfConditionRuleLocalService;
    }
}

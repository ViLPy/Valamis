package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFRuleConditionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFRuleConditionLocalService
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition deleteLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.deleteLFRuleCondition(lfRuleCondition);
    }

    @Override
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
    @Override
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
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
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
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
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition getLFRuleCondition(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.getLFRuleCondition(id);
    }

    @Override
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFRuleConditionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f rule conditions
    * @param end the upper bound of the range of l f rule conditions (not inclusive)
    * @return the range of l f rule conditions
    * @throws SystemException if a system exception occurred
    */
    @Override
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
    @Override
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
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition updateLFRuleCondition(
        com.arcusys.learn.persistence.liferay.model.LFRuleCondition lfRuleCondition)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.updateLFRuleCondition(lfRuleCondition);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfRuleConditionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfRuleConditionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfRuleConditionLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFRuleCondition createLFRuleCondition()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.createLFRuleCondition();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByRollup(
        java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.findByRollup(ruleID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRuleCondition> findByCondition(
        java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRuleConditionLocalService.findByCondition(ruleID);
    }

    @Override
    public void removeByRollup(java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleConditionLocalService.removeByRollup(ruleID);
    }

    @Override
    public void removeByCondition(java.lang.Integer ruleID)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleConditionLocalService.removeByCondition(ruleID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleConditionLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFRuleConditionLocalService getWrappedLFRuleConditionLocalService() {
        return _lfRuleConditionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFRuleConditionLocalService(
        LFRuleConditionLocalService lfRuleConditionLocalService) {
        _lfRuleConditionLocalService = lfRuleConditionLocalService;
    }

    @Override
    public LFRuleConditionLocalService getWrappedService() {
        return _lfRuleConditionLocalService;
    }

    @Override
    public void setWrappedService(
        LFRuleConditionLocalService lfRuleConditionLocalService) {
        _lfRuleConditionLocalService = lfRuleConditionLocalService;
    }
}

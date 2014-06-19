package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanLrsStateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStateLocalService
 * @generated
 */
public class LFTincanLrsStateLocalServiceWrapper
    implements LFTincanLrsStateLocalService,
        ServiceWrapper<LFTincanLrsStateLocalService> {
    private LFTincanLrsStateLocalService _lfTincanLrsStateLocalService;

    public LFTincanLrsStateLocalServiceWrapper(
        LFTincanLrsStateLocalService lfTincanLrsStateLocalService) {
        _lfTincanLrsStateLocalService = lfTincanLrsStateLocalService;
    }

    /**
    * Adds the l f tincan lrs state to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsState the l f tincan lrs state
    * @return the l f tincan lrs state that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState addLFTincanLrsState(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.addLFTincanLrsState(lfTincanLrsState);
    }

    /**
    * Creates a new l f tincan lrs state with the primary key. Does not add the l f tincan lrs state to the database.
    *
    * @param id the primary key for the new l f tincan lrs state
    * @return the new l f tincan lrs state
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState createLFTincanLrsState(
        long id) {
        return _lfTincanLrsStateLocalService.createLFTincanLrsState(id);
    }

    /**
    * Deletes the l f tincan lrs state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state that was removed
    * @throws PortalException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState deleteLFTincanLrsState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.deleteLFTincanLrsState(id);
    }

    /**
    * Deletes the l f tincan lrs state from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsState the l f tincan lrs state
    * @return the l f tincan lrs state that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState deleteLFTincanLrsState(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.deleteLFTincanLrsState(lfTincanLrsState);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsStateLocalService.dynamicQuery();
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
        return _lfTincanLrsStateLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsStateLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanLrsStateLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfTincanLrsStateLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanLrsStateLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState fetchLFTincanLrsState(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.fetchLFTincanLrsState(id);
    }

    /**
    * Returns the l f tincan lrs state with the primary key.
    *
    * @param id the primary key of the l f tincan lrs state
    * @return the l f tincan lrs state
    * @throws PortalException if a l f tincan lrs state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState getLFTincanLrsState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.getLFTincanLrsState(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs states
    * @param end the upper bound of the range of l f tincan lrs states (not inclusive)
    * @return the range of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> getLFTincanLrsStates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.getLFTincanLrsStates(start, end);
    }

    /**
    * Returns the number of l f tincan lrs states.
    *
    * @return the number of l f tincan lrs states
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanLrsStatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.getLFTincanLrsStatesCount();
    }

    /**
    * Updates the l f tincan lrs state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsState the l f tincan lrs state
    * @return the l f tincan lrs state that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState updateLFTincanLrsState(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsState lfTincanLrsState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.updateLFTincanLrsState(lfTincanLrsState);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsStateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsStateLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsStateLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsStateLocalService.removeAll();
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState createLFTincanLrsState()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.createLFTincanLrsState();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityId(
        java.lang.String activityId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.findByActivityId(activityId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndStateId(
        java.lang.String activityId, java.lang.String stateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.findByActivityIdAndStateId(activityId,
            stateId);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsState> findByActivityIdAndAgentId(
        java.lang.String activityId, java.lang.Integer agentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.findByActivityIdAndAgentId(activityId,
            agentId);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsState findByStateDocument(
        java.lang.String activityId, java.lang.String stateId,
        java.lang.Integer agentId, java.lang.String registration)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsStateLocalService.findByStateDocument(activityId,
            stateId, agentId, registration);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanLrsStateLocalService getWrappedLFTincanLrsStateLocalService() {
        return _lfTincanLrsStateLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsStateLocalService(
        LFTincanLrsStateLocalService lfTincanLrsStateLocalService) {
        _lfTincanLrsStateLocalService = lfTincanLrsStateLocalService;
    }

    @Override
    public LFTincanLrsStateLocalService getWrappedService() {
        return _lfTincanLrsStateLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanLrsStateLocalService lfTincanLrsStateLocalService) {
        _lfTincanLrsStateLocalService = lfTincanLrsStateLocalService;
    }
}

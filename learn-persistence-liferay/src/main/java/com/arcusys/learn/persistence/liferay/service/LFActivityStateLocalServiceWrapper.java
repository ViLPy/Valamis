package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFActivityStateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateLocalService
 * @generated
 */
public class LFActivityStateLocalServiceWrapper
    implements LFActivityStateLocalService,
        ServiceWrapper<LFActivityStateLocalService> {
    private LFActivityStateLocalService _lfActivityStateLocalService;

    public LFActivityStateLocalServiceWrapper(
        LFActivityStateLocalService lfActivityStateLocalService) {
        _lfActivityStateLocalService = lfActivityStateLocalService;
    }

    /**
    * Adds the l f activity state to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @return the l f activity state that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState addLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.addLFActivityState(lfActivityState);
    }

    /**
    * Creates a new l f activity state with the primary key. Does not add the l f activity state to the database.
    *
    * @param id the primary key for the new l f activity state
    * @return the new l f activity state
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState createLFActivityState(
        long id) {
        return _lfActivityStateLocalService.createLFActivityState(id);
    }

    /**
    * Deletes the l f activity state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state that was removed
    * @throws PortalException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState deleteLFActivityState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.deleteLFActivityState(id);
    }

    /**
    * Deletes the l f activity state from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @return the l f activity state that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState deleteLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.deleteLFActivityState(lfActivityState);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfActivityStateLocalService.dynamicQuery();
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
        return _lfActivityStateLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfActivityStateLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfActivityStateLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfActivityStateLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfActivityStateLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState fetchLFActivityState(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.fetchLFActivityState(id);
    }

    /**
    * Returns the l f activity state with the primary key.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state
    * @throws PortalException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState getLFActivityState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.getLFActivityState(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activity states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFActivityStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of l f activity states
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> getLFActivityStates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.getLFActivityStates(start, end);
    }

    /**
    * Returns the number of l f activity states.
    *
    * @return the number of l f activity states
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFActivityStatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.getLFActivityStatesCount();
    }

    /**
    * Updates the l f activity state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @return the l f activity state that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState updateLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.updateLFActivityState(lfActivityState);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfActivityStateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfActivityStateLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfActivityStateLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFActivityState createLFActivityState()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.createLFActivityState();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDAndActivityID(
        java.lang.Integer[] activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.findByActivityStateNodeIDAndActivityID(activityStateNodeID,
            activityID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
            activityStateNodeID, activityStateTreeID);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityStateLocalService.findByActivityStateNodeID(activityStateNodeID);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityStateLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFActivityStateLocalService getWrappedLFActivityStateLocalService() {
        return _lfActivityStateLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFActivityStateLocalService(
        LFActivityStateLocalService lfActivityStateLocalService) {
        _lfActivityStateLocalService = lfActivityStateLocalService;
    }

    @Override
    public LFActivityStateLocalService getWrappedService() {
        return _lfActivityStateLocalService;
    }

    @Override
    public void setWrappedService(
        LFActivityStateLocalService lfActivityStateLocalService) {
        _lfActivityStateLocalService = lfActivityStateLocalService;
    }
}

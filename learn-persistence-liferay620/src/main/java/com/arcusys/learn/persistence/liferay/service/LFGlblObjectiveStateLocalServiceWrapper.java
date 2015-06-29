package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFGlblObjectiveStateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFGlblObjectiveStateLocalService
 * @generated
 */
public class LFGlblObjectiveStateLocalServiceWrapper
    implements LFGlblObjectiveStateLocalService,
        ServiceWrapper<LFGlblObjectiveStateLocalService> {
    private LFGlblObjectiveStateLocalService _lfGlblObjectiveStateLocalService;

    public LFGlblObjectiveStateLocalServiceWrapper(
        LFGlblObjectiveStateLocalService lfGlblObjectiveStateLocalService) {
        _lfGlblObjectiveStateLocalService = lfGlblObjectiveStateLocalService;
    }

    /**
    * Adds the l f glbl objective state to the database. Also notifies the appropriate model listeners.
    *
    * @param lfGlblObjectiveState the l f glbl objective state
    * @return the l f glbl objective state that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState addLFGlblObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState lfGlblObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.addLFGlblObjectiveState(lfGlblObjectiveState);
    }

    /**
    * Creates a new l f glbl objective state with the primary key. Does not add the l f glbl objective state to the database.
    *
    * @param id the primary key for the new l f glbl objective state
    * @return the new l f glbl objective state
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState createLFGlblObjectiveState(
        long id) {
        return _lfGlblObjectiveStateLocalService.createLFGlblObjectiveState(id);
    }

    /**
    * Deletes the l f glbl objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f glbl objective state
    * @return the l f glbl objective state that was removed
    * @throws PortalException if a l f glbl objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState deleteLFGlblObjectiveState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.deleteLFGlblObjectiveState(id);
    }

    /**
    * Deletes the l f glbl objective state from the database. Also notifies the appropriate model listeners.
    *
    * @param lfGlblObjectiveState the l f glbl objective state
    * @return the l f glbl objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState deleteLFGlblObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState lfGlblObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.deleteLFGlblObjectiveState(lfGlblObjectiveState);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfGlblObjectiveStateLocalService.dynamicQuery();
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
        return _lfGlblObjectiveStateLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfGlblObjectiveStateLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfGlblObjectiveStateLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfGlblObjectiveStateLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfGlblObjectiveStateLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState fetchLFGlblObjectiveState(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.fetchLFGlblObjectiveState(id);
    }

    /**
    * Returns the l f glbl objective state with the primary key.
    *
    * @param id the primary key of the l f glbl objective state
    * @return the l f glbl objective state
    * @throws PortalException if a l f glbl objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState getLFGlblObjectiveState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.getLFGlblObjectiveState(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f glbl objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFGlblObjectiveStateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f glbl objective states
    * @param end the upper bound of the range of l f glbl objective states (not inclusive)
    * @return the range of l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> getLFGlblObjectiveStates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.getLFGlblObjectiveStates(start,
            end);
    }

    /**
    * Returns the number of l f glbl objective states.
    *
    * @return the number of l f glbl objective states
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFGlblObjectiveStatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.getLFGlblObjectiveStatesCount();
    }

    /**
    * Updates the l f glbl objective state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfGlblObjectiveState the l f glbl objective state
    * @return the l f glbl objective state that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState updateLFGlblObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState lfGlblObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.updateLFGlblObjectiveState(lfGlblObjectiveState);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfGlblObjectiveStateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfGlblObjectiveStateLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfGlblObjectiveStateLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState createLFGlobalObjectiveState()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.createLFGlobalObjectiveState();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.findByTreeID(treeID, start, end);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState findByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException,
            com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlblObjectiveStateLocalService.findByTreeIDAndMapKey(treeID,
            mapKey);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfGlblObjectiveStateLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFGlblObjectiveStateLocalService getWrappedLFGlblObjectiveStateLocalService() {
        return _lfGlblObjectiveStateLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFGlblObjectiveStateLocalService(
        LFGlblObjectiveStateLocalService lfGlblObjectiveStateLocalService) {
        _lfGlblObjectiveStateLocalService = lfGlblObjectiveStateLocalService;
    }

    @Override
    public LFGlblObjectiveStateLocalService getWrappedService() {
        return _lfGlblObjectiveStateLocalService;
    }

    @Override
    public void setWrappedService(
        LFGlblObjectiveStateLocalService lfGlblObjectiveStateLocalService) {
        _lfGlblObjectiveStateLocalService = lfGlblObjectiveStateLocalService;
    }
}

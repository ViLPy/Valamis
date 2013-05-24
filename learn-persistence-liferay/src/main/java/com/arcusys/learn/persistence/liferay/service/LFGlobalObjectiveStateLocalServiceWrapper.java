package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFGlobalObjectiveStateLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFGlobalObjectiveStateLocalService
 * @generated
 */
public class LFGlobalObjectiveStateLocalServiceWrapper
    implements LFGlobalObjectiveStateLocalService,
        ServiceWrapper<LFGlobalObjectiveStateLocalService> {
    private LFGlobalObjectiveStateLocalService _lfGlobalObjectiveStateLocalService;

    public LFGlobalObjectiveStateLocalServiceWrapper(
        LFGlobalObjectiveStateLocalService lfGlobalObjectiveStateLocalService) {
        _lfGlobalObjectiveStateLocalService = lfGlobalObjectiveStateLocalService;
    }

    /**
    * Adds the l f global objective state to the database. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @return the l f global objective state that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState addLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.addLFGlobalObjectiveState(lfGlobalObjectiveState);
    }

    /**
    * Creates a new l f global objective state with the primary key. Does not add the l f global objective state to the database.
    *
    * @param id the primary key for the new l f global objective state
    * @return the new l f global objective state
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState createLFGlobalObjectiveState(
        long id) {
        return _lfGlobalObjectiveStateLocalService.createLFGlobalObjectiveState(id);
    }

    /**
    * Deletes the l f global objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state that was removed
    * @throws PortalException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState deleteLFGlobalObjectiveState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.deleteLFGlobalObjectiveState(id);
    }

    /**
    * Deletes the l f global objective state from the database. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @return the l f global objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState deleteLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.deleteLFGlobalObjectiveState(lfGlobalObjectiveState);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfGlobalObjectiveStateLocalService.dynamicQuery();
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
        return _lfGlobalObjectiveStateLocalService.dynamicQuery(dynamicQuery);
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
        return _lfGlobalObjectiveStateLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _lfGlobalObjectiveStateLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _lfGlobalObjectiveStateLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchLFGlobalObjectiveState(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.fetchLFGlobalObjectiveState(id);
    }

    /**
    * Returns the l f global objective state with the primary key.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state
    * @throws PortalException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState getLFGlobalObjectiveState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.getLFGlobalObjectiveState(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f global objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @return the range of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> getLFGlobalObjectiveStates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.getLFGlobalObjectiveStates(start,
            end);
    }

    /**
    * Returns the number of l f global objective states.
    *
    * @return the number of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public int getLFGlobalObjectiveStatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.getLFGlobalObjectiveStatesCount();
    }

    /**
    * Updates the l f global objective state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @return the l f global objective state that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState updateLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.updateLFGlobalObjectiveState(lfGlobalObjectiveState);
    }

    /**
    * Updates the l f global objective state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @param merge whether to merge the l f global objective state with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f global objective state that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState updateLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.updateLFGlobalObjectiveState(lfGlobalObjectiveState,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfGlobalObjectiveStateLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfGlobalObjectiveStateLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfGlobalObjectiveStateLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState createLFGlobalObjectiveState()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.createLFGlobalObjectiveState();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.findByTreeID(treeID, start,
            end);
    }

    public com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfGlobalObjectiveStateLocalService.findByTreeIDAndMapKey(treeID,
            mapKey);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfGlobalObjectiveStateLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFGlobalObjectiveStateLocalService getWrappedLFGlobalObjectiveStateLocalService() {
        return _lfGlobalObjectiveStateLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFGlobalObjectiveStateLocalService(
        LFGlobalObjectiveStateLocalService lfGlobalObjectiveStateLocalService) {
        _lfGlobalObjectiveStateLocalService = lfGlobalObjectiveStateLocalService;
    }

    public LFGlobalObjectiveStateLocalService getWrappedService() {
        return _lfGlobalObjectiveStateLocalService;
    }

    public void setWrappedService(
        LFGlobalObjectiveStateLocalService lfGlobalObjectiveStateLocalService) {
        _lfGlobalObjectiveStateLocalService = lfGlobalObjectiveStateLocalService;
    }
}

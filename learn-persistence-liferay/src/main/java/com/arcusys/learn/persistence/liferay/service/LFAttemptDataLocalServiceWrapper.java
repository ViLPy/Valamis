package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFAttemptDataLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFAttemptDataLocalService
 * @generated
 */
public class LFAttemptDataLocalServiceWrapper
    implements LFAttemptDataLocalService,
        ServiceWrapper<LFAttemptDataLocalService> {
    private LFAttemptDataLocalService _lfAttemptDataLocalService;

    public LFAttemptDataLocalServiceWrapper(
        LFAttemptDataLocalService lfAttemptDataLocalService) {
        _lfAttemptDataLocalService = lfAttemptDataLocalService;
    }

    /**
    * Adds the l f attempt data to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @return the l f attempt data that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData addLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.addLFAttemptData(lfAttemptData);
    }

    /**
    * Creates a new l f attempt data with the primary key. Does not add the l f attempt data to the database.
    *
    * @param id the primary key for the new l f attempt data
    * @return the new l f attempt data
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData createLFAttemptData(
        long id) {
        return _lfAttemptDataLocalService.createLFAttemptData(id);
    }

    /**
    * Deletes the l f attempt data with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data that was removed
    * @throws PortalException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData deleteLFAttemptData(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.deleteLFAttemptData(id);
    }

    /**
    * Deletes the l f attempt data from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @return the l f attempt data that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData deleteLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.deleteLFAttemptData(lfAttemptData);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfAttemptDataLocalService.dynamicQuery();
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
        return _lfAttemptDataLocalService.dynamicQuery(dynamicQuery);
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
        return _lfAttemptDataLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfAttemptDataLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfAttemptDataLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchLFAttemptData(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.fetchLFAttemptData(id);
    }

    /**
    * Returns the l f attempt data with the primary key.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data
    * @throws PortalException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData getLFAttemptData(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.getLFAttemptData(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f attempt datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> getLFAttemptDatas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.getLFAttemptDatas(start, end);
    }

    /**
    * Returns the number of l f attempt datas.
    *
    * @return the number of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public int getLFAttemptDatasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.getLFAttemptDatasCount();
    }

    /**
    * Updates the l f attempt data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @return the l f attempt data that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData updateLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.updateLFAttemptData(lfAttemptData);
    }

    /**
    * Updates the l f attempt data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @param merge whether to merge the l f attempt data with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f attempt data that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFAttemptData updateLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.updateLFAttemptData(lfAttemptData,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfAttemptDataLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfAttemptDataLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfAttemptDataLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFAttemptData createLFAttemptData()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.createLFAttemptData();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.findByAttemptIDWithActivityID(attemptID,
            activityID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.findByAttemptIDWithDataKey(attemptID,
            dataKey);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.findBySingleKey(attemptID,
            activityID, dataKey, start, end);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfAttemptDataLocalService.findByCollectionValues(attemptID,
            activityID, dataKey);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAttemptDataLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFAttemptDataLocalService getWrappedLFAttemptDataLocalService() {
        return _lfAttemptDataLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFAttemptDataLocalService(
        LFAttemptDataLocalService lfAttemptDataLocalService) {
        _lfAttemptDataLocalService = lfAttemptDataLocalService;
    }

    public LFAttemptDataLocalService getWrappedService() {
        return _lfAttemptDataLocalService;
    }

    public void setWrappedService(
        LFAttemptDataLocalService lfAttemptDataLocalService) {
        _lfAttemptDataLocalService = lfAttemptDataLocalService;
    }
}

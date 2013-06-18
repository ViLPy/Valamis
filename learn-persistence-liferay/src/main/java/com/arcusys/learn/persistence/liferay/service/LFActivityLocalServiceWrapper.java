package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFActivityLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFActivityLocalService
 * @generated
 */
public class LFActivityLocalServiceWrapper implements LFActivityLocalService,
    ServiceWrapper<LFActivityLocalService> {
    private LFActivityLocalService _lfActivityLocalService;

    public LFActivityLocalServiceWrapper(
        LFActivityLocalService lfActivityLocalService) {
        _lfActivityLocalService = lfActivityLocalService;
    }

    /**
    * Adds the l f activity to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @return the l f activity that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity addLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.addLFActivity(lfActivity);
    }

    /**
    * Creates a new l f activity with the primary key. Does not add the l f activity to the database.
    *
    * @param indexNumber the primary key for the new l f activity
    * @return the new l f activity
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity createLFActivity(
        long indexNumber) {
        return _lfActivityLocalService.createLFActivity(indexNumber);
    }

    /**
    * Deletes the l f activity with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity that was removed
    * @throws PortalException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity deleteLFActivity(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.deleteLFActivity(indexNumber);
    }

    /**
    * Deletes the l f activity from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @return the l f activity that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity deleteLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.deleteLFActivity(lfActivity);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfActivityLocalService.dynamicQuery();
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
        return _lfActivityLocalService.dynamicQuery(dynamicQuery);
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
        return _lfActivityLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _lfActivityLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _lfActivityLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFActivity fetchLFActivity(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.fetchLFActivity(indexNumber);
    }

    /**
    * Returns the l f activity with the primary key.
    *
    * @param indexNumber the primary key of the l f activity
    * @return the l f activity
    * @throws PortalException if a l f activity with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity getLFActivity(
        long indexNumber)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.getLFActivity(indexNumber);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activities.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activities
    * @param end the upper bound of the range of l f activities (not inclusive)
    * @return the range of l f activities
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> getLFActivities(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.getLFActivities(start, end);
    }

    /**
    * Returns the number of l f activities.
    *
    * @return the number of l f activities
    * @throws SystemException if a system exception occurred
    */
    public int getLFActivitiesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.getLFActivitiesCount();
    }

    /**
    * Updates the l f activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @return the l f activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity updateLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.updateLFActivity(lfActivity);
    }

    /**
    * Updates the l f activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivity the l f activity
    * @param merge whether to merge the l f activity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f activity that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFActivity updateLFActivity(
        com.arcusys.learn.persistence.liferay.model.LFActivity lfActivity,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.updateLFActivity(lfActivity, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfActivityLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfActivityLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfActivityLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFActivity createLFActivity()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.createLFActivity();
    }

    public com.arcusys.learn.persistence.liferay.model.LFActivity findByPackageAndID(
        java.lang.Integer packageID, java.lang.String id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.findByPackageAndID(packageID, id);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.findByPackageID(packageID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndOrganizationID(
        java.lang.Integer packageID, java.lang.String organizationID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.findByPackageIDAndOrganizationID(packageID,
            organizationID);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivity> findByPackageIDAndParentID(
        java.lang.Integer packageID, java.lang.String parentID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfActivityLocalService.findByPackageIDAndParentID(packageID,
            parentID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFActivityLocalService getWrappedLFActivityLocalService() {
        return _lfActivityLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFActivityLocalService(
        LFActivityLocalService lfActivityLocalService) {
        _lfActivityLocalService = lfActivityLocalService;
    }

    public LFActivityLocalService getWrappedService() {
        return _lfActivityLocalService;
    }

    public void setWrappedService(LFActivityLocalService lfActivityLocalService) {
        _lfActivityLocalService = lfActivityLocalService;
    }
}

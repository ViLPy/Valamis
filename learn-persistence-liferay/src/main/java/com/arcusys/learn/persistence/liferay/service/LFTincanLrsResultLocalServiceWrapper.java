package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsResultLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanLrsResultLocalService
 * @generated
 */
public class LFTincanLrsResultLocalServiceWrapper
    implements LFTincanLrsResultLocalService,
        ServiceWrapper<LFTincanLrsResultLocalService> {
    private LFTincanLrsResultLocalService _lfTincanLrsResultLocalService;

    public LFTincanLrsResultLocalServiceWrapper(
        LFTincanLrsResultLocalService lfTincanLrsResultLocalService) {
        _lfTincanLrsResultLocalService = lfTincanLrsResultLocalService;
    }

    /**
    * Adds the l f tincan lrs result to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsResult the l f tincan lrs result
    * @return the l f tincan lrs result that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult addLFTincanLrsResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.addLFTincanLrsResult(lfTincanLrsResult);
    }

    /**
    * Creates a new l f tincan lrs result with the primary key. Does not add the l f tincan lrs result to the database.
    *
    * @param id the primary key for the new l f tincan lrs result
    * @return the new l f tincan lrs result
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult createLFTincanLrsResult(
        long id) {
        return _lfTincanLrsResultLocalService.createLFTincanLrsResult(id);
    }

    /**
    * Deletes the l f tincan lrs result with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs result
    * @return the l f tincan lrs result that was removed
    * @throws PortalException if a l f tincan lrs result with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult deleteLFTincanLrsResult(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.deleteLFTincanLrsResult(id);
    }

    /**
    * Deletes the l f tincan lrs result from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsResult the l f tincan lrs result
    * @return the l f tincan lrs result that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult deleteLFTincanLrsResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.deleteLFTincanLrsResult(lfTincanLrsResult);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsResultLocalService.dynamicQuery();
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
        return _lfTincanLrsResultLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanLrsResultLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfTincanLrsResultLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfTincanLrsResultLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult fetchLFTincanLrsResult(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.fetchLFTincanLrsResult(id);
    }

    /**
    * Returns the l f tincan lrs result with the primary key.
    *
    * @param id the primary key of the l f tincan lrs result
    * @return the l f tincan lrs result
    * @throws PortalException if a l f tincan lrs result with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult getLFTincanLrsResult(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.getLFTincanLrsResult(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs results.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs results
    * @param end the upper bound of the range of l f tincan lrs results (not inclusive)
    * @return the range of l f tincan lrs results
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult> getLFTincanLrsResults(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.getLFTincanLrsResults(start, end);
    }

    /**
    * Returns the number of l f tincan lrs results.
    *
    * @return the number of l f tincan lrs results
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanLrsResultsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.getLFTincanLrsResultsCount();
    }

    /**
    * Updates the l f tincan lrs result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsResult the l f tincan lrs result
    * @return the l f tincan lrs result that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult updateLFTincanLrsResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.updateLFTincanLrsResult(lfTincanLrsResult);
    }

    /**
    * Updates the l f tincan lrs result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsResult the l f tincan lrs result
    * @param merge whether to merge the l f tincan lrs result with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan lrs result that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult updateLFTincanLrsResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult lfTincanLrsResult,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.updateLFTincanLrsResult(lfTincanLrsResult,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsResultLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsResultLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsResultLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsResultLocalService.removeAll();
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult createLFTincanLrsResult()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsResultLocalService.createLFTincanLrsResult();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanLrsResultLocalService getWrappedLFTincanLrsResultLocalService() {
        return _lfTincanLrsResultLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsResultLocalService(
        LFTincanLrsResultLocalService lfTincanLrsResultLocalService) {
        _lfTincanLrsResultLocalService = lfTincanLrsResultLocalService;
    }

    public LFTincanLrsResultLocalService getWrappedService() {
        return _lfTincanLrsResultLocalService;
    }

    public void setWrappedService(
        LFTincanLrsResultLocalService lfTincanLrsResultLocalService) {
        _lfTincanLrsResultLocalService = lfTincanLrsResultLocalService;
    }
}

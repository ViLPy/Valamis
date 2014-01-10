package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsAgentProfileLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFTincanLrsAgentProfileLocalService
 * @generated
 */
public class LFTincanLrsAgentProfileLocalServiceWrapper
    implements LFTincanLrsAgentProfileLocalService,
        ServiceWrapper<LFTincanLrsAgentProfileLocalService> {
    private LFTincanLrsAgentProfileLocalService _lfTincanLrsAgentProfileLocalService;

    public LFTincanLrsAgentProfileLocalServiceWrapper(
        LFTincanLrsAgentProfileLocalService lfTincanLrsAgentProfileLocalService) {
        _lfTincanLrsAgentProfileLocalService = lfTincanLrsAgentProfileLocalService;
    }

    /**
    * Adds the l f tincan lrs agent profile to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAgentProfile the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile addLFTincanLrsAgentProfile(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.addLFTincanLrsAgentProfile(lfTincanLrsAgentProfile);
    }

    /**
    * Creates a new l f tincan lrs agent profile with the primary key. Does not add the l f tincan lrs agent profile to the database.
    *
    * @param id the primary key for the new l f tincan lrs agent profile
    * @return the new l f tincan lrs agent profile
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile createLFTincanLrsAgentProfile(
        long id) {
        return _lfTincanLrsAgentProfileLocalService.createLFTincanLrsAgentProfile(id);
    }

    /**
    * Deletes the l f tincan lrs agent profile with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile that was removed
    * @throws PortalException if a l f tincan lrs agent profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile deleteLFTincanLrsAgentProfile(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.deleteLFTincanLrsAgentProfile(id);
    }

    /**
    * Deletes the l f tincan lrs agent profile from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAgentProfile the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile deleteLFTincanLrsAgentProfile(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.deleteLFTincanLrsAgentProfile(lfTincanLrsAgentProfile);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanLrsAgentProfileLocalService.dynamicQuery();
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
        return _lfTincanLrsAgentProfileLocalService.dynamicQuery(dynamicQuery);
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
        return _lfTincanLrsAgentProfileLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsAgentProfileLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanLrsAgentProfileLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile fetchLFTincanLrsAgentProfile(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.fetchLFTincanLrsAgentProfile(id);
    }

    /**
    * Returns the l f tincan lrs agent profile with the primary key.
    *
    * @param id the primary key of the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile
    * @throws PortalException if a l f tincan lrs agent profile with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile getLFTincanLrsAgentProfile(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.getLFTincanLrsAgentProfile(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan lrs agent profiles.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs agent profiles
    * @param end the upper bound of the range of l f tincan lrs agent profiles (not inclusive)
    * @return the range of l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> getLFTincanLrsAgentProfiles(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.getLFTincanLrsAgentProfiles(start,
            end);
    }

    /**
    * Returns the number of l f tincan lrs agent profiles.
    *
    * @return the number of l f tincan lrs agent profiles
    * @throws SystemException if a system exception occurred
    */
    public int getLFTincanLrsAgentProfilesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.getLFTincanLrsAgentProfilesCount();
    }

    /**
    * Updates the l f tincan lrs agent profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAgentProfile the l f tincan lrs agent profile
    * @return the l f tincan lrs agent profile that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile updateLFTincanLrsAgentProfile(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.updateLFTincanLrsAgentProfile(lfTincanLrsAgentProfile);
    }

    /**
    * Updates the l f tincan lrs agent profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanLrsAgentProfile the l f tincan lrs agent profile
    * @param merge whether to merge the l f tincan lrs agent profile with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f tincan lrs agent profile that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile updateLFTincanLrsAgentProfile(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile lfTincanLrsAgentProfile,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.updateLFTincanLrsAgentProfile(lfTincanLrsAgentProfile,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfTincanLrsAgentProfileLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanLrsAgentProfileLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanLrsAgentProfileLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile createLFTincanLrsActivityProfile(
        java.lang.Integer agentId, java.lang.String profileId,
        java.lang.Integer documentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.createLFTincanLrsActivityProfile(agentId,
            profileId, documentId);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile> findByProfileId(
        java.lang.String profileId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.findByProfileId(profileId);
    }

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile findByAgentIdAndProfileId(
        java.lang.Integer agentId, java.lang.String profileId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanLrsAgentProfileLocalService.findByAgentIdAndProfileId(agentId,
            profileId);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsAgentProfileLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFTincanLrsAgentProfileLocalService getWrappedLFTincanLrsAgentProfileLocalService() {
        return _lfTincanLrsAgentProfileLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFTincanLrsAgentProfileLocalService(
        LFTincanLrsAgentProfileLocalService lfTincanLrsAgentProfileLocalService) {
        _lfTincanLrsAgentProfileLocalService = lfTincanLrsAgentProfileLocalService;
    }

    public LFTincanLrsAgentProfileLocalService getWrappedService() {
        return _lfTincanLrsAgentProfileLocalService;
    }

    public void setWrappedService(
        LFTincanLrsAgentProfileLocalService lfTincanLrsAgentProfileLocalService) {
        _lfTincanLrsAgentProfileLocalService = lfTincanLrsAgentProfileLocalService;
    }
}

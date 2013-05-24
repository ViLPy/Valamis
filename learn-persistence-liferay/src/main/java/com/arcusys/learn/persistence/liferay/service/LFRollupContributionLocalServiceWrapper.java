package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFRollupContributionLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFRollupContributionLocalService
 * @generated
 */
public class LFRollupContributionLocalServiceWrapper
    implements LFRollupContributionLocalService,
        ServiceWrapper<LFRollupContributionLocalService> {
    private LFRollupContributionLocalService _lfRollupContributionLocalService;

    public LFRollupContributionLocalServiceWrapper(
        LFRollupContributionLocalService lfRollupContributionLocalService) {
        _lfRollupContributionLocalService = lfRollupContributionLocalService;
    }

    /**
    * Adds the l f rollup contribution to the database. Also notifies the appropriate model listeners.
    *
    * @param lfRollupContribution the l f rollup contribution
    * @return the l f rollup contribution that was added
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution addLFRollupContribution(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.addLFRollupContribution(lfRollupContribution);
    }

    /**
    * Creates a new l f rollup contribution with the primary key. Does not add the l f rollup contribution to the database.
    *
    * @param id the primary key for the new l f rollup contribution
    * @return the new l f rollup contribution
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution createLFRollupContribution(
        long id) {
        return _lfRollupContributionLocalService.createLFRollupContribution(id);
    }

    /**
    * Deletes the l f rollup contribution with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f rollup contribution
    * @return the l f rollup contribution that was removed
    * @throws PortalException if a l f rollup contribution with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution deleteLFRollupContribution(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.deleteLFRollupContribution(id);
    }

    /**
    * Deletes the l f rollup contribution from the database. Also notifies the appropriate model listeners.
    *
    * @param lfRollupContribution the l f rollup contribution
    * @return the l f rollup contribution that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution deleteLFRollupContribution(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.deleteLFRollupContribution(lfRollupContribution);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfRollupContributionLocalService.dynamicQuery();
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
        return _lfRollupContributionLocalService.dynamicQuery(dynamicQuery);
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
        return _lfRollupContributionLocalService.dynamicQuery(dynamicQuery,
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
        return _lfRollupContributionLocalService.dynamicQuery(dynamicQuery,
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
        return _lfRollupContributionLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution fetchLFRollupContribution(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.fetchLFRollupContribution(id);
    }

    /**
    * Returns the l f rollup contribution with the primary key.
    *
    * @param id the primary key of the l f rollup contribution
    * @return the l f rollup contribution
    * @throws PortalException if a l f rollup contribution with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution getLFRollupContribution(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.getLFRollupContribution(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f rollup contributions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f rollup contributions
    * @param end the upper bound of the range of l f rollup contributions (not inclusive)
    * @return the range of l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFRollupContribution> getLFRollupContributions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.getLFRollupContributions(start,
            end);
    }

    /**
    * Returns the number of l f rollup contributions.
    *
    * @return the number of l f rollup contributions
    * @throws SystemException if a system exception occurred
    */
    public int getLFRollupContributionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.getLFRollupContributionsCount();
    }

    /**
    * Updates the l f rollup contribution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRollupContribution the l f rollup contribution
    * @return the l f rollup contribution that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution updateLFRollupContribution(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.updateLFRollupContribution(lfRollupContribution);
    }

    /**
    * Updates the l f rollup contribution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfRollupContribution the l f rollup contribution
    * @param merge whether to merge the l f rollup contribution with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f rollup contribution that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution updateLFRollupContribution(
        com.arcusys.learn.persistence.liferay.model.LFRollupContribution lfRollupContribution,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.updateLFRollupContribution(lfRollupContribution,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfRollupContributionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfRollupContributionLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfRollupContributionLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution createLFRollupContribution()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.createLFRollupContribution();
    }

    public com.arcusys.learn.persistence.liferay.model.LFRollupContribution findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfRollupContributionLocalService.findBySequencingID(sequencingID);
    }

    public void removeBySequencingID(java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFRollupContributionException,
            com.liferay.portal.kernel.exception.SystemException {
        _lfRollupContributionLocalService.removeBySequencingID(sequencingID);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRollupContributionLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFRollupContributionLocalService getWrappedLFRollupContributionLocalService() {
        return _lfRollupContributionLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFRollupContributionLocalService(
        LFRollupContributionLocalService lfRollupContributionLocalService) {
        _lfRollupContributionLocalService = lfRollupContributionLocalService;
    }

    public LFRollupContributionLocalService getWrappedService() {
        return _lfRollupContributionLocalService;
    }

    public void setWrappedService(
        LFRollupContributionLocalService lfRollupContributionLocalService) {
        _lfRollupContributionLocalService = lfRollupContributionLocalService;
    }
}

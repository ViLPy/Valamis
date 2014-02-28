package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFTincanClientApiStorageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanClientApiStorageLocalService
 * @generated
 */
public class LFTincanClientApiStorageLocalServiceWrapper
    implements LFTincanClientApiStorageLocalService,
        ServiceWrapper<LFTincanClientApiStorageLocalService> {
    private LFTincanClientApiStorageLocalService _lfTincanClientApiStorageLocalService;

    public LFTincanClientApiStorageLocalServiceWrapper(
        LFTincanClientApiStorageLocalService lfTincanClientApiStorageLocalService) {
        _lfTincanClientApiStorageLocalService = lfTincanClientApiStorageLocalService;
    }

    /**
    * Adds the l f tincan client api storage to the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanClientApiStorage the l f tincan client api storage
    * @return the l f tincan client api storage that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage addLFTincanClientApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage lfTincanClientApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.addLFTincanClientApiStorage(lfTincanClientApiStorage);
    }

    /**
    * Creates a new l f tincan client api storage with the primary key. Does not add the l f tincan client api storage to the database.
    *
    * @param id the primary key for the new l f tincan client api storage
    * @return the new l f tincan client api storage
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage createLFTincanClientApiStorage(
        long id) {
        return _lfTincanClientApiStorageLocalService.createLFTincanClientApiStorage(id);
    }

    /**
    * Deletes the l f tincan client api storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan client api storage
    * @return the l f tincan client api storage that was removed
    * @throws PortalException if a l f tincan client api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage deleteLFTincanClientApiStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.deleteLFTincanClientApiStorage(id);
    }

    /**
    * Deletes the l f tincan client api storage from the database. Also notifies the appropriate model listeners.
    *
    * @param lfTincanClientApiStorage the l f tincan client api storage
    * @return the l f tincan client api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage deleteLFTincanClientApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage lfTincanClientApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.deleteLFTincanClientApiStorage(lfTincanClientApiStorage);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfTincanClientApiStorageLocalService.dynamicQuery();
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
        return _lfTincanClientApiStorageLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanClientApiStorageLocalService.dynamicQuery(dynamicQuery,
            start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfTincanClientApiStorageLocalService.dynamicQuery(dynamicQuery,
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
        return _lfTincanClientApiStorageLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfTincanClientApiStorageLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage fetchLFTincanClientApiStorage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.fetchLFTincanClientApiStorage(id);
    }

    /**
    * Returns the l f tincan client api storage with the primary key.
    *
    * @param id the primary key of the l f tincan client api storage
    * @return the l f tincan client api storage
    * @throws PortalException if a l f tincan client api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage getLFTincanClientApiStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.getLFTincanClientApiStorage(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f tincan client api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanClientApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan client api storages
    * @param end the upper bound of the range of l f tincan client api storages (not inclusive)
    * @return the range of l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage> getLFTincanClientApiStorages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.getLFTincanClientApiStorages(start,
            end);
    }

    /**
    * Returns the number of l f tincan client api storages.
    *
    * @return the number of l f tincan client api storages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFTincanClientApiStoragesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.getLFTincanClientApiStoragesCount();
    }

    /**
    * Updates the l f tincan client api storage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfTincanClientApiStorage the l f tincan client api storage
    * @return the l f tincan client api storage that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage updateLFTincanClientApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage lfTincanClientApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.updateLFTincanClientApiStorage(lfTincanClientApiStorage);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfTincanClientApiStorageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfTincanClientApiStorageLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfTincanClientApiStorageLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage findByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.findByToken(token);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage findByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTincanClientApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfTincanClientApiStorageLocalService.findByCode(code);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFTincanClientApiStorageLocalService getWrappedLFTincanClientApiStorageLocalService() {
        return _lfTincanClientApiStorageLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFTincanClientApiStorageLocalService(
        LFTincanClientApiStorageLocalService lfTincanClientApiStorageLocalService) {
        _lfTincanClientApiStorageLocalService = lfTincanClientApiStorageLocalService;
    }

    @Override
    public LFTincanClientApiStorageLocalService getWrappedService() {
        return _lfTincanClientApiStorageLocalService;
    }

    @Override
    public void setWrappedService(
        LFTincanClientApiStorageLocalService lfTincanClientApiStorageLocalService) {
        _lfTincanClientApiStorageLocalService = lfTincanClientApiStorageLocalService;
    }
}

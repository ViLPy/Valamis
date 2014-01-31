package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LFFileStorageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LFFileStorageLocalService
 * @generated
 */
public class LFFileStorageLocalServiceWrapper
    implements LFFileStorageLocalService,
        ServiceWrapper<LFFileStorageLocalService> {
    private LFFileStorageLocalService _lfFileStorageLocalService;

    public LFFileStorageLocalServiceWrapper(
        LFFileStorageLocalService lfFileStorageLocalService) {
        _lfFileStorageLocalService = lfFileStorageLocalService;
    }

    /**
    * Adds the l f file storage to the database. Also notifies the appropriate model listeners.
    *
    * @param lfFileStorage the l f file storage
    * @return the l f file storage that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage addLFFileStorage(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.addLFFileStorage(lfFileStorage);
    }

    /**
    * Creates a new l f file storage with the primary key. Does not add the l f file storage to the database.
    *
    * @param id the primary key for the new l f file storage
    * @return the new l f file storage
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage createLFFileStorage(
        long id) {
        return _lfFileStorageLocalService.createLFFileStorage(id);
    }

    /**
    * Deletes the l f file storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage that was removed
    * @throws PortalException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage deleteLFFileStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.deleteLFFileStorage(id);
    }

    /**
    * Deletes the l f file storage from the database. Also notifies the appropriate model listeners.
    *
    * @param lfFileStorage the l f file storage
    * @return the l f file storage that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage deleteLFFileStorage(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.deleteLFFileStorage(lfFileStorage);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _lfFileStorageLocalService.dynamicQuery();
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
        return _lfFileStorageLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfFileStorageLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _lfFileStorageLocalService.dynamicQuery(dynamicQuery, start,
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
        return _lfFileStorageLocalService.dynamicQueryCount(dynamicQuery);
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
        return _lfFileStorageLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage fetchLFFileStorage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.fetchLFFileStorage(id);
    }

    /**
    * Returns the l f file storage with the primary key.
    *
    * @param id the primary key of the l f file storage
    * @return the l f file storage
    * @throws PortalException if a l f file storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage getLFFileStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.getLFFileStorage(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f file storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFFileStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of l f file storages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> getLFFileStorages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.getLFFileStorages(start, end);
    }

    /**
    * Returns the number of l f file storages.
    *
    * @return the number of l f file storages
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getLFFileStoragesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.getLFFileStoragesCount();
    }

    /**
    * Updates the l f file storage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfFileStorage the l f file storage
    * @return the l f file storage that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage updateLFFileStorage(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.updateLFFileStorage(lfFileStorage);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _lfFileStorageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfFileStorageLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfFileStorageLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage createLFFileStorage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.createLFFileStorage();
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.findByFilename(filename);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.findByFilename(filename, start, end);
    }

    @Override
    public void removeByFilename(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorageLocalService.removeByFilename(filename);
    }

    @Override
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.findByDirectory(filename);
    }

    @Override
    public void removeByDirectory(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorageLocalService.removeByDirectory(filename);
    }

    @Override
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorageLocalService.removeAll();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LFFileStorageLocalService getWrappedLFFileStorageLocalService() {
        return _lfFileStorageLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLFFileStorageLocalService(
        LFFileStorageLocalService lfFileStorageLocalService) {
        _lfFileStorageLocalService = lfFileStorageLocalService;
    }

    @Override
    public LFFileStorageLocalService getWrappedService() {
        return _lfFileStorageLocalService;
    }

    @Override
    public void setWrappedService(
        LFFileStorageLocalService lfFileStorageLocalService) {
        _lfFileStorageLocalService = lfFileStorageLocalService;
    }
}

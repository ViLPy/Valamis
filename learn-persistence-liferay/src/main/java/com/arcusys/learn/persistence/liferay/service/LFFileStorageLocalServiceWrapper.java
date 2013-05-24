package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LFFileStorageLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LFFileStorageLocalService
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
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage deleteLFFileStorage(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.deleteLFFileStorage(lfFileStorage);
    }

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
        return _lfFileStorageLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.dynamicQueryCount(dynamicQuery);
    }

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
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage getLFFileStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.getLFFileStorage(id);
    }

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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f file storages
    * @param end the upper bound of the range of l f file storages (not inclusive)
    * @return the range of l f file storages
    * @throws SystemException if a system exception occurred
    */
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
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage updateLFFileStorage(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.updateLFFileStorage(lfFileStorage);
    }

    /**
    * Updates the l f file storage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfFileStorage the l f file storage
    * @param merge whether to merge the l f file storage with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f file storage that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFFileStorage updateLFFileStorage(
        com.arcusys.learn.persistence.liferay.model.LFFileStorage lfFileStorage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.updateLFFileStorage(lfFileStorage,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _lfFileStorageLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _lfFileStorageLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _lfFileStorageLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.arcusys.learn.persistence.liferay.model.LFFileStorage createLFFileStorage()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.createLFFileStorage();
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.findByFilename(filename);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
        java.lang.String filename, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.findByFilename(filename, start, end);
    }

    public void removeByFilename(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorageLocalService.removeByFilename(filename);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
        java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _lfFileStorageLocalService.findByDirectory(filename);
    }

    public void removeByDirectory(java.lang.String filename)
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorageLocalService.removeByDirectory(filename);
    }

    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfFileStorageLocalService.removeAll();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LFFileStorageLocalService getWrappedLFFileStorageLocalService() {
        return _lfFileStorageLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLFFileStorageLocalService(
        LFFileStorageLocalService lfFileStorageLocalService) {
        _lfFileStorageLocalService = lfFileStorageLocalService;
    }

    public LFFileStorageLocalService getWrappedService() {
        return _lfFileStorageLocalService;
    }

    public void setWrappedService(
        LFFileStorageLocalService lfFileStorageLocalService) {
        _lfFileStorageLocalService = lfFileStorageLocalService;
    }
}

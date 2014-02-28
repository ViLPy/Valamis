package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFFileStorage;
import com.arcusys.learn.persistence.liferay.service.base.LFFileStorageLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the file storage local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFFileStorageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFFileStorageLocalServiceUtil
 */
public class LFFileStorageLocalServiceImpl extends LFFileStorageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.FileStorageLocalServiceUtil} to access the file storage local service.
     */

    public LFFileStorage createLFFileStorage() throws SystemException {
        return createLFFileStorage(counterLocalService.increment(LFFileStorage.class.getName()));
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
            java.lang.String filename)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfFileStoragePersistence.findByFilename(filename);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByFilename(
            java.lang.String filename, int start, int end)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfFileStoragePersistence.findByFilename(filename, start, end);
    }

    public void removeByFilename(java.lang.String filename)
            throws com.liferay.portal.kernel.exception.SystemException {
        lfFileStoragePersistence.removeByFilename(filename);
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFFileStorage> findByDirectory(
            java.lang.String filename)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfFileStoragePersistence.findByDirectory(filename);
    }

    public void removeByDirectory(java.lang.String filename)
            throws com.liferay.portal.kernel.exception.SystemException {
        lfFileStoragePersistence.removeByDirectory(filename);
    }

    public void removeAll() throws SystemException {
        lfFileStoragePersistence.removeAll();
    }

    @Override
    public LFFileStorage getLFFileStorage(final long id) throws PortalException, SystemException {
        try {
            return super.getLFFileStorage(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

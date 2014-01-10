package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActivityException;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanManifestActivityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan manifest activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanManifestActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanManifestActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanManifestActivityLocalServiceUtil
 */
public class LFTincanManifestActivityLocalServiceImpl
    extends LFTincanManifestActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanManifestActivityLocalServiceUtil} to access the l f tincan manifest activity local service.
     */

    public void removeAll() throws SystemException {
        lfTincanActivityPersistence.removeAll();
    }

    public LFTincanManifestActivity createLFTincanManifestActivity() throws SystemException {
        return createLFTincanManifestActivity(counterLocalService.increment(LFTincanManifestActivity.class.getName()));
    }

    public  java.util.List<LFTincanManifestActivity> findByPackageID(Long packageID) throws SystemException{
        return lfTincanManifestActivityPersistence.findByPackageID(packageID);
    }

    public LFTincanManifestActivity findByTincanID(String tincanID) throws SystemException, NoSuchLFTincanManifestActivityException {
        return lfTincanManifestActivityPersistence.findByTincanID(tincanID);
    }
}

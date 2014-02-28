package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanManifestActException;
import com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanManifestActLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan manifest act local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanManifestActLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil
 */
public class LFTincanManifestActLocalServiceImpl
    extends LFTincanManifestActLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil} to access the l f tincan manifest act local service.
     */

    public void removeAll() throws SystemException {
        lfTincanActivityPersistence.removeAll();
    }

    public LFTincanManifestAct createLFTincanManifestActivity() throws SystemException {
        return createLFTincanManifestAct(counterLocalService.increment(LFTincanManifestAct.class.getName()));
    }

    public  java.util.List<LFTincanManifestAct> findByPackageID(Long packageID) throws SystemException{
        return lfTincanManifestActPersistence.findByPackageID(packageID);
    }

    public LFTincanManifestAct findByTincanID(String tincanID) throws SystemException, NoSuchLFTincanManifestActException {
        return lfTincanManifestActPersistence.findByTincanID(tincanID);
    }
}

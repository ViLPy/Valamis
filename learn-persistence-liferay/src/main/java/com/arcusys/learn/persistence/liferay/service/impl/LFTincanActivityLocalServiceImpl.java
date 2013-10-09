package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivity;
import com.arcusys.learn.persistence.liferay.model.LFTincanActivity;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanActivityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan activity local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil
 */
public class LFTincanActivityLocalServiceImpl
        extends LFTincanActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil} to access the l f tincan activity local service.
     */

    public void removeAll() throws SystemException {
        lfTincanActivityPersistence.removeAll();
    }

    public LFTincanActivity createLFTincanActivity() throws SystemException {
        return createLFTincanActivity(counterLocalService.increment(LFActivity.class.getName()));
    }

    public  java.util.List<LFTincanActivity> findByPackageID(Long packageID) throws SystemException{
        return lfTincanActivityPersistence.findByPackageID(packageID);
    }
}

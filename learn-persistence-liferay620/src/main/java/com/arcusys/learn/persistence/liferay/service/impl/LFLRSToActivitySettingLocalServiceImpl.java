package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFLRSToActivitySetting;
import com.arcusys.learn.persistence.liferay.service.base.LFLRSToActivitySettingLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f l r s to activity setting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFLRSToActivitySettingLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalServiceUtil
 */
public class LFLRSToActivitySettingLocalServiceImpl
    extends LFLRSToActivitySettingLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFLRSToActivitySettingLocalServiceUtil} to access the l f l r s to activity setting local service.
     */

    public LFLRSToActivitySetting createLFLRSToActivitySetting() throws SystemException {
        return createLFLRSToActivitySetting(counterLocalService.increment(LFLRSToActivitySetting.class.getName()));
    }

    public java.util.List<LFLRSToActivitySetting> findByCourseID(Integer id)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lflrsToActivitySettingPersistence.findByCourseID(id);
    }

    public void removeAll() throws SystemException {
        lflrsToActivitySettingPersistence.removeAll();
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificate;
import com.arcusys.learn.persistence.liferay.model.LFSetting;
import com.arcusys.learn.persistence.liferay.service.base.LFSettingLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f setting local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSettingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSettingLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSettingLocalServiceUtil
 */
public class LFSettingLocalServiceImpl extends LFSettingLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFSettingLocalServiceUtil} to access the l f setting local service.
     */
    public LFSetting createLFSetting() throws SystemException {
        return createLFSetting(counterLocalService.increment(LFSetting.class.getName()));
    }

    public LFSetting findByKey(String key)
            throws com.liferay.portal.kernel.exception.SystemException{
        return lfSettingPersistence.fetchByKey(key);
    }

    public void removeAll() throws SystemException {
        lfSettingPersistence.removeAll();
    }
}

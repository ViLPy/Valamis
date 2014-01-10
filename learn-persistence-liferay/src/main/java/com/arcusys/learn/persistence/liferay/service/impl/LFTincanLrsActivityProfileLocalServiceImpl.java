package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsActivityProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsActivityProfileLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs activity profile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsActivityProfileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsActivityProfileLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsActivityProfileLocalServiceUtil
 */
public class LFTincanLrsActivityProfileLocalServiceImpl
    extends LFTincanLrsActivityProfileLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsActivityProfileLocalServiceUtil} to access the l f tincan lrs activity profile local service.
     */


    public LFTincanLrsActivityProfile findByActivityIdAndProfileId(String activityId, String profileId) throws NoSuchLFTincanLrsActivityProfileException, SystemException {
        return lfTincanLrsActivityProfilePersistence.findByActivityIdAndProfileId(activityId, profileId);
    }

    public LFTincanLrsActivityProfile createLFTincanLrsActivityProfile(String activityId, String profileId, Integer documentId) throws SystemException {
        LFTincanLrsActivityProfile activityProfile = createLFTincanLrsActivityProfile(counterLocalService.increment(LFTincanLrsActivityProfile.class.getName()));
        activityProfile.setActivityId(activityId);
        activityProfile.setProfileId(profileId);
        activityProfile.setDocumentId(documentId);
        lfTincanLrsActivityProfilePersistence.update(activityProfile, false);
        return activityProfile;
    }

    public void removeAll() throws SystemException {
        lfTincanLrsActivityProfilePersistence.removeAll();
    }
}

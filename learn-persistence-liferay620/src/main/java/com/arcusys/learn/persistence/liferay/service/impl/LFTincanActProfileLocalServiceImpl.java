package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanActProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanActProfile;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanActProfileLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f tincan act profile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanActProfileLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalServiceUtil
 */
public class LFTincanActProfileLocalServiceImpl
    extends LFTincanActProfileLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanActProfileLocalServiceUtil} to access the l f tincan act profile local service.
     */

    public LFTincanActProfile findByActivityIdAndProfileId(String activityId, String profileId) throws NoSuchLFTincanActProfileException, SystemException {
        return lfTincanActProfilePersistence.findByActivityIdAndProfileId(activityId, profileId);
    }

    public List<LFTincanActProfile> findByActivityId(String activityId) throws NoSuchLFTincanActProfileException, SystemException {
        return lfTincanActProfilePersistence.findByActivityId(activityId);
    }

    public LFTincanActProfile createLFTincanLrsActivityProfile(String activityId, String profileId, Integer documentId) throws SystemException {
        LFTincanActProfile activityProfile = createLFTincanActProfile(counterLocalService.increment(LFTincanActProfile.class.getName()));
        activityProfile.setActivityId(activityId);
        activityProfile.setProfileId(profileId);
        activityProfile.setDocumentId(documentId);
        lfTincanActProfilePersistence.update(activityProfile, false);
        return activityProfile;
    }

    public void removeAll() throws SystemException {
        lfTincanActProfilePersistence.removeAll();
    }
}

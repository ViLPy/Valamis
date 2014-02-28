package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsAgentProfileException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsAgentProfileLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f tincan lrs agent profile local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsAgentProfileLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalServiceUtil
 */
public class LFTincanLrsAgentProfileLocalServiceImpl
    extends LFTincanLrsAgentProfileLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalServiceUtil} to access the l f tincan lrs agent profile local service.
     */

    public LFTincanLrsAgentProfile createLFTincanLrsActivityProfile(Integer agentId, String profileId, Integer documentId) throws SystemException {
        LFTincanLrsAgentProfile agentProfile = createLFTincanLrsAgentProfile(counterLocalService.increment(LFTincanLrsAgentProfile.class.getName()));
        agentProfile.setProfileId(profileId);
        agentProfile.setAgentId(agentId);
        agentProfile.setDocumentId(documentId);
        lfTincanLrsAgentProfilePersistence.update(agentProfile, false);

        return agentProfile;
    }

    public List<LFTincanLrsAgentProfile> findByProfileId(String profileId) throws SystemException, NoSuchLFTincanLrsAgentProfileException {
        return lfTincanLrsAgentProfilePersistence.findByProfileId(profileId);
    }

    public List<LFTincanLrsAgentProfile> findByAgentId(Integer agentId) throws SystemException, NoSuchLFTincanLrsAgentProfileException {
        return lfTincanLrsAgentProfilePersistence.findByAgentId(agentId);
    }

    public LFTincanLrsAgentProfile findByAgentIdAndProfileId(Integer agentId, String profileId) throws SystemException {
        try {
            return lfTincanLrsAgentProfilePersistence.findByAgentIdAndProfileId(agentId, profileId);
        }
        catch (NoSuchLFTincanLrsAgentProfileException e) {
            return null;
        }
    }

    public void removeAll() throws SystemException {
        lfTincanLrsAgentProfilePersistence.removeAll();
    }
}

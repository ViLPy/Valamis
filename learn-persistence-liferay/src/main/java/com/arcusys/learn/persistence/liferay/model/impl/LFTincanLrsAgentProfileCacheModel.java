package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsAgentProfile in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsAgentProfile
* @generated
*/
public class LFTincanLrsAgentProfileCacheModel implements CacheModel<LFTincanLrsAgentProfile>,
    Serializable {
    public long id;
    public Integer documentId;
    public Integer agentId;
    public String profileId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", documentId=");
        sb.append(documentId);
        sb.append(", agentId=");
        sb.append(agentId);
        sb.append(", profileId=");
        sb.append(profileId);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsAgentProfile toEntityModel() {
        LFTincanLrsAgentProfileImpl lfTincanLrsAgentProfileImpl = new LFTincanLrsAgentProfileImpl();

        lfTincanLrsAgentProfileImpl.setId(id);
        lfTincanLrsAgentProfileImpl.setDocumentId(documentId);
        lfTincanLrsAgentProfileImpl.setAgentId(agentId);
        lfTincanLrsAgentProfileImpl.setProfileId(profileId);

        lfTincanLrsAgentProfileImpl.resetOriginalValues();

        return lfTincanLrsAgentProfileImpl;
    }
}

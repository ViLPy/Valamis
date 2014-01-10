package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsState in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsState
* @generated
*/
public class LFTincanLrsStateCacheModel implements CacheModel<LFTincanLrsState>,
    Serializable {
    public long id;
    public String stateId;
    public String documentId;
    public String activityId;
    public String profileId;
    public String registration;
    public Integer agentId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", stateId=");
        sb.append(stateId);
        sb.append(", documentId=");
        sb.append(documentId);
        sb.append(", activityId=");
        sb.append(activityId);
        sb.append(", profileId=");
        sb.append(profileId);
        sb.append(", registration=");
        sb.append(registration);
        sb.append(", agentId=");
        sb.append(agentId);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsState toEntityModel() {
        LFTincanLrsStateImpl lfTincanLrsStateImpl = new LFTincanLrsStateImpl();

        lfTincanLrsStateImpl.setId(id);
        lfTincanLrsStateImpl.setStateId(stateId);
        lfTincanLrsStateImpl.setDocumentId(documentId);
        lfTincanLrsStateImpl.setActivityId(activityId);
        lfTincanLrsStateImpl.setProfileId(profileId);
        lfTincanLrsStateImpl.setRegistration(registration);
        lfTincanLrsStateImpl.setAgentId(agentId);

        lfTincanLrsStateImpl.resetOriginalValues();

        return lfTincanLrsStateImpl;
    }
}

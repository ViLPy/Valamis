package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsActivityProfile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsActivityProfile in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsActivityProfile
* @generated
*/
public class LFTincanLrsActivityProfileCacheModel implements CacheModel<LFTincanLrsActivityProfile>,
    Serializable {
    public long id;
    public Integer documentId;
    public String activityId;
    public String profileId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", documentId=");
        sb.append(documentId);
        sb.append(", activityId=");
        sb.append(activityId);
        sb.append(", profileId=");
        sb.append(profileId);
        sb.append("}");

        return sb.toString();
    }

    public LFTincanLrsActivityProfile toEntityModel() {
        LFTincanLrsActivityProfileImpl lfTincanLrsActivityProfileImpl = new LFTincanLrsActivityProfileImpl();

        lfTincanLrsActivityProfileImpl.setId(id);
        lfTincanLrsActivityProfileImpl.setDocumentId(documentId);
        lfTincanLrsActivityProfileImpl.setActivityId(activityId);
        lfTincanLrsActivityProfileImpl.setProfileId(profileId);

        lfTincanLrsActivityProfileImpl.resetOriginalValues();

        return lfTincanLrsActivityProfileImpl;
    }
}

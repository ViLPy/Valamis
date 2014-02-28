package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanActProfile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanActProfile in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActProfile
 * @generated
 */
public class LFTincanActProfileCacheModel implements CacheModel<LFTincanActProfile>,
    Externalizable {
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

    @Override
    public LFTincanActProfile toEntityModel() {
        LFTincanActProfileImpl lfTincanActProfileImpl = new LFTincanActProfileImpl();

        lfTincanActProfileImpl.setId(id);
        lfTincanActProfileImpl.setDocumentId(documentId);

        if (activityId == null) {
            lfTincanActProfileImpl.setActivityId(StringPool.BLANK);
        } else {
            lfTincanActProfileImpl.setActivityId(activityId);
        }

        if (profileId == null) {
            lfTincanActProfileImpl.setProfileId(StringPool.BLANK);
        } else {
            lfTincanActProfileImpl.setProfileId(profileId);
        }

        lfTincanActProfileImpl.resetOriginalValues();

        return lfTincanActProfileImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        documentId = objectInput.readInt();
        activityId = objectInput.readUTF();
        profileId = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(documentId);

        if (activityId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityId);
        }

        if (profileId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(profileId);
        }
    }
}

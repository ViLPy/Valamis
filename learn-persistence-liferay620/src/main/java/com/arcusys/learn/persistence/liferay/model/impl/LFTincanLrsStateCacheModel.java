package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsState
 * @generated
 */
public class LFTincanLrsStateCacheModel implements CacheModel<LFTincanLrsState>,
    Externalizable {
    public long id;
    public String stateId;
    public String documentId;
    public String activityId;
    public String registration;
    public Integer agentId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", stateId=");
        sb.append(stateId);
        sb.append(", documentId=");
        sb.append(documentId);
        sb.append(", activityId=");
        sb.append(activityId);
        sb.append(", registration=");
        sb.append(registration);
        sb.append(", agentId=");
        sb.append(agentId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsState toEntityModel() {
        LFTincanLrsStateImpl lfTincanLrsStateImpl = new LFTincanLrsStateImpl();

        lfTincanLrsStateImpl.setId(id);

        if (stateId == null) {
            lfTincanLrsStateImpl.setStateId(StringPool.BLANK);
        } else {
            lfTincanLrsStateImpl.setStateId(stateId);
        }

        if (documentId == null) {
            lfTincanLrsStateImpl.setDocumentId(StringPool.BLANK);
        } else {
            lfTincanLrsStateImpl.setDocumentId(documentId);
        }

        if (activityId == null) {
            lfTincanLrsStateImpl.setActivityId(StringPool.BLANK);
        } else {
            lfTincanLrsStateImpl.setActivityId(activityId);
        }

        if (registration == null) {
            lfTincanLrsStateImpl.setRegistration(StringPool.BLANK);
        } else {
            lfTincanLrsStateImpl.setRegistration(registration);
        }

        lfTincanLrsStateImpl.setAgentId(agentId);

        lfTincanLrsStateImpl.resetOriginalValues();

        return lfTincanLrsStateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        stateId = objectInput.readUTF();
        documentId = objectInput.readUTF();
        activityId = objectInput.readUTF();
        registration = objectInput.readUTF();
        agentId = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (stateId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(stateId);
        }

        if (documentId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(documentId);
        }

        if (activityId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityId);
        }

        if (registration == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(registration);
        }

        objectOutput.writeInt(agentId);
    }
}

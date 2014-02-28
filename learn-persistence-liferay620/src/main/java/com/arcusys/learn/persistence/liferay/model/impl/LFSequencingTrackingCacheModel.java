package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSequencingTracking in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingTracking
 * @generated
 */
public class LFSequencingTrackingCacheModel implements CacheModel<LFSequencingTracking>,
    Externalizable {
    public long id;
    public Integer sequencingID;
    public boolean completionSetByContent;
    public boolean objectiveSetByContent;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", completionSetByContent=");
        sb.append(completionSetByContent);
        sb.append(", objectiveSetByContent=");
        sb.append(objectiveSetByContent);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSequencingTracking toEntityModel() {
        LFSequencingTrackingImpl lfSequencingTrackingImpl = new LFSequencingTrackingImpl();

        lfSequencingTrackingImpl.setId(id);
        lfSequencingTrackingImpl.setSequencingID(sequencingID);
        lfSequencingTrackingImpl.setCompletionSetByContent(completionSetByContent);
        lfSequencingTrackingImpl.setObjectiveSetByContent(objectiveSetByContent);

        lfSequencingTrackingImpl.resetOriginalValues();

        return lfSequencingTrackingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        sequencingID = objectInput.readInt();
        completionSetByContent = objectInput.readBoolean();
        objectiveSetByContent = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(sequencingID);
        objectOutput.writeBoolean(completionSetByContent);
        objectOutput.writeBoolean(objectiveSetByContent);
    }
}

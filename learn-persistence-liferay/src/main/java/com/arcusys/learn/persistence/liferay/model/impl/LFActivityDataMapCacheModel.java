package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFActivityDataMap in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityDataMap
 * @generated
 */
public class LFActivityDataMapCacheModel implements CacheModel<LFActivityDataMap>,
    Externalizable {
    public long id;
    public Integer packageID;
    public String activityID;
    public String targetId;
    public boolean readSharedData;
    public boolean writeSharedData;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", activityID=");
        sb.append(activityID);
        sb.append(", targetId=");
        sb.append(targetId);
        sb.append(", readSharedData=");
        sb.append(readSharedData);
        sb.append(", writeSharedData=");
        sb.append(writeSharedData);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFActivityDataMap toEntityModel() {
        LFActivityDataMapImpl lfActivityDataMapImpl = new LFActivityDataMapImpl();

        lfActivityDataMapImpl.setId(id);
        lfActivityDataMapImpl.setPackageID(packageID);

        if (activityID == null) {
            lfActivityDataMapImpl.setActivityID(StringPool.BLANK);
        } else {
            lfActivityDataMapImpl.setActivityID(activityID);
        }

        if (targetId == null) {
            lfActivityDataMapImpl.setTargetId(StringPool.BLANK);
        } else {
            lfActivityDataMapImpl.setTargetId(targetId);
        }

        lfActivityDataMapImpl.setReadSharedData(readSharedData);
        lfActivityDataMapImpl.setWriteSharedData(writeSharedData);

        lfActivityDataMapImpl.resetOriginalValues();

        return lfActivityDataMapImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        packageID = objectInput.readInt();
        activityID = objectInput.readUTF();
        targetId = objectInput.readUTF();
        readSharedData = objectInput.readBoolean();
        writeSharedData = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(packageID);

        if (activityID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityID);
        }

        if (targetId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(targetId);
        }

        objectOutput.writeBoolean(readSharedData);
        objectOutput.writeBoolean(writeSharedData);
    }
}

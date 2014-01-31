package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFAttemptData;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFAttemptData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptData
 * @generated
 */
public class LFAttemptDataCacheModel implements CacheModel<LFAttemptData>,
    Externalizable {
    public long id;
    public String dataKey;
    public String dataValue;
    public Integer attemptID;
    public String activityID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", dataKey=");
        sb.append(dataKey);
        sb.append(", dataValue=");
        sb.append(dataValue);
        sb.append(", attemptID=");
        sb.append(attemptID);
        sb.append(", activityID=");
        sb.append(activityID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFAttemptData toEntityModel() {
        LFAttemptDataImpl lfAttemptDataImpl = new LFAttemptDataImpl();

        lfAttemptDataImpl.setId(id);

        if (dataKey == null) {
            lfAttemptDataImpl.setDataKey(StringPool.BLANK);
        } else {
            lfAttemptDataImpl.setDataKey(dataKey);
        }

        if (dataValue == null) {
            lfAttemptDataImpl.setDataValue(StringPool.BLANK);
        } else {
            lfAttemptDataImpl.setDataValue(dataValue);
        }

        lfAttemptDataImpl.setAttemptID(attemptID);

        if (activityID == null) {
            lfAttemptDataImpl.setActivityID(StringPool.BLANK);
        } else {
            lfAttemptDataImpl.setActivityID(activityID);
        }

        lfAttemptDataImpl.resetOriginalValues();

        return lfAttemptDataImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        dataKey = objectInput.readUTF();
        dataValue = objectInput.readUTF();
        attemptID = objectInput.readInt();
        activityID = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (dataKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dataKey);
        }

        if (dataValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dataValue);
        }

        objectOutput.writeInt(attemptID);

        if (activityID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityID);
        }
    }
}

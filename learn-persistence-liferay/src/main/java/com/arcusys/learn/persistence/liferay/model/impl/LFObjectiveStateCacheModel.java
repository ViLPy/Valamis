package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFObjectiveState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveState
 * @generated
 */
public class LFObjectiveStateCacheModel implements CacheModel<LFObjectiveState>,
    Externalizable {
    public long id;
    public Boolean satisfied;
    public BigDecimal normalizedMeasure;
    public String mapKey;
    public Integer activityStateID;
    public Integer objectiveID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", satisfied=");
        sb.append(satisfied);
        sb.append(", normalizedMeasure=");
        sb.append(normalizedMeasure);
        sb.append(", mapKey=");
        sb.append(mapKey);
        sb.append(", activityStateID=");
        sb.append(activityStateID);
        sb.append(", objectiveID=");
        sb.append(objectiveID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFObjectiveState toEntityModel() {
        LFObjectiveStateImpl lfObjectiveStateImpl = new LFObjectiveStateImpl();

        lfObjectiveStateImpl.setId(id);
        lfObjectiveStateImpl.setSatisfied(satisfied);
        lfObjectiveStateImpl.setNormalizedMeasure(normalizedMeasure);

        if (mapKey == null) {
            lfObjectiveStateImpl.setMapKey(StringPool.BLANK);
        } else {
            lfObjectiveStateImpl.setMapKey(mapKey);
        }

        lfObjectiveStateImpl.setActivityStateID(activityStateID);
        lfObjectiveStateImpl.setObjectiveID(objectiveID);

        lfObjectiveStateImpl.resetOriginalValues();

        return lfObjectiveStateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        satisfied = objectInput.readBoolean();
        normalizedMeasure = (BigDecimal) objectInput.readObject();
        mapKey = objectInput.readUTF();
        activityStateID = objectInput.readInt();
        objectiveID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeBoolean(satisfied);
        objectOutput.writeObject(normalizedMeasure);

        if (mapKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mapKey);
        }

        objectOutput.writeInt(activityStateID);
        objectOutput.writeInt(objectiveID);
    }
}

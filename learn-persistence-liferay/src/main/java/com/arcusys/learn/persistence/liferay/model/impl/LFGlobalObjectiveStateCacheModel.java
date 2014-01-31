package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFGlobalObjectiveState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFGlobalObjectiveState
 * @generated
 */
public class LFGlobalObjectiveStateCacheModel implements CacheModel<LFGlobalObjectiveState>,
    Externalizable {
    public long id;
    public Boolean satisfied;
    public BigDecimal normalizedMeasure;
    public Boolean attemptCompleted;
    public String mapKey;
    public Integer treeID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", satisfied=");
        sb.append(satisfied);
        sb.append(", normalizedMeasure=");
        sb.append(normalizedMeasure);
        sb.append(", attemptCompleted=");
        sb.append(attemptCompleted);
        sb.append(", mapKey=");
        sb.append(mapKey);
        sb.append(", treeID=");
        sb.append(treeID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFGlobalObjectiveState toEntityModel() {
        LFGlobalObjectiveStateImpl lfGlobalObjectiveStateImpl = new LFGlobalObjectiveStateImpl();

        lfGlobalObjectiveStateImpl.setId(id);
        lfGlobalObjectiveStateImpl.setSatisfied(satisfied);
        lfGlobalObjectiveStateImpl.setNormalizedMeasure(normalizedMeasure);
        lfGlobalObjectiveStateImpl.setAttemptCompleted(attemptCompleted);

        if (mapKey == null) {
            lfGlobalObjectiveStateImpl.setMapKey(StringPool.BLANK);
        } else {
            lfGlobalObjectiveStateImpl.setMapKey(mapKey);
        }

        lfGlobalObjectiveStateImpl.setTreeID(treeID);

        lfGlobalObjectiveStateImpl.resetOriginalValues();

        return lfGlobalObjectiveStateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        satisfied = objectInput.readBoolean();
        normalizedMeasure = (BigDecimal) objectInput.readObject();
        attemptCompleted = objectInput.readBoolean();
        mapKey = objectInput.readUTF();
        treeID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeBoolean(satisfied);
        objectOutput.writeObject(normalizedMeasure);
        objectOutput.writeBoolean(attemptCompleted);

        if (mapKey == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mapKey);
        }

        objectOutput.writeInt(treeID);
    }
}

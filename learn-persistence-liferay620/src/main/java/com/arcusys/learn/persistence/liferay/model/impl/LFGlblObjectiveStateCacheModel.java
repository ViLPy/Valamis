package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFGlblObjectiveState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFGlblObjectiveState
 * @generated
 */
public class LFGlblObjectiveStateCacheModel implements CacheModel<LFGlblObjectiveState>,
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
    public LFGlblObjectiveState toEntityModel() {
        LFGlblObjectiveStateImpl lfGlblObjectiveStateImpl = new LFGlblObjectiveStateImpl();

        lfGlblObjectiveStateImpl.setId(id);
        lfGlblObjectiveStateImpl.setSatisfied(satisfied);
        lfGlblObjectiveStateImpl.setNormalizedMeasure(normalizedMeasure);
        lfGlblObjectiveStateImpl.setAttemptCompleted(attemptCompleted);

        if (mapKey == null) {
            lfGlblObjectiveStateImpl.setMapKey(StringPool.BLANK);
        } else {
            lfGlblObjectiveStateImpl.setMapKey(mapKey);
        }

        lfGlblObjectiveStateImpl.setTreeID(treeID);

        lfGlblObjectiveStateImpl.resetOriginalValues();

        return lfGlblObjectiveStateImpl;
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

package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjective;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFObjective in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFObjective
 * @generated
 */
public class LFObjectiveCacheModel implements CacheModel<LFObjective>,
    Externalizable {
    public long lfId;
    public Integer sequencingID;
    public boolean satisfiedByMeasure;
    public String identifier;
    public BigDecimal minNormalizedMeasure;
    public Boolean isPrimary;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{lfId=");
        sb.append(lfId);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", satisfiedByMeasure=");
        sb.append(satisfiedByMeasure);
        sb.append(", identifier=");
        sb.append(identifier);
        sb.append(", minNormalizedMeasure=");
        sb.append(minNormalizedMeasure);
        sb.append(", isPrimary=");
        sb.append(isPrimary);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFObjective toEntityModel() {
        LFObjectiveImpl lfObjectiveImpl = new LFObjectiveImpl();

        lfObjectiveImpl.setLfId(lfId);
        lfObjectiveImpl.setSequencingID(sequencingID);
        lfObjectiveImpl.setSatisfiedByMeasure(satisfiedByMeasure);

        if (identifier == null) {
            lfObjectiveImpl.setIdentifier(StringPool.BLANK);
        } else {
            lfObjectiveImpl.setIdentifier(identifier);
        }

        lfObjectiveImpl.setMinNormalizedMeasure(minNormalizedMeasure);
        lfObjectiveImpl.setIsPrimary(isPrimary);

        lfObjectiveImpl.resetOriginalValues();

        return lfObjectiveImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        lfId = objectInput.readLong();
        sequencingID = objectInput.readInt();
        satisfiedByMeasure = objectInput.readBoolean();
        identifier = objectInput.readUTF();
        minNormalizedMeasure = (BigDecimal) objectInput.readObject();
        isPrimary = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(lfId);
        objectOutput.writeInt(sequencingID);
        objectOutput.writeBoolean(satisfiedByMeasure);

        if (identifier == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(identifier);
        }

        objectOutput.writeObject(minNormalizedMeasure);
        objectOutput.writeBoolean(isPrimary);
    }
}

package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFRuleCondition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFRuleCondition
 * @generated
 */
public class LFRuleConditionCacheModel implements CacheModel<LFRuleCondition>,
    Externalizable {
    public long id;
    public String conditionType;
    public String objectiveId;
    public BigDecimal measureThreshold;
    public boolean inverse;
    public Integer rollupRuleID;
    public Integer conditionRuleID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", conditionType=");
        sb.append(conditionType);
        sb.append(", objectiveId=");
        sb.append(objectiveId);
        sb.append(", measureThreshold=");
        sb.append(measureThreshold);
        sb.append(", inverse=");
        sb.append(inverse);
        sb.append(", rollupRuleID=");
        sb.append(rollupRuleID);
        sb.append(", conditionRuleID=");
        sb.append(conditionRuleID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFRuleCondition toEntityModel() {
        LFRuleConditionImpl lfRuleConditionImpl = new LFRuleConditionImpl();

        lfRuleConditionImpl.setId(id);

        if (conditionType == null) {
            lfRuleConditionImpl.setConditionType(StringPool.BLANK);
        } else {
            lfRuleConditionImpl.setConditionType(conditionType);
        }

        if (objectiveId == null) {
            lfRuleConditionImpl.setObjectiveId(StringPool.BLANK);
        } else {
            lfRuleConditionImpl.setObjectiveId(objectiveId);
        }

        lfRuleConditionImpl.setMeasureThreshold(measureThreshold);
        lfRuleConditionImpl.setInverse(inverse);
        lfRuleConditionImpl.setRollupRuleID(rollupRuleID);
        lfRuleConditionImpl.setConditionRuleID(conditionRuleID);

        lfRuleConditionImpl.resetOriginalValues();

        return lfRuleConditionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        conditionType = objectInput.readUTF();
        objectiveId = objectInput.readUTF();
        measureThreshold = (BigDecimal) objectInput.readObject();
        inverse = objectInput.readBoolean();
        rollupRuleID = objectInput.readInt();
        conditionRuleID = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (conditionType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(conditionType);
        }

        if (objectiveId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(objectiveId);
        }

        objectOutput.writeObject(measureThreshold);
        objectOutput.writeBoolean(inverse);
        objectOutput.writeInt(rollupRuleID);
        objectOutput.writeInt(conditionRuleID);
    }
}

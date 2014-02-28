package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFConditionRule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFConditionRule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFConditionRule
 * @generated
 */
public class LFConditionRuleCacheModel implements CacheModel<LFConditionRule>,
    Externalizable {
    public long id;
    public Integer sequencingID;
    public String combination;
    public String ruleType;
    public String action;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", combination=");
        sb.append(combination);
        sb.append(", ruleType=");
        sb.append(ruleType);
        sb.append(", action=");
        sb.append(action);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFConditionRule toEntityModel() {
        LFConditionRuleImpl lfConditionRuleImpl = new LFConditionRuleImpl();

        lfConditionRuleImpl.setId(id);
        lfConditionRuleImpl.setSequencingID(sequencingID);

        if (combination == null) {
            lfConditionRuleImpl.setCombination(StringPool.BLANK);
        } else {
            lfConditionRuleImpl.setCombination(combination);
        }

        if (ruleType == null) {
            lfConditionRuleImpl.setRuleType(StringPool.BLANK);
        } else {
            lfConditionRuleImpl.setRuleType(ruleType);
        }

        if (action == null) {
            lfConditionRuleImpl.setAction(StringPool.BLANK);
        } else {
            lfConditionRuleImpl.setAction(action);
        }

        lfConditionRuleImpl.resetOriginalValues();

        return lfConditionRuleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        sequencingID = objectInput.readInt();
        combination = objectInput.readUTF();
        ruleType = objectInput.readUTF();
        action = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(sequencingID);

        if (combination == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(combination);
        }

        if (ruleType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ruleType);
        }

        if (action == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(action);
        }
    }
}

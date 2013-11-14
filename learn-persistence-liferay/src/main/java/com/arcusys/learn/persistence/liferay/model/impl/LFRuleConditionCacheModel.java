package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFRuleCondition in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFRuleCondition
* @generated
*/
public class LFRuleConditionCacheModel implements CacheModel<LFRuleCondition>,
    Serializable {
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

    public LFRuleCondition toEntityModel() {
        LFRuleConditionImpl lfRuleConditionImpl = new LFRuleConditionImpl();

        lfRuleConditionImpl.setId(id);

        if (conditionType == null) {
            lfRuleConditionImpl.setConditionType(StringPool.BLANK);
        } else {
            lfRuleConditionImpl.setConditionType(conditionType);
        }

        lfRuleConditionImpl.setObjectiveId(objectiveId);
        lfRuleConditionImpl.setMeasureThreshold(measureThreshold);
        lfRuleConditionImpl.setInverse(inverse);
        lfRuleConditionImpl.setRollupRuleID(rollupRuleID);
        lfRuleConditionImpl.setConditionRuleID(conditionRuleID);

        lfRuleConditionImpl.resetOriginalValues();

        return lfRuleConditionImpl;
    }
}

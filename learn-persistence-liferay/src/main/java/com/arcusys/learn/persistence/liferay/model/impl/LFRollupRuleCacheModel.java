package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRollupRule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFRollupRule in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFRollupRule
* @generated
*/
public class LFRollupRuleCacheModel implements CacheModel<LFRollupRule>,
    Serializable {
    public long id;
    public Integer sequencingID;
    public String combination;
    public String childActivitySet;
    public Integer minimumCount;
    public BigDecimal minimumPercent;
    public String action;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", combination=");
        sb.append(combination);
        sb.append(", childActivitySet=");
        sb.append(childActivitySet);
        sb.append(", minimumCount=");
        sb.append(minimumCount);
        sb.append(", minimumPercent=");
        sb.append(minimumPercent);
        sb.append(", action=");
        sb.append(action);
        sb.append("}");

        return sb.toString();
    }

    public LFRollupRule toEntityModel() {
        LFRollupRuleImpl lfRollupRuleImpl = new LFRollupRuleImpl();

        lfRollupRuleImpl.setId(id);
        lfRollupRuleImpl.setSequencingID(sequencingID);

        if (combination == null) {
            lfRollupRuleImpl.setCombination(StringPool.BLANK);
        } else {
            lfRollupRuleImpl.setCombination(combination);
        }

        if (childActivitySet == null) {
            lfRollupRuleImpl.setChildActivitySet(StringPool.BLANK);
        } else {
            lfRollupRuleImpl.setChildActivitySet(childActivitySet);
        }

        lfRollupRuleImpl.setMinimumCount(minimumCount);
        lfRollupRuleImpl.setMinimumPercent(minimumPercent);

        if (action == null) {
            lfRollupRuleImpl.setAction(StringPool.BLANK);
        } else {
            lfRollupRuleImpl.setAction(action);
        }

        lfRollupRuleImpl.resetOriginalValues();

        return lfRollupRuleImpl;
    }
}

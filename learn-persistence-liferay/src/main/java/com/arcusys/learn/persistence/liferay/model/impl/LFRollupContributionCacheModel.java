package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFRollupContribution in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFRollupContribution
* @generated
*/
public class LFRollupContributionCacheModel implements CacheModel<LFRollupContribution>,
    Serializable {
    public long id;
    public Integer sequencingID;
    public String contributeToSatisfied;
    public String contributeToNotSatisfied;
    public String contributeToCompleted;
    public String contributeToIncomplete;
    public BigDecimal objectiveMeasureWeight;
    public boolean measureSatisfactionIfActive;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(id);
        sb.append(", sequencingID=");
        sb.append(sequencingID);
        sb.append(", contributeToSatisfied=");
        sb.append(contributeToSatisfied);
        sb.append(", contributeToNotSatisfied=");
        sb.append(contributeToNotSatisfied);
        sb.append(", contributeToCompleted=");
        sb.append(contributeToCompleted);
        sb.append(", contributeToIncomplete=");
        sb.append(contributeToIncomplete);
        sb.append(", objectiveMeasureWeight=");
        sb.append(objectiveMeasureWeight);
        sb.append(", measureSatisfactionIfActive=");
        sb.append(measureSatisfactionIfActive);
        sb.append("}");

        return sb.toString();
    }

    public LFRollupContribution toEntityModel() {
        LFRollupContributionImpl lfRollupContributionImpl = new LFRollupContributionImpl();

        lfRollupContributionImpl.setId(id);
        lfRollupContributionImpl.setSequencingID(sequencingID);
        lfRollupContributionImpl.setContributeToSatisfied(contributeToSatisfied);
        lfRollupContributionImpl.setContributeToNotSatisfied(contributeToNotSatisfied);
        lfRollupContributionImpl.setContributeToCompleted(contributeToCompleted);
        lfRollupContributionImpl.setContributeToIncomplete(contributeToIncomplete);
        lfRollupContributionImpl.setObjectiveMeasureWeight(objectiveMeasureWeight);
        lfRollupContributionImpl.setMeasureSatisfactionIfActive(measureSatisfactionIfActive);

        lfRollupContributionImpl.resetOriginalValues();

        return lfRollupContributionImpl;
    }
}

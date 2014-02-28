package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFRollupContribution;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFRollupContribution in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupContribution
 * @generated
 */
public class LFRollupContributionCacheModel implements CacheModel<LFRollupContribution>,
    Externalizable {
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

    @Override
    public LFRollupContribution toEntityModel() {
        LFRollupContributionImpl lfRollupContributionImpl = new LFRollupContributionImpl();

        lfRollupContributionImpl.setId(id);
        lfRollupContributionImpl.setSequencingID(sequencingID);

        if (contributeToSatisfied == null) {
            lfRollupContributionImpl.setContributeToSatisfied(StringPool.BLANK);
        } else {
            lfRollupContributionImpl.setContributeToSatisfied(contributeToSatisfied);
        }

        if (contributeToNotSatisfied == null) {
            lfRollupContributionImpl.setContributeToNotSatisfied(StringPool.BLANK);
        } else {
            lfRollupContributionImpl.setContributeToNotSatisfied(contributeToNotSatisfied);
        }

        if (contributeToCompleted == null) {
            lfRollupContributionImpl.setContributeToCompleted(StringPool.BLANK);
        } else {
            lfRollupContributionImpl.setContributeToCompleted(contributeToCompleted);
        }

        if (contributeToIncomplete == null) {
            lfRollupContributionImpl.setContributeToIncomplete(StringPool.BLANK);
        } else {
            lfRollupContributionImpl.setContributeToIncomplete(contributeToIncomplete);
        }

        lfRollupContributionImpl.setObjectiveMeasureWeight(objectiveMeasureWeight);
        lfRollupContributionImpl.setMeasureSatisfactionIfActive(measureSatisfactionIfActive);

        lfRollupContributionImpl.resetOriginalValues();

        return lfRollupContributionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        sequencingID = objectInput.readInt();
        contributeToSatisfied = objectInput.readUTF();
        contributeToNotSatisfied = objectInput.readUTF();
        contributeToCompleted = objectInput.readUTF();
        contributeToIncomplete = objectInput.readUTF();
        objectiveMeasureWeight = (BigDecimal) objectInput.readObject();
        measureSatisfactionIfActive = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(sequencingID);

        if (contributeToSatisfied == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contributeToSatisfied);
        }

        if (contributeToNotSatisfied == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contributeToNotSatisfied);
        }

        if (contributeToCompleted == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contributeToCompleted);
        }

        if (contributeToIncomplete == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contributeToIncomplete);
        }

        objectOutput.writeObject(objectiveMeasureWeight);
        objectOutput.writeBoolean(measureSatisfactionIfActive);
    }
}

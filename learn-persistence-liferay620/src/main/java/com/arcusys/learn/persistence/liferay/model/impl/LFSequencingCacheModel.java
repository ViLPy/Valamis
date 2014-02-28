package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSequencing;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSequencing in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencing
 * @generated
 */
public class LFSequencingCacheModel implements CacheModel<LFSequencing>,
    Externalizable {
    public long id;
    public Integer packageID;
    public String activityID;
    public String sharedId;
    public String sharedSequencingIdReference;
    public boolean cAttemptObjectiveProgressChild;
    public boolean cAttemptAttemptProgressChild;
    public Integer attemptLimit;
    public Long durationLimitInMilliseconds;
    public Integer rollupContributionID;
    public boolean preventChildrenActivation;
    public boolean constrainChoice;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", activityID=");
        sb.append(activityID);
        sb.append(", sharedId=");
        sb.append(sharedId);
        sb.append(", sharedSequencingIdReference=");
        sb.append(sharedSequencingIdReference);
        sb.append(", cAttemptObjectiveProgressChild=");
        sb.append(cAttemptObjectiveProgressChild);
        sb.append(", cAttemptAttemptProgressChild=");
        sb.append(cAttemptAttemptProgressChild);
        sb.append(", attemptLimit=");
        sb.append(attemptLimit);
        sb.append(", durationLimitInMilliseconds=");
        sb.append(durationLimitInMilliseconds);
        sb.append(", rollupContributionID=");
        sb.append(rollupContributionID);
        sb.append(", preventChildrenActivation=");
        sb.append(preventChildrenActivation);
        sb.append(", constrainChoice=");
        sb.append(constrainChoice);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSequencing toEntityModel() {
        LFSequencingImpl lfSequencingImpl = new LFSequencingImpl();

        lfSequencingImpl.setId(id);
        lfSequencingImpl.setPackageID(packageID);

        if (activityID == null) {
            lfSequencingImpl.setActivityID(StringPool.BLANK);
        } else {
            lfSequencingImpl.setActivityID(activityID);
        }

        if (sharedId == null) {
            lfSequencingImpl.setSharedId(StringPool.BLANK);
        } else {
            lfSequencingImpl.setSharedId(sharedId);
        }

        if (sharedSequencingIdReference == null) {
            lfSequencingImpl.setSharedSequencingIdReference(StringPool.BLANK);
        } else {
            lfSequencingImpl.setSharedSequencingIdReference(sharedSequencingIdReference);
        }

        lfSequencingImpl.setCAttemptObjectiveProgressChild(cAttemptObjectiveProgressChild);
        lfSequencingImpl.setCAttemptAttemptProgressChild(cAttemptAttemptProgressChild);
        lfSequencingImpl.setAttemptLimit(attemptLimit);
        lfSequencingImpl.setDurationLimitInMilliseconds(durationLimitInMilliseconds);
        lfSequencingImpl.setRollupContributionID(rollupContributionID);
        lfSequencingImpl.setPreventChildrenActivation(preventChildrenActivation);
        lfSequencingImpl.setConstrainChoice(constrainChoice);

        lfSequencingImpl.resetOriginalValues();

        return lfSequencingImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        packageID = objectInput.readInt();
        activityID = objectInput.readUTF();
        sharedId = objectInput.readUTF();
        sharedSequencingIdReference = objectInput.readUTF();
        cAttemptObjectiveProgressChild = objectInput.readBoolean();
        cAttemptAttemptProgressChild = objectInput.readBoolean();
        attemptLimit = objectInput.readInt();
        durationLimitInMilliseconds = objectInput.readLong();
        rollupContributionID = objectInput.readInt();
        preventChildrenActivation = objectInput.readBoolean();
        constrainChoice = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(packageID);

        if (activityID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(activityID);
        }

        if (sharedId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sharedId);
        }

        if (sharedSequencingIdReference == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sharedSequencingIdReference);
        }

        objectOutput.writeBoolean(cAttemptObjectiveProgressChild);
        objectOutput.writeBoolean(cAttemptAttemptProgressChild);
        objectOutput.writeInt(attemptLimit);
        objectOutput.writeLong(durationLimitInMilliseconds);
        objectOutput.writeInt(rollupContributionID);
        objectOutput.writeBoolean(preventChildrenActivation);
        objectOutput.writeBoolean(constrainChoice);
    }
}

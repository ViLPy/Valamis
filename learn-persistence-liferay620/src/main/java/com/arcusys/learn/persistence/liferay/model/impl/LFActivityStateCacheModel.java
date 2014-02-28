package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFActivityState in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityState
 * @generated
 */
public class LFActivityStateCacheModel implements CacheModel<LFActivityState>,
    Externalizable {
    public long id;
    public Integer packageID;
    public String activityID;
    public Boolean active;
    public Boolean suspended;
    public Boolean attemptCompleted;
    public BigDecimal attemptCompletionAmount;
    public BigDecimal attemptAbsoluteDuration;
    public BigDecimal attemptExperiencedDuration;
    public BigDecimal activityAbsoluteDuration;
    public BigDecimal activityExperiencedDuration;
    public Integer attemptCount;
    public Integer activityStateNodeID;
    public Integer activityStateTreeID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{id=");
        sb.append(id);
        sb.append(", packageID=");
        sb.append(packageID);
        sb.append(", activityID=");
        sb.append(activityID);
        sb.append(", active=");
        sb.append(active);
        sb.append(", suspended=");
        sb.append(suspended);
        sb.append(", attemptCompleted=");
        sb.append(attemptCompleted);
        sb.append(", attemptCompletionAmount=");
        sb.append(attemptCompletionAmount);
        sb.append(", attemptAbsoluteDuration=");
        sb.append(attemptAbsoluteDuration);
        sb.append(", attemptExperiencedDuration=");
        sb.append(attemptExperiencedDuration);
        sb.append(", activityAbsoluteDuration=");
        sb.append(activityAbsoluteDuration);
        sb.append(", activityExperiencedDuration=");
        sb.append(activityExperiencedDuration);
        sb.append(", attemptCount=");
        sb.append(attemptCount);
        sb.append(", activityStateNodeID=");
        sb.append(activityStateNodeID);
        sb.append(", activityStateTreeID=");
        sb.append(activityStateTreeID);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFActivityState toEntityModel() {
        LFActivityStateImpl lfActivityStateImpl = new LFActivityStateImpl();

        lfActivityStateImpl.setId(id);
        lfActivityStateImpl.setPackageID(packageID);

        if (activityID == null) {
            lfActivityStateImpl.setActivityID(StringPool.BLANK);
        } else {
            lfActivityStateImpl.setActivityID(activityID);
        }

        lfActivityStateImpl.setActive(active);
        lfActivityStateImpl.setSuspended(suspended);
        lfActivityStateImpl.setAttemptCompleted(attemptCompleted);
        lfActivityStateImpl.setAttemptCompletionAmount(attemptCompletionAmount);
        lfActivityStateImpl.setAttemptAbsoluteDuration(attemptAbsoluteDuration);
        lfActivityStateImpl.setAttemptExperiencedDuration(attemptExperiencedDuration);
        lfActivityStateImpl.setActivityAbsoluteDuration(activityAbsoluteDuration);
        lfActivityStateImpl.setActivityExperiencedDuration(activityExperiencedDuration);
        lfActivityStateImpl.setAttemptCount(attemptCount);
        lfActivityStateImpl.setActivityStateNodeID(activityStateNodeID);
        lfActivityStateImpl.setActivityStateTreeID(activityStateTreeID);

        lfActivityStateImpl.resetOriginalValues();

        return lfActivityStateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        packageID = objectInput.readInt();
        activityID = objectInput.readUTF();
        active = objectInput.readBoolean();
        suspended = objectInput.readBoolean();
        attemptCompleted = objectInput.readBoolean();
        attemptCompletionAmount = (BigDecimal) objectInput.readObject();
        attemptAbsoluteDuration = (BigDecimal) objectInput.readObject();
        attemptExperiencedDuration = (BigDecimal) objectInput.readObject();
        activityAbsoluteDuration = (BigDecimal) objectInput.readObject();
        activityExperiencedDuration = (BigDecimal) objectInput.readObject();
        attemptCount = objectInput.readInt();
        activityStateNodeID = objectInput.readInt();
        activityStateTreeID = objectInput.readInt();
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

        objectOutput.writeBoolean(active);
        objectOutput.writeBoolean(suspended);
        objectOutput.writeBoolean(attemptCompleted);
        objectOutput.writeObject(attemptCompletionAmount);
        objectOutput.writeObject(attemptAbsoluteDuration);
        objectOutput.writeObject(attemptExperiencedDuration);
        objectOutput.writeObject(activityAbsoluteDuration);
        objectOutput.writeObject(activityExperiencedDuration);
        objectOutput.writeInt(attemptCount);
        objectOutput.writeInt(activityStateNodeID);
        objectOutput.writeInt(activityStateTreeID);
    }
}

package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFActivityState in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFActivityState
* @generated
*/
public class LFActivityStateCacheModel implements CacheModel<LFActivityState>,
    Serializable {
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
}

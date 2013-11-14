package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSequencing;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFSequencing in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFSequencing
* @generated
*/
public class LFSequencingCacheModel implements CacheModel<LFSequencing>,
    Serializable {
    public long id;
    public Integer packageID;
    public String activityID;
    public String sharedId;
    public String sharedSequencingIdReference;
    public boolean onlyCurrentAttemptObjectiveProgressForChildren;
    public boolean onlyCurrentAttemptAttemptProgressForChildren;
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
        sb.append(", onlyCurrentAttemptObjectiveProgressForChildren=");
        sb.append(onlyCurrentAttemptObjectiveProgressForChildren);
        sb.append(", onlyCurrentAttemptAttemptProgressForChildren=");
        sb.append(onlyCurrentAttemptAttemptProgressForChildren);
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

    public LFSequencing toEntityModel() {
        LFSequencingImpl lfSequencingImpl = new LFSequencingImpl();

        lfSequencingImpl.setId(id);
        lfSequencingImpl.setPackageID(packageID);

        if (activityID == null) {
            lfSequencingImpl.setActivityID(StringPool.BLANK);
        } else {
            lfSequencingImpl.setActivityID(activityID);
        }

        lfSequencingImpl.setSharedId(sharedId);
        lfSequencingImpl.setSharedSequencingIdReference(sharedSequencingIdReference);
        lfSequencingImpl.setOnlyCurrentAttemptObjectiveProgressForChildren(onlyCurrentAttemptObjectiveProgressForChildren);
        lfSequencingImpl.setOnlyCurrentAttemptAttemptProgressForChildren(onlyCurrentAttemptAttemptProgressForChildren);
        lfSequencingImpl.setAttemptLimit(attemptLimit);
        lfSequencingImpl.setDurationLimitInMilliseconds(durationLimitInMilliseconds);
        lfSequencingImpl.setRollupContributionID(rollupContributionID);
        lfSequencingImpl.setPreventChildrenActivation(preventChildrenActivation);
        lfSequencingImpl.setConstrainChoice(constrainChoice);

        lfSequencingImpl.resetOriginalValues();

        return lfSequencingImpl;
    }
}

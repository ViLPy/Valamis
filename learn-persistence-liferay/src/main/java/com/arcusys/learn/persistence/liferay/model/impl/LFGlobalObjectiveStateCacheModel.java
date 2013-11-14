package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFGlobalObjectiveState in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFGlobalObjectiveState
* @generated
*/
public class LFGlobalObjectiveStateCacheModel implements CacheModel<LFGlobalObjectiveState>,
    Serializable {
    public long id;
    public Boolean satisfied;
    public BigDecimal normalizedMeasure;
    public Boolean attemptCompleted;
    public String mapKey;
    public Integer treeID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", satisfied=");
        sb.append(satisfied);
        sb.append(", normalizedMeasure=");
        sb.append(normalizedMeasure);
        sb.append(", attemptCompleted=");
        sb.append(attemptCompleted);
        sb.append(", mapKey=");
        sb.append(mapKey);
        sb.append(", treeID=");
        sb.append(treeID);
        sb.append("}");

        return sb.toString();
    }

    public LFGlobalObjectiveState toEntityModel() {
        LFGlobalObjectiveStateImpl lfGlobalObjectiveStateImpl = new LFGlobalObjectiveStateImpl();

        lfGlobalObjectiveStateImpl.setId(id);
        lfGlobalObjectiveStateImpl.setSatisfied(satisfied);
        lfGlobalObjectiveStateImpl.setNormalizedMeasure(normalizedMeasure);
        lfGlobalObjectiveStateImpl.setAttemptCompleted(attemptCompleted);
        lfGlobalObjectiveStateImpl.setMapKey(mapKey);
        lfGlobalObjectiveStateImpl.setTreeID(treeID);

        lfGlobalObjectiveStateImpl.resetOriginalValues();

        return lfGlobalObjectiveStateImpl;
    }
}

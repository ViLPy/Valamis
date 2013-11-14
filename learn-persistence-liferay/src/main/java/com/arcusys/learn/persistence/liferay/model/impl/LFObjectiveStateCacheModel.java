package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFObjectiveState in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFObjectiveState
* @generated
*/
public class LFObjectiveStateCacheModel implements CacheModel<LFObjectiveState>,
    Serializable {
    public long id;
    public Boolean satisfied;
    public BigDecimal normalizedMeasure;
    public String mapKey;
    public Integer activityStateID;
    public Integer objectiveID;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", satisfied=");
        sb.append(satisfied);
        sb.append(", normalizedMeasure=");
        sb.append(normalizedMeasure);
        sb.append(", mapKey=");
        sb.append(mapKey);
        sb.append(", activityStateID=");
        sb.append(activityStateID);
        sb.append(", objectiveID=");
        sb.append(objectiveID);
        sb.append("}");

        return sb.toString();
    }

    public LFObjectiveState toEntityModel() {
        LFObjectiveStateImpl lfObjectiveStateImpl = new LFObjectiveStateImpl();

        lfObjectiveStateImpl.setId(id);
        lfObjectiveStateImpl.setSatisfied(satisfied);
        lfObjectiveStateImpl.setNormalizedMeasure(normalizedMeasure);
        lfObjectiveStateImpl.setMapKey(mapKey);
        lfObjectiveStateImpl.setActivityStateID(activityStateID);
        lfObjectiveStateImpl.setObjectiveID(objectiveID);

        lfObjectiveStateImpl.resetOriginalValues();

        return lfObjectiveStateImpl;
    }
}

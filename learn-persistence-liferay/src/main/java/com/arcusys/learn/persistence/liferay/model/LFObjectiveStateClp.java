package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class LFObjectiveStateClp extends BaseModelImpl<LFObjectiveState>
    implements LFObjectiveState {
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private String _mapKey;
    private Integer _activityStateID;
    private Integer _objectiveID;
    private BaseModel<?> _lfObjectiveStateRemoteModel;

    public LFObjectiveStateClp() {
    }

    public Class<?> getModelClass() {
        return LFObjectiveState.class;
    }

    public String getModelClassName() {
        return LFObjectiveState.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("satisfied", getSatisfied());
        attributes.put("normalizedMeasure", getNormalizedMeasure());
        attributes.put("mapKey", getMapKey());
        attributes.put("activityStateID", getActivityStateID());
        attributes.put("objectiveID", getObjectiveID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Boolean satisfied = (Boolean) attributes.get("satisfied");

        if (satisfied != null) {
            setSatisfied(satisfied);
        }

        BigDecimal normalizedMeasure = (BigDecimal) attributes.get(
                "normalizedMeasure");

        if (normalizedMeasure != null) {
            setNormalizedMeasure(normalizedMeasure);
        }

        String mapKey = (String) attributes.get("mapKey");

        if (mapKey != null) {
            setMapKey(mapKey);
        }

        Integer activityStateID = (Integer) attributes.get("activityStateID");

        if (activityStateID != null) {
            setActivityStateID(activityStateID);
        }

        Integer objectiveID = (Integer) attributes.get("objectiveID");

        if (objectiveID != null) {
            setObjectiveID(objectiveID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Boolean getSatisfied() {
        return _satisfied;
    }

    public void setSatisfied(Boolean satisfied) {
        _satisfied = satisfied;
    }

    public BigDecimal getNormalizedMeasure() {
        return _normalizedMeasure;
    }

    public void setNormalizedMeasure(BigDecimal normalizedMeasure) {
        _normalizedMeasure = normalizedMeasure;
    }

    public String getMapKey() {
        return _mapKey;
    }

    public void setMapKey(String mapKey) {
        _mapKey = mapKey;
    }

    public Integer getActivityStateID() {
        return _activityStateID;
    }

    public void setActivityStateID(Integer activityStateID) {
        _activityStateID = activityStateID;
    }

    public Integer getObjectiveID() {
        return _objectiveID;
    }

    public void setObjectiveID(Integer objectiveID) {
        _objectiveID = objectiveID;
    }

    public BaseModel<?> getLFObjectiveStateRemoteModel() {
        return _lfObjectiveStateRemoteModel;
    }

    public void setLFObjectiveStateRemoteModel(
        BaseModel<?> lfObjectiveStateRemoteModel) {
        _lfObjectiveStateRemoteModel = lfObjectiveStateRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFObjectiveStateLocalServiceUtil.addLFObjectiveState(this);
        } else {
            LFObjectiveStateLocalServiceUtil.updateLFObjectiveState(this);
        }
    }

    @Override
    public LFObjectiveState toEscapedModel() {
        return (LFObjectiveState) Proxy.newProxyInstance(LFObjectiveState.class.getClassLoader(),
            new Class[] { LFObjectiveState.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFObjectiveStateClp clone = new LFObjectiveStateClp();

        clone.setId(getId());
        clone.setSatisfied(getSatisfied());
        clone.setNormalizedMeasure(getNormalizedMeasure());
        clone.setMapKey(getMapKey());
        clone.setActivityStateID(getActivityStateID());
        clone.setObjectiveID(getObjectiveID());

        return clone;
    }

    public int compareTo(LFObjectiveState lfObjectiveState) {
        long primaryKey = lfObjectiveState.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFObjectiveStateClp lfObjectiveState = null;

        try {
            lfObjectiveState = (LFObjectiveStateClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfObjectiveState.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", satisfied=");
        sb.append(getSatisfied());
        sb.append(", normalizedMeasure=");
        sb.append(getNormalizedMeasure());
        sb.append(", mapKey=");
        sb.append(getMapKey());
        sb.append(", activityStateID=");
        sb.append(getActivityStateID());
        sb.append(", objectiveID=");
        sb.append(getObjectiveID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFObjectiveState");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>satisfied</column-name><column-value><![CDATA[");
        sb.append(getSatisfied());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>normalizedMeasure</column-name><column-value><![CDATA[");
        sb.append(getNormalizedMeasure());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mapKey</column-name><column-value><![CDATA[");
        sb.append(getMapKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityStateID</column-name><column-value><![CDATA[");
        sb.append(getActivityStateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveID</column-name><column-value><![CDATA[");
        sb.append(getObjectiveID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalServiceUtil;

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


public class LFGlobalObjectiveStateClp extends BaseModelImpl<LFGlobalObjectiveState>
    implements LFGlobalObjectiveState {
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private Boolean _attemptCompleted;
    private String _mapKey;
    private Integer _treeID;
    private BaseModel<?> _lfGlobalObjectiveStateRemoteModel;

    public LFGlobalObjectiveStateClp() {
    }

    public Class<?> getModelClass() {
        return LFGlobalObjectiveState.class;
    }

    public String getModelClassName() {
        return LFGlobalObjectiveState.class.getName();
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
        attributes.put("attemptCompleted", getAttemptCompleted());
        attributes.put("mapKey", getMapKey());
        attributes.put("treeID", getTreeID());

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

        Boolean attemptCompleted = (Boolean) attributes.get("attemptCompleted");

        if (attemptCompleted != null) {
            setAttemptCompleted(attemptCompleted);
        }

        String mapKey = (String) attributes.get("mapKey");

        if (mapKey != null) {
            setMapKey(mapKey);
        }

        Integer treeID = (Integer) attributes.get("treeID");

        if (treeID != null) {
            setTreeID(treeID);
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

    public Boolean getAttemptCompleted() {
        return _attemptCompleted;
    }

    public void setAttemptCompleted(Boolean attemptCompleted) {
        _attemptCompleted = attemptCompleted;
    }

    public String getMapKey() {
        return _mapKey;
    }

    public void setMapKey(String mapKey) {
        _mapKey = mapKey;
    }

    public Integer getTreeID() {
        return _treeID;
    }

    public void setTreeID(Integer treeID) {
        _treeID = treeID;
    }

    public BaseModel<?> getLFGlobalObjectiveStateRemoteModel() {
        return _lfGlobalObjectiveStateRemoteModel;
    }

    public void setLFGlobalObjectiveStateRemoteModel(
        BaseModel<?> lfGlobalObjectiveStateRemoteModel) {
        _lfGlobalObjectiveStateRemoteModel = lfGlobalObjectiveStateRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFGlobalObjectiveStateLocalServiceUtil.addLFGlobalObjectiveState(this);
        } else {
            LFGlobalObjectiveStateLocalServiceUtil.updateLFGlobalObjectiveState(this);
        }
    }

    @Override
    public LFGlobalObjectiveState toEscapedModel() {
        return (LFGlobalObjectiveState) Proxy.newProxyInstance(LFGlobalObjectiveState.class.getClassLoader(),
            new Class[] { LFGlobalObjectiveState.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFGlobalObjectiveStateClp clone = new LFGlobalObjectiveStateClp();

        clone.setId(getId());
        clone.setSatisfied(getSatisfied());
        clone.setNormalizedMeasure(getNormalizedMeasure());
        clone.setAttemptCompleted(getAttemptCompleted());
        clone.setMapKey(getMapKey());
        clone.setTreeID(getTreeID());

        return clone;
    }

    public int compareTo(LFGlobalObjectiveState lfGlobalObjectiveState) {
        long primaryKey = lfGlobalObjectiveState.getPrimaryKey();

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

        LFGlobalObjectiveStateClp lfGlobalObjectiveState = null;

        try {
            lfGlobalObjectiveState = (LFGlobalObjectiveStateClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfGlobalObjectiveState.getPrimaryKey();

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
        sb.append(", attemptCompleted=");
        sb.append(getAttemptCompleted());
        sb.append(", mapKey=");
        sb.append(getMapKey());
        sb.append(", treeID=");
        sb.append(getTreeID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState");
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
            "<column><column-name>attemptCompleted</column-name><column-value><![CDATA[");
        sb.append(getAttemptCompleted());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mapKey</column-name><column-value><![CDATA[");
        sb.append(getMapKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>treeID</column-name><column-value><![CDATA[");
        sb.append(getTreeID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

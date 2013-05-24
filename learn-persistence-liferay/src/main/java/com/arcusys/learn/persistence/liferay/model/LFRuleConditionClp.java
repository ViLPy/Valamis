package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil;

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


public class LFRuleConditionClp extends BaseModelImpl<LFRuleCondition>
    implements LFRuleCondition {
    private long _id;
    private String _conditionType;
    private String _objectiveId;
    private BigDecimal _measureThreshold;
    private boolean _inverse;
    private Integer _rollupRuleID;
    private Integer _conditionRuleID;
    private BaseModel<?> _lfRuleConditionRemoteModel;

    public LFRuleConditionClp() {
    }

    public Class<?> getModelClass() {
        return LFRuleCondition.class;
    }

    public String getModelClassName() {
        return LFRuleCondition.class.getName();
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
        attributes.put("conditionType", getConditionType());
        attributes.put("objectiveId", getObjectiveId());
        attributes.put("measureThreshold", getMeasureThreshold());
        attributes.put("inverse", getInverse());
        attributes.put("rollupRuleID", getRollupRuleID());
        attributes.put("conditionRuleID", getConditionRuleID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String conditionType = (String) attributes.get("conditionType");

        if (conditionType != null) {
            setConditionType(conditionType);
        }

        String objectiveId = (String) attributes.get("objectiveId");

        if (objectiveId != null) {
            setObjectiveId(objectiveId);
        }

        BigDecimal measureThreshold = (BigDecimal) attributes.get(
                "measureThreshold");

        if (measureThreshold != null) {
            setMeasureThreshold(measureThreshold);
        }

        Boolean inverse = (Boolean) attributes.get("inverse");

        if (inverse != null) {
            setInverse(inverse);
        }

        Integer rollupRuleID = (Integer) attributes.get("rollupRuleID");

        if (rollupRuleID != null) {
            setRollupRuleID(rollupRuleID);
        }

        Integer conditionRuleID = (Integer) attributes.get("conditionRuleID");

        if (conditionRuleID != null) {
            setConditionRuleID(conditionRuleID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getConditionType() {
        return _conditionType;
    }

    public void setConditionType(String conditionType) {
        _conditionType = conditionType;
    }

    public String getObjectiveId() {
        return _objectiveId;
    }

    public void setObjectiveId(String objectiveId) {
        _objectiveId = objectiveId;
    }

    public BigDecimal getMeasureThreshold() {
        return _measureThreshold;
    }

    public void setMeasureThreshold(BigDecimal measureThreshold) {
        _measureThreshold = measureThreshold;
    }

    public boolean getInverse() {
        return _inverse;
    }

    public boolean isInverse() {
        return _inverse;
    }

    public void setInverse(boolean inverse) {
        _inverse = inverse;
    }

    public Integer getRollupRuleID() {
        return _rollupRuleID;
    }

    public void setRollupRuleID(Integer rollupRuleID) {
        _rollupRuleID = rollupRuleID;
    }

    public Integer getConditionRuleID() {
        return _conditionRuleID;
    }

    public void setConditionRuleID(Integer conditionRuleID) {
        _conditionRuleID = conditionRuleID;
    }

    public BaseModel<?> getLFRuleConditionRemoteModel() {
        return _lfRuleConditionRemoteModel;
    }

    public void setLFRuleConditionRemoteModel(
        BaseModel<?> lfRuleConditionRemoteModel) {
        _lfRuleConditionRemoteModel = lfRuleConditionRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRuleConditionLocalServiceUtil.addLFRuleCondition(this);
        } else {
            LFRuleConditionLocalServiceUtil.updateLFRuleCondition(this);
        }
    }

    @Override
    public LFRuleCondition toEscapedModel() {
        return (LFRuleCondition) Proxy.newProxyInstance(LFRuleCondition.class.getClassLoader(),
            new Class[] { LFRuleCondition.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFRuleConditionClp clone = new LFRuleConditionClp();

        clone.setId(getId());
        clone.setConditionType(getConditionType());
        clone.setObjectiveId(getObjectiveId());
        clone.setMeasureThreshold(getMeasureThreshold());
        clone.setInverse(getInverse());
        clone.setRollupRuleID(getRollupRuleID());
        clone.setConditionRuleID(getConditionRuleID());

        return clone;
    }

    public int compareTo(LFRuleCondition lfRuleCondition) {
        long primaryKey = lfRuleCondition.getPrimaryKey();

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

        LFRuleConditionClp lfRuleCondition = null;

        try {
            lfRuleCondition = (LFRuleConditionClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfRuleCondition.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", conditionType=");
        sb.append(getConditionType());
        sb.append(", objectiveId=");
        sb.append(getObjectiveId());
        sb.append(", measureThreshold=");
        sb.append(getMeasureThreshold());
        sb.append(", inverse=");
        sb.append(getInverse());
        sb.append(", rollupRuleID=");
        sb.append(getRollupRuleID());
        sb.append(", conditionRuleID=");
        sb.append(getConditionRuleID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFRuleCondition");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conditionType</column-name><column-value><![CDATA[");
        sb.append(getConditionType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveId</column-name><column-value><![CDATA[");
        sb.append(getObjectiveId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>measureThreshold</column-name><column-value><![CDATA[");
        sb.append(getMeasureThreshold());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>inverse</column-name><column-value><![CDATA[");
        sb.append(getInverse());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rollupRuleID</column-name><column-value><![CDATA[");
        sb.append(getRollupRuleID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>conditionRuleID</column-name><column-value><![CDATA[");
        sb.append(getConditionRuleID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

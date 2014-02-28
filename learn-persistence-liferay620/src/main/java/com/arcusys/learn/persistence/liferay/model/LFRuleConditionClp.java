package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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

    @Override
    public Class<?> getModelClass() {
        return LFRuleCondition.class;
    }

    @Override
    public String getModelClassName() {
        return LFRuleCondition.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfRuleConditionRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getConditionType() {
        return _conditionType;
    }

    @Override
    public void setConditionType(String conditionType) {
        _conditionType = conditionType;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setConditionType", String.class);

                method.invoke(_lfRuleConditionRemoteModel, conditionType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjectiveId() {
        return _objectiveId;
    }

    @Override
    public void setObjectiveId(String objectiveId) {
        _objectiveId = objectiveId;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectiveId", String.class);

                method.invoke(_lfRuleConditionRemoteModel, objectiveId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public BigDecimal getMeasureThreshold() {
        return _measureThreshold;
    }

    @Override
    public void setMeasureThreshold(BigDecimal measureThreshold) {
        _measureThreshold = measureThreshold;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setMeasureThreshold",
                        BigDecimal.class);

                method.invoke(_lfRuleConditionRemoteModel, measureThreshold);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getInverse() {
        return _inverse;
    }

    @Override
    public boolean isInverse() {
        return _inverse;
    }

    @Override
    public void setInverse(boolean inverse) {
        _inverse = inverse;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setInverse", boolean.class);

                method.invoke(_lfRuleConditionRemoteModel, inverse);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getRollupRuleID() {
        return _rollupRuleID;
    }

    @Override
    public void setRollupRuleID(Integer rollupRuleID) {
        _rollupRuleID = rollupRuleID;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setRollupRuleID", Integer.class);

                method.invoke(_lfRuleConditionRemoteModel, rollupRuleID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getConditionRuleID() {
        return _conditionRuleID;
    }

    @Override
    public void setConditionRuleID(Integer conditionRuleID) {
        _conditionRuleID = conditionRuleID;

        if (_lfRuleConditionRemoteModel != null) {
            try {
                Class<?> clazz = _lfRuleConditionRemoteModel.getClass();

                Method method = clazz.getMethod("setConditionRuleID",
                        Integer.class);

                method.invoke(_lfRuleConditionRemoteModel, conditionRuleID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFRuleConditionRemoteModel() {
        return _lfRuleConditionRemoteModel;
    }

    public void setLFRuleConditionRemoteModel(
        BaseModel<?> lfRuleConditionRemoteModel) {
        _lfRuleConditionRemoteModel = lfRuleConditionRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _lfRuleConditionRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_lfRuleConditionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFRuleConditionLocalServiceUtil.addLFRuleCondition(this);
        } else {
            LFRuleConditionLocalServiceUtil.updateLFRuleCondition(this);
        }
    }

    @Override
    public LFRuleCondition toEscapedModel() {
        return (LFRuleCondition) ProxyUtil.newProxyInstance(LFRuleCondition.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFRuleConditionClp)) {
            return false;
        }

        LFRuleConditionClp lfRuleCondition = (LFRuleConditionClp) obj;

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

    @Override
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

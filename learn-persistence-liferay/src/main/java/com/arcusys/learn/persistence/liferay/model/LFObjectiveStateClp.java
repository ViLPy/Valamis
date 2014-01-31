package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalServiceUtil;

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

    @Override
    public Class<?> getModelClass() {
        return LFObjectiveState.class;
    }

    @Override
    public String getModelClassName() {
        return LFObjectiveState.class.getName();
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfObjectiveStateRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getSatisfied() {
        return _satisfied;
    }

    @Override
    public void setSatisfied(Boolean satisfied) {
        _satisfied = satisfied;

        if (_lfObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setSatisfied", Boolean.class);

                method.invoke(_lfObjectiveStateRemoteModel, satisfied);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public BigDecimal getNormalizedMeasure() {
        return _normalizedMeasure;
    }

    @Override
    public void setNormalizedMeasure(BigDecimal normalizedMeasure) {
        _normalizedMeasure = normalizedMeasure;

        if (_lfObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setNormalizedMeasure",
                        BigDecimal.class);

                method.invoke(_lfObjectiveStateRemoteModel, normalizedMeasure);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMapKey() {
        return _mapKey;
    }

    @Override
    public void setMapKey(String mapKey) {
        _mapKey = mapKey;

        if (_lfObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setMapKey", String.class);

                method.invoke(_lfObjectiveStateRemoteModel, mapKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getActivityStateID() {
        return _activityStateID;
    }

    @Override
    public void setActivityStateID(Integer activityStateID) {
        _activityStateID = activityStateID;

        if (_lfObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityStateID",
                        Integer.class);

                method.invoke(_lfObjectiveStateRemoteModel, activityStateID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getObjectiveID() {
        return _objectiveID;
    }

    @Override
    public void setObjectiveID(Integer objectiveID) {
        _objectiveID = objectiveID;

        if (_lfObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectiveID", Integer.class);

                method.invoke(_lfObjectiveStateRemoteModel, objectiveID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFObjectiveStateRemoteModel() {
        return _lfObjectiveStateRemoteModel;
    }

    public void setLFObjectiveStateRemoteModel(
        BaseModel<?> lfObjectiveStateRemoteModel) {
        _lfObjectiveStateRemoteModel = lfObjectiveStateRemoteModel;
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

        Class<?> remoteModelClass = _lfObjectiveStateRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfObjectiveStateRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFObjectiveStateLocalServiceUtil.addLFObjectiveState(this);
        } else {
            LFObjectiveStateLocalServiceUtil.updateLFObjectiveState(this);
        }
    }

    @Override
    public LFObjectiveState toEscapedModel() {
        return (LFObjectiveState) ProxyUtil.newProxyInstance(LFObjectiveState.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFObjectiveStateClp)) {
            return false;
        }

        LFObjectiveStateClp lfObjectiveState = (LFObjectiveStateClp) obj;

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

    @Override
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

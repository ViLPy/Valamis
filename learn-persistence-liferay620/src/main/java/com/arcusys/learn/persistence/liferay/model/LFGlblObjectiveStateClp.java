package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalServiceUtil;

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


public class LFGlblObjectiveStateClp extends BaseModelImpl<LFGlblObjectiveState>
    implements LFGlblObjectiveState {
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private Boolean _attemptCompleted;
    private String _mapKey;
    private Integer _treeID;
    private BaseModel<?> _lfGlblObjectiveStateRemoteModel;

    public LFGlblObjectiveStateClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFGlblObjectiveState.class;
    }

    @Override
    public String getModelClassName() {
        return LFGlblObjectiveState.class.getName();
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfGlblObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfGlblObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfGlblObjectiveStateRemoteModel, id);
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

        if (_lfGlblObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfGlblObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setSatisfied", Boolean.class);

                method.invoke(_lfGlblObjectiveStateRemoteModel, satisfied);
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

        if (_lfGlblObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfGlblObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setNormalizedMeasure",
                        BigDecimal.class);

                method.invoke(_lfGlblObjectiveStateRemoteModel,
                    normalizedMeasure);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getAttemptCompleted() {
        return _attemptCompleted;
    }

    @Override
    public void setAttemptCompleted(Boolean attemptCompleted) {
        _attemptCompleted = attemptCompleted;

        if (_lfGlblObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfGlblObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setAttemptCompleted",
                        Boolean.class);

                method.invoke(_lfGlblObjectiveStateRemoteModel, attemptCompleted);
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

        if (_lfGlblObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfGlblObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setMapKey", String.class);

                method.invoke(_lfGlblObjectiveStateRemoteModel, mapKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getTreeID() {
        return _treeID;
    }

    @Override
    public void setTreeID(Integer treeID) {
        _treeID = treeID;

        if (_lfGlblObjectiveStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfGlblObjectiveStateRemoteModel.getClass();

                Method method = clazz.getMethod("setTreeID", Integer.class);

                method.invoke(_lfGlblObjectiveStateRemoteModel, treeID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFGlblObjectiveStateRemoteModel() {
        return _lfGlblObjectiveStateRemoteModel;
    }

    public void setLFGlblObjectiveStateRemoteModel(
        BaseModel<?> lfGlblObjectiveStateRemoteModel) {
        _lfGlblObjectiveStateRemoteModel = lfGlblObjectiveStateRemoteModel;
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

        Class<?> remoteModelClass = _lfGlblObjectiveStateRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfGlblObjectiveStateRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFGlblObjectiveStateLocalServiceUtil.addLFGlblObjectiveState(this);
        } else {
            LFGlblObjectiveStateLocalServiceUtil.updateLFGlblObjectiveState(this);
        }
    }

    @Override
    public LFGlblObjectiveState toEscapedModel() {
        return (LFGlblObjectiveState) ProxyUtil.newProxyInstance(LFGlblObjectiveState.class.getClassLoader(),
            new Class[] { LFGlblObjectiveState.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFGlblObjectiveStateClp clone = new LFGlblObjectiveStateClp();

        clone.setId(getId());
        clone.setSatisfied(getSatisfied());
        clone.setNormalizedMeasure(getNormalizedMeasure());
        clone.setAttemptCompleted(getAttemptCompleted());
        clone.setMapKey(getMapKey());
        clone.setTreeID(getTreeID());

        return clone;
    }

    @Override
    public int compareTo(LFGlblObjectiveState lfGlblObjectiveState) {
        long primaryKey = lfGlblObjectiveState.getPrimaryKey();

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

        if (!(obj instanceof LFGlblObjectiveStateClp)) {
            return false;
        }

        LFGlblObjectiveStateClp lfGlblObjectiveState = (LFGlblObjectiveStateClp) obj;

        long primaryKey = lfGlblObjectiveState.getPrimaryKey();

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

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState");
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

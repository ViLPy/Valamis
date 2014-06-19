package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsStateClp extends BaseModelImpl<LFTincanLrsState>
    implements LFTincanLrsState {
    private long _id;
    private String _stateId;
    private String _documentId;
    private String _activityId;
    private String _registration;
    private Integer _agentId;
    private BaseModel<?> _lfTincanLrsStateRemoteModel;

    public LFTincanLrsStateClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsState.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsState.class.getName();
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
        attributes.put("stateId", getStateId());
        attributes.put("documentId", getDocumentId());
        attributes.put("activityId", getActivityId());
        attributes.put("registration", getRegistration());
        attributes.put("agentId", getAgentId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String stateId = (String) attributes.get("stateId");

        if (stateId != null) {
            setStateId(stateId);
        }

        String documentId = (String) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        String activityId = (String) attributes.get("activityId");

        if (activityId != null) {
            setActivityId(activityId);
        }

        String registration = (String) attributes.get("registration");

        if (registration != null) {
            setRegistration(registration);
        }

        Integer agentId = (Integer) attributes.get("agentId");

        if (agentId != null) {
            setAgentId(agentId);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStateRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsStateRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStateId() {
        return _stateId;
    }

    @Override
    public void setStateId(String stateId) {
        _stateId = stateId;

        if (_lfTincanLrsStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStateRemoteModel.getClass();

                Method method = clazz.getMethod("setStateId", String.class);

                method.invoke(_lfTincanLrsStateRemoteModel, stateId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDocumentId() {
        return _documentId;
    }

    @Override
    public void setDocumentId(String documentId) {
        _documentId = documentId;

        if (_lfTincanLrsStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStateRemoteModel.getClass();

                Method method = clazz.getMethod("setDocumentId", String.class);

                method.invoke(_lfTincanLrsStateRemoteModel, documentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityId() {
        return _activityId;
    }

    @Override
    public void setActivityId(String activityId) {
        _activityId = activityId;

        if (_lfTincanLrsStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStateRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityId", String.class);

                method.invoke(_lfTincanLrsStateRemoteModel, activityId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRegistration() {
        return _registration;
    }

    @Override
    public void setRegistration(String registration) {
        _registration = registration;

        if (_lfTincanLrsStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStateRemoteModel.getClass();

                Method method = clazz.getMethod("setRegistration", String.class);

                method.invoke(_lfTincanLrsStateRemoteModel, registration);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAgentId() {
        return _agentId;
    }

    @Override
    public void setAgentId(Integer agentId) {
        _agentId = agentId;

        if (_lfTincanLrsStateRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsStateRemoteModel.getClass();

                Method method = clazz.getMethod("setAgentId", Integer.class);

                method.invoke(_lfTincanLrsStateRemoteModel, agentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsStateRemoteModel() {
        return _lfTincanLrsStateRemoteModel;
    }

    public void setLFTincanLrsStateRemoteModel(
        BaseModel<?> lfTincanLrsStateRemoteModel) {
        _lfTincanLrsStateRemoteModel = lfTincanLrsStateRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsStateRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsStateRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsStateLocalServiceUtil.addLFTincanLrsState(this);
        } else {
            LFTincanLrsStateLocalServiceUtil.updateLFTincanLrsState(this);
        }
    }

    @Override
    public LFTincanLrsState toEscapedModel() {
        return (LFTincanLrsState) ProxyUtil.newProxyInstance(LFTincanLrsState.class.getClassLoader(),
            new Class[] { LFTincanLrsState.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsStateClp clone = new LFTincanLrsStateClp();

        clone.setId(getId());
        clone.setStateId(getStateId());
        clone.setDocumentId(getDocumentId());
        clone.setActivityId(getActivityId());
        clone.setRegistration(getRegistration());
        clone.setAgentId(getAgentId());

        return clone;
    }

    @Override
    public int compareTo(LFTincanLrsState lfTincanLrsState) {
        long primaryKey = lfTincanLrsState.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsStateClp)) {
            return false;
        }

        LFTincanLrsStateClp lfTincanLrsState = (LFTincanLrsStateClp) obj;

        long primaryKey = lfTincanLrsState.getPrimaryKey();

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
        sb.append(", stateId=");
        sb.append(getStateId());
        sb.append(", documentId=");
        sb.append(getDocumentId());
        sb.append(", activityId=");
        sb.append(getActivityId());
        sb.append(", registration=");
        sb.append(getRegistration());
        sb.append(", agentId=");
        sb.append(getAgentId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsState");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateId</column-name><column-value><![CDATA[");
        sb.append(getStateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentId</column-name><column-value><![CDATA[");
        sb.append(getDocumentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityId</column-name><column-value><![CDATA[");
        sb.append(getActivityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registration</column-name><column-value><![CDATA[");
        sb.append(getRegistration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agentId</column-name><column-value><![CDATA[");
        sb.append(getAgentId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

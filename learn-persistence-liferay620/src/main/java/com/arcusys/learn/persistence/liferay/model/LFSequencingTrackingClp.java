package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil;

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


public class LFSequencingTrackingClp extends BaseModelImpl<LFSequencingTracking>
    implements LFSequencingTracking {
    private long _id;
    private Integer _sequencingID;
    private boolean _completionSetByContent;
    private boolean _objectiveSetByContent;
    private BaseModel<?> _lfSequencingTrackingRemoteModel;

    public LFSequencingTrackingClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSequencingTracking.class;
    }

    @Override
    public String getModelClassName() {
        return LFSequencingTracking.class.getName();
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
        attributes.put("sequencingID", getSequencingID());
        attributes.put("completionSetByContent", getCompletionSetByContent());
        attributes.put("objectiveSetByContent", getObjectiveSetByContent());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean completionSetByContent = (Boolean) attributes.get(
                "completionSetByContent");

        if (completionSetByContent != null) {
            setCompletionSetByContent(completionSetByContent);
        }

        Boolean objectiveSetByContent = (Boolean) attributes.get(
                "objectiveSetByContent");

        if (objectiveSetByContent != null) {
            setObjectiveSetByContent(objectiveSetByContent);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSequencingTrackingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingTrackingRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSequencingTrackingRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getSequencingID() {
        return _sequencingID;
    }

    @Override
    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;

        if (_lfSequencingTrackingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingTrackingRemoteModel.getClass();

                Method method = clazz.getMethod("setSequencingID", Integer.class);

                method.invoke(_lfSequencingTrackingRemoteModel, sequencingID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCompletionSetByContent() {
        return _completionSetByContent;
    }

    @Override
    public boolean isCompletionSetByContent() {
        return _completionSetByContent;
    }

    @Override
    public void setCompletionSetByContent(boolean completionSetByContent) {
        _completionSetByContent = completionSetByContent;

        if (_lfSequencingTrackingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingTrackingRemoteModel.getClass();

                Method method = clazz.getMethod("setCompletionSetByContent",
                        boolean.class);

                method.invoke(_lfSequencingTrackingRemoteModel,
                    completionSetByContent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    @Override
    public boolean isObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    @Override
    public void setObjectiveSetByContent(boolean objectiveSetByContent) {
        _objectiveSetByContent = objectiveSetByContent;

        if (_lfSequencingTrackingRemoteModel != null) {
            try {
                Class<?> clazz = _lfSequencingTrackingRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectiveSetByContent",
                        boolean.class);

                method.invoke(_lfSequencingTrackingRemoteModel,
                    objectiveSetByContent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSequencingTrackingRemoteModel() {
        return _lfSequencingTrackingRemoteModel;
    }

    public void setLFSequencingTrackingRemoteModel(
        BaseModel<?> lfSequencingTrackingRemoteModel) {
        _lfSequencingTrackingRemoteModel = lfSequencingTrackingRemoteModel;
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

        Class<?> remoteModelClass = _lfSequencingTrackingRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSequencingTrackingRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSequencingTrackingLocalServiceUtil.addLFSequencingTracking(this);
        } else {
            LFSequencingTrackingLocalServiceUtil.updateLFSequencingTracking(this);
        }
    }

    @Override
    public LFSequencingTracking toEscapedModel() {
        return (LFSequencingTracking) ProxyUtil.newProxyInstance(LFSequencingTracking.class.getClassLoader(),
            new Class[] { LFSequencingTracking.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSequencingTrackingClp clone = new LFSequencingTrackingClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setCompletionSetByContent(getCompletionSetByContent());
        clone.setObjectiveSetByContent(getObjectiveSetByContent());

        return clone;
    }

    @Override
    public int compareTo(LFSequencingTracking lfSequencingTracking) {
        long primaryKey = lfSequencingTracking.getPrimaryKey();

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

        if (!(obj instanceof LFSequencingTrackingClp)) {
            return false;
        }

        LFSequencingTrackingClp lfSequencingTracking = (LFSequencingTrackingClp) obj;

        long primaryKey = lfSequencingTracking.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", completionSetByContent=");
        sb.append(getCompletionSetByContent());
        sb.append(", objectiveSetByContent=");
        sb.append(getObjectiveSetByContent());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFSequencingTracking");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>completionSetByContent</column-name><column-value><![CDATA[");
        sb.append(getCompletionSetByContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveSetByContent</column-name><column-value><![CDATA[");
        sb.append(getObjectiveSetByContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

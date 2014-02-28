package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil;

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


public class LFActivityDataMapClp extends BaseModelImpl<LFActivityDataMap>
    implements LFActivityDataMap {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _targetId;
    private boolean _readSharedData;
    private boolean _writeSharedData;
    private BaseModel<?> _lfActivityDataMapRemoteModel;

    public LFActivityDataMapClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFActivityDataMap.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivityDataMap.class.getName();
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
        attributes.put("packageID", getPackageID());
        attributes.put("activityID", getActivityID());
        attributes.put("targetId", getTargetId());
        attributes.put("readSharedData", getReadSharedData());
        attributes.put("writeSharedData", getWriteSharedData());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        String targetId = (String) attributes.get("targetId");

        if (targetId != null) {
            setTargetId(targetId);
        }

        Boolean readSharedData = (Boolean) attributes.get("readSharedData");

        if (readSharedData != null) {
            setReadSharedData(readSharedData);
        }

        Boolean writeSharedData = (Boolean) attributes.get("writeSharedData");

        if (writeSharedData != null) {
            setWriteSharedData(writeSharedData);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfActivityDataMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityDataMapRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfActivityDataMapRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getPackageID() {
        return _packageID;
    }

    @Override
    public void setPackageID(Integer packageID) {
        _packageID = packageID;

        if (_lfActivityDataMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityDataMapRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfActivityDataMapRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityID() {
        return _activityID;
    }

    @Override
    public void setActivityID(String activityID) {
        _activityID = activityID;

        if (_lfActivityDataMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityDataMapRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityID", String.class);

                method.invoke(_lfActivityDataMapRemoteModel, activityID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTargetId() {
        return _targetId;
    }

    @Override
    public void setTargetId(String targetId) {
        _targetId = targetId;

        if (_lfActivityDataMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityDataMapRemoteModel.getClass();

                Method method = clazz.getMethod("setTargetId", String.class);

                method.invoke(_lfActivityDataMapRemoteModel, targetId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getReadSharedData() {
        return _readSharedData;
    }

    @Override
    public boolean isReadSharedData() {
        return _readSharedData;
    }

    @Override
    public void setReadSharedData(boolean readSharedData) {
        _readSharedData = readSharedData;

        if (_lfActivityDataMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityDataMapRemoteModel.getClass();

                Method method = clazz.getMethod("setReadSharedData",
                        boolean.class);

                method.invoke(_lfActivityDataMapRemoteModel, readSharedData);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getWriteSharedData() {
        return _writeSharedData;
    }

    @Override
    public boolean isWriteSharedData() {
        return _writeSharedData;
    }

    @Override
    public void setWriteSharedData(boolean writeSharedData) {
        _writeSharedData = writeSharedData;

        if (_lfActivityDataMapRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityDataMapRemoteModel.getClass();

                Method method = clazz.getMethod("setWriteSharedData",
                        boolean.class);

                method.invoke(_lfActivityDataMapRemoteModel, writeSharedData);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFActivityDataMapRemoteModel() {
        return _lfActivityDataMapRemoteModel;
    }

    public void setLFActivityDataMapRemoteModel(
        BaseModel<?> lfActivityDataMapRemoteModel) {
        _lfActivityDataMapRemoteModel = lfActivityDataMapRemoteModel;
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

        Class<?> remoteModelClass = _lfActivityDataMapRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfActivityDataMapRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityDataMapLocalServiceUtil.addLFActivityDataMap(this);
        } else {
            LFActivityDataMapLocalServiceUtil.updateLFActivityDataMap(this);
        }
    }

    @Override
    public LFActivityDataMap toEscapedModel() {
        return (LFActivityDataMap) ProxyUtil.newProxyInstance(LFActivityDataMap.class.getClassLoader(),
            new Class[] { LFActivityDataMap.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityDataMapClp clone = new LFActivityDataMapClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setActivityID(getActivityID());
        clone.setTargetId(getTargetId());
        clone.setReadSharedData(getReadSharedData());
        clone.setWriteSharedData(getWriteSharedData());

        return clone;
    }

    @Override
    public int compareTo(LFActivityDataMap lfActivityDataMap) {
        long primaryKey = lfActivityDataMap.getPrimaryKey();

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

        if (!(obj instanceof LFActivityDataMapClp)) {
            return false;
        }

        LFActivityDataMapClp lfActivityDataMap = (LFActivityDataMapClp) obj;

        long primaryKey = lfActivityDataMap.getPrimaryKey();

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
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", activityID=");
        sb.append(getActivityID());
        sb.append(", targetId=");
        sb.append(getTargetId());
        sb.append(", readSharedData=");
        sb.append(getReadSharedData());
        sb.append(", writeSharedData=");
        sb.append(getWriteSharedData());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFActivityDataMap");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityID</column-name><column-value><![CDATA[");
        sb.append(getActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetId</column-name><column-value><![CDATA[");
        sb.append(getTargetId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readSharedData</column-name><column-value><![CDATA[");
        sb.append(getReadSharedData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeSharedData</column-name><column-value><![CDATA[");
        sb.append(getWriteSharedData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

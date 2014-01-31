package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil;

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


public class LFConfigClp extends BaseModelImpl<LFConfig> implements LFConfig {
    private long _id;
    private String _dataKey;
    private String _dataValue;
    private BaseModel<?> _lfConfigRemoteModel;

    public LFConfigClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFConfig.class;
    }

    @Override
    public String getModelClassName() {
        return LFConfig.class.getName();
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
        attributes.put("dataKey", getDataKey());
        attributes.put("dataValue", getDataValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String dataKey = (String) attributes.get("dataKey");

        if (dataKey != null) {
            setDataKey(dataKey);
        }

        String dataValue = (String) attributes.get("dataValue");

        if (dataValue != null) {
            setDataValue(dataValue);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfConfigRemoteModel != null) {
            try {
                Class<?> clazz = _lfConfigRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfConfigRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDataKey() {
        return _dataKey;
    }

    @Override
    public void setDataKey(String dataKey) {
        _dataKey = dataKey;

        if (_lfConfigRemoteModel != null) {
            try {
                Class<?> clazz = _lfConfigRemoteModel.getClass();

                Method method = clazz.getMethod("setDataKey", String.class);

                method.invoke(_lfConfigRemoteModel, dataKey);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDataValue() {
        return _dataValue;
    }

    @Override
    public void setDataValue(String dataValue) {
        _dataValue = dataValue;

        if (_lfConfigRemoteModel != null) {
            try {
                Class<?> clazz = _lfConfigRemoteModel.getClass();

                Method method = clazz.getMethod("setDataValue", String.class);

                method.invoke(_lfConfigRemoteModel, dataValue);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFConfigRemoteModel() {
        return _lfConfigRemoteModel;
    }

    public void setLFConfigRemoteModel(BaseModel<?> lfConfigRemoteModel) {
        _lfConfigRemoteModel = lfConfigRemoteModel;
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

        Class<?> remoteModelClass = _lfConfigRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfConfigRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFConfigLocalServiceUtil.addLFConfig(this);
        } else {
            LFConfigLocalServiceUtil.updateLFConfig(this);
        }
    }

    @Override
    public LFConfig toEscapedModel() {
        return (LFConfig) ProxyUtil.newProxyInstance(LFConfig.class.getClassLoader(),
            new Class[] { LFConfig.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFConfigClp clone = new LFConfigClp();

        clone.setId(getId());
        clone.setDataKey(getDataKey());
        clone.setDataValue(getDataValue());

        return clone;
    }

    @Override
    public int compareTo(LFConfig lfConfig) {
        long primaryKey = lfConfig.getPrimaryKey();

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

        if (!(obj instanceof LFConfigClp)) {
            return false;
        }

        LFConfigClp lfConfig = (LFConfigClp) obj;

        long primaryKey = lfConfig.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", dataKey=");
        sb.append(getDataKey());
        sb.append(", dataValue=");
        sb.append(getDataValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFConfig");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataKey</column-name><column-value><![CDATA[");
        sb.append(getDataKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataValue</column-name><column-value><![CDATA[");
        sb.append(getDataValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

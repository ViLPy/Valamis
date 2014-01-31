package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil;

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


public class LFTincanLrsEndpointClp extends BaseModelImpl<LFTincanLrsEndpoint>
    implements LFTincanLrsEndpoint {
    private long _id;
    private String _endpoint;
    private String _authType;
    private String _key;
    private String _secret;
    private BaseModel<?> _lfTincanLrsEndpointRemoteModel;

    public LFTincanLrsEndpointClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsEndpoint.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsEndpoint.class.getName();
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
        attributes.put("endpoint", getEndpoint());
        attributes.put("authType", getAuthType());
        attributes.put("key", getKey());
        attributes.put("secret", getSecret());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String endpoint = (String) attributes.get("endpoint");

        if (endpoint != null) {
            setEndpoint(endpoint);
        }

        String authType = (String) attributes.get("authType");

        if (authType != null) {
            setAuthType(authType);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String secret = (String) attributes.get("secret");

        if (secret != null) {
            setSecret(secret);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsEndpointRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsEndpointRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsEndpointRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEndpoint() {
        return _endpoint;
    }

    @Override
    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;

        if (_lfTincanLrsEndpointRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsEndpointRemoteModel.getClass();

                Method method = clazz.getMethod("setEndpoint", String.class);

                method.invoke(_lfTincanLrsEndpointRemoteModel, endpoint);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAuthType() {
        return _authType;
    }

    @Override
    public void setAuthType(String authType) {
        _authType = authType;

        if (_lfTincanLrsEndpointRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsEndpointRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthType", String.class);

                method.invoke(_lfTincanLrsEndpointRemoteModel, authType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKey() {
        return _key;
    }

    @Override
    public void setKey(String key) {
        _key = key;

        if (_lfTincanLrsEndpointRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsEndpointRemoteModel.getClass();

                Method method = clazz.getMethod("setKey", String.class);

                method.invoke(_lfTincanLrsEndpointRemoteModel, key);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSecret() {
        return _secret;
    }

    @Override
    public void setSecret(String secret) {
        _secret = secret;

        if (_lfTincanLrsEndpointRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsEndpointRemoteModel.getClass();

                Method method = clazz.getMethod("setSecret", String.class);

                method.invoke(_lfTincanLrsEndpointRemoteModel, secret);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsEndpointRemoteModel() {
        return _lfTincanLrsEndpointRemoteModel;
    }

    public void setLFTincanLrsEndpointRemoteModel(
        BaseModel<?> lfTincanLrsEndpointRemoteModel) {
        _lfTincanLrsEndpointRemoteModel = lfTincanLrsEndpointRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsEndpointRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsEndpointRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsEndpointLocalServiceUtil.addLFTincanLrsEndpoint(this);
        } else {
            LFTincanLrsEndpointLocalServiceUtil.updateLFTincanLrsEndpoint(this);
        }
    }

    @Override
    public LFTincanLrsEndpoint toEscapedModel() {
        return (LFTincanLrsEndpoint) ProxyUtil.newProxyInstance(LFTincanLrsEndpoint.class.getClassLoader(),
            new Class[] { LFTincanLrsEndpoint.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsEndpointClp clone = new LFTincanLrsEndpointClp();

        clone.setId(getId());
        clone.setEndpoint(getEndpoint());
        clone.setAuthType(getAuthType());
        clone.setKey(getKey());
        clone.setSecret(getSecret());

        return clone;
    }

    @Override
    public int compareTo(LFTincanLrsEndpoint lfTincanLrsEndpoint) {
        long primaryKey = lfTincanLrsEndpoint.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsEndpointClp)) {
            return false;
        }

        LFTincanLrsEndpointClp lfTincanLrsEndpoint = (LFTincanLrsEndpointClp) obj;

        long primaryKey = lfTincanLrsEndpoint.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", endpoint=");
        sb.append(getEndpoint());
        sb.append(", authType=");
        sb.append(getAuthType());
        sb.append(", key=");
        sb.append(getKey());
        sb.append(", secret=");
        sb.append(getSecret());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsEndpoint");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endpoint</column-name><column-value><![CDATA[");
        sb.append(getEndpoint());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authType</column-name><column-value><![CDATA[");
        sb.append(getAuthType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>key</column-name><column-value><![CDATA[");
        sb.append(getKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>secret</column-name><column-value><![CDATA[");
        sb.append(getSecret());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

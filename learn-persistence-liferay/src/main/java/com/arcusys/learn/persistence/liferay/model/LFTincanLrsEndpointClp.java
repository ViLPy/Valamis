package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsEndpointLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFTincanLrsEndpoint.class;
    }

    public String getModelClassName() {
        return LFTincanLrsEndpoint.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
    }

    public String getAuthType() {
        return _authType;
    }

    public void setAuthType(String authType) {
        _authType = authType;
    }

    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getSecret() {
        return _secret;
    }

    public void setSecret(String secret) {
        _secret = secret;
    }

    public BaseModel<?> getLFTincanLrsEndpointRemoteModel() {
        return _lfTincanLrsEndpointRemoteModel;
    }

    public void setLFTincanLrsEndpointRemoteModel(
        BaseModel<?> lfTincanLrsEndpointRemoteModel) {
        _lfTincanLrsEndpointRemoteModel = lfTincanLrsEndpointRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsEndpointLocalServiceUtil.addLFTincanLrsEndpoint(this);
        } else {
            LFTincanLrsEndpointLocalServiceUtil.updateLFTincanLrsEndpoint(this);
        }
    }

    @Override
    public LFTincanLrsEndpoint toEscapedModel() {
        return (LFTincanLrsEndpoint) Proxy.newProxyInstance(LFTincanLrsEndpoint.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFTincanLrsEndpointClp lfTincanLrsEndpoint = null;

        try {
            lfTincanLrsEndpoint = (LFTincanLrsEndpointClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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

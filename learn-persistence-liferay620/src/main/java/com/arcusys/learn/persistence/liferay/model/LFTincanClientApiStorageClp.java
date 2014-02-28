package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanClientApiStorageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LFTincanClientApiStorageClp extends BaseModelImpl<LFTincanClientApiStorage>
    implements LFTincanClientApiStorage {
    private long _id;
    private String _name;
    private String _description;
    private String _secret;
    private String _url;
    private String _redirectUrl;
    private String _scope;
    private String _iconUrl;
    private String _token;
    private String _code;
    private Date _issuedAt;
    private Long _expiredIn;
    private BaseModel<?> _lfTincanClientApiStorageRemoteModel;

    public LFTincanClientApiStorageClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanClientApiStorage.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanClientApiStorage.class.getName();
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
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("secret", getSecret());
        attributes.put("url", getUrl());
        attributes.put("redirectUrl", getRedirectUrl());
        attributes.put("scope", getScope());
        attributes.put("iconUrl", getIconUrl());
        attributes.put("token", getToken());
        attributes.put("code", getCode());
        attributes.put("issuedAt", getIssuedAt());
        attributes.put("expiredIn", getExpiredIn());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String secret = (String) attributes.get("secret");

        if (secret != null) {
            setSecret(secret);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String redirectUrl = (String) attributes.get("redirectUrl");

        if (redirectUrl != null) {
            setRedirectUrl(redirectUrl);
        }

        String scope = (String) attributes.get("scope");

        if (scope != null) {
            setScope(scope);
        }

        String iconUrl = (String) attributes.get("iconUrl");

        if (iconUrl != null) {
            setIconUrl(iconUrl);
        }

        String token = (String) attributes.get("token");

        if (token != null) {
            setToken(token);
        }

        String code = (String) attributes.get("code");

        if (code != null) {
            setCode(code);
        }

        Date issuedAt = (Date) attributes.get("issuedAt");

        if (issuedAt != null) {
            setIssuedAt(issuedAt);
        }

        Long expiredIn = (Long) attributes.get("expiredIn");

        if (expiredIn != null) {
            setExpiredIn(expiredIn);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, description);
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

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setSecret", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, secret);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrl() {
        return _url;
    }

    @Override
    public void setUrl(String url) {
        _url = url;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRedirectUrl() {
        return _redirectUrl;
    }

    @Override
    public void setRedirectUrl(String redirectUrl) {
        _redirectUrl = redirectUrl;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setRedirectUrl", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, redirectUrl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScope() {
        return _scope;
    }

    @Override
    public void setScope(String scope) {
        _scope = scope;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setScope", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, scope);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIconUrl() {
        return _iconUrl;
    }

    @Override
    public void setIconUrl(String iconUrl) {
        _iconUrl = iconUrl;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setIconUrl", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, iconUrl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getToken() {
        return _token;
    }

    @Override
    public void setToken(String token) {
        _token = token;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setToken", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, token);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCode() {
        return _code;
    }

    @Override
    public void setCode(String code) {
        _code = code;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setCode", String.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, code);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getIssuedAt() {
        return _issuedAt;
    }

    @Override
    public void setIssuedAt(Date issuedAt) {
        _issuedAt = issuedAt;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setIssuedAt", Date.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, issuedAt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getExpiredIn() {
        return _expiredIn;
    }

    @Override
    public void setExpiredIn(Long expiredIn) {
        _expiredIn = expiredIn;

        if (_lfTincanClientApiStorageRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanClientApiStorageRemoteModel.getClass();

                Method method = clazz.getMethod("setExpiredIn", Long.class);

                method.invoke(_lfTincanClientApiStorageRemoteModel, expiredIn);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanClientApiStorageRemoteModel() {
        return _lfTincanClientApiStorageRemoteModel;
    }

    public void setLFTincanClientApiStorageRemoteModel(
        BaseModel<?> lfTincanClientApiStorageRemoteModel) {
        _lfTincanClientApiStorageRemoteModel = lfTincanClientApiStorageRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanClientApiStorageRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanClientApiStorageRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanClientApiStorageLocalServiceUtil.addLFTincanClientApiStorage(this);
        } else {
            LFTincanClientApiStorageLocalServiceUtil.updateLFTincanClientApiStorage(this);
        }
    }

    @Override
    public LFTincanClientApiStorage toEscapedModel() {
        return (LFTincanClientApiStorage) ProxyUtil.newProxyInstance(LFTincanClientApiStorage.class.getClassLoader(),
            new Class[] { LFTincanClientApiStorage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanClientApiStorageClp clone = new LFTincanClientApiStorageClp();

        clone.setId(getId());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setSecret(getSecret());
        clone.setUrl(getUrl());
        clone.setRedirectUrl(getRedirectUrl());
        clone.setScope(getScope());
        clone.setIconUrl(getIconUrl());
        clone.setToken(getToken());
        clone.setCode(getCode());
        clone.setIssuedAt(getIssuedAt());
        clone.setExpiredIn(getExpiredIn());

        return clone;
    }

    @Override
    public int compareTo(LFTincanClientApiStorage lfTincanClientApiStorage) {
        long primaryKey = lfTincanClientApiStorage.getPrimaryKey();

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

        if (!(obj instanceof LFTincanClientApiStorageClp)) {
            return false;
        }

        LFTincanClientApiStorageClp lfTincanClientApiStorage = (LFTincanClientApiStorageClp) obj;

        long primaryKey = lfTincanClientApiStorage.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", secret=");
        sb.append(getSecret());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", redirectUrl=");
        sb.append(getRedirectUrl());
        sb.append(", scope=");
        sb.append(getScope());
        sb.append(", iconUrl=");
        sb.append(getIconUrl());
        sb.append(", token=");
        sb.append(getToken());
        sb.append(", code=");
        sb.append(getCode());
        sb.append(", issuedAt=");
        sb.append(getIssuedAt());
        sb.append(", expiredIn=");
        sb.append(getExpiredIn());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanClientApiStorage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>secret</column-name><column-value><![CDATA[");
        sb.append(getSecret());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>redirectUrl</column-name><column-value><![CDATA[");
        sb.append(getRedirectUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scope</column-name><column-value><![CDATA[");
        sb.append(getScope());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>iconUrl</column-name><column-value><![CDATA[");
        sb.append(getIconUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>token</column-name><column-value><![CDATA[");
        sb.append(getToken());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>code</column-name><column-value><![CDATA[");
        sb.append(getCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>issuedAt</column-name><column-value><![CDATA[");
        sb.append(getIssuedAt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>expiredIn</column-name><column-value><![CDATA[");
        sb.append(getExpiredIn());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

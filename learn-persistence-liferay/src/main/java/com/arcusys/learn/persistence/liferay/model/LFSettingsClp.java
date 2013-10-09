package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFSettingsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFSettingsClp extends BaseModelImpl<LFSettings>
    implements LFSettings {
    private long _id;
    private String _key;
    private String _value;
    private BaseModel<?> _lfSettingsRemoteModel;

    public LFSettingsClp() {
    }

    public Class<?> getModelClass() {
        return LFSettings.class;
    }

    public String getModelClassName() {
        return LFSettings.class.getName();
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
        attributes.put("key", getKey());
        attributes.put("value", getValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    public BaseModel<?> getLFSettingsRemoteModel() {
        return _lfSettingsRemoteModel;
    }

    public void setLFSettingsRemoteModel(BaseModel<?> lfSettingsRemoteModel) {
        _lfSettingsRemoteModel = lfSettingsRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSettingsLocalServiceUtil.addLFSettings(this);
        } else {
            LFSettingsLocalServiceUtil.updateLFSettings(this);
        }
    }

    @Override
    public LFSettings toEscapedModel() {
        return (LFSettings) Proxy.newProxyInstance(LFSettings.class.getClassLoader(),
            new Class[] { LFSettings.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSettingsClp clone = new LFSettingsClp();

        clone.setId(getId());
        clone.setKey(getKey());
        clone.setValue(getValue());

        return clone;
    }

    public int compareTo(LFSettings lfSettings) {
        long primaryKey = lfSettings.getPrimaryKey();

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

        LFSettingsClp lfSettings = null;

        try {
            lfSettings = (LFSettingsClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSettings.getPrimaryKey();

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
        sb.append(", key=");
        sb.append(getKey());
        sb.append(", value=");
        sb.append(getValue());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSettings");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>key</column-name><column-value><![CDATA[");
        sb.append(getKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

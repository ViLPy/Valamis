package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFSettingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFSettingClp extends BaseModelImpl<LFSetting> implements LFSetting {
    private long _id;
    private String _key;
    private String _value;
    private BaseModel<?> _lfSettingRemoteModel;

    public LFSettingClp() {
    }

    public Class<?> getModelClass() {
        return LFSetting.class;
    }

    public String getModelClassName() {
        return LFSetting.class.getName();
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

    public BaseModel<?> getLFSettingRemoteModel() {
        return _lfSettingRemoteModel;
    }

    public void setLFSettingRemoteModel(BaseModel<?> lfSettingRemoteModel) {
        _lfSettingRemoteModel = lfSettingRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSettingLocalServiceUtil.addLFSetting(this);
        } else {
            LFSettingLocalServiceUtil.updateLFSetting(this);
        }
    }

    @Override
    public LFSetting toEscapedModel() {
        return (LFSetting) Proxy.newProxyInstance(LFSetting.class.getClassLoader(),
            new Class[] { LFSetting.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSettingClp clone = new LFSettingClp();

        clone.setId(getId());
        clone.setKey(getKey());
        clone.setValue(getValue());

        return clone;
    }

    public int compareTo(LFSetting lfSetting) {
        long primaryKey = lfSetting.getPrimaryKey();

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

        LFSettingClp lfSetting = null;

        try {
            lfSetting = (LFSettingClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSetting.getPrimaryKey();

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
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSetting");
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

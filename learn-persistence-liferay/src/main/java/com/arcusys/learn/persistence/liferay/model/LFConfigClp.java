package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFConfigClp extends BaseModelImpl<LFConfig> implements LFConfig {
    private long _id;
    private String _dataKey;
    private String _dataValue;
    private BaseModel<?> _lfConfigRemoteModel;

    public LFConfigClp() {
    }

    public Class<?> getModelClass() {
        return LFConfig.class;
    }

    public String getModelClassName() {
        return LFConfig.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getDataKey() {
        return _dataKey;
    }

    public void setDataKey(String dataKey) {
        _dataKey = dataKey;
    }

    public String getDataValue() {
        return _dataValue;
    }

    public void setDataValue(String dataValue) {
        _dataValue = dataValue;
    }

    public BaseModel<?> getLFConfigRemoteModel() {
        return _lfConfigRemoteModel;
    }

    public void setLFConfigRemoteModel(BaseModel<?> lfConfigRemoteModel) {
        _lfConfigRemoteModel = lfConfigRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFConfigLocalServiceUtil.addLFConfig(this);
        } else {
            LFConfigLocalServiceUtil.updateLFConfig(this);
        }
    }

    @Override
    public LFConfig toEscapedModel() {
        return (LFConfig) Proxy.newProxyInstance(LFConfig.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFConfigClp lfConfig = null;

        try {
            lfConfig = (LFConfigClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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

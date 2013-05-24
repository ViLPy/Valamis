package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFUserClp extends BaseModelImpl<LFUser> implements LFUser {
    private long _lfid;
    private Integer _id;
    private String _name;
    private Double _preferredAudioLevel;
    private String _preferredLanguage;
    private Double _preferredDeliverySpeed;
    private Integer _preferredAudioCaptioning;
    private BaseModel<?> _lfUserRemoteModel;

    public LFUserClp() {
    }

    public Class<?> getModelClass() {
        return LFUser.class;
    }

    public String getModelClassName() {
        return LFUser.class.getName();
    }

    public long getPrimaryKey() {
        return _lfid;
    }

    public void setPrimaryKey(long primaryKey) {
        setLfid(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_lfid);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("lfid", getLfid());
        attributes.put("id", getId());
        attributes.put("name", getName());
        attributes.put("preferredAudioLevel", getPreferredAudioLevel());
        attributes.put("preferredLanguage", getPreferredLanguage());
        attributes.put("preferredDeliverySpeed", getPreferredDeliverySpeed());
        attributes.put("preferredAudioCaptioning", getPreferredAudioCaptioning());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long lfid = (Long) attributes.get("lfid");

        if (lfid != null) {
            setLfid(lfid);
        }

        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Double preferredAudioLevel = (Double) attributes.get(
                "preferredAudioLevel");

        if (preferredAudioLevel != null) {
            setPreferredAudioLevel(preferredAudioLevel);
        }

        String preferredLanguage = (String) attributes.get("preferredLanguage");

        if (preferredLanguage != null) {
            setPreferredLanguage(preferredLanguage);
        }

        Double preferredDeliverySpeed = (Double) attributes.get(
                "preferredDeliverySpeed");

        if (preferredDeliverySpeed != null) {
            setPreferredDeliverySpeed(preferredDeliverySpeed);
        }

        Integer preferredAudioCaptioning = (Integer) attributes.get(
                "preferredAudioCaptioning");

        if (preferredAudioCaptioning != null) {
            setPreferredAudioCaptioning(preferredAudioCaptioning);
        }
    }

    public long getLfid() {
        return _lfid;
    }

    public void setLfid(long lfid) {
        _lfid = lfid;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Double getPreferredAudioLevel() {
        return _preferredAudioLevel;
    }

    public void setPreferredAudioLevel(Double preferredAudioLevel) {
        _preferredAudioLevel = preferredAudioLevel;
    }

    public String getPreferredLanguage() {
        return _preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        _preferredLanguage = preferredLanguage;
    }

    public Double getPreferredDeliverySpeed() {
        return _preferredDeliverySpeed;
    }

    public void setPreferredDeliverySpeed(Double preferredDeliverySpeed) {
        _preferredDeliverySpeed = preferredDeliverySpeed;
    }

    public Integer getPreferredAudioCaptioning() {
        return _preferredAudioCaptioning;
    }

    public void setPreferredAudioCaptioning(Integer preferredAudioCaptioning) {
        _preferredAudioCaptioning = preferredAudioCaptioning;
    }

    public BaseModel<?> getLFUserRemoteModel() {
        return _lfUserRemoteModel;
    }

    public void setLFUserRemoteModel(BaseModel<?> lfUserRemoteModel) {
        _lfUserRemoteModel = lfUserRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFUserLocalServiceUtil.addLFUser(this);
        } else {
            LFUserLocalServiceUtil.updateLFUser(this);
        }
    }

    @Override
    public LFUser toEscapedModel() {
        return (LFUser) Proxy.newProxyInstance(LFUser.class.getClassLoader(),
            new Class[] { LFUser.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFUserClp clone = new LFUserClp();

        clone.setLfid(getLfid());
        clone.setId(getId());
        clone.setName(getName());
        clone.setPreferredAudioLevel(getPreferredAudioLevel());
        clone.setPreferredLanguage(getPreferredLanguage());
        clone.setPreferredDeliverySpeed(getPreferredDeliverySpeed());
        clone.setPreferredAudioCaptioning(getPreferredAudioCaptioning());

        return clone;
    }

    public int compareTo(LFUser lfUser) {
        long primaryKey = lfUser.getPrimaryKey();

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

        LFUserClp lfUser = null;

        try {
            lfUser = (LFUserClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfUser.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{lfid=");
        sb.append(getLfid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", preferredAudioLevel=");
        sb.append(getPreferredAudioLevel());
        sb.append(", preferredLanguage=");
        sb.append(getPreferredLanguage());
        sb.append(", preferredDeliverySpeed=");
        sb.append(getPreferredDeliverySpeed());
        sb.append(", preferredAudioCaptioning=");
        sb.append(getPreferredAudioCaptioning());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>lfid</column-name><column-value><![CDATA[");
        sb.append(getLfid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredAudioLevel</column-name><column-value><![CDATA[");
        sb.append(getPreferredAudioLevel());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredLanguage</column-name><column-value><![CDATA[");
        sb.append(getPreferredLanguage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredDeliverySpeed</column-name><column-value><![CDATA[");
        sb.append(getPreferredDeliverySpeed());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>preferredAudioCaptioning</column-name><column-value><![CDATA[");
        sb.append(getPreferredAudioCaptioning());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

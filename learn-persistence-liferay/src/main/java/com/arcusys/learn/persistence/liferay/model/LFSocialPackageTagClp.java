package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFSocialPackageTagClp extends BaseModelImpl<LFSocialPackageTag>
    implements LFSocialPackageTag {
    private long _id;
    private Integer _socialPackageID;
    private String _name;
    private BaseModel<?> _lfSocialPackageTagRemoteModel;

    public LFSocialPackageTagClp() {
    }

    public Class<?> getModelClass() {
        return LFSocialPackageTag.class;
    }

    public String getModelClassName() {
        return LFSocialPackageTag.class.getName();
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
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    public void setSocialPackageID(Integer socialPackageID) {
        _socialPackageID = socialPackageID;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public BaseModel<?> getLFSocialPackageTagRemoteModel() {
        return _lfSocialPackageTagRemoteModel;
    }

    public void setLFSocialPackageTagRemoteModel(
        BaseModel<?> lfSocialPackageTagRemoteModel) {
        _lfSocialPackageTagRemoteModel = lfSocialPackageTagRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSocialPackageTagLocalServiceUtil.addLFSocialPackageTag(this);
        } else {
            LFSocialPackageTagLocalServiceUtil.updateLFSocialPackageTag(this);
        }
    }

    @Override
    public LFSocialPackageTag toEscapedModel() {
        return (LFSocialPackageTag) Proxy.newProxyInstance(LFSocialPackageTag.class.getClassLoader(),
            new Class[] { LFSocialPackageTag.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSocialPackageTagClp clone = new LFSocialPackageTagClp();

        clone.setId(getId());
        clone.setSocialPackageID(getSocialPackageID());
        clone.setName(getName());

        return clone;
    }

    public int compareTo(LFSocialPackageTag lfSocialPackageTag) {
        long primaryKey = lfSocialPackageTag.getPrimaryKey();

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

        LFSocialPackageTagClp lfSocialPackageTag = null;

        try {
            lfSocialPackageTag = (LFSocialPackageTagClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSocialPackageTag.getPrimaryKey();

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
        sb.append(", socialPackageID=");
        sb.append(getSocialPackageID());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialPackageID</column-name><column-value><![CDATA[");
        sb.append(getSocialPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

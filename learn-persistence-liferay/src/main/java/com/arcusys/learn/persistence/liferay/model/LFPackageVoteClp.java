package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFPackageVoteLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFPackageVoteClp extends BaseModelImpl<LFPackageVote>
    implements LFPackageVote {
    private long _id;
    private Integer _userID;
    private Integer _socialPackageID;
    private Integer _value;
    private BaseModel<?> _lfPackageVoteRemoteModel;

    public LFPackageVoteClp() {
    }

    public Class<?> getModelClass() {
        return LFPackageVote.class;
    }

    public String getModelClassName() {
        return LFPackageVote.class.getName();
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
        attributes.put("userID", getUserID());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("value", getValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        Integer value = (Integer) attributes.get("value");

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

    public Integer getUserID() {
        return _userID;
    }

    public void setUserID(Integer userID) {
        _userID = userID;
    }

    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    public void setSocialPackageID(Integer socialPackageID) {
        _socialPackageID = socialPackageID;
    }

    public Integer getValue() {
        return _value;
    }

    public void setValue(Integer value) {
        _value = value;
    }

    public BaseModel<?> getLFPackageVoteRemoteModel() {
        return _lfPackageVoteRemoteModel;
    }

    public void setLFPackageVoteRemoteModel(
        BaseModel<?> lfPackageVoteRemoteModel) {
        _lfPackageVoteRemoteModel = lfPackageVoteRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFPackageVoteLocalServiceUtil.addLFPackageVote(this);
        } else {
            LFPackageVoteLocalServiceUtil.updateLFPackageVote(this);
        }
    }

    @Override
    public LFPackageVote toEscapedModel() {
        return (LFPackageVote) Proxy.newProxyInstance(LFPackageVote.class.getClassLoader(),
            new Class[] { LFPackageVote.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFPackageVoteClp clone = new LFPackageVoteClp();

        clone.setId(getId());
        clone.setUserID(getUserID());
        clone.setSocialPackageID(getSocialPackageID());
        clone.setValue(getValue());

        return clone;
    }

    public int compareTo(LFPackageVote lfPackageVote) {
        long primaryKey = lfPackageVote.getPrimaryKey();

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

        LFPackageVoteClp lfPackageVote = null;

        try {
            lfPackageVote = (LFPackageVoteClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfPackageVote.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", socialPackageID=");
        sb.append(getSocialPackageID());
        sb.append(", value=");
        sb.append(getValue());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFPackageVote");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>socialPackageID</column-name><column-value><![CDATA[");
        sb.append(getSocialPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>value</column-name><column-value><![CDATA[");
        sb.append(getValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

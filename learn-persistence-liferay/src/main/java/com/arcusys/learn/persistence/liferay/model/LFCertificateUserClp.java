package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFCertificateUserClp extends BaseModelImpl<LFCertificateUser>
    implements LFCertificateUser {
    private long _id;
    private Integer _certificateID;
    private Integer _userID;
    private BaseModel<?> _lfCertificateUserRemoteModel;

    public LFCertificateUserClp() {
    }

    public Class<?> getModelClass() {
        return LFCertificateUser.class;
    }

    public String getModelClassName() {
        return LFCertificateUser.class.getName();
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
        attributes.put("certificateID", getCertificateID());
        attributes.put("userID", getUserID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer userID = (Integer) attributes.get("userID");

        if (userID != null) {
            setUserID(userID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        _certificateID = certificateID;
    }

    public Integer getUserID() {
        return _userID;
    }

    public void setUserID(Integer userID) {
        _userID = userID;
    }

    public BaseModel<?> getLFCertificateUserRemoteModel() {
        return _lfCertificateUserRemoteModel;
    }

    public void setLFCertificateUserRemoteModel(
        BaseModel<?> lfCertificateUserRemoteModel) {
        _lfCertificateUserRemoteModel = lfCertificateUserRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateUserLocalServiceUtil.addLFCertificateUser(this);
        } else {
            LFCertificateUserLocalServiceUtil.updateLFCertificateUser(this);
        }
    }

    @Override
    public LFCertificateUser toEscapedModel() {
        return (LFCertificateUser) Proxy.newProxyInstance(LFCertificateUser.class.getClassLoader(),
            new Class[] { LFCertificateUser.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateUserClp clone = new LFCertificateUserClp();

        clone.setId(getId());
        clone.setCertificateID(getCertificateID());
        clone.setUserID(getUserID());

        return clone;
    }

    public int compareTo(LFCertificateUser lfCertificateUser) {
        long primaryKey = lfCertificateUser.getPrimaryKey();

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

        LFCertificateUserClp lfCertificateUser = null;

        try {
            lfCertificateUser = (LFCertificateUserClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfCertificateUser.getPrimaryKey();

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
        sb.append(", certificateID=");
        sb.append(getCertificateID());
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFCertificateUser");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userID</column-name><column-value><![CDATA[");
        sb.append(getUserID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

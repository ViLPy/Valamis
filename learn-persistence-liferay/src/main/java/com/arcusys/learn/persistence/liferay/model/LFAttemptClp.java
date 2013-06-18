package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFAttemptClp extends BaseModelImpl<LFAttempt> implements LFAttempt {
    private long _id;
    private Integer _userID;
    private Integer _packageID;
    private String _organizationID;
    private Boolean _isComplete;
    private BaseModel<?> _lfAttemptRemoteModel;

    public LFAttemptClp() {
    }

    public Class<?> getModelClass() {
        return LFAttempt.class;
    }

    public String getModelClassName() {
        return LFAttempt.class.getName();
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
        attributes.put("packageID", getPackageID());
        attributes.put("organizationID", getOrganizationID());
        attributes.put("isComplete", getIsComplete());

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

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String organizationID = (String) attributes.get("organizationID");

        if (organizationID != null) {
            setOrganizationID(organizationID);
        }

        Boolean isComplete = (Boolean) attributes.get("isComplete");

        if (isComplete != null) {
            setIsComplete(isComplete);
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

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getOrganizationID() {
        return _organizationID;
    }

    public void setOrganizationID(String organizationID) {
        _organizationID = organizationID;
    }

    public Boolean getIsComplete() {
        return _isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        _isComplete = isComplete;
    }

    public BaseModel<?> getLFAttemptRemoteModel() {
        return _lfAttemptRemoteModel;
    }

    public void setLFAttemptRemoteModel(BaseModel<?> lfAttemptRemoteModel) {
        _lfAttemptRemoteModel = lfAttemptRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFAttemptLocalServiceUtil.addLFAttempt(this);
        } else {
            LFAttemptLocalServiceUtil.updateLFAttempt(this);
        }
    }

    @Override
    public LFAttempt toEscapedModel() {
        return (LFAttempt) Proxy.newProxyInstance(LFAttempt.class.getClassLoader(),
            new Class[] { LFAttempt.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFAttemptClp clone = new LFAttemptClp();

        clone.setId(getId());
        clone.setUserID(getUserID());
        clone.setPackageID(getPackageID());
        clone.setOrganizationID(getOrganizationID());
        clone.setIsComplete(getIsComplete());

        return clone;
    }

    public int compareTo(LFAttempt lfAttempt) {
        long primaryKey = lfAttempt.getPrimaryKey();

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

        LFAttemptClp lfAttempt = null;

        try {
            lfAttempt = (LFAttemptClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfAttempt.getPrimaryKey();

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
        sb.append(", userID=");
        sb.append(getUserID());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", organizationID=");
        sb.append(getOrganizationID());
        sb.append(", isComplete=");
        sb.append(getIsComplete());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFAttempt");
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
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organizationID</column-name><column-value><![CDATA[");
        sb.append(getOrganizationID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isComplete</column-name><column-value><![CDATA[");
        sb.append(getIsComplete());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

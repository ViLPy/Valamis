package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class LFSocialPackageClp extends BaseModelImpl<LFSocialPackage>
    implements LFSocialPackage {
    private long _id;
    private Integer _packageID;
    private String _aboutPackage;
    private Date _publishDate;
    private Integer _authorID;
    private BaseModel<?> _lfSocialPackageRemoteModel;

    public LFSocialPackageClp() {
    }

    public Class<?> getModelClass() {
        return LFSocialPackage.class;
    }

    public String getModelClassName() {
        return LFSocialPackage.class.getName();
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
        attributes.put("packageID", getPackageID());
        attributes.put("aboutPackage", getAboutPackage());
        attributes.put("publishDate", getPublishDate());
        attributes.put("authorID", getAuthorID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String aboutPackage = (String) attributes.get("aboutPackage");

        if (aboutPackage != null) {
            setAboutPackage(aboutPackage);
        }

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }

        Integer authorID = (Integer) attributes.get("authorID");

        if (authorID != null) {
            setAuthorID(authorID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getAboutPackage() {
        return _aboutPackage;
    }

    public void setAboutPackage(String aboutPackage) {
        _aboutPackage = aboutPackage;
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;
    }

    public Integer getAuthorID() {
        return _authorID;
    }

    public void setAuthorID(Integer authorID) {
        _authorID = authorID;
    }

    public BaseModel<?> getLFSocialPackageRemoteModel() {
        return _lfSocialPackageRemoteModel;
    }

    public void setLFSocialPackageRemoteModel(
        BaseModel<?> lfSocialPackageRemoteModel) {
        _lfSocialPackageRemoteModel = lfSocialPackageRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSocialPackageLocalServiceUtil.addLFSocialPackage(this);
        } else {
            LFSocialPackageLocalServiceUtil.updateLFSocialPackage(this);
        }
    }

    @Override
    public LFSocialPackage toEscapedModel() {
        return (LFSocialPackage) Proxy.newProxyInstance(LFSocialPackage.class.getClassLoader(),
            new Class[] { LFSocialPackage.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSocialPackageClp clone = new LFSocialPackageClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setAboutPackage(getAboutPackage());
        clone.setPublishDate(getPublishDate());
        clone.setAuthorID(getAuthorID());

        return clone;
    }

    public int compareTo(LFSocialPackage lfSocialPackage) {
        long primaryKey = lfSocialPackage.getPrimaryKey();

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

        LFSocialPackageClp lfSocialPackage = null;

        try {
            lfSocialPackage = (LFSocialPackageClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSocialPackage.getPrimaryKey();

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
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", aboutPackage=");
        sb.append(getAboutPackage());
        sb.append(", publishDate=");
        sb.append(getPublishDate());
        sb.append(", authorID=");
        sb.append(getAuthorID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSocialPackage");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>aboutPackage</column-name><column-value><![CDATA[");
        sb.append(getAboutPackage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>publishDate</column-name><column-value><![CDATA[");
        sb.append(getPublishDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorID</column-name><column-value><![CDATA[");
        sb.append(getAuthorID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

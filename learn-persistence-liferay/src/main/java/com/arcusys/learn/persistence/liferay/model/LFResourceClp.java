package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFResourceClp extends BaseModelImpl<LFResource>
    implements LFResource {
    private long _id;
    private Integer _packageID;
    private String _scormType;
    private String _resourceID;
    private String _href;
    private String _base;
    private BaseModel<?> _lfResourceRemoteModel;

    public LFResourceClp() {
    }

    public Class<?> getModelClass() {
        return LFResource.class;
    }

    public String getModelClassName() {
        return LFResource.class.getName();
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
        attributes.put("scormType", getScormType());
        attributes.put("resourceID", getResourceID());
        attributes.put("href", getHref());
        attributes.put("base", getBase());

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

        String scormType = (String) attributes.get("scormType");

        if (scormType != null) {
            setScormType(scormType);
        }

        String resourceID = (String) attributes.get("resourceID");

        if (resourceID != null) {
            setResourceID(resourceID);
        }

        String href = (String) attributes.get("href");

        if (href != null) {
            setHref(href);
        }

        String base = (String) attributes.get("base");

        if (base != null) {
            setBase(base);
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

    public String getScormType() {
        return _scormType;
    }

    public void setScormType(String scormType) {
        _scormType = scormType;
    }

    public String getResourceID() {
        return _resourceID;
    }

    public void setResourceID(String resourceID) {
        _resourceID = resourceID;
    }

    public String getHref() {
        return _href;
    }

    public void setHref(String href) {
        _href = href;
    }

    public String getBase() {
        return _base;
    }

    public void setBase(String base) {
        _base = base;
    }

    public BaseModel<?> getLFResourceRemoteModel() {
        return _lfResourceRemoteModel;
    }

    public void setLFResourceRemoteModel(BaseModel<?> lfResourceRemoteModel) {
        _lfResourceRemoteModel = lfResourceRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFResourceLocalServiceUtil.addLFResource(this);
        } else {
            LFResourceLocalServiceUtil.updateLFResource(this);
        }
    }

    @Override
    public LFResource toEscapedModel() {
        return (LFResource) Proxy.newProxyInstance(LFResource.class.getClassLoader(),
            new Class[] { LFResource.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFResourceClp clone = new LFResourceClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setScormType(getScormType());
        clone.setResourceID(getResourceID());
        clone.setHref(getHref());
        clone.setBase(getBase());

        return clone;
    }

    public int compareTo(LFResource lfResource) {
        long primaryKey = lfResource.getPrimaryKey();

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

        LFResourceClp lfResource = null;

        try {
            lfResource = (LFResourceClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfResource.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", scormType=");
        sb.append(getScormType());
        sb.append(", resourceID=");
        sb.append(getResourceID());
        sb.append(", href=");
        sb.append(getHref());
        sb.append(", base=");
        sb.append(getBase());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFResource");
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
            "<column><column-name>scormType</column-name><column-value><![CDATA[");
        sb.append(getScormType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourceID</column-name><column-value><![CDATA[");
        sb.append(getResourceID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>href</column-name><column-value><![CDATA[");
        sb.append(getHref());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>base</column-name><column-value><![CDATA[");
        sb.append(getBase());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

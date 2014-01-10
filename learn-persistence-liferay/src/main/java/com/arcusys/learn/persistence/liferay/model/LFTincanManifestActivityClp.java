package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActivityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanManifestActivityClp extends BaseModelImpl<LFTincanManifestActivity>
    implements LFTincanManifestActivity {
    private long _id;
    private String _tincanID;
    private Long _packageID;
    private String _activityType;
    private String _name;
    private String _description;
    private String _launch;
    private String _resource;
    private BaseModel<?> _lfTincanManifestActivityRemoteModel;

    public LFTincanManifestActivityClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanManifestActivity.class;
    }

    public String getModelClassName() {
        return LFTincanManifestActivity.class.getName();
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
        attributes.put("tincanID", getTincanID());
        attributes.put("packageID", getPackageID());
        attributes.put("activityType", getActivityType());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("launch", getLaunch());
        attributes.put("resource", getResource());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        Long packageID = (Long) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityType = (String) attributes.get("activityType");

        if (activityType != null) {
            setActivityType(activityType);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String launch = (String) attributes.get("launch");

        if (launch != null) {
            setLaunch(launch);
        }

        String resource = (String) attributes.get("resource");

        if (resource != null) {
            setResource(resource);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getTincanID() {
        return _tincanID;
    }

    public void setTincanID(String tincanID) {
        _tincanID = tincanID;
    }

    public Long getPackageID() {
        return _packageID;
    }

    public void setPackageID(Long packageID) {
        _packageID = packageID;
    }

    public String getActivityType() {
        return _activityType;
    }

    public void setActivityType(String activityType) {
        _activityType = activityType;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getLaunch() {
        return _launch;
    }

    public void setLaunch(String launch) {
        _launch = launch;
    }

    public String getResource() {
        return _resource;
    }

    public void setResource(String resource) {
        _resource = resource;
    }

    public BaseModel<?> getLFTincanManifestActivityRemoteModel() {
        return _lfTincanManifestActivityRemoteModel;
    }

    public void setLFTincanManifestActivityRemoteModel(
        BaseModel<?> lfTincanManifestActivityRemoteModel) {
        _lfTincanManifestActivityRemoteModel = lfTincanManifestActivityRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanManifestActivityLocalServiceUtil.addLFTincanManifestActivity(this);
        } else {
            LFTincanManifestActivityLocalServiceUtil.updateLFTincanManifestActivity(this);
        }
    }

    @Override
    public LFTincanManifestActivity toEscapedModel() {
        return (LFTincanManifestActivity) Proxy.newProxyInstance(LFTincanManifestActivity.class.getClassLoader(),
            new Class[] { LFTincanManifestActivity.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanManifestActivityClp clone = new LFTincanManifestActivityClp();

        clone.setId(getId());
        clone.setTincanID(getTincanID());
        clone.setPackageID(getPackageID());
        clone.setActivityType(getActivityType());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setLaunch(getLaunch());
        clone.setResource(getResource());

        return clone;
    }

    public int compareTo(LFTincanManifestActivity lfTincanManifestActivity) {
        long primaryKey = lfTincanManifestActivity.getPrimaryKey();

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

        LFTincanManifestActivityClp lfTincanManifestActivity = null;

        try {
            lfTincanManifestActivity = (LFTincanManifestActivityClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanManifestActivity.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", tincanID=");
        sb.append(getTincanID());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", activityType=");
        sb.append(getActivityType());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", launch=");
        sb.append(getLaunch());
        sb.append(", resource=");
        sb.append(getResource());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanManifestActivity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tincanID</column-name><column-value><![CDATA[");
        sb.append(getTincanID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityType</column-name><column-value><![CDATA[");
        sb.append(getActivityType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>launch</column-name><column-value><![CDATA[");
        sb.append(getLaunch());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resource</column-name><column-value><![CDATA[");
        sb.append(getResource());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

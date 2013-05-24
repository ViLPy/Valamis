package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFActivityDataMapClp extends BaseModelImpl<LFActivityDataMap>
    implements LFActivityDataMap {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _targetId;
    private boolean _readSharedData;
    private boolean _writeSharedData;
    private BaseModel<?> _lfActivityDataMapRemoteModel;

    public LFActivityDataMapClp() {
    }

    public Class<?> getModelClass() {
        return LFActivityDataMap.class;
    }

    public String getModelClassName() {
        return LFActivityDataMap.class.getName();
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
        attributes.put("activityID", getActivityID());
        attributes.put("targetId", getTargetId());
        attributes.put("readSharedData", getReadSharedData());
        attributes.put("writeSharedData", getWriteSharedData());

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

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        String targetId = (String) attributes.get("targetId");

        if (targetId != null) {
            setTargetId(targetId);
        }

        Boolean readSharedData = (Boolean) attributes.get("readSharedData");

        if (readSharedData != null) {
            setReadSharedData(readSharedData);
        }

        Boolean writeSharedData = (Boolean) attributes.get("writeSharedData");

        if (writeSharedData != null) {
            setWriteSharedData(writeSharedData);
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

    public String getActivityID() {
        return _activityID;
    }

    public void setActivityID(String activityID) {
        _activityID = activityID;
    }

    public String getTargetId() {
        return _targetId;
    }

    public void setTargetId(String targetId) {
        _targetId = targetId;
    }

    public boolean getReadSharedData() {
        return _readSharedData;
    }

    public boolean isReadSharedData() {
        return _readSharedData;
    }

    public void setReadSharedData(boolean readSharedData) {
        _readSharedData = readSharedData;
    }

    public boolean getWriteSharedData() {
        return _writeSharedData;
    }

    public boolean isWriteSharedData() {
        return _writeSharedData;
    }

    public void setWriteSharedData(boolean writeSharedData) {
        _writeSharedData = writeSharedData;
    }

    public BaseModel<?> getLFActivityDataMapRemoteModel() {
        return _lfActivityDataMapRemoteModel;
    }

    public void setLFActivityDataMapRemoteModel(
        BaseModel<?> lfActivityDataMapRemoteModel) {
        _lfActivityDataMapRemoteModel = lfActivityDataMapRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityDataMapLocalServiceUtil.addLFActivityDataMap(this);
        } else {
            LFActivityDataMapLocalServiceUtil.updateLFActivityDataMap(this);
        }
    }

    @Override
    public LFActivityDataMap toEscapedModel() {
        return (LFActivityDataMap) Proxy.newProxyInstance(LFActivityDataMap.class.getClassLoader(),
            new Class[] { LFActivityDataMap.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityDataMapClp clone = new LFActivityDataMapClp();

        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setActivityID(getActivityID());
        clone.setTargetId(getTargetId());
        clone.setReadSharedData(getReadSharedData());
        clone.setWriteSharedData(getWriteSharedData());

        return clone;
    }

    public int compareTo(LFActivityDataMap lfActivityDataMap) {
        long primaryKey = lfActivityDataMap.getPrimaryKey();

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

        LFActivityDataMapClp lfActivityDataMap = null;

        try {
            lfActivityDataMap = (LFActivityDataMapClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfActivityDataMap.getPrimaryKey();

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
        sb.append(", activityID=");
        sb.append(getActivityID());
        sb.append(", targetId=");
        sb.append(getTargetId());
        sb.append(", readSharedData=");
        sb.append(getReadSharedData());
        sb.append(", writeSharedData=");
        sb.append(getWriteSharedData());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFActivityDataMap");
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
            "<column><column-name>activityID</column-name><column-value><![CDATA[");
        sb.append(getActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>targetId</column-name><column-value><![CDATA[");
        sb.append(getTargetId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>readSharedData</column-name><column-value><![CDATA[");
        sb.append(getReadSharedData());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>writeSharedData</column-name><column-value><![CDATA[");
        sb.append(getWriteSharedData());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

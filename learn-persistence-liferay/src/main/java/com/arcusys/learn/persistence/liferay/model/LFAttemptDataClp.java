package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFAttemptDataClp extends BaseModelImpl<LFAttemptData>
    implements LFAttemptData {
    private long _id;
    private String _dataKey;
    private String _dataValue;
    private Integer _attemptID;
    private String _activityID;
    private BaseModel<?> _lfAttemptDataRemoteModel;

    public LFAttemptDataClp() {
    }

    public Class<?> getModelClass() {
        return LFAttemptData.class;
    }

    public String getModelClassName() {
        return LFAttemptData.class.getName();
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
        attributes.put("attemptID", getAttemptID());
        attributes.put("activityID", getActivityID());

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

        Integer attemptID = (Integer) attributes.get("attemptID");

        if (attemptID != null) {
            setAttemptID(attemptID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
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

    public Integer getAttemptID() {
        return _attemptID;
    }

    public void setAttemptID(Integer attemptID) {
        _attemptID = attemptID;
    }

    public String getActivityID() {
        return _activityID;
    }

    public void setActivityID(String activityID) {
        _activityID = activityID;
    }

    public BaseModel<?> getLFAttemptDataRemoteModel() {
        return _lfAttemptDataRemoteModel;
    }

    public void setLFAttemptDataRemoteModel(
        BaseModel<?> lfAttemptDataRemoteModel) {
        _lfAttemptDataRemoteModel = lfAttemptDataRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFAttemptDataLocalServiceUtil.addLFAttemptData(this);
        } else {
            LFAttemptDataLocalServiceUtil.updateLFAttemptData(this);
        }
    }

    @Override
    public LFAttemptData toEscapedModel() {
        return (LFAttemptData) Proxy.newProxyInstance(LFAttemptData.class.getClassLoader(),
            new Class[] { LFAttemptData.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFAttemptDataClp clone = new LFAttemptDataClp();

        clone.setId(getId());
        clone.setDataKey(getDataKey());
        clone.setDataValue(getDataValue());
        clone.setAttemptID(getAttemptID());
        clone.setActivityID(getActivityID());

        return clone;
    }

    public int compareTo(LFAttemptData lfAttemptData) {
        long primaryKey = lfAttemptData.getPrimaryKey();

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

        LFAttemptDataClp lfAttemptData = null;

        try {
            lfAttemptData = (LFAttemptDataClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfAttemptData.getPrimaryKey();

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
        sb.append(", dataKey=");
        sb.append(getDataKey());
        sb.append(", dataValue=");
        sb.append(getDataValue());
        sb.append(", attemptID=");
        sb.append(getAttemptID());
        sb.append(", activityID=");
        sb.append(getActivityID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFAttemptData");
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
        sb.append(
            "<column><column-name>attemptID</column-name><column-value><![CDATA[");
        sb.append(getAttemptID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityID</column-name><column-value><![CDATA[");
        sb.append(getActivityID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

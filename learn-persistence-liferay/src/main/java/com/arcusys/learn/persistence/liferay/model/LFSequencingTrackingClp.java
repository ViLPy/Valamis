package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFSequencingTrackingClp extends BaseModelImpl<LFSequencingTracking>
    implements LFSequencingTracking {
    private long _id;
    private Integer _sequencingID;
    private boolean _completionSetByContent;
    private boolean _objectiveSetByContent;
    private BaseModel<?> _lfSequencingTrackingRemoteModel;

    public LFSequencingTrackingClp() {
    }

    public Class<?> getModelClass() {
        return LFSequencingTracking.class;
    }

    public String getModelClassName() {
        return LFSequencingTracking.class.getName();
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
        attributes.put("sequencingID", getSequencingID());
        attributes.put("completionSetByContent", getCompletionSetByContent());
        attributes.put("objectiveSetByContent", getObjectiveSetByContent());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean completionSetByContent = (Boolean) attributes.get(
                "completionSetByContent");

        if (completionSetByContent != null) {
            setCompletionSetByContent(completionSetByContent);
        }

        Boolean objectiveSetByContent = (Boolean) attributes.get(
                "objectiveSetByContent");

        if (objectiveSetByContent != null) {
            setObjectiveSetByContent(objectiveSetByContent);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;
    }

    public boolean getCompletionSetByContent() {
        return _completionSetByContent;
    }

    public boolean isCompletionSetByContent() {
        return _completionSetByContent;
    }

    public void setCompletionSetByContent(boolean completionSetByContent) {
        _completionSetByContent = completionSetByContent;
    }

    public boolean getObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    public boolean isObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    public void setObjectiveSetByContent(boolean objectiveSetByContent) {
        _objectiveSetByContent = objectiveSetByContent;
    }

    public BaseModel<?> getLFSequencingTrackingRemoteModel() {
        return _lfSequencingTrackingRemoteModel;
    }

    public void setLFSequencingTrackingRemoteModel(
        BaseModel<?> lfSequencingTrackingRemoteModel) {
        _lfSequencingTrackingRemoteModel = lfSequencingTrackingRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSequencingTrackingLocalServiceUtil.addLFSequencingTracking(this);
        } else {
            LFSequencingTrackingLocalServiceUtil.updateLFSequencingTracking(this);
        }
    }

    @Override
    public LFSequencingTracking toEscapedModel() {
        return (LFSequencingTracking) Proxy.newProxyInstance(LFSequencingTracking.class.getClassLoader(),
            new Class[] { LFSequencingTracking.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSequencingTrackingClp clone = new LFSequencingTrackingClp();

        clone.setId(getId());
        clone.setSequencingID(getSequencingID());
        clone.setCompletionSetByContent(getCompletionSetByContent());
        clone.setObjectiveSetByContent(getObjectiveSetByContent());

        return clone;
    }

    public int compareTo(LFSequencingTracking lfSequencingTracking) {
        long primaryKey = lfSequencingTracking.getPrimaryKey();

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

        LFSequencingTrackingClp lfSequencingTracking = null;

        try {
            lfSequencingTracking = (LFSequencingTrackingClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfSequencingTracking.getPrimaryKey();

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
        sb.append(", sequencingID=");
        sb.append(getSequencingID());
        sb.append(", completionSetByContent=");
        sb.append(getCompletionSetByContent());
        sb.append(", objectiveSetByContent=");
        sb.append(getObjectiveSetByContent());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFSequencingTracking");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequencingID</column-name><column-value><![CDATA[");
        sb.append(getSequencingID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>completionSetByContent</column-name><column-value><![CDATA[");
        sb.append(getCompletionSetByContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectiveSetByContent</column-name><column-value><![CDATA[");
        sb.append(getObjectiveSetByContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

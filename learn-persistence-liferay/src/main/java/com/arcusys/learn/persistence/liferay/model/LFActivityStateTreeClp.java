package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFActivityStateTreeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFActivityStateTreeClp extends BaseModelImpl<LFActivityStateTree>
    implements LFActivityStateTree {
    private long _id;
    private String _currentActivityID;
    private String _suspendedActivityID;
    private Integer _attemptID;
    private BaseModel<?> _lfActivityStateTreeRemoteModel;

    public LFActivityStateTreeClp() {
    }

    public Class<?> getModelClass() {
        return LFActivityStateTree.class;
    }

    public String getModelClassName() {
        return LFActivityStateTree.class.getName();
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
        attributes.put("currentActivityID", getCurrentActivityID());
        attributes.put("suspendedActivityID", getSuspendedActivityID());
        attributes.put("attemptID", getAttemptID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String currentActivityID = (String) attributes.get("currentActivityID");

        if (currentActivityID != null) {
            setCurrentActivityID(currentActivityID);
        }

        String suspendedActivityID = (String) attributes.get(
                "suspendedActivityID");

        if (suspendedActivityID != null) {
            setSuspendedActivityID(suspendedActivityID);
        }

        Integer attemptID = (Integer) attributes.get("attemptID");

        if (attemptID != null) {
            setAttemptID(attemptID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getCurrentActivityID() {
        return _currentActivityID;
    }

    public void setCurrentActivityID(String currentActivityID) {
        _currentActivityID = currentActivityID;
    }

    public String getSuspendedActivityID() {
        return _suspendedActivityID;
    }

    public void setSuspendedActivityID(String suspendedActivityID) {
        _suspendedActivityID = suspendedActivityID;
    }

    public Integer getAttemptID() {
        return _attemptID;
    }

    public void setAttemptID(Integer attemptID) {
        _attemptID = attemptID;
    }

    public BaseModel<?> getLFActivityStateTreeRemoteModel() {
        return _lfActivityStateTreeRemoteModel;
    }

    public void setLFActivityStateTreeRemoteModel(
        BaseModel<?> lfActivityStateTreeRemoteModel) {
        _lfActivityStateTreeRemoteModel = lfActivityStateTreeRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityStateTreeLocalServiceUtil.addLFActivityStateTree(this);
        } else {
            LFActivityStateTreeLocalServiceUtil.updateLFActivityStateTree(this);
        }
    }

    @Override
    public LFActivityStateTree toEscapedModel() {
        return (LFActivityStateTree) Proxy.newProxyInstance(LFActivityStateTree.class.getClassLoader(),
            new Class[] { LFActivityStateTree.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityStateTreeClp clone = new LFActivityStateTreeClp();

        clone.setId(getId());
        clone.setCurrentActivityID(getCurrentActivityID());
        clone.setSuspendedActivityID(getSuspendedActivityID());
        clone.setAttemptID(getAttemptID());

        return clone;
    }

    public int compareTo(LFActivityStateTree lfActivityStateTree) {
        long primaryKey = lfActivityStateTree.getPrimaryKey();

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

        LFActivityStateTreeClp lfActivityStateTree = null;

        try {
            lfActivityStateTree = (LFActivityStateTreeClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfActivityStateTree.getPrimaryKey();

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
        sb.append(", currentActivityID=");
        sb.append(getCurrentActivityID());
        sb.append(", suspendedActivityID=");
        sb.append(getSuspendedActivityID());
        sb.append(", attemptID=");
        sb.append(getAttemptID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFActivityStateTree");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currentActivityID</column-name><column-value><![CDATA[");
        sb.append(getCurrentActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>suspendedActivityID</column-name><column-value><![CDATA[");
        sb.append(getSuspendedActivityID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attemptID</column-name><column-value><![CDATA[");
        sb.append(getAttemptID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

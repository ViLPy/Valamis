package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsStateClp extends BaseModelImpl<LFTincanLrsState>
    implements LFTincanLrsState {
    private long _id;
    private String _stateId;
    private String _documentId;
    private String _activityId;
    private String _profileId;
    private String _registration;
    private Integer _agentId;
    private BaseModel<?> _lfTincanLrsStateRemoteModel;

    public LFTincanLrsStateClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsState.class;
    }

    public String getModelClassName() {
        return LFTincanLrsState.class.getName();
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
        attributes.put("stateId", getStateId());
        attributes.put("documentId", getDocumentId());
        attributes.put("activityId", getActivityId());
        attributes.put("profileId", getProfileId());
        attributes.put("registration", getRegistration());
        attributes.put("agentId", getAgentId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String stateId = (String) attributes.get("stateId");

        if (stateId != null) {
            setStateId(stateId);
        }

        String documentId = (String) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        String activityId = (String) attributes.get("activityId");

        if (activityId != null) {
            setActivityId(activityId);
        }

        String profileId = (String) attributes.get("profileId");

        if (profileId != null) {
            setProfileId(profileId);
        }

        String registration = (String) attributes.get("registration");

        if (registration != null) {
            setRegistration(registration);
        }

        Integer agentId = (Integer) attributes.get("agentId");

        if (agentId != null) {
            setAgentId(agentId);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getStateId() {
        return _stateId;
    }

    public void setStateId(String stateId) {
        _stateId = stateId;
    }

    public String getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(String documentId) {
        _documentId = documentId;
    }

    public String getActivityId() {
        return _activityId;
    }

    public void setActivityId(String activityId) {
        _activityId = activityId;
    }

    public String getProfileId() {
        return _profileId;
    }

    public void setProfileId(String profileId) {
        _profileId = profileId;
    }

    public String getRegistration() {
        return _registration;
    }

    public void setRegistration(String registration) {
        _registration = registration;
    }

    public Integer getAgentId() {
        return _agentId;
    }

    public void setAgentId(Integer agentId) {
        _agentId = agentId;
    }

    public BaseModel<?> getLFTincanLrsStateRemoteModel() {
        return _lfTincanLrsStateRemoteModel;
    }

    public void setLFTincanLrsStateRemoteModel(
        BaseModel<?> lfTincanLrsStateRemoteModel) {
        _lfTincanLrsStateRemoteModel = lfTincanLrsStateRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsStateLocalServiceUtil.addLFTincanLrsState(this);
        } else {
            LFTincanLrsStateLocalServiceUtil.updateLFTincanLrsState(this);
        }
    }

    @Override
    public LFTincanLrsState toEscapedModel() {
        return (LFTincanLrsState) Proxy.newProxyInstance(LFTincanLrsState.class.getClassLoader(),
            new Class[] { LFTincanLrsState.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsStateClp clone = new LFTincanLrsStateClp();

        clone.setId(getId());
        clone.setStateId(getStateId());
        clone.setDocumentId(getDocumentId());
        clone.setActivityId(getActivityId());
        clone.setProfileId(getProfileId());
        clone.setRegistration(getRegistration());
        clone.setAgentId(getAgentId());

        return clone;
    }

    public int compareTo(LFTincanLrsState lfTincanLrsState) {
        long primaryKey = lfTincanLrsState.getPrimaryKey();

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

        LFTincanLrsStateClp lfTincanLrsState = null;

        try {
            lfTincanLrsState = (LFTincanLrsStateClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsState.getPrimaryKey();

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
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", stateId=");
        sb.append(getStateId());
        sb.append(", documentId=");
        sb.append(getDocumentId());
        sb.append(", activityId=");
        sb.append(getActivityId());
        sb.append(", profileId=");
        sb.append(getProfileId());
        sb.append(", registration=");
        sb.append(getRegistration());
        sb.append(", agentId=");
        sb.append(getAgentId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsState");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>stateId</column-name><column-value><![CDATA[");
        sb.append(getStateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentId</column-name><column-value><![CDATA[");
        sb.append(getDocumentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activityId</column-name><column-value><![CDATA[");
        sb.append(getActivityId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>profileId</column-name><column-value><![CDATA[");
        sb.append(getProfileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registration</column-name><column-value><![CDATA[");
        sb.append(getRegistration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agentId</column-name><column-value><![CDATA[");
        sb.append(getAgentId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

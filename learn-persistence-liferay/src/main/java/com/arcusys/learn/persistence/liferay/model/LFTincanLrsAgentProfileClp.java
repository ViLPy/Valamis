package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsAgentProfileClp extends BaseModelImpl<LFTincanLrsAgentProfile>
    implements LFTincanLrsAgentProfile {
    private long _id;
    private Integer _documentId;
    private Integer _agentId;
    private String _profileId;
    private BaseModel<?> _lfTincanLrsAgentProfileRemoteModel;

    public LFTincanLrsAgentProfileClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsAgentProfile.class;
    }

    public String getModelClassName() {
        return LFTincanLrsAgentProfile.class.getName();
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
        attributes.put("documentId", getDocumentId());
        attributes.put("agentId", getAgentId());
        attributes.put("profileId", getProfileId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer documentId = (Integer) attributes.get("documentId");

        if (documentId != null) {
            setDocumentId(documentId);
        }

        Integer agentId = (Integer) attributes.get("agentId");

        if (agentId != null) {
            setAgentId(agentId);
        }

        String profileId = (String) attributes.get("profileId");

        if (profileId != null) {
            setProfileId(profileId);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(Integer documentId) {
        _documentId = documentId;
    }

    public Integer getAgentId() {
        return _agentId;
    }

    public void setAgentId(Integer agentId) {
        _agentId = agentId;
    }

    public String getProfileId() {
        return _profileId;
    }

    public void setProfileId(String profileId) {
        _profileId = profileId;
    }

    public BaseModel<?> getLFTincanLrsAgentProfileRemoteModel() {
        return _lfTincanLrsAgentProfileRemoteModel;
    }

    public void setLFTincanLrsAgentProfileRemoteModel(
        BaseModel<?> lfTincanLrsAgentProfileRemoteModel) {
        _lfTincanLrsAgentProfileRemoteModel = lfTincanLrsAgentProfileRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsAgentProfileLocalServiceUtil.addLFTincanLrsAgentProfile(this);
        } else {
            LFTincanLrsAgentProfileLocalServiceUtil.updateLFTincanLrsAgentProfile(this);
        }
    }

    @Override
    public LFTincanLrsAgentProfile toEscapedModel() {
        return (LFTincanLrsAgentProfile) Proxy.newProxyInstance(LFTincanLrsAgentProfile.class.getClassLoader(),
            new Class[] { LFTincanLrsAgentProfile.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsAgentProfileClp clone = new LFTincanLrsAgentProfileClp();

        clone.setId(getId());
        clone.setDocumentId(getDocumentId());
        clone.setAgentId(getAgentId());
        clone.setProfileId(getProfileId());

        return clone;
    }

    public int compareTo(LFTincanLrsAgentProfile lfTincanLrsAgentProfile) {
        long primaryKey = lfTincanLrsAgentProfile.getPrimaryKey();

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

        LFTincanLrsAgentProfileClp lfTincanLrsAgentProfile = null;

        try {
            lfTincanLrsAgentProfile = (LFTincanLrsAgentProfileClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsAgentProfile.getPrimaryKey();

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
        sb.append(", documentId=");
        sb.append(getDocumentId());
        sb.append(", agentId=");
        sb.append(getAgentId());
        sb.append(", profileId=");
        sb.append(getProfileId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsAgentProfile");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>documentId</column-name><column-value><![CDATA[");
        sb.append(getDocumentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>agentId</column-name><column-value><![CDATA[");
        sb.append(getAgentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>profileId</column-name><column-value><![CDATA[");
        sb.append(getProfileId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

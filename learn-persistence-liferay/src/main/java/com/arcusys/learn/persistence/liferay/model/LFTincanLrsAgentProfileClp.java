package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsAgentProfileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsAgentProfile.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsAgentProfile.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsAgentProfileRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsAgentProfileRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsAgentProfileRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getDocumentId() {
        return _documentId;
    }

    @Override
    public void setDocumentId(Integer documentId) {
        _documentId = documentId;

        if (_lfTincanLrsAgentProfileRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsAgentProfileRemoteModel.getClass();

                Method method = clazz.getMethod("setDocumentId", Integer.class);

                method.invoke(_lfTincanLrsAgentProfileRemoteModel, documentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getAgentId() {
        return _agentId;
    }

    @Override
    public void setAgentId(Integer agentId) {
        _agentId = agentId;

        if (_lfTincanLrsAgentProfileRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsAgentProfileRemoteModel.getClass();

                Method method = clazz.getMethod("setAgentId", Integer.class);

                method.invoke(_lfTincanLrsAgentProfileRemoteModel, agentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProfileId() {
        return _profileId;
    }

    @Override
    public void setProfileId(String profileId) {
        _profileId = profileId;

        if (_lfTincanLrsAgentProfileRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsAgentProfileRemoteModel.getClass();

                Method method = clazz.getMethod("setProfileId", String.class);

                method.invoke(_lfTincanLrsAgentProfileRemoteModel, profileId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsAgentProfileRemoteModel() {
        return _lfTincanLrsAgentProfileRemoteModel;
    }

    public void setLFTincanLrsAgentProfileRemoteModel(
        BaseModel<?> lfTincanLrsAgentProfileRemoteModel) {
        _lfTincanLrsAgentProfileRemoteModel = lfTincanLrsAgentProfileRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _lfTincanLrsAgentProfileRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_lfTincanLrsAgentProfileRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsAgentProfileLocalServiceUtil.addLFTincanLrsAgentProfile(this);
        } else {
            LFTincanLrsAgentProfileLocalServiceUtil.updateLFTincanLrsAgentProfile(this);
        }
    }

    @Override
    public LFTincanLrsAgentProfile toEscapedModel() {
        return (LFTincanLrsAgentProfile) ProxyUtil.newProxyInstance(LFTincanLrsAgentProfile.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsAgentProfileClp)) {
            return false;
        }

        LFTincanLrsAgentProfileClp lfTincanLrsAgentProfile = (LFTincanLrsAgentProfileClp) obj;

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

    @Override
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

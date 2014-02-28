package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil;

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


public class LFTincanLrsContextClp extends BaseModelImpl<LFTincanLrsContext>
    implements LFTincanLrsContext {
    private long _id;
    private String _registration;
    private Integer _instructorID;
    private Integer _teamID;
    private Integer _contextActivitiesID;
    private String _revision;
    private String _platform;
    private String _language;
    private String _statement;
    private String _extensions;
    private BaseModel<?> _lfTincanLrsContextRemoteModel;

    public LFTincanLrsContextClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsContext.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsContext.class.getName();
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
        attributes.put("registration", getRegistration());
        attributes.put("instructorID", getInstructorID());
        attributes.put("teamID", getTeamID());
        attributes.put("contextActivitiesID", getContextActivitiesID());
        attributes.put("revision", getRevision());
        attributes.put("platform", getPlatform());
        attributes.put("language", getLanguage());
        attributes.put("statement", getStatement());
        attributes.put("extensions", getExtensions());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String registration = (String) attributes.get("registration");

        if (registration != null) {
            setRegistration(registration);
        }

        Integer instructorID = (Integer) attributes.get("instructorID");

        if (instructorID != null) {
            setInstructorID(instructorID);
        }

        Integer teamID = (Integer) attributes.get("teamID");

        if (teamID != null) {
            setTeamID(teamID);
        }

        Integer contextActivitiesID = (Integer) attributes.get(
                "contextActivitiesID");

        if (contextActivitiesID != null) {
            setContextActivitiesID(contextActivitiesID);
        }

        String revision = (String) attributes.get("revision");

        if (revision != null) {
            setRevision(revision);
        }

        String platform = (String) attributes.get("platform");

        if (platform != null) {
            setPlatform(platform);
        }

        String language = (String) attributes.get("language");

        if (language != null) {
            setLanguage(language);
        }

        String statement = (String) attributes.get("statement");

        if (statement != null) {
            setStatement(statement);
        }

        String extensions = (String) attributes.get("extensions");

        if (extensions != null) {
            setExtensions(extensions);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanLrsContextRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRegistration() {
        return _registration;
    }

    @Override
    public void setRegistration(String registration) {
        _registration = registration;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setRegistration", String.class);

                method.invoke(_lfTincanLrsContextRemoteModel, registration);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getInstructorID() {
        return _instructorID;
    }

    @Override
    public void setInstructorID(Integer instructorID) {
        _instructorID = instructorID;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setInstructorID", Integer.class);

                method.invoke(_lfTincanLrsContextRemoteModel, instructorID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getTeamID() {
        return _teamID;
    }

    @Override
    public void setTeamID(Integer teamID) {
        _teamID = teamID;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setTeamID", Integer.class);

                method.invoke(_lfTincanLrsContextRemoteModel, teamID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getContextActivitiesID() {
        return _contextActivitiesID;
    }

    @Override
    public void setContextActivitiesID(Integer contextActivitiesID) {
        _contextActivitiesID = contextActivitiesID;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setContextActivitiesID",
                        Integer.class);

                method.invoke(_lfTincanLrsContextRemoteModel,
                    contextActivitiesID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRevision() {
        return _revision;
    }

    @Override
    public void setRevision(String revision) {
        _revision = revision;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setRevision", String.class);

                method.invoke(_lfTincanLrsContextRemoteModel, revision);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPlatform() {
        return _platform;
    }

    @Override
    public void setPlatform(String platform) {
        _platform = platform;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setPlatform", String.class);

                method.invoke(_lfTincanLrsContextRemoteModel, platform);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLanguage() {
        return _language;
    }

    @Override
    public void setLanguage(String language) {
        _language = language;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setLanguage", String.class);

                method.invoke(_lfTincanLrsContextRemoteModel, language);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatement() {
        return _statement;
    }

    @Override
    public void setStatement(String statement) {
        _statement = statement;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setStatement", String.class);

                method.invoke(_lfTincanLrsContextRemoteModel, statement);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getExtensions() {
        return _extensions;
    }

    @Override
    public void setExtensions(String extensions) {
        _extensions = extensions;

        if (_lfTincanLrsContextRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanLrsContextRemoteModel.getClass();

                Method method = clazz.getMethod("setExtensions", String.class);

                method.invoke(_lfTincanLrsContextRemoteModel, extensions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanLrsContextRemoteModel() {
        return _lfTincanLrsContextRemoteModel;
    }

    public void setLFTincanLrsContextRemoteModel(
        BaseModel<?> lfTincanLrsContextRemoteModel) {
        _lfTincanLrsContextRemoteModel = lfTincanLrsContextRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanLrsContextRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanLrsContextRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsContextLocalServiceUtil.addLFTincanLrsContext(this);
        } else {
            LFTincanLrsContextLocalServiceUtil.updateLFTincanLrsContext(this);
        }
    }

    @Override
    public LFTincanLrsContext toEscapedModel() {
        return (LFTincanLrsContext) ProxyUtil.newProxyInstance(LFTincanLrsContext.class.getClassLoader(),
            new Class[] { LFTincanLrsContext.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsContextClp clone = new LFTincanLrsContextClp();

        clone.setId(getId());
        clone.setRegistration(getRegistration());
        clone.setInstructorID(getInstructorID());
        clone.setTeamID(getTeamID());
        clone.setContextActivitiesID(getContextActivitiesID());
        clone.setRevision(getRevision());
        clone.setPlatform(getPlatform());
        clone.setLanguage(getLanguage());
        clone.setStatement(getStatement());
        clone.setExtensions(getExtensions());

        return clone;
    }

    @Override
    public int compareTo(LFTincanLrsContext lfTincanLrsContext) {
        long primaryKey = lfTincanLrsContext.getPrimaryKey();

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

        if (!(obj instanceof LFTincanLrsContextClp)) {
            return false;
        }

        LFTincanLrsContextClp lfTincanLrsContext = (LFTincanLrsContextClp) obj;

        long primaryKey = lfTincanLrsContext.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", registration=");
        sb.append(getRegistration());
        sb.append(", instructorID=");
        sb.append(getInstructorID());
        sb.append(", teamID=");
        sb.append(getTeamID());
        sb.append(", contextActivitiesID=");
        sb.append(getContextActivitiesID());
        sb.append(", revision=");
        sb.append(getRevision());
        sb.append(", platform=");
        sb.append(getPlatform());
        sb.append(", language=");
        sb.append(getLanguage());
        sb.append(", statement=");
        sb.append(getStatement());
        sb.append(", extensions=");
        sb.append(getExtensions());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>registration</column-name><column-value><![CDATA[");
        sb.append(getRegistration());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>instructorID</column-name><column-value><![CDATA[");
        sb.append(getInstructorID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>teamID</column-name><column-value><![CDATA[");
        sb.append(getTeamID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contextActivitiesID</column-name><column-value><![CDATA[");
        sb.append(getContextActivitiesID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>revision</column-name><column-value><![CDATA[");
        sb.append(getRevision());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>platform</column-name><column-value><![CDATA[");
        sb.append(getPlatform());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>language</column-name><column-value><![CDATA[");
        sb.append(getLanguage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>statement</column-name><column-value><![CDATA[");
        sb.append(getStatement());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extensions</column-name><column-value><![CDATA[");
        sb.append(getExtensions());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

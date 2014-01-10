package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFTincanLrsContext.class;
    }

    public String getModelClassName() {
        return LFTincanLrsContext.class.getName();
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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getRegistration() {
        return _registration;
    }

    public void setRegistration(String registration) {
        _registration = registration;
    }

    public Integer getInstructorID() {
        return _instructorID;
    }

    public void setInstructorID(Integer instructorID) {
        _instructorID = instructorID;
    }

    public Integer getTeamID() {
        return _teamID;
    }

    public void setTeamID(Integer teamID) {
        _teamID = teamID;
    }

    public Integer getContextActivitiesID() {
        return _contextActivitiesID;
    }

    public void setContextActivitiesID(Integer contextActivitiesID) {
        _contextActivitiesID = contextActivitiesID;
    }

    public String getRevision() {
        return _revision;
    }

    public void setRevision(String revision) {
        _revision = revision;
    }

    public String getPlatform() {
        return _platform;
    }

    public void setPlatform(String platform) {
        _platform = platform;
    }

    public String getLanguage() {
        return _language;
    }

    public void setLanguage(String language) {
        _language = language;
    }

    public String getStatement() {
        return _statement;
    }

    public void setStatement(String statement) {
        _statement = statement;
    }

    public String getExtensions() {
        return _extensions;
    }

    public void setExtensions(String extensions) {
        _extensions = extensions;
    }

    public BaseModel<?> getLFTincanLrsContextRemoteModel() {
        return _lfTincanLrsContextRemoteModel;
    }

    public void setLFTincanLrsContextRemoteModel(
        BaseModel<?> lfTincanLrsContextRemoteModel) {
        _lfTincanLrsContextRemoteModel = lfTincanLrsContextRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsContextLocalServiceUtil.addLFTincanLrsContext(this);
        } else {
            LFTincanLrsContextLocalServiceUtil.updateLFTincanLrsContext(this);
        }
    }

    @Override
    public LFTincanLrsContext toEscapedModel() {
        return (LFTincanLrsContext) Proxy.newProxyInstance(LFTincanLrsContext.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFTincanLrsContextClp lfTincanLrsContext = null;

        try {
            lfTincanLrsContext = (LFTincanLrsContextClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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

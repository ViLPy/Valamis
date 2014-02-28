package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFTincanLrsContextSoap implements Serializable {
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

    public LFTincanLrsContextSoap() {
    }

    public static LFTincanLrsContextSoap toSoapModel(LFTincanLrsContext model) {
        LFTincanLrsContextSoap soapModel = new LFTincanLrsContextSoap();

        soapModel.setId(model.getId());
        soapModel.setRegistration(model.getRegistration());
        soapModel.setInstructorID(model.getInstructorID());
        soapModel.setTeamID(model.getTeamID());
        soapModel.setContextActivitiesID(model.getContextActivitiesID());
        soapModel.setRevision(model.getRevision());
        soapModel.setPlatform(model.getPlatform());
        soapModel.setLanguage(model.getLanguage());
        soapModel.setStatement(model.getStatement());
        soapModel.setExtensions(model.getExtensions());

        return soapModel;
    }

    public static LFTincanLrsContextSoap[] toSoapModels(
        LFTincanLrsContext[] models) {
        LFTincanLrsContextSoap[] soapModels = new LFTincanLrsContextSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsContextSoap[][] toSoapModels(
        LFTincanLrsContext[][] models) {
        LFTincanLrsContextSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsContextSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsContextSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsContextSoap[] toSoapModels(
        List<LFTincanLrsContext> models) {
        List<LFTincanLrsContextSoap> soapModels = new ArrayList<LFTincanLrsContextSoap>(models.size());

        for (LFTincanLrsContext model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsContextSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
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
}

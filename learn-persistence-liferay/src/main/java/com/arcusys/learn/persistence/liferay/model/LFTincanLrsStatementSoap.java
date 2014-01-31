package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFTincanLrsStatementSoap implements Serializable {
    private long _id;
    private String _tincanID;
    private Integer _actorID;
    private String _verbID;
    private String _verbDisplay;
    private String _objType;
    private Integer _objID;
    private Integer _resultID;
    private Integer _contextID;
    private Date _timestamp;
    private Date _stored;
    private Integer _authorityID;
    private String _version;

    public LFTincanLrsStatementSoap() {
    }

    public static LFTincanLrsStatementSoap toSoapModel(
        LFTincanLrsStatement model) {
        LFTincanLrsStatementSoap soapModel = new LFTincanLrsStatementSoap();

        soapModel.setId(model.getId());
        soapModel.setTincanID(model.getTincanID());
        soapModel.setActorID(model.getActorID());
        soapModel.setVerbID(model.getVerbID());
        soapModel.setVerbDisplay(model.getVerbDisplay());
        soapModel.setObjType(model.getObjType());
        soapModel.setObjID(model.getObjID());
        soapModel.setResultID(model.getResultID());
        soapModel.setContextID(model.getContextID());
        soapModel.setTimestamp(model.getTimestamp());
        soapModel.setStored(model.getStored());
        soapModel.setAuthorityID(model.getAuthorityID());
        soapModel.setVersion(model.getVersion());

        return soapModel;
    }

    public static LFTincanLrsStatementSoap[] toSoapModels(
        LFTincanLrsStatement[] models) {
        LFTincanLrsStatementSoap[] soapModels = new LFTincanLrsStatementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsStatementSoap[][] toSoapModels(
        LFTincanLrsStatement[][] models) {
        LFTincanLrsStatementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsStatementSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsStatementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsStatementSoap[] toSoapModels(
        List<LFTincanLrsStatement> models) {
        List<LFTincanLrsStatementSoap> soapModels = new ArrayList<LFTincanLrsStatementSoap>(models.size());

        for (LFTincanLrsStatement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsStatementSoap[soapModels.size()]);
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

    public String getTincanID() {
        return _tincanID;
    }

    public void setTincanID(String tincanID) {
        _tincanID = tincanID;
    }

    public Integer getActorID() {
        return _actorID;
    }

    public void setActorID(Integer actorID) {
        _actorID = actorID;
    }

    public String getVerbID() {
        return _verbID;
    }

    public void setVerbID(String verbID) {
        _verbID = verbID;
    }

    public String getVerbDisplay() {
        return _verbDisplay;
    }

    public void setVerbDisplay(String verbDisplay) {
        _verbDisplay = verbDisplay;
    }

    public String getObjType() {
        return _objType;
    }

    public void setObjType(String objType) {
        _objType = objType;
    }

    public Integer getObjID() {
        return _objID;
    }

    public void setObjID(Integer objID) {
        _objID = objID;
    }

    public Integer getResultID() {
        return _resultID;
    }

    public void setResultID(Integer resultID) {
        _resultID = resultID;
    }

    public Integer getContextID() {
        return _contextID;
    }

    public void setContextID(Integer contextID) {
        _contextID = contextID;
    }

    public Date getTimestamp() {
        return _timestamp;
    }

    public void setTimestamp(Date timestamp) {
        _timestamp = timestamp;
    }

    public Date getStored() {
        return _stored;
    }

    public void setStored(Date stored) {
        _stored = stored;
    }

    public Integer getAuthorityID() {
        return _authorityID;
    }

    public void setAuthorityID(Integer authorityID) {
        _authorityID = authorityID;
    }

    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        _version = version;
    }
}

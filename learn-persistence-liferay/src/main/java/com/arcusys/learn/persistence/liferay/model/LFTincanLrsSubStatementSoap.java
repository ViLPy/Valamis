package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
* This class is used by SOAP remote services.
*
* @author    Brian Wing Shun Chan
* @generated
*/
public class LFTincanLrsSubStatementSoap implements Serializable {
    private long _id;
    private Integer _actorID;
    private String _verbID;
    private String _verbDisplay;
    private String _objType;
    private Integer _objID;

    public LFTincanLrsSubStatementSoap() {
    }

    public static LFTincanLrsSubStatementSoap toSoapModel(
        LFTincanLrsSubStatement model) {
        LFTincanLrsSubStatementSoap soapModel = new LFTincanLrsSubStatementSoap();

        soapModel.setId(model.getId());
        soapModel.setActorID(model.getActorID());
        soapModel.setVerbID(model.getVerbID());
        soapModel.setVerbDisplay(model.getVerbDisplay());
        soapModel.setObjType(model.getObjType());
        soapModel.setObjID(model.getObjID());

        return soapModel;
    }

    public static LFTincanLrsSubStatementSoap[] toSoapModels(
        LFTincanLrsSubStatement[] models) {
        LFTincanLrsSubStatementSoap[] soapModels = new LFTincanLrsSubStatementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsSubStatementSoap[][] toSoapModels(
        LFTincanLrsSubStatement[][] models) {
        LFTincanLrsSubStatementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsSubStatementSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsSubStatementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsSubStatementSoap[] toSoapModels(
        List<LFTincanLrsSubStatement> models) {
        List<LFTincanLrsSubStatementSoap> soapModels = new ArrayList<LFTincanLrsSubStatementSoap>(models.size());

        for (LFTincanLrsSubStatement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsSubStatementSoap[soapModels.size()]);
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
}

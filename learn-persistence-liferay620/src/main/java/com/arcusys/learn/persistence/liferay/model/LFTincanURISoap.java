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
public class LFTincanURISoap implements Serializable {
    private String _uri;
    private String _objID;
    private String _objType;
    private String _content;

    public LFTincanURISoap() {
    }

    public static LFTincanURISoap toSoapModel(LFTincanURI model) {
        LFTincanURISoap soapModel = new LFTincanURISoap();

        soapModel.setUri(model.getUri());
        soapModel.setObjID(model.getObjID());
        soapModel.setObjType(model.getObjType());
        soapModel.setContent(model.getContent());

        return soapModel;
    }

    public static LFTincanURISoap[] toSoapModels(LFTincanURI[] models) {
        LFTincanURISoap[] soapModels = new LFTincanURISoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanURISoap[][] toSoapModels(LFTincanURI[][] models) {
        LFTincanURISoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanURISoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanURISoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanURISoap[] toSoapModels(List<LFTincanURI> models) {
        List<LFTincanURISoap> soapModels = new ArrayList<LFTincanURISoap>(models.size());

        for (LFTincanURI model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanURISoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _uri;
    }

    public void setPrimaryKey(String pk) {
        setUri(pk);
    }

    public String getUri() {
        return _uri;
    }

    public void setUri(String uri) {
        _uri = uri;
    }

    public String getObjID() {
        return _objID;
    }

    public void setObjID(String objID) {
        _objID = objID;
    }

    public String getObjType() {
        return _objType;
    }

    public void setObjType(String objType) {
        _objType = objType;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }
}

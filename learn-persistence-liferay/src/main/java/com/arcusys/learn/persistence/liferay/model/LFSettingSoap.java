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
public class LFSettingSoap implements Serializable {
    private long _id;
    private String _key;
    private String _value;

    public LFSettingSoap() {
    }

    public static LFSettingSoap toSoapModel(LFSetting model) {
        LFSettingSoap soapModel = new LFSettingSoap();

        soapModel.setId(model.getId());
        soapModel.setKey(model.getKey());
        soapModel.setValue(model.getValue());

        return soapModel;
    }

    public static LFSettingSoap[] toSoapModels(LFSetting[] models) {
        LFSettingSoap[] soapModels = new LFSettingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSettingSoap[][] toSoapModels(LFSetting[][] models) {
        LFSettingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSettingSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSettingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSettingSoap[] toSoapModels(List<LFSetting> models) {
        List<LFSettingSoap> soapModels = new ArrayList<LFSettingSoap>(models.size());

        for (LFSetting model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSettingSoap[soapModels.size()]);
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

    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }
}

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
public class LFSettingsSoap implements Serializable {
    private long _id;
    private String _key;
    private String _value;

    public LFSettingsSoap() {
    }

    public static LFSettingsSoap toSoapModel(LFSettings model) {
        LFSettingsSoap soapModel = new LFSettingsSoap();

        soapModel.setId(model.getId());
        soapModel.setKey(model.getKey());
        soapModel.setValue(model.getValue());

        return soapModel;
    }

    public static LFSettingsSoap[] toSoapModels(LFSettings[] models) {
        LFSettingsSoap[] soapModels = new LFSettingsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSettingsSoap[][] toSoapModels(LFSettings[][] models) {
        LFSettingsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSettingsSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSettingsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSettingsSoap[] toSoapModels(List<LFSettings> models) {
        List<LFSettingsSoap> soapModels = new ArrayList<LFSettingsSoap>(models.size());

        for (LFSettings model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSettingsSoap[soapModels.size()]);
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

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
public class LFConfigSoap implements Serializable {
    private long _id;
    private String _dataKey;
    private String _dataValue;

    public LFConfigSoap() {
    }

    public static LFConfigSoap toSoapModel(LFConfig model) {
        LFConfigSoap soapModel = new LFConfigSoap();

        soapModel.setId(model.getId());
        soapModel.setDataKey(model.getDataKey());
        soapModel.setDataValue(model.getDataValue());

        return soapModel;
    }

    public static LFConfigSoap[] toSoapModels(LFConfig[] models) {
        LFConfigSoap[] soapModels = new LFConfigSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFConfigSoap[][] toSoapModels(LFConfig[][] models) {
        LFConfigSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFConfigSoap[models.length][models[0].length];
        } else {
            soapModels = new LFConfigSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFConfigSoap[] toSoapModels(List<LFConfig> models) {
        List<LFConfigSoap> soapModels = new ArrayList<LFConfigSoap>(models.size());

        for (LFConfig model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFConfigSoap[soapModels.size()]);
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

    public String getDataKey() {
        return _dataKey;
    }

    public void setDataKey(String dataKey) {
        _dataKey = dataKey;
    }

    public String getDataValue() {
        return _dataValue;
    }

    public void setDataValue(String dataValue) {
        _dataValue = dataValue;
    }
}

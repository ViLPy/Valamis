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
public class LFSiteDependentConfigSoap implements Serializable {
    private long _id;
    private Integer _siteID;
    private String _dataKey;
    private String _dataValue;

    public LFSiteDependentConfigSoap() {
    }

    public static LFSiteDependentConfigSoap toSoapModel(
        LFSiteDependentConfig model) {
        LFSiteDependentConfigSoap soapModel = new LFSiteDependentConfigSoap();

        soapModel.setId(model.getId());
        soapModel.setSiteID(model.getSiteID());
        soapModel.setDataKey(model.getDataKey());
        soapModel.setDataValue(model.getDataValue());

        return soapModel;
    }

    public static LFSiteDependentConfigSoap[] toSoapModels(
        LFSiteDependentConfig[] models) {
        LFSiteDependentConfigSoap[] soapModels = new LFSiteDependentConfigSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSiteDependentConfigSoap[][] toSoapModels(
        LFSiteDependentConfig[][] models) {
        LFSiteDependentConfigSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSiteDependentConfigSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSiteDependentConfigSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSiteDependentConfigSoap[] toSoapModels(
        List<LFSiteDependentConfig> models) {
        List<LFSiteDependentConfigSoap> soapModels = new ArrayList<LFSiteDependentConfigSoap>(models.size());

        for (LFSiteDependentConfig model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSiteDependentConfigSoap[soapModels.size()]);
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

    public Integer getSiteID() {
        return _siteID;
    }

    public void setSiteID(Integer siteID) {
        _siteID = siteID;
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

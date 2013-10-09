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
public class LFTincanLrsEndpointSoap implements Serializable {
    private long _id;
    private String _endpoint;
    private String _authType;
    private String _key;
    private String _secret;

    public LFTincanLrsEndpointSoap() {
    }

    public static LFTincanLrsEndpointSoap toSoapModel(LFTincanLrsEndpoint model) {
        LFTincanLrsEndpointSoap soapModel = new LFTincanLrsEndpointSoap();

        soapModel.setId(model.getId());
        soapModel.setEndpoint(model.getEndpoint());
        soapModel.setAuthType(model.getAuthType());
        soapModel.setKey(model.getKey());
        soapModel.setSecret(model.getSecret());

        return soapModel;
    }

    public static LFTincanLrsEndpointSoap[] toSoapModels(
        LFTincanLrsEndpoint[] models) {
        LFTincanLrsEndpointSoap[] soapModels = new LFTincanLrsEndpointSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsEndpointSoap[][] toSoapModels(
        LFTincanLrsEndpoint[][] models) {
        LFTincanLrsEndpointSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsEndpointSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsEndpointSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsEndpointSoap[] toSoapModels(
        List<LFTincanLrsEndpoint> models) {
        List<LFTincanLrsEndpointSoap> soapModels = new ArrayList<LFTincanLrsEndpointSoap>(models.size());

        for (LFTincanLrsEndpoint model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsEndpointSoap[soapModels.size()]);
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

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
    }

    public String getAuthType() {
        return _authType;
    }

    public void setAuthType(String authType) {
        _authType = authType;
    }

    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getSecret() {
        return _secret;
    }

    public void setSecret(String secret) {
        _secret = secret;
    }
}

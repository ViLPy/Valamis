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
public class LFTCClntApiStorageSoap implements Serializable {
    private long _id;
    private String _name;
    private String _description;
    private String _secret;
    private String _url;
    private String _redirectUrl;
    private String _scope;
    private String _iconUrl;
    private String _token;
    private String _code;
    private Date _issuedAt;
    private Long _expiredIn;

    public LFTCClntApiStorageSoap() {
    }

    public static LFTCClntApiStorageSoap toSoapModel(LFTCClntApiStorage model) {
        LFTCClntApiStorageSoap soapModel = new LFTCClntApiStorageSoap();

        soapModel.setId(model.getId());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setSecret(model.getSecret());
        soapModel.setUrl(model.getUrl());
        soapModel.setRedirectUrl(model.getRedirectUrl());
        soapModel.setScope(model.getScope());
        soapModel.setIconUrl(model.getIconUrl());
        soapModel.setToken(model.getToken());
        soapModel.setCode(model.getCode());
        soapModel.setIssuedAt(model.getIssuedAt());
        soapModel.setExpiredIn(model.getExpiredIn());

        return soapModel;
    }

    public static LFTCClntApiStorageSoap[] toSoapModels(
        LFTCClntApiStorage[] models) {
        LFTCClntApiStorageSoap[] soapModels = new LFTCClntApiStorageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTCClntApiStorageSoap[][] toSoapModels(
        LFTCClntApiStorage[][] models) {
        LFTCClntApiStorageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTCClntApiStorageSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTCClntApiStorageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTCClntApiStorageSoap[] toSoapModels(
        List<LFTCClntApiStorage> models) {
        List<LFTCClntApiStorageSoap> soapModels = new ArrayList<LFTCClntApiStorageSoap>(models.size());

        for (LFTCClntApiStorage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTCClntApiStorageSoap[soapModels.size()]);
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

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getSecret() {
        return _secret;
    }

    public void setSecret(String secret) {
        _secret = secret;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getRedirectUrl() {
        return _redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        _redirectUrl = redirectUrl;
    }

    public String getScope() {
        return _scope;
    }

    public void setScope(String scope) {
        _scope = scope;
    }

    public String getIconUrl() {
        return _iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        _iconUrl = iconUrl;
    }

    public String getToken() {
        return _token;
    }

    public void setToken(String token) {
        _token = token;
    }

    public String getCode() {
        return _code;
    }

    public void setCode(String code) {
        _code = code;
    }

    public Date getIssuedAt() {
        return _issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        _issuedAt = issuedAt;
    }

    public Long getExpiredIn() {
        return _expiredIn;
    }

    public void setExpiredIn(Long expiredIn) {
        _expiredIn = expiredIn;
    }
}

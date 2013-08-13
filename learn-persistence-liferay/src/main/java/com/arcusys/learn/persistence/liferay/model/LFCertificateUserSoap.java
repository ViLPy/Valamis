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
public class LFCertificateUserSoap implements Serializable {
    private long _id;
    private Integer _certificateID;
    private Integer _userID;

    public LFCertificateUserSoap() {
    }

    public static LFCertificateUserSoap toSoapModel(LFCertificateUser model) {
        LFCertificateUserSoap soapModel = new LFCertificateUserSoap();

        soapModel.setId(model.getId());
        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setUserID(model.getUserID());

        return soapModel;
    }

    public static LFCertificateUserSoap[] toSoapModels(
        LFCertificateUser[] models) {
        LFCertificateUserSoap[] soapModels = new LFCertificateUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateUserSoap[][] toSoapModels(
        LFCertificateUser[][] models) {
        LFCertificateUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCertificateUserSoap[models.length][models[0].length];
        } else {
            soapModels = new LFCertificateUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateUserSoap[] toSoapModels(
        List<LFCertificateUser> models) {
        List<LFCertificateUserSoap> soapModels = new ArrayList<LFCertificateUserSoap>(models.size());

        for (LFCertificateUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCertificateUserSoap[soapModels.size()]);
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

    public Integer getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        _certificateID = certificateID;
    }

    public Integer getUserID() {
        return _userID;
    }

    public void setUserID(Integer userID) {
        _userID = userID;
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK;

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
public class LFCertificateToUserSoap implements Serializable {
    private Integer _certificateID;
    private Integer _userID;
    private String _status;
    private Date _addedToUserDate;

    public LFCertificateToUserSoap() {
    }

    public static LFCertificateToUserSoap toSoapModel(LFCertificateToUser model) {
        LFCertificateToUserSoap soapModel = new LFCertificateToUserSoap();

        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setUserID(model.getUserID());
        soapModel.setStatus(model.getStatus());
        soapModel.setAddedToUserDate(model.getAddedToUserDate());

        return soapModel;
    }

    public static LFCertificateToUserSoap[] toSoapModels(
        LFCertificateToUser[] models) {
        LFCertificateToUserSoap[] soapModels = new LFCertificateToUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateToUserSoap[][] toSoapModels(
        LFCertificateToUser[][] models) {
        LFCertificateToUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCertificateToUserSoap[models.length][models[0].length];
        } else {
            soapModels = new LFCertificateToUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateToUserSoap[] toSoapModels(
        List<LFCertificateToUser> models) {
        List<LFCertificateToUserSoap> soapModels = new ArrayList<LFCertificateToUserSoap>(models.size());

        for (LFCertificateToUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCertificateToUserSoap[soapModels.size()]);
    }

    public LFCertificateToUserPK getPrimaryKey() {
        return new LFCertificateToUserPK(_certificateID, _userID);
    }

    public void setPrimaryKey(LFCertificateToUserPK pk) {
        setCertificateID(pk.certificateID);
        setUserID(pk.userID);
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

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public Date getAddedToUserDate() {
        return _addedToUserDate;
    }

    public void setAddedToUserDate(Date addedToUserDate) {
        _addedToUserDate = addedToUserDate;
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateUserPK;

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
public class LFCertificateUserSoap implements Serializable {
    private Long _certificateID;
    private Long _userID;
    private Date _attachedDate;

    public LFCertificateUserSoap() {
    }

    public static LFCertificateUserSoap toSoapModel(LFCertificateUser model) {
        LFCertificateUserSoap soapModel = new LFCertificateUserSoap();

        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setUserID(model.getUserID());
        soapModel.setAttachedDate(model.getAttachedDate());

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

    public LFCertificateUserPK getPrimaryKey() {
        return new LFCertificateUserPK(_certificateID, _userID);
    }

    public void setPrimaryKey(LFCertificateUserPK pk) {
        setCertificateID(pk.certificateID);
        setUserID(pk.userID);
    }

    public Long getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Long certificateID) {
        _certificateID = certificateID;
    }

    public Long getUserID() {
        return _userID;
    }

    public void setUserID(Long userID) {
        _userID = userID;
    }

    public Date getAttachedDate() {
        return _attachedDate;
    }

    public void setAttachedDate(Date attachedDate) {
        _attachedDate = attachedDate;
    }
}

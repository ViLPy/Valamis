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
public class LFCertificateSiteSoap implements Serializable {
    private long _id;
    private Integer _certificateID;
    private Integer _siteID;
    private Integer _arrangementIndex;

    public LFCertificateSiteSoap() {
    }

    public static LFCertificateSiteSoap toSoapModel(LFCertificateSite model) {
        LFCertificateSiteSoap soapModel = new LFCertificateSiteSoap();

        soapModel.setId(model.getId());
        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setSiteID(model.getSiteID());
        soapModel.setArrangementIndex(model.getArrangementIndex());

        return soapModel;
    }

    public static LFCertificateSiteSoap[] toSoapModels(
        LFCertificateSite[] models) {
        LFCertificateSiteSoap[] soapModels = new LFCertificateSiteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateSiteSoap[][] toSoapModels(
        LFCertificateSite[][] models) {
        LFCertificateSiteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCertificateSiteSoap[models.length][models[0].length];
        } else {
            soapModels = new LFCertificateSiteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateSiteSoap[] toSoapModels(
        List<LFCertificateSite> models) {
        List<LFCertificateSiteSoap> soapModels = new ArrayList<LFCertificateSiteSoap>(models.size());

        for (LFCertificateSite model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCertificateSiteSoap[soapModels.size()]);
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

    public Integer getSiteID() {
        return _siteID;
    }

    public void setSiteID(Integer siteID) {
        _siteID = siteID;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }
}

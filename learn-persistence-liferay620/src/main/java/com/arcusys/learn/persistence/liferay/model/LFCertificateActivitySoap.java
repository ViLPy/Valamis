package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFCertificateActivitySoap implements Serializable {
    private Long _certificateID;
    private String _activityName;
    private Integer _datacount;
    private String _periodType;
    private Integer _period;

    public LFCertificateActivitySoap() {
    }

    public static LFCertificateActivitySoap toSoapModel(
        LFCertificateActivity model) {
        LFCertificateActivitySoap soapModel = new LFCertificateActivitySoap();

        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setActivityName(model.getActivityName());
        soapModel.setDatacount(model.getDatacount());
        soapModel.setPeriodType(model.getPeriodType());
        soapModel.setPeriod(model.getPeriod());

        return soapModel;
    }

    public static LFCertificateActivitySoap[] toSoapModels(
        LFCertificateActivity[] models) {
        LFCertificateActivitySoap[] soapModels = new LFCertificateActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateActivitySoap[][] toSoapModels(
        LFCertificateActivity[][] models) {
        LFCertificateActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCertificateActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFCertificateActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateActivitySoap[] toSoapModels(
        List<LFCertificateActivity> models) {
        List<LFCertificateActivitySoap> soapModels = new ArrayList<LFCertificateActivitySoap>(models.size());

        for (LFCertificateActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCertificateActivitySoap[soapModels.size()]);
    }

    public LFCertificateActivityPK getPrimaryKey() {
        return new LFCertificateActivityPK(_certificateID, _activityName);
    }

    public void setPrimaryKey(LFCertificateActivityPK pk) {
        setCertificateID(pk.certificateID);
        setActivityName(pk.activityName);
    }

    public Long getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Long certificateID) {
        _certificateID = certificateID;
    }

    public String getActivityName() {
        return _activityName;
    }

    public void setActivityName(String activityName) {
        _activityName = activityName;
    }

    public Integer getDatacount() {
        return _datacount;
    }

    public void setDatacount(Integer datacount) {
        _datacount = datacount;
    }

    public String getPeriodType() {
        return _periodType;
    }

    public void setPeriodType(String periodType) {
        _periodType = periodType;
    }

    public Integer getPeriod() {
        return _period;
    }

    public void setPeriod(Integer period) {
        _period = period;
    }
}

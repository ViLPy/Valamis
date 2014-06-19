package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFCertificateTincanStatementSoap implements Serializable {
    private Long _certificateID;
    private String _verb;
    private String _object;
    private String _periodType;
    private Integer _period;

    public LFCertificateTincanStatementSoap() {
    }

    public static LFCertificateTincanStatementSoap toSoapModel(
        LFCertificateTincanStatement model) {
        LFCertificateTincanStatementSoap soapModel = new LFCertificateTincanStatementSoap();

        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setVerb(model.getVerb());
        soapModel.setObject(model.getObject());
        soapModel.setPeriodType(model.getPeriodType());
        soapModel.setPeriod(model.getPeriod());

        return soapModel;
    }

    public static LFCertificateTincanStatementSoap[] toSoapModels(
        LFCertificateTincanStatement[] models) {
        LFCertificateTincanStatementSoap[] soapModels = new LFCertificateTincanStatementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateTincanStatementSoap[][] toSoapModels(
        LFCertificateTincanStatement[][] models) {
        LFCertificateTincanStatementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCertificateTincanStatementSoap[models.length][models[0].length];
        } else {
            soapModels = new LFCertificateTincanStatementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateTincanStatementSoap[] toSoapModels(
        List<LFCertificateTincanStatement> models) {
        List<LFCertificateTincanStatementSoap> soapModels = new ArrayList<LFCertificateTincanStatementSoap>(models.size());

        for (LFCertificateTincanStatement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCertificateTincanStatementSoap[soapModels.size()]);
    }

    public LFCertificateTincanStatementPK getPrimaryKey() {
        return new LFCertificateTincanStatementPK(_certificateID, _verb, _object);
    }

    public void setPrimaryKey(LFCertificateTincanStatementPK pk) {
        setCertificateID(pk.certificateID);
        setVerb(pk.verb);
        setObject(pk.object);
    }

    public Long getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Long certificateID) {
        _certificateID = certificateID;
    }

    public String getVerb() {
        return _verb;
    }

    public void setVerb(String verb) {
        _verb = verb;
    }

    public String getObject() {
        return _object;
    }

    public void setObject(String object) {
        _object = object;
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

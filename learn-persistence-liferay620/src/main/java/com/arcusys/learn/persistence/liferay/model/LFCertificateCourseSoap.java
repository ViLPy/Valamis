package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateCoursePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFCertificateCourseSoap implements Serializable {
    private Long _certificateID;
    private Long _courseID;
    private Integer _arrangementIndex;
    private String _periodType;
    private Integer _period;

    public LFCertificateCourseSoap() {
    }

    public static LFCertificateCourseSoap toSoapModel(LFCertificateCourse model) {
        LFCertificateCourseSoap soapModel = new LFCertificateCourseSoap();

        soapModel.setCertificateID(model.getCertificateID());
        soapModel.setCourseID(model.getCourseID());
        soapModel.setArrangementIndex(model.getArrangementIndex());
        soapModel.setPeriodType(model.getPeriodType());
        soapModel.setPeriod(model.getPeriod());

        return soapModel;
    }

    public static LFCertificateCourseSoap[] toSoapModels(
        LFCertificateCourse[] models) {
        LFCertificateCourseSoap[] soapModels = new LFCertificateCourseSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateCourseSoap[][] toSoapModels(
        LFCertificateCourse[][] models) {
        LFCertificateCourseSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCertificateCourseSoap[models.length][models[0].length];
        } else {
            soapModels = new LFCertificateCourseSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCertificateCourseSoap[] toSoapModels(
        List<LFCertificateCourse> models) {
        List<LFCertificateCourseSoap> soapModels = new ArrayList<LFCertificateCourseSoap>(models.size());

        for (LFCertificateCourse model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCertificateCourseSoap[soapModels.size()]);
    }

    public LFCertificateCoursePK getPrimaryKey() {
        return new LFCertificateCoursePK(_certificateID, _courseID);
    }

    public void setPrimaryKey(LFCertificateCoursePK pk) {
        setCertificateID(pk.certificateID);
        setCourseID(pk.courseID);
    }

    public Long getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Long certificateID) {
        _certificateID = certificateID;
    }

    public Long getCourseID() {
        return _courseID;
    }

    public void setCourseID(Long courseID) {
        _courseID = courseID;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
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

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFPackageGradeStoragePK;

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
public class LFPackageGradeStorageSoap implements Serializable {
    private Long _userId;
    private Long _packageId;
    private String _grade;
    private String _comment;
    private Date _date;

    public LFPackageGradeStorageSoap() {
    }

    public static LFPackageGradeStorageSoap toSoapModel(
        LFPackageGradeStorage model) {
        LFPackageGradeStorageSoap soapModel = new LFPackageGradeStorageSoap();

        soapModel.setUserId(model.getUserId());
        soapModel.setPackageId(model.getPackageId());
        soapModel.setGrade(model.getGrade());
        soapModel.setComment(model.getComment());
        soapModel.setDate(model.getDate());

        return soapModel;
    }

    public static LFPackageGradeStorageSoap[] toSoapModels(
        LFPackageGradeStorage[] models) {
        LFPackageGradeStorageSoap[] soapModels = new LFPackageGradeStorageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFPackageGradeStorageSoap[][] toSoapModels(
        LFPackageGradeStorage[][] models) {
        LFPackageGradeStorageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFPackageGradeStorageSoap[models.length][models[0].length];
        } else {
            soapModels = new LFPackageGradeStorageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFPackageGradeStorageSoap[] toSoapModels(
        List<LFPackageGradeStorage> models) {
        List<LFPackageGradeStorageSoap> soapModels = new ArrayList<LFPackageGradeStorageSoap>(models.size());

        for (LFPackageGradeStorage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFPackageGradeStorageSoap[soapModels.size()]);
    }

    public LFPackageGradeStoragePK getPrimaryKey() {
        return new LFPackageGradeStoragePK(_userId, _packageId);
    }

    public void setPrimaryKey(LFPackageGradeStoragePK pk) {
        setUserId(pk.userId);
        setPackageId(pk.packageId);
    }

    public Long getUserId() {
        return _userId;
    }

    public void setUserId(Long userId) {
        _userId = userId;
    }

    public Long getPackageId() {
        return _packageId;
    }

    public void setPackageId(Long packageId) {
        _packageId = packageId;
    }

    public String getGrade() {
        return _grade;
    }

    public void setGrade(String grade) {
        _grade = grade;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        _comment = comment;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        _date = date;
    }
}

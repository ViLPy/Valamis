package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFTincanPackageSoap implements Serializable {
    private long _id;
    private String _title;
    private String _summary;
    private Long _assetRefID;
    private Integer _courseID;

    public LFTincanPackageSoap() {
    }

    public static LFTincanPackageSoap toSoapModel(LFTincanPackage model) {
        LFTincanPackageSoap soapModel = new LFTincanPackageSoap();

        soapModel.setId(model.getId());
        soapModel.setTitle(model.getTitle());
        soapModel.setSummary(model.getSummary());
        soapModel.setAssetRefID(model.getAssetRefID());
        soapModel.setCourseID(model.getCourseID());

        return soapModel;
    }

    public static LFTincanPackageSoap[] toSoapModels(LFTincanPackage[] models) {
        LFTincanPackageSoap[] soapModels = new LFTincanPackageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanPackageSoap[][] toSoapModels(
        LFTincanPackage[][] models) {
        LFTincanPackageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanPackageSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanPackageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanPackageSoap[] toSoapModels(
        List<LFTincanPackage> models) {
        List<LFTincanPackageSoap> soapModels = new ArrayList<LFTincanPackageSoap>(models.size());

        for (LFTincanPackage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanPackageSoap[soapModels.size()]);
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

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getSummary() {
        return _summary;
    }

    public void setSummary(String summary) {
        _summary = summary;
    }

    public Long getAssetRefID() {
        return _assetRefID;
    }

    public void setAssetRefID(Long assetRefID) {
        _assetRefID = assetRefID;
    }

    public Integer getCourseID() {
        return _courseID;
    }

    public void setCourseID(Integer courseID) {
        _courseID = courseID;
    }
}

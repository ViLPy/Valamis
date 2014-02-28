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
public class LFPackageSoap implements Serializable {
    private long _id;
    private String _defaultOrganizationID;
    private String _title;
    private String _base;
    private String _resourcesBase;
    private String _summary;
    private Long _assetRefID;
    private Integer _courseID;

    public LFPackageSoap() {
    }

    public static LFPackageSoap toSoapModel(LFPackage model) {
        LFPackageSoap soapModel = new LFPackageSoap();

        soapModel.setId(model.getId());
        soapModel.setDefaultOrganizationID(model.getDefaultOrganizationID());
        soapModel.setTitle(model.getTitle());
        soapModel.setBase(model.getBase());
        soapModel.setResourcesBase(model.getResourcesBase());
        soapModel.setSummary(model.getSummary());
        soapModel.setAssetRefID(model.getAssetRefID());
        soapModel.setCourseID(model.getCourseID());

        return soapModel;
    }

    public static LFPackageSoap[] toSoapModels(LFPackage[] models) {
        LFPackageSoap[] soapModels = new LFPackageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFPackageSoap[][] toSoapModels(LFPackage[][] models) {
        LFPackageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFPackageSoap[models.length][models[0].length];
        } else {
            soapModels = new LFPackageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFPackageSoap[] toSoapModels(List<LFPackage> models) {
        List<LFPackageSoap> soapModels = new ArrayList<LFPackageSoap>(models.size());

        for (LFPackage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFPackageSoap[soapModels.size()]);
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

    public String getDefaultOrganizationID() {
        return _defaultOrganizationID;
    }

    public void setDefaultOrganizationID(String defaultOrganizationID) {
        _defaultOrganizationID = defaultOrganizationID;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getBase() {
        return _base;
    }

    public void setBase(String base) {
        _base = base;
    }

    public String getResourcesBase() {
        return _resourcesBase;
    }

    public void setResourcesBase(String resourcesBase) {
        _resourcesBase = resourcesBase;
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

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
public class LFTincanManifestActivitySoap implements Serializable {
    private long _id;
    private String _tincanID;
    private Long _packageID;
    private String _activityType;
    private String _name;
    private String _description;
    private String _launch;
    private String _resource;

    public LFTincanManifestActivitySoap() {
    }

    public static LFTincanManifestActivitySoap toSoapModel(
        LFTincanManifestActivity model) {
        LFTincanManifestActivitySoap soapModel = new LFTincanManifestActivitySoap();

        soapModel.setId(model.getId());
        soapModel.setTincanID(model.getTincanID());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setActivityType(model.getActivityType());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setLaunch(model.getLaunch());
        soapModel.setResource(model.getResource());

        return soapModel;
    }

    public static LFTincanManifestActivitySoap[] toSoapModels(
        LFTincanManifestActivity[] models) {
        LFTincanManifestActivitySoap[] soapModels = new LFTincanManifestActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanManifestActivitySoap[][] toSoapModels(
        LFTincanManifestActivity[][] models) {
        LFTincanManifestActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanManifestActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanManifestActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanManifestActivitySoap[] toSoapModels(
        List<LFTincanManifestActivity> models) {
        List<LFTincanManifestActivitySoap> soapModels = new ArrayList<LFTincanManifestActivitySoap>(models.size());

        for (LFTincanManifestActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanManifestActivitySoap[soapModels.size()]);
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

    public String getTincanID() {
        return _tincanID;
    }

    public void setTincanID(String tincanID) {
        _tincanID = tincanID;
    }

    public Long getPackageID() {
        return _packageID;
    }

    public void setPackageID(Long packageID) {
        _packageID = packageID;
    }

    public String getActivityType() {
        return _activityType;
    }

    public void setActivityType(String activityType) {
        _activityType = activityType;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getLaunch() {
        return _launch;
    }

    public void setLaunch(String launch) {
        _launch = launch;
    }

    public String getResource() {
        return _resource;
    }

    public void setResource(String resource) {
        _resource = resource;
    }
}

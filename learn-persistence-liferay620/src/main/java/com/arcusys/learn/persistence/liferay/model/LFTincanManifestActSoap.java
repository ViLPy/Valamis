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
public class LFTincanManifestActSoap implements Serializable {
    private long _id;
    private String _tincanID;
    private Long _packageID;
    private String _activityType;
    private String _name;
    private String _description;
    private String _launch;
    private String _resourceID;

    public LFTincanManifestActSoap() {
    }

    public static LFTincanManifestActSoap toSoapModel(LFTincanManifestAct model) {
        LFTincanManifestActSoap soapModel = new LFTincanManifestActSoap();

        soapModel.setId(model.getId());
        soapModel.setTincanID(model.getTincanID());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setActivityType(model.getActivityType());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setLaunch(model.getLaunch());
        soapModel.setResourceID(model.getResourceID());

        return soapModel;
    }

    public static LFTincanManifestActSoap[] toSoapModels(
        LFTincanManifestAct[] models) {
        LFTincanManifestActSoap[] soapModels = new LFTincanManifestActSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanManifestActSoap[][] toSoapModels(
        LFTincanManifestAct[][] models) {
        LFTincanManifestActSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanManifestActSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanManifestActSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanManifestActSoap[] toSoapModels(
        List<LFTincanManifestAct> models) {
        List<LFTincanManifestActSoap> soapModels = new ArrayList<LFTincanManifestActSoap>(models.size());

        for (LFTincanManifestAct model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanManifestActSoap[soapModels.size()]);
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

    public String getResourceID() {
        return _resourceID;
    }

    public void setResourceID(String resourceID) {
        _resourceID = resourceID;
    }
}

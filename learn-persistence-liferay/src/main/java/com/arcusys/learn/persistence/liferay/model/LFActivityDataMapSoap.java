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
public class LFActivityDataMapSoap implements Serializable {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _targetId;
    private boolean _readSharedData;
    private boolean _writeSharedData;

    public LFActivityDataMapSoap() {
    }

    public static LFActivityDataMapSoap toSoapModel(LFActivityDataMap model) {
        LFActivityDataMapSoap soapModel = new LFActivityDataMapSoap();

        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setActivityID(model.getActivityID());
        soapModel.setTargetId(model.getTargetId());
        soapModel.setReadSharedData(model.getReadSharedData());
        soapModel.setWriteSharedData(model.getWriteSharedData());

        return soapModel;
    }

    public static LFActivityDataMapSoap[] toSoapModels(
        LFActivityDataMap[] models) {
        LFActivityDataMapSoap[] soapModels = new LFActivityDataMapSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFActivityDataMapSoap[][] toSoapModels(
        LFActivityDataMap[][] models) {
        LFActivityDataMapSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFActivityDataMapSoap[models.length][models[0].length];
        } else {
            soapModels = new LFActivityDataMapSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFActivityDataMapSoap[] toSoapModels(
        List<LFActivityDataMap> models) {
        List<LFActivityDataMapSoap> soapModels = new ArrayList<LFActivityDataMapSoap>(models.size());

        for (LFActivityDataMap model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFActivityDataMapSoap[soapModels.size()]);
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

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getActivityID() {
        return _activityID;
    }

    public void setActivityID(String activityID) {
        _activityID = activityID;
    }

    public String getTargetId() {
        return _targetId;
    }

    public void setTargetId(String targetId) {
        _targetId = targetId;
    }

    public boolean getReadSharedData() {
        return _readSharedData;
    }

    public boolean isReadSharedData() {
        return _readSharedData;
    }

    public void setReadSharedData(boolean readSharedData) {
        _readSharedData = readSharedData;
    }

    public boolean getWriteSharedData() {
        return _writeSharedData;
    }

    public boolean isWriteSharedData() {
        return _writeSharedData;
    }

    public void setWriteSharedData(boolean writeSharedData) {
        _writeSharedData = writeSharedData;
    }
}

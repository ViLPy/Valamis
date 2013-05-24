package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

/**
* This class is used by SOAP remote services.
*
* @author    Brian Wing Shun Chan
* @generated
*/
public class LFObjectiveStateSoap implements Serializable {
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private String _mapKey;
    private Integer _activityStateID;
    private Integer _objectiveID;

    public LFObjectiveStateSoap() {
    }

    public static LFObjectiveStateSoap toSoapModel(LFObjectiveState model) {
        LFObjectiveStateSoap soapModel = new LFObjectiveStateSoap();

        soapModel.setId(model.getId());
        soapModel.setSatisfied(model.getSatisfied());
        soapModel.setNormalizedMeasure(model.getNormalizedMeasure());
        soapModel.setMapKey(model.getMapKey());
        soapModel.setActivityStateID(model.getActivityStateID());
        soapModel.setObjectiveID(model.getObjectiveID());

        return soapModel;
    }

    public static LFObjectiveStateSoap[] toSoapModels(LFObjectiveState[] models) {
        LFObjectiveStateSoap[] soapModels = new LFObjectiveStateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFObjectiveStateSoap[][] toSoapModels(
        LFObjectiveState[][] models) {
        LFObjectiveStateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFObjectiveStateSoap[models.length][models[0].length];
        } else {
            soapModels = new LFObjectiveStateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFObjectiveStateSoap[] toSoapModels(
        List<LFObjectiveState> models) {
        List<LFObjectiveStateSoap> soapModels = new ArrayList<LFObjectiveStateSoap>(models.size());

        for (LFObjectiveState model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFObjectiveStateSoap[soapModels.size()]);
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

    public Boolean getSatisfied() {
        return _satisfied;
    }

    public void setSatisfied(Boolean satisfied) {
        _satisfied = satisfied;
    }

    public BigDecimal getNormalizedMeasure() {
        return _normalizedMeasure;
    }

    public void setNormalizedMeasure(BigDecimal normalizedMeasure) {
        _normalizedMeasure = normalizedMeasure;
    }

    public String getMapKey() {
        return _mapKey;
    }

    public void setMapKey(String mapKey) {
        _mapKey = mapKey;
    }

    public Integer getActivityStateID() {
        return _activityStateID;
    }

    public void setActivityStateID(Integer activityStateID) {
        _activityStateID = activityStateID;
    }

    public Integer getObjectiveID() {
        return _objectiveID;
    }

    public void setObjectiveID(Integer objectiveID) {
        _objectiveID = objectiveID;
    }
}

package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFGlobalObjectiveStateSoap implements Serializable {
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private Boolean _attemptCompleted;
    private String _mapKey;
    private Integer _treeID;

    public LFGlobalObjectiveStateSoap() {
    }

    public static LFGlobalObjectiveStateSoap toSoapModel(
        LFGlobalObjectiveState model) {
        LFGlobalObjectiveStateSoap soapModel = new LFGlobalObjectiveStateSoap();

        soapModel.setId(model.getId());
        soapModel.setSatisfied(model.getSatisfied());
        soapModel.setNormalizedMeasure(model.getNormalizedMeasure());
        soapModel.setAttemptCompleted(model.getAttemptCompleted());
        soapModel.setMapKey(model.getMapKey());
        soapModel.setTreeID(model.getTreeID());

        return soapModel;
    }

    public static LFGlobalObjectiveStateSoap[] toSoapModels(
        LFGlobalObjectiveState[] models) {
        LFGlobalObjectiveStateSoap[] soapModels = new LFGlobalObjectiveStateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFGlobalObjectiveStateSoap[][] toSoapModels(
        LFGlobalObjectiveState[][] models) {
        LFGlobalObjectiveStateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFGlobalObjectiveStateSoap[models.length][models[0].length];
        } else {
            soapModels = new LFGlobalObjectiveStateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFGlobalObjectiveStateSoap[] toSoapModels(
        List<LFGlobalObjectiveState> models) {
        List<LFGlobalObjectiveStateSoap> soapModels = new ArrayList<LFGlobalObjectiveStateSoap>(models.size());

        for (LFGlobalObjectiveState model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFGlobalObjectiveStateSoap[soapModels.size()]);
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

    public Boolean getAttemptCompleted() {
        return _attemptCompleted;
    }

    public void setAttemptCompleted(Boolean attemptCompleted) {
        _attemptCompleted = attemptCompleted;
    }

    public String getMapKey() {
        return _mapKey;
    }

    public void setMapKey(String mapKey) {
        _mapKey = mapKey;
    }

    public Integer getTreeID() {
        return _treeID;
    }

    public void setTreeID(Integer treeID) {
        _treeID = treeID;
    }
}

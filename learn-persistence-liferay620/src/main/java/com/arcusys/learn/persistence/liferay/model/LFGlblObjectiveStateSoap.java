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
public class LFGlblObjectiveStateSoap implements Serializable {
    private long _id;
    private Boolean _satisfied;
    private BigDecimal _normalizedMeasure;
    private Boolean _attemptCompleted;
    private String _mapKey;
    private Integer _treeID;

    public LFGlblObjectiveStateSoap() {
    }

    public static LFGlblObjectiveStateSoap toSoapModel(
        LFGlblObjectiveState model) {
        LFGlblObjectiveStateSoap soapModel = new LFGlblObjectiveStateSoap();

        soapModel.setId(model.getId());
        soapModel.setSatisfied(model.getSatisfied());
        soapModel.setNormalizedMeasure(model.getNormalizedMeasure());
        soapModel.setAttemptCompleted(model.getAttemptCompleted());
        soapModel.setMapKey(model.getMapKey());
        soapModel.setTreeID(model.getTreeID());

        return soapModel;
    }

    public static LFGlblObjectiveStateSoap[] toSoapModels(
        LFGlblObjectiveState[] models) {
        LFGlblObjectiveStateSoap[] soapModels = new LFGlblObjectiveStateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFGlblObjectiveStateSoap[][] toSoapModels(
        LFGlblObjectiveState[][] models) {
        LFGlblObjectiveStateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFGlblObjectiveStateSoap[models.length][models[0].length];
        } else {
            soapModels = new LFGlblObjectiveStateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFGlblObjectiveStateSoap[] toSoapModels(
        List<LFGlblObjectiveState> models) {
        List<LFGlblObjectiveStateSoap> soapModels = new ArrayList<LFGlblObjectiveStateSoap>(models.size());

        for (LFGlblObjectiveState model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFGlblObjectiveStateSoap[soapModels.size()]);
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

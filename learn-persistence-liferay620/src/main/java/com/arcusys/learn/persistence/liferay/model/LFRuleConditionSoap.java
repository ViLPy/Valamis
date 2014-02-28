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
public class LFRuleConditionSoap implements Serializable {
    private long _id;
    private String _conditionType;
    private String _objectiveId;
    private BigDecimal _measureThreshold;
    private boolean _inverse;
    private Integer _rollupRuleID;
    private Integer _conditionRuleID;

    public LFRuleConditionSoap() {
    }

    public static LFRuleConditionSoap toSoapModel(LFRuleCondition model) {
        LFRuleConditionSoap soapModel = new LFRuleConditionSoap();

        soapModel.setId(model.getId());
        soapModel.setConditionType(model.getConditionType());
        soapModel.setObjectiveId(model.getObjectiveId());
        soapModel.setMeasureThreshold(model.getMeasureThreshold());
        soapModel.setInverse(model.getInverse());
        soapModel.setRollupRuleID(model.getRollupRuleID());
        soapModel.setConditionRuleID(model.getConditionRuleID());

        return soapModel;
    }

    public static LFRuleConditionSoap[] toSoapModels(LFRuleCondition[] models) {
        LFRuleConditionSoap[] soapModels = new LFRuleConditionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFRuleConditionSoap[][] toSoapModels(
        LFRuleCondition[][] models) {
        LFRuleConditionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFRuleConditionSoap[models.length][models[0].length];
        } else {
            soapModels = new LFRuleConditionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFRuleConditionSoap[] toSoapModels(
        List<LFRuleCondition> models) {
        List<LFRuleConditionSoap> soapModels = new ArrayList<LFRuleConditionSoap>(models.size());

        for (LFRuleCondition model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFRuleConditionSoap[soapModels.size()]);
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

    public String getConditionType() {
        return _conditionType;
    }

    public void setConditionType(String conditionType) {
        _conditionType = conditionType;
    }

    public String getObjectiveId() {
        return _objectiveId;
    }

    public void setObjectiveId(String objectiveId) {
        _objectiveId = objectiveId;
    }

    public BigDecimal getMeasureThreshold() {
        return _measureThreshold;
    }

    public void setMeasureThreshold(BigDecimal measureThreshold) {
        _measureThreshold = measureThreshold;
    }

    public boolean getInverse() {
        return _inverse;
    }

    public boolean isInverse() {
        return _inverse;
    }

    public void setInverse(boolean inverse) {
        _inverse = inverse;
    }

    public Integer getRollupRuleID() {
        return _rollupRuleID;
    }

    public void setRollupRuleID(Integer rollupRuleID) {
        _rollupRuleID = rollupRuleID;
    }

    public Integer getConditionRuleID() {
        return _conditionRuleID;
    }

    public void setConditionRuleID(Integer conditionRuleID) {
        _conditionRuleID = conditionRuleID;
    }
}

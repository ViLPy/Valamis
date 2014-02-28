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
public class LFConditionRuleSoap implements Serializable {
    private long _id;
    private Integer _sequencingID;
    private String _combination;
    private String _ruleType;
    private String _action;

    public LFConditionRuleSoap() {
    }

    public static LFConditionRuleSoap toSoapModel(LFConditionRule model) {
        LFConditionRuleSoap soapModel = new LFConditionRuleSoap();

        soapModel.setId(model.getId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setCombination(model.getCombination());
        soapModel.setRuleType(model.getRuleType());
        soapModel.setAction(model.getAction());

        return soapModel;
    }

    public static LFConditionRuleSoap[] toSoapModels(LFConditionRule[] models) {
        LFConditionRuleSoap[] soapModels = new LFConditionRuleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFConditionRuleSoap[][] toSoapModels(
        LFConditionRule[][] models) {
        LFConditionRuleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFConditionRuleSoap[models.length][models[0].length];
        } else {
            soapModels = new LFConditionRuleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFConditionRuleSoap[] toSoapModels(
        List<LFConditionRule> models) {
        List<LFConditionRuleSoap> soapModels = new ArrayList<LFConditionRuleSoap>(models.size());

        for (LFConditionRule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFConditionRuleSoap[soapModels.size()]);
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

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;
    }

    public String getCombination() {
        return _combination;
    }

    public void setCombination(String combination) {
        _combination = combination;
    }

    public String getRuleType() {
        return _ruleType;
    }

    public void setRuleType(String ruleType) {
        _ruleType = ruleType;
    }

    public String getAction() {
        return _action;
    }

    public void setAction(String action) {
        _action = action;
    }
}

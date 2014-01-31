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
public class LFRollupRuleSoap implements Serializable {
    private long _id;
    private Integer _sequencingID;
    private String _combination;
    private String _childActivitySet;
    private Integer _minimumCount;
    private BigDecimal _minimumPercent;
    private String _action;

    public LFRollupRuleSoap() {
    }

    public static LFRollupRuleSoap toSoapModel(LFRollupRule model) {
        LFRollupRuleSoap soapModel = new LFRollupRuleSoap();

        soapModel.setId(model.getId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setCombination(model.getCombination());
        soapModel.setChildActivitySet(model.getChildActivitySet());
        soapModel.setMinimumCount(model.getMinimumCount());
        soapModel.setMinimumPercent(model.getMinimumPercent());
        soapModel.setAction(model.getAction());

        return soapModel;
    }

    public static LFRollupRuleSoap[] toSoapModels(LFRollupRule[] models) {
        LFRollupRuleSoap[] soapModels = new LFRollupRuleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFRollupRuleSoap[][] toSoapModels(LFRollupRule[][] models) {
        LFRollupRuleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFRollupRuleSoap[models.length][models[0].length];
        } else {
            soapModels = new LFRollupRuleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFRollupRuleSoap[] toSoapModels(List<LFRollupRule> models) {
        List<LFRollupRuleSoap> soapModels = new ArrayList<LFRollupRuleSoap>(models.size());

        for (LFRollupRule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFRollupRuleSoap[soapModels.size()]);
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

    public String getChildActivitySet() {
        return _childActivitySet;
    }

    public void setChildActivitySet(String childActivitySet) {
        _childActivitySet = childActivitySet;
    }

    public Integer getMinimumCount() {
        return _minimumCount;
    }

    public void setMinimumCount(Integer minimumCount) {
        _minimumCount = minimumCount;
    }

    public BigDecimal getMinimumPercent() {
        return _minimumPercent;
    }

    public void setMinimumPercent(BigDecimal minimumPercent) {
        _minimumPercent = minimumPercent;
    }

    public String getAction() {
        return _action;
    }

    public void setAction(String action) {
        _action = action;
    }
}

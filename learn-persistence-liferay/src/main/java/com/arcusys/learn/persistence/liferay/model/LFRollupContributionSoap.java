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
public class LFRollupContributionSoap implements Serializable {
    private long _id;
    private Integer _sequencingID;
    private String _contributeToSatisfied;
    private String _contributeToNotSatisfied;
    private String _contributeToCompleted;
    private String _contributeToIncomplete;
    private BigDecimal _objectiveMeasureWeight;
    private boolean _measureSatisfactionIfActive;

    public LFRollupContributionSoap() {
    }

    public static LFRollupContributionSoap toSoapModel(
        LFRollupContribution model) {
        LFRollupContributionSoap soapModel = new LFRollupContributionSoap();

        soapModel.setId(model.getId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setContributeToSatisfied(model.getContributeToSatisfied());
        soapModel.setContributeToNotSatisfied(model.getContributeToNotSatisfied());
        soapModel.setContributeToCompleted(model.getContributeToCompleted());
        soapModel.setContributeToIncomplete(model.getContributeToIncomplete());
        soapModel.setObjectiveMeasureWeight(model.getObjectiveMeasureWeight());
        soapModel.setMeasureSatisfactionIfActive(model.getMeasureSatisfactionIfActive());

        return soapModel;
    }

    public static LFRollupContributionSoap[] toSoapModels(
        LFRollupContribution[] models) {
        LFRollupContributionSoap[] soapModels = new LFRollupContributionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFRollupContributionSoap[][] toSoapModels(
        LFRollupContribution[][] models) {
        LFRollupContributionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFRollupContributionSoap[models.length][models[0].length];
        } else {
            soapModels = new LFRollupContributionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFRollupContributionSoap[] toSoapModels(
        List<LFRollupContribution> models) {
        List<LFRollupContributionSoap> soapModels = new ArrayList<LFRollupContributionSoap>(models.size());

        for (LFRollupContribution model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFRollupContributionSoap[soapModels.size()]);
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

    public String getContributeToSatisfied() {
        return _contributeToSatisfied;
    }

    public void setContributeToSatisfied(String contributeToSatisfied) {
        _contributeToSatisfied = contributeToSatisfied;
    }

    public String getContributeToNotSatisfied() {
        return _contributeToNotSatisfied;
    }

    public void setContributeToNotSatisfied(String contributeToNotSatisfied) {
        _contributeToNotSatisfied = contributeToNotSatisfied;
    }

    public String getContributeToCompleted() {
        return _contributeToCompleted;
    }

    public void setContributeToCompleted(String contributeToCompleted) {
        _contributeToCompleted = contributeToCompleted;
    }

    public String getContributeToIncomplete() {
        return _contributeToIncomplete;
    }

    public void setContributeToIncomplete(String contributeToIncomplete) {
        _contributeToIncomplete = contributeToIncomplete;
    }

    public BigDecimal getObjectiveMeasureWeight() {
        return _objectiveMeasureWeight;
    }

    public void setObjectiveMeasureWeight(BigDecimal objectiveMeasureWeight) {
        _objectiveMeasureWeight = objectiveMeasureWeight;
    }

    public boolean getMeasureSatisfactionIfActive() {
        return _measureSatisfactionIfActive;
    }

    public boolean isMeasureSatisfactionIfActive() {
        return _measureSatisfactionIfActive;
    }

    public void setMeasureSatisfactionIfActive(
        boolean measureSatisfactionIfActive) {
        _measureSatisfactionIfActive = measureSatisfactionIfActive;
    }
}

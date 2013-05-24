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
public class LFObjectiveSoap implements Serializable {
    private long _lfId;
    private Integer _sequencingID;
    private boolean _satisfiedByMeasure;
    private String _identifier;
    private BigDecimal _minNormalizedMeasure;
    private Boolean _isPrimary;

    public LFObjectiveSoap() {
    }

    public static LFObjectiveSoap toSoapModel(LFObjective model) {
        LFObjectiveSoap soapModel = new LFObjectiveSoap();

        soapModel.setLfId(model.getLfId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setSatisfiedByMeasure(model.getSatisfiedByMeasure());
        soapModel.setIdentifier(model.getIdentifier());
        soapModel.setMinNormalizedMeasure(model.getMinNormalizedMeasure());
        soapModel.setIsPrimary(model.getIsPrimary());

        return soapModel;
    }

    public static LFObjectiveSoap[] toSoapModels(LFObjective[] models) {
        LFObjectiveSoap[] soapModels = new LFObjectiveSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFObjectiveSoap[][] toSoapModels(LFObjective[][] models) {
        LFObjectiveSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFObjectiveSoap[models.length][models[0].length];
        } else {
            soapModels = new LFObjectiveSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFObjectiveSoap[] toSoapModels(List<LFObjective> models) {
        List<LFObjectiveSoap> soapModels = new ArrayList<LFObjectiveSoap>(models.size());

        for (LFObjective model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFObjectiveSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _lfId;
    }

    public void setPrimaryKey(long pk) {
        setLfId(pk);
    }

    public long getLfId() {
        return _lfId;
    }

    public void setLfId(long lfId) {
        _lfId = lfId;
    }

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;
    }

    public boolean getSatisfiedByMeasure() {
        return _satisfiedByMeasure;
    }

    public boolean isSatisfiedByMeasure() {
        return _satisfiedByMeasure;
    }

    public void setSatisfiedByMeasure(boolean satisfiedByMeasure) {
        _satisfiedByMeasure = satisfiedByMeasure;
    }

    public String getIdentifier() {
        return _identifier;
    }

    public void setIdentifier(String identifier) {
        _identifier = identifier;
    }

    public BigDecimal getMinNormalizedMeasure() {
        return _minNormalizedMeasure;
    }

    public void setMinNormalizedMeasure(BigDecimal minNormalizedMeasure) {
        _minNormalizedMeasure = minNormalizedMeasure;
    }

    public Boolean getIsPrimary() {
        return _isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        _isPrimary = isPrimary;
    }
}

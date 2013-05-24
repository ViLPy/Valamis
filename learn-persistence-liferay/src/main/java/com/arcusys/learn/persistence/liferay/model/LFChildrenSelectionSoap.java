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
public class LFChildrenSelectionSoap implements Serializable {
    private long _id;
    private Integer _sequencingID;
    private Integer _takeCount;
    private String _takeTimingOnEachAttempt;
    private String _reorderOnEachAttempt;

    public LFChildrenSelectionSoap() {
    }

    public static LFChildrenSelectionSoap toSoapModel(LFChildrenSelection model) {
        LFChildrenSelectionSoap soapModel = new LFChildrenSelectionSoap();

        soapModel.setId(model.getId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setTakeCount(model.getTakeCount());
        soapModel.setTakeTimingOnEachAttempt(model.getTakeTimingOnEachAttempt());
        soapModel.setReorderOnEachAttempt(model.getReorderOnEachAttempt());

        return soapModel;
    }

    public static LFChildrenSelectionSoap[] toSoapModels(
        LFChildrenSelection[] models) {
        LFChildrenSelectionSoap[] soapModels = new LFChildrenSelectionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFChildrenSelectionSoap[][] toSoapModels(
        LFChildrenSelection[][] models) {
        LFChildrenSelectionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFChildrenSelectionSoap[models.length][models[0].length];
        } else {
            soapModels = new LFChildrenSelectionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFChildrenSelectionSoap[] toSoapModels(
        List<LFChildrenSelection> models) {
        List<LFChildrenSelectionSoap> soapModels = new ArrayList<LFChildrenSelectionSoap>(models.size());

        for (LFChildrenSelection model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFChildrenSelectionSoap[soapModels.size()]);
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

    public Integer getTakeCount() {
        return _takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        _takeCount = takeCount;
    }

    public String getTakeTimingOnEachAttempt() {
        return _takeTimingOnEachAttempt;
    }

    public void setTakeTimingOnEachAttempt(String takeTimingOnEachAttempt) {
        _takeTimingOnEachAttempt = takeTimingOnEachAttempt;
    }

    public String getReorderOnEachAttempt() {
        return _reorderOnEachAttempt;
    }

    public void setReorderOnEachAttempt(String reorderOnEachAttempt) {
        _reorderOnEachAttempt = reorderOnEachAttempt;
    }
}

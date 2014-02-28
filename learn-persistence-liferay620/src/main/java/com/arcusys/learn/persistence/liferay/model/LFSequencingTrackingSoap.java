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
public class LFSequencingTrackingSoap implements Serializable {
    private long _id;
    private Integer _sequencingID;
    private boolean _completionSetByContent;
    private boolean _objectiveSetByContent;

    public LFSequencingTrackingSoap() {
    }

    public static LFSequencingTrackingSoap toSoapModel(
        LFSequencingTracking model) {
        LFSequencingTrackingSoap soapModel = new LFSequencingTrackingSoap();

        soapModel.setId(model.getId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setCompletionSetByContent(model.getCompletionSetByContent());
        soapModel.setObjectiveSetByContent(model.getObjectiveSetByContent());

        return soapModel;
    }

    public static LFSequencingTrackingSoap[] toSoapModels(
        LFSequencingTracking[] models) {
        LFSequencingTrackingSoap[] soapModels = new LFSequencingTrackingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSequencingTrackingSoap[][] toSoapModels(
        LFSequencingTracking[][] models) {
        LFSequencingTrackingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSequencingTrackingSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSequencingTrackingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSequencingTrackingSoap[] toSoapModels(
        List<LFSequencingTracking> models) {
        List<LFSequencingTrackingSoap> soapModels = new ArrayList<LFSequencingTrackingSoap>(models.size());

        for (LFSequencingTracking model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSequencingTrackingSoap[soapModels.size()]);
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

    public boolean getCompletionSetByContent() {
        return _completionSetByContent;
    }

    public boolean isCompletionSetByContent() {
        return _completionSetByContent;
    }

    public void setCompletionSetByContent(boolean completionSetByContent) {
        _completionSetByContent = completionSetByContent;
    }

    public boolean getObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    public boolean isObjectiveSetByContent() {
        return _objectiveSetByContent;
    }

    public void setObjectiveSetByContent(boolean objectiveSetByContent) {
        _objectiveSetByContent = objectiveSetByContent;
    }
}

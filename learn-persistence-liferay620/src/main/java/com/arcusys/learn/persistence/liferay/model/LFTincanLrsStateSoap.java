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
public class LFTincanLrsStateSoap implements Serializable {
    private long _id;
    private String _stateId;
    private String _documentId;
    private String _activityId;
    private String _registration;
    private Integer _agentId;

    public LFTincanLrsStateSoap() {
    }

    public static LFTincanLrsStateSoap toSoapModel(LFTincanLrsState model) {
        LFTincanLrsStateSoap soapModel = new LFTincanLrsStateSoap();

        soapModel.setId(model.getId());
        soapModel.setStateId(model.getStateId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setActivityId(model.getActivityId());
        soapModel.setRegistration(model.getRegistration());
        soapModel.setAgentId(model.getAgentId());

        return soapModel;
    }

    public static LFTincanLrsStateSoap[] toSoapModels(LFTincanLrsState[] models) {
        LFTincanLrsStateSoap[] soapModels = new LFTincanLrsStateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsStateSoap[][] toSoapModels(
        LFTincanLrsState[][] models) {
        LFTincanLrsStateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsStateSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsStateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsStateSoap[] toSoapModels(
        List<LFTincanLrsState> models) {
        List<LFTincanLrsStateSoap> soapModels = new ArrayList<LFTincanLrsStateSoap>(models.size());

        for (LFTincanLrsState model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsStateSoap[soapModels.size()]);
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

    public String getStateId() {
        return _stateId;
    }

    public void setStateId(String stateId) {
        _stateId = stateId;
    }

    public String getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(String documentId) {
        _documentId = documentId;
    }

    public String getActivityId() {
        return _activityId;
    }

    public void setActivityId(String activityId) {
        _activityId = activityId;
    }

    public String getRegistration() {
        return _registration;
    }

    public void setRegistration(String registration) {
        _registration = registration;
    }

    public Integer getAgentId() {
        return _agentId;
    }

    public void setAgentId(Integer agentId) {
        _agentId = agentId;
    }
}

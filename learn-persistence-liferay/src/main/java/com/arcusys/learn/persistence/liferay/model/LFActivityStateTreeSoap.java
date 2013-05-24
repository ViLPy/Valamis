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
public class LFActivityStateTreeSoap implements Serializable {
    private long _id;
    private String _currentActivityID;
    private String _suspendedActivityID;
    private Integer _attemptID;

    public LFActivityStateTreeSoap() {
    }

    public static LFActivityStateTreeSoap toSoapModel(LFActivityStateTree model) {
        LFActivityStateTreeSoap soapModel = new LFActivityStateTreeSoap();

        soapModel.setId(model.getId());
        soapModel.setCurrentActivityID(model.getCurrentActivityID());
        soapModel.setSuspendedActivityID(model.getSuspendedActivityID());
        soapModel.setAttemptID(model.getAttemptID());

        return soapModel;
    }

    public static LFActivityStateTreeSoap[] toSoapModels(
        LFActivityStateTree[] models) {
        LFActivityStateTreeSoap[] soapModels = new LFActivityStateTreeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFActivityStateTreeSoap[][] toSoapModels(
        LFActivityStateTree[][] models) {
        LFActivityStateTreeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFActivityStateTreeSoap[models.length][models[0].length];
        } else {
            soapModels = new LFActivityStateTreeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFActivityStateTreeSoap[] toSoapModels(
        List<LFActivityStateTree> models) {
        List<LFActivityStateTreeSoap> soapModels = new ArrayList<LFActivityStateTreeSoap>(models.size());

        for (LFActivityStateTree model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFActivityStateTreeSoap[soapModels.size()]);
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

    public String getCurrentActivityID() {
        return _currentActivityID;
    }

    public void setCurrentActivityID(String currentActivityID) {
        _currentActivityID = currentActivityID;
    }

    public String getSuspendedActivityID() {
        return _suspendedActivityID;
    }

    public void setSuspendedActivityID(String suspendedActivityID) {
        _suspendedActivityID = suspendedActivityID;
    }

    public Integer getAttemptID() {
        return _attemptID;
    }

    public void setAttemptID(Integer attemptID) {
        _attemptID = attemptID;
    }
}

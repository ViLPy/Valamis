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
public class LFAttemptDataSoap implements Serializable {
    private long _id;
    private String _dataKey;
    private String _dataValue;
    private Integer _attemptID;
    private String _activityID;

    public LFAttemptDataSoap() {
    }

    public static LFAttemptDataSoap toSoapModel(LFAttemptData model) {
        LFAttemptDataSoap soapModel = new LFAttemptDataSoap();

        soapModel.setId(model.getId());
        soapModel.setDataKey(model.getDataKey());
        soapModel.setDataValue(model.getDataValue());
        soapModel.setAttemptID(model.getAttemptID());
        soapModel.setActivityID(model.getActivityID());

        return soapModel;
    }

    public static LFAttemptDataSoap[] toSoapModels(LFAttemptData[] models) {
        LFAttemptDataSoap[] soapModels = new LFAttemptDataSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFAttemptDataSoap[][] toSoapModels(LFAttemptData[][] models) {
        LFAttemptDataSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFAttemptDataSoap[models.length][models[0].length];
        } else {
            soapModels = new LFAttemptDataSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFAttemptDataSoap[] toSoapModels(List<LFAttemptData> models) {
        List<LFAttemptDataSoap> soapModels = new ArrayList<LFAttemptDataSoap>(models.size());

        for (LFAttemptData model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFAttemptDataSoap[soapModels.size()]);
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

    public String getDataKey() {
        return _dataKey;
    }

    public void setDataKey(String dataKey) {
        _dataKey = dataKey;
    }

    public String getDataValue() {
        return _dataValue;
    }

    public void setDataValue(String dataValue) {
        _dataValue = dataValue;
    }

    public Integer getAttemptID() {
        return _attemptID;
    }

    public void setAttemptID(Integer attemptID) {
        _attemptID = attemptID;
    }

    public String getActivityID() {
        return _activityID;
    }

    public void setActivityID(String activityID) {
        _activityID = activityID;
    }
}

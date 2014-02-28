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
public class LFRequiredActivitySoap implements Serializable {
    private long _id;
    private Integer _achievementId;
    private String _activityClassName;
    private Integer _numberActivitiesRequired;

    public LFRequiredActivitySoap() {
    }

    public static LFRequiredActivitySoap toSoapModel(LFRequiredActivity model) {
        LFRequiredActivitySoap soapModel = new LFRequiredActivitySoap();

        soapModel.setId(model.getId());
        soapModel.setAchievementId(model.getAchievementId());
        soapModel.setActivityClassName(model.getActivityClassName());
        soapModel.setNumberActivitiesRequired(model.getNumberActivitiesRequired());

        return soapModel;
    }

    public static LFRequiredActivitySoap[] toSoapModels(
        LFRequiredActivity[] models) {
        LFRequiredActivitySoap[] soapModels = new LFRequiredActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFRequiredActivitySoap[][] toSoapModels(
        LFRequiredActivity[][] models) {
        LFRequiredActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFRequiredActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFRequiredActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFRequiredActivitySoap[] toSoapModels(
        List<LFRequiredActivity> models) {
        List<LFRequiredActivitySoap> soapModels = new ArrayList<LFRequiredActivitySoap>(models.size());

        for (LFRequiredActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFRequiredActivitySoap[soapModels.size()]);
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

    public Integer getAchievementId() {
        return _achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        _achievementId = achievementId;
    }

    public String getActivityClassName() {
        return _activityClassName;
    }

    public void setActivityClassName(String activityClassName) {
        _activityClassName = activityClassName;
    }

    public Integer getNumberActivitiesRequired() {
        return _numberActivitiesRequired;
    }

    public void setNumberActivitiesRequired(Integer numberActivitiesRequired) {
        _numberActivitiesRequired = numberActivitiesRequired;
    }
}

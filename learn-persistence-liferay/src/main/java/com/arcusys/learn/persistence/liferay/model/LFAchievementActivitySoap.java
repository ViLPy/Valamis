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
public class LFAchievementActivitySoap implements Serializable {
    private long _id;
    private Integer _userId;
    private Integer _achievementId;

    public LFAchievementActivitySoap() {
    }

    public static LFAchievementActivitySoap toSoapModel(
        LFAchievementActivity model) {
        LFAchievementActivitySoap soapModel = new LFAchievementActivitySoap();

        soapModel.setId(model.getId());
        soapModel.setUserId(model.getUserId());
        soapModel.setAchievementId(model.getAchievementId());

        return soapModel;
    }

    public static LFAchievementActivitySoap[] toSoapModels(
        LFAchievementActivity[] models) {
        LFAchievementActivitySoap[] soapModels = new LFAchievementActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFAchievementActivitySoap[][] toSoapModels(
        LFAchievementActivity[][] models) {
        LFAchievementActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFAchievementActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFAchievementActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFAchievementActivitySoap[] toSoapModels(
        List<LFAchievementActivity> models) {
        List<LFAchievementActivitySoap> soapModels = new ArrayList<LFAchievementActivitySoap>(models.size());

        for (LFAchievementActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFAchievementActivitySoap[soapModels.size()]);
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

    public Integer getUserId() {
        return _userId;
    }

    public void setUserId(Integer userId) {
        _userId = userId;
    }

    public Integer getAchievementId() {
        return _achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        _achievementId = achievementId;
    }
}

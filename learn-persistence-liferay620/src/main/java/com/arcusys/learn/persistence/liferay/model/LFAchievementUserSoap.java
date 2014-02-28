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
public class LFAchievementUserSoap implements Serializable {
    private long _id;
    private Integer _userId;
    private Integer _achievementId;

    public LFAchievementUserSoap() {
    }

    public static LFAchievementUserSoap toSoapModel(LFAchievementUser model) {
        LFAchievementUserSoap soapModel = new LFAchievementUserSoap();

        soapModel.setId(model.getId());
        soapModel.setUserId(model.getUserId());
        soapModel.setAchievementId(model.getAchievementId());

        return soapModel;
    }

    public static LFAchievementUserSoap[] toSoapModels(
        LFAchievementUser[] models) {
        LFAchievementUserSoap[] soapModels = new LFAchievementUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFAchievementUserSoap[][] toSoapModels(
        LFAchievementUser[][] models) {
        LFAchievementUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFAchievementUserSoap[models.length][models[0].length];
        } else {
            soapModels = new LFAchievementUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFAchievementUserSoap[] toSoapModels(
        List<LFAchievementUser> models) {
        List<LFAchievementUserSoap> soapModels = new ArrayList<LFAchievementUserSoap>(models.size());

        for (LFAchievementUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFAchievementUserSoap[soapModels.size()]);
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

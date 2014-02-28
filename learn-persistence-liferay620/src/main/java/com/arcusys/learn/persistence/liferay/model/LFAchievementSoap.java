package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFAchievementSoap implements Serializable {
    private long _id;
    private String _title;
    private String _description;
    private String _logo;
    private Date _creationDate;

    public LFAchievementSoap() {
    }

    public static LFAchievementSoap toSoapModel(LFAchievement model) {
        LFAchievementSoap soapModel = new LFAchievementSoap();

        soapModel.setId(model.getId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setLogo(model.getLogo());
        soapModel.setCreationDate(model.getCreationDate());

        return soapModel;
    }

    public static LFAchievementSoap[] toSoapModels(LFAchievement[] models) {
        LFAchievementSoap[] soapModels = new LFAchievementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFAchievementSoap[][] toSoapModels(LFAchievement[][] models) {
        LFAchievementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFAchievementSoap[models.length][models[0].length];
        } else {
            soapModels = new LFAchievementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFAchievementSoap[] toSoapModels(List<LFAchievement> models) {
        List<LFAchievementSoap> soapModels = new ArrayList<LFAchievementSoap>(models.size());

        for (LFAchievement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFAchievementSoap[soapModels.size()]);
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

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getLogo() {
        return _logo;
    }

    public void setLogo(String logo) {
        _logo = logo;
    }

    public Date getCreationDate() {
        return _creationDate;
    }

    public void setCreationDate(Date creationDate) {
        _creationDate = creationDate;
    }
}

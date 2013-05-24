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
public class LFUserSoap implements Serializable {
    private long _lfid;
    private Integer _id;
    private String _name;
    private Double _preferredAudioLevel;
    private String _preferredLanguage;
    private Double _preferredDeliverySpeed;
    private Integer _preferredAudioCaptioning;

    public LFUserSoap() {
    }

    public static LFUserSoap toSoapModel(LFUser model) {
        LFUserSoap soapModel = new LFUserSoap();

        soapModel.setLfid(model.getLfid());
        soapModel.setId(model.getId());
        soapModel.setName(model.getName());
        soapModel.setPreferredAudioLevel(model.getPreferredAudioLevel());
        soapModel.setPreferredLanguage(model.getPreferredLanguage());
        soapModel.setPreferredDeliverySpeed(model.getPreferredDeliverySpeed());
        soapModel.setPreferredAudioCaptioning(model.getPreferredAudioCaptioning());

        return soapModel;
    }

    public static LFUserSoap[] toSoapModels(LFUser[] models) {
        LFUserSoap[] soapModels = new LFUserSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFUserSoap[][] toSoapModels(LFUser[][] models) {
        LFUserSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFUserSoap[models.length][models[0].length];
        } else {
            soapModels = new LFUserSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFUserSoap[] toSoapModels(List<LFUser> models) {
        List<LFUserSoap> soapModels = new ArrayList<LFUserSoap>(models.size());

        for (LFUser model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFUserSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _lfid;
    }

    public void setPrimaryKey(long pk) {
        setLfid(pk);
    }

    public long getLfid() {
        return _lfid;
    }

    public void setLfid(long lfid) {
        _lfid = lfid;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Double getPreferredAudioLevel() {
        return _preferredAudioLevel;
    }

    public void setPreferredAudioLevel(Double preferredAudioLevel) {
        _preferredAudioLevel = preferredAudioLevel;
    }

    public String getPreferredLanguage() {
        return _preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        _preferredLanguage = preferredLanguage;
    }

    public Double getPreferredDeliverySpeed() {
        return _preferredDeliverySpeed;
    }

    public void setPreferredDeliverySpeed(Double preferredDeliverySpeed) {
        _preferredDeliverySpeed = preferredDeliverySpeed;
    }

    public Integer getPreferredAudioCaptioning() {
        return _preferredAudioCaptioning;
    }

    public void setPreferredAudioCaptioning(Integer preferredAudioCaptioning) {
        _preferredAudioCaptioning = preferredAudioCaptioning;
    }
}

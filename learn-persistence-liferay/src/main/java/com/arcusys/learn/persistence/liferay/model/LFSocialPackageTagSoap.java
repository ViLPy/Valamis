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
public class LFSocialPackageTagSoap implements Serializable {
    private long _id;
    private Integer _socialPackageID;
    private String _name;

    public LFSocialPackageTagSoap() {
    }

    public static LFSocialPackageTagSoap toSoapModel(LFSocialPackageTag model) {
        LFSocialPackageTagSoap soapModel = new LFSocialPackageTagSoap();

        soapModel.setId(model.getId());
        soapModel.setSocialPackageID(model.getSocialPackageID());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static LFSocialPackageTagSoap[] toSoapModels(
        LFSocialPackageTag[] models) {
        LFSocialPackageTagSoap[] soapModels = new LFSocialPackageTagSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSocialPackageTagSoap[][] toSoapModels(
        LFSocialPackageTag[][] models) {
        LFSocialPackageTagSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSocialPackageTagSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSocialPackageTagSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSocialPackageTagSoap[] toSoapModels(
        List<LFSocialPackageTag> models) {
        List<LFSocialPackageTagSoap> soapModels = new ArrayList<LFSocialPackageTagSoap>(models.size());

        for (LFSocialPackageTag model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSocialPackageTagSoap[soapModels.size()]);
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

    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    public void setSocialPackageID(Integer socialPackageID) {
        _socialPackageID = socialPackageID;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}

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
public class LFSocialPackageSoap implements Serializable {
    private long _id;
    private Integer _packageID;
    private String _aboutPackage;
    private Date _publishDate;
    private Integer _authorID;

    public LFSocialPackageSoap() {
    }

    public static LFSocialPackageSoap toSoapModel(LFSocialPackage model) {
        LFSocialPackageSoap soapModel = new LFSocialPackageSoap();

        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setAboutPackage(model.getAboutPackage());
        soapModel.setPublishDate(model.getPublishDate());
        soapModel.setAuthorID(model.getAuthorID());

        return soapModel;
    }

    public static LFSocialPackageSoap[] toSoapModels(LFSocialPackage[] models) {
        LFSocialPackageSoap[] soapModels = new LFSocialPackageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSocialPackageSoap[][] toSoapModels(
        LFSocialPackage[][] models) {
        LFSocialPackageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSocialPackageSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSocialPackageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSocialPackageSoap[] toSoapModels(
        List<LFSocialPackage> models) {
        List<LFSocialPackageSoap> soapModels = new ArrayList<LFSocialPackageSoap>(models.size());

        for (LFSocialPackage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSocialPackageSoap[soapModels.size()]);
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

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getAboutPackage() {
        return _aboutPackage;
    }

    public void setAboutPackage(String aboutPackage) {
        _aboutPackage = aboutPackage;
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;
    }

    public Integer getAuthorID() {
        return _authorID;
    }

    public void setAuthorID(Integer authorID) {
        _authorID = authorID;
    }
}

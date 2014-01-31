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
public class LFPackageCommentSoap implements Serializable {
    private long _id;
    private Integer _socialPackageID;
    private Integer _authorID;
    private String _comment;
    private Date _publishDate;

    public LFPackageCommentSoap() {
    }

    public static LFPackageCommentSoap toSoapModel(LFPackageComment model) {
        LFPackageCommentSoap soapModel = new LFPackageCommentSoap();

        soapModel.setId(model.getId());
        soapModel.setSocialPackageID(model.getSocialPackageID());
        soapModel.setAuthorID(model.getAuthorID());
        soapModel.setComment(model.getComment());
        soapModel.setPublishDate(model.getPublishDate());

        return soapModel;
    }

    public static LFPackageCommentSoap[] toSoapModels(LFPackageComment[] models) {
        LFPackageCommentSoap[] soapModels = new LFPackageCommentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFPackageCommentSoap[][] toSoapModels(
        LFPackageComment[][] models) {
        LFPackageCommentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFPackageCommentSoap[models.length][models[0].length];
        } else {
            soapModels = new LFPackageCommentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFPackageCommentSoap[] toSoapModels(
        List<LFPackageComment> models) {
        List<LFPackageCommentSoap> soapModels = new ArrayList<LFPackageCommentSoap>(models.size());

        for (LFPackageComment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFPackageCommentSoap[soapModels.size()]);
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

    public Integer getAuthorID() {
        return _authorID;
    }

    public void setAuthorID(Integer authorID) {
        _authorID = authorID;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        _comment = comment;
    }

    public Date getPublishDate() {
        return _publishDate;
    }

    public void setPublishDate(Date publishDate) {
        _publishDate = publishDate;
    }
}

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
public class LFTincanActProfileSoap implements Serializable {
    private long _id;
    private Integer _documentId;
    private String _activityId;
    private String _profileId;

    public LFTincanActProfileSoap() {
    }

    public static LFTincanActProfileSoap toSoapModel(LFTincanActProfile model) {
        LFTincanActProfileSoap soapModel = new LFTincanActProfileSoap();

        soapModel.setId(model.getId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setActivityId(model.getActivityId());
        soapModel.setProfileId(model.getProfileId());

        return soapModel;
    }

    public static LFTincanActProfileSoap[] toSoapModels(
        LFTincanActProfile[] models) {
        LFTincanActProfileSoap[] soapModels = new LFTincanActProfileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanActProfileSoap[][] toSoapModels(
        LFTincanActProfile[][] models) {
        LFTincanActProfileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanActProfileSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanActProfileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanActProfileSoap[] toSoapModels(
        List<LFTincanActProfile> models) {
        List<LFTincanActProfileSoap> soapModels = new ArrayList<LFTincanActProfileSoap>(models.size());

        for (LFTincanActProfile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanActProfileSoap[soapModels.size()]);
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

    public Integer getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(Integer documentId) {
        _documentId = documentId;
    }

    public String getActivityId() {
        return _activityId;
    }

    public void setActivityId(String activityId) {
        _activityId = activityId;
    }

    public String getProfileId() {
        return _profileId;
    }

    public void setProfileId(String profileId) {
        _profileId = profileId;
    }
}

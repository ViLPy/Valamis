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
public class LFTincanLrsActivityProfileSoap implements Serializable {
    private long _id;
    private Integer _documentId;
    private String _activityId;
    private String _profileId;

    public LFTincanLrsActivityProfileSoap() {
    }

    public static LFTincanLrsActivityProfileSoap toSoapModel(
        LFTincanLrsActivityProfile model) {
        LFTincanLrsActivityProfileSoap soapModel = new LFTincanLrsActivityProfileSoap();

        soapModel.setId(model.getId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setActivityId(model.getActivityId());
        soapModel.setProfileId(model.getProfileId());

        return soapModel;
    }

    public static LFTincanLrsActivityProfileSoap[] toSoapModels(
        LFTincanLrsActivityProfile[] models) {
        LFTincanLrsActivityProfileSoap[] soapModels = new LFTincanLrsActivityProfileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsActivityProfileSoap[][] toSoapModels(
        LFTincanLrsActivityProfile[][] models) {
        LFTincanLrsActivityProfileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsActivityProfileSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsActivityProfileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsActivityProfileSoap[] toSoapModels(
        List<LFTincanLrsActivityProfile> models) {
        List<LFTincanLrsActivityProfileSoap> soapModels = new ArrayList<LFTincanLrsActivityProfileSoap>(models.size());

        for (LFTincanLrsActivityProfile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsActivityProfileSoap[soapModels.size()]);
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

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
public class LFAttemptSoap implements Serializable {
    private long _id;
    private Integer _userID;
    private Integer _packageID;
    private String _organizationID;
    private Boolean _isComplete;

    public LFAttemptSoap() {
    }

    public static LFAttemptSoap toSoapModel(LFAttempt model) {
        LFAttemptSoap soapModel = new LFAttemptSoap();

        soapModel.setId(model.getId());
        soapModel.setUserID(model.getUserID());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setOrganizationID(model.getOrganizationID());
        soapModel.setIsComplete(model.getIsComplete());

        return soapModel;
    }

    public static LFAttemptSoap[] toSoapModels(LFAttempt[] models) {
        LFAttemptSoap[] soapModels = new LFAttemptSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFAttemptSoap[][] toSoapModels(LFAttempt[][] models) {
        LFAttemptSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFAttemptSoap[models.length][models[0].length];
        } else {
            soapModels = new LFAttemptSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFAttemptSoap[] toSoapModels(List<LFAttempt> models) {
        List<LFAttemptSoap> soapModels = new ArrayList<LFAttemptSoap>(models.size());

        for (LFAttempt model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFAttemptSoap[soapModels.size()]);
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

    public Integer getUserID() {
        return _userID;
    }

    public void setUserID(Integer userID) {
        _userID = userID;
    }

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getOrganizationID() {
        return _organizationID;
    }

    public void setOrganizationID(String organizationID) {
        _organizationID = organizationID;
    }

    public Boolean getIsComplete() {
        return _isComplete;
    }

    public void setIsComplete(Boolean isComplete) {
        _isComplete = isComplete;
    }
}

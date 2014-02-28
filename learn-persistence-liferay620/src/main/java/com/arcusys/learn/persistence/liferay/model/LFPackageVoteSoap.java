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
public class LFPackageVoteSoap implements Serializable {
    private long _id;
    private Integer _userID;
    private Integer _socialPackageID;
    private Integer _voteValue;

    public LFPackageVoteSoap() {
    }

    public static LFPackageVoteSoap toSoapModel(LFPackageVote model) {
        LFPackageVoteSoap soapModel = new LFPackageVoteSoap();

        soapModel.setId(model.getId());
        soapModel.setUserID(model.getUserID());
        soapModel.setSocialPackageID(model.getSocialPackageID());
        soapModel.setVoteValue(model.getVoteValue());

        return soapModel;
    }

    public static LFPackageVoteSoap[] toSoapModels(LFPackageVote[] models) {
        LFPackageVoteSoap[] soapModels = new LFPackageVoteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFPackageVoteSoap[][] toSoapModels(LFPackageVote[][] models) {
        LFPackageVoteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFPackageVoteSoap[models.length][models[0].length];
        } else {
            soapModels = new LFPackageVoteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFPackageVoteSoap[] toSoapModels(List<LFPackageVote> models) {
        List<LFPackageVoteSoap> soapModels = new ArrayList<LFPackageVoteSoap>(models.size());

        for (LFPackageVote model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFPackageVoteSoap[soapModels.size()]);
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

    public Integer getSocialPackageID() {
        return _socialPackageID;
    }

    public void setSocialPackageID(Integer socialPackageID) {
        _socialPackageID = socialPackageID;
    }

    public Integer getVoteValue() {
        return _voteValue;
    }

    public void setVoteValue(Integer voteValue) {
        _voteValue = voteValue;
    }
}

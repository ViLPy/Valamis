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
public class LFTincanLrsResultSoap implements Serializable {
    private long _id;
    private String _score;
    private Boolean _success;
    private Boolean _completion;
    private String _response;
    private Double _duration;
    private String _extension;

    public LFTincanLrsResultSoap() {
    }

    public static LFTincanLrsResultSoap toSoapModel(LFTincanLrsResult model) {
        LFTincanLrsResultSoap soapModel = new LFTincanLrsResultSoap();

        soapModel.setId(model.getId());
        soapModel.setScore(model.getScore());
        soapModel.setSuccess(model.getSuccess());
        soapModel.setCompletion(model.getCompletion());
        soapModel.setResponse(model.getResponse());
        soapModel.setDuration(model.getDuration());
        soapModel.setExtension(model.getExtension());

        return soapModel;
    }

    public static LFTincanLrsResultSoap[] toSoapModels(
        LFTincanLrsResult[] models) {
        LFTincanLrsResultSoap[] soapModels = new LFTincanLrsResultSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsResultSoap[][] toSoapModels(
        LFTincanLrsResult[][] models) {
        LFTincanLrsResultSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsResultSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsResultSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsResultSoap[] toSoapModels(
        List<LFTincanLrsResult> models) {
        List<LFTincanLrsResultSoap> soapModels = new ArrayList<LFTincanLrsResultSoap>(models.size());

        for (LFTincanLrsResult model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsResultSoap[soapModels.size()]);
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

    public String getScore() {
        return _score;
    }

    public void setScore(String score) {
        _score = score;
    }

    public Boolean getSuccess() {
        return _success;
    }

    public void setSuccess(Boolean success) {
        _success = success;
    }

    public Boolean getCompletion() {
        return _completion;
    }

    public void setCompletion(Boolean completion) {
        _completion = completion;
    }

    public String getResponse() {
        return _response;
    }

    public void setResponse(String response) {
        _response = response;
    }

    public Double getDuration() {
        return _duration;
    }

    public void setDuration(Double duration) {
        _duration = duration;
    }

    public String getExtension() {
        return _extension;
    }

    public void setExtension(String extension) {
        _extension = extension;
    }
}

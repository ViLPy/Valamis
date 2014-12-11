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
public class LFQuizAnswerScoreSoap implements Serializable {
    private long _answerId;
    private Double _score;

    public LFQuizAnswerScoreSoap() {
    }

    public static LFQuizAnswerScoreSoap toSoapModel(LFQuizAnswerScore model) {
        LFQuizAnswerScoreSoap soapModel = new LFQuizAnswerScoreSoap();

        soapModel.setAnswerId(model.getAnswerId());
        soapModel.setScore(model.getScore());

        return soapModel;
    }

    public static LFQuizAnswerScoreSoap[] toSoapModels(
        LFQuizAnswerScore[] models) {
        LFQuizAnswerScoreSoap[] soapModels = new LFQuizAnswerScoreSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuizAnswerScoreSoap[][] toSoapModels(
        LFQuizAnswerScore[][] models) {
        LFQuizAnswerScoreSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuizAnswerScoreSoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuizAnswerScoreSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuizAnswerScoreSoap[] toSoapModels(
        List<LFQuizAnswerScore> models) {
        List<LFQuizAnswerScoreSoap> soapModels = new ArrayList<LFQuizAnswerScoreSoap>(models.size());

        for (LFQuizAnswerScore model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuizAnswerScoreSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _answerId;
    }

    public void setPrimaryKey(long pk) {
        setAnswerId(pk);
    }

    public long getAnswerId() {
        return _answerId;
    }

    public void setAnswerId(long answerId) {
        _answerId = answerId;
    }

    public Double getScore() {
        return _score;
    }

    public void setScore(Double score) {
        _score = score;
    }
}

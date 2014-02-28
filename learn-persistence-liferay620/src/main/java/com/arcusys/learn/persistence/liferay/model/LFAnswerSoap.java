package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFAnswerSoap implements Serializable {
    private long _id;
    private String _description;
    private boolean _correct;
    private Integer _questionId;
    private BigDecimal _rangeFrom;
    private BigDecimal _rangeTo;
    private String _matchingText;
    private Integer _answerPosition;
    private Integer _answerType;

    public LFAnswerSoap() {
    }

    public static LFAnswerSoap toSoapModel(LFAnswer model) {
        LFAnswerSoap soapModel = new LFAnswerSoap();

        soapModel.setId(model.getId());
        soapModel.setDescription(model.getDescription());
        soapModel.setCorrect(model.getCorrect());
        soapModel.setQuestionId(model.getQuestionId());
        soapModel.setRangeFrom(model.getRangeFrom());
        soapModel.setRangeTo(model.getRangeTo());
        soapModel.setMatchingText(model.getMatchingText());
        soapModel.setAnswerPosition(model.getAnswerPosition());
        soapModel.setAnswerType(model.getAnswerType());

        return soapModel;
    }

    public static LFAnswerSoap[] toSoapModels(LFAnswer[] models) {
        LFAnswerSoap[] soapModels = new LFAnswerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFAnswerSoap[][] toSoapModels(LFAnswer[][] models) {
        LFAnswerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFAnswerSoap[models.length][models[0].length];
        } else {
            soapModels = new LFAnswerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFAnswerSoap[] toSoapModels(List<LFAnswer> models) {
        List<LFAnswerSoap> soapModels = new ArrayList<LFAnswerSoap>(models.size());

        for (LFAnswer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFAnswerSoap[soapModels.size()]);
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

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public boolean getCorrect() {
        return _correct;
    }

    public boolean isCorrect() {
        return _correct;
    }

    public void setCorrect(boolean correct) {
        _correct = correct;
    }

    public Integer getQuestionId() {
        return _questionId;
    }

    public void setQuestionId(Integer questionId) {
        _questionId = questionId;
    }

    public BigDecimal getRangeFrom() {
        return _rangeFrom;
    }

    public void setRangeFrom(BigDecimal rangeFrom) {
        _rangeFrom = rangeFrom;
    }

    public BigDecimal getRangeTo() {
        return _rangeTo;
    }

    public void setRangeTo(BigDecimal rangeTo) {
        _rangeTo = rangeTo;
    }

    public String getMatchingText() {
        return _matchingText;
    }

    public void setMatchingText(String matchingText) {
        _matchingText = matchingText;
    }

    public Integer getAnswerPosition() {
        return _answerPosition;
    }

    public void setAnswerPosition(Integer answerPosition) {
        _answerPosition = answerPosition;
    }

    public Integer getAnswerType() {
        return _answerType;
    }

    public void setAnswerType(Integer answerType) {
        _answerType = answerType;
    }
}

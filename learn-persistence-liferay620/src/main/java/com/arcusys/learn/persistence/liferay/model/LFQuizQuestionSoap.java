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
public class LFQuizQuestionSoap implements Serializable {
    private long _id;
    private Integer _quizId;
    private Integer _categoryId;
    private Integer _questionId;
    private String _questionType;
    private String _title;
    private String _url;
    private String _plainText;
    private Integer _arrangementIndex;
    private Boolean _autoShowAnswer;
    private Integer _groupId;

    public LFQuizQuestionSoap() {
    }

    public static LFQuizQuestionSoap toSoapModel(LFQuizQuestion model) {
        LFQuizQuestionSoap soapModel = new LFQuizQuestionSoap();

        soapModel.setId(model.getId());
        soapModel.setQuizId(model.getQuizId());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setQuestionId(model.getQuestionId());
        soapModel.setQuestionType(model.getQuestionType());
        soapModel.setTitle(model.getTitle());
        soapModel.setUrl(model.getUrl());
        soapModel.setPlainText(model.getPlainText());
        soapModel.setArrangementIndex(model.getArrangementIndex());
        soapModel.setAutoShowAnswer(model.getAutoShowAnswer());
        soapModel.setGroupId(model.getGroupId());

        return soapModel;
    }

    public static LFQuizQuestionSoap[] toSoapModels(LFQuizQuestion[] models) {
        LFQuizQuestionSoap[] soapModels = new LFQuizQuestionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuizQuestionSoap[][] toSoapModels(LFQuizQuestion[][] models) {
        LFQuizQuestionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuizQuestionSoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuizQuestionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuizQuestionSoap[] toSoapModels(List<LFQuizQuestion> models) {
        List<LFQuizQuestionSoap> soapModels = new ArrayList<LFQuizQuestionSoap>(models.size());

        for (LFQuizQuestion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuizQuestionSoap[soapModels.size()]);
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

    public Integer getQuizId() {
        return _quizId;
    }

    public void setQuizId(Integer quizId) {
        _quizId = quizId;
    }

    public Integer getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        _categoryId = categoryId;
    }

    public Integer getQuestionId() {
        return _questionId;
    }

    public void setQuestionId(Integer questionId) {
        _questionId = questionId;
    }

    public String getQuestionType() {
        return _questionType;
    }

    public void setQuestionType(String questionType) {
        _questionType = questionType;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getPlainText() {
        return _plainText;
    }

    public void setPlainText(String plainText) {
        _plainText = plainText;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }

    public Boolean getAutoShowAnswer() {
        return _autoShowAnswer;
    }

    public void setAutoShowAnswer(Boolean autoShowAnswer) {
        _autoShowAnswer = autoShowAnswer;
    }

    public Integer getGroupId() {
        return _groupId;
    }

    public void setGroupId(Integer groupId) {
        _groupId = groupId;
    }
}

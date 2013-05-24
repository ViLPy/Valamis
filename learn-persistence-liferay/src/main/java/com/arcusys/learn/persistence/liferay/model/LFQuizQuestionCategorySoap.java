package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
* This class is used by SOAP remote services.
*
* @author    Brian Wing Shun Chan
* @generated
*/
public class LFQuizQuestionCategorySoap implements Serializable {
    private long _id;
    private String _title;
    private String _description;
    private Integer _quizId;
    private Integer _parentId;
    private Integer _arrangementIndex;

    public LFQuizQuestionCategorySoap() {
    }

    public static LFQuizQuestionCategorySoap toSoapModel(
        LFQuizQuestionCategory model) {
        LFQuizQuestionCategorySoap soapModel = new LFQuizQuestionCategorySoap();

        soapModel.setId(model.getId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setQuizId(model.getQuizId());
        soapModel.setParentId(model.getParentId());
        soapModel.setArrangementIndex(model.getArrangementIndex());

        return soapModel;
    }

    public static LFQuizQuestionCategorySoap[] toSoapModels(
        LFQuizQuestionCategory[] models) {
        LFQuizQuestionCategorySoap[] soapModels = new LFQuizQuestionCategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuizQuestionCategorySoap[][] toSoapModels(
        LFQuizQuestionCategory[][] models) {
        LFQuizQuestionCategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuizQuestionCategorySoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuizQuestionCategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuizQuestionCategorySoap[] toSoapModels(
        List<LFQuizQuestionCategory> models) {
        List<LFQuizQuestionCategorySoap> soapModels = new ArrayList<LFQuizQuestionCategorySoap>(models.size());

        for (LFQuizQuestionCategory model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuizQuestionCategorySoap[soapModels.size()]);
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

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Integer getQuizId() {
        return _quizId;
    }

    public void setQuizId(Integer quizId) {
        _quizId = quizId;
    }

    public Integer getParentId() {
        return _parentId;
    }

    public void setParentId(Integer parentId) {
        _parentId = parentId;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }
}

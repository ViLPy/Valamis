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
public class LFQuestionSoap implements Serializable {
    private long _id;
    private Integer _categoryId;
    private String _title;
    private String _description;
    private String _explanationText;
    private boolean _forceCorrectCount;
    private boolean _caseSensitive;
    private Integer _questionType;
    private Integer _courseId;
    private Integer _arrangementIndex;

    public LFQuestionSoap() {
    }

    public static LFQuestionSoap toSoapModel(LFQuestion model) {
        LFQuestionSoap soapModel = new LFQuestionSoap();

        soapModel.setId(model.getId());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setExplanationText(model.getExplanationText());
        soapModel.setForceCorrectCount(model.getForceCorrectCount());
        soapModel.setCaseSensitive(model.getCaseSensitive());
        soapModel.setQuestionType(model.getQuestionType());
        soapModel.setCourseId(model.getCourseId());
        soapModel.setArrangementIndex(model.getArrangementIndex());

        return soapModel;
    }

    public static LFQuestionSoap[] toSoapModels(LFQuestion[] models) {
        LFQuestionSoap[] soapModels = new LFQuestionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuestionSoap[][] toSoapModels(LFQuestion[][] models) {
        LFQuestionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuestionSoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuestionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuestionSoap[] toSoapModels(List<LFQuestion> models) {
        List<LFQuestionSoap> soapModels = new ArrayList<LFQuestionSoap>(models.size());

        for (LFQuestion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuestionSoap[soapModels.size()]);
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

    public Integer getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        _categoryId = categoryId;
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

    public String getExplanationText() {
        return _explanationText;
    }

    public void setExplanationText(String explanationText) {
        _explanationText = explanationText;
    }

    public boolean getForceCorrectCount() {
        return _forceCorrectCount;
    }

    public boolean isForceCorrectCount() {
        return _forceCorrectCount;
    }

    public void setForceCorrectCount(boolean forceCorrectCount) {
        _forceCorrectCount = forceCorrectCount;
    }

    public boolean getCaseSensitive() {
        return _caseSensitive;
    }

    public boolean isCaseSensitive() {
        return _caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        _caseSensitive = caseSensitive;
    }

    public Integer getQuestionType() {
        return _questionType;
    }

    public void setQuestionType(Integer questionType) {
        _questionType = questionType;
    }

    public Integer getCourseId() {
        return _courseId;
    }

    public void setCourseId(Integer courseId) {
        _courseId = courseId;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }
}

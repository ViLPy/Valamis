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
public class LFQuizTreeElementSoap implements Serializable {
    private long _id;
    private Integer _quizID;
    private String _elementID;
    private Boolean _isCategory;
    private String _parentID;
    private Integer _arrangementIndex;

    public LFQuizTreeElementSoap() {
    }

    public static LFQuizTreeElementSoap toSoapModel(LFQuizTreeElement model) {
        LFQuizTreeElementSoap soapModel = new LFQuizTreeElementSoap();

        soapModel.setId(model.getId());
        soapModel.setQuizID(model.getQuizID());
        soapModel.setElementID(model.getElementID());
        soapModel.setIsCategory(model.getIsCategory());
        soapModel.setParentID(model.getParentID());
        soapModel.setArrangementIndex(model.getArrangementIndex());

        return soapModel;
    }

    public static LFQuizTreeElementSoap[] toSoapModels(
        LFQuizTreeElement[] models) {
        LFQuizTreeElementSoap[] soapModels = new LFQuizTreeElementSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuizTreeElementSoap[][] toSoapModels(
        LFQuizTreeElement[][] models) {
        LFQuizTreeElementSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuizTreeElementSoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuizTreeElementSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuizTreeElementSoap[] toSoapModels(
        List<LFQuizTreeElement> models) {
        List<LFQuizTreeElementSoap> soapModels = new ArrayList<LFQuizTreeElementSoap>(models.size());

        for (LFQuizTreeElement model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuizTreeElementSoap[soapModels.size()]);
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

    public Integer getQuizID() {
        return _quizID;
    }

    public void setQuizID(Integer quizID) {
        _quizID = quizID;
    }

    public String getElementID() {
        return _elementID;
    }

    public void setElementID(String elementID) {
        _elementID = elementID;
    }

    public Boolean getIsCategory() {
        return _isCategory;
    }

    public void setIsCategory(Boolean isCategory) {
        _isCategory = isCategory;
    }

    public String getParentID() {
        return _parentID;
    }

    public void setParentID(String parentID) {
        _parentID = parentID;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }
}

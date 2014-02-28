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
public class LFQuestionCategorySoap implements Serializable {
    private long _id;
    private String _title;
    private String _description;
    private Integer _parentId;
    private Integer _courseId;
    private Integer _arrangementIndex;

    public LFQuestionCategorySoap() {
    }

    public static LFQuestionCategorySoap toSoapModel(LFQuestionCategory model) {
        LFQuestionCategorySoap soapModel = new LFQuestionCategorySoap();

        soapModel.setId(model.getId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setParentId(model.getParentId());
        soapModel.setCourseId(model.getCourseId());
        soapModel.setArrangementIndex(model.getArrangementIndex());

        return soapModel;
    }

    public static LFQuestionCategorySoap[] toSoapModels(
        LFQuestionCategory[] models) {
        LFQuestionCategorySoap[] soapModels = new LFQuestionCategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuestionCategorySoap[][] toSoapModels(
        LFQuestionCategory[][] models) {
        LFQuestionCategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuestionCategorySoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuestionCategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuestionCategorySoap[] toSoapModels(
        List<LFQuestionCategory> models) {
        List<LFQuestionCategorySoap> soapModels = new ArrayList<LFQuestionCategorySoap>(models.size());

        for (LFQuestionCategory model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuestionCategorySoap[soapModels.size()]);
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

    public Integer getParentId() {
        return _parentId;
    }

    public void setParentId(Integer parentId) {
        _parentId = parentId;
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

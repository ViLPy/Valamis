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
public class LFQuizSoap implements Serializable {
    private long _id;
    private String _title;
    private String _description;
    private String _logo;
    private String _welcomePageContent;
    private String _finalPageContent;
    private Integer _courseID;
    private Integer _maxDuration;

    public LFQuizSoap() {
    }

    public static LFQuizSoap toSoapModel(LFQuiz model) {
        LFQuizSoap soapModel = new LFQuizSoap();

        soapModel.setId(model.getId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setLogo(model.getLogo());
        soapModel.setWelcomePageContent(model.getWelcomePageContent());
        soapModel.setFinalPageContent(model.getFinalPageContent());
        soapModel.setCourseID(model.getCourseID());
        soapModel.setMaxDuration(model.getMaxDuration());

        return soapModel;
    }

    public static LFQuizSoap[] toSoapModels(LFQuiz[] models) {
        LFQuizSoap[] soapModels = new LFQuizSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFQuizSoap[][] toSoapModels(LFQuiz[][] models) {
        LFQuizSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFQuizSoap[models.length][models[0].length];
        } else {
            soapModels = new LFQuizSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFQuizSoap[] toSoapModels(List<LFQuiz> models) {
        List<LFQuizSoap> soapModels = new ArrayList<LFQuizSoap>(models.size());

        for (LFQuiz model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFQuizSoap[soapModels.size()]);
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

    public String getLogo() {
        return _logo;
    }

    public void setLogo(String logo) {
        _logo = logo;
    }

    public String getWelcomePageContent() {
        return _welcomePageContent;
    }

    public void setWelcomePageContent(String welcomePageContent) {
        _welcomePageContent = welcomePageContent;
    }

    public String getFinalPageContent() {
        return _finalPageContent;
    }

    public void setFinalPageContent(String finalPageContent) {
        _finalPageContent = finalPageContent;
    }

    public Integer getCourseID() {
        return _courseID;
    }

    public void setCourseID(Integer courseID) {
        _courseID = courseID;
    }

    public Integer getMaxDuration() {
        return _maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        _maxDuration = maxDuration;
    }
}

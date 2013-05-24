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
public class LFCourseSoap implements Serializable {
    private long _id;
    private Integer _courseID;
    private Integer _userID;
    private String _grade;
    private String _comment;

    public LFCourseSoap() {
    }

    public static LFCourseSoap toSoapModel(LFCourse model) {
        LFCourseSoap soapModel = new LFCourseSoap();

        soapModel.setId(model.getId());
        soapModel.setCourseID(model.getCourseID());
        soapModel.setUserID(model.getUserID());
        soapModel.setGrade(model.getGrade());
        soapModel.setComment(model.getComment());

        return soapModel;
    }

    public static LFCourseSoap[] toSoapModels(LFCourse[] models) {
        LFCourseSoap[] soapModels = new LFCourseSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFCourseSoap[][] toSoapModels(LFCourse[][] models) {
        LFCourseSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFCourseSoap[models.length][models[0].length];
        } else {
            soapModels = new LFCourseSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFCourseSoap[] toSoapModels(List<LFCourse> models) {
        List<LFCourseSoap> soapModels = new ArrayList<LFCourseSoap>(models.size());

        for (LFCourse model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFCourseSoap[soapModels.size()]);
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

    public Integer getCourseID() {
        return _courseID;
    }

    public void setCourseID(Integer courseID) {
        _courseID = courseID;
    }

    public Integer getUserID() {
        return _userID;
    }

    public void setUserID(Integer userID) {
        _userID = userID;
    }

    public String getGrade() {
        return _grade;
    }

    public void setGrade(String grade) {
        _grade = grade;
    }

    public String getComment() {
        return _comment;
    }

    public void setComment(String comment) {
        _comment = comment;
    }
}

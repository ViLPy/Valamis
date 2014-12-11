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
public class LFLRSToActivitySettingSoap implements Serializable {
    private long _id;
    private Integer _courseID;
    private String _title;
    private String _activityFilter;
    private String _verbFilter;

    public LFLRSToActivitySettingSoap() {
    }

    public static LFLRSToActivitySettingSoap toSoapModel(
        LFLRSToActivitySetting model) {
        LFLRSToActivitySettingSoap soapModel = new LFLRSToActivitySettingSoap();

        soapModel.setId(model.getId());
        soapModel.setCourseID(model.getCourseID());
        soapModel.setTitle(model.getTitle());
        soapModel.setActivityFilter(model.getActivityFilter());
        soapModel.setVerbFilter(model.getVerbFilter());

        return soapModel;
    }

    public static LFLRSToActivitySettingSoap[] toSoapModels(
        LFLRSToActivitySetting[] models) {
        LFLRSToActivitySettingSoap[] soapModels = new LFLRSToActivitySettingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFLRSToActivitySettingSoap[][] toSoapModels(
        LFLRSToActivitySetting[][] models) {
        LFLRSToActivitySettingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFLRSToActivitySettingSoap[models.length][models[0].length];
        } else {
            soapModels = new LFLRSToActivitySettingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFLRSToActivitySettingSoap[] toSoapModels(
        List<LFLRSToActivitySetting> models) {
        List<LFLRSToActivitySettingSoap> soapModels = new ArrayList<LFLRSToActivitySettingSoap>(models.size());

        for (LFLRSToActivitySetting model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFLRSToActivitySettingSoap[soapModels.size()]);
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

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getActivityFilter() {
        return _activityFilter;
    }

    public void setActivityFilter(String activityFilter) {
        _activityFilter = activityFilter;
    }

    public String getVerbFilter() {
        return _verbFilter;
    }

    public void setVerbFilter(String verbFilter) {
        _verbFilter = verbFilter;
    }
}

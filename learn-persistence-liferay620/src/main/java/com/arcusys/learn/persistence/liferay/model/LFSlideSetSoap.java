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
public class LFSlideSetSoap implements Serializable {
    private long _id;
    private String _title;
    private String _description;
    private String _logo;
    private Long _courseId;

    public LFSlideSetSoap() {
    }

    public static LFSlideSetSoap toSoapModel(LFSlideSet model) {
        LFSlideSetSoap soapModel = new LFSlideSetSoap();

        soapModel.setId(model.getId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setLogo(model.getLogo());
        soapModel.setCourseId(model.getCourseId());

        return soapModel;
    }

    public static LFSlideSetSoap[] toSoapModels(LFSlideSet[] models) {
        LFSlideSetSoap[] soapModels = new LFSlideSetSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSlideSetSoap[][] toSoapModels(LFSlideSet[][] models) {
        LFSlideSetSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSlideSetSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSlideSetSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSlideSetSoap[] toSoapModels(List<LFSlideSet> models) {
        List<LFSlideSetSoap> soapModels = new ArrayList<LFSlideSetSoap>(models.size());

        for (LFSlideSet model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSlideSetSoap[soapModels.size()]);
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

    public Long getCourseId() {
        return _courseId;
    }

    public void setCourseId(Long courseId) {
        _courseId = courseId;
    }
}

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
public class LFSlideSoap implements Serializable {
    private long _id;
    private String _bgcolor;
    private String _bgimage;
    private String _title;
    private Long _slideSetId;
    private Long _topSlideId;
    private Long _leftSlideId;
    private String _statementVerb;
    private String _statementObject;
    private String _statementCategoryId;

    public LFSlideSoap() {
    }

    public static LFSlideSoap toSoapModel(LFSlide model) {
        LFSlideSoap soapModel = new LFSlideSoap();

        soapModel.setId(model.getId());
        soapModel.setBgcolor(model.getBgcolor());
        soapModel.setBgimage(model.getBgimage());
        soapModel.setTitle(model.getTitle());
        soapModel.setSlideSetId(model.getSlideSetId());
        soapModel.setTopSlideId(model.getTopSlideId());
        soapModel.setLeftSlideId(model.getLeftSlideId());
        soapModel.setStatementVerb(model.getStatementVerb());
        soapModel.setStatementObject(model.getStatementObject());
        soapModel.setStatementCategoryId(model.getStatementCategoryId());

        return soapModel;
    }

    public static LFSlideSoap[] toSoapModels(LFSlide[] models) {
        LFSlideSoap[] soapModels = new LFSlideSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSlideSoap[][] toSoapModels(LFSlide[][] models) {
        LFSlideSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSlideSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSlideSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSlideSoap[] toSoapModels(List<LFSlide> models) {
        List<LFSlideSoap> soapModels = new ArrayList<LFSlideSoap>(models.size());

        for (LFSlide model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSlideSoap[soapModels.size()]);
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

    public String getBgcolor() {
        return _bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        _bgcolor = bgcolor;
    }

    public String getBgimage() {
        return _bgimage;
    }

    public void setBgimage(String bgimage) {
        _bgimage = bgimage;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public Long getSlideSetId() {
        return _slideSetId;
    }

    public void setSlideSetId(Long slideSetId) {
        _slideSetId = slideSetId;
    }

    public Long getTopSlideId() {
        return _topSlideId;
    }

    public void setTopSlideId(Long topSlideId) {
        _topSlideId = topSlideId;
    }

    public Long getLeftSlideId() {
        return _leftSlideId;
    }

    public void setLeftSlideId(Long leftSlideId) {
        _leftSlideId = leftSlideId;
    }

    public String getStatementVerb() {
        return _statementVerb;
    }

    public void setStatementVerb(String statementVerb) {
        _statementVerb = statementVerb;
    }

    public String getStatementObject() {
        return _statementObject;
    }

    public void setStatementObject(String statementObject) {
        _statementObject = statementObject;
    }

    public String getStatementCategoryId() {
        return _statementCategoryId;
    }

    public void setStatementCategoryId(String statementCategoryId) {
        _statementCategoryId = statementCategoryId;
    }
}

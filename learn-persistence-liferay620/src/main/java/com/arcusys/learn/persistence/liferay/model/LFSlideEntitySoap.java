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
public class LFSlideEntitySoap implements Serializable {
    private long _id;
    private String _top;
    private String _left;
    private String _width;
    private String _height;
    private String _zIndex;
    private String _content;
    private String _entityType;
    private Long _slideId;
    private Long _correctLinkedSlideId;
    private Long _incorrectLinkedSlideId;
    private Boolean _notifyCorrectAnswer;

    public LFSlideEntitySoap() {
    }

    public static LFSlideEntitySoap toSoapModel(LFSlideEntity model) {
        LFSlideEntitySoap soapModel = new LFSlideEntitySoap();

        soapModel.setId(model.getId());
        soapModel.setTop(model.getTop());
        soapModel.setLeft(model.getLeft());
        soapModel.setWidth(model.getWidth());
        soapModel.setHeight(model.getHeight());
        soapModel.setZIndex(model.getZIndex());
        soapModel.setContent(model.getContent());
        soapModel.setEntityType(model.getEntityType());
        soapModel.setSlideId(model.getSlideId());
        soapModel.setCorrectLinkedSlideId(model.getCorrectLinkedSlideId());
        soapModel.setIncorrectLinkedSlideId(model.getIncorrectLinkedSlideId());
        soapModel.setNotifyCorrectAnswer(model.getNotifyCorrectAnswer());

        return soapModel;
    }

    public static LFSlideEntitySoap[] toSoapModels(LFSlideEntity[] models) {
        LFSlideEntitySoap[] soapModels = new LFSlideEntitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSlideEntitySoap[][] toSoapModels(LFSlideEntity[][] models) {
        LFSlideEntitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSlideEntitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFSlideEntitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSlideEntitySoap[] toSoapModels(List<LFSlideEntity> models) {
        List<LFSlideEntitySoap> soapModels = new ArrayList<LFSlideEntitySoap>(models.size());

        for (LFSlideEntity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSlideEntitySoap[soapModels.size()]);
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

    public String getTop() {
        return _top;
    }

    public void setTop(String top) {
        _top = top;
    }

    public String getLeft() {
        return _left;
    }

    public void setLeft(String left) {
        _left = left;
    }

    public String getWidth() {
        return _width;
    }

    public void setWidth(String width) {
        _width = width;
    }

    public String getHeight() {
        return _height;
    }

    public void setHeight(String height) {
        _height = height;
    }

    public String getZIndex() {
        return _zIndex;
    }

    public void setZIndex(String zIndex) {
        _zIndex = zIndex;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public String getEntityType() {
        return _entityType;
    }

    public void setEntityType(String entityType) {
        _entityType = entityType;
    }

    public Long getSlideId() {
        return _slideId;
    }

    public void setSlideId(Long slideId) {
        _slideId = slideId;
    }

    public Long getCorrectLinkedSlideId() {
        return _correctLinkedSlideId;
    }

    public void setCorrectLinkedSlideId(Long correctLinkedSlideId) {
        _correctLinkedSlideId = correctLinkedSlideId;
    }

    public Long getIncorrectLinkedSlideId() {
        return _incorrectLinkedSlideId;
    }

    public void setIncorrectLinkedSlideId(Long incorrectLinkedSlideId) {
        _incorrectLinkedSlideId = incorrectLinkedSlideId;
    }

    public Boolean getNotifyCorrectAnswer() {
        return _notifyCorrectAnswer;
    }

    public void setNotifyCorrectAnswer(Boolean notifyCorrectAnswer) {
        _notifyCorrectAnswer = notifyCorrectAnswer;
    }
}

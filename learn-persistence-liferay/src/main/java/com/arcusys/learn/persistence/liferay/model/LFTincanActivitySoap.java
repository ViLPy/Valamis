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
public class LFTincanActivitySoap implements Serializable {
    private long _id;
    private String _tincanID;
    private Long _packageID;
    private String _objectType;
    private String _name;
    private String _description;
    private String _theType;
    private String _moreInfo;
    private String _interactionType;
    private String _correctResponsesPattern;
    private String _choices;
    private String _scale;
    private String _source;
    private String _target;
    private String _steps;
    private String _extensions;

    public LFTincanActivitySoap() {
    }

    public static LFTincanActivitySoap toSoapModel(LFTincanActivity model) {
        LFTincanActivitySoap soapModel = new LFTincanActivitySoap();

        soapModel.setId(model.getId());
        soapModel.setTincanID(model.getTincanID());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setObjectType(model.getObjectType());
        soapModel.setName(model.getName());
        soapModel.setDescription(model.getDescription());
        soapModel.setTheType(model.getTheType());
        soapModel.setMoreInfo(model.getMoreInfo());
        soapModel.setInteractionType(model.getInteractionType());
        soapModel.setCorrectResponsesPattern(model.getCorrectResponsesPattern());
        soapModel.setChoices(model.getChoices());
        soapModel.setScale(model.getScale());
        soapModel.setSource(model.getSource());
        soapModel.setTarget(model.getTarget());
        soapModel.setSteps(model.getSteps());
        soapModel.setExtensions(model.getExtensions());

        return soapModel;
    }

    public static LFTincanActivitySoap[] toSoapModels(LFTincanActivity[] models) {
        LFTincanActivitySoap[] soapModels = new LFTincanActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanActivitySoap[][] toSoapModels(
        LFTincanActivity[][] models) {
        LFTincanActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanActivitySoap[] toSoapModels(
        List<LFTincanActivity> models) {
        List<LFTincanActivitySoap> soapModels = new ArrayList<LFTincanActivitySoap>(models.size());

        for (LFTincanActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanActivitySoap[soapModels.size()]);
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

    public String getTincanID() {
        return _tincanID;
    }

    public void setTincanID(String tincanID) {
        _tincanID = tincanID;
    }

    public Long getPackageID() {
        return _packageID;
    }

    public void setPackageID(Long packageID) {
        _packageID = packageID;
    }

    public String getObjectType() {
        return _objectType;
    }

    public void setObjectType(String objectType) {
        _objectType = objectType;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getTheType() {
        return _theType;
    }

    public void setTheType(String theType) {
        _theType = theType;
    }

    public String getMoreInfo() {
        return _moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        _moreInfo = moreInfo;
    }

    public String getInteractionType() {
        return _interactionType;
    }

    public void setInteractionType(String interactionType) {
        _interactionType = interactionType;
    }

    public String getCorrectResponsesPattern() {
        return _correctResponsesPattern;
    }

    public void setCorrectResponsesPattern(String correctResponsesPattern) {
        _correctResponsesPattern = correctResponsesPattern;
    }

    public String getChoices() {
        return _choices;
    }

    public void setChoices(String choices) {
        _choices = choices;
    }

    public String getScale() {
        return _scale;
    }

    public void setScale(String scale) {
        _scale = scale;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getTarget() {
        return _target;
    }

    public void setTarget(String target) {
        _target = target;
    }

    public String getSteps() {
        return _steps;
    }

    public void setSteps(String steps) {
        _steps = steps;
    }

    public String getExtensions() {
        return _extensions;
    }

    public void setExtensions(String extensions) {
        _extensions = extensions;
    }
}

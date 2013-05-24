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
public class LFResourceSoap implements Serializable {
    private long _id;
    private Integer _packageID;
    private String _scormType;
    private String _resourceID;
    private String _href;
    private String _base;

    public LFResourceSoap() {
    }

    public static LFResourceSoap toSoapModel(LFResource model) {
        LFResourceSoap soapModel = new LFResourceSoap();

        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setScormType(model.getScormType());
        soapModel.setResourceID(model.getResourceID());
        soapModel.setHref(model.getHref());
        soapModel.setBase(model.getBase());

        return soapModel;
    }

    public static LFResourceSoap[] toSoapModels(LFResource[] models) {
        LFResourceSoap[] soapModels = new LFResourceSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFResourceSoap[][] toSoapModels(LFResource[][] models) {
        LFResourceSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFResourceSoap[models.length][models[0].length];
        } else {
            soapModels = new LFResourceSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFResourceSoap[] toSoapModels(List<LFResource> models) {
        List<LFResourceSoap> soapModels = new ArrayList<LFResourceSoap>(models.size());

        for (LFResource model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFResourceSoap[soapModels.size()]);
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

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getScormType() {
        return _scormType;
    }

    public void setScormType(String scormType) {
        _scormType = scormType;
    }

    public String getResourceID() {
        return _resourceID;
    }

    public void setResourceID(String resourceID) {
        _resourceID = resourceID;
    }

    public String getHref() {
        return _href;
    }

    public void setHref(String href) {
        _href = href;
    }

    public String getBase() {
        return _base;
    }

    public void setBase(String base) {
        _base = base;
    }
}

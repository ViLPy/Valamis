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
public class LFFileStorageSoap implements Serializable {
    private long _id;
    private String _filename;
    private String _content;

    public LFFileStorageSoap() {
    }

    public static LFFileStorageSoap toSoapModel(LFFileStorage model) {
        LFFileStorageSoap soapModel = new LFFileStorageSoap();

        soapModel.setId(model.getId());
        soapModel.setFilename(model.getFilename());
        soapModel.setContent(model.getContent());

        return soapModel;
    }

    public static LFFileStorageSoap[] toSoapModels(LFFileStorage[] models) {
        LFFileStorageSoap[] soapModels = new LFFileStorageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFFileStorageSoap[][] toSoapModels(LFFileStorage[][] models) {
        LFFileStorageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFFileStorageSoap[models.length][models[0].length];
        } else {
            soapModels = new LFFileStorageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFFileStorageSoap[] toSoapModels(List<LFFileStorage> models) {
        List<LFFileStorageSoap> soapModels = new ArrayList<LFFileStorageSoap>(models.size());

        for (LFFileStorage model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFFileStorageSoap[soapModels.size()]);
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

    public String getFilename() {
        return _filename;
    }

    public void setFilename(String filename) {
        _filename = filename;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }
}

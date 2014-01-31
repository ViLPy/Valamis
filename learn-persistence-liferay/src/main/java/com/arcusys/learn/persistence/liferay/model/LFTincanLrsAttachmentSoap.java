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
public class LFTincanLrsAttachmentSoap implements Serializable {
    private long _id;
    private Integer _parentID;
    private String _usageType;
    private String _display;
    private String _description;
    private String _contentType;
    private Integer _length;
    private String _sha2;
    private String _fileUrl;

    public LFTincanLrsAttachmentSoap() {
    }

    public static LFTincanLrsAttachmentSoap toSoapModel(
        LFTincanLrsAttachment model) {
        LFTincanLrsAttachmentSoap soapModel = new LFTincanLrsAttachmentSoap();

        soapModel.setId(model.getId());
        soapModel.setParentID(model.getParentID());
        soapModel.setUsageType(model.getUsageType());
        soapModel.setDisplay(model.getDisplay());
        soapModel.setDescription(model.getDescription());
        soapModel.setContentType(model.getContentType());
        soapModel.setLength(model.getLength());
        soapModel.setSha2(model.getSha2());
        soapModel.setFileUrl(model.getFileUrl());

        return soapModel;
    }

    public static LFTincanLrsAttachmentSoap[] toSoapModels(
        LFTincanLrsAttachment[] models) {
        LFTincanLrsAttachmentSoap[] soapModels = new LFTincanLrsAttachmentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsAttachmentSoap[][] toSoapModels(
        LFTincanLrsAttachment[][] models) {
        LFTincanLrsAttachmentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsAttachmentSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsAttachmentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsAttachmentSoap[] toSoapModels(
        List<LFTincanLrsAttachment> models) {
        List<LFTincanLrsAttachmentSoap> soapModels = new ArrayList<LFTincanLrsAttachmentSoap>(models.size());

        for (LFTincanLrsAttachment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsAttachmentSoap[soapModels.size()]);
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

    public Integer getParentID() {
        return _parentID;
    }

    public void setParentID(Integer parentID) {
        _parentID = parentID;
    }

    public String getUsageType() {
        return _usageType;
    }

    public void setUsageType(String usageType) {
        _usageType = usageType;
    }

    public String getDisplay() {
        return _display;
    }

    public void setDisplay(String display) {
        _display = display;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getContentType() {
        return _contentType;
    }

    public void setContentType(String contentType) {
        _contentType = contentType;
    }

    public Integer getLength() {
        return _length;
    }

    public void setLength(Integer length) {
        _length = length;
    }

    public String getSha2() {
        return _sha2;
    }

    public void setSha2(String sha2) {
        _sha2 = sha2;
    }

    public String getFileUrl() {
        return _fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        _fileUrl = fileUrl;
    }
}

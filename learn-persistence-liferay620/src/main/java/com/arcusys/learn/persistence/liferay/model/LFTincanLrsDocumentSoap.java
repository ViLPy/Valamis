package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFTincanLrsDocumentSoap implements Serializable {
    private long _id;
    private String _documentId;
    private Date _update;
    private String _content;
    private String _contentType;

    public LFTincanLrsDocumentSoap() {
    }

    public static LFTincanLrsDocumentSoap toSoapModel(LFTincanLrsDocument model) {
        LFTincanLrsDocumentSoap soapModel = new LFTincanLrsDocumentSoap();

        soapModel.setId(model.getId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setUpdate(model.getUpdate());
        soapModel.setContent(model.getContent());
        soapModel.setContentType(model.getContentType());

        return soapModel;
    }

    public static LFTincanLrsDocumentSoap[] toSoapModels(
        LFTincanLrsDocument[] models) {
        LFTincanLrsDocumentSoap[] soapModels = new LFTincanLrsDocumentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsDocumentSoap[][] toSoapModels(
        LFTincanLrsDocument[][] models) {
        LFTincanLrsDocumentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsDocumentSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsDocumentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsDocumentSoap[] toSoapModels(
        List<LFTincanLrsDocument> models) {
        List<LFTincanLrsDocumentSoap> soapModels = new ArrayList<LFTincanLrsDocumentSoap>(models.size());

        for (LFTincanLrsDocument model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsDocumentSoap[soapModels.size()]);
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

    public String getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(String documentId) {
        _documentId = documentId;
    }

    public Date getUpdate() {
        return _update;
    }

    public void setUpdate(Date update) {
        _update = update;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public String getContentType() {
        return _contentType;
    }

    public void setContentType(String contentType) {
        _contentType = contentType;
    }
}

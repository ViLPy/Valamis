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
public class LFTincanLrsAgentProfileSoap implements Serializable {
    private long _id;
    private Integer _documentId;
    private Integer _agentId;
    private String _profileId;

    public LFTincanLrsAgentProfileSoap() {
    }

    public static LFTincanLrsAgentProfileSoap toSoapModel(
        LFTincanLrsAgentProfile model) {
        LFTincanLrsAgentProfileSoap soapModel = new LFTincanLrsAgentProfileSoap();

        soapModel.setId(model.getId());
        soapModel.setDocumentId(model.getDocumentId());
        soapModel.setAgentId(model.getAgentId());
        soapModel.setProfileId(model.getProfileId());

        return soapModel;
    }

    public static LFTincanLrsAgentProfileSoap[] toSoapModels(
        LFTincanLrsAgentProfile[] models) {
        LFTincanLrsAgentProfileSoap[] soapModels = new LFTincanLrsAgentProfileSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsAgentProfileSoap[][] toSoapModels(
        LFTincanLrsAgentProfile[][] models) {
        LFTincanLrsAgentProfileSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsAgentProfileSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsAgentProfileSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsAgentProfileSoap[] toSoapModels(
        List<LFTincanLrsAgentProfile> models) {
        List<LFTincanLrsAgentProfileSoap> soapModels = new ArrayList<LFTincanLrsAgentProfileSoap>(models.size());

        for (LFTincanLrsAgentProfile model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsAgentProfileSoap[soapModels.size()]);
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

    public Integer getDocumentId() {
        return _documentId;
    }

    public void setDocumentId(Integer documentId) {
        _documentId = documentId;
    }

    public Integer getAgentId() {
        return _agentId;
    }

    public void setAgentId(Integer agentId) {
        _agentId = agentId;
    }

    public String getProfileId() {
        return _profileId;
    }

    public void setProfileId(String profileId) {
        _profileId = profileId;
    }
}

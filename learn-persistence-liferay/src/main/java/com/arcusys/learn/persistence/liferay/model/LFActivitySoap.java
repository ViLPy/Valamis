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
public class LFActivitySoap implements Serializable {
    private long _indexNumber;
    private String _id;
    private Integer _packageID;
    private String _organizationID;
    private String _parentID;
    private String _title;
    private String _identifierRef;
    private String _resourceParameters;
    private String _hideLMSUI;
    private boolean _visible;
    private boolean _objectivesGlobalToSystem;
    private boolean _sharedDataGlobalToSystem;
    private String _masteryScore;
    private String _maxTimeAllowed;

    public LFActivitySoap() {
    }

    public static LFActivitySoap toSoapModel(LFActivity model) {
        LFActivitySoap soapModel = new LFActivitySoap();

        soapModel.setIndexNumber(model.getIndexNumber());
        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setOrganizationID(model.getOrganizationID());
        soapModel.setParentID(model.getParentID());
        soapModel.setTitle(model.getTitle());
        soapModel.setIdentifierRef(model.getIdentifierRef());
        soapModel.setResourceParameters(model.getResourceParameters());
        soapModel.setHideLMSUI(model.getHideLMSUI());
        soapModel.setVisible(model.getVisible());
        soapModel.setObjectivesGlobalToSystem(model.getObjectivesGlobalToSystem());
        soapModel.setSharedDataGlobalToSystem(model.getSharedDataGlobalToSystem());
        soapModel.setMasteryScore(model.getMasteryScore());
        soapModel.setMaxTimeAllowed(model.getMaxTimeAllowed());

        return soapModel;
    }

    public static LFActivitySoap[] toSoapModels(LFActivity[] models) {
        LFActivitySoap[] soapModels = new LFActivitySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFActivitySoap[][] toSoapModels(LFActivity[][] models) {
        LFActivitySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFActivitySoap[models.length][models[0].length];
        } else {
            soapModels = new LFActivitySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFActivitySoap[] toSoapModels(List<LFActivity> models) {
        List<LFActivitySoap> soapModels = new ArrayList<LFActivitySoap>(models.size());

        for (LFActivity model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFActivitySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _indexNumber;
    }

    public void setPrimaryKey(long pk) {
        setIndexNumber(pk);
    }

    public long getIndexNumber() {
        return _indexNumber;
    }

    public void setIndexNumber(long indexNumber) {
        _indexNumber = indexNumber;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getOrganizationID() {
        return _organizationID;
    }

    public void setOrganizationID(String organizationID) {
        _organizationID = organizationID;
    }

    public String getParentID() {
        return _parentID;
    }

    public void setParentID(String parentID) {
        _parentID = parentID;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getIdentifierRef() {
        return _identifierRef;
    }

    public void setIdentifierRef(String identifierRef) {
        _identifierRef = identifierRef;
    }

    public String getResourceParameters() {
        return _resourceParameters;
    }

    public void setResourceParameters(String resourceParameters) {
        _resourceParameters = resourceParameters;
    }

    public String getHideLMSUI() {
        return _hideLMSUI;
    }

    public void setHideLMSUI(String hideLMSUI) {
        _hideLMSUI = hideLMSUI;
    }

    public boolean getVisible() {
        return _visible;
    }

    public boolean isVisible() {
        return _visible;
    }

    public void setVisible(boolean visible) {
        _visible = visible;
    }

    public boolean getObjectivesGlobalToSystem() {
        return _objectivesGlobalToSystem;
    }

    public boolean isObjectivesGlobalToSystem() {
        return _objectivesGlobalToSystem;
    }

    public void setObjectivesGlobalToSystem(boolean objectivesGlobalToSystem) {
        _objectivesGlobalToSystem = objectivesGlobalToSystem;
    }

    public boolean getSharedDataGlobalToSystem() {
        return _sharedDataGlobalToSystem;
    }

    public boolean isSharedDataGlobalToSystem() {
        return _sharedDataGlobalToSystem;
    }

    public void setSharedDataGlobalToSystem(boolean sharedDataGlobalToSystem) {
        _sharedDataGlobalToSystem = sharedDataGlobalToSystem;
    }

    public String getMasteryScore() {
        return _masteryScore;
    }

    public void setMasteryScore(String masteryScore) {
        _masteryScore = masteryScore;
    }

    public String getMaxTimeAllowed() {
        return _maxTimeAllowed;
    }

    public void setMaxTimeAllowed(String maxTimeAllowed) {
        _maxTimeAllowed = maxTimeAllowed;
    }
}

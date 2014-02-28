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
public class LFPackageScopeRuleSoap implements Serializable {
    private long _id;
    private Integer _packageID;
    private String _scope;
    private String _scopeID;
    private Boolean _visibility;
    private Boolean _isDefault;

    public LFPackageScopeRuleSoap() {
    }

    public static LFPackageScopeRuleSoap toSoapModel(LFPackageScopeRule model) {
        LFPackageScopeRuleSoap soapModel = new LFPackageScopeRuleSoap();

        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setScope(model.getScope());
        soapModel.setScopeID(model.getScopeID());
        soapModel.setVisibility(model.getVisibility());
        soapModel.setIsDefault(model.getIsDefault());

        return soapModel;
    }

    public static LFPackageScopeRuleSoap[] toSoapModels(
        LFPackageScopeRule[] models) {
        LFPackageScopeRuleSoap[] soapModels = new LFPackageScopeRuleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFPackageScopeRuleSoap[][] toSoapModels(
        LFPackageScopeRule[][] models) {
        LFPackageScopeRuleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFPackageScopeRuleSoap[models.length][models[0].length];
        } else {
            soapModels = new LFPackageScopeRuleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFPackageScopeRuleSoap[] toSoapModels(
        List<LFPackageScopeRule> models) {
        List<LFPackageScopeRuleSoap> soapModels = new ArrayList<LFPackageScopeRuleSoap>(models.size());

        for (LFPackageScopeRule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFPackageScopeRuleSoap[soapModels.size()]);
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

    public String getScope() {
        return _scope;
    }

    public void setScope(String scope) {
        _scope = scope;
    }

    public String getScopeID() {
        return _scopeID;
    }

    public void setScopeID(String scopeID) {
        _scopeID = scopeID;
    }

    public Boolean getVisibility() {
        return _visibility;
    }

    public void setVisibility(Boolean visibility) {
        _visibility = visibility;
    }

    public Boolean getIsDefault() {
        return _isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        _isDefault = isDefault;
    }
}

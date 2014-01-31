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
public class LFRoleSoap implements Serializable {
    private long _id;
    private Integer _liferayRoleID;
    private String _permission;
    private Boolean _isDefault;

    public LFRoleSoap() {
    }

    public static LFRoleSoap toSoapModel(LFRole model) {
        LFRoleSoap soapModel = new LFRoleSoap();

        soapModel.setId(model.getId());
        soapModel.setLiferayRoleID(model.getLiferayRoleID());
        soapModel.setPermission(model.getPermission());
        soapModel.setIsDefault(model.getIsDefault());

        return soapModel;
    }

    public static LFRoleSoap[] toSoapModels(LFRole[] models) {
        LFRoleSoap[] soapModels = new LFRoleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFRoleSoap[][] toSoapModels(LFRole[][] models) {
        LFRoleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFRoleSoap[models.length][models[0].length];
        } else {
            soapModels = new LFRoleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFRoleSoap[] toSoapModels(List<LFRole> models) {
        List<LFRoleSoap> soapModels = new ArrayList<LFRoleSoap>(models.size());

        for (LFRole model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFRoleSoap[soapModels.size()]);
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

    public Integer getLiferayRoleID() {
        return _liferayRoleID;
    }

    public void setLiferayRoleID(Integer liferayRoleID) {
        _liferayRoleID = liferayRoleID;
    }

    public String getPermission() {
        return _permission;
    }

    public void setPermission(String permission) {
        _permission = permission;
    }

    public Boolean getIsDefault() {
        return _isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        _isDefault = isDefault;
    }
}

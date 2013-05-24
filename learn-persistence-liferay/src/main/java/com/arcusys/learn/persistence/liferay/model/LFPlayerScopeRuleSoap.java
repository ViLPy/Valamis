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
public class LFPlayerScopeRuleSoap implements Serializable {
    private long _id;
    private String _playerID;
    private String _scope;

    public LFPlayerScopeRuleSoap() {
    }

    public static LFPlayerScopeRuleSoap toSoapModel(LFPlayerScopeRule model) {
        LFPlayerScopeRuleSoap soapModel = new LFPlayerScopeRuleSoap();

        soapModel.setId(model.getId());
        soapModel.setPlayerID(model.getPlayerID());
        soapModel.setScope(model.getScope());

        return soapModel;
    }

    public static LFPlayerScopeRuleSoap[] toSoapModels(
        LFPlayerScopeRule[] models) {
        LFPlayerScopeRuleSoap[] soapModels = new LFPlayerScopeRuleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFPlayerScopeRuleSoap[][] toSoapModels(
        LFPlayerScopeRule[][] models) {
        LFPlayerScopeRuleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFPlayerScopeRuleSoap[models.length][models[0].length];
        } else {
            soapModels = new LFPlayerScopeRuleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFPlayerScopeRuleSoap[] toSoapModels(
        List<LFPlayerScopeRule> models) {
        List<LFPlayerScopeRuleSoap> soapModels = new ArrayList<LFPlayerScopeRuleSoap>(models.size());

        for (LFPlayerScopeRule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFPlayerScopeRuleSoap[soapModels.size()]);
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

    public String getPlayerID() {
        return _playerID;
    }

    public void setPlayerID(String playerID) {
        _playerID = playerID;
    }

    public String getScope() {
        return _scope;
    }

    public void setScope(String scope) {
        _scope = scope;
    }
}

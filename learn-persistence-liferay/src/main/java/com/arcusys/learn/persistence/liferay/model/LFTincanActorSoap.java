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
public class LFTincanActorSoap implements Serializable {
    private long _id;
    private String _tincanID;
    private String _objectType;
    private String _name;
    private String _mbox;
    private String _mbox_sha1sum;
    private String _openid;
    private String _account;
    private String _memberOf;

    public LFTincanActorSoap() {
    }

    public static LFTincanActorSoap toSoapModel(LFTincanActor model) {
        LFTincanActorSoap soapModel = new LFTincanActorSoap();

        soapModel.setId(model.getId());
        soapModel.setTincanID(model.getTincanID());
        soapModel.setObjectType(model.getObjectType());
        soapModel.setName(model.getName());
        soapModel.setMbox(model.getMbox());
        soapModel.setMbox_sha1sum(model.getMbox_sha1sum());
        soapModel.setOpenid(model.getOpenid());
        soapModel.setAccount(model.getAccount());
        soapModel.setMemberOf(model.getMemberOf());

        return soapModel;
    }

    public static LFTincanActorSoap[] toSoapModels(LFTincanActor[] models) {
        LFTincanActorSoap[] soapModels = new LFTincanActorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanActorSoap[][] toSoapModels(LFTincanActor[][] models) {
        LFTincanActorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanActorSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanActorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanActorSoap[] toSoapModels(List<LFTincanActor> models) {
        List<LFTincanActorSoap> soapModels = new ArrayList<LFTincanActorSoap>(models.size());

        for (LFTincanActor model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanActorSoap[soapModels.size()]);
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

    public String getMbox() {
        return _mbox;
    }

    public void setMbox(String mbox) {
        _mbox = mbox;
    }

    public String getMbox_sha1sum() {
        return _mbox_sha1sum;
    }

    public void setMbox_sha1sum(String mbox_sha1sum) {
        _mbox_sha1sum = mbox_sha1sum;
    }

    public String getOpenid() {
        return _openid;
    }

    public void setOpenid(String openid) {
        _openid = openid;
    }

    public String getAccount() {
        return _account;
    }

    public void setAccount(String account) {
        _account = account;
    }

    public String getMemberOf() {
        return _memberOf;
    }

    public void setMemberOf(String memberOf) {
        _memberOf = memberOf;
    }
}

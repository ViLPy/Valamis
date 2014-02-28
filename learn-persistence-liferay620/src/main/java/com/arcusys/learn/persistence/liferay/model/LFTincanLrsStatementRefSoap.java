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
public class LFTincanLrsStatementRefSoap implements Serializable {
    private long _id;
    private String _uuid;

    public LFTincanLrsStatementRefSoap() {
    }

    public static LFTincanLrsStatementRefSoap toSoapModel(
        LFTincanLrsStatementRef model) {
        LFTincanLrsStatementRefSoap soapModel = new LFTincanLrsStatementRefSoap();

        soapModel.setId(model.getId());
        soapModel.setUuid(model.getUuid());

        return soapModel;
    }

    public static LFTincanLrsStatementRefSoap[] toSoapModels(
        LFTincanLrsStatementRef[] models) {
        LFTincanLrsStatementRefSoap[] soapModels = new LFTincanLrsStatementRefSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsStatementRefSoap[][] toSoapModels(
        LFTincanLrsStatementRef[][] models) {
        LFTincanLrsStatementRefSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsStatementRefSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsStatementRefSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsStatementRefSoap[] toSoapModels(
        List<LFTincanLrsStatementRef> models) {
        List<LFTincanLrsStatementRefSoap> soapModels = new ArrayList<LFTincanLrsStatementRefSoap>(models.size());

        for (LFTincanLrsStatementRef model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsStatementRefSoap[soapModels.size()]);
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

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }
}

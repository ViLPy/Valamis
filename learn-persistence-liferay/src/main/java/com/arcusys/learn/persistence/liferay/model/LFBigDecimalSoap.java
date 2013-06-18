package com.arcusys.learn.persistence.liferay.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

/**
* This class is used by SOAP remote services.
*
* @author    Brian Wing Shun Chan
* @generated
*/
public class LFBigDecimalSoap implements Serializable {
    private long _id;
    private BigDecimal _decimal;
    private String _text;

    public LFBigDecimalSoap() {
    }

    public static LFBigDecimalSoap toSoapModel(LFBigDecimal model) {
        LFBigDecimalSoap soapModel = new LFBigDecimalSoap();

        soapModel.setId(model.getId());
        soapModel.setDecimal(model.getDecimal());
        soapModel.setText(model.getText());

        return soapModel;
    }

    public static LFBigDecimalSoap[] toSoapModels(LFBigDecimal[] models) {
        LFBigDecimalSoap[] soapModels = new LFBigDecimalSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFBigDecimalSoap[][] toSoapModels(LFBigDecimal[][] models) {
        LFBigDecimalSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFBigDecimalSoap[models.length][models[0].length];
        } else {
            soapModels = new LFBigDecimalSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFBigDecimalSoap[] toSoapModels(List<LFBigDecimal> models) {
        List<LFBigDecimalSoap> soapModels = new ArrayList<LFBigDecimalSoap>(models.size());

        for (LFBigDecimal model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFBigDecimalSoap[soapModels.size()]);
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

    public BigDecimal getDecimal() {
        return _decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        _decimal = decimal;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }
}

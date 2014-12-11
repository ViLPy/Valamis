package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.persistence.LFLessonLimitPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LFLessonLimitSoap implements Serializable {
    private Long _itemID;
    private String _itemType;
    private Integer _passingLimit;
    private Integer _rerunInterval;
    private String _rerunIntervalType;

    public LFLessonLimitSoap() {
    }

    public static LFLessonLimitSoap toSoapModel(LFLessonLimit model) {
        LFLessonLimitSoap soapModel = new LFLessonLimitSoap();

        soapModel.setItemID(model.getItemID());
        soapModel.setItemType(model.getItemType());
        soapModel.setPassingLimit(model.getPassingLimit());
        soapModel.setRerunInterval(model.getRerunInterval());
        soapModel.setRerunIntervalType(model.getRerunIntervalType());

        return soapModel;
    }

    public static LFLessonLimitSoap[] toSoapModels(LFLessonLimit[] models) {
        LFLessonLimitSoap[] soapModels = new LFLessonLimitSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFLessonLimitSoap[][] toSoapModels(LFLessonLimit[][] models) {
        LFLessonLimitSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFLessonLimitSoap[models.length][models[0].length];
        } else {
            soapModels = new LFLessonLimitSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFLessonLimitSoap[] toSoapModels(List<LFLessonLimit> models) {
        List<LFLessonLimitSoap> soapModels = new ArrayList<LFLessonLimitSoap>(models.size());

        for (LFLessonLimit model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFLessonLimitSoap[soapModels.size()]);
    }

    public LFLessonLimitPK getPrimaryKey() {
        return new LFLessonLimitPK(_itemID, _itemType);
    }

    public void setPrimaryKey(LFLessonLimitPK pk) {
        setItemID(pk.itemID);
        setItemType(pk.itemType);
    }

    public Long getItemID() {
        return _itemID;
    }

    public void setItemID(Long itemID) {
        _itemID = itemID;
    }

    public String getItemType() {
        return _itemType;
    }

    public void setItemType(String itemType) {
        _itemType = itemType;
    }

    public Integer getPassingLimit() {
        return _passingLimit;
    }

    public void setPassingLimit(Integer passingLimit) {
        _passingLimit = passingLimit;
    }

    public Integer getRerunInterval() {
        return _rerunInterval;
    }

    public void setRerunInterval(Integer rerunInterval) {
        _rerunInterval = rerunInterval;
    }

    public String getRerunIntervalType() {
        return _rerunIntervalType;
    }

    public void setRerunIntervalType(String rerunIntervalType) {
        _rerunIntervalType = rerunIntervalType;
    }
}

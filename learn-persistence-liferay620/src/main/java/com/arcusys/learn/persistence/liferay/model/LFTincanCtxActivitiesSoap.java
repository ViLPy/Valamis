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
public class LFTincanCtxActivitiesSoap implements Serializable {
    private long _id;
    private String _parent;
    private String _grouping;
    private String _category;
    private String _other;

    public LFTincanCtxActivitiesSoap() {
    }

    public static LFTincanCtxActivitiesSoap toSoapModel(
        LFTincanCtxActivities model) {
        LFTincanCtxActivitiesSoap soapModel = new LFTincanCtxActivitiesSoap();

        soapModel.setId(model.getId());
        soapModel.setParent(model.getParent());
        soapModel.setGrouping(model.getGrouping());
        soapModel.setCategory(model.getCategory());
        soapModel.setOther(model.getOther());

        return soapModel;
    }

    public static LFTincanCtxActivitiesSoap[] toSoapModels(
        LFTincanCtxActivities[] models) {
        LFTincanCtxActivitiesSoap[] soapModels = new LFTincanCtxActivitiesSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanCtxActivitiesSoap[][] toSoapModels(
        LFTincanCtxActivities[][] models) {
        LFTincanCtxActivitiesSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanCtxActivitiesSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanCtxActivitiesSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanCtxActivitiesSoap[] toSoapModels(
        List<LFTincanCtxActivities> models) {
        List<LFTincanCtxActivitiesSoap> soapModels = new ArrayList<LFTincanCtxActivitiesSoap>(models.size());

        for (LFTincanCtxActivities model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanCtxActivitiesSoap[soapModels.size()]);
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

    public String getParent() {
        return _parent;
    }

    public void setParent(String parent) {
        _parent = parent;
    }

    public String getGrouping() {
        return _grouping;
    }

    public void setGrouping(String grouping) {
        _grouping = grouping;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public String getOther() {
        return _other;
    }

    public void setOther(String other) {
        _other = other;
    }
}

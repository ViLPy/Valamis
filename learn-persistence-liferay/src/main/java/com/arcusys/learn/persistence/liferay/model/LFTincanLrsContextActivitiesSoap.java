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
public class LFTincanLrsContextActivitiesSoap implements Serializable {
    private long _id;
    private String _parent;
    private String _grouping;
    private String _category;
    private String _other;

    public LFTincanLrsContextActivitiesSoap() {
    }

    public static LFTincanLrsContextActivitiesSoap toSoapModel(
        LFTincanLrsContextActivities model) {
        LFTincanLrsContextActivitiesSoap soapModel = new LFTincanLrsContextActivitiesSoap();

        soapModel.setId(model.getId());
        soapModel.setParent(model.getParent());
        soapModel.setGrouping(model.getGrouping());
        soapModel.setCategory(model.getCategory());
        soapModel.setOther(model.getOther());

        return soapModel;
    }

    public static LFTincanLrsContextActivitiesSoap[] toSoapModels(
        LFTincanLrsContextActivities[] models) {
        LFTincanLrsContextActivitiesSoap[] soapModels = new LFTincanLrsContextActivitiesSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsContextActivitiesSoap[][] toSoapModels(
        LFTincanLrsContextActivities[][] models) {
        LFTincanLrsContextActivitiesSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFTincanLrsContextActivitiesSoap[models.length][models[0].length];
        } else {
            soapModels = new LFTincanLrsContextActivitiesSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFTincanLrsContextActivitiesSoap[] toSoapModels(
        List<LFTincanLrsContextActivities> models) {
        List<LFTincanLrsContextActivitiesSoap> soapModels = new ArrayList<LFTincanLrsContextActivitiesSoap>(models.size());

        for (LFTincanLrsContextActivities model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFTincanLrsContextActivitiesSoap[soapModels.size()]);
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

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
public class LFActivityStateNodeSoap implements Serializable {
    private long _id;
    private Integer _parentID;
    private Integer _treeID;
    private String _availableChildrenIDs;

    public LFActivityStateNodeSoap() {
    }

    public static LFActivityStateNodeSoap toSoapModel(LFActivityStateNode model) {
        LFActivityStateNodeSoap soapModel = new LFActivityStateNodeSoap();

        soapModel.setId(model.getId());
        soapModel.setParentID(model.getParentID());
        soapModel.setTreeID(model.getTreeID());
        soapModel.setAvailableChildrenIDs(model.getAvailableChildrenIDs());

        return soapModel;
    }

    public static LFActivityStateNodeSoap[] toSoapModels(
        LFActivityStateNode[] models) {
        LFActivityStateNodeSoap[] soapModels = new LFActivityStateNodeSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFActivityStateNodeSoap[][] toSoapModels(
        LFActivityStateNode[][] models) {
        LFActivityStateNodeSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFActivityStateNodeSoap[models.length][models[0].length];
        } else {
            soapModels = new LFActivityStateNodeSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFActivityStateNodeSoap[] toSoapModels(
        List<LFActivityStateNode> models) {
        List<LFActivityStateNodeSoap> soapModels = new ArrayList<LFActivityStateNodeSoap>(models.size());

        for (LFActivityStateNode model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFActivityStateNodeSoap[soapModels.size()]);
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

    public Integer getParentID() {
        return _parentID;
    }

    public void setParentID(Integer parentID) {
        _parentID = parentID;
    }

    public Integer getTreeID() {
        return _treeID;
    }

    public void setTreeID(Integer treeID) {
        _treeID = treeID;
    }

    public String getAvailableChildrenIDs() {
        return _availableChildrenIDs;
    }

    public void setAvailableChildrenIDs(String availableChildrenIDs) {
        _availableChildrenIDs = availableChildrenIDs;
    }
}

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
public class LFSeqPermissionsSoap implements Serializable {
    private long _id;
    private Integer _sequencingID;
    private boolean _choiceForChildren;
    private boolean _choiceForNonDescendants;
    private boolean _flowForChildren;
    private boolean _forwardOnlyForChildren;

    public LFSeqPermissionsSoap() {
    }

    public static LFSeqPermissionsSoap toSoapModel(LFSeqPermissions model) {
        LFSeqPermissionsSoap soapModel = new LFSeqPermissionsSoap();

        soapModel.setId(model.getId());
        soapModel.setSequencingID(model.getSequencingID());
        soapModel.setChoiceForChildren(model.getChoiceForChildren());
        soapModel.setChoiceForNonDescendants(model.getChoiceForNonDescendants());
        soapModel.setFlowForChildren(model.getFlowForChildren());
        soapModel.setForwardOnlyForChildren(model.getForwardOnlyForChildren());

        return soapModel;
    }

    public static LFSeqPermissionsSoap[] toSoapModels(LFSeqPermissions[] models) {
        LFSeqPermissionsSoap[] soapModels = new LFSeqPermissionsSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSeqPermissionsSoap[][] toSoapModels(
        LFSeqPermissions[][] models) {
        LFSeqPermissionsSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSeqPermissionsSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSeqPermissionsSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSeqPermissionsSoap[] toSoapModels(
        List<LFSeqPermissions> models) {
        List<LFSeqPermissionsSoap> soapModels = new ArrayList<LFSeqPermissionsSoap>(models.size());

        for (LFSeqPermissions model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSeqPermissionsSoap[soapModels.size()]);
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

    public Integer getSequencingID() {
        return _sequencingID;
    }

    public void setSequencingID(Integer sequencingID) {
        _sequencingID = sequencingID;
    }

    public boolean getChoiceForChildren() {
        return _choiceForChildren;
    }

    public boolean isChoiceForChildren() {
        return _choiceForChildren;
    }

    public void setChoiceForChildren(boolean choiceForChildren) {
        _choiceForChildren = choiceForChildren;
    }

    public boolean getChoiceForNonDescendants() {
        return _choiceForNonDescendants;
    }

    public boolean isChoiceForNonDescendants() {
        return _choiceForNonDescendants;
    }

    public void setChoiceForNonDescendants(boolean choiceForNonDescendants) {
        _choiceForNonDescendants = choiceForNonDescendants;
    }

    public boolean getFlowForChildren() {
        return _flowForChildren;
    }

    public boolean isFlowForChildren() {
        return _flowForChildren;
    }

    public void setFlowForChildren(boolean flowForChildren) {
        _flowForChildren = flowForChildren;
    }

    public boolean getForwardOnlyForChildren() {
        return _forwardOnlyForChildren;
    }

    public boolean isForwardOnlyForChildren() {
        return _forwardOnlyForChildren;
    }

    public void setForwardOnlyForChildren(boolean forwardOnlyForChildren) {
        _forwardOnlyForChildren = forwardOnlyForChildren;
    }
}

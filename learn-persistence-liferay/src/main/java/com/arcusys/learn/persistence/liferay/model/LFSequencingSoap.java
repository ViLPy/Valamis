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
public class LFSequencingSoap implements Serializable {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private String _sharedId;
    private String _sharedSequencingIdReference;
    private boolean _onlyCurrentAttemptObjectiveProgressForChildren;
    private boolean _onlyCurrentAttemptAttemptProgressForChildren;
    private Integer _attemptLimit;
    private Long _durationLimitInMilliseconds;
    private Integer _rollupContributionID;
    private boolean _preventChildrenActivation;
    private boolean _constrainChoice;

    public LFSequencingSoap() {
    }

    public static LFSequencingSoap toSoapModel(LFSequencing model) {
        LFSequencingSoap soapModel = new LFSequencingSoap();

        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setActivityID(model.getActivityID());
        soapModel.setSharedId(model.getSharedId());
        soapModel.setSharedSequencingIdReference(model.getSharedSequencingIdReference());
        soapModel.setOnlyCurrentAttemptObjectiveProgressForChildren(model.getOnlyCurrentAttemptObjectiveProgressForChildren());
        soapModel.setOnlyCurrentAttemptAttemptProgressForChildren(model.getOnlyCurrentAttemptAttemptProgressForChildren());
        soapModel.setAttemptLimit(model.getAttemptLimit());
        soapModel.setDurationLimitInMilliseconds(model.getDurationLimitInMilliseconds());
        soapModel.setRollupContributionID(model.getRollupContributionID());
        soapModel.setPreventChildrenActivation(model.getPreventChildrenActivation());
        soapModel.setConstrainChoice(model.getConstrainChoice());

        return soapModel;
    }

    public static LFSequencingSoap[] toSoapModels(LFSequencing[] models) {
        LFSequencingSoap[] soapModels = new LFSequencingSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFSequencingSoap[][] toSoapModels(LFSequencing[][] models) {
        LFSequencingSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFSequencingSoap[models.length][models[0].length];
        } else {
            soapModels = new LFSequencingSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFSequencingSoap[] toSoapModels(List<LFSequencing> models) {
        List<LFSequencingSoap> soapModels = new ArrayList<LFSequencingSoap>(models.size());

        for (LFSequencing model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFSequencingSoap[soapModels.size()]);
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

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getActivityID() {
        return _activityID;
    }

    public void setActivityID(String activityID) {
        _activityID = activityID;
    }

    public String getSharedId() {
        return _sharedId;
    }

    public void setSharedId(String sharedId) {
        _sharedId = sharedId;
    }

    public String getSharedSequencingIdReference() {
        return _sharedSequencingIdReference;
    }

    public void setSharedSequencingIdReference(
        String sharedSequencingIdReference) {
        _sharedSequencingIdReference = sharedSequencingIdReference;
    }

    public boolean getOnlyCurrentAttemptObjectiveProgressForChildren() {
        return _onlyCurrentAttemptObjectiveProgressForChildren;
    }

    public boolean isOnlyCurrentAttemptObjectiveProgressForChildren() {
        return _onlyCurrentAttemptObjectiveProgressForChildren;
    }

    public void setOnlyCurrentAttemptObjectiveProgressForChildren(
        boolean onlyCurrentAttemptObjectiveProgressForChildren) {
        _onlyCurrentAttemptObjectiveProgressForChildren = onlyCurrentAttemptObjectiveProgressForChildren;
    }

    public boolean getOnlyCurrentAttemptAttemptProgressForChildren() {
        return _onlyCurrentAttemptAttemptProgressForChildren;
    }

    public boolean isOnlyCurrentAttemptAttemptProgressForChildren() {
        return _onlyCurrentAttemptAttemptProgressForChildren;
    }

    public void setOnlyCurrentAttemptAttemptProgressForChildren(
        boolean onlyCurrentAttemptAttemptProgressForChildren) {
        _onlyCurrentAttemptAttemptProgressForChildren = onlyCurrentAttemptAttemptProgressForChildren;
    }

    public Integer getAttemptLimit() {
        return _attemptLimit;
    }

    public void setAttemptLimit(Integer attemptLimit) {
        _attemptLimit = attemptLimit;
    }

    public Long getDurationLimitInMilliseconds() {
        return _durationLimitInMilliseconds;
    }

    public void setDurationLimitInMilliseconds(Long durationLimitInMilliseconds) {
        _durationLimitInMilliseconds = durationLimitInMilliseconds;
    }

    public Integer getRollupContributionID() {
        return _rollupContributionID;
    }

    public void setRollupContributionID(Integer rollupContributionID) {
        _rollupContributionID = rollupContributionID;
    }

    public boolean getPreventChildrenActivation() {
        return _preventChildrenActivation;
    }

    public boolean isPreventChildrenActivation() {
        return _preventChildrenActivation;
    }

    public void setPreventChildrenActivation(boolean preventChildrenActivation) {
        _preventChildrenActivation = preventChildrenActivation;
    }

    public boolean getConstrainChoice() {
        return _constrainChoice;
    }

    public boolean isConstrainChoice() {
        return _constrainChoice;
    }

    public void setConstrainChoice(boolean constrainChoice) {
        _constrainChoice = constrainChoice;
    }
}

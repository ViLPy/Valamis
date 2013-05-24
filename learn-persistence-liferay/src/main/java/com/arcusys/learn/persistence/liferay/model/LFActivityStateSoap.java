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
public class LFActivityStateSoap implements Serializable {
    private long _id;
    private Integer _packageID;
    private String _activityID;
    private Boolean _active;
    private Boolean _suspended;
    private Boolean _attemptCompleted;
    private BigDecimal _attemptCompletionAmount;
    private BigDecimal _attemptAbsoluteDuration;
    private BigDecimal _attemptExperiencedDuration;
    private BigDecimal _activityAbsoluteDuration;
    private BigDecimal _activityExperiencedDuration;
    private Integer _attemptCount;
    private Integer _activityStateNodeID;
    private Integer _activityStateTreeID;

    public LFActivityStateSoap() {
    }

    public static LFActivityStateSoap toSoapModel(LFActivityState model) {
        LFActivityStateSoap soapModel = new LFActivityStateSoap();

        soapModel.setId(model.getId());
        soapModel.setPackageID(model.getPackageID());
        soapModel.setActivityID(model.getActivityID());
        soapModel.setActive(model.getActive());
        soapModel.setSuspended(model.getSuspended());
        soapModel.setAttemptCompleted(model.getAttemptCompleted());
        soapModel.setAttemptCompletionAmount(model.getAttemptCompletionAmount());
        soapModel.setAttemptAbsoluteDuration(model.getAttemptAbsoluteDuration());
        soapModel.setAttemptExperiencedDuration(model.getAttemptExperiencedDuration());
        soapModel.setActivityAbsoluteDuration(model.getActivityAbsoluteDuration());
        soapModel.setActivityExperiencedDuration(model.getActivityExperiencedDuration());
        soapModel.setAttemptCount(model.getAttemptCount());
        soapModel.setActivityStateNodeID(model.getActivityStateNodeID());
        soapModel.setActivityStateTreeID(model.getActivityStateTreeID());

        return soapModel;
    }

    public static LFActivityStateSoap[] toSoapModels(LFActivityState[] models) {
        LFActivityStateSoap[] soapModels = new LFActivityStateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LFActivityStateSoap[][] toSoapModels(
        LFActivityState[][] models) {
        LFActivityStateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LFActivityStateSoap[models.length][models[0].length];
        } else {
            soapModels = new LFActivityStateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LFActivityStateSoap[] toSoapModels(
        List<LFActivityState> models) {
        List<LFActivityStateSoap> soapModels = new ArrayList<LFActivityStateSoap>(models.size());

        for (LFActivityState model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LFActivityStateSoap[soapModels.size()]);
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

    public Boolean getActive() {
        return _active;
    }

    public void setActive(Boolean active) {
        _active = active;
    }

    public Boolean getSuspended() {
        return _suspended;
    }

    public void setSuspended(Boolean suspended) {
        _suspended = suspended;
    }

    public Boolean getAttemptCompleted() {
        return _attemptCompleted;
    }

    public void setAttemptCompleted(Boolean attemptCompleted) {
        _attemptCompleted = attemptCompleted;
    }

    public BigDecimal getAttemptCompletionAmount() {
        return _attemptCompletionAmount;
    }

    public void setAttemptCompletionAmount(BigDecimal attemptCompletionAmount) {
        _attemptCompletionAmount = attemptCompletionAmount;
    }

    public BigDecimal getAttemptAbsoluteDuration() {
        return _attemptAbsoluteDuration;
    }

    public void setAttemptAbsoluteDuration(BigDecimal attemptAbsoluteDuration) {
        _attemptAbsoluteDuration = attemptAbsoluteDuration;
    }

    public BigDecimal getAttemptExperiencedDuration() {
        return _attemptExperiencedDuration;
    }

    public void setAttemptExperiencedDuration(
        BigDecimal attemptExperiencedDuration) {
        _attemptExperiencedDuration = attemptExperiencedDuration;
    }

    public BigDecimal getActivityAbsoluteDuration() {
        return _activityAbsoluteDuration;
    }

    public void setActivityAbsoluteDuration(BigDecimal activityAbsoluteDuration) {
        _activityAbsoluteDuration = activityAbsoluteDuration;
    }

    public BigDecimal getActivityExperiencedDuration() {
        return _activityExperiencedDuration;
    }

    public void setActivityExperiencedDuration(
        BigDecimal activityExperiencedDuration) {
        _activityExperiencedDuration = activityExperiencedDuration;
    }

    public Integer getAttemptCount() {
        return _attemptCount;
    }

    public void setAttemptCount(Integer attemptCount) {
        _attemptCount = attemptCount;
    }

    public Integer getActivityStateNodeID() {
        return _activityStateNodeID;
    }

    public void setActivityStateNodeID(Integer activityStateNodeID) {
        _activityStateNodeID = activityStateNodeID;
    }

    public Integer getActivityStateTreeID() {
        return _activityStateTreeID;
    }

    public void setActivityStateTreeID(Integer activityStateTreeID) {
        _activityStateTreeID = activityStateTreeID;
    }
}

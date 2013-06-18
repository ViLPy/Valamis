package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFActivityState}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFActivityState
* @generated
*/
public class LFActivityStateWrapper implements LFActivityState,
    ModelWrapper<LFActivityState> {
    private LFActivityState _lfActivityState;

    public LFActivityStateWrapper(LFActivityState lfActivityState) {
        _lfActivityState = lfActivityState;
    }

    public Class<?> getModelClass() {
        return LFActivityState.class;
    }

    public String getModelClassName() {
        return LFActivityState.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("activityID", getActivityID());
        attributes.put("active", getActive());
        attributes.put("suspended", getSuspended());
        attributes.put("attemptCompleted", getAttemptCompleted());
        attributes.put("attemptCompletionAmount", getAttemptCompletionAmount());
        attributes.put("attemptAbsoluteDuration", getAttemptAbsoluteDuration());
        attributes.put("attemptExperiencedDuration",
            getAttemptExperiencedDuration());
        attributes.put("activityAbsoluteDuration", getActivityAbsoluteDuration());
        attributes.put("activityExperiencedDuration",
            getActivityExperiencedDuration());
        attributes.put("attemptCount", getAttemptCount());
        attributes.put("activityStateNodeID", getActivityStateNodeID());
        attributes.put("activityStateTreeID", getActivityStateTreeID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        Boolean active = (Boolean) attributes.get("active");

        if (active != null) {
            setActive(active);
        }

        Boolean suspended = (Boolean) attributes.get("suspended");

        if (suspended != null) {
            setSuspended(suspended);
        }

        Boolean attemptCompleted = (Boolean) attributes.get("attemptCompleted");

        if (attemptCompleted != null) {
            setAttemptCompleted(attemptCompleted);
        }

        BigDecimal attemptCompletionAmount = (BigDecimal) attributes.get(
                "attemptCompletionAmount");

        if (attemptCompletionAmount != null) {
            setAttemptCompletionAmount(attemptCompletionAmount);
        }

        BigDecimal attemptAbsoluteDuration = (BigDecimal) attributes.get(
                "attemptAbsoluteDuration");

        if (attemptAbsoluteDuration != null) {
            setAttemptAbsoluteDuration(attemptAbsoluteDuration);
        }

        BigDecimal attemptExperiencedDuration = (BigDecimal) attributes.get(
                "attemptExperiencedDuration");

        if (attemptExperiencedDuration != null) {
            setAttemptExperiencedDuration(attemptExperiencedDuration);
        }

        BigDecimal activityAbsoluteDuration = (BigDecimal) attributes.get(
                "activityAbsoluteDuration");

        if (activityAbsoluteDuration != null) {
            setActivityAbsoluteDuration(activityAbsoluteDuration);
        }

        BigDecimal activityExperiencedDuration = (BigDecimal) attributes.get(
                "activityExperiencedDuration");

        if (activityExperiencedDuration != null) {
            setActivityExperiencedDuration(activityExperiencedDuration);
        }

        Integer attemptCount = (Integer) attributes.get("attemptCount");

        if (attemptCount != null) {
            setAttemptCount(attemptCount);
        }

        Integer activityStateNodeID = (Integer) attributes.get(
                "activityStateNodeID");

        if (activityStateNodeID != null) {
            setActivityStateNodeID(activityStateNodeID);
        }

        Integer activityStateTreeID = (Integer) attributes.get(
                "activityStateTreeID");

        if (activityStateTreeID != null) {
            setActivityStateTreeID(activityStateTreeID);
        }
    }

    /**
     * Returns the primary key of this l f activity state.
     *
     * @return the primary key of this l f activity state
     */
    public long getPrimaryKey() {
        return _lfActivityState.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f activity state.
     *
     * @param primaryKey the primary key of this l f activity state
     */
    public void setPrimaryKey(long primaryKey) {
        _lfActivityState.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f activity state.
     *
     * @return the ID of this l f activity state
     */
    public long getId() {
        return _lfActivityState.getId();
    }

    /**
     * Sets the ID of this l f activity state.
     *
     * @param id the ID of this l f activity state
     */
    public void setId(long id) {
        _lfActivityState.setId(id);
    }

    /**
     * Returns the package i d of this l f activity state.
     *
     * @return the package i d of this l f activity state
     */
    public java.lang.Integer getPackageID() {
        return _lfActivityState.getPackageID();
    }

    /**
     * Sets the package i d of this l f activity state.
     *
     * @param packageID the package i d of this l f activity state
     */
    public void setPackageID(java.lang.Integer packageID) {
        _lfActivityState.setPackageID(packageID);
    }

    /**
     * Returns the activity i d of this l f activity state.
     *
     * @return the activity i d of this l f activity state
     */
    public java.lang.String getActivityID() {
        return _lfActivityState.getActivityID();
    }

    /**
     * Sets the activity i d of this l f activity state.
     *
     * @param activityID the activity i d of this l f activity state
     */
    public void setActivityID(java.lang.String activityID) {
        _lfActivityState.setActivityID(activityID);
    }

    /**
     * Returns the active of this l f activity state.
     *
     * @return the active of this l f activity state
     */
    public java.lang.Boolean getActive() {
        return _lfActivityState.getActive();
    }

    /**
     * Sets the active of this l f activity state.
     *
     * @param active the active of this l f activity state
     */
    public void setActive(java.lang.Boolean active) {
        _lfActivityState.setActive(active);
    }

    /**
     * Returns the suspended of this l f activity state.
     *
     * @return the suspended of this l f activity state
     */
    public java.lang.Boolean getSuspended() {
        return _lfActivityState.getSuspended();
    }

    /**
     * Sets the suspended of this l f activity state.
     *
     * @param suspended the suspended of this l f activity state
     */
    public void setSuspended(java.lang.Boolean suspended) {
        _lfActivityState.setSuspended(suspended);
    }

    /**
     * Returns the attempt completed of this l f activity state.
     *
     * @return the attempt completed of this l f activity state
     */
    public java.lang.Boolean getAttemptCompleted() {
        return _lfActivityState.getAttemptCompleted();
    }

    /**
     * Sets the attempt completed of this l f activity state.
     *
     * @param attemptCompleted the attempt completed of this l f activity state
     */
    public void setAttemptCompleted(java.lang.Boolean attemptCompleted) {
        _lfActivityState.setAttemptCompleted(attemptCompleted);
    }

    /**
     * Returns the attempt completion amount of this l f activity state.
     *
     * @return the attempt completion amount of this l f activity state
     */
    public java.math.BigDecimal getAttemptCompletionAmount() {
        return _lfActivityState.getAttemptCompletionAmount();
    }

    /**
     * Sets the attempt completion amount of this l f activity state.
     *
     * @param attemptCompletionAmount the attempt completion amount of this l f activity state
     */
    public void setAttemptCompletionAmount(
        java.math.BigDecimal attemptCompletionAmount) {
        _lfActivityState.setAttemptCompletionAmount(attemptCompletionAmount);
    }

    /**
     * Returns the attempt absolute duration of this l f activity state.
     *
     * @return the attempt absolute duration of this l f activity state
     */
    public java.math.BigDecimal getAttemptAbsoluteDuration() {
        return _lfActivityState.getAttemptAbsoluteDuration();
    }

    /**
     * Sets the attempt absolute duration of this l f activity state.
     *
     * @param attemptAbsoluteDuration the attempt absolute duration of this l f activity state
     */
    public void setAttemptAbsoluteDuration(
        java.math.BigDecimal attemptAbsoluteDuration) {
        _lfActivityState.setAttemptAbsoluteDuration(attemptAbsoluteDuration);
    }

    /**
     * Returns the attempt experienced duration of this l f activity state.
     *
     * @return the attempt experienced duration of this l f activity state
     */
    public java.math.BigDecimal getAttemptExperiencedDuration() {
        return _lfActivityState.getAttemptExperiencedDuration();
    }

    /**
     * Sets the attempt experienced duration of this l f activity state.
     *
     * @param attemptExperiencedDuration the attempt experienced duration of this l f activity state
     */
    public void setAttemptExperiencedDuration(
        java.math.BigDecimal attemptExperiencedDuration) {
        _lfActivityState.setAttemptExperiencedDuration(attemptExperiencedDuration);
    }

    /**
     * Returns the activity absolute duration of this l f activity state.
     *
     * @return the activity absolute duration of this l f activity state
     */
    public java.math.BigDecimal getActivityAbsoluteDuration() {
        return _lfActivityState.getActivityAbsoluteDuration();
    }

    /**
     * Sets the activity absolute duration of this l f activity state.
     *
     * @param activityAbsoluteDuration the activity absolute duration of this l f activity state
     */
    public void setActivityAbsoluteDuration(
        java.math.BigDecimal activityAbsoluteDuration) {
        _lfActivityState.setActivityAbsoluteDuration(activityAbsoluteDuration);
    }

    /**
     * Returns the activity experienced duration of this l f activity state.
     *
     * @return the activity experienced duration of this l f activity state
     */
    public java.math.BigDecimal getActivityExperiencedDuration() {
        return _lfActivityState.getActivityExperiencedDuration();
    }

    /**
     * Sets the activity experienced duration of this l f activity state.
     *
     * @param activityExperiencedDuration the activity experienced duration of this l f activity state
     */
    public void setActivityExperiencedDuration(
        java.math.BigDecimal activityExperiencedDuration) {
        _lfActivityState.setActivityExperiencedDuration(activityExperiencedDuration);
    }

    /**
     * Returns the attempt count of this l f activity state.
     *
     * @return the attempt count of this l f activity state
     */
    public java.lang.Integer getAttemptCount() {
        return _lfActivityState.getAttemptCount();
    }

    /**
     * Sets the attempt count of this l f activity state.
     *
     * @param attemptCount the attempt count of this l f activity state
     */
    public void setAttemptCount(java.lang.Integer attemptCount) {
        _lfActivityState.setAttemptCount(attemptCount);
    }

    /**
     * Returns the activity state node i d of this l f activity state.
     *
     * @return the activity state node i d of this l f activity state
     */
    public java.lang.Integer getActivityStateNodeID() {
        return _lfActivityState.getActivityStateNodeID();
    }

    /**
     * Sets the activity state node i d of this l f activity state.
     *
     * @param activityStateNodeID the activity state node i d of this l f activity state
     */
    public void setActivityStateNodeID(java.lang.Integer activityStateNodeID) {
        _lfActivityState.setActivityStateNodeID(activityStateNodeID);
    }

    /**
     * Returns the activity state tree i d of this l f activity state.
     *
     * @return the activity state tree i d of this l f activity state
     */
    public java.lang.Integer getActivityStateTreeID() {
        return _lfActivityState.getActivityStateTreeID();
    }

    /**
     * Sets the activity state tree i d of this l f activity state.
     *
     * @param activityStateTreeID the activity state tree i d of this l f activity state
     */
    public void setActivityStateTreeID(java.lang.Integer activityStateTreeID) {
        _lfActivityState.setActivityStateTreeID(activityStateTreeID);
    }

    public boolean isNew() {
        return _lfActivityState.isNew();
    }

    public void setNew(boolean n) {
        _lfActivityState.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfActivityState.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfActivityState.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfActivityState.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivityState.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivityState.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivityState.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivityState.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityStateWrapper((LFActivityState) _lfActivityState.clone());
    }

    public int compareTo(LFActivityState lfActivityState) {
        return _lfActivityState.compareTo(lfActivityState);
    }

    @Override
    public int hashCode() {
        return _lfActivityState.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFActivityState> toCacheModel() {
        return _lfActivityState.toCacheModel();
    }

    public LFActivityState toEscapedModel() {
        return new LFActivityStateWrapper(_lfActivityState.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivityState.toString();
    }

    public java.lang.String toXmlString() {
        return _lfActivityState.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivityState.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFActivityState getWrappedLFActivityState() {
        return _lfActivityState;
    }

    public LFActivityState getWrappedModel() {
        return _lfActivityState;
    }

    public void resetOriginalValues() {
        _lfActivityState.resetOriginalValues();
    }
}

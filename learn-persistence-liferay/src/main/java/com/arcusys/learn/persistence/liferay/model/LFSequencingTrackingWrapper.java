package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFSequencingTracking}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFSequencingTracking
* @generated
*/
public class LFSequencingTrackingWrapper implements LFSequencingTracking,
    ModelWrapper<LFSequencingTracking> {
    private LFSequencingTracking _lfSequencingTracking;

    public LFSequencingTrackingWrapper(
        LFSequencingTracking lfSequencingTracking) {
        _lfSequencingTracking = lfSequencingTracking;
    }

    public Class<?> getModelClass() {
        return LFSequencingTracking.class;
    }

    public String getModelClassName() {
        return LFSequencingTracking.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("completionSetByContent", getCompletionSetByContent());
        attributes.put("objectiveSetByContent", getObjectiveSetByContent());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean completionSetByContent = (Boolean) attributes.get(
                "completionSetByContent");

        if (completionSetByContent != null) {
            setCompletionSetByContent(completionSetByContent);
        }

        Boolean objectiveSetByContent = (Boolean) attributes.get(
                "objectiveSetByContent");

        if (objectiveSetByContent != null) {
            setObjectiveSetByContent(objectiveSetByContent);
        }
    }

    /**
     * Returns the primary key of this l f sequencing tracking.
     *
     * @return the primary key of this l f sequencing tracking
     */
    public long getPrimaryKey() {
        return _lfSequencingTracking.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f sequencing tracking.
     *
     * @param primaryKey the primary key of this l f sequencing tracking
     */
    public void setPrimaryKey(long primaryKey) {
        _lfSequencingTracking.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f sequencing tracking.
     *
     * @return the ID of this l f sequencing tracking
     */
    public long getId() {
        return _lfSequencingTracking.getId();
    }

    /**
     * Sets the ID of this l f sequencing tracking.
     *
     * @param id the ID of this l f sequencing tracking
     */
    public void setId(long id) {
        _lfSequencingTracking.setId(id);
    }

    /**
     * Returns the sequencing i d of this l f sequencing tracking.
     *
     * @return the sequencing i d of this l f sequencing tracking
     */
    public java.lang.Integer getSequencingID() {
        return _lfSequencingTracking.getSequencingID();
    }

    /**
     * Sets the sequencing i d of this l f sequencing tracking.
     *
     * @param sequencingID the sequencing i d of this l f sequencing tracking
     */
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfSequencingTracking.setSequencingID(sequencingID);
    }

    /**
     * Returns the completion set by content of this l f sequencing tracking.
     *
     * @return the completion set by content of this l f sequencing tracking
     */
    public boolean getCompletionSetByContent() {
        return _lfSequencingTracking.getCompletionSetByContent();
    }

    /**
     * Returns <code>true</code> if this l f sequencing tracking is completion set by content.
     *
     * @return <code>true</code> if this l f sequencing tracking is completion set by content; <code>false</code> otherwise
     */
    public boolean isCompletionSetByContent() {
        return _lfSequencingTracking.isCompletionSetByContent();
    }

    /**
     * Sets whether this l f sequencing tracking is completion set by content.
     *
     * @param completionSetByContent the completion set by content of this l f sequencing tracking
     */
    public void setCompletionSetByContent(boolean completionSetByContent) {
        _lfSequencingTracking.setCompletionSetByContent(completionSetByContent);
    }

    /**
     * Returns the objective set by content of this l f sequencing tracking.
     *
     * @return the objective set by content of this l f sequencing tracking
     */
    public boolean getObjectiveSetByContent() {
        return _lfSequencingTracking.getObjectiveSetByContent();
    }

    /**
     * Returns <code>true</code> if this l f sequencing tracking is objective set by content.
     *
     * @return <code>true</code> if this l f sequencing tracking is objective set by content; <code>false</code> otherwise
     */
    public boolean isObjectiveSetByContent() {
        return _lfSequencingTracking.isObjectiveSetByContent();
    }

    /**
     * Sets whether this l f sequencing tracking is objective set by content.
     *
     * @param objectiveSetByContent the objective set by content of this l f sequencing tracking
     */
    public void setObjectiveSetByContent(boolean objectiveSetByContent) {
        _lfSequencingTracking.setObjectiveSetByContent(objectiveSetByContent);
    }

    public boolean isNew() {
        return _lfSequencingTracking.isNew();
    }

    public void setNew(boolean n) {
        _lfSequencingTracking.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfSequencingTracking.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfSequencingTracking.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfSequencingTracking.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSequencingTracking.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSequencingTracking.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSequencingTracking.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSequencingTracking.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSequencingTrackingWrapper((LFSequencingTracking) _lfSequencingTracking.clone());
    }

    public int compareTo(LFSequencingTracking lfSequencingTracking) {
        return _lfSequencingTracking.compareTo(lfSequencingTracking);
    }

    @Override
    public int hashCode() {
        return _lfSequencingTracking.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFSequencingTracking> toCacheModel() {
        return _lfSequencingTracking.toCacheModel();
    }

    public LFSequencingTracking toEscapedModel() {
        return new LFSequencingTrackingWrapper(_lfSequencingTracking.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSequencingTracking.toString();
    }

    public java.lang.String toXmlString() {
        return _lfSequencingTracking.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingTracking.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFSequencingTracking getWrappedLFSequencingTracking() {
        return _lfSequencingTracking;
    }

    public LFSequencingTracking getWrappedModel() {
        return _lfSequencingTracking;
    }

    public void resetOriginalValues() {
        _lfSequencingTracking.resetOriginalValues();
    }
}

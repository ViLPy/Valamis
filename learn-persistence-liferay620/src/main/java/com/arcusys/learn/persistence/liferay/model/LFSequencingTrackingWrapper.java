package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSequencingTracking}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencingTracking
 * @generated
 */
public class LFSequencingTrackingWrapper implements LFSequencingTracking,
    ModelWrapper<LFSequencingTracking> {
    private LFSequencingTracking _lfSequencingTracking;

    public LFSequencingTrackingWrapper(
        LFSequencingTracking lfSequencingTracking) {
        _lfSequencingTracking = lfSequencingTracking;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSequencingTracking.class;
    }

    @Override
    public String getModelClassName() {
        return LFSequencingTracking.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("completionSetByContent", getCompletionSetByContent());
        attributes.put("objectiveSetByContent", getObjectiveSetByContent());

        return attributes;
    }

    @Override
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
    @Override
    public long getPrimaryKey() {
        return _lfSequencingTracking.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f sequencing tracking.
    *
    * @param primaryKey the primary key of this l f sequencing tracking
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSequencingTracking.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f sequencing tracking.
    *
    * @return the ID of this l f sequencing tracking
    */
    @Override
    public long getId() {
        return _lfSequencingTracking.getId();
    }

    /**
    * Sets the ID of this l f sequencing tracking.
    *
    * @param id the ID of this l f sequencing tracking
    */
    @Override
    public void setId(long id) {
        _lfSequencingTracking.setId(id);
    }

    /**
    * Returns the sequencing i d of this l f sequencing tracking.
    *
    * @return the sequencing i d of this l f sequencing tracking
    */
    @Override
    public java.lang.Integer getSequencingID() {
        return _lfSequencingTracking.getSequencingID();
    }

    /**
    * Sets the sequencing i d of this l f sequencing tracking.
    *
    * @param sequencingID the sequencing i d of this l f sequencing tracking
    */
    @Override
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfSequencingTracking.setSequencingID(sequencingID);
    }

    /**
    * Returns the completion set by content of this l f sequencing tracking.
    *
    * @return the completion set by content of this l f sequencing tracking
    */
    @Override
    public boolean getCompletionSetByContent() {
        return _lfSequencingTracking.getCompletionSetByContent();
    }

    /**
    * Returns <code>true</code> if this l f sequencing tracking is completion set by content.
    *
    * @return <code>true</code> if this l f sequencing tracking is completion set by content; <code>false</code> otherwise
    */
    @Override
    public boolean isCompletionSetByContent() {
        return _lfSequencingTracking.isCompletionSetByContent();
    }

    /**
    * Sets whether this l f sequencing tracking is completion set by content.
    *
    * @param completionSetByContent the completion set by content of this l f sequencing tracking
    */
    @Override
    public void setCompletionSetByContent(boolean completionSetByContent) {
        _lfSequencingTracking.setCompletionSetByContent(completionSetByContent);
    }

    /**
    * Returns the objective set by content of this l f sequencing tracking.
    *
    * @return the objective set by content of this l f sequencing tracking
    */
    @Override
    public boolean getObjectiveSetByContent() {
        return _lfSequencingTracking.getObjectiveSetByContent();
    }

    /**
    * Returns <code>true</code> if this l f sequencing tracking is objective set by content.
    *
    * @return <code>true</code> if this l f sequencing tracking is objective set by content; <code>false</code> otherwise
    */
    @Override
    public boolean isObjectiveSetByContent() {
        return _lfSequencingTracking.isObjectiveSetByContent();
    }

    /**
    * Sets whether this l f sequencing tracking is objective set by content.
    *
    * @param objectiveSetByContent the objective set by content of this l f sequencing tracking
    */
    @Override
    public void setObjectiveSetByContent(boolean objectiveSetByContent) {
        _lfSequencingTracking.setObjectiveSetByContent(objectiveSetByContent);
    }

    @Override
    public boolean isNew() {
        return _lfSequencingTracking.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSequencingTracking.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSequencingTracking.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSequencingTracking.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSequencingTracking.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSequencingTracking.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSequencingTracking.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSequencingTracking.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSequencingTracking.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSequencingTracking.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSequencingTracking.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSequencingTrackingWrapper((LFSequencingTracking) _lfSequencingTracking.clone());
    }

    @Override
    public int compareTo(LFSequencingTracking lfSequencingTracking) {
        return _lfSequencingTracking.compareTo(lfSequencingTracking);
    }

    @Override
    public int hashCode() {
        return _lfSequencingTracking.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSequencingTracking> toCacheModel() {
        return _lfSequencingTracking.toCacheModel();
    }

    @Override
    public LFSequencingTracking toEscapedModel() {
        return new LFSequencingTrackingWrapper(_lfSequencingTracking.toEscapedModel());
    }

    @Override
    public LFSequencingTracking toUnescapedModel() {
        return new LFSequencingTrackingWrapper(_lfSequencingTracking.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSequencingTracking.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSequencingTracking.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencingTracking.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSequencingTrackingWrapper)) {
            return false;
        }

        LFSequencingTrackingWrapper lfSequencingTrackingWrapper = (LFSequencingTrackingWrapper) obj;

        if (Validator.equals(_lfSequencingTracking,
                    lfSequencingTrackingWrapper._lfSequencingTracking)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSequencingTracking getWrappedLFSequencingTracking() {
        return _lfSequencingTracking;
    }

    @Override
    public LFSequencingTracking getWrappedModel() {
        return _lfSequencingTracking;
    }

    @Override
    public void resetOriginalValues() {
        _lfSequencingTracking.resetOriginalValues();
    }
}

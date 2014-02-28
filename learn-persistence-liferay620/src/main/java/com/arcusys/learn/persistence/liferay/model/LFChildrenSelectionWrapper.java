package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFChildrenSelection}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFChildrenSelection
 * @generated
 */
public class LFChildrenSelectionWrapper implements LFChildrenSelection,
    ModelWrapper<LFChildrenSelection> {
    private LFChildrenSelection _lfChildrenSelection;

    public LFChildrenSelectionWrapper(LFChildrenSelection lfChildrenSelection) {
        _lfChildrenSelection = lfChildrenSelection;
    }

    @Override
    public Class<?> getModelClass() {
        return LFChildrenSelection.class;
    }

    @Override
    public String getModelClassName() {
        return LFChildrenSelection.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("takeCount", getTakeCount());
        attributes.put("takeTimingOnEachAttempt", getTakeTimingOnEachAttempt());
        attributes.put("reorderOnEachAttempt", getReorderOnEachAttempt());

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

        Integer takeCount = (Integer) attributes.get("takeCount");

        if (takeCount != null) {
            setTakeCount(takeCount);
        }

        String takeTimingOnEachAttempt = (String) attributes.get(
                "takeTimingOnEachAttempt");

        if (takeTimingOnEachAttempt != null) {
            setTakeTimingOnEachAttempt(takeTimingOnEachAttempt);
        }

        String reorderOnEachAttempt = (String) attributes.get(
                "reorderOnEachAttempt");

        if (reorderOnEachAttempt != null) {
            setReorderOnEachAttempt(reorderOnEachAttempt);
        }
    }

    /**
    * Returns the primary key of this l f children selection.
    *
    * @return the primary key of this l f children selection
    */
    @Override
    public long getPrimaryKey() {
        return _lfChildrenSelection.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f children selection.
    *
    * @param primaryKey the primary key of this l f children selection
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfChildrenSelection.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f children selection.
    *
    * @return the ID of this l f children selection
    */
    @Override
    public long getId() {
        return _lfChildrenSelection.getId();
    }

    /**
    * Sets the ID of this l f children selection.
    *
    * @param id the ID of this l f children selection
    */
    @Override
    public void setId(long id) {
        _lfChildrenSelection.setId(id);
    }

    /**
    * Returns the sequencing i d of this l f children selection.
    *
    * @return the sequencing i d of this l f children selection
    */
    @Override
    public java.lang.Integer getSequencingID() {
        return _lfChildrenSelection.getSequencingID();
    }

    /**
    * Sets the sequencing i d of this l f children selection.
    *
    * @param sequencingID the sequencing i d of this l f children selection
    */
    @Override
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfChildrenSelection.setSequencingID(sequencingID);
    }

    /**
    * Returns the take count of this l f children selection.
    *
    * @return the take count of this l f children selection
    */
    @Override
    public java.lang.Integer getTakeCount() {
        return _lfChildrenSelection.getTakeCount();
    }

    /**
    * Sets the take count of this l f children selection.
    *
    * @param takeCount the take count of this l f children selection
    */
    @Override
    public void setTakeCount(java.lang.Integer takeCount) {
        _lfChildrenSelection.setTakeCount(takeCount);
    }

    /**
    * Returns the take timing on each attempt of this l f children selection.
    *
    * @return the take timing on each attempt of this l f children selection
    */
    @Override
    public java.lang.String getTakeTimingOnEachAttempt() {
        return _lfChildrenSelection.getTakeTimingOnEachAttempt();
    }

    /**
    * Sets the take timing on each attempt of this l f children selection.
    *
    * @param takeTimingOnEachAttempt the take timing on each attempt of this l f children selection
    */
    @Override
    public void setTakeTimingOnEachAttempt(
        java.lang.String takeTimingOnEachAttempt) {
        _lfChildrenSelection.setTakeTimingOnEachAttempt(takeTimingOnEachAttempt);
    }

    /**
    * Returns the reorder on each attempt of this l f children selection.
    *
    * @return the reorder on each attempt of this l f children selection
    */
    @Override
    public java.lang.String getReorderOnEachAttempt() {
        return _lfChildrenSelection.getReorderOnEachAttempt();
    }

    /**
    * Sets the reorder on each attempt of this l f children selection.
    *
    * @param reorderOnEachAttempt the reorder on each attempt of this l f children selection
    */
    @Override
    public void setReorderOnEachAttempt(java.lang.String reorderOnEachAttempt) {
        _lfChildrenSelection.setReorderOnEachAttempt(reorderOnEachAttempt);
    }

    @Override
    public boolean isNew() {
        return _lfChildrenSelection.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfChildrenSelection.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfChildrenSelection.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfChildrenSelection.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfChildrenSelection.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfChildrenSelection.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfChildrenSelection.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfChildrenSelection.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfChildrenSelection.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfChildrenSelection.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfChildrenSelection.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFChildrenSelectionWrapper((LFChildrenSelection) _lfChildrenSelection.clone());
    }

    @Override
    public int compareTo(LFChildrenSelection lfChildrenSelection) {
        return _lfChildrenSelection.compareTo(lfChildrenSelection);
    }

    @Override
    public int hashCode() {
        return _lfChildrenSelection.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFChildrenSelection> toCacheModel() {
        return _lfChildrenSelection.toCacheModel();
    }

    @Override
    public LFChildrenSelection toEscapedModel() {
        return new LFChildrenSelectionWrapper(_lfChildrenSelection.toEscapedModel());
    }

    @Override
    public LFChildrenSelection toUnescapedModel() {
        return new LFChildrenSelectionWrapper(_lfChildrenSelection.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfChildrenSelection.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfChildrenSelection.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfChildrenSelection.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFChildrenSelectionWrapper)) {
            return false;
        }

        LFChildrenSelectionWrapper lfChildrenSelectionWrapper = (LFChildrenSelectionWrapper) obj;

        if (Validator.equals(_lfChildrenSelection,
                    lfChildrenSelectionWrapper._lfChildrenSelection)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFChildrenSelection getWrappedLFChildrenSelection() {
        return _lfChildrenSelection;
    }

    @Override
    public LFChildrenSelection getWrappedModel() {
        return _lfChildrenSelection;
    }

    @Override
    public void resetOriginalValues() {
        _lfChildrenSelection.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFChildrenSelection}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFChildrenSelection
* @generated
*/
public class LFChildrenSelectionWrapper implements LFChildrenSelection,
    ModelWrapper<LFChildrenSelection> {
    private LFChildrenSelection _lfChildrenSelection;

    public LFChildrenSelectionWrapper(LFChildrenSelection lfChildrenSelection) {
        _lfChildrenSelection = lfChildrenSelection;
    }

    public Class<?> getModelClass() {
        return LFChildrenSelection.class;
    }

    public String getModelClassName() {
        return LFChildrenSelection.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("takeCount", getTakeCount());
        attributes.put("takeTimingOnEachAttempt", getTakeTimingOnEachAttempt());
        attributes.put("reorderOnEachAttempt", getReorderOnEachAttempt());

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
    public long getPrimaryKey() {
        return _lfChildrenSelection.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f children selection.
     *
     * @param primaryKey the primary key of this l f children selection
     */
    public void setPrimaryKey(long primaryKey) {
        _lfChildrenSelection.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f children selection.
     *
     * @return the ID of this l f children selection
     */
    public long getId() {
        return _lfChildrenSelection.getId();
    }

    /**
     * Sets the ID of this l f children selection.
     *
     * @param id the ID of this l f children selection
     */
    public void setId(long id) {
        _lfChildrenSelection.setId(id);
    }

    /**
     * Returns the sequencing i d of this l f children selection.
     *
     * @return the sequencing i d of this l f children selection
     */
    public java.lang.Integer getSequencingID() {
        return _lfChildrenSelection.getSequencingID();
    }

    /**
     * Sets the sequencing i d of this l f children selection.
     *
     * @param sequencingID the sequencing i d of this l f children selection
     */
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfChildrenSelection.setSequencingID(sequencingID);
    }

    /**
     * Returns the take count of this l f children selection.
     *
     * @return the take count of this l f children selection
     */
    public java.lang.Integer getTakeCount() {
        return _lfChildrenSelection.getTakeCount();
    }

    /**
     * Sets the take count of this l f children selection.
     *
     * @param takeCount the take count of this l f children selection
     */
    public void setTakeCount(java.lang.Integer takeCount) {
        _lfChildrenSelection.setTakeCount(takeCount);
    }

    /**
     * Returns the take timing on each attempt of this l f children selection.
     *
     * @return the take timing on each attempt of this l f children selection
     */
    public java.lang.String getTakeTimingOnEachAttempt() {
        return _lfChildrenSelection.getTakeTimingOnEachAttempt();
    }

    /**
     * Sets the take timing on each attempt of this l f children selection.
     *
     * @param takeTimingOnEachAttempt the take timing on each attempt of this l f children selection
     */
    public void setTakeTimingOnEachAttempt(
        java.lang.String takeTimingOnEachAttempt) {
        _lfChildrenSelection.setTakeTimingOnEachAttempt(takeTimingOnEachAttempt);
    }

    /**
     * Returns the reorder on each attempt of this l f children selection.
     *
     * @return the reorder on each attempt of this l f children selection
     */
    public java.lang.String getReorderOnEachAttempt() {
        return _lfChildrenSelection.getReorderOnEachAttempt();
    }

    /**
     * Sets the reorder on each attempt of this l f children selection.
     *
     * @param reorderOnEachAttempt the reorder on each attempt of this l f children selection
     */
    public void setReorderOnEachAttempt(java.lang.String reorderOnEachAttempt) {
        _lfChildrenSelection.setReorderOnEachAttempt(reorderOnEachAttempt);
    }

    public boolean isNew() {
        return _lfChildrenSelection.isNew();
    }

    public void setNew(boolean n) {
        _lfChildrenSelection.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfChildrenSelection.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfChildrenSelection.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfChildrenSelection.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfChildrenSelection.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfChildrenSelection.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfChildrenSelection.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfChildrenSelection.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFChildrenSelectionWrapper((LFChildrenSelection) _lfChildrenSelection.clone());
    }

    public int compareTo(LFChildrenSelection lfChildrenSelection) {
        return _lfChildrenSelection.compareTo(lfChildrenSelection);
    }

    @Override
    public int hashCode() {
        return _lfChildrenSelection.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFChildrenSelection> toCacheModel() {
        return _lfChildrenSelection.toCacheModel();
    }

    public LFChildrenSelection toEscapedModel() {
        return new LFChildrenSelectionWrapper(_lfChildrenSelection.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfChildrenSelection.toString();
    }

    public java.lang.String toXmlString() {
        return _lfChildrenSelection.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfChildrenSelection.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFChildrenSelection getWrappedLFChildrenSelection() {
        return _lfChildrenSelection;
    }

    public LFChildrenSelection getWrappedModel() {
        return _lfChildrenSelection;
    }

    public void resetOriginalValues() {
        _lfChildrenSelection.resetOriginalValues();
    }
}

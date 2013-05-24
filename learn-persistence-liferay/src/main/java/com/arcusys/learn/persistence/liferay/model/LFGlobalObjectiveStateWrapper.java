package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFGlobalObjectiveState}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFGlobalObjectiveState
* @generated
*/
public class LFGlobalObjectiveStateWrapper implements LFGlobalObjectiveState,
    ModelWrapper<LFGlobalObjectiveState> {
    private LFGlobalObjectiveState _lfGlobalObjectiveState;

    public LFGlobalObjectiveStateWrapper(
        LFGlobalObjectiveState lfGlobalObjectiveState) {
        _lfGlobalObjectiveState = lfGlobalObjectiveState;
    }

    public Class<?> getModelClass() {
        return LFGlobalObjectiveState.class;
    }

    public String getModelClassName() {
        return LFGlobalObjectiveState.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("satisfied", getSatisfied());
        attributes.put("normalizedMeasure", getNormalizedMeasure());
        attributes.put("attemptCompleted", getAttemptCompleted());
        attributes.put("mapKey", getMapKey());
        attributes.put("treeID", getTreeID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Boolean satisfied = (Boolean) attributes.get("satisfied");

        if (satisfied != null) {
            setSatisfied(satisfied);
        }

        BigDecimal normalizedMeasure = (BigDecimal) attributes.get(
                "normalizedMeasure");

        if (normalizedMeasure != null) {
            setNormalizedMeasure(normalizedMeasure);
        }

        Boolean attemptCompleted = (Boolean) attributes.get("attemptCompleted");

        if (attemptCompleted != null) {
            setAttemptCompleted(attemptCompleted);
        }

        String mapKey = (String) attributes.get("mapKey");

        if (mapKey != null) {
            setMapKey(mapKey);
        }

        Integer treeID = (Integer) attributes.get("treeID");

        if (treeID != null) {
            setTreeID(treeID);
        }
    }

    /**
     * Returns the primary key of this l f global objective state.
     *
     * @return the primary key of this l f global objective state
     */
    public long getPrimaryKey() {
        return _lfGlobalObjectiveState.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f global objective state.
     *
     * @param primaryKey the primary key of this l f global objective state
     */
    public void setPrimaryKey(long primaryKey) {
        _lfGlobalObjectiveState.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f global objective state.
     *
     * @return the ID of this l f global objective state
     */
    public long getId() {
        return _lfGlobalObjectiveState.getId();
    }

    /**
     * Sets the ID of this l f global objective state.
     *
     * @param id the ID of this l f global objective state
     */
    public void setId(long id) {
        _lfGlobalObjectiveState.setId(id);
    }

    /**
     * Returns the satisfied of this l f global objective state.
     *
     * @return the satisfied of this l f global objective state
     */
    public java.lang.Boolean getSatisfied() {
        return _lfGlobalObjectiveState.getSatisfied();
    }

    /**
     * Sets the satisfied of this l f global objective state.
     *
     * @param satisfied the satisfied of this l f global objective state
     */
    public void setSatisfied(java.lang.Boolean satisfied) {
        _lfGlobalObjectiveState.setSatisfied(satisfied);
    }

    /**
     * Returns the normalized measure of this l f global objective state.
     *
     * @return the normalized measure of this l f global objective state
     */
    public java.math.BigDecimal getNormalizedMeasure() {
        return _lfGlobalObjectiveState.getNormalizedMeasure();
    }

    /**
     * Sets the normalized measure of this l f global objective state.
     *
     * @param normalizedMeasure the normalized measure of this l f global objective state
     */
    public void setNormalizedMeasure(java.math.BigDecimal normalizedMeasure) {
        _lfGlobalObjectiveState.setNormalizedMeasure(normalizedMeasure);
    }

    /**
     * Returns the attempt completed of this l f global objective state.
     *
     * @return the attempt completed of this l f global objective state
     */
    public java.lang.Boolean getAttemptCompleted() {
        return _lfGlobalObjectiveState.getAttemptCompleted();
    }

    /**
     * Sets the attempt completed of this l f global objective state.
     *
     * @param attemptCompleted the attempt completed of this l f global objective state
     */
    public void setAttemptCompleted(java.lang.Boolean attemptCompleted) {
        _lfGlobalObjectiveState.setAttemptCompleted(attemptCompleted);
    }

    /**
     * Returns the map key of this l f global objective state.
     *
     * @return the map key of this l f global objective state
     */
    public java.lang.String getMapKey() {
        return _lfGlobalObjectiveState.getMapKey();
    }

    /**
     * Sets the map key of this l f global objective state.
     *
     * @param mapKey the map key of this l f global objective state
     */
    public void setMapKey(java.lang.String mapKey) {
        _lfGlobalObjectiveState.setMapKey(mapKey);
    }

    /**
     * Returns the tree i d of this l f global objective state.
     *
     * @return the tree i d of this l f global objective state
     */
    public java.lang.Integer getTreeID() {
        return _lfGlobalObjectiveState.getTreeID();
    }

    /**
     * Sets the tree i d of this l f global objective state.
     *
     * @param treeID the tree i d of this l f global objective state
     */
    public void setTreeID(java.lang.Integer treeID) {
        _lfGlobalObjectiveState.setTreeID(treeID);
    }

    public boolean isNew() {
        return _lfGlobalObjectiveState.isNew();
    }

    public void setNew(boolean n) {
        _lfGlobalObjectiveState.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfGlobalObjectiveState.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfGlobalObjectiveState.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfGlobalObjectiveState.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfGlobalObjectiveState.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfGlobalObjectiveState.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfGlobalObjectiveState.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfGlobalObjectiveState.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFGlobalObjectiveStateWrapper((LFGlobalObjectiveState) _lfGlobalObjectiveState.clone());
    }

    public int compareTo(LFGlobalObjectiveState lfGlobalObjectiveState) {
        return _lfGlobalObjectiveState.compareTo(lfGlobalObjectiveState);
    }

    @Override
    public int hashCode() {
        return _lfGlobalObjectiveState.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFGlobalObjectiveState> toCacheModel() {
        return _lfGlobalObjectiveState.toCacheModel();
    }

    public LFGlobalObjectiveState toEscapedModel() {
        return new LFGlobalObjectiveStateWrapper(_lfGlobalObjectiveState.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfGlobalObjectiveState.toString();
    }

    public java.lang.String toXmlString() {
        return _lfGlobalObjectiveState.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfGlobalObjectiveState.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFGlobalObjectiveState getWrappedLFGlobalObjectiveState() {
        return _lfGlobalObjectiveState;
    }

    public LFGlobalObjectiveState getWrappedModel() {
        return _lfGlobalObjectiveState;
    }

    public void resetOriginalValues() {
        _lfGlobalObjectiveState.resetOriginalValues();
    }
}

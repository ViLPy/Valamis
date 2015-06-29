package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFGlblObjectiveState}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlblObjectiveState
 * @generated
 */
public class LFGlblObjectiveStateWrapper implements LFGlblObjectiveState,
    ModelWrapper<LFGlblObjectiveState> {
    private LFGlblObjectiveState _lfGlblObjectiveState;

    public LFGlblObjectiveStateWrapper(
        LFGlblObjectiveState lfGlblObjectiveState) {
        _lfGlblObjectiveState = lfGlblObjectiveState;
    }

    @Override
    public Class<?> getModelClass() {
        return LFGlblObjectiveState.class;
    }

    @Override
    public String getModelClassName() {
        return LFGlblObjectiveState.class.getName();
    }

    @Override
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

    @Override
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
    * Returns the primary key of this l f glbl objective state.
    *
    * @return the primary key of this l f glbl objective state
    */
    @Override
    public long getPrimaryKey() {
        return _lfGlblObjectiveState.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f glbl objective state.
    *
    * @param primaryKey the primary key of this l f glbl objective state
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfGlblObjectiveState.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f glbl objective state.
    *
    * @return the ID of this l f glbl objective state
    */
    @Override
    public long getId() {
        return _lfGlblObjectiveState.getId();
    }

    /**
    * Sets the ID of this l f glbl objective state.
    *
    * @param id the ID of this l f glbl objective state
    */
    @Override
    public void setId(long id) {
        _lfGlblObjectiveState.setId(id);
    }

    /**
    * Returns the satisfied of this l f glbl objective state.
    *
    * @return the satisfied of this l f glbl objective state
    */
    @Override
    public java.lang.Boolean getSatisfied() {
        return _lfGlblObjectiveState.getSatisfied();
    }

    /**
    * Sets the satisfied of this l f glbl objective state.
    *
    * @param satisfied the satisfied of this l f glbl objective state
    */
    @Override
    public void setSatisfied(java.lang.Boolean satisfied) {
        _lfGlblObjectiveState.setSatisfied(satisfied);
    }

    /**
    * Returns the normalized measure of this l f glbl objective state.
    *
    * @return the normalized measure of this l f glbl objective state
    */
    @Override
    public java.math.BigDecimal getNormalizedMeasure() {
        return _lfGlblObjectiveState.getNormalizedMeasure();
    }

    /**
    * Sets the normalized measure of this l f glbl objective state.
    *
    * @param normalizedMeasure the normalized measure of this l f glbl objective state
    */
    @Override
    public void setNormalizedMeasure(java.math.BigDecimal normalizedMeasure) {
        _lfGlblObjectiveState.setNormalizedMeasure(normalizedMeasure);
    }

    /**
    * Returns the attempt completed of this l f glbl objective state.
    *
    * @return the attempt completed of this l f glbl objective state
    */
    @Override
    public java.lang.Boolean getAttemptCompleted() {
        return _lfGlblObjectiveState.getAttemptCompleted();
    }

    /**
    * Sets the attempt completed of this l f glbl objective state.
    *
    * @param attemptCompleted the attempt completed of this l f glbl objective state
    */
    @Override
    public void setAttemptCompleted(java.lang.Boolean attemptCompleted) {
        _lfGlblObjectiveState.setAttemptCompleted(attemptCompleted);
    }

    /**
    * Returns the map key of this l f glbl objective state.
    *
    * @return the map key of this l f glbl objective state
    */
    @Override
    public java.lang.String getMapKey() {
        return _lfGlblObjectiveState.getMapKey();
    }

    /**
    * Sets the map key of this l f glbl objective state.
    *
    * @param mapKey the map key of this l f glbl objective state
    */
    @Override
    public void setMapKey(java.lang.String mapKey) {
        _lfGlblObjectiveState.setMapKey(mapKey);
    }

    /**
    * Returns the tree i d of this l f glbl objective state.
    *
    * @return the tree i d of this l f glbl objective state
    */
    @Override
    public java.lang.Integer getTreeID() {
        return _lfGlblObjectiveState.getTreeID();
    }

    /**
    * Sets the tree i d of this l f glbl objective state.
    *
    * @param treeID the tree i d of this l f glbl objective state
    */
    @Override
    public void setTreeID(java.lang.Integer treeID) {
        _lfGlblObjectiveState.setTreeID(treeID);
    }

    @Override
    public boolean isNew() {
        return _lfGlblObjectiveState.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfGlblObjectiveState.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfGlblObjectiveState.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfGlblObjectiveState.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfGlblObjectiveState.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfGlblObjectiveState.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfGlblObjectiveState.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfGlblObjectiveState.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfGlblObjectiveState.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfGlblObjectiveState.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfGlblObjectiveState.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFGlblObjectiveStateWrapper((LFGlblObjectiveState) _lfGlblObjectiveState.clone());
    }

    @Override
    public int compareTo(LFGlblObjectiveState lfGlblObjectiveState) {
        return _lfGlblObjectiveState.compareTo(lfGlblObjectiveState);
    }

    @Override
    public int hashCode() {
        return _lfGlblObjectiveState.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFGlblObjectiveState> toCacheModel() {
        return _lfGlblObjectiveState.toCacheModel();
    }

    @Override
    public LFGlblObjectiveState toEscapedModel() {
        return new LFGlblObjectiveStateWrapper(_lfGlblObjectiveState.toEscapedModel());
    }

    @Override
    public LFGlblObjectiveState toUnescapedModel() {
        return new LFGlblObjectiveStateWrapper(_lfGlblObjectiveState.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfGlblObjectiveState.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfGlblObjectiveState.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfGlblObjectiveState.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFGlblObjectiveStateWrapper)) {
            return false;
        }

        LFGlblObjectiveStateWrapper lfGlblObjectiveStateWrapper = (LFGlblObjectiveStateWrapper) obj;

        if (Validator.equals(_lfGlblObjectiveState,
                    lfGlblObjectiveStateWrapper._lfGlblObjectiveState)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFGlblObjectiveState getWrappedLFGlblObjectiveState() {
        return _lfGlblObjectiveState;
    }

    @Override
    public LFGlblObjectiveState getWrappedModel() {
        return _lfGlblObjectiveState;
    }

    @Override
    public void resetOriginalValues() {
        _lfGlblObjectiveState.resetOriginalValues();
    }
}

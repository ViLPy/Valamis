package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFGlobalObjectiveState}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlobalObjectiveState
 * @generated
 */
public class LFGlobalObjectiveStateWrapper implements LFGlobalObjectiveState,
    ModelWrapper<LFGlobalObjectiveState> {
    private LFGlobalObjectiveState _lfGlobalObjectiveState;

    public LFGlobalObjectiveStateWrapper(
        LFGlobalObjectiveState lfGlobalObjectiveState) {
        _lfGlobalObjectiveState = lfGlobalObjectiveState;
    }

    @Override
    public Class<?> getModelClass() {
        return LFGlobalObjectiveState.class;
    }

    @Override
    public String getModelClassName() {
        return LFGlobalObjectiveState.class.getName();
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
    * Returns the primary key of this l f global objective state.
    *
    * @return the primary key of this l f global objective state
    */
    @Override
    public long getPrimaryKey() {
        return _lfGlobalObjectiveState.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f global objective state.
    *
    * @param primaryKey the primary key of this l f global objective state
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfGlobalObjectiveState.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f global objective state.
    *
    * @return the ID of this l f global objective state
    */
    @Override
    public long getId() {
        return _lfGlobalObjectiveState.getId();
    }

    /**
    * Sets the ID of this l f global objective state.
    *
    * @param id the ID of this l f global objective state
    */
    @Override
    public void setId(long id) {
        _lfGlobalObjectiveState.setId(id);
    }

    /**
    * Returns the satisfied of this l f global objective state.
    *
    * @return the satisfied of this l f global objective state
    */
    @Override
    public java.lang.Boolean getSatisfied() {
        return _lfGlobalObjectiveState.getSatisfied();
    }

    /**
    * Sets the satisfied of this l f global objective state.
    *
    * @param satisfied the satisfied of this l f global objective state
    */
    @Override
    public void setSatisfied(java.lang.Boolean satisfied) {
        _lfGlobalObjectiveState.setSatisfied(satisfied);
    }

    /**
    * Returns the normalized measure of this l f global objective state.
    *
    * @return the normalized measure of this l f global objective state
    */
    @Override
    public java.math.BigDecimal getNormalizedMeasure() {
        return _lfGlobalObjectiveState.getNormalizedMeasure();
    }

    /**
    * Sets the normalized measure of this l f global objective state.
    *
    * @param normalizedMeasure the normalized measure of this l f global objective state
    */
    @Override
    public void setNormalizedMeasure(java.math.BigDecimal normalizedMeasure) {
        _lfGlobalObjectiveState.setNormalizedMeasure(normalizedMeasure);
    }

    /**
    * Returns the attempt completed of this l f global objective state.
    *
    * @return the attempt completed of this l f global objective state
    */
    @Override
    public java.lang.Boolean getAttemptCompleted() {
        return _lfGlobalObjectiveState.getAttemptCompleted();
    }

    /**
    * Sets the attempt completed of this l f global objective state.
    *
    * @param attemptCompleted the attempt completed of this l f global objective state
    */
    @Override
    public void setAttemptCompleted(java.lang.Boolean attemptCompleted) {
        _lfGlobalObjectiveState.setAttemptCompleted(attemptCompleted);
    }

    /**
    * Returns the map key of this l f global objective state.
    *
    * @return the map key of this l f global objective state
    */
    @Override
    public java.lang.String getMapKey() {
        return _lfGlobalObjectiveState.getMapKey();
    }

    /**
    * Sets the map key of this l f global objective state.
    *
    * @param mapKey the map key of this l f global objective state
    */
    @Override
    public void setMapKey(java.lang.String mapKey) {
        _lfGlobalObjectiveState.setMapKey(mapKey);
    }

    /**
    * Returns the tree i d of this l f global objective state.
    *
    * @return the tree i d of this l f global objective state
    */
    @Override
    public java.lang.Integer getTreeID() {
        return _lfGlobalObjectiveState.getTreeID();
    }

    /**
    * Sets the tree i d of this l f global objective state.
    *
    * @param treeID the tree i d of this l f global objective state
    */
    @Override
    public void setTreeID(java.lang.Integer treeID) {
        _lfGlobalObjectiveState.setTreeID(treeID);
    }

    @Override
    public boolean isNew() {
        return _lfGlobalObjectiveState.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfGlobalObjectiveState.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfGlobalObjectiveState.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfGlobalObjectiveState.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfGlobalObjectiveState.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfGlobalObjectiveState.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfGlobalObjectiveState.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfGlobalObjectiveState.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfGlobalObjectiveState.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfGlobalObjectiveState.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfGlobalObjectiveState.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFGlobalObjectiveStateWrapper((LFGlobalObjectiveState) _lfGlobalObjectiveState.clone());
    }

    @Override
    public int compareTo(LFGlobalObjectiveState lfGlobalObjectiveState) {
        return _lfGlobalObjectiveState.compareTo(lfGlobalObjectiveState);
    }

    @Override
    public int hashCode() {
        return _lfGlobalObjectiveState.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFGlobalObjectiveState> toCacheModel() {
        return _lfGlobalObjectiveState.toCacheModel();
    }

    @Override
    public LFGlobalObjectiveState toEscapedModel() {
        return new LFGlobalObjectiveStateWrapper(_lfGlobalObjectiveState.toEscapedModel());
    }

    @Override
    public LFGlobalObjectiveState toUnescapedModel() {
        return new LFGlobalObjectiveStateWrapper(_lfGlobalObjectiveState.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfGlobalObjectiveState.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfGlobalObjectiveState.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfGlobalObjectiveState.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFGlobalObjectiveStateWrapper)) {
            return false;
        }

        LFGlobalObjectiveStateWrapper lfGlobalObjectiveStateWrapper = (LFGlobalObjectiveStateWrapper) obj;

        if (Validator.equals(_lfGlobalObjectiveState,
                    lfGlobalObjectiveStateWrapper._lfGlobalObjectiveState)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFGlobalObjectiveState getWrappedLFGlobalObjectiveState() {
        return _lfGlobalObjectiveState;
    }

    @Override
    public LFGlobalObjectiveState getWrappedModel() {
        return _lfGlobalObjectiveState;
    }

    @Override
    public void resetOriginalValues() {
        _lfGlobalObjectiveState.resetOriginalValues();
    }
}

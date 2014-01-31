package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFObjectiveState}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveState
 * @generated
 */
public class LFObjectiveStateWrapper implements LFObjectiveState,
    ModelWrapper<LFObjectiveState> {
    private LFObjectiveState _lfObjectiveState;

    public LFObjectiveStateWrapper(LFObjectiveState lfObjectiveState) {
        _lfObjectiveState = lfObjectiveState;
    }

    @Override
    public Class<?> getModelClass() {
        return LFObjectiveState.class;
    }

    @Override
    public String getModelClassName() {
        return LFObjectiveState.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("satisfied", getSatisfied());
        attributes.put("normalizedMeasure", getNormalizedMeasure());
        attributes.put("mapKey", getMapKey());
        attributes.put("activityStateID", getActivityStateID());
        attributes.put("objectiveID", getObjectiveID());

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

        String mapKey = (String) attributes.get("mapKey");

        if (mapKey != null) {
            setMapKey(mapKey);
        }

        Integer activityStateID = (Integer) attributes.get("activityStateID");

        if (activityStateID != null) {
            setActivityStateID(activityStateID);
        }

        Integer objectiveID = (Integer) attributes.get("objectiveID");

        if (objectiveID != null) {
            setObjectiveID(objectiveID);
        }
    }

    /**
    * Returns the primary key of this l f objective state.
    *
    * @return the primary key of this l f objective state
    */
    @Override
    public long getPrimaryKey() {
        return _lfObjectiveState.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f objective state.
    *
    * @param primaryKey the primary key of this l f objective state
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfObjectiveState.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f objective state.
    *
    * @return the ID of this l f objective state
    */
    @Override
    public long getId() {
        return _lfObjectiveState.getId();
    }

    /**
    * Sets the ID of this l f objective state.
    *
    * @param id the ID of this l f objective state
    */
    @Override
    public void setId(long id) {
        _lfObjectiveState.setId(id);
    }

    /**
    * Returns the satisfied of this l f objective state.
    *
    * @return the satisfied of this l f objective state
    */
    @Override
    public java.lang.Boolean getSatisfied() {
        return _lfObjectiveState.getSatisfied();
    }

    /**
    * Sets the satisfied of this l f objective state.
    *
    * @param satisfied the satisfied of this l f objective state
    */
    @Override
    public void setSatisfied(java.lang.Boolean satisfied) {
        _lfObjectiveState.setSatisfied(satisfied);
    }

    /**
    * Returns the normalized measure of this l f objective state.
    *
    * @return the normalized measure of this l f objective state
    */
    @Override
    public java.math.BigDecimal getNormalizedMeasure() {
        return _lfObjectiveState.getNormalizedMeasure();
    }

    /**
    * Sets the normalized measure of this l f objective state.
    *
    * @param normalizedMeasure the normalized measure of this l f objective state
    */
    @Override
    public void setNormalizedMeasure(java.math.BigDecimal normalizedMeasure) {
        _lfObjectiveState.setNormalizedMeasure(normalizedMeasure);
    }

    /**
    * Returns the map key of this l f objective state.
    *
    * @return the map key of this l f objective state
    */
    @Override
    public java.lang.String getMapKey() {
        return _lfObjectiveState.getMapKey();
    }

    /**
    * Sets the map key of this l f objective state.
    *
    * @param mapKey the map key of this l f objective state
    */
    @Override
    public void setMapKey(java.lang.String mapKey) {
        _lfObjectiveState.setMapKey(mapKey);
    }

    /**
    * Returns the activity state i d of this l f objective state.
    *
    * @return the activity state i d of this l f objective state
    */
    @Override
    public java.lang.Integer getActivityStateID() {
        return _lfObjectiveState.getActivityStateID();
    }

    /**
    * Sets the activity state i d of this l f objective state.
    *
    * @param activityStateID the activity state i d of this l f objective state
    */
    @Override
    public void setActivityStateID(java.lang.Integer activityStateID) {
        _lfObjectiveState.setActivityStateID(activityStateID);
    }

    /**
    * Returns the objective i d of this l f objective state.
    *
    * @return the objective i d of this l f objective state
    */
    @Override
    public java.lang.Integer getObjectiveID() {
        return _lfObjectiveState.getObjectiveID();
    }

    /**
    * Sets the objective i d of this l f objective state.
    *
    * @param objectiveID the objective i d of this l f objective state
    */
    @Override
    public void setObjectiveID(java.lang.Integer objectiveID) {
        _lfObjectiveState.setObjectiveID(objectiveID);
    }

    @Override
    public boolean isNew() {
        return _lfObjectiveState.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfObjectiveState.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfObjectiveState.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfObjectiveState.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfObjectiveState.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfObjectiveState.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfObjectiveState.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfObjectiveState.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfObjectiveState.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfObjectiveState.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfObjectiveState.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFObjectiveStateWrapper((LFObjectiveState) _lfObjectiveState.clone());
    }

    @Override
    public int compareTo(LFObjectiveState lfObjectiveState) {
        return _lfObjectiveState.compareTo(lfObjectiveState);
    }

    @Override
    public int hashCode() {
        return _lfObjectiveState.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFObjectiveState> toCacheModel() {
        return _lfObjectiveState.toCacheModel();
    }

    @Override
    public LFObjectiveState toEscapedModel() {
        return new LFObjectiveStateWrapper(_lfObjectiveState.toEscapedModel());
    }

    @Override
    public LFObjectiveState toUnescapedModel() {
        return new LFObjectiveStateWrapper(_lfObjectiveState.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfObjectiveState.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfObjectiveState.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfObjectiveState.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFObjectiveStateWrapper)) {
            return false;
        }

        LFObjectiveStateWrapper lfObjectiveStateWrapper = (LFObjectiveStateWrapper) obj;

        if (Validator.equals(_lfObjectiveState,
                    lfObjectiveStateWrapper._lfObjectiveState)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFObjectiveState getWrappedLFObjectiveState() {
        return _lfObjectiveState;
    }

    @Override
    public LFObjectiveState getWrappedModel() {
        return _lfObjectiveState;
    }

    @Override
    public void resetOriginalValues() {
        _lfObjectiveState.resetOriginalValues();
    }
}

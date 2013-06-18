package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFRuleCondition}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFRuleCondition
* @generated
*/
public class LFRuleConditionWrapper implements LFRuleCondition,
    ModelWrapper<LFRuleCondition> {
    private LFRuleCondition _lfRuleCondition;

    public LFRuleConditionWrapper(LFRuleCondition lfRuleCondition) {
        _lfRuleCondition = lfRuleCondition;
    }

    public Class<?> getModelClass() {
        return LFRuleCondition.class;
    }

    public String getModelClassName() {
        return LFRuleCondition.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("conditionType", getConditionType());
        attributes.put("objectiveId", getObjectiveId());
        attributes.put("measureThreshold", getMeasureThreshold());
        attributes.put("inverse", getInverse());
        attributes.put("rollupRuleID", getRollupRuleID());
        attributes.put("conditionRuleID", getConditionRuleID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String conditionType = (String) attributes.get("conditionType");

        if (conditionType != null) {
            setConditionType(conditionType);
        }

        String objectiveId = (String) attributes.get("objectiveId");

        if (objectiveId != null) {
            setObjectiveId(objectiveId);
        }

        BigDecimal measureThreshold = (BigDecimal) attributes.get(
                "measureThreshold");

        if (measureThreshold != null) {
            setMeasureThreshold(measureThreshold);
        }

        Boolean inverse = (Boolean) attributes.get("inverse");

        if (inverse != null) {
            setInverse(inverse);
        }

        Integer rollupRuleID = (Integer) attributes.get("rollupRuleID");

        if (rollupRuleID != null) {
            setRollupRuleID(rollupRuleID);
        }

        Integer conditionRuleID = (Integer) attributes.get("conditionRuleID");

        if (conditionRuleID != null) {
            setConditionRuleID(conditionRuleID);
        }
    }

    /**
     * Returns the primary key of this l f rule condition.
     *
     * @return the primary key of this l f rule condition
     */
    public long getPrimaryKey() {
        return _lfRuleCondition.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f rule condition.
     *
     * @param primaryKey the primary key of this l f rule condition
     */
    public void setPrimaryKey(long primaryKey) {
        _lfRuleCondition.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f rule condition.
     *
     * @return the ID of this l f rule condition
     */
    public long getId() {
        return _lfRuleCondition.getId();
    }

    /**
     * Sets the ID of this l f rule condition.
     *
     * @param id the ID of this l f rule condition
     */
    public void setId(long id) {
        _lfRuleCondition.setId(id);
    }

    /**
     * Returns the condition type of this l f rule condition.
     *
     * @return the condition type of this l f rule condition
     */
    public java.lang.String getConditionType() {
        return _lfRuleCondition.getConditionType();
    }

    /**
     * Sets the condition type of this l f rule condition.
     *
     * @param conditionType the condition type of this l f rule condition
     */
    public void setConditionType(java.lang.String conditionType) {
        _lfRuleCondition.setConditionType(conditionType);
    }

    /**
     * Returns the objective ID of this l f rule condition.
     *
     * @return the objective ID of this l f rule condition
     */
    public java.lang.String getObjectiveId() {
        return _lfRuleCondition.getObjectiveId();
    }

    /**
     * Sets the objective ID of this l f rule condition.
     *
     * @param objectiveId the objective ID of this l f rule condition
     */
    public void setObjectiveId(java.lang.String objectiveId) {
        _lfRuleCondition.setObjectiveId(objectiveId);
    }

    /**
     * Returns the measure threshold of this l f rule condition.
     *
     * @return the measure threshold of this l f rule condition
     */
    public java.math.BigDecimal getMeasureThreshold() {
        return _lfRuleCondition.getMeasureThreshold();
    }

    /**
     * Sets the measure threshold of this l f rule condition.
     *
     * @param measureThreshold the measure threshold of this l f rule condition
     */
    public void setMeasureThreshold(java.math.BigDecimal measureThreshold) {
        _lfRuleCondition.setMeasureThreshold(measureThreshold);
    }

    /**
     * Returns the inverse of this l f rule condition.
     *
     * @return the inverse of this l f rule condition
     */
    public boolean getInverse() {
        return _lfRuleCondition.getInverse();
    }

    /**
     * Returns <code>true</code> if this l f rule condition is inverse.
     *
     * @return <code>true</code> if this l f rule condition is inverse; <code>false</code> otherwise
     */
    public boolean isInverse() {
        return _lfRuleCondition.isInverse();
    }

    /**
     * Sets whether this l f rule condition is inverse.
     *
     * @param inverse the inverse of this l f rule condition
     */
    public void setInverse(boolean inverse) {
        _lfRuleCondition.setInverse(inverse);
    }

    /**
     * Returns the rollup rule i d of this l f rule condition.
     *
     * @return the rollup rule i d of this l f rule condition
     */
    public java.lang.Integer getRollupRuleID() {
        return _lfRuleCondition.getRollupRuleID();
    }

    /**
     * Sets the rollup rule i d of this l f rule condition.
     *
     * @param rollupRuleID the rollup rule i d of this l f rule condition
     */
    public void setRollupRuleID(java.lang.Integer rollupRuleID) {
        _lfRuleCondition.setRollupRuleID(rollupRuleID);
    }

    /**
     * Returns the condition rule i d of this l f rule condition.
     *
     * @return the condition rule i d of this l f rule condition
     */
    public java.lang.Integer getConditionRuleID() {
        return _lfRuleCondition.getConditionRuleID();
    }

    /**
     * Sets the condition rule i d of this l f rule condition.
     *
     * @param conditionRuleID the condition rule i d of this l f rule condition
     */
    public void setConditionRuleID(java.lang.Integer conditionRuleID) {
        _lfRuleCondition.setConditionRuleID(conditionRuleID);
    }

    public boolean isNew() {
        return _lfRuleCondition.isNew();
    }

    public void setNew(boolean n) {
        _lfRuleCondition.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfRuleCondition.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfRuleCondition.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfRuleCondition.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfRuleCondition.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfRuleCondition.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfRuleCondition.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfRuleCondition.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFRuleConditionWrapper((LFRuleCondition) _lfRuleCondition.clone());
    }

    public int compareTo(LFRuleCondition lfRuleCondition) {
        return _lfRuleCondition.compareTo(lfRuleCondition);
    }

    @Override
    public int hashCode() {
        return _lfRuleCondition.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFRuleCondition> toCacheModel() {
        return _lfRuleCondition.toCacheModel();
    }

    public LFRuleCondition toEscapedModel() {
        return new LFRuleConditionWrapper(_lfRuleCondition.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfRuleCondition.toString();
    }

    public java.lang.String toXmlString() {
        return _lfRuleCondition.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRuleCondition.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFRuleCondition getWrappedLFRuleCondition() {
        return _lfRuleCondition;
    }

    public LFRuleCondition getWrappedModel() {
        return _lfRuleCondition;
    }

    public void resetOriginalValues() {
        _lfRuleCondition.resetOriginalValues();
    }
}

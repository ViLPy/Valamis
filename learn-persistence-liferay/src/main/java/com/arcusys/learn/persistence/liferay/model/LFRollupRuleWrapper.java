package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFRollupRule}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFRollupRule
* @generated
*/
public class LFRollupRuleWrapper implements LFRollupRule,
    ModelWrapper<LFRollupRule> {
    private LFRollupRule _lfRollupRule;

    public LFRollupRuleWrapper(LFRollupRule lfRollupRule) {
        _lfRollupRule = lfRollupRule;
    }

    public Class<?> getModelClass() {
        return LFRollupRule.class;
    }

    public String getModelClassName() {
        return LFRollupRule.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("combination", getCombination());
        attributes.put("childActivitySet", getChildActivitySet());
        attributes.put("minimumCount", getMinimumCount());
        attributes.put("minimumPercent", getMinimumPercent());
        attributes.put("action", getAction());

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

        String combination = (String) attributes.get("combination");

        if (combination != null) {
            setCombination(combination);
        }

        String childActivitySet = (String) attributes.get("childActivitySet");

        if (childActivitySet != null) {
            setChildActivitySet(childActivitySet);
        }

        Integer minimumCount = (Integer) attributes.get("minimumCount");

        if (minimumCount != null) {
            setMinimumCount(minimumCount);
        }

        BigDecimal minimumPercent = (BigDecimal) attributes.get(
                "minimumPercent");

        if (minimumPercent != null) {
            setMinimumPercent(minimumPercent);
        }

        String action = (String) attributes.get("action");

        if (action != null) {
            setAction(action);
        }
    }

    /**
     * Returns the primary key of this l f rollup rule.
     *
     * @return the primary key of this l f rollup rule
     */
    public long getPrimaryKey() {
        return _lfRollupRule.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f rollup rule.
     *
     * @param primaryKey the primary key of this l f rollup rule
     */
    public void setPrimaryKey(long primaryKey) {
        _lfRollupRule.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f rollup rule.
     *
     * @return the ID of this l f rollup rule
     */
    public long getId() {
        return _lfRollupRule.getId();
    }

    /**
     * Sets the ID of this l f rollup rule.
     *
     * @param id the ID of this l f rollup rule
     */
    public void setId(long id) {
        _lfRollupRule.setId(id);
    }

    /**
     * Returns the sequencing i d of this l f rollup rule.
     *
     * @return the sequencing i d of this l f rollup rule
     */
    public java.lang.Integer getSequencingID() {
        return _lfRollupRule.getSequencingID();
    }

    /**
     * Sets the sequencing i d of this l f rollup rule.
     *
     * @param sequencingID the sequencing i d of this l f rollup rule
     */
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfRollupRule.setSequencingID(sequencingID);
    }

    /**
     * Returns the combination of this l f rollup rule.
     *
     * @return the combination of this l f rollup rule
     */
    public java.lang.String getCombination() {
        return _lfRollupRule.getCombination();
    }

    /**
     * Sets the combination of this l f rollup rule.
     *
     * @param combination the combination of this l f rollup rule
     */
    public void setCombination(java.lang.String combination) {
        _lfRollupRule.setCombination(combination);
    }

    /**
     * Returns the child activity set of this l f rollup rule.
     *
     * @return the child activity set of this l f rollup rule
     */
    public java.lang.String getChildActivitySet() {
        return _lfRollupRule.getChildActivitySet();
    }

    /**
     * Sets the child activity set of this l f rollup rule.
     *
     * @param childActivitySet the child activity set of this l f rollup rule
     */
    public void setChildActivitySet(java.lang.String childActivitySet) {
        _lfRollupRule.setChildActivitySet(childActivitySet);
    }

    /**
     * Returns the minimum count of this l f rollup rule.
     *
     * @return the minimum count of this l f rollup rule
     */
    public java.lang.Integer getMinimumCount() {
        return _lfRollupRule.getMinimumCount();
    }

    /**
     * Sets the minimum count of this l f rollup rule.
     *
     * @param minimumCount the minimum count of this l f rollup rule
     */
    public void setMinimumCount(java.lang.Integer minimumCount) {
        _lfRollupRule.setMinimumCount(minimumCount);
    }

    /**
     * Returns the minimum percent of this l f rollup rule.
     *
     * @return the minimum percent of this l f rollup rule
     */
    public java.math.BigDecimal getMinimumPercent() {
        return _lfRollupRule.getMinimumPercent();
    }

    /**
     * Sets the minimum percent of this l f rollup rule.
     *
     * @param minimumPercent the minimum percent of this l f rollup rule
     */
    public void setMinimumPercent(java.math.BigDecimal minimumPercent) {
        _lfRollupRule.setMinimumPercent(minimumPercent);
    }

    /**
     * Returns the action of this l f rollup rule.
     *
     * @return the action of this l f rollup rule
     */
    public java.lang.String getAction() {
        return _lfRollupRule.getAction();
    }

    /**
     * Sets the action of this l f rollup rule.
     *
     * @param action the action of this l f rollup rule
     */
    public void setAction(java.lang.String action) {
        _lfRollupRule.setAction(action);
    }

    public boolean isNew() {
        return _lfRollupRule.isNew();
    }

    public void setNew(boolean n) {
        _lfRollupRule.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfRollupRule.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfRollupRule.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfRollupRule.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfRollupRule.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfRollupRule.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfRollupRule.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfRollupRule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFRollupRuleWrapper((LFRollupRule) _lfRollupRule.clone());
    }

    public int compareTo(LFRollupRule lfRollupRule) {
        return _lfRollupRule.compareTo(lfRollupRule);
    }

    @Override
    public int hashCode() {
        return _lfRollupRule.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFRollupRule> toCacheModel() {
        return _lfRollupRule.toCacheModel();
    }

    public LFRollupRule toEscapedModel() {
        return new LFRollupRuleWrapper(_lfRollupRule.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfRollupRule.toString();
    }

    public java.lang.String toXmlString() {
        return _lfRollupRule.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRollupRule.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFRollupRule getWrappedLFRollupRule() {
        return _lfRollupRule;
    }

    public LFRollupRule getWrappedModel() {
        return _lfRollupRule;
    }

    public void resetOriginalValues() {
        _lfRollupRule.resetOriginalValues();
    }
}

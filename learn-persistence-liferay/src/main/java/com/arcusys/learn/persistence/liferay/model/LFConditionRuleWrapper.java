package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFConditionRule}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFConditionRule
* @generated
*/
public class LFConditionRuleWrapper implements LFConditionRule,
    ModelWrapper<LFConditionRule> {
    private LFConditionRule _lfConditionRule;

    public LFConditionRuleWrapper(LFConditionRule lfConditionRule) {
        _lfConditionRule = lfConditionRule;
    }

    public Class<?> getModelClass() {
        return LFConditionRule.class;
    }

    public String getModelClassName() {
        return LFConditionRule.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("combination", getCombination());
        attributes.put("ruleType", getRuleType());
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

        String ruleType = (String) attributes.get("ruleType");

        if (ruleType != null) {
            setRuleType(ruleType);
        }

        String action = (String) attributes.get("action");

        if (action != null) {
            setAction(action);
        }
    }

    /**
     * Returns the primary key of this l f condition rule.
     *
     * @return the primary key of this l f condition rule
     */
    public long getPrimaryKey() {
        return _lfConditionRule.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f condition rule.
     *
     * @param primaryKey the primary key of this l f condition rule
     */
    public void setPrimaryKey(long primaryKey) {
        _lfConditionRule.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f condition rule.
     *
     * @return the ID of this l f condition rule
     */
    public long getId() {
        return _lfConditionRule.getId();
    }

    /**
     * Sets the ID of this l f condition rule.
     *
     * @param id the ID of this l f condition rule
     */
    public void setId(long id) {
        _lfConditionRule.setId(id);
    }

    /**
     * Returns the sequencing i d of this l f condition rule.
     *
     * @return the sequencing i d of this l f condition rule
     */
    public java.lang.Integer getSequencingID() {
        return _lfConditionRule.getSequencingID();
    }

    /**
     * Sets the sequencing i d of this l f condition rule.
     *
     * @param sequencingID the sequencing i d of this l f condition rule
     */
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfConditionRule.setSequencingID(sequencingID);
    }

    /**
     * Returns the combination of this l f condition rule.
     *
     * @return the combination of this l f condition rule
     */
    public java.lang.String getCombination() {
        return _lfConditionRule.getCombination();
    }

    /**
     * Sets the combination of this l f condition rule.
     *
     * @param combination the combination of this l f condition rule
     */
    public void setCombination(java.lang.String combination) {
        _lfConditionRule.setCombination(combination);
    }

    /**
     * Returns the rule type of this l f condition rule.
     *
     * @return the rule type of this l f condition rule
     */
    public java.lang.String getRuleType() {
        return _lfConditionRule.getRuleType();
    }

    /**
     * Sets the rule type of this l f condition rule.
     *
     * @param ruleType the rule type of this l f condition rule
     */
    public void setRuleType(java.lang.String ruleType) {
        _lfConditionRule.setRuleType(ruleType);
    }

    /**
     * Returns the action of this l f condition rule.
     *
     * @return the action of this l f condition rule
     */
    public java.lang.String getAction() {
        return _lfConditionRule.getAction();
    }

    /**
     * Sets the action of this l f condition rule.
     *
     * @param action the action of this l f condition rule
     */
    public void setAction(java.lang.String action) {
        _lfConditionRule.setAction(action);
    }

    public boolean isNew() {
        return _lfConditionRule.isNew();
    }

    public void setNew(boolean n) {
        _lfConditionRule.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfConditionRule.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfConditionRule.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfConditionRule.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfConditionRule.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfConditionRule.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfConditionRule.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfConditionRule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFConditionRuleWrapper((LFConditionRule) _lfConditionRule.clone());
    }

    public int compareTo(LFConditionRule lfConditionRule) {
        return _lfConditionRule.compareTo(lfConditionRule);
    }

    @Override
    public int hashCode() {
        return _lfConditionRule.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFConditionRule> toCacheModel() {
        return _lfConditionRule.toCacheModel();
    }

    public LFConditionRule toEscapedModel() {
        return new LFConditionRuleWrapper(_lfConditionRule.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfConditionRule.toString();
    }

    public java.lang.String toXmlString() {
        return _lfConditionRule.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfConditionRule.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFConditionRule getWrappedLFConditionRule() {
        return _lfConditionRule;
    }

    public LFConditionRule getWrappedModel() {
        return _lfConditionRule;
    }

    public void resetOriginalValues() {
        _lfConditionRule.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFRollupContribution}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRollupContribution
 * @generated
 */
public class LFRollupContributionWrapper implements LFRollupContribution,
    ModelWrapper<LFRollupContribution> {
    private LFRollupContribution _lfRollupContribution;

    public LFRollupContributionWrapper(
        LFRollupContribution lfRollupContribution) {
        _lfRollupContribution = lfRollupContribution;
    }

    @Override
    public Class<?> getModelClass() {
        return LFRollupContribution.class;
    }

    @Override
    public String getModelClassName() {
        return LFRollupContribution.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("contributeToSatisfied", getContributeToSatisfied());
        attributes.put("contributeToNotSatisfied", getContributeToNotSatisfied());
        attributes.put("contributeToCompleted", getContributeToCompleted());
        attributes.put("contributeToIncomplete", getContributeToIncomplete());
        attributes.put("objectiveMeasureWeight", getObjectiveMeasureWeight());
        attributes.put("measureSatisfactionIfActive",
            getMeasureSatisfactionIfActive());

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

        String contributeToSatisfied = (String) attributes.get(
                "contributeToSatisfied");

        if (contributeToSatisfied != null) {
            setContributeToSatisfied(contributeToSatisfied);
        }

        String contributeToNotSatisfied = (String) attributes.get(
                "contributeToNotSatisfied");

        if (contributeToNotSatisfied != null) {
            setContributeToNotSatisfied(contributeToNotSatisfied);
        }

        String contributeToCompleted = (String) attributes.get(
                "contributeToCompleted");

        if (contributeToCompleted != null) {
            setContributeToCompleted(contributeToCompleted);
        }

        String contributeToIncomplete = (String) attributes.get(
                "contributeToIncomplete");

        if (contributeToIncomplete != null) {
            setContributeToIncomplete(contributeToIncomplete);
        }

        BigDecimal objectiveMeasureWeight = (BigDecimal) attributes.get(
                "objectiveMeasureWeight");

        if (objectiveMeasureWeight != null) {
            setObjectiveMeasureWeight(objectiveMeasureWeight);
        }

        Boolean measureSatisfactionIfActive = (Boolean) attributes.get(
                "measureSatisfactionIfActive");

        if (measureSatisfactionIfActive != null) {
            setMeasureSatisfactionIfActive(measureSatisfactionIfActive);
        }
    }

    /**
    * Returns the primary key of this l f rollup contribution.
    *
    * @return the primary key of this l f rollup contribution
    */
    @Override
    public long getPrimaryKey() {
        return _lfRollupContribution.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f rollup contribution.
    *
    * @param primaryKey the primary key of this l f rollup contribution
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfRollupContribution.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f rollup contribution.
    *
    * @return the ID of this l f rollup contribution
    */
    @Override
    public long getId() {
        return _lfRollupContribution.getId();
    }

    /**
    * Sets the ID of this l f rollup contribution.
    *
    * @param id the ID of this l f rollup contribution
    */
    @Override
    public void setId(long id) {
        _lfRollupContribution.setId(id);
    }

    /**
    * Returns the sequencing i d of this l f rollup contribution.
    *
    * @return the sequencing i d of this l f rollup contribution
    */
    @Override
    public java.lang.Integer getSequencingID() {
        return _lfRollupContribution.getSequencingID();
    }

    /**
    * Sets the sequencing i d of this l f rollup contribution.
    *
    * @param sequencingID the sequencing i d of this l f rollup contribution
    */
    @Override
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfRollupContribution.setSequencingID(sequencingID);
    }

    /**
    * Returns the contribute to satisfied of this l f rollup contribution.
    *
    * @return the contribute to satisfied of this l f rollup contribution
    */
    @Override
    public java.lang.String getContributeToSatisfied() {
        return _lfRollupContribution.getContributeToSatisfied();
    }

    /**
    * Sets the contribute to satisfied of this l f rollup contribution.
    *
    * @param contributeToSatisfied the contribute to satisfied of this l f rollup contribution
    */
    @Override
    public void setContributeToSatisfied(java.lang.String contributeToSatisfied) {
        _lfRollupContribution.setContributeToSatisfied(contributeToSatisfied);
    }

    /**
    * Returns the contribute to not satisfied of this l f rollup contribution.
    *
    * @return the contribute to not satisfied of this l f rollup contribution
    */
    @Override
    public java.lang.String getContributeToNotSatisfied() {
        return _lfRollupContribution.getContributeToNotSatisfied();
    }

    /**
    * Sets the contribute to not satisfied of this l f rollup contribution.
    *
    * @param contributeToNotSatisfied the contribute to not satisfied of this l f rollup contribution
    */
    @Override
    public void setContributeToNotSatisfied(
        java.lang.String contributeToNotSatisfied) {
        _lfRollupContribution.setContributeToNotSatisfied(contributeToNotSatisfied);
    }

    /**
    * Returns the contribute to completed of this l f rollup contribution.
    *
    * @return the contribute to completed of this l f rollup contribution
    */
    @Override
    public java.lang.String getContributeToCompleted() {
        return _lfRollupContribution.getContributeToCompleted();
    }

    /**
    * Sets the contribute to completed of this l f rollup contribution.
    *
    * @param contributeToCompleted the contribute to completed of this l f rollup contribution
    */
    @Override
    public void setContributeToCompleted(java.lang.String contributeToCompleted) {
        _lfRollupContribution.setContributeToCompleted(contributeToCompleted);
    }

    /**
    * Returns the contribute to incomplete of this l f rollup contribution.
    *
    * @return the contribute to incomplete of this l f rollup contribution
    */
    @Override
    public java.lang.String getContributeToIncomplete() {
        return _lfRollupContribution.getContributeToIncomplete();
    }

    /**
    * Sets the contribute to incomplete of this l f rollup contribution.
    *
    * @param contributeToIncomplete the contribute to incomplete of this l f rollup contribution
    */
    @Override
    public void setContributeToIncomplete(
        java.lang.String contributeToIncomplete) {
        _lfRollupContribution.setContributeToIncomplete(contributeToIncomplete);
    }

    /**
    * Returns the objective measure weight of this l f rollup contribution.
    *
    * @return the objective measure weight of this l f rollup contribution
    */
    @Override
    public java.math.BigDecimal getObjectiveMeasureWeight() {
        return _lfRollupContribution.getObjectiveMeasureWeight();
    }

    /**
    * Sets the objective measure weight of this l f rollup contribution.
    *
    * @param objectiveMeasureWeight the objective measure weight of this l f rollup contribution
    */
    @Override
    public void setObjectiveMeasureWeight(
        java.math.BigDecimal objectiveMeasureWeight) {
        _lfRollupContribution.setObjectiveMeasureWeight(objectiveMeasureWeight);
    }

    /**
    * Returns the measure satisfaction if active of this l f rollup contribution.
    *
    * @return the measure satisfaction if active of this l f rollup contribution
    */
    @Override
    public boolean getMeasureSatisfactionIfActive() {
        return _lfRollupContribution.getMeasureSatisfactionIfActive();
    }

    /**
    * Returns <code>true</code> if this l f rollup contribution is measure satisfaction if active.
    *
    * @return <code>true</code> if this l f rollup contribution is measure satisfaction if active; <code>false</code> otherwise
    */
    @Override
    public boolean isMeasureSatisfactionIfActive() {
        return _lfRollupContribution.isMeasureSatisfactionIfActive();
    }

    /**
    * Sets whether this l f rollup contribution is measure satisfaction if active.
    *
    * @param measureSatisfactionIfActive the measure satisfaction if active of this l f rollup contribution
    */
    @Override
    public void setMeasureSatisfactionIfActive(
        boolean measureSatisfactionIfActive) {
        _lfRollupContribution.setMeasureSatisfactionIfActive(measureSatisfactionIfActive);
    }

    @Override
    public boolean isNew() {
        return _lfRollupContribution.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfRollupContribution.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfRollupContribution.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfRollupContribution.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfRollupContribution.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfRollupContribution.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfRollupContribution.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfRollupContribution.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfRollupContribution.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfRollupContribution.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfRollupContribution.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFRollupContributionWrapper((LFRollupContribution) _lfRollupContribution.clone());
    }

    @Override
    public int compareTo(LFRollupContribution lfRollupContribution) {
        return _lfRollupContribution.compareTo(lfRollupContribution);
    }

    @Override
    public int hashCode() {
        return _lfRollupContribution.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFRollupContribution> toCacheModel() {
        return _lfRollupContribution.toCacheModel();
    }

    @Override
    public LFRollupContribution toEscapedModel() {
        return new LFRollupContributionWrapper(_lfRollupContribution.toEscapedModel());
    }

    @Override
    public LFRollupContribution toUnescapedModel() {
        return new LFRollupContributionWrapper(_lfRollupContribution.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfRollupContribution.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfRollupContribution.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRollupContribution.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFRollupContributionWrapper)) {
            return false;
        }

        LFRollupContributionWrapper lfRollupContributionWrapper = (LFRollupContributionWrapper) obj;

        if (Validator.equals(_lfRollupContribution,
                    lfRollupContributionWrapper._lfRollupContribution)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFRollupContribution getWrappedLFRollupContribution() {
        return _lfRollupContribution;
    }

    @Override
    public LFRollupContribution getWrappedModel() {
        return _lfRollupContribution;
    }

    @Override
    public void resetOriginalValues() {
        _lfRollupContribution.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFObjective}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFObjective
* @generated
*/
public class LFObjectiveWrapper implements LFObjective,
    ModelWrapper<LFObjective> {
    private LFObjective _lfObjective;

    public LFObjectiveWrapper(LFObjective lfObjective) {
        _lfObjective = lfObjective;
    }

    public Class<?> getModelClass() {
        return LFObjective.class;
    }

    public String getModelClassName() {
        return LFObjective.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("lfId", getLfId());
        attributes.put("sequencingID", getSequencingID());
        attributes.put("satisfiedByMeasure", getSatisfiedByMeasure());
        attributes.put("identifier", getIdentifier());
        attributes.put("minNormalizedMeasure", getMinNormalizedMeasure());
        attributes.put("isPrimary", getIsPrimary());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long lfId = (Long) attributes.get("lfId");

        if (lfId != null) {
            setLfId(lfId);
        }

        Integer sequencingID = (Integer) attributes.get("sequencingID");

        if (sequencingID != null) {
            setSequencingID(sequencingID);
        }

        Boolean satisfiedByMeasure = (Boolean) attributes.get(
                "satisfiedByMeasure");

        if (satisfiedByMeasure != null) {
            setSatisfiedByMeasure(satisfiedByMeasure);
        }

        String identifier = (String) attributes.get("identifier");

        if (identifier != null) {
            setIdentifier(identifier);
        }

        BigDecimal minNormalizedMeasure = (BigDecimal) attributes.get(
                "minNormalizedMeasure");

        if (minNormalizedMeasure != null) {
            setMinNormalizedMeasure(minNormalizedMeasure);
        }

        Boolean isPrimary = (Boolean) attributes.get("isPrimary");

        if (isPrimary != null) {
            setIsPrimary(isPrimary);
        }
    }

    /**
     * Returns the primary key of this l f objective.
     *
     * @return the primary key of this l f objective
     */
    public long getPrimaryKey() {
        return _lfObjective.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f objective.
     *
     * @param primaryKey the primary key of this l f objective
     */
    public void setPrimaryKey(long primaryKey) {
        _lfObjective.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the lf ID of this l f objective.
     *
     * @return the lf ID of this l f objective
     */
    public long getLfId() {
        return _lfObjective.getLfId();
    }

    /**
     * Sets the lf ID of this l f objective.
     *
     * @param lfId the lf ID of this l f objective
     */
    public void setLfId(long lfId) {
        _lfObjective.setLfId(lfId);
    }

    /**
     * Returns the sequencing i d of this l f objective.
     *
     * @return the sequencing i d of this l f objective
     */
    public java.lang.Integer getSequencingID() {
        return _lfObjective.getSequencingID();
    }

    /**
     * Sets the sequencing i d of this l f objective.
     *
     * @param sequencingID the sequencing i d of this l f objective
     */
    public void setSequencingID(java.lang.Integer sequencingID) {
        _lfObjective.setSequencingID(sequencingID);
    }

    /**
     * Returns the satisfied by measure of this l f objective.
     *
     * @return the satisfied by measure of this l f objective
     */
    public boolean getSatisfiedByMeasure() {
        return _lfObjective.getSatisfiedByMeasure();
    }

    /**
     * Returns <code>true</code> if this l f objective is satisfied by measure.
     *
     * @return <code>true</code> if this l f objective is satisfied by measure; <code>false</code> otherwise
     */
    public boolean isSatisfiedByMeasure() {
        return _lfObjective.isSatisfiedByMeasure();
    }

    /**
     * Sets whether this l f objective is satisfied by measure.
     *
     * @param satisfiedByMeasure the satisfied by measure of this l f objective
     */
    public void setSatisfiedByMeasure(boolean satisfiedByMeasure) {
        _lfObjective.setSatisfiedByMeasure(satisfiedByMeasure);
    }

    /**
     * Returns the identifier of this l f objective.
     *
     * @return the identifier of this l f objective
     */
    public java.lang.String getIdentifier() {
        return _lfObjective.getIdentifier();
    }

    /**
     * Sets the identifier of this l f objective.
     *
     * @param identifier the identifier of this l f objective
     */
    public void setIdentifier(java.lang.String identifier) {
        _lfObjective.setIdentifier(identifier);
    }

    /**
     * Returns the min normalized measure of this l f objective.
     *
     * @return the min normalized measure of this l f objective
     */
    public java.math.BigDecimal getMinNormalizedMeasure() {
        return _lfObjective.getMinNormalizedMeasure();
    }

    /**
     * Sets the min normalized measure of this l f objective.
     *
     * @param minNormalizedMeasure the min normalized measure of this l f objective
     */
    public void setMinNormalizedMeasure(
        java.math.BigDecimal minNormalizedMeasure) {
        _lfObjective.setMinNormalizedMeasure(minNormalizedMeasure);
    }

    /**
     * Returns the is primary of this l f objective.
     *
     * @return the is primary of this l f objective
     */
    public java.lang.Boolean getIsPrimary() {
        return _lfObjective.getIsPrimary();
    }

    /**
     * Sets the is primary of this l f objective.
     *
     * @param isPrimary the is primary of this l f objective
     */
    public void setIsPrimary(java.lang.Boolean isPrimary) {
        _lfObjective.setIsPrimary(isPrimary);
    }

    public boolean isNew() {
        return _lfObjective.isNew();
    }

    public void setNew(boolean n) {
        _lfObjective.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfObjective.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfObjective.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfObjective.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfObjective.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfObjective.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfObjective.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfObjective.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFObjectiveWrapper((LFObjective) _lfObjective.clone());
    }

    public int compareTo(LFObjective lfObjective) {
        return _lfObjective.compareTo(lfObjective);
    }

    @Override
    public int hashCode() {
        return _lfObjective.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFObjective> toCacheModel() {
        return _lfObjective.toCacheModel();
    }

    public LFObjective toEscapedModel() {
        return new LFObjectiveWrapper(_lfObjective.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfObjective.toString();
    }

    public java.lang.String toXmlString() {
        return _lfObjective.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfObjective.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFObjective getWrappedLFObjective() {
        return _lfObjective;
    }

    public LFObjective getWrappedModel() {
        return _lfObjective;
    }

    public void resetOriginalValues() {
        _lfObjective.resetOriginalValues();
    }
}

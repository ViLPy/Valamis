package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSequencing}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSequencing
 * @generated
 */
public class LFSequencingWrapper implements LFSequencing,
    ModelWrapper<LFSequencing> {
    private LFSequencing _lfSequencing;

    public LFSequencingWrapper(LFSequencing lfSequencing) {
        _lfSequencing = lfSequencing;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSequencing.class;
    }

    @Override
    public String getModelClassName() {
        return LFSequencing.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("activityID", getActivityID());
        attributes.put("sharedId", getSharedId());
        attributes.put("sharedSequencingIdReference",
            getSharedSequencingIdReference());
        attributes.put("cAttemptObjectiveProgressChild",
            getCAttemptObjectiveProgressChild());
        attributes.put("cAttemptAttemptProgressChild",
            getCAttemptAttemptProgressChild());
        attributes.put("attemptLimit", getAttemptLimit());
        attributes.put("durationLimitInMilliseconds",
            getDurationLimitInMilliseconds());
        attributes.put("rollupContributionID", getRollupContributionID());
        attributes.put("preventChildrenActivation",
            getPreventChildrenActivation());
        attributes.put("constrainChoice", getConstrainChoice());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String activityID = (String) attributes.get("activityID");

        if (activityID != null) {
            setActivityID(activityID);
        }

        String sharedId = (String) attributes.get("sharedId");

        if (sharedId != null) {
            setSharedId(sharedId);
        }

        String sharedSequencingIdReference = (String) attributes.get(
                "sharedSequencingIdReference");

        if (sharedSequencingIdReference != null) {
            setSharedSequencingIdReference(sharedSequencingIdReference);
        }

        Boolean cAttemptObjectiveProgressChild = (Boolean) attributes.get(
                "cAttemptObjectiveProgressChild");

        if (cAttemptObjectiveProgressChild != null) {
            setCAttemptObjectiveProgressChild(cAttemptObjectiveProgressChild);
        }

        Boolean cAttemptAttemptProgressChild = (Boolean) attributes.get(
                "cAttemptAttemptProgressChild");

        if (cAttemptAttemptProgressChild != null) {
            setCAttemptAttemptProgressChild(cAttemptAttemptProgressChild);
        }

        Integer attemptLimit = (Integer) attributes.get("attemptLimit");

        if (attemptLimit != null) {
            setAttemptLimit(attemptLimit);
        }

        Long durationLimitInMilliseconds = (Long) attributes.get(
                "durationLimitInMilliseconds");

        if (durationLimitInMilliseconds != null) {
            setDurationLimitInMilliseconds(durationLimitInMilliseconds);
        }

        Integer rollupContributionID = (Integer) attributes.get(
                "rollupContributionID");

        if (rollupContributionID != null) {
            setRollupContributionID(rollupContributionID);
        }

        Boolean preventChildrenActivation = (Boolean) attributes.get(
                "preventChildrenActivation");

        if (preventChildrenActivation != null) {
            setPreventChildrenActivation(preventChildrenActivation);
        }

        Boolean constrainChoice = (Boolean) attributes.get("constrainChoice");

        if (constrainChoice != null) {
            setConstrainChoice(constrainChoice);
        }
    }

    /**
    * Returns the primary key of this l f sequencing.
    *
    * @return the primary key of this l f sequencing
    */
    @Override
    public long getPrimaryKey() {
        return _lfSequencing.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f sequencing.
    *
    * @param primaryKey the primary key of this l f sequencing
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSequencing.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f sequencing.
    *
    * @return the ID of this l f sequencing
    */
    @Override
    public long getId() {
        return _lfSequencing.getId();
    }

    /**
    * Sets the ID of this l f sequencing.
    *
    * @param id the ID of this l f sequencing
    */
    @Override
    public void setId(long id) {
        _lfSequencing.setId(id);
    }

    /**
    * Returns the package i d of this l f sequencing.
    *
    * @return the package i d of this l f sequencing
    */
    @Override
    public java.lang.Integer getPackageID() {
        return _lfSequencing.getPackageID();
    }

    /**
    * Sets the package i d of this l f sequencing.
    *
    * @param packageID the package i d of this l f sequencing
    */
    @Override
    public void setPackageID(java.lang.Integer packageID) {
        _lfSequencing.setPackageID(packageID);
    }

    /**
    * Returns the activity i d of this l f sequencing.
    *
    * @return the activity i d of this l f sequencing
    */
    @Override
    public java.lang.String getActivityID() {
        return _lfSequencing.getActivityID();
    }

    /**
    * Sets the activity i d of this l f sequencing.
    *
    * @param activityID the activity i d of this l f sequencing
    */
    @Override
    public void setActivityID(java.lang.String activityID) {
        _lfSequencing.setActivityID(activityID);
    }

    /**
    * Returns the shared ID of this l f sequencing.
    *
    * @return the shared ID of this l f sequencing
    */
    @Override
    public java.lang.String getSharedId() {
        return _lfSequencing.getSharedId();
    }

    /**
    * Sets the shared ID of this l f sequencing.
    *
    * @param sharedId the shared ID of this l f sequencing
    */
    @Override
    public void setSharedId(java.lang.String sharedId) {
        _lfSequencing.setSharedId(sharedId);
    }

    /**
    * Returns the shared sequencing ID reference of this l f sequencing.
    *
    * @return the shared sequencing ID reference of this l f sequencing
    */
    @Override
    public java.lang.String getSharedSequencingIdReference() {
        return _lfSequencing.getSharedSequencingIdReference();
    }

    /**
    * Sets the shared sequencing ID reference of this l f sequencing.
    *
    * @param sharedSequencingIdReference the shared sequencing ID reference of this l f sequencing
    */
    @Override
    public void setSharedSequencingIdReference(
        java.lang.String sharedSequencingIdReference) {
        _lfSequencing.setSharedSequencingIdReference(sharedSequencingIdReference);
    }

    /**
    * Returns the c attempt objective progress child of this l f sequencing.
    *
    * @return the c attempt objective progress child of this l f sequencing
    */
    @Override
    public boolean getCAttemptObjectiveProgressChild() {
        return _lfSequencing.getCAttemptObjectiveProgressChild();
    }

    /**
    * Returns <code>true</code> if this l f sequencing is c attempt objective progress child.
    *
    * @return <code>true</code> if this l f sequencing is c attempt objective progress child; <code>false</code> otherwise
    */
    @Override
    public boolean isCAttemptObjectiveProgressChild() {
        return _lfSequencing.isCAttemptObjectiveProgressChild();
    }

    /**
    * Sets whether this l f sequencing is c attempt objective progress child.
    *
    * @param cAttemptObjectiveProgressChild the c attempt objective progress child of this l f sequencing
    */
    @Override
    public void setCAttemptObjectiveProgressChild(
        boolean cAttemptObjectiveProgressChild) {
        _lfSequencing.setCAttemptObjectiveProgressChild(cAttemptObjectiveProgressChild);
    }

    /**
    * Returns the c attempt attempt progress child of this l f sequencing.
    *
    * @return the c attempt attempt progress child of this l f sequencing
    */
    @Override
    public boolean getCAttemptAttemptProgressChild() {
        return _lfSequencing.getCAttemptAttemptProgressChild();
    }

    /**
    * Returns <code>true</code> if this l f sequencing is c attempt attempt progress child.
    *
    * @return <code>true</code> if this l f sequencing is c attempt attempt progress child; <code>false</code> otherwise
    */
    @Override
    public boolean isCAttemptAttemptProgressChild() {
        return _lfSequencing.isCAttemptAttemptProgressChild();
    }

    /**
    * Sets whether this l f sequencing is c attempt attempt progress child.
    *
    * @param cAttemptAttemptProgressChild the c attempt attempt progress child of this l f sequencing
    */
    @Override
    public void setCAttemptAttemptProgressChild(
        boolean cAttemptAttemptProgressChild) {
        _lfSequencing.setCAttemptAttemptProgressChild(cAttemptAttemptProgressChild);
    }

    /**
    * Returns the attempt limit of this l f sequencing.
    *
    * @return the attempt limit of this l f sequencing
    */
    @Override
    public java.lang.Integer getAttemptLimit() {
        return _lfSequencing.getAttemptLimit();
    }

    /**
    * Sets the attempt limit of this l f sequencing.
    *
    * @param attemptLimit the attempt limit of this l f sequencing
    */
    @Override
    public void setAttemptLimit(java.lang.Integer attemptLimit) {
        _lfSequencing.setAttemptLimit(attemptLimit);
    }

    /**
    * Returns the duration limit in milliseconds of this l f sequencing.
    *
    * @return the duration limit in milliseconds of this l f sequencing
    */
    @Override
    public java.lang.Long getDurationLimitInMilliseconds() {
        return _lfSequencing.getDurationLimitInMilliseconds();
    }

    /**
    * Sets the duration limit in milliseconds of this l f sequencing.
    *
    * @param durationLimitInMilliseconds the duration limit in milliseconds of this l f sequencing
    */
    @Override
    public void setDurationLimitInMilliseconds(
        java.lang.Long durationLimitInMilliseconds) {
        _lfSequencing.setDurationLimitInMilliseconds(durationLimitInMilliseconds);
    }

    /**
    * Returns the rollup contribution i d of this l f sequencing.
    *
    * @return the rollup contribution i d of this l f sequencing
    */
    @Override
    public java.lang.Integer getRollupContributionID() {
        return _lfSequencing.getRollupContributionID();
    }

    /**
    * Sets the rollup contribution i d of this l f sequencing.
    *
    * @param rollupContributionID the rollup contribution i d of this l f sequencing
    */
    @Override
    public void setRollupContributionID(java.lang.Integer rollupContributionID) {
        _lfSequencing.setRollupContributionID(rollupContributionID);
    }

    /**
    * Returns the prevent children activation of this l f sequencing.
    *
    * @return the prevent children activation of this l f sequencing
    */
    @Override
    public boolean getPreventChildrenActivation() {
        return _lfSequencing.getPreventChildrenActivation();
    }

    /**
    * Returns <code>true</code> if this l f sequencing is prevent children activation.
    *
    * @return <code>true</code> if this l f sequencing is prevent children activation; <code>false</code> otherwise
    */
    @Override
    public boolean isPreventChildrenActivation() {
        return _lfSequencing.isPreventChildrenActivation();
    }

    /**
    * Sets whether this l f sequencing is prevent children activation.
    *
    * @param preventChildrenActivation the prevent children activation of this l f sequencing
    */
    @Override
    public void setPreventChildrenActivation(boolean preventChildrenActivation) {
        _lfSequencing.setPreventChildrenActivation(preventChildrenActivation);
    }

    /**
    * Returns the constrain choice of this l f sequencing.
    *
    * @return the constrain choice of this l f sequencing
    */
    @Override
    public boolean getConstrainChoice() {
        return _lfSequencing.getConstrainChoice();
    }

    /**
    * Returns <code>true</code> if this l f sequencing is constrain choice.
    *
    * @return <code>true</code> if this l f sequencing is constrain choice; <code>false</code> otherwise
    */
    @Override
    public boolean isConstrainChoice() {
        return _lfSequencing.isConstrainChoice();
    }

    /**
    * Sets whether this l f sequencing is constrain choice.
    *
    * @param constrainChoice the constrain choice of this l f sequencing
    */
    @Override
    public void setConstrainChoice(boolean constrainChoice) {
        _lfSequencing.setConstrainChoice(constrainChoice);
    }

    @Override
    public boolean isNew() {
        return _lfSequencing.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSequencing.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSequencing.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSequencing.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSequencing.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSequencing.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSequencing.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSequencing.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSequencing.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSequencing.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSequencing.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSequencingWrapper((LFSequencing) _lfSequencing.clone());
    }

    @Override
    public int compareTo(LFSequencing lfSequencing) {
        return _lfSequencing.compareTo(lfSequencing);
    }

    @Override
    public int hashCode() {
        return _lfSequencing.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSequencing> toCacheModel() {
        return _lfSequencing.toCacheModel();
    }

    @Override
    public LFSequencing toEscapedModel() {
        return new LFSequencingWrapper(_lfSequencing.toEscapedModel());
    }

    @Override
    public LFSequencing toUnescapedModel() {
        return new LFSequencingWrapper(_lfSequencing.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSequencing.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSequencing.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSequencing.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSequencingWrapper)) {
            return false;
        }

        LFSequencingWrapper lfSequencingWrapper = (LFSequencingWrapper) obj;

        if (Validator.equals(_lfSequencing, lfSequencingWrapper._lfSequencing)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSequencing getWrappedLFSequencing() {
        return _lfSequencing;
    }

    @Override
    public LFSequencing getWrappedModel() {
        return _lfSequencing;
    }

    @Override
    public void resetOriginalValues() {
        _lfSequencing.resetOriginalValues();
    }
}

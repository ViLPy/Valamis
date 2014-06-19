package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateActivity
 * @generated
 */
public class LFCertificateActivityWrapper implements LFCertificateActivity,
    ModelWrapper<LFCertificateActivity> {
    private LFCertificateActivity _lfCertificateActivity;

    public LFCertificateActivityWrapper(
        LFCertificateActivity lfCertificateActivity) {
        _lfCertificateActivity = lfCertificateActivity;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateActivity.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("activityName", getActivityName());
        attributes.put("datacount", getDatacount());
        attributes.put("periodType", getPeriodType());
        attributes.put("period", getPeriod());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long certificateID = (Long) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        String activityName = (String) attributes.get("activityName");

        if (activityName != null) {
            setActivityName(activityName);
        }

        Integer datacount = (Integer) attributes.get("datacount");

        if (datacount != null) {
            setDatacount(datacount);
        }

        String periodType = (String) attributes.get("periodType");

        if (periodType != null) {
            setPeriodType(periodType);
        }

        Integer period = (Integer) attributes.get("period");

        if (period != null) {
            setPeriod(period);
        }
    }

    /**
    * Returns the primary key of this l f certificate activity.
    *
    * @return the primary key of this l f certificate activity
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK getPrimaryKey() {
        return _lfCertificateActivity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate activity.
    *
    * @param primaryKey the primary key of this l f certificate activity
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK primaryKey) {
        _lfCertificateActivity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the certificate i d of this l f certificate activity.
    *
    * @return the certificate i d of this l f certificate activity
    */
    @Override
    public java.lang.Long getCertificateID() {
        return _lfCertificateActivity.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate activity.
    *
    * @param certificateID the certificate i d of this l f certificate activity
    */
    @Override
    public void setCertificateID(java.lang.Long certificateID) {
        _lfCertificateActivity.setCertificateID(certificateID);
    }

    /**
    * Returns the activity name of this l f certificate activity.
    *
    * @return the activity name of this l f certificate activity
    */
    @Override
    public java.lang.String getActivityName() {
        return _lfCertificateActivity.getActivityName();
    }

    /**
    * Sets the activity name of this l f certificate activity.
    *
    * @param activityName the activity name of this l f certificate activity
    */
    @Override
    public void setActivityName(java.lang.String activityName) {
        _lfCertificateActivity.setActivityName(activityName);
    }

    /**
    * Returns the datacount of this l f certificate activity.
    *
    * @return the datacount of this l f certificate activity
    */
    @Override
    public java.lang.Integer getDatacount() {
        return _lfCertificateActivity.getDatacount();
    }

    /**
    * Sets the datacount of this l f certificate activity.
    *
    * @param datacount the datacount of this l f certificate activity
    */
    @Override
    public void setDatacount(java.lang.Integer datacount) {
        _lfCertificateActivity.setDatacount(datacount);
    }

    /**
    * Returns the period type of this l f certificate activity.
    *
    * @return the period type of this l f certificate activity
    */
    @Override
    public java.lang.String getPeriodType() {
        return _lfCertificateActivity.getPeriodType();
    }

    /**
    * Sets the period type of this l f certificate activity.
    *
    * @param periodType the period type of this l f certificate activity
    */
    @Override
    public void setPeriodType(java.lang.String periodType) {
        _lfCertificateActivity.setPeriodType(periodType);
    }

    /**
    * Returns the period of this l f certificate activity.
    *
    * @return the period of this l f certificate activity
    */
    @Override
    public java.lang.Integer getPeriod() {
        return _lfCertificateActivity.getPeriod();
    }

    /**
    * Sets the period of this l f certificate activity.
    *
    * @param period the period of this l f certificate activity
    */
    @Override
    public void setPeriod(java.lang.Integer period) {
        _lfCertificateActivity.setPeriod(period);
    }

    @Override
    public boolean isNew() {
        return _lfCertificateActivity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificateActivity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificateActivity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificateActivity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificateActivity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateActivity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateActivity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificateActivity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificateActivity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateActivityWrapper((LFCertificateActivity) _lfCertificateActivity.clone());
    }

    @Override
    public int compareTo(LFCertificateActivity lfCertificateActivity) {
        return _lfCertificateActivity.compareTo(lfCertificateActivity);
    }

    @Override
    public int hashCode() {
        return _lfCertificateActivity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificateActivity> toCacheModel() {
        return _lfCertificateActivity.toCacheModel();
    }

    @Override
    public LFCertificateActivity toEscapedModel() {
        return new LFCertificateActivityWrapper(_lfCertificateActivity.toEscapedModel());
    }

    @Override
    public LFCertificateActivity toUnescapedModel() {
        return new LFCertificateActivityWrapper(_lfCertificateActivity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateActivity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificateActivity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateActivity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateActivityWrapper)) {
            return false;
        }

        LFCertificateActivityWrapper lfCertificateActivityWrapper = (LFCertificateActivityWrapper) obj;

        if (Validator.equals(_lfCertificateActivity,
                    lfCertificateActivityWrapper._lfCertificateActivity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificateActivity getWrappedLFCertificateActivity() {
        return _lfCertificateActivity;
    }

    @Override
    public LFCertificateActivity getWrappedModel() {
        return _lfCertificateActivity;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificateActivity.resetOriginalValues();
    }
}

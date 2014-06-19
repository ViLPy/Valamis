package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFCertificateTincanStatement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFCertificateTincanStatement
 * @generated
 */
public class LFCertificateTincanStatementWrapper
    implements LFCertificateTincanStatement,
        ModelWrapper<LFCertificateTincanStatement> {
    private LFCertificateTincanStatement _lfCertificateTincanStatement;

    public LFCertificateTincanStatementWrapper(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        _lfCertificateTincanStatement = lfCertificateTincanStatement;
    }

    @Override
    public Class<?> getModelClass() {
        return LFCertificateTincanStatement.class;
    }

    @Override
    public String getModelClassName() {
        return LFCertificateTincanStatement.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("certificateID", getCertificateID());
        attributes.put("verb", getVerb());
        attributes.put("object", getObject());
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

        String verb = (String) attributes.get("verb");

        if (verb != null) {
            setVerb(verb);
        }

        String object = (String) attributes.get("object");

        if (object != null) {
            setObject(object);
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
    * Returns the primary key of this l f certificate tincan statement.
    *
    * @return the primary key of this l f certificate tincan statement
    */
    @Override
    public com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK getPrimaryKey() {
        return _lfCertificateTincanStatement.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f certificate tincan statement.
    *
    * @param primaryKey the primary key of this l f certificate tincan statement
    */
    @Override
    public void setPrimaryKey(
        com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateTincanStatementPK primaryKey) {
        _lfCertificateTincanStatement.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the certificate i d of this l f certificate tincan statement.
    *
    * @return the certificate i d of this l f certificate tincan statement
    */
    @Override
    public java.lang.Long getCertificateID() {
        return _lfCertificateTincanStatement.getCertificateID();
    }

    /**
    * Sets the certificate i d of this l f certificate tincan statement.
    *
    * @param certificateID the certificate i d of this l f certificate tincan statement
    */
    @Override
    public void setCertificateID(java.lang.Long certificateID) {
        _lfCertificateTincanStatement.setCertificateID(certificateID);
    }

    /**
    * Returns the verb of this l f certificate tincan statement.
    *
    * @return the verb of this l f certificate tincan statement
    */
    @Override
    public java.lang.String getVerb() {
        return _lfCertificateTincanStatement.getVerb();
    }

    /**
    * Sets the verb of this l f certificate tincan statement.
    *
    * @param verb the verb of this l f certificate tincan statement
    */
    @Override
    public void setVerb(java.lang.String verb) {
        _lfCertificateTincanStatement.setVerb(verb);
    }

    /**
    * Returns the object of this l f certificate tincan statement.
    *
    * @return the object of this l f certificate tincan statement
    */
    @Override
    public java.lang.String getObject() {
        return _lfCertificateTincanStatement.getObject();
    }

    /**
    * Sets the object of this l f certificate tincan statement.
    *
    * @param object the object of this l f certificate tincan statement
    */
    @Override
    public void setObject(java.lang.String object) {
        _lfCertificateTincanStatement.setObject(object);
    }

    /**
    * Returns the period type of this l f certificate tincan statement.
    *
    * @return the period type of this l f certificate tincan statement
    */
    @Override
    public java.lang.String getPeriodType() {
        return _lfCertificateTincanStatement.getPeriodType();
    }

    /**
    * Sets the period type of this l f certificate tincan statement.
    *
    * @param periodType the period type of this l f certificate tincan statement
    */
    @Override
    public void setPeriodType(java.lang.String periodType) {
        _lfCertificateTincanStatement.setPeriodType(periodType);
    }

    /**
    * Returns the period of this l f certificate tincan statement.
    *
    * @return the period of this l f certificate tincan statement
    */
    @Override
    public java.lang.Integer getPeriod() {
        return _lfCertificateTincanStatement.getPeriod();
    }

    /**
    * Sets the period of this l f certificate tincan statement.
    *
    * @param period the period of this l f certificate tincan statement
    */
    @Override
    public void setPeriod(java.lang.Integer period) {
        _lfCertificateTincanStatement.setPeriod(period);
    }

    @Override
    public boolean isNew() {
        return _lfCertificateTincanStatement.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfCertificateTincanStatement.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfCertificateTincanStatement.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfCertificateTincanStatement.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfCertificateTincanStatement.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfCertificateTincanStatement.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfCertificateTincanStatement.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfCertificateTincanStatement.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfCertificateTincanStatement.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfCertificateTincanStatement.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfCertificateTincanStatement.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFCertificateTincanStatementWrapper((LFCertificateTincanStatement) _lfCertificateTincanStatement.clone());
    }

    @Override
    public int compareTo(
        LFCertificateTincanStatement lfCertificateTincanStatement) {
        return _lfCertificateTincanStatement.compareTo(lfCertificateTincanStatement);
    }

    @Override
    public int hashCode() {
        return _lfCertificateTincanStatement.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFCertificateTincanStatement> toCacheModel() {
        return _lfCertificateTincanStatement.toCacheModel();
    }

    @Override
    public LFCertificateTincanStatement toEscapedModel() {
        return new LFCertificateTincanStatementWrapper(_lfCertificateTincanStatement.toEscapedModel());
    }

    @Override
    public LFCertificateTincanStatement toUnescapedModel() {
        return new LFCertificateTincanStatementWrapper(_lfCertificateTincanStatement.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfCertificateTincanStatement.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfCertificateTincanStatement.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfCertificateTincanStatement.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFCertificateTincanStatementWrapper)) {
            return false;
        }

        LFCertificateTincanStatementWrapper lfCertificateTincanStatementWrapper = (LFCertificateTincanStatementWrapper) obj;

        if (Validator.equals(_lfCertificateTincanStatement,
                    lfCertificateTincanStatementWrapper._lfCertificateTincanStatement)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFCertificateTincanStatement getWrappedLFCertificateTincanStatement() {
        return _lfCertificateTincanStatement;
    }

    @Override
    public LFCertificateTincanStatement getWrappedModel() {
        return _lfCertificateTincanStatement;
    }

    @Override
    public void resetOriginalValues() {
        _lfCertificateTincanStatement.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFBigDecimal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFBigDecimal
 * @generated
 */
public class LFBigDecimalWrapper implements LFBigDecimal,
    ModelWrapper<LFBigDecimal> {
    private LFBigDecimal _lfBigDecimal;

    public LFBigDecimalWrapper(LFBigDecimal lfBigDecimal) {
        _lfBigDecimal = lfBigDecimal;
    }

    @Override
    public Class<?> getModelClass() {
        return LFBigDecimal.class;
    }

    @Override
    public String getModelClassName() {
        return LFBigDecimal.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("decimal", getDecimal());
        attributes.put("text", getText());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        BigDecimal decimal = (BigDecimal) attributes.get("decimal");

        if (decimal != null) {
            setDecimal(decimal);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }
    }

    /**
    * Returns the primary key of this l f big decimal.
    *
    * @return the primary key of this l f big decimal
    */
    @Override
    public long getPrimaryKey() {
        return _lfBigDecimal.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f big decimal.
    *
    * @param primaryKey the primary key of this l f big decimal
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfBigDecimal.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f big decimal.
    *
    * @return the ID of this l f big decimal
    */
    @Override
    public long getId() {
        return _lfBigDecimal.getId();
    }

    /**
    * Sets the ID of this l f big decimal.
    *
    * @param id the ID of this l f big decimal
    */
    @Override
    public void setId(long id) {
        _lfBigDecimal.setId(id);
    }

    /**
    * Returns the decimal of this l f big decimal.
    *
    * @return the decimal of this l f big decimal
    */
    @Override
    public java.math.BigDecimal getDecimal() {
        return _lfBigDecimal.getDecimal();
    }

    /**
    * Sets the decimal of this l f big decimal.
    *
    * @param decimal the decimal of this l f big decimal
    */
    @Override
    public void setDecimal(java.math.BigDecimal decimal) {
        _lfBigDecimal.setDecimal(decimal);
    }

    /**
    * Returns the text of this l f big decimal.
    *
    * @return the text of this l f big decimal
    */
    @Override
    public java.lang.String getText() {
        return _lfBigDecimal.getText();
    }

    /**
    * Sets the text of this l f big decimal.
    *
    * @param text the text of this l f big decimal
    */
    @Override
    public void setText(java.lang.String text) {
        _lfBigDecimal.setText(text);
    }

    @Override
    public boolean isNew() {
        return _lfBigDecimal.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfBigDecimal.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfBigDecimal.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfBigDecimal.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfBigDecimal.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfBigDecimal.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfBigDecimal.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfBigDecimal.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfBigDecimal.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfBigDecimal.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfBigDecimal.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFBigDecimalWrapper((LFBigDecimal) _lfBigDecimal.clone());
    }

    @Override
    public int compareTo(LFBigDecimal lfBigDecimal) {
        return _lfBigDecimal.compareTo(lfBigDecimal);
    }

    @Override
    public int hashCode() {
        return _lfBigDecimal.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFBigDecimal> toCacheModel() {
        return _lfBigDecimal.toCacheModel();
    }

    @Override
    public LFBigDecimal toEscapedModel() {
        return new LFBigDecimalWrapper(_lfBigDecimal.toEscapedModel());
    }

    @Override
    public LFBigDecimal toUnescapedModel() {
        return new LFBigDecimalWrapper(_lfBigDecimal.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfBigDecimal.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfBigDecimal.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfBigDecimal.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFBigDecimalWrapper)) {
            return false;
        }

        LFBigDecimalWrapper lfBigDecimalWrapper = (LFBigDecimalWrapper) obj;

        if (Validator.equals(_lfBigDecimal, lfBigDecimalWrapper._lfBigDecimal)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFBigDecimal getWrappedLFBigDecimal() {
        return _lfBigDecimal;
    }

    @Override
    public LFBigDecimal getWrappedModel() {
        return _lfBigDecimal;
    }

    @Override
    public void resetOriginalValues() {
        _lfBigDecimal.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFBigDecimal}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFBigDecimal
* @generated
*/
public class LFBigDecimalWrapper implements LFBigDecimal,
    ModelWrapper<LFBigDecimal> {
    private LFBigDecimal _lfBigDecimal;

    public LFBigDecimalWrapper(LFBigDecimal lfBigDecimal) {
        _lfBigDecimal = lfBigDecimal;
    }

    public Class<?> getModelClass() {
        return LFBigDecimal.class;
    }

    public String getModelClassName() {
        return LFBigDecimal.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("decimal", getDecimal());
        attributes.put("text", getText());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfBigDecimal.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f big decimal.
     *
     * @param primaryKey the primary key of this l f big decimal
     */
    public void setPrimaryKey(long primaryKey) {
        _lfBigDecimal.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f big decimal.
     *
     * @return the ID of this l f big decimal
     */
    public long getId() {
        return _lfBigDecimal.getId();
    }

    /**
     * Sets the ID of this l f big decimal.
     *
     * @param id the ID of this l f big decimal
     */
    public void setId(long id) {
        _lfBigDecimal.setId(id);
    }

    /**
     * Returns the decimal of this l f big decimal.
     *
     * @return the decimal of this l f big decimal
     */
    public java.math.BigDecimal getDecimal() {
        return _lfBigDecimal.getDecimal();
    }

    /**
     * Sets the decimal of this l f big decimal.
     *
     * @param decimal the decimal of this l f big decimal
     */
    public void setDecimal(java.math.BigDecimal decimal) {
        _lfBigDecimal.setDecimal(decimal);
    }

    /**
     * Returns the text of this l f big decimal.
     *
     * @return the text of this l f big decimal
     */
    public java.lang.String getText() {
        return _lfBigDecimal.getText();
    }

    /**
     * Sets the text of this l f big decimal.
     *
     * @param text the text of this l f big decimal
     */
    public void setText(java.lang.String text) {
        _lfBigDecimal.setText(text);
    }

    public boolean isNew() {
        return _lfBigDecimal.isNew();
    }

    public void setNew(boolean n) {
        _lfBigDecimal.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfBigDecimal.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfBigDecimal.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfBigDecimal.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfBigDecimal.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfBigDecimal.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfBigDecimal.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfBigDecimal.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFBigDecimalWrapper((LFBigDecimal) _lfBigDecimal.clone());
    }

    public int compareTo(LFBigDecimal lfBigDecimal) {
        return _lfBigDecimal.compareTo(lfBigDecimal);
    }

    @Override
    public int hashCode() {
        return _lfBigDecimal.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFBigDecimal> toCacheModel() {
        return _lfBigDecimal.toCacheModel();
    }

    public LFBigDecimal toEscapedModel() {
        return new LFBigDecimalWrapper(_lfBigDecimal.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfBigDecimal.toString();
    }

    public java.lang.String toXmlString() {
        return _lfBigDecimal.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfBigDecimal.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFBigDecimal getWrappedLFBigDecimal() {
        return _lfBigDecimal;
    }

    public LFBigDecimal getWrappedModel() {
        return _lfBigDecimal;
    }

    public void resetOriginalValues() {
        _lfBigDecimal.resetOriginalValues();
    }
}

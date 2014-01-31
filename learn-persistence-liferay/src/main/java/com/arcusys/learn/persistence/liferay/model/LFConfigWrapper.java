package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFConfig
 * @generated
 */
public class LFConfigWrapper implements LFConfig, ModelWrapper<LFConfig> {
    private LFConfig _lfConfig;

    public LFConfigWrapper(LFConfig lfConfig) {
        _lfConfig = lfConfig;
    }

    @Override
    public Class<?> getModelClass() {
        return LFConfig.class;
    }

    @Override
    public String getModelClassName() {
        return LFConfig.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("dataKey", getDataKey());
        attributes.put("dataValue", getDataValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String dataKey = (String) attributes.get("dataKey");

        if (dataKey != null) {
            setDataKey(dataKey);
        }

        String dataValue = (String) attributes.get("dataValue");

        if (dataValue != null) {
            setDataValue(dataValue);
        }
    }

    /**
    * Returns the primary key of this l f config.
    *
    * @return the primary key of this l f config
    */
    @Override
    public long getPrimaryKey() {
        return _lfConfig.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f config.
    *
    * @param primaryKey the primary key of this l f config
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfConfig.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f config.
    *
    * @return the ID of this l f config
    */
    @Override
    public long getId() {
        return _lfConfig.getId();
    }

    /**
    * Sets the ID of this l f config.
    *
    * @param id the ID of this l f config
    */
    @Override
    public void setId(long id) {
        _lfConfig.setId(id);
    }

    /**
    * Returns the data key of this l f config.
    *
    * @return the data key of this l f config
    */
    @Override
    public java.lang.String getDataKey() {
        return _lfConfig.getDataKey();
    }

    /**
    * Sets the data key of this l f config.
    *
    * @param dataKey the data key of this l f config
    */
    @Override
    public void setDataKey(java.lang.String dataKey) {
        _lfConfig.setDataKey(dataKey);
    }

    /**
    * Returns the data value of this l f config.
    *
    * @return the data value of this l f config
    */
    @Override
    public java.lang.String getDataValue() {
        return _lfConfig.getDataValue();
    }

    /**
    * Sets the data value of this l f config.
    *
    * @param dataValue the data value of this l f config
    */
    @Override
    public void setDataValue(java.lang.String dataValue) {
        _lfConfig.setDataValue(dataValue);
    }

    @Override
    public boolean isNew() {
        return _lfConfig.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfConfig.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfConfig.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfConfig.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfConfig.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfConfig.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfConfig.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfConfig.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfConfig.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfConfig.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfConfig.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFConfigWrapper((LFConfig) _lfConfig.clone());
    }

    @Override
    public int compareTo(LFConfig lfConfig) {
        return _lfConfig.compareTo(lfConfig);
    }

    @Override
    public int hashCode() {
        return _lfConfig.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFConfig> toCacheModel() {
        return _lfConfig.toCacheModel();
    }

    @Override
    public LFConfig toEscapedModel() {
        return new LFConfigWrapper(_lfConfig.toEscapedModel());
    }

    @Override
    public LFConfig toUnescapedModel() {
        return new LFConfigWrapper(_lfConfig.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfConfig.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfConfig.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfConfig.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFConfigWrapper)) {
            return false;
        }

        LFConfigWrapper lfConfigWrapper = (LFConfigWrapper) obj;

        if (Validator.equals(_lfConfig, lfConfigWrapper._lfConfig)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFConfig getWrappedLFConfig() {
        return _lfConfig;
    }

    @Override
    public LFConfig getWrappedModel() {
        return _lfConfig;
    }

    @Override
    public void resetOriginalValues() {
        _lfConfig.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSiteDependentConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSiteDependentConfig
 * @generated
 */
public class LFSiteDependentConfigWrapper implements LFSiteDependentConfig,
    ModelWrapper<LFSiteDependentConfig> {
    private LFSiteDependentConfig _lfSiteDependentConfig;

    public LFSiteDependentConfigWrapper(
        LFSiteDependentConfig lfSiteDependentConfig) {
        _lfSiteDependentConfig = lfSiteDependentConfig;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSiteDependentConfig.class;
    }

    @Override
    public String getModelClassName() {
        return LFSiteDependentConfig.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("siteID", getSiteID());
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

        Integer siteID = (Integer) attributes.get("siteID");

        if (siteID != null) {
            setSiteID(siteID);
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
    * Returns the primary key of this l f site dependent config.
    *
    * @return the primary key of this l f site dependent config
    */
    @Override
    public long getPrimaryKey() {
        return _lfSiteDependentConfig.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f site dependent config.
    *
    * @param primaryKey the primary key of this l f site dependent config
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSiteDependentConfig.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f site dependent config.
    *
    * @return the ID of this l f site dependent config
    */
    @Override
    public long getId() {
        return _lfSiteDependentConfig.getId();
    }

    /**
    * Sets the ID of this l f site dependent config.
    *
    * @param id the ID of this l f site dependent config
    */
    @Override
    public void setId(long id) {
        _lfSiteDependentConfig.setId(id);
    }

    /**
    * Returns the site i d of this l f site dependent config.
    *
    * @return the site i d of this l f site dependent config
    */
    @Override
    public java.lang.Integer getSiteID() {
        return _lfSiteDependentConfig.getSiteID();
    }

    /**
    * Sets the site i d of this l f site dependent config.
    *
    * @param siteID the site i d of this l f site dependent config
    */
    @Override
    public void setSiteID(java.lang.Integer siteID) {
        _lfSiteDependentConfig.setSiteID(siteID);
    }

    /**
    * Returns the data key of this l f site dependent config.
    *
    * @return the data key of this l f site dependent config
    */
    @Override
    public java.lang.String getDataKey() {
        return _lfSiteDependentConfig.getDataKey();
    }

    /**
    * Sets the data key of this l f site dependent config.
    *
    * @param dataKey the data key of this l f site dependent config
    */
    @Override
    public void setDataKey(java.lang.String dataKey) {
        _lfSiteDependentConfig.setDataKey(dataKey);
    }

    /**
    * Returns the data value of this l f site dependent config.
    *
    * @return the data value of this l f site dependent config
    */
    @Override
    public java.lang.String getDataValue() {
        return _lfSiteDependentConfig.getDataValue();
    }

    /**
    * Sets the data value of this l f site dependent config.
    *
    * @param dataValue the data value of this l f site dependent config
    */
    @Override
    public void setDataValue(java.lang.String dataValue) {
        _lfSiteDependentConfig.setDataValue(dataValue);
    }

    @Override
    public boolean isNew() {
        return _lfSiteDependentConfig.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSiteDependentConfig.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSiteDependentConfig.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSiteDependentConfig.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSiteDependentConfig.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSiteDependentConfig.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSiteDependentConfig.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSiteDependentConfig.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSiteDependentConfig.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSiteDependentConfig.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSiteDependentConfig.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSiteDependentConfigWrapper((LFSiteDependentConfig) _lfSiteDependentConfig.clone());
    }

    @Override
    public int compareTo(LFSiteDependentConfig lfSiteDependentConfig) {
        return _lfSiteDependentConfig.compareTo(lfSiteDependentConfig);
    }

    @Override
    public int hashCode() {
        return _lfSiteDependentConfig.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSiteDependentConfig> toCacheModel() {
        return _lfSiteDependentConfig.toCacheModel();
    }

    @Override
    public LFSiteDependentConfig toEscapedModel() {
        return new LFSiteDependentConfigWrapper(_lfSiteDependentConfig.toEscapedModel());
    }

    @Override
    public LFSiteDependentConfig toUnescapedModel() {
        return new LFSiteDependentConfigWrapper(_lfSiteDependentConfig.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSiteDependentConfig.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSiteDependentConfig.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSiteDependentConfig.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSiteDependentConfigWrapper)) {
            return false;
        }

        LFSiteDependentConfigWrapper lfSiteDependentConfigWrapper = (LFSiteDependentConfigWrapper) obj;

        if (Validator.equals(_lfSiteDependentConfig,
                    lfSiteDependentConfigWrapper._lfSiteDependentConfig)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSiteDependentConfig getWrappedLFSiteDependentConfig() {
        return _lfSiteDependentConfig;
    }

    @Override
    public LFSiteDependentConfig getWrappedModel() {
        return _lfSiteDependentConfig;
    }

    @Override
    public void resetOriginalValues() {
        _lfSiteDependentConfig.resetOriginalValues();
    }
}

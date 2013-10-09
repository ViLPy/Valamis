package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFSettings}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFSettings
* @generated
*/
public class LFSettingsWrapper implements LFSettings, ModelWrapper<LFSettings> {
    private LFSettings _lfSettings;

    public LFSettingsWrapper(LFSettings lfSettings) {
        _lfSettings = lfSettings;
    }

    public Class<?> getModelClass() {
        return LFSettings.class;
    }

    public String getModelClassName() {
        return LFSettings.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("key", getKey());
        attributes.put("value", getValue());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }
    }

    /**
     * Returns the primary key of this l f settings.
     *
     * @return the primary key of this l f settings
     */
    public long getPrimaryKey() {
        return _lfSettings.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f settings.
     *
     * @param primaryKey the primary key of this l f settings
     */
    public void setPrimaryKey(long primaryKey) {
        _lfSettings.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f settings.
     *
     * @return the ID of this l f settings
     */
    public long getId() {
        return _lfSettings.getId();
    }

    /**
     * Sets the ID of this l f settings.
     *
     * @param id the ID of this l f settings
     */
    public void setId(long id) {
        _lfSettings.setId(id);
    }

    /**
     * Returns the key of this l f settings.
     *
     * @return the key of this l f settings
     */
    public java.lang.String getKey() {
        return _lfSettings.getKey();
    }

    /**
     * Sets the key of this l f settings.
     *
     * @param key the key of this l f settings
     */
    public void setKey(java.lang.String key) {
        _lfSettings.setKey(key);
    }

    /**
     * Returns the value of this l f settings.
     *
     * @return the value of this l f settings
     */
    public java.lang.String getValue() {
        return _lfSettings.getValue();
    }

    /**
     * Sets the value of this l f settings.
     *
     * @param value the value of this l f settings
     */
    public void setValue(java.lang.String value) {
        _lfSettings.setValue(value);
    }

    public boolean isNew() {
        return _lfSettings.isNew();
    }

    public void setNew(boolean n) {
        _lfSettings.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfSettings.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfSettings.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfSettings.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSettings.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSettings.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSettings.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSettings.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSettingsWrapper((LFSettings) _lfSettings.clone());
    }

    public int compareTo(LFSettings lfSettings) {
        return _lfSettings.compareTo(lfSettings);
    }

    @Override
    public int hashCode() {
        return _lfSettings.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFSettings> toCacheModel() {
        return _lfSettings.toCacheModel();
    }

    public LFSettings toEscapedModel() {
        return new LFSettingsWrapper(_lfSettings.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSettings.toString();
    }

    public java.lang.String toXmlString() {
        return _lfSettings.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSettings.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFSettings getWrappedLFSettings() {
        return _lfSettings;
    }

    public LFSettings getWrappedModel() {
        return _lfSettings;
    }

    public void resetOriginalValues() {
        _lfSettings.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFSetting}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFSetting
* @generated
*/
public class LFSettingWrapper implements LFSetting, ModelWrapper<LFSetting> {
    private LFSetting _lfSetting;

    public LFSettingWrapper(LFSetting lfSetting) {
        _lfSetting = lfSetting;
    }

    public Class<?> getModelClass() {
        return LFSetting.class;
    }

    public String getModelClassName() {
        return LFSetting.class.getName();
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
     * Returns the primary key of this l f setting.
     *
     * @return the primary key of this l f setting
     */
    public long getPrimaryKey() {
        return _lfSetting.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f setting.
     *
     * @param primaryKey the primary key of this l f setting
     */
    public void setPrimaryKey(long primaryKey) {
        _lfSetting.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f setting.
     *
     * @return the ID of this l f setting
     */
    public long getId() {
        return _lfSetting.getId();
    }

    /**
     * Sets the ID of this l f setting.
     *
     * @param id the ID of this l f setting
     */
    public void setId(long id) {
        _lfSetting.setId(id);
    }

    /**
     * Returns the key of this l f setting.
     *
     * @return the key of this l f setting
     */
    public java.lang.String getKey() {
        return _lfSetting.getKey();
    }

    /**
     * Sets the key of this l f setting.
     *
     * @param key the key of this l f setting
     */
    public void setKey(java.lang.String key) {
        _lfSetting.setKey(key);
    }

    /**
     * Returns the value of this l f setting.
     *
     * @return the value of this l f setting
     */
    public java.lang.String getValue() {
        return _lfSetting.getValue();
    }

    /**
     * Sets the value of this l f setting.
     *
     * @param value the value of this l f setting
     */
    public void setValue(java.lang.String value) {
        _lfSetting.setValue(value);
    }

    public boolean isNew() {
        return _lfSetting.isNew();
    }

    public void setNew(boolean n) {
        _lfSetting.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfSetting.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfSetting.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfSetting.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSetting.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSetting.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSetting.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSetting.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSettingWrapper((LFSetting) _lfSetting.clone());
    }

    public int compareTo(LFSetting lfSetting) {
        return _lfSetting.compareTo(lfSetting);
    }

    @Override
    public int hashCode() {
        return _lfSetting.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFSetting> toCacheModel() {
        return _lfSetting.toCacheModel();
    }

    public LFSetting toEscapedModel() {
        return new LFSettingWrapper(_lfSetting.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSetting.toString();
    }

    public java.lang.String toXmlString() {
        return _lfSetting.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSetting.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFSetting getWrappedLFSetting() {
        return _lfSetting;
    }

    public LFSetting getWrappedModel() {
        return _lfSetting;
    }

    public void resetOriginalValues() {
        _lfSetting.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsEndpoint}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsEndpoint
 * @generated
 */
public class LFTincanLrsEndpointWrapper implements LFTincanLrsEndpoint,
    ModelWrapper<LFTincanLrsEndpoint> {
    private LFTincanLrsEndpoint _lfTincanLrsEndpoint;

    public LFTincanLrsEndpointWrapper(LFTincanLrsEndpoint lfTincanLrsEndpoint) {
        _lfTincanLrsEndpoint = lfTincanLrsEndpoint;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsEndpoint.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsEndpoint.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("endpoint", getEndpoint());
        attributes.put("authType", getAuthType());
        attributes.put("key", getKey());
        attributes.put("secret", getSecret());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String endpoint = (String) attributes.get("endpoint");

        if (endpoint != null) {
            setEndpoint(endpoint);
        }

        String authType = (String) attributes.get("authType");

        if (authType != null) {
            setAuthType(authType);
        }

        String key = (String) attributes.get("key");

        if (key != null) {
            setKey(key);
        }

        String secret = (String) attributes.get("secret");

        if (secret != null) {
            setSecret(secret);
        }
    }

    /**
    * Returns the primary key of this l f tincan lrs endpoint.
    *
    * @return the primary key of this l f tincan lrs endpoint
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsEndpoint.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs endpoint.
    *
    * @param primaryKey the primary key of this l f tincan lrs endpoint
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsEndpoint.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs endpoint.
    *
    * @return the ID of this l f tincan lrs endpoint
    */
    @Override
    public long getId() {
        return _lfTincanLrsEndpoint.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs endpoint.
    *
    * @param id the ID of this l f tincan lrs endpoint
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsEndpoint.setId(id);
    }

    /**
    * Returns the endpoint of this l f tincan lrs endpoint.
    *
    * @return the endpoint of this l f tincan lrs endpoint
    */
    @Override
    public java.lang.String getEndpoint() {
        return _lfTincanLrsEndpoint.getEndpoint();
    }

    /**
    * Sets the endpoint of this l f tincan lrs endpoint.
    *
    * @param endpoint the endpoint of this l f tincan lrs endpoint
    */
    @Override
    public void setEndpoint(java.lang.String endpoint) {
        _lfTincanLrsEndpoint.setEndpoint(endpoint);
    }

    /**
    * Returns the auth type of this l f tincan lrs endpoint.
    *
    * @return the auth type of this l f tincan lrs endpoint
    */
    @Override
    public java.lang.String getAuthType() {
        return _lfTincanLrsEndpoint.getAuthType();
    }

    /**
    * Sets the auth type of this l f tincan lrs endpoint.
    *
    * @param authType the auth type of this l f tincan lrs endpoint
    */
    @Override
    public void setAuthType(java.lang.String authType) {
        _lfTincanLrsEndpoint.setAuthType(authType);
    }

    /**
    * Returns the key of this l f tincan lrs endpoint.
    *
    * @return the key of this l f tincan lrs endpoint
    */
    @Override
    public java.lang.String getKey() {
        return _lfTincanLrsEndpoint.getKey();
    }

    /**
    * Sets the key of this l f tincan lrs endpoint.
    *
    * @param key the key of this l f tincan lrs endpoint
    */
    @Override
    public void setKey(java.lang.String key) {
        _lfTincanLrsEndpoint.setKey(key);
    }

    /**
    * Returns the secret of this l f tincan lrs endpoint.
    *
    * @return the secret of this l f tincan lrs endpoint
    */
    @Override
    public java.lang.String getSecret() {
        return _lfTincanLrsEndpoint.getSecret();
    }

    /**
    * Sets the secret of this l f tincan lrs endpoint.
    *
    * @param secret the secret of this l f tincan lrs endpoint
    */
    @Override
    public void setSecret(java.lang.String secret) {
        _lfTincanLrsEndpoint.setSecret(secret);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsEndpoint.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsEndpoint.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsEndpoint.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsEndpoint.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsEndpoint.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsEndpoint.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsEndpoint.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsEndpoint.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsEndpoint.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsEndpoint.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsEndpoint.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsEndpointWrapper((LFTincanLrsEndpoint) _lfTincanLrsEndpoint.clone());
    }

    @Override
    public int compareTo(LFTincanLrsEndpoint lfTincanLrsEndpoint) {
        return _lfTincanLrsEndpoint.compareTo(lfTincanLrsEndpoint);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsEndpoint.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsEndpoint> toCacheModel() {
        return _lfTincanLrsEndpoint.toCacheModel();
    }

    @Override
    public LFTincanLrsEndpoint toEscapedModel() {
        return new LFTincanLrsEndpointWrapper(_lfTincanLrsEndpoint.toEscapedModel());
    }

    @Override
    public LFTincanLrsEndpoint toUnescapedModel() {
        return new LFTincanLrsEndpointWrapper(_lfTincanLrsEndpoint.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsEndpoint.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsEndpoint.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsEndpoint.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsEndpointWrapper)) {
            return false;
        }

        LFTincanLrsEndpointWrapper lfTincanLrsEndpointWrapper = (LFTincanLrsEndpointWrapper) obj;

        if (Validator.equals(_lfTincanLrsEndpoint,
                    lfTincanLrsEndpointWrapper._lfTincanLrsEndpoint)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsEndpoint getWrappedLFTincanLrsEndpoint() {
        return _lfTincanLrsEndpoint;
    }

    @Override
    public LFTincanLrsEndpoint getWrappedModel() {
        return _lfTincanLrsEndpoint;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsEndpoint.resetOriginalValues();
    }
}

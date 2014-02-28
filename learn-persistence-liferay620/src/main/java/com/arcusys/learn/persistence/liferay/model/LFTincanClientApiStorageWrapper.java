package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanClientApiStorage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanClientApiStorage
 * @generated
 */
public class LFTincanClientApiStorageWrapper implements LFTincanClientApiStorage,
    ModelWrapper<LFTincanClientApiStorage> {
    private LFTincanClientApiStorage _lfTincanClientApiStorage;

    public LFTincanClientApiStorageWrapper(
        LFTincanClientApiStorage lfTincanClientApiStorage) {
        _lfTincanClientApiStorage = lfTincanClientApiStorage;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanClientApiStorage.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanClientApiStorage.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("secret", getSecret());
        attributes.put("url", getUrl());
        attributes.put("redirectUrl", getRedirectUrl());
        attributes.put("scope", getScope());
        attributes.put("iconUrl", getIconUrl());
        attributes.put("token", getToken());
        attributes.put("code", getCode());
        attributes.put("issuedAt", getIssuedAt());
        attributes.put("expiredIn", getExpiredIn());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String secret = (String) attributes.get("secret");

        if (secret != null) {
            setSecret(secret);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String redirectUrl = (String) attributes.get("redirectUrl");

        if (redirectUrl != null) {
            setRedirectUrl(redirectUrl);
        }

        String scope = (String) attributes.get("scope");

        if (scope != null) {
            setScope(scope);
        }

        String iconUrl = (String) attributes.get("iconUrl");

        if (iconUrl != null) {
            setIconUrl(iconUrl);
        }

        String token = (String) attributes.get("token");

        if (token != null) {
            setToken(token);
        }

        String code = (String) attributes.get("code");

        if (code != null) {
            setCode(code);
        }

        Date issuedAt = (Date) attributes.get("issuedAt");

        if (issuedAt != null) {
            setIssuedAt(issuedAt);
        }

        Long expiredIn = (Long) attributes.get("expiredIn");

        if (expiredIn != null) {
            setExpiredIn(expiredIn);
        }
    }

    /**
    * Returns the primary key of this l f tincan client api storage.
    *
    * @return the primary key of this l f tincan client api storage
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanClientApiStorage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan client api storage.
    *
    * @param primaryKey the primary key of this l f tincan client api storage
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanClientApiStorage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan client api storage.
    *
    * @return the ID of this l f tincan client api storage
    */
    @Override
    public long getId() {
        return _lfTincanClientApiStorage.getId();
    }

    /**
    * Sets the ID of this l f tincan client api storage.
    *
    * @param id the ID of this l f tincan client api storage
    */
    @Override
    public void setId(long id) {
        _lfTincanClientApiStorage.setId(id);
    }

    /**
    * Returns the name of this l f tincan client api storage.
    *
    * @return the name of this l f tincan client api storage
    */
    @Override
    public java.lang.String getName() {
        return _lfTincanClientApiStorage.getName();
    }

    /**
    * Sets the name of this l f tincan client api storage.
    *
    * @param name the name of this l f tincan client api storage
    */
    @Override
    public void setName(java.lang.String name) {
        _lfTincanClientApiStorage.setName(name);
    }

    /**
    * Returns the description of this l f tincan client api storage.
    *
    * @return the description of this l f tincan client api storage
    */
    @Override
    public java.lang.String getDescription() {
        return _lfTincanClientApiStorage.getDescription();
    }

    /**
    * Sets the description of this l f tincan client api storage.
    *
    * @param description the description of this l f tincan client api storage
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfTincanClientApiStorage.setDescription(description);
    }

    /**
    * Returns the secret of this l f tincan client api storage.
    *
    * @return the secret of this l f tincan client api storage
    */
    @Override
    public java.lang.String getSecret() {
        return _lfTincanClientApiStorage.getSecret();
    }

    /**
    * Sets the secret of this l f tincan client api storage.
    *
    * @param secret the secret of this l f tincan client api storage
    */
    @Override
    public void setSecret(java.lang.String secret) {
        _lfTincanClientApiStorage.setSecret(secret);
    }

    /**
    * Returns the url of this l f tincan client api storage.
    *
    * @return the url of this l f tincan client api storage
    */
    @Override
    public java.lang.String getUrl() {
        return _lfTincanClientApiStorage.getUrl();
    }

    /**
    * Sets the url of this l f tincan client api storage.
    *
    * @param url the url of this l f tincan client api storage
    */
    @Override
    public void setUrl(java.lang.String url) {
        _lfTincanClientApiStorage.setUrl(url);
    }

    /**
    * Returns the redirect url of this l f tincan client api storage.
    *
    * @return the redirect url of this l f tincan client api storage
    */
    @Override
    public java.lang.String getRedirectUrl() {
        return _lfTincanClientApiStorage.getRedirectUrl();
    }

    /**
    * Sets the redirect url of this l f tincan client api storage.
    *
    * @param redirectUrl the redirect url of this l f tincan client api storage
    */
    @Override
    public void setRedirectUrl(java.lang.String redirectUrl) {
        _lfTincanClientApiStorage.setRedirectUrl(redirectUrl);
    }

    /**
    * Returns the scope of this l f tincan client api storage.
    *
    * @return the scope of this l f tincan client api storage
    */
    @Override
    public java.lang.String getScope() {
        return _lfTincanClientApiStorage.getScope();
    }

    /**
    * Sets the scope of this l f tincan client api storage.
    *
    * @param scope the scope of this l f tincan client api storage
    */
    @Override
    public void setScope(java.lang.String scope) {
        _lfTincanClientApiStorage.setScope(scope);
    }

    /**
    * Returns the icon url of this l f tincan client api storage.
    *
    * @return the icon url of this l f tincan client api storage
    */
    @Override
    public java.lang.String getIconUrl() {
        return _lfTincanClientApiStorage.getIconUrl();
    }

    /**
    * Sets the icon url of this l f tincan client api storage.
    *
    * @param iconUrl the icon url of this l f tincan client api storage
    */
    @Override
    public void setIconUrl(java.lang.String iconUrl) {
        _lfTincanClientApiStorage.setIconUrl(iconUrl);
    }

    /**
    * Returns the token of this l f tincan client api storage.
    *
    * @return the token of this l f tincan client api storage
    */
    @Override
    public java.lang.String getToken() {
        return _lfTincanClientApiStorage.getToken();
    }

    /**
    * Sets the token of this l f tincan client api storage.
    *
    * @param token the token of this l f tincan client api storage
    */
    @Override
    public void setToken(java.lang.String token) {
        _lfTincanClientApiStorage.setToken(token);
    }

    /**
    * Returns the code of this l f tincan client api storage.
    *
    * @return the code of this l f tincan client api storage
    */
    @Override
    public java.lang.String getCode() {
        return _lfTincanClientApiStorage.getCode();
    }

    /**
    * Sets the code of this l f tincan client api storage.
    *
    * @param code the code of this l f tincan client api storage
    */
    @Override
    public void setCode(java.lang.String code) {
        _lfTincanClientApiStorage.setCode(code);
    }

    /**
    * Returns the issued at of this l f tincan client api storage.
    *
    * @return the issued at of this l f tincan client api storage
    */
    @Override
    public java.util.Date getIssuedAt() {
        return _lfTincanClientApiStorage.getIssuedAt();
    }

    /**
    * Sets the issued at of this l f tincan client api storage.
    *
    * @param issuedAt the issued at of this l f tincan client api storage
    */
    @Override
    public void setIssuedAt(java.util.Date issuedAt) {
        _lfTincanClientApiStorage.setIssuedAt(issuedAt);
    }

    /**
    * Returns the expired in of this l f tincan client api storage.
    *
    * @return the expired in of this l f tincan client api storage
    */
    @Override
    public java.lang.Long getExpiredIn() {
        return _lfTincanClientApiStorage.getExpiredIn();
    }

    /**
    * Sets the expired in of this l f tincan client api storage.
    *
    * @param expiredIn the expired in of this l f tincan client api storage
    */
    @Override
    public void setExpiredIn(java.lang.Long expiredIn) {
        _lfTincanClientApiStorage.setExpiredIn(expiredIn);
    }

    @Override
    public boolean isNew() {
        return _lfTincanClientApiStorage.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanClientApiStorage.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanClientApiStorage.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanClientApiStorage.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanClientApiStorage.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanClientApiStorage.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanClientApiStorage.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanClientApiStorage.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanClientApiStorage.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanClientApiStorage.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanClientApiStorage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanClientApiStorageWrapper((LFTincanClientApiStorage) _lfTincanClientApiStorage.clone());
    }

    @Override
    public int compareTo(LFTincanClientApiStorage lfTincanClientApiStorage) {
        return _lfTincanClientApiStorage.compareTo(lfTincanClientApiStorage);
    }

    @Override
    public int hashCode() {
        return _lfTincanClientApiStorage.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanClientApiStorage> toCacheModel() {
        return _lfTincanClientApiStorage.toCacheModel();
    }

    @Override
    public LFTincanClientApiStorage toEscapedModel() {
        return new LFTincanClientApiStorageWrapper(_lfTincanClientApiStorage.toEscapedModel());
    }

    @Override
    public LFTincanClientApiStorage toUnescapedModel() {
        return new LFTincanClientApiStorageWrapper(_lfTincanClientApiStorage.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanClientApiStorage.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanClientApiStorage.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanClientApiStorage.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanClientApiStorageWrapper)) {
            return false;
        }

        LFTincanClientApiStorageWrapper lfTincanClientApiStorageWrapper = (LFTincanClientApiStorageWrapper) obj;

        if (Validator.equals(_lfTincanClientApiStorage,
                    lfTincanClientApiStorageWrapper._lfTincanClientApiStorage)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanClientApiStorage getWrappedLFTincanClientApiStorage() {
        return _lfTincanClientApiStorage;
    }

    @Override
    public LFTincanClientApiStorage getWrappedModel() {
        return _lfTincanClientApiStorage;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanClientApiStorage.resetOriginalValues();
    }
}

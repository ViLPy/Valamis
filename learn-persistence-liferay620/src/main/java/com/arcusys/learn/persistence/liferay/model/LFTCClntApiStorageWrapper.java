package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTCClntApiStorage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTCClntApiStorage
 * @generated
 */
public class LFTCClntApiStorageWrapper implements LFTCClntApiStorage,
    ModelWrapper<LFTCClntApiStorage> {
    private LFTCClntApiStorage _lftcClntApiStorage;

    public LFTCClntApiStorageWrapper(LFTCClntApiStorage lftcClntApiStorage) {
        _lftcClntApiStorage = lftcClntApiStorage;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTCClntApiStorage.class;
    }

    @Override
    public String getModelClassName() {
        return LFTCClntApiStorage.class.getName();
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
    * Returns the primary key of this l f t c clnt api storage.
    *
    * @return the primary key of this l f t c clnt api storage
    */
    @Override
    public long getPrimaryKey() {
        return _lftcClntApiStorage.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f t c clnt api storage.
    *
    * @param primaryKey the primary key of this l f t c clnt api storage
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lftcClntApiStorage.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f t c clnt api storage.
    *
    * @return the ID of this l f t c clnt api storage
    */
    @Override
    public long getId() {
        return _lftcClntApiStorage.getId();
    }

    /**
    * Sets the ID of this l f t c clnt api storage.
    *
    * @param id the ID of this l f t c clnt api storage
    */
    @Override
    public void setId(long id) {
        _lftcClntApiStorage.setId(id);
    }

    /**
    * Returns the name of this l f t c clnt api storage.
    *
    * @return the name of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getName() {
        return _lftcClntApiStorage.getName();
    }

    /**
    * Sets the name of this l f t c clnt api storage.
    *
    * @param name the name of this l f t c clnt api storage
    */
    @Override
    public void setName(java.lang.String name) {
        _lftcClntApiStorage.setName(name);
    }

    /**
    * Returns the description of this l f t c clnt api storage.
    *
    * @return the description of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getDescription() {
        return _lftcClntApiStorage.getDescription();
    }

    /**
    * Sets the description of this l f t c clnt api storage.
    *
    * @param description the description of this l f t c clnt api storage
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lftcClntApiStorage.setDescription(description);
    }

    /**
    * Returns the secret of this l f t c clnt api storage.
    *
    * @return the secret of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getSecret() {
        return _lftcClntApiStorage.getSecret();
    }

    /**
    * Sets the secret of this l f t c clnt api storage.
    *
    * @param secret the secret of this l f t c clnt api storage
    */
    @Override
    public void setSecret(java.lang.String secret) {
        _lftcClntApiStorage.setSecret(secret);
    }

    /**
    * Returns the url of this l f t c clnt api storage.
    *
    * @return the url of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getUrl() {
        return _lftcClntApiStorage.getUrl();
    }

    /**
    * Sets the url of this l f t c clnt api storage.
    *
    * @param url the url of this l f t c clnt api storage
    */
    @Override
    public void setUrl(java.lang.String url) {
        _lftcClntApiStorage.setUrl(url);
    }

    /**
    * Returns the redirect url of this l f t c clnt api storage.
    *
    * @return the redirect url of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getRedirectUrl() {
        return _lftcClntApiStorage.getRedirectUrl();
    }

    /**
    * Sets the redirect url of this l f t c clnt api storage.
    *
    * @param redirectUrl the redirect url of this l f t c clnt api storage
    */
    @Override
    public void setRedirectUrl(java.lang.String redirectUrl) {
        _lftcClntApiStorage.setRedirectUrl(redirectUrl);
    }

    /**
    * Returns the scope of this l f t c clnt api storage.
    *
    * @return the scope of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getScope() {
        return _lftcClntApiStorage.getScope();
    }

    /**
    * Sets the scope of this l f t c clnt api storage.
    *
    * @param scope the scope of this l f t c clnt api storage
    */
    @Override
    public void setScope(java.lang.String scope) {
        _lftcClntApiStorage.setScope(scope);
    }

    /**
    * Returns the icon url of this l f t c clnt api storage.
    *
    * @return the icon url of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getIconUrl() {
        return _lftcClntApiStorage.getIconUrl();
    }

    /**
    * Sets the icon url of this l f t c clnt api storage.
    *
    * @param iconUrl the icon url of this l f t c clnt api storage
    */
    @Override
    public void setIconUrl(java.lang.String iconUrl) {
        _lftcClntApiStorage.setIconUrl(iconUrl);
    }

    /**
    * Returns the token of this l f t c clnt api storage.
    *
    * @return the token of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getToken() {
        return _lftcClntApiStorage.getToken();
    }

    /**
    * Sets the token of this l f t c clnt api storage.
    *
    * @param token the token of this l f t c clnt api storage
    */
    @Override
    public void setToken(java.lang.String token) {
        _lftcClntApiStorage.setToken(token);
    }

    /**
    * Returns the code of this l f t c clnt api storage.
    *
    * @return the code of this l f t c clnt api storage
    */
    @Override
    public java.lang.String getCode() {
        return _lftcClntApiStorage.getCode();
    }

    /**
    * Sets the code of this l f t c clnt api storage.
    *
    * @param code the code of this l f t c clnt api storage
    */
    @Override
    public void setCode(java.lang.String code) {
        _lftcClntApiStorage.setCode(code);
    }

    /**
    * Returns the issued at of this l f t c clnt api storage.
    *
    * @return the issued at of this l f t c clnt api storage
    */
    @Override
    public java.util.Date getIssuedAt() {
        return _lftcClntApiStorage.getIssuedAt();
    }

    /**
    * Sets the issued at of this l f t c clnt api storage.
    *
    * @param issuedAt the issued at of this l f t c clnt api storage
    */
    @Override
    public void setIssuedAt(java.util.Date issuedAt) {
        _lftcClntApiStorage.setIssuedAt(issuedAt);
    }

    /**
    * Returns the expired in of this l f t c clnt api storage.
    *
    * @return the expired in of this l f t c clnt api storage
    */
    @Override
    public java.lang.Long getExpiredIn() {
        return _lftcClntApiStorage.getExpiredIn();
    }

    /**
    * Sets the expired in of this l f t c clnt api storage.
    *
    * @param expiredIn the expired in of this l f t c clnt api storage
    */
    @Override
    public void setExpiredIn(java.lang.Long expiredIn) {
        _lftcClntApiStorage.setExpiredIn(expiredIn);
    }

    @Override
    public boolean isNew() {
        return _lftcClntApiStorage.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lftcClntApiStorage.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lftcClntApiStorage.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lftcClntApiStorage.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lftcClntApiStorage.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lftcClntApiStorage.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lftcClntApiStorage.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lftcClntApiStorage.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lftcClntApiStorage.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lftcClntApiStorage.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lftcClntApiStorage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTCClntApiStorageWrapper((LFTCClntApiStorage) _lftcClntApiStorage.clone());
    }

    @Override
    public int compareTo(LFTCClntApiStorage lftcClntApiStorage) {
        return _lftcClntApiStorage.compareTo(lftcClntApiStorage);
    }

    @Override
    public int hashCode() {
        return _lftcClntApiStorage.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTCClntApiStorage> toCacheModel() {
        return _lftcClntApiStorage.toCacheModel();
    }

    @Override
    public LFTCClntApiStorage toEscapedModel() {
        return new LFTCClntApiStorageWrapper(_lftcClntApiStorage.toEscapedModel());
    }

    @Override
    public LFTCClntApiStorage toUnescapedModel() {
        return new LFTCClntApiStorageWrapper(_lftcClntApiStorage.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lftcClntApiStorage.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lftcClntApiStorage.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lftcClntApiStorage.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTCClntApiStorageWrapper)) {
            return false;
        }

        LFTCClntApiStorageWrapper lftcClntApiStorageWrapper = (LFTCClntApiStorageWrapper) obj;

        if (Validator.equals(_lftcClntApiStorage,
                    lftcClntApiStorageWrapper._lftcClntApiStorage)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTCClntApiStorage getWrappedLFTCClntApiStorage() {
        return _lftcClntApiStorage;
    }

    @Override
    public LFTCClntApiStorage getWrappedModel() {
        return _lftcClntApiStorage;
    }

    @Override
    public void resetOriginalValues() {
        _lftcClntApiStorage.resetOriginalValues();
    }
}

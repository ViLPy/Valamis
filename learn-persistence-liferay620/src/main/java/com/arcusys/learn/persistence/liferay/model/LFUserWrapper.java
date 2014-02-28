package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFUser
 * @generated
 */
public class LFUserWrapper implements LFUser, ModelWrapper<LFUser> {
    private LFUser _lfUser;

    public LFUserWrapper(LFUser lfUser) {
        _lfUser = lfUser;
    }

    @Override
    public Class<?> getModelClass() {
        return LFUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFUser.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("lfid", getLfid());
        attributes.put("id", getId());
        attributes.put("name", getName());
        attributes.put("preferredAudioLevel", getPreferredAudioLevel());
        attributes.put("preferredLanguage", getPreferredLanguage());
        attributes.put("preferredDeliverySpeed", getPreferredDeliverySpeed());
        attributes.put("preferredAudioCaptioning", getPreferredAudioCaptioning());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long lfid = (Long) attributes.get("lfid");

        if (lfid != null) {
            setLfid(lfid);
        }

        Integer id = (Integer) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Double preferredAudioLevel = (Double) attributes.get(
                "preferredAudioLevel");

        if (preferredAudioLevel != null) {
            setPreferredAudioLevel(preferredAudioLevel);
        }

        String preferredLanguage = (String) attributes.get("preferredLanguage");

        if (preferredLanguage != null) {
            setPreferredLanguage(preferredLanguage);
        }

        Double preferredDeliverySpeed = (Double) attributes.get(
                "preferredDeliverySpeed");

        if (preferredDeliverySpeed != null) {
            setPreferredDeliverySpeed(preferredDeliverySpeed);
        }

        Integer preferredAudioCaptioning = (Integer) attributes.get(
                "preferredAudioCaptioning");

        if (preferredAudioCaptioning != null) {
            setPreferredAudioCaptioning(preferredAudioCaptioning);
        }
    }

    /**
    * Returns the primary key of this l f user.
    *
    * @return the primary key of this l f user
    */
    @Override
    public long getPrimaryKey() {
        return _lfUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f user.
    *
    * @param primaryKey the primary key of this l f user
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the lfid of this l f user.
    *
    * @return the lfid of this l f user
    */
    @Override
    public long getLfid() {
        return _lfUser.getLfid();
    }

    /**
    * Sets the lfid of this l f user.
    *
    * @param lfid the lfid of this l f user
    */
    @Override
    public void setLfid(long lfid) {
        _lfUser.setLfid(lfid);
    }

    /**
    * Returns the ID of this l f user.
    *
    * @return the ID of this l f user
    */
    @Override
    public java.lang.Integer getId() {
        return _lfUser.getId();
    }

    /**
    * Sets the ID of this l f user.
    *
    * @param id the ID of this l f user
    */
    @Override
    public void setId(java.lang.Integer id) {
        _lfUser.setId(id);
    }

    /**
    * Returns the name of this l f user.
    *
    * @return the name of this l f user
    */
    @Override
    public java.lang.String getName() {
        return _lfUser.getName();
    }

    /**
    * Sets the name of this l f user.
    *
    * @param name the name of this l f user
    */
    @Override
    public void setName(java.lang.String name) {
        _lfUser.setName(name);
    }

    /**
    * Returns the preferred audio level of this l f user.
    *
    * @return the preferred audio level of this l f user
    */
    @Override
    public java.lang.Double getPreferredAudioLevel() {
        return _lfUser.getPreferredAudioLevel();
    }

    /**
    * Sets the preferred audio level of this l f user.
    *
    * @param preferredAudioLevel the preferred audio level of this l f user
    */
    @Override
    public void setPreferredAudioLevel(java.lang.Double preferredAudioLevel) {
        _lfUser.setPreferredAudioLevel(preferredAudioLevel);
    }

    /**
    * Returns the preferred language of this l f user.
    *
    * @return the preferred language of this l f user
    */
    @Override
    public java.lang.String getPreferredLanguage() {
        return _lfUser.getPreferredLanguage();
    }

    /**
    * Sets the preferred language of this l f user.
    *
    * @param preferredLanguage the preferred language of this l f user
    */
    @Override
    public void setPreferredLanguage(java.lang.String preferredLanguage) {
        _lfUser.setPreferredLanguage(preferredLanguage);
    }

    /**
    * Returns the preferred delivery speed of this l f user.
    *
    * @return the preferred delivery speed of this l f user
    */
    @Override
    public java.lang.Double getPreferredDeliverySpeed() {
        return _lfUser.getPreferredDeliverySpeed();
    }

    /**
    * Sets the preferred delivery speed of this l f user.
    *
    * @param preferredDeliverySpeed the preferred delivery speed of this l f user
    */
    @Override
    public void setPreferredDeliverySpeed(
        java.lang.Double preferredDeliverySpeed) {
        _lfUser.setPreferredDeliverySpeed(preferredDeliverySpeed);
    }

    /**
    * Returns the preferred audio captioning of this l f user.
    *
    * @return the preferred audio captioning of this l f user
    */
    @Override
    public java.lang.Integer getPreferredAudioCaptioning() {
        return _lfUser.getPreferredAudioCaptioning();
    }

    /**
    * Sets the preferred audio captioning of this l f user.
    *
    * @param preferredAudioCaptioning the preferred audio captioning of this l f user
    */
    @Override
    public void setPreferredAudioCaptioning(
        java.lang.Integer preferredAudioCaptioning) {
        _lfUser.setPreferredAudioCaptioning(preferredAudioCaptioning);
    }

    @Override
    public boolean isNew() {
        return _lfUser.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfUser.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfUser.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfUser.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfUser.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfUser.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfUser.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfUser.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfUser.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfUser.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFUserWrapper((LFUser) _lfUser.clone());
    }

    @Override
    public int compareTo(LFUser lfUser) {
        return _lfUser.compareTo(lfUser);
    }

    @Override
    public int hashCode() {
        return _lfUser.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFUser> toCacheModel() {
        return _lfUser.toCacheModel();
    }

    @Override
    public LFUser toEscapedModel() {
        return new LFUserWrapper(_lfUser.toEscapedModel());
    }

    @Override
    public LFUser toUnescapedModel() {
        return new LFUserWrapper(_lfUser.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfUser.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfUser.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfUser.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFUserWrapper)) {
            return false;
        }

        LFUserWrapper lfUserWrapper = (LFUserWrapper) obj;

        if (Validator.equals(_lfUser, lfUserWrapper._lfUser)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFUser getWrappedLFUser() {
        return _lfUser;
    }

    @Override
    public LFUser getWrappedModel() {
        return _lfUser;
    }

    @Override
    public void resetOriginalValues() {
        _lfUser.resetOriginalValues();
    }
}

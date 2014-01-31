package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFAchievementUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementUser
 * @generated
 */
public class LFAchievementUserWrapper implements LFAchievementUser,
    ModelWrapper<LFAchievementUser> {
    private LFAchievementUser _lfAchievementUser;

    public LFAchievementUserWrapper(LFAchievementUser lfAchievementUser) {
        _lfAchievementUser = lfAchievementUser;
    }

    @Override
    public Class<?> getModelClass() {
        return LFAchievementUser.class;
    }

    @Override
    public String getModelClassName() {
        return LFAchievementUser.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("userId", getUserId());
        attributes.put("achievementId", getAchievementId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer userId = (Integer) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Integer achievementId = (Integer) attributes.get("achievementId");

        if (achievementId != null) {
            setAchievementId(achievementId);
        }
    }

    /**
    * Returns the primary key of this l f achievement user.
    *
    * @return the primary key of this l f achievement user
    */
    @Override
    public long getPrimaryKey() {
        return _lfAchievementUser.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f achievement user.
    *
    * @param primaryKey the primary key of this l f achievement user
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfAchievementUser.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f achievement user.
    *
    * @return the ID of this l f achievement user
    */
    @Override
    public long getId() {
        return _lfAchievementUser.getId();
    }

    /**
    * Sets the ID of this l f achievement user.
    *
    * @param id the ID of this l f achievement user
    */
    @Override
    public void setId(long id) {
        _lfAchievementUser.setId(id);
    }

    /**
    * Returns the user ID of this l f achievement user.
    *
    * @return the user ID of this l f achievement user
    */
    @Override
    public java.lang.Integer getUserId() {
        return _lfAchievementUser.getUserId();
    }

    /**
    * Sets the user ID of this l f achievement user.
    *
    * @param userId the user ID of this l f achievement user
    */
    @Override
    public void setUserId(java.lang.Integer userId) {
        _lfAchievementUser.setUserId(userId);
    }

    /**
    * Returns the achievement ID of this l f achievement user.
    *
    * @return the achievement ID of this l f achievement user
    */
    @Override
    public java.lang.Integer getAchievementId() {
        return _lfAchievementUser.getAchievementId();
    }

    /**
    * Sets the achievement ID of this l f achievement user.
    *
    * @param achievementId the achievement ID of this l f achievement user
    */
    @Override
    public void setAchievementId(java.lang.Integer achievementId) {
        _lfAchievementUser.setAchievementId(achievementId);
    }

    @Override
    public boolean isNew() {
        return _lfAchievementUser.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfAchievementUser.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfAchievementUser.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfAchievementUser.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfAchievementUser.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfAchievementUser.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfAchievementUser.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfAchievementUser.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfAchievementUser.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfAchievementUser.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfAchievementUser.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFAchievementUserWrapper((LFAchievementUser) _lfAchievementUser.clone());
    }

    @Override
    public int compareTo(LFAchievementUser lfAchievementUser) {
        return _lfAchievementUser.compareTo(lfAchievementUser);
    }

    @Override
    public int hashCode() {
        return _lfAchievementUser.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFAchievementUser> toCacheModel() {
        return _lfAchievementUser.toCacheModel();
    }

    @Override
    public LFAchievementUser toEscapedModel() {
        return new LFAchievementUserWrapper(_lfAchievementUser.toEscapedModel());
    }

    @Override
    public LFAchievementUser toUnescapedModel() {
        return new LFAchievementUserWrapper(_lfAchievementUser.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfAchievementUser.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfAchievementUser.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAchievementUser.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFAchievementUserWrapper)) {
            return false;
        }

        LFAchievementUserWrapper lfAchievementUserWrapper = (LFAchievementUserWrapper) obj;

        if (Validator.equals(_lfAchievementUser,
                    lfAchievementUserWrapper._lfAchievementUser)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFAchievementUser getWrappedLFAchievementUser() {
        return _lfAchievementUser;
    }

    @Override
    public LFAchievementUser getWrappedModel() {
        return _lfAchievementUser;
    }

    @Override
    public void resetOriginalValues() {
        _lfAchievementUser.resetOriginalValues();
    }
}

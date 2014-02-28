package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFAchievementActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievementActivity
 * @generated
 */
public class LFAchievementActivityWrapper implements LFAchievementActivity,
    ModelWrapper<LFAchievementActivity> {
    private LFAchievementActivity _lfAchievementActivity;

    public LFAchievementActivityWrapper(
        LFAchievementActivity lfAchievementActivity) {
        _lfAchievementActivity = lfAchievementActivity;
    }

    @Override
    public Class<?> getModelClass() {
        return LFAchievementActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFAchievementActivity.class.getName();
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
    * Returns the primary key of this l f achievement activity.
    *
    * @return the primary key of this l f achievement activity
    */
    @Override
    public long getPrimaryKey() {
        return _lfAchievementActivity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f achievement activity.
    *
    * @param primaryKey the primary key of this l f achievement activity
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfAchievementActivity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f achievement activity.
    *
    * @return the ID of this l f achievement activity
    */
    @Override
    public long getId() {
        return _lfAchievementActivity.getId();
    }

    /**
    * Sets the ID of this l f achievement activity.
    *
    * @param id the ID of this l f achievement activity
    */
    @Override
    public void setId(long id) {
        _lfAchievementActivity.setId(id);
    }

    /**
    * Returns the user ID of this l f achievement activity.
    *
    * @return the user ID of this l f achievement activity
    */
    @Override
    public java.lang.Integer getUserId() {
        return _lfAchievementActivity.getUserId();
    }

    /**
    * Sets the user ID of this l f achievement activity.
    *
    * @param userId the user ID of this l f achievement activity
    */
    @Override
    public void setUserId(java.lang.Integer userId) {
        _lfAchievementActivity.setUserId(userId);
    }

    /**
    * Returns the achievement ID of this l f achievement activity.
    *
    * @return the achievement ID of this l f achievement activity
    */
    @Override
    public java.lang.Integer getAchievementId() {
        return _lfAchievementActivity.getAchievementId();
    }

    /**
    * Sets the achievement ID of this l f achievement activity.
    *
    * @param achievementId the achievement ID of this l f achievement activity
    */
    @Override
    public void setAchievementId(java.lang.Integer achievementId) {
        _lfAchievementActivity.setAchievementId(achievementId);
    }

    @Override
    public boolean isNew() {
        return _lfAchievementActivity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfAchievementActivity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfAchievementActivity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfAchievementActivity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfAchievementActivity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfAchievementActivity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfAchievementActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfAchievementActivity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfAchievementActivity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfAchievementActivity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfAchievementActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFAchievementActivityWrapper((LFAchievementActivity) _lfAchievementActivity.clone());
    }

    @Override
    public int compareTo(LFAchievementActivity lfAchievementActivity) {
        return _lfAchievementActivity.compareTo(lfAchievementActivity);
    }

    @Override
    public int hashCode() {
        return _lfAchievementActivity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFAchievementActivity> toCacheModel() {
        return _lfAchievementActivity.toCacheModel();
    }

    @Override
    public LFAchievementActivity toEscapedModel() {
        return new LFAchievementActivityWrapper(_lfAchievementActivity.toEscapedModel());
    }

    @Override
    public LFAchievementActivity toUnescapedModel() {
        return new LFAchievementActivityWrapper(_lfAchievementActivity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfAchievementActivity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfAchievementActivity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAchievementActivity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFAchievementActivityWrapper)) {
            return false;
        }

        LFAchievementActivityWrapper lfAchievementActivityWrapper = (LFAchievementActivityWrapper) obj;

        if (Validator.equals(_lfAchievementActivity,
                    lfAchievementActivityWrapper._lfAchievementActivity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFAchievementActivity getWrappedLFAchievementActivity() {
        return _lfAchievementActivity;
    }

    @Override
    public LFAchievementActivity getWrappedModel() {
        return _lfAchievementActivity;
    }

    @Override
    public void resetOriginalValues() {
        _lfAchievementActivity.resetOriginalValues();
    }
}

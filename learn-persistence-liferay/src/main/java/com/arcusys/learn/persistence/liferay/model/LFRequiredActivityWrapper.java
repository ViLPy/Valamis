package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFRequiredActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFRequiredActivity
 * @generated
 */
public class LFRequiredActivityWrapper implements LFRequiredActivity,
    ModelWrapper<LFRequiredActivity> {
    private LFRequiredActivity _lfRequiredActivity;

    public LFRequiredActivityWrapper(LFRequiredActivity lfRequiredActivity) {
        _lfRequiredActivity = lfRequiredActivity;
    }

    @Override
    public Class<?> getModelClass() {
        return LFRequiredActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFRequiredActivity.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("achievementId", getAchievementId());
        attributes.put("activityClassName", getActivityClassName());
        attributes.put("numberActivitiesRequired", getNumberActivitiesRequired());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer achievementId = (Integer) attributes.get("achievementId");

        if (achievementId != null) {
            setAchievementId(achievementId);
        }

        String activityClassName = (String) attributes.get("activityClassName");

        if (activityClassName != null) {
            setActivityClassName(activityClassName);
        }

        Integer numberActivitiesRequired = (Integer) attributes.get(
                "numberActivitiesRequired");

        if (numberActivitiesRequired != null) {
            setNumberActivitiesRequired(numberActivitiesRequired);
        }
    }

    /**
    * Returns the primary key of this l f required activity.
    *
    * @return the primary key of this l f required activity
    */
    @Override
    public long getPrimaryKey() {
        return _lfRequiredActivity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f required activity.
    *
    * @param primaryKey the primary key of this l f required activity
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfRequiredActivity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f required activity.
    *
    * @return the ID of this l f required activity
    */
    @Override
    public long getId() {
        return _lfRequiredActivity.getId();
    }

    /**
    * Sets the ID of this l f required activity.
    *
    * @param id the ID of this l f required activity
    */
    @Override
    public void setId(long id) {
        _lfRequiredActivity.setId(id);
    }

    /**
    * Returns the achievement ID of this l f required activity.
    *
    * @return the achievement ID of this l f required activity
    */
    @Override
    public java.lang.Integer getAchievementId() {
        return _lfRequiredActivity.getAchievementId();
    }

    /**
    * Sets the achievement ID of this l f required activity.
    *
    * @param achievementId the achievement ID of this l f required activity
    */
    @Override
    public void setAchievementId(java.lang.Integer achievementId) {
        _lfRequiredActivity.setAchievementId(achievementId);
    }

    /**
    * Returns the activity class name of this l f required activity.
    *
    * @return the activity class name of this l f required activity
    */
    @Override
    public java.lang.String getActivityClassName() {
        return _lfRequiredActivity.getActivityClassName();
    }

    /**
    * Sets the activity class name of this l f required activity.
    *
    * @param activityClassName the activity class name of this l f required activity
    */
    @Override
    public void setActivityClassName(java.lang.String activityClassName) {
        _lfRequiredActivity.setActivityClassName(activityClassName);
    }

    /**
    * Returns the number activities required of this l f required activity.
    *
    * @return the number activities required of this l f required activity
    */
    @Override
    public java.lang.Integer getNumberActivitiesRequired() {
        return _lfRequiredActivity.getNumberActivitiesRequired();
    }

    /**
    * Sets the number activities required of this l f required activity.
    *
    * @param numberActivitiesRequired the number activities required of this l f required activity
    */
    @Override
    public void setNumberActivitiesRequired(
        java.lang.Integer numberActivitiesRequired) {
        _lfRequiredActivity.setNumberActivitiesRequired(numberActivitiesRequired);
    }

    @Override
    public boolean isNew() {
        return _lfRequiredActivity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfRequiredActivity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfRequiredActivity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfRequiredActivity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfRequiredActivity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfRequiredActivity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfRequiredActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfRequiredActivity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfRequiredActivity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfRequiredActivity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfRequiredActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFRequiredActivityWrapper((LFRequiredActivity) _lfRequiredActivity.clone());
    }

    @Override
    public int compareTo(LFRequiredActivity lfRequiredActivity) {
        return _lfRequiredActivity.compareTo(lfRequiredActivity);
    }

    @Override
    public int hashCode() {
        return _lfRequiredActivity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFRequiredActivity> toCacheModel() {
        return _lfRequiredActivity.toCacheModel();
    }

    @Override
    public LFRequiredActivity toEscapedModel() {
        return new LFRequiredActivityWrapper(_lfRequiredActivity.toEscapedModel());
    }

    @Override
    public LFRequiredActivity toUnescapedModel() {
        return new LFRequiredActivityWrapper(_lfRequiredActivity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfRequiredActivity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfRequiredActivity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfRequiredActivity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFRequiredActivityWrapper)) {
            return false;
        }

        LFRequiredActivityWrapper lfRequiredActivityWrapper = (LFRequiredActivityWrapper) obj;

        if (Validator.equals(_lfRequiredActivity,
                    lfRequiredActivityWrapper._lfRequiredActivity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFRequiredActivity getWrappedLFRequiredActivity() {
        return _lfRequiredActivity;
    }

    @Override
    public LFRequiredActivity getWrappedModel() {
        return _lfRequiredActivity;
    }

    @Override
    public void resetOriginalValues() {
        _lfRequiredActivity.resetOriginalValues();
    }
}

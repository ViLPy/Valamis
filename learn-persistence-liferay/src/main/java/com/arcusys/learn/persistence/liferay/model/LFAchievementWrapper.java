package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFAchievement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFAchievement
 * @generated
 */
public class LFAchievementWrapper implements LFAchievement,
    ModelWrapper<LFAchievement> {
    private LFAchievement _lfAchievement;

    public LFAchievementWrapper(LFAchievement lfAchievement) {
        _lfAchievement = lfAchievement;
    }

    @Override
    public Class<?> getModelClass() {
        return LFAchievement.class;
    }

    @Override
    public String getModelClassName() {
        return LFAchievement.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
        attributes.put("creationDate", getCreationDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String logo = (String) attributes.get("logo");

        if (logo != null) {
            setLogo(logo);
        }

        Date creationDate = (Date) attributes.get("creationDate");

        if (creationDate != null) {
            setCreationDate(creationDate);
        }
    }

    /**
    * Returns the primary key of this l f achievement.
    *
    * @return the primary key of this l f achievement
    */
    @Override
    public long getPrimaryKey() {
        return _lfAchievement.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f achievement.
    *
    * @param primaryKey the primary key of this l f achievement
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfAchievement.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f achievement.
    *
    * @return the ID of this l f achievement
    */
    @Override
    public long getId() {
        return _lfAchievement.getId();
    }

    /**
    * Sets the ID of this l f achievement.
    *
    * @param id the ID of this l f achievement
    */
    @Override
    public void setId(long id) {
        _lfAchievement.setId(id);
    }

    /**
    * Returns the title of this l f achievement.
    *
    * @return the title of this l f achievement
    */
    @Override
    public java.lang.String getTitle() {
        return _lfAchievement.getTitle();
    }

    /**
    * Sets the title of this l f achievement.
    *
    * @param title the title of this l f achievement
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfAchievement.setTitle(title);
    }

    /**
    * Returns the description of this l f achievement.
    *
    * @return the description of this l f achievement
    */
    @Override
    public java.lang.String getDescription() {
        return _lfAchievement.getDescription();
    }

    /**
    * Sets the description of this l f achievement.
    *
    * @param description the description of this l f achievement
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfAchievement.setDescription(description);
    }

    /**
    * Returns the logo of this l f achievement.
    *
    * @return the logo of this l f achievement
    */
    @Override
    public java.lang.String getLogo() {
        return _lfAchievement.getLogo();
    }

    /**
    * Sets the logo of this l f achievement.
    *
    * @param logo the logo of this l f achievement
    */
    @Override
    public void setLogo(java.lang.String logo) {
        _lfAchievement.setLogo(logo);
    }

    /**
    * Returns the creation date of this l f achievement.
    *
    * @return the creation date of this l f achievement
    */
    @Override
    public java.util.Date getCreationDate() {
        return _lfAchievement.getCreationDate();
    }

    /**
    * Sets the creation date of this l f achievement.
    *
    * @param creationDate the creation date of this l f achievement
    */
    @Override
    public void setCreationDate(java.util.Date creationDate) {
        _lfAchievement.setCreationDate(creationDate);
    }

    @Override
    public boolean isNew() {
        return _lfAchievement.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfAchievement.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfAchievement.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfAchievement.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfAchievement.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfAchievement.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfAchievement.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfAchievement.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfAchievement.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfAchievement.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfAchievement.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFAchievementWrapper((LFAchievement) _lfAchievement.clone());
    }

    @Override
    public int compareTo(LFAchievement lfAchievement) {
        return _lfAchievement.compareTo(lfAchievement);
    }

    @Override
    public int hashCode() {
        return _lfAchievement.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFAchievement> toCacheModel() {
        return _lfAchievement.toCacheModel();
    }

    @Override
    public LFAchievement toEscapedModel() {
        return new LFAchievementWrapper(_lfAchievement.toEscapedModel());
    }

    @Override
    public LFAchievement toUnescapedModel() {
        return new LFAchievementWrapper(_lfAchievement.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfAchievement.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfAchievement.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfAchievement.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFAchievementWrapper)) {
            return false;
        }

        LFAchievementWrapper lfAchievementWrapper = (LFAchievementWrapper) obj;

        if (Validator.equals(_lfAchievement, lfAchievementWrapper._lfAchievement)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFAchievement getWrappedLFAchievement() {
        return _lfAchievement;
    }

    @Override
    public LFAchievement getWrappedModel() {
        return _lfAchievement;
    }

    @Override
    public void resetOriginalValues() {
        _lfAchievement.resetOriginalValues();
    }
}

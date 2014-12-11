package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFLRSToActivitySetting}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFLRSToActivitySetting
 * @generated
 */
public class LFLRSToActivitySettingWrapper implements LFLRSToActivitySetting,
    ModelWrapper<LFLRSToActivitySetting> {
    private LFLRSToActivitySetting _lflrsToActivitySetting;

    public LFLRSToActivitySettingWrapper(
        LFLRSToActivitySetting lflrsToActivitySetting) {
        _lflrsToActivitySetting = lflrsToActivitySetting;
    }

    @Override
    public Class<?> getModelClass() {
        return LFLRSToActivitySetting.class;
    }

    @Override
    public String getModelClassName() {
        return LFLRSToActivitySetting.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("courseID", getCourseID());
        attributes.put("title", getTitle());
        attributes.put("activityFilter", getActivityFilter());
        attributes.put("verbFilter", getVerbFilter());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer courseID = (Integer) attributes.get("courseID");

        if (courseID != null) {
            setCourseID(courseID);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String activityFilter = (String) attributes.get("activityFilter");

        if (activityFilter != null) {
            setActivityFilter(activityFilter);
        }

        String verbFilter = (String) attributes.get("verbFilter");

        if (verbFilter != null) {
            setVerbFilter(verbFilter);
        }
    }

    /**
    * Returns the primary key of this l f l r s to activity setting.
    *
    * @return the primary key of this l f l r s to activity setting
    */
    @Override
    public long getPrimaryKey() {
        return _lflrsToActivitySetting.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f l r s to activity setting.
    *
    * @param primaryKey the primary key of this l f l r s to activity setting
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lflrsToActivitySetting.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f l r s to activity setting.
    *
    * @return the ID of this l f l r s to activity setting
    */
    @Override
    public long getId() {
        return _lflrsToActivitySetting.getId();
    }

    /**
    * Sets the ID of this l f l r s to activity setting.
    *
    * @param id the ID of this l f l r s to activity setting
    */
    @Override
    public void setId(long id) {
        _lflrsToActivitySetting.setId(id);
    }

    /**
    * Returns the course i d of this l f l r s to activity setting.
    *
    * @return the course i d of this l f l r s to activity setting
    */
    @Override
    public java.lang.Integer getCourseID() {
        return _lflrsToActivitySetting.getCourseID();
    }

    /**
    * Sets the course i d of this l f l r s to activity setting.
    *
    * @param courseID the course i d of this l f l r s to activity setting
    */
    @Override
    public void setCourseID(java.lang.Integer courseID) {
        _lflrsToActivitySetting.setCourseID(courseID);
    }

    /**
    * Returns the title of this l f l r s to activity setting.
    *
    * @return the title of this l f l r s to activity setting
    */
    @Override
    public java.lang.String getTitle() {
        return _lflrsToActivitySetting.getTitle();
    }

    /**
    * Sets the title of this l f l r s to activity setting.
    *
    * @param title the title of this l f l r s to activity setting
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lflrsToActivitySetting.setTitle(title);
    }

    /**
    * Returns the activity filter of this l f l r s to activity setting.
    *
    * @return the activity filter of this l f l r s to activity setting
    */
    @Override
    public java.lang.String getActivityFilter() {
        return _lflrsToActivitySetting.getActivityFilter();
    }

    /**
    * Sets the activity filter of this l f l r s to activity setting.
    *
    * @param activityFilter the activity filter of this l f l r s to activity setting
    */
    @Override
    public void setActivityFilter(java.lang.String activityFilter) {
        _lflrsToActivitySetting.setActivityFilter(activityFilter);
    }

    /**
    * Returns the verb filter of this l f l r s to activity setting.
    *
    * @return the verb filter of this l f l r s to activity setting
    */
    @Override
    public java.lang.String getVerbFilter() {
        return _lflrsToActivitySetting.getVerbFilter();
    }

    /**
    * Sets the verb filter of this l f l r s to activity setting.
    *
    * @param verbFilter the verb filter of this l f l r s to activity setting
    */
    @Override
    public void setVerbFilter(java.lang.String verbFilter) {
        _lflrsToActivitySetting.setVerbFilter(verbFilter);
    }

    @Override
    public boolean isNew() {
        return _lflrsToActivitySetting.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lflrsToActivitySetting.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lflrsToActivitySetting.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lflrsToActivitySetting.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lflrsToActivitySetting.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lflrsToActivitySetting.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lflrsToActivitySetting.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lflrsToActivitySetting.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lflrsToActivitySetting.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lflrsToActivitySetting.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lflrsToActivitySetting.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFLRSToActivitySettingWrapper((LFLRSToActivitySetting) _lflrsToActivitySetting.clone());
    }

    @Override
    public int compareTo(LFLRSToActivitySetting lflrsToActivitySetting) {
        return _lflrsToActivitySetting.compareTo(lflrsToActivitySetting);
    }

    @Override
    public int hashCode() {
        return _lflrsToActivitySetting.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFLRSToActivitySetting> toCacheModel() {
        return _lflrsToActivitySetting.toCacheModel();
    }

    @Override
    public LFLRSToActivitySetting toEscapedModel() {
        return new LFLRSToActivitySettingWrapper(_lflrsToActivitySetting.toEscapedModel());
    }

    @Override
    public LFLRSToActivitySetting toUnescapedModel() {
        return new LFLRSToActivitySettingWrapper(_lflrsToActivitySetting.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lflrsToActivitySetting.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lflrsToActivitySetting.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lflrsToActivitySetting.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFLRSToActivitySettingWrapper)) {
            return false;
        }

        LFLRSToActivitySettingWrapper lflrsToActivitySettingWrapper = (LFLRSToActivitySettingWrapper) obj;

        if (Validator.equals(_lflrsToActivitySetting,
                    lflrsToActivitySettingWrapper._lflrsToActivitySetting)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFLRSToActivitySetting getWrappedLFLRSToActivitySetting() {
        return _lflrsToActivitySetting;
    }

    @Override
    public LFLRSToActivitySetting getWrappedModel() {
        return _lflrsToActivitySetting;
    }

    @Override
    public void resetOriginalValues() {
        _lflrsToActivitySetting.resetOriginalValues();
    }
}

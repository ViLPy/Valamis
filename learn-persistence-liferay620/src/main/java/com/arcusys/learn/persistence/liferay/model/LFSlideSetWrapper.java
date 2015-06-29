package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSlideSet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideSet
 * @generated
 */
public class LFSlideSetWrapper implements LFSlideSet, ModelWrapper<LFSlideSet> {
    private LFSlideSet _lfSlideSet;

    public LFSlideSetWrapper(LFSlideSet lfSlideSet) {
        _lfSlideSet = lfSlideSet;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSlideSet.class;
    }

    @Override
    public String getModelClassName() {
        return LFSlideSet.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("logo", getLogo());
        attributes.put("courseId", getCourseId());

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

        Long courseId = (Long) attributes.get("courseId");

        if (courseId != null) {
            setCourseId(courseId);
        }
    }

    /**
    * Returns the primary key of this l f slide set.
    *
    * @return the primary key of this l f slide set
    */
    @Override
    public long getPrimaryKey() {
        return _lfSlideSet.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f slide set.
    *
    * @param primaryKey the primary key of this l f slide set
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSlideSet.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f slide set.
    *
    * @return the ID of this l f slide set
    */
    @Override
    public long getId() {
        return _lfSlideSet.getId();
    }

    /**
    * Sets the ID of this l f slide set.
    *
    * @param id the ID of this l f slide set
    */
    @Override
    public void setId(long id) {
        _lfSlideSet.setId(id);
    }

    /**
    * Returns the title of this l f slide set.
    *
    * @return the title of this l f slide set
    */
    @Override
    public java.lang.String getTitle() {
        return _lfSlideSet.getTitle();
    }

    /**
    * Sets the title of this l f slide set.
    *
    * @param title the title of this l f slide set
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfSlideSet.setTitle(title);
    }

    /**
    * Returns the description of this l f slide set.
    *
    * @return the description of this l f slide set
    */
    @Override
    public java.lang.String getDescription() {
        return _lfSlideSet.getDescription();
    }

    /**
    * Sets the description of this l f slide set.
    *
    * @param description the description of this l f slide set
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfSlideSet.setDescription(description);
    }

    /**
    * Returns the logo of this l f slide set.
    *
    * @return the logo of this l f slide set
    */
    @Override
    public java.lang.String getLogo() {
        return _lfSlideSet.getLogo();
    }

    /**
    * Sets the logo of this l f slide set.
    *
    * @param logo the logo of this l f slide set
    */
    @Override
    public void setLogo(java.lang.String logo) {
        _lfSlideSet.setLogo(logo);
    }

    /**
    * Returns the course ID of this l f slide set.
    *
    * @return the course ID of this l f slide set
    */
    @Override
    public java.lang.Long getCourseId() {
        return _lfSlideSet.getCourseId();
    }

    /**
    * Sets the course ID of this l f slide set.
    *
    * @param courseId the course ID of this l f slide set
    */
    @Override
    public void setCourseId(java.lang.Long courseId) {
        _lfSlideSet.setCourseId(courseId);
    }

    @Override
    public boolean isNew() {
        return _lfSlideSet.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSlideSet.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSlideSet.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSlideSet.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSlideSet.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSlideSet.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSlideSet.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSlideSet.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSlideSet.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSlideSet.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSlideSet.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSlideSetWrapper((LFSlideSet) _lfSlideSet.clone());
    }

    @Override
    public int compareTo(LFSlideSet lfSlideSet) {
        return _lfSlideSet.compareTo(lfSlideSet);
    }

    @Override
    public int hashCode() {
        return _lfSlideSet.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSlideSet> toCacheModel() {
        return _lfSlideSet.toCacheModel();
    }

    @Override
    public LFSlideSet toEscapedModel() {
        return new LFSlideSetWrapper(_lfSlideSet.toEscapedModel());
    }

    @Override
    public LFSlideSet toUnescapedModel() {
        return new LFSlideSetWrapper(_lfSlideSet.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSlideSet.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSlideSet.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSlideSet.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSlideSetWrapper)) {
            return false;
        }

        LFSlideSetWrapper lfSlideSetWrapper = (LFSlideSetWrapper) obj;

        if (Validator.equals(_lfSlideSet, lfSlideSetWrapper._lfSlideSet)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSlideSet getWrappedLFSlideSet() {
        return _lfSlideSet;
    }

    @Override
    public LFSlideSet getWrappedModel() {
        return _lfSlideSet;
    }

    @Override
    public void resetOriginalValues() {
        _lfSlideSet.resetOriginalValues();
    }
}

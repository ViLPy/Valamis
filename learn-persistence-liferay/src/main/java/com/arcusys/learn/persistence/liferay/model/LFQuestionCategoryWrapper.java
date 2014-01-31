package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuestionCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionCategory
 * @generated
 */
public class LFQuestionCategoryWrapper implements LFQuestionCategory,
    ModelWrapper<LFQuestionCategory> {
    private LFQuestionCategory _lfQuestionCategory;

    public LFQuestionCategoryWrapper(LFQuestionCategory lfQuestionCategory) {
        _lfQuestionCategory = lfQuestionCategory;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuestionCategory.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuestionCategory.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("parentId", getParentId());
        attributes.put("courseId", getCourseId());
        attributes.put("arrangementIndex", getArrangementIndex());

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

        Integer parentId = (Integer) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        Integer courseId = (Integer) attributes.get("courseId");

        if (courseId != null) {
            setCourseId(courseId);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    /**
    * Returns the primary key of this l f question category.
    *
    * @return the primary key of this l f question category
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuestionCategory.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f question category.
    *
    * @param primaryKey the primary key of this l f question category
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuestionCategory.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f question category.
    *
    * @return the ID of this l f question category
    */
    @Override
    public long getId() {
        return _lfQuestionCategory.getId();
    }

    /**
    * Sets the ID of this l f question category.
    *
    * @param id the ID of this l f question category
    */
    @Override
    public void setId(long id) {
        _lfQuestionCategory.setId(id);
    }

    /**
    * Returns the title of this l f question category.
    *
    * @return the title of this l f question category
    */
    @Override
    public java.lang.String getTitle() {
        return _lfQuestionCategory.getTitle();
    }

    /**
    * Sets the title of this l f question category.
    *
    * @param title the title of this l f question category
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfQuestionCategory.setTitle(title);
    }

    /**
    * Returns the description of this l f question category.
    *
    * @return the description of this l f question category
    */
    @Override
    public java.lang.String getDescription() {
        return _lfQuestionCategory.getDescription();
    }

    /**
    * Sets the description of this l f question category.
    *
    * @param description the description of this l f question category
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfQuestionCategory.setDescription(description);
    }

    /**
    * Returns the parent ID of this l f question category.
    *
    * @return the parent ID of this l f question category
    */
    @Override
    public java.lang.Integer getParentId() {
        return _lfQuestionCategory.getParentId();
    }

    /**
    * Sets the parent ID of this l f question category.
    *
    * @param parentId the parent ID of this l f question category
    */
    @Override
    public void setParentId(java.lang.Integer parentId) {
        _lfQuestionCategory.setParentId(parentId);
    }

    /**
    * Returns the course ID of this l f question category.
    *
    * @return the course ID of this l f question category
    */
    @Override
    public java.lang.Integer getCourseId() {
        return _lfQuestionCategory.getCourseId();
    }

    /**
    * Sets the course ID of this l f question category.
    *
    * @param courseId the course ID of this l f question category
    */
    @Override
    public void setCourseId(java.lang.Integer courseId) {
        _lfQuestionCategory.setCourseId(courseId);
    }

    /**
    * Returns the arrangement index of this l f question category.
    *
    * @return the arrangement index of this l f question category
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfQuestionCategory.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f question category.
    *
    * @param arrangementIndex the arrangement index of this l f question category
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfQuestionCategory.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfQuestionCategory.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuestionCategory.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuestionCategory.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuestionCategory.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuestionCategory.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuestionCategory.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuestionCategory.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuestionCategory.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuestionCategory.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuestionCategory.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuestionCategory.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuestionCategoryWrapper((LFQuestionCategory) _lfQuestionCategory.clone());
    }

    @Override
    public int compareTo(LFQuestionCategory lfQuestionCategory) {
        return _lfQuestionCategory.compareTo(lfQuestionCategory);
    }

    @Override
    public int hashCode() {
        return _lfQuestionCategory.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuestionCategory> toCacheModel() {
        return _lfQuestionCategory.toCacheModel();
    }

    @Override
    public LFQuestionCategory toEscapedModel() {
        return new LFQuestionCategoryWrapper(_lfQuestionCategory.toEscapedModel());
    }

    @Override
    public LFQuestionCategory toUnescapedModel() {
        return new LFQuestionCategoryWrapper(_lfQuestionCategory.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuestionCategory.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuestionCategory.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuestionCategory.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuestionCategoryWrapper)) {
            return false;
        }

        LFQuestionCategoryWrapper lfQuestionCategoryWrapper = (LFQuestionCategoryWrapper) obj;

        if (Validator.equals(_lfQuestionCategory,
                    lfQuestionCategoryWrapper._lfQuestionCategory)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuestionCategory getWrappedLFQuestionCategory() {
        return _lfQuestionCategory;
    }

    @Override
    public LFQuestionCategory getWrappedModel() {
        return _lfQuestionCategory;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuestionCategory.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuizQuestionCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionCategory
 * @generated
 */
public class LFQuizQuestionCategoryWrapper implements LFQuizQuestionCategory,
    ModelWrapper<LFQuizQuestionCategory> {
    private LFQuizQuestionCategory _lfQuizQuestionCategory;

    public LFQuizQuestionCategoryWrapper(
        LFQuizQuestionCategory lfQuizQuestionCategory) {
        _lfQuizQuestionCategory = lfQuizQuestionCategory;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizQuestionCategory.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizQuestionCategory.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("quizId", getQuizId());
        attributes.put("parentId", getParentId());
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

        Integer quizId = (Integer) attributes.get("quizId");

        if (quizId != null) {
            setQuizId(quizId);
        }

        Integer parentId = (Integer) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    /**
    * Returns the primary key of this l f quiz question category.
    *
    * @return the primary key of this l f quiz question category
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuizQuestionCategory.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f quiz question category.
    *
    * @param primaryKey the primary key of this l f quiz question category
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuizQuestionCategory.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f quiz question category.
    *
    * @return the ID of this l f quiz question category
    */
    @Override
    public long getId() {
        return _lfQuizQuestionCategory.getId();
    }

    /**
    * Sets the ID of this l f quiz question category.
    *
    * @param id the ID of this l f quiz question category
    */
    @Override
    public void setId(long id) {
        _lfQuizQuestionCategory.setId(id);
    }

    /**
    * Returns the title of this l f quiz question category.
    *
    * @return the title of this l f quiz question category
    */
    @Override
    public java.lang.String getTitle() {
        return _lfQuizQuestionCategory.getTitle();
    }

    /**
    * Sets the title of this l f quiz question category.
    *
    * @param title the title of this l f quiz question category
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfQuizQuestionCategory.setTitle(title);
    }

    /**
    * Returns the description of this l f quiz question category.
    *
    * @return the description of this l f quiz question category
    */
    @Override
    public java.lang.String getDescription() {
        return _lfQuizQuestionCategory.getDescription();
    }

    /**
    * Sets the description of this l f quiz question category.
    *
    * @param description the description of this l f quiz question category
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfQuizQuestionCategory.setDescription(description);
    }

    /**
    * Returns the quiz ID of this l f quiz question category.
    *
    * @return the quiz ID of this l f quiz question category
    */
    @Override
    public java.lang.Integer getQuizId() {
        return _lfQuizQuestionCategory.getQuizId();
    }

    /**
    * Sets the quiz ID of this l f quiz question category.
    *
    * @param quizId the quiz ID of this l f quiz question category
    */
    @Override
    public void setQuizId(java.lang.Integer quizId) {
        _lfQuizQuestionCategory.setQuizId(quizId);
    }

    /**
    * Returns the parent ID of this l f quiz question category.
    *
    * @return the parent ID of this l f quiz question category
    */
    @Override
    public java.lang.Integer getParentId() {
        return _lfQuizQuestionCategory.getParentId();
    }

    /**
    * Sets the parent ID of this l f quiz question category.
    *
    * @param parentId the parent ID of this l f quiz question category
    */
    @Override
    public void setParentId(java.lang.Integer parentId) {
        _lfQuizQuestionCategory.setParentId(parentId);
    }

    /**
    * Returns the arrangement index of this l f quiz question category.
    *
    * @return the arrangement index of this l f quiz question category
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfQuizQuestionCategory.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f quiz question category.
    *
    * @param arrangementIndex the arrangement index of this l f quiz question category
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfQuizQuestionCategory.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfQuizQuestionCategory.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuizQuestionCategory.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuizQuestionCategory.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuizQuestionCategory.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuizQuestionCategory.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuizQuestionCategory.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuizQuestionCategory.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuizQuestionCategory.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuizQuestionCategory.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuizQuestionCategory.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuizQuestionCategory.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuizQuestionCategoryWrapper((LFQuizQuestionCategory) _lfQuizQuestionCategory.clone());
    }

    @Override
    public int compareTo(LFQuizQuestionCategory lfQuizQuestionCategory) {
        return _lfQuizQuestionCategory.compareTo(lfQuizQuestionCategory);
    }

    @Override
    public int hashCode() {
        return _lfQuizQuestionCategory.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuizQuestionCategory> toCacheModel() {
        return _lfQuizQuestionCategory.toCacheModel();
    }

    @Override
    public LFQuizQuestionCategory toEscapedModel() {
        return new LFQuizQuestionCategoryWrapper(_lfQuizQuestionCategory.toEscapedModel());
    }

    @Override
    public LFQuizQuestionCategory toUnescapedModel() {
        return new LFQuizQuestionCategoryWrapper(_lfQuizQuestionCategory.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuizQuestionCategory.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuizQuestionCategory.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizQuestionCategory.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizQuestionCategoryWrapper)) {
            return false;
        }

        LFQuizQuestionCategoryWrapper lfQuizQuestionCategoryWrapper = (LFQuizQuestionCategoryWrapper) obj;

        if (Validator.equals(_lfQuizQuestionCategory,
                    lfQuizQuestionCategoryWrapper._lfQuizQuestionCategory)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuizQuestionCategory getWrappedLFQuizQuestionCategory() {
        return _lfQuizQuestionCategory;
    }

    @Override
    public LFQuizQuestionCategory getWrappedModel() {
        return _lfQuizQuestionCategory;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuizQuestionCategory.resetOriginalValues();
    }
}

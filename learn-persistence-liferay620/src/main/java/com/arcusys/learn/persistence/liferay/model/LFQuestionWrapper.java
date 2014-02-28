package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuestion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestion
 * @generated
 */
public class LFQuestionWrapper implements LFQuestion, ModelWrapper<LFQuestion> {
    private LFQuestion _lfQuestion;

    public LFQuestionWrapper(LFQuestion lfQuestion) {
        _lfQuestion = lfQuestion;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuestion.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuestion.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("explanationText", getExplanationText());
        attributes.put("forceCorrectCount", getForceCorrectCount());
        attributes.put("caseSensitive", getCaseSensitive());
        attributes.put("questionType", getQuestionType());
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

        Integer categoryId = (Integer) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String explanationText = (String) attributes.get("explanationText");

        if (explanationText != null) {
            setExplanationText(explanationText);
        }

        Boolean forceCorrectCount = (Boolean) attributes.get(
                "forceCorrectCount");

        if (forceCorrectCount != null) {
            setForceCorrectCount(forceCorrectCount);
        }

        Boolean caseSensitive = (Boolean) attributes.get("caseSensitive");

        if (caseSensitive != null) {
            setCaseSensitive(caseSensitive);
        }

        Integer questionType = (Integer) attributes.get("questionType");

        if (questionType != null) {
            setQuestionType(questionType);
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
    * Returns the primary key of this l f question.
    *
    * @return the primary key of this l f question
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuestion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f question.
    *
    * @param primaryKey the primary key of this l f question
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuestion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f question.
    *
    * @return the ID of this l f question
    */
    @Override
    public long getId() {
        return _lfQuestion.getId();
    }

    /**
    * Sets the ID of this l f question.
    *
    * @param id the ID of this l f question
    */
    @Override
    public void setId(long id) {
        _lfQuestion.setId(id);
    }

    /**
    * Returns the category ID of this l f question.
    *
    * @return the category ID of this l f question
    */
    @Override
    public java.lang.Integer getCategoryId() {
        return _lfQuestion.getCategoryId();
    }

    /**
    * Sets the category ID of this l f question.
    *
    * @param categoryId the category ID of this l f question
    */
    @Override
    public void setCategoryId(java.lang.Integer categoryId) {
        _lfQuestion.setCategoryId(categoryId);
    }

    /**
    * Returns the title of this l f question.
    *
    * @return the title of this l f question
    */
    @Override
    public java.lang.String getTitle() {
        return _lfQuestion.getTitle();
    }

    /**
    * Sets the title of this l f question.
    *
    * @param title the title of this l f question
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfQuestion.setTitle(title);
    }

    /**
    * Returns the description of this l f question.
    *
    * @return the description of this l f question
    */
    @Override
    public java.lang.String getDescription() {
        return _lfQuestion.getDescription();
    }

    /**
    * Sets the description of this l f question.
    *
    * @param description the description of this l f question
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfQuestion.setDescription(description);
    }

    /**
    * Returns the explanation text of this l f question.
    *
    * @return the explanation text of this l f question
    */
    @Override
    public java.lang.String getExplanationText() {
        return _lfQuestion.getExplanationText();
    }

    /**
    * Sets the explanation text of this l f question.
    *
    * @param explanationText the explanation text of this l f question
    */
    @Override
    public void setExplanationText(java.lang.String explanationText) {
        _lfQuestion.setExplanationText(explanationText);
    }

    /**
    * Returns the force correct count of this l f question.
    *
    * @return the force correct count of this l f question
    */
    @Override
    public boolean getForceCorrectCount() {
        return _lfQuestion.getForceCorrectCount();
    }

    /**
    * Returns <code>true</code> if this l f question is force correct count.
    *
    * @return <code>true</code> if this l f question is force correct count; <code>false</code> otherwise
    */
    @Override
    public boolean isForceCorrectCount() {
        return _lfQuestion.isForceCorrectCount();
    }

    /**
    * Sets whether this l f question is force correct count.
    *
    * @param forceCorrectCount the force correct count of this l f question
    */
    @Override
    public void setForceCorrectCount(boolean forceCorrectCount) {
        _lfQuestion.setForceCorrectCount(forceCorrectCount);
    }

    /**
    * Returns the case sensitive of this l f question.
    *
    * @return the case sensitive of this l f question
    */
    @Override
    public boolean getCaseSensitive() {
        return _lfQuestion.getCaseSensitive();
    }

    /**
    * Returns <code>true</code> if this l f question is case sensitive.
    *
    * @return <code>true</code> if this l f question is case sensitive; <code>false</code> otherwise
    */
    @Override
    public boolean isCaseSensitive() {
        return _lfQuestion.isCaseSensitive();
    }

    /**
    * Sets whether this l f question is case sensitive.
    *
    * @param caseSensitive the case sensitive of this l f question
    */
    @Override
    public void setCaseSensitive(boolean caseSensitive) {
        _lfQuestion.setCaseSensitive(caseSensitive);
    }

    /**
    * Returns the question type of this l f question.
    *
    * @return the question type of this l f question
    */
    @Override
    public java.lang.Integer getQuestionType() {
        return _lfQuestion.getQuestionType();
    }

    /**
    * Sets the question type of this l f question.
    *
    * @param questionType the question type of this l f question
    */
    @Override
    public void setQuestionType(java.lang.Integer questionType) {
        _lfQuestion.setQuestionType(questionType);
    }

    /**
    * Returns the course ID of this l f question.
    *
    * @return the course ID of this l f question
    */
    @Override
    public java.lang.Integer getCourseId() {
        return _lfQuestion.getCourseId();
    }

    /**
    * Sets the course ID of this l f question.
    *
    * @param courseId the course ID of this l f question
    */
    @Override
    public void setCourseId(java.lang.Integer courseId) {
        _lfQuestion.setCourseId(courseId);
    }

    /**
    * Returns the arrangement index of this l f question.
    *
    * @return the arrangement index of this l f question
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfQuestion.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f question.
    *
    * @param arrangementIndex the arrangement index of this l f question
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfQuestion.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfQuestion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuestion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuestion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuestion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuestion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuestion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuestion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuestion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuestion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuestion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuestion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuestionWrapper((LFQuestion) _lfQuestion.clone());
    }

    @Override
    public int compareTo(LFQuestion lfQuestion) {
        return _lfQuestion.compareTo(lfQuestion);
    }

    @Override
    public int hashCode() {
        return _lfQuestion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuestion> toCacheModel() {
        return _lfQuestion.toCacheModel();
    }

    @Override
    public LFQuestion toEscapedModel() {
        return new LFQuestionWrapper(_lfQuestion.toEscapedModel());
    }

    @Override
    public LFQuestion toUnescapedModel() {
        return new LFQuestionWrapper(_lfQuestion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuestion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuestion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuestion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuestionWrapper)) {
            return false;
        }

        LFQuestionWrapper lfQuestionWrapper = (LFQuestionWrapper) obj;

        if (Validator.equals(_lfQuestion, lfQuestionWrapper._lfQuestion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuestion getWrappedLFQuestion() {
        return _lfQuestion;
    }

    @Override
    public LFQuestion getWrappedModel() {
        return _lfQuestion;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuestion.resetOriginalValues();
    }
}

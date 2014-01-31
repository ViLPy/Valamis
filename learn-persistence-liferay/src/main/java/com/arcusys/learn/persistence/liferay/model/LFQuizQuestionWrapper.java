package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuizQuestion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestion
 * @generated
 */
public class LFQuizQuestionWrapper implements LFQuizQuestion,
    ModelWrapper<LFQuizQuestion> {
    private LFQuizQuestion _lfQuizQuestion;

    public LFQuizQuestionWrapper(LFQuizQuestion lfQuizQuestion) {
        _lfQuizQuestion = lfQuizQuestion;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizQuestion.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizQuestion.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("quizId", getQuizId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("questionId", getQuestionId());
        attributes.put("questionType", getQuestionType());
        attributes.put("title", getTitle());
        attributes.put("url", getUrl());
        attributes.put("plainText", getPlainText());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer quizId = (Integer) attributes.get("quizId");

        if (quizId != null) {
            setQuizId(quizId);
        }

        Integer categoryId = (Integer) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        Integer questionId = (Integer) attributes.get("questionId");

        if (questionId != null) {
            setQuestionId(questionId);
        }

        String questionType = (String) attributes.get("questionType");

        if (questionType != null) {
            setQuestionType(questionType);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String plainText = (String) attributes.get("plainText");

        if (plainText != null) {
            setPlainText(plainText);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    /**
    * Returns the primary key of this l f quiz question.
    *
    * @return the primary key of this l f quiz question
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuizQuestion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f quiz question.
    *
    * @param primaryKey the primary key of this l f quiz question
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuizQuestion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f quiz question.
    *
    * @return the ID of this l f quiz question
    */
    @Override
    public long getId() {
        return _lfQuizQuestion.getId();
    }

    /**
    * Sets the ID of this l f quiz question.
    *
    * @param id the ID of this l f quiz question
    */
    @Override
    public void setId(long id) {
        _lfQuizQuestion.setId(id);
    }

    /**
    * Returns the quiz ID of this l f quiz question.
    *
    * @return the quiz ID of this l f quiz question
    */
    @Override
    public java.lang.Integer getQuizId() {
        return _lfQuizQuestion.getQuizId();
    }

    /**
    * Sets the quiz ID of this l f quiz question.
    *
    * @param quizId the quiz ID of this l f quiz question
    */
    @Override
    public void setQuizId(java.lang.Integer quizId) {
        _lfQuizQuestion.setQuizId(quizId);
    }

    /**
    * Returns the category ID of this l f quiz question.
    *
    * @return the category ID of this l f quiz question
    */
    @Override
    public java.lang.Integer getCategoryId() {
        return _lfQuizQuestion.getCategoryId();
    }

    /**
    * Sets the category ID of this l f quiz question.
    *
    * @param categoryId the category ID of this l f quiz question
    */
    @Override
    public void setCategoryId(java.lang.Integer categoryId) {
        _lfQuizQuestion.setCategoryId(categoryId);
    }

    /**
    * Returns the question ID of this l f quiz question.
    *
    * @return the question ID of this l f quiz question
    */
    @Override
    public java.lang.Integer getQuestionId() {
        return _lfQuizQuestion.getQuestionId();
    }

    /**
    * Sets the question ID of this l f quiz question.
    *
    * @param questionId the question ID of this l f quiz question
    */
    @Override
    public void setQuestionId(java.lang.Integer questionId) {
        _lfQuizQuestion.setQuestionId(questionId);
    }

    /**
    * Returns the question type of this l f quiz question.
    *
    * @return the question type of this l f quiz question
    */
    @Override
    public java.lang.String getQuestionType() {
        return _lfQuizQuestion.getQuestionType();
    }

    /**
    * Sets the question type of this l f quiz question.
    *
    * @param questionType the question type of this l f quiz question
    */
    @Override
    public void setQuestionType(java.lang.String questionType) {
        _lfQuizQuestion.setQuestionType(questionType);
    }

    /**
    * Returns the title of this l f quiz question.
    *
    * @return the title of this l f quiz question
    */
    @Override
    public java.lang.String getTitle() {
        return _lfQuizQuestion.getTitle();
    }

    /**
    * Sets the title of this l f quiz question.
    *
    * @param title the title of this l f quiz question
    */
    @Override
    public void setTitle(java.lang.String title) {
        _lfQuizQuestion.setTitle(title);
    }

    /**
    * Returns the url of this l f quiz question.
    *
    * @return the url of this l f quiz question
    */
    @Override
    public java.lang.String getUrl() {
        return _lfQuizQuestion.getUrl();
    }

    /**
    * Sets the url of this l f quiz question.
    *
    * @param url the url of this l f quiz question
    */
    @Override
    public void setUrl(java.lang.String url) {
        _lfQuizQuestion.setUrl(url);
    }

    /**
    * Returns the plain text of this l f quiz question.
    *
    * @return the plain text of this l f quiz question
    */
    @Override
    public java.lang.String getPlainText() {
        return _lfQuizQuestion.getPlainText();
    }

    /**
    * Sets the plain text of this l f quiz question.
    *
    * @param plainText the plain text of this l f quiz question
    */
    @Override
    public void setPlainText(java.lang.String plainText) {
        _lfQuizQuestion.setPlainText(plainText);
    }

    /**
    * Returns the arrangement index of this l f quiz question.
    *
    * @return the arrangement index of this l f quiz question
    */
    @Override
    public java.lang.Integer getArrangementIndex() {
        return _lfQuizQuestion.getArrangementIndex();
    }

    /**
    * Sets the arrangement index of this l f quiz question.
    *
    * @param arrangementIndex the arrangement index of this l f quiz question
    */
    @Override
    public void setArrangementIndex(java.lang.Integer arrangementIndex) {
        _lfQuizQuestion.setArrangementIndex(arrangementIndex);
    }

    @Override
    public boolean isNew() {
        return _lfQuizQuestion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuizQuestion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuizQuestion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuizQuestion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuizQuestion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuizQuestion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuizQuestion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuizQuestion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuizQuestion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuizQuestion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuizQuestion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuizQuestionWrapper((LFQuizQuestion) _lfQuizQuestion.clone());
    }

    @Override
    public int compareTo(LFQuizQuestion lfQuizQuestion) {
        return _lfQuizQuestion.compareTo(lfQuizQuestion);
    }

    @Override
    public int hashCode() {
        return _lfQuizQuestion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuizQuestion> toCacheModel() {
        return _lfQuizQuestion.toCacheModel();
    }

    @Override
    public LFQuizQuestion toEscapedModel() {
        return new LFQuizQuestionWrapper(_lfQuizQuestion.toEscapedModel());
    }

    @Override
    public LFQuizQuestion toUnescapedModel() {
        return new LFQuizQuestionWrapper(_lfQuizQuestion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuizQuestion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuizQuestion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizQuestion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizQuestionWrapper)) {
            return false;
        }

        LFQuizQuestionWrapper lfQuizQuestionWrapper = (LFQuizQuestionWrapper) obj;

        if (Validator.equals(_lfQuizQuestion,
                    lfQuizQuestionWrapper._lfQuizQuestion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuizQuestion getWrappedLFQuizQuestion() {
        return _lfQuizQuestion;
    }

    @Override
    public LFQuizQuestion getWrappedModel() {
        return _lfQuizQuestion;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuizQuestion.resetOriginalValues();
    }
}

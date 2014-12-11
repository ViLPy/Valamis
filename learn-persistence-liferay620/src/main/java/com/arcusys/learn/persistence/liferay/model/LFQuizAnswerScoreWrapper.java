package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFQuizAnswerScore}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScore
 * @generated
 */
public class LFQuizAnswerScoreWrapper implements LFQuizAnswerScore,
    ModelWrapper<LFQuizAnswerScore> {
    private LFQuizAnswerScore _lfQuizAnswerScore;

    public LFQuizAnswerScoreWrapper(LFQuizAnswerScore lfQuizAnswerScore) {
        _lfQuizAnswerScore = lfQuizAnswerScore;
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizAnswerScore.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizAnswerScore.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("answerId", getAnswerId());
        attributes.put("score", getScore());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long answerId = (Long) attributes.get("answerId");

        if (answerId != null) {
            setAnswerId(answerId);
        }

        Double score = (Double) attributes.get("score");

        if (score != null) {
            setScore(score);
        }
    }

    /**
    * Returns the primary key of this l f quiz answer score.
    *
    * @return the primary key of this l f quiz answer score
    */
    @Override
    public long getPrimaryKey() {
        return _lfQuizAnswerScore.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f quiz answer score.
    *
    * @param primaryKey the primary key of this l f quiz answer score
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfQuizAnswerScore.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the answer ID of this l f quiz answer score.
    *
    * @return the answer ID of this l f quiz answer score
    */
    @Override
    public long getAnswerId() {
        return _lfQuizAnswerScore.getAnswerId();
    }

    /**
    * Sets the answer ID of this l f quiz answer score.
    *
    * @param answerId the answer ID of this l f quiz answer score
    */
    @Override
    public void setAnswerId(long answerId) {
        _lfQuizAnswerScore.setAnswerId(answerId);
    }

    /**
    * Returns the score of this l f quiz answer score.
    *
    * @return the score of this l f quiz answer score
    */
    @Override
    public java.lang.Double getScore() {
        return _lfQuizAnswerScore.getScore();
    }

    /**
    * Sets the score of this l f quiz answer score.
    *
    * @param score the score of this l f quiz answer score
    */
    @Override
    public void setScore(java.lang.Double score) {
        _lfQuizAnswerScore.setScore(score);
    }

    @Override
    public boolean isNew() {
        return _lfQuizAnswerScore.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfQuizAnswerScore.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfQuizAnswerScore.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfQuizAnswerScore.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfQuizAnswerScore.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfQuizAnswerScore.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfQuizAnswerScore.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfQuizAnswerScore.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfQuizAnswerScore.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfQuizAnswerScore.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfQuizAnswerScore.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFQuizAnswerScoreWrapper((LFQuizAnswerScore) _lfQuizAnswerScore.clone());
    }

    @Override
    public int compareTo(LFQuizAnswerScore lfQuizAnswerScore) {
        return _lfQuizAnswerScore.compareTo(lfQuizAnswerScore);
    }

    @Override
    public int hashCode() {
        return _lfQuizAnswerScore.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFQuizAnswerScore> toCacheModel() {
        return _lfQuizAnswerScore.toCacheModel();
    }

    @Override
    public LFQuizAnswerScore toEscapedModel() {
        return new LFQuizAnswerScoreWrapper(_lfQuizAnswerScore.toEscapedModel());
    }

    @Override
    public LFQuizAnswerScore toUnescapedModel() {
        return new LFQuizAnswerScoreWrapper(_lfQuizAnswerScore.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfQuizAnswerScore.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfQuizAnswerScore.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfQuizAnswerScore.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFQuizAnswerScoreWrapper)) {
            return false;
        }

        LFQuizAnswerScoreWrapper lfQuizAnswerScoreWrapper = (LFQuizAnswerScoreWrapper) obj;

        if (Validator.equals(_lfQuizAnswerScore,
                    lfQuizAnswerScoreWrapper._lfQuizAnswerScore)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFQuizAnswerScore getWrappedLFQuizAnswerScore() {
        return _lfQuizAnswerScore;
    }

    @Override
    public LFQuizAnswerScore getWrappedModel() {
        return _lfQuizAnswerScore;
    }

    @Override
    public void resetOriginalValues() {
        _lfQuizAnswerScore.resetOriginalValues();
    }
}

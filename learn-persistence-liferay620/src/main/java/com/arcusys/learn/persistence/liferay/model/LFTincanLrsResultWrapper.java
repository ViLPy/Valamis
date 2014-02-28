package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanLrsResult}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsResult
 * @generated
 */
public class LFTincanLrsResultWrapper implements LFTincanLrsResult,
    ModelWrapper<LFTincanLrsResult> {
    private LFTincanLrsResult _lfTincanLrsResult;

    public LFTincanLrsResultWrapper(LFTincanLrsResult lfTincanLrsResult) {
        _lfTincanLrsResult = lfTincanLrsResult;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanLrsResult.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanLrsResult.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("score", getScore());
        attributes.put("success", getSuccess());
        attributes.put("completion", getCompletion());
        attributes.put("response", getResponse());
        attributes.put("duration", getDuration());
        attributes.put("extension", getExtension());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String score = (String) attributes.get("score");

        if (score != null) {
            setScore(score);
        }

        Boolean success = (Boolean) attributes.get("success");

        if (success != null) {
            setSuccess(success);
        }

        Boolean completion = (Boolean) attributes.get("completion");

        if (completion != null) {
            setCompletion(completion);
        }

        String response = (String) attributes.get("response");

        if (response != null) {
            setResponse(response);
        }

        Double duration = (Double) attributes.get("duration");

        if (duration != null) {
            setDuration(duration);
        }

        String extension = (String) attributes.get("extension");

        if (extension != null) {
            setExtension(extension);
        }
    }

    /**
    * Returns the primary key of this l f tincan lrs result.
    *
    * @return the primary key of this l f tincan lrs result
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanLrsResult.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan lrs result.
    *
    * @param primaryKey the primary key of this l f tincan lrs result
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsResult.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan lrs result.
    *
    * @return the ID of this l f tincan lrs result
    */
    @Override
    public long getId() {
        return _lfTincanLrsResult.getId();
    }

    /**
    * Sets the ID of this l f tincan lrs result.
    *
    * @param id the ID of this l f tincan lrs result
    */
    @Override
    public void setId(long id) {
        _lfTincanLrsResult.setId(id);
    }

    /**
    * Returns the score of this l f tincan lrs result.
    *
    * @return the score of this l f tincan lrs result
    */
    @Override
    public java.lang.String getScore() {
        return _lfTincanLrsResult.getScore();
    }

    /**
    * Sets the score of this l f tincan lrs result.
    *
    * @param score the score of this l f tincan lrs result
    */
    @Override
    public void setScore(java.lang.String score) {
        _lfTincanLrsResult.setScore(score);
    }

    /**
    * Returns the success of this l f tincan lrs result.
    *
    * @return the success of this l f tincan lrs result
    */
    @Override
    public java.lang.Boolean getSuccess() {
        return _lfTincanLrsResult.getSuccess();
    }

    /**
    * Sets the success of this l f tincan lrs result.
    *
    * @param success the success of this l f tincan lrs result
    */
    @Override
    public void setSuccess(java.lang.Boolean success) {
        _lfTincanLrsResult.setSuccess(success);
    }

    /**
    * Returns the completion of this l f tincan lrs result.
    *
    * @return the completion of this l f tincan lrs result
    */
    @Override
    public java.lang.Boolean getCompletion() {
        return _lfTincanLrsResult.getCompletion();
    }

    /**
    * Sets the completion of this l f tincan lrs result.
    *
    * @param completion the completion of this l f tincan lrs result
    */
    @Override
    public void setCompletion(java.lang.Boolean completion) {
        _lfTincanLrsResult.setCompletion(completion);
    }

    /**
    * Returns the response of this l f tincan lrs result.
    *
    * @return the response of this l f tincan lrs result
    */
    @Override
    public java.lang.String getResponse() {
        return _lfTincanLrsResult.getResponse();
    }

    /**
    * Sets the response of this l f tincan lrs result.
    *
    * @param response the response of this l f tincan lrs result
    */
    @Override
    public void setResponse(java.lang.String response) {
        _lfTincanLrsResult.setResponse(response);
    }

    /**
    * Returns the duration of this l f tincan lrs result.
    *
    * @return the duration of this l f tincan lrs result
    */
    @Override
    public java.lang.Double getDuration() {
        return _lfTincanLrsResult.getDuration();
    }

    /**
    * Sets the duration of this l f tincan lrs result.
    *
    * @param duration the duration of this l f tincan lrs result
    */
    @Override
    public void setDuration(java.lang.Double duration) {
        _lfTincanLrsResult.setDuration(duration);
    }

    /**
    * Returns the extension of this l f tincan lrs result.
    *
    * @return the extension of this l f tincan lrs result
    */
    @Override
    public java.lang.String getExtension() {
        return _lfTincanLrsResult.getExtension();
    }

    /**
    * Sets the extension of this l f tincan lrs result.
    *
    * @param extension the extension of this l f tincan lrs result
    */
    @Override
    public void setExtension(java.lang.String extension) {
        _lfTincanLrsResult.setExtension(extension);
    }

    @Override
    public boolean isNew() {
        return _lfTincanLrsResult.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanLrsResult.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanLrsResult.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsResult.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanLrsResult.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsResult.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsResult.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsResult.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanLrsResult.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanLrsResult.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsResult.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsResultWrapper((LFTincanLrsResult) _lfTincanLrsResult.clone());
    }

    @Override
    public int compareTo(LFTincanLrsResult lfTincanLrsResult) {
        return _lfTincanLrsResult.compareTo(lfTincanLrsResult);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsResult.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanLrsResult> toCacheModel() {
        return _lfTincanLrsResult.toCacheModel();
    }

    @Override
    public LFTincanLrsResult toEscapedModel() {
        return new LFTincanLrsResultWrapper(_lfTincanLrsResult.toEscapedModel());
    }

    @Override
    public LFTincanLrsResult toUnescapedModel() {
        return new LFTincanLrsResultWrapper(_lfTincanLrsResult.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsResult.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanLrsResult.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsResult.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanLrsResultWrapper)) {
            return false;
        }

        LFTincanLrsResultWrapper lfTincanLrsResultWrapper = (LFTincanLrsResultWrapper) obj;

        if (Validator.equals(_lfTincanLrsResult,
                    lfTincanLrsResultWrapper._lfTincanLrsResult)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanLrsResult getWrappedLFTincanLrsResult() {
        return _lfTincanLrsResult;
    }

    @Override
    public LFTincanLrsResult getWrappedModel() {
        return _lfTincanLrsResult;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanLrsResult.resetOriginalValues();
    }
}

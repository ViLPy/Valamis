package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsResult}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsResult
* @generated
*/
public class LFTincanLrsResultWrapper implements LFTincanLrsResult,
    ModelWrapper<LFTincanLrsResult> {
    private LFTincanLrsResult _lfTincanLrsResult;

    public LFTincanLrsResultWrapper(LFTincanLrsResult lfTincanLrsResult) {
        _lfTincanLrsResult = lfTincanLrsResult;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsResult.class;
    }

    public String getModelClassName() {
        return LFTincanLrsResult.class.getName();
    }

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
    public long getPrimaryKey() {
        return _lfTincanLrsResult.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs result.
     *
     * @param primaryKey the primary key of this l f tincan lrs result
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsResult.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs result.
     *
     * @return the ID of this l f tincan lrs result
     */
    public long getId() {
        return _lfTincanLrsResult.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs result.
     *
     * @param id the ID of this l f tincan lrs result
     */
    public void setId(long id) {
        _lfTincanLrsResult.setId(id);
    }

    /**
     * Returns the score of this l f tincan lrs result.
     *
     * @return the score of this l f tincan lrs result
     */
    public java.lang.String getScore() {
        return _lfTincanLrsResult.getScore();
    }

    /**
     * Sets the score of this l f tincan lrs result.
     *
     * @param score the score of this l f tincan lrs result
     */
    public void setScore(java.lang.String score) {
        _lfTincanLrsResult.setScore(score);
    }

    /**
     * Returns the success of this l f tincan lrs result.
     *
     * @return the success of this l f tincan lrs result
     */
    public java.lang.Boolean getSuccess() {
        return _lfTincanLrsResult.getSuccess();
    }

    /**
     * Sets the success of this l f tincan lrs result.
     *
     * @param success the success of this l f tincan lrs result
     */
    public void setSuccess(java.lang.Boolean success) {
        _lfTincanLrsResult.setSuccess(success);
    }

    /**
     * Returns the completion of this l f tincan lrs result.
     *
     * @return the completion of this l f tincan lrs result
     */
    public java.lang.Boolean getCompletion() {
        return _lfTincanLrsResult.getCompletion();
    }

    /**
     * Sets the completion of this l f tincan lrs result.
     *
     * @param completion the completion of this l f tincan lrs result
     */
    public void setCompletion(java.lang.Boolean completion) {
        _lfTincanLrsResult.setCompletion(completion);
    }

    /**
     * Returns the response of this l f tincan lrs result.
     *
     * @return the response of this l f tincan lrs result
     */
    public java.lang.String getResponse() {
        return _lfTincanLrsResult.getResponse();
    }

    /**
     * Sets the response of this l f tincan lrs result.
     *
     * @param response the response of this l f tincan lrs result
     */
    public void setResponse(java.lang.String response) {
        _lfTincanLrsResult.setResponse(response);
    }

    /**
     * Returns the duration of this l f tincan lrs result.
     *
     * @return the duration of this l f tincan lrs result
     */
    public java.lang.Double getDuration() {
        return _lfTincanLrsResult.getDuration();
    }

    /**
     * Sets the duration of this l f tincan lrs result.
     *
     * @param duration the duration of this l f tincan lrs result
     */
    public void setDuration(java.lang.Double duration) {
        _lfTincanLrsResult.setDuration(duration);
    }

    /**
     * Returns the extension of this l f tincan lrs result.
     *
     * @return the extension of this l f tincan lrs result
     */
    public java.lang.String getExtension() {
        return _lfTincanLrsResult.getExtension();
    }

    /**
     * Sets the extension of this l f tincan lrs result.
     *
     * @param extension the extension of this l f tincan lrs result
     */
    public void setExtension(java.lang.String extension) {
        _lfTincanLrsResult.setExtension(extension);
    }

    public boolean isNew() {
        return _lfTincanLrsResult.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsResult.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsResult.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsResult.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsResult.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsResult.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsResult.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsResult.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsResult.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsResultWrapper((LFTincanLrsResult) _lfTincanLrsResult.clone());
    }

    public int compareTo(LFTincanLrsResult lfTincanLrsResult) {
        return _lfTincanLrsResult.compareTo(lfTincanLrsResult);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsResult.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsResult> toCacheModel() {
        return _lfTincanLrsResult.toCacheModel();
    }

    public LFTincanLrsResult toEscapedModel() {
        return new LFTincanLrsResultWrapper(_lfTincanLrsResult.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsResult.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsResult.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsResult.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsResult getWrappedLFTincanLrsResult() {
        return _lfTincanLrsResult;
    }

    public LFTincanLrsResult getWrappedModel() {
        return _lfTincanLrsResult;
    }

    public void resetOriginalValues() {
        _lfTincanLrsResult.resetOriginalValues();
    }
}

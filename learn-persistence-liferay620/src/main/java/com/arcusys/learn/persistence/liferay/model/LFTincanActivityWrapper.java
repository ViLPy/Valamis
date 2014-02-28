package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanActivity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanActivity
 * @generated
 */
public class LFTincanActivityWrapper implements LFTincanActivity,
    ModelWrapper<LFTincanActivity> {
    private LFTincanActivity _lfTincanActivity;

    public LFTincanActivityWrapper(LFTincanActivity lfTincanActivity) {
        _lfTincanActivity = lfTincanActivity;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanActivity.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("tincanID", getTincanID());
        attributes.put("packageID", getPackageID());
        attributes.put("objectType", getObjectType());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("theType", getTheType());
        attributes.put("moreInfo", getMoreInfo());
        attributes.put("interactionType", getInteractionType());
        attributes.put("correctResponsesPattern", getCorrectResponsesPattern());
        attributes.put("choices", getChoices());
        attributes.put("scale", getScale());
        attributes.put("source", getSource());
        attributes.put("target", getTarget());
        attributes.put("steps", getSteps());
        attributes.put("extensions", getExtensions());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        Long packageID = (Long) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String objectType = (String) attributes.get("objectType");

        if (objectType != null) {
            setObjectType(objectType);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String theType = (String) attributes.get("theType");

        if (theType != null) {
            setTheType(theType);
        }

        String moreInfo = (String) attributes.get("moreInfo");

        if (moreInfo != null) {
            setMoreInfo(moreInfo);
        }

        String interactionType = (String) attributes.get("interactionType");

        if (interactionType != null) {
            setInteractionType(interactionType);
        }

        String correctResponsesPattern = (String) attributes.get(
                "correctResponsesPattern");

        if (correctResponsesPattern != null) {
            setCorrectResponsesPattern(correctResponsesPattern);
        }

        String choices = (String) attributes.get("choices");

        if (choices != null) {
            setChoices(choices);
        }

        String scale = (String) attributes.get("scale");

        if (scale != null) {
            setScale(scale);
        }

        String source = (String) attributes.get("source");

        if (source != null) {
            setSource(source);
        }

        String target = (String) attributes.get("target");

        if (target != null) {
            setTarget(target);
        }

        String steps = (String) attributes.get("steps");

        if (steps != null) {
            setSteps(steps);
        }

        String extensions = (String) attributes.get("extensions");

        if (extensions != null) {
            setExtensions(extensions);
        }
    }

    /**
    * Returns the primary key of this l f tincan activity.
    *
    * @return the primary key of this l f tincan activity
    */
    @Override
    public long getPrimaryKey() {
        return _lfTincanActivity.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan activity.
    *
    * @param primaryKey the primary key of this l f tincan activity
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfTincanActivity.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f tincan activity.
    *
    * @return the ID of this l f tincan activity
    */
    @Override
    public long getId() {
        return _lfTincanActivity.getId();
    }

    /**
    * Sets the ID of this l f tincan activity.
    *
    * @param id the ID of this l f tincan activity
    */
    @Override
    public void setId(long id) {
        _lfTincanActivity.setId(id);
    }

    /**
    * Returns the tincan i d of this l f tincan activity.
    *
    * @return the tincan i d of this l f tincan activity
    */
    @Override
    public java.lang.String getTincanID() {
        return _lfTincanActivity.getTincanID();
    }

    /**
    * Sets the tincan i d of this l f tincan activity.
    *
    * @param tincanID the tincan i d of this l f tincan activity
    */
    @Override
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanActivity.setTincanID(tincanID);
    }

    /**
    * Returns the package i d of this l f tincan activity.
    *
    * @return the package i d of this l f tincan activity
    */
    @Override
    public java.lang.Long getPackageID() {
        return _lfTincanActivity.getPackageID();
    }

    /**
    * Sets the package i d of this l f tincan activity.
    *
    * @param packageID the package i d of this l f tincan activity
    */
    @Override
    public void setPackageID(java.lang.Long packageID) {
        _lfTincanActivity.setPackageID(packageID);
    }

    /**
    * Returns the object type of this l f tincan activity.
    *
    * @return the object type of this l f tincan activity
    */
    @Override
    public java.lang.String getObjectType() {
        return _lfTincanActivity.getObjectType();
    }

    /**
    * Sets the object type of this l f tincan activity.
    *
    * @param objectType the object type of this l f tincan activity
    */
    @Override
    public void setObjectType(java.lang.String objectType) {
        _lfTincanActivity.setObjectType(objectType);
    }

    /**
    * Returns the name of this l f tincan activity.
    *
    * @return the name of this l f tincan activity
    */
    @Override
    public java.lang.String getName() {
        return _lfTincanActivity.getName();
    }

    /**
    * Sets the name of this l f tincan activity.
    *
    * @param name the name of this l f tincan activity
    */
    @Override
    public void setName(java.lang.String name) {
        _lfTincanActivity.setName(name);
    }

    /**
    * Returns the description of this l f tincan activity.
    *
    * @return the description of this l f tincan activity
    */
    @Override
    public java.lang.String getDescription() {
        return _lfTincanActivity.getDescription();
    }

    /**
    * Sets the description of this l f tincan activity.
    *
    * @param description the description of this l f tincan activity
    */
    @Override
    public void setDescription(java.lang.String description) {
        _lfTincanActivity.setDescription(description);
    }

    /**
    * Returns the the type of this l f tincan activity.
    *
    * @return the the type of this l f tincan activity
    */
    @Override
    public java.lang.String getTheType() {
        return _lfTincanActivity.getTheType();
    }

    /**
    * Sets the the type of this l f tincan activity.
    *
    * @param theType the the type of this l f tincan activity
    */
    @Override
    public void setTheType(java.lang.String theType) {
        _lfTincanActivity.setTheType(theType);
    }

    /**
    * Returns the more info of this l f tincan activity.
    *
    * @return the more info of this l f tincan activity
    */
    @Override
    public java.lang.String getMoreInfo() {
        return _lfTincanActivity.getMoreInfo();
    }

    /**
    * Sets the more info of this l f tincan activity.
    *
    * @param moreInfo the more info of this l f tincan activity
    */
    @Override
    public void setMoreInfo(java.lang.String moreInfo) {
        _lfTincanActivity.setMoreInfo(moreInfo);
    }

    /**
    * Returns the interaction type of this l f tincan activity.
    *
    * @return the interaction type of this l f tincan activity
    */
    @Override
    public java.lang.String getInteractionType() {
        return _lfTincanActivity.getInteractionType();
    }

    /**
    * Sets the interaction type of this l f tincan activity.
    *
    * @param interactionType the interaction type of this l f tincan activity
    */
    @Override
    public void setInteractionType(java.lang.String interactionType) {
        _lfTincanActivity.setInteractionType(interactionType);
    }

    /**
    * Returns the correct responses pattern of this l f tincan activity.
    *
    * @return the correct responses pattern of this l f tincan activity
    */
    @Override
    public java.lang.String getCorrectResponsesPattern() {
        return _lfTincanActivity.getCorrectResponsesPattern();
    }

    /**
    * Sets the correct responses pattern of this l f tincan activity.
    *
    * @param correctResponsesPattern the correct responses pattern of this l f tincan activity
    */
    @Override
    public void setCorrectResponsesPattern(
        java.lang.String correctResponsesPattern) {
        _lfTincanActivity.setCorrectResponsesPattern(correctResponsesPattern);
    }

    /**
    * Returns the choices of this l f tincan activity.
    *
    * @return the choices of this l f tincan activity
    */
    @Override
    public java.lang.String getChoices() {
        return _lfTincanActivity.getChoices();
    }

    /**
    * Sets the choices of this l f tincan activity.
    *
    * @param choices the choices of this l f tincan activity
    */
    @Override
    public void setChoices(java.lang.String choices) {
        _lfTincanActivity.setChoices(choices);
    }

    /**
    * Returns the scale of this l f tincan activity.
    *
    * @return the scale of this l f tincan activity
    */
    @Override
    public java.lang.String getScale() {
        return _lfTincanActivity.getScale();
    }

    /**
    * Sets the scale of this l f tincan activity.
    *
    * @param scale the scale of this l f tincan activity
    */
    @Override
    public void setScale(java.lang.String scale) {
        _lfTincanActivity.setScale(scale);
    }

    /**
    * Returns the source of this l f tincan activity.
    *
    * @return the source of this l f tincan activity
    */
    @Override
    public java.lang.String getSource() {
        return _lfTincanActivity.getSource();
    }

    /**
    * Sets the source of this l f tincan activity.
    *
    * @param source the source of this l f tincan activity
    */
    @Override
    public void setSource(java.lang.String source) {
        _lfTincanActivity.setSource(source);
    }

    /**
    * Returns the target of this l f tincan activity.
    *
    * @return the target of this l f tincan activity
    */
    @Override
    public java.lang.String getTarget() {
        return _lfTincanActivity.getTarget();
    }

    /**
    * Sets the target of this l f tincan activity.
    *
    * @param target the target of this l f tincan activity
    */
    @Override
    public void setTarget(java.lang.String target) {
        _lfTincanActivity.setTarget(target);
    }

    /**
    * Returns the steps of this l f tincan activity.
    *
    * @return the steps of this l f tincan activity
    */
    @Override
    public java.lang.String getSteps() {
        return _lfTincanActivity.getSteps();
    }

    /**
    * Sets the steps of this l f tincan activity.
    *
    * @param steps the steps of this l f tincan activity
    */
    @Override
    public void setSteps(java.lang.String steps) {
        _lfTincanActivity.setSteps(steps);
    }

    /**
    * Returns the extensions of this l f tincan activity.
    *
    * @return the extensions of this l f tincan activity
    */
    @Override
    public java.lang.String getExtensions() {
        return _lfTincanActivity.getExtensions();
    }

    /**
    * Sets the extensions of this l f tincan activity.
    *
    * @param extensions the extensions of this l f tincan activity
    */
    @Override
    public void setExtensions(java.lang.String extensions) {
        _lfTincanActivity.setExtensions(extensions);
    }

    @Override
    public boolean isNew() {
        return _lfTincanActivity.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanActivity.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanActivity.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanActivity.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanActivity.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanActivity.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanActivity.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanActivity.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanActivity.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanActivityWrapper((LFTincanActivity) _lfTincanActivity.clone());
    }

    @Override
    public int compareTo(LFTincanActivity lfTincanActivity) {
        return _lfTincanActivity.compareTo(lfTincanActivity);
    }

    @Override
    public int hashCode() {
        return _lfTincanActivity.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanActivity> toCacheModel() {
        return _lfTincanActivity.toCacheModel();
    }

    @Override
    public LFTincanActivity toEscapedModel() {
        return new LFTincanActivityWrapper(_lfTincanActivity.toEscapedModel());
    }

    @Override
    public LFTincanActivity toUnescapedModel() {
        return new LFTincanActivityWrapper(_lfTincanActivity.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanActivity.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanActivity.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanActivity.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanActivityWrapper)) {
            return false;
        }

        LFTincanActivityWrapper lfTincanActivityWrapper = (LFTincanActivityWrapper) obj;

        if (Validator.equals(_lfTincanActivity,
                    lfTincanActivityWrapper._lfTincanActivity)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanActivity getWrappedLFTincanActivity() {
        return _lfTincanActivity;
    }

    @Override
    public LFTincanActivity getWrappedModel() {
        return _lfTincanActivity;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanActivity.resetOriginalValues();
    }
}

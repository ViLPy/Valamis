package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFSocialPackageTag}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackageTag
 * @generated
 */
public class LFSocialPackageTagWrapper implements LFSocialPackageTag,
    ModelWrapper<LFSocialPackageTag> {
    private LFSocialPackageTag _lfSocialPackageTag;

    public LFSocialPackageTagWrapper(LFSocialPackageTag lfSocialPackageTag) {
        _lfSocialPackageTag = lfSocialPackageTag;
    }

    @Override
    public Class<?> getModelClass() {
        return LFSocialPackageTag.class;
    }

    @Override
    public String getModelClassName() {
        return LFSocialPackageTag.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer socialPackageID = (Integer) attributes.get("socialPackageID");

        if (socialPackageID != null) {
            setSocialPackageID(socialPackageID);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    /**
    * Returns the primary key of this l f social package tag.
    *
    * @return the primary key of this l f social package tag
    */
    @Override
    public long getPrimaryKey() {
        return _lfSocialPackageTag.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f social package tag.
    *
    * @param primaryKey the primary key of this l f social package tag
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _lfSocialPackageTag.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this l f social package tag.
    *
    * @return the ID of this l f social package tag
    */
    @Override
    public long getId() {
        return _lfSocialPackageTag.getId();
    }

    /**
    * Sets the ID of this l f social package tag.
    *
    * @param id the ID of this l f social package tag
    */
    @Override
    public void setId(long id) {
        _lfSocialPackageTag.setId(id);
    }

    /**
    * Returns the social package i d of this l f social package tag.
    *
    * @return the social package i d of this l f social package tag
    */
    @Override
    public java.lang.Integer getSocialPackageID() {
        return _lfSocialPackageTag.getSocialPackageID();
    }

    /**
    * Sets the social package i d of this l f social package tag.
    *
    * @param socialPackageID the social package i d of this l f social package tag
    */
    @Override
    public void setSocialPackageID(java.lang.Integer socialPackageID) {
        _lfSocialPackageTag.setSocialPackageID(socialPackageID);
    }

    /**
    * Returns the name of this l f social package tag.
    *
    * @return the name of this l f social package tag
    */
    @Override
    public java.lang.String getName() {
        return _lfSocialPackageTag.getName();
    }

    /**
    * Sets the name of this l f social package tag.
    *
    * @param name the name of this l f social package tag
    */
    @Override
    public void setName(java.lang.String name) {
        _lfSocialPackageTag.setName(name);
    }

    @Override
    public boolean isNew() {
        return _lfSocialPackageTag.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfSocialPackageTag.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfSocialPackageTag.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfSocialPackageTag.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfSocialPackageTag.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSocialPackageTag.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSocialPackageTag.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSocialPackageTag.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfSocialPackageTag.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfSocialPackageTag.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSocialPackageTag.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSocialPackageTagWrapper((LFSocialPackageTag) _lfSocialPackageTag.clone());
    }

    @Override
    public int compareTo(LFSocialPackageTag lfSocialPackageTag) {
        return _lfSocialPackageTag.compareTo(lfSocialPackageTag);
    }

    @Override
    public int hashCode() {
        return _lfSocialPackageTag.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFSocialPackageTag> toCacheModel() {
        return _lfSocialPackageTag.toCacheModel();
    }

    @Override
    public LFSocialPackageTag toEscapedModel() {
        return new LFSocialPackageTagWrapper(_lfSocialPackageTag.toEscapedModel());
    }

    @Override
    public LFSocialPackageTag toUnescapedModel() {
        return new LFSocialPackageTagWrapper(_lfSocialPackageTag.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSocialPackageTag.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfSocialPackageTag.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSocialPackageTag.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFSocialPackageTagWrapper)) {
            return false;
        }

        LFSocialPackageTagWrapper lfSocialPackageTagWrapper = (LFSocialPackageTagWrapper) obj;

        if (Validator.equals(_lfSocialPackageTag,
                    lfSocialPackageTagWrapper._lfSocialPackageTag)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFSocialPackageTag getWrappedLFSocialPackageTag() {
        return _lfSocialPackageTag;
    }

    @Override
    public LFSocialPackageTag getWrappedModel() {
        return _lfSocialPackageTag;
    }

    @Override
    public void resetOriginalValues() {
        _lfSocialPackageTag.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFSocialPackageTag}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFSocialPackageTag
* @generated
*/
public class LFSocialPackageTagWrapper implements LFSocialPackageTag,
    ModelWrapper<LFSocialPackageTag> {
    private LFSocialPackageTag _lfSocialPackageTag;

    public LFSocialPackageTagWrapper(LFSocialPackageTag lfSocialPackageTag) {
        _lfSocialPackageTag = lfSocialPackageTag;
    }

    public Class<?> getModelClass() {
        return LFSocialPackageTag.class;
    }

    public String getModelClassName() {
        return LFSocialPackageTag.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("socialPackageID", getSocialPackageID());
        attributes.put("name", getName());

        return attributes;
    }

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
    public long getPrimaryKey() {
        return _lfSocialPackageTag.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f social package tag.
     *
     * @param primaryKey the primary key of this l f social package tag
     */
    public void setPrimaryKey(long primaryKey) {
        _lfSocialPackageTag.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f social package tag.
     *
     * @return the ID of this l f social package tag
     */
    public long getId() {
        return _lfSocialPackageTag.getId();
    }

    /**
     * Sets the ID of this l f social package tag.
     *
     * @param id the ID of this l f social package tag
     */
    public void setId(long id) {
        _lfSocialPackageTag.setId(id);
    }

    /**
     * Returns the social package i d of this l f social package tag.
     *
     * @return the social package i d of this l f social package tag
     */
    public java.lang.Integer getSocialPackageID() {
        return _lfSocialPackageTag.getSocialPackageID();
    }

    /**
     * Sets the social package i d of this l f social package tag.
     *
     * @param socialPackageID the social package i d of this l f social package tag
     */
    public void setSocialPackageID(java.lang.Integer socialPackageID) {
        _lfSocialPackageTag.setSocialPackageID(socialPackageID);
    }

    /**
     * Returns the name of this l f social package tag.
     *
     * @return the name of this l f social package tag
     */
    public java.lang.String getName() {
        return _lfSocialPackageTag.getName();
    }

    /**
     * Sets the name of this l f social package tag.
     *
     * @param name the name of this l f social package tag
     */
    public void setName(java.lang.String name) {
        _lfSocialPackageTag.setName(name);
    }

    public boolean isNew() {
        return _lfSocialPackageTag.isNew();
    }

    public void setNew(boolean n) {
        _lfSocialPackageTag.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfSocialPackageTag.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfSocialPackageTag.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfSocialPackageTag.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSocialPackageTag.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSocialPackageTag.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSocialPackageTag.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSocialPackageTag.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSocialPackageTagWrapper((LFSocialPackageTag) _lfSocialPackageTag.clone());
    }

    public int compareTo(LFSocialPackageTag lfSocialPackageTag) {
        return _lfSocialPackageTag.compareTo(lfSocialPackageTag);
    }

    @Override
    public int hashCode() {
        return _lfSocialPackageTag.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFSocialPackageTag> toCacheModel() {
        return _lfSocialPackageTag.toCacheModel();
    }

    public LFSocialPackageTag toEscapedModel() {
        return new LFSocialPackageTagWrapper(_lfSocialPackageTag.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSocialPackageTag.toString();
    }

    public java.lang.String toXmlString() {
        return _lfSocialPackageTag.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSocialPackageTag.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFSocialPackageTag getWrappedLFSocialPackageTag() {
        return _lfSocialPackageTag;
    }

    public LFSocialPackageTag getWrappedModel() {
        return _lfSocialPackageTag;
    }

    public void resetOriginalValues() {
        _lfSocialPackageTag.resetOriginalValues();
    }
}

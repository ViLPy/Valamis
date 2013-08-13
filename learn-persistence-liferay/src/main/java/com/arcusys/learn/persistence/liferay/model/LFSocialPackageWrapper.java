package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFSocialPackage}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFSocialPackage
* @generated
*/
public class LFSocialPackageWrapper implements LFSocialPackage,
    ModelWrapper<LFSocialPackage> {
    private LFSocialPackage _lfSocialPackage;

    public LFSocialPackageWrapper(LFSocialPackage lfSocialPackage) {
        _lfSocialPackage = lfSocialPackage;
    }

    public Class<?> getModelClass() {
        return LFSocialPackage.class;
    }

    public String getModelClassName() {
        return LFSocialPackage.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("aboutPackage", getAboutPackage());
        attributes.put("publishDate", getPublishDate());
        attributes.put("authorID", getAuthorID());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String aboutPackage = (String) attributes.get("aboutPackage");

        if (aboutPackage != null) {
            setAboutPackage(aboutPackage);
        }

        Date publishDate = (Date) attributes.get("publishDate");

        if (publishDate != null) {
            setPublishDate(publishDate);
        }

        Integer authorID = (Integer) attributes.get("authorID");

        if (authorID != null) {
            setAuthorID(authorID);
        }
    }

    /**
     * Returns the primary key of this l f social package.
     *
     * @return the primary key of this l f social package
     */
    public long getPrimaryKey() {
        return _lfSocialPackage.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f social package.
     *
     * @param primaryKey the primary key of this l f social package
     */
    public void setPrimaryKey(long primaryKey) {
        _lfSocialPackage.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f social package.
     *
     * @return the ID of this l f social package
     */
    public long getId() {
        return _lfSocialPackage.getId();
    }

    /**
     * Sets the ID of this l f social package.
     *
     * @param id the ID of this l f social package
     */
    public void setId(long id) {
        _lfSocialPackage.setId(id);
    }

    /**
     * Returns the package i d of this l f social package.
     *
     * @return the package i d of this l f social package
     */
    public java.lang.Integer getPackageID() {
        return _lfSocialPackage.getPackageID();
    }

    /**
     * Sets the package i d of this l f social package.
     *
     * @param packageID the package i d of this l f social package
     */
    public void setPackageID(java.lang.Integer packageID) {
        _lfSocialPackage.setPackageID(packageID);
    }

    /**
     * Returns the about package of this l f social package.
     *
     * @return the about package of this l f social package
     */
    public java.lang.String getAboutPackage() {
        return _lfSocialPackage.getAboutPackage();
    }

    /**
     * Sets the about package of this l f social package.
     *
     * @param aboutPackage the about package of this l f social package
     */
    public void setAboutPackage(java.lang.String aboutPackage) {
        _lfSocialPackage.setAboutPackage(aboutPackage);
    }

    /**
     * Returns the publish date of this l f social package.
     *
     * @return the publish date of this l f social package
     */
    public java.util.Date getPublishDate() {
        return _lfSocialPackage.getPublishDate();
    }

    /**
     * Sets the publish date of this l f social package.
     *
     * @param publishDate the publish date of this l f social package
     */
    public void setPublishDate(java.util.Date publishDate) {
        _lfSocialPackage.setPublishDate(publishDate);
    }

    /**
     * Returns the author i d of this l f social package.
     *
     * @return the author i d of this l f social package
     */
    public java.lang.Integer getAuthorID() {
        return _lfSocialPackage.getAuthorID();
    }

    /**
     * Sets the author i d of this l f social package.
     *
     * @param authorID the author i d of this l f social package
     */
    public void setAuthorID(java.lang.Integer authorID) {
        _lfSocialPackage.setAuthorID(authorID);
    }

    public boolean isNew() {
        return _lfSocialPackage.isNew();
    }

    public void setNew(boolean n) {
        _lfSocialPackage.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfSocialPackage.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfSocialPackage.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfSocialPackage.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfSocialPackage.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfSocialPackage.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfSocialPackage.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfSocialPackage.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFSocialPackageWrapper((LFSocialPackage) _lfSocialPackage.clone());
    }

    public int compareTo(LFSocialPackage lfSocialPackage) {
        return _lfSocialPackage.compareTo(lfSocialPackage);
    }

    @Override
    public int hashCode() {
        return _lfSocialPackage.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFSocialPackage> toCacheModel() {
        return _lfSocialPackage.toCacheModel();
    }

    public LFSocialPackage toEscapedModel() {
        return new LFSocialPackageWrapper(_lfSocialPackage.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfSocialPackage.toString();
    }

    public java.lang.String toXmlString() {
        return _lfSocialPackage.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfSocialPackage.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFSocialPackage getWrappedLFSocialPackage() {
        return _lfSocialPackage;
    }

    public LFSocialPackage getWrappedModel() {
        return _lfSocialPackage;
    }

    public void resetOriginalValues() {
        _lfSocialPackage.resetOriginalValues();
    }
}

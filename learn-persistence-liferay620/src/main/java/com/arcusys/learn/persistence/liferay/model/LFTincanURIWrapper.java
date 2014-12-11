package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LFTincanURI}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURI
 * @generated
 */
public class LFTincanURIWrapper implements LFTincanURI,
    ModelWrapper<LFTincanURI> {
    private LFTincanURI _lfTincanURI;

    public LFTincanURIWrapper(LFTincanURI lfTincanURI) {
        _lfTincanURI = lfTincanURI;
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanURI.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanURI.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uri", getUri());
        attributes.put("objID", getObjID());
        attributes.put("objType", getObjType());
        attributes.put("content", getContent());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uri = (String) attributes.get("uri");

        if (uri != null) {
            setUri(uri);
        }

        String objID = (String) attributes.get("objID");

        if (objID != null) {
            setObjID(objID);
        }

        String objType = (String) attributes.get("objType");

        if (objType != null) {
            setObjType(objType);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }
    }

    /**
    * Returns the primary key of this l f tincan u r i.
    *
    * @return the primary key of this l f tincan u r i
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _lfTincanURI.getPrimaryKey();
    }

    /**
    * Sets the primary key of this l f tincan u r i.
    *
    * @param primaryKey the primary key of this l f tincan u r i
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _lfTincanURI.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uri of this l f tincan u r i.
    *
    * @return the uri of this l f tincan u r i
    */
    @Override
    public java.lang.String getUri() {
        return _lfTincanURI.getUri();
    }

    /**
    * Sets the uri of this l f tincan u r i.
    *
    * @param uri the uri of this l f tincan u r i
    */
    @Override
    public void setUri(java.lang.String uri) {
        _lfTincanURI.setUri(uri);
    }

    /**
    * Returns the obj i d of this l f tincan u r i.
    *
    * @return the obj i d of this l f tincan u r i
    */
    @Override
    public java.lang.String getObjID() {
        return _lfTincanURI.getObjID();
    }

    /**
    * Sets the obj i d of this l f tincan u r i.
    *
    * @param objID the obj i d of this l f tincan u r i
    */
    @Override
    public void setObjID(java.lang.String objID) {
        _lfTincanURI.setObjID(objID);
    }

    /**
    * Returns the obj type of this l f tincan u r i.
    *
    * @return the obj type of this l f tincan u r i
    */
    @Override
    public java.lang.String getObjType() {
        return _lfTincanURI.getObjType();
    }

    /**
    * Sets the obj type of this l f tincan u r i.
    *
    * @param objType the obj type of this l f tincan u r i
    */
    @Override
    public void setObjType(java.lang.String objType) {
        _lfTincanURI.setObjType(objType);
    }

    /**
    * Returns the content of this l f tincan u r i.
    *
    * @return the content of this l f tincan u r i
    */
    @Override
    public java.lang.String getContent() {
        return _lfTincanURI.getContent();
    }

    /**
    * Sets the content of this l f tincan u r i.
    *
    * @param content the content of this l f tincan u r i
    */
    @Override
    public void setContent(java.lang.String content) {
        _lfTincanURI.setContent(content);
    }

    @Override
    public boolean isNew() {
        return _lfTincanURI.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _lfTincanURI.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _lfTincanURI.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _lfTincanURI.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _lfTincanURI.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanURI.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanURI.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanURI.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _lfTincanURI.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _lfTincanURI.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanURI.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanURIWrapper((LFTincanURI) _lfTincanURI.clone());
    }

    @Override
    public int compareTo(LFTincanURI lfTincanURI) {
        return _lfTincanURI.compareTo(lfTincanURI);
    }

    @Override
    public int hashCode() {
        return _lfTincanURI.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<LFTincanURI> toCacheModel() {
        return _lfTincanURI.toCacheModel();
    }

    @Override
    public LFTincanURI toEscapedModel() {
        return new LFTincanURIWrapper(_lfTincanURI.toEscapedModel());
    }

    @Override
    public LFTincanURI toUnescapedModel() {
        return new LFTincanURIWrapper(_lfTincanURI.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanURI.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _lfTincanURI.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanURI.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanURIWrapper)) {
            return false;
        }

        LFTincanURIWrapper lfTincanURIWrapper = (LFTincanURIWrapper) obj;

        if (Validator.equals(_lfTincanURI, lfTincanURIWrapper._lfTincanURI)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public LFTincanURI getWrappedLFTincanURI() {
        return _lfTincanURI;
    }

    @Override
    public LFTincanURI getWrappedModel() {
        return _lfTincanURI;
    }

    @Override
    public void resetOriginalValues() {
        _lfTincanURI.resetOriginalValues();
    }
}

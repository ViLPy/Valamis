package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsStatement}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsStatement
* @generated
*/
public class LFTincanLrsStatementWrapper implements LFTincanLrsStatement,
    ModelWrapper<LFTincanLrsStatement> {
    private LFTincanLrsStatement _lfTincanLrsStatement;

    public LFTincanLrsStatementWrapper(
        LFTincanLrsStatement lfTincanLrsStatement) {
        _lfTincanLrsStatement = lfTincanLrsStatement;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsStatement.class;
    }

    public String getModelClassName() {
        return LFTincanLrsStatement.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("tincanID", getTincanID());
        attributes.put("actorID", getActorID());
        attributes.put("verbID", getVerbID());
        attributes.put("verbDisplay", getVerbDisplay());
        attributes.put("objType", getObjType());
        attributes.put("objID", getObjID());
        attributes.put("resultID", getResultID());
        attributes.put("contextID", getContextID());
        attributes.put("timestamp", getTimestamp());
        attributes.put("stored", getStored());
        attributes.put("authorityID", getAuthorityID());
        attributes.put("version", getVersion());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String tincanID = (String) attributes.get("tincanID");

        if (tincanID != null) {
            setTincanID(tincanID);
        }

        Integer actorID = (Integer) attributes.get("actorID");

        if (actorID != null) {
            setActorID(actorID);
        }

        String verbID = (String) attributes.get("verbID");

        if (verbID != null) {
            setVerbID(verbID);
        }

        String verbDisplay = (String) attributes.get("verbDisplay");

        if (verbDisplay != null) {
            setVerbDisplay(verbDisplay);
        }

        String objType = (String) attributes.get("objType");

        if (objType != null) {
            setObjType(objType);
        }

        Integer objID = (Integer) attributes.get("objID");

        if (objID != null) {
            setObjID(objID);
        }

        Integer resultID = (Integer) attributes.get("resultID");

        if (resultID != null) {
            setResultID(resultID);
        }

        Integer contextID = (Integer) attributes.get("contextID");

        if (contextID != null) {
            setContextID(contextID);
        }

        Date timestamp = (Date) attributes.get("timestamp");

        if (timestamp != null) {
            setTimestamp(timestamp);
        }

        Date stored = (Date) attributes.get("stored");

        if (stored != null) {
            setStored(stored);
        }

        Integer authorityID = (Integer) attributes.get("authorityID");

        if (authorityID != null) {
            setAuthorityID(authorityID);
        }

        String version = (String) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }
    }

    /**
     * Returns the primary key of this l f tincan lrs statement.
     *
     * @return the primary key of this l f tincan lrs statement
     */
    public long getPrimaryKey() {
        return _lfTincanLrsStatement.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs statement.
     *
     * @param primaryKey the primary key of this l f tincan lrs statement
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsStatement.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs statement.
     *
     * @return the ID of this l f tincan lrs statement
     */
    public long getId() {
        return _lfTincanLrsStatement.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs statement.
     *
     * @param id the ID of this l f tincan lrs statement
     */
    public void setId(long id) {
        _lfTincanLrsStatement.setId(id);
    }

    /**
     * Returns the tincan i d of this l f tincan lrs statement.
     *
     * @return the tincan i d of this l f tincan lrs statement
     */
    public java.lang.String getTincanID() {
        return _lfTincanLrsStatement.getTincanID();
    }

    /**
     * Sets the tincan i d of this l f tincan lrs statement.
     *
     * @param tincanID the tincan i d of this l f tincan lrs statement
     */
    public void setTincanID(java.lang.String tincanID) {
        _lfTincanLrsStatement.setTincanID(tincanID);
    }

    /**
     * Returns the actor i d of this l f tincan lrs statement.
     *
     * @return the actor i d of this l f tincan lrs statement
     */
    public java.lang.Integer getActorID() {
        return _lfTincanLrsStatement.getActorID();
    }

    /**
     * Sets the actor i d of this l f tincan lrs statement.
     *
     * @param actorID the actor i d of this l f tincan lrs statement
     */
    public void setActorID(java.lang.Integer actorID) {
        _lfTincanLrsStatement.setActorID(actorID);
    }

    /**
     * Returns the verb i d of this l f tincan lrs statement.
     *
     * @return the verb i d of this l f tincan lrs statement
     */
    public java.lang.String getVerbID() {
        return _lfTincanLrsStatement.getVerbID();
    }

    /**
     * Sets the verb i d of this l f tincan lrs statement.
     *
     * @param verbID the verb i d of this l f tincan lrs statement
     */
    public void setVerbID(java.lang.String verbID) {
        _lfTincanLrsStatement.setVerbID(verbID);
    }

    /**
     * Returns the verb display of this l f tincan lrs statement.
     *
     * @return the verb display of this l f tincan lrs statement
     */
    public java.lang.String getVerbDisplay() {
        return _lfTincanLrsStatement.getVerbDisplay();
    }

    /**
     * Sets the verb display of this l f tincan lrs statement.
     *
     * @param verbDisplay the verb display of this l f tincan lrs statement
     */
    public void setVerbDisplay(java.lang.String verbDisplay) {
        _lfTincanLrsStatement.setVerbDisplay(verbDisplay);
    }

    /**
     * Returns the obj type of this l f tincan lrs statement.
     *
     * @return the obj type of this l f tincan lrs statement
     */
    public java.lang.String getObjType() {
        return _lfTincanLrsStatement.getObjType();
    }

    /**
     * Sets the obj type of this l f tincan lrs statement.
     *
     * @param objType the obj type of this l f tincan lrs statement
     */
    public void setObjType(java.lang.String objType) {
        _lfTincanLrsStatement.setObjType(objType);
    }

    /**
     * Returns the obj i d of this l f tincan lrs statement.
     *
     * @return the obj i d of this l f tincan lrs statement
     */
    public java.lang.Integer getObjID() {
        return _lfTincanLrsStatement.getObjID();
    }

    /**
     * Sets the obj i d of this l f tincan lrs statement.
     *
     * @param objID the obj i d of this l f tincan lrs statement
     */
    public void setObjID(java.lang.Integer objID) {
        _lfTincanLrsStatement.setObjID(objID);
    }

    /**
     * Returns the result i d of this l f tincan lrs statement.
     *
     * @return the result i d of this l f tincan lrs statement
     */
    public java.lang.Integer getResultID() {
        return _lfTincanLrsStatement.getResultID();
    }

    /**
     * Sets the result i d of this l f tincan lrs statement.
     *
     * @param resultID the result i d of this l f tincan lrs statement
     */
    public void setResultID(java.lang.Integer resultID) {
        _lfTincanLrsStatement.setResultID(resultID);
    }

    /**
     * Returns the context i d of this l f tincan lrs statement.
     *
     * @return the context i d of this l f tincan lrs statement
     */
    public java.lang.Integer getContextID() {
        return _lfTincanLrsStatement.getContextID();
    }

    /**
     * Sets the context i d of this l f tincan lrs statement.
     *
     * @param contextID the context i d of this l f tincan lrs statement
     */
    public void setContextID(java.lang.Integer contextID) {
        _lfTincanLrsStatement.setContextID(contextID);
    }

    /**
     * Returns the timestamp of this l f tincan lrs statement.
     *
     * @return the timestamp of this l f tincan lrs statement
     */
    public java.util.Date getTimestamp() {
        return _lfTincanLrsStatement.getTimestamp();
    }

    /**
     * Sets the timestamp of this l f tincan lrs statement.
     *
     * @param timestamp the timestamp of this l f tincan lrs statement
     */
    public void setTimestamp(java.util.Date timestamp) {
        _lfTincanLrsStatement.setTimestamp(timestamp);
    }

    /**
     * Returns the stored of this l f tincan lrs statement.
     *
     * @return the stored of this l f tincan lrs statement
     */
    public java.util.Date getStored() {
        return _lfTincanLrsStatement.getStored();
    }

    /**
     * Sets the stored of this l f tincan lrs statement.
     *
     * @param stored the stored of this l f tincan lrs statement
     */
    public void setStored(java.util.Date stored) {
        _lfTincanLrsStatement.setStored(stored);
    }

    /**
     * Returns the authority i d of this l f tincan lrs statement.
     *
     * @return the authority i d of this l f tincan lrs statement
     */
    public java.lang.Integer getAuthorityID() {
        return _lfTincanLrsStatement.getAuthorityID();
    }

    /**
     * Sets the authority i d of this l f tincan lrs statement.
     *
     * @param authorityID the authority i d of this l f tincan lrs statement
     */
    public void setAuthorityID(java.lang.Integer authorityID) {
        _lfTincanLrsStatement.setAuthorityID(authorityID);
    }

    /**
     * Returns the version of this l f tincan lrs statement.
     *
     * @return the version of this l f tincan lrs statement
     */
    public java.lang.String getVersion() {
        return _lfTincanLrsStatement.getVersion();
    }

    /**
     * Sets the version of this l f tincan lrs statement.
     *
     * @param version the version of this l f tincan lrs statement
     */
    public void setVersion(java.lang.String version) {
        _lfTincanLrsStatement.setVersion(version);
    }

    public boolean isNew() {
        return _lfTincanLrsStatement.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsStatement.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsStatement.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsStatement.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsStatement.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsStatement.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsStatement.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsStatement.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsStatement.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsStatementWrapper((LFTincanLrsStatement) _lfTincanLrsStatement.clone());
    }

    public int compareTo(LFTincanLrsStatement lfTincanLrsStatement) {
        return _lfTincanLrsStatement.compareTo(lfTincanLrsStatement);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsStatement.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsStatement> toCacheModel() {
        return _lfTincanLrsStatement.toCacheModel();
    }

    public LFTincanLrsStatement toEscapedModel() {
        return new LFTincanLrsStatementWrapper(_lfTincanLrsStatement.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsStatement.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsStatement.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsStatement.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsStatement getWrappedLFTincanLrsStatement() {
        return _lfTincanLrsStatement;
    }

    public LFTincanLrsStatement getWrappedModel() {
        return _lfTincanLrsStatement;
    }

    public void resetOriginalValues() {
        _lfTincanLrsStatement.resetOriginalValues();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFTincanLrsContext}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFTincanLrsContext
* @generated
*/
public class LFTincanLrsContextWrapper implements LFTincanLrsContext,
    ModelWrapper<LFTincanLrsContext> {
    private LFTincanLrsContext _lfTincanLrsContext;

    public LFTincanLrsContextWrapper(LFTincanLrsContext lfTincanLrsContext) {
        _lfTincanLrsContext = lfTincanLrsContext;
    }

    public Class<?> getModelClass() {
        return LFTincanLrsContext.class;
    }

    public String getModelClassName() {
        return LFTincanLrsContext.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("registration", getRegistration());
        attributes.put("instructorID", getInstructorID());
        attributes.put("teamID", getTeamID());
        attributes.put("contextActivitiesID", getContextActivitiesID());
        attributes.put("revision", getRevision());
        attributes.put("platform", getPlatform());
        attributes.put("language", getLanguage());
        attributes.put("statement", getStatement());
        attributes.put("extensions", getExtensions());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String registration = (String) attributes.get("registration");

        if (registration != null) {
            setRegistration(registration);
        }

        Integer instructorID = (Integer) attributes.get("instructorID");

        if (instructorID != null) {
            setInstructorID(instructorID);
        }

        Integer teamID = (Integer) attributes.get("teamID");

        if (teamID != null) {
            setTeamID(teamID);
        }

        Integer contextActivitiesID = (Integer) attributes.get(
                "contextActivitiesID");

        if (contextActivitiesID != null) {
            setContextActivitiesID(contextActivitiesID);
        }

        String revision = (String) attributes.get("revision");

        if (revision != null) {
            setRevision(revision);
        }

        String platform = (String) attributes.get("platform");

        if (platform != null) {
            setPlatform(platform);
        }

        String language = (String) attributes.get("language");

        if (language != null) {
            setLanguage(language);
        }

        String statement = (String) attributes.get("statement");

        if (statement != null) {
            setStatement(statement);
        }

        String extensions = (String) attributes.get("extensions");

        if (extensions != null) {
            setExtensions(extensions);
        }
    }

    /**
     * Returns the primary key of this l f tincan lrs context.
     *
     * @return the primary key of this l f tincan lrs context
     */
    public long getPrimaryKey() {
        return _lfTincanLrsContext.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f tincan lrs context.
     *
     * @param primaryKey the primary key of this l f tincan lrs context
     */
    public void setPrimaryKey(long primaryKey) {
        _lfTincanLrsContext.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the ID of this l f tincan lrs context.
     *
     * @return the ID of this l f tincan lrs context
     */
    public long getId() {
        return _lfTincanLrsContext.getId();
    }

    /**
     * Sets the ID of this l f tincan lrs context.
     *
     * @param id the ID of this l f tincan lrs context
     */
    public void setId(long id) {
        _lfTincanLrsContext.setId(id);
    }

    /**
     * Returns the registration of this l f tincan lrs context.
     *
     * @return the registration of this l f tincan lrs context
     */
    public java.lang.String getRegistration() {
        return _lfTincanLrsContext.getRegistration();
    }

    /**
     * Sets the registration of this l f tincan lrs context.
     *
     * @param registration the registration of this l f tincan lrs context
     */
    public void setRegistration(java.lang.String registration) {
        _lfTincanLrsContext.setRegistration(registration);
    }

    /**
     * Returns the instructor i d of this l f tincan lrs context.
     *
     * @return the instructor i d of this l f tincan lrs context
     */
    public java.lang.Integer getInstructorID() {
        return _lfTincanLrsContext.getInstructorID();
    }

    /**
     * Sets the instructor i d of this l f tincan lrs context.
     *
     * @param instructorID the instructor i d of this l f tincan lrs context
     */
    public void setInstructorID(java.lang.Integer instructorID) {
        _lfTincanLrsContext.setInstructorID(instructorID);
    }

    /**
     * Returns the team i d of this l f tincan lrs context.
     *
     * @return the team i d of this l f tincan lrs context
     */
    public java.lang.Integer getTeamID() {
        return _lfTincanLrsContext.getTeamID();
    }

    /**
     * Sets the team i d of this l f tincan lrs context.
     *
     * @param teamID the team i d of this l f tincan lrs context
     */
    public void setTeamID(java.lang.Integer teamID) {
        _lfTincanLrsContext.setTeamID(teamID);
    }

    /**
     * Returns the context activities i d of this l f tincan lrs context.
     *
     * @return the context activities i d of this l f tincan lrs context
     */
    public java.lang.Integer getContextActivitiesID() {
        return _lfTincanLrsContext.getContextActivitiesID();
    }

    /**
     * Sets the context activities i d of this l f tincan lrs context.
     *
     * @param contextActivitiesID the context activities i d of this l f tincan lrs context
     */
    public void setContextActivitiesID(java.lang.Integer contextActivitiesID) {
        _lfTincanLrsContext.setContextActivitiesID(contextActivitiesID);
    }

    /**
     * Returns the revision of this l f tincan lrs context.
     *
     * @return the revision of this l f tincan lrs context
     */
    public java.lang.String getRevision() {
        return _lfTincanLrsContext.getRevision();
    }

    /**
     * Sets the revision of this l f tincan lrs context.
     *
     * @param revision the revision of this l f tincan lrs context
     */
    public void setRevision(java.lang.String revision) {
        _lfTincanLrsContext.setRevision(revision);
    }

    /**
     * Returns the platform of this l f tincan lrs context.
     *
     * @return the platform of this l f tincan lrs context
     */
    public java.lang.String getPlatform() {
        return _lfTincanLrsContext.getPlatform();
    }

    /**
     * Sets the platform of this l f tincan lrs context.
     *
     * @param platform the platform of this l f tincan lrs context
     */
    public void setPlatform(java.lang.String platform) {
        _lfTincanLrsContext.setPlatform(platform);
    }

    /**
     * Returns the language of this l f tincan lrs context.
     *
     * @return the language of this l f tincan lrs context
     */
    public java.lang.String getLanguage() {
        return _lfTincanLrsContext.getLanguage();
    }

    /**
     * Sets the language of this l f tincan lrs context.
     *
     * @param language the language of this l f tincan lrs context
     */
    public void setLanguage(java.lang.String language) {
        _lfTincanLrsContext.setLanguage(language);
    }

    /**
     * Returns the statement of this l f tincan lrs context.
     *
     * @return the statement of this l f tincan lrs context
     */
    public java.lang.String getStatement() {
        return _lfTincanLrsContext.getStatement();
    }

    /**
     * Sets the statement of this l f tincan lrs context.
     *
     * @param statement the statement of this l f tincan lrs context
     */
    public void setStatement(java.lang.String statement) {
        _lfTincanLrsContext.setStatement(statement);
    }

    /**
     * Returns the extensions of this l f tincan lrs context.
     *
     * @return the extensions of this l f tincan lrs context
     */
    public java.lang.String getExtensions() {
        return _lfTincanLrsContext.getExtensions();
    }

    /**
     * Sets the extensions of this l f tincan lrs context.
     *
     * @param extensions the extensions of this l f tincan lrs context
     */
    public void setExtensions(java.lang.String extensions) {
        _lfTincanLrsContext.setExtensions(extensions);
    }

    public boolean isNew() {
        return _lfTincanLrsContext.isNew();
    }

    public void setNew(boolean n) {
        _lfTincanLrsContext.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfTincanLrsContext.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfTincanLrsContext.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfTincanLrsContext.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfTincanLrsContext.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfTincanLrsContext.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfTincanLrsContext.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfTincanLrsContext.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFTincanLrsContextWrapper((LFTincanLrsContext) _lfTincanLrsContext.clone());
    }

    public int compareTo(LFTincanLrsContext lfTincanLrsContext) {
        return _lfTincanLrsContext.compareTo(lfTincanLrsContext);
    }

    @Override
    public int hashCode() {
        return _lfTincanLrsContext.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFTincanLrsContext> toCacheModel() {
        return _lfTincanLrsContext.toCacheModel();
    }

    public LFTincanLrsContext toEscapedModel() {
        return new LFTincanLrsContextWrapper(_lfTincanLrsContext.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfTincanLrsContext.toString();
    }

    public java.lang.String toXmlString() {
        return _lfTincanLrsContext.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfTincanLrsContext.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFTincanLrsContext getWrappedLFTincanLrsContext() {
        return _lfTincanLrsContext;
    }

    public LFTincanLrsContext getWrappedModel() {
        return _lfTincanLrsContext;
    }

    public void resetOriginalValues() {
        _lfTincanLrsContext.resetOriginalValues();
    }
}

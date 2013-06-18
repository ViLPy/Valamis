package com.arcusys.learn.persistence.liferay.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
* <p>
    * This class is a wrapper for {@link LFActivity}.
    * </p>
*
* @author    Brian Wing Shun Chan
* @see       LFActivity
* @generated
*/
public class LFActivityWrapper implements LFActivity, ModelWrapper<LFActivity> {
    private LFActivity _lfActivity;

    public LFActivityWrapper(LFActivity lfActivity) {
        _lfActivity = lfActivity;
    }

    public Class<?> getModelClass() {
        return LFActivity.class;
    }

    public String getModelClassName() {
        return LFActivity.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("indexNumber", getIndexNumber());
        attributes.put("id", getId());
        attributes.put("packageID", getPackageID());
        attributes.put("organizationID", getOrganizationID());
        attributes.put("parentID", getParentID());
        attributes.put("title", getTitle());
        attributes.put("identifierRef", getIdentifierRef());
        attributes.put("resourceParameters", getResourceParameters());
        attributes.put("hideLMSUI", getHideLMSUI());
        attributes.put("visible", getVisible());
        attributes.put("objectivesGlobalToSystem", getObjectivesGlobalToSystem());
        attributes.put("sharedDataGlobalToSystem", getSharedDataGlobalToSystem());
        attributes.put("masteryScore", getMasteryScore());
        attributes.put("maxTimeAllowed", getMaxTimeAllowed());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long indexNumber = (Long) attributes.get("indexNumber");

        if (indexNumber != null) {
            setIndexNumber(indexNumber);
        }

        String id = (String) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer packageID = (Integer) attributes.get("packageID");

        if (packageID != null) {
            setPackageID(packageID);
        }

        String organizationID = (String) attributes.get("organizationID");

        if (organizationID != null) {
            setOrganizationID(organizationID);
        }

        String parentID = (String) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String identifierRef = (String) attributes.get("identifierRef");

        if (identifierRef != null) {
            setIdentifierRef(identifierRef);
        }

        String resourceParameters = (String) attributes.get(
                "resourceParameters");

        if (resourceParameters != null) {
            setResourceParameters(resourceParameters);
        }

        String hideLMSUI = (String) attributes.get("hideLMSUI");

        if (hideLMSUI != null) {
            setHideLMSUI(hideLMSUI);
        }

        Boolean visible = (Boolean) attributes.get("visible");

        if (visible != null) {
            setVisible(visible);
        }

        Boolean objectivesGlobalToSystem = (Boolean) attributes.get(
                "objectivesGlobalToSystem");

        if (objectivesGlobalToSystem != null) {
            setObjectivesGlobalToSystem(objectivesGlobalToSystem);
        }

        Boolean sharedDataGlobalToSystem = (Boolean) attributes.get(
                "sharedDataGlobalToSystem");

        if (sharedDataGlobalToSystem != null) {
            setSharedDataGlobalToSystem(sharedDataGlobalToSystem);
        }

        String masteryScore = (String) attributes.get("masteryScore");

        if (masteryScore != null) {
            setMasteryScore(masteryScore);
        }

        String maxTimeAllowed = (String) attributes.get("maxTimeAllowed");

        if (maxTimeAllowed != null) {
            setMaxTimeAllowed(maxTimeAllowed);
        }
    }

    /**
     * Returns the primary key of this l f activity.
     *
     * @return the primary key of this l f activity
     */
    public long getPrimaryKey() {
        return _lfActivity.getPrimaryKey();
    }

    /**
     * Sets the primary key of this l f activity.
     *
     * @param primaryKey the primary key of this l f activity
     */
    public void setPrimaryKey(long primaryKey) {
        _lfActivity.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the index number of this l f activity.
     *
     * @return the index number of this l f activity
     */
    public long getIndexNumber() {
        return _lfActivity.getIndexNumber();
    }

    /**
     * Sets the index number of this l f activity.
     *
     * @param indexNumber the index number of this l f activity
     */
    public void setIndexNumber(long indexNumber) {
        _lfActivity.setIndexNumber(indexNumber);
    }

    /**
     * Returns the ID of this l f activity.
     *
     * @return the ID of this l f activity
     */
    public java.lang.String getId() {
        return _lfActivity.getId();
    }

    /**
     * Sets the ID of this l f activity.
     *
     * @param id the ID of this l f activity
     */
    public void setId(java.lang.String id) {
        _lfActivity.setId(id);
    }

    /**
     * Returns the package i d of this l f activity.
     *
     * @return the package i d of this l f activity
     */
    public java.lang.Integer getPackageID() {
        return _lfActivity.getPackageID();
    }

    /**
     * Sets the package i d of this l f activity.
     *
     * @param packageID the package i d of this l f activity
     */
    public void setPackageID(java.lang.Integer packageID) {
        _lfActivity.setPackageID(packageID);
    }

    /**
     * Returns the organization i d of this l f activity.
     *
     * @return the organization i d of this l f activity
     */
    public java.lang.String getOrganizationID() {
        return _lfActivity.getOrganizationID();
    }

    /**
     * Sets the organization i d of this l f activity.
     *
     * @param organizationID the organization i d of this l f activity
     */
    public void setOrganizationID(java.lang.String organizationID) {
        _lfActivity.setOrganizationID(organizationID);
    }

    /**
     * Returns the parent i d of this l f activity.
     *
     * @return the parent i d of this l f activity
     */
    public java.lang.String getParentID() {
        return _lfActivity.getParentID();
    }

    /**
     * Sets the parent i d of this l f activity.
     *
     * @param parentID the parent i d of this l f activity
     */
    public void setParentID(java.lang.String parentID) {
        _lfActivity.setParentID(parentID);
    }

    /**
     * Returns the title of this l f activity.
     *
     * @return the title of this l f activity
     */
    public java.lang.String getTitle() {
        return _lfActivity.getTitle();
    }

    /**
     * Sets the title of this l f activity.
     *
     * @param title the title of this l f activity
     */
    public void setTitle(java.lang.String title) {
        _lfActivity.setTitle(title);
    }

    /**
     * Returns the identifier ref of this l f activity.
     *
     * @return the identifier ref of this l f activity
     */
    public java.lang.String getIdentifierRef() {
        return _lfActivity.getIdentifierRef();
    }

    /**
     * Sets the identifier ref of this l f activity.
     *
     * @param identifierRef the identifier ref of this l f activity
     */
    public void setIdentifierRef(java.lang.String identifierRef) {
        _lfActivity.setIdentifierRef(identifierRef);
    }

    /**
     * Returns the resource parameters of this l f activity.
     *
     * @return the resource parameters of this l f activity
     */
    public java.lang.String getResourceParameters() {
        return _lfActivity.getResourceParameters();
    }

    /**
     * Sets the resource parameters of this l f activity.
     *
     * @param resourceParameters the resource parameters of this l f activity
     */
    public void setResourceParameters(java.lang.String resourceParameters) {
        _lfActivity.setResourceParameters(resourceParameters);
    }

    /**
     * Returns the hide l m s u i of this l f activity.
     *
     * @return the hide l m s u i of this l f activity
     */
    public java.lang.String getHideLMSUI() {
        return _lfActivity.getHideLMSUI();
    }

    /**
     * Sets the hide l m s u i of this l f activity.
     *
     * @param hideLMSUI the hide l m s u i of this l f activity
     */
    public void setHideLMSUI(java.lang.String hideLMSUI) {
        _lfActivity.setHideLMSUI(hideLMSUI);
    }

    /**
     * Returns the visible of this l f activity.
     *
     * @return the visible of this l f activity
     */
    public boolean getVisible() {
        return _lfActivity.getVisible();
    }

    /**
     * Returns <code>true</code> if this l f activity is visible.
     *
     * @return <code>true</code> if this l f activity is visible; <code>false</code> otherwise
     */
    public boolean isVisible() {
        return _lfActivity.isVisible();
    }

    /**
     * Sets whether this l f activity is visible.
     *
     * @param visible the visible of this l f activity
     */
    public void setVisible(boolean visible) {
        _lfActivity.setVisible(visible);
    }

    /**
     * Returns the objectives global to system of this l f activity.
     *
     * @return the objectives global to system of this l f activity
     */
    public boolean getObjectivesGlobalToSystem() {
        return _lfActivity.getObjectivesGlobalToSystem();
    }

    /**
     * Returns <code>true</code> if this l f activity is objectives global to system.
     *
     * @return <code>true</code> if this l f activity is objectives global to system; <code>false</code> otherwise
     */
    public boolean isObjectivesGlobalToSystem() {
        return _lfActivity.isObjectivesGlobalToSystem();
    }

    /**
     * Sets whether this l f activity is objectives global to system.
     *
     * @param objectivesGlobalToSystem the objectives global to system of this l f activity
     */
    public void setObjectivesGlobalToSystem(boolean objectivesGlobalToSystem) {
        _lfActivity.setObjectivesGlobalToSystem(objectivesGlobalToSystem);
    }

    /**
     * Returns the shared data global to system of this l f activity.
     *
     * @return the shared data global to system of this l f activity
     */
    public boolean getSharedDataGlobalToSystem() {
        return _lfActivity.getSharedDataGlobalToSystem();
    }

    /**
     * Returns <code>true</code> if this l f activity is shared data global to system.
     *
     * @return <code>true</code> if this l f activity is shared data global to system; <code>false</code> otherwise
     */
    public boolean isSharedDataGlobalToSystem() {
        return _lfActivity.isSharedDataGlobalToSystem();
    }

    /**
     * Sets whether this l f activity is shared data global to system.
     *
     * @param sharedDataGlobalToSystem the shared data global to system of this l f activity
     */
    public void setSharedDataGlobalToSystem(boolean sharedDataGlobalToSystem) {
        _lfActivity.setSharedDataGlobalToSystem(sharedDataGlobalToSystem);
    }

    /**
     * Returns the mastery score of this l f activity.
     *
     * @return the mastery score of this l f activity
     */
    public java.lang.String getMasteryScore() {
        return _lfActivity.getMasteryScore();
    }

    /**
     * Sets the mastery score of this l f activity.
     *
     * @param masteryScore the mastery score of this l f activity
     */
    public void setMasteryScore(java.lang.String masteryScore) {
        _lfActivity.setMasteryScore(masteryScore);
    }

    /**
     * Returns the max time allowed of this l f activity.
     *
     * @return the max time allowed of this l f activity
     */
    public java.lang.String getMaxTimeAllowed() {
        return _lfActivity.getMaxTimeAllowed();
    }

    /**
     * Sets the max time allowed of this l f activity.
     *
     * @param maxTimeAllowed the max time allowed of this l f activity
     */
    public void setMaxTimeAllowed(java.lang.String maxTimeAllowed) {
        _lfActivity.setMaxTimeAllowed(maxTimeAllowed);
    }

    public boolean isNew() {
        return _lfActivity.isNew();
    }

    public void setNew(boolean n) {
        _lfActivity.setNew(n);
    }

    public boolean isCachedModel() {
        return _lfActivity.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _lfActivity.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _lfActivity.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _lfActivity.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _lfActivity.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _lfActivity.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _lfActivity.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LFActivityWrapper((LFActivity) _lfActivity.clone());
    }

    public int compareTo(LFActivity lfActivity) {
        return _lfActivity.compareTo(lfActivity);
    }

    @Override
    public int hashCode() {
        return _lfActivity.hashCode();
    }

    public com.liferay.portal.model.CacheModel<LFActivity> toCacheModel() {
        return _lfActivity.toCacheModel();
    }

    public LFActivity toEscapedModel() {
        return new LFActivityWrapper(_lfActivity.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _lfActivity.toString();
    }

    public java.lang.String toXmlString() {
        return _lfActivity.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _lfActivity.persist();
    }

    /**
    * @deprecated Renamed to {@link #getWrappedModel}
    */
    public LFActivity getWrappedLFActivity() {
        return _lfActivity;
    }

    public LFActivity getWrappedModel() {
        return _lfActivity;
    }

    public void resetOriginalValues() {
        _lfActivity.resetOriginalValues();
    }
}

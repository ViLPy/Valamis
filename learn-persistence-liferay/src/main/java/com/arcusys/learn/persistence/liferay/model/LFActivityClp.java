package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFActivityClp extends BaseModelImpl<LFActivity>
    implements LFActivity {
    private long _indexNumber;
    private String _id;
    private Integer _packageID;
    private String _organizationID;
    private String _parentID;
    private String _title;
    private String _identifierRef;
    private String _resourceParameters;
    private String _hideLMSUI;
    private boolean _visible;
    private boolean _objectivesGlobalToSystem;
    private boolean _sharedDataGlobalToSystem;
    private String _masteryScore;
    private String _maxTimeAllowed;
    private BaseModel<?> _lfActivityRemoteModel;

    public LFActivityClp() {
    }

    public Class<?> getModelClass() {
        return LFActivity.class;
    }

    public String getModelClassName() {
        return LFActivity.class.getName();
    }

    public long getPrimaryKey() {
        return _indexNumber;
    }

    public void setPrimaryKey(long primaryKey) {
        setIndexNumber(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_indexNumber);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getIndexNumber() {
        return _indexNumber;
    }

    public void setIndexNumber(long indexNumber) {
        _indexNumber = indexNumber;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Integer getPackageID() {
        return _packageID;
    }

    public void setPackageID(Integer packageID) {
        _packageID = packageID;
    }

    public String getOrganizationID() {
        return _organizationID;
    }

    public void setOrganizationID(String organizationID) {
        _organizationID = organizationID;
    }

    public String getParentID() {
        return _parentID;
    }

    public void setParentID(String parentID) {
        _parentID = parentID;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getIdentifierRef() {
        return _identifierRef;
    }

    public void setIdentifierRef(String identifierRef) {
        _identifierRef = identifierRef;
    }

    public String getResourceParameters() {
        return _resourceParameters;
    }

    public void setResourceParameters(String resourceParameters) {
        _resourceParameters = resourceParameters;
    }

    public String getHideLMSUI() {
        return _hideLMSUI;
    }

    public void setHideLMSUI(String hideLMSUI) {
        _hideLMSUI = hideLMSUI;
    }

    public boolean getVisible() {
        return _visible;
    }

    public boolean isVisible() {
        return _visible;
    }

    public void setVisible(boolean visible) {
        _visible = visible;
    }

    public boolean getObjectivesGlobalToSystem() {
        return _objectivesGlobalToSystem;
    }

    public boolean isObjectivesGlobalToSystem() {
        return _objectivesGlobalToSystem;
    }

    public void setObjectivesGlobalToSystem(boolean objectivesGlobalToSystem) {
        _objectivesGlobalToSystem = objectivesGlobalToSystem;
    }

    public boolean getSharedDataGlobalToSystem() {
        return _sharedDataGlobalToSystem;
    }

    public boolean isSharedDataGlobalToSystem() {
        return _sharedDataGlobalToSystem;
    }

    public void setSharedDataGlobalToSystem(boolean sharedDataGlobalToSystem) {
        _sharedDataGlobalToSystem = sharedDataGlobalToSystem;
    }

    public String getMasteryScore() {
        return _masteryScore;
    }

    public void setMasteryScore(String masteryScore) {
        _masteryScore = masteryScore;
    }

    public String getMaxTimeAllowed() {
        return _maxTimeAllowed;
    }

    public void setMaxTimeAllowed(String maxTimeAllowed) {
        _maxTimeAllowed = maxTimeAllowed;
    }

    public BaseModel<?> getLFActivityRemoteModel() {
        return _lfActivityRemoteModel;
    }

    public void setLFActivityRemoteModel(BaseModel<?> lfActivityRemoteModel) {
        _lfActivityRemoteModel = lfActivityRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityLocalServiceUtil.addLFActivity(this);
        } else {
            LFActivityLocalServiceUtil.updateLFActivity(this);
        }
    }

    @Override
    public LFActivity toEscapedModel() {
        return (LFActivity) Proxy.newProxyInstance(LFActivity.class.getClassLoader(),
            new Class[] { LFActivity.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFActivityClp clone = new LFActivityClp();

        clone.setIndexNumber(getIndexNumber());
        clone.setId(getId());
        clone.setPackageID(getPackageID());
        clone.setOrganizationID(getOrganizationID());
        clone.setParentID(getParentID());
        clone.setTitle(getTitle());
        clone.setIdentifierRef(getIdentifierRef());
        clone.setResourceParameters(getResourceParameters());
        clone.setHideLMSUI(getHideLMSUI());
        clone.setVisible(getVisible());
        clone.setObjectivesGlobalToSystem(getObjectivesGlobalToSystem());
        clone.setSharedDataGlobalToSystem(getSharedDataGlobalToSystem());
        clone.setMasteryScore(getMasteryScore());
        clone.setMaxTimeAllowed(getMaxTimeAllowed());

        return clone;
    }

    public int compareTo(LFActivity lfActivity) {
        long primaryKey = lfActivity.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFActivityClp lfActivity = null;

        try {
            lfActivity = (LFActivityClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfActivity.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{indexNumber=");
        sb.append(getIndexNumber());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", organizationID=");
        sb.append(getOrganizationID());
        sb.append(", parentID=");
        sb.append(getParentID());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", identifierRef=");
        sb.append(getIdentifierRef());
        sb.append(", resourceParameters=");
        sb.append(getResourceParameters());
        sb.append(", hideLMSUI=");
        sb.append(getHideLMSUI());
        sb.append(", visible=");
        sb.append(getVisible());
        sb.append(", objectivesGlobalToSystem=");
        sb.append(getObjectivesGlobalToSystem());
        sb.append(", sharedDataGlobalToSystem=");
        sb.append(getSharedDataGlobalToSystem());
        sb.append(", masteryScore=");
        sb.append(getMasteryScore());
        sb.append(", maxTimeAllowed=");
        sb.append(getMaxTimeAllowed());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFActivity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>indexNumber</column-name><column-value><![CDATA[");
        sb.append(getIndexNumber());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>organizationID</column-name><column-value><![CDATA[");
        sb.append(getOrganizationID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentID</column-name><column-value><![CDATA[");
        sb.append(getParentID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>identifierRef</column-name><column-value><![CDATA[");
        sb.append(getIdentifierRef());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourceParameters</column-name><column-value><![CDATA[");
        sb.append(getResourceParameters());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hideLMSUI</column-name><column-value><![CDATA[");
        sb.append(getHideLMSUI());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>visible</column-name><column-value><![CDATA[");
        sb.append(getVisible());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectivesGlobalToSystem</column-name><column-value><![CDATA[");
        sb.append(getObjectivesGlobalToSystem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sharedDataGlobalToSystem</column-name><column-value><![CDATA[");
        sb.append(getSharedDataGlobalToSystem());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>masteryScore</column-name><column-value><![CDATA[");
        sb.append(getMasteryScore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maxTimeAllowed</column-name><column-value><![CDATA[");
        sb.append(getMaxTimeAllowed());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

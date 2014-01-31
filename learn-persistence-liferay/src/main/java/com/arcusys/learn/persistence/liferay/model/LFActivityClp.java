package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

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

    @Override
    public Class<?> getModelClass() {
        return LFActivity.class;
    }

    @Override
    public String getModelClassName() {
        return LFActivity.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _indexNumber;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setIndexNumber(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _indexNumber;
    }

    @Override
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

    @Override
    public long getIndexNumber() {
        return _indexNumber;
    }

    @Override
    public void setIndexNumber(long indexNumber) {
        _indexNumber = indexNumber;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setIndexNumber", long.class);

                method.invoke(_lfActivityRemoteModel, indexNumber);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getId() {
        return _id;
    }

    @Override
    public void setId(String id) {
        _id = id;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setId", String.class);

                method.invoke(_lfActivityRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getPackageID() {
        return _packageID;
    }

    @Override
    public void setPackageID(Integer packageID) {
        _packageID = packageID;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Integer.class);

                method.invoke(_lfActivityRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOrganizationID() {
        return _organizationID;
    }

    @Override
    public void setOrganizationID(String organizationID) {
        _organizationID = organizationID;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setOrganizationID",
                        String.class);

                method.invoke(_lfActivityRemoteModel, organizationID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getParentID() {
        return _parentID;
    }

    @Override
    public void setParentID(String parentID) {
        _parentID = parentID;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setParentID", String.class);

                method.invoke(_lfActivityRemoteModel, parentID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfActivityRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIdentifierRef() {
        return _identifierRef;
    }

    @Override
    public void setIdentifierRef(String identifierRef) {
        _identifierRef = identifierRef;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setIdentifierRef", String.class);

                method.invoke(_lfActivityRemoteModel, identifierRef);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResourceParameters() {
        return _resourceParameters;
    }

    @Override
    public void setResourceParameters(String resourceParameters) {
        _resourceParameters = resourceParameters;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setResourceParameters",
                        String.class);

                method.invoke(_lfActivityRemoteModel, resourceParameters);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getHideLMSUI() {
        return _hideLMSUI;
    }

    @Override
    public void setHideLMSUI(String hideLMSUI) {
        _hideLMSUI = hideLMSUI;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setHideLMSUI", String.class);

                method.invoke(_lfActivityRemoteModel, hideLMSUI);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getVisible() {
        return _visible;
    }

    @Override
    public boolean isVisible() {
        return _visible;
    }

    @Override
    public void setVisible(boolean visible) {
        _visible = visible;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setVisible", boolean.class);

                method.invoke(_lfActivityRemoteModel, visible);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getObjectivesGlobalToSystem() {
        return _objectivesGlobalToSystem;
    }

    @Override
    public boolean isObjectivesGlobalToSystem() {
        return _objectivesGlobalToSystem;
    }

    @Override
    public void setObjectivesGlobalToSystem(boolean objectivesGlobalToSystem) {
        _objectivesGlobalToSystem = objectivesGlobalToSystem;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectivesGlobalToSystem",
                        boolean.class);

                method.invoke(_lfActivityRemoteModel, objectivesGlobalToSystem);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSharedDataGlobalToSystem() {
        return _sharedDataGlobalToSystem;
    }

    @Override
    public boolean isSharedDataGlobalToSystem() {
        return _sharedDataGlobalToSystem;
    }

    @Override
    public void setSharedDataGlobalToSystem(boolean sharedDataGlobalToSystem) {
        _sharedDataGlobalToSystem = sharedDataGlobalToSystem;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setSharedDataGlobalToSystem",
                        boolean.class);

                method.invoke(_lfActivityRemoteModel, sharedDataGlobalToSystem);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMasteryScore() {
        return _masteryScore;
    }

    @Override
    public void setMasteryScore(String masteryScore) {
        _masteryScore = masteryScore;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setMasteryScore", String.class);

                method.invoke(_lfActivityRemoteModel, masteryScore);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMaxTimeAllowed() {
        return _maxTimeAllowed;
    }

    @Override
    public void setMaxTimeAllowed(String maxTimeAllowed) {
        _maxTimeAllowed = maxTimeAllowed;

        if (_lfActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setMaxTimeAllowed",
                        String.class);

                method.invoke(_lfActivityRemoteModel, maxTimeAllowed);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFActivityRemoteModel() {
        return _lfActivityRemoteModel;
    }

    public void setLFActivityRemoteModel(BaseModel<?> lfActivityRemoteModel) {
        _lfActivityRemoteModel = lfActivityRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _lfActivityRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_lfActivityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFActivityLocalServiceUtil.addLFActivity(this);
        } else {
            LFActivityLocalServiceUtil.updateLFActivity(this);
        }
    }

    @Override
    public LFActivity toEscapedModel() {
        return (LFActivity) ProxyUtil.newProxyInstance(LFActivity.class.getClassLoader(),
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

    @Override
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFActivityClp)) {
            return false;
        }

        LFActivityClp lfActivity = (LFActivityClp) obj;

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

    @Override
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

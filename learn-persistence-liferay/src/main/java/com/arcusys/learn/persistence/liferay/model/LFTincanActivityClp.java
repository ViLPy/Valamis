package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil;

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


public class LFTincanActivityClp extends BaseModelImpl<LFTincanActivity>
    implements LFTincanActivity {
    private long _id;
    private String _tincanID;
    private Long _packageID;
    private String _objectType;
    private String _name;
    private String _description;
    private String _theType;
    private String _moreInfo;
    private String _interactionType;
    private String _correctResponsesPattern;
    private String _choices;
    private String _scale;
    private String _source;
    private String _target;
    private String _steps;
    private String _extensions;
    private BaseModel<?> _lfTincanActivityRemoteModel;

    public LFTincanActivityClp() {
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
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanActivityRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTincanID() {
        return _tincanID;
    }

    @Override
    public void setTincanID(String tincanID) {
        _tincanID = tincanID;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setTincanID", String.class);

                method.invoke(_lfTincanActivityRemoteModel, tincanID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getPackageID() {
        return _packageID;
    }

    @Override
    public void setPackageID(Long packageID) {
        _packageID = packageID;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Long.class);

                method.invoke(_lfTincanActivityRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjectType() {
        return _objectType;
    }

    @Override
    public void setObjectType(String objectType) {
        _objectType = objectType;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setObjectType", String.class);

                method.invoke(_lfTincanActivityRemoteModel, objectType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_lfTincanActivityRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfTincanActivityRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTheType() {
        return _theType;
    }

    @Override
    public void setTheType(String theType) {
        _theType = theType;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setTheType", String.class);

                method.invoke(_lfTincanActivityRemoteModel, theType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMoreInfo() {
        return _moreInfo;
    }

    @Override
    public void setMoreInfo(String moreInfo) {
        _moreInfo = moreInfo;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setMoreInfo", String.class);

                method.invoke(_lfTincanActivityRemoteModel, moreInfo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInteractionType() {
        return _interactionType;
    }

    @Override
    public void setInteractionType(String interactionType) {
        _interactionType = interactionType;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setInteractionType",
                        String.class);

                method.invoke(_lfTincanActivityRemoteModel, interactionType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCorrectResponsesPattern() {
        return _correctResponsesPattern;
    }

    @Override
    public void setCorrectResponsesPattern(String correctResponsesPattern) {
        _correctResponsesPattern = correctResponsesPattern;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setCorrectResponsesPattern",
                        String.class);

                method.invoke(_lfTincanActivityRemoteModel,
                    correctResponsesPattern);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChoices() {
        return _choices;
    }

    @Override
    public void setChoices(String choices) {
        _choices = choices;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setChoices", String.class);

                method.invoke(_lfTincanActivityRemoteModel, choices);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getScale() {
        return _scale;
    }

    @Override
    public void setScale(String scale) {
        _scale = scale;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setScale", String.class);

                method.invoke(_lfTincanActivityRemoteModel, scale);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSource() {
        return _source;
    }

    @Override
    public void setSource(String source) {
        _source = source;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setSource", String.class);

                method.invoke(_lfTincanActivityRemoteModel, source);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTarget() {
        return _target;
    }

    @Override
    public void setTarget(String target) {
        _target = target;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setTarget", String.class);

                method.invoke(_lfTincanActivityRemoteModel, target);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSteps() {
        return _steps;
    }

    @Override
    public void setSteps(String steps) {
        _steps = steps;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setSteps", String.class);

                method.invoke(_lfTincanActivityRemoteModel, steps);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getExtensions() {
        return _extensions;
    }

    @Override
    public void setExtensions(String extensions) {
        _extensions = extensions;

        if (_lfTincanActivityRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanActivityRemoteModel.getClass();

                Method method = clazz.getMethod("setExtensions", String.class);

                method.invoke(_lfTincanActivityRemoteModel, extensions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanActivityRemoteModel() {
        return _lfTincanActivityRemoteModel;
    }

    public void setLFTincanActivityRemoteModel(
        BaseModel<?> lfTincanActivityRemoteModel) {
        _lfTincanActivityRemoteModel = lfTincanActivityRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanActivityRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanActivityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanActivityLocalServiceUtil.addLFTincanActivity(this);
        } else {
            LFTincanActivityLocalServiceUtil.updateLFTincanActivity(this);
        }
    }

    @Override
    public LFTincanActivity toEscapedModel() {
        return (LFTincanActivity) ProxyUtil.newProxyInstance(LFTincanActivity.class.getClassLoader(),
            new Class[] { LFTincanActivity.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanActivityClp clone = new LFTincanActivityClp();

        clone.setId(getId());
        clone.setTincanID(getTincanID());
        clone.setPackageID(getPackageID());
        clone.setObjectType(getObjectType());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setTheType(getTheType());
        clone.setMoreInfo(getMoreInfo());
        clone.setInteractionType(getInteractionType());
        clone.setCorrectResponsesPattern(getCorrectResponsesPattern());
        clone.setChoices(getChoices());
        clone.setScale(getScale());
        clone.setSource(getSource());
        clone.setTarget(getTarget());
        clone.setSteps(getSteps());
        clone.setExtensions(getExtensions());

        return clone;
    }

    @Override
    public int compareTo(LFTincanActivity lfTincanActivity) {
        long primaryKey = lfTincanActivity.getPrimaryKey();

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

        if (!(obj instanceof LFTincanActivityClp)) {
            return false;
        }

        LFTincanActivityClp lfTincanActivity = (LFTincanActivityClp) obj;

        long primaryKey = lfTincanActivity.getPrimaryKey();

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
        StringBundler sb = new StringBundler(33);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", tincanID=");
        sb.append(getTincanID());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", objectType=");
        sb.append(getObjectType());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", theType=");
        sb.append(getTheType());
        sb.append(", moreInfo=");
        sb.append(getMoreInfo());
        sb.append(", interactionType=");
        sb.append(getInteractionType());
        sb.append(", correctResponsesPattern=");
        sb.append(getCorrectResponsesPattern());
        sb.append(", choices=");
        sb.append(getChoices());
        sb.append(", scale=");
        sb.append(getScale());
        sb.append(", source=");
        sb.append(getSource());
        sb.append(", target=");
        sb.append(getTarget());
        sb.append(", steps=");
        sb.append(getSteps());
        sb.append(", extensions=");
        sb.append(getExtensions());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(52);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanActivity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tincanID</column-name><column-value><![CDATA[");
        sb.append(getTincanID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>packageID</column-name><column-value><![CDATA[");
        sb.append(getPackageID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objectType</column-name><column-value><![CDATA[");
        sb.append(getObjectType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>theType</column-name><column-value><![CDATA[");
        sb.append(getTheType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>moreInfo</column-name><column-value><![CDATA[");
        sb.append(getMoreInfo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>interactionType</column-name><column-value><![CDATA[");
        sb.append(getInteractionType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>correctResponsesPattern</column-name><column-value><![CDATA[");
        sb.append(getCorrectResponsesPattern());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>choices</column-name><column-value><![CDATA[");
        sb.append(getChoices());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>scale</column-name><column-value><![CDATA[");
        sb.append(getScale());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>source</column-name><column-value><![CDATA[");
        sb.append(getSource());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>target</column-name><column-value><![CDATA[");
        sb.append(getTarget());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>steps</column-name><column-value><![CDATA[");
        sb.append(getSteps());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>extensions</column-name><column-value><![CDATA[");
        sb.append(getExtensions());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

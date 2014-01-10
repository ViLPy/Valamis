package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanActivityLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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

    public Class<?> getModelClass() {
        return LFTincanActivity.class;
    }

    public String getModelClassName() {
        return LFTincanActivity.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

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

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getTincanID() {
        return _tincanID;
    }

    public void setTincanID(String tincanID) {
        _tincanID = tincanID;
    }

    public Long getPackageID() {
        return _packageID;
    }

    public void setPackageID(Long packageID) {
        _packageID = packageID;
    }

    public String getObjectType() {
        return _objectType;
    }

    public void setObjectType(String objectType) {
        _objectType = objectType;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getTheType() {
        return _theType;
    }

    public void setTheType(String theType) {
        _theType = theType;
    }

    public String getMoreInfo() {
        return _moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        _moreInfo = moreInfo;
    }

    public String getInteractionType() {
        return _interactionType;
    }

    public void setInteractionType(String interactionType) {
        _interactionType = interactionType;
    }

    public String getCorrectResponsesPattern() {
        return _correctResponsesPattern;
    }

    public void setCorrectResponsesPattern(String correctResponsesPattern) {
        _correctResponsesPattern = correctResponsesPattern;
    }

    public String getChoices() {
        return _choices;
    }

    public void setChoices(String choices) {
        _choices = choices;
    }

    public String getScale() {
        return _scale;
    }

    public void setScale(String scale) {
        _scale = scale;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getTarget() {
        return _target;
    }

    public void setTarget(String target) {
        _target = target;
    }

    public String getSteps() {
        return _steps;
    }

    public void setSteps(String steps) {
        _steps = steps;
    }

    public String getExtensions() {
        return _extensions;
    }

    public void setExtensions(String extensions) {
        _extensions = extensions;
    }

    public BaseModel<?> getLFTincanActivityRemoteModel() {
        return _lfTincanActivityRemoteModel;
    }

    public void setLFTincanActivityRemoteModel(
        BaseModel<?> lfTincanActivityRemoteModel) {
        _lfTincanActivityRemoteModel = lfTincanActivityRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanActivityLocalServiceUtil.addLFTincanActivity(this);
        } else {
            LFTincanActivityLocalServiceUtil.updateLFTincanActivity(this);
        }
    }

    @Override
    public LFTincanActivity toEscapedModel() {
        return (LFTincanActivity) Proxy.newProxyInstance(LFTincanActivity.class.getClassLoader(),
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
        if (obj == null) {
            return false;
        }

        LFTincanActivityClp lfTincanActivity = null;

        try {
            lfTincanActivity = (LFTincanActivityClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanManifestActLocalServiceUtil;

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


public class LFTincanManifestActClp extends BaseModelImpl<LFTincanManifestAct>
    implements LFTincanManifestAct {
    private long _id;
    private String _tincanID;
    private Long _packageID;
    private String _activityType;
    private String _name;
    private String _description;
    private String _launch;
    private String _resourceID;
    private BaseModel<?> _lfTincanManifestActRemoteModel;

    public LFTincanManifestActClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFTincanManifestAct.class;
    }

    @Override
    public String getModelClassName() {
        return LFTincanManifestAct.class.getName();
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
        attributes.put("activityType", getActivityType());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("launch", getLaunch());
        attributes.put("resourceID", getResourceID());

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

        String activityType = (String) attributes.get("activityType");

        if (activityType != null) {
            setActivityType(activityType);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String launch = (String) attributes.get("launch");

        if (launch != null) {
            setLaunch(launch);
        }

        String resourceID = (String) attributes.get("resourceID");

        if (resourceID != null) {
            setResourceID(resourceID);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfTincanManifestActRemoteModel, id);
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

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setTincanID", String.class);

                method.invoke(_lfTincanManifestActRemoteModel, tincanID);
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

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setPackageID", Long.class);

                method.invoke(_lfTincanManifestActRemoteModel, packageID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActivityType() {
        return _activityType;
    }

    @Override
    public void setActivityType(String activityType) {
        _activityType = activityType;

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setActivityType", String.class);

                method.invoke(_lfTincanManifestActRemoteModel, activityType);
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

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_lfTincanManifestActRemoteModel, name);
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

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfTincanManifestActRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLaunch() {
        return _launch;
    }

    @Override
    public void setLaunch(String launch) {
        _launch = launch;

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setLaunch", String.class);

                method.invoke(_lfTincanManifestActRemoteModel, launch);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResourceID() {
        return _resourceID;
    }

    @Override
    public void setResourceID(String resourceID) {
        _resourceID = resourceID;

        if (_lfTincanManifestActRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanManifestActRemoteModel.getClass();

                Method method = clazz.getMethod("setResourceID", String.class);

                method.invoke(_lfTincanManifestActRemoteModel, resourceID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanManifestActRemoteModel() {
        return _lfTincanManifestActRemoteModel;
    }

    public void setLFTincanManifestActRemoteModel(
        BaseModel<?> lfTincanManifestActRemoteModel) {
        _lfTincanManifestActRemoteModel = lfTincanManifestActRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanManifestActRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanManifestActRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanManifestActLocalServiceUtil.addLFTincanManifestAct(this);
        } else {
            LFTincanManifestActLocalServiceUtil.updateLFTincanManifestAct(this);
        }
    }

    @Override
    public LFTincanManifestAct toEscapedModel() {
        return (LFTincanManifestAct) ProxyUtil.newProxyInstance(LFTincanManifestAct.class.getClassLoader(),
            new Class[] { LFTincanManifestAct.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanManifestActClp clone = new LFTincanManifestActClp();

        clone.setId(getId());
        clone.setTincanID(getTincanID());
        clone.setPackageID(getPackageID());
        clone.setActivityType(getActivityType());
        clone.setName(getName());
        clone.setDescription(getDescription());
        clone.setLaunch(getLaunch());
        clone.setResourceID(getResourceID());

        return clone;
    }

    @Override
    public int compareTo(LFTincanManifestAct lfTincanManifestAct) {
        long primaryKey = lfTincanManifestAct.getPrimaryKey();

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

        if (!(obj instanceof LFTincanManifestActClp)) {
            return false;
        }

        LFTincanManifestActClp lfTincanManifestAct = (LFTincanManifestActClp) obj;

        long primaryKey = lfTincanManifestAct.getPrimaryKey();

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
        StringBundler sb = new StringBundler(17);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", tincanID=");
        sb.append(getTincanID());
        sb.append(", packageID=");
        sb.append(getPackageID());
        sb.append(", activityType=");
        sb.append(getActivityType());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", launch=");
        sb.append(getLaunch());
        sb.append(", resourceID=");
        sb.append(getResourceID());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanManifestAct");
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
            "<column><column-name>activityType</column-name><column-value><![CDATA[");
        sb.append(getActivityType());
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
            "<column><column-name>launch</column-name><column-value><![CDATA[");
        sb.append(getLaunch());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resourceID</column-name><column-value><![CDATA[");
        sb.append(getResourceID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFTincanURILocalServiceUtil;

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


public class LFTincanURIClp extends BaseModelImpl<LFTincanURI>
    implements LFTincanURI {
    private String _uri;
    private String _objID;
    private String _objType;
    private String _content;
    private BaseModel<?> _lfTincanURIRemoteModel;

    public LFTincanURIClp() {
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
    public String getPrimaryKey() {
        return _uri;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setUri(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _uri;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
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

    @Override
    public String getUri() {
        return _uri;
    }

    @Override
    public void setUri(String uri) {
        _uri = uri;

        if (_lfTincanURIRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanURIRemoteModel.getClass();

                Method method = clazz.getMethod("setUri", String.class);

                method.invoke(_lfTincanURIRemoteModel, uri);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjID() {
        return _objID;
    }

    @Override
    public void setObjID(String objID) {
        _objID = objID;

        if (_lfTincanURIRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanURIRemoteModel.getClass();

                Method method = clazz.getMethod("setObjID", String.class);

                method.invoke(_lfTincanURIRemoteModel, objID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getObjType() {
        return _objType;
    }

    @Override
    public void setObjType(String objType) {
        _objType = objType;

        if (_lfTincanURIRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanURIRemoteModel.getClass();

                Method method = clazz.getMethod("setObjType", String.class);

                method.invoke(_lfTincanURIRemoteModel, objType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContent() {
        return _content;
    }

    @Override
    public void setContent(String content) {
        _content = content;

        if (_lfTincanURIRemoteModel != null) {
            try {
                Class<?> clazz = _lfTincanURIRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_lfTincanURIRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFTincanURIRemoteModel() {
        return _lfTincanURIRemoteModel;
    }

    public void setLFTincanURIRemoteModel(BaseModel<?> lfTincanURIRemoteModel) {
        _lfTincanURIRemoteModel = lfTincanURIRemoteModel;
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

        Class<?> remoteModelClass = _lfTincanURIRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfTincanURIRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanURILocalServiceUtil.addLFTincanURI(this);
        } else {
            LFTincanURILocalServiceUtil.updateLFTincanURI(this);
        }
    }

    @Override
    public LFTincanURI toEscapedModel() {
        return (LFTincanURI) ProxyUtil.newProxyInstance(LFTincanURI.class.getClassLoader(),
            new Class[] { LFTincanURI.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanURIClp clone = new LFTincanURIClp();

        clone.setUri(getUri());
        clone.setObjID(getObjID());
        clone.setObjType(getObjType());
        clone.setContent(getContent());

        return clone;
    }

    @Override
    public int compareTo(LFTincanURI lfTincanURI) {
        String primaryKey = lfTincanURI.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LFTincanURIClp)) {
            return false;
        }

        LFTincanURIClp lfTincanURI = (LFTincanURIClp) obj;

        String primaryKey = lfTincanURI.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{uri=");
        sb.append(getUri());
        sb.append(", objID=");
        sb.append(getObjID());
        sb.append(", objType=");
        sb.append(getObjType());
        sb.append(", content=");
        sb.append(getContent());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFTincanURI");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uri</column-name><column-value><![CDATA[");
        sb.append(getUri());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objID</column-name><column-value><![CDATA[");
        sb.append(getObjID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objType</column-name><column-value><![CDATA[");
        sb.append(getObjType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

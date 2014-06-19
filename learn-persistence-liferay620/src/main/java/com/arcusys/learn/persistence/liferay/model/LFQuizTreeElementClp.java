package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFQuizTreeElementLocalServiceUtil;

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


public class LFQuizTreeElementClp extends BaseModelImpl<LFQuizTreeElement>
    implements LFQuizTreeElement {
    private long _id;
    private Integer _quizID;
    private String _elementID;
    private Boolean _isCategory;
    private String _parentID;
    private Integer _arrangementIndex;
    private BaseModel<?> _lfQuizTreeElementRemoteModel;

    public LFQuizTreeElementClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizTreeElement.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizTreeElement.class.getName();
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
        attributes.put("quizID", getQuizID());
        attributes.put("elementID", getElementID());
        attributes.put("isCategory", getIsCategory());
        attributes.put("parentID", getParentID());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer quizID = (Integer) attributes.get("quizID");

        if (quizID != null) {
            setQuizID(quizID);
        }

        String elementID = (String) attributes.get("elementID");

        if (elementID != null) {
            setElementID(elementID);
        }

        Boolean isCategory = (Boolean) attributes.get("isCategory");

        if (isCategory != null) {
            setIsCategory(isCategory);
        }

        String parentID = (String) attributes.get("parentID");

        if (parentID != null) {
            setParentID(parentID);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfQuizTreeElementRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizTreeElementRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfQuizTreeElementRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getQuizID() {
        return _quizID;
    }

    @Override
    public void setQuizID(Integer quizID) {
        _quizID = quizID;

        if (_lfQuizTreeElementRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizTreeElementRemoteModel.getClass();

                Method method = clazz.getMethod("setQuizID", Integer.class);

                method.invoke(_lfQuizTreeElementRemoteModel, quizID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getElementID() {
        return _elementID;
    }

    @Override
    public void setElementID(String elementID) {
        _elementID = elementID;

        if (_lfQuizTreeElementRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizTreeElementRemoteModel.getClass();

                Method method = clazz.getMethod("setElementID", String.class);

                method.invoke(_lfQuizTreeElementRemoteModel, elementID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getIsCategory() {
        return _isCategory;
    }

    @Override
    public void setIsCategory(Boolean isCategory) {
        _isCategory = isCategory;

        if (_lfQuizTreeElementRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizTreeElementRemoteModel.getClass();

                Method method = clazz.getMethod("setIsCategory", Boolean.class);

                method.invoke(_lfQuizTreeElementRemoteModel, isCategory);
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

        if (_lfQuizTreeElementRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizTreeElementRemoteModel.getClass();

                Method method = clazz.getMethod("setParentID", String.class);

                method.invoke(_lfQuizTreeElementRemoteModel, parentID);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    @Override
    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;

        if (_lfQuizTreeElementRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizTreeElementRemoteModel.getClass();

                Method method = clazz.getMethod("setArrangementIndex",
                        Integer.class);

                method.invoke(_lfQuizTreeElementRemoteModel, arrangementIndex);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFQuizTreeElementRemoteModel() {
        return _lfQuizTreeElementRemoteModel;
    }

    public void setLFQuizTreeElementRemoteModel(
        BaseModel<?> lfQuizTreeElementRemoteModel) {
        _lfQuizTreeElementRemoteModel = lfQuizTreeElementRemoteModel;
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

        Class<?> remoteModelClass = _lfQuizTreeElementRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfQuizTreeElementRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizTreeElementLocalServiceUtil.addLFQuizTreeElement(this);
        } else {
            LFQuizTreeElementLocalServiceUtil.updateLFQuizTreeElement(this);
        }
    }

    @Override
    public LFQuizTreeElement toEscapedModel() {
        return (LFQuizTreeElement) ProxyUtil.newProxyInstance(LFQuizTreeElement.class.getClassLoader(),
            new Class[] { LFQuizTreeElement.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuizTreeElementClp clone = new LFQuizTreeElementClp();

        clone.setId(getId());
        clone.setQuizID(getQuizID());
        clone.setElementID(getElementID());
        clone.setIsCategory(getIsCategory());
        clone.setParentID(getParentID());
        clone.setArrangementIndex(getArrangementIndex());

        return clone;
    }

    @Override
    public int compareTo(LFQuizTreeElement lfQuizTreeElement) {
        long primaryKey = lfQuizTreeElement.getPrimaryKey();

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

        if (!(obj instanceof LFQuizTreeElementClp)) {
            return false;
        }

        LFQuizTreeElementClp lfQuizTreeElement = (LFQuizTreeElementClp) obj;

        long primaryKey = lfQuizTreeElement.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", quizID=");
        sb.append(getQuizID());
        sb.append(", elementID=");
        sb.append(getElementID());
        sb.append(", isCategory=");
        sb.append(getIsCategory());
        sb.append(", parentID=");
        sb.append(getParentID());
        sb.append(", arrangementIndex=");
        sb.append(getArrangementIndex());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quizID</column-name><column-value><![CDATA[");
        sb.append(getQuizID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>elementID</column-name><column-value><![CDATA[");
        sb.append(getElementID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isCategory</column-name><column-value><![CDATA[");
        sb.append(getIsCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentID</column-name><column-value><![CDATA[");
        sb.append(getParentID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

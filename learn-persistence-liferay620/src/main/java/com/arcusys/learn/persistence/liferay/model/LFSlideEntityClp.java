package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFSlideEntityLocalServiceUtil;

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


public class LFSlideEntityClp extends BaseModelImpl<LFSlideEntity>
    implements LFSlideEntity {
    private long _id;
    private String _top;
    private String _left;
    private String _width;
    private String _height;
    private String _zIndex;
    private String _content;
    private String _entityType;
    private Long _slideId;
    private Long _correctLinkedSlideId;
    private Long _incorrectLinkedSlideId;
    private Boolean _notifyCorrectAnswer;
    private BaseModel<?> _lfSlideEntityRemoteModel;

    public LFSlideEntityClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFSlideEntity.class;
    }

    @Override
    public String getModelClassName() {
        return LFSlideEntity.class.getName();
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
        attributes.put("top", getTop());
        attributes.put("left", getLeft());
        attributes.put("width", getWidth());
        attributes.put("height", getHeight());
        attributes.put("zIndex", getZIndex());
        attributes.put("content", getContent());
        attributes.put("entityType", getEntityType());
        attributes.put("slideId", getSlideId());
        attributes.put("correctLinkedSlideId", getCorrectLinkedSlideId());
        attributes.put("incorrectLinkedSlideId", getIncorrectLinkedSlideId());
        attributes.put("notifyCorrectAnswer", getNotifyCorrectAnswer());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String top = (String) attributes.get("top");

        if (top != null) {
            setTop(top);
        }

        String left = (String) attributes.get("left");

        if (left != null) {
            setLeft(left);
        }

        String width = (String) attributes.get("width");

        if (width != null) {
            setWidth(width);
        }

        String height = (String) attributes.get("height");

        if (height != null) {
            setHeight(height);
        }

        String zIndex = (String) attributes.get("zIndex");

        if (zIndex != null) {
            setZIndex(zIndex);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        String entityType = (String) attributes.get("entityType");

        if (entityType != null) {
            setEntityType(entityType);
        }

        Long slideId = (Long) attributes.get("slideId");

        if (slideId != null) {
            setSlideId(slideId);
        }

        Long correctLinkedSlideId = (Long) attributes.get(
                "correctLinkedSlideId");

        if (correctLinkedSlideId != null) {
            setCorrectLinkedSlideId(correctLinkedSlideId);
        }

        Long incorrectLinkedSlideId = (Long) attributes.get(
                "incorrectLinkedSlideId");

        if (incorrectLinkedSlideId != null) {
            setIncorrectLinkedSlideId(incorrectLinkedSlideId);
        }

        Boolean notifyCorrectAnswer = (Boolean) attributes.get(
                "notifyCorrectAnswer");

        if (notifyCorrectAnswer != null) {
            setNotifyCorrectAnswer(notifyCorrectAnswer);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfSlideEntityRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTop() {
        return _top;
    }

    @Override
    public void setTop(String top) {
        _top = top;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setTop", String.class);

                method.invoke(_lfSlideEntityRemoteModel, top);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLeft() {
        return _left;
    }

    @Override
    public void setLeft(String left) {
        _left = left;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setLeft", String.class);

                method.invoke(_lfSlideEntityRemoteModel, left);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWidth() {
        return _width;
    }

    @Override
    public void setWidth(String width) {
        _width = width;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setWidth", String.class);

                method.invoke(_lfSlideEntityRemoteModel, width);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getHeight() {
        return _height;
    }

    @Override
    public void setHeight(String height) {
        _height = height;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setHeight", String.class);

                method.invoke(_lfSlideEntityRemoteModel, height);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getZIndex() {
        return _zIndex;
    }

    @Override
    public void setZIndex(String zIndex) {
        _zIndex = zIndex;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setZIndex", String.class);

                method.invoke(_lfSlideEntityRemoteModel, zIndex);
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

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_lfSlideEntityRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEntityType() {
        return _entityType;
    }

    @Override
    public void setEntityType(String entityType) {
        _entityType = entityType;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setEntityType", String.class);

                method.invoke(_lfSlideEntityRemoteModel, entityType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getSlideId() {
        return _slideId;
    }

    @Override
    public void setSlideId(Long slideId) {
        _slideId = slideId;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setSlideId", Long.class);

                method.invoke(_lfSlideEntityRemoteModel, slideId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getCorrectLinkedSlideId() {
        return _correctLinkedSlideId;
    }

    @Override
    public void setCorrectLinkedSlideId(Long correctLinkedSlideId) {
        _correctLinkedSlideId = correctLinkedSlideId;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setCorrectLinkedSlideId",
                        Long.class);

                method.invoke(_lfSlideEntityRemoteModel, correctLinkedSlideId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getIncorrectLinkedSlideId() {
        return _incorrectLinkedSlideId;
    }

    @Override
    public void setIncorrectLinkedSlideId(Long incorrectLinkedSlideId) {
        _incorrectLinkedSlideId = incorrectLinkedSlideId;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setIncorrectLinkedSlideId",
                        Long.class);

                method.invoke(_lfSlideEntityRemoteModel, incorrectLinkedSlideId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getNotifyCorrectAnswer() {
        return _notifyCorrectAnswer;
    }

    @Override
    public void setNotifyCorrectAnswer(Boolean notifyCorrectAnswer) {
        _notifyCorrectAnswer = notifyCorrectAnswer;

        if (_lfSlideEntityRemoteModel != null) {
            try {
                Class<?> clazz = _lfSlideEntityRemoteModel.getClass();

                Method method = clazz.getMethod("setNotifyCorrectAnswer",
                        Boolean.class);

                method.invoke(_lfSlideEntityRemoteModel, notifyCorrectAnswer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFSlideEntityRemoteModel() {
        return _lfSlideEntityRemoteModel;
    }

    public void setLFSlideEntityRemoteModel(
        BaseModel<?> lfSlideEntityRemoteModel) {
        _lfSlideEntityRemoteModel = lfSlideEntityRemoteModel;
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

        Class<?> remoteModelClass = _lfSlideEntityRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfSlideEntityRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFSlideEntityLocalServiceUtil.addLFSlideEntity(this);
        } else {
            LFSlideEntityLocalServiceUtil.updateLFSlideEntity(this);
        }
    }

    @Override
    public LFSlideEntity toEscapedModel() {
        return (LFSlideEntity) ProxyUtil.newProxyInstance(LFSlideEntity.class.getClassLoader(),
            new Class[] { LFSlideEntity.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFSlideEntityClp clone = new LFSlideEntityClp();

        clone.setId(getId());
        clone.setTop(getTop());
        clone.setLeft(getLeft());
        clone.setWidth(getWidth());
        clone.setHeight(getHeight());
        clone.setZIndex(getZIndex());
        clone.setContent(getContent());
        clone.setEntityType(getEntityType());
        clone.setSlideId(getSlideId());
        clone.setCorrectLinkedSlideId(getCorrectLinkedSlideId());
        clone.setIncorrectLinkedSlideId(getIncorrectLinkedSlideId());
        clone.setNotifyCorrectAnswer(getNotifyCorrectAnswer());

        return clone;
    }

    @Override
    public int compareTo(LFSlideEntity lfSlideEntity) {
        long primaryKey = lfSlideEntity.getPrimaryKey();

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

        if (!(obj instanceof LFSlideEntityClp)) {
            return false;
        }

        LFSlideEntityClp lfSlideEntity = (LFSlideEntityClp) obj;

        long primaryKey = lfSlideEntity.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", top=");
        sb.append(getTop());
        sb.append(", left=");
        sb.append(getLeft());
        sb.append(", width=");
        sb.append(getWidth());
        sb.append(", height=");
        sb.append(getHeight());
        sb.append(", zIndex=");
        sb.append(getZIndex());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", entityType=");
        sb.append(getEntityType());
        sb.append(", slideId=");
        sb.append(getSlideId());
        sb.append(", correctLinkedSlideId=");
        sb.append(getCorrectLinkedSlideId());
        sb.append(", incorrectLinkedSlideId=");
        sb.append(getIncorrectLinkedSlideId());
        sb.append(", notifyCorrectAnswer=");
        sb.append(getNotifyCorrectAnswer());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFSlideEntity");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>top</column-name><column-value><![CDATA[");
        sb.append(getTop());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>left</column-name><column-value><![CDATA[");
        sb.append(getLeft());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>width</column-name><column-value><![CDATA[");
        sb.append(getWidth());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>height</column-name><column-value><![CDATA[");
        sb.append(getHeight());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>zIndex</column-name><column-value><![CDATA[");
        sb.append(getZIndex());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>entityType</column-name><column-value><![CDATA[");
        sb.append(getEntityType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>slideId</column-name><column-value><![CDATA[");
        sb.append(getSlideId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>correctLinkedSlideId</column-name><column-value><![CDATA[");
        sb.append(getCorrectLinkedSlideId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>incorrectLinkedSlideId</column-name><column-value><![CDATA[");
        sb.append(getIncorrectLinkedSlideId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>notifyCorrectAnswer</column-name><column-value><![CDATA[");
        sb.append(getNotifyCorrectAnswer());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

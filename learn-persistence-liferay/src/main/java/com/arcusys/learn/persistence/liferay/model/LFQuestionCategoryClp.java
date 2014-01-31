package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil;

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


public class LFQuestionCategoryClp extends BaseModelImpl<LFQuestionCategory>
    implements LFQuestionCategory {
    private long _id;
    private String _title;
    private String _description;
    private Integer _parentId;
    private Integer _courseId;
    private Integer _arrangementIndex;
    private BaseModel<?> _lfQuestionCategoryRemoteModel;

    public LFQuestionCategoryClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuestionCategory.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuestionCategory.class.getName();
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
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("parentId", getParentId());
        attributes.put("courseId", getCourseId());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer parentId = (Integer) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        Integer courseId = (Integer) attributes.get("courseId");

        if (courseId != null) {
            setCourseId(courseId);
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

        if (_lfQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfQuestionCategoryRemoteModel, id);
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

        if (_lfQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfQuestionCategoryRemoteModel, title);
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

        if (_lfQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfQuestionCategoryRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getParentId() {
        return _parentId;
    }

    @Override
    public void setParentId(Integer parentId) {
        _parentId = parentId;

        if (_lfQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setParentId", Integer.class);

                method.invoke(_lfQuestionCategoryRemoteModel, parentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getCourseId() {
        return _courseId;
    }

    @Override
    public void setCourseId(Integer courseId) {
        _courseId = courseId;

        if (_lfQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseId", Integer.class);

                method.invoke(_lfQuestionCategoryRemoteModel, courseId);
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

        if (_lfQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setArrangementIndex",
                        Integer.class);

                method.invoke(_lfQuestionCategoryRemoteModel, arrangementIndex);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFQuestionCategoryRemoteModel() {
        return _lfQuestionCategoryRemoteModel;
    }

    public void setLFQuestionCategoryRemoteModel(
        BaseModel<?> lfQuestionCategoryRemoteModel) {
        _lfQuestionCategoryRemoteModel = lfQuestionCategoryRemoteModel;
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

        Class<?> remoteModelClass = _lfQuestionCategoryRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfQuestionCategoryRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuestionCategoryLocalServiceUtil.addLFQuestionCategory(this);
        } else {
            LFQuestionCategoryLocalServiceUtil.updateLFQuestionCategory(this);
        }
    }

    @Override
    public LFQuestionCategory toEscapedModel() {
        return (LFQuestionCategory) ProxyUtil.newProxyInstance(LFQuestionCategory.class.getClassLoader(),
            new Class[] { LFQuestionCategory.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuestionCategoryClp clone = new LFQuestionCategoryClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setParentId(getParentId());
        clone.setCourseId(getCourseId());
        clone.setArrangementIndex(getArrangementIndex());

        return clone;
    }

    @Override
    public int compareTo(LFQuestionCategory lfQuestionCategory) {
        long primaryKey = lfQuestionCategory.getPrimaryKey();

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

        if (!(obj instanceof LFQuestionCategoryClp)) {
            return false;
        }

        LFQuestionCategoryClp lfQuestionCategory = (LFQuestionCategoryClp) obj;

        long primaryKey = lfQuestionCategory.getPrimaryKey();

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
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", parentId=");
        sb.append(getParentId());
        sb.append(", courseId=");
        sb.append(getCourseId());
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
            "com.arcusys.learn.persistence.liferay.model.LFQuestionCategory");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseId</column-name><column-value><![CDATA[");
        sb.append(getCourseId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

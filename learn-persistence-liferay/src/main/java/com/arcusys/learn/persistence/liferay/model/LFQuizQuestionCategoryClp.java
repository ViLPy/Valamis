package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalServiceUtil;

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


public class LFQuizQuestionCategoryClp extends BaseModelImpl<LFQuizQuestionCategory>
    implements LFQuizQuestionCategory {
    private long _id;
    private String _title;
    private String _description;
    private Integer _quizId;
    private Integer _parentId;
    private Integer _arrangementIndex;
    private BaseModel<?> _lfQuizQuestionCategoryRemoteModel;

    public LFQuizQuestionCategoryClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizQuestionCategory.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizQuestionCategory.class.getName();
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
        attributes.put("quizId", getQuizId());
        attributes.put("parentId", getParentId());
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

        Integer quizId = (Integer) attributes.get("quizId");

        if (quizId != null) {
            setQuizId(quizId);
        }

        Integer parentId = (Integer) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
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

        if (_lfQuizQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfQuizQuestionCategoryRemoteModel, id);
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

        if (_lfQuizQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfQuizQuestionCategoryRemoteModel, title);
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

        if (_lfQuizQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_lfQuizQuestionCategoryRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getQuizId() {
        return _quizId;
    }

    @Override
    public void setQuizId(Integer quizId) {
        _quizId = quizId;

        if (_lfQuizQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setQuizId", Integer.class);

                method.invoke(_lfQuizQuestionCategoryRemoteModel, quizId);
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

        if (_lfQuizQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setParentId", Integer.class);

                method.invoke(_lfQuizQuestionCategoryRemoteModel, parentId);
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

        if (_lfQuizQuestionCategoryRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionCategoryRemoteModel.getClass();

                Method method = clazz.getMethod("setArrangementIndex",
                        Integer.class);

                method.invoke(_lfQuizQuestionCategoryRemoteModel,
                    arrangementIndex);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFQuizQuestionCategoryRemoteModel() {
        return _lfQuizQuestionCategoryRemoteModel;
    }

    public void setLFQuizQuestionCategoryRemoteModel(
        BaseModel<?> lfQuizQuestionCategoryRemoteModel) {
        _lfQuizQuestionCategoryRemoteModel = lfQuizQuestionCategoryRemoteModel;
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

        Class<?> remoteModelClass = _lfQuizQuestionCategoryRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfQuizQuestionCategoryRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizQuestionCategoryLocalServiceUtil.addLFQuizQuestionCategory(this);
        } else {
            LFQuizQuestionCategoryLocalServiceUtil.updateLFQuizQuestionCategory(this);
        }
    }

    @Override
    public LFQuizQuestionCategory toEscapedModel() {
        return (LFQuizQuestionCategory) ProxyUtil.newProxyInstance(LFQuizQuestionCategory.class.getClassLoader(),
            new Class[] { LFQuizQuestionCategory.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuizQuestionCategoryClp clone = new LFQuizQuestionCategoryClp();

        clone.setId(getId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setQuizId(getQuizId());
        clone.setParentId(getParentId());
        clone.setArrangementIndex(getArrangementIndex());

        return clone;
    }

    @Override
    public int compareTo(LFQuizQuestionCategory lfQuizQuestionCategory) {
        long primaryKey = lfQuizQuestionCategory.getPrimaryKey();

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

        if (!(obj instanceof LFQuizQuestionCategoryClp)) {
            return false;
        }

        LFQuizQuestionCategoryClp lfQuizQuestionCategory = (LFQuizQuestionCategoryClp) obj;

        long primaryKey = lfQuizQuestionCategory.getPrimaryKey();

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
        sb.append(", quizId=");
        sb.append(getQuizId());
        sb.append(", parentId=");
        sb.append(getParentId());
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
            "com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory");
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
            "<column><column-name>quizId</column-name><column-value><![CDATA[");
        sb.append(getQuizId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

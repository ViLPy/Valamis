package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.ClpSerializer;
import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil;

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


public class LFQuizQuestionClp extends BaseModelImpl<LFQuizQuestion>
    implements LFQuizQuestion {
    private long _id;
    private Integer _quizId;
    private Integer _categoryId;
    private Integer _questionId;
    private String _questionType;
    private String _title;
    private String _url;
    private String _plainText;
    private Integer _arrangementIndex;
    private Boolean _autoShowAnswer;
    private Integer _groupId;
    private BaseModel<?> _lfQuizQuestionRemoteModel;

    public LFQuizQuestionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return LFQuizQuestion.class;
    }

    @Override
    public String getModelClassName() {
        return LFQuizQuestion.class.getName();
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
        attributes.put("quizId", getQuizId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("questionId", getQuestionId());
        attributes.put("questionType", getQuestionType());
        attributes.put("title", getTitle());
        attributes.put("url", getUrl());
        attributes.put("plainText", getPlainText());
        attributes.put("arrangementIndex", getArrangementIndex());
        attributes.put("autoShowAnswer", getAutoShowAnswer());
        attributes.put("groupId", getGroupId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer quizId = (Integer) attributes.get("quizId");

        if (quizId != null) {
            setQuizId(quizId);
        }

        Integer categoryId = (Integer) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        Integer questionId = (Integer) attributes.get("questionId");

        if (questionId != null) {
            setQuestionId(questionId);
        }

        String questionType = (String) attributes.get("questionType");

        if (questionType != null) {
            setQuestionType(questionType);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String url = (String) attributes.get("url");

        if (url != null) {
            setUrl(url);
        }

        String plainText = (String) attributes.get("plainText");

        if (plainText != null) {
            setPlainText(plainText);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }

        Boolean autoShowAnswer = (Boolean) attributes.get("autoShowAnswer");

        if (autoShowAnswer != null) {
            setAutoShowAnswer(autoShowAnswer);
        }

        Integer groupId = (Integer) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_lfQuizQuestionRemoteModel, id);
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

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setQuizId", Integer.class);

                method.invoke(_lfQuizQuestionRemoteModel, quizId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getCategoryId() {
        return _categoryId;
    }

    @Override
    public void setCategoryId(Integer categoryId) {
        _categoryId = categoryId;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setCategoryId", Integer.class);

                method.invoke(_lfQuizQuestionRemoteModel, categoryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getQuestionId() {
        return _questionId;
    }

    @Override
    public void setQuestionId(Integer questionId) {
        _questionId = questionId;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setQuestionId", Integer.class);

                method.invoke(_lfQuizQuestionRemoteModel, questionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getQuestionType() {
        return _questionType;
    }

    @Override
    public void setQuestionType(String questionType) {
        _questionType = questionType;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setQuestionType", String.class);

                method.invoke(_lfQuizQuestionRemoteModel, questionType);
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

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_lfQuizQuestionRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUrl() {
        return _url;
    }

    @Override
    public void setUrl(String url) {
        _url = url;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setUrl", String.class);

                method.invoke(_lfQuizQuestionRemoteModel, url);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPlainText() {
        return _plainText;
    }

    @Override
    public void setPlainText(String plainText) {
        _plainText = plainText;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setPlainText", String.class);

                method.invoke(_lfQuizQuestionRemoteModel, plainText);
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

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setArrangementIndex",
                        Integer.class);

                method.invoke(_lfQuizQuestionRemoteModel, arrangementIndex);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Boolean getAutoShowAnswer() {
        return _autoShowAnswer;
    }

    @Override
    public void setAutoShowAnswer(Boolean autoShowAnswer) {
        _autoShowAnswer = autoShowAnswer;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setAutoShowAnswer",
                        Boolean.class);

                method.invoke(_lfQuizQuestionRemoteModel, autoShowAnswer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Integer getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(Integer groupId) {
        _groupId = groupId;

        if (_lfQuizQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _lfQuizQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", Integer.class);

                method.invoke(_lfQuizQuestionRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getLFQuizQuestionRemoteModel() {
        return _lfQuizQuestionRemoteModel;
    }

    public void setLFQuizQuestionRemoteModel(
        BaseModel<?> lfQuizQuestionRemoteModel) {
        _lfQuizQuestionRemoteModel = lfQuizQuestionRemoteModel;
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

        Class<?> remoteModelClass = _lfQuizQuestionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_lfQuizQuestionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizQuestionLocalServiceUtil.addLFQuizQuestion(this);
        } else {
            LFQuizQuestionLocalServiceUtil.updateLFQuizQuestion(this);
        }
    }

    @Override
    public LFQuizQuestion toEscapedModel() {
        return (LFQuizQuestion) ProxyUtil.newProxyInstance(LFQuizQuestion.class.getClassLoader(),
            new Class[] { LFQuizQuestion.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFQuizQuestionClp clone = new LFQuizQuestionClp();

        clone.setId(getId());
        clone.setQuizId(getQuizId());
        clone.setCategoryId(getCategoryId());
        clone.setQuestionId(getQuestionId());
        clone.setQuestionType(getQuestionType());
        clone.setTitle(getTitle());
        clone.setUrl(getUrl());
        clone.setPlainText(getPlainText());
        clone.setArrangementIndex(getArrangementIndex());
        clone.setAutoShowAnswer(getAutoShowAnswer());
        clone.setGroupId(getGroupId());

        return clone;
    }

    @Override
    public int compareTo(LFQuizQuestion lfQuizQuestion) {
        long primaryKey = lfQuizQuestion.getPrimaryKey();

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

        if (!(obj instanceof LFQuizQuestionClp)) {
            return false;
        }

        LFQuizQuestionClp lfQuizQuestion = (LFQuizQuestionClp) obj;

        long primaryKey = lfQuizQuestion.getPrimaryKey();

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
        StringBundler sb = new StringBundler(23);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", quizId=");
        sb.append(getQuizId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", questionId=");
        sb.append(getQuestionId());
        sb.append(", questionType=");
        sb.append(getQuestionType());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", url=");
        sb.append(getUrl());
        sb.append(", plainText=");
        sb.append(getPlainText());
        sb.append(", arrangementIndex=");
        sb.append(getArrangementIndex());
        sb.append(", autoShowAnswer=");
        sb.append(getAutoShowAnswer());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFQuizQuestion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>quizId</column-name><column-value><![CDATA[");
        sb.append(getQuizId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>questionId</column-name><column-value><![CDATA[");
        sb.append(getQuestionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>questionType</column-name><column-value><![CDATA[");
        sb.append(getQuestionType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>url</column-name><column-value><![CDATA[");
        sb.append(getUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>plainText</column-name><column-value><![CDATA[");
        sb.append(getPlainText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>autoShowAnswer</column-name><column-value><![CDATA[");
        sb.append(getAutoShowAnswer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

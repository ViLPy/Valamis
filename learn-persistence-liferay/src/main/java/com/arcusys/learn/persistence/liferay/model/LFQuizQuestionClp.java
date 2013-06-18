package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

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
    private BaseModel<?> _lfQuizQuestionRemoteModel;

    public LFQuizQuestionClp() {
    }

    public Class<?> getModelClass() {
        return LFQuizQuestion.class;
    }

    public String getModelClassName() {
        return LFQuizQuestion.class.getName();
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
        attributes.put("quizId", getQuizId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("questionId", getQuestionId());
        attributes.put("questionType", getQuestionType());
        attributes.put("title", getTitle());
        attributes.put("url", getUrl());
        attributes.put("plainText", getPlainText());
        attributes.put("arrangementIndex", getArrangementIndex());

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
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getQuizId() {
        return _quizId;
    }

    public void setQuizId(Integer quizId) {
        _quizId = quizId;
    }

    public Integer getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        _categoryId = categoryId;
    }

    public Integer getQuestionId() {
        return _questionId;
    }

    public void setQuestionId(Integer questionId) {
        _questionId = questionId;
    }

    public String getQuestionType() {
        return _questionType;
    }

    public void setQuestionType(String questionType) {
        _questionType = questionType;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getPlainText() {
        return _plainText;
    }

    public void setPlainText(String plainText) {
        _plainText = plainText;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }

    public BaseModel<?> getLFQuizQuestionRemoteModel() {
        return _lfQuizQuestionRemoteModel;
    }

    public void setLFQuizQuestionRemoteModel(
        BaseModel<?> lfQuizQuestionRemoteModel) {
        _lfQuizQuestionRemoteModel = lfQuizQuestionRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFQuizQuestionLocalServiceUtil.addLFQuizQuestion(this);
        } else {
            LFQuizQuestionLocalServiceUtil.updateLFQuizQuestion(this);
        }
    }

    @Override
    public LFQuizQuestion toEscapedModel() {
        return (LFQuizQuestion) Proxy.newProxyInstance(LFQuizQuestion.class.getClassLoader(),
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

        return clone;
    }

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
        if (obj == null) {
            return false;
        }

        LFQuizQuestionClp lfQuizQuestion = null;

        try {
            lfQuizQuestion = (LFQuizQuestionClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

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
        StringBundler sb = new StringBundler(19);

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
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

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

        sb.append("</model>");

        return sb.toString();
    }
}

package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class LFAnswerClp extends BaseModelImpl<LFAnswer> implements LFAnswer {
    private long _id;
    private String _description;
    private boolean _correct;
    private Integer _questionId;
    private BigDecimal _rangeFrom;
    private BigDecimal _rangeTo;
    private String _matchingText;
    private Integer _answerPosition;
    private Integer _answerType;
    private BaseModel<?> _lfAnswerRemoteModel;

    public LFAnswerClp() {
    }

    public Class<?> getModelClass() {
        return LFAnswer.class;
    }

    public String getModelClassName() {
        return LFAnswer.class.getName();
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
        attributes.put("description", getDescription());
        attributes.put("correct", getCorrect());
        attributes.put("questionId", getQuestionId());
        attributes.put("rangeFrom", getRangeFrom());
        attributes.put("rangeTo", getRangeTo());
        attributes.put("matchingText", getMatchingText());
        attributes.put("answerPosition", getAnswerPosition());
        attributes.put("answerType", getAnswerType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Boolean correct = (Boolean) attributes.get("correct");

        if (correct != null) {
            setCorrect(correct);
        }

        Integer questionId = (Integer) attributes.get("questionId");

        if (questionId != null) {
            setQuestionId(questionId);
        }

        BigDecimal rangeFrom = (BigDecimal) attributes.get("rangeFrom");

        if (rangeFrom != null) {
            setRangeFrom(rangeFrom);
        }

        BigDecimal rangeTo = (BigDecimal) attributes.get("rangeTo");

        if (rangeTo != null) {
            setRangeTo(rangeTo);
        }

        String matchingText = (String) attributes.get("matchingText");

        if (matchingText != null) {
            setMatchingText(matchingText);
        }

        Integer answerPosition = (Integer) attributes.get("answerPosition");

        if (answerPosition != null) {
            setAnswerPosition(answerPosition);
        }

        Integer answerType = (Integer) attributes.get("answerType");

        if (answerType != null) {
            setAnswerType(answerType);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public boolean getCorrect() {
        return _correct;
    }

    public boolean isCorrect() {
        return _correct;
    }

    public void setCorrect(boolean correct) {
        _correct = correct;
    }

    public Integer getQuestionId() {
        return _questionId;
    }

    public void setQuestionId(Integer questionId) {
        _questionId = questionId;
    }

    public BigDecimal getRangeFrom() {
        return _rangeFrom;
    }

    public void setRangeFrom(BigDecimal rangeFrom) {
        _rangeFrom = rangeFrom;
    }

    public BigDecimal getRangeTo() {
        return _rangeTo;
    }

    public void setRangeTo(BigDecimal rangeTo) {
        _rangeTo = rangeTo;
    }

    public String getMatchingText() {
        return _matchingText;
    }

    public void setMatchingText(String matchingText) {
        _matchingText = matchingText;
    }

    public Integer getAnswerPosition() {
        return _answerPosition;
    }

    public void setAnswerPosition(Integer answerPosition) {
        _answerPosition = answerPosition;
    }

    public Integer getAnswerType() {
        return _answerType;
    }

    public void setAnswerType(Integer answerType) {
        _answerType = answerType;
    }

    public BaseModel<?> getLFAnswerRemoteModel() {
        return _lfAnswerRemoteModel;
    }

    public void setLFAnswerRemoteModel(BaseModel<?> lfAnswerRemoteModel) {
        _lfAnswerRemoteModel = lfAnswerRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFAnswerLocalServiceUtil.addLFAnswer(this);
        } else {
            LFAnswerLocalServiceUtil.updateLFAnswer(this);
        }
    }

    @Override
    public LFAnswer toEscapedModel() {
        return (LFAnswer) Proxy.newProxyInstance(LFAnswer.class.getClassLoader(),
            new Class[] { LFAnswer.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFAnswerClp clone = new LFAnswerClp();

        clone.setId(getId());
        clone.setDescription(getDescription());
        clone.setCorrect(getCorrect());
        clone.setQuestionId(getQuestionId());
        clone.setRangeFrom(getRangeFrom());
        clone.setRangeTo(getRangeTo());
        clone.setMatchingText(getMatchingText());
        clone.setAnswerPosition(getAnswerPosition());
        clone.setAnswerType(getAnswerType());

        return clone;
    }

    public int compareTo(LFAnswer lfAnswer) {
        long primaryKey = lfAnswer.getPrimaryKey();

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

        LFAnswerClp lfAnswer = null;

        try {
            lfAnswer = (LFAnswerClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfAnswer.getPrimaryKey();

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
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", correct=");
        sb.append(getCorrect());
        sb.append(", questionId=");
        sb.append(getQuestionId());
        sb.append(", rangeFrom=");
        sb.append(getRangeFrom());
        sb.append(", rangeTo=");
        sb.append(getRangeTo());
        sb.append(", matchingText=");
        sb.append(getMatchingText());
        sb.append(", answerPosition=");
        sb.append(getAnswerPosition());
        sb.append(", answerType=");
        sb.append(getAnswerType());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.arcusys.learn.persistence.liferay.model.LFAnswer");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>correct</column-name><column-value><![CDATA[");
        sb.append(getCorrect());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>questionId</column-name><column-value><![CDATA[");
        sb.append(getQuestionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rangeFrom</column-name><column-value><![CDATA[");
        sb.append(getRangeFrom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>rangeTo</column-name><column-value><![CDATA[");
        sb.append(getRangeTo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>matchingText</column-name><column-value><![CDATA[");
        sb.append(getMatchingText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answerPosition</column-name><column-value><![CDATA[");
        sb.append(getAnswerPosition());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answerType</column-name><column-value><![CDATA[");
        sb.append(getAnswerType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

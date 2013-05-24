package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFAnswer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.math.BigDecimal;

/**
* The cache model class for representing LFAnswer in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFAnswer
* @generated
*/
public class LFAnswerCacheModel implements CacheModel<LFAnswer>, Serializable {
    public long id;
    public String description;
    public boolean correct;
    public Integer questionId;
    public BigDecimal rangeFrom;
    public BigDecimal rangeTo;
    public String matchingText;
    public Integer answerPosition;
    public Integer answerType;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(id);
        sb.append(", description=");
        sb.append(description);
        sb.append(", correct=");
        sb.append(correct);
        sb.append(", questionId=");
        sb.append(questionId);
        sb.append(", rangeFrom=");
        sb.append(rangeFrom);
        sb.append(", rangeTo=");
        sb.append(rangeTo);
        sb.append(", matchingText=");
        sb.append(matchingText);
        sb.append(", answerPosition=");
        sb.append(answerPosition);
        sb.append(", answerType=");
        sb.append(answerType);
        sb.append("}");

        return sb.toString();
    }

    public LFAnswer toEntityModel() {
        LFAnswerImpl lfAnswerImpl = new LFAnswerImpl();

        lfAnswerImpl.setId(id);

        if (description == null) {
            lfAnswerImpl.setDescription(StringPool.BLANK);
        } else {
            lfAnswerImpl.setDescription(description);
        }

        lfAnswerImpl.setCorrect(correct);
        lfAnswerImpl.setQuestionId(questionId);
        lfAnswerImpl.setRangeFrom(rangeFrom);
        lfAnswerImpl.setRangeTo(rangeTo);

        if (matchingText == null) {
            lfAnswerImpl.setMatchingText(StringPool.BLANK);
        } else {
            lfAnswerImpl.setMatchingText(matchingText);
        }

        lfAnswerImpl.setAnswerPosition(answerPosition);
        lfAnswerImpl.setAnswerType(answerType);

        lfAnswerImpl.resetOriginalValues();

        return lfAnswerImpl;
    }
}

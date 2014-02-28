package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFAnswer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.math.BigDecimal;

/**
 * The cache model class for representing LFAnswer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFAnswer
 * @generated
 */
public class LFAnswerCacheModel implements CacheModel<LFAnswer>, Externalizable {
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

    @Override
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

    @Override
    public void readExternal(ObjectInput objectInput)
        throws ClassNotFoundException, IOException {
        id = objectInput.readLong();
        description = objectInput.readUTF();
        correct = objectInput.readBoolean();
        questionId = objectInput.readInt();
        rangeFrom = (BigDecimal) objectInput.readObject();
        rangeTo = (BigDecimal) objectInput.readObject();
        matchingText = objectInput.readUTF();
        answerPosition = objectInput.readInt();
        answerType = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeBoolean(correct);
        objectOutput.writeInt(questionId);
        objectOutput.writeObject(rangeFrom);
        objectOutput.writeObject(rangeTo);

        if (matchingText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(matchingText);
        }

        objectOutput.writeInt(answerPosition);
        objectOutput.writeInt(answerType);
    }
}

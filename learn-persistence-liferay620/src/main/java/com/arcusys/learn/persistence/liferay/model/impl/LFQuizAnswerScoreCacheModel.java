package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuizAnswerScore in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizAnswerScore
 * @generated
 */
public class LFQuizAnswerScoreCacheModel implements CacheModel<LFQuizAnswerScore>,
    Externalizable {
    public long answerId;
    public Double score;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{answerId=");
        sb.append(answerId);
        sb.append(", score=");
        sb.append(score);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFQuizAnswerScore toEntityModel() {
        LFQuizAnswerScoreImpl lfQuizAnswerScoreImpl = new LFQuizAnswerScoreImpl();

        lfQuizAnswerScoreImpl.setAnswerId(answerId);
        lfQuizAnswerScoreImpl.setScore(score);

        lfQuizAnswerScoreImpl.resetOriginalValues();

        return lfQuizAnswerScoreImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        answerId = objectInput.readLong();
        score = objectInput.readDouble();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(answerId);
        objectOutput.writeDouble(score);
    }
}

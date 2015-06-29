package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuestion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuestion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestion
 * @generated
 */
public class LFQuestionCacheModel implements CacheModel<LFQuestion>,
    Externalizable {
    public long id;
    public Integer categoryId;
    public String title;
    public String description;
    public String explanationText;
    public String rightAnswerText;
    public String wrongAnswerText;
    public boolean forceCorrectCount;
    public boolean caseSensitive;
    public Integer questionType;
    public Integer courseId;
    public Integer arrangementIndex;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(id);
        sb.append(", categoryId=");
        sb.append(categoryId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", explanationText=");
        sb.append(explanationText);
        sb.append(", rightAnswerText=");
        sb.append(rightAnswerText);
        sb.append(", wrongAnswerText=");
        sb.append(wrongAnswerText);
        sb.append(", forceCorrectCount=");
        sb.append(forceCorrectCount);
        sb.append(", caseSensitive=");
        sb.append(caseSensitive);
        sb.append(", questionType=");
        sb.append(questionType);
        sb.append(", courseId=");
        sb.append(courseId);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFQuestion toEntityModel() {
        LFQuestionImpl lfQuestionImpl = new LFQuestionImpl();

        lfQuestionImpl.setId(id);
        lfQuestionImpl.setCategoryId(categoryId);

        if (title == null) {
            lfQuestionImpl.setTitle(StringPool.BLANK);
        } else {
            lfQuestionImpl.setTitle(title);
        }

        if (description == null) {
            lfQuestionImpl.setDescription(StringPool.BLANK);
        } else {
            lfQuestionImpl.setDescription(description);
        }

        if (explanationText == null) {
            lfQuestionImpl.setExplanationText(StringPool.BLANK);
        } else {
            lfQuestionImpl.setExplanationText(explanationText);
        }

        if (rightAnswerText == null) {
            lfQuestionImpl.setRightAnswerText(StringPool.BLANK);
        } else {
            lfQuestionImpl.setRightAnswerText(rightAnswerText);
        }

        if (wrongAnswerText == null) {
            lfQuestionImpl.setWrongAnswerText(StringPool.BLANK);
        } else {
            lfQuestionImpl.setWrongAnswerText(wrongAnswerText);
        }

        lfQuestionImpl.setForceCorrectCount(forceCorrectCount);
        lfQuestionImpl.setCaseSensitive(caseSensitive);
        lfQuestionImpl.setQuestionType(questionType);
        lfQuestionImpl.setCourseId(courseId);
        lfQuestionImpl.setArrangementIndex(arrangementIndex);

        lfQuestionImpl.resetOriginalValues();

        return lfQuestionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        categoryId = objectInput.readInt();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        explanationText = objectInput.readUTF();
        rightAnswerText = objectInput.readUTF();
        wrongAnswerText = objectInput.readUTF();
        forceCorrectCount = objectInput.readBoolean();
        caseSensitive = objectInput.readBoolean();
        questionType = objectInput.readInt();
        courseId = objectInput.readInt();
        arrangementIndex = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(categoryId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (explanationText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(explanationText);
        }

        if (rightAnswerText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(rightAnswerText);
        }

        if (wrongAnswerText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(wrongAnswerText);
        }

        objectOutput.writeBoolean(forceCorrectCount);
        objectOutput.writeBoolean(caseSensitive);
        objectOutput.writeInt(questionType);
        objectOutput.writeInt(courseId);
        objectOutput.writeInt(arrangementIndex);
    }
}

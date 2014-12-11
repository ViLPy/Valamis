package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuizQuestion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestion
 * @generated
 */
public class LFQuizQuestionCacheModel implements CacheModel<LFQuizQuestion>,
    Externalizable {
    public long id;
    public Integer quizId;
    public Integer categoryId;
    public Integer questionId;
    public String questionType;
    public String title;
    public String url;
    public String plainText;
    public Integer arrangementIndex;
    public Boolean autoShowAnswer;
    public Integer groupId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{id=");
        sb.append(id);
        sb.append(", quizId=");
        sb.append(quizId);
        sb.append(", categoryId=");
        sb.append(categoryId);
        sb.append(", questionId=");
        sb.append(questionId);
        sb.append(", questionType=");
        sb.append(questionType);
        sb.append(", title=");
        sb.append(title);
        sb.append(", url=");
        sb.append(url);
        sb.append(", plainText=");
        sb.append(plainText);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append(", autoShowAnswer=");
        sb.append(autoShowAnswer);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFQuizQuestion toEntityModel() {
        LFQuizQuestionImpl lfQuizQuestionImpl = new LFQuizQuestionImpl();

        lfQuizQuestionImpl.setId(id);
        lfQuizQuestionImpl.setQuizId(quizId);
        lfQuizQuestionImpl.setCategoryId(categoryId);
        lfQuizQuestionImpl.setQuestionId(questionId);

        if (questionType == null) {
            lfQuizQuestionImpl.setQuestionType(StringPool.BLANK);
        } else {
            lfQuizQuestionImpl.setQuestionType(questionType);
        }

        if (title == null) {
            lfQuizQuestionImpl.setTitle(StringPool.BLANK);
        } else {
            lfQuizQuestionImpl.setTitle(title);
        }

        if (url == null) {
            lfQuizQuestionImpl.setUrl(StringPool.BLANK);
        } else {
            lfQuizQuestionImpl.setUrl(url);
        }

        if (plainText == null) {
            lfQuizQuestionImpl.setPlainText(StringPool.BLANK);
        } else {
            lfQuizQuestionImpl.setPlainText(plainText);
        }

        lfQuizQuestionImpl.setArrangementIndex(arrangementIndex);
        lfQuizQuestionImpl.setAutoShowAnswer(autoShowAnswer);
        lfQuizQuestionImpl.setGroupId(groupId);

        lfQuizQuestionImpl.resetOriginalValues();

        return lfQuizQuestionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        quizId = objectInput.readInt();
        categoryId = objectInput.readInt();
        questionId = objectInput.readInt();
        questionType = objectInput.readUTF();
        title = objectInput.readUTF();
        url = objectInput.readUTF();
        plainText = objectInput.readUTF();
        arrangementIndex = objectInput.readInt();
        autoShowAnswer = objectInput.readBoolean();
        groupId = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(quizId);
        objectOutput.writeInt(categoryId);
        objectOutput.writeInt(questionId);

        if (questionType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(questionType);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (url == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(url);
        }

        if (plainText == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(plainText);
        }

        objectOutput.writeInt(arrangementIndex);
        objectOutput.writeBoolean(autoShowAnswer);
        objectOutput.writeInt(groupId);
    }
}

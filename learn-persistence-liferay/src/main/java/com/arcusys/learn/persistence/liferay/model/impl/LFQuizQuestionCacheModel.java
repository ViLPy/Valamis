package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFQuizQuestion in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFQuizQuestion
* @generated
*/
public class LFQuizQuestionCacheModel implements CacheModel<LFQuizQuestion>,
    Serializable {
    public long id;
    public Integer quizId;
    public Integer categoryId;
    public Integer questionId;
    public String questionType;
    public String title;
    public String url;
    public String plainText;
    public Integer arrangementIndex;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

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
        sb.append("}");

        return sb.toString();
    }

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

        lfQuizQuestionImpl.setTitle(title);

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

        lfQuizQuestionImpl.resetOriginalValues();

        return lfQuizQuestionImpl;
    }
}

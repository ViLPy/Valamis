package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuestion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFQuestion in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFQuestion
* @generated
*/
public class LFQuestionCacheModel implements CacheModel<LFQuestion>,
    Serializable {
    public long id;
    public Integer categoryId;
    public String title;
    public String description;
    public String explanationText;
    public boolean forceCorrectCount;
    public boolean caseSensitive;
    public Integer questionType;
    public Integer courseId;
    public Integer arrangementIndex;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

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

        lfQuestionImpl.setForceCorrectCount(forceCorrectCount);
        lfQuestionImpl.setCaseSensitive(caseSensitive);
        lfQuestionImpl.setQuestionType(questionType);
        lfQuestionImpl.setCourseId(courseId);
        lfQuestionImpl.setArrangementIndex(arrangementIndex);

        lfQuestionImpl.resetOriginalValues();

        return lfQuestionImpl;
    }
}

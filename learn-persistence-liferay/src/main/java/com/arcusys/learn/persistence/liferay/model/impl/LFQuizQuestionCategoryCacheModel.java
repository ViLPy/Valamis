package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFQuizQuestionCategory in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFQuizQuestionCategory
* @generated
*/
public class LFQuizQuestionCategoryCacheModel implements CacheModel<LFQuizQuestionCategory>,
    Serializable {
    public long id;
    public String title;
    public String description;
    public Integer quizId;
    public Integer parentId;
    public Integer arrangementIndex;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", quizId=");
        sb.append(quizId);
        sb.append(", parentId=");
        sb.append(parentId);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append("}");

        return sb.toString();
    }

    public LFQuizQuestionCategory toEntityModel() {
        LFQuizQuestionCategoryImpl lfQuizQuestionCategoryImpl = new LFQuizQuestionCategoryImpl();

        lfQuizQuestionCategoryImpl.setId(id);

        if (title == null) {
            lfQuizQuestionCategoryImpl.setTitle(StringPool.BLANK);
        } else {
            lfQuizQuestionCategoryImpl.setTitle(title);
        }

        if (description == null) {
            lfQuizQuestionCategoryImpl.setDescription(StringPool.BLANK);
        } else {
            lfQuizQuestionCategoryImpl.setDescription(description);
        }

        lfQuizQuestionCategoryImpl.setQuizId(quizId);
        lfQuizQuestionCategoryImpl.setParentId(parentId);
        lfQuizQuestionCategoryImpl.setArrangementIndex(arrangementIndex);

        lfQuizQuestionCategoryImpl.resetOriginalValues();

        return lfQuizQuestionCategoryImpl;
    }
}

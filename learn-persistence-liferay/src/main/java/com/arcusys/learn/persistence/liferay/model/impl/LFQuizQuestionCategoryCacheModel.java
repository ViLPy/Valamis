package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuizQuestionCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestionCategory
 * @generated
 */
public class LFQuizQuestionCategoryCacheModel implements CacheModel<LFQuizQuestionCategory>,
    Externalizable {
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

    @Override
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

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        quizId = objectInput.readInt();
        parentId = objectInput.readInt();
        arrangementIndex = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

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

        objectOutput.writeInt(quizId);
        objectOutput.writeInt(parentId);
        objectOutput.writeInt(arrangementIndex);
    }
}

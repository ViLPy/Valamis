package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuestionCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuestionCategory
 * @generated
 */
public class LFQuestionCategoryCacheModel implements CacheModel<LFQuestionCategory>,
    Externalizable {
    public long id;
    public String title;
    public String description;
    public Integer parentId;
    public Integer courseId;
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
        sb.append(", parentId=");
        sb.append(parentId);
        sb.append(", courseId=");
        sb.append(courseId);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFQuestionCategory toEntityModel() {
        LFQuestionCategoryImpl lfQuestionCategoryImpl = new LFQuestionCategoryImpl();

        lfQuestionCategoryImpl.setId(id);

        if (title == null) {
            lfQuestionCategoryImpl.setTitle(StringPool.BLANK);
        } else {
            lfQuestionCategoryImpl.setTitle(title);
        }

        if (description == null) {
            lfQuestionCategoryImpl.setDescription(StringPool.BLANK);
        } else {
            lfQuestionCategoryImpl.setDescription(description);
        }

        lfQuestionCategoryImpl.setParentId(parentId);
        lfQuestionCategoryImpl.setCourseId(courseId);
        lfQuestionCategoryImpl.setArrangementIndex(arrangementIndex);

        lfQuestionCategoryImpl.resetOriginalValues();

        return lfQuestionCategoryImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        parentId = objectInput.readInt();
        courseId = objectInput.readInt();
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

        objectOutput.writeInt(parentId);
        objectOutput.writeInt(courseId);
        objectOutput.writeInt(arrangementIndex);
    }
}

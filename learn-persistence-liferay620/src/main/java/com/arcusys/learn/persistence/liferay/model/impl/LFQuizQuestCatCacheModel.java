package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuizQuestCat in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizQuestCat
 * @generated
 */
public class LFQuizQuestCatCacheModel implements CacheModel<LFQuizQuestCat>,
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
    public LFQuizQuestCat toEntityModel() {
        LFQuizQuestCatImpl lfQuizQuestCatImpl = new LFQuizQuestCatImpl();

        lfQuizQuestCatImpl.setId(id);

        if (title == null) {
            lfQuizQuestCatImpl.setTitle(StringPool.BLANK);
        } else {
            lfQuizQuestCatImpl.setTitle(title);
        }

        if (description == null) {
            lfQuizQuestCatImpl.setDescription(StringPool.BLANK);
        } else {
            lfQuizQuestCatImpl.setDescription(description);
        }

        lfQuizQuestCatImpl.setQuizId(quizId);
        lfQuizQuestCatImpl.setParentId(parentId);
        lfQuizQuestCatImpl.setArrangementIndex(arrangementIndex);

        lfQuizQuestCatImpl.resetOriginalValues();

        return lfQuizQuestCatImpl;
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

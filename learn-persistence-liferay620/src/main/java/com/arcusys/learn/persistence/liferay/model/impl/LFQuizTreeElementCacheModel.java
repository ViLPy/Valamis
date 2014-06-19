package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizTreeElement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFQuizTreeElement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFQuizTreeElement
 * @generated
 */
public class LFQuizTreeElementCacheModel implements CacheModel<LFQuizTreeElement>,
    Externalizable {
    public long id;
    public Integer quizID;
    public String elementID;
    public Boolean isCategory;
    public String parentID;
    public Integer arrangementIndex;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(id);
        sb.append(", quizID=");
        sb.append(quizID);
        sb.append(", elementID=");
        sb.append(elementID);
        sb.append(", isCategory=");
        sb.append(isCategory);
        sb.append(", parentID=");
        sb.append(parentID);
        sb.append(", arrangementIndex=");
        sb.append(arrangementIndex);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFQuizTreeElement toEntityModel() {
        LFQuizTreeElementImpl lfQuizTreeElementImpl = new LFQuizTreeElementImpl();

        lfQuizTreeElementImpl.setId(id);
        lfQuizTreeElementImpl.setQuizID(quizID);

        if (elementID == null) {
            lfQuizTreeElementImpl.setElementID(StringPool.BLANK);
        } else {
            lfQuizTreeElementImpl.setElementID(elementID);
        }

        lfQuizTreeElementImpl.setIsCategory(isCategory);

        if (parentID == null) {
            lfQuizTreeElementImpl.setParentID(StringPool.BLANK);
        } else {
            lfQuizTreeElementImpl.setParentID(parentID);
        }

        lfQuizTreeElementImpl.setArrangementIndex(arrangementIndex);

        lfQuizTreeElementImpl.resetOriginalValues();

        return lfQuizTreeElementImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        quizID = objectInput.readInt();
        elementID = objectInput.readUTF();
        isCategory = objectInput.readBoolean();
        parentID = objectInput.readUTF();
        arrangementIndex = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(quizID);

        if (elementID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(elementID);
        }

        objectOutput.writeBoolean(isCategory);

        if (parentID == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(parentID);
        }

        objectOutput.writeInt(arrangementIndex);
    }
}

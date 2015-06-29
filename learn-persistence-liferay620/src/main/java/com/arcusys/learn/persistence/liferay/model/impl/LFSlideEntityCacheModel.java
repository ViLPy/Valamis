package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlideEntity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSlideEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideEntity
 * @generated
 */
public class LFSlideEntityCacheModel implements CacheModel<LFSlideEntity>,
    Externalizable {
    public long id;
    public String top;
    public String left;
    public String width;
    public String height;
    public String zIndex;
    public String content;
    public String entityType;
    public Long slideId;
    public Long correctLinkedSlideId;
    public Long incorrectLinkedSlideId;
    public Boolean notifyCorrectAnswer;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{id=");
        sb.append(id);
        sb.append(", top=");
        sb.append(top);
        sb.append(", left=");
        sb.append(left);
        sb.append(", width=");
        sb.append(width);
        sb.append(", height=");
        sb.append(height);
        sb.append(", zIndex=");
        sb.append(zIndex);
        sb.append(", content=");
        sb.append(content);
        sb.append(", entityType=");
        sb.append(entityType);
        sb.append(", slideId=");
        sb.append(slideId);
        sb.append(", correctLinkedSlideId=");
        sb.append(correctLinkedSlideId);
        sb.append(", incorrectLinkedSlideId=");
        sb.append(incorrectLinkedSlideId);
        sb.append(", notifyCorrectAnswer=");
        sb.append(notifyCorrectAnswer);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSlideEntity toEntityModel() {
        LFSlideEntityImpl lfSlideEntityImpl = new LFSlideEntityImpl();

        lfSlideEntityImpl.setId(id);

        if (top == null) {
            lfSlideEntityImpl.setTop(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setTop(top);
        }

        if (left == null) {
            lfSlideEntityImpl.setLeft(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setLeft(left);
        }

        if (width == null) {
            lfSlideEntityImpl.setWidth(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setWidth(width);
        }

        if (height == null) {
            lfSlideEntityImpl.setHeight(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setHeight(height);
        }

        if (zIndex == null) {
            lfSlideEntityImpl.setZIndex(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setZIndex(zIndex);
        }

        if (content == null) {
            lfSlideEntityImpl.setContent(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setContent(content);
        }

        if (entityType == null) {
            lfSlideEntityImpl.setEntityType(StringPool.BLANK);
        } else {
            lfSlideEntityImpl.setEntityType(entityType);
        }

        lfSlideEntityImpl.setSlideId(slideId);
        lfSlideEntityImpl.setCorrectLinkedSlideId(correctLinkedSlideId);
        lfSlideEntityImpl.setIncorrectLinkedSlideId(incorrectLinkedSlideId);
        lfSlideEntityImpl.setNotifyCorrectAnswer(notifyCorrectAnswer);

        lfSlideEntityImpl.resetOriginalValues();

        return lfSlideEntityImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        top = objectInput.readUTF();
        left = objectInput.readUTF();
        width = objectInput.readUTF();
        height = objectInput.readUTF();
        zIndex = objectInput.readUTF();
        content = objectInput.readUTF();
        entityType = objectInput.readUTF();
        slideId = objectInput.readLong();
        correctLinkedSlideId = objectInput.readLong();
        incorrectLinkedSlideId = objectInput.readLong();
        notifyCorrectAnswer = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (top == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(top);
        }

        if (left == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(left);
        }

        if (width == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(width);
        }

        if (height == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(height);
        }

        if (zIndex == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(zIndex);
        }

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }

        if (entityType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(entityType);
        }

        objectOutput.writeLong(slideId);
        objectOutput.writeLong(correctLinkedSlideId);
        objectOutput.writeLong(incorrectLinkedSlideId);
        objectOutput.writeBoolean(notifyCorrectAnswer);
    }
}

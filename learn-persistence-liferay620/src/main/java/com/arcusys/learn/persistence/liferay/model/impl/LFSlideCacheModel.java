package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlide;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSlide in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSlide
 * @generated
 */
public class LFSlideCacheModel implements CacheModel<LFSlide>, Externalizable {
    public long id;
    public String bgcolor;
    public String bgimage;
    public String title;
    public Long slideSetId;
    public Long topSlideId;
    public Long leftSlideId;
    public String statementVerb;
    public String statementObject;
    public String statementCategoryId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{id=");
        sb.append(id);
        sb.append(", bgcolor=");
        sb.append(bgcolor);
        sb.append(", bgimage=");
        sb.append(bgimage);
        sb.append(", title=");
        sb.append(title);
        sb.append(", slideSetId=");
        sb.append(slideSetId);
        sb.append(", topSlideId=");
        sb.append(topSlideId);
        sb.append(", leftSlideId=");
        sb.append(leftSlideId);
        sb.append(", statementVerb=");
        sb.append(statementVerb);
        sb.append(", statementObject=");
        sb.append(statementObject);
        sb.append(", statementCategoryId=");
        sb.append(statementCategoryId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSlide toEntityModel() {
        LFSlideImpl lfSlideImpl = new LFSlideImpl();

        lfSlideImpl.setId(id);

        if (bgcolor == null) {
            lfSlideImpl.setBgcolor(StringPool.BLANK);
        } else {
            lfSlideImpl.setBgcolor(bgcolor);
        }

        if (bgimage == null) {
            lfSlideImpl.setBgimage(StringPool.BLANK);
        } else {
            lfSlideImpl.setBgimage(bgimage);
        }

        if (title == null) {
            lfSlideImpl.setTitle(StringPool.BLANK);
        } else {
            lfSlideImpl.setTitle(title);
        }

        lfSlideImpl.setSlideSetId(slideSetId);
        lfSlideImpl.setTopSlideId(topSlideId);
        lfSlideImpl.setLeftSlideId(leftSlideId);

        if (statementVerb == null) {
            lfSlideImpl.setStatementVerb(StringPool.BLANK);
        } else {
            lfSlideImpl.setStatementVerb(statementVerb);
        }

        if (statementObject == null) {
            lfSlideImpl.setStatementObject(StringPool.BLANK);
        } else {
            lfSlideImpl.setStatementObject(statementObject);
        }

        if (statementCategoryId == null) {
            lfSlideImpl.setStatementCategoryId(StringPool.BLANK);
        } else {
            lfSlideImpl.setStatementCategoryId(statementCategoryId);
        }

        lfSlideImpl.resetOriginalValues();

        return lfSlideImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        bgcolor = objectInput.readUTF();
        bgimage = objectInput.readUTF();
        title = objectInput.readUTF();
        slideSetId = objectInput.readLong();
        topSlideId = objectInput.readLong();
        leftSlideId = objectInput.readLong();
        statementVerb = objectInput.readUTF();
        statementObject = objectInput.readUTF();
        statementCategoryId = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (bgcolor == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(bgcolor);
        }

        if (bgimage == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(bgimage);
        }

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        objectOutput.writeLong(slideSetId);
        objectOutput.writeLong(topSlideId);
        objectOutput.writeLong(leftSlideId);

        if (statementVerb == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statementVerb);
        }

        if (statementObject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statementObject);
        }

        if (statementCategoryId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(statementCategoryId);
        }
    }
}

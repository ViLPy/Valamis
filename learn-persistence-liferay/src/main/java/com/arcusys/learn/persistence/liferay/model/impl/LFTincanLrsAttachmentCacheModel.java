package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsAttachment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsAttachment
 * @generated
 */
public class LFTincanLrsAttachmentCacheModel implements CacheModel<LFTincanLrsAttachment>,
    Externalizable {
    public long id;
    public Integer parentID;
    public String usageType;
    public String display;
    public String description;
    public String contentType;
    public Integer length;
    public String sha2;
    public String fileUrl;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(id);
        sb.append(", parentID=");
        sb.append(parentID);
        sb.append(", usageType=");
        sb.append(usageType);
        sb.append(", display=");
        sb.append(display);
        sb.append(", description=");
        sb.append(description);
        sb.append(", contentType=");
        sb.append(contentType);
        sb.append(", length=");
        sb.append(length);
        sb.append(", sha2=");
        sb.append(sha2);
        sb.append(", fileUrl=");
        sb.append(fileUrl);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsAttachment toEntityModel() {
        LFTincanLrsAttachmentImpl lfTincanLrsAttachmentImpl = new LFTincanLrsAttachmentImpl();

        lfTincanLrsAttachmentImpl.setId(id);
        lfTincanLrsAttachmentImpl.setParentID(parentID);

        if (usageType == null) {
            lfTincanLrsAttachmentImpl.setUsageType(StringPool.BLANK);
        } else {
            lfTincanLrsAttachmentImpl.setUsageType(usageType);
        }

        if (display == null) {
            lfTincanLrsAttachmentImpl.setDisplay(StringPool.BLANK);
        } else {
            lfTincanLrsAttachmentImpl.setDisplay(display);
        }

        if (description == null) {
            lfTincanLrsAttachmentImpl.setDescription(StringPool.BLANK);
        } else {
            lfTincanLrsAttachmentImpl.setDescription(description);
        }

        if (contentType == null) {
            lfTincanLrsAttachmentImpl.setContentType(StringPool.BLANK);
        } else {
            lfTincanLrsAttachmentImpl.setContentType(contentType);
        }

        lfTincanLrsAttachmentImpl.setLength(length);

        if (sha2 == null) {
            lfTincanLrsAttachmentImpl.setSha2(StringPool.BLANK);
        } else {
            lfTincanLrsAttachmentImpl.setSha2(sha2);
        }

        if (fileUrl == null) {
            lfTincanLrsAttachmentImpl.setFileUrl(StringPool.BLANK);
        } else {
            lfTincanLrsAttachmentImpl.setFileUrl(fileUrl);
        }

        lfTincanLrsAttachmentImpl.resetOriginalValues();

        return lfTincanLrsAttachmentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        parentID = objectInput.readInt();
        usageType = objectInput.readUTF();
        display = objectInput.readUTF();
        description = objectInput.readUTF();
        contentType = objectInput.readUTF();
        length = objectInput.readInt();
        sha2 = objectInput.readUTF();
        fileUrl = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(parentID);

        if (usageType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(usageType);
        }

        if (display == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(display);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (contentType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contentType);
        }

        objectOutput.writeInt(length);

        if (sha2 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sha2);
        }

        if (fileUrl == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fileUrl);
        }
    }
}

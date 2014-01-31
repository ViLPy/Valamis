package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFTincanLrsDocument in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsDocument
 * @generated
 */
public class LFTincanLrsDocumentCacheModel implements CacheModel<LFTincanLrsDocument>,
    Externalizable {
    public long id;
    public String documentId;
    public long update;
    public String content;
    public String contentType;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", documentId=");
        sb.append(documentId);
        sb.append(", update=");
        sb.append(update);
        sb.append(", content=");
        sb.append(content);
        sb.append(", contentType=");
        sb.append(contentType);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsDocument toEntityModel() {
        LFTincanLrsDocumentImpl lfTincanLrsDocumentImpl = new LFTincanLrsDocumentImpl();

        lfTincanLrsDocumentImpl.setId(id);

        if (documentId == null) {
            lfTincanLrsDocumentImpl.setDocumentId(StringPool.BLANK);
        } else {
            lfTincanLrsDocumentImpl.setDocumentId(documentId);
        }

        if (update == Long.MIN_VALUE) {
            lfTincanLrsDocumentImpl.setUpdate(null);
        } else {
            lfTincanLrsDocumentImpl.setUpdate(new Date(update));
        }

        if (content == null) {
            lfTincanLrsDocumentImpl.setContent(StringPool.BLANK);
        } else {
            lfTincanLrsDocumentImpl.setContent(content);
        }

        if (contentType == null) {
            lfTincanLrsDocumentImpl.setContentType(StringPool.BLANK);
        } else {
            lfTincanLrsDocumentImpl.setContentType(contentType);
        }

        lfTincanLrsDocumentImpl.resetOriginalValues();

        return lfTincanLrsDocumentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        documentId = objectInput.readUTF();
        update = objectInput.readLong();
        content = objectInput.readUTF();
        contentType = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (documentId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(documentId);
        }

        objectOutput.writeLong(update);

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }

        if (contentType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(contentType);
        }
    }
}

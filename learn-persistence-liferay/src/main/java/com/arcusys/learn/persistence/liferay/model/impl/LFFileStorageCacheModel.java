package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFFileStorage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFFileStorage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFFileStorage
 * @generated
 */
public class LFFileStorageCacheModel implements CacheModel<LFFileStorage>,
    Externalizable {
    public long id;
    public String filename;
    public String content;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{id=");
        sb.append(id);
        sb.append(", filename=");
        sb.append(filename);
        sb.append(", content=");
        sb.append(content);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFFileStorage toEntityModel() {
        LFFileStorageImpl lfFileStorageImpl = new LFFileStorageImpl();

        lfFileStorageImpl.setId(id);

        if (filename == null) {
            lfFileStorageImpl.setFilename(StringPool.BLANK);
        } else {
            lfFileStorageImpl.setFilename(filename);
        }

        if (content == null) {
            lfFileStorageImpl.setContent(StringPool.BLANK);
        } else {
            lfFileStorageImpl.setContent(content);
        }

        lfFileStorageImpl.resetOriginalValues();

        return lfFileStorageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        filename = objectInput.readUTF();
        content = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (filename == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(filename);
        }

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }
    }
}

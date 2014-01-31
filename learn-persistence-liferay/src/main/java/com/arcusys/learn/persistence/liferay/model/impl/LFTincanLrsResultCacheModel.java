package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsResult;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFTincanLrsResult in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsResult
 * @generated
 */
public class LFTincanLrsResultCacheModel implements CacheModel<LFTincanLrsResult>,
    Externalizable {
    public long id;
    public String score;
    public Boolean success;
    public Boolean completion;
    public String response;
    public Double duration;
    public String extension;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{id=");
        sb.append(id);
        sb.append(", score=");
        sb.append(score);
        sb.append(", success=");
        sb.append(success);
        sb.append(", completion=");
        sb.append(completion);
        sb.append(", response=");
        sb.append(response);
        sb.append(", duration=");
        sb.append(duration);
        sb.append(", extension=");
        sb.append(extension);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFTincanLrsResult toEntityModel() {
        LFTincanLrsResultImpl lfTincanLrsResultImpl = new LFTincanLrsResultImpl();

        lfTincanLrsResultImpl.setId(id);

        if (score == null) {
            lfTincanLrsResultImpl.setScore(StringPool.BLANK);
        } else {
            lfTincanLrsResultImpl.setScore(score);
        }

        lfTincanLrsResultImpl.setSuccess(success);
        lfTincanLrsResultImpl.setCompletion(completion);

        if (response == null) {
            lfTincanLrsResultImpl.setResponse(StringPool.BLANK);
        } else {
            lfTincanLrsResultImpl.setResponse(response);
        }

        lfTincanLrsResultImpl.setDuration(duration);

        if (extension == null) {
            lfTincanLrsResultImpl.setExtension(StringPool.BLANK);
        } else {
            lfTincanLrsResultImpl.setExtension(extension);
        }

        lfTincanLrsResultImpl.resetOriginalValues();

        return lfTincanLrsResultImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        score = objectInput.readUTF();
        success = objectInput.readBoolean();
        completion = objectInput.readBoolean();
        response = objectInput.readUTF();
        duration = objectInput.readDouble();
        extension = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);

        if (score == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(score);
        }

        objectOutput.writeBoolean(success);
        objectOutput.writeBoolean(completion);

        if (response == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(response);
        }

        objectOutput.writeDouble(duration);

        if (extension == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(extension);
        }
    }
}

package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlideSet;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LFSlideSet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideSet
 * @generated
 */
public class LFSlideSetCacheModel implements CacheModel<LFSlideSet>,
    Externalizable {
    public long id;
    public String title;
    public String description;
    public String logo;
    public Long courseId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", logo=");
        sb.append(logo);
        sb.append(", courseId=");
        sb.append(courseId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFSlideSet toEntityModel() {
        LFSlideSetImpl lfSlideSetImpl = new LFSlideSetImpl();

        lfSlideSetImpl.setId(id);

        if (title == null) {
            lfSlideSetImpl.setTitle(StringPool.BLANK);
        } else {
            lfSlideSetImpl.setTitle(title);
        }

        if (description == null) {
            lfSlideSetImpl.setDescription(StringPool.BLANK);
        } else {
            lfSlideSetImpl.setDescription(description);
        }

        if (logo == null) {
            lfSlideSetImpl.setLogo(StringPool.BLANK);
        } else {
            lfSlideSetImpl.setLogo(logo);
        }

        lfSlideSetImpl.setCourseId(courseId);

        lfSlideSetImpl.resetOriginalValues();

        return lfSlideSetImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        logo = objectInput.readUTF();
        courseId = objectInput.readLong();
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

        if (logo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(logo);
        }

        objectOutput.writeLong(courseId);
    }
}

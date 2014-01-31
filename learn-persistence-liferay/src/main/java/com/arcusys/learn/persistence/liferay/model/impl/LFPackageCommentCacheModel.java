package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageComment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LFPackageComment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageComment
 * @generated
 */
public class LFPackageCommentCacheModel implements CacheModel<LFPackageComment>,
    Externalizable {
    public long id;
    public Integer socialPackageID;
    public Integer authorID;
    public String comment;
    public long publishDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(id);
        sb.append(", socialPackageID=");
        sb.append(socialPackageID);
        sb.append(", authorID=");
        sb.append(authorID);
        sb.append(", comment=");
        sb.append(comment);
        sb.append(", publishDate=");
        sb.append(publishDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public LFPackageComment toEntityModel() {
        LFPackageCommentImpl lfPackageCommentImpl = new LFPackageCommentImpl();

        lfPackageCommentImpl.setId(id);
        lfPackageCommentImpl.setSocialPackageID(socialPackageID);
        lfPackageCommentImpl.setAuthorID(authorID);

        if (comment == null) {
            lfPackageCommentImpl.setComment(StringPool.BLANK);
        } else {
            lfPackageCommentImpl.setComment(comment);
        }

        if (publishDate == Long.MIN_VALUE) {
            lfPackageCommentImpl.setPublishDate(null);
        } else {
            lfPackageCommentImpl.setPublishDate(new Date(publishDate));
        }

        lfPackageCommentImpl.resetOriginalValues();

        return lfPackageCommentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        socialPackageID = objectInput.readInt();
        authorID = objectInput.readInt();
        comment = objectInput.readUTF();
        publishDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeInt(socialPackageID);
        objectOutput.writeInt(authorID);

        if (comment == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(comment);
        }

        objectOutput.writeLong(publishDate);
    }
}

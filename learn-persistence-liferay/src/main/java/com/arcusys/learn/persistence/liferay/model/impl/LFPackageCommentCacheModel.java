package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageComment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
* The cache model class for representing LFPackageComment in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFPackageComment
* @generated
*/
public class LFPackageCommentCacheModel implements CacheModel<LFPackageComment>,
    Serializable {
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
}

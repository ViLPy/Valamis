package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
* The cache model class for representing LFTincanLrsAttachment in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsAttachment
* @generated
*/
public class LFTincanLrsAttachmentCacheModel implements CacheModel<LFTincanLrsAttachment>,
    Serializable {
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

    public LFTincanLrsAttachment toEntityModel() {
        LFTincanLrsAttachmentImpl lfTincanLrsAttachmentImpl = new LFTincanLrsAttachmentImpl();

        lfTincanLrsAttachmentImpl.setId(id);
        lfTincanLrsAttachmentImpl.setParentID(parentID);
        lfTincanLrsAttachmentImpl.setUsageType(usageType);
        lfTincanLrsAttachmentImpl.setDisplay(display);
        lfTincanLrsAttachmentImpl.setDescription(description);
        lfTincanLrsAttachmentImpl.setContentType(contentType);
        lfTincanLrsAttachmentImpl.setLength(length);
        lfTincanLrsAttachmentImpl.setSha2(sha2);
        lfTincanLrsAttachmentImpl.setFileUrl(fileUrl);

        lfTincanLrsAttachmentImpl.resetOriginalValues();

        return lfTincanLrsAttachmentImpl;
    }
}

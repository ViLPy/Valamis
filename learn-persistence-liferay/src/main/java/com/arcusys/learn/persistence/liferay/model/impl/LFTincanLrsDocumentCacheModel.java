package com.arcusys.learn.persistence.liferay.model.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
* The cache model class for representing LFTincanLrsDocument in entity cache.
*
* @author Brian Wing Shun Chan
* @see LFTincanLrsDocument
* @generated
*/
public class LFTincanLrsDocumentCacheModel implements CacheModel<LFTincanLrsDocument>,
    Serializable {
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

    public LFTincanLrsDocument toEntityModel() {
        LFTincanLrsDocumentImpl lfTincanLrsDocumentImpl = new LFTincanLrsDocumentImpl();

        lfTincanLrsDocumentImpl.setId(id);
        lfTincanLrsDocumentImpl.setDocumentId(documentId);

        if (update == Long.MIN_VALUE) {
            lfTincanLrsDocumentImpl.setUpdate(null);
        } else {
            lfTincanLrsDocumentImpl.setUpdate(new Date(update));
        }

        lfTincanLrsDocumentImpl.setContent(content);
        lfTincanLrsDocumentImpl.setContentType(contentType);

        lfTincanLrsDocumentImpl.resetOriginalValues();

        return lfTincanLrsDocumentImpl;
    }
}

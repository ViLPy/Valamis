package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsDocumentException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsDocument;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsDocumentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the l f tincan lrs document local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsDocumentLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil
 */
public class LFTincanLrsDocumentLocalServiceImpl
    extends LFTincanLrsDocumentLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsDocumentLocalServiceUtil} to access the l f tincan lrs document local service.
     */

    public LFTincanLrsDocument createLFTincanLrsDocument() throws SystemException {
        return super.createLFTincanLrsDocument(counterLocalService.increment(LFTincanLrsDocument.class.getName()));
    }

    public LFTincanLrsDocument createLFTincanLrsDocument(String documentId, Date update, String contentType, String content) throws SystemException {
        LFTincanLrsDocument document = createLFTincanLrsDocument(counterLocalService.increment(LFTincanLrsDocument.class.getName()));
        document.setDocumentId(documentId);
        document.setUpdate(update);
        document.setContentType(contentType);
        document.setContent(content);
        lfTincanLrsDocumentPersistence.update(document, false);
        return document;
    }

    public void deleteLFTincanLrsDocument(String documentId) throws NoSuchLFTincanLrsDocumentException, SystemException {
        lfTincanLrsDocumentPersistence.remove( findByDocumentId(documentId));
    }

    public LFTincanLrsDocument findByDocumentId(String documentId) throws NoSuchLFTincanLrsDocumentException, SystemException {
        return lfTincanLrsDocumentPersistence.findByDocumentId(documentId);
    }

    public void removeAll() throws SystemException {
        lfTincanLrsDocumentPersistence.removeAll();
    }
}

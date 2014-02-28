package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsAttachment;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsAttachmentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f tincan lrs attachment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsAttachmentLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalServiceUtil
 */
public class LFTincanLrsAttachmentLocalServiceImpl
    extends LFTincanLrsAttachmentLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsAttachmentLocalServiceUtil} to access the l f tincan lrs attachment local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsAttachmentPersistence.removeAll();
    }

    public LFTincanLrsAttachment createLFTincanLrsAttachment() throws SystemException {
        return createLFTincanLrsAttachment(counterLocalService.increment(LFTincanLrsAttachment.class.getName()));
    }

    public List<LFTincanLrsAttachment> findByParentID(final Integer parentID) throws SystemException {
        return lfTincanLrsAttachmentPersistence.findByParentID(parentID);
    }
}

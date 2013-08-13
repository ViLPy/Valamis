package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageComment;
import com.arcusys.learn.persistence.liferay.service.base.LFPackageCommentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f package comment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageCommentLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFPackageCommentLocalServiceUtil
 */
public class LFPackageCommentLocalServiceImpl
    extends LFPackageCommentLocalServiceBaseImpl {

    public LFPackageComment createLFPackageComment() throws SystemException {
        return super.createLFPackageComment(counterLocalService.increment(LFPackageComment.class.getName()));
    }

    public List<LFPackageComment> findBySocialPackageID(final Integer packageID) throws SystemException {
        return lfPackageCommentPersistence.findBySocialPackageID(packageID);
    }

    public void removeAll() throws SystemException {
        lfPackageCommentPersistence.removeAll();
    }
}

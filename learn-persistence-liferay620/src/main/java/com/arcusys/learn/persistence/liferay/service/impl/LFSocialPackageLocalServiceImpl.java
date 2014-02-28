package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;
import com.arcusys.learn.persistence.liferay.service.base.LFSocialPackageLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f social package local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSocialPackageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSocialPackageLocalServiceUtil
 */
public class LFSocialPackageLocalServiceImpl
    extends LFSocialPackageLocalServiceBaseImpl {

    public LFSocialPackage createLFSocialPackage() throws SystemException {
        return super.createLFSocialPackage(counterLocalService.increment(LFSocialPackage.class.getName()));
    }

    public List<LFSocialPackage> findByAuthorID(final Integer authorID) throws SystemException {
        return lfSocialPackagePersistence.findByAuthorID(authorID);
    }

    public void removeAll() throws SystemException {
        lfSocialPackagePersistence.removeAll();
    }
}

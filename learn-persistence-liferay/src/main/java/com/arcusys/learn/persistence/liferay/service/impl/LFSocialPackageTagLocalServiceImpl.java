package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;
import com.arcusys.learn.persistence.liferay.service.base.LFSocialPackageTagLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f social package tag local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSocialPackageTagLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSocialPackageTagLocalServiceUtil
 */
public class LFSocialPackageTagLocalServiceImpl
    extends LFSocialPackageTagLocalServiceBaseImpl {

    public LFSocialPackageTag createLFSocialPackageTag() throws SystemException {
        return super.createLFSocialPackageTag(counterLocalService.increment(LFSocialPackageTag.class.getName()));
    }

    public List<LFSocialPackageTag> findByName(final String name) throws SystemException {
        return lfSocialPackageTagPersistence.findByName(name);
    }

    public List<LFSocialPackageTag> findBySocialPackageID(final Integer packageID) throws SystemException {
        return lfSocialPackageTagPersistence.findBySocialPackageID(packageID);
    }

    public void removeAll() throws SystemException {
        lfSocialPackageTagPersistence.removeAll();
    }
}

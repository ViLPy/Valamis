package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFPackageGradeStorageException;
import com.arcusys.learn.persistence.liferay.model.LFPackageGradeStorage;
import com.arcusys.learn.persistence.liferay.service.base.LFPackageGradeStorageLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f package grade storage local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageGradeStorageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalServiceUtil
 */
public class LFPackageGradeStorageLocalServiceImpl
    extends LFPackageGradeStorageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFPackageGradeStorageLocalServiceUtil} to access the l f package grade storage local service.
     */

    public LFPackageGradeStorage findGrade(long userId, long packageId) throws SystemException, NoSuchLFPackageGradeStorageException {
        return lfPackageGradeStoragePersistence.findByGrade(userId, packageId);
    }

    public void removeAll() throws SystemException {
        lfPackageGradeStoragePersistence.removeAll();
    }
}

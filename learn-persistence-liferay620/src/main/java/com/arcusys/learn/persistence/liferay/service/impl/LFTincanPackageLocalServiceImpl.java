package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackage;
import com.arcusys.learn.persistence.liferay.model.LFTincanPackage;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanPackageLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;

/**
 * The implementation of the l f tincan package local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanPackageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil
 */
public class LFTincanPackageLocalServiceImpl
    extends LFTincanPackageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanPackageLocalServiceUtil} to access the l f tincan package local service.
     */
    public LFTincanPackage createLFTincanPackage() throws SystemException {
        return createLFTincanPackage(counterLocalService.increment(LFPackage.class.getName()));
    }

    public LFTincanPackage findByRefID(Long refId) throws SystemException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTincanPackageException {
        return lfTincanPackagePersistence.findByRefID(refId);
    }

    public java.util.List<LFTincanPackage> findByPackageID(Long[] ids) throws SystemException {
        ArrayList<LFTincanPackage> list = new ArrayList<LFTincanPackage>();
        for (Long id: ids) {
            try {
                LFTincanPackage pkg = getLFTincanPackage(id);
                if (pkg != null) list.add(pkg);
            } catch (PortalException e) {
                // do nothing
            }
        }
        return list;
    }

    public  java.util.List<LFTincanPackage> findByInstance(Integer[] courseIDs) throws  SystemException{
        return lfTincanPackagePersistence.findByInstance(courseIDs);
    }

    public  java.util.List<LFTincanPackage> findByCourseID(Integer courseID) throws  SystemException{
        return lfTincanPackagePersistence.findByCourseID(courseID);
    }

    public java.util.List<LFTincanPackage> findByTitleAndCourseID(String titlePattern, Integer[] courseIDs) throws  SystemException{
        return lfTincanPackagePersistence.findByTitleAndCourseID(titlePattern, courseIDs);
    }

    public int countByTitleAndCourseID(String titlePattern, Integer[] courseIDs) throws  SystemException{
        return lfTincanPackagePersistence.countByTitleAndCourseID(titlePattern, courseIDs);
    }

    @Override
    public LFTincanPackage getLFTincanPackage(final long id) throws PortalException, SystemException {
        try {
            return super.getLFTincanPackage(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

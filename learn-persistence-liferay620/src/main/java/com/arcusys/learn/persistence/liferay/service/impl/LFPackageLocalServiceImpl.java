package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackage;
import com.arcusys.learn.persistence.liferay.service.base.LFPackageLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;

/**
 * The implementation of the l f package local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFPackageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil
 */
public class LFPackageLocalServiceImpl extends LFPackageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFPackageLocalServiceUtil} to access the l f package local service.
     */
    public LFPackage createLFPackage() throws SystemException {
        return createLFPackage(counterLocalService.increment(LFPackage.class.getName()));
    }

    public LFPackage findByRefID(Long refId) throws SystemException,
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageException{
        return lfPackagePersistence.findByRefID(refId);
    }

    public java.util.List<LFPackage> findByPackageID(Long[] ids) throws SystemException {
        ArrayList<LFPackage> list = new ArrayList<LFPackage>();
        for (Long id: ids) {
            try {
                LFPackage pkg = getLFPackage(id);
                if (pkg != null) list.add(pkg);
            } catch (PortalException e) {
                // do nothing
            }
        }
        return list;
    }

    public  java.util.List<LFPackage> findByInstance(Integer[] courseIDs) throws  SystemException{
        return lfPackagePersistence.findByInstance(courseIDs);
    }

    public  java.util.List<LFPackage> findByCourseID(Integer courseID) throws  SystemException{
        return lfPackagePersistence.findByCourseID(courseID);
    }

    public void removeAll() throws SystemException {
        lfPackagePersistence.removeAll();
    }

    public java.util.List<LFPackage> findByTitleAndCourseID(String titlePattern, Integer[] courseIDs) throws SystemException{
        return lfPackagePersistence.findByTitleAndCourseID(titlePattern, courseIDs);
    }

    public int countByTitleAndCourseID(String titlePattern, Integer[] courseIDs) throws SystemException{
        return lfPackagePersistence.countByTitleAndCourseID(titlePattern, courseIDs);
    }

    @Override
    public LFPackage getLFPackage(final long id) throws PortalException, SystemException {
        try {
            return super.getLFPackage(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

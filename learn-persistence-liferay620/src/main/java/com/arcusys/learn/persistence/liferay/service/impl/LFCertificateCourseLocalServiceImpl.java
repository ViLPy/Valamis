package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateCourseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f certificate course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateCourseLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalServiceUtil
 */
public class LFCertificateCourseLocalServiceImpl
    extends LFCertificateCourseLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateCourseLocalServiceUtil} to access the l f certificate course local service.
     */

    public List<LFCertificateCourse> findByCertificateID(Long certificateID)
            throws SystemException {
        return lfCertificateCoursePersistence.findByCertificateID(certificateID);
    }

    public List<LFCertificateCourse> findByCourseID(Long courseID)
            throws SystemException {
        return lfCertificateCoursePersistence.findByCourseID(courseID);
    }

    public LFCertificateCourse findByCertificateIDAndSiteID(Long certificateID, Long siteID)
            throws SystemException, NoSuchLFCertificateCourseException {
        return lfCertificateCoursePersistence.findByCertificateIDAndCourseID(certificateID, siteID);
    }

    public void removeAll() throws SystemException {
        lfCertificateCoursePersistence.removeAll();
    }
}

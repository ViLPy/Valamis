package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateCourseException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateActivity;
import com.arcusys.learn.persistence.liferay.model.LFCertificateCourse;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateActivityLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateActivityPK;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f certificate activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalServiceUtil
 */
public class LFCertificateActivityLocalServiceImpl
    extends LFCertificateActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateActivityLocalServiceUtil} to access the l f certificate activity local service.
     */

    public LFCertificateActivity createLFCertificateActivity(Long certificateID, String activityName) {
        return super.createLFCertificateActivity(new LFCertificateActivityPK(certificateID, activityName));
    }

    public List<LFCertificateActivity> findByCertificateID(Long certificateID)
            throws SystemException {
        return lfCertificateActivityPersistence.findByCertificateID(certificateID);
    }

    public List<LFCertificateActivity> findByActivityName(String activityName)
            throws SystemException {
        return lfCertificateActivityPersistence.findByActivityName(activityName);
    }

    public LFCertificateActivity findByCertificateIDAndActivityName(Long certificateID, String activityName)
            throws SystemException, NoSuchLFCertificateCourseException {
        return lfCertificateActivityPersistence.fetchByCertificateIDAndActivityName(certificateID, activityName);
    }

    public void removeAll() throws SystemException {
        lfCertificateCoursePersistence.removeAll();
    }
}

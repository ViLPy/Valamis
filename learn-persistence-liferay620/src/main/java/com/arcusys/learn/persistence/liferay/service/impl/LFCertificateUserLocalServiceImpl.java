package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import java.util.List;
/**
 * The implementation of the l f certificate user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateUserLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil
 */
public class LFCertificateUserLocalServiceImpl
    extends LFCertificateUserLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateUserLocalServiceUtil} to access the l f certificate user local service.
     */

//    public LFCertificateUser createLFCertificateUser() throws SystemException {
//        return createLFCertificateUser(counterLocalService.increment(LFCertificateUser.class.getName()));
//    }

    public List<LFCertificateUser> findByCertificateID(Long certificateID)
            throws SystemException {
        return lfCertificateUserPersistence.findByCertificateID(certificateID);
    }

    public List<LFCertificateUser> findByUserID(Long userID)
            throws SystemException {
        return lfCertificateUserPersistence.findByUserID(userID);
    }

    public LFCertificateUser findByUserIDAndCertificateID(Long userID, Long certificateID)
            throws SystemException, com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException {
        return lfCertificateUserPersistence.findByUserIDAndCertificateID(userID, certificateID);
    }

    public void removeByUserIDAndCertificateID(Long userID, Long certificateID) throws SystemException, com.arcusys.learn.persistence.liferay.NoSuchLFCertificateUserException{
        lfCertificateUserPersistence.removeByUserIDAndCertificateID(userID,  certificateID);
    }

    public void removeAll() throws SystemException {
        lfCertificateUserPersistence.removeAll();
    }
}

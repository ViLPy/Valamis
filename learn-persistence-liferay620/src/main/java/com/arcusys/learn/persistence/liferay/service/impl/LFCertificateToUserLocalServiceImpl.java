package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateToUser;
import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateToUserLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFCertificateToUserPK;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f certificate to user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateToUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateToUserLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateToUserLocalServiceUtil
 */
public class LFCertificateToUserLocalServiceImpl
    extends LFCertificateToUserLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateToUserLocalServiceUtil} to access the l f certificate to user local service.
     */
    public LFCertificateToUser createLFCertificateUser(Integer userId, Integer certificateId) throws SystemException {
        LFCertificateToUserPK pk = new LFCertificateToUserPK(certificateId, userId);
        return createLFCertificateToUser(pk);
    }

    public List<LFCertificateToUser> findByCertificateID(Integer certificateID)
            throws SystemException {
        return lfCertificateToUserPersistence.findByCertificateID(certificateID);
    }

    public List<LFCertificateToUser> findByUserID(Integer userID)
            throws SystemException {
        return lfCertificateToUserPersistence.findByUserID(userID);
    }

    public List<LFCertificateToUser> findByUserIDAndCertificateID(Integer userID, Integer certificateID)
            throws SystemException {
        return lfCertificateToUserPersistence.findByUserIDAndCertificateID(userID, certificateID);
    }

    public void removeByUserIDAndCertificateID(Integer userID, Integer certificateID) throws SystemException{
        lfCertificateToUserPersistence.removeByUserIDAndCertificateID(userID,  certificateID);
    }

    public void removeAll() throws SystemException {
        lfCertificateToUserPersistence.removeAll();
    }
}

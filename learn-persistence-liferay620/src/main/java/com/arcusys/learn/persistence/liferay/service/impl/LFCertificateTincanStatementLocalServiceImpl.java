package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException;
import com.arcusys.learn.persistence.liferay.model.LFCertificateTincanStatement;
import com.arcusys.learn.persistence.liferay.model.LFCertificateUser;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateTincanStatementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f certificate tincan statement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateTincanStatementLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalServiceUtil
 */
public class LFCertificateTincanStatementLocalServiceImpl
    extends LFCertificateTincanStatementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateTincanStatementLocalServiceUtil} to access the l f certificate tincan statement local service.
     */

    public List<LFCertificateTincanStatement> findByCertificateID(Long certificateID)
            throws SystemException {
        return lfCertificateTincanStatementPersistence.findByCertificateID(certificateID);
    }

    public List<LFCertificateTincanStatement> findByVerb(String verb)
            throws SystemException {
        return lfCertificateTincanStatementPersistence.findByVerb(verb);
    }

    public List<LFCertificateTincanStatement> findByStatementObject(String obj)
            throws SystemException {
        return lfCertificateTincanStatementPersistence.findByObject(obj);
    }

    public List<LFCertificateTincanStatement> findByVerbAndObject(String verb, String obj)
            throws SystemException, NoSuchLFCertificateTincanStatementException {
        return lfCertificateTincanStatementPersistence.findByVerbAndObject(verb, obj);
    }

    public LFCertificateTincanStatement findByCertificateIDAndVerbAndObject(Long certificateID, String verb, String obj)
            throws SystemException, NoSuchLFCertificateTincanStatementException {
        return lfCertificateTincanStatementPersistence.findByCertificateIDAndVerbAndObject(certificateID, verb, obj);
    }

    public void removeByUserIDAndCertificateID(Long certificateID, String verb, String obj) throws SystemException, com.arcusys.learn.persistence.liferay.NoSuchLFCertificateTincanStatementException{
        lfCertificateTincanStatementPersistence.removeByCertificateIDAndVerbAndObject(certificateID, verb, obj);
    }

    public void removeAll() throws SystemException {
        lfCertificateUserPersistence.removeAll();
    }
}

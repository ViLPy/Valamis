package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificate;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the l f certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateLocalServiceUtil
 */
public class LFCertificateLocalServiceImpl
    extends LFCertificateLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateLocalServiceUtil} to access the l f certificate local service.
     */

    public LFCertificate createLFCertificate() throws SystemException {
        return createLFCertificate(counterLocalService.increment(LFCertificate.class.getName()));
    }

    public void removeAll() throws SystemException {
        lfCertificatePersistence.removeAll();
    }
}

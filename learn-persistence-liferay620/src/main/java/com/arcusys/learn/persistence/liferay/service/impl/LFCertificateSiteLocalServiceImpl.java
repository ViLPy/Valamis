package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFCertificateSite;
import com.arcusys.learn.persistence.liferay.service.base.LFCertificateSiteLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import java.util.List;
/**
 * The implementation of the l f certificate site local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFCertificateSiteLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalServiceUtil
 */
public class LFCertificateSiteLocalServiceImpl
    extends LFCertificateSiteLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalServiceUtil} to access the l f certificate site local service.
     */

    public LFCertificateSite createLFCertificateSite() throws SystemException {
        return createLFCertificateSite(counterLocalService.increment(LFCertificateSite.class.getName()));
    }

    public List<LFCertificateSite> findByCertificateID(Integer certificateID)
            throws SystemException {
        return lfCertificateSitePersistence.findByCertificateID(certificateID);
    }

    public List<LFCertificateSite> findByCertificateIDAndSiteID(Integer certificateID, Integer siteID)
            throws SystemException {
        return lfCertificateSitePersistence.findByCertificateIDAndSiteID(certificateID, siteID);
    }
    public List<LFCertificateSite> findByCertificateIDAndSiteID(Integer[] certificateID, Integer siteID)
            throws SystemException {
        return lfCertificateSitePersistence.findByCertificateIDAndSiteID(certificateID, siteID);
    }
    public void removeAll() throws SystemException {
        lfCertificateSitePersistence.removeAll();
    }

}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFActivityException;
import com.arcusys.learn.persistence.liferay.model.LFActivity;
import com.arcusys.learn.persistence.liferay.service.base.LFActivityLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil
 */
public class LFActivityLocalServiceImpl extends LFActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFActivityLocalServiceUtil} to access the l f activity local service.
     */
    public LFActivity createLFActivity() throws SystemException {
        return createLFActivity(counterLocalService.increment(LFActivity.class.getName()));
    }

    public LFActivity findByPackageAndID(Integer packageID, String id)
            throws com.liferay.portal.kernel.exception.SystemException {
        try {
            return lfActivityPersistence.findByPackageAndID(packageID, id);
        } catch (NoSuchLFActivityException e) {
            return null;
        }
    }

    public java.util.List<LFActivity> findByPackageID(Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return lfActivityPersistence.findByPackageID(packageID);
    }

    public java.util.List<LFActivity> findByPackageIDAndOrganizationID(Integer packageID, String organizationID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfActivityPersistence.findByPackageIDAndOrganizationID(packageID, organizationID);
    }

    public java.util.List<LFActivity> findByPackageIDAndParentID(Integer packageID, String parentID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfActivityPersistence.findByPackageIDAndParentID(packageID, parentID);
    }

    public void removeAll() throws SystemException {
        lfActivityPersistence.removeAll();
    }

    @Override
    public LFActivity getLFActivity(final long id) throws PortalException, SystemException {
        try {
            return super.getLFActivity(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

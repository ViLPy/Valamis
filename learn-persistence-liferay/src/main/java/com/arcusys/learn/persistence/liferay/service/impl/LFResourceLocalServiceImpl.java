package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFResource;
import com.arcusys.learn.persistence.liferay.service.base.LFResourceLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f resource local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFResourceLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFResourceLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil
 */
public class LFResourceLocalServiceImpl extends LFResourceLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFResourceLocalServiceUtil} to access the l f resource local service.
     */

    public LFResource createLFResource() throws SystemException {
        return super.createLFResource(counterLocalService.increment(LFResource.class.getName()));
    }

    public List<LFResource> findByPackageID(final Integer packageID) throws SystemException {
        return lfResourcePersistence.findByPackageID(packageID, -1, -1);
    }

    public List<LFResource> findByPackageIDAndResourceID(final Integer packageID, final String resourceID, int start, int end) throws SystemException {
        return lfResourcePersistence.findByPackageIDAndResourceID(packageID, resourceID, start, end);
    }

    public void removeAll() throws SystemException {
        lfResourcePersistence.removeAll();
    }

    @Override
    public LFResource getLFResource(final long id) throws PortalException, SystemException {
        try {
            return super.getLFResource(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

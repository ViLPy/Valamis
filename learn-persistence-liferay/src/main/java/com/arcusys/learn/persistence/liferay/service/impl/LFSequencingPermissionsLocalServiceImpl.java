package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.service.base.LFSequencingPermissionsLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.model.LFSequencingPermissions;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the l f sequencing permissions local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSequencingPermissionsLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil
 */
public class LFSequencingPermissionsLocalServiceImpl
    extends LFSequencingPermissionsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFSequencingPermissionsLocalServiceUtil} to access the l f sequencing permissions local service.
     */
    public LFSequencingPermissions createLFSequencingPermissions() throws SystemException {
        return createLFSequencingPermissions(counterLocalService.increment(LFSequencingPermissions.class.getName()));
    }
    public java.util.List<LFSequencingPermissions> findBySequencingID(Integer sequencingID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfSequencingPermissionsPersistence.findBySequencingID(sequencingID);
    }
    public void removeBySequencingID(Integer sequencingID)
            throws  com.liferay.portal.kernel.exception.SystemException {
        lfSequencingPermissionsPersistence.removeBySequencingID(sequencingID);
    }

    public void removeAll() throws SystemException {
        lfSequencingPermissionsPersistence.removeAll();
    }

    @Override
    public LFSequencingPermissions getLFSequencingPermissions(final long id) throws PortalException, SystemException {
        try {
            return super.getLFSequencingPermissions(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

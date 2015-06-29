package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSeqPermissions;
import com.arcusys.learn.persistence.liferay.service.base.LFSeqPermissionsLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the l f seq permissions local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSeqPermissionsLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalServiceUtil
 */
public class LFSeqPermissionsLocalServiceImpl
    extends LFSeqPermissionsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFSeqPermissionsLocalServiceUtil} to access the l f seq permissions local service.
     */
    public LFSeqPermissions createLFSequencingPermissions() throws SystemException {
        return createLFSeqPermissions(counterLocalService.increment(LFSeqPermissions.class.getName()));
    }
    public java.util.List<LFSeqPermissions> findBySequencingID(Integer sequencingID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfSeqPermissionsPersistence.findBySequencingID(sequencingID);
    }
    public void removeBySequencingID(Integer sequencingID)
            throws  com.liferay.portal.kernel.exception.SystemException {
        lfSeqPermissionsPersistence.removeBySequencingID(sequencingID);
    }

    public void removeAll() throws SystemException {
        lfSeqPermissionsPersistence.removeAll();
    }

    @Override
    public LFSeqPermissions getLFSeqPermissions(final long id) throws PortalException, SystemException {
        try {
            return super.getLFSeqPermissions(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFRole;
import com.arcusys.learn.persistence.liferay.service.base.LFRoleLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f role local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFRoleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRoleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil
 */
public class LFRoleLocalServiceImpl extends LFRoleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFRoleLocalServiceUtil} to access the l f role local service.
     */

    public LFRole createLFRole() throws SystemException {
        return super.createLFRole(counterLocalService.increment(LFRole.class.getName()));
    }

    public List<LFRole> findByPermission(final String permission) throws SystemException {
        return lfRolePersistence.findByPermission(permission);
    }
    public List<LFRole> findByRoleIDAndPermission(final Integer roleID, final String permission) throws SystemException {
        return lfRolePersistence.findByRoleIDAndPermission(roleID, permission);
    }
    public List<LFRole> findByDefaultAndPermission(final String permission, final Boolean isDefault) throws SystemException{
        return lfRolePersistence.findByDefaultAndPermission(isDefault, permission);
    }

    public void removeByRoleIDAndPermission(Integer liferayRoleID, String permission)
            throws com.liferay.portal.kernel.exception.SystemException{
        lfRolePersistence.removeByRoleIDAndPermission(liferayRoleID, permission);
    }

    public void removeAll() throws SystemException {
        lfRolePersistence.removeAll();
    }
}

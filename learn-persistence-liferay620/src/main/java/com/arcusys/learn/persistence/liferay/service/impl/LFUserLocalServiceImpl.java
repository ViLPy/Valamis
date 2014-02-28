package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFUser;
import com.arcusys.learn.persistence.liferay.service.base.LFUserLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the l f user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFUserLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFUserLocalServiceUtil
 */
public class LFUserLocalServiceImpl extends LFUserLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFUserLocalServiceUtil} to access the l f user local service.
     */
    public LFUser createLFUser() throws SystemException {
        return createLFUser(counterLocalService.increment(LFUser.class.getName()));
    }

    public LFUser findByUserId(Integer id)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException, com.liferay.portal.kernel.exception.SystemException {
        return lfUserPersistence.findByUserId(id);
    }

    public void removeByUserId(Integer id)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFUserException,
            com.liferay.portal.kernel.exception.SystemException {
        lfUserPersistence.removeByUserId(id);
    }

    public java.util.List<LFUser> findByUserIds(Integer[] ids)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfUserPersistence.findByUserIdCollection(ids);
    }

    public void removeAll() throws SystemException {
        lfUserPersistence.removeAll();
    }

    @Override
    public LFUser getLFUser(final long id) throws PortalException, SystemException {
        try {
            return super.getLFUser(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

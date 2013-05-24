package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFAttemptException;
import com.arcusys.learn.persistence.liferay.model.LFAttempt;
import com.arcusys.learn.persistence.liferay.service.base.LFAttemptLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f attempt local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFAttemptLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAttemptLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil
 */
public class LFAttemptLocalServiceImpl extends LFAttemptLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFAttemptLocalServiceUtil} to access the l f attempt local service.
     */
    public LFAttempt createLFAttempt() throws SystemException {
        return super.createLFAttempt(counterLocalService.increment(LFAttempt.class.getName()));
    }

    public List<LFAttempt> findByUserIDPackageIDIsComplete(Integer userID, Integer packageID, Boolean isComplete)
            throws SystemException {
        return lfAttemptPersistence.findByUserIDPackageIDIsComplete(userID, packageID, isComplete);
    }

    public List<LFAttempt> findByPackageID(Integer packageID)
            throws SystemException {
        return lfAttemptPersistence.findByPackageID(packageID);
    }

    public List<LFAttempt> findByUserID(Integer userID)
            throws SystemException {
        return lfAttemptPersistence.findByUserID(userID);
    }

    public void removeAll() throws SystemException {
        lfAttemptPersistence.removeAll();
    }

    @Override
    public LFAttempt getLFAttempt(final long id) throws PortalException, SystemException {
        try {
            return super.getLFAttempt(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

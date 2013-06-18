package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityDataMap;
import com.arcusys.learn.persistence.liferay.service.base.LFActivityDataMapLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f activity data map local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityDataMapLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil
 */
public class LFActivityDataMapLocalServiceImpl
        extends LFActivityDataMapLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFActivityDataMapLocalServiceUtil} to access the l f activity data map local service.
     */
    public LFActivityDataMap createLFAttemptData() throws SystemException {
        return super.createLFActivityDataMap(counterLocalService.increment(LFActivityDataMap.class.getName()));
    }

    public List<LFActivityDataMap> findByPackageIDAndActivityID(final Integer packageID, final String activityID)
            throws SystemException {
        return lfActivityDataMapPersistence.findByPackageIDAndActivityID(packageID, activityID);
    }

    public void removeByPackageIDAndActivityID(final Integer packageID, final String activityID)
            throws SystemException {
        lfActivityDataMapPersistence.removeByPackageIDAndActivityID(packageID, activityID);
    }

    public void removeAll() throws SystemException {
        lfActivityDataMapPersistence.removeAll();
    }

    @Override
    public LFActivityDataMap getLFActivityDataMap(final long id) throws PortalException, SystemException {
        try {
            return super.getLFActivityDataMap(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

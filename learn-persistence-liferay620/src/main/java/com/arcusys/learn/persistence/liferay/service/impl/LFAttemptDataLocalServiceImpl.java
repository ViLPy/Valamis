package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFAttemptData;
import com.arcusys.learn.persistence.liferay.service.base.LFAttemptDataLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f attempt data local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAttemptDataLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil
 */
public class LFAttemptDataLocalServiceImpl
        extends LFAttemptDataLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFAttemptDataLocalServiceUtil} to access the l f attempt data local service.
     */

    public LFAttemptData createLFAttemptData() throws SystemException {
        return super.createLFAttemptData(counterLocalService.increment(LFAttemptData.class.getName()));
    }

    public List<LFAttemptData> findByAttemptIDWithActivityID(final Integer attemptID, final String activityID)
            throws SystemException {
        return lfAttemptDataPersistence.findByAttemptIDWithActivityID(attemptID, activityID);
    }

    public List<LFAttemptData> findByAttemptIDWithDataKey(final Integer attemptID, final String dataKey)
            throws SystemException {
        return lfAttemptDataPersistence.findByAttemptIDWithDataKey(attemptID, dataKey);
    }

    public List<LFAttemptData> findBySingleKey(final Integer attemptID, final String activityID, final String dataKey, int start, int end)
            throws SystemException {
        return lfAttemptDataPersistence.findBySingleKey(attemptID, activityID, dataKey, start, end);
    }

    public List<LFAttemptData> findByCollectionValues(final Integer attemptID, final String activityID, final String dataKey)
            throws SystemException {
        return lfAttemptDataPersistence.findByCollectionValues(attemptID, activityID, dataKey);
    }

    public void removeAll() throws SystemException {
        lfAttemptDataPersistence.removeAll();
    }

    @Override
    public LFAttemptData getLFAttemptData(final long id) throws PortalException, SystemException {
        try {
            return super.getLFAttemptData(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFActivityState;
import com.arcusys.learn.persistence.liferay.service.base.LFActivityStateLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f activity state local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalServiceUtil
 */
public class LFActivityStateLocalServiceImpl
    extends LFActivityStateLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFActivityStateLocalServiceUtil} to access the l f activity state local service.
     */
    public LFActivityState createLFActivityState() throws SystemException {
        return super.createLFActivityState(counterLocalService.increment(LFActivityState.class.getName()));
    }

    public List<LFActivityState> findByActivityStateNodeIDAndActivityID(final Integer[] activityStateNodeID, String activityID) throws SystemException {
        return lfActivityStatePersistence.findByActivityStateNodeIDAndActivityID(activityStateNodeID, activityID, 0, 1);
    }

    public List<LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(String activityID, final Integer[] activityStateNodeID, Integer activityStateTreeID) throws SystemException {
        return lfActivityStatePersistence.findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID, activityStateNodeID, activityStateTreeID, -1, -1);
    }

    public List<LFActivityState> findByActivityStateNodeID(final Integer[] activityStateNodeID) throws SystemException {
        return lfActivityStatePersistence.findByActivityStateNodeID(activityStateNodeID, 0, 1);
    }

    public void removeAll() throws SystemException {
        lfActivityStatePersistence.removeAll();
    }

    @Override
    public LFActivityState getLFActivityState(final long id) throws PortalException, SystemException {
        try {
            return super.getLFActivityState(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsState;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs state local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil
 */
public class LFTincanLrsStateLocalServiceImpl
    extends LFTincanLrsStateLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStateLocalServiceUtil} to access the l f tincan lrs state local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsStatePersistence.removeAll();
    }

    public LFTincanLrsState createLFTincanLrsState() throws SystemException {
        return createLFTincanLrsState(counterLocalService.increment(LFTincanLrsState.class.getName()));
    }

    public java.util.List<LFTincanLrsState> findByActivityId(String activityId) throws SystemException{
        return lfTincanLrsStatePersistence.findByActivityId(activityId);
    }

    public java.util.List<LFTincanLrsState> findByActivityIdAndStateId(String activityId, String stateId) throws SystemException{
        return lfTincanLrsStatePersistence.findByActivityIdAndStateId(activityId, stateId);
    }

    public java.util.List<LFTincanLrsState> findByActivityIdAndAgentId(String activityId, Integer agentId) throws SystemException{
        return lfTincanLrsStatePersistence.findByActivityIdAndAgentId(activityId, agentId);
    }

    public LFTincanLrsState findByStateDocument(String activityId, String stateId, Integer agentId, String registration) throws SystemException{
        return lfTincanLrsStatePersistence.fetchByStateDocument(activityId, stateId, agentId, registration);
    }
}

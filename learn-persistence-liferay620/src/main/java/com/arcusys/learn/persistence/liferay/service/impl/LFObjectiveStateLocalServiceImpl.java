package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveStateException;
import com.arcusys.learn.persistence.liferay.model.LFObjectiveState;
import com.arcusys.learn.persistence.liferay.service.base.LFObjectiveStateLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f objective state local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFObjectiveStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFObjectiveStateLocalServiceUtil
 */
public class LFObjectiveStateLocalServiceImpl
    extends LFObjectiveStateLocalServiceBaseImpl {

    public LFObjectiveState createLFObjectiveState() throws SystemException {
        return createLFObjectiveState(counterLocalService.increment(LFObjectiveState.class.getName()));
    }

    public LFObjectiveState findByMapKeyAndActivityStateID(String mapKey, Integer activityStateID)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFObjectiveStateException {
        return lfObjectiveStatePersistence.findByMapKeyAndActivityStateID(mapKey, activityStateID);
    }

    public java.util.List<LFObjectiveState> findByActivityStateID(Integer activityStateID, int start, int end)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return lfObjectiveStatePersistence.findByActivityStateID(activityStateID, start, end);
    }

    public void removeAll() throws SystemException {
        lfObjectiveStatePersistence.removeAll();
    }

    @Override
    public LFObjectiveState getLFObjectiveState(final long id) throws PortalException, SystemException {
        try {
            return super.getLFObjectiveState(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

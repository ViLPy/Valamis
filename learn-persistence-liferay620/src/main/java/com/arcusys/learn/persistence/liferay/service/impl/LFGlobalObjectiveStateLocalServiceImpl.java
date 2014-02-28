package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException;
import com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState;
import com.arcusys.learn.persistence.liferay.service.base.LFGlobalObjectiveStateLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f global objective state local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFGlobalObjectiveStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFGlobalObjectiveStateLocalServiceUtil
 */
public class LFGlobalObjectiveStateLocalServiceImpl
        extends LFGlobalObjectiveStateLocalServiceBaseImpl {

    public LFGlobalObjectiveState createLFGlobalObjectiveState() throws SystemException {
        return createLFGlobalObjectiveState(counterLocalService.increment(LFGlobalObjectiveState.class.getName()));
    }

    public java.util.List<LFGlobalObjectiveState> findByTreeID(Integer treeID, int start, int end)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return lfGlobalObjectiveStatePersistence.findByTreeID(treeID, start, end);
    }

    public LFGlobalObjectiveState findByTreeIDAndMapKey(Integer treeID, String mapKey)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFGlobalObjectiveStateException {
        return lfGlobalObjectiveStatePersistence.findByTreeIDAndMapKey(treeID, mapKey);
    }

    public void removeAll() throws SystemException {
        lfGlobalObjectiveStatePersistence.removeAll();
    }

    @Override
    public LFGlobalObjectiveState getLFGlobalObjectiveState(final long id) throws PortalException, SystemException {
        try {
            return super.getLFGlobalObjectiveState(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

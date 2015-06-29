package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFGlblObjectiveStateException;
import com.arcusys.learn.persistence.liferay.model.LFGlblObjectiveState;
import com.arcusys.learn.persistence.liferay.service.base.LFGlblObjectiveStateLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f glbl objective state local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFGlblObjectiveStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalServiceUtil
 */
public class LFGlblObjectiveStateLocalServiceImpl
    extends LFGlblObjectiveStateLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFGlblObjectiveStateLocalServiceUtil} to access the l f glbl objective state local service.
     */
    public LFGlblObjectiveState createLFGlobalObjectiveState() throws SystemException {
        return createLFGlblObjectiveState(counterLocalService.increment(LFGlblObjectiveState.class.getName()));
    }

    public java.util.List<LFGlblObjectiveState> findByTreeID(Integer treeID, int start, int end)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return lfGlblObjectiveStatePersistence.findByTreeID(treeID, start, end);
    }

    public LFGlblObjectiveState findByTreeIDAndMapKey(Integer treeID, String mapKey)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException, NoSuchLFGlblObjectiveStateException {
        return lfGlblObjectiveStatePersistence.findByTreeIDAndMapKey(treeID, mapKey);
    }

    public void removeAll() throws SystemException {
        lfGlblObjectiveStatePersistence.removeAll();
    }

    @Override
    public LFGlblObjectiveState getLFGlblObjectiveState(final long id) throws PortalException, SystemException {
        try {
            return super.getLFGlblObjectiveState(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

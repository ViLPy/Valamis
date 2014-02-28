package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjective;
import com.arcusys.learn.persistence.liferay.service.base.LFObjectiveLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f objective local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFObjectiveLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil
 */
public class LFObjectiveLocalServiceImpl extends LFObjectiveLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFObjectiveLocalServiceUtil} to access the l f objective local service.
     */

    public LFObjective createLFObjective() throws SystemException {
        return createLFObjective(counterLocalService.increment(LFObjective.class.getName()));
    }

    public java.util.List<LFObjective> findBySequencingIDAndIsPrimary(Integer sequencingID, boolean isPrimary)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return lfObjectivePersistence.findBySequencingIDAndIsPrimary(sequencingID, isPrimary);
    }

    public java.util.List<LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(Integer sequencingID, boolean isPrimary, String identifier)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return lfObjectivePersistence.findBySequencingIDIsPrimaryIdentifier(sequencingID, isPrimary, identifier);
    }

    public void removeAll() throws SystemException {
        lfObjectivePersistence.removeAll();
    }

    @Override
    public LFObjective getLFObjective(final long id) throws PortalException, SystemException {
        try {
            return super.getLFObjective(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

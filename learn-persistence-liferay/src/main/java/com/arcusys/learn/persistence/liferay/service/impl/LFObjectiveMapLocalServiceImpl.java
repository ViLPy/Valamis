package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;
import com.arcusys.learn.persistence.liferay.service.base.LFObjectiveMapLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f objective map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFObjectiveMapLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil
 */
public class LFObjectiveMapLocalServiceImpl
    extends LFObjectiveMapLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFObjectiveMapLocalServiceUtil} to access the l f objective map local service.
     */
    public LFObjectiveMap createLFObjectiveMap() throws SystemException {
        return createLFObjectiveMap(counterLocalService.increment(LFObjectiveMap.class.getName()));
    }
    public java.util.List<LFObjectiveMap> findByObjectiveID(Integer objectiveID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfObjectiveMapPersistence.findByObjectiveID(objectiveID);
    }
    public void removeByObjectiveID(Integer objectiveID)
            throws  com.liferay.portal.kernel.exception.SystemException {
        lfObjectiveMapPersistence.removeByObjectiveID(objectiveID);
    }

    public void removeAll() throws SystemException {
        lfObjectiveMapPersistence.removeAll();
    }

    @Override
    public LFObjectiveMap getLFObjectiveMap(final long id) throws PortalException, SystemException {
        try {
            return super.getLFObjectiveMap(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

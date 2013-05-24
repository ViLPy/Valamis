package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.service.base.LFSequencingTrackingLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.model.LFSequencingTracking;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f sequencing tracking local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSequencingTrackingLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil
 */
public class LFSequencingTrackingLocalServiceImpl
    extends LFSequencingTrackingLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFSequencingTrackingLocalServiceUtil} to access the l f sequencing tracking local service.
     */
    public LFSequencingTracking createLFSequencingTracking() throws SystemException {
        return createLFSequencingTracking(counterLocalService.increment(LFSequencingTracking.class.getName()));
    }
    public java.util.List<LFSequencingTracking> findBySequencingID(Integer sequencingID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfSequencingTrackingPersistence.findBySequencingID(sequencingID);
    }
    public void removeBySequencingID(Integer sequencingID)
            throws  com.liferay.portal.kernel.exception.SystemException {
        lfSequencingTrackingPersistence.removeBySequencingID(sequencingID);
    }

    public void removeAll() throws SystemException {
        lfSequencingTrackingPersistence.removeAll();
    }

    @Override
    public LFSequencingTracking getLFSequencingTracking(final long id) throws PortalException, SystemException {
        try {
            return super.getLFSequencingTracking(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

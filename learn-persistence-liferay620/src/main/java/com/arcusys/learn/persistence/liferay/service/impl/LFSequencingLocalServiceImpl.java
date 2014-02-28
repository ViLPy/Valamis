package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSequencing;
import com.arcusys.learn.persistence.liferay.service.base.LFSequencingLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f sequencing local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSequencingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSequencingLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil
 */
public class LFSequencingLocalServiceImpl
    extends LFSequencingLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFSequencingLocalServiceUtil} to access the l f sequencing local service.
     */
    public LFSequencing createLFSequencing() throws SystemException {
        return createLFSequencing(counterLocalService.increment(LFSequencing.class.getName()));
    }

    public LFSequencing findByActivityIDAndPackageID(Integer packageID, String activityID)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException{
        return lfSequencingPersistence.findByActivityIDAndPackageID(packageID, activityID);
    }

    public LFSequencing removeByActivityIDAndPackageID(Integer packageID, String activityID)
            throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.liferay.portal.kernel.exception.SystemException{
        return lfSequencingPersistence.removeByActivityIDAndPackageID(packageID, activityID);

    }

    public void removeAll() throws SystemException {
        lfSequencingPersistence.removeAll();
    }

    @Override
    public LFSequencing getLFSequencing(final long id) throws PortalException, SystemException {
        try {
            return super.getLFSequencing(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

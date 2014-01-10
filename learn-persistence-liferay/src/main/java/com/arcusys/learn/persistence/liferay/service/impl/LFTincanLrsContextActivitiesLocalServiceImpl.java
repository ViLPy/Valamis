package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsContextActivitiesLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan lrs context activities local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextActivitiesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsContextActivitiesLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextActivitiesLocalServiceUtil
 */
public class LFTincanLrsContextActivitiesLocalServiceImpl
    extends LFTincanLrsContextActivitiesLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextActivitiesLocalServiceUtil} to access the l f tincan lrs context activities local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsContextActivitiesPersistence.removeAll();
    }

    public LFTincanLrsContextActivities createLFTincanLrsContextActivities() throws SystemException {
        return createLFTincanLrsContextActivities(counterLocalService.increment(LFTincanLrsContextActivities.class.getName()));
    }
}

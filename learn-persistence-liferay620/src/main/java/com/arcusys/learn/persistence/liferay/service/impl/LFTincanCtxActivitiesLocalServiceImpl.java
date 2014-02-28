package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFTincanCtxActivities;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanCtxActivitiesLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f tincan ctx activities local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanCtxActivitiesLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalServiceUtil
 */
public class LFTincanCtxActivitiesLocalServiceImpl
    extends LFTincanCtxActivitiesLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanCtxActivitiesLocalServiceUtil} to access the l f tincan ctx activities local service.
     */

    public void removeAll() throws SystemException {
        lfTincanCtxActivitiesPersistence.removeAll();
    }

    public LFTincanCtxActivities createLFTincanLrsContextActivities() throws SystemException {
        return createLFTincanCtxActivities(counterLocalService.increment(LFTincanCtxActivities.class.getName()));
    }
}

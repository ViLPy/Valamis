package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFAchievementActivity;
import com.arcusys.learn.persistence.liferay.model.LFRequiredActivity;
import com.arcusys.learn.persistence.liferay.service.base.LFRequiredActivityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f required activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRequiredActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalServiceUtil
 */
public class LFRequiredActivityLocalServiceImpl
    extends LFRequiredActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFRequiredActivityLocalServiceUtil} to access the l f required activity local service.
     */
    public List<LFRequiredActivity> findByAchievementId(Integer achievementId) throws SystemException {
        return lfRequiredActivityPersistence.findByAchievementId(achievementId);
    }

    public LFRequiredActivity createLFRequiredActivity(Integer achievementId, String activityClassName, Integer numberActivitiesRequired) throws SystemException {
        LFRequiredActivity result = createLFRequiredActivity(counterLocalService.increment(LFRequiredActivity.class.getName()));
        result.setAchievementId(achievementId);
        result.setActivityClassName(activityClassName);
        result.setNumberActivitiesRequired(numberActivitiesRequired);
        lfRequiredActivityPersistence.update(result, false);
        return result;
    }

    public void removeAll() throws SystemException {
        lfRequiredActivityPersistence.removeAll();
    }
}

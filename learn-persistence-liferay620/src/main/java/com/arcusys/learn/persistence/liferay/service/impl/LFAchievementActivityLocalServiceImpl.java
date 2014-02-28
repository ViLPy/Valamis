package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFAchievement;
import com.arcusys.learn.persistence.liferay.model.LFAchievementActivity;
import com.arcusys.learn.persistence.liferay.service.base.LFAchievementActivityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f achievement activity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAchievementActivityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalServiceUtil
 */
public class LFAchievementActivityLocalServiceImpl
    extends LFAchievementActivityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFAchievementActivityLocalServiceUtil} to access the l f achievement activity local service.
     */
    public List<LFAchievementActivity> findByAchievementId(Integer achievementId) throws SystemException {
        return lfAchievementActivityPersistence.findByAchievementId(achievementId);
    }

    public List<LFAchievementActivity> findByUserId(Integer userId) throws SystemException {
        return lfAchievementActivityPersistence.findByUserId(userId);
    }

    public List<LFAchievementActivity> findAll() throws SystemException {
        return lfAchievementActivityPersistence.findAll();
    }

    public List<LFAchievementActivity> findAllByAchievementAndUserId(Integer achievementId, Integer userId) throws SystemException {
        return lfAchievementActivityPersistence.findByAllByAchievementAndUserId(userId, achievementId);
    }

    public LFAchievementActivity createLFAchievementActivity(Integer userId, Integer achievementId) throws SystemException {
        LFAchievementActivity result = createLFAchievementActivity(counterLocalService.increment(LFAchievementActivity.class.getName()));
        result.setUserId(userId);
        result.setAchievementId(achievementId);
        lfAchievementActivityPersistence.update(result, false);
        return result;
    }

    public void removeAll() throws SystemException {
        lfAchievementActivityPersistence.removeAll();
    }
}

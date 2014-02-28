package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFAchievementUser;
import com.arcusys.learn.persistence.liferay.service.base.LFAchievementUserLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f achievement user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAchievementUserLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalServiceUtil
 */
public class LFAchievementUserLocalServiceImpl
    extends LFAchievementUserLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFAchievementUserLocalServiceUtil} to access the l f achievement user local service.
     */
    public List<LFAchievementUser> findByUserId(Integer userId) throws SystemException {
        return lfAchievementUserPersistence.findByUserId(userId);
    }

    public List<LFAchievementUser> findAll() throws SystemException {
        return lfAchievementUserPersistence.findAll();
    }
    public List<LFAchievementUser> findByAchievementId(Integer achievementId) throws SystemException {
        return lfAchievementUserPersistence.findByAchievementId(achievementId);
    }

    public LFAchievementUser createLFAchievementUser(Integer userId, Integer achievementId) throws SystemException {
        LFAchievementUser result = createLFAchievementUser(counterLocalService.increment(LFAchievementUser.class.getName()));
        result.setAchievementId(achievementId);
        result.setUserId(userId);
        lfAchievementUserPersistence.update(result, false);
        return result;
    }
    public void removeAll() throws SystemException {
        lfAchievementUserPersistence.removeAll();
    }
}

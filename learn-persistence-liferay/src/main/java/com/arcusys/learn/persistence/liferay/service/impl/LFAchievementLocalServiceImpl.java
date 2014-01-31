package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFAchievement;
import com.arcusys.learn.persistence.liferay.service.base.LFAchievementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the l f achievement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFAchievementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAchievementLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFAchievementLocalServiceUtil
 */
public class LFAchievementLocalServiceImpl
    extends LFAchievementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFAchievementLocalServiceUtil} to access the l f achievement local service.
     */

    public LFAchievement createLFAchievement(String title, String description, String logo, Date creationDate ) throws SystemException {
        LFAchievement result = createLFAchievement(counterLocalService.increment(LFAchievement.class.getName()));
        result.setTitle(title);
        result.setDescription(description);
        result.setLogo(logo);
        result.setCreationDate(creationDate);

        lfAchievementPersistence.update(result, false);
        return result;
    }

    public List<LFAchievement> findAll() throws SystemException {
        return lfAchievementPersistence.findAll();
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFLessonLimitException;
import com.arcusys.learn.persistence.liferay.model.LFLessonLimit;
import com.arcusys.learn.persistence.liferay.service.base.LFLessonLimitLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f lesson limit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFLessonLimitLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil
 */
public class LFLessonLimitLocalServiceImpl
    extends LFLessonLimitLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFLessonLimitLocalServiceUtil} to access the l f lesson limit local service.
     */
    public LFLessonLimit findByID(Long itemID, String itemType) throws SystemException, NoSuchLFLessonLimitException{
        return lfLessonLimitPersistence.findByItemIDAndItemType(itemID, itemType);
    }

    public List<LFLessonLimit> findByIDs(Long[] ids) throws SystemException {
        return lfLessonLimitPersistence.findByIDs(ids);
    }
}

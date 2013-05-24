package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuestionCategory;
import com.arcusys.learn.persistence.liferay.service.base.LFQuestionCategoryLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f question category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuestionCategoryLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil
 */
public class LFQuestionCategoryLocalServiceImpl
    extends LFQuestionCategoryLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuestionCategoryLocalServiceUtil} to access the l f question category local service.
     */

    public LFQuestionCategory createLFQuestionCategory() throws SystemException {
        return super.createLFQuestionCategory(counterLocalService.increment(LFQuestionCategory.class.getName()));
    }

    public List<LFQuestionCategory> findByCourseId(final Integer[] courseIds) throws SystemException {
        return lfQuestionCategoryPersistence.findByCourseId(courseIds);
    }

    public List<LFQuestionCategory> findByCourseIdAndParentId(final Integer[] courseIds, final Integer[] parentIds) throws SystemException {
        return lfQuestionCategoryPersistence.findByCourseIdAndParentId(courseIds, parentIds);
    }

    public void removeAll() throws SystemException {
        lfQuestionCategoryPersistence.removeAll();
    }

    @Override
    public LFQuestionCategory getLFQuestionCategory(final long id) throws PortalException, SystemException {
        try {
            return super.getLFQuestionCategory(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestionCategory;
import com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestionCategoryLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f quiz question category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestionCategoryLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalServiceUtil
 */
public class LFQuizQuestionCategoryLocalServiceImpl
    extends LFQuizQuestionCategoryLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuizQuestionCategoryLocalServiceUtil} to access the l f quiz question category local service.
     */

    public LFQuizQuestionCategory createLFQuizQuestionCategory() throws SystemException {
        return super.createLFQuizQuestionCategory(counterLocalService.increment(LFQuizQuestionCategory.class.getName()));
    }

    public List<LFQuizQuestionCategory> findByQuizIdAndParentId(final Integer quizId, final Integer parentId) throws SystemException {
        return lfQuizQuestionCategoryPersistence.findByQuizIdAndParentId(quizId, parentId);
    }

    public List<LFQuizQuestionCategory> findByQuizId(final Integer quizId) throws SystemException {
        return lfQuizQuestionCategoryPersistence.findByQuizId(quizId);
    }

    public void removeAll() throws SystemException {
        lfQuizQuestionCategoryPersistence.removeAll();
    }

    @Override
    public LFQuizQuestionCategory getLFQuizQuestionCategory(final long id) throws PortalException, SystemException {
        try {
            return super.getLFQuizQuestionCategory(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

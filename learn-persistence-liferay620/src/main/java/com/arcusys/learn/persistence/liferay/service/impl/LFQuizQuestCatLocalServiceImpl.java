package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestCat;
import com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestCatLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;
/**
 * The implementation of the l f quiz quest cat local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuizQuestCatLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestCatLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuizQuestCatLocalServiceUtil
 */
public class LFQuizQuestCatLocalServiceImpl
    extends LFQuizQuestCatLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuizQuestCatLocalServiceUtil} to access the l f quiz quest cat local service.
     */

    public LFQuizQuestCat createLFQuizQuestionCategory() throws SystemException {
        return super.createLFQuizQuestCat(counterLocalService.increment(LFQuizQuestCat.class.getName()));
    }

    public List<LFQuizQuestCat> findByQuizIdAndParentId(final Integer quizId, final Integer parentId) throws SystemException {
        return lfQuizQuestCatPersistence.findByQuizIdAndParentId(quizId, parentId);
    }

    public List<LFQuizQuestCat> findByQuizId(final Integer quizId) throws SystemException {
        return lfQuizQuestCatPersistence.findByQuizId(quizId);
    }

    public void removeAll() throws SystemException {
        lfQuizQuestCatPersistence.removeAll();
    }

    @Override
    public LFQuizQuestCat getLFQuizQuestCat(final long id) throws PortalException, SystemException {
        try {
            return super.getLFQuizQuestCat(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

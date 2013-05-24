package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuizQuestion;
import com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestionLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f quiz question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizQuestionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil
 */
public class LFQuizQuestionLocalServiceImpl
    extends LFQuizQuestionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuizQuestionLocalServiceUtil} to access the l f quiz question local service.
     */
    public LFQuizQuestion createLFQuizQuestion() throws SystemException {
        return super.createLFQuizQuestion(counterLocalService.increment(LFQuizQuestion.class.getName()));
    }

    public java.util.List<LFQuizQuestion> findByQuizID(Integer quizID) throws SystemException{
        return lfQuizQuestionPersistence.findByQuizID(quizID);
    }
    public java.util.List<LFQuizQuestion> findByQuizAndCategory(Integer quizID, Integer categoryId) throws SystemException{
        return lfQuizQuestionPersistence.findByQuizAndCategory(quizID, categoryId);
    }

    public void removeAll() throws SystemException {
        lfQuizQuestionPersistence.removeAll();
    }

    @Override
    public LFQuizQuestion getLFQuizQuestion(final long id) throws PortalException, SystemException {
        try {
            return super.getLFQuizQuestion(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

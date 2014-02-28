package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuestion;
import com.arcusys.learn.persistence.liferay.service.base.LFQuestionLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuestionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuestionLocalServiceUtil
 */
public class LFQuestionLocalServiceImpl extends LFQuestionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuestionLocalServiceUtil} to access the l f question local service.
     */
    public LFQuestion createLFQuestion() throws SystemException {
        return super.createLFQuestion(counterLocalService.increment(LFQuestion.class.getName()));
    }

    public List<LFQuestion> findByCourseIdAndCategoryId(final Integer[] courseIds, final Integer[] categeryIds) throws SystemException {
        return lfQuestionPersistence.findByCourseIdAndCategoryId(courseIds, categeryIds);
    }


    public void removeAll() throws SystemException {
        lfQuestionPersistence.removeAll();
    }

    @Override
    public LFQuestion getLFQuestion(final long id) throws PortalException, SystemException {
        try {
            return super.getLFQuestion(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

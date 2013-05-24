package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFAnswer;
import com.arcusys.learn.persistence.liferay.service.base.LFAnswerLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f answer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFAnswerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAnswerLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil
 */
public class LFAnswerLocalServiceImpl extends LFAnswerLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFAnswerLocalServiceUtil} to access the l f answer local service.
     */
    public LFAnswer createLFAnswer() throws SystemException {
        return super.createLFAnswer(counterLocalService.increment(LFAnswer.class.getName()));
    }

    public List<LFAnswer> findByQuestionId(final Integer questionId) throws SystemException {
        return lfAnswerPersistence.findByQuestionId(questionId);
    }

    public void removeByQuestionId(final Integer questionId) throws SystemException {
        lfAnswerPersistence.removeByQuestionId(questionId);
    }

    public void removeAll() throws SystemException {
        lfAnswerPersistence.removeAll();
    }

    @Override
    public LFAnswer getLFAnswer(final long id) throws PortalException, SystemException {
        try {
            return super.getLFAnswer(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFQuizAnswerScoreException;
import com.arcusys.learn.persistence.liferay.model.LFQuizAnswerScore;
import com.arcusys.learn.persistence.liferay.service.base.LFQuizAnswerScoreLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f quiz answer score local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizAnswerScoreLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalServiceUtil
 */
public class LFQuizAnswerScoreLocalServiceImpl
    extends LFQuizAnswerScoreLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuizAnswerScoreLocalServiceUtil} to access the l f quiz answer score local service.
     */

    public LFQuizAnswerScore getScoresForAnswer(long answerId) throws SystemException, NoSuchLFQuizAnswerScoreException {
        //return lfQuizAnswerScorePersistence.findByAnswerId(answerId);
        return lfQuizAnswerScorePersistence.findByPrimaryKey(answerId);
    }

    public LFQuizAnswerScore createLFQuizQuestionScore() throws SystemException {
        return super.createLFQuizAnswerScore(counterLocalService.increment(LFQuizAnswerScore.class.getName()));
    }}

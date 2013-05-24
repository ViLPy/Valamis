package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFQuiz;
import com.arcusys.learn.persistence.liferay.service.base.LFQuizLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the l f quiz local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFQuizLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFQuizLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil
 */
public class LFQuizLocalServiceImpl extends LFQuizLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFQuizLocalServiceUtil} to access the l f quiz local service.
     */
    public LFQuiz createLFQuiz() throws SystemException {
        return super.createLFQuiz(counterLocalService.increment(LFQuiz.class.getName()));
    }

    public List<LFQuiz> findByCourseId(final Integer[] courseIds) throws SystemException {
        return lfQuizPersistence.findByCourseId(courseIds);
    }

    public void removeAll() throws SystemException {
        lfQuizPersistence.removeAll();
    }

    @Override
    public LFQuiz getLFQuiz(final long id) throws PortalException, SystemException {
        try {
            return super.getLFQuiz(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}

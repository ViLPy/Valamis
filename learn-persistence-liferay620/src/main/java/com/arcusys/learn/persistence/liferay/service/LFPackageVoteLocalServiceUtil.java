package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFPackageVote. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFPackageVoteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFPackageVoteLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageVoteLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFPackageVoteLocalServiceImpl
 * @generated
 */
public class LFPackageVoteLocalServiceUtil {
    private static LFPackageVoteLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFPackageVoteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f package vote to the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackageVote the l f package vote
    * @return the l f package vote that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote addLFPackageVote(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFPackageVote(lfPackageVote);
    }

    /**
    * Creates a new l f package vote with the primary key. Does not add the l f package vote to the database.
    *
    * @param id the primary key for the new l f package vote
    * @return the new l f package vote
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote createLFPackageVote(
        long id) {
        return getService().createLFPackageVote(id);
    }

    /**
    * Deletes the l f package vote with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote that was removed
    * @throws PortalException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote deleteLFPackageVote(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPackageVote(id);
    }

    /**
    * Deletes the l f package vote from the database. Also notifies the appropriate model listeners.
    *
    * @param lfPackageVote the l f package vote
    * @return the l f package vote that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote deleteLFPackageVote(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFPackageVote(lfPackageVote);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote fetchLFPackageVote(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFPackageVote(id);
    }

    /**
    * Returns the l f package vote with the primary key.
    *
    * @param id the primary key of the l f package vote
    * @return the l f package vote
    * @throws PortalException if a l f package vote with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote getLFPackageVote(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackageVote(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f package votes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFPackageVoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f package votes
    * @param end the upper bound of the range of l f package votes (not inclusive)
    * @return the range of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> getLFPackageVotes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackageVotes(start, end);
    }

    /**
    * Returns the number of l f package votes.
    *
    * @return the number of l f package votes
    * @throws SystemException if a system exception occurred
    */
    public static int getLFPackageVotesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFPackageVotesCount();
    }

    /**
    * Updates the l f package vote in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfPackageVote the l f package vote
    * @return the l f package vote that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote updateLFPackageVote(
        com.arcusys.learn.persistence.liferay.model.LFPackageVote lfPackageVote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFPackageVote(lfPackageVote);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFPackageVote createLFPackageVote()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFPackageVote();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFPackageVote> findBySocialPackageID(
        java.lang.Integer packageID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBySocialPackageID(packageID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFPackageVoteLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFPackageVoteLocalService.class.getName());

            if (invokableLocalService instanceof LFPackageVoteLocalService) {
                _service = (LFPackageVoteLocalService) invokableLocalService;
            } else {
                _service = new LFPackageVoteLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFPackageVoteLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFPackageVoteLocalService service) {
    }
}

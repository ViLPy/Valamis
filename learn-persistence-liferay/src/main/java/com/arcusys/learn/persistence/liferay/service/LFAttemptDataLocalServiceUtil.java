package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFAttemptData. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFAttemptDataLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFAttemptDataLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFAttemptDataLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFAttemptDataLocalServiceImpl
 * @generated
 */
public class LFAttemptDataLocalServiceUtil {
    private static LFAttemptDataLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFAttemptDataLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f attempt data to the database. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @return the l f attempt data that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData addLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFAttemptData(lfAttemptData);
    }

    /**
    * Creates a new l f attempt data with the primary key. Does not add the l f attempt data to the database.
    *
    * @param id the primary key for the new l f attempt data
    * @return the new l f attempt data
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData createLFAttemptData(
        long id) {
        return getService().createLFAttemptData(id);
    }

    /**
    * Deletes the l f attempt data with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data that was removed
    * @throws PortalException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData deleteLFAttemptData(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFAttemptData(id);
    }

    /**
    * Deletes the l f attempt data from the database. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @return the l f attempt data that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData deleteLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFAttemptData(lfAttemptData);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData fetchLFAttemptData(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFAttemptData(id);
    }

    /**
    * Returns the l f attempt data with the primary key.
    *
    * @param id the primary key of the l f attempt data
    * @return the l f attempt data
    * @throws PortalException if a l f attempt data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData getLFAttemptData(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFAttemptData(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f attempt datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFAttemptDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f attempt datas
    * @param end the upper bound of the range of l f attempt datas (not inclusive)
    * @return the range of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> getLFAttemptDatas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFAttemptDatas(start, end);
    }

    /**
    * Returns the number of l f attempt datas.
    *
    * @return the number of l f attempt datas
    * @throws SystemException if a system exception occurred
    */
    public static int getLFAttemptDatasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFAttemptDatasCount();
    }

    /**
    * Updates the l f attempt data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfAttemptData the l f attempt data
    * @return the l f attempt data that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData updateLFAttemptData(
        com.arcusys.learn.persistence.liferay.model.LFAttemptData lfAttemptData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFAttemptData(lfAttemptData);
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

    public static com.arcusys.learn.persistence.liferay.model.LFAttemptData createLFAttemptData()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFAttemptData();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithActivityID(
        java.lang.Integer attemptID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByAttemptIDWithActivityID(attemptID, activityID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByAttemptIDWithDataKey(
        java.lang.Integer attemptID, java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByAttemptIDWithDataKey(attemptID, dataKey);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findBySingleKey(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findBySingleKey(attemptID, activityID, dataKey, start, end);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFAttemptData> findByCollectionValues(
        java.lang.Integer attemptID, java.lang.String activityID,
        java.lang.String dataKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByCollectionValues(attemptID, activityID, dataKey);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFAttemptDataLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFAttemptDataLocalService.class.getName());

            if (invokableLocalService instanceof LFAttemptDataLocalService) {
                _service = (LFAttemptDataLocalService) invokableLocalService;
            } else {
                _service = new LFAttemptDataLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFAttemptDataLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFAttemptDataLocalService service) {
    }
}

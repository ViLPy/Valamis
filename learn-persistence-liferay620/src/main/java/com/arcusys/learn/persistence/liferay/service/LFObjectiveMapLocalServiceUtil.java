package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFObjectiveMap. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFObjectiveMapLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveMapLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFObjectiveMapLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFObjectiveMapLocalServiceImpl
 * @generated
 */
public class LFObjectiveMapLocalServiceUtil {
    private static LFObjectiveMapLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFObjectiveMapLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f objective map to the database. Also notifies the appropriate model listeners.
    *
    * @param lfObjectiveMap the l f objective map
    * @return the l f objective map that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap addLFObjectiveMap(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFObjectiveMap(lfObjectiveMap);
    }

    /**
    * Creates a new l f objective map with the primary key. Does not add the l f objective map to the database.
    *
    * @param id the primary key for the new l f objective map
    * @return the new l f objective map
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap createLFObjectiveMap(
        long id) {
        return getService().createLFObjectiveMap(id);
    }

    /**
    * Deletes the l f objective map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map that was removed
    * @throws PortalException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap deleteLFObjectiveMap(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFObjectiveMap(id);
    }

    /**
    * Deletes the l f objective map from the database. Also notifies the appropriate model listeners.
    *
    * @param lfObjectiveMap the l f objective map
    * @return the l f objective map that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap deleteLFObjectiveMap(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFObjectiveMap(lfObjectiveMap);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchLFObjectiveMap(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFObjectiveMap(id);
    }

    /**
    * Returns the l f objective map with the primary key.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map
    * @throws PortalException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap getLFObjectiveMap(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFObjectiveMap(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f objective maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @return the range of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> getLFObjectiveMaps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFObjectiveMaps(start, end);
    }

    /**
    * Returns the number of l f objective maps.
    *
    * @return the number of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public static int getLFObjectiveMapsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFObjectiveMapsCount();
    }

    /**
    * Updates the l f objective map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfObjectiveMap the l f objective map
    * @return the l f objective map that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap updateLFObjectiveMap(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFObjectiveMap(lfObjectiveMap);
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

    public static com.arcusys.learn.persistence.liferay.model.LFObjectiveMap createLFObjectiveMap()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFObjectiveMap();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByObjectiveID(objectiveID);
    }

    public static void removeByObjectiveID(java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeByObjectiveID(objectiveID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFObjectiveMapLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFObjectiveMapLocalService.class.getName());

            if (invokableLocalService instanceof LFObjectiveMapLocalService) {
                _service = (LFObjectiveMapLocalService) invokableLocalService;
            } else {
                _service = new LFObjectiveMapLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFObjectiveMapLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFObjectiveMapLocalService service) {
    }
}

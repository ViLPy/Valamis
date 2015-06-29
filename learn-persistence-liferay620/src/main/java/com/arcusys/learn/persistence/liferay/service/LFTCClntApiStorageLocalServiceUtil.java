package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LFTCClntApiStorage. This utility wraps
 * {@link com.arcusys.learn.persistence.liferay.service.impl.LFTCClntApiStorageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LFTCClntApiStorageLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTCClntApiStorageLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFTCClntApiStorageLocalServiceImpl
 * @generated
 */
public class LFTCClntApiStorageLocalServiceUtil {
    private static LFTCClntApiStorageLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFTCClntApiStorageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f t c clnt api storage to the database. Also notifies the appropriate model listeners.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    * @return the l f t c clnt api storage that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage addLFTCClntApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFTCClntApiStorage(lftcClntApiStorage);
    }

    /**
    * Creates a new l f t c clnt api storage with the primary key. Does not add the l f t c clnt api storage to the database.
    *
    * @param id the primary key for the new l f t c clnt api storage
    * @return the new l f t c clnt api storage
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage createLFTCClntApiStorage(
        long id) {
        return getService().createLFTCClntApiStorage(id);
    }

    /**
    * Deletes the l f t c clnt api storage with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage that was removed
    * @throws PortalException if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage deleteLFTCClntApiStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFTCClntApiStorage(id);
    }

    /**
    * Deletes the l f t c clnt api storage from the database. Also notifies the appropriate model listeners.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    * @return the l f t c clnt api storage that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage deleteLFTCClntApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFTCClntApiStorage(lftcClntApiStorage);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage fetchLFTCClntApiStorage(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFTCClntApiStorage(id);
    }

    /**
    * Returns the l f t c clnt api storage with the primary key.
    *
    * @param id the primary key of the l f t c clnt api storage
    * @return the l f t c clnt api storage
    * @throws PortalException if a l f t c clnt api storage with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage getLFTCClntApiStorage(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTCClntApiStorage(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f t c clnt api storages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTCClntApiStorageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f t c clnt api storages
    * @param end the upper bound of the range of l f t c clnt api storages (not inclusive)
    * @return the range of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage> getLFTCClntApiStorages(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTCClntApiStorages(start, end);
    }

    /**
    * Returns the number of l f t c clnt api storages.
    *
    * @return the number of l f t c clnt api storages
    * @throws SystemException if a system exception occurred
    */
    public static int getLFTCClntApiStoragesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFTCClntApiStoragesCount();
    }

    /**
    * Updates the l f t c clnt api storage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lftcClntApiStorage the l f t c clnt api storage
    * @return the l f t c clnt api storage that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage updateLFTCClntApiStorage(
        com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage lftcClntApiStorage)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFTCClntApiStorage(lftcClntApiStorage);
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

    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByToken(
        java.lang.String token)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByToken(token);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTCClntApiStorage findByCode(
        java.lang.String code)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSequencingException,
            com.arcusys.learn.persistence.liferay.NoSuchLFTCClntApiStorageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCode(code);
    }

    public static void clearService() {
        _service = null;
    }

    public static LFTCClntApiStorageLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFTCClntApiStorageLocalService.class.getName());

            if (invokableLocalService instanceof LFTCClntApiStorageLocalService) {
                _service = (LFTCClntApiStorageLocalService) invokableLocalService;
            } else {
                _service = new LFTCClntApiStorageLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFTCClntApiStorageLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LFTCClntApiStorageLocalService service) {
    }
}

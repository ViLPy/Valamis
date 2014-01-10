package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs sub statement service. This utility wraps {@link LFTincanLrsSubStatementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsSubStatementPersistence
 * @see LFTincanLrsSubStatementPersistenceImpl
 * @generated
 */
public class LFTincanLrsSubStatementUtil {
    private static LFTincanLrsSubStatementPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(
        LFTincanLrsSubStatement lfTincanLrsSubStatement) {
        getPersistence().clearCache(lfTincanLrsSubStatement);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFTincanLrsSubStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsSubStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsSubStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFTincanLrsSubStatement update(
        LFTincanLrsSubStatement lfTincanLrsSubStatement, boolean merge)
        throws SystemException {
        return getPersistence().update(lfTincanLrsSubStatement, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFTincanLrsSubStatement update(
        LFTincanLrsSubStatement lfTincanLrsSubStatement, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfTincanLrsSubStatement, merge, serviceContext);
    }

    /**
    * Caches the l f tincan lrs sub statement in the entity cache if it is enabled.
    *
    * @param lfTincanLrsSubStatement the l f tincan lrs sub statement
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement) {
        getPersistence().cacheResult(lfTincanLrsSubStatement);
    }

    /**
    * Caches the l f tincan lrs sub statements in the entity cache if it is enabled.
    *
    * @param lfTincanLrsSubStatements the l f tincan lrs sub statements
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement> lfTincanLrsSubStatements) {
        getPersistence().cacheResult(lfTincanLrsSubStatements);
    }

    /**
    * Creates a new l f tincan lrs sub statement with the primary key. Does not add the l f tincan lrs sub statement to the database.
    *
    * @param id the primary key for the new l f tincan lrs sub statement
    * @return the new l f tincan lrs sub statement
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs sub statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException if a l f tincan lrs sub statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement lfTincanLrsSubStatement,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsSubStatement, merge);
    }

    /**
    * Returns the l f tincan lrs sub statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException if a l f tincan lrs sub statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsSubStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs sub statement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs sub statement
    * @return the l f tincan lrs sub statement, or <code>null</code> if a l f tincan lrs sub statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs sub statements.
    *
    * @return the l f tincan lrs sub statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs sub statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs sub statements
    * @param end the upper bound of the range of l f tincan lrs sub statements (not inclusive)
    * @return the range of l f tincan lrs sub statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs sub statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs sub statements
    * @param end the upper bound of the range of l f tincan lrs sub statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs sub statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs sub statements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs sub statements.
    *
    * @return the number of l f tincan lrs sub statements
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsSubStatementPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsSubStatementPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsSubStatementPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsSubStatementUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFTincanLrsSubStatementPersistence persistence) {
    }
}

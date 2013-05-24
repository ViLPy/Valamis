package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f children selection service. This utility wraps {@link LFChildrenSelectionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFChildrenSelectionPersistence
 * @see LFChildrenSelectionPersistenceImpl
 * @generated
 */
public class LFChildrenSelectionUtil {
    private static LFChildrenSelectionPersistence _persistence;

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
    public static void clearCache(LFChildrenSelection lfChildrenSelection) {
        getPersistence().clearCache(lfChildrenSelection);
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
    public static List<LFChildrenSelection> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFChildrenSelection> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFChildrenSelection> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFChildrenSelection update(
        LFChildrenSelection lfChildrenSelection, boolean merge)
        throws SystemException {
        return getPersistence().update(lfChildrenSelection, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFChildrenSelection update(
        LFChildrenSelection lfChildrenSelection, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfChildrenSelection, merge, serviceContext);
    }

    /**
    * Caches the l f children selection in the entity cache if it is enabled.
    *
    * @param lfChildrenSelection the l f children selection
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection) {
        getPersistence().cacheResult(lfChildrenSelection);
    }

    /**
    * Caches the l f children selections in the entity cache if it is enabled.
    *
    * @param lfChildrenSelections the l f children selections
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> lfChildrenSelections) {
        getPersistence().cacheResult(lfChildrenSelections);
    }

    /**
    * Creates a new l f children selection with the primary key. Does not add the l f children selection to the database.
    *
    * @param id the primary key for the new l f children selection
    * @return the new l f children selection
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f children selection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfChildrenSelection, merge);
    }

    /**
    * Returns the l f children selection with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException} if it could not be found.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f children selection with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection, or <code>null</code> if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns the l f children selection where sequencingID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException} if it could not be found.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f children selection
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a matching l f children selection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySequencingID(sequencingID);
    }

    /**
    * Returns the l f children selection where sequencingID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f children selection, or <code>null</code> if a matching l f children selection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBySequencingID(sequencingID);
    }

    /**
    * Returns the l f children selection where sequencingID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param sequencingID the sequencing i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f children selection, or <code>null</code> if a matching l f children selection could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchBySequencingID(
        java.lang.Integer sequencingID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingID(sequencingID, retrieveFromCache);
    }

    /**
    * Returns all the l f children selections.
    *
    * @return the l f children selections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f children selections.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f children selections
    * @param end the upper bound of the range of l f children selections (not inclusive)
    * @return the range of l f children selections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f children selections.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f children selections
    * @param end the upper bound of the range of l f children selections (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f children selections
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes the l f children selection where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @return the l f children selection that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFChildrenSelection removeBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeBySequencingID(sequencingID);
    }

    /**
    * Removes all the l f children selections from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f children selections where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f children selections
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySequencingID(sequencingID);
    }

    /**
    * Returns the number of l f children selections.
    *
    * @return the number of l f children selections
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFChildrenSelectionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFChildrenSelectionPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFChildrenSelectionPersistence.class.getName());

            ReferenceRegistry.registerReference(LFChildrenSelectionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFChildrenSelectionPersistence persistence) {
    }
}

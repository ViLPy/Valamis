package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjective;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f objective service. This utility wraps {@link LFObjectivePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectivePersistence
 * @see LFObjectivePersistenceImpl
 * @generated
 */
public class LFObjectiveUtil {
    private static LFObjectivePersistence _persistence;

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
    public static void clearCache(LFObjective lfObjective) {
        getPersistence().clearCache(lfObjective);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFObjective> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFObjective> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFObjective> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFObjective update(LFObjective lfObjective)
        throws SystemException {
        return getPersistence().update(lfObjective);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFObjective update(LFObjective lfObjective,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfObjective, serviceContext);
    }

    /**
    * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @return the matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimary(sequencingID, isPrimary);
    }

    /**
    * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @return the range of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimary(sequencingID, isPrimary,
            start, end);
    }

    /**
    * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimary(sequencingID, isPrimary,
            start, end, orderByComparator);
    }

    /**
    * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimary_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimary_First(sequencingID,
            isPrimary, orderByComparator);
    }

    /**
    * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimary_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingIDAndIsPrimary_First(sequencingID,
            isPrimary, orderByComparator);
    }

    /**
    * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimary_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimary_Last(sequencingID,
            isPrimary, orderByComparator);
    }

    /**
    * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimary_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingIDAndIsPrimary_Last(sequencingID,
            isPrimary, orderByComparator);
    }

    /**
    * Returns the l f objectives before and after the current l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param lfId the primary key of the current l f objective
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective[] findBySequencingIDAndIsPrimary_PrevAndNext(
        long lfId, java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimary_PrevAndNext(lfId,
            sequencingID, isPrimary, orderByComparator);
    }

    /**
    * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeBySequencingIDAndIsPrimary(sequencingID, isPrimary);
    }

    /**
    * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @return the number of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBySequencingIDAndIsPrimary(sequencingID, isPrimary);
    }

    /**
    * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @return the matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier);
    }

    /**
    * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @return the range of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier, start, end);
    }

    /**
    * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier, start, end, orderByComparator);
    }

    /**
    * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimaryAndIdentifier_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimaryAndIdentifier_First(sequencingID,
            isPrimary, identifier, orderByComparator);
    }

    /**
    * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimaryAndIdentifier_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingIDAndIsPrimaryAndIdentifier_First(sequencingID,
            isPrimary, identifier, orderByComparator);
    }

    /**
    * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimaryAndIdentifier_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimaryAndIdentifier_Last(sequencingID,
            isPrimary, identifier, orderByComparator);
    }

    /**
    * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimaryAndIdentifier_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySequencingIDAndIsPrimaryAndIdentifier_Last(sequencingID,
            isPrimary, identifier, orderByComparator);
    }

    /**
    * Returns the l f objectives before and after the current l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param lfId the primary key of the current l f objective
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective[] findBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(
        long lfId, java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(lfId,
            sequencingID, isPrimary, identifier, orderByComparator);
    }

    /**
    * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier);
    }

    /**
    * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @return the number of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static int countBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier);
    }

    /**
    * Caches the l f objective in the entity cache if it is enabled.
    *
    * @param lfObjective the l f objective
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective) {
        getPersistence().cacheResult(lfObjective);
    }

    /**
    * Caches the l f objectives in the entity cache if it is enabled.
    *
    * @param lfObjectives the l f objectives
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> lfObjectives) {
        getPersistence().cacheResult(lfObjectives);
    }

    /**
    * Creates a new l f objective with the primary key. Does not add the l f objective to the database.
    *
    * @param lfId the primary key for the new l f objective
    * @return the new l f objective
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective create(
        long lfId) {
        return getPersistence().create(lfId);
    }

    /**
    * Removes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective remove(
        long lfId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(lfId);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFObjective updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfObjective);
    }

    /**
    * Returns the l f objective with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException} if it could not be found.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective findByPrimaryKey(
        long lfId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(lfId);
    }

    /**
    * Returns the l f objective with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective, or <code>null</code> if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective fetchByPrimaryKey(
        long lfId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(lfId);
    }

    /**
    * Returns all the l f objectives.
    *
    * @return the l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f objectives.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @return the range of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f objectives.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f objectives from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f objectives.
    *
    * @return the number of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFObjectivePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFObjectivePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFObjectivePersistence.class.getName());

            ReferenceRegistry.registerReference(LFObjectiveUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFObjectivePersistence persistence) {
    }
}

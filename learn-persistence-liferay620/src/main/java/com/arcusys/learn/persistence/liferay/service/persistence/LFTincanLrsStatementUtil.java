package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs statement service. This utility wraps {@link LFTincanLrsStatementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementPersistence
 * @see LFTincanLrsStatementPersistenceImpl
 * @generated
 */
public class LFTincanLrsStatementUtil {
    private static LFTincanLrsStatementPersistence _persistence;

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
    public static void clearCache(LFTincanLrsStatement lfTincanLrsStatement) {
        getPersistence().clearCache(lfTincanLrsStatement);
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
    public static List<LFTincanLrsStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsStatement> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static LFTincanLrsStatement update(
        LFTincanLrsStatement lfTincanLrsStatement) throws SystemException {
        return getPersistence().update(lfTincanLrsStatement);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static LFTincanLrsStatement update(
        LFTincanLrsStatement lfTincanLrsStatement, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(lfTincanLrsStatement, serviceContext);
    }

    /**
    * Returns all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @return the matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObjTypeAndObjID(objType, objID);
    }

    /**
    * Returns a range of all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @return the range of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByObjTypeAndObjID(objType, objID, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjTypeAndObjID(objType, objID, start, end,
            orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByObjTypeAndObjID_First(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjTypeAndObjID_First(objType, objID,
            orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByObjTypeAndObjID_First(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByObjTypeAndObjID_First(objType, objID,
            orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByObjTypeAndObjID_Last(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjTypeAndObjID_Last(objType, objID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByObjTypeAndObjID_Last(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByObjTypeAndObjID_Last(objType, objID,
            orderByComparator);
    }

    /**
    * Returns the l f tincan lrs statements before and after the current l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs statement
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement[] findByObjTypeAndObjID_PrevAndNext(
        long id, java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByObjTypeAndObjID_PrevAndNext(id, objType, objID,
            orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs statements where objType = &#63; and objID = &#63; from the database.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByObjTypeAndObjID(java.lang.String objType,
        java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByObjTypeAndObjID(objType, objID);
    }

    /**
    * Returns the number of l f tincan lrs statements where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByObjTypeAndObjID(java.lang.String objType,
        java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByObjTypeAndObjID(objType, objID);
    }

    /**
    * Returns all the l f tincan lrs statements where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @return the matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActorID(actorID);
    }

    /**
    * Returns a range of all the l f tincan lrs statements where actorID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param actorID the actor i d
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @return the range of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActorID(actorID, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs statements where actorID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param actorID the actor i d
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActorID(actorID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByActorID_First(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActorID_First(actorID, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByActorID_First(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByActorID_First(actorID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByActorID_Last(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByActorID_Last(actorID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByActorID_Last(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByActorID_Last(actorID, orderByComparator);
    }

    /**
    * Returns the l f tincan lrs statements before and after the current l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs statement
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement[] findByActorID_PrevAndNext(
        long id, java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByActorID_PrevAndNext(id, actorID, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs statements where actorID = &#63; from the database.
    *
    * @param actorID the actor i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByActorID(java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByActorID(actorID);
    }

    /**
    * Returns the number of l f tincan lrs statements where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByActorID(java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByActorID(actorID);
    }

    /**
    * Returns all the l f tincan lrs statements where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @return the matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerbID(verbID);
    }

    /**
    * Returns a range of all the l f tincan lrs statements where verbID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param verbID the verb i d
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @return the range of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerbID(verbID, start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs statements where verbID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param verbID the verb i d
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerbID(verbID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByVerbID_First(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerbID_First(verbID, orderByComparator);
    }

    /**
    * Returns the first l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByVerbID_First(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByVerbID_First(verbID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByVerbID_Last(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByVerbID_Last(verbID, orderByComparator);
    }

    /**
    * Returns the last l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByVerbID_Last(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByVerbID_Last(verbID, orderByComparator);
    }

    /**
    * Returns the l f tincan lrs statements before and after the current l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param id the primary key of the current l f tincan lrs statement
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement[] findByVerbID_PrevAndNext(
        long id, java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByVerbID_PrevAndNext(id, verbID, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs statements where verbID = &#63; from the database.
    *
    * @param verbID the verb i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByVerbID(java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByVerbID(verbID);
    }

    /**
    * Returns the number of l f tincan lrs statements where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByVerbID(java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByVerbID(verbID);
    }

    /**
    * Returns the l f tincan lrs statement where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException} if it could not be found.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTincanID(tincanID);
    }

    /**
    * Returns the l f tincan lrs statement where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByTincanID(
        java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTincanID(tincanID);
    }

    /**
    * Returns the l f tincan lrs statement where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param tincanID the tincan i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByTincanID(
        java.lang.String tincanID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTincanID(tincanID, retrieveFromCache);
    }

    /**
    * Removes the l f tincan lrs statement where tincanID = &#63; from the database.
    *
    * @param tincanID the tincan i d
    * @return the l f tincan lrs statement that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement removeByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByTincanID(tincanID);
    }

    /**
    * Returns the number of l f tincan lrs statements where tincanID = &#63;.
    *
    * @param tincanID the tincan i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static int countByTincanID(java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTincanID(tincanID);
    }

    /**
    * Caches the l f tincan lrs statement in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStatement the l f tincan lrs statement
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement) {
        getPersistence().cacheResult(lfTincanLrsStatement);
    }

    /**
    * Caches the l f tincan lrs statements in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStatements the l f tincan lrs statements
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> lfTincanLrsStatements) {
        getPersistence().cacheResult(lfTincanLrsStatements);
    }

    /**
    * Creates a new l f tincan lrs statement with the primary key. Does not add the l f tincan lrs statement to the database.
    *
    * @param id the primary key for the new l f tincan lrs statement
    * @return the new l f tincan lrs statement
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsStatement);
    }

    /**
    * Returns the l f tincan lrs statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs statement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement, or <code>null</code> if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs statements.
    *
    * @return the l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @return the range of l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs statements.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanLrsStatementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs statements
    * @param end the upper bound of the range of l f tincan lrs statements (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs statements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs statements.
    *
    * @return the number of l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsStatementPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsStatementPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsStatementPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsStatementUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(LFTincanLrsStatementPersistence persistence) {
    }
}

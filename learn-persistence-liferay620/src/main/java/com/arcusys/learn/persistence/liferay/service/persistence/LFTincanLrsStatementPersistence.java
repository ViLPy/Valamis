package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan lrs statement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementPersistenceImpl
 * @see LFTincanLrsStatementUtil
 * @generated
 */
public interface LFTincanLrsStatementPersistence extends BasePersistence<LFTincanLrsStatement> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanLrsStatementUtil} to access the l f tincan lrs statement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f tincan lrs statements where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @return the matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByObjTypeAndObjID(
        java.lang.String objType, java.lang.Integer objID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByObjTypeAndObjID_First(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByObjTypeAndObjID_First(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByObjTypeAndObjID_Last(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs statement in the ordered set where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByObjTypeAndObjID_Last(
        java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement[] findByObjTypeAndObjID_PrevAndNext(
        long id, java.lang.String objType, java.lang.Integer objID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs statements where objType = &#63; and objID = &#63; from the database.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByObjTypeAndObjID(java.lang.String objType,
        java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs statements where objType = &#63; and objID = &#63;.
    *
    * @param objType the obj type
    * @param objID the obj i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public int countByObjTypeAndObjID(java.lang.String objType,
        java.lang.Integer objID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs statements where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @return the matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByActorID(
        java.lang.Integer actorID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByActorID_First(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByActorID_First(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByActorID_Last(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs statement in the ordered set where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByActorID_Last(
        java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement[] findByActorID_PrevAndNext(
        long id, java.lang.Integer actorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs statements where actorID = &#63; from the database.
    *
    * @param actorID the actor i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByActorID(java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs statements where actorID = &#63;.
    *
    * @param actorID the actor i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public int countByActorID(java.lang.Integer actorID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs statements where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @return the matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findByVerbID(
        java.lang.String verbID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByVerbID_First(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByVerbID_First(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByVerbID_Last(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f tincan lrs statement in the ordered set where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByVerbID_Last(
        java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement[] findByVerbID_PrevAndNext(
        long id, java.lang.String verbID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs statements where verbID = &#63; from the database.
    *
    * @param verbID the verb i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByVerbID(java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs statements where verbID = &#63;.
    *
    * @param verbID the verb i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public int countByVerbID(java.lang.String verbID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs statement where tincanID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException} if it could not be found.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs statement where tincanID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param tincanID the tincan i d
    * @return the matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByTincanID(
        java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs statement where tincanID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param tincanID the tincan i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan lrs statement, or <code>null</code> if a matching l f tincan lrs statement could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByTincanID(
        java.lang.String tincanID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan lrs statement where tincanID = &#63; from the database.
    *
    * @param tincanID the tincan i d
    * @return the l f tincan lrs statement that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement removeByTincanID(
        java.lang.String tincanID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs statements where tincanID = &#63;.
    *
    * @param tincanID the tincan i d
    * @return the number of matching l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public int countByTincanID(java.lang.String tincanID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f tincan lrs statement in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStatement the l f tincan lrs statement
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement);

    /**
    * Caches the l f tincan lrs statements in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStatements the l f tincan lrs statements
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> lfTincanLrsStatements);

    /**
    * Creates a new l f tincan lrs statement with the primary key. Does not add the l f tincan lrs statement to the database.
    *
    * @param id the primary key for the new l f tincan lrs statement
    * @return the new l f tincan lrs statement
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement create(
        long id);

    /**
    * Removes the l f tincan lrs statement with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement lfTincanLrsStatement)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs statement with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan lrs statement with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs statement
    * @return the l f tincan lrs statement, or <code>null</code> if a l f tincan lrs statement with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan lrs statements.
    *
    * @return the l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan lrs statements from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan lrs statements.
    *
    * @return the number of l f tincan lrs statements
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

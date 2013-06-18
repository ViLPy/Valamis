package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjective;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f objective service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectivePersistenceImpl
 * @see LFObjectiveUtil
 * @generated
 */
public interface LFObjectivePersistence extends BasePersistence<LFObjective> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFObjectiveUtil} to access the l f objective persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f objective in the entity cache if it is enabled.
    *
    * @param lfObjective the l f objective
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective);

    /**
    * Caches the l f objectives in the entity cache if it is enabled.
    *
    * @param lfObjectives the l f objectives
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> lfObjectives);

    /**
    * Creates a new l f objective with the primary key. Does not add the l f objective to the database.
    *
    * @param lfId the primary key for the new l f objective
    * @return the new l f objective
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjective create(
        long lfId);

    /**
    * Removes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjective remove(
        long lfId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFObjective updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException} if it could not be found.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjective findByPrimaryKey(
        long lfId)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective, or <code>null</code> if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjective fetchByPrimaryKey(
        long lfId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @return the matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @return the range of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimary_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective, or <code>null</code> if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimary_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimary_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f objective in the ordered set where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective, or <code>null</code> if a matching l f objective could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimary_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective[] findBySequencingIDAndIsPrimary_PrevAndNext(
        long lfId, java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @return the matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimaryAndIdentifier_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimaryAndIdentifier_First(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective findBySequencingIDAndIsPrimaryAndIdentifier_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective fetchBySequencingIDAndIsPrimaryAndIdentifier_Last(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFObjective[] findBySequencingIDAndIsPrimaryAndIdentifier_PrevAndNext(
        long lfId, java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f objectives.
    *
    * @return the l f objectives
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objectives.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @return the range of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objectives.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @throws SystemException if a system exception occurred
    */
    public void removeBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @throws SystemException if a system exception occurred
    */
    public void removeBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objectives from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @return the number of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingIDAndIsPrimary(java.lang.Integer sequencingID,
        java.lang.Boolean isPrimary)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objectives where sequencingID = &#63; and isPrimary = &#63; and identifier = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @param isPrimary the is primary
    * @param identifier the identifier
    * @return the number of matching l f objectives
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, java.lang.Boolean isPrimary,
        java.lang.String identifier)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objectives.
    *
    * @return the number of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

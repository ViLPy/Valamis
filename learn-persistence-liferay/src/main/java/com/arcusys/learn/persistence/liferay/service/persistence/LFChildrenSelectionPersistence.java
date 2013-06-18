package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFChildrenSelection;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f children selection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFChildrenSelectionPersistenceImpl
 * @see LFChildrenSelectionUtil
 * @generated
 */
public interface LFChildrenSelectionPersistence extends BasePersistence<LFChildrenSelection> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFChildrenSelectionUtil} to access the l f children selection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f children selection in the entity cache if it is enabled.
    *
    * @param lfChildrenSelection the l f children selection
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection);

    /**
    * Caches the l f children selections in the entity cache if it is enabled.
    *
    * @param lfChildrenSelections the l f children selections
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> lfChildrenSelections);

    /**
    * Creates a new l f children selection with the primary key. Does not add the l f children selection to the database.
    *
    * @param id the primary key for the new l f children selection
    * @return the new l f children selection
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection create(
        long id);

    /**
    * Removes the l f children selection with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFChildrenSelection lfChildrenSelection,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f children selection with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException} if it could not be found.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f children selection with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f children selection
    * @return the l f children selection, or <code>null</code> if a l f children selection with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f children selection where sequencingID = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException} if it could not be found.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f children selection
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException if a matching l f children selection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection findBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f children selection where sequencingID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param sequencingID the sequencing i d
    * @return the matching l f children selection, or <code>null</code> if a matching l f children selection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchBySequencingID(
        java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f children selection where sequencingID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param sequencingID the sequencing i d
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f children selection, or <code>null</code> if a matching l f children selection could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection fetchBySequencingID(
        java.lang.Integer sequencingID, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f children selections.
    *
    * @return the l f children selections
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFChildrenSelection> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f children selection where sequencingID = &#63; from the database.
    *
    * @param sequencingID the sequencing i d
    * @return the l f children selection that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFChildrenSelection removeBySequencingID(
        java.lang.Integer sequencingID)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFChildrenSelectionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f children selections from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f children selections where sequencingID = &#63;.
    *
    * @param sequencingID the sequencing i d
    * @return the number of matching l f children selections
    * @throws SystemException if a system exception occurred
    */
    public int countBySequencingID(java.lang.Integer sequencingID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f children selections.
    *
    * @return the number of l f children selections
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

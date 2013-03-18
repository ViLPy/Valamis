package com.arcusys.learn.service.persistence;

import com.arcusys.learn.model.Book;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the book service. This utility wraps {@link BookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 * <p/>
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 * @see BookPersistence
 * @see BookPersistenceImpl
 */
public class BookUtil {
    private static BookPersistence _persistence;

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
    public static void clearCache(Book book) {
        getPersistence().clearCache(book);
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
    public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery)
            throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery,
                                                  int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery,
                                                  int start, int end, OrderByComparator orderByComparator)
            throws SystemException {
        return getPersistence()
                .findWithDynamicQuery(dynamicQuery, start, end,
                        orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Book update(Book book, boolean merge)
            throws SystemException {
        return getPersistence().update(book, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Book update(Book book, boolean merge,
                              ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(book, merge, serviceContext);
    }

    /**
     * Caches the book in the entity cache if it is enabled.
     *
     * @param book the book
     */
    public static void cacheResult(com.arcusys.learn.model.Book book) {
        getPersistence().cacheResult(book);
    }

    /**
     * Caches the books in the entity cache if it is enabled.
     *
     * @param books the books
     */
    public static void cacheResult(
            java.util.List<com.arcusys.learn.model.Book> books) {
        getPersistence().cacheResult(books);
    }

    /**
     * Creates a new book with the primary key. Does not add the book to the database.
     *
     * @param bookId the primary key for the new book
     * @return the new book
     */
    public static com.arcusys.learn.model.Book create(long bookId) {
        return getPersistence().create(bookId);
    }

    /**
     * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param bookId the primary key of the book
     * @return the book that was removed
     * @throws com.arcusys.learn.NoSuchBookException
     *                         if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public static com.arcusys.learn.model.Book remove(long bookId)
            throws com.arcusys.learn.NoSuchBookException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(bookId);
    }

    public static com.arcusys.learn.model.Book updateImpl(
            com.arcusys.learn.model.Book book, boolean merge)
            throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(book, merge);
    }

    /**
     * Returns the book with the primary key or throws a {@link com.arcusys.learn.NoSuchBookException} if it could not be found.
     *
     * @param bookId the primary key of the book
     * @return the book
     * @throws com.arcusys.learn.NoSuchBookException
     *                         if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public static com.arcusys.learn.model.Book findByPrimaryKey(long bookId)
            throws com.arcusys.learn.NoSuchBookException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(bookId);
    }

    /**
     * Returns the book with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param bookId the primary key of the book
     * @return the book, or <code>null</code> if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public static com.arcusys.learn.model.Book fetchByPrimaryKey(long bookId)
            throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(bookId);
    }

    /**
     * Returns all the books.
     *
     * @return the books
     * @throws SystemException if a system exception occurred
     */
    public static java.util.List<com.arcusys.learn.model.Book> findAll()
            throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
     * Returns a range of all the books.
     * <p/>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of books
     * @param end   the upper bound of the range of books (not inclusive)
     * @return the range of books
     * @throws SystemException if a system exception occurred
     */
    public static java.util.List<com.arcusys.learn.model.Book> findAll(
            int start, int end)
            throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
     * Returns an ordered range of all the books.
     * <p/>
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start             the lower bound of the range of books
     * @param end               the upper bound of the range of books (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of books
     * @throws SystemException if a system exception occurred
     */
    public static java.util.List<com.arcusys.learn.model.Book> findAll(
            int start, int end,
            com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
            throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
     * Removes all the books from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public static void removeAll()
            throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
     * Returns the number of books.
     *
     * @return the number of books
     * @throws SystemException if a system exception occurred
     */
    public static int countAll()
            throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BookPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BookPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.service.ClpSerializer.getServletContextName(),
                    BookPersistence.class.getName());

            ReferenceRegistry.registerReference(BookUtil.class, "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(BookPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(BookUtil.class, "_persistence");
    }
}
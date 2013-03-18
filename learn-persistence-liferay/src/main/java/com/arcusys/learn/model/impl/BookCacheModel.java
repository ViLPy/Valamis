package com.arcusys.learn.model.impl;

import com.arcusys.learn.model.Book;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;
import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 * @see Book
 */
public class BookCacheModel implements CacheModel<Book>, Serializable {
    public long bookId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String title;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{bookId=");
        sb.append(bookId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", title=");
        sb.append(title);
        sb.append("}");

        return sb.toString();
    }

    public Book toEntityModel() {
        BookImpl bookImpl = new BookImpl();

        bookImpl.setBookId(bookId);
        bookImpl.setGroupId(groupId);
        bookImpl.setCompanyId(companyId);
        bookImpl.setUserId(userId);

        if (userName == null) {
            bookImpl.setUserName(StringPool.BLANK);
        } else {
            bookImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            bookImpl.setCreateDate(null);
        } else {
            bookImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            bookImpl.setModifiedDate(null);
        } else {
            bookImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (title == null) {
            bookImpl.setTitle(StringPool.BLANK);
        } else {
            bookImpl.setTitle(title);
        }

        bookImpl.resetOriginalValues();

        return bookImpl;
    }
}

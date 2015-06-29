/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.arcusys.learn.persistence.liferay;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLFTCClntApiStorageException extends NoSuchModelException {

	public NoSuchLFTCClntApiStorageException() {
		super();
	}

	public NoSuchLFTCClntApiStorageException(String msg) {
		super(msg);
	}

	public NoSuchLFTCClntApiStorageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLFTCClntApiStorageException(Throwable cause) {
		super(cause);
	}

}
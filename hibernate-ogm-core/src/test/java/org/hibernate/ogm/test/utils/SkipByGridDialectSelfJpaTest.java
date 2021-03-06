/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.hibernate.ogm.test.utils;

import junit.framework.Assert;

import org.hibernate.ogm.test.simpleentity.Hypothesis;
import org.hibernate.ogm.test.utils.jpa.JpaTestCase;
import org.junit.Test;

/**
 * Test {@link SkipByGridDialect} is working with {@link JpaTestCase}
 *
 * @author Davide D'Alto <davide@hibernate.org>
 */
public class SkipByGridDialectSelfJpaTest extends JpaTestCase {

	@Test
	@SkipByGridDialect({
		GridDialectType.HASHMAP, GridDialectType.INFINISPAN, GridDialectType.MONGODB, GridDialectType.EHCACHE
	})
	public void testWhichAlwaysFails() {
		Assert.fail( "This should never be executed" );
	}

	@Test
	public void testCorrect() {
		// all fine
	}

	@Override
	public Class<?>[] getEntities() {
		return new Class<?>[] { Hypothesis.class };
	}

}

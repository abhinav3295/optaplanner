/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.planner.core.testdata.util;

import org.junit.Assert;
import org.junit.ComparisonFailure;

public class PlannerAssert extends Assert {

    public static void assertCode(String expectedCode, Object o) {
        assertTrue(o instanceof CodeAssertable);
        assertCode(expectedCode, (CodeAssertable) o);
    }

    public static void assertCode(String message, String expectedCode, Object o) {
        assertTrue(o instanceof CodeAssertable);
        assertCode(message, expectedCode, (CodeAssertable) o);
    }

    public static void assertCode(String expectedCode, CodeAssertable codeAssertable) {
        assertEquals(expectedCode, codeAssertable.getCode());
    }

    public static void assertCode(String message, String expectedCode, CodeAssertable codeAssertable) {
        assertEquals(message, expectedCode, codeAssertable.getCode());
    }

    public static void assertInstanceOf(Class expectedClass, Object actualInstance) {
        assertInstanceOf(null, expectedClass, actualInstance);
    }

    public static void assertInstanceOf(String message, Class expectedClass, Object actualInstance) {
        if (!expectedClass.isInstance(actualInstance)) {
            String cleanMessage = message == null ? "" : message;
            throw new ComparisonFailure(cleanMessage, expectedClass.getName(),
                    actualInstance == null ? "null" : actualInstance.getClass().getName());
        }
    }

    public static void assertNotInstanceOf(Class expectedClass, Object actualInstance) {
        assertNotInstanceOf(null, expectedClass, actualInstance);
    }

    public static void assertNotInstanceOf(String message, Class expectedClass, Object actualInstance) {
        if (expectedClass.isInstance(actualInstance)) {
            String cleanMessage = message == null ? "" : message;
            throw new ComparisonFailure(cleanMessage, "not " + expectedClass.getName(),
                    actualInstance == null ? "null" : actualInstance.getClass().getName());
        }
    }

    private PlannerAssert() {
    }

}

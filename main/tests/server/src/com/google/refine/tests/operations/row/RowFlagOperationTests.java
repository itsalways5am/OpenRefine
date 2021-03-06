package com.google.refine.tests.operations.row;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.refine.operations.OperationRegistry;
import com.google.refine.operations.row.RowFlagOperation;
import com.google.refine.tests.RefineTest;
import com.google.refine.tests.util.TestUtils;
import com.google.refine.util.ParsingUtilities;

public class RowFlagOperationTests extends RefineTest {
    @BeforeSuite
    public void registerOperation() {
        OperationRegistry.registerOperation(getCoreModule(), "row-flag", RowFlagOperation.class);
    }
    
    @Test
    public void serializeRowFlagOperation() throws Exception {
        String json = "{"
                + "\"op\":\"core/row-flag\","
                + "\"description\":\"Flag rows\","
                + "\"flagged\":true,"
                + "\"engineConfig\":{\"mode\":\"row-based\",\"facets\":[]}}";
        TestUtils.isSerializedTo(ParsingUtilities.mapper.readValue(json, RowFlagOperation.class), json);
    }
}

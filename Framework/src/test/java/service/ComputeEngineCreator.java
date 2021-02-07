package service;

import model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.engine.numberOfInstances";
    private static final String TESTDATA_MACHINE_TYPE = "testdata.engine.machineType";
    private static final String TESTDATA_NUMBER_OF_NODES = "testdata.engine.numberOfNodes";
    private static final String TESTDATA_NUMBER_OF_GPUS = "testdata.engine.numberOfGPUs";
    private static final String TESTDATA_TYPE_OF_GPUS = "testdata.engine.typeOfGPUs";
    private static final String TESTDATA_DATACENTER_LOCATION = "testdata.engine.datacenterLocation";
    private static final String TESTDATA_COMMITTED_USAGE = "testdata.engine.committedUsage";

    public static ComputeEngine withDataFromProperty() {
        return new ComputeEngine(
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_NODES),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_TYPE_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}

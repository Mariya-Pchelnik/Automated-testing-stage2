package com.epam.learn.service;

import com.epam.learn.model.ComputeEngine;

public class ComputeEngineCreator {
    public static final String TESTDATA_COMPUTEENGINE_INSTANCENUMBER="testdata.computeEngine.instanceNumber";
    public static final String TESTDATA_COMPUTEENGINE_SYSTEM="testdata.computeEngine.system";
    public static final String TESTDATA_COMPUTEENGINE_MACHINECLASS="testdata.computeEngine.machineClass";
    public static final String TESTDATA_COMPUTEENGINE_SERIES="testdata.computeEngine.series";
    public static final String TESTDATA_COMPUTEENGINE_MACHINETYPE ="testdata.computeEngine.machineType";
    public static final String TESTDATA_COMPUTEENGINE_NUMBEROFGPUS="testdata.computeEngine.numberOfGPUs";
    public static final String TESTDATA_COMPUTEENGINE_TYPEOFGPU="testdata.computeEngine.typeOfGPU";
    public static final String TESTDATA_COMPUTEENGINE_LOCALSSD="testdata.computeEngine.localSSD";
    public static final String TESTDATA_COMPUTEENGINE_DATACENTERLOCATION="testdata.computeEngine.datacenterLocation";
    public static final String TESTDATA_COMPUTEENGINE_COMMITEDUSAGE="testdata.computeEngine.commitedUsage";

    public static ComputeEngine withGPU(){
        return new ComputeEngine(TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_INSTANCENUMBER),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_SYSTEM),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_MACHINECLASS),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_SERIES),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_MACHINETYPE),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_NUMBEROFGPUS),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_TYPEOFGPU),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_LOCALSSD),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_DATACENTERLOCATION),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_COMMITEDUSAGE));
    }
    public static ComputeEngine withoutGPU(){
        return new ComputeEngine(TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_INSTANCENUMBER),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_SYSTEM),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_MACHINECLASS),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_SERIES),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_MACHINETYPE),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_LOCALSSD),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_DATACENTERLOCATION),
                TestDataReader.getTestData(TESTDATA_COMPUTEENGINE_COMMITEDUSAGE));
    }
}

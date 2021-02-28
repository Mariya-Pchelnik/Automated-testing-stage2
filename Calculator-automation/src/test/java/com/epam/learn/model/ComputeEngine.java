package com.epam.learn.model;

import java.util.Objects;

public class ComputeEngine {

    private String instanceNumber;
    private String system;
    private String machineClass;
    private String series;
    private String machineType;
    private String numberOfGPUs;
    private String typeOfGPU;
    private String localSSD;
    private String datacenterLocation;
    private String commitedUsage;

    public ComputeEngine(String instanceNumber, String system,
                         String machineClass, String series,
                         String machineType, String numberOfGPUs,
                         String typeOfGPU, String localSSD,
                         String datacenterLocation, String commitedUsage) {
        this.instanceNumber = instanceNumber;
        this.system = system;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.numberOfGPUs = numberOfGPUs;
        this.typeOfGPU = typeOfGPU;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsage = commitedUsage;
    }

    public ComputeEngine(String instanceNumber, String system,
                         String machineClass, String series,
                         String machineType, String localSSD,
                         String datacenterLocation, String commitedUsage) {
        this.instanceNumber = instanceNumber;
        this.system = system;
        this.machineClass = machineClass;
        this.series = series;
        this.machineType = machineType;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.commitedUsage = commitedUsage;
    }

    public void setInstanceNumber(String instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public void setTypeOfGPU(String typeOfGPU) {
        this.typeOfGPU = typeOfGPU;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public void setCommitedUsage(String commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    public String getInstanceNumber() {
        return instanceNumber;
    }

    public String getSystem() {
        return system;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getTypeOfGPU() {
        return typeOfGPU;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommitedUsage() {
        return commitedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(instanceNumber, that.instanceNumber) &&
                Objects.equals(system, that.system) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(typeOfGPU, that.typeOfGPU) &&
                Objects.equals(localSSD, that.localSSD) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(commitedUsage, that.commitedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceNumber, system,
                machineClass, series,
                machineType, numberOfGPUs,
                typeOfGPU, localSSD, datacenterLocation, commitedUsage);
    }
}

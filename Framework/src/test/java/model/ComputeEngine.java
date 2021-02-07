package model;

import java.util.Objects;

public class ComputeEngine {
    private String numberOfInstances;
    private String machineType;
    private String numberOfNodes;
    private String numberOfGPUs;
    private String typeOfGPUs;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEngine(String numberOfInstances, String machineType, String numberOfNodes, String numberOfGPUs,
                         String typeOfGPUs, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.machineType = machineType;
        this.numberOfNodes = numberOfNodes;
        this.numberOfGPUs = numberOfGPUs;
        this.typeOfGPUs = typeOfGPUs;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(String numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getTypeOfGPUs() {
        return typeOfGPUs;
    }

    public void setTypeOfGPUs(String typeOfGPUs) {
        this.typeOfGPUs = typeOfGPUs;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" + "numberOfInstances='" + numberOfInstances + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfNodes='" + numberOfNodes + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", typeOfGPUs='" + typeOfGPUs + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances)
                && Objects.equals(machineType, that.machineType) && Objects.equals(numberOfNodes, that.numberOfNodes)
                && Objects.equals(numberOfGPUs, that.numberOfGPUs) && Objects.equals(typeOfGPUs, that.typeOfGPUs)
                && Objects.equals(datacenterLocation, that.datacenterLocation)
                && Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, machineType, numberOfNodes, numberOfGPUs, typeOfGPUs,
                datacenterLocation, committedUsage);
    }
}

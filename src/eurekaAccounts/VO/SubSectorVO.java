package eurekaAccounts.VO;

public class SubSectorVO {
    private int subSectorId;
    private String subSectorName;
    private Integer sectorId;

    public SubSectorVO() {
    }

    public SubSectorVO(int subSectorId, String subSectorName, Integer sectorId) {
        this.subSectorId = subSectorId;
        this.subSectorName = subSectorName;
        this.sectorId = sectorId;
    }

    public int getSubSectorId() {
        return subSectorId;
    }

    public void setSubSectorId(int subSectorId) {
        this.subSectorId = subSectorId;
    }

    public String getSubSectorName() {
        return subSectorName;
    }

    public void setSubSectorName(String subSectorName) {
        this.subSectorName = subSectorName;
    }

    public Integer getSectorId() {
        return sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    @Override
    public String toString() {
        return "SubSectorVO{subSectorId=" + subSectorId
                + ", subSectorName='" + subSectorName + "', sectorId=" + sectorId + "}";
    }
}

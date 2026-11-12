package eurekaAccounts.VO;

public class SubSectorVO {
    private int subSectorId;
    private String subSectorName;

    public SubSectorVO() {
    }

    public SubSectorVO(int sectorId, String sectorName) {
        this.subSectorId = sectorId;
        this.subSectorName = sectorName;
    }

    @Override
    public String toString() {
        return "SubSectorVO{" +
                "subSectorId=" + subSectorId +"\n"+
                ", subSectorName='" + subSectorName + '\'' +
                '}';
    }

    public int getSectorId() {
        return subSectorId;
    }

    public void setSectorId(int sectorId) {
        this.subSectorId = sectorId;
    }

    public String getSectorName() {
        return subSectorName;
    }

    public void setSectorName(String sectorName) {
        this.subSectorName = sectorName;
    }
}

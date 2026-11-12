package eurekaAccounts.VO;

public class SectorVO {
    private int sectorId;
    private String sectorName;

    public SectorVO() {
    }

    public SectorVO(int sectorId, String sectorName) {
        this.sectorId = sectorId;
        this.sectorName = sectorName;
    }

    @Override
    public String toString() {
        return "SectorVO{" +
                "sectorId=" + sectorId +"\n"+
                ", sectorName='" + sectorName + '\'' +
                '}';
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
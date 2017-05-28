package isacademy.jjdd1.itconcrete.smartconnect.map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stop {

        @SerializedName("stopId")
        @Expose
        private Integer stopId;
        @SerializedName("stopCode")
        @Expose
        private String stopCode;
        @SerializedName("stopName")
        @Expose
        private String stopName;
        @SerializedName("stopShortName")
        @Expose
        private String stopShortName;
        @SerializedName("stopDesc")
        @Expose
        private String stopDesc;
        @SerializedName("subName")
        @Expose
        private String subName;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("stopLat")
        @Expose
        private Float stopLat;
        @SerializedName("stopLon")
        @Expose
        private Float stopLon;
        @SerializedName("zoneId")
        @Expose
        private Integer zoneId;
        @SerializedName("zoneName")
        @Expose
        private String zoneName;
        @SerializedName("stopUrl")
        @Expose
        private String stopUrl;
        @SerializedName("locationType")
        @Expose
        private Object locationType;
        @SerializedName("parentStation")
        @Expose
        private Object parentStation;
        @SerializedName("stopTimezone")
        @Expose
        private String stopTimezone;
        @SerializedName("wheelchairBoarding")
        @Expose
        private Object wheelchairBoarding;
        @SerializedName("virtual")
        @Expose
        private Integer virtual;
        @SerializedName("nonpassenger")
        @Expose
        private Integer nonpassenger;
        @SerializedName("depot")
        @Expose
        private Integer depot;
        @SerializedName("ticketZoneBorder")
        @Expose
        private Integer ticketZoneBorder;
        @SerializedName("onDemand")
        @Expose
        private Integer onDemand;
        @SerializedName("activationDate")
        @Expose
        private String activationDate;

        public Stop() {
        }

        public Stop(Integer stopId, String stopCode, String stopName, String stopShortName, String stopDesc, String subName, String date, Float stopLat, Float stopLon, Integer zoneId, String zoneName, String stopUrl, Object locationType, Object parentStation, String stopTimezone, Object wheelchairBoarding, Integer virtual, Integer nonpassenger, Integer depot, Integer ticketZoneBorder, Integer onDemand, String activationDate) {
            super();
            this.stopId = stopId;
            this.stopCode = stopCode;
            this.stopName = stopName;
            this.stopShortName = stopShortName;
            this.stopDesc = stopDesc;
            this.subName = subName;
            this.date = date;
            this.stopLat = stopLat;
            this.stopLon = stopLon;
            this.zoneId = zoneId;
            this.zoneName = zoneName;
            this.stopUrl = stopUrl;
            this.locationType = locationType;
            this.parentStation = parentStation;
            this.stopTimezone = stopTimezone;
            this.wheelchairBoarding = wheelchairBoarding;
            this.virtual = virtual;
            this.nonpassenger = nonpassenger;
            this.depot = depot;
            this.ticketZoneBorder = ticketZoneBorder;
            this.onDemand = onDemand;
            this.activationDate = activationDate;
        }

        public Integer getStopId() {
            return stopId;
        }

        public void setStopId(Integer stopId) {
            this.stopId = stopId;
        }

        public String getStopCode() {
            return stopCode;
        }

        public void setStopCode(String stopCode) {
            this.stopCode = stopCode;
        }

        public String getStopName() {
            return stopName;
        }

        public void setStopName(String stopName) {
            this.stopName = stopName;
        }

        public String getStopShortName() {
            return stopShortName;
        }

        public void setStopShortName(String stopShortName) {
            this.stopShortName = stopShortName;
        }

        public String getStopDesc() {
            return stopDesc;
        }

        public void setStopDesc(String stopDesc) {
            this.stopDesc = stopDesc;
        }

        public String getSubName() {
            return subName;
        }

        public void setSubName(String subName) {
            this.subName = subName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Float getStopLat() {
            return stopLat;
        }

        public void setStopLat(Float stopLat) {
            this.stopLat = stopLat;
        }

        public Float getStopLon() {
            return stopLon;
        }

        public void setStopLon(Float stopLon) {
            this.stopLon = stopLon;
        }

        public Integer getZoneId() {
            return zoneId;
        }

        public void setZoneId(Integer zoneId) {
            this.zoneId = zoneId;
        }

        public String getZoneName() {
            return zoneName;
        }

        public void setZoneName(String zoneName) {
            this.zoneName = zoneName;
        }

        public String getStopUrl() {
            return stopUrl;
        }

        public void setStopUrl(String stopUrl) {
            this.stopUrl = stopUrl;
        }

        public Object getLocationType() {
            return locationType;
        }

        public void setLocationType(Object locationType) {
            this.locationType = locationType;
        }

        public Object getParentStation() {
            return parentStation;
        }

        public void setParentStation(Object parentStation) {
            this.parentStation = parentStation;
        }

        public String getStopTimezone() {
            return stopTimezone;
        }

        public void setStopTimezone(String stopTimezone) {
            this.stopTimezone = stopTimezone;
        }

        public Object getWheelchairBoarding() {
            return wheelchairBoarding;
        }

        public void setWheelchairBoarding(Object wheelchairBoarding) {
            this.wheelchairBoarding = wheelchairBoarding;
        }

        public Integer getVirtual() {
            return virtual;
        }

        public void setVirtual(Integer virtual) {
            this.virtual = virtual;
        }

        public Integer getNonpassenger() {
            return nonpassenger;
        }

        public void setNonpassenger(Integer nonpassenger) {
            this.nonpassenger = nonpassenger;
        }

        public Integer getDepot() {
            return depot;
        }

        public void setDepot(Integer depot) {
            this.depot = depot;
        }

        public Integer getTicketZoneBorder() {
            return ticketZoneBorder;
        }

        public void setTicketZoneBorder(Integer ticketZoneBorder) {
            this.ticketZoneBorder = ticketZoneBorder;
        }

        public Integer getOnDemand() {
            return onDemand;
        }

        public void setOnDemand(Integer onDemand) {
            this.onDemand = onDemand;
        }

        public String getActivationDate() {
            return activationDate;
        }

        public void setActivationDate(String activationDate) {
            this.activationDate = activationDate;
        }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", stopCode='" + stopCode + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopShortName='" + stopShortName + '\'' +
                ", stopDesc='" + stopDesc + '\'' +
                ", subName='" + subName + '\'' +
                ", date='" + date + '\'' +
                ", stopLat=" + stopLat +
                ", stopLon=" + stopLon +
                ", zoneId=" + zoneId +
                ", zoneName='" + zoneName + '\'' +
                ", stopUrl='" + stopUrl + '\'' +
                ", locationType=" + locationType +
                ", parentStation=" + parentStation +
                ", stopTimezone='" + stopTimezone + '\'' +
                ", wheelchairBoarding=" + wheelchairBoarding +
                ", virtual=" + virtual +
                ", nonpassenger=" + nonpassenger +
                ", depot=" + depot +
                ", ticketZoneBorder=" + ticketZoneBorder +
                ", onDemand=" + onDemand +
                ", activationDate='" + activationDate + '\'' +
                '}'+ "\n";
    }
}

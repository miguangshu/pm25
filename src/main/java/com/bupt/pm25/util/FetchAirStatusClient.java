package com.bupt.pm25.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.StationEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class FetchAirStatusClient {
    private static Integer TIME_OUT = 3000;
    private static final String URL = "http://pm25.in/beijing";
    public static List<AirStatus> fetchAirStatus() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        List<Element> trs = doc.getElementsByTag("tr");
        List<AirStatus> airStatusList = new ArrayList<AirStatus>();
        for (Element tr : trs) {
            List<Element> tds = tr.getElementsByTag("td");
            if (tds == null || tds.size() == 0) continue;
            Element element = tds.get(0);
            String stationName = element.html().trim();
            if (stationName != null && !stationName.equals("")) {
                StationEntity stationEntity = StationUtils.getStationEntity(stationName);
                AirStatus airStatus = new AirStatus();
                airStatus.setStation(stationEntity);
                airStatus.setAqi(tds.get(1).html());
                airStatus.setPm25(tds.get(4).html());
                airStatus.setPm10(tds.get(5).html());
                airStatus.setCo(tds.get(6).html());
                airStatus.setNo2(tds.get(7).html());
                airStatus.setO3(tds.get(8).html());
                airStatus.setSo2(tds.get(10).html());
                airStatusList.add(airStatus);
            }
        }
        return airStatusList;
    }
}

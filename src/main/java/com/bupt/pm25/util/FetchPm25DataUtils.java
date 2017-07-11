package com.bupt.pm25.util;

import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.Pm25Entity;
import com.bupt.pm25.model.StationEntity;
import com.bupt.pm25.model.WeatherDataEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.*;

public class FetchPm25DataUtils {
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(FetchPm25DataUtils.class);
	// Url
//	public final static String URL = "http://api.k780.com:88/";
//    public static String URL = "http://www.nmc.cn/service/data/real/$cityid$.json?_=$timestamp$";
	public static String URL = "https://api.waqi.info/mapq/bounds/?bounds=39.48284540453334,115.30975341796875,40.24179856487036,116.60614013671874&inc=placeholders&k=_2Y2EzVxxICV0cHTcISxRWXmldZA4+PRlRFUYjLg==&_=%s";
	public static ObjectMapper mapper = new ObjectMapper(); // create once, reuse
	public static String pmURL = "https://api.waqi.info/api/widget/@%s/widget.v1.json";
	/**
	 * 根据城市编码获取天气数据
	 * @return
	 * @throws IOException
     */
	public static List<Pm25Entity> getPm25() throws IOException {
		Map params = new HashMap();
		String jsonResult = HttpsClientUtils.doPost(String.format(URL,System.currentTimeMillis()),params,"UTF-8");
		System.out.printf(jsonResult);
		JsonNode root = mapper.readTree(jsonResult);
		Iterator<JsonNode> iterator = root.elements();
		List<Pm25Entity> pm25List = new ArrayList<Pm25Entity>();
		while (iterator.hasNext()){
			JsonNode node = iterator.next();
			Double lon = node.get("lon").asDouble();
			Double lat = node.get("lat").asDouble();
			String stationName = node.get("city").asText();
			int stationId = node.get("idx").asInt();
			String pm25Value = "-",pm10Value = "-",o3Value = "-",no2Value = "-",so2Value = "-",coValue = "-";
			try {
				String airConditionData = HttpsClientUtils.doPost(String.format(pmURL,stationId),params,"UTF-8");
				JsonNode airConditionDataRoot = mapper.readTree(airConditionData);
				JsonNode rxs = airConditionDataRoot.get("rxs");
				ArrayNode obs = (ArrayNode)rxs.get("obs");
				JsonNode msg = obs.get(0).get("msg");
				JsonNode model = msg.get("model");
				ArrayNode iaqi = (ArrayNode)model.get("iaqi");
				JsonNode pm25 = iaqi.get(0);
				pm25Value = ((ArrayNode)pm25.get("v")).get(0).asText();

				JsonNode pm10 = iaqi.get(1);
				pm10Value = ((ArrayNode)pm10.get("v")).get(0).asText();

				JsonNode o3 = iaqi.get(2);
				o3Value = ((ArrayNode)o3.get("v")).get(0).asText();

				JsonNode no2 = iaqi.get(3);
				no2Value = ((ArrayNode)no2.get("v")).get(0).asText();

				JsonNode so2 = iaqi.get(4);
				so2Value = ((ArrayNode)so2.get("v")).get(0).asText();

				JsonNode co = iaqi.get(5);
				coValue = ((ArrayNode)co.get("v")).get(0).asText();
			} catch (Exception e) {
				logger.error("抓取站点【{}】数据异常:",stationName,e);
			}
			Pm25Entity pm25Entity = new Pm25Entity();
			StationEntity stationEntity = new StationEntity(stationId+"",stationName,lon+"",lat+"",null,"001");
			pm25Entity.setStation(stationEntity);
			pm25Entity.setPm25(pm25Value);
			pm25Entity.setPm10(pm10Value);
			pm25Entity.setO3(o3Value);
			pm25Entity.setNo2(no2Value);
			pm25Entity.setSo2(so2Value);
			pm25Entity.setCo(coValue);
			pm25List.add(pm25Entity);
		}
		return pm25List;
	}

	public static void main(String[] args) throws Exception{
		System.out.println(getPm25());
	}
}

package team.spring.aqs.util;

import java.util.UUID;

public class UuidUtils {
	public static String CreateUUID() {
		String uuids = (UUID.randomUUID().toString()).replaceAll("-", "");
		return uuids;
	}
}

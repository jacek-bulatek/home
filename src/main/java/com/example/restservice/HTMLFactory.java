package com.example.restservice;

import java.util.BitSet;


public class HTMLFactory {

	enum Floor {
		GROUND,
		FIRST;
	}

	public static BitSet groundLights = new BitSet();
	public static BitSet firstFloorLights = new BitSet();

	public static String Generate(Floor floor) {
		String body = "";
		body += initBody();
		switch(floor){
			case GROUND:
				body += forgeGround();
				break;
			case FIRST:
				body += forgeFirst();
				break;
			default:
				break;
		}
		body += endBody();
		return body;
	}

	private static String initBody() {
		return 
			"<html>"
		+	"<head>"
		+	"<style>"
		+	"#plan 		{ position: relative; background-size: cover; width: 80%; height: 80%; left: 10%; top:10%;} "
		+	"#plan > *	{ position: absolute; }"
		+	"button		{ border-radius: 50%; width: 30px; height: 30px; border: 0px;}"
		+	".lightOn	{ background: url(/light_on.png);  background-size: cover; }"
		+	".lightOff	{ background: url(/light_off.png); background-size: cover; }"
		+	"</style>"
		+	"</head>"
		+	"<body>"
		;
	}

	private static String forgeGround() {
		return 
			"<div id=\"plan\" style=\"background-image: url(/ground.png)\">"
		+		"<div style=\"left: 0; top: 0;\">"
		+			"<form action=\"#\" method=\"POST\">"
		+				"<input name=\"flip\" value=\"0\" type=\"hidden\">"
		+				"<button class=\""+ (groundLights.get(0) ? "lightOn" : "lightOff") +"\" type=\"submit\"></button>"
		+			"</form>"
		+		"</div>"
		+	"</div>"
		;
	}

	private static String forgeFirst() {
		return " i policję";
	}

	private static String endBody() {
		return 
			"</body>"
		+	"</html>"
		;
	}
}

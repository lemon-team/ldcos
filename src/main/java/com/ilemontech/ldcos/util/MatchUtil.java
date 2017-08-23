package com.ilemontech.ldcos.util;

import java.util.List;
import java.util.Set;

import org.springframework.util.PatternMatchUtils;

public class MatchUtil extends PatternMatchUtils {

	public static boolean simpleMatch(List<String> list, String str) {
		if (list == null || str == null) {
			return false;
		}
		for (String s : list) {
			if (simpleMatch(s, str)) {
				return true;
			}
		}
		return false;
	}

	public static boolean simpleMatch(Set<String> set, String str) {
		if (set == null || str == null) {
			return false;
		}
		for (String s : set) {
			if (simpleMatch(s, str)) {
				return true;
			}
		}
		return false;
	}

}

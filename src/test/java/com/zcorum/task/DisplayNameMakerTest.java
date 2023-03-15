package com.zcorum.task;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayNameMakerTest {

	private DisplayNameMaker displayNameMaker;

	@BeforeEach
	public void setup() {
		this.displayNameMaker = new DisplayNameMaker();
	}

	private static Stream<Arguments> testData() {
		return Stream.of(
				Arguments.of(null, null, null, ""),
				Arguments.of(null, "", "", ""),
				Arguments.of("", null, "", ""),
				Arguments.of("", "", null, ""),
				Arguments.of(null, "", null, ""),
				Arguments.of(null, null, "", ""),
				Arguments.of("", null, null, ""),
				Arguments.of("", "", "", ""),
				Arguments.of("Gottfried", "Chukwudi", "Apple", "Chukwudi, Gottfried"),
				Arguments.of("Diya", "", "Google", "Google"),
				Arguments.of("", "Shirli", "", ""),
				Arguments.of("Clytemnestra", "", "", ""),
				Arguments.of("", "Dumnorix", "Facebook", "Facebook"),
				Arguments.of("Mouric", null, "Amazon", "Amazon"),
				Arguments.of(null, "Halldora", "ZCorum", "ZCorum"),
				Arguments.of("Hachiro", "Adalhard", "", "Adalhard, Hachiro")
		);
	}

	@ParameterizedTest
	@MethodSource("testData")
	public void testDisplayName(String firstName, String lastName, String businessName, String expectedResult) {
		assertEquals(expectedResult, displayNameMaker.displayName(firstName, lastName, businessName));
	}
}
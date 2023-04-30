package br.com.lbenaducci.rubikscubesolver.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Color {
	BLUE("\u001B[30m\u001B[44m"),
	GREEN("\u001B[30m\u001B[102m"),
	ORANGE("\u001B[30m\u001B[48;5;208m"),
	RED("\u001B[30m\u001B[101m"),
	WHITE("\u001B[30m\u001B[107m"),
	YELLOW("\u001B[30m\u001B[103m");

	private final String code;
}

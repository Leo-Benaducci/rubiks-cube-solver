package br.com.lbenaducci.rubikscubesolver.models.entities;

import br.com.lbenaducci.rubikscubesolver.models.enums.Color;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static br.com.lbenaducci.rubikscubesolver.models.enums.Color.*;
import static org.junit.jupiter.api.Assertions.*;

class FaceTest {
	private final Face face = new Face(BLUE, GREEN, ORANGE,
	                                   RED, WHITE, YELLOW,
	                                   BLUE, GREEN, ORANGE);
	private final Face faceComplete = new Face(WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE);

	@Nested
	class Get {
		@Test
		void invalidPosition() {
			assertThrows(IllegalStateException.class, () -> face.get(0));
			assertThrows(IllegalStateException.class, () -> face.get(10));
		}

		@Test
		void success() {
			Color one = face.get(1);
			assertEquals(BLUE, one);

			Color nine = face.get(9);
			assertEquals(ORANGE, nine);
		}
	}

	@Nested
	class Set {
		@Test
		void invalidPosition() {
			assertThrows(IllegalStateException.class, () -> face.set(0, WHITE));
			assertThrows(IllegalStateException.class, () -> face.set(10, WHITE));
		}

		@Test
		void success() {
			face.set(1, WHITE);
			assertEquals(WHITE, face.get(1));

			face.set(9, WHITE);
			assertEquals(WHITE, face.get(9));
		}
	}

	@Nested
	class CountColor {
		@Test
		void success(){
			int red = face.countColor(RED);
			assertEquals(1, red);

			int blue = face.countColor(BLUE);
			assertEquals(2, blue);
		}
	}

	@Nested
	class IsComplete {
		@Test
		void success() {
			assertFalse(face.isComplete());
			assertTrue(faceComplete.isComplete());
		}
	}

	@Nested
	class RotateClockwise {
		@Test
		void success() {
			face.rotateClockwise();
			assertEquals(new Face(BLUE, RED, BLUE, GREEN, WHITE, GREEN, ORANGE, YELLOW, ORANGE), face);
		}
	}

	@Nested
	class RotateCounterclockwise {
		@Test
		void success() {
			face.rotateCounterclockwise();
			assertEquals(new Face(ORANGE, YELLOW, ORANGE, GREEN, WHITE, GREEN, BLUE, RED, BLUE), face);
		}
	}
}
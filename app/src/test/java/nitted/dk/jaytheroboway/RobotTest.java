package nitted.dk.jaytheroboway;

import org.junit.Test;

import nitted.dk.jaytheroboway.Model.Grid;
import nitted.dk.jaytheroboway.Model.Robot;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ibrahim on 11/07/2017.
 */

public class RobotTest {


	@Test
	public void testDirection() {
		final Robot robot = new Robot(new Grid(5,5), new Grid(1,2), Robot.Direction.N);
		assertEquals(robot.getDirection(), Robot.Direction.N);
	}

	@Test
	public void testMoveForward() {
		final Robot robot = new Robot(new Grid(5,5), new Grid(1,2), Robot.Direction.N);
		try {
			robot.turn(Robot.Turn.FORWARD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(robot.getPosition().getRow(), 1);
	}

	@Test
	public void testCase1() {
		final Robot r = new Robot(new Grid(5,5), new Grid(1,2), Robot.Direction.N);
		final String routeCode = "RFRFFRFRF";

		for (int i = 0; i < routeCode.length(); i++) {
			String s = String.valueOf(routeCode.charAt(i));

			try {
				r.turn(Robot.Turn.fromString(s));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		assertEquals(r.getPosition().getColumn(), 1);
		assertEquals(r.getPosition().getRow(), 3);
		assertEquals(r.getDirection(), Robot.Direction.N);
	}

	@Test
	public void testCase2() {
		final Robot r = new Robot(new Grid(5,5), new Grid(0,0), Robot.Direction.E);
		final String routeCode = "RFLFFLRF";

		for (int i = 0; i < routeCode.length(); i++) {
			String s = String.valueOf(routeCode.charAt(i));

			try {
				r.turn(Robot.Turn.fromString(s));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		assertEquals(r.getPosition().getColumn(), 3);
		assertEquals(r.getPosition().getRow(), 1);
		assertEquals(r.getDirection(), Robot.Direction.E);
	}
}

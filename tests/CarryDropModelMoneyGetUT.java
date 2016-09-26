import static org.junit.Assert.*;

import org.junit.Test;

public class CarryDropModelMoneyGetUT {
	CarryDropModel myObject = new CarryDropModel();
	@Test
	public void testGetMoney() {
		
		assertEquals(1000, myObject.getMoney());
	}

}
